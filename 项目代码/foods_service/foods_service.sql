CREATE DATABASE IF NOT EXISTS `foods_service` default charset utf8 COLLATE utf8_general_ci;

USE `foods_service`;
SET FOREIGN_KEY_CHECKS=0;
drop TABLE if EXISTS `admin_msg`;
CREATE TABLE IF NOT EXISTS `admin_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `login_name` varchar(255) DEFAULT NULL COMMENT '登录名',
 `password` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='管理员';


drop TABLE if EXISTS `yd_type_msg`;
CREATE TABLE IF NOT EXISTS `yd_type_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `type_name` varchar(255) DEFAULT NULL COMMENT '类型名',
 `mfzxh` int(11) DEFAULT NULL COMMENT '每分钟消耗',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='运动类型';


drop TABLE if EXISTS `ys_type_msg`;
CREATE TABLE IF NOT EXISTS `ys_type_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `type_name` varchar(255) DEFAULT NULL COMMENT '类型名',
 `mqkr_num` int(11) DEFAULT NULL COMMENT '每千克热量',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='饮食类型';


drop TABLE if EXISTS `user_msg`;
CREATE TABLE IF NOT EXISTS `user_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `login_name` varchar(255) DEFAULT NULL COMMENT '登录名',
 `password` varchar(255) DEFAULT NULL COMMENT '密码',
 `name` varchar(255) DEFAULT NULL COMMENT '姓名',
 `celphone` varchar(255) DEFAULT NULL COMMENT '联系电话',
 `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
 `sex` int(11) DEFAULT NULL COMMENT '性别',
 `sg` int(11) DEFAULT NULL COMMENT '身高',
 `weight` double(10,2) DEFAULT NULL COMMENT '体重',
 `bmi` double(10,2) DEFAULT NULL COMMENT 'BMI',
 `age` varchar(255) DEFAULT NULL COMMENT '年龄',
 `head_img` varchar(200) DEFAULT NULL COMMENT '头像',
 `zc_time` varchar(30) DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户';


drop TABLE if EXISTS `yd_log`;
CREATE TABLE IF NOT EXISTS `yd_log` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `yd_date` varchar(30) DEFAULT NULL COMMENT '运动日期',
 `ydfzs` int(11) DEFAULT NULL COMMENT '运动分钟数',
 `yd_type` int(11) DEFAULT NULL COMMENT '运动类型',
 `mfzxh` int(11) DEFAULT NULL COMMENT '每分钟消耗',
 `zr_num` int(11) DEFAULT NULL COMMENT '总热量',
 `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
KEY `yd_log_yd_type_ref` (`yd_type`),
CONSTRAINT `yd_log_yd_type_ref` FOREIGN KEY (`yd_type`) REFERENCES `yd_type_msg` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
KEY `yd_log_user_id_ref` (`user_id`),
CONSTRAINT `yd_log_user_id_ref` FOREIGN KEY (`user_id`) REFERENCES `user_msg` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='运动记录';


drop TABLE if EXISTS `ys_log`;
CREATE TABLE IF NOT EXISTS `ys_log` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `ys_date` varchar(30) DEFAULT NULL COMMENT '饮食日期',
 `ys_time` int(11) DEFAULT NULL COMMENT '饮食时间',
 `ys_type` int(11) DEFAULT NULL COMMENT '饮食类型',
 `mqkr_num` int(11) DEFAULT NULL COMMENT '每千克热量',
 `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
 `zrl` int(11) DEFAULT NULL COMMENT '总热量',
KEY `ys_log_ys_type_ref` (`ys_type`),
CONSTRAINT `ys_log_ys_type_ref` FOREIGN KEY (`ys_type`) REFERENCES `ys_type_msg` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
KEY `ys_log_user_id_ref` (`user_id`),
CONSTRAINT `ys_log_user_id_ref` FOREIGN KEY (`user_id`) REFERENCES `user_msg` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='饮食记录';


drop TABLE if EXISTS `bmifw_msg`;
CREATE TABLE IF NOT EXISTS `bmifw_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `fw_name` varchar(255) DEFAULT NULL COMMENT '范围名',
 `min` double(10,2) DEFAULT NULL COMMENT '最小值',
 `max` double(10,2) DEFAULT NULL COMMENT '最大值',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='BMI范围';


