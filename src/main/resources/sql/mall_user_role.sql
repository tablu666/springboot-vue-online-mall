

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mall_user_role
-- ----------------------------
DROP TABLE IF EXISTS `mall_user_role`;
CREATE TABLE `mall_user_role` (
  `uid` int(11) NOT NULL COMMENT '用户id',
  `rid` int(4) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`uid`,`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mall_user_role
-- ----------------------------
INSERT INTO `mall_user_role` VALUES ('1', '1');
INSERT INTO `mall_user_role` VALUES ('1', '2');
INSERT INTO `mall_user_role` VALUES ('2', '1');
INSERT INTO `mall_user_role` VALUES ('2', '2');
INSERT INTO `mall_user_role` VALUES ('2', '3');
INSERT INTO `mall_user_role` VALUES ('3', '1');
