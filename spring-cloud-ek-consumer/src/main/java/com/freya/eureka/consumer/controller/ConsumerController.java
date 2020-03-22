package com.freya.eureka.consumer.controller;

import com.freya.common.api.model.AppleModel;
import com.freya.eureka.consumer.feign.AppleFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("/getApple")
	public List<AppleModel> getApple() {

		return client.getApple();
	}
}
