# 电子商务项目
## 电商项目简介
电子商务项目[taoshop](https://github.com/u014427391/taoshop)</br>
项目releases链接:https://github.com/u014427391/taoshop/releases

本开源电商项目，SpringBoot+Dubbo技术栈实现微服务，实现一款分布式集群的电商系统。(开发中...)

## 开源协议
taoshop使用Apache2.0开源协议

## 功能
### [门户网站]
- [ ] 商品搜索(Lucene)
- [x] 最新上架
- [ ] 购物车功能
- [x] 品目商品搜索
- [ ] 优惠券秒杀(高并发处理)
- [ ] 商品详情
- [x] 商品品类多级联动

### [运营平台]
- [ ] 会员中心
- [ ] 订单系统
- [ ] 店铺管理
- [ ] 评论管理
- [ ] 风控系统
- [ ] 采购平台
- [ ] 内容管理

## 技术栈
* 模板引擎：Thymeleaf
* 搜索引擎：Lucene
* 负载均衡：Nginx
* 缓存处理：Redis
* 后台主要框架：SpringBoot、Mybatis
* 微服务搭建：Dubbo
## 平台工程目录


```
├─taoshop----------------------------父项目，公共依赖
│  │
│  ├─taoshop-search--------------------------全局搜索
│  │
│  ├─taoshop-quartz-----------------------任务调度系统
│  │
│  ├─taoshop-sso-------------------------单点登录工程
│  │
│  ├─taoshop-portal--------------------------门户网站
│  │
│  ├─taoshop-cms--------------------------平台cms系统
|  |
|  |─taoshop-order--------------------------平台订单系统
│  │
│  ├─paascloud-provider
│  │  │
│  │  │
│  │  ├─taoshop-provider-usc------------------用户信息服务中心
|  |  |
|  |  |-taoshop-provider-item------------------商品信息服务中心
|  |  |
|  |  |-taoshop-provider-shop------------------商铺信息服务中心
│  │  │
│  │  └─taoshop-provider-order------------------订单信息服务中心
│  │
│  ├─taoshop-provider-api
│  │  │
│  │  │-taoshop-provider-api-usc------------------用户信息服务API
|  |  |
|  |  |-taosho-provider-api-item------------------商品信息服务API
|  |  |
|  |  |-taoshop-provider-api-shop------------------商铺信息服务API
|  |  |
│  │  └─taoshop-provider-api-order------------------订单信息服务API
│  │
│  ├─taoshop-common
│  │  │
│  │  ├─taoshop-common-core------------------平台核心依赖服务
│  │  │
│  │  ├─taoshop-common-zk------------------zookeeper配置工程
│  │  │
│  │  ├─taoshop-common-quartz------------------任务调度服务
│  │  │
│  │  ├─taoshop-security-core------------------安全服务核心服务
│  │  │
│  │  └─taoshop-security-auth2------------------API认证授权服务
│  │




```



## 架构设计

![Image text](https://github.com/u014427391/taoshop/raw/master/screenshot/架构图20180409.png)


## 平台功能演示


运营系统登录
![Image text](https://github.com/u014427391/taoshop/raw/master/screenshot/运营平台登录.png)


订单管理页面
![Image text](https://github.com/u014427391/taoshop/raw/master/screenshot/订单管理.png)

## 附录

### 一、分布式基本知识
#### 1.1) 架构演变
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181103230911558.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTQ0MjczOTE=,size_16,color_FFFFFF,t_70)

先给出dubbo官方的图，图片表示了架构的演变。然后我说一下自己的理解。

应用最开始是单体应用，即一个应用包括了所有应用模块。

随后就是垂直应用架构，也就是将系统拆分为多个应用模块。

随后就是RPC架构，之前的垂直应用架构其实可以说是在一个进程内的通讯，而RPC就是一种进步，RPC是进程之间的通讯，远程过程调用就是这么来的。

有了RPC之后，虽然可以实现进程之间的通讯，但是服务器集群后的服务器资源利用有些时候容易造成浪费，比如有个系统，一般情况都是不能很好地预估需要分配多少机器的，很容易造成一种情况就是业务访问很频繁的模块分配了不足的机器，而访问不是很频繁的模块分配了太多的机器，这种情况就不能实现资源的很好利用，所以针对这种情况就有了SOA(Service Oriented Architecture)的出现，SOA其实就是一个服务注册中心，可以实现资源调度，合理地分配资源，提高资源调度，是一个治理中心。

#### 1.2)、分布式基本概念
所以我们了解了架构演变之后，就可以更好的理解分布式，分布式其实就是一种可以实现不同进程之间通讯的架构，然后进程之间怎么通讯的？一般都是通过RPC框架实现。比如Java方面的，Dubbo框架或者Spring Cloud。

### 二、RCP简介
#### 2.1) RPC概念
RPC：全称远程过程调用，是一种**进程间的通信的方式**，它所做的事情就是实现进程内的通信，允许调用另外一个地址空间，可以是共享网络里的另外一台机器。

#### 2.2) RPC核心模块
RPC有两个核心模块：通信和序列化

### 三、Dubbo原理简介
#### 3.1) Dubbo简介
Dubbo是阿里巴巴开源的一款Java RPC框架，现在已经捐赠给Apache
官网：http://dubbo.apache.org/

#### 3.2) 核心功能
a、智能容错和负载均衡

b、服务注册和发现

c、面向接口的远程方法调用

#### 3.3) 原理简介

![在这里插入图片描述](https://img-blog.csdnimg.cn/20181104105820112.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTQ0MjczOTE=,size_16,color_FFFFFF,t_70)

上图是Dubbo官方的图

**角色**

Provider：暴露服务的服务提供者

Container：服务运行的容器

Consumer：调用远程服务的消费者

Registry：服务注册和发现的注册中心

Minitor：统计服务调用次数和时间的监控中心


**调用**

下面根据我的理解说明一下

0：服务器容器负责启动、加载、运行服务提供者

1：服务提供者在启动后就可以向注册中心暴露服务

2：服务消费者在启动后就可以向注册中心订阅想要的服务

3：注册中心向服务消费者返回服务调用列表

4：服务消费者基于软负载均衡算法调用服务提供者的服务，这个服务提供者有可能是一个服务提供者列表，调用那个服务提供者就是根据负载均衡来调用了

5：服务提供者和服务消费者定时将保存在内存中的服务调用次数和服务调用时间推送给监控中心


## 博客记录
为了帮助学习者更好地理解代码，下面给出自己写的一些博客链接
### 单点登录
[CAS单点登录简单介绍](https://blog.csdn.net/u014427391/article/details/82083995)

### 消息队列
[RocketMQ入门手册](https://blog.csdn.net/u014427391/article/details/79914331)

### 搜索引擎
[Apache Lucene全局搜索引擎入门教程](https://blog.csdn.net/u014427391/article/details/80006401)

### Dubbo
[Dubbo学习笔记](https://blog.csdn.net/u014427391/article/details/83716884)

### SpringBoot
[电商门户网站商品品类多级联动SpringBoot+Thymeleaf实现](https://blog.csdn.net/u014427391/article/details/83685901)

### Mybatis
[Mybatis+Thymeleaf开发遇到的几个问题笔录](https://blog.csdn.net/u014427391/article/details/83686014)

### 缓存
[Redis学习笔记之基本数据结构](https://blog.csdn.net/u014427391/article/details/82860694)

[SpringBoot集成Redis实现缓存处理(Spring AOP技术)](http://blog.csdn.net/u014427391/article/details/78799623)

### Oracle知识
[Oracle知识整理笔录](https://blog.csdn.net/u014427391/article/details/82317376)

[Oracle笔记之锁表和解锁](https://blog.csdn.net/u014427391/article/details/83046148)

[Oracle笔记之修改表字段类型](https://blog.csdn.net/u014427391/article/details/83046006)

