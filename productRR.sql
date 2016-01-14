/*
SQLyog Community Edition- MySQL GUI v5.20
Host - 5.0.45-community-nt : Database - recommendedsystem
*********************************************************************
Server version : 5.0.45-community-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `recommendedsystem`;

USE `recommendedsystem`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `memory_cards` */

DROP TABLE IF EXISTS `memory_cards`;

CREATE TABLE `memory_cards` (
  `product_name` varchar(50) NOT NULL,
  `memory_size` double default NULL,
  `version` double default NULL,
  `speed` double default NULL,
  `price` double default NULL,
  `rating` varchar(50) default NULL,
  PRIMARY KEY  (`product_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `memory_cards` */

insert  into `memory_cards`(`product_name`,`memory_size`,`version`,`speed`,`price`,`rating`) values ('Dell MicroSDHC 16 GB Class 4',16,2,4,441,'2'),('Dell MicroSDHC 8 GB Class 4',8,2,4,250,'3'),('Kingston MicroSD Card 16 GB Cl',16,1,4,489,'3'),('Kingston MicroSDHC 16 GB Class',16,1,10,410,'5'),('Samsung MB-MSAGB/IN MicroSD 16',16,1,6,518,'4'),('Samsung MicroSDHC 32 GB Class ',32,2,6,921,'4'),('Samsung MicroSDHC 32GB Class 1',32,2,10,1149,'5'),('SanDisk MicroSD Card 32 GB Cla',32,1,4,917,'3'),('Sandisk MicroSDHC 16 GB Class ',16,2,10,610,'5'),('SanDisk MicroSDHC 4 GB',4,2,4,199,'2'),('Sony SDHC 16 GB Class 10',16,2,10,750,'4'),('Sony SDHC 32 GB Class 10',32,2,10,1283,'5'),('Strontium MicroSD Card ',16,1,6,370,'4'),('Strontium MicroSD Card 16 GB C',16,1,10,500,'5'),('Strontium MicroSD Card 32 GB C',32,1,10,878,'5'),('Strontium SDHC 32 GB Class 10 ',32,2,10,1039,'3'),('Toshiba MicroSD Card 16 GB Cla',16,1,4,445,'2'),('Toshiba MicroSD Card 8 GB Clas',8,1,4,169,'2'),('Transcend MicroSD Card 16 GB C',16,1,4,459,'2'),('Transcend MicroSD Card 32 GB C',32,1,10,1035,'5'),('Transcend MicroSD Card 4 GB Cl',4,1,4,195,'3'),('Transcend MicroSD Card 8 GB Cl',8,1,10,330,'4');

/*Table structure for table `mobile_products` */

DROP TABLE IF EXISTS `mobile_products`;

CREATE TABLE `mobile_products` (
  `product_name` varchar(100) NOT NULL,
  `rating` varchar(50) default NULL,
  `Functionality` varchar(200) default NULL,
  `Description` varchar(300) default NULL,
  PRIMARY KEY  (`product_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `mobile_products` */

insert  into `mobile_products`(`product_name`,`rating`,`Functionality`,`Description`) values ('Lenevo A6000','3','5,294,4.1,8,1,8,2300','Superb battery life Decent '),('Lenevo P90','5','5,294,4.1,8,1,8,2300','Superb battery life Decent '),('Lenovo A916','4','5.5,267,1.2,8,1,13,2500','Robust configuration Comes with stylus Good rear camera Competitively priced'),('Lenovo Golden Warrior Note 8','4','8,6,245,4.1,8,1,13,2300','Lenovo launched their latest android smartphone Lenovo Golden Warrior Note 8 in India. The phone is running latest Android v4.4.2 (KitKat) OS with powerful Mediatek MT6752 chipset. It integrated 1.7 GHz Octa-core Cortex-A53 processor and Mali-T760 GPU. The phone has accelerometer, proximity and ligh'),('Lenovo K3','2','5,294,4.1,16,1,8,2300','Light casing Solid configuration Android KitKat platform Affordable price'),('Lenovo S856','3','5.5,267,4.1,8,1,8,2500','The Lenovo S856 is powered by a Quad-core 1.2 GHz Cortex-A7 CPU processor with 1 GB RAM. The device also has 8 GB internal storage + microSD (up to 32 GB) and a 5.5-inch IPS LCD capacitive touchscreen (720 x 1280 , 267 ppi) display. It has a 8MP rear camera and supports Wifi, GPS, 3G and 4G LTE. It '),('Lenovo Vibe X2 Pro','4','5.3,416,4.4,32,2,13,2410','Lenovo Vibe X2 smartphone with 5.00-inch 1080x1920 display powered by 2GHz processor alongside 2GB RAM and 13-megapixel rear camera.'),('Nokia 215','2','215,2.4,166,0,0,0,0.3,1100','Preloaded internet apps 32GB external memory Sound '),('Nokia 215 Dual sim','1','2.4,167,0,0,0,0.3,1100','Social networking apps Supports 32GB cards Torch light'),('Nokia Lumia 638','1','638,4.5,218,8.1,8,1,5,1830','Latest Windows Phone OS Powerful configuration Supports 4G networks Reasonably price'),('Nokia Lumia 730 Dual sim','4','4.7,316,8.1,8,1,6.7,2200','Cost effective Free cloud storage Eye-catchy design Latest Windows OS'),('nokia Lumia 735','3','735,4.7,312,8.1,8,1,6.7,2200','Stunning OLED ClearBlack HD display Brilliant cameras at both panels Powerful processor Ample connectivity features'),('Nokia Lumia 830','3','830,5,294,8.1,16,1,10,2200,10','Awesome display Decent configuration Stunning rear cameras'),('Nokia N1','3','7.9,324,5,32,2,8,5300','Slim light and robust design High quality display Powerful configuration Nokia Z launcher'),('Samsumg galaxy A5','3','5,294,4.4,16,2,13,2300','Super AMOLED HD display Sleek and light metallic body Sound configuration Powerful cameras'),('Samsung galaxy A3 Duos','1','4.5,245,4.4,16,1,8,1900','Quad-core processor Premium looks Affordably priced Ample storage options'),('Samsung galaxy A5 DUOS','4','5,294,4.4,16,2,13,2300','Superb AMOLED HD display Sleek and light metallic body Sound configuration '),('Samsung galaxy core prime','3','4.5,207,4.4,8,1,5,2000','Android KitKat OS Pocket friendly Good cameras Reliable configuration Nice'),('Samsung galaxy E5','4','5,294,4.4,16,2,8,2400','Slim outfit 64-bit SoC Impressive cameras java developer download'),('Samsung galaxy E7','3','5.5,267,4.4,16,2,13,2950','Powerful configuration Slim frame with low bezels Nice cameras'),('samsung galaxy grand max','3','5.25,282,4.4,16,2,13,2500','Slim outfit 64-bit SoC Impressive cameras'),('Sony Xperia E3','2','4.5,218,4.1,4,1,5,2330','Durable display Light outfit Robust configuration Reliable battery'),('Sony Xperia E3 Dual','2','4.5,218,4.1,4,1,5,2330','Durable display Light outfit Reliable battery'),('Sony Xperia M2 Aqua','2','4.2,229,4.1,8,1,8,2300','Water and dust resistant outfit IPS scratch resistant display Powerful configuration Superior cameras'),('Sony Xperia Z3','5','5.2,424,4.4,16,3,20.7,3100','FHD TRILUMINOS display Dust and water resistant Slim and gorgeous outfit Robust configuration Great for gaming'),('Sony Xperia Z3 Dual','5','5.2,424,4.4,32,3,20.7,3100','A new firmware update has been certified for the Xperia Z3 Dual'),('Sony Xperia Z3 Tablet Compact','5','8,283,4.1,16,3,8.1,4500','Slim outfit 64-bit SoC Impressive cameras'),('Sony Xperia Z3v','5','5.2,424,4.4,32,3,20.7,3200','FHD TRILUMINOS display Robust configuration Great cameras Ample storage Advanced connectivity options');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
