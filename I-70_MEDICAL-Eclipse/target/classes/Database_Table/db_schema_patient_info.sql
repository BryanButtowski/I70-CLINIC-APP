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
-- Table structure for table `patient_info`
--

DROP TABLE IF EXISTS `patient_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_info` (
  `patient_ssn` char(10) NOT NULL,
  `registration_date` date NOT NULL,
  `prev_physician` varchar(50) DEFAULT NULL,
  `p_lastname` varchar(45) NOT NULL,
  `p_firstname` varchar(45) NOT NULL,
  `p_middlename` varchar(45) DEFAULT NULL,
  `p_honorifics` varchar(30) NOT NULL,
  `p_birthdate` date NOT NULL,
  `p_age` int NOT NULL,
  `p_gender` varchar(6) NOT NULL,
  `p_maritalstatus` varchar(10) NOT NULL,
  `p_homePN` varchar(12) DEFAULT NULL,
  `p_workPN` varchar(12) DEFAULT NULL,
  `p_cellPN` varchar(12) NOT NULL,
  `p_street_brgy` varchar(30) NOT NULL,
  `p_city` varchar(30) NOT NULL,
  `p_region` varchar(30) NOT NULL,
  `p_zipcode` char(4) NOT NULL,
  `p_POBox` varchar(30) DEFAULT NULL,
  `p_province` varchar(30) NOT NULL,
  `p_ethnicity` varchar(30) DEFAULT NULL,
  `p_race` varchar(30) NOT NULL,
  `p_occupation` varchar(50) NOT NULL,
  `p_employer` varchar(50) NOT NULL,
  `p_employerPN` varchar(12) NOT NULL,
  `EC_name` varchar(100) NOT NULL,
  `E2P_relation` varchar(20) NOT NULL,
  `EC_PN` varchar(12) NOT NULL,
  `patient_guardian_authorization` varchar(3) NOT NULL,
  PRIMARY KEY (`patient_ssn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_info`
--

LOCK TABLES `patient_info` WRITE;
/*!40000 ALTER TABLE `patient_info` DISABLE KEYS */;
INSERT INTO `patient_info` VALUES ('1122334455','2025-06-18','Dr. Ramon Bautista','Almario','Ricardo','Villanueva','Mr','1999-06-30',25,'Male','Married','0277112233','0277998844','09195557777','789 San Miguel Street','Pasay City','NCR','1700','','Metro Manila','Kapampangan','Filipino','Professional Basketball Player','Los Angeles Lakers','0212345678','Maribel Villanueva Almario','Spouse','09178889900','Yes'),('1234567890','2025-06-18','Dr. Jose Rizal','Dela Cruz','Juan','Santos','Mr','2000-08-23',24,'Male','Single','0278123456','0283123456','09181234567','456 Mabini Street','Quezon City','NCR','1100',' P.O. Box 1121','Metro Manila','Tagalog','Filipino','Call Center Agent','BPO Solutions Inc.','0287654321','Maria Dela Cruz','Mother','09172223333','Yes'),('2345678901','2025-06-18','Dr. Ricardo Flores','Tan','Luis','Manuel','Mr','1989-06-28',35,'Male','Married','0458881234','0458885678','09172345678','456 Fields Avenue','Angeles City','Region III','2009','PO Box 2002','Pampanga','Kapampangan','Filipino-Chinese','Hotel Owner','Clarkview Hotels Group','0458889999','Maria Cristina Tan','Spouse','09231232563','Yes'),('3344556677','2025-06-18','Dr. Roberto Mendoza','Reyes','Andrea','Santos','Mrs','1995-04-02',30,'Female','Married','0279776655','0279443322','09176543210','456 Lipa City Avenue','Lipa City','CALABARZON','4220','PO Box 5678','Batangas','Tagalog','Filipino','Hospital Registrar','Lipa City Medical Center','0288776655','Carlos Reyes','Husband','09178889900','Yes'),('3456789012','2025-06-18','Dr. Maricel Rivera','Santos','Maria','Teresa','Mrs','1990-10-21',34,'Female','Married','0468881111','0468882222','09173456789','789 Anabu Coast Subdivision','Imus City','CALABARZON','4103','PO Box 3003','Cavite','Tagalog','Filipino','College Professor','De La Salle University-Dasmarinas','0468883333','Roberto Santos','Spouse','09123654789','Yes'),('4455667788','2025-06-18','Dr. Maria Santos','Dela Cruz','Maria','Magdalena','Ms','1975-05-01',59,'Female','Single','0279887766','0279554433','09187654321','123 Batangas Street','Batangas City','CALABARZON','4200','PO Box 1234','Batangas','Tagalog','Filipino','Video Editor','NBA','0288998877','Juan Dela Cruz','Father','09178889999','Yes'),('5544332211','2025-06-18','Dr. Lourdes Gomez','Almario','Emilio','Francisco','Mr','1998-12-31',26,'Male','Single','0277223344','0288556677','09223334455','101 Apalit Road','San Fernando','Region III','2000','P.O 2014','Pampanga','Kapampangan','Filipino','Hospital Registrar','Pampanga Medical Center','0459876543','Ricardo Almario','Brother','09195557777','Yes'),('5566778899','2025-06-18','','Reyes','Kevin','Trex','Mr','1995-06-04',30,'Male','Single','0279001234','0279112233','09191234567','321 Katipunan Avenue','Caloocan City','NCR','1400','','Metro Manila','Tagalog','Filipino','Call Center Agent','VoiceHub Philippines Inc.','0288123456','Ana Reyes','Sister','09179990000','Yes'),('9988776655','2025-06-18','Dr. Alejandro Ramos','Cabrera','Jayson','Gomez','Mr','1993-01-12',32,'Male','Single','0278001122','0278003344','09192345678','456 Malvar Street','Marikina City','NCR','1800','','Metro Manila','Ilocano','Filipino','Professional Basketball Player','Miami Heat','0200111222','Miguel Cabrera','Brother','09197776655','Yes');
/*!40000 ALTER TABLE `patient_info` ENABLE KEYS */;
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
