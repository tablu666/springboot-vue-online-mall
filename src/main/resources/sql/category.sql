DROP TABLE IF EXISTS `mall_category`;
CREATE TABLE `mall_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类别id',
  `parent_id` int(11) DEFAULT NULL COMMENT '父类别id,根节点/一级类别的id=0',
  `name` varchar(50) DEFAULT NULL COMMENT '类别名称',
  `status` tinyint(1) DEFAULT '1' COMMENT '类别状态1-正常,2-已废弃',
  `mark` tinyint(3) DEFAULT NULL COMMENT '美剧标识',
  `sort_order` int(4) DEFAULT NULL COMMENT '排序编号,同类展示顺序,数值相等则自然排序',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `mall_category` (`id`, `parent_id`, `name`, `mark`)
VALUES
	(100001,0,'特色专区',NULL),
	(100002,0,'蓝光珍藏',NULL),
	(100003,0,'数码电子',NULL),
	(100004,0,'玩偶手办',NULL),
	(100005,0,'服饰日用',NULL),
	(100006,100001,'绝命毒师',1),
	(100007,100001,'风骚律师',2),
	(100008,100001,'行尸走肉',3),
	(100009,100001,'无耻之徒',4),
	(100010,100001,'瑞克和莫蒂',5),
	(100011,100003,'电脑',NULL),
	(100012,100003,'手机',NULL),
	(100013,100003,'手表',NULL),
	(100014,100003,'音箱',NULL),
	(100015,100003,'配件',NULL),
	(100016,100004,'大型',NULL),
	(100017,100004,'迷你',NULL),
	(100018,100004,'限定',NULL),
	(100019,100005,'衣服',NULL),
	(100020,100005,'裤子',NULL),
	(100021,100005,'其他',NULL);