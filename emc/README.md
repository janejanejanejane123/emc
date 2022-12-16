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
├── emc-search -- 基于Elasticsearch的商品搜索系统服务
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

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
Oexy+1/JM/r0fHX2mEglYYmq4PE=
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
Oexy+1/JM/r0fHX2mEglYYmq4PE=
