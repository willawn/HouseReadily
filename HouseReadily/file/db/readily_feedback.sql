/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : house

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2013-03-11 12:49:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `readily_feedback`
-- ----------------------------
DROP TABLE IF EXISTS `readily_feedback`;
CREATE TABLE `readily_feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(80) DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `creater` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readily_feedback
-- ----------------------------
