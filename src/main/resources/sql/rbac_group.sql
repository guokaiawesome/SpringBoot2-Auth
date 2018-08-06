CREATE TABLE `rbac_group` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '组的名称',
  `update_person_id` bigint(20) NOT NULL COMMENT 'user_base_info表的id',
  `state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态，1表示有效，0表示无效',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin
