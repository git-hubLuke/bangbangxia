/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : bangbangxia

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2020-02-26 21:44:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bookmanage
-- ----------------------------
DROP TABLE IF EXISTS `bookmanage`;
CREATE TABLE `bookmanage` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) DEFAULT NULL,
  `book_author` varchar(255) DEFAULT NULL,
  `book_inventory` varchar(255) DEFAULT NULL,
  `book_price` double(255,0) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookmanage
-- ----------------------------
INSERT INTO `bookmanage` VALUES ('1', '水浒传', '施耐庵', '188', '50');
INSERT INTO `bookmanage` VALUES ('2', '三国演义', '罗贯中', '222', '88');
INSERT INTO `bookmanage` VALUES ('3', 'Java基础', '黑马程序员', '288', '69');

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(200) DEFAULT NULL,
  `task_content` varchar(200) DEFAULT NULL,
  `task_createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `accept_userId` int(11) DEFAULT NULL,
  `task_state` int(11) DEFAULT NULL,
  `task_money` float DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`task_id`),
  KEY `accept_userId` (`accept_userId`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `accept_userId` FOREIGN KEY (`accept_userId`) REFERENCES `user` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES ('1', '图书馆借书', '借java相关的书籍', '2020-02-17 16:57:44', '2', '2', '15', '2');
INSERT INTO `task` VALUES ('2', '校园帮拿快递', '帮老五拿快递', '2020-02-18 23:24:38', '1', '3', null, '1');
INSERT INTO `task` VALUES ('3', '老尾汕头店买肠粉', '帮小明买肠粉', '2020-02-23 14:14:04', '2', '1', null, '1');
INSERT INTO `task` VALUES ('4', '校园帮买水果茶', '帮小林去丹姐那里买一杯芒果益力多', '2020-02-18 23:24:25', '1', '1', null, '2');
INSERT INTO `task` VALUES ('5', 'abc', 'aaaa', '2020-02-18 23:24:29', '2', '2', null, '2');
INSERT INTO `task` VALUES ('6', 'aaa', 'bbbb', '2020-02-18 23:24:41', '1', '3', null, '2');
INSERT INTO `task` VALUES ('7', '登塘', '买卷粿条', '2020-02-18 23:24:32', '2', '3', null, '1');
INSERT INTO `task` VALUES ('11', '二饭买糖水', '帮室友去二饭帮糖水', '2020-02-18 23:24:26', '1', '1', null, '2');
INSERT INTO `task` VALUES ('12', '三饭买扒饭', '帮朋友去三饭买扒饭', '2020-02-23 14:14:08', '2', '1', null, '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_phone` varchar(255) DEFAULT NULL,
  `user_headpic` varchar(255) DEFAULT NULL,
  `user_token` varchar(255) DEFAULT NULL,
  `user_sex` char(20) DEFAULT NULL,
  `user_city` char(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '123', '15919578521', null, '', '男', '潮州');
INSERT INTO `user` VALUES ('2', 'laowang', 'qwertyui12345', null, null, null, null, null);
INSERT INTO `user` VALUES ('4', '小七', 'abcd1234', null, null, null, null, null);
INSERT INTO `user` VALUES ('5', '凤九', '2020', null, null, null, null, null);
INSERT INTO `user` VALUES ('6', 'admin', '123456', null, null, null, null, null);

-- ----------------------------
-- Table structure for user_sub
-- ----------------------------
DROP TABLE IF EXISTS `user_sub`;
CREATE TABLE `user_sub` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `subDateTime` datetime DEFAULT NULL,
  `returnDateTime` datetime DEFAULT NULL,
  `booktype` int(4) DEFAULT NULL,
  `returntype` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `book_id` FOREIGN KEY (`book_id`) REFERENCES `bookmanage` (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_sub
-- ----------------------------
INSERT INTO `user_sub` VALUES ('1', '3', '2', '2020-02-11 22:01:10', null, '2', '3');
INSERT INTO `user_sub` VALUES ('2', '3', '2', '2020-02-11 22:01:10', null, '1', '1');
INSERT INTO `user_sub` VALUES ('61', '2', '3', '2020-02-07 15:26:26', '2020-02-12 16:47:30', '3', '2');
INSERT INTO `user_sub` VALUES ('62', '2', '1', '2020-02-07 15:26:26', '2020-02-16 16:44:33', '2', '2');
INSERT INTO `user_sub` VALUES ('64', '3', '2', '2020-02-07 15:26:26', null, '1', '1');
