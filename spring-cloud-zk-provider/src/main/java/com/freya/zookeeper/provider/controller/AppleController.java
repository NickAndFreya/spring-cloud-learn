package com.freya.zookeeper.provider.controller;

import com.freya.common.api.model.AppleModel;
import com.freya.zookeeper.provider.service.AppleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/20 17:03
 */
@RestController
public class AppleController {

	@Autowired
	private AppleService service;

	@GetMapping("/allRedApple")
	public List<AppleModel> getAllRedApple() {
		return service.getAllRedApple();
	}
}
