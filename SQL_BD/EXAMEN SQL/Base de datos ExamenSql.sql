CREATE DATABASE  IF NOT EXISTS `examensql` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci */;
USE `examensql`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: examensql
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
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `categorias` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` text COLLATE utf8mb4_spanish2_ci,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Categoria1'),(2,'Categoria2'),(3,'Categoria3'),(4,'Categoria4'),(5,'Categoria5'),(6,'Categoria6'),(7,'Categoria7'),(8,'Categoria8'),(9,'Categoria9'),(10,'Categoria10');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `direccion` varchar(150) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `telefono` char(9) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Cliente1','DirCliente1','944111111'),(2,'Cliente2','DirCliente2','944222222'),(3,'Cliente3','DirCliente3','944333333'),(4,'Cliente4','DirCliente4','944444444'),(5,'Cliente5','DirCliente5','944555555'),(6,'Cliente6','DirCliente6','944666666'),(7,'Cliente7','DirCliente7','944777777'),(8,'Cliente8','DirCliente8','944888888'),(9,'Cliente9','DirCliente9','944999999'),(10,'Cliente10','DirCliente10','944101010');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturas`
--

DROP TABLE IF EXISTS `facturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `facturas` (
  `id_factura` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `id_cliente` int(11) NOT NULL,
  PRIMARY KEY (`id_factura`),
  KEY `fk_facturas_clientes_idx` (`id_cliente`),
  CONSTRAINT `fk_facturas_clientes` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturas`
--

LOCK TABLES `facturas` WRITE;
/*!40000 ALTER TABLE `facturas` DISABLE KEYS */;
INSERT INTO `facturas` VALUES (1,'2020-01-05',1),(2,'2020-01-08',2),(3,'2019-05-12',3),(4,'2020-01-25',1),(5,'2019-04-15',5),(6,'2019-12-05',6),(7,'2018-12-15',8),(8,'2017-05-06',4),(9,'2018-12-25',8),(10,'2016-09-30',8),(11,'2019-09-19',10),(12,'2019-08-15',4),(13,'2020-01-25',8),(14,'2020-02-25',1),(15,'2020-02-15',1),(16,'2020-02-11',5),(17,'2020-01-15',8),(18,'2018-11-25',1),(19,'2017-12-25',5),(20,'2018-10-30',3);
/*!40000 ALTER TABLE `facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `productos` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` text COLLATE utf8mb4_spanish2_ci,
  `precio` decimal(6,2) DEFAULT NULL,
  `id_categoria` int(11) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `fk_productos_proveedores1_idx` (`id_proveedor`),
  KEY `fk_productos_categorias1_idx` (`id_categoria`),
  CONSTRAINT `fk_productos_categorias1` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`),
  CONSTRAINT `fk_productos_proveedores1` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (84,'Producto1',5.00,1,10),(85,'Producto2',8.60,6,15),(86,'Producto3',45.55,4,12),(87,'Producto4',48.00,5,16),(88,'Producto5',25.00,8,11),(89,'Producto6',4.50,1,13),(90,'Producto7',14.56,2,18),(91,'Producto8',75.50,3,10),(92,'Producto9',15.80,1,14),(93,'Producto10',55.00,5,11),(94,'Producto11',14.00,8,14),(95,'Producto12',22.00,9,16),(96,'Producto13',14.50,7,16),(97,'Producto14',15.45,1,17),(98,'Producto15',15.00,5,18),(99,'Producto16',224.00,10,19),(100,'Producto17',15.00,5,13),(101,'Producto18',26.00,8,16),(102,'Producto19',48.00,9,12),(103,'Producto20',14.84,1,12),(104,'Producto21',22.00,1,11),(105,'Producto22',14.60,2,12),(106,'Producto23',5.00,3,15),(107,'Producto24',8.00,6,14);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `productos_BEFORE_INSERT` BEFORE INSERT ON `productos` FOR EACH ROW BEGIN
DECLARE 
	precio int;
	IF (precio < 0) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No se pueden introducir precios negativos';
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Temporary view structure for view `productosporcategoria`
--

DROP TABLE IF EXISTS `productosporcategoria`;
/*!50001 DROP VIEW IF EXISTS `productosporcategoria`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `productosporcategoria` AS SELECT 
 1 AS `categoría`,
 1 AS `numero productos`,
 1 AS `precio máximo`,
 1 AS `precio mínimo`,
 1 AS `media de precios`,
 1 AS `suma de precios`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `proveedores` (
  `id_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `direccion` varchar(100) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `telefono` char(9) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (10,'Proveedor1','DirecProv1','911111111'),(11,'Proveedor2','DirecProv2','911222222'),(12,'Proveedor3','DirecProv3','911333333'),(13,'Proveedor4','DirecProv4','911444444'),(14,'Proveedor5','DirecProv5','911555555'),(15,'Proveedor6','DirecProv6','911666666'),(16,'Proveedor7','DirecProv7','911777777'),(17,'Proveedor8','DirecProv8','911888888'),(18,'Proveedor9','DirecProv9','911999999'),(19,'Proveedor10','DirecProv10','911101010');
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ventas` (
  `id_venta` int(11) NOT NULL AUTO_INCREMENT,
  `id_factura` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_venta`,`id_factura`,`id_producto`),
  KEY `fk_facturas_has_productos_productos1_idx` (`id_producto`),
  KEY `fk_facturas_has_productos_facturas1_idx` (`id_factura`),
  CONSTRAINT `fk_facturas_has_productos_facturas1` FOREIGN KEY (`id_factura`) REFERENCES `facturas` (`id_factura`),
  CONSTRAINT `fk_facturas_has_productos_productos1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES (1,1,84,25),(2,3,85,10),(3,1,85,5),(4,5,99,3),(5,2,98,15),(6,3,85,25),(7,4,89,4),(8,5,84,6),(9,8,89,8),(10,6,87,55),(11,4,90,62),(12,1,103,152),(13,8,103,3),(14,9,101,6),(15,8,95,5),(16,4,94,78),(17,6,95,45),(18,7,96,12),(19,8,97,5);
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'examensql'
--

--
-- Dumping routines for database 'examensql'
--
/*!50003 DROP PROCEDURE IF EXISTS `facturas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `facturas`(IN _fecha1 DATE, IN _fecha2 DATE)
BEGIN
	SELECT *
    FROM facturas
    WHERE fecha BETWEEN _fecha1 AND _fecha2;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `productosporcategoria`
--

/*!50001 DROP VIEW IF EXISTS `productosporcategoria`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `productosporcategoria` AS select `c`.`descripcion` AS `categoría`,count(`p`.`id_producto`) AS `numero productos`,max(`p`.`precio`) AS `precio máximo`,min(`p`.`precio`) AS `precio mínimo`,avg(`p`.`precio`) AS `media de precios`,sum(`p`.`precio`) AS `suma de precios` from (`productos` `p` join `categorias` `c` on((`p`.`id_categoria` = `c`.`id_categoria`))) group by `c`.`descripcion` */;
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

-- Dump completed on 2020-02-26 14:30:51
