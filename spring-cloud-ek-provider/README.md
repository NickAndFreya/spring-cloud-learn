## eureka 服务提供者

### 依赖
     <!--服务注册发现依赖-->
     dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
     </dependency>
### 配置文件信息
    spring.application.name=server-provider
    server.port=8025
    server.servlet.context-path=/provider
    #注册到eureka集群中
    eureka.client.service-url.defaultZone=http://localhost:8020/eureka,http://localhost:8021/eureka
  

### 开启服务注册
    启动类上添加@EnableDiscoveryClient 开启服务注册与发现
