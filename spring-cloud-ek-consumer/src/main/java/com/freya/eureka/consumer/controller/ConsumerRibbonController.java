package com.freya.eureka.consumer.controller;

import com.freya.common.api.model.DeptModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/21 23:02
 */
@RestController
public class ConsumerRibbonController {
	private static final Map<String, String> urls = new ConcurrentHashMap<>();

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalancerClient;


	@PostConstruct
	private void init() {
		urls.put("deptList", "http://server-provider/provider/list");
		urls.put("saveDept", "http://server-provider/provider/save");
		urls.put("modify", "http://server-provider/provider/modify/{1}");
		urls.put("deleteDept", "http://server-provider/provider/delete/{1}");
	}

	/**
	 * 获取实例信息
	 * @return
	 */
	@GetMapping("/instanceInfo")
	public Map<String, String> instance() {
		Map<String, String> result = new HashMap<>();
		ServiceInstance instance = this.loadBalancerClient.choose("server-provider");
		result.put("serviceId", instance.getServiceId());
		result.put("port", String.valueOf(instance.getPort()));
		result.put("host", instance.getHost());
		return result;
	}

	/**
	 * GET 测试
	 * @return
	 * @throws URISyntaxException
	 */
	@GetMapping("/deptList")
	public List<DeptModel> list() throws URISyntaxException {
		URI url = new URI(urls.get("deptList"));
		List<DeptModel> list = restTemplate.getForObject(url, List.class);
		return list;
	}

	/**
	 * POST 测试
	 * @throws URISyntaxException
	 */
	@PostMapping("/saveDept")
	public void save() throws URISyntaxException {
		URI url = new URI(urls.get("saveDept"));
		restTemplate.postForLocation(url, DeptModel.builder().id(6).name("董事会").build());
	}

	/**
	 * PUT 测试
	 * @param id
	 * @throws URISyntaxException
	 */
	@PutMapping("/modify/{id}")
	public void modify(@PathVariable("id") int id) throws URISyntaxException {
		restTemplate.put(urls.get("modify"), null, id);
	}

	/**
	 * DELETE 测试
	 * @param index
	 * @throws URISyntaxException
	 */
	@DeleteMapping("/deleteDept/{index}")
	public void delete(@PathVariable("index") Integer index) throws URISyntaxException {
		restTemplate.delete(urls.get("deleteDept"), index);
	}
}
