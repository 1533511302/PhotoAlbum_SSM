/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50639
Source Host           : localhost:3306
Source Database       : photoalbum

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2018-10-03 22:41:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for album
-- ----------------------------
DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
  `albumid` int(11) NOT NULL AUTO_INCREMENT,
  `albumname` varchar(32) NOT NULL,
  `userid` int(11) NOT NULL COMMENT '逻辑外键',
  `introduce` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`albumid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of album
-- ----------------------------
INSERT INTO `album` VALUES ('1', 'beauty', '1', '美女');
INSERT INTO `album` VALUES ('2', 'food', '1', '食物');
INSERT INTO `album` VALUES ('3', 'man', '1', 'Q头像');
INSERT INTO `album` VALUES ('4', 'wuman', '1', 'Q头像');
INSERT INTO `album` VALUES ('5', 'man', '1', 'Q头像');
INSERT INTO `album` VALUES ('6', 'dog', '1', '小狗');
INSERT INTO `album` VALUES ('7', 'dog', '1', '小狗相册');
INSERT INTO `album` VALUES ('8', 'dog', '1', '小狗相册');
INSERT INTO `album` VALUES ('9', 'dog', '1', '小狗相册');
INSERT INTO `album` VALUES ('10', '妹妹', '1', '漂亮');
INSERT INTO `album` VALUES ('11', '妹妹2', '1', '漂亮');
INSERT INTO `album` VALUES ('12', '妹妹3', '1', '漂亮');
INSERT INTO `album` VALUES ('13', '妹妹4', '1', '漂亮');

-- ----------------------------
-- Table structure for photo
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo` (
  `photoid` int(11) NOT NULL AUTO_INCREMENT,
  `photoname` varchar(32) NOT NULL,
  `albumid` int(11) NOT NULL,
  `photourl` varchar(512) DEFAULT NULL,
  `introduce` varchar(512) DEFAULT NULL,
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`photoid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of photo
-- ----------------------------
INSERT INTO `photo` VALUES ('1', '美女1', '5', 'studio_0001.jpg', '漂亮', '2018-09-09 13:55:44');
INSERT INTO `photo` VALUES ('2', '美女2', '5', 'studio_0002.jpg', '漂亮', '2018-09-09 13:55:45');
INSERT INTO `photo` VALUES ('3', '美女3', '5', 'studio_0003.jpg', '漂亮', '2018-09-09 13:55:46');
INSERT INTO `photo` VALUES ('4', '美女4', '5', 'studio_0004.jpg', '漂亮', '2018-09-09 13:55:47');
INSERT INTO `photo` VALUES ('5', '美女5', '5', 'studio_0005.jpg', '漂亮', '2018-09-09 13:55:47');
INSERT INTO `photo` VALUES ('6', '美女6', '5', 'studio_0006.jpg', '漂亮', '2018-09-09 13:55:48');
INSERT INTO `photo` VALUES ('7', '美女7', '5', 'studio_0007.jpg', '漂亮', '2018-09-09 13:55:48');
INSERT INTO `photo` VALUES ('8', '美女8', '5', 'studio_0008.jpg', '漂亮', '2018-09-09 13:55:49');
INSERT INTO `photo` VALUES ('9', '美女9', '5', 'studio_0009.jpg', '漂亮', '2018-09-09 13:55:50');
INSERT INTO `photo` VALUES ('10', '食物1', '4', 'food1.jpg', '漂亮', '2018-09-09 13:56:07');
INSERT INTO `photo` VALUES ('11', '食物2', '4', 'food2.jpg', '漂亮', '2018-09-09 13:56:09');
INSERT INTO `photo` VALUES ('12', '头像', '3', 'studio_0001.jpg', '漂亮', '2018-09-09 13:59:07');
INSERT INTO `photo` VALUES ('13', '头像2', '1', 'studio_0002.jpg', '漂亮', '2018-09-09 13:59:11');
INSERT INTO `photo` VALUES ('14', '头像3', '2', 'studio_0003.jpg', '漂亮', '2018-09-09 13:59:18');
INSERT INTO `photo` VALUES ('15', '小狗1', '6', 'dog1.jpg', '漂亮', '2018-09-09 13:43:24');
INSERT INTO `photo` VALUES ('16', '小狗2', '6', 'dog2.jpg', '漂亮', '2018-09-09 13:45:30');
INSERT INTO `photo` VALUES ('17', '小狗3', '6', 'dog3.jpg', '漂亮', '2018-09-09 13:45:30');
INSERT INTO `photo` VALUES ('18', '小狗4', '6', 'dog4.jpg', '漂亮', '2018-09-09 13:45:31');
INSERT INTO `photo` VALUES ('19', '小狗5', '7', 'dog2.jpg', '漂亮', '2018-09-09 13:45:32');
INSERT INTO `photo` VALUES ('20', '小狗6', '8', 'dog3.jpg', '漂亮', '2018-09-09 13:45:32');
INSERT INTO `photo` VALUES ('21', '小狗7', '9', 'dog1.jpg', '漂亮', '2018-09-09 14:01:45');
INSERT INTO `photo` VALUES ('22', '美女10', '5', 'studio_0009.jpg', '漂亮', '2018-10-01 10:25:50');
INSERT INTO `photo` VALUES ('23', '美女10', '5', 'studio_0008.jpg', '漂亮', '2018-10-01 10:25:52');
INSERT INTO `photo` VALUES ('24', '食物', '5', '4ca7a73fbdfd4260946d082796bba8e0.jpg', '漂亮', '2018-10-01 23:01:27');
INSERT INTO `photo` VALUES ('25', '食物', '2', '577cab26a35f462f91d0f3187fc41dc2.jpg', '漂亮', '2018-10-01 23:04:35');
INSERT INTO `photo` VALUES ('26', '小狗', '2', 'fc9639fdf392416f9b74bc1a0a1aaa48.jpg', '漂亮', '2018-10-01 23:07:52');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=193 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123456', '123456');
INSERT INTO `user` VALUES ('3', 'root', '123456');
