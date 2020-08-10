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
  `album` varchar(180) DEFAULT NULL COMMENT '专辑',
  `audio_url` varchar(500) DEFAULT NULL COMMENT '音乐链接地址',
  `cover_url` varchar(500) DEFAULT NULL COMMENT '音乐封面',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0-已启用，1-已停用，2-已删除',
  `gmt_created` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='音乐表';

-- 正在导出表  open_music.music 的数据：~106 rows (大约)
/*!40000 ALTER TABLE `music` DISABLE KEYS */;
INSERT INTO `music` (`id`, `title`, `artist`, `album`, `audio_url`, `cover_url`, `sort`, `status`, `gmt_created`, `gmt_modified`) VALUES
	(2, 'Someone Like You', 'Adele', 'Someone Like You', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/music/some_one_like_you.m4a', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/pic/some_one_like_you.jpg', 1, 0, '2020-08-03 23:40:53', '2020-08-03 23:40:53'),
	(3, '红日', '李克勤', '红日', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/music/hong_ri.m4a', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/pic/hong_ri.jpg', 2, 0, '2020-08-03 23:41:55', '2020-08-03 23:41:55'),
	(4, '后来', '刘若英', '我等你', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/music/hou_lai.mp3', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/pic/hou_lai.jpg', 3, 0, '2020-08-03 23:43:03', '2020-08-03 23:43:03'),
	(5, '惊蛰', '音阙诗听 / 王梓钰', '二十四节气', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/music/jing_zhe.m4a', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/pic/jing_zhe.jpg', 5, 0, '2020-08-03 23:43:54', '2020-08-03 23:43:54'),
	(6, '野狼disco', '宝石Gem', '野狼disco', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/music/ye_lang_disco.m4a', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m001/pic/ye_lang_disco.jpg', 6, 0, '2020-08-03 23:44:36', '2020-08-03 23:44:36'),
	(7, '听说', '刘若英', 'Rene', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m003/music/%E5%90%AC%E8%AF%B4.m4a', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m003/pic/%E5%90%AC%E8%AF%B4.jpg', 4, 0, '2020-08-08 11:50:49', '2020-08-08 11:50:50'),
	(8, '童年', '罗大佑', '罗大佑自选辑', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m003/music/%E7%AB%A5%E5%B9%B4.mp3', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m003/pic/%E7%AB%A5%E5%B9%B4.jpg', 7, 0, '2020-08-08 11:51:38', '2020-08-08 11:51:43'),
	(9, '光阴的故事', '罗大佑', '命中注定最犀利', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m002-01/music/%E5%85%89%E9%98%B4%E7%9A%84%E6%95%85%E4%BA%8B.mp3', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m002-01/pic/%E5%85%89%E9%98%B4%E7%9A%84%E6%95%85%E4%BA%8B.jpg', 9, 0, '2020-08-08 11:51:40', '2020-08-08 11:51:44'),
	(10, '恋曲1990', '罗大佑', '昨日情歌74-89', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m003/music/%E6%81%8B%E6%9B%B21990.m4a', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m003/pic/%E6%81%8B%E6%9B%B21990.jpg', 8, 0, '2020-08-08 11:51:41', '2020-08-08 11:51:44'),
	(11, '漂浮地铁', '李宇春', 'N+1 Evolution 珍藏版', NULL, NULL, 100, 0, '2020-08-10 14:40:18', '2020-08-10 14:40:23'),
	(12, '往事只能回味', '高胜美', '怀念老歌一', NULL, NULL, 100, 0, '2020-08-10 14:40:19', '2020-08-10 14:40:24'),
	(13, '往事只能回味', '好妹妹', '说时依旧', NULL, NULL, 100, 0, '2020-08-10 14:40:19', '2020-08-10 14:40:24'),
	(14, '我只在乎你', '邓丽君', '我只在乎你', NULL, NULL, 100, 0, '2020-08-10 14:40:21', '2020-08-10 14:40:25'),
	(15, '往事只能回味', '岳云鹏 / 宋小宝', '往事只能回味', NULL, NULL, 100, 0, '2020-08-10 14:40:21', '2020-08-10 14:40:26'),
	(16, '往事只能回味', '金志文', '我是歌手第四季 第9期', NULL, NULL, 100, 0, '2020-08-10 14:40:28', '2020-08-10 14:40:26'),
	(17, 'I\'m Yours', 'Jason Mraz', 'I\'m Yours', NULL, NULL, 100, 0, '2020-08-10 14:40:28', '2020-08-10 14:40:29'),
	(18, '1965', 'Zella Day', '1965', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m004/music/1965.m4a', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m004/music/1965.jpg', 12, 0, '2020-08-09 18:57:11', '2020-08-09 18:57:12'),
	(19, 'I Am You', 'Kim Taylor', 'I Am You', NULL, NULL, 100, 0, '2020-08-10 14:40:32', '2020-08-10 14:40:35'),
	(20, 'Innocence', 'Avril Lavigne', 'The Best Damn Thing: Deluxe Edition', NULL, NULL, 100, 0, '2020-08-10 14:40:36', '2020-08-10 14:40:41'),
	(21, 'Marry You', 'Bruno Mars', 'Now Los Mejores Exitos Del Ano 2012', NULL, NULL, 100, 0, '2020-08-10 14:40:40', '2020-08-10 14:40:42'),
	(22, '沉默是金', '张国荣', '张国荣经典金曲精选', NULL, NULL, 100, 0, '2020-08-10 14:40:44', '2020-08-10 14:40:47'),
	(23, '似水流年', '张国荣', 'Salute', NULL, NULL, 100, 0, '2020-08-10 14:40:46', '2020-08-10 14:40:47'),
	(24, '晚风花香', '邓丽君', '原乡情浓', NULL, NULL, 100, 0, '2020-08-10 14:40:45', '2020-08-10 14:40:49'),
	(25, '爱拼才会赢', '叶启田', '爱拼才会赢', NULL, NULL, 100, 0, '2020-08-10 14:40:55', '2020-08-10 14:40:55'),
	(26, '相思好比小蚂蚁', '张蔷', '特别的日子', NULL, NULL, 100, 0, '2020-08-10 14:40:57', '2020-08-10 14:40:56'),
	(27, '潇洒地走', '张蔷', '潇洒地走', NULL, NULL, 100, 0, '2020-08-10 14:40:58', '2020-08-10 14:40:59'),
	(28, 'The Way Of Life', '吴硕浚', '오! 필승 봉순영 OST', NULL, NULL, 100, 0, '2020-08-10 14:41:00', '2020-08-10 14:41:04'),
	(29, '我的八十年代', '张蔷', '别再问我什么是迪斯科', NULL, NULL, 100, 0, '2020-08-10 14:41:02', '2020-08-10 14:41:04'),
	(30, '我这家伙的答案是你', 'Leessang / 河琳', 'AsuRa BalBalTa', NULL, NULL, 100, 0, '2020-08-10 14:41:05', '2020-08-10 14:41:06'),
	(31, '为爱痴狂', '刘若英', '收获 新歌+精选', NULL, NULL, 100, 0, '2020-08-10 14:41:07', '2020-08-10 14:41:06'),
	(32, '为爱痴狂', '陈梦嘉', 'THUG LIFE', NULL, NULL, 100, 0, '2020-08-10 14:41:07', '2020-08-10 14:41:08'),
	(33, '北京北京', 'G.E.M.邓紫棋', '北京北京', NULL, NULL, 100, 0, '2020-08-10 14:41:09', '2020-08-10 14:41:10'),
	(34, '光年之外', 'G.E.M.邓紫棋', '光年之外', NULL, NULL, 100, 0, '2020-08-10 14:41:10', '2020-08-10 14:41:11'),
	(35, '泡沫', 'G.E.M.邓紫棋', 'Xposed', NULL, NULL, 100, 0, '2020-08-10 14:41:12', '2020-08-10 14:41:13'),
	(36, '后会无期', 'G.E.M.邓紫棋', '后会无期', NULL, NULL, 100, 0, '2020-08-10 14:41:13', '2020-08-10 14:41:14'),
	(37, '一百万个可能', 'Christine Welch', '一百万个可能', NULL, NULL, 100, 0, '2020-08-10 14:41:15', '2020-08-10 14:41:15'),
	(38, 'Yellow', 'Coldplay', 'Best Of British', NULL, NULL, 100, 0, '2020-08-10 14:41:16', '2020-08-10 14:41:17'),
	(39, '明天，你好', '牛奶咖啡', 'Lost & Found 去寻找', NULL, NULL, 100, 0, '2020-08-10 14:41:17', '2020-08-10 14:41:18'),
	(40, '习惯了寂寞', '牛奶咖啡', '习惯了寂寞', NULL, NULL, 100, 0, '2020-08-10 14:41:19', '2020-08-10 14:41:20'),
	(41, '忧伤倒数', '小昔米', '夫妻那些事 电视剧原声带', NULL, NULL, 100, 0, '2020-08-10 14:41:21', '2020-08-10 14:41:22'),
	(42, 'Let Her Go', 'Passenger', 'All The Little Lights', NULL, NULL, 100, 0, '2020-08-10 14:41:23', '2020-08-10 14:41:24'),
	(43, '怒放的生命', '汪峰', '怒放的生命', NULL, NULL, 100, 0, '2020-08-10 14:41:25', '2020-08-10 14:41:25'),
	(44, '牛仔很忙', '周杰伦', '我很忙', NULL, NULL, 100, 0, '2020-08-10 14:41:26', '2020-08-10 14:41:27'),
	(45, '东风破 ', '周杰伦', '叶惠美', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m004/music/%E4%B8%9C%E9%A3%8E%E7%A0%B4.mp3', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m004/music/%E4%B8%9C%E9%A3%8E%E7%A0%B4.jpg', 14, 0, '2020-08-10 14:41:28', '2020-08-10 14:41:28'),
	(46, '认真的雪 ', '薛之谦', '未完成的歌', NULL, NULL, 100, 0, '2020-08-10 14:41:29', '2020-08-10 14:41:30'),
	(47, '桔梗谣', '斯琴格日乐', '织谣', NULL, NULL, 100, 0, '2020-08-10 14:41:30', '2020-08-10 14:41:31'),
	(48, '夜太黑', '林忆莲', '夜太黑', NULL, NULL, 100, 0, '2020-08-10 14:41:32', '2020-08-10 14:41:32'),
	(49, '十年', '陈奕迅', '黑白灰', NULL, NULL, 100, 0, '2020-08-10 14:41:33', '2020-08-10 14:41:33'),
	(50, '安和桥', '宋冬野', '安和桥北', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m004/music/%E5%AE%89%E5%92%8C%E6%A1%A5.m4a', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m004/music/%E5%AE%89%E5%92%8C%E6%A1%A5.jpg', 15, 0, '2020-08-10 14:41:34', '2020-08-10 14:41:34'),
	(51, 'My Heart Will Go On', 'Celine Dion', 'My Love: Ultimate Essential Collection (North American Version)', NULL, NULL, 100, 0, '2020-08-10 14:41:35', '2020-08-10 14:41:36'),
	(52, '勇敢的心', 'Various Artists', '最新热歌慢摇88', NULL, NULL, 100, 0, '2020-08-10 14:41:37', '2020-08-10 14:41:37'),
	(53, 'The South Wind', 'Joanie Madden', 'Song of the Irish Whistle', NULL, NULL, 100, 0, '2020-08-10 14:41:38', '2020-08-10 14:41:39'),
	(54, 'Down By the Salley Gardens', 'Joanie Madden', 'Song of the Irish Whistle', NULL, NULL, 100, 0, '2020-08-10 14:41:40', '2020-08-10 14:41:41'),
	(55, 'The Immigrant', 'Joanie Madden', 'Song of the Irish Whistle', NULL, NULL, 100, 0, '2020-08-10 14:41:42', '2020-08-10 14:41:43'),
	(56, 'John of the Glen', 'Joanie Madden', 'Song of the Irish Whistle 2', NULL, NULL, 100, 0, '2020-08-10 14:41:45', '2020-08-10 14:41:46'),
	(57, 'The Mountain of Women', 'Joanie Madden', 'Song of the Irish Whistle', NULL, NULL, 100, 0, '2020-08-10 14:41:48', '2020-08-10 14:41:49'),
	(58, 'Come By the Hills', 'Joanie Madden', 'Song of the Irish Whistle 2', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m004/music/Come%20By%20the%20Hills.m4a', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m004/music/Come%20By%20the%20Hills.jpg', 13, 0, '2020-08-10 14:41:50', '2020-08-10 14:41:50'),
	(59, 'Women of Ireland', 'Joanie Madden', 'Song of the Irish Whistle', NULL, NULL, 100, 0, '2020-08-10 14:41:51', '2020-08-10 14:41:51'),
	(60, 'いつも何度でも', '宗次郎', 'Prime Selection', NULL, NULL, 100, 0, '2020-08-10 14:41:52', '2020-08-10 14:41:53'),
	(61, '故乡的原风景', '宗次郎', '武侠音乐精装特辑', NULL, NULL, 100, 0, '2020-08-10 14:41:54', '2020-08-10 14:41:54'),
	(62, '似夜流月', '宗次郎', '热门华语234', NULL, NULL, 100, 0, '2020-08-10 14:41:55', '2020-08-10 14:41:57'),
	(63, '再度重相逢', '伍佰 & China Blue', '泪桥', NULL, NULL, 100, 0, '2020-08-10 14:41:56', '2020-08-10 14:41:55'),
	(64, '挪威的森林', '伍佰 & China Blue', '爱情的尽头', NULL, NULL, 100, 0, '2020-08-10 14:41:58', '2020-08-10 14:41:58'),
	(65, 'Last Dance', '伍佰 & China Blue', '爱情的尽头', NULL, NULL, 100, 0, '2020-08-10 14:41:59', '2020-08-10 14:41:59'),
	(66, '你要相信这不是最后一天', '华晨宇', '你要相信这不是最后一天', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m002-01/music/%E4%BD%A0%E8%A6%81%E7%9B%B8%E4%BF%A1%E8%BF%99%E4%B8%8D%E6%98%AF%E6%9C%80%E5%90%8E%E4%B8%80%E5%A4%A9.m4a', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m002-01/pic/%E4%BD%A0%E8%A6%81%E7%9B%B8%E4%BF%A1%E8%BF%99%E4%B8%8D%E6%98%AF%E6%9C%80%E5%90%8E%E4%B8%80%E5%A4%A9.jpg', 10, 0, '2020-08-10 14:42:01', '2020-08-10 14:42:00'),
	(67, '蜀绣', '李宇春', '蜀绣', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m002-01/music/%E8%9C%80%E7%BB%A3.mp3', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m002-01/pic/%E8%9C%80%E7%BB%A3.jpg', 11, 0, '2020-08-10 14:42:00', '2020-08-10 14:42:01'),
	(68, 'Traveling Light', 'Joel Hanson', 'Traveling Light', NULL, NULL, 100, 0, '2020-08-10 14:42:03', '2020-08-10 14:42:03'),
	(69, '盛夏的果实', '莫文蔚', '莫后年代 莫文蔚20周年世纪典藏', NULL, NULL, 100, 0, '2020-08-10 14:42:02', '2020-08-10 14:42:32'),
	(70, '一生所爱', '卢冠廷 / 莫文蔚', '齐天周大圣之西游双记 电影歌乐游唱版', NULL, NULL, 100, 0, '2020-08-10 14:42:04', '2020-08-10 14:42:33'),
	(71, '一辈子的孤单 ', '刘若英', 'Love & the City', NULL, NULL, 100, 0, '2020-08-10 14:42:05', '2020-08-10 14:42:34'),
	(72, '七里香', '周杰伦', '七里香', NULL, NULL, 100, 0, '2020-08-10 14:42:04', '2020-08-10 14:42:38'),
	(73, '稻香', '周杰伦', '魔杰座', NULL, NULL, 100, 0, '2020-08-10 14:42:06', '2020-08-10 14:42:39'),
	(74, '越长大越孤单', '牛奶咖啡', '越长大越孤单', NULL, NULL, 100, 0, '2020-08-10 14:42:06', '2020-08-10 14:42:39'),
	(75, '青花瓷', '周杰伦', '我很忙', NULL, NULL, 100, 0, '2020-08-10 14:42:08', '2020-08-10 14:42:40'),
	(76, '我的歌声里 ', '曲婉婷', 'Everything In The World (白金庆功版)', NULL, NULL, 100, 0, '2020-08-10 14:42:09', '2020-08-10 14:42:41'),
	(77, '没有什么不同', '曲婉婷', 'Everything In The World (白金庆功版)', NULL, NULL, 100, 0, '2020-08-10 14:42:08', '2020-08-10 14:42:41'),
	(78, '亲爱的那不是爱情', '张韶涵', 'Ang 5.0', NULL, NULL, 100, 0, '2020-08-10 14:42:10', '2020-08-10 14:42:42'),
	(79, '隐形的翅膀', '张韶涵', '潘朵拉', NULL, NULL, 100, 0, '2020-08-10 14:42:10', '2020-08-10 14:42:43'),
	(80, '曹操', '林俊杰', '曹操', NULL, NULL, 100, 0, '2020-08-10 14:42:11', '2020-08-10 14:42:44'),
	(81, '醉赤壁', '林俊杰', 'JJ陆', NULL, NULL, 100, 0, '2020-08-10 14:42:12', '2020-08-10 14:42:45'),
	(82, '画心', '张靓颖', '画心', NULL, NULL, 100, 0, '2020-08-10 14:42:12', '2020-08-10 14:42:45'),
	(83, '我最亲爱的', '张惠妹', '你在看我吗', NULL, NULL, 100, 0, '2020-08-10 14:42:13', '2020-08-10 14:42:46'),
	(84, '阳光下的我们', '曲婉婷', 'Say The Words', NULL, NULL, 100, 0, '2020-08-10 14:42:13', '2020-08-10 14:42:48'),
	(85, 'Jar Of Love', '曲婉婷', 'Everything In The World (白金庆功版)', NULL, NULL, 100, 0, '2020-08-10 14:42:14', '2020-08-10 14:42:48'),
	(86, '广东十年爱情故事', '广东雨神', '广东十年爱情故事', NULL, NULL, 100, 0, '2020-08-10 14:42:15', '2020-08-10 14:42:49'),
	(87, '蝴蝶泉边', '黄雅莉', '崽崽', NULL, NULL, 100, 0, '2020-08-10 14:42:17', '2020-08-10 14:42:49'),
	(88, '差生', '李宇春', '少年中国', NULL, NULL, 100, 0, '2020-08-10 14:42:15', '2020-08-10 14:42:50'),
	(89, '粉末', '李宇春', '粉末', NULL, NULL, 100, 0, '2020-08-10 14:42:18', '2020-08-10 14:42:50'),
	(90, '光辉岁月', 'Beyond', '光辉岁月', NULL, NULL, 100, 0, '2020-08-10 14:42:18', '2020-08-10 14:42:51'),
	(91, '海阔天空', 'Beyond', '乐与怒', NULL, NULL, 100, 0, '2020-08-10 14:42:19', '2020-08-10 14:42:52'),
	(92, '不再犹豫', 'Beyond', 'Beyond The Stage', NULL, NULL, 100, 0, '2020-08-10 14:42:20', '2020-08-10 14:42:52'),
	(93, '真的爱你', 'Beyond', 'BEYOND IV', NULL, NULL, 100, 0, '2020-08-10 14:42:20', '2020-08-10 14:42:53'),
	(94, '老朋友', '杨尘,王旭(旭日阳刚)', '老朋友', NULL, NULL, 100, 0, '2020-08-10 14:42:22', '2020-08-10 14:42:54'),
	(95, '粉红色的回忆', '韩宝仪', '粉红色的回忆', NULL, NULL, 100, 0, '2020-08-10 14:42:22', '2020-08-10 14:42:54'),
	(96, '老男孩', '筷子兄弟', '父亲', NULL, NULL, 100, 0, '2020-08-10 14:42:23', '2020-08-10 14:42:56'),
	(97, '父亲', '筷子兄弟', '父亲', NULL, NULL, 100, 0, '2020-08-10 14:42:24', '2020-08-10 14:43:01'),
	(98, 'Yesterday Once More', 'Carpenters', 'Yesterday Once More', NULL, NULL, 100, 0, '2020-08-10 14:42:25', '2020-08-10 14:43:00'),
	(99, '庐州月', '许嵩', '寻雾启示', NULL, NULL, 100, 0, '2020-08-10 14:42:26', '2020-08-10 14:43:01'),
	(100, '有何不可', '许嵩', '自定义', NULL, NULL, 100, 0, '2020-08-10 14:42:27', '2020-08-10 14:43:03'),
	(101, '清明雨上', '许嵩', '自定义', NULL, NULL, 100, 0, '2020-08-10 14:42:27', '2020-08-10 14:43:02'),
	(102, '断桥残雪', '许嵩', '断桥残雪', NULL, NULL, 100, 0, '2020-08-10 14:42:28', '2020-08-10 14:43:04'),
	(103, '认错', '许嵩', '自定义', NULL, NULL, 100, 0, '2020-08-10 14:42:29', '2020-08-10 14:43:04'),
	(104, '星座书上', '许嵩', '自定义', NULL, NULL, 100, 0, '2020-08-10 14:42:30', '2020-08-10 14:43:05'),
	(105, '西厢', '后弦', '古·玩', NULL, NULL, 100, 0, '2020-08-10 14:42:30', '2020-08-10 14:43:05'),
	(106, '苏州城外的微笑', '后弦', '很有爱', NULL, NULL, 100, 0, '2020-08-10 14:43:07', '2020-08-10 14:43:06'),
	(107, '单车恋人', '后弦', '9公主', NULL, NULL, 100, 0, '2020-08-10 14:43:08', '2020-08-10 14:43:07');
/*!40000 ALTER TABLE `music` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
