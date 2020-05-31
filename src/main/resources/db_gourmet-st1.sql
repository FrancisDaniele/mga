CREATE DATABASE  IF NOT EXISTS `db_gourmet` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_gourmet`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: db_gourmet
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `cat_id` int(11) NOT NULL AUTO_INCREMENT,
  `cat_nombre` varchar(45) NOT NULL,
  `cat_descripcion` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`cat_id`),
  UNIQUE KEY `cat_nombre_UNIQUE` (`cat_nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Mediterranea',NULL),(2,'China',NULL),(3,'Japonesa',NULL),(4,'Mexicana',NULL),(5,'Italiana',NULL),(6,'Pizzeria',NULL),(7,'Carne',NULL);
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localidades`
--

DROP TABLE IF EXISTS `localidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `localidades` (
  `loc_id` int(11) NOT NULL AUTO_INCREMENT,
  `loc_nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`loc_id`),
  UNIQUE KEY `loc_nombre_UNIQUE` (`loc_nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localidades`
--

LOCK TABLES `localidades` WRITE;
/*!40000 ALTER TABLE `localidades` DISABLE KEYS */;
INSERT INTO `localidades` VALUES (2,'Marratxí'),(1,'Palma de Mallorca');
/*!40000 ALTER TABLE `localidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opiniones`
--

DROP TABLE IF EXISTS `opiniones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `opiniones` (
  `opi_id` int(11) NOT NULL AUTO_INCREMENT,
  `opi_res_id` int(11) NOT NULL,
  `opi_usu_id` int(11) NOT NULL,
  `opi_puntuacion` double NOT NULL,
  `opi_opinion` varchar(140) DEFAULT NULL,
  `opi_fecha` date DEFAULT NULL,
  PRIMARY KEY (`opi_id`),
  KEY `opi_usu_id_FK_idx` (`opi_usu_id`),
  KEY `opi_res_id_FK_idx` (`opi_res_id`),
  CONSTRAINT `opi_res_id_FK` FOREIGN KEY (`opi_res_id`) REFERENCES `restaurantes` (`res_id`),
  CONSTRAINT `opi_usu_id_FK` FOREIGN KEY (`opi_usu_id`) REFERENCES `usuarios` (`usu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opiniones`
--

LOCK TABLES `opiniones` WRITE;
/*!40000 ALTER TABLE `opiniones` DISABLE KEYS */;
/*!40000 ALTER TABLE `opiniones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurantes`
--

DROP TABLE IF EXISTS `restaurantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurantes` (
  `res_id` int(11) NOT NULL AUTO_INCREMENT,
  `res_nombre` varchar(20) NOT NULL,
  `res_direccion` varchar(45) NOT NULL,
  `res_puntuacion` double DEFAULT NULL,
  `res_votaciones` int(11) DEFAULT NULL,
  `res_descripcion` varchar(280) NOT NULL,
  `res_cat_id` int(11) DEFAULT NULL,
  `res_loc_id` int(11) DEFAULT '1',
  PRIMARY KEY (`res_id`),
  KEY `res_cat_FK_idx` (`res_cat_id`),
  KEY `res_loc_FK_idx` (`res_loc_id`),
  CONSTRAINT `res_cat_FK` FOREIGN KEY (`res_cat_id`) REFERENCES `categorias` (`cat_id`),
  CONSTRAINT `res_loc_FK` FOREIGN KEY (`res_loc_id`) REFERENCES `localidades` (`loc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurantes`
--

LOCK TABLES `restaurantes` WRITE;
/*!40000 ALTER TABLE `restaurantes` DISABLE KEYS */;
INSERT INTO `restaurantes` VALUES (1,'prueba','prueba',2.5,2,'prueba',1,1),(2,'mae','mae',2.5,-2,'jjdjdk',1,1),(3,'fd','ga',0,0,'bc',1,1),(4,'El tanos','asdf',1,1,'afsdf',1,1),(5,'El PIJO','asdf',1,1,'afsdf',2,2),(7,'Pizzeria -japones','caller mor',10,2,'muy bueno',3,2);
/*!40000 ALTER TABLE `restaurantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `usu_id` int(11) NOT NULL,
  `usu_nombre` varchar(20) NOT NULL,
  `usu_apellido1` varchar(20) NOT NULL,
  `usu_apellido2` varchar(20) DEFAULT NULL,
  `usu_email` varchar(45) NOT NULL,
  `usu_password` varchar(45) NOT NULL,
  PRIMARY KEY (`usu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (0,'admin','admin','admin','fdj00@iesemilidarder.con','31416'),(1,'fran','d','j','fdfrancisdaniele@gmail.com','1234'),(2,'yo','yo','yo','yo@mail.com','1111');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-25 17:51:12
