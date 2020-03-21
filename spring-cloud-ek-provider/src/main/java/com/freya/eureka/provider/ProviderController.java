package com.freya.eureka.provider;

import com.freya.common.api.model.AppleModel;
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
public class ProviderController {

	@Autowired
	private AppleService service;

	@GetMapping("/appleBigThan140G")
	public List<AppleModel> getApple() {
		return service.getAppleBigThan140G();
	}
}
