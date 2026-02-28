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
-- Table structure for table `hipaa_info`
--

DROP TABLE IF EXISTS `hipaa_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hipaa_info` (
  `patient_ssn` char(10) NOT NULL,
  `HIPAA_name` varchar(100) NOT NULL,
  `HIPAA_PN` varchar(12) NOT NULL,
  `HIPAA2P_relation` varchar(20) NOT NULL,
  PRIMARY KEY (`patient_ssn`,`HIPAA_name`),
  CONSTRAINT `patient_ssn_h` FOREIGN KEY (`patient_ssn`) REFERENCES `patient_info` (`patient_ssn`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hipaa_info`
--

LOCK TABLES `hipaa_info` WRITE;
/*!40000 ALTER TABLE `hipaa_info` DISABLE KEYS */;
INSERT INTO `hipaa_info` VALUES ('1122334455','Emilio Almario','09173334444','Brother'),('1122334455','Ricardo V. Almario','09195557777','Self'),('1234567890','Ana Santos','09176667777','Aunt'),('1234567890','Juan Santos Dela Cruz','09181234567','Self'),('2345678901','Luis M. Tan','09172345678','Self'),('2345678901','Maria Cristina Tan','09231232563','Spouse'),('3344556677','Andrea S. Reyes','09176543210','Self'),('3344556677','Carlos Reyes','09178889900','Spouse'),('3456789012','Maria T. Santos','09173456789','Self'),('3456789012','Roberto Santos','09123654789','Spouse'),('4455667788','Juan Dela Cruz','09178889999','Father'),('4455667788','Maria M. Dela Cruz','09187654321','Self'),('5544332211','Emilio F. Almario','09223334455','Self'),('5544332211','Luz Almario','09179998888','Mother'),('5566778899','Ana Reyes','09179990000','Sister'),('5566778899','Kevin T. Reyes','09191234567','Self'),('9988776655','Alma Gomez','09198887777','Mother'),('9988776655','Jayson G. Cabrera','09192345678','Self');
/*!40000 ALTER TABLE `hipaa_info` ENABLE KEYS */;
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
