CREATE DATABASE  IF NOT EXISTS `servicio_social` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `servicio_social`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: servicio_social
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
-- Table structure for table `documento`
--

DROP TABLE IF EXISTS `documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `documento` (
  `iddocumento` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_documento` varchar(100) DEFAULT NULL,
  `estado_documento` varchar(45) DEFAULT NULL,
  `fecha_documento` date DEFAULT NULL,
  `link_documento` varchar(200) DEFAULT NULL,
  `tipo_documento` varchar(45) DEFAULT NULL,
  `idseguimiento` int(11) NOT NULL,
  PRIMARY KEY (`iddocumento`),
  UNIQUE KEY `iddocumento_UNIQUE` (`iddocumento`),
  KEY `fk_documento_seguimiento1_idx` (`idseguimiento`),
  CONSTRAINT `fk_documento_seguimiento1` FOREIGN KEY (`idseguimiento`) REFERENCES `seguimiento` (`idseguimiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documento`
--

LOCK TABLES `documento` WRITE;
/*!40000 ALTER TABLE `documento` DISABLE KEYS */;
/*!40000 ALTER TABLE `documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eleccionestudiante`
--

DROP TABLE IF EXISTS `eleccionestudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `eleccionestudiante` (
  `idestudiante` int(11) NOT NULL,
  `idsolicitudProyecto` int(11) NOT NULL,
  `fecha_seleccion` date DEFAULT NULL,
  KEY `fk_estudiante_has_solicitudProyecto_solicitudProyecto1_idx` (`idsolicitudProyecto`),
  KEY `fk_estudiante_has_solicitudProyecto_estudiante1_idx` (`idestudiante`),
  CONSTRAINT `fk_estudiante_has_solicitudProyecto_estudiante1` FOREIGN KEY (`idestudiante`) REFERENCES `estudiante` (`idestudiante`),
  CONSTRAINT `fk_estudiante_has_solicitudProyecto_solicitudProyecto1` FOREIGN KEY (`idsolicitudProyecto`) REFERENCES `solicitudproyecto` (`idsolicitudproyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eleccionestudiante`
--

LOCK TABLES `eleccionestudiante` WRITE;
/*!40000 ALTER TABLE `eleccionestudiante` DISABLE KEYS */;
/*!40000 ALTER TABLE `eleccionestudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `estudiante` (
  `idestudiante` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` varchar(9) DEFAULT NULL,
  `nombre` varchar(40) DEFAULT NULL,
  `paterno` varchar(35) DEFAULT NULL,
  `materno` varchar(35) DEFAULT NULL,
  `programaeducativo` varchar(130) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `promedio` float DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `nombrecontacto` varchar(60) DEFAULT NULL,
  `telefonocontacto` varchar(10) DEFAULT NULL,
  `idinicioSesion` int(11) NOT NULL,
  PRIMARY KEY (`idestudiante`),
  KEY `fk_estudiante_inicioSesion1_idx` (`idinicioSesion`),
  CONSTRAINT `fk_estudiante_inicioSesion1` FOREIGN KEY (`idinicioSesion`) REFERENCES `iniciosesion` (`idiniciosesion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
INSERT INTO `estudiante` VALUES (1,'S17013000','Victor Manuel','Niño','Martinez','Ingeniería de Software','victor@gmail.com',9.1,'2283026464','Jessica Niño','2282456789',1),(2,'S17012999','Alan','Gonzalez','Heredia','Ingeniería de Software','alan@hotmail.com',9,'2284321654','Carlos Gonzalez','2233963852',2),(3,'S17012878','Juan Carlos','Suarez','Hernandez','Ingeniería de Software','juanga@gmail.com',9.2,'2232741258','Roberto Suarez','9933789321',3),(4,'S16023032','Ana Carolina','Sandria','Sanchez','Ingeniería de Software','carolina@hotmail.com',9,'287456789','Maria Sandria','2873212584',4);
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `estudiante_detalles`
--

DROP TABLE IF EXISTS `estudiante_detalles`;
/*!50001 DROP VIEW IF EXISTS `estudiante_detalles`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `estudiante_detalles` AS SELECT 
 1 AS `idinicioSesion`,
 1 AS `idseguimiento`,
 1 AS `idservicioSocial`,
 1 AS `idestudiante`,
 1 AS `matricula`,
 1 AS `nombre`,
 1 AS `paterno`,
 1 AS `materno`,
 1 AS `programaeducativo`,
 1 AS `email`,
 1 AS `promedio`,
 1 AS `telefono`,
 1 AS `nombrecontacto`,
 1 AS `telefonocontacto`,
 1 AS `folio_inscripcion`,
 1 AS `tipo_incripcion`,
 1 AS `fecha_inscripcion`,
 1 AS `bloque`,
 1 AS `creditos`,
 1 AS `nrc`,
 1 AS `seccion`,
 1 AS `nombre_profesor`,
 1 AS `calificacion`,
 1 AS `estado`,
 1 AS `horasAcumuladas`,
 1 AS `usuario`,
 1 AS `contrasenia`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `iniciosesion`
--

DROP TABLE IF EXISTS `iniciosesion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `iniciosesion` (
  `idinicioSesion` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) DEFAULT NULL,
  `contrasenia` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idinicioSesion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iniciosesion`
--

LOCK TABLES `iniciosesion` WRITE;
/*!40000 ALTER TABLE `iniciosesion` DISABLE KEYS */;
INSERT INTO `iniciosesion` VALUES (1,'victorNino','12345'),(2,'alanHeredia','54321'),(3,'juanCarlos','23456'),(4,'carolinaSandria','24689');
/*!40000 ALTER TABLE `iniciosesion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscripcion`
--

DROP TABLE IF EXISTS `inscripcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `inscripcion` (
  `folio_inscripcion` int(11) NOT NULL AUTO_INCREMENT,
  `idservicioSocial` int(11) NOT NULL,
  `idestudiante` int(11) NOT NULL,
  `idseguimiento` int(11) NOT NULL,
  `tipo_incripcion` varchar(45) NOT NULL,
  `fecha_inscripcion` date NOT NULL,
  PRIMARY KEY (`folio_inscripcion`),
  KEY `fk_servicioSocial_has_estudiante_estudiante1_idx` (`idestudiante`),
  KEY `fk_servicioSocial_has_estudiante_servicioSocial1_idx` (`idservicioSocial`),
  KEY `fk_inscripcion_seguimiento1_idx` (`idseguimiento`),
  CONSTRAINT `fk_inscripcion_seguimiento1` FOREIGN KEY (`idseguimiento`) REFERENCES `seguimiento` (`idseguimiento`),
  CONSTRAINT `fk_servicioSocial_has_estudiante_estudiante1` FOREIGN KEY (`idestudiante`) REFERENCES `estudiante` (`idestudiante`),
  CONSTRAINT `fk_servicioSocial_has_estudiante_servicioSocial1` FOREIGN KEY (`idservicioSocial`) REFERENCES `serviciosocial` (`idserviciosocial`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscripcion`
--

LOCK TABLES `inscripcion` WRITE;
/*!40000 ALTER TABLE `inscripcion` DISABLE KEYS */;
INSERT INTO `inscripcion` VALUES (1,1,1,1,'Normal','2019-06-08'),(5,1,2,2,'Normal','2019-06-08'),(6,1,3,3,'Normal','2019-06-08'),(7,1,4,4,'Segunda','2019-06-08');
/*!40000 ALTER TABLE `inscripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registroplandeactividades`
--

DROP TABLE IF EXISTS `registroplandeactividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `registroplandeactividades` (
  `idregistroPlanDeActividades` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_planActividades` varchar(45) DEFAULT NULL,
  `duracion_planActividades` varchar(45) DEFAULT NULL,
  `horario_planActividades` varchar(45) DEFAULT NULL,
  `nombre_planActividades` varchar(45) DEFAULT NULL,
  `responsabilidades_planActividades` varchar(45) DEFAULT NULL,
  `idseguimiento` int(11) NOT NULL,
  `idresponsableProyecto` int(11) NOT NULL,
  PRIMARY KEY (`idregistroPlanDeActividades`),
  UNIQUE KEY `idregistroPlanDeActividades_UNIQUE` (`idregistroPlanDeActividades`),
  KEY `fk_registroPlanDeActividades_seguimiento1_idx` (`idseguimiento`),
  KEY `fk_registroPlanDeActividades_responsableProyecto1_idx` (`idresponsableProyecto`),
  CONSTRAINT `fk_registroPlanDeActividades_responsableProyecto1` FOREIGN KEY (`idresponsableProyecto`) REFERENCES `responsableproyecto` (`idresponsableproyecto`),
  CONSTRAINT `fk_registroPlanDeActividades_seguimiento1` FOREIGN KEY (`idseguimiento`) REFERENCES `seguimiento` (`idseguimiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registroplandeactividades`
--

LOCK TABLES `registroplandeactividades` WRITE;
/*!40000 ALTER TABLE `registroplandeactividades` DISABLE KEYS */;
/*!40000 ALTER TABLE `registroplandeactividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reportemensual`
--

DROP TABLE IF EXISTS `reportemensual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `reportemensual` (
  `idreporteMensual` int(11) NOT NULL AUTO_INCREMENT,
  `estado_reporteMensual` varchar(45) DEFAULT NULL,
  `horasReportadas` int(11) DEFAULT NULL,
  `link_reporteMensual` varchar(200) DEFAULT NULL,
  `mes_reporteMensual` varchar(45) DEFAULT NULL,
  `noReporte` int(11) DEFAULT NULL,
  `idseguimiento` int(11) NOT NULL,
  PRIMARY KEY (`idreporteMensual`),
  UNIQUE KEY `idreporteMensual_UNIQUE` (`idreporteMensual`),
  KEY `fk_reporteMensual_seguimiento1_idx` (`idseguimiento`),
  CONSTRAINT `fk_reporteMensual_seguimiento1` FOREIGN KEY (`idseguimiento`) REFERENCES `seguimiento` (`idseguimiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reportemensual`
--

LOCK TABLES `reportemensual` WRITE;
/*!40000 ALTER TABLE `reportemensual` DISABLE KEYS */;
/*!40000 ALTER TABLE `reportemensual` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responsableproyecto`
--

DROP TABLE IF EXISTS `responsableproyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `responsableproyecto` (
  `idresponsableProyecto` int(11) NOT NULL AUTO_INCREMENT,
  `cargo` varchar(45) DEFAULT NULL,
  `correoElectronico` varchar(45) DEFAULT NULL,
  `materno` varchar(45) DEFAULT NULL,
  `paterno` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `idunidadReceptora` int(11) NOT NULL,
  PRIMARY KEY (`idresponsableProyecto`),
  UNIQUE KEY `idresponsableProyecto_UNIQUE` (`idresponsableProyecto`),
  KEY `fk_responsableProyecto_unidadReceptora1_idx` (`idunidadReceptora`),
  CONSTRAINT `fk_responsableProyecto_unidadReceptora1` FOREIGN KEY (`idunidadReceptora`) REFERENCES `unidadreceptora` (`idunidadreceptora`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsableproyecto`
--

LOCK TABLES `responsableproyecto` WRITE;
/*!40000 ALTER TABLE `responsableproyecto` DISABLE KEYS */;
/*!40000 ALTER TABLE `responsableproyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seguimiento`
--

DROP TABLE IF EXISTS `seguimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `seguimiento` (
  `idseguimiento` int(11) NOT NULL AUTO_INCREMENT,
  `calificacion` double DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `horasAcumuladas` int(11) DEFAULT NULL,
  PRIMARY KEY (`idseguimiento`),
  UNIQUE KEY `idseguimiento_UNIQUE` (`idseguimiento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguimiento`
--

LOCK TABLES `seguimiento` WRITE;
/*!40000 ALTER TABLE `seguimiento` DISABLE KEYS */;
INSERT INTO `seguimiento` VALUES (1,0,'Cursando',0),(2,0,'Cursando',0),(3,0,'Cursando',0),(4,0,'Cursando',0);
/*!40000 ALTER TABLE `seguimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serviciosocial`
--

DROP TABLE IF EXISTS `serviciosocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `serviciosocial` (
  `idservicioSocial` int(11) NOT NULL AUTO_INCREMENT,
  `bloque` int(11) DEFAULT NULL,
  `creditos` int(11) DEFAULT NULL,
  `nrc` int(11) DEFAULT NULL,
  `seccion` int(11) DEFAULT NULL,
  `nombre_profesor` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idservicioSocial`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serviciosocial`
--

LOCK TABLES `serviciosocial` WRITE;
/*!40000 ALTER TABLE `serviciosocial` DISABLE KEYS */;
INSERT INTO `serviciosocial` VALUES (1,1,10,12345,1,'Fredy Castañeda');
/*!40000 ALTER TABLE `serviciosocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitudproyecto`
--

DROP TABLE IF EXISTS `solicitudproyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `solicitudproyecto` (
  `idsolicitudProyecto` int(11) NOT NULL AUTO_INCREMENT,
  `actividad_solicitud` varchar(45) DEFAULT NULL,
  `horario_solicitud` varchar(45) DEFAULT NULL,
  `lugar_solicitud` varchar(45) DEFAULT NULL,
  `noEstudiantes_solicitud` int(11) DEFAULT NULL,
  `requisitos_solicitud` varchar(200) DEFAULT NULL,
  `tipoSolicitud` varchar(45) DEFAULT NULL,
  `idseguimiento` int(11) NOT NULL,
  PRIMARY KEY (`idsolicitudProyecto`),
  KEY `fk_solicitudProyecto_seguimiento1_idx` (`idseguimiento`),
  CONSTRAINT `fk_solicitudProyecto_seguimiento1` FOREIGN KEY (`idseguimiento`) REFERENCES `seguimiento` (`idseguimiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitudproyecto`
--

LOCK TABLES `solicitudproyecto` WRITE;
/*!40000 ALTER TABLE `solicitudproyecto` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitudproyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidadreceptora`
--

DROP TABLE IF EXISTS `unidadreceptora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `unidadreceptora` (
  `idunidadReceptora` int(11) NOT NULL AUTO_INCREMENT,
  `ciudad` varchar(45) DEFAULT NULL,
  `correoElectronico` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `nombreDirectivo` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idunidadReceptora`),
  UNIQUE KEY `idunidadReceptora_UNIQUE` (`idunidadReceptora`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidadreceptora`
--

LOCK TABLES `unidadreceptora` WRITE;
/*!40000 ALTER TABLE `unidadreceptora` DISABLE KEYS */;
/*!40000 ALTER TABLE `unidadreceptora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `estudiante_detalles`
--

/*!50001 DROP VIEW IF EXISTS `estudiante_detalles`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `estudiante_detalles` AS select `e`.`idinicioSesion` AS `idinicioSesion`,`i`.`idseguimiento` AS `idseguimiento`,`i`.`idservicioSocial` AS `idservicioSocial`,`e`.`idestudiante` AS `idestudiante`,`e`.`matricula` AS `matricula`,`e`.`nombre` AS `nombre`,`e`.`paterno` AS `paterno`,`e`.`materno` AS `materno`,`e`.`programaeducativo` AS `programaeducativo`,`e`.`email` AS `email`,`e`.`promedio` AS `promedio`,`e`.`telefono` AS `telefono`,`e`.`nombrecontacto` AS `nombrecontacto`,`e`.`telefonocontacto` AS `telefonocontacto`,`i`.`folio_inscripcion` AS `folio_inscripcion`,`i`.`tipo_incripcion` AS `tipo_incripcion`,`i`.`fecha_inscripcion` AS `fecha_inscripcion`,`serviciosocial`.`bloque` AS `bloque`,`serviciosocial`.`creditos` AS `creditos`,`serviciosocial`.`nrc` AS `nrc`,`serviciosocial`.`seccion` AS `seccion`,`serviciosocial`.`nombre_profesor` AS `nombre_profesor`,`seguimiento`.`calificacion` AS `calificacion`,`seguimiento`.`estado` AS `estado`,`seguimiento`.`horasAcumuladas` AS `horasAcumuladas`,`iniciosesion`.`usuario` AS `usuario`,`iniciosesion`.`contrasenia` AS `contrasenia` from ((((`estudiante` `e` join `inscripcion` `i` on((`e`.`idestudiante` = `i`.`idestudiante`))) join `serviciosocial` on((`i`.`idservicioSocial` = `serviciosocial`.`idservicioSocial`))) join `seguimiento` on((`i`.`idseguimiento` = `seguimiento`.`idseguimiento`))) join `iniciosesion` on((`e`.`idinicioSesion` = `iniciosesion`.`idinicioSesion`))) */;
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

-- Dump completed on 2019-06-08 21:01:56
