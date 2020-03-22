## eureka sever consumer 
### 依赖
    <!--服务注册与发现-->
    <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
    <!--服务Feign调用依赖-->
     <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-openfeign</artifactId>
     </dependency>
     
### 配置文件信息
    spring.application.name=server-consumer
    server.port=8026
    server.servlet.context-path=/consumer
    #服务注册到eureka cluster中
    eureka.client.service-url.defaultZone=http://localhost:8020/eureka,http://localhost:8021/eureka
    #此配置和解决unknow server的问题
    ribbon.eureka.enabled=true
    
### 服务注册与启用远程调用
    启动类上添加@EnableDiscoveryClient启用服务注册与发现，@EnableFeignClients启用feign进行远程调用
    
    启动类添加 如下代码，测试基于Ribbon的负载均衡
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
    	return new RestTemplate();
    }