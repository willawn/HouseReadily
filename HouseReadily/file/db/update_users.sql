ALTER TABLE `users` ADD COLUMN `regSource` int(11);
ALTER TABLE `readily_housereadily` ADD COLUMN `syncTime` datetime;
ALTER TABLE `readily_housereadily` ADD COLUMN `version` varchar(10);
ALTER TABLE `readily_customer` ADD COLUMN `syncTime` datetime;
ALTER TABLE `readily_customer` ADD COLUMN `version` varchar(10);

update readily_housereadily set updateTime = createTime where updateTime is null;
update readily_housereadily set syncTime = updateTime where syncTime is null;
update readily_housereadily set version = '1.0' where version is null or version = '';
update readily_housereadily set lastFollowDate = updateTime where lastFollowDate is null;
update readily_customer set updateTime = createTime where updateTime is null;
update readily_customer set syncTime = updateTime where syncTime is null;
update readily_customer set version = '1.0' where version is null or version = '';

ALTER TABLE `readily_systemlog` DROP COLUMN `regSource`;
ALTER TABLE `readily_systemlog` ADD COLUMN `ip` varchar(50);

--2013-04-18
ALTER TABLE `readily_customer` ADD COLUMN `cityCode` int(11);
update readily_customer set cityCode = (select ParentId from house_area where Id = bigAreaCode) where cityCode is null and bigAreaCode is not null;
update readily_housereadily set cityCode = (select ParentId from house_area where Id = bigAreaCode) where cityCode is null and bigAreaCode is not null;

--2013-04-19
ALTER TABLE `readily_customer` ADD COLUMN `lastFollowDate` datetime;
update readily_customer set lastFollowDate = updateTime where lastFollowDate is null;

--2013-05-15
ALTER TABLE `readily_housereadily` ADD COLUMN `isEnable` int(11);
ALTER TABLE `readily_housereadily` ADD COLUMN `isDelete` int(11);
update readily_housereadily set isEnable = 1 where isEnable is null;
update readily_housereadily set isDelete = 1 where isDelete is null;
ALTER TABLE `readily_customer` ADD COLUMN `isEnable` int(11);
ALTER TABLE `readily_customer` ADD COLUMN `isDelete` int(11);
update readily_customer set isEnable = 1 where isEnable is null;
update readily_customer set isDelete = 1 where isDelete is null;
ALTER TABLE `readily_userext` ADD COLUMN `avatar` varchar(80);

--2013-06-21
ALTER TABLE `readily_housereadily` ADD INDEX `readily_housereadily_projectId_index`(`projectId`) USING BTREE;
ALTER TABLE `readily_housereadily` ADD INDEX `readily_housereadily_creater_index`(`creater`) USING BTREE;

ALTER TABLE `readily_houseattachment` ADD INDEX `readily_houseattachment_houseReadilyId_index`(`houseReadilyId`) USING BTREE;

ALTER TABLE `readily_houseowner` ADD INDEX `readily_houseowner_houseReadilyId_index`(`houseReadilyId`) USING BTREE;
ALTER TABLE `readily_houseowner` ADD INDEX `readily_houseowner_customerId_index`(`customerId`) USING BTREE;

ALTER TABLE `readily_housefollow` ADD INDEX `readily_housefollow_houseReadilyId_index`(`houseReadilyId`) USING BTREE;
ALTER TABLE `readily_housefollow` ADD INDEX `readily_housefollow_customerId_index`(`customerId`) USING BTREE;

ALTER TABLE `readily_customer` ADD INDEX `readily_customer_creater_index`(`creater`) USING BTREE;

ALTER TABLE `readily_systemlog` ADD INDEX `readily_systemlog_userId_index`(`userId`) USING BTREE;
ALTER TABLE `readily_systemlog` ADD INDEX `readily_systemlog_creater_index`(`creater`) USING BTREE;

ALTER TABLE `readily_operatelog` ADD INDEX `readily_operatelog_userId_index`(`userId`) USING BTREE;
ALTER TABLE `readily_operatelog` ADD INDEX `readily_operatelog_creater_index`(`creater`) USING BTREE;

