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
  `album` varchar(180) DEFAULT NULL COMMENT '专辑',
  `audio_url` varchar(500) DEFAULT NULL COMMENT '音乐链接地址',
  `cover_url` varchar(500) DEFAULT NULL COMMENT '音乐封面',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0-已启用，1-已停用，2-已删除',
  `gmt_created` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='音乐表';

-- Dumping data for table open_music.music: ~106 rows (大约)
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
	(11, '漂浮地铁', '李宇春', 'N+1 Evolution 珍藏版', NULL, NULL, 100, 0, NULL, NULL),
	(12, '往事只能回味', '高胜美', '怀念老歌一', NULL, NULL, 100, 0, NULL, NULL),
	(13, '往事只能回味', '好妹妹', '说时依旧', NULL, NULL, 100, 0, NULL, NULL),
	(14, '我只在乎你', '邓丽君', '我只在乎你', NULL, NULL, 100, 0, NULL, NULL),
	(15, '往事只能回味', '岳云鹏 / 宋小宝', '往事只能回味', NULL, NULL, 100, 0, NULL, NULL),
	(16, '往事只能回味', '金志文', '我是歌手第四季 第9期', NULL, NULL, 100, 0, NULL, NULL),
	(17, 'I\'m Yours', 'Jason Mraz', 'I\'m Yours', NULL, NULL, 100, 0, NULL, NULL),
	(18, '1965', 'Zella Day', '1965', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m004/music/1965.m4a', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m004/music/1965.jpg', 12, 0, '2020-08-09 18:57:11', '2020-08-09 18:57:12'),
	(19, 'I Am You', 'Kim Taylor', 'I Am You', NULL, NULL, 100, 0, NULL, NULL),
	(20, 'Innocence', 'Avril Lavigne', 'The Best Damn Thing: Deluxe Edition', NULL, NULL, 100, 0, NULL, NULL),
	(21, 'Marry You', 'Bruno Mars', 'Now Los Mejores Exitos Del Ano 2012', NULL, NULL, 100, 0, NULL, NULL),
	(22, '沉默是金', '张国荣', '张国荣经典金曲精选', NULL, NULL, 100, 0, NULL, NULL),
	(23, '似水流年', '张国荣', 'Salute', NULL, NULL, 100, 0, NULL, NULL),
	(24, '晚风花香', '邓丽君', '原乡情浓', NULL, NULL, 100, 0, NULL, NULL),
	(25, '爱拼才会赢', '叶启田', '爱拼才会赢', NULL, NULL, 100, 0, NULL, NULL),
	(26, '相思好比小蚂蚁', '张蔷', '特别的日子', NULL, NULL, 100, 0, NULL, NULL),
	(27, '潇洒地走', '张蔷', '潇洒地走', NULL, NULL, 100, 0, NULL, NULL),
	(28, 'The Way Of Life', '吴硕浚', '오! 필승 봉순영 OST', NULL, NULL, 100, 0, NULL, NULL),
	(29, '我的八十年代', '张蔷', '别再问我什么是迪斯科', NULL, NULL, 100, 0, NULL, NULL),
	(30, '我这家伙的答案是你', 'Leessang / 河琳', 'AsuRa BalBalTa', NULL, NULL, 100, 0, NULL, NULL),
	(31, '为爱痴狂', '刘若英', '收获 新歌+精选', NULL, NULL, 100, 0, NULL, NULL),
	(32, '为爱痴狂', '陈梦嘉', 'THUG LIFE', NULL, NULL, 100, 0, NULL, NULL),
	(33, '北京北京', 'G.E.M.邓紫棋', '北京北京', NULL, NULL, 100, 0, NULL, NULL),
	(34, '光年之外', 'G.E.M.邓紫棋', '光年之外', NULL, NULL, 100, 0, NULL, NULL),
	(35, '泡沫', 'G.E.M.邓紫棋', 'Xposed', NULL, NULL, 100, 0, NULL, NULL),
	(36, '后会无期', 'G.E.M.邓紫棋', '后会无期', NULL, NULL, 100, 0, NULL, NULL),
	(37, '一百万个可能', 'Christine Welch', '一百万个可能', NULL, NULL, 100, 0, NULL, NULL),
	(38, 'Yellow', 'Coldplay', 'Best Of British', NULL, NULL, 100, 0, NULL, NULL),
	(39, '明天，你好', '牛奶咖啡', 'Lost & Found 去寻找', NULL, NULL, 100, 0, NULL, NULL),
	(40, '习惯了寂寞', '牛奶咖啡', '习惯了寂寞', NULL, NULL, 100, 0, NULL, NULL),
	(41, '忧伤倒数', '小昔米', '夫妻那些事 电视剧原声带', NULL, NULL, 100, 0, NULL, NULL),
	(42, 'Let Her Go', 'Passenger', 'All The Little Lights', NULL, NULL, 100, 0, NULL, NULL),
	(43, '怒放的生命', '汪峰', '怒放的生命', NULL, NULL, 100, 0, NULL, NULL),
	(44, '牛仔很忙', '周杰伦', '我很忙', NULL, NULL, 100, 0, NULL, NULL),
	(45, '东风破 ', '周杰伦', '叶惠美', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m004/music/%E4%B8%9C%E9%A3%8E%E7%A0%B4.mp3', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m004/music/%E4%B8%9C%E9%A3%8E%E7%A0%B4.jpg', 14, 0, NULL, NULL),
	(46, '认真的雪 ', '薛之谦', '未完成的歌', NULL, NULL, 100, 0, NULL, NULL),
	(47, '桔梗谣', '斯琴格日乐', '织谣', NULL, NULL, 100, 0, NULL, NULL),
	(48, '夜太黑', '林忆莲', '夜太黑', NULL, NULL, 100, 0, NULL, NULL),
	(49, '十年', '陈奕迅', '黑白灰', NULL, NULL, 100, 0, NULL, NULL),
	(50, '安和桥', '宋冬野', '安和桥北', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m004/music/%E5%AE%89%E5%92%8C%E6%A1%A5.m4a', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m004/music/%E5%AE%89%E5%92%8C%E6%A1%A5.jpg', 15, 0, NULL, NULL),
	(51, 'My Heart Will Go On', 'Celine Dion', 'My Love: Ultimate Essential Collection (North American Version)', NULL, NULL, 100, 0, NULL, NULL),
	(52, '勇敢的心', 'Various Artists', '最新热歌慢摇88', NULL, NULL, 100, 0, NULL, NULL),
	(53, 'The South Wind', 'Joanie Madden', 'Song of the Irish Whistle', NULL, NULL, 100, 0, NULL, NULL),
	(54, 'Down By the Salley Gardens', 'Joanie Madden', 'Song of the Irish Whistle', NULL, NULL, 100, 0, NULL, NULL),
	(55, 'The Immigrant', 'Joanie Madden', 'Song of the Irish Whistle', NULL, NULL, 100, 0, NULL, NULL),
	(56, 'John of the Glen', 'Joanie Madden', 'Song of the Irish Whistle 2', NULL, NULL, 100, 0, NULL, NULL),
	(57, 'The Mountain of Women', 'Joanie Madden', 'Song of the Irish Whistle', NULL, NULL, 100, 0, NULL, NULL),
	(58, 'Come By the Hills', 'Joanie Madden', 'Song of the Irish Whistle 2', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m004/music/Come%20By%20the%20Hills.m4a', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m004/music/Come%20By%20the%20Hills.jpg', 13, 0, NULL, NULL),
	(59, 'Women of Ireland', 'Joanie Madden', 'Song of the Irish Whistle', NULL, NULL, 100, 0, NULL, NULL),
	(60, 'いつも何度でも', '宗次郎', 'Prime Selection', NULL, NULL, 100, 0, NULL, NULL),
	(61, '故乡的原风景', '宗次郎', '武侠音乐精装特辑', NULL, NULL, 100, 0, NULL, NULL),
	(62, '似夜流月', '宗次郎', '热门华语234', NULL, NULL, 100, 0, NULL, NULL),
	(63, '再度重相逢', '伍佰 & China Blue', '泪桥', NULL, NULL, 100, 0, NULL, NULL),
	(64, '挪威的森林', '伍佰 & China Blue', '爱情的尽头', NULL, NULL, 100, 0, NULL, NULL),
	(65, 'Last Dance', '伍佰 & China Blue', '爱情的尽头', NULL, NULL, 100, 0, NULL, NULL),
	(66, '你要相信这不是最后一天', '华晨宇', '你要相信这不是最后一天', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m002-01/music/%E4%BD%A0%E8%A6%81%E7%9B%B8%E4%BF%A1%E8%BF%99%E4%B8%8D%E6%98%AF%E6%9C%80%E5%90%8E%E4%B8%80%E5%A4%A9.m4a', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m002-01/pic/%E4%BD%A0%E8%A6%81%E7%9B%B8%E4%BF%A1%E8%BF%99%E4%B8%8D%E6%98%AF%E6%9C%80%E5%90%8E%E4%B8%80%E5%A4%A9.jpg', 10, 0, NULL, NULL),
	(67, '蜀绣', '李宇春', '蜀绣', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m002-01/music/%E8%9C%80%E7%BB%A3.mp3', 'https://cdn.jsdelivr.net/gh/woodwhales/woodwhales-music-store@m002-01/pic/%E8%9C%80%E7%BB%A3.jpg', 11, 0, NULL, NULL),
	(68, 'Traveling Light', 'Joel Hanson', 'Traveling Light', NULL, NULL, 100, 0, NULL, NULL),
	(69, '盛夏的果实', '莫文蔚', '莫后年代 莫文蔚20周年世纪典藏', NULL, NULL, 100, 0, NULL, NULL),
	(70, '一生所爱', '卢冠廷 / 莫文蔚', '齐天周大圣之西游双记 电影歌乐游唱版', NULL, NULL, 100, 0, NULL, NULL),
	(71, '一辈子的孤单 ', '刘若英', 'Love & the City', NULL, NULL, 100, 0, NULL, NULL),
	(72, '七里香', '周杰伦', '七里香', NULL, NULL, 100, 0, NULL, NULL),
	(73, '稻香', '周杰伦', '魔杰座', NULL, NULL, 100, 0, NULL, NULL),
	(74, '越长大越孤单', '牛奶咖啡', '越长大越孤单', NULL, NULL, 100, 0, NULL, NULL),
	(75, '青花瓷', '周杰伦', '我很忙', NULL, NULL, 100, 0, NULL, NULL),
	(76, '我的歌声里 ', '曲婉婷', 'Everything In The World (白金庆功版)', NULL, NULL, 100, 0, NULL, NULL),
	(77, '没有什么不同', '曲婉婷', 'Everything In The World (白金庆功版)', NULL, NULL, 100, 0, NULL, NULL),
	(78, '亲爱的那不是爱情', '张韶涵', 'Ang 5.0', NULL, NULL, 100, 0, NULL, NULL),
	(79, '隐形的翅膀', '张韶涵', '潘朵拉', NULL, NULL, 100, 0, NULL, NULL),
	(80, '曹操', '林俊杰', '曹操', NULL, NULL, 100, 0, NULL, NULL),
	(81, '醉赤壁', '林俊杰', 'JJ陆', NULL, NULL, 100, 0, NULL, NULL),
	(82, '画心', '张靓颖', '画心', NULL, NULL, 100, 0, NULL, NULL),
	(83, '我最亲爱的', '张惠妹', '你在看我吗', NULL, NULL, 100, 0, NULL, NULL),
	(84, '阳光下的我们', '曲婉婷', 'Say The Words', NULL, NULL, 100, 0, NULL, NULL),
	(85, 'Jar Of Love', '曲婉婷', 'Everything In The World (白金庆功版)', NULL, NULL, 100, 0, NULL, NULL),
	(86, '广东十年爱情故事', '广东雨神', '广东十年爱情故事', NULL, NULL, 100, 0, NULL, NULL),
	(87, '蝴蝶泉边', '黄雅莉', '崽崽', NULL, NULL, 100, 0, NULL, NULL),
	(88, '差生', '李宇春', '少年中国', NULL, NULL, 100, 0, NULL, NULL),
	(89, '粉末', '李宇春', '粉末', NULL, NULL, 100, 0, NULL, NULL),
	(90, '光辉岁月', 'Beyond', '光辉岁月', NULL, NULL, 100, 0, NULL, NULL),
	(91, '海阔天空', 'Beyond', '乐与怒', NULL, NULL, 100, 0, NULL, NULL),
	(92, '不再犹豫', 'Beyond', 'Beyond The Stage', NULL, NULL, 100, 0, NULL, NULL),
	(93, '真的爱你', 'Beyond', 'BEYOND IV', NULL, NULL, 100, 0, NULL, NULL),
	(94, '老朋友', '杨尘,王旭(旭日阳刚)', '老朋友', NULL, NULL, 100, 0, NULL, NULL),
	(95, '粉红色的回忆', '韩宝仪', '粉红色的回忆', NULL, NULL, 100, 0, NULL, NULL),
	(96, '老男孩', '筷子兄弟', '父亲', NULL, NULL, 100, 0, NULL, NULL),
	(97, '父亲', '筷子兄弟', '父亲', NULL, NULL, 100, 0, NULL, NULL),
	(98, 'Yesterday Once More', 'Carpenters', 'Yesterday Once More', NULL, NULL, 100, 0, NULL, NULL),
	(99, '庐州月', '许嵩', '寻雾启示', NULL, NULL, 100, 0, NULL, NULL),
	(100, '有何不可', '许嵩', '自定义', NULL, NULL, 100, 0, NULL, NULL),
	(101, '清明雨上', '许嵩', '自定义', NULL, NULL, 100, 0, NULL, NULL),
	(102, '断桥残雪', '许嵩', '断桥残雪', NULL, NULL, 100, 0, NULL, NULL),
	(103, '认错', '许嵩', '自定义', NULL, NULL, 100, 0, NULL, NULL),
	(104, '星座书上', '许嵩', '自定义', NULL, NULL, 100, 0, NULL, NULL),
	(105, '西厢', '后弦', '古·玩', NULL, NULL, 100, 0, NULL, NULL),
	(106, '苏州城外的微笑', '后弦', '很有爱', NULL, NULL, 100, 0, NULL, NULL),
	(107, '单车恋人', '后弦', '9公主', NULL, NULL, 100, 0, NULL, NULL);
/*!40000 ALTER TABLE `music` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
