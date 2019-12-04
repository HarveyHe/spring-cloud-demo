# Sentinel 控制台
使用如下命令启动控制台：(jar包)
```
sh sentinel.sh
```
默认用户名和密码都是 sentinel。
默认用户名和密码都是 admin。


客户端引入依赖
```
<dependencies>
     <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-web</artifactId>
     </dependency>
     <dependency>
         <groupId>com.alibaba.cloud</groupId>
         <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
     </dependency>
</dependencies>
<dependencyManagement>
     <!--注意跟 SpringBoot 保持一致 2.1.x for Spring Boot 2.1.x-->
     <dependencies>
         <dependency>
             <groupId>com.alibaba.cloud</groupId>
             <artifactId>spring-cloud-alibaba-dependencies</artifactId>
             <version>2.1.0.RELEASE</version>
             <type>pom</type>
             <scope>import</scope>
         </dependency>
     </dependencies>
</dependencyManagement>
```

配置文件：
```$xslt
# 应用名称 
spring.application.name=blog
spring.cloud.sentinel.transport.port=8720
# 测试请替换为自己的地址
spring.cloud.sentinel.transport.dashboard=116.190.247.112:8084


```
`这里的 spring.cloud.sentinel.transport.port端口配置会在应用对应的机器上启动一个 Http Server，该 Server 会与 Sentinel 控制台做交互。比如 Sentinel 控制台添加了1个限流规则，会把规则数据 push 给这个 Http Server 接收，Http Server 再将规则注册到 Sentinel 中。
`

