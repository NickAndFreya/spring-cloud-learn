## eureka 注册中心

### 添加如下依赖

    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    </dependency>
         
### 声明注册中心
    启动类上添加 @EnableEurekaServer 声明本服务为Eureka注册中心
### 配置文件
#### application-node1.properties 配置
    server.port=8020
    #服务名称
    spring.application.name=eureka-server-node1
    # 表示是否将自己注册到Eureka Server，默认为true。非集群模式时这里设置false
    eureka.client.register-with-eureka=true
    #表示是否从Eureka Server获取注册信息，默认为true。非集群模式时这里设置false
    eureka.client.fetch-registry=true
    #设置与Eureka Server交互的地址，查询服务和注册服务都需要依赖这个地址。多个地址可使用 , 分隔。
    #配置node2的端口，实现注册中心相互注册
    eureka.client.service-url.defaultZone=http://localhost:8021/eureka
    # eureka 实例名称和应用名称保持一致
    eureka.instance.hostname=eureka-server-node1
        
####  application-node2.properties 配置 
    server.port=8021
    #服务名称
    spring.application.name=eureka-server-node2
    # 表示是否将自己注册到Eureka Server，默认为true。 非集群模式时这里设置false
    eureka.client.register-with-eureka=true
    #表示是否从Eureka Server获取注册信息，默认为true。非集群模式时这里设置false
    eureka.client.fetch-registry=true
    #设置与Eureka Server交互的地址，查询服务和注册服务都需要依赖这个地址。多个地址可使用 , 分隔。
    #配置node1的端口，实现注册中心相互注册
    eureka.client.service-url.defaultZone=http://localhost:8020/eureka
    #eureka 实例名称和应用服务名称保持一致
    eureka.instance.hostname=eureka-server-node2   
