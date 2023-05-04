# woodwhales-music

[![](https://img.shields.io/badge/author-woodwhales-green.svg)](https://woodwhales.cn/) ![](https://img.shields.io/badge/license-GPL%203.0-orange.svg)

> 基于 SpringBoot 的开源超简洁音乐播放器

<center><b>在线播放：<a href="https://music.icoders.cn">https://music.icoders.cn</a></b></center>

环境要求：JDK1.8

技术栈：springboot + thymeleaf + layui + spring security + jsoup + mybatis plus + mysql 

配置说明：

- SQL 文件：woodwhales-music/doc/sql/open_music.sql
- 配置文件：woodwhales-music/src/main/resources/dev/application-dev.yml

## 功能说明

### 3.6.0

- **与低于 v3.6.0 版本的库表不兼容，请使用 doc 中的 [open_music（适用高于 v3.6.0 版本）.sql](doc/sql/open_music（适用高于 v3.6.0 版本）.sql) 进行库表数据初始化操作**

    > 低于  v3.6.0 版本的库表数据初始化 SQL： [open_music（适用低于 v3.6.0 版本）.sql](doc/sql/open_music（open_music（适用低于 v3.6.0 版本）.sql) 

- 后台 UI 页面全面升级（使用 vue + element-ui 进行重构）

- 列表查询、新增、编辑音乐页面增加播放 APlayer 播放器，可支持实时听音乐

- 音乐链接支持 github、alist 来源

### 3.5.5

- 修复 cdn.jsdelivr.net 因未翻墙而无法访问题
- woodwhales-common 版本依赖更新

###  3.5.0

- 引入 [woodwhales-common](https://github.com/woodwhales/woodwhales-common) 依赖

### 3.0.0

- 支持导出已关联音乐清单。

### 2.0.0

-   添加、编辑音乐信息时，当填写了音乐链接或者封面链接其中之一后，可自动填充另外一个文本内容。

### 1.0.0

-   前端页面加载完毕，可离线播放。
-   后台系统可添加、编辑、删除音乐，并对音乐列表排序。
-   添加音乐：可从音乐平台 html 动态解析，支持：网易云、QQ云音乐、虾米音乐（平台已关闭）。

## 前台

访问端口：http://127.0.0.1:8084/music/

![](doc/images/index.png)

## 后台

访问端口：http://127.0.0.1:8084/music/admin/

dev 环境账号密码：admin / admin

### 首页

![](doc/images/v3.6.0/admin-index.png)

音乐名称为<font color='gree'>绿色字体</font>，表示该音乐**已关联**音频链接和专辑封面链接。

音乐名称为<font color='red'>红色字体</font>，表示该音乐**未关联**音频链接和专辑封面链接。

### 添加/编辑

太懒了，加了个解析音乐平台的解析器，一旦解析成功，自动填充：音乐名称、作者、专辑名称。

> 支持：网易云、QQ 音乐、虾米音乐（平台已关闭）

![](doc/images/v3.6.0/admin-add.png)

### 解析

1. 复制要解析的 html 源码。

2. 选择要解析的平台，粘贴 html 源码，点击解析：

    ![](doc/images/admin-add-parse.png)

#### 网易云

class 为：`g-bd4 f-cb`的 html 源码

![](doc/images/admin-add-wangyiyun.png)

#### QQ 音乐

class 为：`main`的 html 源码

![](doc/images/admin-add-qqmusic.png)

#### 虾米

class 为：`page-container`的 html 源码

![](doc/images/admin-add-xiami.png)

## 歌单

| 序号 | 音乐名称 | 专辑 | 作者 |
| --- | ------ | ------ | --- |
| 1 | 所念皆星河 | 所念皆星河 | CMJ |
| 2 | Someone Like You | Someone Like You | Adele |
| 3 | いつも何度でも | 千と千尋の神隠し サウンドトラック | 木村弓 |
| 4 | 容易受伤的女人(国) | 阿菲正传 | 王菲 |
| 5 | Glad You Came | The Wanted (Special Edition) | The Wanted |
| 6 | 红日 | 红日 | 李克勤 |
| 7 | Goodbye | Goodbye Lullaby | Avril Lavigne |
| 8 | Imagine | Imagine: John Lennon | John Lennon |
| 9 | 后来 | 我等你 | 刘若英 |
| 10 | Comptine D'un Autre Été, L'après-Midi | Le Fabuleux Destin d'Amélie Poulain | Yann Tiersen |
| 11 | 听说 | Rene | 刘若英 |
| 12 | 光亮 | 光亮 | 周深 |
| 13 | Journey | Serenity | Capo Productions |
| 14 | 惊蛰 | 二十四节气 | 音阙诗听 / 王梓钰 |
| 15 | 孤勇者 | 孤勇者 | 陈奕迅 |
| 16 | 关于郑州的记忆 | 《你好，郑州》 | 李志 |
| 17 | 哀歌 (M-5) | 犬夜叉 音楽篇 | 和田薫 |
| 18 | 野狼disco | 野狼disco | 宝石Gem |
| 19 | 童年 | 罗大佑自选辑 | 罗大佑 |
| 20 | For the Love of a Princess | Braveheart (Original Motion Picture Soundtrack) (Expanded Edition) | James Horner |
| 21 | 老街 | 小黄 | 李荣浩 |
| 22 | 恋曲1990 | 昨日情歌74-89 | 罗大佑 |
| 23 | 光阴的故事 | 命中注定最犀利 | 罗大佑 |
| 24 | 情非得已 | 遇见100%幸福1 烈爱红盘 | 庾澄庆 |
| 25 | 你要相信这不是最后一天 | 你要相信这不是最后一天 | 华晨宇 |
| 26 | 蜀绣 | 蜀绣 | 李宇春 |
| 27 | Jasmine Flower | Love Ballads | Kenny G |
| 28 | 赤伶 | 赤伶 | 邓寓君(等什么君) |
| 29 | 追梦赤子心 | 追梦痴子心 | GALA |
| 30 | 太阳照常升起 | 太阳照常升起 电影原声大碟 | 久石譲 |
| 31 | Destiny | 마녀유희 OST | 李成旭 |
| 32 | 1965 | 1965 | Zella Day |
| 33 | A Thousand Years | A Thousand Years | Christina Perri |
| 34 | Come By the Hills | Song of the Irish Whistle 2 | Joanie Madden |
| 35 | La Valse D'Amelie | Le Fabuleux destin d'Amélie Poulain | Yann Tiersen |
| 36 | 理想三旬 | 浓烟下的诗歌电台 | 陈鸿宇 |
| 37 | 东风破 | 叶惠美 | 周杰伦 |
| 38 | The Long And Winding Street | Mellow Candle | Robert de Boron |
| 39 | 安和桥 | 安和桥北 | 宋冬野 |
| 40 | The Cello Song | The Piano Guys: Hits Volume 1 | Steven Sharp Nelson |
| 41 | 当我想你的时候 | 当我想你的时候 | 汪峰 |
| 42 | 明天，你好 | Lost & Found 去寻找 | 牛奶咖啡 |
| 43 | 芒种 | 二十四节气 | 音阙诗听 / 赵方婧 |
| 44 | 漂浮地铁 | N+1 Evolution 珍藏版 | 李宇春 |
| 45 | 别送我 | 别送我 | 陈鸿宇 / 苏紫旭 / 刘昊霖 / 寒洛&鼓润 |
| 46 | 稻香 | 魔杰座 | 周杰伦 |
| 47 | 认真的雪 | 未完成的歌 | 薛之谦 |
| 48 | 浅草キッド | GOLDEN☆BEST | 北野武 |
| 49 | 晚风花香 | 原乡情浓 | 邓丽君 |
| 50 | 沉默是金 | 张国荣经典金曲精选 | 张国荣 |
| 51 | Best of 2012: Payphone/Call Me Maybe/Wide Awake/Starship/We Are Young | Anthem Lights Covers | Anthem Lights |
| 52 | 为爱痴狂 | 收获 新歌+精选 | 刘若英 |
| 53 | Lemon Tree | Dish Of The Day | Fool's Garden |
| 54 | 广东十年爱情故事 | 广东十年爱情故事 | 广东雨神 |
| 55 | Turning Tables | 21 | Adele |
| 56 | Monsters | Monsters | Katie Sky |
| 57 | A Day at a Time | Life In a Day (O.S.T) | Ellie Goulding Matthew Herbert |
| 58 | 我的八十年代 | 别再问我什么是迪斯科 | 张蔷 |
| 59 | 南山南 | 南山南 | 马頔 |
| 60 | 后会无期 | 后会无期 | G.E.M.邓紫棋 |
| 61 | 画心 | 画心 | 张靓颖 |
| 62 | 为爱痴狂_陈梦嘉 | THUG LIFE | 陈梦嘉 |
| 63 | Yellow | Best Of British | Coldplay |
| 64 | 一百万个可能 | 一百万个可能 | Christine Welch |
| 65 | 习惯了寂寞 | 习惯了寂寞 | 牛奶咖啡 |
| 66 | 我的歌声里 | Everything In The World (白金庆功版) | 曲婉婷 |
| 67 | 女人花 | 女人花 | 梅艳芳 |
| 68 | 一剪梅 | 花神 | 黄渤 / 左小祖咒 |
| 69 | A Life So Changed | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 70 | Here We Are Again (纯音乐) (《喜剧之王》电影插曲) | Here We Are Again (纯音乐) (《喜剧之王》电影插曲) | Cagnet (キャグネット) |
| 71 | 相思好比小蚂蚁 | 特别的日子 | 张蔷 |
| 72 | Almost Lover | Almost Lover | A Fine Frenzy |
| 73 | Down By The Salley Gardens | camomile | 藤田恵美 (ふじた えみ) |
| 74 | With An Orchid | If I Could Tell You | Yanni |
| 75 | 宝贝 (in a day) | Original | 张悬 |
| 76 | 这世界那么多人 | 这世界那么多人 | 莫文蔚 |
| 77 | 明天你是否依然爱我 | 其实你不懂我的心 | 童安格 |
| 78 | 爱如潮水 | 张信哲精选 | 张信哲 |
| 79 | 7 Years | The Young Pope (Original Series Sountrack) | Lukas Graham |
| 80 | The Sound of Silence (Reprise) | The Graduate | Simon & Garfunkel |
| 81 | BINGBIAN病变 (女声版) | BINGBIAN病变 (女声版) | 鞠文娴 |
| 82 | Don't You Remember | 21 | Adele |
| 83 | かごめと犬夜叉 (M-11+6) | 犬夜叉 音楽篇 | 和田薫 |
| 84 | 吉姆餐厅 | 吉姆餐厅 | 赵雷 |
| 85 | 很爱很爱你 | 很爱很爱你 | 刘若英 |
| 86 | 我们的时光 | 吉姆餐厅 | 赵雷 |
| 87 | Women of Ireland | Song of the Irish Whistle | Joanie Madden |
| 88 | Traveling Light | Traveling Light | Joel Hanson |
| 89 | 醉赤壁 | JJ陆 | 林俊杰 |
| 90 | 笑看风云 (Live) | 汪小敏 笑看风云 | 汪小敏 |
| 91 | 再度重相逢 | 泪桥 | 伍佰 & China Blue |
| 92 | The Way Of Life | 오! 필승 봉순영 OST | 吴硕浚 |
| 93 | 世界这么大还是遇见你 (清新的小女孩（中文版）) | 清新的小女孩（中文版） | 程响 |
| 94 | The Sounds Of Silence 寂静之音 | Silence With Sound From Nature | Bandari |
| 95 | 夏日漱石 (Summer Cozy Rock) | 浪潮上岸 (Tears In Ocean) | 橘子海 (Orange Ocean) |
| 96 | Chasing Pavements | Chasing Pavements | Adele |
| 97 | Right Here Waiting | Ballads | Richard Marx |
| 98 | 成都 | 成都 | 赵雷 |
| 99 | Faidherbe square (instrumental) | Curses from past times | ProleteR |
| 100 | Easy Breeze | Something Simple | Thomas Greenberg |
| 101 | Spring In My Step | Spring In My Step | Silent Partner |
| 102 | Free Loop | Cf, Movie & Drama Hits 广告，开麦拉！ | Daniel Powter |
| 103 | I Could Be The One | Acoustic | Donna Lewis |
| 104 | 不让我的眼泪陪我过夜 | 丝路 | 齐秦 |
| 105 | Unchained Melody | Ghost | Alex North |
| 106 | Let Her Go | All The Little Lights | Passenger |
| 107 | Jar Of Love | Everything In The World (白金庆功版) | 曲婉婷 |
| 108 | 菊花爆满山 | 菊花爆满山 | 马博 |
| 109 | John of the Glen | Song of the Irish Whistle 2 | Joanie Madden |
| 110 | Illusionary Daytime | Endless Daydream | Shirfine |
| 111 | 青丝 | 青丝（完整版） | 等什么君(邓寓君) |
| 112 | Marry You | Now Los Mejores Exitos Del Ano 2012 | Bruno Mars |
| 113 | Seve | Seve | Tez Cadey |
| 114 | 似水流年 | Salute | 张国荣 |
| 115 | Rolling In The Deep | Rolling In The Deep | Adele |
| 116 | 喜欢你 | Beyond 25th Anniversary | Beyond |
| 117 | 我只在乎你 | 我只在乎你 | 邓丽君 |
| 118 | Coachella - Woodstock In My Mind | Lust For Life | Lana Del Rey |
| 119 | 辞九门回忆 | 辞九门回忆 | 等什么君(邓寓君) |
| 120 | 海阔天空 | 乐与怒 | Beyond |
| 121 | 傲气傲笑万重浪 | 黄飞鸿系列电影原声精装版 | 黄霑 |
| 122 | 倩女幽魂 | Ultimate | 张国荣 |
| 123 | Angolan Women | Life In a Day (O.S.T) | The Three Angolan Women |
| 124 | 清明雨上 | 自定义 | 许嵩 |
| 125 | That Girl | 24 HRS (Deluxe) | Olly Murs |
| 126 | Set Fire to the Rain | 21 | Adele |
| 127 | 小情歌 | 小宇宙 | 苏打绿 |
| 128 | 阳光总在风雨后 | 都是夜归人 | 许美静 |
| 129 | Day by Day | 마녀유희 OST | 赵冠宇 |
| 130 | The Sound of Silence (Album Version) | Forever Friends 'Just For You' | Simon & Garfunkel |
| 131 | Refrain | Eternal Light | 阿南亮子 (あなん りょうこ) |
| 132 | 盛夏的果实 | 莫后年代 莫文蔚20周年世纪典藏 | 莫文蔚 |
| 133 | 若把你 | 若把你 | Kirsty刘瑾睿 |
| 134 | Dark Paradise | Born To Die (Deluxe Version) | Lana Del Rey |
| 135 | Dirty Paws | Summer Acoustic | Of Monsters And Men |
| 136 | Miracle In The Middle Of My Heart (Original Mix) | Miracle In The Middle Of My Heart (Original Mix) | Clément Bcx |
| 137 | 老朋友 | 老朋友 | 杨尘,王旭(旭日阳刚) |
| 138 | Whistle | Glee: The Music - The Complete Season Four | Glee Cast |
| 139 | She | 7 Years and 50 Days | Groove Coverage |
| 140 | 十月：我和曾经的我们 | 迷藏 | 钟城 / 姚望 |
| 141 | Stronger | Kids Top 20 - De Grootste Hits Van 2013 - Summer Edition 2013 | Kelly Clarkson |
| 142 | A Penny At A Time | Life In A Day OST | Matthew Herbert |
| 143 | The Immigrant | Song of the Irish Whistle | Joanie Madden |
| 144 | 家族の风景 | 虹の歌集 | 手嶌葵 |
| 145 | 爱拼才会赢 | 爱拼才会赢 | 叶启田 |
| 146 | 单身情歌 | 单身情歌．超炫精选 | 林志炫 |
| 147 | 丑八怪 | 意外 | 薛之谦 |
| 148 | 沧海一声笑 | 沧海一声笑 | 许冠杰 |
| 149 | 桔梗谣 | 桔梗谣 | 阿里郎 |
| 150 | Intro | xx | The xx |
| 151 | Need You Now | iTunes Session | Lady A |
| 152 | 父亲 | 父亲 | 筷子兄弟 |
| 153 | 桔梗谣 | 织谣 | 斯琴格日乐 |
| 154 | 姑娘在远方 | 姑娘在远方 | 柯柯柯啊 |
| 155 | 般若波罗蜜多心经 | 《大唐玄奘》电影片尾曲 | 王菲 |
| 156 | 彩云之南 | 彩云之南 | 徐千雅 |
| 157 | 合肥的石头 | 赤脚青春 | 飘乐队 |
| 158 | 似夜流月 | 热门华语234 | 宗次郎 (そうじろう) |
| 159 | Caribbean Blue 加勒比海蓝 | Moonlight Bay | Bandari |
| 160 | Five hundred miles | America, Vol. 10: Country - The Folk Revival Revolution | The Journeymen |
| 161 | Right Now (Na Na Na) | Right Now (Na Na Na) | Akon |
| 162 | Victory | Battlecry | Two Steps From Hell |
| 163 | 桔梗谣(道拉基) (朝鲜民谣) | 恋恋金达莱 | 蒋薇 |
| 164 | Down By the Salley Gardens | Song of the Irish Whistle | Joanie Madden |
| 165 | 追梦人 | 浮世情怀 | 凤飞飞 |
| 166 | 小鱼儿的思绪 | 武侠音乐系列第二部之思情篇（截取版） | 麦振鸿 |
| 167 | 故乡 | 我只有两天.许巍精选 | 许巍 |
| 168 | Bubbly | So Fresh - The Hits Of Autumn 2008 | Colbie Caillat |
| 169 | 勇敢的心 | 勇敢的心 | 汪峰 |
| 170 | 我很好 | I'm fine | 刘沁 |
| 171 | 江南 | 他是…JJ林俊杰 | 林俊杰 |
| 172 | 年少有为 | 耳朵 | 李荣浩 |
| 173 | Price Tag | Price Tag | Jessie J / B.o.B |
| 174 | The Sound of Silence_轻音乐 | The Best Pan Pipes in the World...Ever! | Panpipes |
| 175 | Eversleeping | Eversleeping | Xandria |
| 176 | Breaking My Heart | Unreleased | Lana Del Rey |
| 177 | Dying In the Sun | Bury the Hatchet | The Cranberries |
| 178 | See You Again | See You Again | See You Again |
| 179 | I Am You | I Am You | Kim Taylor |
| 180 | I'm Yours | I'm Yours | Jason Mraz |
| 181 | Innocence | The Best Damn Thing: Deluxe Edition | Avril Lavigne |
| 182 | 一生所爱 | 齐天周大圣之西游双记 电影歌乐游唱版 | 卢冠廷 / 莫文蔚 |
| 183 | 潇洒地走 | 潇洒地走 | 张蔷 |
| 184 | Apologize | Dreaming Out Loud (Tour Edition) | OneRepublic |
| 185 | Better Than One | The Score EP 2 | The Score |
| 186 | 停格 | 停格 | 蔡健雅 |
| 187 | When You're Gone | When You're Gone | Avril Lavigne |
| 188 | Astronomia | Astronomia | Vicetone / Tony Igy |
| 189 | 容易受伤的女人 | 阿菲正传 | 王菲 |
| 190 | River Flows In You | Kuschelklassik Piano Dreams, Vol. 2 | Martin Ermen |
| 191 | 倔强 | 神的孩子都在跳舞 | 五月天 |
| 192 | 牛仔很忙 | 我很忙 | 周杰伦 |
| 193 | 当爱在靠近 | Love & the City | 刘若英 |
| 194 | 日晷之梦 | 幸福时光 精选辑 | Kevin Kern |
| 195 | Last Reunion | Lament of Valkyrie (Epicmusicvn Series) | Peter Roe |
| 196 | 起风了 | 起风了 | 吴青峰 |
| 197 | Concerning Hobbits | The Lord of the Rings: The Fellowship of the Ring (Original Motion Picture Soundtrack) | Howard Shore |
| 198 | 叱咤红人 | 相依为命: 20年精彩印记 | 陈小春 |
| 199 | 天才白痴梦 | 天才与白痴 | 许冠杰 |
| 200 | 分手以后才知道最珍贵 | 回到家乡 | 胡力 |
| 201 | 往事只能回味 | 怀念老歌一 | 高胜美 |
| 202 | 原来你也在这里 | 我的失败与伟大 | 刘若英 |
| 203 | 我这家伙的答案是你 | AsuRa BalBalTa | Leessang / 河琳 |
| 204 | 往事只能回味 | 我是歌手第四季 第9期 | 金志文 |
| 205 | 勇敢的心 | 最新热歌慢摇88 | Various Artists |
| 206 | 等一分钟 | 滕爱Teng Love | 徐誉滕 |
| 207 | 我想大声告诉你 (《蜗居》电视剧片尾曲) | 我想大声告诉你 | 樊凡 |
| 208 | 光阴的故事 | 光阴的故事 | 黄晓明 邓超 佟大为 |
| 209 | 越长大越孤单 | 越长大越孤单 | 牛奶咖啡 |
| 210 | 往事只能回味 | 说时依旧 | 好妹妹 |
| 211 | 知足 | 知足 最真杰作选 | 五月天 |
| 212 | 一起摇摆 | 生来彷徨 | 汪峰 |
| 213 | 演员 | 绅士 | 薛之谦 |
| 214 | 南方姑娘 | 赵小雷 | 赵雷 |
| 215 | 我最亲爱的 | 你在看我吗 | 张惠妹 |
| 216 | 문을 여시오 (New Ver.) 请开门 | 문을 여시오 | 任昌丁 / 金昌烈 |
| 217 | Cornfield Chase | Interstellar (Original Motion Picture Soundtrack) | Hans Zimmer |
| 218 | Riverside | Philharmonics (Deluxe Edition) | Agnes Obel |
| 219 | Gotta Have You | Say I Am You | The Weepies |
| 220 | Big Big World | Big Big World | Emilia |
| 221 | 认错 | 自定义 | 许嵩 |
| 222 | My Heart Will Go On | Love Ballads | Kenny G |
| 223 | 月光下的凤尾竹 (葫芦丝) | 金耳朵.发烧民乐 | 纯音乐 |
| 224 | Love The Way You Lie | Life After Recovery | Eminem / Rihanna |
| 225 | 好汉歌 | 好汉歌 | 刘欢 |
| 226 | 布拉格广场 | 看我72变 | 蔡依林 / 周杰伦 |
| 227 | 粉红色的回忆 | 粉红色的回忆 | 韩宝仪 |
| 228 | Childhood Memory 童年 | Sunny Bay | Bandari |
| 229 | Dream Catcher 追梦人 | Relaxation - Dreams | Bandari |
| 230 | 小苹果 | 老男孩之猛龙过江 电影原声 | 筷子兄弟 |
| 231 | 穿越时空的思念 (DiESi Remix) | 穿越时空的思念 | DiESi |
| 232 | Hello | Hello | Adele |
| 233 | Chiru (Saisei No Uta) | Nostalgic | Robert de Boron |
| 234 | Southampton | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 235 | 雪见·落入凡尘 | 仙剑奇侠传三 电视剧原声带 | 麦振鸿 |
| 236 | 时间都去哪儿了 | 听得到的时间 | 王铮亮 |
| 237 | 土耳其进行曲 | 土耳其进行曲 | Various Artists |
| 238 | That's Not My Name | That's Not My Name | The Ting Tings |
| 239 | The Mountain of Women | Song of the Irish Whistle | Joanie Madden |
| 240 | Hymn To The Sea | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 241 | Don't push me | Jade - silver edition | sweetbox |
| 242 | Just Give Me A Reason | The Truth About Love | P!nk Nate Ruess |
| 243 | いつも何度でも | Prime Selection | 宗次郎 |
| 244 | 光年之外 | 光年之外 | G.E.M.邓紫棋 |
| 245 | 差生 | 少年中国 | 李宇春 |
| 246 | Nocturne No. 2 in E Flat Major, Op. 9, No. 2 | The Chopin Collection: The Nocturnes | Arthur Rubinstein |
| 247 | 青花瓷 | 我很忙 | 周杰伦 |
| 248 | Beyond The Memory | Beyond The Memory | July |
| 249 | 十年 | 黑白灰 | 陈奕迅 |
| 250 | 送别 | 送别 | 朴树 |
| 251 | 曹操 | 曹操 | 林俊杰 |
| 252 | 一辈子的孤单 | 涩女郎 电视原声带 | 刘若英 |
| 253 | 黑板情书 | 黑板情书 | 后弦 |
| 254 | I can't let this go on any further | I can't let this go on any further | Savior |
| 255 | 因为爱情 | Stranger Under My Skin | 陈奕迅 王菲 |
| 256 | New Morning 清晨 | Mist | Bandari |
| 257 | Love the Way You Lie Part III (Original Demo) | Don't Look Down | Skylar Grey |
| 258 | 我从崖边跌落 | 算云烟 | 谢春花 |
| 259 | 往事只能回味 | 往事只能回味 | 岳云鹏 / 宋小宝 |
| 260 | Never An Absolution | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 261 | Rose | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 262 | Secrets | Secrets | OneRepublic |
| 263 | 突然的自我 | 忘情1015精选辑 | 伍佰 & China Blue |
| 264 | 春风十里 | 所有的酒，都不如你 | 鹿先森乐队 |
| 265 | Roses and Gold | Dust Diaries | Robin Jackson |
| 266 | Yesterday Once More | Yesterday Once More | Carpenters |
| 267 | 星座书上 | 自定义 | 许嵩 |
| 268 | 粉末 | 粉末 | 李宇春 |
| 269 | 苏州城外的微笑 | 很有爱 | 后弦 |
| 270 | Hey Jude | It's a Battle | John Lennon / Paul McCartney / It's a Cover Up |
| 271 | 天下 | 明天过后 | 张杰 |
| 272 | Last Dance | 爱情的尽头 | 伍佰 & China Blue |
| 273 | Miss Misery | Good Will Hunting (Music from the Miramax Motion Picture) | Elliott Smith |
| 274 | Rain after Summer | Rain after Summer | 羽肿 |
| 275 | 宝贝 (in the night) | Original | 张悬 |
| 276 | 不再犹豫 | Beyond The Stage | Beyond |
| 277 | Take a Bow | Good Girl Gone Bad | Rihanna |
| 278 | 泡沫 | Xposed | G.E.M.邓紫棋 |
| 279 | 没有什么不同 | 我的歌声里 | 曲婉婷 |
| 280 | 夜太黑 | 夜太黑 | 林忆莲 |
| 281 | 故乡的原风景 | 武侠音乐精装特辑 | 宗次郎 |
| 282 | 亲爱的那不是爱情 | Ang 5.0 | 张韶涵 |
| 283 | 红色高跟鞋 | 若你碰到他 | 蔡健雅 |
| 284 | The End of the World | The End of the World | Skeeter Davis |
| 285 | 怒放的生命 | 怒放的生命 | 汪峰 |
| 286 | 大约在冬季 | 冬雨 | 齐秦 |
| 287 | 喜欢你 | 喜欢你 | G.E.M. 邓紫棋 |
| 288 | 挪威的森林 | 爱情的尽头 | 伍佰 & China Blue |
| 289 | 本草纲目 | 依然范特西 | 周杰伦 |
| 290 | 小刀会序曲 | 武侠音乐系列之豪气中天 | 商易 / 夏飞云 / 上海民族乐团 |
| 291 | Nijamena | Nijamena | Anurag Kulkarni /Anup Rubens |
| 292 | 2 Soon | Not Thinking Bout 2morrow | Jon Young |
| 293 | 彩云追月 | Edell.Love | 爱戴 |
| 294 | 忧伤倒数 | 夫妻那些事 电视剧原声带 | 小昔米 |
| 295 | 爱情转移 | 认了吧 | 陈奕迅 |
| 296 | 阳光下的我们 | Say The Words | 曲婉婷 |
| 297 | 今天 | 真永远 | 刘德华 |
| 298 | 隐形的翅膀 | 潘朵拉 | 张韶涵 |
| 299 | 蝴蝶泉边 | 崽崽 | 黄雅莉 |
| 300 | Tassel | Dulcet Series spring special collection | Cymophane |
| 301 | 生如夏花 | 生如夏花 | 朴树 |
| 302 | Sugar | V | Maroon 5 |
| 303 | 七里香 | 七里香 | 周杰伦 |
| 304 | 辞·九门回忆 | 辞·九门回忆 | 冰幽 / 解忧草 |
| 305 | 庐州月 | 寻雾启示 | 许嵩 |
| 306 | Only Time | Only Time: The Collection (Box Set) | Enya |
| 307 | 香水有毒 (DJ版) | 香水有毒(宣传单曲) | 胡杨林 |
| 308 | 有何不可 | 自定义 | 许嵩 |
| 309 | 真的爱你 | BEYOND IV | Beyond |
| 310 | Remember The Time | The Ultimate Collection | Michael Jackson |
| 311 | Teenage Dream | Teenage Dream | Katy Perry |
| 312 | 莫扎特：《小夜曲》第一乐章 | 2008-2011 演奏实况合集 | 中国国家交响乐团 |
| 313 | Loves Me Not | t.A.T.u. - The Best | t.A.T.u. |
| 314 | 穿越时空的思念2 时代を超える想い2 | 映画“犬夜叉 时代を越える想い 音楽篇” | 和田薫 |
| 315 | 毕业说分手 | 毕业说分手 | 冰冰超人 |
| 316 | The South Wind | Song of the Irish Whistle | Joanie Madden |
| 317 | 可能 | 可能 | 程响 |
| 318 | The Scientist | The Scientist | Coldplay |
| 319 | 大海 | 70老男孩 | 张雨生 |
| 320 | 八年的爱 | 八年的爱 | 冰冰超人 |
| 321 | TiK ToK | Animal | Kesha |
| 322 | Underneath Your Clothes | Laundry Service | Shakira |
| 323 | My Heart Will Go On | My Love: Ultimate Essential Collection (North American Version) | Celine Dion |
| 324 | 我变了 我没变 | 我变了 我没变 | 杨宗纬 |
| 325 | Trip | Trip | Axero |
| 326 | 断桥残雪 | 断桥残雪 | 许嵩 |
| 327 | 春天里 | 信仰在空中飘扬 | 汪峰 |
| 328 | What A Wonderful World | All Time Greatest Hits | Louis Armstrong |
| 329 | 光明 | 信仰在空中飘扬 | 汪峰 |
| 330 | 光辉岁月 | 光辉岁月 | Beyond |
| 331 | Rhythm Of The Rain | Let It Be Me | Jason Donovan |
| 332 | Five Hundred Miles (《醉乡民谣》电影主题曲|《一路繁花相送》电视剧插曲) | Inside Llewyn Davis: Original Soundtrack Recording | Justin Timberlake / Carey Mull |
| 333 | The truth that you leave | The truth that you leave | Pianoboy高至豪 |
| 334 | 雨过天不晴 | 雨过天不晴 | 柯柯柯啊 |
| 335 | Snowdreams 雪之梦 | Rhine River | Bandari |
| 336 | Not a Single Day 하루도 | Rain's World (Special Edition) | Rain |
| 337 | Summer Vibe | Summer Vibe | Walk off the Earth |
| 338 | We Are One | Super Deluxe Sound I | Kelly Sweet |
| 339 | 北京北京 | 勇敢的心 | 汪峰 |
| 340 | Don't Wanna Know/We Don't Talk Anymore | Don't Wanna Know/We Don't Talk Anymore | Sam Tsui / Alex Blue |
| 341 | We Don't Talk Anymore | We Don't Talk Anymore | Alex Blue TJ Brown |
| 342 | Will and Elizabeth | Pirates of the Caribbean: The Curse of the Black Pearl | Klaus Badelt |
| 343 | You Got Me | Breakthrough | Colbie Caillat |
| 344 | Where Is the Love | Best of Both Worlds | Josh Vietti |
| 345 | Love Story | Women's Day 2019 | Taylor Swift |
| 346 | I Do | I Do | Colbie Caillat |
| 347 | BLUE | Blue Neighbourhood (Deluxe) | Troye Sivan Alex Hope |
| 348 | A Little Story | My View | Valentin |
| 349 | Memories | 마녀유희 OST | 金有京 |
| 350 | MELANCHOLY | MELANCHOLY | White Cherry |
| 351 | Sundial Dreams | In the Enchanted Garden | Kevin Kern |
| 352 | If | 마녀유희 OST | 全慧彬 |
| 353 | 相思赋予谁 | 春生 | 好妹妹 |
| 354 | 画离弦 (柯柯吉他版) | 画离弦 | 柯柯柯啊 |
| 355 | 筝锋 | 功夫 电影原声大碟 | 黄英华 |
| 356 | Thinking Out Loud | NOW That's What I Call Music! 90 | Ed Sheeran |
| 357 | Righteous Path | Introducing Mellow | Blazo |
| 358 | Somebody That I Used To Know | Making Mirrors | Gotye Kimbra |
| 359 | Aloha Heja He | Melancholie und Sturmflut (Bonus Tracks Edition) | Achim Reichel |
| 360 | Palace Memories | Sound. Earth. Nature. Spirit. - Vol. Sound | S.E.N.S. |
| 361 | 回家(萨克斯风) | 金耳朵Ⅲ | Kenny G |
| 362 | Breath and Life | The Platinum Series III: Eterna | Audiomachine |
| 363 | East of Eden | East of Eden | Zella Day |
| 364 | Carpe Diem | Dead Poets Society | Maurice Jarre |
| 365 | Beautiful In White (Demo) | Beautiful In White (Demo) | Shane Filan |
| 366 | Keating's Triumph | Dead Poets Society | Maurice Jarre |
| 367 | Better Man | Sing When You're Winning | Robbie Williams |
| 368 | Love Me Like You Do | Delirium | Ellie Goulding |
| 369 | Summer | ENCORE | 久石譲 |
| 370 | Viva La Vida | Viva La Vida Or Death And All His Friends | Coldplay |
| 371 | 爱向着我来的那天 사랑아 내게 오기만 해 (PartⅠ) | 마녀유희 OST | Ashily |
| 372 | You're Beautiful | So Beautiful 1 | James Blunt |
| 373 | 思念是一种病 | OK | 张震岳 / 蔡健雅 |
| 374 | Sunburst | Sunburst | Tobu / Itro |
| 375 | Farewell to Camraw | When the Pipers Play | Black Kilts Berlin /Robert Mathieson |
| 376 | 想太多 | 想太多 | 李玖哲 |
| 377 | Booty Music | Git Fresh | Deep Side |
| 378 | Genie | THE BEST ~New Edition~ | 少女时代 |
| 379 | 樱花草 | 花言乔语 (精装版) | Sweety |
| 380 | Girlfriend | The Best Damn Thing: Deluxe Edition | Avril Lavigne |
| 381 | Remember The Name | Sampler Mixtape | Fort Minor |
| 382 | Right Here Waiting (Piano) | Right Here Waiting (Piano) | Basil Jose /Richard Marx |
| 383 | The Long Way Home | The Bright Side | Lenka |
| 384 | 单车恋人 | 9公主 | 后弦 |
| 385 | 愤怒的消失 그게 말이죠 | 마녀유희 OST | 木单车 |
| 386 | 西厢 | 古·玩 | 后弦 |
| 387 | Bye Bye Bye | Rising Love | Lovestoned |
| 388 | Star of the County Down | Musique Celtic | Rosheen |
| 389 | Main Title (The Godfather Waltz) | The Godfather I | Nino Rota |
| 390 | 命运的恶作剧 운명의 장난 | 마녀유희 OST | MC 真理 / 哈哈 |
| 391 | Far Away From Home | Greatest Hits | Groove Coverage |
| 392 | Damn You | The Unreleased Collection | Lana Del Rey |
| 393 | Love Yourself (Natio Remix) | Love Yourself (Natio Remix) | Natio / Justin Bieber / Conor Maynard |
| 394 | Red River Valley | Journey Home | Bronn Journey |
| 395 | 去年夏天 | 去年夏天 | 王大毛 |
| 396 | My Happy Ending | Under My Skin (Special Edition) | Avril Lavigne |
| 397 | 友谊之光 | 监狱风云 | 玛莉亚 |
| 398 | The Moon Represents My Heart | Love Ballads | Kenny G |
| 399 | Auld Lang Syne | The Greatest Gift | Charlie Landsborough |
| 400 | 口弦 | 听见凉山 电视剧原声带 | 赵艺涵 |
| 401 | 奇异恩典 | 最新热歌慢摇73 | Various Artists |
| 402 | Flower Dance | A Cup Of Coffee | DJ Okawari |
| 403 | Come And Get It | Chartsurfer Vol. 30 | Selena Gomez |
| 404 | Heartbeats | Swings and Roundabouts | Amy Deasismont |
| 405 | Hero | Hero | Enrique Iglesias |
| 406 | I Just Wanna Run | Take Action! Volume 9 | The Downtown Fiction |
| 407 | 莫失莫忘 | 仙剑奇侠传 电视原创配乐 | 麦振鸿 |
| 408 | I Want You to Know | I Want You to Know | Zedd / Selena Gomez |
| 409 | We Are Young | Dancing Bear Best Of 2012 International | Fun. Janelle Monáe |
| 410 | The Day You Went Away | The Day You Went Away: The Best of M2M | M2M |
| 411 | Sleepyhead | Acoustic Daydreams | Galen Crew |
| 412 | Moon As My Heart | Harmonica Sound of Hong Kong | Robert Bonfiglio |
| 413 | 卡农D大调 | 胎教音乐 | 群星 |
| 414 | My Soul | Time... | July |
| 415 | 富士山下 | What's Going On…? | 陈奕迅 |
| 416 | New Soul | Irlande | Vox Angeli |
| 417 | If I Die Young | If I Die Young - Single | The Band Perry |
| 418 | The Godfather (Love Theme) | The Godfather I | Nino Rota |
| 419 | My Love (Radio Edit) | Coast to Coast | Westlife |
| 420 | What Are Words | What Are Words | Chris Medina |
| 421 | Young For You | Young For You | GALA |
| 422 | The Ludlows | Legends Of The Fall Original Motion Picture Soundtrack | James Horner |
| 423 | Pop Danthology 2012 | Pop Danthology | DJ Daniel Kim |
| 424 | 城南花已开 | 城南花已开 | 三亩地 |
| 425 | Paris | Paris | Else |
| 426 | 花心 | Keep Wakin 1987-2002 周而复始 | 周华健 |
| 427 | 呼唤 오나라 I | 대장금 OST | 김지현 |
| 428 | 爱向着我来的那天2 사랑아 내게 오기만 해 (Part II) | 마녀유희 OST | Ashily |
| 429 | 再见 | 再见 | 张震岳 |
| 430 | 千千阙歌 | 千千阙歌 | 陈慧娴 |
| 431 | Kiss The Rain 비를 맞다 | The Best - Reminiscent 10th Anniversary | Yiruma |
| 432 | Runner | Runner | Dustin O'Halloran |
| 433 | This Is the Life | Weathered | Angie Miller |
| 434 | 从头再来 | 从头再来 | 刘欢 |
| 435 | Dead Poets Society (Finale) | Filmharmonic II | The Royal Philharmonic Orchestra Maurice Jarre |
| 436 | The sally gardens | Arias Ancora | Laure Green |
| 437 | 送别 | 送别 | 韩红 |
| 438 | 安静 钢琴版 | 纯音乐流行歌曲钢琴版 | Paul Liu |
| 439 | Wrecking Ball | Wrecking Ball | Miley Cyrus |
| 440 | 是啊 그래 | 마녀유희 OST | 나창현 |
| 441 | Six Feet Under | Six Feet Under | Billie Eilish |
| 442 | 穿越时空的思念1 时代を超える想い1 | 映画“犬夜叉 时代を越える想い 音楽篇” | 和田薫 |
| 443 | Umbrella | Now That's What I Call Music! 25 Years | Rihanna / Jay-Z |
| 444 | Waka Waka (Esto Es África) | Waka Waka (This Time For Africa) (The Official 2010 Fifa World Cup Song) | Shakira |
| 445 | In The End | In The End | Linkin Park |
| 446 | Monody | Monody | TheFatRat / Laura Brehm |
| 447 | The Show | The Show | Lenka |
| 448 | 野子 (Live) | 我是歌手第四季 第3期 | 苏运莹 |
| 449 | Gee | The First Mini Album Gee | 少女时代 (소녀시대) |
| 450 | Ship In The Sand | Dear Me, Look Up | Marble Sounds |
| 451 | Summertime Sadness | Summertime Sadness | Lana Del Rey |
| 452 | 慕情 (M-4) | 犬夜叉 音楽篇 | 和田薫 |
| 453 | I Love You (Remix) | I Love You | United Idol |
| 454 | 你还要我怎样 | 意外 | 薛之谦 |
| 455 | 发现爱 | 西界 | 林俊杰 / 金莎 |
| 456 | 桥边姑娘 | 桥边姑娘 | 海伦 |
| 457 | 犯错 | 犯错 | 顾峰 / 斯琴高丽 |
| 458 | 那年初夏 | 毕业了我们一无所有 | 任然 |
| 459 | 北京欢迎你 | 北京2008年奥运会歌曲专辑 | 群星 |
| 460 | Red River Valley | Cowboy Songs | Michael Martin Murphey |
| 461 | 500 Miles | Buck The Trend | Peter, Paul & Mary |
| 462 | 500 Miles | Christ Is My Hope | The Innocence Mission |
| 463 | 500 Miles | Let's Folk | The Brothers Four |
| 464 | 画离弦 (柯柯版) | 画离弦 | 柯柯柯啊 |
| 465 | Annie's Wonderland 安妮的仙境 | Wonderland | Bandari |
| 466 | 阿凡达与屌丝男 | 心花路放 电影原声带 | 许鹤缤 |
| 467 | Skinny Love | Skinny Love | Birdy |
| 468 | 我的歌声里 | 我的歌声里 | 李代沫 |
| 469 | 情人 | 海阔天空 | Beyond |
| 470 | 桔梗谣 | 노들강변 매화타령 민요 | 노들강변 매화타령 민요 |
| 471 | 为爱痴狂 | 《中国好声音》2012跨年演唱会 | 金志文 |
| 472 | Mariage d'amour | Lettre à ma Mère | Richard Clayderman |
| 473 | 世界第一等 | 世界第一等 | 浪哥 |
| 474 | Unable To Stay, Unwilling To Leave | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 475 | 带我到山顶 | 听见凉山 | 赵艺涵 |
| 476 | Baby | Baby | Justin Bieber / Ludacris |
| 477 | 春娇与志明 | 春娇与志明 | 街道办GDC /欧阳耀莹 |
| 478 | Nevada | Monstercat - Best of 2016 | Vicetone / Cozi Zuehlsdorff |
| 479 | 听妈妈的话 | 依然范特西 | 周杰伦 |
| 480 | Jambalaya | 不朽的声音(人生最难忘的歌) | Carpenters |
| 481 | 红尘情歌 | 情路无悔 | 高安 /黑鸭子组合 |
| 482 | Prendre sa main | Cri d'amour | Angel Lover |
| 483 | 安静 | 范特西 | 周杰伦 |
| 484 | 梦中蝶影 | 歌曲合辑 | 华语群星 |
| 485 | 姑娘我爱你 | 姑娘我爱你 | 索朗扎西 |
| 486 | 借我 | 算云烟 | 谢春花 |
| 487 | 兰亭序 | 魔杰座 | 周杰伦 |
| 488 | The Red Sun | 20 Years of Achievement around the World | Richard Clayderman |
| 489 | 纯真年代 | 大小世界 | 爱朵女孩 |
| 490 | Vincent | Legendary Don McLean | Don McLean |
| 491 | 平凡之路 | 猎户星座 | 朴树 |
| 492 | 李白 | 模特 | 李荣浩 |
| 493 | You | YOU | Approaching Nirvana |
| 494 | Coming Home | Coming Home | Skylar Grey / Diddy-Dirty Money |
| 495 | Turnin' | Young Rising Sons | Young Rising Sons |
| 496 | 意外 | 意外 | 薛之谦 |
| 497 | Promise | Promise | sapientdream |
| 498 | 那些年 | 那些年，我们一起追的女孩 电影原声带 | 胡夏 |
| 499 | 有一种爱叫做放手 | 有一种爱叫做放手 | 阿木 |
| 500 | 童年 | 童年 | 北京天使合唱团 |
| 501 | 赤伶(DJ版) | 赤伶 | DJ名龙 |
| 502 | 我最亲爱的 | 我的歌声里 | 李代沫 |
| 503 | April 四月之春 | Sunrise Hill | Bandari |
| 504 | Fight | Fight | BeatBrothers |
| 505 | 我希望 | 匆匆那年 电视原声带 | 杨玏 |
| 506 | 知道不知道 | Rene | 刘若英 |
| 507 | Don't Worry Be Happy | Pretty Donkey Girl | Holly Dolly |
| 508 | Say Hello | These Friends Of Mine | Rosie Thomas / Sufjan Stevens |
| 509 | The Right Path | Age of Innocence (Original Soundtrack) | Thomas Greenberg |
| 510 | 相思 | 腔.调 | 毛阿敏 |
| 511 | 相对 | 子曰 第一册 | 子曰乐队 |
| 512 | Sally Gardens | Spring | The O'Neill Brothers |
| 513 | 2 Phút Hơn (KAIZ Remix) | 2 Phút Hơn (KAIZ Remix) | Pháo / KAIZ |
| 514 | Valder Fields | A Plea en Vendredi | Tamas Wells |
| 515 | 刚好遇见你 | 刚好遇见你 | 李玉刚 |
| 516 | Way Back then | 오징어게임 OST | 郑在日 (정재일) |
| 517 | Luv Letter | 髙橋大輔～フェイヴァリット・ミュージック～ | 神津裕之 |
| 518 | 海阔天空 | 一声所爱 大地飞歌（第九期） | 汪小敏 |
| 519 | 万水千山总是情 | 万水千山总是情 电视剧原声带 | 汪明荃 |
| 520 | 希望 | Grace & Charm | 陈慧琳 |
| 521 | Anak (remix: Freddie Aguilar|Remix) | 清尘 | 清尘 |
| 522 | Liability | Melodrama | Lorde |
| 523 | Never Say Good Bye | 마이걸 | Mario & Nesty (마리오&네스티) |
| 524 | 城府 | 自定义 | 许嵩 |
| 525 | All Falls Down | All Falls Down | Alan Walker / Noah Cyrus / Digital Farm Animals / Juliander |
| 526 | 梦中的婚礼 | Richard Clayderman | Richard Clayderman |
| 527 | Faded | Faded | Alan Walker / Iselin Solheim |
| 528 | Take It From Me | Say I Am You | The Weepies / Deb Talan / Steve Tannen |
| 529 | 鼓楼 | 无法长大 | 赵雷 |
| 530 | You Belong To Me | To You | Carla Bruni |
| 531 | 发如雪 | 十一月的萧邦 | 周杰伦 |
| 532 | Windy Hill（风之谷） | Windy Hill | 羽肿 |
| 533 | Bloom of Youth | クドわふたー オリジナル サウンドトラック | 清水淳一 |
| 534 | Your Man | Double Cream 5: 20 Years of Nashville #1's 1992-2012 | Josh Turner |
| 535 | 热爱105°C的你 | 热爱105°C的你 | 腾格尔 / 艾伦 / 沈腾 |
| 536 | Eventide | Eventide | Nylon |
| 537 | Because of You | Because Of You | Kelly Clarkson |
| 538 | Demons | Continued Silence EP | Imagine Dragons |
| 539 | Take Me To Church | Bravo Hits 86 | Hozier |
| 540 | Just One Last Dance (Album Version) | Key To My Soul | Sarah Connor /Marc Terenzi |
| 541 | Love The Way You Lie (Part III (Original Demo)) | Relaxing Acoustic | Skylar Grey |
| 542 | 老男孩 | 父亲 | 筷子兄弟 |
| 543 | 我是一只小小鸟 | 我是一只小小鸟 | 赵传 |
| 544 | Be What You Wanna Be | Darin | Darin |
| 545 | 好久不见 | 认了吧 | 陈奕迅 |
| 546 | A Place Called You | Enchanted | Emma Stevens |
| 547 | Young And Beautiful | Triple J Hottest 100 Vol 21 | Lana Del Rey |
| 548 | 长路漫漫任我闯 | 林子祥精选之天长地久 | 林子祥 |
| 549 | Frail Love | Frail Love | Cloves |
| 550 | Scarborough Fair | The Very Best of Sarah Brightman 1990-2000 | Sarah Brightman |
| 551 | 从头再来 | 经典20年 珍藏锦集 | 刘欢 |
| 552 | 浮夸 | U-87 | 陈奕迅 |
| 553 | Asphyxia 窒息 | asphyxia | 逆时针向 |
| 554 | The Ocean (Radio Edit) | The Ocean | Mike Perry / SHY Martin |
| 555 | Lonely | Nana | Nana |
| 556 | Unity | Sounds of Syndication, Vol .1 (Presented by Syndicate) | TheFatRat |
| 557 | Hey, Soul Sister | Save Me, San Francisco | Train |
| 558 | Waltz No.6 'Petit Chien' in D Flat Major Op.40-1 | 越听越聪明 1 | Classical Artists |
| 559 | Too Far | King in the Mirror | Anna F |
| 560 | Inspire | Serenity | Capo Productions |
| 561 | Sutter's Mill | The Music of Dan Fogelberg | Dan Fogelberg |
| 562 | Please Don't Go | Please Don't Go | Joel Adams |
| 563 | 曾经的你 | 每一刻都是崭新的 | 许巍 |
| 564 | Stay Here Forever | Valentine's Day OST | Jewel |
| 565 | 存在 | 生无所求 | 汪峰 |
| 566 | Stay Alive | The Secret Life Of Walter Mitty (Music From And Inspired By The Motion Picture) | José González |
| 567 | Everybody | Everybody | Ingrid Michaelson |
| 568 | 传奇 | 传奇 | 王菲 |
| 569 | 易燃易爆炸 | 如也 | 陈粒 |
| 570 | 飞向别人的床 | 飞向别人的床 | 沉珂（C.K）& 光光 |
| 571 | 赤伶 (弹唱版) | 赤伶 | 孙鹏凯 |
| 572 | Astronomia（黑人抬棺古风版） | 黑人抬棺古风版 | litterzy、水玥儿 |
| 573 | I Want My Tears Back | Imaginaerum | Nightwish |
| 574 | 红颜 | MuSiC混合体 | 胡彦斌 |
| 575 | 혼자시킨 사랑 独自的爱情 | 명랑소녀 성공기 OST | True Bird |
| 576 | 潮湿的心 | 蜕变1少女的心情故事 | 卓依婷 |
| 577 | brave heart | brave heart | 宮崎歩 |
| 578 | 明天过后 | 明天过后 | 张杰 |
| 579 | Love Theme | 명랑소녀 성공기 OST | 吴振宇 |
| 580 | Read My Mind | Jade | Sweetbox |
| 581 | Let It Out | Let It Out | Frances |
| 582 | Love Song | 명랑소녀 성공기 OST | 赵长赫 |
| 583 | 飞得更高 | 笑着哭 | 汪峰 |
| 584 | 花火 | 花火 | 汪峰 |
| 585 | 直到永远 | 生死不离 我们在一起 | 汪峰 |
| 586 | 跟往事干杯 | 不朽金曲精选 Ⅰ | 姜育恒 |
| 587 | 蓝莲花 | 时光.漫步 | 许巍 |
| 588 | 娃娃脸 | 娃娃脸 | 后弦 |
| 589 | 我爱你中国 | 怒放的生命 | 汪峰 |
| 590 | 星象仪 プラネタリウム | プラネタリウム | 大塚爱 |
| 591 | 一直很安静 | 寂寞在唱歌 | 阿桑 |
| 592 | 生活不止眼前的苟且 | 生活不止眼前的苟且 | 许巍 |
| 593 | Tears Of A Clown | Mastercutor | U.D.O. |
| 594 | 運命のルーレット廻して (转动命运之轮) | 運命のルーレット廻して | ZARD (ザード) |
| 595 | For Free | Folk For Kids | Lana Del Rey / Zella Day / Weyes Blood |
| 596 | My Destiny (我的命运) | 별에서 온 그대 OST Part 1 | LYn (린) |
| 597 | 亲爱的路人 | 亲爱的路人 | 刘若英 |
| 598 | 等不到的爱 | 裸婚时代 电视剧原声带 | 文章 |
| 599 | Call Me Maybe | Call Me Maybe | Carly Rae Jepsen |
| 600 | 花开在眼前 | 花开在眼前 | 韩磊 |
| 601 | 如果不能好好爱 | 如果不能好好爱 | 吴克群 |
| 602 | 童年 | 纵贯线演唱会 | 罗大佑、李宗盛、张震岳、周华健 |
| 603 | 魔訶不思議アドベンチャー! | ドラゴンボール全曲集 | 高橋洋樹 |
| 604 | One Night In 北京 | SHIN 同名专辑 | 信乐团 |
| 605 | The Monster | The Monster | Eminem / Rihanna |
| 606 | Amazing Grace 天赐恩宠 | 苏格兰音乐之旅 苏格兰风笛 | 群星 |
| 607 | 小仙女 | 武侠音乐系列之缠绵悱恻 （截取版） | 麦振鸿 |
| 608 | Élan | Élan | Nightwish |
| 609 | 喜剧之王 | 喜剧之王 | 李荣浩 |
| 610 | Scotland the Brave 苏格兰勇士 | 苏格兰音乐之旅 苏格兰风笛 | 群星 |
| 611 | 月牙湾 | 爱.歌姬 | F.I.R. |
| 612 | Gangsta Bop | Konvicted | Akon |
| 613 | Hallelujah | Warmer In The Winter (Deluxe Edition) | Lindsey Stirling |
| 614 | Nijamena (BGM版) | Nijamena | H2s |
| 615 | 二泉映月 | 阿炳全集 | 阿炳 |
| 616 | 男儿当自强 | 笑傲歌坛 传世经典 | 林子祥 |
| 617 | 上海滩 | 上海滩 | 叶丽仪 |
| 618 | 我和你 | 北京2008 奥运会、残奥会开闭幕式主题歌曲专辑 | 刘欢 / Sarah Brightman |
| 619 | 算你狠 | 绝对收藏 | 陈小春 |
| 620 | 黄种人 | 黄·锋 | 谢霆锋 |
| 621 | Croatian Rhapsody | The Piano Player | Maksim Mrvica |
| 622 | He's a Pirate | Pirates of the Caribbean: The Curse of the Black Pearl | Klaus Badelt |
| 623 | 星月神话 | 女人又一次哭泣 | 金莎 |
| 624 | 夜上海 | 夜上海精选 | 周璇 |
| 625 | 带你去旅行 | 带你去旅行 | 校长（张驰） |
| 626 | 天下第一 | 武侠音乐系列之豪气中天 （截取版） | 麦振鸿 / 罗坚 |
| 627 | '97爱情宣言 | 狼 97黄金自选辑 | 齐秦 |
| 628 | 外面的世界 | 燃烧爱情（狼之旅） | 齐秦 |
| 629 | 小酒窝 | JJ陆 | 林俊杰 / 蔡卓妍 |
| 630 | Past Lives | Drowning | Slushii |
| 631 | 往事随风 | 痛并快乐着 | 齐秦 |
| 632 | Go Time | Go Time | Mark Petrie |
| 633 | Someone to Stay | Someone to Stay | Vancouver Sleep Clinic |
| 634 | The Portrait | Titanic: Special Edition | James Horner |
| 635 | 那年我双手插兜 不知道什么叫做对手 | 那年我双手插兜 不知道什么叫做对手（语录版） | 黑左 / 莎馬淑鳐 / 刘liu创意人 |
| 636 | 你还欠我一个拥抱 | 很有爱 | 后弦 / Sara |
| 637 | Strength of a Thousand Men | Archangel | Two Steps From Hell |
| 638 | 匆匆那年 | 匆匆那年 电影原声带 | 王菲 |
| 639 | Spirit of the Wild | Age of Wonders | BrunuhVille |
| 640 | 命运 운명 | 풀 하우스 OST (KBS 미니시리즈) | Why |
| 641 | 大海~ | Asia | THE JAYWALK |
| 642 | 热爱105°C的你 | 热爱105°C的你 | 阿肆 |
| 643 | Flavor Of Life | Flavor Of Life | 宇多田ヒカル |
| 644 | Death Of Titanic | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 645 | 孤勇者_凤凰传奇 | 孤勇者 | 凤凰传奇 |
| 646 | 不如不见 | What's Going On…? | 陈奕迅 |
| 647 | Distant Memories | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 648 | 偏爱 | 破天荒 | 张芸京 |
| 649 | Diamonds | Diamonds | Rihanna |
| 650 | 我欲成仙 | 西游记后传片头曲 | 刘欢 |
| 651 | 希望 (国语) | 我是阳光的 | 陈慧琳 |
| 652 | Something Just Like This | Something Just Like This | The Chainsmokers / Coldplay |
| 653 | 辞九门回忆(DJ版) | 未知 | 未知 |
