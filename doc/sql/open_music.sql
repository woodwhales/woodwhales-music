-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.27 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 open_music 的数据库结构
CREATE DATABASE IF NOT EXISTS `open_music` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `open_music`;

-- 导出  表 open_music.music 结构
CREATE TABLE IF NOT EXISTS `music` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '音乐表主键',
  `title` varchar(180) NOT NULL COMMENT '音乐名称标题（音乐名称）',
  `artist` varchar(30) DEFAULT NULL COMMENT '作者',
  `album` varchar(30) DEFAULT NULL COMMENT '专辑',
  `audio_url` varchar(500) DEFAULT NULL COMMENT '音乐链接地址',
  `cover_url` varchar(500) DEFAULT NULL COMMENT '音乐封面',
  `stauts` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0-已启用，1-已停用，2-已删除',
  `gmt_created` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='音乐表';

-- 正在导出表  open_music.music 的数据：~8 rows (大约)
/*!40000 ALTER TABLE `music` DISABLE KEYS */;
INSERT INTO `music` (`id`, `title`, `artist`, `album`, `audio_url`, `cover_url`, `stauts`, `gmt_created`, `gmt_modified`) VALUES
	(2, 'Someone Like You', 'Adele', 'Someone Like You', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/music/some_one_like_you.m4a', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/pic/some_one_like_you.jpg', 0, '2020-08-03 23:40:53', '2020-08-03 23:40:53'),
	(3, '红日', '李克勤', '红日', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/music/hong_ri.m4a', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/pic/hong_ri.jpg', 0, '2020-08-03 23:41:55', '2020-08-03 23:41:55'),
	(4, '后来', '刘若英', '我等你', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/music/hou_lai.mp3', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/pic/hou_lai.jpg', 0, '2020-08-03 23:43:03', '2020-08-03 23:43:03'),
	(5, '惊蛰', '音阙诗听 / 王梓钰', '二十四节气', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/music/jing_zhe.m4a', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/pic/jing_zhe.jpg', 0, '2020-08-03 23:43:54', '2020-08-03 23:43:54'),
	(6, '野狼disco', '宝石Gem', '野狼disco', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/music/ye_lang_disco.m4a', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/pic/ye_lang_disco.jpg', 0, '2020-08-03 23:44:36', '2020-08-03 23:44:36'),
	(7, '你要相信这不是最后一天', '华晨宇', '你要相信这不是最后一天', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m002/music/%E4%BD%A0%E8%A6%81%E7%9B%B8%E4%BF%A1%E8%BF%99%E4%B8%8D%E6%98%AF%E6%9C%80%E5%90%8E%E4%B8%80%E5%A4%A9.m4a', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m002/pic/%E4%BD%A0%E8%A6%81%E7%9B%B8%E4%BF%A1%E8%BF%99%E4%B8%8D%E6%98%AF%E6%9C%80%E5%90%8E%E4%B8%80%E5%A4%A9.jpg', 0, '2020-08-04 12:48:46', '2020-08-04 12:48:46'),
	(8, '光阴的故事', '罗大佑', '光阴的故事', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m002/music/%E5%85%89%E9%98%B4%E7%9A%84%E6%95%85%E4%BA%8B.mp3', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m002/pic/%E5%85%89%E9%98%B4%E7%9A%84%E6%95%85%E4%BA%8B.jpg', 0, '2020-08-04 12:49:28', '2020-08-04 12:49:28'),
	(9, '蜀绣', '李宇春', '蜀绣', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m002-01/music/%E8%9C%80%E7%BB%A3.mp3', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m002/pic/%E8%9C%80%E7%BB%A3.jpg', 0, '2020-08-04 12:49:54', '2020-08-04 12:49:54');
/*!40000 ALTER TABLE `music` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
