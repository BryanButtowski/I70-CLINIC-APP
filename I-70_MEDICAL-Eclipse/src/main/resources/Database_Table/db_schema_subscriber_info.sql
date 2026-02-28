-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_schema
-- ------------------------------------------------------
-- Server version	9.3.0

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
-- Table structure for table `subscriber_info`
--

DROP TABLE IF EXISTS `subscriber_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscriber_info` (
  `subscriber_ssn` char(10) NOT NULL,
  `subscriber_name` varchar(100) NOT NULL,
  `subscriber_birthdate` date NOT NULL,
  `subscriber_gender` varchar(6) NOT NULL,
  `subscriber_employer` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`subscriber_ssn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscriber_info`
--

LOCK TABLES `subscriber_info` WRITE;
/*!40000 ALTER TABLE `subscriber_info` DISABLE KEYS */;
INSERT INTO `subscriber_info` VALUES ('0234567891','Maria Reyes Santos','1992-06-18','Female','ABC Technologies Inc'),('0987654321','Ana Santos','1979-06-18','Female','St. Luke\'s Medical Center'),('1122334455','Ricardo V. Almario','1999-06-30','Male','Los Angeles Firehawks'),('1233211234','Alma Gomez','1960-01-03','Female','DepEd Manila'),('1234432112','Luz Almario','1965-06-11','Female','DepEd Pampanga'),('1234567890','Juan Santos Dela Cruz','2000-08-23','Male','BPO Solutions Inc.'),('1234567898','Juan Santos Dela Cruz','1995-03-03','Male','Goldman Sachs Philippines'),('2023051610','Kerby Bryan Correa','2005-05-01','Male','ABC Farm'),('2023051611','Analee S. Correa','1980-07-17','Female',''),('2345678901','Luis M. Tan','1989-06-28','Male','Clarkview Hotels Group'),('3344556677','Andrea S. Reyes','1995-04-02','Female','Lipa City Medical Center'),('3456789012','Maria T. Santos','1990-10-21','Female','DLSU-Dasmarinas'),('4455667788','Maria M. Dela Cruz','1969-05-01','Female','NBA'),('4567890123','Roberto Santos','1991-01-01','Male','SM City Dasmarinas'),('5544332211','Emilio Almario','1998-12-31','Male','Almario Construction Supply'),('5566778811','Miguel S. Reyes','2000-09-25','Male','San Pablo City General Hospital'),('5566778899','Kevin Reyes','1995-06-04','Male','VoiceHub Philippines Inc.'),('6677889900','Ana Reyes','2000-03-01','Female','DepEd Caloocan'),('9876543210','Carmen Reyes','1980-05-05','Female','DEF Corporation'),('9988776655','Jayson G. Cabrera','1993-01-12','Male','Miami Dragons');
/*!40000 ALTER TABLE `subscriber_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-20 15:54:40
