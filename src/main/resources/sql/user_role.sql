DROP TABLE IF EXISTS `mall_user_role`;
CREATE TABLE `mall_user_role` (
  `uid` int(11) NOT NULL COMMENT '用户id',
  `rid` int(4) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`uid`,`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `mall_user_role` (`uid`,`rid`)
VALUES
	(1,1),
	(1,3);