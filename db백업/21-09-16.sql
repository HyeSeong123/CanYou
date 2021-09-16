/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 10.4.20-MariaDB : Database - test1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test1` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `test1`;

/*Table structure for table `board` */

DROP TABLE IF EXISTS `board`;

CREATE TABLE `board` (
  `num` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `boardName` char(20) NOT NULL,
  `boardCode` char(20) NOT NULL,
  `depth` int(3) unsigned NOT NULL DEFAULT 1,
  `parentCode` char(20) DEFAULT NULL,
  `boardUrl` varchar(200) NOT NULL,
  `menuOrder` int(3) NOT NULL DEFAULT 1,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

/*Data for the table `board` */

insert  into `board`(`num`,`regDate`,`updateDate`,`boardName`,`boardCode`,`depth`,`parentCode`,`boardUrl`,`menuOrder`) values 
(1,'2021-09-16 09:28:41','2021-09-16 09:28:43','ToDoList','toDoList',1,NULL,'toDoList=daily',2),
(2,'2021-09-16 09:35:02','2021-09-16 09:35:04','DailyList','daily',2,'toDoList','toDoList=daily',1),
(3,'2021-09-16 10:01:17','2021-09-16 10:01:18','MonthlyList','monthly',2,'toDoList','toDoList=monthly',1),
(4,'2021-09-16 10:02:04','2021-09-16 10:02:06','YearList','year',2,'toDoList','toDoList=year',1),
(5,'2021-09-16 10:03:47','2021-09-16 10:03:50','공지사항','notice',1,NULL,'/notice',1),
(6,'2021-09-16 10:06:00','2021-09-16 10:06:02','여행계획','tripPlan',1,NULL,'/tripPlan',3),
(7,'2021-09-16 10:08:42','2021-09-16 10:08:44','게시판','board',1,NULL,'board=suggestion',4),
(8,'2021-09-16 10:09:42','2021-09-16 10:09:42','건의게시판','suggestion',2,'board','board=suggestion',1),
(9,'2021-09-16 10:10:13','2021-09-16 10:10:15','ToDo자랑','todoOpen',2,'board','board=toDoOpen',1),
(10,'2021-09-16 10:13:09','2021-09-16 10:13:11','여행추천','tripGood',2,'board','board=tripGood',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
