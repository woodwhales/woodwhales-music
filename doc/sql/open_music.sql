-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.27 - MySQL Community Server (GPL)
-- 服务器OS:                        Win64
-- HeidiSQL 版本:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for open_music
CREATE DATABASE IF NOT EXISTS `open_music` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `open_music`;

-- Dumping structure for table open_music.music
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

-- Dumping data for table open_music.music: ~5 rows (大约)
/*!40000 ALTER TABLE `music` DISABLE KEYS */;
INSERT INTO `music` (`id`, `title`, `artist`, `album`, `audio_url`, `cover_url`, `stauts`, `gmt_created`, `gmt_modified`) VALUES
	(2, 'Someone Like You', 'Adele', 'Someone Like You', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/music/some_one_like_you.m4a', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/pic/some_one_like_you.jpg', 0, '2020-08-03 23:40:53', '2020-08-03 23:40:53'),
	(3, '红日', '李克勤', '红日', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/music/hong_ri.m4a', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/pic/hong_ri.jpg', 0, '2020-08-03 23:41:55', '2020-08-03 23:41:55'),
	(4, '后来', '刘若英', '我等你', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/music/hou_lai.mp3', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/pic/hou_lai.jpg', 0, '2020-08-03 23:43:03', '2020-08-03 23:43:03'),
	(5, '惊蛰', '音阙诗听 / 王梓钰', '二十四节气', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/music/jing_zhe.m4a', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/pic/jing_zhe.jpg', 0, '2020-08-03 23:43:54', '2020-08-03 23:43:54'),
	(6, '野狼disco', '宝石Gem', '野狼disco', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/music/ye_lang_disco.m4a', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/pic/ye_lang_disco.jpg', 0, '2020-08-03 23:44:36', '2020-08-03 23:44:36');
/*!40000 ALTER TABLE `music` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
