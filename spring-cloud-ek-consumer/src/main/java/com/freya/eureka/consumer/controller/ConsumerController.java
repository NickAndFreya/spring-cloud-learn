package com.freya.eureka.consumer.controller;

import com.freya.common.api.model.AppleModel;
import com.freya.common.api.model.DeptModel;
import com.freya.eureka.consumer.feign.AppleFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/21 23:02
 */
@RestController
public class ConsumerController {
	@Autowired
	private AppleFeignClient client;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/getApple")
	public List<AppleModel> getApple() {

		return client.getApple();
	}

	@GetMapping("/deptList")
	public List<DeptModel> list() throws URISyntaxException {
		URI url = new URI("http://server-provider/provider/list");
		List<DeptModel> list = restTemplate.getForObject(url, List.class);
		return list;
	}

	@PostMapping("/saveDept")
	public void save() throws URISyntaxException {
		URI url = new URI("http://server-provider/provider/save");
		restTemplate.postForLocation(url, DeptModel.builder().id(6).name("董事会").build());
	}

	@PutMapping("/modify/{id}")
	public void modify(@PathVariable("id") int id) throws URISyntaxException {
		restTemplate.put("http://server-provider/provider/modify/{1}", null, id);
	}

	@DeleteMapping("/deleteDept/{index}")
	public void delete(@PathVariable("index") Integer index) throws URISyntaxException {
		restTemplate.delete("http://server-provider/provider/delete/{1}", index);
	}
}
