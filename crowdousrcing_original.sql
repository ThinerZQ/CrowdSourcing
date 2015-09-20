/*
SQLyog Ultimate v8.32 
MySQL - 5.5.9 : Database - CrowdSourcing
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`CrowdSourcing` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `CrowdSourcing`;

/*Table structure for table `decomposetask` */

DROP TABLE IF EXISTS `decomposetask`;

CREATE TABLE `decomposetask` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `step` tinyint(4) DEFAULT NULL COMMENT '分为几步',
  `best` enum('yes','no') DEFAULT NULL COMMENT '是否为最佳分解',
  `releaseTime` datetime DEFAULT NULL COMMENT '发布时间',
  `deadlineTime` datetime DEFAULT NULL COMMENT '截止时间',
  `completeTime` datetime DEFAULT NULL COMMENT '完成时间',
  `taskId` bigint(20) DEFAULT NULL COMMENT '任务主键',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户主键',
  PRIMARY KEY (`id`),
  KEY `FK_decomposetask` (`taskId`),
  KEY `FK_decomposetask_user` (`userId`),
  CONSTRAINT `FK_decomposetask` FOREIGN KEY (`taskId`) REFERENCES `task` (`id`),
  CONSTRAINT `FK_decomposetask_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `decomposetask` */

/*Table structure for table `decomposetask_task` */

DROP TABLE IF EXISTS `decomposetask_task`;

CREATE TABLE `decomposetask_task` (
  `decomposeTaskId` bigint(20) NOT NULL COMMENT '关联分解任务表主键',
  `taskId` bigint(20) NOT NULL COMMENT '关联任务表主键',
  `whichStep` bigint(20) DEFAULT NULL COMMENT '指定哪一步',
  PRIMARY KEY (`decomposeTaskId`,`taskId`),
  KEY `FK_decomposetask_task_task` (`taskId`),
  CONSTRAINT `FK_decomposetask_task_decompose` FOREIGN KEY (`decomposeTaskId`) REFERENCES `decomposetask` (`id`),
  CONSTRAINT `FK_decomposetask_task_task` FOREIGN KEY (`taskId`) REFERENCES `task` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `decomposetask_task` */

/*Table structure for table `description` */

DROP TABLE IF EXISTS `description`;

CREATE TABLE `description` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `description` varchar(255) DEFAULT NULL COMMENT '任务描述',
  `taskId` bigint(20) DEFAULT NULL COMMENT '任务主键',
  PRIMARY KEY (`id`),
  KEY `FK_description` (`taskId`),
  CONSTRAINT `FK_description` FOREIGN KEY (`taskId`) REFERENCES `task` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `description` */

insert  into `description`(`id`,`description`,`taskId`) values (1,'不少于300字  sss',NULL);

/*Table structure for table `judgetask` */

DROP TABLE IF EXISTS `judgetask`;

CREATE TABLE `judgetask` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `simple` enum('yes','no') DEFAULT NULL COMMENT '是否简单',
  `releaseTime` datetime DEFAULT NULL COMMENT '发布时间',
  `deadlineTime` datetime DEFAULT NULL COMMENT '截止时间',
  `completeTime` datetime DEFAULT NULL COMMENT '完成时间',
  `taskId` bigint(20) DEFAULT NULL COMMENT '任务ID',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户主键',
  PRIMARY KEY (`id`),
  KEY `FK_judgetask` (`taskId`),
  KEY `FK_judgetask_user` (`userId`),
  CONSTRAINT `FK_judgetask` FOREIGN KEY (`taskId`) REFERENCES `task` (`id`),
  CONSTRAINT `FK_judgetask_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `judgetask` */

/*Table structure for table `mergetask` */

DROP TABLE IF EXISTS `mergetask`;

