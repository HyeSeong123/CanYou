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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

/*Data for the table `board` */

insert  into `board`(`num`,`regDate`,`updateDate`,`boardName`,`boardCode`,`depth`,`parentCode`,`boardUrl`,`menuOrder`) values 
(1,'2021-12-07 16:58:39','2021-12-07 16:58:41','소개','about',1,NULL,'javascript:smooth_scroll(main_section2)',2),
(2,'2021-12-07 17:00:03','2021-12-07 17:00:04','안내','service',1,NULL,'/service.do',3),
(3,'2021-12-07 17:00:03','2021-12-07 17:00:04','갤러리','gallary',1,NULL,'javascript:smooth_scroll(main_section4)',4),
(4,'2021-12-07 17:00:03','2021-12-07 17:00:03','문의','contact',1,NULL,'/contact.do',5),
(5,'2021-12-07 17:00:03','2021-12-07 17:00:03','게시판','board',1,NULL,'/notice.do',6),
(7,'2021-12-14 18:21:46','2021-12-14 18:21:48','공지사항','notice',2,'board','/notice.do',1),
(8,'2021-12-14 18:22:08','2021-12-14 18:22:10','리뷰','review',2,'board','/review.do',2),
(9,'2021-12-14 18:22:08','2021-12-14 18:22:08','이벤트','event',3,'board','/event.do',3);

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `member_name` char(15) NOT NULL,
  `member_id` char(20) NOT NULL,
  `member_pw` varchar(200) NOT NULL,
  `member_birth` datetime DEFAULT NULL,
  `member_nickname` char(20) NOT NULL,
  `member_email` varchar(40) NOT NULL,
  `member_phNum` char(20) NOT NULL,
  `member_level` int(1) unsigned NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE KEY `member_id` (`member_id`),
  UNIQUE KEY `member_nickname` (`member_nickname`),
  KEY `member_index` (`member_name`,`member_id`,`member_nickname`,`member_level`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `member` */

insert  into `member`(`id`,`regDate`,`updateDate`,`member_name`,`member_id`,`member_pw`,`member_birth`,`member_nickname`,`member_email`,`member_phNum`,`member_level`) values 
(1,'2021-09-29 13:58:04','2021-09-29 13:58:04','방혜성','baobab612','$2a$10$6AXNn6BiRLDCp4dBKUDRVehPzIC/N0sMVcpL22fHx14U.8O7BxDty','1997-04-20 15:53:28','방혜성','banggu1997@naver.com','01083700420',1),
(3,'2021-12-14 17:52:48','2021-12-14 17:52:48','박성준','sung1305','$2a$10$y4ghsuyrZq2oSU1A/Qkr0uJIuFoYBqw/wkBdx3vfDxSqFbLrLjefW',NULL,'asdf','asia1305@naver.com','01066497471',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
