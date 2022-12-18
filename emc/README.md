## 项目介绍

`emc-swarm`是一套微服务系统，采用了 Spring Cloud 2021 & Alibaba、Spring Boot
2.7、、MyBatis、Elasticsearch、Docker、Kubernetes等核心技术，同时提供了基于Vue的管理后台方便快速搭建系统。`emc-swarm`
在业务的基础集成了注册中心、配置中心、监控中心、网关等系统功能。文档齐全，附带全套Spring Cloud教程。

## 系统架构图

## 组织结构

``` lua
emc
├── emc-common -- 工具类及通用代码模块
├── emc-mbg -- MyBatisPlusGenerator生成的数据库操作代码模块
├── emc-auth -- 统一的认证中心
├── emc-gateway -- 基于Spring Cloud Gateway的微服务API网关服务
├── emc-monitor -- 基于Spring Boot Admin的微服务监控中心
├── emc-admin -- 后台管理系统服务
├── emc-search -- 基于Elasticsearch的搜索系统服务
├── emc-portal -- 移动端系统服务
├── emc-demo -- 微服务远程调用测试服务
└── config -- 配置中心存储的配置
```

## 项目文档

## 项目演示

## 技术选型

### 后端技术

| 技术                   | 说明                 | 官网                                                 |
|----------------------| -------------------- | ---------------------------------------------------- |
| Spring Cloud         | 微服务框架           | https://spring.io/projects/spring-cloud              |
| Spring Cloud Alibaba | 微服务框架           | https://github.com/alibaba/spring-cloud-alibaba      |
| Spring Boot          | 容器+MVC框架         | https://spring.io/projects/spring-boot               |
| MyBatisPlus          | ORM框架              | http://www.mybatis.org/mybatis-3/zh/index.html       |
| MyBatisPlusGenerator | 数据层代码生成       | http://www.mybatis.org/generator/index.html          |
| PageHelper           | MyBatis物理分页插件  | http://git.oschina.net/free/Mybatis_PageHelper       |
| Knife4j              | 文档生产工具         | https://github.com/xiaoymin/swagger-bootstrap-ui     |
| Elasticsearch        | 搜索引擎             | https://github.com/elastic/elasticsearch             |
| RabbitMq             | 消息队列             | https://www.rabbitmq.com/                            |
| Redis                | 分布式缓存           | https://redis.io/                                    |
| MongoDb              | NoSql数据库          | https://www.mongodb.com/                             |
| Docker               | 应用容器引擎         | https://www.docker.com/                              |
| Druid                | 数据库连接池         | https://github.com/alibaba/druid                     |
| OSS                  | 对象存储             | https://github.com/aliyun/aliyun-oss-java-sdk        |
| MinIO                | 对象存储             | https://github.com/minio/minio                       |
| LogStash             | 日志收集             | https://github.com/logstash/logstash-logback-encoder |
| Lombok               | 简化对象封装工具     | https://github.com/rzwitserloot/lombok               |
| Seata                | 全局事务管理框架     | https://github.com/seata/seata                       |
| Portainer            | 可视化Docker容器管理 | https://github.com/portainer/portainer               |
| Jenkins              | 自动化部署工具       | https://github.com/jenkinsci/jenkins                 |
| Kubernetes           | 应用容器管理平台     | https://kubernetes.io/                               |

### 前端技术

## 环境搭建

### 开发环境

| 工具          | 版本号 | 下载                                                         |
| ------------- | ------ | ------------------------------------------------------------ |
| JDK           | 1.8    | https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html |
| Mysql         | 5.7    | https://www.mysql.com/                                       |
| Redis         | 7.0    | https://redis.io/download                                    |
| Elasticsearch | 7.17.3 | https://www.elastic.co/cn/downloads/elasticsearch            |
| Kibana        | 7.17.3 | https://www.elastic.co/cn/downloads/kibana                   |
| Logstash      | 7.17.3 | https://www.elastic.co/cn/downloads/logstash                 |
| MongoDb       | 5.0    | https://www.mongodb.com/download-center                      |
| RabbitMq      | 3.10.5 | http://www.rabbitmq.com/download.html                        |
| nginx         | 1.22   | http://nginx.org/en/download.html                            |

### 搭建步骤