CREATE TABLE `mergetask` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `finalResult` longtext COMMENT '结果',
  `releaseTime` datetime DEFAULT NULL COMMENT '发布时间',
  `deadlineTime` datetime DEFAULT NULL COMMENT '截止时间',
  `completeTime` datetime DEFAULT NULL COMMENT '完成时间',
  `taskId` bigint(20) DEFAULT NULL COMMENT '任务主键',
  PRIMARY KEY (`id`),
  KEY `FK_mergetask` (`taskId`),
  CONSTRAINT `FK_mergetask` FOREIGN KEY (`taskId`) REFERENCES `task` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mergetask` */

/*Table structure for table `qualification` */

DROP TABLE IF EXISTS `qualification`;

CREATE TABLE `qualification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `qualification` varchar(255) DEFAULT NULL COMMENT '资格要求',
  `taskId` bigint(20) DEFAULT NULL COMMENT '任务ID',
  PRIMARY KEY (`id`),
  KEY `FK_qualification` (`taskId`),
  CONSTRAINT `FK_qualification` FOREIGN KEY (`taskId`) REFERENCES `task` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qualification` */

/*Table structure for table `solvetask` */

DROP TABLE IF EXISTS `solvetask`;

CREATE TABLE `solvetask` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `result` longtext COMMENT '解决结果',
  `best` enum('yes','no') DEFAULT NULL COMMENT '最好结果',
  `releaseTime` datetime DEFAULT NULL COMMENT '发布时间',
  `deadlineTime` datetime DEFAULT NULL COMMENT '截止时间',
  `completeTime` datetime DEFAULT NULL COMMENT '完成时间',
  `taskId` bigint(20) DEFAULT NULL COMMENT '任务主键',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户主键',
  PRIMARY KEY (`id`),
  KEY `FK_solvetask` (`taskId`),
  KEY `FK_solvetask_user` (`userId`),
  CONSTRAINT `FK_solvetask` FOREIGN KEY (`taskId`) REFERENCES `task` (`id`),
  CONSTRAINT `FK_solvetask_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `solvetask` */

/*Table structure for table `task` */

DROP TABLE IF EXISTS `task`;

CREATE TABLE `task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) DEFAULT NULL COMMENT '任务标题',
  `releaseTime` datetime DEFAULT NULL COMMENT '任务发布时间',
  `deadlineTime` datetime DEFAULT NULL COMMENT '任务结束时间',
  `completeTime` datetime DEFAULT NULL COMMENT '任务被完成时间',
  `taskType` varchar(50) DEFAULT NULL COMMENT '任务类型',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户主键',
  PRIMARY KEY (`id`),
  KEY `FK_task` (`userId`),
  CONSTRAINT `FK_task` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

/*Data for the table `task` */

insert  into `task`(`id`,`title`,`releaseTime`,`deadlineTime`,`completeTime`,`taskType`,`userId`) values (22,'写一篇的文章111 text','2015-09-17 22:34:02','2015-09-17 22:34:02',NULL,'mainTask',NULL),(23,'写一篇的文章111 text','2015-09-17 22:36:30','2015-09-17 22:36:30',NULL,'mainTask',NULL),(24,'写一篇的文章111 text','2015-09-17 22:57:21','2015-09-17 22:57:21',NULL,'mainTask',NULL),(25,'写一篇的文章111 text','2015-09-19 18:54:17','2015-09-19 18:54:17',NULL,'mainTask',NULL),(26,'写一篇的文章111 text','2015-09-19 18:57:21','2015-09-19 18:57:21',NULL,'mainTask',NULL),(27,'写一篇的文章111 text','2015-09-19 19:00:14','2015-09-19 19:00:14',NULL,'mainTask',NULL),(28,'写一篇的文章111 text','2015-09-19 21:10:53','2015-09-19 21:10:53',NULL,'mainTask',NULL),(29,'写一篇的文章111 text','2015-09-19 21:13:47','2015-09-19 21:13:47',NULL,'mainTask',NULL),(30,'写一篇的文章111 text','2015-09-19 21:15:16','2015-09-19 21:15:16',NULL,'mainTask',NULL),(31,'写一篇的文章111 text','2015-09-19 21:17:05','2015-09-19 21:17:05',NULL,'mainTask',NULL),(32,'写一篇的文章111 text','2015-09-19 21:19:10','2015-09-19 21:19:10',NULL,'mainTask',NULL),(33,'写一篇的文章111 text','2015-09-19 21:21:31','2015-09-19 21:21:31',NULL,'mainTask',NULL),(34,'写一篇的文章111 text','2015-09-19 21:22:19','2015-09-19 21:22:19',NULL,'mainTask',NULL),(35,'写一篇的文章111 text','2015-09-19 21:23:21','2015-09-19 21:23:21',NULL,'mainTask',NULL),(36,'写一篇的文章111 text','2015-09-19 21:24:28','2015-09-19 21:24:28',NULL,'mainTask',NULL),(37,'写一篇的文章111 text','2015-09-19 21:25:55','2015-09-19 21:25:55',NULL,'mainTask',NULL),(38,'写一篇的文章111 text','2015-09-19 21:51:24','2015-09-19 21:51:24',NULL,'mainTask',NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userName` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `email` varchar(50) NOT NULL COMMENT '电子邮件',
  `activateCode` varchar(255) DEFAULT NULL COMMENT '激活码',
  `status` enum('0','1','2') DEFAULT NULL COMMENT '用户状态',
  `registerDate` datetime NOT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`userName`,`password`,`email`,`activateCode`,`status`,`registerDate`) values (1,'test1','123456','601097836@qq.com','4543','1','2011-11-11 00:00:00'),(2,NULL,'6823ssssss','6010978@qq.com',NULL,NULL,'2015-09-19 18:53:58');

