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
  `iddocumento` int(11) NOT NULL,
  `descripcion_documento` varchar(100) DEFAULT NULL,
  `estado_documento` varchar(45) DEFAULT NULL,
  `fecha_documento` date DEFAULT NULL,
  `link_documento` varchar(120) DEFAULT NULL,
  `tipo_documento` varchar(45) DEFAULT NULL,
  `idseguimiento` int(11) NOT NULL,
  PRIMARY KEY (`iddocumento`),
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iniciosesion`
--

DROP TABLE IF EXISTS `iniciosesion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `iniciosesion` (
  `idinicioSesion` int(11) NOT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `contrasenia` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idinicioSesion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iniciosesion`
--

LOCK TABLES `iniciosesion` WRITE;
/*!40000 ALTER TABLE `iniciosesion` DISABLE KEYS */;
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
  UNIQUE KEY `idservicioSocial_UNIQUE` (`idservicioSocial`),
  UNIQUE KEY `idestudiante_UNIQUE` (`idestudiante`),
  KEY `fk_servicioSocial_has_estudiante_estudiante1_idx` (`idestudiante`),
  KEY `fk_servicioSocial_has_estudiante_servicioSocial1_idx` (`idservicioSocial`),
  KEY `fk_inscripcion_seguimiento1_idx` (`idseguimiento`),
  CONSTRAINT `fk_inscripcion_seguimiento1` FOREIGN KEY (`idseguimiento`) REFERENCES `seguimiento` (`idseguimiento`),
  CONSTRAINT `fk_servicioSocial_has_estudiante_estudiante1` FOREIGN KEY (`idestudiante`) REFERENCES `estudiante` (`idestudiante`),
  CONSTRAINT `fk_servicioSocial_has_estudiante_servicioSocial1` FOREIGN KEY (`idservicioSocial`) REFERENCES `serviciosocial` (`idserviciosocial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscripcion`
--

LOCK TABLES `inscripcion` WRITE;
/*!40000 ALTER TABLE `inscripcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `inscripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registroplandeactividades`
--

DROP TABLE IF EXISTS `registroplandeactividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `registroplandeactividades` (
  `idregistroPlanDeActividades` int(11) NOT NULL,
  `descripcion_planActividades` varchar(45) DEFAULT NULL,
  `duracion_planActividades` varchar(45) DEFAULT NULL,
  `horario_planActividades` varchar(45) DEFAULT NULL,
  `nombre_planActividades` varchar(45) DEFAULT NULL,
  `responsabilidades_planActividades` varchar(45) DEFAULT NULL,
  `idseguimiento` int(11) NOT NULL,
  `idresponsableProyecto` int(11) NOT NULL,
  PRIMARY KEY (`idregistroPlanDeActividades`),
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
  `idreporteMensual` int(11) NOT NULL,
  `estado_reporteMensual` varchar(45) DEFAULT NULL,
  `horasReportadas` varchar(45) DEFAULT NULL,
  `link_reporteMensual` varchar(200) DEFAULT NULL,
  `mes_reporteMensual` varchar(45) DEFAULT NULL,
  `noReporte` int(11) DEFAULT NULL,
  `idseguimiento` int(11) NOT NULL,
  PRIMARY KEY (`idreporteMensual`),
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
  `idresponsableProyecto` int(11) NOT NULL,
  `cargo` varchar(45) DEFAULT NULL,
  `correoElectronico` varchar(45) DEFAULT NULL,
  `materno` varchar(45) DEFAULT NULL,
  `paterno` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `idunidadReceptora` int(11) NOT NULL,
  PRIMARY KEY (`idresponsableProyecto`),
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
  `idseguimiento` int(11) NOT NULL,
  `calificacion` double DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `horasAcumuladas` int(11) DEFAULT NULL,
  PRIMARY KEY (`idseguimiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguimiento`
--

LOCK TABLES `seguimiento` WRITE;
/*!40000 ALTER TABLE `seguimiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `seguimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serviciosocial`
--

DROP TABLE IF EXISTS `serviciosocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `serviciosocial` (
  `idservicioSocial` int(11) NOT NULL,
  `bloque` int(11) DEFAULT NULL,
  `creditos` int(11) DEFAULT NULL,
  `nrc` int(11) DEFAULT NULL,
  `seccion` int(11) DEFAULT NULL,
  `nombre_profesor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idservicioSocial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serviciosocial`
--

LOCK TABLES `serviciosocial` WRITE;
/*!40000 ALTER TABLE `serviciosocial` DISABLE KEYS */;
/*!40000 ALTER TABLE `serviciosocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitudproyecto`
--

DROP TABLE IF EXISTS `solicitudproyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `solicitudproyecto` (
  `idsolicitudProyecto` int(11) NOT NULL,
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
  `idunidadReceptora` int(11) NOT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `correoElectronico` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `nombreDirectivo` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idunidadReceptora`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidadreceptora`
--

LOCK TABLES `unidadreceptora` WRITE;
/*!40000 ALTER TABLE `unidadreceptora` DISABLE KEYS */;
/*!40000 ALTER TABLE `unidadreceptora` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-08 13:19:39
