/*
Navicat MySQL Data Transfer

Source Server         : 42.121.118.76
Source Server Version : 50528
Source Host           : 42.121.118.76:3306
Source Database       : house

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2013-03-29 13:23:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `readily_operatelog`
-- ----------------------------
DROP TABLE IF EXISTS `readily_operatelog`;
CREATE TABLE `readily_operatelog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `terminal` varchar(30) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `creater` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `ip` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readily_operatelog
-- ----------------------------
