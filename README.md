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
| 1 | Someone Like You | Someone Like You | Adele |
| 2 | いつも何度でも | 千と千尋の神隠し サウンドトラック | 木村弓 |
| 3 | 容易受伤的女人(国) | 阿菲正传 | 王菲 |
| 4 | Glad You Came | The Wanted (Special Edition) | The Wanted |
| 5 | 红日 | 红日 | 李克勤 |
| 6 | Goodbye | Goodbye Lullaby | Avril Lavigne |
| 7 | Imagine | Imagine: John Lennon | John Lennon |
| 8 | 后来 | 我等你 | 刘若英 |
| 9 | Comptine D'un Autre Été, L'après-Midi | Le Fabuleux Destin d'Amélie Poulain | Yann Tiersen |
| 10 | 听说 | Rene | 刘若英 |
| 11 | 光亮 | 光亮 | 周深 |
| 12 | Journey | Serenity | Capo Productions |
| 13 | 惊蛰 | 二十四节气 | 音阙诗听 / 王梓钰 |
| 14 | 孤勇者 | 孤勇者 | 陈奕迅 |
| 15 | 关于郑州的记忆 | 《你好，郑州》 | 李志 |
| 16 | 哀歌 (M-5) | 犬夜叉 音楽篇 | 和田薫 |
| 17 | 野狼disco | 野狼disco | 宝石Gem |
| 18 | 童年 | 罗大佑自选辑 | 罗大佑 |
| 19 | For the Love of a Princess | Braveheart (Original Motion Picture Soundtrack) (Expanded Edition) | James Horner |
| 20 | 老街 | 小黄 | 李荣浩 |
| 21 | 恋曲1990 | 昨日情歌74-89 | 罗大佑 |
| 22 | 光阴的故事 | 命中注定最犀利 | 罗大佑 |
| 23 | 情非得已 | 遇见100%幸福1 烈爱红盘 | 庾澄庆 |
| 24 | 你要相信这不是最后一天 | 你要相信这不是最后一天 | 华晨宇 |
| 25 | 蜀绣 | 蜀绣 | 李宇春 |
| 26 | Jasmine Flower | Love Ballads | Kenny G |
| 27 | 赤伶 | 赤伶 | 邓寓君(等什么君) |
| 28 | 追梦赤子心 | 追梦痴子心 | GALA |
| 29 | 太阳照常升起 | 太阳照常升起 电影原声大碟 | 久石譲 |
| 30 | Destiny | 마녀유희 OST | 李成旭 |
| 31 | 1965 | 1965 | Zella Day |
| 32 | A Thousand Years | A Thousand Years | Christina Perri |
| 33 | Come By the Hills | Song of the Irish Whistle 2 | Joanie Madden |
| 34 | La Valse D'Amelie | Le Fabuleux destin d'Amélie Poulain | Yann Tiersen |
| 35 | 理想三旬 | 浓烟下的诗歌电台 | 陈鸿宇 |
| 36 | 东风破 | 叶惠美 | 周杰伦 |
| 37 | The Long And Winding Street | Mellow Candle | Robert de Boron |
| 38 | 安和桥 | 安和桥北 | 宋冬野 |
| 39 | The Cello Song | The Piano Guys: Hits Volume 1 | Steven Sharp Nelson |
| 40 | 当我想你的时候 | 当我想你的时候 | 汪峰 |
| 41 | 明天，你好 | Lost & Found 去寻找 | 牛奶咖啡 |
| 42 | 芒种 | 二十四节气 | 音阙诗听 / 赵方婧 |
| 43 | 漂浮地铁 | N+1 Evolution 珍藏版 | 李宇春 |
| 44 | 别送我 | 别送我 | 陈鸿宇 / 苏紫旭 / 刘昊霖 / 寒洛&鼓润 |
| 45 | 稻香 | 魔杰座 | 周杰伦 |
| 46 | 认真的雪 | 未完成的歌 | 薛之谦 |
| 47 | 浅草キッド | GOLDEN☆BEST | 北野武 |
| 48 | 晚风花香 | 原乡情浓 | 邓丽君 |
| 49 | 沉默是金 | 张国荣经典金曲精选 | 张国荣 |
| 50 | Best of 2012: Payphone/Call Me Maybe/Wide Awake/Starship/We Are Young | Anthem Lights Covers | Anthem Lights |
| 51 | 为爱痴狂 | 收获 新歌+精选 | 刘若英 |
| 52 | Lemon Tree | Dish Of The Day | Fool's Garden |
| 53 | 广东十年爱情故事 | 广东十年爱情故事 | 广东雨神 |
| 54 | Turning Tables | 21 | Adele |
| 55 | Monsters | Monsters | Katie Sky |
| 56 | A Day at a Time | Life In a Day (O.S.T) | Ellie Goulding Matthew Herbert |
| 57 | 我的八十年代 | 别再问我什么是迪斯科 | 张蔷 |
| 58 | 南山南 | 南山南 | 马頔 |
| 59 | 后会无期 | 后会无期 | G.E.M.邓紫棋 |
| 60 | 画心 | 画心 | 张靓颖 |
| 61 | 为爱痴狂_陈梦嘉 | THUG LIFE | 陈梦嘉 |
| 62 | Yellow | Best Of British | Coldplay |
| 63 | 一百万个可能 | 一百万个可能 | Christine Welch |
| 64 | 习惯了寂寞 | 习惯了寂寞 | 牛奶咖啡 |
| 65 | 我的歌声里 | Everything In The World (白金庆功版) | 曲婉婷 |
| 66 | 一剪梅 | 花神 | 黄渤 / 左小祖咒 |
| 67 | A Life So Changed | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 68 | Here We Are Again (纯音乐) (《喜剧之王》电影插曲) | Here We Are Again (纯音乐) (《喜剧之王》电影插曲) | Cagnet (キャグネット) |
| 69 | 相思好比小蚂蚁 | 特别的日子 | 张蔷 |
| 70 | Down By The Salley Gardens | camomile | 藤田恵美 (ふじた えみ) |
| 71 | With An Orchid | If I Could Tell You | Yanni |
| 72 | 宝贝 (in a day) | Original | 张悬 |
| 73 | 这世界那么多人 | 这世界那么多人 | 莫文蔚 |
| 74 | 明天你是否依然爱我 | 其实你不懂我的心 | 童安格 |
| 75 | 爱如潮水 | 张信哲精选 | 张信哲 |
| 76 | 7 Years | The Young Pope (Original Series Sountrack) | Lukas Graham |
| 77 | The Sound of Silence (Reprise) | The Graduate | Simon & Garfunkel |
| 78 | BINGBIAN病变 (女声版) | BINGBIAN病变 (女声版) | 鞠文娴 |
| 79 | Don't You Remember | 21 | Adele |
| 80 | かごめと犬夜叉 (M-11+6) | 犬夜叉 音楽篇 | 和田薫 |
| 81 | 吉姆餐厅 | 吉姆餐厅 | 赵雷 |
| 82 | 很爱很爱你 | 很爱很爱你 | 刘若英 |
| 83 | 我们的时光 | 吉姆餐厅 | 赵雷 |
| 84 | Women of Ireland | Song of the Irish Whistle | Joanie Madden |
| 85 | Traveling Light | Traveling Light | Joel Hanson |
| 86 | 笑看风云 (Live) | 汪小敏 笑看风云 | 汪小敏 |
| 87 | 醉赤壁 | JJ陆 | 林俊杰 |
| 88 | 再度重相逢 | 泪桥 | 伍佰 & China Blue |
| 89 | The Way Of Life | 오! 필승 봉순영 OST | 吴硕浚 |
| 90 | 世界这么大还是遇见你 (清新的小女孩（中文版）) | 清新的小女孩（中文版） | 程响 |
| 91 | 夏日漱石 (Summer Cozy Rock) | 浪潮上岸 (Tears In Ocean) | 橘子海 (Orange Ocean) |
| 92 | Chasing Pavements | Chasing Pavements | Adele |
| 93 | Right Here Waiting | Ballads | Richard Marx |
| 94 | 成都 | 成都 | 赵雷 |
| 95 | Faidherbe square (instrumental) | Curses from past times | ProleteR |
| 96 | Easy Breeze | Something Simple | Thomas Greenberg |
| 97 | Spring In My Step | Spring In My Step | Silent Partner |
| 98 | Free Loop | Cf, Movie & Drama Hits 广告，开麦拉！ | Daniel Powter |
| 99 | I Could Be The One | Acoustic | Donna Lewis |
| 100 | 不让我的眼泪陪我过夜 | 丝路 | 齐秦 |
| 101 | Unchained Melody | Ghost | Alex North |
| 102 | Let Her Go | All The Little Lights | Passenger |
| 103 | Jar Of Love | Everything In The World (白金庆功版) | 曲婉婷 |
| 104 | 菊花爆满山 | 菊花爆满山 | 马博 |
| 105 | John of the Glen | Song of the Irish Whistle 2 | Joanie Madden |
| 106 | Illusionary Daytime | Endless Daydream | Shirfine |
| 107 | 青丝 | 青丝（完整版） | 等什么君(邓寓君) |
| 108 | Marry You | Now Los Mejores Exitos Del Ano 2012 | Bruno Mars |
| 109 | Seve | Seve | Tez Cadey |
| 110 | 似水流年 | Salute | 张国荣 |
| 111 | Rolling In The Deep | Rolling In The Deep | Adele |
| 112 | 喜欢你 | Beyond 25th Anniversary | Beyond |
| 113 | 我只在乎你 | 我只在乎你 | 邓丽君 |
| 114 | Coachella - Woodstock In My Mind | Lust For Life | Lana Del Rey |
| 115 | 辞九门回忆 | 辞九门回忆 | 等什么君(邓寓君) |
| 116 | 海阔天空 | 乐与怒 | Beyond |
| 117 | 傲气傲笑万重浪 | 黄飞鸿系列电影原声精装版 | 黄霑 |
| 118 | 倩女幽魂 | Ultimate | 张国荣 |
| 119 | Angolan Women | Life In a Day (O.S.T) | The Three Angolan Women |
| 120 | 清明雨上 | 自定义 | 许嵩 |
| 121 | That Girl | 24 HRS (Deluxe) | Olly Murs |
| 122 | Set Fire to the Rain | 21 | Adele |
| 123 | 小情歌 | 小宇宙 | 苏打绿 |
| 124 | 阳光总在风雨后 | 都是夜归人 | 许美静 |
| 125 | Day by Day | 마녀유희 OST | 赵冠宇 |
| 126 | The Sound of Silence (Album Version) | Forever Friends 'Just For You' | Simon & Garfunkel |
| 127 | Refrain | Eternal Light | 阿南亮子 (あなん りょうこ) |
| 128 | 盛夏的果实 | 莫后年代 莫文蔚20周年世纪典藏 | 莫文蔚 |
| 129 | Dark Paradise | Born To Die (Deluxe Version) | Lana Del Rey |
| 130 | Dirty Paws | Summer Acoustic | Of Monsters And Men |
| 131 | Miracle In The Middle Of My Heart (Original Mix) | Miracle In The Middle Of My Heart (Original Mix) | Clément Bcx |
| 132 | 老朋友 | 老朋友 | 杨尘,王旭(旭日阳刚) |
| 133 | Whistle | Glee: The Music - The Complete Season Four | Glee Cast |
| 134 | She | 7 Years and 50 Days | Groove Coverage |
| 135 | 十月：我和曾经的我们 | 迷藏 | 钟城 / 姚望 |
| 136 | Stronger | Kids Top 20 - De Grootste Hits Van 2013 - Summer Edition 2013 | Kelly Clarkson |
| 137 | A Penny At A Time | Life In A Day OST | Matthew Herbert |
| 138 | The Immigrant | Song of the Irish Whistle | Joanie Madden |
| 139 | 家族の风景 | 虹の歌集 | 手嶌葵 |
| 140 | 爱拼才会赢 | 爱拼才会赢 | 叶启田 |
| 141 | 单身情歌 | 单身情歌．超炫精选 | 林志炫 |
| 142 | 丑八怪 | 意外 | 薛之谦 |
| 143 | 沧海一声笑 | 沧海一声笑 | 许冠杰 |
| 144 | 桔梗谣 | 桔梗谣 | 阿里郎 |
| 145 | Intro | xx | The xx |
| 146 | Need You Now | iTunes Session | Lady A |
| 147 | 父亲 | 父亲 | 筷子兄弟 |
| 148 | 桔梗谣 | 织谣 | 斯琴格日乐 |
| 149 | 姑娘在远方 | 姑娘在远方 | 柯柯柯啊 |
| 150 | 彩云之南 | 彩云之南 | 徐千雅 |
| 151 | 合肥的石头 | 赤脚青春 | 飘乐队 |
| 152 | 似夜流月 | 热门华语234 | 宗次郎 (そうじろう) |
| 153 | Five hundred miles | America, Vol. 10: Country - The Folk Revival Revolution | The Journeymen |
| 154 | Right Now (Na Na Na) | Right Now (Na Na Na) | Akon |
| 155 | Victory | Battlecry | Two Steps From Hell |
| 156 | 桔梗谣(道拉基) (朝鲜民谣) | 恋恋金达莱 | 蒋薇 |
| 157 | Down By the Salley Gardens | Song of the Irish Whistle | Joanie Madden |
| 158 | 小鱼儿的思绪 | 武侠音乐系列第二部之思情篇（截取版） | 麦振鸿 |
| 159 | 故乡 | 我只有两天.许巍精选 | 许巍 |
| 160 | Bubbly | So Fresh - The Hits Of Autumn 2008 | Colbie Caillat |
| 161 | 勇敢的心 | 勇敢的心 | 汪峰 |
| 162 | 我很好 | I'm fine | 刘沁 |
| 163 | 江南 | 他是…JJ林俊杰 | 林俊杰 |
| 164 | 年少有为 | 耳朵 | 李荣浩 |
| 165 | Price Tag | Price Tag | Jessie J / B.o.B |
| 166 | The Sound of Silence_轻音乐 | The Best Pan Pipes in the World...Ever! | Panpipes |
| 167 | Eversleeping | Eversleeping | Xandria |
| 168 | Breaking My Heart | Unreleased | Lana Del Rey |
| 169 | Dying In the Sun | Bury the Hatchet | The Cranberries |
| 170 | See You Again | See You Again | See You Again |
| 171 | I Am You | I Am You | Kim Taylor |
| 172 | I'm Yours | I'm Yours | Jason Mraz |
| 173 | Innocence | The Best Damn Thing: Deluxe Edition | Avril Lavigne |
| 174 | 一生所爱 | 齐天周大圣之西游双记 电影歌乐游唱版 | 卢冠廷 / 莫文蔚 |
| 175 | 潇洒地走 | 潇洒地走 | 张蔷 |
| 176 | Apologize | Dreaming Out Loud (Tour Edition) | OneRepublic |
| 177 | Better Than One | The Score EP 2 | The Score |
| 178 | 停格 | 停格 | 蔡健雅 |
| 179 | When You're Gone | When You're Gone | Avril Lavigne |
| 180 | Astronomia | Astronomia | Vicetone / Tony Igy |
| 181 | 容易受伤的女人 | 阿菲正传 | 王菲 |
| 182 | River Flows In You | Kuschelklassik Piano Dreams, Vol. 2 | Martin Ermen |
| 183 | 倔强 | 神的孩子都在跳舞 | 五月天 |
| 184 | 牛仔很忙 | 我很忙 | 周杰伦 |
| 185 | Last Reunion | Lament of Valkyrie (Epicmusicvn Series) | Peter Roe |
| 186 | 日晷之梦 | 幸福时光 精选辑 | Kevin Kern |
| 187 | 起风了 | 起风了 | 吴青峰 |
| 188 | Concerning Hobbits | The Lord of the Rings: The Fellowship of the Ring (Original Motion Picture Soundtrack) | Howard Shore |
| 189 | 叱咤红人 | 相依为命: 20年精彩印记 | 陈小春 |
| 190 | 天才白痴梦 | 天才与白痴 | 许冠杰 |
| 191 | 分手以后才知道最珍贵 | 回到家乡 | 胡力 |
| 192 | 往事只能回味 | 怀念老歌一 | 高胜美 |
| 193 | 我这家伙的答案是你 | AsuRa BalBalTa | Leessang / 河琳 |
| 194 | 往事只能回味 | 我是歌手第四季 第9期 | 金志文 |
| 195 | 勇敢的心 | 最新热歌慢摇88 | Various Artists |
| 196 | 等一分钟 | 滕爱Teng Love | 徐誉滕 |
| 197 | 我想大声告诉你 (《蜗居》电视剧片尾曲) | 我想大声告诉你 | 樊凡 |
| 198 | 光阴的故事 | 光阴的故事 | 黄晓明 邓超 佟大为 |
| 199 | 越长大越孤单 | 越长大越孤单 | 牛奶咖啡 |
| 200 | 往事只能回味 | 说时依旧 | 好妹妹 |
| 201 | 知足 | 知足 最真杰作选 | 五月天 |
| 202 | 一起摇摆 | 生来彷徨 | 汪峰 |
| 203 | 演员 | 绅士 | 薛之谦 |
| 204 | 南方姑娘 | 赵小雷 | 赵雷 |
| 205 | 我最亲爱的 | 你在看我吗 | 张惠妹 |
| 206 | 문을 여시오 (New Ver.) 请开门 | 문을 여시오 | 任昌丁 / 金昌烈 |
| 207 | Cornfield Chase | Interstellar (Original Motion Picture Soundtrack) | Hans Zimmer |
| 208 | Riverside | Philharmonics (Deluxe Edition) | Agnes Obel |
| 209 | Gotta Have You | Say I Am You | The Weepies |
| 210 | Big Big World | Big Big World | Emilia |
| 211 | 认错 | 自定义 | 许嵩 |
| 212 | My Heart Will Go On | Love Ballads | Kenny G |
| 213 | 月光下的凤尾竹 (葫芦丝) | 金耳朵.发烧民乐 | 纯音乐 |
| 214 | Love The Way You Lie | Life After Recovery | Eminem / Rihanna |
| 215 | 好汉歌 | 好汉歌 | 刘欢 |
| 216 | 布拉格广场 | 看我72变 | 蔡依林 / 周杰伦 |
| 217 | 粉红色的回忆 | 粉红色的回忆 | 韩宝仪 |
| 218 | 穿越时空的思念 (DiESi Remix) | 穿越时空的思念 | DiESi |
| 219 | Hello | Hello | Adele |
| 220 | Chiru (Saisei No Uta) | Nostalgic | Robert de Boron |
| 221 | Southampton | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 222 | 雪见·落入凡尘 | 仙剑奇侠传三 电视剧原声带 | 麦振鸿 |
| 223 | 时间都去哪儿了 | 听得到的时间 | 王铮亮 |
| 224 | 土耳其进行曲 | 土耳其进行曲 | Various Artists |
| 225 | That's Not My Name | That's Not My Name | The Ting Tings |
| 226 | The Mountain of Women | Song of the Irish Whistle | Joanie Madden |
| 227 | Hymn To The Sea | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 228 | Don't push me | Jade - silver edition | sweetbox |
| 229 | Just Give Me A Reason | The Truth About Love | P!nk Nate Ruess |
| 230 | いつも何度でも | Prime Selection | 宗次郎 |
| 231 | 光年之外 | 光年之外 | G.E.M.邓紫棋 |
| 232 | 差生 | 少年中国 | 李宇春 |
| 233 | Nocturne No. 2 in E Flat Major, Op. 9, No. 2 | The Chopin Collection: The Nocturnes | Arthur Rubinstein |
| 234 | 青花瓷 | 我很忙 | 周杰伦 |
| 235 | Beyond The Memory | Beyond The Memory | July |
| 236 | 十年 | 黑白灰 | 陈奕迅 |
| 237 | 送别 | 送别 | 朴树 |
| 238 | 曹操 | 曹操 | 林俊杰 |
| 239 | 一辈子的孤单 | 涩女郎 电视原声带 | 刘若英 |
| 240 | 黑板情书 | 黑板情书 | 后弦 |
| 241 | I can't let this go on any further | I can't let this go on any further | Savior |
| 242 | 因为爱情 | Stranger Under My Skin | 陈奕迅 王菲 |
| 243 | Love the Way You Lie Part III (Original Demo) | Don't Look Down | Skylar Grey |
| 244 | 我从崖边跌落 | 算云烟 | 谢春花 |
| 245 | 往事只能回味 | 往事只能回味 | 岳云鹏 / 宋小宝 |
| 246 | Never An Absolution | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 247 | Rose | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 248 | Secrets | Secrets | OneRepublic |
| 249 | 突然的自我 | 忘情1015精选辑 | 伍佰 & China Blue |
| 250 | 春风十里 | 所有的酒，都不如你 | 鹿先森乐队 |
| 251 | Roses and Gold | Dust Diaries | Robin Jackson |
| 252 | Yesterday Once More | Yesterday Once More | Carpenters |
| 253 | 星座书上 | 自定义 | 许嵩 |
| 254 | 粉末 | 粉末 | 李宇春 |
| 255 | 苏州城外的微笑 | 很有爱 | 后弦 |
| 256 | Hey Jude | It's a Battle | John Lennon / Paul McCartney / It's a Cover Up |
| 257 | 天下 | 明天过后 | 张杰 |
| 258 | Last Dance | 爱情的尽头 | 伍佰 & China Blue |
| 259 | Miss Misery | Good Will Hunting (Music from the Miramax Motion Picture) | Elliott Smith |
| 260 | 宝贝 (in the night) | Original | 张悬 |
| 261 | 不再犹豫 | Beyond The Stage | Beyond |
| 262 | Take a Bow | Good Girl Gone Bad | Rihanna |
| 263 | 泡沫 | Xposed | G.E.M.邓紫棋 |
| 264 | 没有什么不同 | 我的歌声里 | 曲婉婷 |
| 265 | 夜太黑 | 夜太黑 | 林忆莲 |
| 266 | 故乡的原风景 | 武侠音乐精装特辑 | 宗次郎 |
| 267 | 亲爱的那不是爱情 | Ang 5.0 | 张韶涵 |
| 268 | 红色高跟鞋 | 若你碰到他 | 蔡健雅 |
| 269 | The End of the World | The End of the World | Skeeter Davis |
| 270 | 怒放的生命 | 怒放的生命 | 汪峰 |
| 271 | 大约在冬季 | 冬雨 | 齐秦 |
| 272 | 喜欢你 | 喜欢你 | G.E.M. 邓紫棋 |
| 273 | 挪威的森林 | 爱情的尽头 | 伍佰 & China Blue |
| 274 | 本草纲目 | 依然范特西 | 周杰伦 |
| 275 | 小刀会序曲 | 武侠音乐系列之豪气中天 | 商易 / 夏飞云 / 上海民族乐团 |
| 276 | Nijamena | Nijamena | Anurag Kulkarni /Anup Rubens |
| 277 | 2 Soon | Not Thinking Bout 2morrow | Jon Young |
| 278 | 彩云追月 | Edell.Love | 爱戴 |
| 279 | 忧伤倒数 | 夫妻那些事 电视剧原声带 | 小昔米 |
| 280 | 爱情转移 | 认了吧 | 陈奕迅 |
| 281 | 阳光下的我们 | Say The Words | 曲婉婷 |
| 282 | 今天 | 真永远 | 刘德华 |
| 283 | 隐形的翅膀 | 潘朵拉 | 张韶涵 |
| 284 | 蝴蝶泉边 | 崽崽 | 黄雅莉 |
| 285 | Tassel | Dulcet Series spring special collection | Cymophane |
| 286 | 生如夏花 | 生如夏花 | 朴树 |
| 287 | Sugar | V | Maroon 5 |
| 288 | 七里香 | 七里香 | 周杰伦 |
| 289 | 辞·九门回忆 | 辞·九门回忆 | 冰幽 / 解忧草 |
| 290 | 庐州月 | 寻雾启示 | 许嵩 |
| 291 | Only Time | Only Time: The Collection (Box Set) | Enya |
| 292 | 香水有毒 (DJ版) | 香水有毒(宣传单曲) | 胡杨林 |
| 293 | 有何不可 | 自定义 | 许嵩 |
| 294 | 真的爱你 | BEYOND IV | Beyond |
| 295 | Remember The Time | The Ultimate Collection | Michael Jackson |
| 296 | Teenage Dream | Teenage Dream | Katy Perry |
| 297 | 莫扎特：《小夜曲》第一乐章 | 2008-2011 演奏实况合集 | 中国国家交响乐团 |
| 298 | Loves Me Not | t.A.T.u. - The Best | t.A.T.u. |
| 299 | 穿越时空的思念2 时代を超える想い2 | 映画“犬夜叉 时代を越える想い 音楽篇” | 和田薫 |
| 300 | 毕业说分手 | 毕业说分手 | 冰冰超人 |
| 301 | The South Wind | Song of the Irish Whistle | Joanie Madden |
| 302 | The Scientist | The Scientist | Coldplay |
| 303 | 大海 | 70老男孩 | 张雨生 |
| 304 | 八年的爱 | 八年的爱 | 冰冰超人 |
| 305 | TiK ToK | Animal | Kesha |
| 306 | Underneath Your Clothes | Laundry Service | Shakira |
| 307 | My Heart Will Go On | My Love: Ultimate Essential Collection (North American Version) | Celine Dion |
| 308 | 我变了 我没变 | 我变了 我没变 | 杨宗纬 |
| 309 | Trip | Trip | Axero |
| 310 | 断桥残雪 | 断桥残雪 | 许嵩 |
| 311 | 春天里 | 信仰在空中飘扬 | 汪峰 |
| 312 | What A Wonderful World | All Time Greatest Hits | Louis Armstrong |
| 313 | 光明 | 信仰在空中飘扬 | 汪峰 |
| 314 | 光辉岁月 | 光辉岁月 | Beyond |
| 315 | Rhythm Of The Rain | Let It Be Me | Jason Donovan |
| 316 | Five Hundred Miles (《醉乡民谣》电影主题曲|《一路繁花相送》电视剧插曲) | Inside Llewyn Davis: Original Soundtrack Recording | Justin Timberlake / Carey Mull |
| 317 | Snowdreams 雪之梦 | Rhine River | Bandari |
| 318 | Not a Single Day 하루도 | Rain's World (Special Edition) | Rain |
| 319 | Summer Vibe | Summer Vibe | Walk off the Earth |
| 320 | We Are One | Super Deluxe Sound I | Kelly Sweet |
| 321 | 北京北京 | 勇敢的心 | 汪峰 |
| 322 | Don't Wanna Know/We Don't Talk Anymore | Don't Wanna Know/We Don't Talk Anymore | Sam Tsui / Alex Blue |
| 323 | We Don't Talk Anymore | We Don't Talk Anymore | Alex Blue TJ Brown |
| 324 | You Got Me | Breakthrough | Colbie Caillat |
| 325 | Where Is the Love | Best of Both Worlds | Josh Vietti |
| 326 | Love Story | Women's Day 2019 | Taylor Swift |
| 327 | I Do | I Do | Colbie Caillat |
| 328 | BLUE | Blue Neighbourhood (Deluxe) | Troye Sivan Alex Hope |
| 329 | A Little Story | My View | Valentin |
| 330 | Memories | 마녀유희 OST | 金有京 |
| 331 | MELANCHOLY | MELANCHOLY | White Cherry |
| 332 | Sundial Dreams | In the Enchanted Garden | Kevin Kern |
| 333 | If | 마녀유희 OST | 全慧彬 |
| 334 | 相思赋予谁 | 春生 | 好妹妹 |
| 335 | 画离弦 (柯柯吉他版) | 画离弦 | 柯柯柯啊 |
| 336 | 筝锋 | 功夫 电影原声大碟 | 黄英华 |
| 337 | Thinking Out Loud | NOW That's What I Call Music! 90 | Ed Sheeran |
| 338 | Righteous Path | Introducing Mellow | Blazo |
| 339 | Somebody That I Used To Know | Making Mirrors | Gotye Kimbra |
| 340 | Aloha Heja He | Melancholie und Sturmflut (Bonus Tracks Edition) | Achim Reichel |
| 341 | Palace Memories | Sound. Earth. Nature. Spirit. - Vol. Sound | S.E.N.S. |
| 342 | 回家(萨克斯风) | 金耳朵Ⅲ | Kenny G |
| 343 | Breath and Life | The Platinum Series III: Eterna | Audiomachine |
| 344 | East of Eden | East of Eden | Zella Day |
| 345 | Carpe Diem | Dead Poets Society | Maurice Jarre |
| 346 | Beautiful In White (Demo) | Beautiful In White (Demo) | Shane Filan |
| 347 | Keating's Triumph | Dead Poets Society | Maurice Jarre |
| 348 | Better Man | Sing When You're Winning | Robbie Williams |
| 349 | Love Me Like You Do | Delirium | Ellie Goulding |
| 350 | Summer | ENCORE | 久石譲 |
| 351 | Viva La Vida | Viva La Vida Or Death And All His Friends | Coldplay |
| 352 | 爱向着我来的那天 사랑아 내게 오기만 해 (PartⅠ) | 마녀유희 OST | Ashily |
| 353 | You're Beautiful | So Beautiful 1 | James Blunt |
| 354 | 思念是一种病 | OK | 张震岳 / 蔡健雅 |
| 355 | Sunburst | Sunburst | Tobu / Itro |
| 356 | Farewell to Camraw | When the Pipers Play | Black Kilts Berlin /Robert Mathieson |
| 357 | 想太多 | 想太多 | 李玖哲 |
| 358 | Booty Music | Git Fresh | Deep Side |
| 359 | Genie | THE BEST ~New Edition~ | 少女时代 |
| 360 | 樱花草 | 花言乔语 (精装版) | Sweety |
| 361 | Girlfriend | The Best Damn Thing: Deluxe Edition | Avril Lavigne |
| 362 | Remember The Name | Sampler Mixtape | Fort Minor |
| 363 | Right Here Waiting (Piano) | Right Here Waiting (Piano) | Basil Jose /Richard Marx |
| 364 | The Long Way Home | The Bright Side | Lenka |
| 365 | 单车恋人 | 9公主 | 后弦 |
| 366 | 愤怒的消失 그게 말이죠 | 마녀유희 OST | 木单车 |
| 367 | 西厢 | 古·玩 | 后弦 |
| 368 | Bye Bye Bye | Rising Love | Lovestoned |
| 369 | Star of the County Down | Musique Celtic | Rosheen |
| 370 | Main Title (The Godfather Waltz) | The Godfather I | Nino Rota |
| 371 | 命运的恶作剧 운명의 장난 | 마녀유희 OST | MC 真理 / 哈哈 |
| 372 | Far Away From Home | Greatest Hits | Groove Coverage |
| 373 | Damn You | The Unreleased Collection | Lana Del Rey |
| 374 | Love Yourself (Natio Remix) | Love Yourself (Natio Remix) | Natio / Justin Bieber / Conor Maynard |
| 375 | Red River Valley | Journey Home | Bronn Journey |
| 376 | 去年夏天 | 去年夏天 | 王大毛 |
| 377 | My Happy Ending | Under My Skin (Special Edition) | Avril Lavigne |
| 378 | 友谊之光 | 监狱风云 | 玛莉亚 |
| 379 | The Moon Represents My Heart | Love Ballads | Kenny G |
| 380 | Auld Lang Syne | The Greatest Gift | Charlie Landsborough |
| 381 | 口弦 | 听见凉山 电视剧原声带 | 赵艺涵 |
| 382 | 奇异恩典 | 最新热歌慢摇73 | Various Artists |
| 383 | Flower Dance | A Cup Of Coffee | DJ Okawari |
| 384 | Come And Get It | Chartsurfer Vol. 30 | Selena Gomez |
| 385 | Heartbeats | Swings and Roundabouts | Amy Deasismont |
| 386 | Hero | Hero | Enrique Iglesias |
| 387 | I Just Wanna Run | Take Action! Volume 9 | The Downtown Fiction |
| 388 | 莫失莫忘 | 仙剑奇侠传 电视原创配乐 | 麦振鸿 |
| 389 | I Want You to Know | I Want You to Know | Zedd / Selena Gomez |
| 390 | We Are Young | Dancing Bear Best Of 2012 International | Fun. Janelle Monáe |
| 391 | The Day You Went Away | The Day You Went Away: The Best of M2M | M2M |
| 392 | Sleepyhead | Acoustic Daydreams | Galen Crew |
| 393 | Moon As My Heart | Harmonica Sound of Hong Kong | Robert Bonfiglio |
| 394 | 卡农D大调 | 胎教音乐 | 群星 |
| 395 | My Soul | Time... | July |
| 396 | 富士山下 | What's Going On…? | 陈奕迅 |
| 397 | New Soul | Irlande | Vox Angeli |
| 398 | If I Die Young | If I Die Young - Single | The Band Perry |
| 399 | The Godfather (Love Theme) | The Godfather I | Nino Rota |
| 400 | My Love (Radio Edit) | Coast to Coast | Westlife |
| 401 | What Are Words | What Are Words | Chris Medina |
| 402 | Young For You | Young For You | GALA |
| 403 | The Ludlows | Legends Of The Fall Original Motion Picture Soundtrack | James Horner |
| 404 | Pop Danthology 2012 | Pop Danthology | DJ Daniel Kim |
| 405 | Paris | Paris | Else |
| 406 | 呼唤 오나라 I | 대장금 OST | 김지현 |
| 407 | 爱向着我来的那天2 사랑아 내게 오기만 해 (Part II) | 마녀유희 OST | Ashily |
| 408 | 再见 | 再见 | 张震岳 |
| 409 | 千千阙歌 | 千千阙歌 | 陈慧娴 |
| 410 | Kiss The Rain 비를 맞다 | The Best - Reminiscent 10th Anniversary | Yiruma |
| 411 | Runner | Runner | Dustin O'Halloran |
| 412 | This Is the Life | Weathered | Angie Miller |
| 413 | Dead Poets Society (Finale) | Filmharmonic II | The Royal Philharmonic Orchestra Maurice Jarre |
| 414 | The sally gardens | Arias Ancora | Laure Green |
| 415 | 送别 | 送别 | 韩红 |
| 416 | 安静 钢琴版 | 纯音乐流行歌曲钢琴版 | Paul Liu |
| 417 | Wrecking Ball | Wrecking Ball | Miley Cyrus |
| 418 | 是啊 그래 | 마녀유희 OST | 나창현 |
| 419 | Six Feet Under | Six Feet Under | Billie Eilish |
| 420 | 穿越时空的思念1 时代を超える想い1 | 映画“犬夜叉 时代を越える想い 音楽篇” | 和田薫 |
| 421 | Umbrella | Now That's What I Call Music! 25 Years | Rihanna / Jay-Z |
| 422 | Waka Waka (Esto Es África) | Waka Waka (This Time For Africa) (The Official 2010 Fifa World Cup Song) | Shakira |
| 423 | In The End | In The End | Linkin Park |
| 424 | Monody | Monody | TheFatRat / Laura Brehm |
| 425 | The Show | The Show | Lenka |
| 426 | 野子 (Live) | 我是歌手第四季 第3期 | 苏运莹 |
| 427 | Gee | The First Mini Album Gee | 少女时代 (소녀시대) |
| 428 | Ship In The Sand | Dear Me, Look Up | Marble Sounds |
| 429 | Summertime Sadness | Summertime Sadness | Lana Del Rey |
| 430 | 慕情 (M-4) | 犬夜叉 音楽篇 | 和田薫 |
| 431 | I Love You (Remix) | I Love You | United Idol |
| 432 | 你还要我怎样 | 意外 | 薛之谦 |
| 433 | 发现爱 | 西界 | 林俊杰 / 金莎 |
| 434 | 桥边姑娘 | 桥边姑娘 | 海伦 |
| 435 | 犯错 | 犯错 | 顾峰 / 斯琴高丽 |
| 436 | 那年初夏 | 毕业了我们一无所有 | 任然 |
| 437 | 北京欢迎你 | 北京2008年奥运会歌曲专辑 | 群星 |
| 438 | Red River Valley | Cowboy Songs | Michael Martin Murphey |
| 439 | 500 Miles | Buck The Trend | Peter, Paul & Mary |
| 440 | 500 Miles | Christ Is My Hope | The Innocence Mission |
| 441 | 500 Miles | Let's Folk | The Brothers Four |
| 442 | 画离弦 (柯柯版) | 画离弦 | 柯柯柯啊 |
| 443 | 阿凡达与屌丝男 | 心花路放 电影原声带 | 许鹤缤 |
| 444 | Skinny Love | Skinny Love | Birdy |
| 445 | 我的歌声里 | 我的歌声里 | 李代沫 |
| 446 | 情人 | 海阔天空 | Beyond |
| 447 | 桔梗谣 | 노들강변 매화타령 민요 | 노들강변 매화타령 민요 |
| 448 | 为爱痴狂 | 歌曲合辑 | 金志文 |
| 449 | Mariage d'amour | Lettre à ma Mère | Richard Clayderman |
| 450 | 世界第一等 | 世界第一等 | 浪哥 |
| 451 | Unable To Stay, Unwilling To Leave | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 452 | 带我到山顶 | 听见凉山 | 赵艺涵 |
| 453 | Baby | Baby | Justin Bieber / Ludacris |
| 454 | 春娇与志明 | 春娇与志明 | 街道办GDC /欧阳耀莹 |
| 455 | Nevada | Monstercat - Best of 2016 | Vicetone / Cozi Zuehlsdorff |
| 456 | 听妈妈的话 | 依然范特西 | 周杰伦 |
| 457 | Jambalaya | 不朽的声音(人生最难忘的歌) | Carpenters |
| 458 | 红尘情歌 | 情路无悔 | 高安 /黑鸭子组合 |
| 459 | Prendre sa main | Cri d'amour | Angel Lover |
| 460 | 安静 | 范特西 | 周杰伦 |
| 461 | 梦中蝶影 | 歌曲合辑 | 华语群星 |
| 462 | 姑娘我爱你 | 姑娘我爱你 | 索朗扎西 |
| 463 | 借我 | 算云烟 | 谢春花 |
| 464 | 兰亭序 | 魔杰座 | 周杰伦 |
| 465 | The Red Sun | 20 Years of Achievement around the World | Richard Clayderman |
| 466 | 纯真年代 | 大小世界 | 爱朵女孩 |
| 467 | Vincent | Legendary Don McLean | Don McLean |
| 468 | 平凡之路 | 猎户星座 | 朴树 |
| 469 | 李白 | 模特 | 李荣浩 |
| 470 | Coming Home | Coming Home | Skylar Grey / Diddy-Dirty Money |
| 471 | Turnin' | Young Rising Sons | Young Rising Sons |
| 472 | 意外 | 意外 | 薛之谦 |
| 473 | Promise | Promise | sapientdream |
| 474 | 那些年 | 那些年，我们一起追的女孩 电影原声带 | 胡夏 |
| 475 | 有一种爱叫做放手 | 有一种爱叫做放手 | 阿木 |
| 476 | 童年 | 童年 | 北京天使合唱团 |
| 477 | 赤伶(DJ版) | 赤伶 | DJ名龙 |
| 478 | 我最亲爱的 | 我的歌声里 | 李代沫 |
| 479 | Fight | Fight | BeatBrothers |
| 480 | 我希望 | 匆匆那年 电视原声带 | 杨玏 |
| 481 | 知道不知道 | Rene | 刘若英 |
| 482 | Don't Worry Be Happy | Pretty Donkey Girl | Holly Dolly |
| 483 | Say Hello | These Friends Of Mine | Rosie Thomas / Sufjan Stevens |
| 484 | The Right Path | Age of Innocence (Original Soundtrack) | Thomas Greenberg |
| 485 | 相思 | 腔.调 | 毛阿敏 |
| 486 | 相对 | 子曰 第一册 | 子曰乐队 |
| 487 | Sally Gardens | Spring | The O'Neill Brothers |
| 488 | 2 Phút Hơn (KAIZ Remix) | 2 Phút Hơn (KAIZ Remix) | Pháo / KAIZ |
| 489 | Valder Fields | A Plea en Vendredi | Tamas Wells |
| 490 | 刚好遇见你 | 刚好遇见你 | 李玉刚 |
| 491 | Way Back then | 오징어게임 OST | 郑在日 (정재일) |
| 492 | Luv Letter | 髙橋大輔～フェイヴァリット・ミュージック～ | 神津裕之 |
| 493 | 海阔天空 | 一声所爱 大地飞歌（第九期） | 汪小敏 |
| 494 | 万水千山总是情 | 万水千山总是情 电视剧原声带 | 汪明荃 |
| 495 | 希望 | Grace & Charm | 陈慧琳 |
| 496 | Anak (remix: Freddie Aguilar|Remix) | 清尘 | 清尘 |
| 497 | Liability | Melodrama | Lorde |
| 498 | Never Say Good Bye | 마이걸 | Mario & Nesty (마리오&네스티) |
| 499 | 城府 | 自定义 | 许嵩 |
| 500 | All Falls Down | All Falls Down | Alan Walker / Noah Cyrus / Digital Farm Animals / Juliander |
| 501 | 梦中的婚礼 | Richard Clayderman | Richard Clayderman |
| 502 | Faded | Faded | Alan Walker / Iselin Solheim |
| 503 | Take It From Me | Say I Am You | The Weepies / Deb Talan / Steve Tannen |
| 504 | 鼓楼 | 无法长大 | 赵雷 |
| 505 | You Belong To Me | To You | Carla Bruni |
| 506 | 发如雪 | 十一月的萧邦 | 周杰伦 |
| 507 | Windy Hill（风之谷） | Windy Hill | 羽肿 |
| 508 | Bloom of Youth | クドわふたー オリジナル サウンドトラック | 清水淳一 |
| 509 | Your Man | Double Cream 5: 20 Years of Nashville #1's 1992-2012 | Josh Turner |
| 510 | 热爱105°C的你 | 热爱105°C的你 | 腾格尔 / 艾伦 / 沈腾 |
| 511 | Eventide | Eventide | Nylon |
| 512 | Because of You | Because Of You | Kelly Clarkson |
| 513 | Demons | Continued Silence EP | Imagine Dragons |
| 514 | Take Me To Church | Bravo Hits 86 | Hozier |
| 515 | Just One Last Dance (Album Version) | Key To My Soul | Sarah Connor /Marc Terenzi |
| 516 | Love The Way You Lie (Part III (Original Demo)) | Relaxing Acoustic | Skylar Grey |
| 517 | 小苹果 | 老男孩之猛龙过江 电影原声 | 筷子兄弟 |
| 518 | 我是一只小小鸟 | 我是一只小小鸟 | 赵传 |
| 519 | Be What You Wanna Be | Darin | Darin |
| 520 | 好久不见 | 认了吧 | 陈奕迅 |
| 521 | Young And Beautiful | Triple J Hottest 100 Vol 21 | Lana Del Rey |
| 522 | 长路漫漫任我闯 | 林子祥精选之天长地久 | 林子祥 |
| 523 | Frail Love | Frail Love | Cloves |
| 524 | Scarborough Fair | The Very Best of Sarah Brightman 1990-2000 | Sarah Brightman |
| 525 | 从头再来 | 经典20年 珍藏锦集 | 刘欢 |
| 526 | 浮夸 | U-87 | 陈奕迅 |
| 527 | The Ocean (Radio Edit) | The Ocean | Mike Perry / SHY Martin |
| 528 | Lonely | Nana | Nana |
| 529 | Unity | Sounds of Syndication, Vol .1 (Presented by Syndicate) | TheFatRat |
| 530 | Hey, Soul Sister | Save Me, San Francisco | Train |
| 531 | Too Far | King in the Mirror | Anna F |
| 532 | Inspire | Serenity | Capo Productions |
| 533 | Sutter's Mill | The Music of Dan Fogelberg | Dan Fogelberg |
| 534 | Please Don't Go | Please Don't Go | Joel Adams |
| 535 | 曾经的你 | 每一刻都是崭新的 | 许巍 |
| 536 | Stay Here Forever | Valentine's Day OST | Jewel |
| 537 | 存在 | 生无所求 | 汪峰 |
| 538 | Stay Alive | The Secret Life Of Walter Mitty (Music From And Inspired By The Motion Picture) | José González |
| 539 | Everybody | Everybody | Ingrid Michaelson |
| 540 | 传奇 | 传奇 | 王菲 |
| 541 | 易燃易爆炸 | 如也 | 陈粒 |
| 542 | 飞向别人的床 | 飞向别人的床 | 沉珂（C.K）& 光光 |
| 543 | 赤伶 (弹唱版) | 赤伶 | 孙鹏凯 |
| 544 | Astronomia（黑人抬棺古风版） | 黑人抬棺古风版 | litterzy、水玥儿 |
| 545 | I Want My Tears Back | Imaginaerum | Nightwish |
| 546 | 红颜 | MuSiC混合体 | 胡彦斌 |
| 547 | 혼자시킨 사랑 独自的爱情 | 명랑소녀 성공기 OST | True Bird |
| 548 | 潮湿的心 | 蜕变1少女的心情故事 | 卓依婷 |
| 549 | brave heart | brave heart | 宮崎歩 |
| 550 | 明天过后 | 明天过后 | 张杰 |
| 551 | Love Theme | 명랑소녀 성공기 OST | 吴振宇 |
| 552 | Read My Mind | Jade | Sweetbox |
| 553 | Let It Out | Let It Out | Frances |
| 554 | Love Song | 명랑소녀 성공기 OST | 赵长赫 |
| 555 | 飞得更高 | 笑着哭 | 汪峰 |
| 556 | 花火 | 花火 | 汪峰 |
| 557 | 直到永远 | 生死不离 我们在一起 | 汪峰 |
| 558 | 跟往事干杯 | 不朽金曲精选 Ⅰ | 姜育恒 |
| 559 | 蓝莲花 | 时光.漫步 | 许巍 |
| 560 | 娃娃脸 | 娃娃脸 | 后弦 |
| 561 | 我爱你中国 | 怒放的生命 | 汪峰 |
| 562 | 星象仪 プラネタリウム | プラネタリウム | 大塚爱 |
| 563 | 一直很安静 | 寂寞在唱歌 | 阿桑 |
| 564 | 生活不止眼前的苟且 | 生活不止眼前的苟且 | 许巍 |
| 565 | Tears Of A Clown | Mastercutor | U.D.O. |
| 566 | 運命のルーレット廻して (转动命运之轮) | 運命のルーレット廻して | ZARD (ザード) |
| 567 | For Free | Folk For Kids | Lana Del Rey / Zella Day / Weyes Blood |
| 568 | My Destiny (我的命运) | 별에서 온 그대 OST Part 1 | LYn (린) |
| 569 | 亲爱的路人 | 亲爱的路人 | 刘若英 |
| 570 | Call Me Maybe | Call Me Maybe | Carly Rae Jepsen |
| 571 | 花开在眼前 | 花开在眼前 | 韩磊 |
| 572 | 如果不能好好爱 | 如果不能好好爱 | 吴克群 |
| 573 | 童年 | 纵贯线演唱会 | 罗大佑、李宗盛、张震岳、周华健 |
| 574 | 魔訶不思議アドベンチャー! | ドラゴンボール全曲集 | 高橋洋樹 |
| 575 | One Night In 北京 | SHIN 同名专辑 | 信乐团 |
| 576 | The Monster | The Monster | Eminem / Rihanna |
| 577 | Amazing Grace 天赐恩宠 | 苏格兰音乐之旅 苏格兰风笛 | 群星 |
| 578 | 小仙女 | 武侠音乐系列之缠绵悱恻 （截取版） | 麦振鸿 |
| 579 | Élan | Élan | Nightwish |
| 580 | 喜剧之王 | 喜剧之王 | 李荣浩 |
| 581 | Scotland the Brave 苏格兰勇士 | 苏格兰音乐之旅 苏格兰风笛 | 群星 |
| 582 | 月牙湾 | 爱.歌姬 | F.I.R. |
| 583 | Gangsta Bop | Konvicted | Akon |
| 584 | Hallelujah | Warmer In The Winter (Deluxe Edition) | Lindsey Stirling |
| 585 | Nijamena (BGM版) | Nijamena | H2s |
| 586 | 二泉映月 | 阿炳全集 | 阿炳 |
| 587 | 男儿当自强 | 笑傲歌坛 传世经典 | 林子祥 |
| 588 | 上海滩 | 上海滩 | 叶丽仪 |
| 589 | 我和你 | 北京2008 奥运会、残奥会开闭幕式主题歌曲专辑 | 刘欢 / Sarah Brightman |
| 590 | 算你狠 | 绝对收藏 | 陈小春 |
| 591 | 黄种人 | 黄·锋 | 谢霆锋 |
| 592 | Croatian Rhapsody | The Piano Player | Maksim Mrvica |
| 593 | He's a Pirate | Pirates of the Caribbean: The Curse of the Black Pearl | Klaus Badelt |
| 594 | 星月神话 | 女人又一次哭泣 | 金莎 |
| 595 | 夜上海 | 夜上海精选 | 周璇 |
| 596 | 带你去旅行 | 带你去旅行 | 校长（张驰） |
| 597 | 天下第一 | 武侠音乐系列之豪气中天 （截取版） | 麦振鸿 / 罗坚 |
| 598 | '97爱情宣言 | 狼 97黄金自选辑 | 齐秦 |
| 599 | 外面的世界 | 燃烧爱情（狼之旅） | 齐秦 |
| 600 | 小酒窝 | JJ陆 | 林俊杰 / 蔡卓妍 |
| 601 | Past Lives | Drowning | Slushii |
| 602 | 往事随风 | 痛并快乐着 | 齐秦 |
| 603 | Go Time | Go Time | Mark Petrie |
| 604 | Someone to Stay | Someone to Stay | Vancouver Sleep Clinic |
| 605 | The Portrait | Titanic: Special Edition | James Horner |
| 606 | 那年我双手插兜 不知道什么叫做对手 | 那年我双手插兜 不知道什么叫做对手（语录版） | 黑左 / 莎馬淑鳐 / 刘liu创意人 |
| 607 | 你还欠我一个拥抱 | 很有爱 | 后弦 / Sara |
| 608 | Strength of a Thousand Men | Archangel | Two Steps From Hell |
| 609 | 匆匆那年 | 匆匆那年 电影原声带 | 王菲 |
| 610 | Spirit of the Wild | Age of Wonders | BrunuhVille |
| 611 | 命运 운명 | 풀 하우스 OST (KBS 미니시리즈) | Why |
| 612 | 大海~ | Asia | THE JAYWALK |
| 613 | 热爱105°C的你 | 热爱105°C的你 | 阿肆 |
| 614 | Flavor Of Life | Flavor Of Life | 宇多田ヒカル |
| 615 | Death Of Titanic | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 616 | 孤勇者_凤凰传奇 | 孤勇者 | 凤凰传奇 |
| 617 | 不如不见 | What's Going On…? | 陈奕迅 |
| 618 | Distant Memories | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 619 | 偏爱 | 破天荒 | 张芸京 |
| 620 | Diamonds | Diamonds | Rihanna |
| 621 | 我欲成仙 | 西游记后传片头曲 | 刘欢 |
| 622 | 希望 (国语) | 我是阳光的 | 陈慧琳 |
| 623 | Something Just Like This | Something Just Like This | The Chainsmokers / Coldplay |
| 624 | 辞九门回忆(DJ版) | 未知 | 未知 |
