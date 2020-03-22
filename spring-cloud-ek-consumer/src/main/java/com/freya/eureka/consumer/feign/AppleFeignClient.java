package com.freya.eureka.consumer.feign;

import com.freya.common.api.model.AppleModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/21 23:02
 */
@FeignClient("server-provider")
public interface AppleFeignClient {
	@GetMapping("/provider/appleBigThan140G")
	List<AppleModel> getApple();
}
