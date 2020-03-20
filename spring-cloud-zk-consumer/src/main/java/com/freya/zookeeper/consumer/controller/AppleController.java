package com.freya.zookeeper.consumer.controller;

import com.freya.common.api.model.AppleModel;
import com.freya.zookeeper.consumer.feign.AppleServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/20 17:24
 */
@RestController
public class AppleController {
	@Autowired
	private AppleServiceFeignClient client;

	@GetMapping(path = "/red")
	public List<AppleModel> getAllRedApple() {
		return client.get();
	}
}
