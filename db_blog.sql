/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : db_blog

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 22/04/2020 19:22:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for arcticle_tag_ref
-- ----------------------------
DROP TABLE IF EXISTS `arcticle_tag_ref`;
CREATE TABLE `arcticle_tag_ref`  (
  `arctile_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  PRIMARY KEY (`arctile_id`, `tag_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of arcticle_tag_ref
-- ----------------------------
INSERT INTO `arcticle_tag_ref` VALUES (1, 1);
INSERT INTO `arcticle_tag_ref` VALUES (1, 2);
INSERT INTO `arcticle_tag_ref` VALUES (2, 3);

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_user_id` int(11) NULL DEFAULT NULL,
  `article_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `article_content` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `article_view_count` int(11) NULL DEFAULT NULL,
  `article_update_time` datetime(0) NULL DEFAULT NULL,
  `article_create_time` datetime(0) NULL DEFAULT NULL,
  `article_summary` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `article_image` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `article_commend` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '学习笔记');
INSERT INTO `category` VALUES (2, 'SpringBoot源码');
INSERT INTO `category` VALUES (3, '奇怪的知识');
INSERT INTO `category` VALUES (4, '脑洞大开');
INSERT INTO `category` VALUES (5, 'SpringMVC');
INSERT INTO `category` VALUES (6, '进阶之路');
INSERT INTO `category` VALUES (7, 'Python');
INSERT INTO `category` VALUES (8, 'Diango');
INSERT INTO `category` VALUES (9, 'Tensflow');
INSERT INTO `category` VALUES (14, '大数据');
INSERT INTO `category` VALUES (15, '法外狂徒');
INSERT INTO `category` VALUES (17, '码记杂谈');
INSERT INTO `category` VALUES (18, '菜鸟进阶');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_author_avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comment_content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comment_create_time` datetime(0) NULL DEFAULT NULL,
  `comment_author_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comment_author_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_comment_id` int(10) NULL DEFAULT NULL,
  `artic_id` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (1, 'Java');
INSERT INTO `tag` VALUES (2, 'Python');
INSERT INTO `tag` VALUES (3, 'jQuery');
INSERT INTO `tag` VALUES (4, 'Mybatis');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_pass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_last_login_time` datetime(0) NULL DEFAULT NULL,
  `user_register_time` datetime(0) NULL DEFAULT NULL,
  `user_status` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'yelv', 'e10adc3949ba59abbe56e057f20f883e', 'yelv', 'muu@yelv.com', NULL, '2020-04-15 07:04:53', '2020-04-02 07:05:00', 1);

SET FOREIGN_KEY_CHECKS = 1;
