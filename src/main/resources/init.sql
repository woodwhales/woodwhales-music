-- 导出  表 open_music.music 结构
CREATE TABLE IF NOT EXISTS `music` (
                                       `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '音乐表主键',
                                       `title` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '音乐名称标题（音乐名称）',
                                       `artist` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作者',
                                       `album` varchar(180) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '专辑',
                                       `audio_url` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '音乐链接地址',
                                       `cover_url` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '音乐封面',
                                       `sort` int(11) DEFAULT '1' COMMENT '排序',
                                       `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0-已启用，1-已停用，2-已删除',
                                       `gmt_created` datetime DEFAULT NULL COMMENT '创建时间',
                                       `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='音乐表';

-- 数据导出被取消选择。

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
                                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='系统配置表';