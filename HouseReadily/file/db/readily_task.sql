/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : house

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2013-05-29 16:48:11
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `isDisplay` int(11) DEFAULT NULL
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readily_task
-- ----------------------------
INSERT INTO `readily_task` VALUES ('1', '有头有脸', '上传头像获得2积分', '您第一次上传头像时可获得2积分,该任务可以获得{0}次奖励,您已获得其中{1}次奖励', '2', '2', '1', '/images/icon/task/avatar.png;/images/icon/task/avatar_gray.png', '1', 1);
INSERT INTO `readily_task` VALUES ('2', '资料齐全', '完善个人资料获得8积分', '您第一次上传头像时可获得8积分,该任务可以获得{0}次奖励,您已获得其中{1}次奖励', '8', '8', '1', '/images/icon/task/personal.png;/images/icon/task/personal_gray.png', '1', 1);
INSERT INTO `readily_task` VALUES ('3', '首次分享', '首次分享应用获得15积分', '您第一次分享应用时可获得15积分,该任务可以获得{0}次奖励,您已获得其中{1}次奖励', '15', '15', '1', '/images/icon/task/firstshare.png;/images/icon/task/firstshare_gray.png', '1', 1);
INSERT INTO `readily_task` VALUES ('4', '每日登录', '每天首次登录随机获得1-15分', '您在每天首次联网登录的时候将获得1-15积分,该任务每天可以获得{0}次奖励,您已获得其中{1}次奖励', null, null, '1', '/images/icon/task/login.png;/images/icon/task/login_gray.png', '2', 1);
INSERT INTO `readily_task` VALUES ('5', '房源达人', '每日前3次录入房源获得每次2积分', '您在每天前3次录入房源时每次可获得2积分,该任务每天可以获得{0}次奖励,您已获得其中{1}次奖励', '6', '6', '3', '/images/icon/task/housereadily.png;/images/icon/task/housereadily_gray.png', '2', 1);
INSERT INTO `readily_task` VALUES ('6', '客户专家', '每日前3次录入客源获得每次2积分', '您在每天前3次录入客源时每次可获得2积分,该任务每天可以获得{0}次奖励,您已获得其中{1}次奖励', '6', '6', '3', '/images/icon/task/customer.png;/images/icon/task/customer_gray.png', '2', 1);
INSERT INTO `readily_task` VALUES ('7', '分享应用', '分享应用获取5积分', '分享此应用可以获得5积分,该任务每天可以获得{0}次奖励,您已获得其中{1}次奖励', '5', '5', '1', '/images/icon/task/share.png;/images/icon/task/share_gray.png', '2', 1);
INSERT INTO `readily_task` VALUES ('8', '赠送积分', '2013年6月15日之前注册用户赠送100积分', '2013年6月15日之前注册用户赠送100积分,该任务可以获得{0}次奖励,您已获得其中{1}次奖励', '100', '100', '1', '', '1', 0);

-- ----------------------------
-- Table structure for `readily_tasklog`
-- ----------------------------
DROP TABLE IF EXISTS `readily_tasklog`;
CREATE TABLE `readily_tasklog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `taskId` int(11) DEFAULT NULL,
  `shareType` int(11) DEFAULT NULL,
  `growing` int(11) DEFAULT NULL,
  `integration` int(11) DEFAULT NULL,
  `creater` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readily_tasklog
-- ----------------------------