drop TABLE if EXISTS `ynum_fw_msg`;
CREATE TABLE IF NOT EXISTS `ynum_fw_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `fw_name` varchar(255) DEFAULT NULL COMMENT '范围名',
 `min` double(10,2) DEFAULT NULL COMMENT '最小值',
 `max` double(10,2) DEFAULT NULL COMMENT '最大值',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='饮食热量范围';


drop TABLE if EXISTS `ydxhfw_msg`;
CREATE TABLE IF NOT EXISTS `ydxhfw_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `fw_name` varchar(255) DEFAULT NULL COMMENT '范围名',
 `min` double(10,2) DEFAULT NULL COMMENT '最小值',
 `max` double(10,2) DEFAULT NULL COMMENT '最大值',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='运动消耗范围';


drop TABLE if EXISTS `ysjh_msg`;
CREATE TABLE IF NOT EXISTS `ysjh_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `jh_name` varchar(255) DEFAULT NULL COMMENT '计划名',
 `fm_img` varchar(200) DEFAULT NULL COMMENT '封面图',
 `bmifw` int(11) DEFAULT NULL COMMENT 'BMI范围',
 `ynum_fw` int(11) DEFAULT NULL COMMENT '饮食热量范围',
 `jh_detail` text  COLLATE utf8_bin DEFAULT NULL COMMENT '计划详情',
 `fb_time` varchar(30) DEFAULT NULL COMMENT '发布时间',
KEY `ysjh_msg_bmifw_ref` (`bmifw`),
CONSTRAINT `ysjh_msg_bmifw_ref` FOREIGN KEY (`bmifw`) REFERENCES `bmifw_msg` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
KEY `ysjh_msg_ynum_fw_ref` (`ynum_fw`),
CONSTRAINT `ysjh_msg_ynum_fw_ref` FOREIGN KEY (`ynum_fw`) REFERENCES `ynum_fw_msg` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='饮食计划';


drop TABLE if EXISTS `ydjh_msg`;
CREATE TABLE IF NOT EXISTS `ydjh_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `jh_name` varchar(255) DEFAULT NULL COMMENT '计划名',
 `fm_img` varchar(200) DEFAULT NULL COMMENT '封面图',
 `bmifw` int(11) DEFAULT NULL COMMENT 'BMI范围',
 `ydxhfw` int(11) DEFAULT NULL COMMENT '运动消耗范围',
 `jh_detail` text  COLLATE utf8_bin DEFAULT NULL COMMENT '计划详情',
 `fb_time` varchar(30) DEFAULT NULL COMMENT '发布时间',
KEY `ydjh_msg_bmifw_ref` (`bmifw`),
CONSTRAINT `ydjh_msg_bmifw_ref` FOREIGN KEY (`bmifw`) REFERENCES `bmifw_msg` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
KEY `ydjh_msg_ydxhfw_ref` (`ydxhfw`),
CONSTRAINT `ydjh_msg_ydxhfw_ref` FOREIGN KEY (`ydxhfw`) REFERENCES `ydxhfw_msg` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='运动计划';


drop TABLE if EXISTS `ys_collect_msg`;
CREATE TABLE IF NOT EXISTS `ys_collect_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `ysjh` int(11) DEFAULT NULL COMMENT '饮食计划',
 `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
 `collect_time` varchar(30) DEFAULT NULL COMMENT '收藏时间',
KEY `ys_collect_msg_ysjh_ref` (`ysjh`),
CONSTRAINT `ys_collect_msg_ysjh_ref` FOREIGN KEY (`ysjh`) REFERENCES `ysjh_msg` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
KEY `ys_collect_msg_user_id_ref` (`user_id`),
CONSTRAINT `ys_collect_msg_user_id_ref` FOREIGN KEY (`user_id`) REFERENCES `user_msg` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='饮食收藏';


drop TABLE if EXISTS `yd_collect_msg`;
CREATE TABLE IF NOT EXISTS `yd_collect_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `ydjh` int(11) DEFAULT NULL COMMENT '运动计划',
 `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
 `collect_time` varchar(30) DEFAULT NULL COMMENT '收藏时间',
KEY `yd_collect_msg_ydjh_ref` (`ydjh`),
CONSTRAINT `yd_collect_msg_ydjh_ref` FOREIGN KEY (`ydjh`) REFERENCES `ydjh_msg` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
KEY `yd_collect_msg_user_id_ref` (`user_id`),
CONSTRAINT `yd_collect_msg_user_id_ref` FOREIGN KEY (`user_id`) REFERENCES `user_msg` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='运动收藏';


