CREATE DATABASE  IF NOT EXISTS `masajes` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci */;
USE `masajes`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: masajes
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `clientes` (
  `idclientes` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `apellidos` varchar(90) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `dni` char(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`idclientes`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Lorenza','Martinez Pernia','75123695W'),(2,'Vanesa','Romero Cuesta','74112588Y'),(6,'Rodolfo','Chiquilicuatre','78785421G'),(7,'Miguelito','Minguez Mengual','78785421N'),(8,'Minguito','Lorenzo Grijalba','72514585V'),(9,'Lara','Alvarez Serna','75856555K'),(11,'Pepe Luis','Gonzalez Ruiz','71252222A'),(12,'Ramon','Pelaez','78888888F'),(13,'María','Pascual Del Amo','11212121S'),(39,'Javier','Ortega Perez','75421585A'),(41,'Marisa','Aguilar Garcia','78968855U'),(43,'Maria','Ortega Saez','77885544K'),(45,'Elena','Doncel Ortega','75632158J');
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
-- Temporary view structure for view `clientes_vip_y_servicios`
--

DROP TABLE IF EXISTS `clientes_vip_y_servicios`;
/*!50001 DROP VIEW IF EXISTS `clientes_vip_y_servicios`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `clientes_vip_y_servicios` AS SELECT 
 1 AS `idcliente`,
 1 AS `cnombre`,
 1 AS `capellidos`,
 1 AS `idservicio`,
 1 AS `snombre`,
 1 AS `sprecio`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `clientes_vip_y_serviciosdni`
--

DROP TABLE IF EXISTS `clientes_vip_y_serviciosdni`;
/*!50001 DROP VIEW IF EXISTS `clientes_vip_y_serviciosdni`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `clientes_vip_y_serviciosdni` AS SELECT 
 1 AS `idcliente`,
 1 AS `cnombre`,
 1 AS `capellidos`,
 1 AS `idservicio`,
 1 AS `snombre`,
 1 AS `sprecio`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `clientesgetall`
--

DROP TABLE IF EXISTS `clientesgetall`;
/*!50001 DROP VIEW IF EXISTS `clientesgetall`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `historial` (
  `idhistorial` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tabla` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `accion` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`idhistorial`)
) ENGINE=InnoDB AUTO_INCREMENT=390 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial`
--

LOCK TABLES `historial` WRITE;
/*!40000 ALTER TABLE `historial` DISABLE KEYS */;
INSERT INTO `historial` VALUES (1,'2020-02-25 21:01:05','servicios','insertado'),(2,'2020-02-25 21:01:23','trabajadores','insertado'),(3,'2020-02-25 21:01:57','clientes','antes de insertar'),(4,'2020-02-25 21:01:57','clientes','insertado'),(5,'2020-02-25 21:28:47','servicios','actualizado'),(6,'2020-02-25 21:29:00','servicios','actualizado'),(7,'2020-02-25 21:30:03','clientes','antes de actualizar'),(8,'2020-02-25 21:30:03','clientes','actualizado'),(9,'2020-02-25 21:30:20','clientes','antes de insertar'),(10,'2020-02-25 21:30:20','clientes','insertado'),(11,'2020-02-25 21:30:24','clientes','antes de eliminar'),(12,'2020-02-25 21:30:24','clientes','eliminado'),(13,'2020-02-25 21:31:02','clientes','antes de actualizar'),(14,'2020-02-25 21:31:02','clientes','actualizado'),(15,'2020-02-25 21:31:10','clientes','antes de actualizar'),(16,'2020-02-25 21:31:10','clientes','actualizado'),(17,'2020-02-25 21:31:26','clientes','antes de actualizar'),(18,'2020-02-25 21:31:26','clientes','actualizado'),(19,'2020-02-25 21:31:48','clientes','antes de actualizar'),(20,'2020-02-25 21:31:48','clientes','actualizado'),(21,'2020-02-25 21:32:07','trabajadores','actualizado'),(22,'2020-02-25 21:32:43','trabajadores','actualizado'),(23,'2020-02-25 21:32:52','servicios','eliminado'),(24,'2020-02-26 00:03:12','clientes','antes de actualizar'),(25,'2020-02-26 00:03:12','clientes','actualizado'),(26,'2020-02-26 00:05:12','clientes','antes de insertar'),(27,'2020-02-26 00:05:12','clientes','insertado'),(28,'2020-02-26 00:05:22','clientes','antes de eliminar'),(29,'2020-02-26 00:05:22','clientes','eliminado'),(30,'2020-02-26 18:00:12','trabajadores','insertado'),(31,'2020-02-26 18:28:59','sesiones','insertada'),(32,'2020-02-26 23:49:28','servicios','insertado'),(33,'2020-02-27 19:49:02','sesiones','actualizada'),(34,'2020-02-27 19:49:26','sesiones','actualizada'),(35,'2020-02-27 19:49:51','sesiones','actualizada'),(36,'2020-02-27 19:50:04','sesiones','actualizada'),(37,'2020-02-27 19:50:42','sesiones','actualizada'),(38,'2020-02-27 19:51:12','sesiones','actualizada'),(39,'2020-02-27 19:51:34','sesiones','actualizada'),(40,'2020-02-27 19:51:59','sesiones','actualizada'),(41,'2020-02-27 19:52:07','sesiones','actualizada'),(42,'2020-02-27 19:52:24','sesiones','actualizada'),(43,'2020-02-27 19:52:57','sesiones','actualizada'),(55,'2020-02-27 20:02:37','clientes','antes de insertar'),(56,'2020-02-27 20:02:37','clientes','cliente insertado'),(57,'2020-02-27 20:02:37','clientes','antes de insertar'),(58,'2020-02-27 20:02:37','clientes','cliente insertado'),(59,'2020-02-27 20:02:37','clientes','antes de insertar'),(60,'2020-02-27 20:02:37','clientes','cliente insertado'),(61,'2020-02-27 20:02:37','clientes','antes de insertar'),(62,'2020-02-27 20:02:37','clientes','cliente insertado'),(63,'2020-02-27 20:02:37','clientes','antes de insertar'),(64,'2020-02-27 20:02:37','clientes','cliente insertado'),(65,'2020-02-27 20:02:37','clientes','antes de insertar'),(66,'2020-02-27 20:02:37','clientes','cliente insertado'),(67,'2020-02-27 20:03:05','sesiones','actualizada'),(68,'2020-02-27 20:03:23','clientes','antes de actualizar'),(69,'2020-02-27 20:03:23','clientes','cliente actualizado'),(70,'2020-02-27 20:03:28','clientes','antes de actualizar'),(71,'2020-02-27 20:03:28','clientes','cliente actualizado'),(72,'2020-02-27 20:04:37','clientes','antes de actualizar'),(73,'2020-02-27 20:04:37','clientes','cliente actualizado'),(74,'2020-02-27 20:13:44','servicios','eliminado'),(75,'2020-02-27 20:15:15','servicios','insertado'),(76,'2020-02-27 20:15:32','servicios','actualizado'),(77,'2020-02-27 20:16:13','servicios','eliminado'),(78,'2020-02-27 20:16:50','servicios','insertado'),(79,'2020-02-27 20:17:09','servicios','eliminado'),(80,'2020-02-28 13:02:33','clientes','antes de insertar'),(81,'2020-02-28 13:02:33','clientes','cliente insertado'),(82,'2020-02-28 13:03:30','clientes','antes de eliminar'),(83,'2020-02-28 13:03:30','clientes','cliente eliminado'),(84,'2020-02-28 13:38:51','clientes','antes de insertar'),(85,'2020-02-28 13:38:51','clientes','cliente insertado'),(86,'2020-02-28 13:40:35','clientes','antes de actualizar'),(87,'2020-02-28 13:40:35','clientes','cliente actualizado'),(88,'2020-02-28 13:48:28','trabajadores','insertado'),(89,'2020-02-28 13:51:12','trabajadores','actualizado'),(90,'2020-02-28 13:51:37','trabajadores','eliminado'),(91,'2020-02-28 13:52:21','trabajadores','insertado'),(92,'2020-02-28 13:52:33','trabajadores','eliminado'),(93,'2020-02-28 13:53:28','clientes','antes de insertar'),(94,'2020-02-28 13:53:28','clientes','cliente insertado'),(95,'2020-02-28 13:53:56','clientes','antes de eliminar'),(96,'2020-02-28 13:53:56','clientes','cliente eliminado'),(97,'2020-03-02 08:45:00','clientes','antes de insertar'),(98,'2020-03-02 08:45:00','clientes','cliente insertado'),(99,'2020-03-02 09:53:50','servicios','insertado'),(100,'2020-03-02 09:55:06','servicios','actualizado'),(101,'2020-03-02 09:56:23','servicios','actualizado'),(102,'2020-03-02 09:58:35','servicios','actualizado'),(103,'2020-03-02 10:01:25','servicios','eliminado'),(104,'2020-03-02 10:49:19','sesiones','actualizada'),(105,'2020-03-02 10:49:31','sesiones','insertada'),(106,'2020-03-02 10:51:24','sesiones','insertada'),(107,'2020-03-02 12:01:42','clientes','antes de actualizar'),(108,'2020-03-02 12:01:42','clientes','cliente actualizado'),(109,'2020-03-02 12:22:37','clientes','antes de actualizar'),(110,'2020-03-02 12:22:37','clientes','cliente actualizado'),(111,'2020-03-02 13:16:47','clientes','antes de insertar'),(112,'2020-03-02 13:16:47','clientes','cliente insertado'),(113,'2020-03-02 13:22:54','sesiones','insertada'),(114,'2020-03-02 13:33:57','sesiones','insertada'),(115,'2020-03-02 13:35:25','sesiones','insertada'),(116,'2020-03-02 13:44:30','sesiones','actualizada'),(117,'2020-03-02 13:44:42','sesiones','actualizada'),(118,'2020-03-02 13:54:01','sesiones','insertada'),(119,'2020-03-02 14:18:24','clientes','antes de insertar'),(120,'2020-03-02 14:18:24','clientes','cliente insertado'),(121,'2020-03-02 14:18:36','clientes','antes de actualizar'),(122,'2020-03-02 14:18:36','clientes','cliente actualizado'),(123,'2020-03-03 09:14:38','sesiones','insertada'),(124,'2020-03-03 09:15:33','sesiones','insertada'),(125,'2020-03-03 09:29:15','sesiones','insertada'),(126,'2020-03-03 09:29:35','clientes','antes de eliminar'),(127,'2020-03-03 09:29:35','clientes','cliente eliminado'),(128,'2020-03-03 09:32:33','clientes','antes de insertar'),(129,'2020-03-03 09:32:33','clientes','cliente insertado'),(130,'2020-03-03 09:36:38','clientes','antes de insertar'),(131,'2020-03-03 09:36:38','clientes','cliente insertado'),(132,'2020-03-03 09:36:59','clientes','antes de insertar'),(133,'2020-03-03 09:36:59','clientes','cliente insertado'),(134,'2020-03-03 09:46:08','sesiones','insertada'),(135,'2020-03-03 09:47:13','sesiones','modificada'),(136,'2020-03-03 09:47:36','sesiones','modificada'),(137,'2020-03-03 09:47:42','sesiones','modificada'),(138,'2020-03-03 09:47:47','sesiones','modificada'),(139,'2020-03-03 09:52:29','clientes','antes de insertar'),(140,'2020-03-03 09:52:29','clientes','cliente insertado'),(141,'2020-03-03 09:52:56','clientes','antes de insertar'),(142,'2020-03-03 09:52:56','clientes','cliente insertado'),(143,'2020-03-03 09:53:11','clientes','antes de insertar'),(144,'2020-03-03 09:53:11','clientes','cliente insertado'),(145,'2020-03-03 09:53:31','clientes','antes de eliminar'),(146,'2020-03-03 09:53:31','clientes','cliente eliminado'),(147,'2020-03-03 09:53:37','clientes','antes de eliminar'),(148,'2020-03-03 09:53:37','clientes','cliente eliminado'),(149,'2020-03-03 09:53:42','clientes','antes de eliminar'),(150,'2020-03-03 09:53:42','clientes','cliente eliminado'),(151,'2020-03-03 09:53:46','clientes','antes de eliminar'),(152,'2020-03-03 09:53:46','clientes','cliente eliminado'),(153,'2020-03-03 09:53:50','clientes','antes de eliminar'),(154,'2020-03-03 09:53:50','clientes','cliente eliminado'),(155,'2020-03-03 09:53:53','clientes','antes de eliminar'),(156,'2020-03-03 09:53:53','clientes','cliente eliminado'),(157,'2020-03-03 10:20:10','clientes','antes de actualizar'),(158,'2020-03-03 10:20:10','clientes','cliente actualizado'),(159,'2020-03-03 10:21:49','clientes','antes de actualizar'),(160,'2020-03-03 10:21:49','clientes','cliente actualizado'),(161,'2020-03-03 10:22:07','clientes','antes de actualizar'),(162,'2020-03-03 10:22:07','clientes','cliente actualizado'),(163,'2020-03-03 10:22:31','clientes','antes de actualizar'),(164,'2020-03-03 10:22:31','clientes','cliente actualizado'),(165,'2020-03-03 11:47:08','clientes','antes de actualizar'),(166,'2020-03-03 11:47:08','clientes','cliente actualizado'),(167,'2020-03-03 11:49:37','clientes','antes de actualizar'),(168,'2020-03-03 11:49:37','clientes','cliente actualizado'),(169,'2020-03-03 11:52:24','clientes','antes de actualizar'),(170,'2020-03-03 11:52:24','clientes','cliente actualizado'),(171,'2020-03-03 11:53:03','clientes','antes de actualizar'),(172,'2020-03-03 11:53:03','clientes','cliente actualizado'),(173,'2020-03-03 11:55:06','clientes','antes de actualizar'),(174,'2020-03-03 11:55:06','clientes','cliente actualizado'),(175,'2020-03-03 11:55:37','clientes','antes de actualizar'),(176,'2020-03-03 11:55:37','clientes','cliente actualizado'),(177,'2020-03-03 11:59:04','clientes','antes de actualizar'),(178,'2020-03-03 11:59:04','clientes','cliente actualizado'),(179,'2020-03-03 11:59:24','clientes','antes de actualizar'),(180,'2020-03-03 11:59:24','clientes','cliente actualizado'),(181,'2020-03-03 11:59:51','clientes','antes de actualizar'),(182,'2020-03-03 11:59:51','clientes','cliente actualizado'),(183,'2020-03-03 12:00:00','clientes','antes de actualizar'),(184,'2020-03-03 12:00:00','clientes','cliente actualizado'),(185,'2020-03-03 12:01:42','clientes','antes de actualizar'),(186,'2020-03-03 12:01:42','clientes','cliente actualizado'),(187,'2020-03-03 12:01:45','clientes','antes de actualizar'),(188,'2020-03-03 12:01:45','clientes','cliente actualizado'),(189,'2020-03-03 12:01:49','clientes','antes de actualizar'),(190,'2020-03-03 12:01:49','clientes','cliente actualizado'),(191,'2020-03-03 12:01:54','clientes','antes de actualizar'),(192,'2020-03-03 12:01:54','clientes','cliente actualizado'),(193,'2020-03-03 12:01:59','clientes','antes de actualizar'),(194,'2020-03-03 12:01:59','clientes','cliente actualizado'),(195,'2020-03-03 12:02:33','clientes','antes de actualizar'),(196,'2020-03-03 12:02:33','clientes','cliente actualizado'),(197,'2020-03-03 12:02:37','clientes','antes de actualizar'),(198,'2020-03-03 12:02:37','clientes','cliente actualizado'),(199,'2020-03-03 12:05:39','clientes','antes de actualizar'),(200,'2020-03-03 12:05:39','clientes','cliente actualizado'),(201,'2020-03-03 12:06:04','clientes','antes de actualizar'),(202,'2020-03-03 12:06:04','clientes','cliente actualizado'),(203,'2020-03-04 08:42:41','sesiones','actualizada'),(204,'2020-03-04 08:42:58','sesiones','actualizada'),(205,'2020-03-04 08:43:17','sesiones','actualizada'),(206,'2020-03-04 08:43:26','sesiones','actualizada'),(207,'2020-03-04 11:45:30','clientes','antes de insertar'),(208,'2020-03-04 11:45:30','clientes','cliente insertado'),(209,'2020-03-04 13:11:16','trabajadores','insertado'),(210,'2020-03-04 13:11:33','trabajadores','eliminado'),(211,'2020-03-04 13:24:36','trabajadores','insertado'),(212,'2020-03-04 13:24:53','trabajadores','eliminado'),(213,'2020-03-04 13:37:37','trabajadores','insertado'),(214,'2020-03-04 13:37:40','trabajadores','insertado'),(215,'2020-03-04 13:37:44','trabajadores','insertado'),(216,'2020-03-04 13:39:00','trabajadores','insertado'),(217,'2020-03-04 13:39:05','trabajadores','insertado'),(218,'2020-03-04 13:41:21','trabajadores','insertado'),(219,'2020-03-04 13:41:24','trabajadores','insertado'),(220,'2020-03-04 13:42:18','trabajadores','eliminado'),(221,'2020-03-04 13:42:18','trabajadores','eliminado'),(222,'2020-03-04 13:42:18','trabajadores','eliminado'),(223,'2020-03-04 13:42:18','trabajadores','eliminado'),(224,'2020-03-04 13:42:18','trabajadores','eliminado'),(225,'2020-03-04 13:42:18','trabajadores','eliminado'),(226,'2020-03-04 14:25:00','trabajadores','actualizado'),(227,'2020-03-04 14:27:49','trabajadores','actualizado'),(228,'2020-03-04 14:27:50','trabajadores','actualizado'),(229,'2020-03-04 14:27:53','trabajadores','actualizado'),(230,'2020-03-04 14:27:58','trabajadores','insertado'),(231,'2020-03-04 14:29:07','trabajadores','actualizado'),(232,'2020-03-04 14:29:12','trabajadores','actualizado'),(233,'2020-03-04 14:29:15','trabajadores','actualizado'),(234,'2020-03-04 14:29:24','trabajadores','actualizado'),(235,'2020-03-05 12:02:22','trabajadores','insertado'),(236,'2020-03-05 12:06:24','trabajadores','insertado'),(237,'2020-03-05 12:55:19','trabajadores','insertado'),(238,'2020-03-05 13:04:30','trabajadores','actualizado'),(239,'2020-03-05 13:05:02','trabajadores','eliminado'),(240,'2020-03-05 13:12:07','sesiones','insertada'),(241,'2020-03-05 13:20:18','trabajadores','insertado'),(242,'2020-03-05 13:20:55','trabajadores','insertado'),(243,'2020-03-05 13:21:20','trabajadores','insertado'),(244,'2020-03-05 13:51:39','trabajadores','actualizado'),(245,'2020-03-05 14:03:24','trabajadores','actualizado'),(246,'2020-03-05 14:03:40','trabajadores','insertado'),(247,'2020-03-05 14:05:00','trabajadores','actualizado'),(248,'2020-03-05 14:05:06','trabajadores','eliminado'),(249,'2020-03-05 14:22:35','sesiones','insertada'),(250,'2020-03-05 14:23:12','sesiones','actualizada'),(251,'2020-03-05 14:23:22','sesiones','actualizada'),(252,'2020-03-05 14:24:41','sesiones','actualizada'),(253,'2020-03-05 14:26:39','trabajadores','insertado'),(254,'2020-03-05 14:30:19','servicios','insertado'),(255,'2020-03-05 14:31:37','trabajadores','insertado'),(256,'2020-03-06 10:16:51','sesiones','insertada'),(257,'2020-03-06 10:18:00','sesiones','insertada'),(258,'2020-03-06 10:47:39','sesiones','insertada'),(259,'2020-03-06 11:01:17','sesiones','insertada'),(260,'2020-03-06 11:01:51','sesiones','insertada'),(261,'2020-03-06 11:08:41','sesiones','insertada'),(262,'2020-03-06 12:10:44','clientes','antes de insertar'),(263,'2020-03-06 12:10:44','clientes','cliente insertado'),(264,'2020-03-06 12:12:11','clientes','antes de actualizar'),(265,'2020-03-06 12:12:11','clientes','cliente actualizado'),(266,'2020-03-06 12:19:17','sesiones','insertada'),(267,'2020-03-06 12:28:31','sesiones','actualizada'),(268,'2020-03-06 12:50:32','sesiones','actualizada'),(269,'2020-03-06 12:50:45','sesiones','actualizada'),(270,'2020-03-06 13:06:28','sesiones','actualizada'),(271,'2020-03-06 13:06:42','sesiones','actualizada'),(272,'2020-03-06 13:06:56','sesiones','actualizada'),(273,'2020-03-06 13:07:40','sesiones','actualizada'),(274,'2020-03-06 13:08:00','sesiones','actualizada'),(275,'2020-03-06 13:08:46','sesiones','actualizada'),(276,'2020-03-06 13:09:38','sesiones','actualizada'),(277,'2020-03-06 13:21:52','sesiones','actualizada'),(278,'2020-03-06 13:23:29','sesiones','actualizada'),(279,'2020-03-06 13:23:37','sesiones','actualizada'),(280,'2020-03-06 13:25:23','sesiones','actualizada'),(281,'2020-03-06 13:28:15','sesiones','actualizada'),(282,'2020-03-06 13:29:10','sesiones','actualizada'),(283,'2020-03-06 13:29:36','sesiones','actualizada'),(284,'2020-03-06 13:29:55','sesiones','actualizada'),(285,'2020-03-06 13:30:21','sesiones','actualizada'),(286,'2020-03-06 13:33:32','sesiones','actualizada'),(287,'2020-03-06 13:33:41','sesiones','actualizada'),(288,'2020-03-06 13:50:02','sesiones','actualizada'),(289,'2020-03-06 13:55:57','sesiones','actualizada'),(290,'2020-03-06 14:02:13','sesiones','actualizada'),(291,'2020-03-06 14:02:53','sesiones','actualizada'),(292,'2020-03-06 14:02:57','sesiones','actualizada'),(293,'2020-03-06 14:02:57','sesiones','actualizada'),(294,'2020-03-06 14:04:53','sesiones','actualizada'),(295,'2020-03-06 14:06:18','sesiones','actualizada'),(296,'2020-03-06 14:06:34','sesiones','actualizada'),(297,'2020-03-06 14:06:54','sesiones','actualizada'),(298,'2020-03-06 14:07:01','sesiones','actualizada'),(299,'2020-03-06 14:07:49','sesiones','insertada'),(300,'2020-03-06 14:10:38','sesiones','insertada'),(301,'2020-03-06 14:14:36','sesiones','insertada'),(302,'2020-03-06 14:15:38','sesiones','actualizada'),(303,'2020-03-06 14:15:43','sesiones','actualizada'),(304,'2020-03-06 14:15:52','sesiones','actualizada'),(305,'2020-03-06 14:16:00','sesiones','modificada'),(306,'2020-03-06 14:16:04','sesiones','modificada'),(307,'2020-03-06 14:16:07','sesiones','modificada'),(308,'2020-03-06 14:16:12','sesiones','modificada'),(309,'2020-03-06 14:16:14','sesiones','modificada'),(310,'2020-03-06 14:16:17','sesiones','modificada'),(311,'2020-03-06 14:16:19','sesiones','modificada'),(312,'2020-03-06 14:16:21','sesiones','modificada'),(313,'2020-03-09 10:35:35','servicios','insertado'),(314,'2020-03-09 10:36:02','servicios','actualizado'),(315,'2020-03-09 10:36:19','servicios','eliminado'),(316,'2020-03-09 10:39:36','servicios','eliminado'),(317,'2020-03-09 10:44:45','servicios','insertado'),(318,'2020-03-09 10:45:48','servicios','insertado'),(319,'2020-03-09 10:45:50','servicios','insertado'),(320,'2020-03-09 10:46:02','servicios','insertado'),(321,'2020-03-09 10:47:12','servicios','insertado'),(322,'2020-03-09 10:50:16','servicios','actualizado'),(323,'2020-03-09 10:51:29','servicios','actualizado'),(324,'2020-03-09 10:51:39','servicios','actualizado'),(325,'2020-03-09 10:54:02','trabajadores','actualizado'),(326,'2020-03-09 10:54:31','clientes','antes de actualizar'),(327,'2020-03-09 10:54:31','clientes','cliente actualizado'),(328,'2020-03-09 10:55:19','clientes','antes de insertar'),(329,'2020-03-09 10:55:19','clientes','cliente insertado'),(330,'2020-03-09 10:58:30','clientes','antes de insertar'),(331,'2020-03-09 10:58:30','clientes','cliente insertado'),(332,'2020-03-09 11:05:13','clientes','antes de insertar'),(333,'2020-03-09 11:05:13','clientes','cliente insertado'),(334,'2020-03-09 12:04:58','clientes','antes de insertar'),(335,'2020-03-09 12:04:58','clientes','cliente insertado'),(336,'2020-03-09 12:09:56','clientes','antes de insertar'),(337,'2020-03-09 12:09:56','clientes','cliente insertado'),(338,'2020-03-09 12:13:55','clientes','antes de insertar'),(339,'2020-03-09 12:13:55','clientes','cliente insertado'),(340,'2020-03-09 12:21:04','clientes','antes de insertar'),(341,'2020-03-09 12:21:04','clientes','cliente insertado'),(342,'2020-03-09 12:23:34','clientes','antes de insertar'),(343,'2020-03-09 12:23:34','clientes','cliente insertado'),(344,'2020-03-09 13:08:58','trabajadores','actualizado'),(345,'2020-03-09 13:09:03','trabajadores','actualizado'),(346,'2020-03-09 13:09:16','clientes','antes de eliminar'),(347,'2020-03-09 13:09:16','clientes','cliente eliminado'),(348,'2020-03-09 13:09:23','clientes','antes de eliminar'),(349,'2020-03-09 13:09:23','clientes','cliente eliminado'),(350,'2020-03-09 13:09:27','clientes','antes de eliminar'),(351,'2020-03-09 13:09:27','clientes','cliente eliminado'),(352,'2020-03-09 13:09:33','clientes','antes de eliminar'),(353,'2020-03-09 13:09:33','clientes','cliente eliminado'),(354,'2020-03-09 13:09:35','clientes','antes de eliminar'),(355,'2020-03-09 13:09:35','clientes','cliente eliminado'),(356,'2020-03-09 13:09:37','clientes','antes de eliminar'),(357,'2020-03-09 13:09:37','clientes','cliente eliminado'),(358,'2020-03-09 13:09:41','clientes','antes de eliminar'),(359,'2020-03-09 13:09:41','clientes','cliente eliminado'),(360,'2020-03-09 13:09:43','clientes','antes de eliminar'),(361,'2020-03-09 13:09:43','clientes','cliente eliminado'),(362,'2020-03-09 13:09:46','clientes','antes de eliminar'),(363,'2020-03-09 13:09:46','clientes','cliente eliminado'),(364,'2020-03-09 13:09:48','clientes','antes de eliminar'),(365,'2020-03-09 13:09:48','clientes','cliente eliminado'),(366,'2020-03-09 13:10:06','servicios','eliminado'),(367,'2020-03-09 13:10:08','servicios','eliminado'),(368,'2020-03-09 13:10:10','servicios','eliminado'),(369,'2020-03-09 13:10:11','servicios','eliminado'),(370,'2020-03-09 13:10:13','servicios','eliminado'),(371,'2020-03-09 13:10:24','sesiones','modificada'),(372,'2020-03-09 13:10:34','sesiones','modificada'),(373,'2020-03-09 13:10:40','sesiones','modificada'),(374,'2020-03-09 13:10:53','sesiones','modificada'),(375,'2020-03-09 13:10:58','sesiones','modificada'),(376,'2020-03-09 13:11:01','sesiones','modificada'),(377,'2020-03-09 13:11:14','sesiones','actualizada'),(378,'2020-03-09 13:11:24','sesiones','actualizada'),(379,'2020-03-09 13:11:34','sesiones','actualizada'),(380,'2020-03-09 13:12:15','trabajadores','eliminado'),(381,'2020-03-09 13:12:22','trabajadores','eliminado'),(382,'2020-03-09 13:12:25','trabajadores','eliminado'),(383,'2020-03-09 13:12:32','trabajadores','eliminado'),(384,'2020-03-09 13:12:34','trabajadores','eliminado'),(385,'2020-03-09 13:12:46','trabajadores','actualizado'),(386,'2020-03-09 13:12:59','trabajadores','actualizado'),(387,'2020-03-09 13:13:08','trabajadores','actualizado'),(388,'2020-03-09 13:13:18','trabajadores','actualizado'),(389,'2020-03-09 13:13:39','trabajadores','actualizado');
/*!40000 ALTER TABLE `historial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicios`
--

DROP TABLE IF EXISTS `servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `servicios` (
  `idservicios` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `precio` decimal(6,3) NOT NULL,
  PRIMARY KEY (`idservicios`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sesiones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clientes_idclientes` int(11) NOT NULL,
  `trabajadores_idtrabajadores` int(11) NOT NULL,
  `servicios_idservicios` int(11) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sesiones`
--

LOCK TABLES `sesiones` WRITE;
/*!40000 ALTER TABLE `sesiones` DISABLE KEYS */;
INSERT INTO `sesiones` VALUES (1,12,2,13,'1999-05-22 21:19:00','Bien','Aceptable'),(2,7,4,5,'2020-01-28 15:00:00','',''),(3,6,7,4,'2005-05-04 15:25:00','Muy bien','Para repetir'),(4,6,4,5,'2020-02-11 22:22:00','',''),(5,1,4,1,'2020-02-22 11:01:00','No fue muy agradable','No recomendable'),(9,39,8,1,'2018-05-01 21:00:00','Fue todo genial, es la tercera vez que voy.','Aceptable'),(16,9,7,13,'2020-02-03 00:00:00','BIen','Aceptable'),(18,6,4,5,'2005-11-11 11:22:00','','Aceptable'),(20,6,7,5,'2015-02-22 22:22:00','La verda es que me gusto bastante','Para repetir'),(22,6,7,5,'2018-02-23 22:22:00','La verda essdasds que me gusto bastante','Para repetir'),(25,11,1,1,'2019-02-10 10:22:00','Ya no me gusta naaaaaa','No recomendable'),(26,41,8,4,'2019-04-10 16:23:00','Todo bien','Aceptable'),(28,6,7,11,'2015-02-02 16:04:04','EncantadÃ­sima, un placer visitar este sitio','Para repetir'),(29,6,7,13,'2021-01-04 02:14:14','Todo super bien. EncantadÃ­sima','Para repetir'),(30,45,7,13,'2019-12-05 16:30:00','Todo normal','Aceptable'),(35,2,9,4,'2015-11-11 19:05:00','Bueno bueno, esta prueba..','Aceptable');
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
SET character_set_client = utf8mb4;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `trabajadores` (
  `idtrabajadores` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `apellidos` varchar(90) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `dni` char(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`idtrabajadores`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajadores`
--

LOCK TABLES `trabajadores` WRITE;
/*!40000 ALTER TABLE `trabajadores` DISABLE KEYS */;
INSERT INTO `trabajadores` VALUES (1,'Jose Angel','Garcia Pelaez','71859635P'),(2,'Alberto','Romero Relai','78521252O'),(4,'Leticia','Sancho Villa','71285369G'),(7,'Teodoro','Fernandez','78545215B'),(8,'Rocío ','Alvarez de la Serna','72234567I'),(9,'Paquito ','Lopez Diez','76532612B'),(14,'Arsacio','Melchor Pelses','77777777V'),(28,'Ronaldo','Nazario Gomez','78521459D'),(29,'Ramon','Garcia Peleteiro','78899665L'),(46,'Andres','Melchor Pelses','77777337V');
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuarios` (
  `idusuarios` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `password` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `rol` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`idusuarios`),
  UNIQUE KEY `email_UNIQUE` (`email`)
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
-- Dumping events for database 'masajes'
--

--
-- Dumping routines for database 'masajes'
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
	SELECT idclientes, nombre, apellidos, dni FROM clientes;
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
/*!50003 DROP PROCEDURE IF EXISTS `serviciosGetById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `serviciosGetById`(IN _id INT)
BEGIN
    SELECT idservicios, nombre, precio
    FROM servicios
    WHERE idservicios=_id;
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
-- Final view structure for view `clientes_vip_y_servicios`
--

/*!50001 DROP VIEW IF EXISTS `clientes_vip_y_servicios`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `clientes_vip_y_servicios` AS select `c`.`idclientes` AS `idcliente`,`c`.`nombre` AS `cnombre`,`c`.`apellidos` AS `capellidos`,`s`.`idservicios` AS `idservicio`,`s`.`nombre` AS `snombre`,`s`.`precio` AS `sprecio` from ((`clientes` `c` join `sesiones` `ses` on((`c`.`idclientes` = `ses`.`clientes_idclientes`))) join `servicios` `s` on((`s`.`idservicios` = `ses`.`servicios_idservicios`))) where (`c`.`dni` like '%A') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `clientes_vip_y_serviciosdni`
--

/*!50001 DROP VIEW IF EXISTS `clientes_vip_y_serviciosdni`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `clientes_vip_y_serviciosdni` AS select `c`.`idclientes` AS `idcliente`,`c`.`nombre` AS `cnombre`,`c`.`apellidos` AS `capellidos`,`s`.`idservicios` AS `idservicio`,`s`.`nombre` AS `snombre`,`s`.`precio` AS `sprecio` from ((`clientes` `c` join `sesiones` `ses` on((`c`.`idclientes` = `ses`.`clientes_idclientes`))) join `servicios` `s` on((`s`.`idservicios` = `ses`.`servicios_idservicios`))) where (`c`.`dni` like '%A') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

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

-- Dump completed on 2020-03-09 13:15:49
