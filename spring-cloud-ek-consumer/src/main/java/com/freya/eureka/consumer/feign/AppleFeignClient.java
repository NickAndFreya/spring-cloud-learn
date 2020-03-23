package com.freya.eureka.consumer.feign;

import com.freya.common.api.model.AppleModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 封装Feign方式接口
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/21 23:02
 */
@FeignClient(value = "server-provider",path = "/provider")
public interface AppleFeignClient {
	/**
	 * 调用provider提供的接口
	 * @return
	 */
	@GetMapping("/appleBigThan140G")
	List<AppleModel> getApple();
}
