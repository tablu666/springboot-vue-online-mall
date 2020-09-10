

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mall_order
-- ----------------------------
DROP TABLE IF EXISTS `mall_order`;
CREATE TABLE `mall_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `order_no` bigint(20) DEFAULT NULL COMMENT '订单号',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) DEFAULT NULL COMMENT '收货地址id',
  `receiver_name` varchar(20) DEFAULT NULL COMMENT '收货姓名',
  `receiver_mobile` varchar(20) DEFAULT NULL COMMENT '收货电话',
  `receiver_province` varchar(20) DEFAULT NULL COMMENT '省份',
  `receiver_city` varchar(20) DEFAULT NULL COMMENT '城市',
  `receiver_district` varchar(20) DEFAULT NULL COMMENT '区/县',
  `receiver_address` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `receiver_zip` varchar(6) DEFAULT NULL COMMENT '邮编',
  `payment` decimal(20,2) DEFAULT NULL COMMENT '付款金额RMB,保留两位小数',
  `payment_type` int(4) DEFAULT NULL COMMENT '支付类型,1-在线支付,2-验证码支付/temp',
  `postage` int(10) DEFAULT NULL COMMENT '运费RMB',
  `status` int(10) DEFAULT NULL COMMENT '订单状态:0-已取消,10-未付款,20-已付款,40-已发货,50-交易成功,60-交易关闭',
  `payment_time` datetime DEFAULT NULL COMMENT '支付时间',
  `send_time` datetime DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime DEFAULT NULL COMMENT '交易完成时间',
  `close_time` datetime DEFAULT NULL COMMENT '交易关闭时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_no_index` (`order_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mall_order
-- ----------------------------
INSERT INTO `mall_order` VALUES ('6', '2146620071', '3', '10', '小飞侠', '13966666666', '浙江省', '宁波市', '鄞州区', '菜鸟驿站', '315100', '8796.00', '2', '0', '20', '2020-09-05 10:28:28', null, null, null, '2020-09-05 14:13:01', '2020-09-05 14:13:01');
INSERT INTO `mall_order` VALUES ('7', '251071072', '3', '10', '小飞侠', '13966666666', '浙江省', '宁波市', '鄞州区', '菜鸟驿站', '315100', '349.00', '2', '0', '20', '2020-09-05 12:17:46', null, null, null, '2020-09-05 20:16:58', '2020-09-05 20:16:58');
INSERT INTO `mall_order` VALUES ('8', '159187104', '3', '10', '小飞侠', '13966666666', '浙江省', '宁波市', '鄞州区', '菜鸟驿站', '315100', '12998.00', '2', '0', '10', null, null, null, null, '2020-09-05 21:15:14', '2020-09-05 21:15:14');
INSERT INTO `mall_order` VALUES ('9', '1423387337', '3', '10', '小飞侠', '13966666666', '浙江省', '宁波市', '鄞州区', '菜鸟驿站', '315100', '249.00', '2', '0', '10', null, null, null, null, '2020-09-05 22:26:46', '2020-09-05 22:26:46');
INSERT INTO `mall_order` VALUES ('10', '1517709139', '4', '12', '奥力给', '15088888888', '山东省', '青岛市', '崂山区', '中国海洋大学OUC', '266100', '1299.00', '2', '0', '10', null, null, null, null, '2020-09-06 22:15:34', '2020-09-06 22:15:34');
INSERT INTO `mall_order` VALUES ('11', '2103231513', '3', '10', '小飞侠', '13966666666', '浙江省', '宁波市', '鄞州区', '菜鸟驿站', '315100', '6999.00', '2', '0', '10', null, null, null, null, '2020-09-07 10:34:06', '2020-09-07 10:34:06');
INSERT INTO `mall_order` VALUES ('12', '350140606', '3', '10', '小飞侠', '13966666666', '浙江省', '宁波市', '鄞州区', '菜鸟驿站', '315100', '1499.00', '2', '0', '20', '2020-09-07 02:34:57', null, null, null, '2020-09-07 10:34:42', '2020-09-07 10:34:42');
INSERT INTO `mall_order` VALUES ('13', '1163644090', '4', '12', '奥力给', '15088888888', '山东省', '青岛市', '崂山区', '中国海洋大学OUC', '266100', '3999.00', '2', '0', '10', null, null, null, null, '2020-09-07 10:35:55', '2020-09-07 10:35:55');
INSERT INTO `mall_order` VALUES ('14', '2137632416', '4', '12', '奥力给', '15088888888', '山东省', '青岛市', '崂山区', '中国海洋大学OUC', '266100', '349.00', '2', '0', '10', null, null, null, null, '2020-09-07 10:36:24', '2020-09-07 10:36:24');
INSERT INTO `mall_order` VALUES ('15', '1401828009', '4', '12', '奥力给', '15088888888', '山东省', '青岛市', '崂山区', '中国海洋大学OUC', '266100', '1299.00', '2', '0', '10', null, null, null, null, '2020-09-07 10:38:16', '2020-09-07 10:38:16');
INSERT INTO `mall_order` VALUES ('16', '1943650881', '4', '12', '奥力给', '15088888888', '山东省', '青岛市', '崂山区', '中国海洋大学OUC', '266100', '349.00', '2', '0', '10', null, null, null, null, '2020-09-07 10:38:28', '2020-09-07 10:38:28');
