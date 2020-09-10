

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mall_order_item
-- ----------------------------
DROP TABLE IF EXISTS `mall_order_item`;
CREATE TABLE `mall_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单子表id',
  `user_id` int(11) DEFAULT NULL,
  `order_no` bigint(20) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL COMMENT '商品id',
  `product_name` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `product_image` varchar(500) DEFAULT NULL COMMENT '商品图片地址',
  `current_unit_price` decimal(20,2) DEFAULT NULL COMMENT '下单时商品单价RMB,保留两位小数',
  `quantity` int(10) DEFAULT NULL COMMENT '商品数量',
  `total_price` decimal(20,2) DEFAULT NULL COMMENT '商品总价RMB,保留两位小数',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  KEY `order_no_index` (`order_no`) USING BTREE,
  KEY `order_no_user_id_index` (`user_id`,`order_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mall_order_item
-- ----------------------------
INSERT INTO `mall_order_item` VALUES ('9', '3', '2146620071', '6', '绝命毒师全5季', 'https://m.media-amazon.com/images/I/91g-wvbhEfL._AC_UY218_.jpg', '899.00', '1', '899.00', '2020-09-05 14:13:01', '2020-09-05 14:13:01');
INSERT INTO `mall_order_item` VALUES ('10', '3', '2146620071', '19', '小米10 Ultra', 'https://cdn.dxomark.com/wp-content/uploads/medias/post-50844/xiaomimi10ultra.jpg', '5299.00', '1', '5299.00', '2020-09-05 14:13:01', '2020-09-05 14:13:01');
INSERT INTO `mall_order_item` VALUES ('11', '3', '2146620071', '3', '瑞克和莫蒂 Rick姥爷UFO', '/imgs/product/main-product-3.jpg', '1299.00', '2', '2598.00', '2020-09-05 14:13:01', '2020-09-05 14:13:01');
INSERT INTO `mall_order_item` VALUES ('12', '3', '251071072', '14', '风骚律师第5季', 'https://m.media-amazon.com/images/I/911dnC5hoaL._AC_UY218_.jpg', '349.00', '1', '349.00', '2020-09-05 20:16:58', '2020-09-05 20:16:58');
INSERT INTO `mall_order_item` VALUES ('13', '3', '159187104', '2', '华为P50 5G旗舰', '/imgs/product/main-product-2.jpg', '8999.00', '1', '8999.00', '2020-09-05 21:15:14', '2020-09-05 21:15:14');
INSERT INTO `mall_order_item` VALUES ('14', '3', '159187104', '4', 'TWD 瑞克同款牛仔夹克', '/imgs/product/main-product-4.jpg', '3999.00', '1', '3999.00', '2020-09-05 21:15:14', '2020-09-05 21:15:14');
INSERT INTO `mall_order_item` VALUES ('15', '3', '1423387337', '15', 'Pickle Rick 黑色短袖 百搭', 'https://m.media-amazon.com/images/I/A13usaonutL._AC_CLa%7C2140%2C2000%7C81lCTyhTYXL.png%7C0%2C0%2C2140%2C2000%2B0.0%2C0.0%2C2140.0%2C2000.0_UX466_.png', '249.00', '1', '249.00', '2020-09-05 22:26:46', '2020-09-05 22:26:46');
INSERT INTO `mall_order_item` VALUES ('16', '4', '1517709139', '3', '瑞克和莫蒂 Rick姥爷UFO', '/imgs/product/main-product-3.jpg', '1299.00', '1', '1299.00', '2020-09-06 22:15:34', '2020-09-06 22:15:34');
INSERT INTO `mall_order_item` VALUES ('17', '3', '2103231513', '24', 'Google Pixel 4', 'https://cdn.dxomark.com/wp-content/uploads/medias/post-35617/Clearly-White-Pixel-4-Front_Back-1024x768.jpg', '6999.00', '1', '6999.00', '2020-09-07 10:34:06', '2020-09-07 10:34:06');
INSERT INTO `mall_order_item` VALUES ('18', '3', '350140606', '5', 'Samsung Galaxy buds', '/imgs/product/main-product-5.png', '1499.00', '1', '1499.00', '2020-09-07 10:34:42', '2020-09-07 10:34:42');
INSERT INTO `mall_order_item` VALUES ('19', '4', '1163644090', '4', 'TWD 瑞克同款牛仔夹克', '/imgs/product/main-product-4.jpg', '3999.00', '1', '3999.00', '2020-09-07 10:35:55', '2020-09-07 10:35:55');
INSERT INTO `mall_order_item` VALUES ('20', '4', '2137632416', '11', '风骚律师第3季', 'https://m.media-amazon.com/images/I/A1dF3y4zGcL._AC_UY218_.jpg', '349.00', '1', '349.00', '2020-09-07 10:36:24', '2020-09-07 10:36:24');
INSERT INTO `mall_order_item` VALUES ('21', '4', '1401828009', '12', '无耻之徒全10季', 'https://m.media-amazon.com/images/I/81wJW8nRwVL._AC_UY218_.jpg', '1299.00', '1', '1299.00', '2020-09-07 10:38:16', '2020-09-07 10:38:16');
INSERT INTO `mall_order_item` VALUES ('22', '4', '1943650881', '13', '风骚律师第4季', 'https://m.media-amazon.com/images/I/81+HloHHyuL._AC_UY218_.jpg', '349.00', '1', '349.00', '2020-09-07 10:38:28', '2020-09-07 10:38:28');
