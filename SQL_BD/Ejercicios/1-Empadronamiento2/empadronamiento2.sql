CREATE DATABASE  IF NOT EXISTS `empadronamiento2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `empadronamiento2`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: empadronamiento2
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
-- Table structure for table `municipios`
--

DROP TABLE IF EXISTS `municipios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `municipios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codigo` char(5) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `nombre` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `municipios`
--

LOCK TABLES `municipios` WRITE;
/*!40000 ALTER TABLE `municipios` DISABLE KEYS */;
INSERT INTO `municipios` VALUES (1,'BUVDP','Valles De Palenzuela'),(2,'PAVLL','Villodrigo'),(3,'BURVL','Revilla Vallejera'),(4,'BUPAM','Pampliega');
/*!40000 ALTER TABLE `municipios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `apellidos` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `dni` char(9) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `habita_en` int NOT NULL,
  `empadronado_en` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ndi_UNIQUE` (`dni`),
  KEY `fk_personas1_viviendas11_idx` (`habita_en`),
  KEY `fk_personas1_viviendas12_idx` (`empadronado_en`),
  CONSTRAINT `fk_personas1_viviendas11` FOREIGN KEY (`habita_en`) REFERENCES `viviendas` (`id`),
  CONSTRAINT `fk_personas1_viviendas12` FOREIGN KEY (`empadronado_en`) REFERENCES `viviendas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES (1,'Alberto','Rodriguez Revuelta','71258323D',1,2),(2,'Francisco ','Perez Martinez','71286598F',2,3),(3,'Vanesa','Romero Garcia','75246529G',7,2),(4,'Miguel','Santos Perez','78643512B',6,5),(5,'Tito','Gonzalez Ruiz','78459696G',1,1),(6,'Raul','Minguez Laso','75213459Q',4,6),(7,'Elena ','Furiaste Ronda','76525212Z',3,1);
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas_has_viviendas`
--

DROP TABLE IF EXISTS `personas_has_viviendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personas_has_viviendas` (
  `persona_id` int NOT NULL,
  `vivienda_id` int NOT NULL,
  PRIMARY KEY (`persona_id`,`vivienda_id`),
  KEY `fk_personas1_has_viviendas1_viviendas11_idx` (`vivienda_id`),
  KEY `fk_personas1_has_viviendas1_personas11_idx` (`persona_id`),
  CONSTRAINT `fk_personas1_has_viviendas1_personas11` FOREIGN KEY (`persona_id`) REFERENCES `personas` (`id`),
  CONSTRAINT `fk_personas1_has_viviendas1_viviendas11` FOREIGN KEY (`vivienda_id`) REFERENCES `viviendas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas_has_viviendas`
--

LOCK TABLES `personas_has_viviendas` WRITE;
/*!40000 ALTER TABLE `personas_has_viviendas` DISABLE KEYS */;
INSERT INTO `personas_has_viviendas` VALUES (1,1),(6,1),(1,2),(2,3),(3,5),(7,5),(4,6),(5,7);
/*!40000 ALTER TABLE `personas_has_viviendas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viviendas`
--

DROP TABLE IF EXISTS `viviendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `viviendas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codigo` char(5) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `calle` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `numero` varchar(5) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `municipio_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_viviendas1_municipios11_idx` (`municipio_id`),
  CONSTRAINT `fk_viviendas1_municipios11` FOREIGN KEY (`municipio_id`) REFERENCES `municipios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viviendas`
--

LOCK TABLES `viviendas` WRITE;
/*!40000 ALTER TABLE `viviendas` DISABLE KEYS */;
INSERT INTO `viviendas` VALUES (1,'C0001','Los huertos','3',1),(2,'C0002','San Francisco','23',1),(3,'D3202','Mayor','134',2),(4,'C0005','El ayuntamiento','44',1),(5,'G3203','La iglesia','1',3),(6,'K8803','Fernando Trueba','15',4),(7,'G3204','San Agustin','111',3);
/*!40000 ALTER TABLE `viviendas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'empadronamiento2'
--

--
-- Dumping routines for database 'empadronamiento2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-06  0:29:00
