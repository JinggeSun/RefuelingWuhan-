# RefuelingWuhan-
加油，武汉

## 版本信息
- jdk8
- spring boot 2.2.4.RELEASE
- Spring cloud Hoxton.SR1
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

