DROP TABLE IF EXISTS `resena`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `resena` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resena` text COLLATE utf8_bin,
  `curso_codigo` int(11) NOT NULL,
  `alumno_codigo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_resena_curso1_idx` (`curso_codigo`),
  KEY `fk_resena_alumno1_idx` (`alumno_codigo`),
  CONSTRAINT `fk_resena_alumno1` FOREIGN KEY (`alumno_codigo`) REFERENCES `alumno` (`codigo`),
  CONSTRAINT `fk_resena_curso1` FOREIGN KEY (`curso_codigo`) REFERENCES `curso` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;