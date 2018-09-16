/*
SQLyog v10.2 
MySQL - 5.1.32-community : Database - taoshop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`taoshop` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `taoshop`;

/*Table structure for table `item_brand` */

DROP TABLE IF EXISTS `item_brand`;

CREATE TABLE `item_brand` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(20) DEFAULT NULL,
  `last_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `item_brand` */

insert  into `item_brand`(`id`,`brand_name`,`last_modify_time`,`create_time`) values (1,'荣耀','2018-07-24 23:21:20','2018-06-24 20:42:37');

/*Table structure for table `item_category` */

DROP TABLE IF EXISTS `item_category`;

CREATE TABLE `item_category` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(20) DEFAULT NULL,
  `sjid` bigint(11) DEFAULT NULL,
  `last_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

/*Data for the table `item_category` */

insert  into `item_category`(`id`,`category_name`,`sjid`,`last_modify_time`,`create_time`) values (1,'家用电器',0,'2018-06-24 18:59:07','2018-06-24 15:52:04'),(2,'手机数码',0,'2018-06-24 19:01:39','2018-06-24 16:27:48'),(3,'电脑办公',0,'2018-06-24 19:01:33','2018-06-24 16:27:50'),(4,'家居家具',0,'2018-06-24 19:01:24','2018-06-24 16:27:52'),(5,'品牌衣饰',0,'2018-06-24 19:02:18','2018-06-24 16:27:54'),(6,'美妆洗护',0,'2018-06-24 19:03:08','2018-06-24 16:27:56'),(7,'珠宝眼镜',0,'2018-06-24 19:03:23','2018-06-24 16:27:58'),(8,'学习书籍',0,'2018-06-24 19:03:46','2018-06-24 16:28:00'),(9,'电视',1,'2018-06-24 19:04:11','2018-06-24 17:35:18'),(10,'空调',1,'2018-06-24 19:04:20','2018-06-24 18:27:28'),(11,'洗衣机',1,'2018-06-24 19:04:19','2018-06-24 18:44:41'),(12,'冰箱',1,'2018-06-24 19:06:05','2018-06-24 19:06:04'),(13,'手机通讯',2,'2018-06-24 19:06:07','2018-06-24 19:06:06'),(14,'手机配件',2,'2018-06-24 19:06:09','2018-06-24 19:06:07'),(15,'电脑整机',3,'2018-06-24 19:06:12','2018-06-24 19:06:09'),(16,'曲面电视',9,'2018-06-24 19:08:07','2018-06-24 19:08:05'),(17,'超薄电视',9,'2018-06-24 19:08:08','2018-06-24 19:08:07'),(18,'HDR电视',9,'2018-06-24 19:08:26','2018-06-24 19:08:09'),(19,'人工智能电视',9,'2018-06-24 19:08:36','2018-06-24 19:08:10'),(20,'柜式空调',10,'2018-07-24 22:42:34','2018-07-24 22:42:30'),(21,'中央空调',10,'2018-07-24 22:42:36','2018-07-24 22:42:35'),(22,'变频空调',10,'2018-07-24 22:42:39','2018-07-24 22:42:37'),(23,'滚筒洗衣机',11,'2018-07-24 22:43:40','2018-07-24 22:43:42'),(24,'迷你洗衣机',11,'2018-07-24 22:43:54','2018-07-24 22:43:56'),(25,'洗衣机配件',11,'2018-07-24 22:44:14','2018-07-24 22:44:15'),(26,'酒柜',12,'2018-07-24 22:45:41','2018-07-24 22:45:00'),(27,'多门',12,'2018-07-24 22:45:49','2018-07-24 22:45:51'),(28,'冷柜',12,'2018-07-24 22:46:12','2018-07-24 22:46:14'),(29,'冰箱配件',12,'2018-07-24 22:46:38','2018-07-24 22:46:40'),(30,'手机',13,'2018-07-24 22:48:23','2018-07-24 22:48:25'),(31,'游戏手机',13,'2018-07-24 22:48:29','2018-07-24 22:48:27'),(32,'对讲机',13,'2018-07-24 22:49:24','2018-07-24 22:49:27'),(33,'手机壳',14,'2018-07-25 23:22:38','2018-07-25 23:22:43'),(34,'数据线',14,'2018-07-25 23:23:01','2018-07-25 23:23:03'),(35,'充电器',14,'2018-07-25 23:23:30','2018-07-25 23:23:32'),(36,'手机饰品',14,'2018-07-25 23:24:33','2018-07-25 23:24:35'),(37,'电脑办公',3,'2018-07-25 23:25:36','2018-07-25 23:25:38'),(38,'电脑配件',3,'2018-07-25 23:25:44','2018-07-25 23:25:40'),(39,'外设产品',3,'2018-07-25 23:26:16','2018-07-25 23:26:18');

