# RefuelingWuhan-
加油，武汉

## 版本信息
- jdk8
- spring boot 2.2.4.RELEASE
- Spring cloud Hoxton.SR1
# 版本1
## 模块
###  注册中心 registrer-center
使用eureka作为注册中心
### 省份中心 province-center
小项目，为了微服务而微服务
### 数据中心 data-center
疫情数据
### 配置中心 config-center
目前采用本地配置，本地配置简单。

未来计划，使用docker安装gitlab，将配置中心的文件放在gitlab里。开发时，将配置中心打成jar包，所有配置均操作gitlab里面的配置文件。机器性能有限，以后再论。

没有使用github，家里网络太慢。

svn不想安装。

配置中心目前只是配置，而不是中心。等初版本完成后，改为配置中心。
### fegin
服务之前调用
### 网关 zuul-center
网关,api的接口只把网关的接口暴露出去，其他微服务地址不暴露

---
# 版本2
之前的版本1已经完成名，处于入门。现在，对各个组建进行升级，以及引入一些未引入的组建。

### eureka 注册中心
### spring security 安全认证
完成工作
1. 增加登陆页面
未能完成工作
1. 密码不需要配置在配置文件中
### 高可用
1. 2个注册中心相互调用
### docker
1. dockerfile，打包
2. 放在容器中管理
### 步骤
1. mvn clean package -Dmaven.test.skip=true
2. dockfile
```
FROM hub.c.163.com/library/java:8-alpine

ADD target/*.jar app.jar

EXPOSE 8762

ENTRYPOINT ["java", "-jar", "/app.jar"]
``` 
3. docker build -t springcloud2/eureka2 .    
4. docker run -p 8761:8761 -d springcloud2/eureka2:latest
```
server:
  port: 8762
spring:
  application:
    name: eureka-server
  security:
    user:
      name: admin
      password: 123456
eureka:
  instance:
    prefer-ip-address: false
    hostname: e-2
  client:
    service-url:
      defaultZone: http://admin:123456@e-1:8761/eureka/
    # 向自己注册
    register-with-eureka: true
  #server:
    # 自我保护机制
    #enable-self-preservation: false
    fetch-registry: true
```
### config-server 配置中心
配置中心也可以像注册中心那样，达成jar包，放在docker里面。配置中心，操作的都是线上的文件。
### svn服务器
1. 本地使用docker搭建svn服务器
2. 搭建svn不容易，建议使用github，把更多精力放在spring-config上。而不是这个svn。svn还得要带http服务的。
3. 放弃，使用github
### 改造项目
之前使用项目文件，现在改为git文件
1. 配置git，连接，用户名，密码，前缀即可，很简单。
#### ps
未完成，目前项目没有灵活配置，就不加bus了。等下一个版本加。
今天大部分时间都用来svn上了。浪费太多时间了。不应该

#### 打包
目前，spring-config在这个版本没有其他配置了（下一个版本增加bus）。将其打包jar，部署到docker里面。。

以后开发，在本地git里添加配置文件，然后push，剩余就是正常的springboot开发。

# 明天一天时间安排
1. web ok
