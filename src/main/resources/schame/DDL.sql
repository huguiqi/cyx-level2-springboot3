/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.1.199
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : 192.168.1.199:3306
 Source Schema         : STUDENT_DB

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 02/11/2023 21:36:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `name` varchar(45) NOT NULL,
                           `sex` char(1) DEFAULT NULL,
                           `birth` date DEFAULT NULL,
                           `photo_url` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

ALTER TABLE `STUDENT_DB`.`student`
    MODIFY COLUMN `birth` datetime NULL DEFAULT '' AFTER `sex`;


