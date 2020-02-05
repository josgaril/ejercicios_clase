CREATE DATABASE  IF NOT EXISTS `alojamientorural` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `alojamientorural`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: alojamientorural
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
-- Table structure for table `actividades`
--

DROP TABLE IF EXISTS `actividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actividades` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `nivel` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividades`
--

LOCK TABLES `actividades` WRITE;
/*!40000 ALTER TABLE `actividades` DISABLE KEYS */;
INSERT INTO `actividades` VALUES (1,'Senderismo','Caminar por los alrededores de la casa',4),(2,'Bicicleta','Rutas con la bici por las montañas de la comarca',5),(3,'Quads','Rutas con quad por los caminos de la zona',6),(4,'Paracaidas','Saltos en paracaidas',9),(5,'Paintball','Juego de pistolas con bolas de pintura',3),(6,'Escalada','Escala por montañas espectaculares',9),(7,'Piragüismo','Ruta en piragua por el río',6),(8,'Cars','Carreras con carse de diferente cilindrada',5);
/*!40000 ALTER TABLE `actividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alojamientos`
--

DROP TABLE IF EXISTS `alojamientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alojamientos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `direccion` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `telefono` int NOT NULL,
  `persona_contacto` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_alojamientos_trabajadores1_idx` (`persona_contacto`),
  CONSTRAINT `fk_alojamientos_trabajadores1` FOREIGN KEY (`persona_contacto`) REFERENCES `trabajadores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alojamientos`
--

LOCK TABLES `alojamientos` WRITE;
/*!40000 ALTER TABLE `alojamientos` DISABLE KEYS */;
INSERT INTO `alojamientos` VALUES (1,'Villa Aurora','Flamingo Cortes',944526585,6),(2,'Las Rosas','Puente roto 23 ',944526368,11),(3,'La Huerta','Fernando Rojas 34',944586547,8),(4,'Antoñita','Perez Galdos 122',944857895,14);
/*!40000 ALTER TABLE `alojamientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alojamientos_has_actividades`
--

DROP TABLE IF EXISTS `alojamientos_has_actividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alojamientos_has_actividades` (
  `alojamiento_id` int NOT NULL,
  `actividad_id` int NOT NULL,
  `dias` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`alojamiento_id`,`actividad_id`,`dias`),
  KEY `fk_alojamientos_has_actividades_actividades1_idx` (`actividad_id`),
  KEY `fk_alojamientos_has_actividades_alojamientos1_idx` (`alojamiento_id`),
  CONSTRAINT `fk_alojamientos_has_actividades_actividades1` FOREIGN KEY (`actividad_id`) REFERENCES `actividades` (`id`),
  CONSTRAINT `fk_alojamientos_has_actividades_alojamientos1` FOREIGN KEY (`alojamiento_id`) REFERENCES `alojamientos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alojamientos_has_actividades`
--

LOCK TABLES `alojamientos_has_actividades` WRITE;
/*!40000 ALTER TABLE `alojamientos_has_actividades` DISABLE KEYS */;
INSERT INTO `alojamientos_has_actividades` VALUES (1,1,'lunes'),(2,1,'sabados'),(3,1,'jueves'),(4,1,'martes'),(1,2,'miercoles'),(2,3,'martes'),(2,4,'miercoles'),(3,4,'viernes'),(4,5,'viernes'),(3,6,'martes'),(4,6,'viernes'),(1,7,'sabados'),(3,7,'viernes');
/*!40000 ALTER TABLE `alojamientos_has_actividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habitaciones`
--

DROP TABLE IF EXISTS `habitaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `habitaciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `wc` tinyint NOT NULL,
  `precio` decimal(10,0) NOT NULL,
  `tipo_id` int NOT NULL,
  `alojamiento_id` int NOT NULL,
  PRIMARY KEY (`id`,`tipo_id`),
  KEY `fk_habitaciones_tipos1_idx` (`tipo_id`),
  KEY `fk_habitaciones_alojamientos1_idx` (`alojamiento_id`),
  CONSTRAINT `fk_habitaciones_alojamientos1` FOREIGN KEY (`alojamiento_id`) REFERENCES `alojamientos` (`id`),
  CONSTRAINT `fk_habitaciones_tipos1` FOREIGN KEY (`tipo_id`) REFERENCES `tipos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitaciones`
--

LOCK TABLES `habitaciones` WRITE;
/*!40000 ALTER TABLE `habitaciones` DISABLE KEYS */;
INSERT INTO `habitaciones` VALUES (1,0,36,1,1),(2,1,50,2,1),(3,1,40,1,2),(4,1,55,2,1),(5,1,75,3,3),(6,1,70,3,4),(7,0,23,1,3),(8,1,48,2,2),(9,1,150,3,2),(10,0,26,1,3);
/*!40000 ALTER TABLE `habitaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos`
--

DROP TABLE IF EXISTS `tipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos`
--

LOCK TABLES `tipos` WRITE;
/*!40000 ALTER TABLE `tipos` DISABLE KEYS */;
INSERT INTO `tipos` VALUES (1,'Individual'),(2,'Doble'),(3,'Triple');
/*!40000 ALTER TABLE `tipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabajadores`
--

DROP TABLE IF EXISTS `trabajadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trabajadores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `NIF` varchar(9) COLLATE utf8_spanish2_ci NOT NULL,
  `alojamiento_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `NIF_UNIQUE` (`NIF`),
  KEY `fk_trabajadores_alojamientos_idx` (`alojamiento_id`),
  CONSTRAINT `fk_trabajadores_alojamientos` FOREIGN KEY (`alojamiento_id`) REFERENCES `alojamientos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci COMMENT='				';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajadores`
--

LOCK TABLES `trabajadores` WRITE;
/*!40000 ALTER TABLE `trabajadores` DISABLE KEYS */;
INSERT INTO `trabajadores` VALUES (6,'Jose Angel','San Agustin 7 6ºI','71415625D',1),(7,'Alberto Gomez Serna','Los pajaritos 23 3ºA','78546532F',2),(8,'Rebeca Palacios Bernabé','Itzasu 32 1ºA','79653215G',1),(9,'Mario Casilda ','Romanceros 123 4ºD','71559658N',3),(10,'Patricia Cervantes','Avenida Vitoria 111 8ºB','76352658C',4),(11,'Leticia Rodriguez ','San Agustin 3 1ºB','79526351Z',3),(12,'Francisco De La Cruz','El mirador S/N','76985989Q',2),(13,'Jorge Tejedor','Amorebieta 43 2ºD','74114695I',3),(14,'Mireia Bezos','La mayor 9 3ºE','75326952V',1),(15,'Alejandro Garcia','Las cercadas 15 4ºB','71265989L',3);
/*!40000 ALTER TABLE `trabajadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'alojamientorural'
--

--
-- Dumping routines for database 'alojamientorural'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-05 21:12:06
