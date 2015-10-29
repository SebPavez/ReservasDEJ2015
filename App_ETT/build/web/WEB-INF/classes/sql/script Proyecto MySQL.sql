/*
SQLyog - Free MySQL GUI v5.11
Host - 5.1.45-community : Database - bd
*********************************************************************
Server version : 5.1.45-community
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `bd`;

USE `bd`;

/*Table structure for table `automovil` */

DROP TABLE IF EXISTS `automovil`;

CREATE TABLE `automovil` (
  `patente` varchar(8) NOT NULL,
  `marca` varchar(20) NOT NULL,
  `modelo` varchar(20) NOT NULL,
  `color` varchar(10) NOT NULL,
  `num_estacionamiento` int(11) DEFAULT NULL,
  PRIMARY KEY (`patente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `automovil` */

insert into `automovil` (`patente`,`marca`,`modelo`,`color`,`num_estacionamiento`) values ('AN-5678','Nissan','Sentra','Blanco',25),('AS-7044','Nissan','Primera','azul',14),('BP-1612','Chevrolet','Corsa','Azul',34),('PS-5678','Toyota','Yaris','rojo',15);

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `rut` varchar(20) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `direccion` varchar(20) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  PRIMARY KEY (`rut`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cliente` */

insert into `cliente` (`rut`,`nombre`,`direccion`,`telefono`) values ('10643821-6','Juan Lopez','Los paltos 123','6331220'),('12493155-8','Marco Rojas','alerces 456','4182820'),('14643121-6','Ana Vera','Las acacias 88','3124020');

/*Table structure for table `reserva` */

DROP TABLE IF EXISTS `reserva`;

CREATE TABLE `reserva` (
  `codreserva` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_entrega` date NOT NULL,
  `litros_bencina` int(11) NOT NULL,
  `cliente_rut` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codreserva`),
  KEY `cliente_rut` (`cliente_rut`),
  CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`cliente_rut`) REFERENCES `cliente` (`rut`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `reserva` */

insert into `reserva` (`codreserva`,`fecha_inicio`,`fecha_entrega`,`litros_bencina`,`cliente_rut`) values (2030,'2012-03-10','2012-03-15',15,'12493155-8'),(4050,'2012-03-15','2012-03-20',10,'14643121-6'),(8020,'2012-03-18','2012-03-25',12,'10643821-6');

/*Table structure for table `reserva_automovil` */

DROP TABLE IF EXISTS `reserva_automovil`;

CREATE TABLE `reserva_automovil` (
  `reserva_codreserva` int(11) DEFAULT NULL,
  `automovil_patente` varchar(8) DEFAULT NULL,
  `precio_automovil` int(11) DEFAULT NULL,
  KEY `reserva_codreserva` (`reserva_codreserva`),
  KEY `automovil_patente` (`automovil_patente`),
  CONSTRAINT `reserva_automovil_ibfk_1` FOREIGN KEY (`reserva_codreserva`) REFERENCES `reserva` (`codreserva`),
  CONSTRAINT `reserva_automovil_ibfk_2` FOREIGN KEY (`automovil_patente`) REFERENCES `automovil` (`patente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `reserva_automovil` */

insert into `reserva_automovil` (`reserva_codreserva`,`automovil_patente`,`precio_automovil`) values (2030,'BP-1612',25000),(4050,'AN-5678',27000),(2030,'AS-7044',23000),(8020,'PS-5678',19000);
