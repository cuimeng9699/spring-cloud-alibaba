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


CREATE TABLE `auth_user`
(
  `id`                      bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name`                    varchar(255)    NOT NULL DEFAULT '' COMMENT '用户登录名称',
  `password`                varchar(255)    NOT NULL DEFAULT '' COMMENT '用户密码',
  `display_name`            varchar(255)    NOT NULL DEFAULT '' COMMENT '用户用于显示名称',
  `account_non_expired`     tinyint(1)      NOT NULL DEFAULT 0 COMMENT '账户是否未过期',
  `account_non_locked`      tinyint(1)      NOT NULL DEFAULT 0 COMMENT '账户是否未锁定',
  `credentials_non_expired` tinyint(1)      NOT NULL DEFAULT 0 COMMENT '凭证是否未过期',
  `enabled`                 tinyint(1)      NOT NULL DEFAULT 0 COMMENT '账户是否可用',
  `create_time`             timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time`             timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted`              tinyint(1)      NOT NULL DEFAULT 0 COMMENT '0:未删除；1：已删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_auth_user_name` (`name`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `auth_role`
(
  `id`          bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code`        varchar(255)    NOT NULL DEFAULT '' COMMENT '角色名称编码',
  `name_ch`     varchar(255)    NOT NULL DEFAULT '' COMMENT '角色中文名称',
  `create_time` timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted`  tinyint(1)      NOT NULL DEFAULT 0 COMMENT '0:未删除；1：已删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_auth_role_name` (`code`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `auth_user_role`
(
  `id`          bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id`     bigint UNSIGNED NOT NULL default 0 COMMENT '用户表ID',
  `role_id`     bigint UNSIGNED NOT NULL default 0 COMMENT '角色表ID',
  `create_time` timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted`  tinyint(1)      NOT NULL DEFAULT 0 COMMENT '0:未删除；1：已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_auth_user_id` (`user_id`) USING BTREE,
  UNIQUE KEY `idx_user_role_unique` (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4;


CREATE TABLE `auth_permission`
(
  `id`              bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `url`             varchar(128)    NOT NULL DEFAULT '' COMMENT 'url',
  `permission_tag`  varchar(128)    NOT NULL DEFAULT '' COMMENT '权限标签',
  `permission_name` varchar(128)    NOT NULL DEFAULT '' COMMENT '权限中文名称',
  `permission_type` varchar(64)     NOT NULL DEFAULT '' COMMENT '权限类型:ROOT;MENU;URL',
  `parent_id`       bigint          NOT NULL DEFAULT -1 COMMENT '权限类型为MENU时,才有意义',
  `create_time`     timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time`     timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted`      tinyint(1)      NOT NULL DEFAULT 0 COMMENT '0:未删除；1：已删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_permission_tag` (`permission_tag`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4;


CREATE TABLE `auth_role_permission`
(
  `id`            bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id`       bigint UNSIGNED NOT NULL default 0 COMMENT '角色id',
  `permission_id` bigint UNSIGNED NOT NULL default 0 COMMENT '权限id',
  `create_time`   timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time`   timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted`    tinyint(1)      NOT NULL DEFAULT 0 COMMENT '0:未删除；1：已删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_role_permission_unique` (`role_id`, `permission_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `auth_department`
(
  `id`          bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code`        varchar(255)    NOT NULL DEFAULT '' COMMENT '部门编码',
  `name_ch`     varchar(255)    NOT NULL DEFAULT '' COMMENT '部门中文名称',
  `parent_id`   bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '上级部门ID',
  `create_time` timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted`  tinyint(1)      NOT NULL DEFAULT 0 COMMENT '0:未删除；1：已删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_code` (`code`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `auth_user_department`
(
  `id`            bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id`       bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户ID',
  `department_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '部门ID',
  `create_time`   timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time`   timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted`    tinyint(1)      NOT NULL DEFAULT 0 COMMENT '0:未删除；1：已删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_auth_user_department_user_id` (`user_id`) USING BTREE,
  UNIQUE KEY `idx_auth_user_department_department_id` (`department_id`) USING BTREE,
  UNIQUE KEY `idx_user_department_unique` (`user_id`, `department_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4;

-- -----------------------spring security tables------------------------
create table persistent_logins
(
  `id`        bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username`  varchar(64)     NOT NULL DEFAULT '' COMMENT '登陆名称',
  `series`    varchar(64)     NOT NULL DEFAULT '' COMMENT '序列码',
  `token`     varchar(64)     NOT NULL DEFAULT '' COMMENT 'token',
  `last_used` timestamp       NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '上次登陆时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_auth_series` (`series`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `SPRING_SESSION`
(
  `id`                    bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `primary_id`            CHAR(36)        NOT NULL DEFAULT '' COMMENT '主键',
  `session_id`            CHAR(36)        NOT NULL DEFAULT '' COMMENT 'sessionId',
  `creation_time`         BIGINT          NOT NULL DEFAULT 0 COMMENT '创建时间',
  `last_access_time`      BIGINT          NOT NULL DEFAULT 0 COMMENT '最后访问时间',
  `max_inactive_interval` INT             NOT NULL DEFAULT 0 COMMENT '最大活动间隔',
  `expiry_time`           BIGINT          NOT NULL DEFAULT 0 COMMENT '过期时间',
  `principal_name`        VARCHAR(100)             DEFAULT '' COMMENT '登陆名称',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_primary_id` (`primary_id`) USING BTREE,
  INDEX `idx_session_id` (`session_id`) USING BTREE,
  INDEX `idx_expiry_time` (`expiry_time`) USING BTREE,
  INDEX `idx_principal_name` (`principal_name`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `SPRING_SESSION_ATTRIBUTES`
(
  `id`                 bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `session_primary_id` CHAR(36)        NOT NULL DEFAULT '' COMMENT 'session primary key',
  `attribute_name`     VARCHAR(200)    NOT NULL DEFAULT '' COMMENT '属性名称',
  `attribute_bytes`    BLOB            NOT NULL COMMENT '属性值',
  PRIMARY KEY (`id`) USING BTREE,
  index `idx_session_primary_id_attribute_name` (`session_primary_id`, `attribute_name`) USING BTREE,
  CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (`session_primary_id`) REFERENCES SPRING_SESSION (`primary_id`) ON DELETE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `operation_sql_config`
(
  `id`              bigint(32) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `operation_type`  varchar(16)         NOT NULL DEFAULT '' COMMENT '操作类型',
  `operation_table` varchar(64)         NOT NULL DEFAULT '' COMMENT '操作表名',
  `field_name`      varchar(2048)       NOT NULL DEFAULT '' COMMENT '字段名',
  `term`            varchar(2048)       NOT NULL DEFAULT '' COMMENT '条件',
  `order_group`     varchar(128)        NOT NULL DEFAULT '' COMMENT '排序和分组',
  `is_easy_sql`     tinyint(1)          NOT NULL DEFAULT '1' COMMENT '1:是；0：否',
  `opreation_desc`  varchar(128)        NOT NULL DEFAULT '' COMMENT '操作描述',
  `create_time`     timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time`     timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted`      tinyint(1)          NOT NULL DEFAULT '0' COMMENT '0:未删除；1：已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='操作数据库配置表';
INSERT INTO `operation_sql_config` (`id`, `operation_type`, `operation_table`, `field_name`, `term`, `order_group`, `is_easy_sql`, `opreation_desc`, `create_time`, `update_time`, `is_deleted`) VALUES (1, 'SELECT', 'user_extend', 'select user_name as userName,city_name as cityName,area_name as areaName from user_extend', 'city_id = ,user_name like', 'order by create_time desc', 0, '用户扩展表查询', '2022-06-25 11:53:40', '2022-06-27 09:34:32', 0);
INSERT INTO `operation_sql_config` (`id`, `operation_type`, `operation_table`, `field_name`, `term`, `order_group`, `is_easy_sql`, `opreation_desc`, `create_time`, `update_time`, `is_deleted`) VALUES (2, 'SELECT', 'user_extend,user', 'select ue.user_name as userName,u.address as address from user_extend ue left join user u on ue.user_id = u.id  ', 'ue.city_id = , u.name like', 'order by ue.create_time desc', 1, '用户俩表关联查询', '2022-06-26 21:16:43', '2022-06-26 22:06:56', 0);

