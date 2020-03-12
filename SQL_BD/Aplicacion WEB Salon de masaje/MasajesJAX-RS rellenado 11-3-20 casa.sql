CREATE DATABASE  IF NOT EXISTS `masajesjax-rs` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `masajesjax-rs`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: masajesjax-rs
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `idclientes` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `apellidos` varchar(90) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `dni` char(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `borrado` tinyint DEFAULT '0',
  PRIMARY KEY (`idclientes`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Roberto','Loyoa Gil','78963256U',0),(2,'Vanesa','Romero Cuesta','74112588Y',0),(6,'Rodolfo','Chiquilicuatre','78785421G',0),(7,'Miguelito','Minguez Mengual','78785421N',0),(8,'Minguito','Lorenzo Grijalba','72514585V',0),(9,'Lara','Alvarez Serna','75856555K',0),(11,'Pepe Luis','Gonzalez Ruiz','71252222A',0),(12,'Ramon','Pelaez','78888888F',0),(13,'Rodrigo','Casas O\'donnel','71131223F',0),(39,'Javier','Ortega Perez','75421585L',0),(40,'Lorenza','Martinez Pernia','75123695W',0);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `clientes_BEFORE_INSERT` BEFORE INSERT ON `clientes` FOR EACH ROW BEGIN
	INSERT INTO historial (tabla, accion) VALUES ('clientes','antes de insertar');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `clientes_AFTER_INSERT` AFTER INSERT ON `clientes` FOR EACH ROW BEGIN
	INSERT INTO historial (tabla, accion) VALUES ('clientes','cliente insertado');

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `clientes_BEFORE_UPDATE` BEFORE UPDATE ON `clientes` FOR EACH ROW BEGIN
	INSERT INTO historial (tabla, accion) VALUES ('clientes','antes de actualizar');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `clientes_AFTER_UPDATE` AFTER UPDATE ON `clientes` FOR EACH ROW BEGIN
	INSERT INTO historial (tabla, accion) VALUES ('clientes','cliente actualizado');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `clientes_BEFORE_DELETE` BEFORE DELETE ON `clientes` FOR EACH ROW BEGIN
	INSERT INTO historial (tabla, accion) VALUES ('clientes','antes de eliminar');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `clientes_AFTER_DELETE` AFTER DELETE ON `clientes` FOR EACH ROW BEGIN
	INSERT INTO historial (tabla, accion) VALUES ('clientes','cliente eliminado');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Temporary view structure for view `clientesgetall`
--

DROP TABLE IF EXISTS `clientesgetall`;
/*!50001 DROP VIEW IF EXISTS `clientesgetall`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `clientesgetall` AS SELECT 
 1 AS `idclientes`,
 1 AS `nombre`,
 1 AS `apellidos`,
 1 AS `dni`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `historial`
--

DROP TABLE IF EXISTS `historial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historial` (
  `idhistorial` int NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tabla` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `accion` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`idhistorial`)
) ENGINE=InnoDB AUTO_INCREMENT=519 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial`
--

LOCK TABLES `historial` WRITE;
/*!40000 ALTER TABLE `historial` DISABLE KEYS */;
INSERT INTO `historial` VALUES (1,'2020-02-25 21:01:05','servicios','insertado'),(2,'2020-02-25 21:01:23','trabajadores','insertado'),(3,'2020-02-25 21:01:57','clientes','antes de insertar'),(4,'2020-02-25 21:01:57','clientes','insertado'),(5,'2020-02-25 21:28:47','servicios','actualizado'),(6,'2020-02-25 21:29:00','servicios','actualizado'),(7,'2020-02-25 21:30:03','clientes','antes de actualizar'),(8,'2020-02-25 21:30:03','clientes','actualizado'),(9,'2020-02-25 21:30:20','clientes','antes de insertar'),(10,'2020-02-25 21:30:20','clientes','insertado'),(11,'2020-02-25 21:30:24','clientes','antes de eliminar'),(12,'2020-02-25 21:30:24','clientes','eliminado'),(13,'2020-02-25 21:31:02','clientes','antes de actualizar'),(14,'2020-02-25 21:31:02','clientes','actualizado'),(15,'2020-02-25 21:31:10','clientes','antes de actualizar'),(16,'2020-02-25 21:31:10','clientes','actualizado'),(17,'2020-02-25 21:31:26','clientes','antes de actualizar'),(18,'2020-02-25 21:31:26','clientes','actualizado'),(19,'2020-02-25 21:31:48','clientes','antes de actualizar'),(20,'2020-02-25 21:31:48','clientes','actualizado'),(21,'2020-02-25 21:32:07','trabajadores','actualizado'),(22,'2020-02-25 21:32:43','trabajadores','actualizado'),(23,'2020-02-25 21:32:52','servicios','eliminado'),(24,'2020-02-26 00:03:12','clientes','antes de actualizar'),(25,'2020-02-26 00:03:12','clientes','actualizado'),(26,'2020-02-26 00:05:12','clientes','antes de insertar'),(27,'2020-02-26 00:05:12','clientes','insertado'),(28,'2020-02-26 00:05:22','clientes','antes de eliminar'),(29,'2020-02-26 00:05:22','clientes','eliminado'),(30,'2020-02-26 18:00:12','trabajadores','insertado'),(31,'2020-02-26 18:28:59','sesiones','insertada'),(32,'2020-02-26 23:49:28','servicios','insertado'),(33,'2020-02-27 19:49:02','sesiones','actualizada'),(34,'2020-02-27 19:49:26','sesiones','actualizada'),(35,'2020-02-27 19:49:51','sesiones','actualizada'),(36,'2020-02-27 19:50:04','sesiones','actualizada'),(37,'2020-02-27 19:50:42','sesiones','actualizada'),(38,'2020-02-27 19:51:12','sesiones','actualizada'),(39,'2020-02-27 19:51:34','sesiones','actualizada'),(40,'2020-02-27 19:51:59','sesiones','actualizada'),(41,'2020-02-27 19:52:07','sesiones','actualizada'),(42,'2020-02-27 19:52:24','sesiones','actualizada'),(43,'2020-02-27 19:52:57','sesiones','actualizada'),(55,'2020-02-27 20:02:37','clientes','antes de insertar'),(56,'2020-02-27 20:02:37','clientes','cliente insertado'),(57,'2020-02-27 20:02:37','clientes','antes de insertar'),(58,'2020-02-27 20:02:37','clientes','cliente insertado'),(59,'2020-02-27 20:02:37','clientes','antes de insertar'),(60,'2020-02-27 20:02:37','clientes','cliente insertado'),(61,'2020-02-27 20:02:37','clientes','antes de insertar'),(62,'2020-02-27 20:02:37','clientes','cliente insertado'),(63,'2020-02-27 20:02:37','clientes','antes de insertar'),(64,'2020-02-27 20:02:37','clientes','cliente insertado'),(65,'2020-02-27 20:02:37','clientes','antes de insertar'),(66,'2020-02-27 20:02:37','clientes','cliente insertado'),(67,'2020-02-27 20:03:05','sesiones','actualizada'),(68,'2020-02-27 20:03:23','clientes','antes de actualizar'),(69,'2020-02-27 20:03:23','clientes','cliente actualizado'),(70,'2020-02-27 20:03:28','clientes','antes de actualizar'),(71,'2020-02-27 20:03:28','clientes','cliente actualizado'),(72,'2020-02-27 20:04:37','clientes','antes de actualizar'),(73,'2020-02-27 20:04:37','clientes','cliente actualizado'),(74,'2020-02-27 20:13:44','servicios','eliminado'),(75,'2020-02-27 20:15:15','servicios','insertado'),(76,'2020-02-27 20:15:32','servicios','actualizado'),(77,'2020-02-27 20:16:13','servicios','eliminado'),(78,'2020-02-27 20:16:50','servicios','insertado'),(79,'2020-02-27 20:17:09','servicios','eliminado'),(80,'2020-02-28 20:00:18','sesiones','insertada'),(81,'2020-02-28 20:03:02','sesiones','insertada'),(82,'2020-02-28 20:05:40','sesiones','insertada'),(83,'2020-02-28 20:05:52','sesiones','actualizada'),(84,'2020-03-03 18:35:02','clientes','antes de insertar'),(85,'2020-03-03 18:35:02','clientes','cliente insertado'),(86,'2020-03-03 18:35:50','trabajadores','insertado'),(87,'2020-03-03 18:36:52','servicios','insertado'),(88,'2020-03-03 19:03:41','clientes','antes de actualizar'),(89,'2020-03-03 19:03:41','clientes','cliente actualizado'),(90,'2020-03-03 19:06:35','clientes','antes de actualizar'),(91,'2020-03-03 19:06:35','clientes','cliente actualizado'),(92,'2020-03-03 19:16:18','clientes','antes de actualizar'),(93,'2020-03-03 19:16:18','clientes','cliente actualizado'),(94,'2020-03-03 19:16:37','clientes','antes de actualizar'),(95,'2020-03-03 19:16:37','clientes','cliente actualizado'),(96,'2020-03-03 19:16:46','clientes','antes de actualizar'),(97,'2020-03-03 19:16:46','clientes','cliente actualizado'),(98,'2020-03-03 19:17:10','clientes','antes de actualizar'),(99,'2020-03-03 19:17:10','clientes','cliente actualizado'),(100,'2020-03-03 19:17:26','clientes','antes de actualizar'),(101,'2020-03-03 19:17:26','clientes','cliente actualizado'),(102,'2020-03-03 19:19:33','clientes','antes de actualizar'),(103,'2020-03-03 19:19:33','clientes','cliente actualizado'),(104,'2020-03-03 19:20:31','clientes','antes de actualizar'),(105,'2020-03-03 19:20:31','clientes','cliente actualizado'),(106,'2020-03-03 19:20:36','clientes','antes de actualizar'),(107,'2020-03-03 19:20:36','clientes','cliente actualizado'),(108,'2020-03-03 19:21:00','clientes','antes de actualizar'),(109,'2020-03-03 19:21:00','clientes','cliente actualizado'),(110,'2020-03-03 19:21:03','clientes','antes de actualizar'),(111,'2020-03-03 19:21:03','clientes','cliente actualizado'),(112,'2020-03-03 19:24:20','clientes','antes de actualizar'),(113,'2020-03-03 19:24:20','clientes','cliente actualizado'),(114,'2020-03-03 19:24:42','clientes','antes de actualizar'),(115,'2020-03-03 19:24:42','clientes','cliente actualizado'),(116,'2020-03-03 19:28:46','clientes','antes de insertar'),(117,'2020-03-03 19:28:46','clientes','cliente insertado'),(118,'2020-03-03 19:41:29','trabajadores','insertado'),(119,'2020-03-03 19:43:37','trabajadores','insertado'),(120,'2020-03-03 19:45:12','trabajadores','actualizado'),(121,'2020-03-03 19:50:49','trabajadores','actualizado'),(122,'2020-03-03 20:29:06','clientes','antes de actualizar'),(123,'2020-03-03 20:29:06','clientes','cliente actualizado'),(124,'2020-03-03 20:29:23','clientes','antes de actualizar'),(125,'2020-03-03 20:29:23','clientes','cliente actualizado'),(126,'2020-03-03 20:29:33','clientes','antes de actualizar'),(127,'2020-03-03 20:29:33','clientes','cliente actualizado'),(128,'2020-03-03 20:31:44','clientes','antes de actualizar'),(129,'2020-03-03 20:31:44','clientes','cliente actualizado'),(130,'2020-03-03 21:10:13','trabajadores','actualizado'),(131,'2020-03-03 21:10:19','trabajadores','actualizado'),(132,'2020-03-03 21:10:29','trabajadores','actualizado'),(133,'2020-03-03 21:28:01','servicios','actualizado'),(134,'2020-03-03 21:28:06','servicios','actualizado'),(135,'2020-03-03 21:28:49','servicios','actualizado'),(136,'2020-03-03 21:28:59','servicios','actualizado'),(137,'2020-03-03 21:30:43','servicios','actualizado'),(138,'2020-03-03 21:30:49','servicios','actualizado'),(139,'2020-03-03 21:31:31','servicios','actualizado'),(140,'2020-03-03 21:31:51','servicios','actualizado'),(141,'2020-03-03 21:32:05','servicios','actualizado'),(142,'2020-03-03 21:37:40','servicios','actualizado'),(143,'2020-03-03 21:38:30','servicios','actualizado'),(144,'2020-03-04 17:46:35','sesiones','insertada'),(145,'2020-03-04 17:47:41','sesiones','actualizada'),(146,'2020-03-04 18:26:42','trabajadores','insertado'),(147,'2020-03-04 18:27:12','trabajadores','actualizado'),(148,'2020-03-04 18:27:56','trabajadores','insertado'),(149,'2020-03-04 18:30:04','trabajadores','insertado'),(150,'2020-03-04 18:45:16','trabajadores','eliminado'),(151,'2020-03-04 18:47:09','trabajadores','actualizado'),(152,'2020-03-04 18:47:17','trabajadores','actualizado'),(153,'2020-03-04 18:48:35','trabajadores','insertado'),(154,'2020-03-04 18:55:28','trabajadores','actualizado'),(155,'2020-03-04 18:56:16','trabajadores','actualizado'),(156,'2020-03-04 18:56:20','trabajadores','actualizado'),(157,'2020-03-04 19:16:11','trabajadores','actualizado'),(158,'2020-03-04 19:23:34','trabajadores','actualizado'),(159,'2020-03-04 19:23:42','trabajadores','actualizado'),(160,'2020-03-04 19:24:30','trabajadores','actualizado'),(161,'2020-03-04 19:24:36','trabajadores','actualizado'),(162,'2020-03-04 19:27:14','trabajadores','actualizado'),(163,'2020-03-04 19:27:20','trabajadores','actualizado'),(164,'2020-03-04 19:34:37','trabajadores','insertado'),(165,'2020-03-04 19:49:19','trabajadores','insertado'),(166,'2020-03-05 18:35:32','clientes','antes de actualizar'),(167,'2020-03-05 18:35:32','clientes','cliente actualizado'),(168,'2020-03-05 18:49:25','trabajadores','insertado'),(169,'2020-03-05 19:32:07','clientes','antes de insertar'),(170,'2020-03-05 19:32:07','clientes','cliente insertado'),(171,'2020-03-05 19:34:15','clientes','antes de actualizar'),(172,'2020-03-05 19:34:15','clientes','cliente actualizado'),(173,'2020-03-05 19:35:24','clientes','antes de eliminar'),(174,'2020-03-05 19:35:24','clientes','cliente eliminado'),(175,'2020-03-05 19:42:41','clientes','antes de eliminar'),(176,'2020-03-05 19:42:41','clientes','cliente eliminado'),(177,'2020-03-05 19:43:39','clientes','antes de insertar'),(178,'2020-03-05 19:43:39','clientes','cliente insertado'),(179,'2020-03-05 19:43:58','clientes','antes de eliminar'),(180,'2020-03-05 19:43:58','clientes','cliente eliminado'),(181,'2020-03-05 19:44:16','clientes','antes de insertar'),(182,'2020-03-05 19:44:16','clientes','cliente insertado'),(183,'2020-03-05 19:44:27','clientes','antes de eliminar'),(184,'2020-03-05 19:44:27','clientes','cliente eliminado'),(185,'2020-03-05 19:46:03','clientes','antes de actualizar'),(186,'2020-03-05 19:46:03','clientes','cliente actualizado'),(187,'2020-03-05 20:19:05','sesiones','modificada'),(188,'2020-03-07 11:45:49','trabajadores','insertado'),(189,'2020-03-07 12:13:08','trabajadores','insertado'),(190,'2020-03-07 12:13:15','trabajadores','actualizado'),(191,'2020-03-07 12:23:51','trabajadores','insertado'),(192,'2020-03-07 12:24:40','trabajadores','actualizado'),(193,'2020-03-07 12:29:56','trabajadores','actualizado'),(194,'2020-03-07 12:38:34','trabajadores','actualizado'),(195,'2020-03-07 12:42:08','trabajadores','actualizado'),(196,'2020-03-07 12:44:30','trabajadores','eliminado'),(197,'2020-03-07 12:57:50','clientes','antes de insertar'),(198,'2020-03-07 12:57:50','clientes','cliente insertado'),(199,'2020-03-07 13:12:04','sesiones','insertada'),(200,'2020-03-07 13:12:22','sesiones','insertada'),(201,'2020-03-08 16:32:26','trabajadores','insertado'),(202,'2020-03-08 16:32:34','trabajadores','actualizado'),(203,'2020-03-08 16:32:40','trabajadores','eliminado'),(204,'2020-03-08 16:33:11','clientes','antes de insertar'),(205,'2020-03-08 16:33:11','clientes','cliente insertado'),(206,'2020-03-08 16:33:17','clientes','antes de actualizar'),(207,'2020-03-08 16:33:17','clientes','cliente actualizado'),(208,'2020-03-08 16:33:21','clientes','antes de eliminar'),(209,'2020-03-08 16:33:21','clientes','cliente eliminado'),(210,'2020-03-08 16:33:35','servicios','insertado'),(211,'2020-03-08 16:33:42','servicios','actualizado'),(212,'2020-03-08 16:33:47','servicios','eliminado'),(213,'2020-03-08 16:33:50','servicios','eliminado'),(214,'2020-03-08 16:34:12','sesiones','insertada'),(215,'2020-03-08 16:34:20','sesiones','actualizada'),(216,'2020-03-08 16:34:36','sesiones','modificada'),(217,'2020-03-08 16:58:28','trabajadores','insertado'),(218,'2020-03-08 16:58:43','trabajadores','actualizado'),(219,'2020-03-08 16:58:52','trabajadores','eliminado'),(220,'2020-03-08 16:59:05','clientes','antes de insertar'),(221,'2020-03-08 16:59:05','clientes','cliente insertado'),(222,'2020-03-08 16:59:09','clientes','antes de eliminar'),(223,'2020-03-08 16:59:09','clientes','cliente eliminado'),(224,'2020-03-08 16:59:43','servicios','insertado'),(225,'2020-03-08 16:59:46','servicios','actualizado'),(226,'2020-03-08 16:59:49','servicios','eliminado'),(227,'2020-03-08 17:00:10','sesiones','insertada'),(228,'2020-03-08 17:00:22','sesiones','actualizada'),(229,'2020-03-08 17:00:33','sesiones','actualizada'),(230,'2020-03-08 17:04:16','sesiones','actualizada'),(231,'2020-03-08 17:04:31','sesiones','insertada'),(232,'2020-03-08 17:10:15','sesiones','insertada'),(233,'2020-03-08 17:11:05','sesiones','actualizada'),(234,'2020-03-08 17:11:09','sesiones','modificada'),(235,'2020-03-08 17:11:12','sesiones','modificada'),(236,'2020-03-08 17:29:39','sesiones','insertada'),(237,'2020-03-08 17:39:54','sesiones','insertada'),(238,'2020-03-08 17:40:22','clientes','antes de insertar'),(239,'2020-03-08 17:40:22','clientes','cliente insertado'),(241,'2020-03-08 17:41:20','trabajadores','insertado'),(242,'2020-03-08 17:41:32','clientes','antes de insertar'),(243,'2020-03-08 17:41:32','clientes','cliente insertado'),(245,'2020-03-08 17:48:04','sesiones','actualizada'),(246,'2020-03-08 17:48:27','sesiones','actualizada'),(247,'2020-03-08 17:49:05','sesiones','actualizada'),(248,'2020-03-08 17:49:08','sesiones','actualizada'),(249,'2020-03-08 17:49:15','sesiones','actualizada'),(251,'2020-03-08 18:40:21','trabajadores','insertado'),(252,'2020-03-08 18:42:17','trabajadores','actualizado'),(253,'2020-03-08 18:48:14','trabajadores','eliminado'),(254,'2020-03-08 19:06:15','trabajadores','insertado'),(255,'2020-03-08 19:23:59','clientes','antes de insertar'),(256,'2020-03-08 19:23:59','clientes','cliente insertado'),(257,'2020-03-08 19:24:30','clientes','antes de insertar'),(258,'2020-03-08 19:24:30','clientes','cliente insertado'),(259,'2020-03-08 19:25:07','clientes','antes de insertar'),(260,'2020-03-08 19:25:07','clientes','cliente insertado'),(261,'2020-03-08 19:25:38','clientes','antes de actualizar'),(262,'2020-03-08 19:25:38','clientes','cliente actualizado'),(263,'2020-03-08 19:25:53','clientes','antes de insertar'),(264,'2020-03-08 19:25:53','clientes','cliente insertado'),(265,'2020-03-08 19:27:00','clientes','antes de actualizar'),(266,'2020-03-08 19:27:00','clientes','cliente actualizado'),(267,'2020-03-08 19:31:24','servicios','insertado'),(268,'2020-03-08 20:08:56','trabajadores','actualizado'),(269,'2020-03-08 20:09:01','trabajadores','actualizado'),(270,'2020-03-08 20:09:08','trabajadores','actualizado'),(271,'2020-03-08 20:30:28','trabajadores','actualizado'),(272,'2020-03-08 21:00:09','trabajadores','insertado'),(273,'2020-03-09 20:07:15','clientes','antes de insertar'),(274,'2020-03-09 20:07:15','clientes','cliente insertado'),(275,'2020-03-09 20:11:13','clientes','antes de insertar'),(276,'2020-03-09 20:11:13','clientes','cliente insertado'),(277,'2020-03-09 20:29:43','clientes','antes de insertar'),(278,'2020-03-09 20:29:43','clientes','cliente insertado'),(279,'2020-03-09 20:32:54','clientes','antes de insertar'),(280,'2020-03-09 20:32:54','clientes','cliente insertado'),(281,'2020-03-09 20:37:17','trabajadores','insertado'),(282,'2020-03-09 20:43:29','trabajadores','insertado'),(283,'2020-03-09 21:18:57','sesiones','insertada'),(284,'2020-03-09 21:31:41','sesiones','insertada'),(285,'2020-03-09 23:55:18','sesiones','insertada'),(286,'2020-03-09 23:55:44','sesiones','actualizada'),(287,'2020-03-09 23:56:40','sesiones','actualizada'),(288,'2020-03-09 23:58:24','clientes','antes de actualizar'),(289,'2020-03-09 23:58:24','clientes','cliente actualizado'),(290,'2020-03-09 23:59:45','clientes','antes de actualizar'),(291,'2020-03-09 23:59:45','clientes','cliente actualizado'),(292,'2020-03-10 00:00:52','clientes','antes de actualizar'),(293,'2020-03-10 00:00:52','clientes','cliente actualizado'),(294,'2020-03-10 00:05:24','trabajadores','actualizado'),(295,'2020-03-10 00:20:35','trabajadores','actualizado'),(296,'2020-03-10 00:20:39','trabajadores','actualizado'),(297,'2020-03-10 00:25:00','sesiones','actualizada'),(298,'2020-03-10 00:25:25','sesiones','actualizada'),(299,'2020-03-10 00:25:32','sesiones','actualizada'),(300,'2020-03-10 00:25:42','sesiones','actualizada'),(301,'2020-03-10 00:30:04','sesiones','actualizada'),(302,'2020-03-10 00:30:14','sesiones','actualizada'),(303,'2020-03-10 00:30:28','sesiones','actualizada'),(304,'2020-03-10 00:30:43','sesiones','actualizada'),(305,'2020-03-10 00:31:06','sesiones','actualizada'),(306,'2020-03-10 00:31:24','sesiones','actualizada'),(307,'2020-03-10 00:32:39','sesiones','actualizada'),(308,'2020-03-10 00:32:48','sesiones','actualizada'),(309,'2020-03-10 00:33:16','sesiones','actualizada'),(310,'2020-03-10 17:29:32','clientes','antes de insertar'),(311,'2020-03-10 17:29:32','clientes','cliente insertado'),(314,'2020-03-10 17:32:30','clientes','antes de insertar'),(315,'2020-03-10 17:32:30','clientes','cliente insertado'),(317,'2020-03-10 17:33:54','clientes','antes de insertar'),(318,'2020-03-10 17:33:54','clientes','cliente insertado'),(320,'2020-03-10 17:36:05','clientes','antes de insertar'),(321,'2020-03-10 17:36:05','clientes','cliente insertado'),(322,'2020-03-10 17:42:46','trabajadores','insertado'),(323,'2020-03-10 17:47:58','clientes','antes de insertar'),(324,'2020-03-10 17:47:58','clientes','cliente insertado'),(325,'2020-03-10 17:48:04','clientes','antes de insertar'),(326,'2020-03-10 17:48:04','clientes','cliente insertado'),(328,'2020-03-10 17:49:12','clientes','antes de insertar'),(329,'2020-03-10 17:49:12','clientes','cliente insertado'),(330,'2020-03-10 18:48:17','clientes','antes de insertar'),(331,'2020-03-10 18:48:17','clientes','cliente insertado'),(333,'2020-03-10 18:50:44','clientes','antes de insertar'),(334,'2020-03-10 18:50:44','clientes','cliente insertado'),(335,'2020-03-10 19:04:09','trabajadores','insertado'),(336,'2020-03-10 19:10:22','trabajadores','eliminado'),(337,'2020-03-10 19:11:36','trabajadores','actualizado'),(338,'2020-03-10 19:11:42','trabajadores','actualizado'),(339,'2020-03-10 19:12:03','trabajadores','actualizado'),(340,'2020-03-10 19:12:30','trabajadores','actualizado'),(341,'2020-03-10 19:23:43','trabajadores','insertado'),(342,'2020-03-10 19:41:49','trabajadores','insertado'),(343,'2020-03-10 19:49:00','trabajadores','insertado'),(344,'2020-03-10 20:02:27','trabajadores','insertado'),(345,'2020-03-10 20:25:03','trabajadores','actualizado'),(346,'2020-03-10 20:28:13','trabajadores','eliminado'),(347,'2020-03-10 20:29:56','trabajadores','eliminado'),(348,'2020-03-10 20:30:39','trabajadores','eliminado'),(349,'2020-03-10 20:40:20','trabajadores','insertado'),(350,'2020-03-10 20:40:42','trabajadores','insertado'),(351,'2020-03-10 20:41:34','trabajadores','actualizado'),(352,'2020-03-10 20:42:06','trabajadores','eliminado'),(353,'2020-03-10 20:42:10','trabajadores','eliminado'),(354,'2020-03-10 21:06:21','clientes','antes de insertar'),(355,'2020-03-10 21:06:21','clientes','cliente insertado'),(356,'2020-03-10 21:12:16','clientes','antes de actualizar'),(357,'2020-03-10 21:12:16','clientes','cliente actualizado'),(358,'2020-03-10 21:23:32','clientes','antes de insertar'),(359,'2020-03-10 21:23:32','clientes','cliente insertado'),(360,'2020-03-10 21:32:59','clientes','antes de insertar'),(361,'2020-03-10 21:32:59','clientes','cliente insertado'),(362,'2020-03-10 21:37:09','clientes','antes de insertar'),(363,'2020-03-10 21:37:09','clientes','cliente insertado'),(364,'2020-03-10 21:38:04','clientes','antes de insertar'),(365,'2020-03-10 21:38:04','clientes','cliente insertado'),(366,'2020-03-10 21:38:24','clientes','antes de insertar'),(367,'2020-03-10 21:38:24','clientes','cliente insertado'),(368,'2020-03-10 21:39:15','clientes','antes de insertar'),(369,'2020-03-10 21:39:15','clientes','cliente insertado'),(371,'2020-03-10 21:40:17','clientes','antes de insertar'),(372,'2020-03-10 21:40:17','clientes','cliente insertado'),(373,'2020-03-10 21:40:32','clientes','antes de insertar'),(374,'2020-03-10 21:40:32','clientes','cliente insertado'),(375,'2020-03-10 21:55:44','clientes','antes de eliminar'),(376,'2020-03-10 21:55:44','clientes','cliente eliminado'),(377,'2020-03-10 22:16:03','servicios','insertado'),(378,'2020-03-10 22:24:19','servicios','insertado'),(379,'2020-03-10 22:26:25','servicios','eliminado'),(380,'2020-03-10 22:47:32','sesiones','insertada'),(381,'2020-03-10 22:47:56','sesiones','insertada'),(382,'2020-03-10 22:49:16','sesiones','actualizada'),(383,'2020-03-10 23:05:00','sesiones','insertada'),(384,'2020-03-10 23:06:56','sesiones','actualizada'),(385,'2020-03-10 23:07:16','sesiones','actualizada'),(386,'2020-03-10 23:07:35','sesiones','actualizada'),(387,'2020-03-10 23:07:37','sesiones','actualizada'),(388,'2020-03-10 23:08:08','sesiones','modificada'),(389,'2020-03-11 00:57:10','clientes','antes de eliminar'),(390,'2020-03-11 00:57:10','clientes','cliente eliminado'),(391,'2020-03-11 00:57:53','clientes','antes de insertar'),(392,'2020-03-11 00:57:53','clientes','cliente insertado'),(393,'2020-03-11 00:58:15','clientes','antes de insertar'),(394,'2020-03-11 00:58:15','clientes','cliente insertado'),(395,'2020-03-11 01:13:47','sesiones','insertada'),(396,'2020-03-11 01:16:03','sesiones','insertada'),(397,'2020-03-11 01:30:48','sesiones','insertada'),(398,'2020-03-11 01:34:24','sesiones','actualizada'),(399,'2020-03-11 01:35:01','sesiones','actualizada'),(400,'2020-03-11 01:36:24','sesiones','insertada'),(401,'2020-03-11 01:37:07','sesiones','modificada'),(402,'2020-03-11 17:08:43','clientes','antes de insertar'),(403,'2020-03-11 17:08:43','clientes','cliente insertado'),(407,'2020-03-11 19:34:33','clientes','antes de insertar'),(408,'2020-03-11 19:34:33','clientes','cliente insertado'),(409,'2020-03-11 19:42:58','clientes','antes de insertar'),(410,'2020-03-11 19:42:58','clientes','cliente insertado'),(412,'2020-03-11 19:46:40','clientes','antes de insertar'),(413,'2020-03-11 19:46:40','clientes','cliente insertado'),(414,'2020-03-11 19:50:55','sesiones','modificada'),(415,'2020-03-11 19:50:55','sesiones','modificada'),(416,'2020-03-11 19:50:55','sesiones','modificada'),(417,'2020-03-11 19:50:55','sesiones','modificada'),(418,'2020-03-11 19:50:55','sesiones','modificada'),(419,'2020-03-11 19:50:55','sesiones','modificada'),(420,'2020-03-11 19:50:55','sesiones','modificada'),(421,'2020-03-11 19:50:55','sesiones','modificada'),(422,'2020-03-11 19:50:55','sesiones','modificada'),(423,'2020-03-11 19:50:55','sesiones','modificada'),(424,'2020-03-11 19:50:55','sesiones','modificada'),(425,'2020-03-11 19:50:55','sesiones','modificada'),(426,'2020-03-11 19:50:55','sesiones','modificada'),(427,'2020-03-11 19:50:55','sesiones','modificada'),(428,'2020-03-11 19:50:55','sesiones','modificada'),(429,'2020-03-11 19:50:55','sesiones','modificada'),(430,'2020-03-11 19:50:55','sesiones','modificada'),(431,'2020-03-11 19:50:55','sesiones','modificada'),(432,'2020-03-11 19:50:55','sesiones','modificada'),(433,'2020-03-11 19:50:55','sesiones','modificada'),(434,'2020-03-11 19:51:13','clientes','antes de actualizar'),(435,'2020-03-11 19:51:13','clientes','cliente actualizado'),(436,'2020-03-11 19:51:26','clientes','antes de eliminar'),(437,'2020-03-11 19:51:26','clientes','cliente eliminado'),(438,'2020-03-11 19:51:26','clientes','antes de eliminar'),(439,'2020-03-11 19:51:26','clientes','cliente eliminado'),(440,'2020-03-11 19:51:26','clientes','antes de eliminar'),(441,'2020-03-11 19:51:26','clientes','cliente eliminado'),(442,'2020-03-11 19:51:26','clientes','antes de eliminar'),(443,'2020-03-11 19:51:26','clientes','cliente eliminado'),(444,'2020-03-11 19:51:26','clientes','antes de eliminar'),(445,'2020-03-11 19:51:26','clientes','cliente eliminado'),(446,'2020-03-11 19:51:26','clientes','antes de eliminar'),(447,'2020-03-11 19:51:26','clientes','cliente eliminado'),(448,'2020-03-11 19:51:26','clientes','antes de eliminar'),(449,'2020-03-11 19:51:26','clientes','cliente eliminado'),(450,'2020-03-11 19:51:26','clientes','antes de eliminar'),(451,'2020-03-11 19:51:26','clientes','cliente eliminado'),(452,'2020-03-11 19:51:26','clientes','antes de eliminar'),(453,'2020-03-11 19:51:26','clientes','cliente eliminado'),(454,'2020-03-11 19:51:26','clientes','antes de eliminar'),(455,'2020-03-11 19:51:26','clientes','cliente eliminado'),(456,'2020-03-11 19:51:26','clientes','antes de eliminar'),(457,'2020-03-11 19:51:26','clientes','cliente eliminado'),(458,'2020-03-11 19:51:26','clientes','antes de eliminar'),(459,'2020-03-11 19:51:26','clientes','cliente eliminado'),(460,'2020-03-11 19:51:26','clientes','antes de eliminar'),(461,'2020-03-11 19:51:26','clientes','cliente eliminado'),(462,'2020-03-11 19:51:26','clientes','antes de eliminar'),(463,'2020-03-11 19:51:26','clientes','cliente eliminado'),(464,'2020-03-11 19:51:26','clientes','antes de eliminar'),(465,'2020-03-11 19:51:26','clientes','cliente eliminado'),(466,'2020-03-11 19:51:26','clientes','antes de eliminar'),(467,'2020-03-11 19:51:26','clientes','cliente eliminado'),(468,'2020-03-11 19:51:26','clientes','antes de eliminar'),(469,'2020-03-11 19:51:26','clientes','cliente eliminado'),(470,'2020-03-11 19:51:26','clientes','antes de eliminar'),(471,'2020-03-11 19:51:26','clientes','cliente eliminado'),(472,'2020-03-11 19:51:26','clientes','antes de eliminar'),(473,'2020-03-11 19:51:26','clientes','cliente eliminado'),(474,'2020-03-11 19:51:26','clientes','antes de eliminar'),(475,'2020-03-11 19:51:26','clientes','cliente eliminado'),(476,'2020-03-11 19:51:26','clientes','antes de eliminar'),(477,'2020-03-11 19:51:26','clientes','cliente eliminado'),(478,'2020-03-11 19:51:26','clientes','antes de eliminar'),(479,'2020-03-11 19:51:26','clientes','cliente eliminado'),(480,'2020-03-11 19:51:26','clientes','antes de eliminar'),(481,'2020-03-11 19:51:26','clientes','cliente eliminado'),(482,'2020-03-11 19:51:26','clientes','antes de eliminar'),(483,'2020-03-11 19:51:26','clientes','cliente eliminado'),(484,'2020-03-11 19:51:26','clientes','antes de eliminar'),(485,'2020-03-11 19:51:26','clientes','cliente eliminado'),(486,'2020-03-11 19:51:26','clientes','antes de eliminar'),(487,'2020-03-11 19:51:26','clientes','cliente eliminado'),(488,'2020-03-11 19:51:26','clientes','antes de eliminar'),(489,'2020-03-11 19:51:26','clientes','cliente eliminado'),(490,'2020-03-11 19:51:26','clientes','antes de eliminar'),(491,'2020-03-11 19:51:26','clientes','cliente eliminado'),(492,'2020-03-11 19:51:26','clientes','antes de eliminar'),(493,'2020-03-11 19:51:26','clientes','cliente eliminado'),(494,'2020-03-11 19:51:26','clientes','antes de eliminar'),(495,'2020-03-11 19:51:26','clientes','cliente eliminado'),(496,'2020-03-11 19:51:26','clientes','antes de eliminar'),(497,'2020-03-11 19:51:26','clientes','cliente eliminado'),(498,'2020-03-11 19:51:26','clientes','antes de eliminar'),(499,'2020-03-11 19:51:26','clientes','cliente eliminado'),(500,'2020-03-11 19:51:26','clientes','antes de eliminar'),(501,'2020-03-11 19:51:26','clientes','cliente eliminado'),(502,'2020-03-11 19:51:36','servicios','eliminado'),(503,'2020-03-11 19:51:37','servicios','eliminado'),(504,'2020-03-11 19:51:54','trabajadores','eliminado'),(505,'2020-03-11 19:51:54','trabajadores','eliminado'),(506,'2020-03-11 19:51:54','trabajadores','eliminado'),(507,'2020-03-11 19:51:54','trabajadores','eliminado'),(508,'2020-03-11 19:51:54','trabajadores','eliminado'),(509,'2020-03-11 19:51:54','trabajadores','eliminado'),(510,'2020-03-11 19:51:54','trabajadores','eliminado'),(511,'2020-03-11 19:51:54','trabajadores','eliminado'),(512,'2020-03-11 19:51:54','trabajadores','eliminado'),(513,'2020-03-11 19:51:54','trabajadores','eliminado'),(514,'2020-03-11 19:51:54','trabajadores','eliminado'),(515,'2020-03-11 19:51:54','trabajadores','eliminado'),(516,'2020-03-11 19:51:54','trabajadores','eliminado'),(517,'2020-03-11 19:51:54','trabajadores','eliminado'),(518,'2020-03-11 19:51:54','trabajadores','eliminado');
/*!40000 ALTER TABLE `historial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicios`
--

DROP TABLE IF EXISTS `servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicios` (
  `idservicios` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `precio` decimal(6,3) NOT NULL,
  PRIMARY KEY (`idservicios`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicios`
--

LOCK TABLES `servicios` WRITE;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;
INSERT INTO `servicios` VALUES (1,'Masaje a cuatro manos',65.255),(4,'Masaje exfoliante bambú',55.125),(5,'Masaje antiestress',60.552),(6,'Masaje de manos',12.595),(11,'Masaje descontracturante',38.598),(13,'Masaje tailandes',80.595);
/*!40000 ALTER TABLE `servicios` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `servicios_AFTER_INSERT` AFTER INSERT ON `servicios` FOR EACH ROW BEGIN
	INSERT INTO historial (tabla, accion) VALUES('servicios', 'insertado');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `servicios_AFTER_UPDATE` AFTER UPDATE ON `servicios` FOR EACH ROW BEGIN
	INSERT INTO historial (tabla, accion) VALUES('servicios', 'actualizado');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `servicios_AFTER_DELETE` AFTER DELETE ON `servicios` FOR EACH ROW BEGIN
	INSERT INTO historial (tabla, accion) VALUES('servicios', 'eliminado');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `sesiones`
--

DROP TABLE IF EXISTS `sesiones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sesiones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `clientes_idclientes` int NOT NULL,
  `trabajadores_idtrabajadores` int NOT NULL,
  `servicios_idservicios` int NOT NULL,
  `fecha` datetime NOT NULL,
  `resena` text CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci,
  `calificacion` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `actuacion_UNIQUE` (`clientes_idclientes`,`trabajadores_idtrabajadores`,`servicios_idservicios`,`fecha`),
  KEY `fk_actuaciones_clientes_idx` (`clientes_idclientes`),
  KEY `fk_actuaciones_trabajadores1_idx` (`trabajadores_idtrabajadores`),
  KEY `fk_actuaciones_servicios1_idx` (`servicios_idservicios`),
  CONSTRAINT `fk_actuaciones_clientes` FOREIGN KEY (`clientes_idclientes`) REFERENCES `clientes` (`idclientes`),
  CONSTRAINT `fk_actuaciones_servicios1` FOREIGN KEY (`servicios_idservicios`) REFERENCES `servicios` (`idservicios`),
  CONSTRAINT `fk_actuaciones_trabajadores1` FOREIGN KEY (`trabajadores_idtrabajadores`) REFERENCES `trabajadores` (`idtrabajadores`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sesiones`
--

LOCK TABLES `sesiones` WRITE;
/*!40000 ALTER TABLE `sesiones` DISABLE KEYS */;
INSERT INTO `sesiones` VALUES (1,2,9,4,'2020-11-09 16:20:00','Normalll, ni bien ni mal','Aceptable'),(2,12,2,5,'2020-01-28 15:00:00','',''),(3,6,7,4,'2005-05-04 15:25:00','Muy bien','Para repetir'),(4,6,4,5,'2020-02-11 22:22:00','',''),(5,1,4,1,'2020-02-22 11:01:00','No fue muy agradable','No recomendable'),(6,2,1,1,'1200-02-22 22:22:00','En ocasiones me hacían daño en la espalda','No recomendable'),(7,2,2,4,'2012-02-11 12:31:00','asasdasd','No recomendable'),(9,39,8,1,'2018-05-01 21:00:00','Fue todo genial, es la tercera vez que voy.','Aceptable');
/*!40000 ALTER TABLE `sesiones` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `sesiones_AFTER_INSERT` AFTER INSERT ON `sesiones` FOR EACH ROW BEGIN
	INSERT INTO historial (tabla, accion) VALUES('sesiones', 'insertada');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `sesiones_AFTER_UPDATE` AFTER UPDATE ON `sesiones` FOR EACH ROW BEGIN
	INSERT INTO historial (tabla, accion) VALUES('sesiones', 'actualizada');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `sesiones_AFTER_DELETE` AFTER DELETE ON `sesiones` FOR EACH ROW BEGIN
	INSERT INTO historial (tabla, accion) VALUES('sesiones', 'modificada');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Temporary view structure for view `sesionesporfecha`
--

DROP TABLE IF EXISTS `sesionesporfecha`;
/*!50001 DROP VIEW IF EXISTS `sesionesporfecha`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `sesionesporfecha` AS SELECT 
 1 AS `cliente`,
 1 AS `trabajador`,
 1 AS `servicio`,
 1 AS `fecha`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `trabajadores`
--

DROP TABLE IF EXISTS `trabajadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trabajadores` (
  `idtrabajadores` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `apellidos` varchar(90) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `dni` char(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`idtrabajadores`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajadores`
--

LOCK TABLES `trabajadores` WRITE;
/*!40000 ALTER TABLE `trabajadores` DISABLE KEYS */;
INSERT INTO `trabajadores` VALUES (1,'Jose Angel','Garcia Pelaeza','71859635P'),(2,'Alberto','Romero Relai','78521252O'),(4,'Leticia','Sancho Villa','71285369G'),(7,'Teodoro','Fernandez','78545215B'),(8,'Rocío ','Alvarez de la Serna','72234567I'),(9,'Paquito ','Lopez Diez','76532612B'),(10,'Mario','Diez casas','74478548J'),(11,'Leopoldo','Alas Clarin','75125484K'),(12,'Mario','Diez casas','74478548G');
/*!40000 ALTER TABLE `trabajadores` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trabajadores_AFTER_INSERT` AFTER INSERT ON `trabajadores` FOR EACH ROW BEGIN
	INSERT INTO historial (tabla, accion) VALUES('trabajadores', 'insertado');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trabajadores_AFTER_UPDATE` AFTER UPDATE ON `trabajadores` FOR EACH ROW BEGIN
	INSERT INTO historial (tabla, accion) VALUES('trabajadores', 'actualizado');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trabajadores_AFTER_DELETE` AFTER DELETE ON `trabajadores` FOR EACH ROW BEGIN
	INSERT INTO historial (tabla, accion) VALUES('trabajadores', 'eliminado');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idusuarios` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `password` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `rol` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`idusuarios`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'jose@jose.com','123456','administrador'),(2,'alberto@alberto.com','123456','user');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'masajesjax-rs'
--

--
-- Dumping routines for database 'masajesjax-rs'
--
/*!50003 DROP FUNCTION IF EXISTS `nombre_completo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `nombre_completo`(nombre VARCHAR(45), apellidos VARCHAR(90)) RETURNS varchar(150) CHARSET utf8mb4 COLLATE utf8mb4_spanish2_ci
    DETERMINISTIC
BEGIN
	RETURN CONCAT(nombre, ' ', apellidos);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `clientesDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `clientesDelete`(IN _id INT)
BEGIN
DELETE FROM clientes WHERE idclientes=_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `clientesGetAll` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `clientesGetAll`()
BEGIN
	SELECT * FROM clientes;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `clientesGetById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `clientesGetById`(IN _id INT)
BEGIN
	SELECT * FROM clientes WHERE idclientes=_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `clientesInsert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `clientesInsert`(IN _nombre VARCHAR(45), IN _apellidos VARCHAR(90), IN _dni CHAR(9), OUT _id INT)
BEGIN
	INSERT INTO clientes (nombre, apellidos, dni) VALUES (_nombre, _apellidos, _dni);
	SET _id = LAST_INSERT_ID();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `clientesUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `clientesUpdate`(IN _id INT,IN _nombre VARCHAR(45), IN _apellidos VARCHAR(90), IN _dni CHAR(9))
BEGIN
	UPDATE clientes SET nombre=_nombre, apellidos=_apellidos, dni=_dni WHERE idclientes=_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `serciciosGetByID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `serciciosGetByID`(IN _id INT)
BEGIN
	SELECT * FROM servicios WHERE idservicios=_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `serviciosDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `serviciosDelete`(IN _id INT)
BEGIN
DELETE FROM servicios WHERE idservicios=_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `serviciosGetALL` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `serviciosGetALL`()
BEGIN
	SELECT * FROM servicios;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `serviciosInsert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `serviciosInsert`(IN _nombre VARCHAR(45), IN _precio DECIMAL, OUT _id INT)
BEGIN
	INSERT INTO servicios (nombre, precio) VALUES (_nombre, _precio);
    SET _id=LAST_INSERT_ID();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `serviciosUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `serviciosUpdate`(IN _id INT,IN _nombre VARCHAR(45), IN _precio DECIMAL)
BEGIN
	UPDATE servicios SET nombre=_nombre, precio=_precio WHERE idservicios=_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sesionesDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sesionesDelete`(IN _id INT)
BEGIN
	DELETE FROM sesiones WHERE id=_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sesionesGetAll` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sesionesGetAll`()
BEGIN
	SELECT * FROM sesiones;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sesionesGetById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sesionesGetById`(IN _id INT)
BEGIN
	SELECT * FROM sesiones WHERE id=_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sesionesInsert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sesionesInsert`(IN _idclientes INT, IN _idtrabajadores INT, IN _idservicios INT, IN _fecha DATE, IN _resena TEXT, IN _calificacion VARCHAR(15), OUT _id INT)
BEGIN
	INSERT INTO sesiones (clientes_idclientes, trabajadores_idtrabajadores, servicios_idservicios, fecha, resena, calificacion) VALUES (_idclientes, _idtrabajadores, _idservicios, _fecha, _resena, _calificacion);
	SET _id = LAST_INSERT_ID();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sesionesUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sesionesUpdate`(IN _id INT, IN _idclientes INT, IN _idtrabajadores INT, IN _idservicios INT, IN _fecha DATE, IN _resena TEXT, IN _calificacion VARCHAR(15))
BEGIN
	UPDATE sesiones SET clientes_idclientes=_idclientes, trabajadores_idtrabajadores=_idtrabajadores, servicios_idservicios=_idservicios, fecha=_fecha, resena=_resena, calificacion=_calificacion WHERE id=_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `trabajadoresDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `trabajadoresDelete`(IN _id INT)
BEGIN
DELETE FROM trabajadores WHERE idtrabajadores=_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `trabajadoresGetAll` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `trabajadoresGetAll`()
BEGIN
	SELECT * FROM trabajadores;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `trabajadoresGetByID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `trabajadoresGetByID`(IN _id INT)
BEGIN
	SELECT * FROM trabajadores WHERE idtrabajadores=_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `trabajadoresInsert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `trabajadoresInsert`(IN _nombre VARCHAR(45), IN _apellidos VARCHAR(90), IN _dni CHAR(9), OUT _id INT)
BEGIN
	INSERT INTO trabajadores (nombre, apellidos, dni) VALUES (_nombre, _apellidos, _dni);
	SET _id = LAST_INSERT_ID();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `trabajadoresUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `trabajadoresUpdate`(IN _id INT,IN _nombre VARCHAR(45), IN _apellidos VARCHAR(90), IN _dni CHAR(9))
BEGIN
	UPDATE trabajadores SET nombre=_nombre, apellidos=_apellidos, dni=_dni WHERE idtrabajadores=_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `clientesgetall`
--

/*!50001 DROP VIEW IF EXISTS `clientesgetall`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `clientesgetall` AS select `clientes`.`idclientes` AS `idclientes`,`clientes`.`nombre` AS `nombre`,`clientes`.`apellidos` AS `apellidos`,`clientes`.`dni` AS `dni` from `clientes` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `sesionesporfecha`
--

/*!50001 DROP VIEW IF EXISTS `sesionesporfecha`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `sesionesporfecha` AS select `c`.`nombre` AS `cliente`,`t`.`nombre` AS `trabajador`,`s`.`nombre` AS `servicio`,`ses`.`fecha` AS `fecha` from (((`clientes` `c` join `sesiones` `ses` on((`c`.`idclientes` = `ses`.`clientes_idclientes`))) join `trabajadores` `t` on((`t`.`idtrabajadores` = `ses`.`trabajadores_idtrabajadores`))) join `servicios` `s` on((`s`.`idservicios` = `ses`.`servicios_idservicios`))) order by `ses`.`fecha` */;
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

-- Dump completed on 2020-03-11 19:53:45
