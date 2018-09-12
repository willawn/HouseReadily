/*
Navicat MySQL Data Transfer

Source Server         : 42.121.118.76
Source Server Version : 50528
Source Host           : 42.121.118.76:3306
Source Database       : house

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2013-05-28 18:00:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `readily_broker`
-- ----------------------------
DROP TABLE IF EXISTS `readily_broker`;
CREATE TABLE `readily_broker` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `company` varchar(100) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `subareas` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readily_broker
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readily_code
-- ----------------------------

-- ----------------------------
-- Table structure for `readily_customer`
-- ----------------------------
DROP TABLE IF EXISTS `readily_customer`;
CREATE TABLE `readily_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ctype` int(11) NOT NULL,
  `buildType` int(11) DEFAULT NULL,
  `name` varchar(80) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `phone` varchar(80) DEFAULT NULL,
  `mobile` varchar(80) DEFAULT NULL,
  `cityCode` int(11) DEFAULT NULL,
  `bigAreaCode` int(11) DEFAULT NULL,
  `smallAreaCode` int(11) DEFAULT NULL,
  `roomNum` int(11) DEFAULT NULL,
  `hallNum` int(11) DEFAULT NULL,
  `toiletNum` int(11) DEFAULT NULL,
  `beginFirstPayment` decimal(21,10) DEFAULT NULL,
  `endFirstPayment` decimal(21,10) DEFAULT NULL,
  `beginArea` decimal(21,10) DEFAULT NULL,
  `endArea` decimal(21,10) DEFAULT NULL,
  `beginUnitPrice` decimal(21,10) DEFAULT NULL,
  `endUnitPrice` decimal(21,10) DEFAULT NULL,
  `beginTotalPrice` decimal(21,10) DEFAULT NULL,
  `endTotalPrice` decimal(21,10) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `month` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `creater` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `syncTime` datetime DEFAULT NULL,
  `version` varchar(10) DEFAULT NULL,
  `lastFollowDate` datetime DEFAULT NULL,
  `isEnable` int(11) DEFAULT NULL,
  `isDelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readily_customer
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readily_feedback
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
  `mpath` varchar(80) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `isPicture` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `lastFollowDate` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `creater` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `syncTime` datetime DEFAULT NULL,
  `version` varchar(10) DEFAULT NULL,
  `isEnable` int(11) DEFAULT NULL,
  `isDelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readily_housereadily
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readily_operatelog
-- ----------------------------

-- ----------------------------
-- Table structure for `readily_userext`
-- ----------------------------
DROP TABLE IF EXISTS `readily_userext`;
CREATE TABLE `readily_userext` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `houseReadilyCount` int(11) NOT NULL,
  `customerCount` int(11) NOT NULL,
  `level` int(11) NOT NULL,
  `growing` int(11) NOT NULL,
  `integration` int(11) NOT NULL,
  `isUpdate` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readily_userext
-- ----------------------------

-- ----------------------------
-- Table structure for `readily_task`
-- ----------------------------
DROP TABLE IF EXISTS `readily_task`;
CREATE TABLE `readily_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(80) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `explanation` varchar(500) DEFAULT NULL,
  `growing` int(11) DEFAULT NULL,
  `integration` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `img` varchar(80) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readily_task
-- ----------------------------
INSERT INTO `readily_task` VALUES ('1', '有头有脸', '上传头像获得2积分', '您第一次上传头像时可获得2积分,该任务可以获得{0}次奖励,您已获得其中{1}次奖励', '2', '2', '1', '/images/icon/task/avatar.png;/images/icon/task/avatar_gray.png', '1');
INSERT INTO `readily_task` VALUES ('2', '资料齐全', '完善个人资料获得8积分', '您第一次上传头像时可获得8积分,该任务可以获得{0}次奖励,您已获得其中{1}次奖励', '8', '8', '1', '/images/icon/task/personal.png;/images/icon/task/personal_gray.png', '1');
INSERT INTO `readily_task` VALUES ('3', '首次分享', '首次分享应用获得15积分', '您第一次分享应用时可获得15积分,该任务可以获得{0}次奖励,您已获得其中{1}次奖励', '15', '15', '1', '/images/icon/task/firstshare.png;/images/icon/task/firstshare_gray.png', '1');
INSERT INTO `readily_task` VALUES ('4', '每日登录', '每天首次登录随机获得1-15分', '您在每天首次联网登录的时候将获得1-15积分,该任务每天可以获得{0}次奖励,您已获得其中{1}次奖励', null, null, '1', '/images/icon/task/login.png;/images/icon/task/login_gray.png', '2');
INSERT INTO `readily_task` VALUES ('5', '房源达人', '每日前3次录入房源获得每次2积分', '您在每天前3次录入房源时每次可获得2积分,该任务每天可以获得{0}次奖励,您已获得其中{1}次奖励', '6', '6', '3', '/images/icon/task/housereadily.png;/images/icon/task/housereadily_gray.png', '2');
INSERT INTO `readily_task` VALUES ('6', '客户专家', '每日前3次录入客源获得每次2积分', '您在每天前3次录入客源时每次可获得2积分,该任务每天可以获得{0}次奖励,您已获得其中{1}次奖励', '6', '6', '3', '/images/icon/task/customer.png;/images/icon/task/customer_gray.png', '2');
INSERT INTO `readily_task` VALUES ('7', '分享应用', '分享应用获取5积分', '分享此应用可以获得5积分,该任务每天可以获得{0}次奖励,您已获得其中{1}次奖励', '5', '5', '1', '/images/icon/task/share.png;/images/icon/task/share_gray.png', '2');

-- ----------------------------
-- Table structure for `readily_tasklog`
-- ----------------------------
DROP TABLE IF EXISTS `readily_tasklog`;
CREATE TABLE `readily_tasklog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `taskId` int(11) DEFAULT NULL,
  `growing` int(11) DEFAULT NULL,
  `integration` int(11) DEFAULT NULL,
  `creater` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readily_tasklog
-- ----------------------------
