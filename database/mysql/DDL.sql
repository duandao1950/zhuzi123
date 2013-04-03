delimiter $$

CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `style_id` int(11) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `author_id` int(11) NOT NULL,
  `content` longtext NOT NULL,
  `content_ext` longtext,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `article_read` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NOT NULL,
  `read_count` int(11) DEFAULT '0',
  `like_count` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `period_id` varchar(45) DEFAULT NULL,
  `author_name` varchar(45) NOT NULL,
  `name_pying` varchar(45) DEFAULT NULL,
  `birth` datetime DEFAULT NULL,
  `death` datetime DEFAULT NULL,
  `is_valid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `author_read` (
  `id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL,
  `read_count` int(11) DEFAULT '0',
  `like_count` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `dic_key` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `table_name` varchar(45) DEFAULT NULL,
  `key` varchar(45) DEFAULT NULL,
  `EFF_DATE` varchar(45) DEFAULT NULL,
  `EXP_DATE` varchar(45) DEFAULT NULL,
  `ORDERNUMBER` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `dic_value` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `table_name` varchar(45) DEFAULT NULL,
  `value` varchar(45) DEFAULT NULL,
  `value_ext1` varchar(45) DEFAULT NULL,
  `value_ext2` varchar(45) DEFAULT NULL,
  `value_addi` varchar(45) DEFAULT NULL,
  `language` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` varchar(45) NOT NULL,
  `permission_name` varchar(45) DEFAULT NULL,
  `permission_note` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` varchar(45) NOT NULL,
  `ROLE_NAME` varchar(45) NOT NULL,
  `DESCRIPTION` varchar(45) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(45) NOT NULL,
  `permission_id` varchar(45) NOT NULL,
  `role_permission_note` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `user` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `mobile_phone` varchar(45) DEFAULT NULL,
  `local_ip` varchar(45) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `ID_2` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gb2312$$

delimiter $$

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `role_id` varchar(45) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8$$

