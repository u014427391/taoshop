# 电子商务项目
## 电商项目简介
电子商务项目[taoshop](https://github.com/u014427391/taoshop)</br>
项目releases链接:https://github.com/u014427391/taoshop/releases

本开源电商项目，SpringBoot+Dubbo技术栈实现微服务，实现一款分布式集群的电商系统。(开发中...)

## 开源协议
taoshop使用Apache2.0开源协议

## 功能
### [前台]
- [ ] 商品搜索(Lucene)
- [x] 最新上架
- [ ] 购物车功能
- [ ] 优惠券秒杀(高并发处理)
- [ ] 单点登录(SSO)
- [ ] 商品详情
- [x] 商品品类多级联动

### [后台]
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
* 微服务搭建：SpringCloud或者阿里的Dubbo
## 平台工程目录
PS:taoshop-sso重新建个project，链接为https://github.com/u014427391/sso

```
├─taoshop----------------------------父项目，公共依赖
│  │
│  ├─taoshop-search--------------------------全局搜索
│  │
│  ├─taoshop-quartz-----------------------任务调度系统
│  │
│  ├─taoshop-sso-------------------------单点登录工程(另建工程)
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

## 数据库设计
概要设计

![Image text](https://github.com/u014427391/taoshop/raw/master/screenshot/数据库设计.png)

## 平台功能演示

运营系统登录
![Image text](https://github.com/u014427391/taoshop/raw/master/screenshot/运营平台登录.png)


订单管理页面
![Image text](https://github.com/u014427391/taoshop/raw/master/screenshot/订单管理.png)


### 附录
为了帮助学习者更好地理解代码，下面给出自己写的一些博客链接

[CAS单点登录简单介绍](https://blog.csdn.net/u014427391/article/details/82083995)

[Redis学习笔记之基本数据结构](https://blog.csdn.net/u014427391/article/details/82860694))

[RocketMQ入门手册](https://blog.csdn.net/u014427391/article/details/79914331)

[Apache Lucene全局搜索引擎入门教程](https://blog.csdn.net/u014427391/article/details/80006401)

