/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : bill

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-03-02 15:59:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `id` char(36) NOT NULL,
  `userId` char(36) NOT NULL,
  `money` double NOT NULL,
  `time` char(10) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '0:未结算，1:已结算',
  `submitTime` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES ('a39a0511-e301-4f2f-ad62-680ab6c2d076', '07fb774a-1c64-11e8-b661-1c1b0df7c63c', '13.5', '2018-03-02', null, '0', '2018-03-02 15:54:14');
INSERT INTO `bill` VALUES ('e4dcd048-6874-4536-a09b-d634387e1ad2', '07fb774a-1c64-11e8-b661-1c1b0df7c63c', '13.5', '2018-03-02', null, '0', '2018-03-02 15:58:25');

-- ----------------------------
-- Table structure for inout
-- ----------------------------
DROP TABLE IF EXISTS `inout`;
CREATE TABLE `inout` (
  `id` char(36) NOT NULL,
  `resultId` char(36) NOT NULL,
  `userId` char(36) NOT NULL,
  `out` double NOT NULL,
  `in` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inout
-- ----------------------------

-- ----------------------------
-- Table structure for result
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `id` char(36) NOT NULL,
  `year` int(4) NOT NULL,
  `month` int(2) NOT NULL,
  `avg` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of result
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` char(36) NOT NULL,
  `account` varchar(20) NOT NULL,
  `name` varchar(10) NOT NULL,
  `password` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('07fb774a-1c64-11e8-b661-1c1b0df7c63c', 'shahx', '沙海霞', '123456');
INSERT INTO `user` VALUES ('d40cb4bc-1c63-11e8-b661-1c1b0df7c63c', 'luogy', '罗高阳', '123456');
INSERT INTO `user` VALUES ('f88e721a-1c63-11e8-b661-1c1b0df7c63c', 'xingzy', '邢正一', '123456');
