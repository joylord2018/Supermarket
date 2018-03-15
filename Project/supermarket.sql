/*
SQLyog Ultimate v12.3.1 (32 bit)
MySQL - 5.0.24-community-nt : Database - supermarket
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`supermarket` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `supermarket`;

/*Table structure for table `s_address` */

DROP TABLE IF EXISTS `s_address`;

CREATE TABLE `s_address` (
  `aid` int(10) NOT NULL auto_increment,
  `contact` varchar(20) default NULL,
  `addressDesc` varchar(50) default NULL,
  `postCode` varchar(20) default NULL,
  `tel` varchar(20) default NULL,
  `createdBy` varchar(20) default NULL,
  `creationDate` timestamp NULL default CURRENT_TIMESTAMP,
  `modifyBy` varchar(20) default NULL,
  `modifyDate` timestamp NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `s_address` */

/*Table structure for table `s_bill` */

DROP TABLE IF EXISTS `s_bill`;

CREATE TABLE `s_bill` (
  `bid` int(10) NOT NULL auto_increment,
  `billCode` varchar(50) default NULL,
  `productName` varchar(50) default NULL,
  `productDesc` varchar(50) default NULL,
  `productUnit` varchar(50) default NULL,
  `productCount` int(20) default NULL,
  `totalPrice` double default NULL,
  `isPayment` int(5) default NULL,
  `providerId` int(10) default NULL,
  `createdBy` varchar(20) default NULL,
  `createtionDate` timestamp NULL default CURRENT_TIMESTAMP,
  `modifyBy` varchar(20) default NULL,
  `modifyDate` timestamp NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`bid`),
  KEY `providerId` (`providerId`),
  CONSTRAINT `s_bill_ibfk_1` FOREIGN KEY (`providerId`) REFERENCES `s_provider` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `s_bill` */

insert  into `s_bill`(`bid`,`billCode`,`productName`,`productDesc`,`productUnit`,`productCount`,`totalPrice`,`isPayment`,`providerId`,`createdBy`,`createtionDate`,`modifyBy`,`modifyDate`) values 
(1,'001','大前门','牛批','条',20,2000,2,5,NULL,'2017-11-23 09:31:20',NULL,'0000-00-00 00:00:00'),
(2,'002','软中华','厉害','条',10,7000,1,2,NULL,'2017-11-23 09:31:22',NULL,'0000-00-00 00:00:00'),
(3,'003','硬玉溪','可以','条',30,4500,2,4,NULL,'2017-11-23 09:34:14',NULL,'0000-00-00 00:00:00'),
(4,'004','九五至尊','无敌','条',15,15000,1,1,NULL,'2017-11-23 09:34:52',NULL,'0000-00-00 00:00:00'),
(5,'005','黑皖','舒服','条',50,37500,2,3,NULL,'2017-11-23 09:35:00',NULL,'0000-00-00 00:00:00');

/*Table structure for table `s_provider` */

DROP TABLE IF EXISTS `s_provider`;

CREATE TABLE `s_provider` (
  `pid` int(20) NOT NULL auto_increment,
  `procode` varchar(50) default NULL,
  `proname` varchar(50) default NULL,
  `prodesc` varchar(50) default NULL,
  `procontact` varchar(50) default NULL,
  `prophone` varchar(20) default NULL,
  `proaddress` varchar(50) default NULL,
  `profax` varchar(20) default NULL,
  `createdby` int(20) default NULL,
  `createtiondate` timestamp NULL default CURRENT_TIMESTAMP,
  `modifyby` varchar(20) default NULL,
  `modifydate` timestamp NULL default NULL,
  PRIMARY KEY  (`pid`),
  KEY `createdby` (`createdby`),
  CONSTRAINT `s_provider_ibfk_1` FOREIGN KEY (`createdby`) REFERENCES `s_user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `s_provider` */

insert  into `s_provider`(`pid`,`procode`,`proname`,`prodesc`,`procontact`,`prophone`,`proaddress`,`profax`,`createdby`,`createtiondate`,`modifyby`,`modifydate`) values 
(1,'10001','95纸烟厂','95至尊造烟','温家宝','120-12151','中南海2号洞','01505005',5,'2016-04-15 10:37:51',NULL,NULL),
(2,'10002','中国纸烟总局','国家造烟部门','习近平','100-15944','中南海1号洞','01505006',5,'2016-08-05 10:37:55',NULL,NULL),
(3,'10003','皖烟制造厂','安徽制烟处','胡锦涛','102-54981','中南海3号洞','01505014',5,'2017-03-16 10:38:08',NULL,NULL),
(4,'10004','玉溪纸烟局','玉溪制制造总部','王拥军','195-89448','中南海4号洞','01505096',5,'2017-08-16 10:38:17',NULL,NULL),
(5,'10005','京城烟厂','京城制造厂','登一辉','192-59551','中南海5号洞','01554845',5,'2017-09-16 10:38:21',NULL,NULL);

/*Table structure for table `s_role` */

DROP TABLE IF EXISTS `s_role`;

CREATE TABLE `s_role` (
  `rid` int(10) NOT NULL auto_increment,
  `roleCode` varchar(50) default NULL,
  `roleName` varchar(50) default NULL,
  `createBy` varchar(50) default NULL,
  `createtionDate` timestamp NULL default CURRENT_TIMESTAMP,
  `modifyBy` varchar(50) default NULL,
  `modifyDate` timestamp NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `s_role` */

insert  into `s_role`(`rid`,`roleCode`,`roleName`,`createBy`,`createtionDate`,`modifyBy`,`modifyDate`) values 
(1,NULL,'经理',NULL,'2017-11-21 09:33:55',NULL,'0000-00-00 00:00:00'),
(2,NULL,'财务',NULL,'2017-11-21 09:33:58',NULL,'0000-00-00 00:00:00'),
(3,NULL,'员工',NULL,'2017-11-21 09:34:09',NULL,'0000-00-00 00:00:00'),
(4,NULL,'系统管理员',NULL,'2017-09-12 13:53:46',NULL,'0000-00-00 00:00:00');

/*Table structure for table `s_user` */

DROP TABLE IF EXISTS `s_user`;

CREATE TABLE `s_user` (
  `userId` int(10) NOT NULL auto_increment,
  `userCode` varchar(50) default NULL,
  `userName` varchar(50) default NULL,
  `userPassword` varchar(50) default NULL,
  `sex` varchar(10) default NULL,
  `birthday` date default NULL,
  `phone` int(11) default NULL,
  `address` varchar(50) default NULL,
  `userRole` int(50) default NULL,
  `createBy` int(50) default NULL,
  `creationDate` date default NULL,
  `modifyBy` varchar(50) default NULL,
  `modifyDate` date default NULL,
  `idPic` varchar(50) default NULL,
  PRIMARY KEY  (`userId`),
  KEY `userRole` (`userRole`),
  KEY `createBy` (`createBy`),
  CONSTRAINT `s_user_ibfk_1` FOREIGN KEY (`userRole`) REFERENCES `s_role` (`rid`),
  CONSTRAINT `s_user_ibfk_2` FOREIGN KEY (`createBy`) REFERENCES `s_user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `s_user` */

insert  into `s_user`(`userId`,`userCode`,`userName`,`userPassword`,`sex`,`birthday`,`phone`,`address`,`userRole`,`createBy`,`creationDate`,`modifyBy`,`modifyDate`,`idPic`) values 
(1,'qwq','柔语嫣','123123','女','1996-08-16',1369598784,'长宁区',2,5,'2017-12-06',NULL,NULL,NULL),
(2,'asa','大牛哥','123123','男','1992-08-28',1234567890,'嘉定区',3,5,'2017-12-05',NULL,NULL,NULL),
(3,'wew','二愣子','123123','男','1990-08-06',1262625622,'徐汇区',1,5,'2017-12-06',NULL,NULL,NULL),
(4,'zxz','文依然','123123','女','1994-06-08',1236265265,'杨浦区',2,5,'2017-12-06',NULL,NULL,NULL),
(5,'admin','Admin','123123','男','1991-09-01',1051520050,'青浦区',4,5,'2017-12-06',NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
