/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : house

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2013-04-17 11:24:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `readily_code`
-- ----------------------------
DROP TABLE IF EXISTS `readily_code`;
CREATE TABLE `readily_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `userName` varchar(80) DEFAULT NULL,
  `mobile` varchar(80) DEFAULT NULL,
  `code` varchar(80) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readily_code
-- ----------------------------
