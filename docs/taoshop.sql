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

insert  into `item_brand`(`id`,`brand_name`,`last_modify_time`,`create_time`) values (1,'test','2018-06-24 20:42:35','2018-06-24 20:42:37');

/*Table structure for table `item_category` */

DROP TABLE IF EXISTS `item_category`;

CREATE TABLE `item_category` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(20) DEFAULT NULL,
  `sjid` bigint(11) DEFAULT NULL,
  `last_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `item_category` */

insert  into `item_category`(`id`,`category_name`,`sjid`,`last_modify_time`,`create_time`) values (1,'家用电器',0,'2018-06-24 18:59:07','2018-06-24 15:52:04'),(2,'手机数码',0,'2018-06-24 19:01:39','2018-06-24 16:27:48'),(3,'电脑办公',0,'2018-06-24 19:01:33','2018-06-24 16:27:50'),(4,'家居家具',0,'2018-06-24 19:01:24','2018-06-24 16:27:52'),(5,'品牌衣饰',0,'2018-06-24 19:02:18','2018-06-24 16:27:54'),(6,'美妆洗护',0,'2018-06-24 19:03:08','2018-06-24 16:27:56'),(7,'珠宝眼镜',0,'2018-06-24 19:03:23','2018-06-24 16:27:58'),(8,'学习书籍',0,'2018-06-24 19:03:46','2018-06-24 16:28:00'),(9,'电视',1,'2018-06-24 19:04:11','2018-06-24 17:35:18'),(10,'空调',1,'2018-06-24 19:04:20','2018-06-24 18:27:28'),(11,'洗衣机',1,'2018-06-24 19:04:19','2018-06-24 18:44:41'),(12,'冰箱',1,'2018-06-24 19:06:05','2018-06-24 19:06:04'),(13,'手机通讯',2,'2018-06-24 19:06:07','2018-06-24 19:06:06'),(14,'手机配件',2,'2018-06-24 19:06:09','2018-06-24 19:06:07'),(15,'电脑整机',3,'2018-06-24 19:06:12','2018-06-24 19:06:09'),(16,'曲面电视',9,'2018-06-24 19:08:07','2018-06-24 19:08:05'),(17,'超薄电视',9,'2018-06-24 19:08:08','2018-06-24 19:08:07'),(18,'HDR电视',9,'2018-06-24 19:08:26','2018-06-24 19:08:09'),(19,'人工智能电视',9,'2018-06-24 19:08:36','2018-06-24 19:08:10');

/*Table structure for table `item_sku` */

DROP TABLE IF EXISTS `item_sku`;

CREATE TABLE `item_sku` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'id，主键',
  `sku_code` varchar(50) NOT NULL COMMENT 'sku编号，唯一',
  `sku_name` varchar(50) DEFAULT NULL COMMENT 'sku名称，冗余spu_name',
  `price` decimal(9,2) NOT NULL COMMENT '售价',
  `stock` int(11) NOT NULL COMMENT '库存',
  `shop_id` bigint(11) NOT NULL COMMENT '商铺id，为0表示自营',
  `spu_id` bigint(11) NOT NULL COMMENT 'spu id，外键',
  `last_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `item_sku` */

insert  into `item_sku`(`id`,`sku_code`,`sku_name`,`price`,`stock`,`shop_id`,`spu_id`,`last_modify_time`,`create_time`) values (1,'112233','112233','1122.00',111,1,1,'2018-06-30 15:50:08','2018-06-30 15:50:10'),(2,'112234','test','1123.00',111,2,2,'2018-07-01 16:58:37','2018-06-30 15:55:27'),(3,'112235','112223','1234.00',123,3,2,'2018-07-01 16:56:45','2018-07-01 16:56:47');

/*Table structure for table `item_sku_spec_value` */

DROP TABLE IF EXISTS `item_sku_spec_value`;

CREATE TABLE `item_sku_spec_value` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `spu_id` bigint(20) NOT NULL COMMENT 'sku_id',
  `spec_value_id` bigint(20) NOT NULL COMMENT '规格值id',
  `last_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='sku规格值';

/*Data for the table `item_sku_spec_value` */

/*Table structure for table `item_spec` */

DROP TABLE IF EXISTS `item_spec`;

CREATE TABLE `item_spec` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `spec_no` varchar(50) NOT NULL COMMENT '规格编号',
  `spec_name` varchar(50) NOT NULL COMMENT '规格名称',
  `last_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='规格表';

/*Data for the table `item_spec` */

/*Table structure for table `item_spec_value` */

DROP TABLE IF EXISTS `item_spec_value`;

CREATE TABLE `item_spec_value` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `spec_id` bigint(20) NOT NULL COMMENT '规格id',
  `spec_value` varchar(50) NOT NULL COMMENT '规格值',
  `last_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='规格值表';

/*Data for the table `item_spec_value` */

/*Table structure for table `item_spu` */

DROP TABLE IF EXISTS `item_spu`;

CREATE TABLE `item_spu` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `spu_code` varchar(50) NOT NULL COMMENT '商品编号，唯一',
  `item_name` varchar(50) NOT NULL COMMENT '商品名称',
  `category_id` bigint(11) NOT NULL COMMENT '分类id',
  `brand_id` bigint(11) NOT NULL COMMENT '品牌id',
  `last_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT '1978-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `item_spu` */

insert  into `item_spu`(`id`,`spu_code`,`item_name`,`category_id`,`brand_id`,`last_modify_time`,`create_time`) values (1,'112233','小米手机',1,1,'2018-06-30 15:49:29','2018-06-30 15:49:26'),(2,'112234','三星手机',2,2,'2018-06-30 15:54:47','1978-01-01 00:00:00');

/*Table structure for table `item_spu_spec` */

DROP TABLE IF EXISTS `item_spu_spec`;

CREATE TABLE `item_spu_spec` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `spu_id` bigint(20) NOT NULL COMMENT 'spu_id',
  `spec_id` bigint(20) NOT NULL COMMENT 'spec_id',
  `last_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='spu规格表';

/*Data for the table `item_spu_spec` */

/*Table structure for table `shop_info` */

DROP TABLE IF EXISTS `shop_info`;

CREATE TABLE `shop_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(50) NOT NULL COMMENT '店铺名称',
  `last_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺表';

/*Data for the table `shop_info` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
