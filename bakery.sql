-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: prj_se_bakery
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `br_category`
--

DROP TABLE IF EXISTS `br_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `br_category` (
  `cat_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cat_id`),
  UNIQUE KEY `cat_name` (`cat_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `br_category`
--

LOCK TABLES `br_category` WRITE;
/*!40000 ALTER TABLE `br_category` DISABLE KEYS */;
INSERT INTO `br_category` VALUES (2,'Cat 1'),(1,'Cat 2');
/*!40000 ALTER TABLE `br_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `br_credit_card`
--

DROP TABLE IF EXISTS `br_credit_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `br_credit_card` (
  `card_id` int(11) NOT NULL AUTO_INCREMENT,
  `card_no` varchar(20) DEFAULT NULL,
  `card_paid` int(11) DEFAULT NULL,
  `card_status` enum('order','sales') DEFAULT NULL,
  `card_paid_id` varchar(15) NOT NULL,
  PRIMARY KEY (`card_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `br_credit_card`
--

LOCK TABLES `br_credit_card` WRITE;
/*!40000 ALTER TABLE `br_credit_card` DISABLE KEYS */;
INSERT INTO `br_credit_card` VALUES (1,'1111-1111-1111-1111',6500,'sales','INV_00000000003'),(2,'2222-2222-2222-2222',30400,'order','ORD_00000000003'),(3,'1111-1111-1111-1111',5000,'sales','INV_00000000005'),(4,'1111-1111-1111-1111',6200,'sales','INV_00000000006'),(5,'1111-1111-1111-1111',8600,'sales','INV_00000000007');
/*!40000 ALTER TABLE `br_credit_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `br_customer`
--

DROP TABLE IF EXISTS `br_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `br_customer` (
  `cust_id` int(11) NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(30) DEFAULT NULL,
  `cust_phno` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `br_customer`
--

LOCK TABLES `br_customer` WRITE;
/*!40000 ALTER TABLE `br_customer` DISABLE KEYS */;
INSERT INTO `br_customer` VALUES (2,'TTTT','1111'),(3,'Lwin Lwin','2222'),(4,'Phyo Phyo','22222'),(5,'Go GO','999999');
/*!40000 ALTER TABLE `br_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `br_employee`
--

DROP TABLE IF EXISTS `br_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `br_employee` (
  `emp_id` char(8) NOT NULL,
  `emp_name` varchar(35) NOT NULL,
  `emp_password` varchar(50) DEFAULT NULL,
  `emp_email` varchar(50) DEFAULT NULL,
  `emp_ph` varchar(9) DEFAULT NULL,
  `emp_roles` enum('admin','staff') DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `br_employee`
--

LOCK TABLES `br_employee` WRITE;
/*!40000 ALTER TABLE `br_employee` DISABLE KEYS */;
INSERT INTO `br_employee` VALUES ('eid_0001','Daw Hla','2f55c3c0d10571b03cb3deb89f338a65','hlahla@gmail.com','01123456','admin'),('eid_0002','U Ba','21661093e56e24cd60b10092005c4ac7','baba@gmail.com','01123456','staff'),('eid_0003','Daw Lwin','f801ee6854e902f73c6dd945ed2bd452','lwin@gmail.com','123456','admin'),('eid_0004','Mg Kyaw Kyaw','3c782fcc2d466fcce64f75e3ac09fb81','kyawkyaw@gmail.com','0111111','staff'),('eid_0005','Lwin Moe','478479140cf2173dc9dd0fabbf40bd29','lwin.moe@gmail.com','01222222','staff');
/*!40000 ALTER TABLE `br_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `br_employee_action_log`
--

DROP TABLE IF EXISTS `br_employee_action_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `br_employee_action_log` (
  `action_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` char(8) DEFAULT NULL,
  `action_date` datetime DEFAULT NULL,
  `action_name` enum('order','sales') DEFAULT NULL,
  `action_control_id` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`action_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `br_employee_action_log`
--

LOCK TABLES `br_employee_action_log` WRITE;
/*!40000 ALTER TABLE `br_employee_action_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `br_employee_action_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `br_employee_log`
--

DROP TABLE IF EXISTS `br_employee_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `br_employee_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` char(8) DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  `logout_time` datetime DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `br_employee_log`
--

LOCK TABLES `br_employee_log` WRITE;
/*!40000 ALTER TABLE `br_employee_log` DISABLE KEYS */;
INSERT INTO `br_employee_log` VALUES (2,'eid_0001','2019-08-05 19:15:07','2019-08-05 19:15:19'),(3,'eid_0001','2019-08-05 20:17:00','2019-08-05 20:17:15'),(4,'eid_0001','2019-08-06 09:05:47','2019-08-06 20:10:30'),(5,'eid_0001','2019-08-06 09:06:34','2019-08-06 20:10:30'),(6,'eid_0001','2019-08-06 09:07:10','2019-08-06 20:10:30'),(7,'eid_0001','2019-08-06 09:08:27','2019-08-06 20:10:30'),(8,'eid_0001','2019-08-06 09:09:11','2019-08-06 20:10:30'),(9,'eid_0001','2019-08-06 09:10:00','2019-08-06 20:10:30'),(10,'eid_0001','2019-08-06 09:40:47','2019-08-06 20:10:30'),(11,'eid_0001','2019-08-06 09:56:17','2019-08-06 20:10:30'),(12,'eid_0001','2019-08-06 09:58:17','2019-08-06 20:10:30'),(13,'eid_0001','2019-08-06 10:06:10','2019-08-06 20:10:30'),(14,'eid_0001','2019-08-06 10:08:15','2019-08-06 20:10:30'),(15,'eid_0001','2019-08-06 10:20:18','2019-08-06 20:10:30'),(16,'eid_0001','2019-08-06 10:36:51','2019-08-06 20:10:30'),(17,'eid_0001','2019-08-06 10:41:49','2019-08-06 20:10:30'),(18,'eid_0001','2019-08-06 10:45:19','2019-08-06 20:10:30'),(19,'eid_0001','2019-08-06 19:33:41','2019-08-06 20:10:30'),(20,'eid_0001','2019-08-06 19:44:11','2019-08-06 20:10:30'),(21,'eid_0001','2019-08-06 19:46:00','2019-08-06 20:10:30'),(22,'eid_0001','2019-08-06 19:53:40','2019-08-06 20:10:30'),(23,'eid_0001','2019-08-06 19:56:10','2019-08-06 20:10:30'),(24,'eid_0001','2019-08-06 20:01:05','2019-08-06 20:10:30'),(25,'eid_0001','2019-08-06 20:05:27','2019-08-06 20:10:30'),(26,'eid_0001','2019-08-06 20:08:54','2019-08-06 20:10:30'),(27,'eid_0001','2019-08-21 07:46:34','2019-08-21 08:05:23'),(28,'eid_0001','2019-08-21 08:05:18','2019-08-21 08:05:23'),(29,'eid_0001','2019-08-25 06:45:14','2019-08-27 18:18:39'),(30,'eid_0001','2019-08-25 06:49:25','2019-08-27 18:18:39'),(31,'eid_0001','2019-08-25 07:05:55','2019-08-27 18:18:39'),(32,'eid_0001','2019-08-25 07:06:45','2019-08-27 18:18:39'),(33,'eid_0001','2019-08-25 13:46:18','2019-08-27 18:18:39'),(34,'eid_0001','2019-08-25 18:06:23','2019-08-27 18:18:39'),(35,'eid_0001','2019-08-26 09:09:08','2019-08-27 18:18:39'),(36,'eid_0001','2019-08-26 09:11:21','2019-08-27 18:18:39'),(37,'eid_0001','2019-08-26 09:25:05','2019-08-27 18:18:39'),(38,'eid_0001','2019-08-27 18:18:23','2019-08-27 18:18:39'),(39,'eid_0001','2019-08-27 18:41:01','2019-08-28 10:22:53'),(40,'eid_0001','2019-08-27 18:42:54','2019-08-28 10:22:53'),(41,'eid_0001','2019-08-28 05:57:07','2019-08-28 10:22:53'),(42,'eid_0001','2019-08-28 05:59:49','2019-08-28 10:22:53'),(43,'eid_0001','2019-08-28 06:00:50','2019-08-28 10:22:53'),(44,'eid_0001','2019-08-28 06:02:53','2019-08-28 10:22:53'),(45,'eid_0001','2019-08-28 06:04:55','2019-08-28 10:22:53'),(46,'eid_0001','2019-08-28 06:06:45','2019-08-28 10:22:53'),(47,'eid_0001','2019-08-28 06:07:41','2019-08-28 10:22:53'),(48,'eid_0001','2019-08-28 06:12:17','2019-08-28 10:22:53'),(49,'eid_0001','2019-08-28 07:05:01','2019-08-28 10:22:53'),(50,'eid_0001','2019-08-28 07:06:52','2019-08-28 10:22:53'),(51,'eid_0001','2019-08-28 07:12:53','2019-08-28 10:22:53'),(52,'eid_0001','2019-08-28 08:33:45','2019-08-28 10:22:53'),(53,'eid_0001','2019-08-28 09:20:45','2019-08-28 10:22:53'),(54,'eid_0001','2019-08-28 09:21:50','2019-08-28 10:22:53'),(55,'eid_0001','2019-08-28 09:30:06','2019-08-28 10:22:53'),(56,'eid_0001','2019-08-28 09:31:29','2019-08-28 10:22:53'),(57,'eid_0001','2019-08-28 09:33:26','2019-08-28 10:22:53'),(58,'eid_0001','2019-08-28 09:34:24','2019-08-28 10:22:53'),(59,'eid_0001','2019-08-28 09:36:27','2019-08-28 10:22:53'),(60,'eid_0001','2019-08-28 09:37:30','2019-08-28 10:22:53'),(61,'eid_0001','2019-08-28 09:38:25','2019-08-28 10:22:53'),(62,'eid_0001','2019-08-28 09:39:05','2019-08-28 10:22:53'),(63,'eid_0001','2019-08-28 09:39:57','2019-08-28 10:22:53'),(64,'eid_0001','2019-08-28 09:41:02','2019-08-28 10:22:53'),(65,'eid_0001','2019-08-28 09:42:09','2019-08-28 10:22:53'),(66,'eid_0001','2019-08-28 09:43:07','2019-08-28 10:22:53'),(67,'eid_0001','2019-08-28 09:43:46','2019-08-28 10:22:53'),(68,'eid_0001','2019-08-28 09:44:38','2019-08-28 10:22:53'),(69,'eid_0001','2019-08-28 09:45:12','2019-08-28 10:22:53'),(70,'eid_0001','2019-08-28 10:17:34','2019-08-28 10:22:53'),(71,'eid_0001','2019-08-28 10:18:42','2019-08-28 10:22:53'),(72,'eid_0001','2019-08-28 10:19:46','2019-08-28 10:22:53'),(73,'eid_0001','2019-08-28 10:21:47','2019-08-28 10:22:53'),(74,'eid_0001','2019-08-28 10:22:32','2019-08-28 10:22:53'),(75,'eid_0001','2019-08-28 10:34:31','2019-08-28 11:18:56'),(76,'eid_0001','2019-08-28 10:36:41','2019-08-28 11:18:56'),(77,'eid_0001','2019-08-28 10:50:51','2019-08-28 11:18:56'),(78,'eid_0001','2019-08-28 11:07:25','2019-08-28 11:18:56'),(79,'eid_0001','2019-08-28 11:10:35','2019-08-28 11:18:56'),(80,'eid_0001','2019-08-28 11:18:45','2019-08-28 11:18:56'),(81,'eid_0002','2019-08-28 11:19:03','2019-08-28 11:24:31'),(82,'eid_0001','2019-08-28 11:24:39',NULL),(83,'eid_0001','2019-08-28 11:30:00',NULL),(84,'eid_0001','2019-08-28 11:32:46',NULL);
/*!40000 ALTER TABLE `br_employee_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `br_ingredient`
--

DROP TABLE IF EXISTS `br_ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `br_ingredient` (
  `ing_id` int(11) NOT NULL AUTO_INCREMENT,
  `ing_name` varchar(150) DEFAULT NULL,
  `ing_desc` varchar(300) DEFAULT NULL,
  `ing_cost` int(11) DEFAULT NULL,
  `ing_qty` int(11) DEFAULT NULL,
  `order_no` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ing_id`),
  KEY `order_no` (`order_no`),
  CONSTRAINT `br_ingredient_ibfk_1` FOREIGN KEY (`order_no`) REFERENCES `br_order` (`order_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `br_ingredient`
--

LOCK TABLES `br_ingredient` WRITE;
/*!40000 ALTER TABLE `br_ingredient` DISABLE KEYS */;
INSERT INTO `br_ingredient` VALUES (1,'Ing1','Ing Desc',100,5,'ORD_00000000002'),(2,'Ing 123','Ing 123 Desc',5000,5,'ORD_00000000003'),(3,'Cake','Cake',40,5,'ORD_00000000003'),(4,'Cake','Cake',40,5,'ORD_00000000003'),(5,'Candle','White Candle',10,100,'ORD_00000000004');
/*!40000 ALTER TABLE `br_ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `br_order`
--

DROP TABLE IF EXISTS `br_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `br_order` (
  `order_no` char(15) NOT NULL,
  `order_date` date NOT NULL,
  `receive_date` date DEFAULT NULL,
  `order_status` tinyint(4) DEFAULT NULL,
  `paid_status` enum('cash','card') NOT NULL,
  `cust_id` int(11) NOT NULL,
  `emp_id` char(8) NOT NULL,
  PRIMARY KEY (`order_no`),
  KEY `cust_id` (`cust_id`),
  KEY `emp_id` (`emp_id`),
  CONSTRAINT `br_order_ibfk_1` FOREIGN KEY (`cust_id`) REFERENCES `br_customer` (`cust_id`),
  CONSTRAINT `br_order_ibfk_2` FOREIGN KEY (`emp_id`) REFERENCES `br_employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `br_order`
--

LOCK TABLES `br_order` WRITE;
/*!40000 ALTER TABLE `br_order` DISABLE KEYS */;
INSERT INTO `br_order` VALUES ('ORD_00000000001','2019-08-26','2019-08-29',1,'cash',2,'eid_0001'),('ORD_00000000002','2019-08-26','2019-08-29',1,'cash',3,'eid_0001'),('ORD_00000000003','2019-08-26','2019-08-30',0,'card',4,'eid_0001'),('ORD_00000000004','2019-08-28','2019-08-31',1,'cash',5,'eid_0002');
/*!40000 ALTER TABLE `br_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `br_order_detail`
--

DROP TABLE IF EXISTS `br_order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `br_order_detail` (
  `order_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_qty` int(11) DEFAULT NULL,
  `order_price` int(11) DEFAULT NULL,
  `order_no` char(15) DEFAULT NULL,
  `prod_id` char(8) NOT NULL,
  PRIMARY KEY (`order_detail_id`),
  KEY `prod_id` (`prod_id`),
  KEY `order_no` (`order_no`),
  CONSTRAINT `br_order_detail_ibfk_2` FOREIGN KEY (`prod_id`) REFERENCES `br_product` (`prod_id`),
  CONSTRAINT `br_order_detail_ibfk_3` FOREIGN KEY (`order_no`) REFERENCES `br_order` (`order_no`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `br_order_detail`
--

LOCK TABLES `br_order_detail` WRITE;
/*!40000 ALTER TABLE `br_order_detail` DISABLE KEYS */;
INSERT INTO `br_order_detail` VALUES (2,3,1300,'ORD_00000000001','pid_0001'),(3,5,1300,'ORD_00000000002','pid_0001'),(4,2,1200,'ORD_00000000003','pid_0002'),(5,2,1300,'ORD_00000000003','pid_0001'),(6,2,1300,'ORD_00000000004','pid_0001'),(7,5,1200,'ORD_00000000004','pid_0002');
/*!40000 ALTER TABLE `br_order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `br_orders_view`
--

DROP TABLE IF EXISTS `br_orders_view`;
/*!50001 DROP VIEW IF EXISTS `br_orders_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `br_orders_view` AS SELECT 
 1 AS `ono`,
 1 AS `odate_str`,
 1 AS `rdate_str`,
 1 AS `odate`,
 1 AS `rdate`,
 1 AS `ostatus`,
 1 AS `pstatus`,
 1 AS `cname`,
 1 AS `detail_total`,
 1 AS `ing_total`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `br_product`
--

DROP TABLE IF EXISTS `br_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `br_product` (
  `prod_id` char(8) NOT NULL,
  `prod_name` varchar(100) DEFAULT NULL,
  `prod_price` int(11) DEFAULT NULL,
  `prod_desc` varchar(300) DEFAULT NULL,
  `cat_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`prod_id`),
  KEY `cat_id` (`cat_id`),
  CONSTRAINT `br_product_ibfk_1` FOREIGN KEY (`cat_id`) REFERENCES `br_category` (`cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `br_product`
--

LOCK TABLES `br_product` WRITE;
/*!40000 ALTER TABLE `br_product` DISABLE KEYS */;
INSERT INTO `br_product` VALUES ('pid_0001','Cheese Cake',1300,'Cheese Plain',2),('pid_0002','BlueBerry Cake',1200,'Test',2);
/*!40000 ALTER TABLE `br_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `br_product_photo`
--

DROP TABLE IF EXISTS `br_product_photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `br_product_photo` (
  `prod_id` char(8) NOT NULL,
  `photo_name` varchar(50) DEFAULT NULL,
  `photo_data` blob,
  `photo_size` int(11) DEFAULT NULL,
  PRIMARY KEY (`prod_id`),
  CONSTRAINT `br_product_photo_ibfk_1` FOREIGN KEY (`prod_id`) REFERENCES `br_product` (`prod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `br_product_photo`
--

LOCK TABLES `br_product_photo` WRITE;
/*!40000 ALTER TABLE `br_product_photo` DISABLE KEYS */;
/*!40000 ALTER TABLE `br_product_photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `br_sales`
--

DROP TABLE IF EXISTS `br_sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `br_sales` (
  `sales_id` char(15) NOT NULL,
  `sales_date` datetime DEFAULT NULL,
  `paid_status` enum('cash','card') NOT NULL,
  `emp_id` char(8) NOT NULL,
  PRIMARY KEY (`sales_id`),
  KEY `emp_id` (`emp_id`),
  CONSTRAINT `br_sales_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `br_employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `br_sales`
--

LOCK TABLES `br_sales` WRITE;
/*!40000 ALTER TABLE `br_sales` DISABLE KEYS */;
INSERT INTO `br_sales` VALUES ('INV_00000000001','2019-08-06 19:46:49','cash','eid_0001'),('INV_00000000002','2019-08-06 20:01:23','cash','eid_0001'),('INV_00000000003','2019-08-06 20:09:17','card','eid_0001'),('INV_00000000004','2019-08-25 14:02:42','cash','eid_0001'),('INV_00000000005','2019-08-28 10:35:05','card','eid_0001'),('INV_00000000006','2019-08-28 10:41:25','card','eid_0001'),('INV_00000000007','2019-08-28 10:51:36','card','eid_0001'),('INV_00000000008','2019-08-28 11:07:53','cash','eid_0001');
/*!40000 ALTER TABLE `br_sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `br_sales_detail`
--

DROP TABLE IF EXISTS `br_sales_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `br_sales_detail` (
  `detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `prod_id` char(8) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `sales_id` char(15) DEFAULT NULL,
  PRIMARY KEY (`detail_id`),
  KEY `prod_id` (`prod_id`),
  KEY `sales_id` (`sales_id`),
  CONSTRAINT `br_sales_detail_ibfk_2` FOREIGN KEY (`prod_id`) REFERENCES `br_product` (`prod_id`),
  CONSTRAINT `br_sales_detail_ibfk_3` FOREIGN KEY (`sales_id`) REFERENCES `br_sales` (`sales_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `br_sales_detail`
--

LOCK TABLES `br_sales_detail` WRITE;
/*!40000 ALTER TABLE `br_sales_detail` DISABLE KEYS */;
INSERT INTO `br_sales_detail` VALUES (1,'pid_0001',3,1300,'INV_00000000001'),(2,'pid_0002',5,1200,'INV_00000000001'),(3,'pid_0001',3,1300,'INV_00000000002'),(4,'pid_0002',5,1200,'INV_00000000002'),(5,'pid_0001',5,1300,'INV_00000000003'),(6,'pid_0001',5,1300,'INV_00000000004'),(7,'pid_0001',2,1300,'INV_00000000005'),(8,'pid_0002',2,1200,'INV_00000000005'),(9,'pid_0001',2,1300,'INV_00000000006'),(10,'pid_0002',3,1200,'INV_00000000006'),(11,'pid_0001',2,1300,'INV_00000000007'),(12,'pid_0002',5,1200,'INV_00000000007'),(13,'pid_0001',6,1300,'INV_00000000008');
/*!40000 ALTER TABLE `br_sales_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `br_sales_view`
--

DROP TABLE IF EXISTS `br_sales_view`;
/*!50001 DROP VIEW IF EXISTS `br_sales_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `br_sales_view` AS SELECT 
 1 AS `sid`,
 1 AS `sdateStr`,
 1 AS `sdate`,
 1 AS `status`,
 1 AS `seid`,
 1 AS `sename`,
 1 AS `stotal`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `br_orders_view`
--

/*!50001 DROP VIEW IF EXISTS `br_orders_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `br_orders_view` AS select `o`.`order_no` AS `ono`,date_format(`o`.`order_date`,'%d-%m-%Y') AS `odate_str`,date_format(`o`.`receive_date`,'%d-%m-%Y') AS `rdate_str`,`o`.`order_date` AS `odate`,`o`.`receive_date` AS `rdate`,if((`o`.`order_status` = 1),'FINISH','NOT FINISH') AS `ostatus`,`o`.`paid_status` AS `pstatus`,`c`.`cust_name` AS `cname`,(select sum((`d`.`order_qty` * `d`.`order_price`)) from `br_order_detail` `d` where (`d`.`order_no` = `o`.`order_no`)) AS `detail_total`,(select sum((`i`.`ing_cost` * `i`.`ing_qty`)) from `br_ingredient` `i` where (`i`.`order_no` = `o`.`order_no`)) AS `ing_total` from (`br_order` `o` join `br_customer` `c`) where (`o`.`cust_id` = `c`.`cust_id`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `br_sales_view`
--

/*!50001 DROP VIEW IF EXISTS `br_sales_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `br_sales_view` AS select `s`.`sales_id` AS `sid`,date_format(`s`.`sales_date`,'%d-%m-%Y %h:%i:%s %p') AS `sdateStr`,`s`.`sales_date` AS `sdate`,`s`.`paid_status` AS `status`,`s`.`emp_id` AS `seid`,`e`.`emp_name` AS `sename`,(select sum((`d`.`qty` * `d`.`price`)) from `br_sales_detail` `d` where (`d`.`sales_id` = `s`.`sales_id`)) AS `stotal` from (`br_sales` `s` join `br_employee` `e`) where (`s`.`emp_id` = `e`.`emp_id`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-28 11:38:11
