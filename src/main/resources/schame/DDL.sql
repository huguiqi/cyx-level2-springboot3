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


CREATE TABLE `dept` (
                        `id` varchar(10) NOT NULL,
                        `manager` varchar(45) DEFAULT NULL,
                        `name` varchar(45) DEFAULT NULL,
                        `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
                        `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3


DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
                            `id` varchar(255) NOT NULL,
                            `dept` varchar(255) DEFAULT NULL,
                            `name` varchar(255) DEFAULT NULL,
                            `position` varchar(255) DEFAULT NULL,
                            `salary` float DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('1','销售部','刘光达','枪手',3500.45);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_api`
--

DROP TABLE IF EXISTS `employee_api`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_api` (
                                `id` varchar(255) NOT NULL,
                                `employee_id` varchar(255) DEFAULT NULL,
                                `leader` varchar(45) DEFAULT NULL,
                                `kpi` varchar(255) DEFAULT NULL,
                                `comments` varchar(255) DEFAULT NULL,
                                `check_date` datetime DEFAULT CURRENT_TIMESTAMP,
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_api`
--

LOCK TABLES `employee_api` WRITE;
/*!40000 ALTER TABLE `employee_api` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_api` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary_data`
--

DROP TABLE IF EXISTS `salary_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary_data` (
                               `years` int NOT NULL,
                               `salary` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;
