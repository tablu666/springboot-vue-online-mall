

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mall_shipping
-- ----------------------------
DROP TABLE IF EXISTS `mall_shipping`;
CREATE TABLE `mall_shipping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `receiver_name` varchar(20) DEFAULT NULL COMMENT '收货姓名',
  `receiver_mobile` varchar(20) DEFAULT NULL COMMENT '收货电话',
  `receiver_province` varchar(20) DEFAULT NULL COMMENT '省份',
  `receiver_city` varchar(20) DEFAULT NULL COMMENT '城市',
  `receiver_district` varchar(20) DEFAULT NULL COMMENT '区/县',
  `receiver_address` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `receiver_zip` varchar(6) DEFAULT NULL COMMENT '邮编',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mall_shipping
-- ----------------------------
INSERT INTO `mall_shipping` VALUES ('1', '3', '小飞侠', '13966666666', '浙江省', '宁波市', '鄞州区', '菜鸟驿站', '315100', '2020-09-05 13:57:59', '2020-09-05 13:58:27');
INSERT INTO `mall_shipping` VALUES ('2', '3', '大宝剑', '15088888888', '上海市', '上海市', '浦东新区', '菜鸟驿站', '200120', '2020-09-07 12:33:40', '2020-09-07 12:33:40');
