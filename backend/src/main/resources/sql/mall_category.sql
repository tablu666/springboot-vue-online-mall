

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mall_category
-- ----------------------------
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
) ENGINE=InnoDB AUTO_INCREMENT=100023 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mall_category
-- ----------------------------
INSERT INTO `mall_category` VALUES ('100001', '0', '特色专区', '1', null, '5', '2020-08-17 13:49:02', '2020-08-20 12:52:03');
INSERT INTO `mall_category` VALUES ('100002', '0', '蓝光珍藏', '1', null, '4', '2020-08-17 13:49:02', '2020-08-20 12:52:04');
INSERT INTO `mall_category` VALUES ('100003', '0', '数码电子', '1', null, '3', '2020-08-17 13:49:02', '2020-08-20 12:52:05');
INSERT INTO `mall_category` VALUES ('100004', '0', '玩偶手办', '1', null, '2', '2020-08-17 13:49:02', '2020-08-20 12:52:06');
INSERT INTO `mall_category` VALUES ('100005', '0', '服饰日用', '1', null, '1', '2020-08-17 13:49:02', '2020-08-20 12:52:08');
INSERT INTO `mall_category` VALUES ('100006', '100001', '绝命毒师', '1', '1', '5', '2020-08-17 13:49:02', '2020-08-20 12:52:09');
INSERT INTO `mall_category` VALUES ('100007', '100001', '风骚律师', '1', '2', '4', '2020-08-17 13:49:02', '2020-08-20 12:52:10');
INSERT INTO `mall_category` VALUES ('100008', '100001', '行尸走肉', '1', '3', '3', '2020-08-17 13:49:02', '2020-08-20 12:52:11');
INSERT INTO `mall_category` VALUES ('100009', '100001', '无耻之徒', '1', '4', '2', '2020-08-17 13:49:02', '2020-08-20 12:52:13');
INSERT INTO `mall_category` VALUES ('100010', '100001', '瑞克和莫蒂', '1', '5', '1', '2020-08-17 13:49:02', '2020-08-20 12:52:15');
INSERT INTO `mall_category` VALUES ('100011', '100003', '电脑', '1', null, '5', '2020-08-17 13:49:02', '2020-08-20 12:52:25');
INSERT INTO `mall_category` VALUES ('100012', '100003', '手机', '1', null, '4', '2020-08-17 13:49:02', '2020-08-20 12:52:26');
INSERT INTO `mall_category` VALUES ('100013', '100003', '手表', '1', null, '3', '2020-08-17 13:49:02', '2020-08-20 12:52:27');
INSERT INTO `mall_category` VALUES ('100014', '100003', '音箱', '1', null, '2', '2020-08-17 13:49:02', '2020-08-20 12:52:28');
INSERT INTO `mall_category` VALUES ('100015', '100003', '配件', '1', null, '1', '2020-08-17 13:49:02', '2020-08-20 12:52:30');
INSERT INTO `mall_category` VALUES ('100016', '100004', '大型', '1', null, '3', '2020-08-17 13:49:02', '2020-08-20 12:52:33');
INSERT INTO `mall_category` VALUES ('100017', '100004', '迷你', '1', null, '2', '2020-08-17 13:49:02', '2020-08-20 12:52:34');
INSERT INTO `mall_category` VALUES ('100018', '100004', '限定', '1', null, '1', '2020-08-17 13:49:02', '2020-08-20 12:52:35');
INSERT INTO `mall_category` VALUES ('100019', '100005', '衣服', '1', null, '3', '2020-08-17 13:49:02', '2020-08-20 12:52:36');
INSERT INTO `mall_category` VALUES ('100020', '100005', '裤子', '1', null, '2', '2020-08-17 13:49:02', '2020-08-20 12:52:36');
INSERT INTO `mall_category` VALUES ('100021', '100005', '其他', '1', null, '1', '2020-08-17 13:49:02', '2020-08-20 12:52:39');
INSERT INTO `mall_category` VALUES ('100022', '100015', '手机壳', '1', null, '1', '2020-08-20 12:57:44', '2020-08-20 12:58:54');
