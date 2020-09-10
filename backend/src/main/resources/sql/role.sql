DROP TABLE IF EXISTS `mall_role`;
CREATE TABLE `mall_role` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '角色表id',
  `role_name` varchar(30) DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(60) DEFAULT NULL COMMENT '角色描述',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `mall_role` (`id`,`role_name`, `role_desc`)
VALUES
	(1,'ROLE_CUSTOMER','用户'),
	(2,'ROLE_EMPLOYEE','员工'),
	(3,'ROLE_MANAGER','经理');