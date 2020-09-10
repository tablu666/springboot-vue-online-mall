

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mall_role
-- ----------------------------
DROP TABLE IF EXISTS `mall_role`;
CREATE TABLE `mall_role` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '角色表id',
  `role_name` varchar(30) DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(60) DEFAULT NULL COMMENT '角色描述',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mall_role
-- ----------------------------
INSERT INTO `mall_role` VALUES ('1', 'ROLE_CUSTOMER', '用户', '2020-08-19 13:56:01', '2020-08-19 13:56:01');
INSERT INTO `mall_role` VALUES ('2', 'ROLE_EMPLOYEE', '员工', '2020-08-19 13:56:01', '2020-08-19 13:56:01');
INSERT INTO `mall_role` VALUES ('3', 'ROLE_MANAGER', '经理', '2020-08-19 13:56:01', '2020-08-19 13:56:01');
INSERT INTO `mall_role` VALUES ('4', 'ROLE_TEST', '内测', '2020-08-25 10:21:17', '2020-08-25 10:24:07');
