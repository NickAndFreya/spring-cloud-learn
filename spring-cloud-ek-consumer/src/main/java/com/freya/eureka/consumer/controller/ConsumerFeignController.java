package com.freya.eureka.consumer.controller;

import com.freya.common.api.model.AppleModel;
import com.freya.eureka.consumer.feign.AppleFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Feign 方式调用
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/21 23:02
 */
@RestController
public class ConsumerFeignController {
	@Autowired
	private AppleFeignClient client;


	@GetMapping("/getApple")
	public List<AppleModel> getApple() {

		return client.getApple();
	}

}
