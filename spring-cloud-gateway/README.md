## spring-cloud-gateway 简单使用

### 1 添加如下依赖 
    <!--spring cloud gateway-->
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-gateway</artifactId>
    </dependency>
    <!--服务注册发现依赖 用于将服务网关服务注册到eureka注册中心-->
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
### 2 启动类上添加如下注解开启服务注册与发现
    @EnableDiscoveryClient

### 3 配置文件添加gateway配置
    spring:
      application:
        name: service-gateway
      cloud:
        gateway:
          discovery:
            locator:
              #服务路由方式一:gateway自动配置
              #true，表明Gateway开启服务注册和发现的功能，并且Spring Cloud Gateway自动根据服务
              # 发现为每一个服务创建了一个router，这个router将以服务名开头的请求路径转发到对应的服务。
              enabled: true
              #将请求路径上的服务名配置为小写 【因为服务注册的时候，向注册中心注册时将服务名转成大写的了】
              lower-case-service-id: true