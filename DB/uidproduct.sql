/*
SQLyog Community Edition- MySQL GUI v5.20
Host - 5.0.45-community-nt : Database - product
*********************************************************************
Server version : 5.0.45-community-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `product`;

USE `product`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `userprorating` */

DROP TABLE IF EXISTS `userprorating`;

CREATE TABLE `userprorating` (
  `uid` int(10) default NULL,
  `product` varchar(255) default NULL,
  `rating` int(10) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `userprorating` */

insert  into `userprorating`(`uid`,`product`,`rating`) values (1,'Lenevo A6000',2),(1,'Lenevo P90',4),(1,'Lenovo A916',3),(1,'Sony Xperia Z3v',4),(1,'Sony Xperia Z3 Tablet Compact',3),(1,'Sony Xperia Z3 Dual',5),(1,'Lenovo Golden Warrior Note 8',3),(1,'Lenovo K3',3),(1,'Lenovo S856',2),(1,'Sony Xperia Z3',1),(1,'Sony Xperia M2 Aqua',2),(1,'Sony Xperia E3 Dual',4),(1,'Sony Xperia E3',3),(1,'Nokia 215',4),(1,'Nokia 215 Dual sim',2),(2,'Sony Xperia Z3',5),(2,'Sony Xperia M2 Aqua',4),(2,'Sony Xperia M2 Dual',5),(2,'Sony Xperia E3',4),(2,'Nokia Lumia 730 Dual sim',5),(2,'Nokia N1',3),(2,'Samsung galaxy A3 Duos',2),(2,'Samsung galaxy core prime',4),(2,'Lenovo Golden Warrior Note 8',3),(2,'Lenovo Vibe X2 Pro',4),(3,'Samsumg galaxy A5',5),(3,'Samsung galaxy core prime',3),(3,'Samsung galaxy E5',1),(3,'Samsung galaxy E7',2),(3,'Nokia 215',5),(3,'Nokia 215 Dual sim',4),(3,'Nokia Lumia 638',3),(3,'nokia Lumia 735',4),(3,'Nokia Lumia 830',5),(3,'Lenevo P90',5),(4,'Samsung galaxy E5',3),(4,'samsung galaxy grand max',2),(4,'Samsung galaxy E7',5),(4,'Lenovo Vibe X2 Pro',1),(4,'Lenovo K3',1),(4,'Lenovo S856',5),(4,'Sony Xperia Z3 Dual',5),(4,'Sony Xperia Z3 Tablet Compact',4),(4,'Nokia Lumia 830',5),(4,'Nokia N1',2),(4,'Nokia Lumia 830',5),(5,'Lenovo K3',3),(5,'Lenovo Golden Warrior Note 8',2),(5,'Lenovo A916',5),(5,'Sony Xperia Z3v',5),(5,'Sony Xperia Z3 Tablet Compact',2),(5,'Sony Xperia Z3 Dual',5),(5,'Lenovo Vibe X2 Pro',3),(5,'Nokia 215',1),(5,'Nokia 215 Dual sim',2),(5,'Samsung galaxy A5 DUOS',4),(5,'Samsung galaxy core prime',5),(6,'Lenevo A6000',4),(6,'Lenovo A916',5),(6,'Lenevo P90',3),(6,'nokia Lumia 735',2),(6,'Nokia Lumia 730 Dual sim',3),(6,'Nokia Lumia 638',5),(6,'Sony Xperia E3',3),(6,'Sony Xperia E3 Dual',2),(6,'Sony Xperia M2 Aqua',1),(6,'Samsung galaxy E7',4),(6,'samsung galaxy grand max',4),(7,'Nokia 215',3),(7,'Nokia 215 Dual sim',2),(7,'Nokia Lumia 638',2),(7,'Sony Xperia Z3 Dual',4),(7,'Sony Xperia Z3 Tablet Compact',5),(7,'Sony Xperia Z3 Dual',4),(7,'Lenevo A6000',4),(7,'Lenevo P90',4),(7,'Lenovo A916',5),(7,'Samsung galaxy A3 Duos',3),(7,'Samsumg galaxy A5',2),(8,'Nokia Lumia 730 Dual sim',3),(8,'samsung galaxy grand max',5),(8,'Sony Xperia Z3 Dual',2),(8,'Sony Xperia Z3v',3),(8,'Samsumg galaxy A5',4),(8,'Nokia N1',2),(8,'Lenovo S856',1),(8,'samsung galaxy grand max',5),(8,'Sony Xperia E3',3),(8,'Sony Xperia E3 Dual',5),(9,'Lenovo Vibe X2 Pro',1),(9,'Lenovo S856',5),(9,'Lenevo A6000',4),(9,'Nokia Lumia 830',2),(9,'nokia Lumia 735',3),(9,'Nokia Lumia 730 Dual sim',5),(9,'Sony Xperia M2 Aqua',3),(9,'Sony Xperia E3 Dual',1),(9,'Lenovo Golden Warrior Note 8',4),(9,'Lenevo A6000',4),(9,'samsung galaxy grand max',4),(10,'Nokia Lumia 638',5),(10,'Nokia 215 Dual sim',4),(10,'Nokia Lumia 730 Dual sim',2),(10,'Sony Xperia Z3v',3),(10,'Sony Xperia Z3 Dual',4),(10,'Lenovo Golden Warrior Note 8',4),(10,'Lenovo K3',3),(10,'Nokia N1',1),(10,'Samsumg galaxy A5',2),(10,'Samsung galaxy E7',1);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