/*Table structure for table `item_sku` */

DROP TABLE IF EXISTS `item_sku`;

CREATE TABLE `item_sku` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'id，主键',
  `sku_code` varchar(50) NOT NULL COMMENT 'sku编号，唯一',
  `sku_name` varchar(50) DEFAULT NULL COMMENT 'sku名称，冗余spu_name',
  `price` decimal(9,2) NOT NULL COMMENT '商城售价',
  `promotion_price` decimal(9,2) DEFAULT NULL COMMENT '促销售价',
  `stock` int(11) NOT NULL COMMENT '库存',
  `shop_id` bigint(11) NOT NULL COMMENT '商铺id，为0表示自营',
  `spu_id` bigint(11) NOT NULL COMMENT 'spu id，外键',
  `img_path` varchar(50) DEFAULT NULL COMMENT '图片路径',
  `last_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `item_sku` */

insert  into `item_sku`(`id`,`sku_code`,`sku_name`,`price`,`promotion_price`,`stock`,`shop_id`,`spu_id`,`img_path`,`last_modify_time`,`create_time`) values (1,'112233','112233','1122.00','999.00',111,1,1,'/static/picture/img_small_350x350.jpg','2018-07-24 22:21:07','2018-06-30 15:50:10'),(2,'112234','test','1123.00','999.00',111,2,2,'/static/picture/img_small_350x350.jpg','2018-07-24 22:21:09','2018-06-30 15:55:27'),(3,'112235','112223','1234.00','999.00',123,3,2,'/static/picture/img_small_350x350.jpg','2018-07-24 22:21:13','2018-07-01 16:56:47');

/*Table structure for table `item_sku_spec_value` */

DROP TABLE IF EXISTS `item_sku_spec_value`;

CREATE TABLE `item_sku_spec_value` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sku_id` bigint(20) NOT NULL COMMENT 'sku_id',
  `spec_value_id` bigint(20) NOT NULL COMMENT '规格值id',
  `last_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='sku规格值';

/*Data for the table `item_sku_spec_value` */

insert  into `item_sku_spec_value`(`id`,`sku_id`,`spec_value_id`,`last_modify_time`,`create_time`) values (1,1,1,'2018-07-28 17:20:31','2018-07-28 17:20:34'),(2,1,2,'2018-07-28 17:20:42','2018-07-28 17:20:44');

/*Table structure for table `item_spec` */

DROP TABLE IF EXISTS `item_spec`;

CREATE TABLE `item_spec` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `spec_no` varchar(50) NOT NULL COMMENT '规格编号',
  `spec_name` varchar(50) NOT NULL COMMENT '规格名称',
  `last_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='规格表';

/*Data for the table `item_spec` */

insert  into `item_spec`(`id`,`spec_no`,`spec_name`,`last_modify_time`,`create_time`) values (1,'test','系统','2018-07-28 13:56:14','2018-07-28 13:56:16'),(2,'test11','网络','2018-07-28 13:57:00','2018-07-28 13:57:02');

/*Table structure for table `item_spec_value` */

DROP TABLE IF EXISTS `item_spec_value`;

