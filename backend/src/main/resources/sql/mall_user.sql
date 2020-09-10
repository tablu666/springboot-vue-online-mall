

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mall_user
-- ----------------------------
DROP TABLE IF EXISTS `mall_user`;
CREATE TABLE `mall_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '用户密码,BCrypt加密',
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `question` varchar(100) DEFAULT NULL COMMENT '找回密码问题',
  `answer` varchar(100) DEFAULT NULL COMMENT '找回密码答案',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mall_user
-- ----------------------------
INSERT INTO `mall_user` VALUES ('1', 'employee', '$2a$10$lwuqwxt1bd9knB4XAkw8/.jRsxa7Qy.l/2HSTDAz33LRPkD2tj.Zq', 'employee@outlook.com', null, null, null, '2020-08-18 16:20:56', '2020-08-20 09:48:25');
INSERT INTO `mall_user` VALUES ('2', 'manager', '$2a$10$cgE9htwvrXq9Fw34Jf8M3e.kc8.ZEIcBSpL8IzuMBsDllmPTQFbqW', 'manager@outlook.com', null, null, null, '2020-08-20 09:58:56', '2020-08-20 09:58:56');
INSERT INTO `mall_user` VALUES ('3', 'jimmy', '$2a$10$ql4CcFheOE.uSj902842fOdtma5Qppd54OtjM2yIWGSgDuHL6Fr7i', 'saulgoodman@gmail.com', null, null, null, '2020-08-19 23:32:28', '2020-08-19 23:32:28');
