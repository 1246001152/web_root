/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.25a : Database - rootdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rootdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `rootdb`;

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `m_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(50) DEFAULT NULL,
  `p_id` bigint(20) DEFAULT NULL,
  `url` varchar(1000) DEFAULT NULL,
  `img` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `menu` */

insert  into `menu`(`m_id`,`menu_name`,`p_id`,`url`,`img`) values (1,'会员管理',-1,'javascript:;','&#xe6b8;'),(2,'会员列表',1,'member-list.html','&#xe6a7;'),(3,'会员删除',1,'member-del.html','&#xe6a7;'),(4,'会员管理',1,'member-edit.html','&#xe6a7;'),(5,'会员列表',4,'member-list.html','&#xe6a7;'),(6,'等级管理',4,'level-manager.html','&#xe6a7;'),(7,'订单管理',-1,'javascript:;','&#xe723;'),(8,'分类管理',-1,'javascript:;','&#xe723;'),(9,'管理员管理',-1,'javascript:;','&#xe726;'),(10,'订单列表',7,'order-list.html','&#xe6a7;'),(11,'多级分类',8,'level-manager.html','&#xe6a7;'),(12,'用户管理',9,'UserServlet?action=query','&#xe6a7;'),(14,'角色管理',9,'RoleSerlvet?action=query','&#xe6a7;'),(15,'菜单管理',9,'MenuSerlvet?action=query','&#xe6a7;'),(16,'城市联动',-1,'javascript:;','&#xe723;'),(17,'系统统计',-1,'javascript:;','&#xe6ce;'),(18,'图标字体',-1,'javascript:;','&#xe6b4;');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `r_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`r_id`,`role_name`) values (1,'管理员'),(2,'总经理'),(3,'经理');

/*Table structure for table `role_menu` */

DROP TABLE IF EXISTS `role_menu`;

CREATE TABLE `role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `r_id` bigint(20) DEFAULT NULL,
  `m_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_menu_role_r_id_fk` (`r_id`),
  KEY `role_menu_menu_m_id_fk` (`m_id`),
  CONSTRAINT `role_menu_menu_m_id_fk` FOREIGN KEY (`m_id`) REFERENCES `menu` (`m_id`),
  CONSTRAINT `role_menu_role_r_id_fk` FOREIGN KEY (`r_id`) REFERENCES `role` (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

/*Data for the table `role_menu` */

insert  into `role_menu`(`id`,`r_id`,`m_id`) values (3,1,1),(4,1,2),(5,1,3),(6,1,4),(7,1,5),(8,1,6),(9,1,7),(10,1,8),(11,1,9),(12,1,10),(13,1,11),(14,1,12),(16,1,14),(17,1,15),(29,1,16),(30,1,17),(31,1,18),(46,2,1),(47,2,7),(48,2,8),(49,2,9),(50,2,16),(51,2,17),(52,2,18);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `u_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`u_id`,`username`,`password`) values (1,'admin123','admin123'),(5,'zhang3','123456'),(6,'lisi','123456');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `u_id` bigint(20) DEFAULT NULL,
  `r_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_role_user_u_id_fk` (`u_id`),
  KEY `user_role_role_r_id_fk` (`r_id`),
  CONSTRAINT `user_role_user_u_id_fk` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`),
  CONSTRAINT `user_role_role_r_id_fk` FOREIGN KEY (`r_id`) REFERENCES `role` (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`u_id`,`r_id`) values (1,1,1),(2,5,3),(3,6,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
