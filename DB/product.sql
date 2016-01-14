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

/*Table structure for table `mobile_products` */

DROP TABLE IF EXISTS `mobile_products`;

CREATE TABLE `mobile_products` (
  `product_name` varchar(100) NOT NULL,
  `rating` varchar(50) default NULL,
  `Functionality` varchar(200) default NULL,
  `Description` varchar(300) default NULL,
  PRIMARY KEY  (`product_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
