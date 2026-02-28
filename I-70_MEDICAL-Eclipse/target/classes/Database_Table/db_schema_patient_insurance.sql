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
-- Table structure for table `patient_insurance`
--

DROP TABLE IF EXISTS `patient_insurance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_insurance` (
  `patient_ssn` char(10) NOT NULL,
  `subscriber_ssn` char(10) NOT NULL,
  `insurance_code` int NOT NULL,
  `S2P_relation` varchar(20) NOT NULL,
  PRIMARY KEY (`insurance_code`,`subscriber_ssn`,`patient_ssn`),
  KEY `insurance_code_pi_idx` (`insurance_code`),
  KEY `subscriber_ssn_pi_idx` (`subscriber_ssn`),
  KEY `patient_ssn_pi_idx` (`patient_ssn`),
  CONSTRAINT `insurance_code_pi` FOREIGN KEY (`insurance_code`) REFERENCES `insurance_name` (`insurance_code`),
  CONSTRAINT `patient_ssn_pi` FOREIGN KEY (`patient_ssn`) REFERENCES `patient_info` (`patient_ssn`),
  CONSTRAINT `subscriber_ssn_pi` FOREIGN KEY (`subscriber_ssn`) REFERENCES `subscriber_info` (`subscriber_ssn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_insurance`
--

LOCK TABLES `patient_insurance` WRITE;
/*!40000 ALTER TABLE `patient_insurance` DISABLE KEYS */;
INSERT INTO `patient_insurance` VALUES ('9988776655','1233211234',1,'Mother'),('1234567890','1234567890',1,'Self'),('2345678901','2345678901',1,'Self'),('3344556677','3344556677',1,'Self'),('1122334455','5544332211',1,'Brother'),('5544332211','5544332211',1,'Self'),('5566778899','6677889900',1,'Sister'),('4455667788','4455667788',2,'Self'),('3456789012','4567890123',2,'Spouse'),('1234567890','0987654321',3,'Aunt'),('3456789012','3456789012',3,'Self'),('3344556677','4455667788',3,'Spouse'),('4455667788','4455667788',3,'Self'),('5566778899','5566778899',3,'Self'),('1122334455','1122334455',4,'Self'),('5544332211','1234432112',5,'Mother'),('9988776655','9988776655',6,'Self'),('2345678901','2345678901',7,'Self');
/*!40000 ALTER TABLE `patient_insurance` ENABLE KEYS */;
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
