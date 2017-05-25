-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: dbcomissoes
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.21-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbcomissao`
--

DROP TABLE IF EXISTS `tbcomissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbcomissao` (
  `data_comissao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `loja` varchar(20) NOT NULL,
  `mes` varchar(20) NOT NULL,
  `ano` varchar(15) DEFAULT NULL,
  `valor` decimal(10,2) NOT NULL,
  `iduser` int(11) NOT NULL,
  KEY `iduser` (`iduser`),
  CONSTRAINT `tbcomissao_ibfk_1` FOREIGN KEY (`iduser`) REFERENCES `tbusuarios` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbcomissao`
--

LOCK TABLES `tbcomissao` WRITE;
/*!40000 ALTER TABLE `tbcomissao` DISABLE KEYS */;
INSERT INTO `tbcomissao` VALUES ('2017-05-25 17:09:54','1 - Candelária','Fevereiro','2017',4444.00,1),('2017-05-25 17:26:11','1 - Candelária','Fevereiro','2017',4444.00,1),('2017-05-25 17:26:22','1 - Candelária','Fevereiro','2017',4444.00,1),('2017-05-25 17:26:29','1 - Candelária','Fevereiro','2017',4444.00,1),('2017-05-25 17:27:04','1 - Candelária','Fevereiro','2017',4444.00,1),('2017-05-25 17:29:04','1 - Candelária','Fevereiro','2017',4444.00,1);
/*!40000 ALTER TABLE `tbcomissao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-25 15:29:50
