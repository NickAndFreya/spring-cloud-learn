package com.freya.zookeeper.consumer.feign;

import com.freya.common.api.model.AppleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/20 17:27
 */
@Configuration
@EnableFeignClients
@EnableDiscoveryClient
public class AppleServiceFeignClient {
	@Autowired
	private AppleFeign feign;

	@FeignClient(value = "zk-provider", path = "/provider")
	interface AppleFeign {
		@GetMapping(path = "/allRedApple")
		List<AppleModel> allRedApple();
	}

	public List<AppleModel> get() {
		return feign.allRedApple();
	}

}
