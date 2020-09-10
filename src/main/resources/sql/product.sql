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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `mall_product` (`id`, `category_id`, `mark_id`, `name`, `subtitle`, `price`, `stock`, `status`)
VALUES
	(1,100012,1,'Apple iPhone 12 512G 沙漠金 绝命毒师联名 5G手机','iPhone 12，美剧联名款上线。',12999.00,12,1),
	(2,100012,2,'16+512G 华为 Mate40 风骚律师 Better Call Saul','华为5G旗舰，震撼来袭。',8999.00,6,1),
	(3,100017,5,'瑞克和莫蒂 Rick姥爷UFO迷你版','真实还原Rick姥爷座驾',1299.00,2,1);