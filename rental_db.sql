CREATE DATABASE  IF NOT EXISTS `rental_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `rental_db`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: rental_db
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `property`
--

DROP TABLE IF EXISTS `property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `property` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `streetAddress` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zipCode` varchar(45) DEFAULT NULL,
  `numberOfUnits` int(11) DEFAULT NULL,
  `managerId` int(11) DEFAULT NULL,
  `ownerId` int(11) DEFAULT NULL,
  `openUnits` int(11) DEFAULT NULL,
  `occupiedUnits` int(11) DEFAULT NULL,
  `maintenanceCost` double DEFAULT NULL,
  `currentIncome` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property`
--

LOCK TABLES `property` WRITE;
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
INSERT INTO `property` VALUES (1,'2nd Street Apartments','212 2nd Street','Davenport','Iowa','12354',10,1,1,5,5,100,500),(2,'House','212 W 3rd','Davenport','Iowa','12234',1,1,1,0,1,100,500),(3,'5th Street Apartments','212 5nd Street','Davenport','Iowa','21324',10,1,1,5,5,100,500);
/*!40000 ALTER TABLE `property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `property_photos`
--

DROP TABLE IF EXISTS `property_photos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `property_photos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `propertyId` int(11) DEFAULT NULL,
  `photoFileLocation` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property_photos`
--

LOCK TABLES `property_photos` WRITE;
/*!40000 ALTER TABLE `property_photos` DISABLE KEYS */;
INSERT INTO `property_photos` VALUES (1,1,'C:/propertyPhotos/1.jpg'),(2,2,'C:/propertyPhotos/2.jpg'),(7,4,'C:/propertyPhotos/4.jpg'),(8,5,'C:/propertyPhotos/5.jpg');
/*!40000 ALTER TABLE `property_photos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tenant`
--

DROP TABLE IF EXISTS `tenant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tenant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `unitId` int(11) DEFAULT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `phoneNumber` varchar(20) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `moveInDate` date DEFAULT NULL,
  `leaseExpires` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenant`
--

LOCK TABLES `tenant` WRITE;
/*!40000 ALTER TABLE `tenant` DISABLE KEYS */;
INSERT INTO `tenant` VALUES (1,2,'Brian','Node','563211234','brian@brian.com','2018-01-15','2018-07-15'),(2,3,'John','Doe','123456789','john@doe.com','2018-01-15','2018-07-15'),(3,4,'John','Doe','123456789','john@doe.com','2018-01-15','2018-07-15');
/*!40000 ALTER TABLE `tenant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `units`
--

DROP TABLE IF EXISTS `units`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `units` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `propertyId` int(11) NOT NULL,
  `tenantId` int(11) DEFAULT NULL,
  `bedrooms` int(11) DEFAULT NULL,
  `bathrooms` int(11) DEFAULT NULL,
  `squareFeet` int(11) DEFAULT NULL,
  `unitName` varchar(45) NOT NULL,
  `unitDescription` longtext,
  `unitRent` double DEFAULT NULL,
  `backRent` double DEFAULT NULL,
  `occupied` tinyint(4) DEFAULT NULL,
  `maintenanceNeeded` tinyint(4) DEFAULT NULL,
  `maintenanceDescription` longtext,
  `maintenanceCost` double DEFAULT NULL,
  `depositHeld` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `units`
--

LOCK TABLES `units` WRITE;
/*!40000 ALTER TABLE `units` DISABLE KEYS */;
INSERT INTO `units` VALUES (2,1,1,1,1,600,'10','Apartment 10',500,0,1,0,'None',0,500),(3,1,3,1,1,600,'2','Apartment 2',500,0,1,0,'None',0,500),(4,2,2,1,1,600,'1','212 W 798 St House',800,0,1,0,'None',0,800);
/*!40000 ALTER TABLE `units` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `salt` varchar(15) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'john','8�V��\'�I�����%�?�/�ٸ���.�Wٙ�','aR4X@RFUJi8','Hank','hank@john.com'),(3,'john2','và4á-pD#P¦h�»¥Ú”J‹;öÑ™ÅuÙy;¬Q','ltiG81iov5b','John Doe','john@john.com');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-10 16:25:13
