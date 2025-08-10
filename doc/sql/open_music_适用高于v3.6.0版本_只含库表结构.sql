-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.27 - MySQL Community Server - GPL
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  12.2.0.6576
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 导出 open_music 的数据库结构
CREATE DATABASE IF NOT EXISTS `open_music` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `open_music`;

-- 导出  表 open_music.file_detail 结构
CREATE TABLE IF NOT EXISTS `file_detail` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '文件id',
  `url` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '文件访问地址',
  `size` bigint DEFAULT NULL COMMENT '文件大小，单位字节',
  `filename` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文件名称',
  `original_filename` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '原始文件名',
  `base_path` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '基础存储路径',
  `path` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '存储路径',
  `ext` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文件扩展名',
  `content_type` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'MIME类型',
  `platform` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '存储平台',
  `th_url` varchar(512) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '缩略图访问路径',
  `th_filename` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '缩略图名称',
  `th_size` bigint DEFAULT NULL COMMENT '缩略图大小，单位字节',
  `th_content_type` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '缩略图MIME类型',
  `object_id` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文件所属对象id',
  `object_type` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文件所属对象类型，例如用户头像，评价图片',
  `metadata` text COLLATE utf8mb4_unicode_ci COMMENT '文件元数据',
  `user_metadata` text COLLATE utf8mb4_unicode_ci COMMENT '文件用户元数据',
  `th_metadata` text COLLATE utf8mb4_unicode_ci COMMENT '缩略图元数据',
  `th_user_metadata` text COLLATE utf8mb4_unicode_ci COMMENT '缩略图用户元数据',
  `attr` text COLLATE utf8mb4_unicode_ci COMMENT '附加属性',
  `file_acl` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文件ACL',
  `th_file_acl` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '缩略图文件ACL',
  `hash_info` text COLLATE utf8mb4_unicode_ci COMMENT '哈希信息',
  `upload_id` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '上传ID，仅在手动分片上传时使用',
  `upload_status` int DEFAULT NULL COMMENT '上传状态，仅在手动分片上传时使用，1：初始化完成，2：上传完成',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0-已启用，1-已停用，2-已删除',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `url` (`url`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='文件记录表';

-- 数据导出被取消选择。

-- 导出  表 open_music.file_part_detail 结构
CREATE TABLE IF NOT EXISTS `file_part_detail` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '分片id',
  `platform` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '存储平台',
  `upload_id` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '上传ID，仅在手动分片上传时使用',
  `e_tag` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分片 ETag',
  `part_number` int DEFAULT NULL COMMENT '分片号。每一个上传的分片都有一个分片号，一般情况下取值范围是1~10000',
  `part_size` bigint DEFAULT NULL COMMENT '文件大小，单位字节',
  `hash_info` text COLLATE utf8mb4_unicode_ci COMMENT '哈希信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0-已启用，1-已停用，2-已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='文件分片信息表，仅在手动分片上传时使用';

-- 数据导出被取消选择。

-- 导出  表 open_music.music_info 结构
CREATE TABLE IF NOT EXISTS `music_info` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '音乐表主键',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '音乐名称标题（音乐名称）',
  `artist` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '作者',
  `album` varchar(180) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '专辑',
  `sort` int DEFAULT '1' COMMENT '排序',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0-已启用，1-已停用，2-已删除',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `link_status` int unsigned NOT NULL DEFAULT '0' COMMENT '链接填充状态：0-未填充链接，1-已填充链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='音乐表';

-- 数据导出被取消选择。

-- 导出  表 open_music.music_info_link 结构
CREATE TABLE IF NOT EXISTS `music_info_link` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0-已启用，1-已停用，2-已删除',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `link_url` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '音频链接',
  `link_type` int NOT NULL DEFAULT '0' COMMENT '链接类型：0-音频，1-封面',
  `link_source` int NOT NULL DEFAULT '0' COMMENT '链接来源：0-github，1-alist',
  `music_id` bigint unsigned NOT NULL COMMENT 'music表id',
  PRIMARY KEY (`id`),
  KEY `music_id` (`music_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='音乐链接信息表';

-- 数据导出被取消选择。

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

-- 数据导出被取消选择。

-- 导出  表 open_music.sys_config 结构
CREATE TABLE IF NOT EXISTS `sys_config` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0-已启用，1-已停用，2-已删除',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `config_key` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '配置key',
  `config_content` mediumtext CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '配置内容',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `config_key` (`config_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci COMMENT='系统配置表';

-- 数据导出被取消选择。

-- 导出  表 open_music.sys_user 结构
CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0-已启用，1-已停用，2-已删除',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `username` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `two_factor_secret` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '2fa密钥',
  `two_factor_enabled` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '是否开启2fa：0-不开启，1-开启',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

-- 数据导出被取消选择。

-- 导出  表 open_music.tag_info 结构
CREATE TABLE IF NOT EXISTS `tag_info` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0-已启用，1-已停用，2-已删除',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `name` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标签名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='标签表';

-- 数据导出被取消选择。

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
