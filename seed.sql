-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: tim3
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
-- Table structure for table `artikal`
--

DROP TABLE IF EXISTS tim3.artikal;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE tim3.artikal (
  `ARTIKAL_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `BARKOD` varchar(255) DEFAULT NULL,
  `NAZIV` varchar(255) DEFAULT NULL,
  `JEDINICNA_KOLICINA` double DEFAULT NULL,
  `MJERNA_JEDINICA` int(11) DEFAULT NULL,
  `PRODAJNA_CIJENA` double DEFAULT NULL,
  PRIMARY KEY (`ARTIKAL_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artikal`
--

LOCK TABLES tim3.artikal WRITE;
/*!40000 ALTER TABLE tim3.artikal DISABLE KEYS */;
INSERT INTO tim3.artikal VALUES (1,'1234567890001','Mlijeko',1,2,1.17),(2,'1234567890002','Brasno',1,0,1.34),(3,'1234567890003','Cokolada',100,1,0.99),(4,'1234567890004','So',1,0,0.88),(5,'1234567890005','Secer',1,0,1.03),(6,'1234567890006','Riza',1,0,2.15),(7,'1234567890007','Ulje',1,2,1.95),(8,'1234567890008','Kafa',1,0,3.4),(9,'1234567890009','Jogurt',1,2,1.75),(10,'1234567890010','Sijalica',1,4,0.35);
/*!40000 ALTER TABLE tim3.artikal ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dokument`
--

DROP TABLE IF EXISTS tim3.dokument;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE tim3.dokument (
  `DOKUMENT_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DISCRIMINATOR` varchar(255) NOT NULL,
  `DATUM` datetime DEFAULT NULL,
  `KREIRAO_ID` bigint(20) DEFAULT NULL,
  `SKLADISTE_ID` bigint(20) DEFAULT NULL,
  `BARKOD` varchar(255) DEFAULT NULL,
  `DOBAVALJC_ID` bigint(20) DEFAULT NULL,
  `RAZLOG_OTPISA` varchar(255) DEFAULT NULL,
  `KUPAC_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`DOKUMENT_ID`),
  KEY `FKk1s7ndaihjmlnngjql90xq9l7` (`KREIRAO_ID`),
  KEY `FKlxsojo71x41yvkuvw0mwa57rg` (`SKLADISTE_ID`),
  KEY `FKoofvgmaq7ako7pupo8awwl7j1` (`DOBAVALJC_ID`),
  KEY `FKp06e5libymeryoumobgm30irg` (`KUPAC_ID`),
  CONSTRAINT `FKk1s7ndaihjmlnngjql90xq9l7` FOREIGN KEY (`KREIRAO_ID`) REFERENCES tim3.uposlenik (`UPOSLENIK_ID`),
  CONSTRAINT `FKlxsojo71x41yvkuvw0mwa57rg` FOREIGN KEY (`SKLADISTE_ID`) REFERENCES tim3.skladiste (`SKLADISTE_ID`),
  CONSTRAINT `FKoofvgmaq7ako7pupo8awwl7j1` FOREIGN KEY (`DOBAVALJC_ID`) REFERENCES tim3.poslovni_partner (`POSLOVNI_PARTNER_ID`),
  CONSTRAINT `FKp06e5libymeryoumobgm30irg` FOREIGN KEY (`KUPAC_ID`) REFERENCES tim3.poslovni_partner (`POSLOVNI_PARTNER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dokument`
--

LOCK TABLES tim3.dokument WRITE;
/*!40000 ALTER TABLE tim3.dokument DISABLE KEYS */;
INSERT INTO tim3.dokument VALUES (1,'NAB','2016-05-13 00:00:00',1,1,'0123456789001',1,NULL,NULL),(2,'NAB','2016-05-13 00:00:00',2,2,'0123456789002',1,NULL,NULL),(3,'NAB','2016-05-13 00:00:00',5,3,'0123456789003',2,NULL,NULL);
/*!40000 ALTER TABLE tim3.dokument ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poslovni_partner`
--

DROP TABLE IF EXISTS tim3.poslovni_partner;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE tim3.poslovni_partner (
  `POSLOVNI_PARTNER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `JIB` varchar(255) DEFAULT NULL,
  `NAZIV` varchar(255) DEFAULT NULL,
  `ADRESA` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`POSLOVNI_PARTNER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poslovni_partner`
--

LOCK TABLES tim3.poslovni_partner WRITE;
/*!40000 ALTER TABLE tim3.poslovni_partner DISABLE KEYS */;
INSERT INTO tim3.poslovni_partner VALUES (1,'123456789012','API','Neka adresa'),(2,'123456789013','MS','Neka adresa 42'),(3,'123456789014','ETF','Neka adresa 42'),(4,'123456789015','MIT','Neka adresa 42'),(5,'123456789016','Cenga d.o.o','Neka adresa 42');
/*!40000 ALTER TABLE tim3.poslovni_partner ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skladiste`
--

DROP TABLE IF EXISTS tim3.skladiste;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE tim3.skladiste (
  `SKLADISTE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ADRESA` varchar(255) DEFAULT NULL,
  `KONTAKT_TELEFON` varchar(255) DEFAULT NULL,
  `NAZIV` varchar(255) DEFAULT NULL,
  `RADNO_VRIJEME_OD` int(11) DEFAULT NULL,
  `RADNO_VRIJEME_DO` int(11) DEFAULT NULL,
  PRIMARY KEY (`SKLADISTE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skladiste`
--

LOCK TABLES tim3.skladiste WRITE;
/*!40000 ALTER TABLE tim3.skladiste DISABLE KEYS */;
INSERT INTO tim3.skladiste VALUES (1,'Neka adresa 22','033-123-456','Skladište Sarajevo',800,1700),(2,'Tuzlanska bb','035-456-367','Skladište Tuzla',800,1700),(3,'Mostarska 37','036-571-361','Skladište Mostar',900,1800);
/*!40000 ALTER TABLE tim3.skladiste ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skladiste_artikal`
--

DROP TABLE IF EXISTS tim3.skladiste_artikal;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE tim3.skladiste_artikal (
  `SKLADISTE_ARTIKAL_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ARTIKAL_ID` bigint(20) DEFAULT NULL,
  `SKLADISTE_ID` bigint(20) DEFAULT NULL,
  `PONDERIRANA_CIJENA` double DEFAULT NULL,
  `KOLICINA` int(11) DEFAULT NULL,
  PRIMARY KEY (`SKLADISTE_ARTIKAL_ID`),
  KEY `FK2utemat3yr7kvvlvruoli36r2` (`ARTIKAL_ID`),
  KEY `FKr06q4gv747qwhrrt38q6v9uvb` (`SKLADISTE_ID`),
  CONSTRAINT `FK2utemat3yr7kvvlvruoli36r2` FOREIGN KEY (`ARTIKAL_ID`) REFERENCES tim3.artikal (`ARTIKAL_ID`),
  CONSTRAINT `FKr06q4gv747qwhrrt38q6v9uvb` FOREIGN KEY (`SKLADISTE_ID`) REFERENCES tim3.skladiste (`SKLADISTE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skladiste_artikal`
--

LOCK TABLES tim3.skladiste_artikal WRITE;
/*!40000 ALTER TABLE tim3.skladiste_artikal DISABLE KEYS */;
INSERT INTO tim3.skladiste_artikal VALUES (1,1,1,1.17,10),(2,2,1,1.34,1000),(3,3,2,0.99,50),(4,4,3,0.88,5000),(5,5,3,1.03,5000),(6,6,2,2.15,500),(7,7,1,1.95,750),(8,8,2,3.4,230),(9,9,1,1.75,400),(10,10,1,0.35,1000);
/*!40000 ALTER TABLE tim3.skladiste_artikal ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stavka_dokumenta`
--

DROP TABLE IF EXISTS tim3.stavka_dokumenta;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE tim3.stavka_dokumenta (
  `STAVKA_DOKUMENTA_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ARTIKAL_ID` bigint(20) DEFAULT NULL,
  `DOKUMENT_ID` bigint(20) DEFAULT NULL,
  `KOLICINA` int(11) DEFAULT NULL,
  `CIJENA` double DEFAULT NULL,
  PRIMARY KEY (`STAVKA_DOKUMENTA_ID`),
  KEY `FKovgsv2vcw35y9khoqb1qihgmy` (`ARTIKAL_ID`),
  KEY `FKjsl9yyhj6u82g586p658kgddh` (`DOKUMENT_ID`),
  CONSTRAINT `FKjsl9yyhj6u82g586p658kgddh` FOREIGN KEY (`DOKUMENT_ID`) REFERENCES tim3.dokument (`DOKUMENT_ID`),
  CONSTRAINT `FKovgsv2vcw35y9khoqb1qihgmy` FOREIGN KEY (`ARTIKAL_ID`) REFERENCES tim3.artikal (`ARTIKAL_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stavka_dokumenta`
--

LOCK TABLES tim3.stavka_dokumenta WRITE;
/*!40000 ALTER TABLE tim3.stavka_dokumenta DISABLE KEYS */;
INSERT INTO tim3.stavka_dokumenta VALUES (1,1,1,100,1.17),(2,2,1,1000,1.34),(3,7,1,750,1.95),(4,9,1,400,1.75),(5,10,1,1000,0.35),(6,3,2,50,0.99),(7,6,2,500,2.15),(8,8,2,230,3.4),(9,4,3,5000,0.88),(10,5,3,5000,1.03);
/*!40000 ALTER TABLE tim3.stavka_dokumenta ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uposlenik`
--

DROP TABLE IF EXISTS tim3.uposlenik;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE tim3.uposlenik (
  `UPOSLENIK_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `IME` varchar(255) DEFAULT NULL,
  `PREZIME` varchar(255) DEFAULT NULL,
  `JMBG` varchar(255) DEFAULT NULL,
  `DATUM_RODJENJA` datetime DEFAULT NULL,
  `MJESTO_RODJENJA` varchar(255) DEFAULT NULL,
  `ADRESA_STANOVANJA` varchar(255) DEFAULT NULL,
  `BROJ_TELEFONA` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `STRUCNA_SPREMA` int(11) DEFAULT NULL,
  `DATUM_ZAPOSLENJA` datetime DEFAULT NULL,
  `USER` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `TIP_UPOSLENIKA` int(11) DEFAULT NULL,
  `SKLADISTE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`UPOSLENIK_ID`),
  KEY `FK1sua90e1qntf664y698v5jhfc` (`SKLADISTE_ID`),
  CONSTRAINT `FK1sua90e1qntf664y698v5jhfc` FOREIGN KEY (`SKLADISTE_ID`) REFERENCES tim3.skladiste (`SKLADISTE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uposlenik`
--

LOCK TABLES tim3.uposlenik WRITE;
/*!40000 ALTER TABLE tim3.uposlenik DISABLE KEYS */;
INSERT INTO tim3.uposlenik VALUES (1,'Menadzer','Menadzer','1111111111111','1993-08-17 00:00:00','Sarajevo','Moja adresa 11','061236871','menadzer@etf.unsa.ba',5,'2012-11-21 00:00:00','menadzer','81dc9bdb52d04dc20036dbd8313ed055',0,1),(2,'Uposlenik','Uposlenik','2222222222222','1993-08-17 00:00:00','Sarajevo','Moja adresa 11','061236871','uposlenik@etf.unsa.ba',5,'2012-11-21 00:00:00','uposlenik','81dc9bdb52d04dc20036dbd8313ed055',1,1),(3,'Džemal','Čengić','1234567890147','1993-08-17 00:00:00','Sarajevo','Moja adresa 11','061236871','dcengic2@etf.unsa.ba',5,'2012-11-21 00:00:00','dcenga','81dc9bdb52d04dc20036dbd8313ed055',0,1),(4,'Mirzet','Brkic','1234567893689','1994-02-21 00:00:00','Velika Kladusa','Moja adresa 11','061236871','mbrkic@etf.unsa.ba',6,'2013-05-07 00:00:00','mbrkic','81dc9bdb52d04dc20036dbd8313ed055',0,2),(5,'Naida','Congo','0369852147963','1994-05-02 00:00:00','Sarajevo','Moja adresa 11','061478366','ncongo@etf.unsa.ba',3,'2013-07-09 00:00:00','ncongo','81dc9bdb52d04dc20036dbd8313ed055',1,1),(6,'Nino','Corovic','7896325410361','1995-01-25 00:00:00','Tuzla','Moja adresa 11','061478366','ncorovic@etf.unsa.ba',3,'2015-01-09 00:00:00','ncorovic','81dc9bdb52d04dc20036dbd8313ed055',1,2),(7,'Nermin','Boja','1236547896321','1993-07-28 00:00:00','Mostar','Moja adresa 11','062654712','nboja@etf.unsa.ba',4,'2015-01-09 00:00:00','nboja','81dc9bdb52d04dc20036dbd8313ed055',0,3),(8,'Lejla','Bajgoric','3698523698521','1994-02-01 00:00:00','Mostar','Moja adresa 11','062654712','lbajgoric@etf.unsa.ba',2,'2015-01-09 00:00:00','lbajgoric','81dc9bdb52d04dc20036dbd8313ed055',1,3);
/*!40000 ALTER TABLE tim3.uposlenik ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-15 13:50:18