ALTER TABLE `readily_code` ADD INDEX `readily_code_userId_index`(`userId`) USING BTREE;

ALTER TABLE `readily_userext` ADD INDEX `readily_userext_userId_index`(`userId`) USING BTREE;

ALTER TABLE `readily_tasklog` ADD INDEX `readily_tasklog_userId_index`(`userId`) USING BTREE;
ALTER TABLE `readily_tasklog` ADD INDEX `readily_tasklog_taskId_index`(`taskId`) USING BTREE;
ALTER TABLE `readily_tasklog` ADD INDEX `readily_tasklog_creater_index`(`creater`) USING BTREE;

--2013-06-27
ALTER TABLE `readily_housereadily` ADD COLUMN `towards` int(11);
ALTER TABLE `readily_housereadily` ADD COLUMN `fitment` int(11);
ALTER TABLE `readily_housereadily` ADD COLUMN `houseRight` int(11);
ALTER TABLE `readily_housereadily` ADD COLUMN `furn` int(11);
ALTER TABLE `readily_housereadily` ADD COLUMN `keyer` varchar(100);
ALTER TABLE `readily_housereadily` ADD COLUMN `state` int(11);
update readily_housereadily set state = 8 where state is null;
ALTER TABLE `readily_customer` ADD COLUMN `state` int(11);
update readily_customer set state = 8 where state is null;

--update readily_userext userext set userext.houseReadilyCount = (select count(id) from readily_housereadily where creater = userext.userId and isDelete = 1);
--update readily_userext userext set userext.customerCount = (select count(id) from readily_customer where creater = userext.userId and isDelete = 1);

INSERT INTO `readily_task` VALUES('1', '有头有脸', '上传头像获得2积分', '您第一次上传头像时可获得2积分,该任务可以获得{0}次奖励,您已获得其中{1}次奖励', 2, 2, 1, '', 1);
INSERT INTO `readily_task` VALUES('2', '资料齐全', '完善个人资料获得8积分', '您第一次上传头像时可获得8积分,该任务可以获得{0}次奖励,您已获得其中{1}次奖励', 8, 8, 1, '', 1);
INSERT INTO `readily_task` VALUES('3', '首次分享', '首次分享应用获得15积分', '您第一次分享应用时可获得15积分,该任务可以获得{0}次奖励,您已获得其中{1}次奖励', 15, 15, 1, '', 1);
INSERT INTO `readily_task` VALUES('4', '每日登录', '每天首次登录随机获得1-15分', '您在每天首次联网登录的时候将获得1-15积分,该任务每天可以获得{0}次奖励,您已获得其中{1}次奖励', null, null, 1, '', 2);
INSERT INTO `readily_task` VALUES('5', '房源达人', '每日前3次录入房源获得每次2积分', '您在每天前3次录入房源时每次可获得2积分,该任务每天可以获得{0}次奖励,您已获得其中{1}次奖励', 6, 6, 3, '', 2);
INSERT INTO `readily_task` VALUES('6', '客户专家', '每日前3次录入客源获得每次2积分', '您在每天前3次录入客源时每次可获得2积分,该任务每天可以获得{0}次奖励,您已获得其中{1}次奖励', 6, 6, 3, '', 2);
INSERT INTO `readily_task` VALUES('7', '分享应用', '分享应用获取5积分', '分享此应用可以获得5积分,该任务每天可以获得{0}次奖励,您已获得其中{1}次奖励', 5, 5, 1, '', 2);

select userId from readily_tasklog where taskId = 3 group by userId having count(userId) > 1;
update readily_code set description = concat('您的手机验证码为：', code, '，请在10分钟内按页面提示提交验证码。【随手房】') where description is null;

--处理刷分sql
insert into readily_tasklog(userId, taskId, growing, integration, creater, createTime) values(59896, 5, 2, 2, 59896, '2013-08-02 10:38:41');