CREATE TABLE `item_spec_value` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `spec_id` bigint(20) DEFAULT NULL COMMENT '外键',
  `spec_value` varchar(50) NOT NULL COMMENT '规格值',
  `last_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='规格值表';

/*Data for the table `item_spec_value` */

insert  into `item_spec_value`(`id`,`spec_id`,`spec_value`,`last_modify_time`,`create_time`) values (1,NULL,'苹果（IOS）','2018-07-28 17:19:12','2018-07-28 17:19:14'),(2,NULL,'联通4G','2018-07-28 17:19:59','2018-07-28 17:20:00');

/*Table structure for table `item_spu` */

DROP TABLE IF EXISTS `item_spu`;

CREATE TABLE `item_spu` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '商品id，主键',
  `spu_code` varchar(50) NOT NULL COMMENT '商品编号，唯一',
  `item_name` varchar(50) NOT NULL COMMENT '商品名称',
  `category_id` bigint(11) NOT NULL COMMENT '分类id',
  `brand_id` bigint(11) NOT NULL COMMENT '品牌id',
  `shop_id` bigint(11) NOT NULL COMMENT '商铺id',
  `last_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT '1978-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `item_spu` */

insert  into `item_spu`(`id`,`spu_code`,`item_name`,`category_id`,`brand_id`,`shop_id`,`last_modify_time`,`create_time`) values (1,'112233','荣耀10 GT游戏加速 AIS手持夜景',1,1,1,'2018-07-24 23:31:29','2018-06-30 15:49:26'),(2,'112234','小米MIX2S 全面屏游戏手机',2,1,1,'2018-07-24 23:31:36','1978-01-01 00:00:00');

/*Table structure for table `item_spu_spec` */

DROP TABLE IF EXISTS `item_spu_spec`;

CREATE TABLE `item_spu_spec` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `spu_id` bigint(20) NOT NULL COMMENT 'spu_id',
  `spec_id` bigint(20) NOT NULL COMMENT 'spec_id',
  `last_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='spu规格表';

/*Data for the table `item_spu_spec` */

insert  into `item_spu_spec`(`id`,`spu_id`,`spec_id`,`last_modify_time`,`create_time`) values (1,1,1,'2018-07-28 13:57:38','2018-07-28 13:57:40'),(2,1,2,'2018-07-28 13:57:44','2018-07-28 13:57:42');

/*Table structure for table `shop_info` */

DROP TABLE IF EXISTS `shop_info`;

CREATE TABLE `shop_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(50) NOT NULL COMMENT '店铺名称',
  `last_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='店铺表';

/*Data for the table `shop_info` */

insert  into `shop_info`(`id`,`shop_name`,`last_modify_time`,`create_time`) values (1,'小米官方旗舰店','2018-07-24 23:31:02','2018-07-24 23:30:58');

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户Id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机',
  `sex` varchar(6) DEFAULT NULL COMMENT '性别',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mark` varchar(100) DEFAULT NULL COMMENT '备注',
  `rank` varchar(10) DEFAULT NULL COMMENT '账号等级',
  `lastLogin` date DEFAULT NULL COMMENT '最后一次登录时间',
  `loginIp` varchar(30) DEFAULT NULL COMMENT '登录ip',
  `imageUrl` varchar(100) DEFAULT NULL COMMENT '头像图片路径',
  `regTime` date NOT NULL COMMENT '注册时间',
  `locked` tinyint(1) DEFAULT NULL COMMENT '账号是否被锁定',
  `rights` varchar(100) DEFAULT NULL COMMENT '权限（没有使用）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_u_1` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`username`,`password`,`phone`,`sex`,`email`,`mark`,`rank`,`lastLogin`,`loginIp`,`imageUrl`,`regTime`,`locked`,`rights`) values (1,'admin','28dca2a7b33b7413ad3bce1d58c26dd679c799f1','1552323312','男','313222@foxmail.com','超级管理员','admin','2017-08-12','127.0.0.1','/static/images/','2017-03-15',0,NULL),(2,'sys','e68feeafe796b666a2e21089eb7aae9c678bf82d','1552323312','男','313222@foxmail.com','系统管理员','sys','2017-08-25','127.0.0.1','/static/images/','2017-03-15',0,NULL),(3,'user','adf8e0d0828bde6e90c2bab72e7a2a763d88a0de','1552323312','男','313222@foxmail.com','用户','user','2017-08-18','127.0.0.1','/static/images/','2017-03-15',0,NULL),(9,'test','123','12332233212','保密','2312@qq.com','没有备注','user','2017-11-25','127.0.0.1',NULL,'2017-11-25',0,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
