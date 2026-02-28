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
-- Table structure for table `billhandler_info`
--

DROP TABLE IF EXISTS `billhandler_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `billhandler_info` (
  `billhandler_id` int NOT NULL AUTO_INCREMENT,
  `BH_name` varchar(100) NOT NULL,
  `BH_birthdate` date NOT NULL,
  `BH_address` varchar(100) NOT NULL,
  `BH_PN` varchar(12) NOT NULL,
  `BH_occupation` varchar(50) NOT NULL,
  `BH_employer` varchar(50) DEFAULT NULL,
  `BH_employerAddress` varchar(100) DEFAULT NULL,
  `BH_employerPN` varchar(12) DEFAULT NULL,
  `patient_ssn` char(10) NOT NULL,
  PRIMARY KEY (`billhandler_id`),
  KEY `patient_ssn_bh_idx` (`patient_ssn`),
  CONSTRAINT `patient_ssn_bh` FOREIGN KEY (`patient_ssn`) REFERENCES `patient_info` (`patient_ssn`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billhandler_info`
--

LOCK TABLES `billhandler_info` WRITE;
/*!40000 ALTER TABLE `billhandler_info` DISABLE KEYS */;
INSERT INTO `billhandler_info` VALUES (2,'Ana Santos','2000-06-18','789 Katipunan Ave, Quezon City','09176667777','Nurse','St. Luke\'s Medical Center','E. Rodriguez Sr. Ave, Quezon City','0276543210','1234567890'),(3,'Emilio Almario','1998-12-31','123 Balagtas St, San Fernando, Pampanga','09173334444','Business Owner','Almario Construction Supply','San Fernando, Pampanga','0458887766','1122334455'),(4,'Luz Almario','2007-06-18','456 Rizal St, Apalit, Pampanga','09179998888','Retired Teacher','DepEd Pampanga','Apalit, Pampanga','0458123456','5544332211'),(5,'Daniel Robles','1999-03-03','789 Gen. Luna St, San Juan City','09221114455','Billing Officer','St. Jude Hospital','St. Jude Hospital, Manila','0255123456','9988776655'),(6,'Ana Reyes','2000-03-01','321 Katipunan Avenue, Caloocan City','09179990000','Public School Teacher','DepEd Caloocan','Caloocan City','0288345678','5566778899'),(7,'Juan Dela Cruz','1958-02-01','123 Batangas Street, Batangas City','09178889999','Retired','','','','4455667788'),(8,'Carlos Reyes','1996-12-24','456 Lipa City Avenue, Lipa City','09178889900','Medical Administrator','St. Jude Hospital','Lipa City, Batangas','0288665544','3344556677'),(11,'Maria Cristina Tan','1990-04-01','456 Fields Avenue, Angeles City','09170001111','Accountant','Tan Accounting Firm','','','2345678901'),(12,'Roberto Santos','1991-01-01','789 Anabu Coast, Imus City','09172223333','Mall Operations Manager','SM Supermalls','','','3456789012');
/*!40000 ALTER TABLE `billhandler_info` ENABLE KEYS */;
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