/*Table structure for table `votetask` */

DROP TABLE IF EXISTS `votetask`;

CREATE TABLE `votetask` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `releaseTime` datetime DEFAULT NULL COMMENT '发布时间',
  `deadlineTime` datetime DEFAULT NULL COMMENT '截止时间',
  `completeTime` datetime DEFAULT NULL COMMENT '完成时间',
  `taskId` bigint(20) DEFAULT NULL COMMENT '任务主键',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户主键',
  PRIMARY KEY (`id`),
  KEY `FK_votetask_task` (`taskId`),
  KEY `FK_votetask_user` (`userId`),
  CONSTRAINT `FK_votetask_task` FOREIGN KEY (`taskId`) REFERENCES `task` (`id`),
  CONSTRAINT `FK_votetask_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `votetask` */

/*Table structure for table `votetask_decomposetask` */

DROP TABLE IF EXISTS `votetask_decomposetask`;

CREATE TABLE `votetask_decomposetask` (
  `voteTaskId` bigint(20) NOT NULL COMMENT '关联投票任务表ID',
  `decomposeTaskId` bigint(20) NOT NULL COMMENT '关联分解任务表ID',
  PRIMARY KEY (`voteTaskId`,`decomposeTaskId`),
  KEY `FK_votetask_decomposetask_decompose` (`decomposeTaskId`),
  CONSTRAINT `FK_votetask_decomposetask_decompose` FOREIGN KEY (`decomposeTaskId`) REFERENCES `decomposetask` (`id`),
  CONSTRAINT `FK_votetask_decomposetask_vote` FOREIGN KEY (`voteTaskId`) REFERENCES `votetask` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `votetask_decomposetask` */

/*Table structure for table `votetask_solvetask` */

DROP TABLE IF EXISTS `votetask_solvetask`;

CREATE TABLE `votetask_solvetask` (
  `voteTaskId` bigint(20) NOT NULL COMMENT '关联投票任务主键',
  `solveTaskId` bigint(20) NOT NULL COMMENT '关联解决任务主键',
  PRIMARY KEY (`voteTaskId`,`solveTaskId`),
  KEY `FK_votetask_solvetask_solve` (`solveTaskId`),
  CONSTRAINT `FK_votetask_solvetask_solve` FOREIGN KEY (`solveTaskId`) REFERENCES `solvetask` (`id`),
  CONSTRAINT `FK_votetask_solvetask_vote` FOREIGN KEY (`voteTaskId`) REFERENCES `votetask` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `votetask_solvetask` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
