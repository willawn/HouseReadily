/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : house

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2012-12-07 15:56:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `readily_customer`
-- ----------------------------
DROP TABLE IF EXISTS `readily_customer`;
CREATE TABLE `readily_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ctype` int(11) NOT NULL,
  `name` varchar(80) CHARACTER SET utf8 DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `phone` varchar(80) CHARACTER SET utf8 DEFAULT NULL,
  `mobile` char(11) CHARACTER SET utf8 DEFAULT NULL,
  `bigAreaCode` int(11) DEFAULT NULL,
  `smallAreaCode` int(11) DEFAULT NULL,
  `roomNum` int(11) DEFAULT NULL,
  `hallNum` int(11) DEFAULT NULL,
  `toiletNum` int(11) DEFAULT NULL,
  `area` decimal(21,10) DEFAULT NULL,
  `unitPrice` decimal(21,10) DEFAULT NULL,
  `totalPrice` decimal(21,10) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `month` int(11) DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `creater` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readily_customer
-- ----------------------------

-- ----------------------------
-- Table structure for `readily_houseattachment`
-- ----------------------------
DROP TABLE IF EXISTS `readily_houseattachment`;
CREATE TABLE `readily_houseattachment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) CHARACTER SET utf8 NOT NULL,
  `houseReadilyId` int(11) NOT NULL,
  `name` varchar(80) CHARACTER SET utf8 DEFAULT NULL,
  `description` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `path` varchar(80) CHARACTER SET utf8 DEFAULT NULL,
  `spath` varchar(80) CHARACTER SET utf8 DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `isPicture` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readily_houseattachment
-- ----------------------------

-- ----------------------------
-- Table structure for `readily_housefollow`
-- ----------------------------
DROP TABLE IF EXISTS `readily_housefollow`;
CREATE TABLE `readily_housefollow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `houseReadilyId` int(11) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `mode` int(11) DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `creater` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readily_housefollow
-- ----------------------------

-- ----------------------------
-- Table structure for `readily_houseowner`
-- ----------------------------
DROP TABLE IF EXISTS `readily_houseowner`;
CREATE TABLE `readily_houseowner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isMain` int(11) DEFAULT NULL,
  `houseReadilyId` int(11) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `creater` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readily_houseowner
-- ----------------------------

-- ----------------------------
-- Table structure for `readily_housereadily`
-- ----------------------------
DROP TABLE IF EXISTS `readily_housereadily`;
CREATE TABLE `readily_housereadily` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stype` int(11) DEFAULT NULL,
  `projectId` int(11) DEFAULT NULL,
  `projectName` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `cityCode` int(11) DEFAULT NULL,
  `bigAreaCode` int(11) DEFAULT NULL,
  `smallAreaCode` int(11) DEFAULT NULL,
  `lon` decimal(21,10) DEFAULT NULL,
  `lat` decimal(21,10) DEFAULT NULL,
  `buildType` int(11) DEFAULT NULL,
  `title` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `building` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `houseNum` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `roomNum` int(11) DEFAULT NULL,
  `hallNum` int(11) DEFAULT NULL,
  `toiletNum` int(11) DEFAULT NULL,
  `area` decimal(21,10) DEFAULT NULL,
  `unitPrice` decimal(21,10) DEFAULT NULL,
  `totalPrice` decimal(21,10) DEFAULT NULL,
  `hasRedBook` int(11) DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `creater` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readily_housereadily
-- ----------------------------
