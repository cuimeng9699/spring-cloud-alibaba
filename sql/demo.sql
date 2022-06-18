-- demo user
CREATE TABLE `user`
(
  `id`       int(11)     NOT NULL COMMENT '主键',
  `name`     varchar(64) NOT NULL COMMENT '姓名',
  `birthday` date         DEFAULT NULL COMMENT '生日',
  `address`  varchar(256) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


-- demo userExtend
CREATE TABLE `user_extend`
(
  `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id`     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户Id',
  `user_name`   varchar(64)         NOT NULL DEFAULT '' COMMENT '用户名称',
  `city_id`     int(11)             NOT NULL DEFAULT '0' COMMENT '城市ID',
  `city_name`   varchar(64)         NOT NULL DEFAULT '' COMMENT '城市名称',
  `area_id`     int(11)             NOT NULL DEFAULT '0' COMMENT '区域ID',
  `area_name`   varchar(64)         NOT NULL DEFAULT '' COMMENT '区域名称',
  `create_time` timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted`  tinyint(1)          NOT NULL DEFAULT '0' COMMENT '0:未删除；1：已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户扩展表';



CREATE TABLE `distributed_lock`
(
  `id`           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `lock_key`     varchar(100)        NOT NULL DEFAULT '' COMMENT '分布式锁key',
  `lock_status`  int(11)             NOT NULL DEFAULT '-1' COMMENT '锁状态，锁定或未锁定',
  `lock_timeout` int(11)             NOT NULL DEFAULT '10' COMMENT '超时时间，单位秒',
  `lock_by`      varchar(50)         NOT NULL DEFAULT '' COMMENT '获取锁的人',
  `lock_time`    timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '获取锁时间戳，单位秒',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uniq_lock_key` (`lock_key`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='分布式锁表';