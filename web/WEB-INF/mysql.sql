

CREATE TABLE `user_register_table` (
   `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
   `username` varchar(20) DEFAULT 'Null',
   `email` varchar(50) NOT NULL,
   `password` varchar(50) NOT NULL,
   `activatecode` varchar(50) DEFAULT NULL,
   `status` char(1) DEFAULT NULL,
   `registerdate` timestamp NULL DEFAULT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8




