/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 8.0.18 : Database - db_blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_blog` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `db_blog`;

/*Table structure for table `arcticle_tag_ref` */

DROP TABLE IF EXISTS `arcticle_tag_ref`;

CREATE TABLE `arcticle_tag_ref` (
  `arctile_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  PRIMARY KEY (`arctile_id`,`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `arcticle_tag_ref` */

insert  into `arcticle_tag_ref`(`arctile_id`,`tag_id`) values 
(1,1),
(1,2),
(2,3);

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_user_id` int(11) DEFAULT NULL,
  `article_title` varchar(255) DEFAULT NULL,
  `article_content` mediumtext,
  `article_view_count` int(11) DEFAULT NULL,
  `article_update_time` datetime DEFAULT NULL,
  `article_create_time` datetime DEFAULT NULL,
  `article_summary` text,
  `article_image` varchar(100) DEFAULT NULL,
  `article_commend` int(2) DEFAULT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `article` */

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`category_id`,`category_name`) values 
(1,'学习笔记'),
(2,'SpringBoot源码'),
(3,'奇怪的知识'),
(4,'脑洞大开'),
(5,'SpringMVC'),
(6,'进阶之路'),
(7,'Python'),
(8,'Diango'),
(9,'Tensflow'),
(14,'大数据'),
(15,'法外狂徒'),
(17,'码记杂谈'),
(18,'菜鸟进阶');

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_author_avatar` varchar(255) DEFAULT NULL,
  `comment_content` varchar(1000) DEFAULT NULL,
  `comment_create_time` datetime DEFAULT NULL,
  `comment_author_name` varchar(50) DEFAULT NULL,
  `comment_author_email` varchar(50) DEFAULT NULL,
  `parent_comment_id` int(10) DEFAULT NULL,
  `artic_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

/*Table structure for table `tag` */

DROP TABLE IF EXISTS `tag`;

CREATE TABLE `tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `tag` */

insert  into `tag`(`tag_id`,`tag_name`) values 
(1,'Java'),
(2,'Python'),
(3,'jQuery'),
(4,'Mybatis');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `user_pass` varchar(255) DEFAULT NULL,
  `user_nickname` varchar(255) DEFAULT NULL,
  `user_email` varchar(100) DEFAULT NULL,
  `user_avatar` varchar(255) DEFAULT NULL,
  `user_last_login_time` datetime DEFAULT NULL,
  `user_register_time` datetime DEFAULT NULL,
  `user_status` int(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_name`,`user_pass`,`user_nickname`,`user_email`,`user_avatar`,`user_last_login_time`,`user_register_time`,`user_status`) values 
(1,'yelv','e10adc3949ba59abbe56e057f20f883e','yelv','muu@yelv.com',NULL,'2020-04-15 07:04:53','2020-04-02 07:05:00',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
