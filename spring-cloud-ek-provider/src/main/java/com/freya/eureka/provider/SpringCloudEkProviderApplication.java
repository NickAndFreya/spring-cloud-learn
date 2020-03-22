package com.freya.eureka.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //启用服务注册与发现
public class SpringCloudEkProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEkProviderApplication.class, args);
	}

}