drop TABLE if EXISTS `post_msg`;
CREATE TABLE IF NOT EXISTS `post_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `title` varchar(255) DEFAULT NULL COMMENT '标题',
 `subtitle` varchar(1000) DEFAULT NULL COMMENT '副标题',
 `post_detail` text  COLLATE utf8_bin DEFAULT NULL COMMENT '帖子详情',
 `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
 `fb_time` varchar(30) DEFAULT NULL COMMENT '发布时间',
KEY `post_msg_user_id_ref` (`user_id`),
CONSTRAINT `post_msg_user_id_ref` FOREIGN KEY (`user_id`) REFERENCES `user_msg` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='帖子';


drop TABLE if EXISTS `dis_msg`;
CREATE TABLE IF NOT EXISTS `dis_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `post_id` int(11) DEFAULT NULL COMMENT '帖子ID',
 `dis_content` varchar(255) DEFAULT NULL COMMENT '评论内容',
 `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
 `dis_time` varchar(30) DEFAULT NULL COMMENT '评论时间',
KEY `dis_msg_post_id_ref` (`post_id`),
CONSTRAINT `dis_msg_post_id_ref` FOREIGN KEY (`post_id`) REFERENCES `post_msg` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
KEY `dis_msg_user_id_ref` (`user_id`),
CONSTRAINT `dis_msg_user_id_ref` FOREIGN KEY (`user_id`) REFERENCES `user_msg` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='评论';


drop TABLE if EXISTS `reply_msg`;
CREATE TABLE IF NOT EXISTS `reply_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `dis_id` int(11) DEFAULT NULL COMMENT '评论ID',
 `reply_content` varchar(255) DEFAULT NULL COMMENT '回复内容',
 `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
 `reply_time` varchar(30) DEFAULT NULL COMMENT '回复时间',
KEY `reply_msg_dis_id_ref` (`dis_id`),
CONSTRAINT `reply_msg_dis_id_ref` FOREIGN KEY (`dis_id`) REFERENCES `dis_msg` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
KEY `reply_msg_user_id_ref` (`user_id`),
CONSTRAINT `reply_msg_user_id_ref` FOREIGN KEY (`user_id`) REFERENCES `user_msg` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='回复';


drop TABLE if EXISTS `lmsg_suggest_msg`;
CREATE TABLE IF NOT EXISTS `lmsg_suggest_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `title` varchar(255) DEFAULT NULL COMMENT '标题',
 `lmsg_content` varchar(1000) DEFAULT NULL COMMENT '留言内容',
 `lmsg_img` varchar(200) DEFAULT NULL COMMENT '留言附图',
 `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
 `lmsg_status` int(11) DEFAULT NULL COMMENT '留言状态',
 `reply_content` varchar(255) DEFAULT NULL COMMENT '回复内容',
 `lmsg_time` varchar(30) DEFAULT NULL COMMENT '留言时间',
KEY `lmsg_suggest_msg_user_id_ref` (`user_id`),
CONSTRAINT `lmsg_suggest_msg_user_id_ref` FOREIGN KEY (`user_id`) REFERENCES `user_msg` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='留言反馈';


drop TABLE if EXISTS `yyxcs_msg`;
CREATE TABLE IF NOT EXISTS `yyxcs_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `title` varchar(255) DEFAULT NULL COMMENT '标题',
 `fm_img` varchar(200) DEFAULT NULL COMMENT '封面图',
 `cs_content` text  COLLATE utf8_bin DEFAULT NULL COMMENT '常识内容',
 `fb_time` varchar(30) DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='营养小常识';


drop TABLE if EXISTS `xt_intro_msg`;
CREATE TABLE IF NOT EXISTS `xt_intro_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `title` varchar(255) DEFAULT NULL COMMENT '标题',
 `fm_img` varchar(200) DEFAULT NULL COMMENT '封面图',
 `intro_detail` text  COLLATE utf8_bin DEFAULT NULL COMMENT '介绍详情',
 `celphone` varchar(255) DEFAULT NULL COMMENT '联系电话',
 `address` varchar(255) DEFAULT NULL COMMENT '地址',
 `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='系统介绍';


drop TABLE if EXISTS `banner_msg`;
CREATE TABLE IF NOT EXISTS `banner_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `banner` varchar(200) DEFAULT NULL COMMENT '轮播图',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='轮播图';



