/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MariaDB
 Source Server Version : 100307
 Source Host           : localhost:3306
 Source Schema         : kadima

 Target Server Type    : MariaDB
 Target Server Version : 100307
 File Encoding         : 65001

 Date: 10/06/2018 20:58:01
*/

DROP DATABASE IF EXISTS `kadima`;
CREATE DATABASE `kadima`;
USE `kadima`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`
(
  `id`       int(5)                                                  NOT NULL AUTO_INCREMENT,
  `uid`      int(5)                                                  NOT NULL,
  `title`    varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `category` int(1)                                                  NOT NULL DEFAULT 1,
  `content`  text CHARACTER SET utf8 COLLATE utf8_general_ci         NOT NULL,
  `time`     datetime(0)                                             NOT NULL DEFAULT current_timestamp(),
  `state`    int(1)                                                  NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `news_author` (`uid`) USING BTREE,
  CONSTRAINT `news_author` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article`
VALUES (1, 1, '国服筹备进度公开 打造用户体验和品牌社会影响力', 1, '<p>国服？</p>', '2018-06-10 20:54:25', 1);
INSERT INTO `article`
VALUES (2, 1, '活动公告', 2, '<p>活动公告测试1</p>', '2018-06-10 20:54:37', 1);
INSERT INTO `article`
VALUES (3, 1, '更新分析', 3, '<p>更新分析测试2</p>', '2018-06-10 20:54:49', 1);
INSERT INTO `article`
VALUES (4, 1, '怎么下蹲', 4, '<p></p><p>按C就可以了</p>', '2018-06-10 20:55:30', 1);
INSERT INTO `article`
VALUES (5, 1, '怎么切换手雷', 5, '<p>按G</p>', '2018-06-10 20:55:42', 1);
INSERT INTO `article`
VALUES (6, 1, '怎么吃鸡', 6, '<p>把Kadima祭天</p>', '2018-06-10 20:55:52', 1);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`
(
  `id`      int(5)                                                   NOT NULL AUTO_INCREMENT,
  `name`    varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci   NOT NULL,
  `email`   varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci   NOT NULL,
  `title`   varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci   NOT NULL,
  `content` varchar(1023) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `state`   int(1)                                                   NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message`
VALUES (1, '李尚哲', 'lsz0929@live.cn', '李尚哲牛逼', '两天嘻嘻', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
  `id`       int(5)                                                 NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` char(56) CHARACTER SET utf8 COLLATE utf8_general_ci    NOT NULL,
  `root`     int(1)                                                 NOT NULL,
  `state`    int(1)                                                 NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES (1, 'admin', '22F2D7FEEA7D16D7F25F86FA21A95780F54828D3ABFA3053E2311477', 1, 1);
INSERT INTO `user`
VALUES (2, 'kadima', '1DCCEABB46A172D48065130C412EA146FB0D725F371D3CDE39923C14', 1, 1);
INSERT INTO `user`
VALUES (3, 'lsz', '4CC8C6DBED14D4335B63F2D63B2837F4D4EB38B37A52D6C9D4BFB70C', 1, 1);

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`
(
  `id`    int(5)                                                  NOT NULL AUTO_INCREMENT,
  `uid`   int(5)                                                  NOT NULL,
  `name`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL,
  `type`  int(1)                                                  NOT NULL,
  `path`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time`  datetime(0)                                             NOT NULL DEFAULT current_timestamp(),
  `state` int(1)                                                  NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `video_user` (`uid`) USING BTREE,
  CONSTRAINT `video_user` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video`
VALUES (1, 1, '卢本伟牛逼', 2, '//player.bilibili.com/player.html?aid=17560149&cid=28719377&page=1', '2018-06-10 20:56:48',
        1);
INSERT INTO `video`
VALUES (2, 1, '神的随波逐流', 2, '//player.bilibili.com/player.html?aid=1731565&cid=2644659&page=1', '2018-06-10 20:56:59',
        1);

SET FOREIGN_KEY_CHECKS = 1;
