CREATE DATABASE  IF NOT EXISTS `booklikes` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `booklikes`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: booklikes
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `libros`
--

DROP TABLE IF EXISTS `libros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libros` (
  `idlibro` int NOT NULL AUTO_INCREMENT,
  `autor` varchar(45) DEFAULT NULL,
  `titulo` varchar(45) DEFAULT NULL,
  `fecha_cracion` datetime DEFAULT CURRENT_TIMESTAMP,
  `descripcion` varchar(200) DEFAULT NULL,
  `id_usuario` int NOT NULL,
  PRIMARY KEY (`idlibro`),
  UNIQUE KEY `titulo_UNIQUE` (`titulo`),
  KEY `fk_libros_usuarios1_idx` (`id_usuario`),
  CONSTRAINT `fk_libros_usuarios1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libros`
--

LOCK TABLES `libros` WRITE;
/*!40000 ALTER TABLE `libros` DISABLE KEYS */;
INSERT INTO `libros` VALUES (1,'Gabriel García Márquez','100 años de soledad','2024-03-04 19:11:34','Familias a lo largo de la historia de colombia',1),(2,'Cervantes','Don quijote','2024-03-04 19:11:34','Historias de un hidalgo y su escudero ',2),(3,'Tolkien','El señor de los anillos','2024-03-04 19:11:34','La tierra media',3),(4,'El retrato de Dorian Gray','Oscar Wilde','2024-03-04 19:11:34','Historia de la juventud',4);
/*!40000 ALTER TABLE `libros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libros_favoritos`
--

DROP TABLE IF EXISTS `libros_favoritos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libros_favoritos` (
  `id_favorito` int NOT NULL AUTO_INCREMENT,
  `idlibro` int DEFAULT NULL,
  `idusuario` int DEFAULT NULL,
  `fecha_favorito` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_favorito`),
  KEY `fk_libros_has_usuarios_usuarios1_idx` (`idusuario`),
  KEY `fk_libros_has_usuarios_libros_idx` (`idlibro`),
  CONSTRAINT `fk_libros_has_usuarios_libros` FOREIGN KEY (`idlibro`) REFERENCES `libros` (`idlibro`),
  CONSTRAINT `fk_libros_has_usuarios_usuarios1` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libros_favoritos`
--

LOCK TABLES `libros_favoritos` WRITE;
/*!40000 ALTER TABLE `libros_favoritos` DISABLE KEYS */;
INSERT INTO `libros_favoritos` VALUES (1,1,3,'2024-03-04 19:12:23'),(2,2,2,'2024-03-04 19:12:23'),(3,3,1,'2024-03-04 19:12:23'),(4,4,4,'2024-03-04 19:12:23'),(5,2,3,'2024-03-04 19:12:23'),(6,1,4,'2024-03-04 19:12:23');
/*!40000 ALTER TABLE `libros_favoritos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idusuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Pablo ','1234'),(2,'Luci','4567'),(3,'Ricardo','7891'),(4,'Gabriel','2345');
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

-- Dump completed on 2024-03-04 19:27:29
