-- 导出  表 open_music.music_info 结构
CREATE TABLE IF NOT EXISTS `music_info` (
                                            `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '音乐表主键',
                                            `title` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '音乐名称标题（音乐名称）',
                                            `artist` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作者',
                                            `album` varchar(180) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '专辑',
                                            `sort` int(11) DEFAULT '1' COMMENT '排序',
                                            `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0-已启用，1-已停用，2-已删除',
                                            `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                            `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                            `link_status` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '链接填充状态：0-未填充链接，1-已填充链接',
                                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='音乐表';

-- 数据导出被取消选择。

-- 导出  表 open_music.music_info_link 结构
CREATE TABLE IF NOT EXISTS `music_info_link` (
                                                 `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
                                                 `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0-已启用，1-已停用，2-已删除',
                                                 `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                                 `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                                 `link_url` varchar(1024) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '音频链接',
                                                 `link_type` int(11) NOT NULL DEFAULT '0' COMMENT '链接类型：0-音频，1-封面',
                                                 `link_source` int(11) NOT NULL DEFAULT '0' COMMENT '链接来源：0-github，1-alist',
                                                 `music_id` bigint(20) unsigned NOT NULL COMMENT 'music表id',
                                                 PRIMARY KEY (`id`),
                                                 KEY `music_id` (`music_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='音乐链接信息表';

-- 数据导出被取消选择。

-- 导出  表 open_music.sys_config 结构
CREATE TABLE IF NOT EXISTS `sys_config` (
                                            `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
                                            `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0-已启用，1-已停用，2-已删除',
                                            `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                            `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                            `config_key` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '配置key',
                                            `config_content` mediumtext COLLATE utf8_unicode_ci NOT NULL COMMENT '配置内容',
                                            PRIMARY KEY (`id`),
                                            INDEX `config_key` (`config_key`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统配置表';

-- 导出  表 open_music.sys_user 结构
CREATE TABLE IF NOT EXISTS `sys_user` (
                                            `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
                                            `status` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0-已启用，1-已停用，2-已删除',
                                            `gmt_created` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                            `gmt_modified` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                            `username` VARCHAR(120) NOT NULL COMMENT '用户名' COLLATE 'utf8mb4_general_ci',
                                            `password` VARCHAR(300) NOT NULL COMMENT '密码' COLLATE 'utf8mb4_general_ci',
                                            `two_factor_secret` VARCHAR(300) NOT NULL COMMENT '2fa密钥' COLLATE 'utf8mb4_general_ci',
                                            `two_factor_enabled` TINYINT(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否开启2fa：0-不开启，1-开启',
                                            PRIMARY KEY (`id`) USING BTREE,
                                            UNIQUE INDEX `username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

-- 导出  表 open_music.music_tag 结构
CREATE TABLE IF NOT EXISTS `music_tag` (
                                           `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '音乐表主键',
                                           `music_id` bigint unsigned NOT NULL DEFAULT '0' COMMENT 'music_info 表id',
                                           `tag_id` bigint unsigned NOT NULL DEFAULT '0' COMMENT 'tag_info 表id',
                                           `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0-已启用，1-已停用，2-已删除',
    `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `music_info_id` (`music_id`) USING BTREE,
    KEY `tag_info_id` (`tag_id`) USING BTREE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='音乐标签表';

-- 导出  表 open_music.tag_info 结构
CREATE TABLE IF NOT EXISTS `tag_info` (
                                          `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
                                          `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0-已启用，1-已停用，2-已删除',
    `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `name` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标签名称',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='标签表';