INSERT INTO `foods_service`.`admin_msg` (`id`,`login_name`,`password`)  VALUES('1','admin','123');
INSERT INTO `foods_service`.`admin_msg` (`id`,`login_name`,`password`)  VALUES('2','admin1','123');
INSERT INTO `foods_service`.`admin_msg` (`id`,`login_name`,`password`)  VALUES('3','admin2','123');
INSERT INTO `foods_service`.`admin_msg` (`id`,`login_name`,`password`)  VALUES('4','admin3','123');
INSERT INTO `foods_service`.`admin_msg` (`id`,`login_name`,`password`)  VALUES('5','admin4','123');
INSERT INTO `foods_service`.`yd_type_msg` (`id`,`type_name`,`mfzxh`)  VALUES('1','类型名0','43');
INSERT INTO `foods_service`.`yd_type_msg` (`id`,`type_name`,`mfzxh`)  VALUES('2','类型名1','97');
INSERT INTO `foods_service`.`yd_type_msg` (`id`,`type_name`,`mfzxh`)  VALUES('3','类型名2','15');
INSERT INTO `foods_service`.`yd_type_msg` (`id`,`type_name`,`mfzxh`)  VALUES('4','类型名3','79');
INSERT INTO `foods_service`.`yd_type_msg` (`id`,`type_name`,`mfzxh`)  VALUES('5','类型名4','33');
INSERT INTO `foods_service`.`ys_type_msg` (`id`,`type_name`,`mqkr_num`)  VALUES('1','类型名0','43');
INSERT INTO `foods_service`.`ys_type_msg` (`id`,`type_name`,`mqkr_num`)  VALUES('2','类型名1','72');
INSERT INTO `foods_service`.`ys_type_msg` (`id`,`type_name`,`mqkr_num`)  VALUES('3','类型名2','98');
INSERT INTO `foods_service`.`ys_type_msg` (`id`,`type_name`,`mqkr_num`)  VALUES('4','类型名3','99');
INSERT INTO `foods_service`.`ys_type_msg` (`id`,`type_name`,`mqkr_num`)  VALUES('5','类型名4','2');
INSERT INTO `foods_service`.`user_msg` (`id`,`login_name`,`password`,`name`,`celphone`,`email`,`sex`,`sg`,`weight`,`bmi`,`age`,`head_img`,`zc_time`)  VALUES('1','user','123','姓名0','13052653265','9523895@qq.com','2','44','67.1','0.0','年龄0','http://localhost:8080/foods_service/static/images/2/1.jpg','2025-03-20 17:55:45');
INSERT INTO `foods_service`.`user_msg` (`id`,`login_name`,`password`,`name`,`celphone`,`email`,`sex`,`sg`,`weight`,`bmi`,`age`,`head_img`,`zc_time`)  VALUES('2','user1','123','姓名1','13553613261','04050495495@qq.com','1','16','73.1','0.0','年龄1','http://localhost:8080/foods_service/static/images/2/2.jpg','2025-03-20 17:55:45');
INSERT INTO `foods_service`.`user_msg` (`id`,`login_name`,`password`,`name`,`celphone`,`email`,`sex`,`sg`,`weight`,`bmi`,`age`,`head_img`,`zc_time`)  VALUES('3','user2','123','姓名2','13552623265','8384388333@qq.com','1','72','93.4','0.0','年龄2','http://localhost:8080/foods_service/static/images/2/3.jpg','2025-03-21 17:55:45');
INSERT INTO `foods_service`.`user_msg` (`id`,`login_name`,`password`,`name`,`celphone`,`email`,`sex`,`sg`,`weight`,`bmi`,`age`,`head_img`,`zc_time`)  VALUES('4','user3','123','姓名3','13052623165','84238482483422@qq.com','1','17','5.1','0.0','年龄3','http://localhost:8080/foods_service/static/images/2/4.jpg','2025-03-20 17:55:45');
INSERT INTO `foods_service`.`user_msg` (`id`,`login_name`,`password`,`name`,`celphone`,`email`,`sex`,`sg`,`weight`,`bmi`,`age`,`head_img`,`zc_time`)  VALUES('5','user4','123','姓名4','13052633163','9523895@qq.com','1','45','29.3','0.0','年龄4','http://localhost:8080/foods_service/static/images/2/5.jpg','2025-03-21 17:55:45');
INSERT INTO `foods_service`.`yd_log` (`id`,`yd_date`,`ydfzs`,`yd_type`,`mfzxh`,`zr_num`,`user_id`)  VALUES('1','2025-03-21','33','5','33','76','4');
INSERT INTO `foods_service`.`yd_log` (`id`,`yd_date`,`ydfzs`,`yd_type`,`mfzxh`,`zr_num`,`user_id`)  VALUES('2','2025-03-21','95','2','97','24','4');
INSERT INTO `foods_service`.`yd_log` (`id`,`yd_date`,`ydfzs`,`yd_type`,`mfzxh`,`zr_num`,`user_id`)  VALUES('3','2025-03-21','61','1','43','17','4');
INSERT INTO `foods_service`.`yd_log` (`id`,`yd_date`,`ydfzs`,`yd_type`,`mfzxh`,`zr_num`,`user_id`)  VALUES('4','2025-03-20','79','3','15','45','4');
INSERT INTO `foods_service`.`yd_log` (`id`,`yd_date`,`ydfzs`,`yd_type`,`mfzxh`,`zr_num`,`user_id`)  VALUES('5','2025-03-21','47','4','79','19','4');
INSERT INTO `foods_service`.`ys_log` (`id`,`ys_date`,`ys_time`,`ys_type`,`mqkr_num`,`user_id`,`zrl`)  VALUES('1','2025-03-20','2','3','98','3','0');
INSERT INTO `foods_service`.`ys_log` (`id`,`ys_date`,`ys_time`,`ys_type`,`mqkr_num`,`user_id`,`zrl`)  VALUES('2','2025-03-20','2','2','72','4','0');
INSERT INTO `foods_service`.`ys_log` (`id`,`ys_date`,`ys_time`,`ys_type`,`mqkr_num`,`user_id`,`zrl`)  VALUES('3','2025-03-20','2','5','2','1','0');
INSERT INTO `foods_service`.`ys_log` (`id`,`ys_date`,`ys_time`,`ys_type`,`mqkr_num`,`user_id`,`zrl`)  VALUES('4','2025-03-21','1','4','99','1','0');
INSERT INTO `foods_service`.`ys_log` (`id`,`ys_date`,`ys_time`,`ys_type`,`mqkr_num`,`user_id`,`zrl`)  VALUES('5','2025-03-20','2','4','99','1','0');
INSERT INTO `foods_service`.`bmifw_msg` (`id`,`fw_name`,`min`,`max`)  VALUES('1','范围名0','10.3','60.6');
INSERT INTO `foods_service`.`bmifw_msg` (`id`,`fw_name`,`min`,`max`)  VALUES('2','范围名1','83.5','40.1');
INSERT INTO `foods_service`.`bmifw_msg` (`id`,`fw_name`,`min`,`max`)  VALUES('3','范围名2','71.9','66.6');
INSERT INTO `foods_service`.`bmifw_msg` (`id`,`fw_name`,`min`,`max`)  VALUES('4','范围名3','12.8','32.5');
INSERT INTO `foods_service`.`bmifw_msg` (`id`,`fw_name`,`min`,`max`)  VALUES('5','范围名4','91.1','59.9');
INSERT INTO `foods_service`.`ynum_fw_msg` (`id`,`fw_name`,`min`,`max`)  VALUES('1','范围名0','41.6','22.5');
INSERT INTO `foods_service`.`ynum_fw_msg` (`id`,`fw_name`,`min`,`max`)  VALUES('2','范围名1','60.2','45.7');
INSERT INTO `foods_service`.`ynum_fw_msg` (`id`,`fw_name`,`min`,`max`)  VALUES('3','范围名2','3.4','18.9');
INSERT INTO `foods_service`.`ynum_fw_msg` (`id`,`fw_name`,`min`,`max`)  VALUES('4','范围名3','1.8','11.2');
INSERT INTO `foods_service`.`ynum_fw_msg` (`id`,`fw_name`,`min`,`max`)  VALUES('5','范围名4','23.5','29.0');
INSERT INTO `foods_service`.`ydxhfw_msg` (`id`,`fw_name`,`min`,`max`)  VALUES('1','范围名0','34.5','64.7');
INSERT INTO `foods_service`.`ydxhfw_msg` (`id`,`fw_name`,`min`,`max`)  VALUES('2','范围名1','98.4','90.1');
INSERT INTO `foods_service`.`ydxhfw_msg` (`id`,`fw_name`,`min`,`max`)  VALUES('3','范围名2','71.6','64.8');
INSERT INTO `foods_service`.`ydxhfw_msg` (`id`,`fw_name`,`min`,`max`)  VALUES('4','范围名3','27.8','20.7');
INSERT INTO `foods_service`.`ydxhfw_msg` (`id`,`fw_name`,`min`,`max`)  VALUES('5','范围名4','97.1','51.3');
INSERT INTO `foods_service`.`ysjh_msg` (`id`,`jh_name`,`fm_img`,`bmifw`,`ynum_fw`,`jh_detail`,`fb_time`)  VALUES('1','计划名0','http://localhost:8080/foods_service/static/images/4/1.png','1','5','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2025-03-20 17:55:45');
INSERT INTO `foods_service`.`ysjh_msg` (`id`,`jh_name`,`fm_img`,`bmifw`,`ynum_fw`,`jh_detail`,`fb_time`)  VALUES('2','计划名1','http://localhost:8080/foods_service/static/images/4/2.png','4','2','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2025-03-20 17:55:45');
INSERT INTO `foods_service`.`ysjh_msg` (`id`,`jh_name`,`fm_img`,`bmifw`,`ynum_fw`,`jh_detail`,`fb_time`)  VALUES('3','计划名2','http://localhost:8080/foods_service/static/images/4/3.png','4','2','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2025-03-20 17:55:45');
INSERT INTO `foods_service`.`ysjh_msg` (`id`,`jh_name`,`fm_img`,`bmifw`,`ynum_fw`,`jh_detail`,`fb_time`)  VALUES('4','计划名3','http://localhost:8080/foods_service/static/images/4/4.png','5','3','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2025-03-20 17:55:45');
INSERT INTO `foods_service`.`ysjh_msg` (`id`,`jh_name`,`fm_img`,`bmifw`,`ynum_fw`,`jh_detail`,`fb_time`)  VALUES('5','计划名4','http://localhost:8080/foods_service/static/images/4/5.png','3','5','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2025-03-20 17:55:45');
INSERT INTO `foods_service`.`ydjh_msg` (`id`,`jh_name`,`fm_img`,`bmifw`,`ydxhfw`,`jh_detail`,`fb_time`)  VALUES('1','计划名0','http://localhost:8080/foods_service/static/images/1/1.jpg','5','3','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2025-03-20 17:55:46');
INSERT INTO `foods_service`.`ydjh_msg` (`id`,`jh_name`,`fm_img`,`bmifw`,`ydxhfw`,`jh_detail`,`fb_time`)  VALUES('2','计划名1','http://localhost:8080/foods_service/static/images/1/2.jpg','4','1','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2025-03-21 17:55:46');
INSERT INTO `foods_service`.`ydjh_msg` (`id`,`jh_name`,`fm_img`,`bmifw`,`ydxhfw`,`jh_detail`,`fb_time`)  VALUES('3','计划名2','http://localhost:8080/foods_service/static/images/1/3.jpg','3','2','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2025-03-21 17:55:46');
INSERT INTO `foods_service`.`ydjh_msg` (`id`,`jh_name`,`fm_img`,`bmifw`,`ydxhfw`,`jh_detail`,`fb_time`)  VALUES('4','计划名3','http://localhost:8080/foods_service/static/images/1/4.jpg','2','1','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2025-03-21 17:55:46');
INSERT INTO `foods_service`.`ydjh_msg` (`id`,`jh_name`,`fm_img`,`bmifw`,`ydxhfw`,`jh_detail`,`fb_time`)  VALUES('5','计划名4','http://localhost:8080/foods_service/static/images/1/5.jpg','4','5','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2025-03-20 17:55:46');
INSERT INTO `foods_service`.`ys_collect_msg` (`id`,`ysjh`,`user_id`,`collect_time`)  VALUES('1','1','3','2025-03-21 17:55:46');
INSERT INTO `foods_service`.`ys_collect_msg` (`id`,`ysjh`,`user_id`,`collect_time`)  VALUES('2','1','5','2025-03-21 17:55:46');
INSERT INTO `foods_service`.`ys_collect_msg` (`id`,`ysjh`,`user_id`,`collect_time`)  VALUES('3','5','1','2025-03-21 17:55:46');
INSERT INTO `foods_service`.`ys_collect_msg` (`id`,`ysjh`,`user_id`,`collect_time`)  VALUES('4','2','2','2025-03-20 17:55:46');
INSERT INTO `foods_service`.`ys_collect_msg` (`id`,`ysjh`,`user_id`,`collect_time`)  VALUES('5','1','1','2025-03-20 17:55:46');
INSERT INTO `foods_service`.`yd_collect_msg` (`id`,`ydjh`,`user_id`,`collect_time`)  VALUES('1','3','1','2025-03-20 17:55:46');
INSERT INTO `foods_service`.`yd_collect_msg` (`id`,`ydjh`,`user_id`,`collect_time`)  VALUES('2','1','4','2025-03-21 17:55:46');
INSERT INTO `foods_service`.`yd_collect_msg` (`id`,`ydjh`,`user_id`,`collect_time`)  VALUES('3','1','1','2025-03-20 17:55:46');
INSERT INTO `foods_service`.`yd_collect_msg` (`id`,`ydjh`,`user_id`,`collect_time`)  VALUES('4','3','2','2025-03-20 17:55:46');
INSERT INTO `foods_service`.`yd_collect_msg` (`id`,`ydjh`,`user_id`,`collect_time`)  VALUES('5','5','4','2025-03-21 17:55:46');
INSERT INTO `foods_service`.`post_msg` (`id`,`title`,`subtitle`,`post_detail`,`user_id`,`fb_time`)  VALUES('1','标题0','副标题0','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2','2025-03-20 17:55:46');
INSERT INTO `foods_service`.`post_msg` (`id`,`title`,`subtitle`,`post_detail`,`user_id`,`fb_time`)  VALUES('2','标题1','副标题1','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2','2025-03-20 17:55:46');
INSERT INTO `foods_service`.`post_msg` (`id`,`title`,`subtitle`,`post_detail`,`user_id`,`fb_time`)  VALUES('3','标题2','副标题2','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','5','2025-03-20 17:55:46');
INSERT INTO `foods_service`.`post_msg` (`id`,`title`,`subtitle`,`post_detail`,`user_id`,`fb_time`)  VALUES('4','标题3','副标题3','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','4','2025-03-20 17:55:46');
INSERT INTO `foods_service`.`post_msg` (`id`,`title`,`subtitle`,`post_detail`,`user_id`,`fb_time`)  VALUES('5','标题4','副标题4','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','1','2025-03-21 17:55:46');
INSERT INTO `foods_service`.`dis_msg` (`id`,`post_id`,`dis_content`,`user_id`,`dis_time`)  VALUES('1','2','评论内容0','2','2025-03-21 17:55:46');
INSERT INTO `foods_service`.`dis_msg` (`id`,`post_id`,`dis_content`,`user_id`,`dis_time`)  VALUES('2','3','评论内容1','5','2025-03-21 17:55:46');
INSERT INTO `foods_service`.`dis_msg` (`id`,`post_id`,`dis_content`,`user_id`,`dis_time`)  VALUES('3','4','评论内容2','3','2025-03-21 17:55:46');
INSERT INTO `foods_service`.`dis_msg` (`id`,`post_id`,`dis_content`,`user_id`,`dis_time`)  VALUES('4','3','评论内容3','5','2025-03-21 17:55:46');
INSERT INTO `foods_service`.`dis_msg` (`id`,`post_id`,`dis_content`,`user_id`,`dis_time`)  VALUES('5','5','评论内容4','3','2025-03-20 17:55:46');
INSERT INTO `foods_service`.`reply_msg` (`id`,`dis_id`,`reply_content`,`user_id`,`reply_time`)  VALUES('1','1','回复内容0','1','2025-03-20 17:55:46');
INSERT INTO `foods_service`.`reply_msg` (`id`,`dis_id`,`reply_content`,`user_id`,`reply_time`)  VALUES('2','3','回复内容1','1','2025-03-21 17:55:46');
INSERT INTO `foods_service`.`reply_msg` (`id`,`dis_id`,`reply_content`,`user_id`,`reply_time`)  VALUES('3','1','回复内容2','3','2025-03-20 17:55:46');
INSERT INTO `foods_service`.`reply_msg` (`id`,`dis_id`,`reply_content`,`user_id`,`reply_time`)  VALUES('4','3','回复内容3','1','2025-03-21 17:55:46');
INSERT INTO `foods_service`.`reply_msg` (`id`,`dis_id`,`reply_content`,`user_id`,`reply_time`)  VALUES('5','1','回复内容4','2','2025-03-21 17:55:46');
INSERT INTO `foods_service`.`lmsg_suggest_msg` (`id`,`title`,`lmsg_content`,`lmsg_img`,`user_id`,`lmsg_status`,`reply_content`,`lmsg_time`)  VALUES('1','标题0','留言内容0','http://localhost:8080/foods_service/static/images/1/1.jpg','5','1','回复内容0','2025-03-20 17:55:46');
INSERT INTO `foods_service`.`lmsg_suggest_msg` (`id`,`title`,`lmsg_content`,`lmsg_img`,`user_id`,`lmsg_status`,`reply_content`,`lmsg_time`)  VALUES('2','标题1','留言内容1','http://localhost:8080/foods_service/static/images/1/2.jpg','2','1','回复内容1','2025-03-21 17:55:46');
INSERT INTO `foods_service`.`lmsg_suggest_msg` (`id`,`title`,`lmsg_content`,`lmsg_img`,`user_id`,`lmsg_status`,`reply_content`,`lmsg_time`)  VALUES('3','标题2','留言内容2','http://localhost:8080/foods_service/static/images/1/3.jpg','3','1','回复内容2','2025-03-21 17:55:46');
INSERT INTO `foods_service`.`lmsg_suggest_msg` (`id`,`title`,`lmsg_content`,`lmsg_img`,`user_id`,`lmsg_status`,`reply_content`,`lmsg_time`)  VALUES('4','标题3','留言内容3','http://localhost:8080/foods_service/static/images/1/4.jpg','1','1','回复内容3','2025-03-21 17:55:46');
INSERT INTO `foods_service`.`lmsg_suggest_msg` (`id`,`title`,`lmsg_content`,`lmsg_img`,`user_id`,`lmsg_status`,`reply_content`,`lmsg_time`)  VALUES('5','标题4','留言内容4','http://localhost:8080/foods_service/static/images/1/5.jpg','2','1','回复内容4','2025-03-20 17:55:46');
INSERT INTO `foods_service`.`yyxcs_msg` (`id`,`title`,`fm_img`,`cs_content`,`fb_time`)  VALUES('1','标题0','http://localhost:8080/foods_service/static/images/1/1.jpg','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2025-03-20 17:55:46');
INSERT INTO `foods_service`.`yyxcs_msg` (`id`,`title`,`fm_img`,`cs_content`,`fb_time`)  VALUES('2','标题1','http://localhost:8080/foods_service/static/images/1/2.jpg','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2025-03-20 17:55:46');
INSERT INTO `foods_service`.`yyxcs_msg` (`id`,`title`,`fm_img`,`cs_content`,`fb_time`)  VALUES('3','标题2','http://localhost:8080/foods_service/static/images/1/3.jpg','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2025-03-20 17:55:46');
INSERT INTO `foods_service`.`yyxcs_msg` (`id`,`title`,`fm_img`,`cs_content`,`fb_time`)  VALUES('4','标题3','http://localhost:8080/foods_service/static/images/1/4.jpg','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2025-03-21 17:55:46');
INSERT INTO `foods_service`.`yyxcs_msg` (`id`,`title`,`fm_img`,`cs_content`,`fb_time`)  VALUES('5','标题4','http://localhost:8080/foods_service/static/images/1/5.jpg','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2025-03-21 17:55:46');
INSERT INTO `foods_service`.`xt_intro_msg` (`id`,`title`,`fm_img`,`intro_detail`,`celphone`,`address`,`email`)  VALUES('1','标题0','http://localhost:8080/foods_service/static/images/1/1.jpg','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','13052653265','地址0','05236585@qq.com');
INSERT INTO `foods_service`.`banner_msg` (`id`,`banner`)  VALUES('1','http://localhost:8080/foods_service/static/images/3/2.jpg');
INSERT INTO `foods_service`.`banner_msg` (`id`,`banner`)  VALUES('2','http://localhost:8080/foods_service/static/images/3/3.jpg');
INSERT INTO `foods_service`.`banner_msg` (`id`,`banner`)  VALUES('3','http://localhost:8080/foods_service/static/images/3/4.jpg');
INSERT INTO `foods_service`.`banner_msg` (`id`,`banner`)  VALUES('4','http://localhost:8080/foods_service/static/images/3/5.jpg');
INSERT INTO `foods_service`.`banner_msg` (`id`,`banner`)  VALUES('5','http://localhost:8080/foods_service/static/images/3/6.jpg');