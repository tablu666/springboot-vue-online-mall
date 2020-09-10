

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mall_product
-- ----------------------------
DROP TABLE IF EXISTS `mall_product`;
CREATE TABLE `mall_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `category_id` int(11) NOT NULL COMMENT '分类id,对应mall_category表的主键',
  `mark_id` tinyint(3) DEFAULT NULL COMMENT '美剧标识,对应mall_category表的mark字段',
  `name` varchar(100) NOT NULL COMMENT '商品名称',
  `subtitle` varchar(200) DEFAULT NULL COMMENT '商品副标题',
  `main_image` varchar(500) DEFAULT NULL COMMENT '产品主图,url',
  `sub_images` text COMMENT '图片地址,json格式,扩展用',
  `detail` text COMMENT '商品详情',
  `price` decimal(20,2) NOT NULL COMMENT '价格RMB,保留两位小数',
  `stock` int(11) NOT NULL COMMENT '库存数量',
  `status` int(6) DEFAULT '1' COMMENT '商品状态.1-在售 2-下架 3-删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mall_product
-- ----------------------------
INSERT INTO `mall_product` VALUES ('1', '100012', '1', 'iPhone12 沙漠金', '【绝命毒师】联名款上线', '/imgs/product/main-product-1.jpg', null, null, '12999.00', '20', '1', '2020-08-17 14:36:23', '2020-09-05 21:38:58');
INSERT INTO `mall_product` VALUES ('2', '100012', '2', '华为P50 5G旗舰', 'HUAWEI 联手风骚律师，震撼来袭', '/imgs/product/main-product-2.jpg', null, null, '8999.00', '20', '1', '2020-08-17 14:36:23', '2020-09-05 21:39:01');
INSERT INTO `mall_product` VALUES ('3', '100017', '5', '瑞克和莫蒂 Rick姥爷UFO', '真实还原Rick姥爷座驾细节', '/imgs/product/main-product-3.jpg', null, null, '1299.00', '19', '1', '2020-08-17 14:36:23', '2020-09-05 21:39:04');
INSERT INTO `mall_product` VALUES ('4', '100019', '3', 'TWD 瑞克同款牛仔夹克', 'TWD联名，穿上更有型', '/imgs/product/main-product-4.jpg', null, null, '3999.00', '19', '1', '2020-08-25 11:07:28', '2020-09-05 21:39:06');
INSERT INTO `mall_product` VALUES ('5', '100015', '4', 'Samsung Galaxy buds', '无耻之徒大姐Fiona形象代言', '/imgs/product/main-product-5.png', null, null, '1499.00', '19', '1', '2020-08-28 22:33:08', '2020-09-05 21:39:08');
INSERT INTO `mall_product` VALUES ('6', '100002', '1', '绝命毒师全5季', '豆瓣高分神剧', 'https://m.media-amazon.com/images/I/91g-wvbhEfL._AC_UY218_.jpg', null, null, '899.00', '20', '1', '2020-08-29 22:55:40', '2020-09-05 21:39:12');
INSERT INTO `mall_product` VALUES ('7', '100002', '2', '风骚律师第1季', '毒师衍生剧', 'https://m.media-amazon.com/images/I/A1xY64ADdZL._AC_UY218_.jpg', null, null, '349.00', '20', '1', '2020-08-29 23:00:12', '2020-08-30 20:35:52');
INSERT INTO `mall_product` VALUES ('8', '100002', '3', '行尸走肉全10季', '战丧尸小分队', 'https://m.media-amazon.com/images/I/810WkI17sAL._AC_UY218_.jpg', null, null, '1299.00', '20', '1', '2020-08-29 23:02:49', '2020-08-30 20:50:07');
INSERT INTO `mall_product` VALUES ('9', '100002', '2', '风骚律师第2季', '毒师衍生剧', 'https://m.media-amazon.com/images/I/A1MjwiXxzRL._AC_UY654_FMwebp_QL65_.jpg', null, null, '349.00', '20', '1', '2020-08-29 23:06:40', '2020-08-30 20:43:05');
INSERT INTO `mall_product` VALUES ('10', '100002', '5', '瑞克和莫蒂全4季', 'Rick永远滴神', 'https://m.media-amazon.com/images/I/81g8noVZI-L._AC_UY218_.jpg', null, null, '899.00', '20', '1', '2020-08-29 23:08:37', '2020-08-30 20:49:28');
INSERT INTO `mall_product` VALUES ('11', '100002', '2', '风骚律师第3季', '毒师衍生剧', 'https://m.media-amazon.com/images/I/A1dF3y4zGcL._AC_UY218_.jpg', null, null, '349.00', '19', '1', '2020-08-30 20:38:31', '2020-08-30 20:46:06');
INSERT INTO `mall_product` VALUES ('12', '100002', '4', '无耻之徒全10季', 'Gallagher!', 'https://m.media-amazon.com/images/I/81wJW8nRwVL._AC_UY218_.jpg', null, null, '1299.00', '19', '1', '2020-08-30 20:39:51', '2020-08-30 20:50:36');
INSERT INTO `mall_product` VALUES ('13', '100002', '2', '风骚律师第4季', '毒师衍生剧', 'https://m.media-amazon.com/images/I/81+HloHHyuL._AC_UY218_.jpg', null, null, '349.00', '19', '1', '2020-08-30 20:46:25', '2020-08-30 20:48:12');
INSERT INTO `mall_product` VALUES ('14', '100002', '2', '风骚律师第5季', '毒师衍生剧', 'https://m.media-amazon.com/images/I/911dnC5hoaL._AC_UY218_.jpg', null, null, '349.00', '20', '1', '2020-08-30 20:47:03', '2020-09-05 21:39:16');
INSERT INTO `mall_product` VALUES ('15', '100019', '5', 'Pickle Rick 黑色短袖 百搭', '腌黄瓜，回味无穷', 'https://m.media-amazon.com/images/I/A13usaonutL._AC_CLa%7C2140%2C2000%7C81lCTyhTYXL.png%7C0%2C0%2C2140%2C2000%2B0.0%2C0.0%2C2140.0%2C2000.0_UX466_.png', null, null, '249.00', '19', '1', '2020-08-30 21:28:46', '2020-09-05 21:39:19');
INSERT INTO `mall_product` VALUES ('16', '100021', '1', '绝命毒师 老白白T', 'Heisenberg!', 'https://m.media-amazon.com/images/I/71OcUF5LyML._AC_UY218_.jpg', null, null, '99.00', '20', '1', '2020-08-30 21:31:09', '2020-09-05 21:39:21');
INSERT INTO `mall_product` VALUES ('17', '100017', '2', 'Better call saul 迷你手办', '索尔律师造型', 'https://images-eu.ssl-images-amazon.com/images/I/51oImP5sEVL._SY300_QL70_ML2_.jpg', null, null, '249.00', '20', '1', '2020-08-30 21:42:53', '2020-09-05 21:39:24');
INSERT INTO `mall_product` VALUES ('18', '100017', '3', '行尸走肉 尼根 棒球模型', 'Lucille是真的猛', 'https://cdn.shopify.com/s/files/1/1041/0702/products/33inch-The-Walking-Dead-tool-Negan-PU-baseball-bat-softball-bit-stick.jpg_640x640_a890e185-72e3-4aab-afac-6287d54e7804_1024x1024.jpg?v=1543256024', null, null, '329.00', '20', '1', '2020-08-30 21:51:34', '2020-09-05 21:39:26');
INSERT INTO `mall_product` VALUES ('19', '100012', '3', '小米10 Ultra', 'Xiaomi 10周年 美剧TWD纪念版', 'https://cdn.dxomark.com/wp-content/uploads/medias/post-50844/xiaomimi10ultra.jpg', null, null, '5299.00', '20', '1', '2020-09-01 11:22:38', '2020-09-05 21:39:29');
INSERT INTO `mall_product` VALUES ('20', '100012', '4', '三星 S20 Ultra', 'Samsung [Shameless]联名 限量款', 'https://cdn.dxomark.com/wp-content/uploads/medias/post-44843/SS_S20_Ultra_Catalog_Gray_F_B.jpg', null, null, '9999.00', '20', '1', '2020-09-01 11:30:53', '2020-09-05 21:39:33');
INSERT INTO `mall_product` VALUES ('21', '100012', '5', 'Oppo Find X2 Pro', '绿厂强势联名高口碑烧脑动漫R&M', 'https://cdn.dxomark.com/wp-content/uploads/medias/post-42531/oppofindx2pro-550x413.jpg', null, null, '7299.00', '10', '1', '2020-09-01 14:45:11', '2020-09-01 14:49:11');
INSERT INTO `mall_product` VALUES ('22', '100012', '1', 'OnePlus 8 Pro', '一加 [Breaking Bad]联名 至尊版', 'https://cdn.dxomark.com/wp-content/uploads/medias/post-47840/oneplus8Pro-550x412.jpg', null, null, '4999.00', '10', '1', '2020-09-01 14:57:36', '2020-09-01 14:58:42');
INSERT INTO `mall_product` VALUES ('23', '100012', '3', 'Sony Xperia 1 II', '索尼&The.Walking.Dead，为信仰充值 ', 'https://cdn.dxomark.com/wp-content/uploads/medias/post-50656/sonyyxperia1ii-550x413.jpg', null, null, '14999.00', '10', '1', '2020-09-01 15:00:59', '2020-09-01 15:01:56');
INSERT INTO `mall_product` VALUES ('24', '100012', '5', 'Google Pixel 4', '太子联名Rick.and.Morty 太空探索版', 'https://cdn.dxomark.com/wp-content/uploads/medias/post-35617/Clearly-White-Pixel-4-Front_Back-1024x768.jpg', null, null, '6999.00', '9', '1', '2020-09-01 15:06:11', '2020-09-01 15:06:11');
