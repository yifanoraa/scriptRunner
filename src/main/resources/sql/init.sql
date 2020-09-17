DROP TABLE IF EXISTS `job_scheduled`;
DROP TABLE IF EXISTS `testuser`;
CREATE TABLE `job_scheduled` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) not NULL,
  `cron` varchar(128) Not null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `jobConfig`;
