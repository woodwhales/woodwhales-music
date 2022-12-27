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

### 1.0.0

-   前端页面加载完毕，可离线播放。
-   后台系统可添加、编辑、删除音乐，并对音乐列表排序。
-   添加音乐：可从音乐平台 html 动态解析，支持：网易云、QQ云音乐、虾米音乐（平台已关闭）。

### 2.0.0

-   添加、编辑音乐信息时，当填写了音乐链接或者封面链接其中之一后，可自动填充另外一个文本内容。

### 3.0.0

- 支持导出已关联音乐清单。

###  3.5.0

- 引入 [woodwhales-common](https://github.com/woodwhales/woodwhales-common) 依赖

### 3.5.5

- 修复 cdn.jsdelivr.net 因未翻墙而无法访问题
- woodwhales-common 版本依赖更新

## 前台

访问端口：http://127.0.0.1:8084/music/

![](doc/images/index.png)

## 后台

访问端口：http://127.0.0.1:8084/music/admin/

dev 环境账号密码：admin / admin

### 首页

![](doc/images/admin-index.png)

音乐名称为<font color='gree'>绿色字体</font>，表示该音乐**已关联**音频链接和专辑封面链接。

音乐名称为<font color='red'>红色字体</font>，表示该音乐**未关联**音频链接和专辑封面链接。

### 添加/编辑

太懒了，加了个解析音乐平台的解析器，一旦解析成功，自动填充：音乐名称、作者、专辑名称。

> 支持：网易云、QQ 音乐、虾米音乐（平台已关闭）

![](doc/images/admin-add.png)

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
| 11 | Journey | Serenity | Capo Productions |
| 12 | 惊蛰 | 二十四节气 | 音阙诗听 / 王梓钰 |
| 13 | 孤勇者 | 孤勇者 | 陈奕迅 |
| 14 | 关于郑州的记忆 | 《你好，郑州》 | 李志 |
| 15 | 哀歌 (M-5) | 犬夜叉 音楽篇 | 和田薫 |
| 16 | 野狼disco | 野狼disco | 宝石Gem |
| 17 | 童年 | 罗大佑自选辑 | 罗大佑 |
| 18 | For the Love of a Princess | Braveheart (Original Motion Picture Soundtrack) (Expanded Edition) | James Horner |
| 19 | 老街 | 小黄 | 李荣浩 |
| 20 | 恋曲1990 | 昨日情歌74-89 | 罗大佑 |
| 21 | 光阴的故事 | 命中注定最犀利 | 罗大佑 |
| 22 | 情非得已 | 遇见100%幸福1 烈爱红盘 | 庾澄庆 |
| 23 | 你要相信这不是最后一天 | 你要相信这不是最后一天 | 华晨宇 |
| 24 | 蜀绣 | 蜀绣 | 李宇春 |
| 25 | 追梦赤子心 | 追梦痴子心 | GALA |
| 26 | Jasmine Flower | Love Ballads | Kenny G |
| 27 | 太阳照常升起 | 太阳照常升起 电影原声大碟 | 久石譲 |
| 28 | Destiny | 마녀유희 OST | 李成旭 |
| 29 | 1965 | 1965 | Zella Day |
| 30 | A Thousand Years | A Thousand Years | Christina Perri |
| 31 | Come By the Hills | Song of the Irish Whistle 2 | Joanie Madden |
| 32 | La Valse D'Amelie | Le Fabuleux destin d'Amélie Poulain | Yann Tiersen |
| 33 | 理想三旬 | 浓烟下的诗歌电台 | 陈鸿宇 |
| 34 | 东风破  | 叶惠美 | 周杰伦 |
| 35 | The Long And Winding Street | Mellow Candle | Robert de Boron |
| 36 | 安和桥 | 安和桥北 | 宋冬野 |
| 37 | The Cello Song | The Piano Guys: Hits Volume 1 | Steven Sharp Nelson |
| 38 | 当我想你的时候 | 当我想你的时候 | 汪峰 |
| 39 | 明天，你好 | Lost & Found 去寻找 | 牛奶咖啡 |
| 40 | 芒种 | 二十四节气 | 音阙诗听 / 赵方婧 |
| 41 | 漂浮地铁 | N+1 Evolution 珍藏版 | 李宇春 |
| 42 | 别送我 | 别送我 | 陈鸿宇 / 苏紫旭 / 刘昊霖 / 寒洛&鼓润 |
| 43 | 稻香 | 魔杰座 | 周杰伦 |
| 44 | 认真的雪 | 未完成的歌 | 薛之谦 |
| 45 | 浅草キッド | GOLDEN☆BEST | 北野武 |
| 46 | 晚风花香 | 原乡情浓 | 邓丽君 |
| 47 | 沉默是金 | 张国荣经典金曲精选 | 张国荣 |
| 48 | Best of 2012: Payphone/Call Me Maybe/Wide Awake/Starship/We Are Young | Anthem Lights Covers | Anthem Lights |
| 49 | 为爱痴狂 | 收获 新歌+精选 | 刘若英 |
| 50 | Lemon Tree | Dish Of The Day | Fool's Garden |
| 51 | 广东十年爱情故事 | 广东十年爱情故事 | 广东雨神 |
| 52 | Turning Tables | 21 | Adele |
| 53 | Monsters | Monsters | Katie Sky |
| 54 | A Day at a Time | Life In a Day (O.S.T) | Ellie Goulding Matthew Herbert |
| 55 | 我的八十年代 | 别再问我什么是迪斯科 | 张蔷 |
| 56 | 南山南 | 南山南 | 马頔 |
| 57 | 后会无期 | 后会无期 | G.E.M.邓紫棋 |
| 58 | 画心 | 画心 | 张靓颖 |
| 59 | 为爱痴狂_陈梦嘉 | THUG LIFE | 陈梦嘉 |
| 60 | Yellow | Best Of British | Coldplay |
| 61 | 一百万个可能 | 一百万个可能 | Christine Welch |
| 62 | 习惯了寂寞 | 习惯了寂寞 | 牛奶咖啡 |
| 63 | 我的歌声里 | Everything In The World (白金庆功版) | 曲婉婷 |
| 64 | 一剪梅 | 花神 | 黄渤 /左小祖咒 |
| 65 | A Life So Changed | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 66 | Here We Are Again (纯音乐) (《喜剧之王》电影插曲) | Here We Are Again (纯音乐) (《喜剧之王》电影插曲) | Cagnet (キャグネット) |
| 67 | 相思好比小蚂蚁 | 特别的日子 | 张蔷 |
| 68 | 宝贝 (in a day) | Original | 张悬 |
| 69 | Down By The Salley Gardens | camomile | 藤田恵美 (ふじた えみ) |
| 70 | 这世界那么多人 | 这世界那么多人 | 莫文蔚 |
| 71 | 明天你是否依然爱我 | 其实你不懂我的心 | 童安格 |
| 72 | With An Orchid | If I Could Tell You | Yanni |
| 73 | 爱如潮水 | 张信哲精选 | 张信哲 |
| 74 | 7 Years | The Young Pope (Original Series Sountrack) | Lukas Graham |
| 75 | The Sound of Silence (Reprise) | The Graduate | Simon & Garfunkel |
| 76 | BINGBIAN病变 (女声版) | BINGBIAN病变 (女声版) | 鞠文娴 |
| 77 | Don't You Remember | 21 | Adele |
| 78 | かごめと犬夜叉 (M-11+6) | 犬夜叉 音楽篇 | 和田薫 |
| 79 | 吉姆餐厅 | 吉姆餐厅 | 赵雷 |
| 80 | 很爱很爱你 | 很爱很爱你 | 刘若英 |
| 81 | 我们的时光 | 吉姆餐厅 | 赵雷 |
| 82 | Women of Ireland | Song of the Irish Whistle | Joanie Madden |
| 83 | Traveling Light | Traveling Light | Joel Hanson |
| 84 | 笑看风云 (Live) | 汪小敏 笑看风云 | 汪小敏 |
| 85 | 醉赤壁 | JJ陆 | 林俊杰 |
| 86 | 再度重相逢 | 泪桥 | 伍佰 & China Blue |
| 87 | The Way Of Life | 오! 필승 봉순영 OST | 吴硕浚 |
| 88 | 世界这么大还是遇见你 (清新的小女孩（中文版）) | 清新的小女孩（中文版） | 程响 |
| 89 | 夏日漱石 (Summer Cozy Rock) | 浪潮上岸 (Tears In Ocean) | 橘子海 (Orange Ocean) |
| 90 | Chasing Pavements | Chasing Pavements | Adele |
| 91 | Right Here Waiting | Ballads | Richard Marx |
| 92 | 成都 | 成都 | 赵雷 |
| 93 | Faidherbe square (instrumental) | Curses from past times | ProleteR |
| 94 | Easy Breeze | Something Simple | Thomas Greenberg |
| 95 | Spring In My Step | Spring In My Step | Silent Partner |
| 96 | Free Loop | Cf, Movie & Drama Hits 广告，开麦拉！ | Daniel Powter |
| 97 | 不让我的眼泪陪我过夜 | 丝路 | 齐秦 |
| 98 | I Could Be The One | Acoustic | Donna Lewis |
| 99 | Unchained Melody | Ghost | Alex North |
| 100 | Let Her Go | All The Little Lights | Passenger |
| 101 | Jar Of Love | Everything In The World (白金庆功版) | 曲婉婷 |
| 102 | 菊花爆满山 | 菊花爆满山 | 马博 |
| 103 | John of the Glen | Song of the Irish Whistle 2 | Joanie Madden |
| 104 | Illusionary Daytime | Endless Daydream | Shirfine |
| 105 | Marry You | Now Los Mejores Exitos Del Ano 2012 | Bruno Mars |
| 106 | Seve | Seve | Tez Cadey |
| 107 | 似水流年 | Salute | 张国荣 |
| 108 | Rolling In The Deep | Rolling In The Deep | Adele |
| 109 | 喜欢你 | Beyond 25th Anniversary | Beyond |
| 110 | 我只在乎你 | 我只在乎你 | 邓丽君 |
| 111 | Coachella - Woodstock In My Mind | Lust For Life | Lana Del Rey |
| 112 | 海阔天空 | 乐与怒 | Beyond |
| 113 | 傲气傲笑万重浪 | 黄飞鸿系列电影原声精装版 | 黄霑 |
| 114 | 倩女幽魂 | Ultimate | 张国荣 |
| 115 | Angolan Women | Life In a Day (O.S.T) | The Three Angolan Women |
| 116 | 清明雨上 | 自定义 | 许嵩 |
| 117 | Set Fire to the Rain | 21 | Adele |
| 118 | That Girl | 24 HRS (Deluxe) | Olly Murs |
| 119 | 小情歌 | 小宇宙 | 苏打绿 |
| 120 | 阳光总在风雨后 | 都是夜归人 | 许美静 |
| 121 | Day by Day | 마녀유희 OST | 赵冠宇 |
| 122 | The Sound of Silence (Album Version) | Forever Friends 'Just For You' | Simon & Garfunkel |
| 123 | Refrain | Eternal Light | 阿南亮子 (あなん りょうこ) |
| 124 | 盛夏的果实 | 莫后年代 莫文蔚20周年世纪典藏 | 莫文蔚 |
| 125 | Dark Paradise (Alternative Demo) | Born To Die (Demos) | Lana Del Rey |
| 126 | Dirty Paws | Summer Acoustic | Of Monsters And Men |
| 127 | Miracle In The Middle Of My Heart (Original Mix) | Miracle In The Middle Of My Heart (Original Mix) | Clément Bcx |
| 128 | 老朋友 | 老朋友 | 杨尘,王旭(旭日阳刚) |
| 129 | Whistle | Glee: The Music - The Complete Season Four | Glee Cast |
| 130 | She | 7 Years and 50 Days | Groove Coverage |
| 131 | 十月：我和曾经的我们 | 迷藏 | 钟城 / 姚望 |
| 132 | Stronger | Kids Top 20 - De Grootste Hits Van 2013 - Summer Edition 2013 | Kelly Clarkson |
| 133 | The Immigrant | Song of the Irish Whistle | Joanie Madden |
| 134 | 家族の风景 | 虹の歌集 | 手嶌葵 |
| 135 | 爱拼才会赢 | 爱拼才会赢 | 叶启田 |
| 136 | 单身情歌 | 单身情歌．超炫精选 | 林志炫 |
| 137 | 丑八怪 | 意外 | 薛之谦 |
| 138 | 沧海一声笑 | 沧海一声笑 | 许冠杰 |
| 139 | 桔梗谣 | 桔梗谣 | 阿里郎 |
| 140 | Intro | xx | The xx |
| 141 | Need You Now | iTunes Session | Lady A |
| 142 | 父亲 | 父亲 | 筷子兄弟 |
| 143 | 桔梗谣 | 织谣 | 斯琴格日乐 |
| 144 | 老男孩 | 父亲 | 筷子兄弟 |
| 145 | 彩云之南 | 彩云之南 | 徐千雅 |
| 146 | Chasing Pavements | Chasing Pavements | Adele |
| 147 | 合肥的石头 | 赤脚青春 | 飘乐队 |
| 148 | 似夜流月 | 热门华语234 | 宗次郎 (そうじろう) |
| 149 | Five hundred miles | America, Vol. 10: Country - The Folk Revival Revolution | The Journeymen |
| 150 | 芒种 | 二十四节气 | 音阙诗听 / 赵方婧 |
| 151 | Right Now (Na Na Na) | Right Now (Na Na Na) | Akon |
| 152 | Victory | Battlecry | Two Steps From Hell |
| 153 | 桔梗谣(道拉基) (朝鲜民谣) | 恋恋金达莱 | 蒋薇 |
| 154 | Down By the Salley Gardens | Song of the Irish Whistle | Joanie Madden |
| 155 | 故乡 | 我只有两天.许巍精选 | 许巍 |
| 156 | 小鱼儿的思绪 | 武侠音乐系列第二部之思情篇（截取版） | 麦振鸿 |
| 157 | Bubbly | So Fresh - The Hits Of Autumn 2008 | Colbie Caillat |
| 158 | 我很好 | I'm fine | 刘沁 |
| 159 | 江南 | 他是…JJ林俊杰 | 林俊杰 |
| 160 | 勇敢的心 | 勇敢的心 | 汪峰 |
| 161 | 年少有为 | 耳朵 | 李荣浩 |
| 162 | Price Tag | Price Tag | Jessie J / B.o.B |
| 163 | The Sound of Silence_轻音乐 | The Best Pan Pipes in the World...Ever! | Panpipes |
| 164 | Eversleeping | Eversleeping | Xandria |
| 165 | Breaking My Heart | Breaking My Heart | Lana Del Rey |
| 166 | Dying In the Sun | Bury the Hatchet | The Cranberries |
| 167 | See You Again | See You Again | See You Again |
| 168 | I Am You | I Am You | Kim Taylor |
| 169 | I'm Yours | I'm Yours | Jason Mraz |
| 170 | Innocence | The Best Damn Thing: Deluxe Edition | Avril Lavigne |
| 171 | 一生所爱 | 齐天周大圣之西游双记 电影歌乐游唱版 | 卢冠廷 / 莫文蔚 |
| 172 | 潇洒地走 | 潇洒地走 | 张蔷 |
| 173 | Apologize | Dreaming Out Loud (Tour Edition) | OneRepublic |
| 174 | Better Than One | The Score EP 2 | The Score |
| 175 | 停格 | 停格 | 蔡健雅 |
| 176 | When You're Gone | When You're Gone | Avril Lavigne |
| 177 | 容易受伤的女人 | 阿菲正传 | 王菲 |
| 178 | Astronomia | Astronomia | Vicetone / Tony Igy |
| 179 | River Flows In You | Kuschelklassik Piano Dreams, Vol. 2 | Martin Ermen |
| 180 | 倔强 | 神的孩子都在跳舞 | 五月天 |
| 181 | 牛仔很忙 | 我很忙 | 周杰伦 |
| 182 | Last Reunion | Lament of Valkyrie (Epicmusicvn Series) | Peter Roe |
| 183 | Concerning Hobbits | The Lord of the Rings: The Fellowship of the Ring (Original Motion Picture Soundtrack) | Howard Shore |
| 184 | 起风了 | 起风了 | 吴青峰 |
| 185 | 日晷之梦 | 幸福时光 精选辑 | Kevin Kern |
| 186 | 分手以后才知道最珍贵 | 回到家乡 | 胡力 |
| 187 | 叱咤红人 | 相依为命: 20年精彩印记 | 陈小春 |
| 188 | 天才白痴梦 | 天才与白痴 | 许冠杰 |
| 189 | 往事只能回味 | 怀念老歌一 | 高胜美 |
| 190 | 我这家伙的答案是你 | AsuRa BalBalTa | Leessang / 河琳 |
| 191 | 往事只能回味 | 我是歌手第四季 第9期 | 金志文 |
| 192 | 勇敢的心 | 最新热歌慢摇88 | Various Artists |
| 193 | 等一分钟 | 滕爱Teng Love | 徐誉滕 |
| 194 | 我想大声告诉你 (《蜗居》电视剧片尾曲) | 我想大声告诉你 | 樊凡 |
| 195 | 光阴的故事 | 光阴的故事 | 黄晓明 邓超 佟大为 |
| 196 | 越长大越孤单 | 越长大越孤单 | 牛奶咖啡 |
| 197 | 知足 | 知足 最真杰作选 | 五月天 |
| 198 | 往事只能回味 | 说时依旧 | 好妹妹 |
| 199 | 演员 | 绅士 | 薛之谦 |
| 200 | 一起摇摆 | 生来彷徨 | 汪峰 |
| 201 | 南方姑娘 | 赵小雷 | 赵雷 |
| 202 | 我最亲爱的 | 你在看我吗 | 张惠妹 |
| 203 | 문을 여시오 (New Ver.) 请开门 | 문을 여시오 | 任昌丁 / 金昌烈 |
| 204 | Cornfield Chase | Interstellar (Original Motion Picture Soundtrack) | Hans Zimmer |
| 205 | Riverside | Philharmonics (Deluxe Edition) | Agnes Obel |
| 206 | Gotta Have You | Say I Am You | The Weepies |
| 207 | Big Big World | Big Big World | Emilia |
| 208 | 认错 | 自定义 | 许嵩 |
| 209 | 月光下的凤尾竹 (葫芦丝) | 金耳朵.发烧民乐 | 纯音乐 |
| 210 | Love The Way You Lie | Life After Recovery | Eminem / Rihanna |
| 211 | 好汉歌 | 好汉歌 | 刘欢 |
| 212 | My Heart Will Go On | Love Ballads | Kenny G |
| 213 | 布拉格广场 | 看我72变 | 蔡依林 / 周杰伦 |
| 214 | 粉红色的回忆 | 粉红色的回忆 | 韩宝仪 |
| 215 | 穿越时空的思念 (DiESi Remix) | 穿越时空的思念 | DiESi |
| 216 | Hello | Hello | Adele |
| 217 | Chiru (Saisei No Uta) | Nostalgic | Robert de Boron |
| 218 | Southampton | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 219 | 雪见·落入凡尘 | 仙剑奇侠传三 电视剧原声带 | 麦振鸿 |
| 220 | 时间都去哪儿了 | 听得到的时间 | 王铮亮 |
| 221 | 土耳其进行曲 | 土耳其进行曲 | Various Artists |
| 222 | That's Not My Name | That's Not My Name | The Ting Tings |
| 223 | The Mountain of Women | Song of the Irish Whistle | Joanie Madden |
| 224 | Hymn To The Sea | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 225 | Don't push me | Jade - silver edition | sweetbox |
| 226 | Just Give Me A Reason | The Truth About Love | P!nk Nate Ruess |
| 227 | いつも何度でも | Prime Selection | 宗次郎 |
| 228 | 光年之外 | 光年之外 | G.E.M.邓紫棋 |
| 229 | Take It From Me | Say I Am You | The Weepies |
| 230 | 差生 | 少年中国 | 李宇春 |
| 231 | Nocturne No. 2 in E Flat Major, Op. 9, No. 2 | The Chopin Collection: The Nocturnes | Arthur Rubinstein |
| 232 | 青花瓷 | 我很忙 | 周杰伦 |
| 233 | Beyond The Memory | Beyond The Memory | July |
| 234 | 十年 | 黑白灰 | 陈奕迅 |
| 235 | 送别 | 送别 | 朴树 |
| 236 | 曹操 | 曹操 | 林俊杰 |
| 237 | 黑板情书 | 黑板情书 | 后弦 |
| 238 | I can't let this go on any further | I can't let this go on any further | Savior |
| 239 | 一辈子的孤单 | 涩女郎 电视原声带 | 刘若英 |
| 240 | 因为爱情 | Stranger Under My Skin | 陈奕迅 王菲 |
| 241 | 我从崖边跌落 | 算云烟 | 谢春花 |
| 242 | 往事只能回味 | 往事只能回味 | 岳云鹏 / 宋小宝 |
| 243 | Never An Absolution | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 244 | Rose | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 245 | 关于郑州的记忆 | 你好，郑州 | 李志 |
| 246 | 突然的自我 | 忘情1015精选辑 | 伍佰 & China Blue |
| 247 | Roses and Gold | Dust Diaries | Robin Jackson |
| 248 | 春风十里 | 所有的酒，都不如你 | 鹿先森乐队 |
| 249 | 星座书上 | 自定义 | 许嵩 |
| 250 | Yesterday Once More | Yesterday Once More | Carpenters |
| 251 | 粉末 | 粉末 | 李宇春 |
| 252 | 苏州城外的微笑 | 很有爱 | 后弦 |
| 253 | Hey Jude | It's a Battle | John Lennon / Paul McCartney / It's a Cover Up |
| 254 | 天下 | 明天过后 | 张杰 |
| 255 | Last Dance | 爱情的尽头 | 伍佰 & China Blue |
| 256 | Miss Misery | Good Will Hunting (Music from the Miramax Motion Picture) | Elliott Smith |
| 257 | 宝贝 (in the night) | Original | 张悬 |
| 258 | 不再犹豫 | Beyond The Stage | Beyond |
| 259 | Take a Bow | Good Girl Gone Bad | Rihanna |
| 260 | 泡沫 | Xposed | G.E.M.邓紫棋 |
| 261 | 没有什么不同 | 我的歌声里 | 曲婉婷 |
| 262 | 夜太黑 | 夜太黑 | 林忆莲 |
| 263 | 故乡的原风景 | 武侠音乐精装特辑 | 宗次郎 |
| 264 | 亲爱的那不是爱情 | Ang 5.0 | 张韶涵 |
| 265 | 红色高跟鞋 | 若你碰到他 | 蔡健雅 |
| 266 | The End of the World | The End of the World | Skeeter Davis |
| 267 | 怒放的生命 | 怒放的生命 | 汪峰 |
| 268 | 大约在冬季 | 冬雨 | 齐秦 |
| 269 | 喜欢你 | 喜欢你 | G.E.M. 邓紫棋 |
| 270 | 挪威的森林 | 爱情的尽头 | 伍佰 & China Blue |
| 271 | 本草纲目 | 依然范特西 | 周杰伦 |
| 272 | 小刀会序曲 | 武侠音乐系列之豪气中天 | 商易 / 夏飞云 / 上海民族乐团 |
| 273 | 2 Soon | Not Thinking Bout 2morrow | Jon Young |
| 274 | 彩云追月 | Edell.Love | 爱戴 |
| 275 | 忧伤倒数 | 夫妻那些事 电视剧原声带 | 小昔米 |
| 276 | 爱情转移 | 认了吧 | 陈奕迅 |
| 277 | 阳光下的我们 | Say The Words | 曲婉婷 |
| 278 | 今天 | 真永远 | 刘德华 |
| 279 | Breaking My Heart | Unreleased | Lana Del Rey |
| 280 | 隐形的翅膀 | 潘朵拉 | 张韶涵 |
| 281 | 蝴蝶泉边 | 崽崽 | 黄雅莉 |
| 282 | Tassel | Dulcet Series spring special collection | Cymophane |
| 283 | Sugar | V | Maroon 5 |
| 284 | 七里香 | 七里香 | 周杰伦 |
| 285 | 庐州月 | 寻雾启示 | 许嵩 |
| 286 | Only Time | Only Time: The Collection (Box Set) | Enya |
| 287 | 香水有毒 (DJ版) | 香水有毒(宣传单曲) | 胡杨林 |
| 288 | 有何不可 | 自定义 | 许嵩 |
| 289 | 真的爱你 | BEYOND IV | Beyond |
| 290 | Remember The Time | The Ultimate Collection | Michael Jackson |
| 291 | Teenage Dream | Teenage Dream | Katy Perry |
| 292 | 莫扎特：《小夜曲》第一乐章 | 2008-2011 演奏实况合集 | 中国国家交响乐团 |
| 293 | Loves Me Not | t.A.T.u. - The Best | t.A.T.u. |
| 294 | 穿越时空的思念2 时代を超える想い2 | 映画“犬夜叉 时代を越える想い 音楽篇” | 和田薫 |
| 295 | 毕业说分手 | 毕业说分手 | 冰冰超人 |
| 296 | The South Wind | Song of the Irish Whistle | Joanie Madden |
| 297 | The Scientist | The Scientist | Coldplay |
| 298 | 大海 | 70老男孩 | 张雨生 |
| 299 | 八年的爱 | 八年的爱 | 冰冰超人 |
| 300 | TiK ToK | Animal | Kesha |
| 301 | Underneath Your Clothes | Laundry Service | Shakira |
| 302 | My Heart Will Go On | My Love: Ultimate Essential Collection (North American Version) | Celine Dion |
| 303 | 我变了 我没变 | 我变了 我没变 | 杨宗纬 |
| 304 | Trip | Trip | Axero |
| 305 | 断桥残雪 | 断桥残雪 | 许嵩 |
| 306 | 春天里 | 信仰在空中飘扬 | 汪峰 |
| 307 | What A Wonderful World | All Time Greatest Hits | Louis Armstrong |
| 308 | 光明 | 信仰在空中飘扬 | 汪峰 |
| 309 | 光辉岁月 | 光辉岁月 | Beyond |
| 310 | Rhythm Of The Rain | Let It Be Me | Jason Donovan |
| 311 | Five Hundred Miles (《醉乡民谣》电影主题曲|《一路繁花相送》电视剧插曲) | Inside Llewyn Davis: Original Soundtrack Recording | Justin Timberlake / Carey Mull |
| 312 | Snowdreams 雪之梦 | Rhine River | Bandari |
| 313 | Not a Single Day 하루도 | Rain's World (Special Edition) | Rain |
| 314 | Don't Wanna Know/We Don't Talk Anymore | Don't Wanna Know/We Don't Talk Anymore | Sam Tsui Alex Blue |
| 315 | Summer Vibe | Summer Vibe | Walk off the Earth |
| 316 | We Are One | Super Deluxe Sound I | Kelly Sweet |
| 317 | 北京北京 | 勇敢的心 | 汪峰 |
| 318 | We Don't Talk Anymore | We Don't Talk Anymore | Alex Blue TJ Brown |
| 319 | You Got Me | Breakthrough | Colbie Caillat |
| 320 | Where Is the Love | Best of Both Worlds | Josh Vietti |
| 321 | Love Story | Women's Day 2019 | Taylor Swift |
| 322 | BLUE | Blue Neighbourhood (Deluxe) | Troye Sivan Alex Hope |
| 323 | I Do | I Do | Colbie Caillat |
| 324 | A Little Story | My View | Valentin |
| 325 | Memories | 마녀유희 OST | 金有京 |
| 326 | MELANCHOLY | MELANCHOLY | White Cherry |
| 327 | Sundial Dreams | In the Enchanted Garden | Kevin Kern |
| 328 | If | 마녀유희 OST | 全慧彬 |
| 329 | 相思赋予谁 | 春生 | 好妹妹 |
| 330 | 筝锋 | 功夫 电影原声大碟 | 黄英华 |
| 331 | Thinking Out Loud | NOW That's What I Call Music! 90 | Ed Sheeran |
| 332 | Righteous Path | Introducing Mellow | Blazo |
| 333 | Somebody That I Used To Know | Making Mirrors | Gotye Kimbra |
| 334 | Aloha Heja He | Melancholie und Sturmflut (Bonus Tracks Edition) | Achim Reichel |
| 335 | 回家(萨克斯风) | 金耳朵Ⅲ | Kenny G |
| 336 | Palace Memories | Sound. Earth. Nature. Spirit. - Vol. Sound | S.E.N.S. |
| 337 | East of Eden | East of Eden | Zella Day |
| 338 | Breath and Life | The Platinum Series III: Eterna | Audiomachine |
| 339 | Carpe Diem | Dead Poets Society | Maurice Jarre |
| 340 | Beautiful In White (Demo) | Beautiful In White (Demo) | Shane Filan |
| 341 | Keating's Triumph | Dead Poets Society | Maurice Jarre |
| 342 | Better Man | Sing When You're Winning | Robbie Williams |
| 343 | Love Me Like You Do | Delirium | Ellie Goulding |
| 344 | Summer | ENCORE | 久石譲 |
| 345 | Viva La Vida | Viva La Vida Or Death And All His Friends | Coldplay |
| 346 | 爱向着我来的那天 사랑아 내게 오기만 해 (PartⅠ) | 마녀유희 OST | Ashily |
| 347 | Love The Way You Lie [Part III (Original Demo)] | Her Songs | Skylar Grey |
| 348 | You're Beautiful | So Beautiful 1 | James Blunt |
| 349 | 思念是一种病 | OK | 张震岳 / 蔡健雅 |
| 350 | Sunburst | Sunburst | Tobu / Itro |
| 351 | Farewell to Camraw | When the Pipers Play | Black Kilts Berlin /Robert Mathieson |
| 352 | 想太多 | 想太多 | 李玖哲 |
| 353 | Booty Music | Git Fresh | Deep Side |
| 354 | Genie | THE BEST ~New Edition~ | 少女时代 |
| 355 | 樱花草 | 花言乔语 (精装版) | Sweety |
| 356 | Girlfriend | The Best Damn Thing: Deluxe Edition | Avril Lavigne |
| 357 | Remember The Name | Sampler Mixtape | Fort Minor |
| 358 | The Long Way Home | The Bright Side | Lenka |
| 359 | Right Here Waiting_轻音乐 | Ballads | Richard Marx |
| 360 | 单车恋人 | 9公主 | 后弦 |
| 361 | 愤怒的消失 그게 말이죠 | 마녀유희 OST | 木单车 |
| 362 | 西厢 | 古·玩 | 后弦 |
| 363 | Bye Bye Bye | Rising Love | Lovestoned |
| 364 | Star of the County Down | Musique Celtic | Rosheen |
| 365 | Main Title (The Godfather Waltz) | The Godfather I | Nino Rota |
| 366 | 命运的恶作剧 운명의 장난 | 마녀유희 OST | MC 真理 / 哈哈 |
| 367 | Far Away From Home | Greatest Hits | Groove Coverage |
| 368 | Damn You | The Unreleased Collection | Lana Del Rey |
| 369 | Love Yourself (Natio Remix) | Love Yourself (Natio Remix) | Natio / Justin Bieber / Conor Maynard |
| 370 | Red River Valley | Journey Home | Bronn Journey |
| 371 | 去年夏天 | 去年夏天 | 王大毛 |
| 372 | My Happy Ending | Under My Skin (Special Edition) | Avril Lavigne |
| 373 | 友谊之光 | 监狱风云 | 玛莉亚 |
| 374 | The Moon Represents My Heart | Love Ballads | Kenny G |
| 375 | Auld Lang Syne | The Greatest Gift | Charlie Landsborough |
| 376 | 口弦 | 听见凉山 电视剧原声带 | 赵艺涵 |
| 377 | 奇异恩典 | 最新热歌慢摇73 | Various Artists |
| 378 | Flower Dance | A Cup Of Coffee | DJ Okawari |
| 379 | Come And Get It | Chartsurfer Vol. 30 | Selena Gomez |
| 380 | Heartbeats | Swings and Roundabouts | Amy Deasismont |
| 381 | Hero | Hero | Enrique Iglesias |
| 382 | I Just Wanna Run | Take Action! Volume 9 | The Downtown Fiction |
| 383 | 莫失莫忘 | 武侠音乐系列之后悔莫及 | 麦振鸿 |
| 384 | I Want You to Know | I Want You to Know | Zedd / Selena Gomez |
| 385 | We Are Young | Dancing Bear Best Of 2012 International | Fun. Janelle Monáe |
| 386 | The Day You Went Away | The Day You Went Away: The Best of M2M | M2M |
| 387 | Sleepyhead | Acoustic Daydreams | Galen Crew |
| 388 | Moon As My Heart | Harmonica Sound of Hong Kong | Robert Bonfiglio |
| 389 | 卡农D大调 | 胎教音乐 | 群星 |
| 390 | My Soul | Time... | July |
| 391 | 富士山下 | What's Going On…? | 陈奕迅 |
| 392 | New Soul | Irlande | Vox Angeli |
| 393 | If I Die Young | If I Die Young - Single | The Band Perry |
| 394 | The Godfather (Love Theme) | The Godfather I | Nino Rota |
| 395 | My Love (Radio Edit) | Coast to Coast | Westlife |
| 396 | What Are Words | What Are Words | Chris Medina |
| 397 | Young For You | Young For You | GALA |
| 398 | The Ludlows | Legends Of The Fall Original Motion Picture Soundtrack | James Horner |
| 399 | Pop Danthology 2012 | Pop Danthology | DJ Daniel Kim |
| 400 | Paris | Paris | Else |
| 401 | 呼唤 오나라 I | 대장금 OST | 김지현 |
| 402 | 爱向着我来的那天2 사랑아 내게 오기만 해 (Part II) | 마녀유희 OST | Ashily |
| 403 | 再见 | 再见 | 张震岳 |
| 404 | 千千阙歌 | 千千阙歌 | 陈慧娴 |
| 405 | Roses and Gold | Dust Diaries | Robin Jackson |
| 406 | Kiss The Rain 비를 맞다 | The Best - Reminiscent 10th Anniversary | Yiruma |
| 407 | Runner | Runner | Dustin O'Halloran |
| 408 | This Is the Life | Weathered | Angie Miller |
| 409 | Dead Poets Society (Finale) | Filmharmonic II | The Royal Philharmonic Orchestra Maurice Jarre |
| 410 | The sally gardens | Arias Ancora | Laure Green |
| 411 | 安静 钢琴版 | 纯音乐流行歌曲钢琴版 | Paul Liu |
| 412 | Wrecking Ball | Wrecking Ball | Miley Cyrus |
| 413 | 是啊 그래 | 마녀유희 OST | 나창현 |
| 414 | Six Feet Under | Six Feet Under | Billie Eilish |
| 415 | 穿越时空的思念1 时代を超える想い1 | 映画“犬夜叉 时代を越える想い 音楽篇” | 和田薫 |
| 416 | Umbrella | Now That's What I Call Music! 25 Years | Rihanna / Jay-Z |
| 417 | 桔梗谣 | 桔梗谣 | 阿里郎 |
| 418 | Waka Waka (Esto Es África) | Waka Waka (This Time For Africa) (The Official 2010 Fifa World Cup Song) | Shakira |
| 419 | Kiss The Rain 비를 맞다 | The Best - Reminiscent 10th Anniversary | Yiruma |
| 420 | In The End | In The End | Linkin Park |
| 421 | 野子 (Live) | 我是歌手第四季 第3期 | 苏运莹 |
| 422 | Monody | Monody | TheFatRat / Laura Brehm |
| 423 | The Show | The Show | Lenka |
| 424 | Ship In The Sand | Dear Me, Look Up | Marble Sounds |
| 425 | Summertime Sadness | Summertime Sadness | Lana Del Rey |
| 426 | 慕情 (M-4) | 犬夜叉 音楽篇 | 和田薫 |
| 427 | I Love You | I Love You | United Idol |
| 428 | 你还要我怎样 | 意外 | 薛之谦 |
| 429 | 发现爱 | 西界 | 林俊杰 / 金莎 |
| 430 | 桥边姑娘 | 桥边姑娘 | 海伦 |
| 431 | 犯错 | 犯错 | 顾峰 / 斯琴高丽 |
| 432 | 那年初夏 | 毕业了我们一无所有 | 任然 |
| 433 | 北京欢迎你 | 北京2008年奥运会歌曲专辑 | 群星 |
| 434 | Red River Valley | Cowboy Songs | Michael Martin Murphey |
| 435 | 500 Miles | Buck The Trend | Peter, Paul & Mary |
| 436 | 500 Miles | Christ Is My Hope | The Innocence Mission |
| 437 | 500 Miles | Let's Folk | The Brothers Four |
| 438 | 阿凡达与屌丝男 | 心花路放 电影原声带 | 许鹤缤 |
| 439 | Skinny Love | Skinny Love | Birdy |
| 440 | 我的歌声里 | 我的歌声里 | 李代沫 |
| 441 | 情人 | 海阔天空 | Beyond |
| 442 | 桔梗谣 | 노들강변 매화타령 민요 | 노들강변 매화타령 민요 |
| 443 | 为爱痴狂 | 歌曲合辑 | 金志文 |
| 444 | Mariage d'amour | Lettre à ma Mère | Richard Clayderman |
| 445 | 世界第一等 | 世界第一等 | 浪哥 |
| 446 | Unable To Stay, Unwilling To Leave | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 447 | 带我到山顶 | 听见凉山 | 赵艺涵 |
| 448 | Baby | Baby | Justin Bieber / Ludacris |
| 449 | 春娇与志明 | 春娇与志明 | 街道办GDC /欧阳耀莹 |
| 450 | Nevada | Monstercat - Best of 2016 | Vicetone / Cozi Zuehlsdorff |
| 451 | 听妈妈的话 | 依然范特西 | 周杰伦 |
| 452 | 红尘情歌 | 情路无悔 | 高安 /黑鸭子组合 |
| 453 | Jambalaya | 不朽的声音(人生最难忘的歌) | Carpenters |
| 454 | Prendre sa main | Cri d'amour | Angel Lover |
| 455 | 安静 | 范特西 | 周杰伦 |
| 456 | 梦中蝶影 | 歌曲合辑 | 华语群星 |
| 457 | 姑娘我爱你 | 姑娘我爱你 | 索朗扎西 |
| 458 | 借我 | 算云烟 | 谢春花 |
| 459 | 兰亭序 | 魔杰座 | 周杰伦 |
| 460 | The Red Sun | 20 Years of Achievement around the World | Richard Clayderman |
| 461 | 纯真年代 | 大小世界 | 爱朵女孩 |
| 462 | 李白 | 模特 | 李荣浩 |
| 463 | 平凡之路 | 猎户星座 | 朴树 |
| 464 | Vincent | Legendary Don McLean | Don McLean |
| 465 | 起风了 | 起风了 | 吴青峰 |
| 466 | 意外 | 意外 | 薛之谦 |
| 467 | Coming Home | Coming Home | Skylar Grey / Diddy-Dirty Money |
| 468 | Turnin' | Young Rising Sons | Young Rising Sons |
| 469 | Promise | Promise | sapientdream |
| 470 | 那些年 | 那些年，我们一起追的女孩 电影原声带 | 胡夏 |
| 471 | 有一种爱叫做放手 | 有一种爱叫做放手 | 阿木 |
| 472 | 童年 | 童年 | 北京天使合唱团 |
| 473 | 我最亲爱的 | 我的歌声里 | 李代沫 |
| 474 | 我希望 | 匆匆那年 电视原声带 | 杨玏 |
| 475 | 知道不知道 | Rene | 刘若英 |
| 476 | Don't Worry Be Happy | Pretty Donkey Girl | Holly Dolly |
| 477 | Say Hello | These Friends Of Mine | Rosie Thomas / Sufjan Stevens |
| 478 | The Right Path | Age of Innocence (Original Soundtrack) | Thomas Greenberg |
| 479 | 相思 | 腔.调 | 毛阿敏 |
| 480 | 2 Phút Hơn (KAIZ Remix) | 2 Phút Hơn (KAIZ Remix) | Pháo / KAIZ |
| 481 | 相对 | 子曰 第一册 | 子曰乐队 |
| 482 | Sally Gardens | Spring | The O'Neill Brothers |
| 483 | Valder Fields | A Plea en Vendredi | Tamas Wells |
| 484 | 刚好遇见你 | 刚好遇见你 | 李玉刚 |
| 485 | Way Back then | 오징어게임 OST | 郑在日 (정재일) |
| 486 | 海阔天空 | 一声所爱 大地飞歌（第九期） | 汪小敏 |
| 487 | Luv Letter | 髙橋大輔～フェイヴァリット・ミュージック～ | 神津裕之 |
| 488 | 万水千山总是情 | 万水千山总是情 电视剧原声带 | 汪明荃 |
| 489 | 希望 | Grace & Charm | 陈慧琳 |
| 490 | Liability | Melodrama | Lorde |
| 491 | Never Say Good Bye | 마이걸 | Mario & Nesty (마리오&네스티) |
| 492 | 城府 | 自定义 | 许嵩 |
| 493 | The Long Way Home | The Bright Side | Lenka |
| 494 | All Falls Down | All Falls Down | Alan Walker / Noah Cyrus / Digital Farm Animals / Juliander |
| 495 | 梦中的婚礼 | Richard Clayderman | Richard Clayderman |
| 496 | Faded | Faded | Alan Walker / Iselin Solheim |
| 497 | Take It From Me | Say I Am You | The Weepies / Deb Talan / Steve Tannen |
| 498 | You Belong To Me | To You | Carla Bruni |
| 499 | 发如雪 | 十一月的萧邦 | 周杰伦 |
| 500 | Windy Hill（风之谷） | Windy Hill | 羽肿 |
| 501 | Bloom of Youth | クドわふたー オリジナル サウンドトラック | 清水淳一 |
| 502 | Your Man | Double Cream 5: 20 Years of Nashville #1's 1992-2012 | Josh Turner |
| 503 | Eventide | Eventide | Nylon |
| 504 | Because of You | Because Of You | Kelly Clarkson |
| 505 | Demons | Continued Silence EP | Imagine Dragons |
| 506 | Take Me To Church | Bravo Hits 86 | Hozier |
| 507 | Just One Last Dance (Album Version) | Key To My Soul | Sarah Connor /Marc Terenzi |
| 508 | Love The Way You Lie (Part III (Original Demo)) | Relaxing Acoustic | Skylar Grey |
| 509 | 小苹果 | 老男孩之猛龙过江 电影原声 | 筷子兄弟 |
| 510 | 我是一只小小鸟 | 我是一只小小鸟 | 赵传 |
| 511 | 好久不见 | 认了吧 | 陈奕迅 |
| 512 | Be What You Wanna Be | Darin | Darin |
| 513 | 长路漫漫任我闯 | 林子祥精选之天长地久 | 林子祥 |
| 514 | A Place Called You | Enchanted | Emma Stevens |
| 515 | Young And Beautiful | Triple J Hottest 100 Vol 21 | Lana Del Rey |
| 516 | Scarborough Fair | The Very Best of Sarah Brightman 1990-2000 | Sarah Brightman |
| 517 | Frail Love | Frail Love | Cloves |
| 518 | 从头再来 | 经典20年 珍藏锦集 | 刘欢 |
| 519 | 浮夸 | U-87 | 陈奕迅 |
| 520 | The Ocean (Radio Edit) | The Ocean | Mike Perry / SHY Martin |
| 521 | When You're Gone | When You're Gone | Avril Lavigne |
| 522 | Lonely | Nana | Nana |
| 523 | Unity | Sounds of Syndication, Vol .1 (Presented by Syndicate) | TheFatRat |
| 524 | Hey, Soul Sister | Save Me, San Francisco | Train |
| 525 | Too Far | King in the Mirror | Anna F |
| 526 | Inspire | Serenity | Capo Productions |
| 527 | Please Don't Go | Please Don't Go | Joel Adams |
| 528 | 曾经的你 | 每一刻都是崭新的 | 许巍 |
| 529 | Sutter's Mill | The Music of Dan Fogelberg | Dan Fogelberg |
| 530 | Stay Alive | The Secret Life Of Walter Mitty (Music From And Inspired By The Motion Picture) | José González |
| 531 | 存在 | 生无所求 | 汪峰 |
| 532 | Stay Here Forever | Valentine's Day OST | Jewel |
| 533 | Skin | Skin | Rag'N'Bone Man |
| 534 | 易燃易爆炸 | 如也 | 陈粒 |
| 535 | 飞向别人的床 | 飞向别人的床 | 沉珂（C.K）& 光光 |
| 536 | 传奇 | 传奇 | 王菲 |
| 537 | Everybody | Everybody | Ingrid Michaelson |
| 538 | Astronomia（黑人抬棺古风版） | 黑人抬棺古风版 | litterzy、水玥儿 |
| 539 | I Want My Tears Back | Imaginaerum | Nightwish |
| 540 | 红颜 | MuSiC混合体 | 胡彦斌 |
| 541 | 혼자시킨 사랑 独自的爱情 | 명랑소녀 성공기 OST | True Bird |
| 542 | 潮湿的心 | 蜕变1少女的心情故事 | 卓依婷 |
| 543 | brave heart | brave heart | 宮崎歩 |
| 544 | 明天过后 | 明天过后 | 张杰 |
| 545 | Hymn To The Sea | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 546 | Love Theme | 명랑소녀 성공기 OST | 吴振宇 |
| 547 | Read My Mind | Jade | Sweetbox |
| 548 | Love Song | 명랑소녀 성공기 OST | 赵长赫 |
| 549 | Let It Out | Let It Out | Frances |
| 550 | 飞得更高 | 笑着哭 | 汪峰 |
| 551 | 花火 | 花火 | 汪峰 |
| 552 | 跟往事干杯 | 不朽金曲精选 Ⅰ | 姜育恒 |
| 553 | 直到永远 | 生死不离 我们在一起 | 汪峰 |
| 554 | 蓝莲花 | 时光.漫步 | 许巍 |
| 555 | 娃娃脸 | 娃娃脸 | 后弦 |
| 556 | 星象仪 プラネタリウム | プラネタリウム | 大塚爱 |
| 557 | 我爱你中国 | 怒放的生命 | 汪峰 |
| 558 | 莫失莫忘 | 仙侠音乐系列之仙剑奇侠传一 | 麦振鸿 |
| 559 | 一直很安静 | 寂寞在唱歌 | 阿桑 |
| 560 | 生活不止眼前的苟且 | 生活不止眼前的苟且 | 许巍 |
| 561 | 運命のルーレット廻して (转动命运之轮) | 運命のルーレット廻して | ZARD (ザード) |
| 562 | Tears Of A Clown | Mastercutor | U.D.O. |
| 563 | For Free | Folk For Kids | Lana Del Rey / Zella Day / Weyes Blood |
| 564 | My Destiny (我的命运) | 별에서 온 그대 OST Part 1 | LYn (린) |
| 565 | 亲爱的路人 | 亲爱的路人 | 刘若英 |
| 566 | Call Me Maybe | Call Me Maybe | Carly Rae Jepsen |
| 567 | 如果不能好好爱 | 如果不能好好爱 | 吴克群 |
| 568 | 花开在眼前 | 花开在眼前 | 韩磊 |
| 569 | 童年 | 纵贯线演唱会 | 罗大佑、李宗盛、张震岳、周华健 |
| 570 | 魔訶不思議アドベンチャー! | ドラゴンボール全曲集 | 高橋洋樹 |
| 571 | The Monster | The Monster | Eminem / Rihanna |
| 572 | One Night In 北京 | SHIN 同名专辑 | 信乐团 |
| 573 | Amazing Grace 天赐恩宠 | 苏格兰音乐之旅 苏格兰风笛 | 群星 |
| 574 | Élan | Élan | Nightwish |
| 575 | 小仙女 | 武侠音乐系列之缠绵悱恻 （截取版） | 麦振鸿 |
| 576 | 喜剧之王 | 喜剧之王 | 李荣浩 |
| 577 | Scotland the Brave 苏格兰勇士 | 苏格兰音乐之旅 苏格兰风笛 | 群星 |
| 578 | 月牙湾 | 爱.歌姬 | F.I.R. |
| 579 | Hallelujah | Warmer In The Winter (Deluxe Edition) | Lindsey Stirling |
| 580 | 二泉映月 | 阿炳全集 | 阿炳 |
| 581 | 男儿当自强 | 笑傲歌坛 传世经典 | 林子祥 |
| 582 | Summer | ENCORE | 久石譲 |
| 583 | 我和你 | 北京2008 奥运会、残奥会开闭幕式主题歌曲专辑 | 刘欢 / Sarah Brightman |
| 584 | 上海滩 | 上海滩 | 叶丽仪 |
| 585 | 算你狠 | 绝对收藏 | 陈小春 |
| 586 | 黄种人 | 黄·锋 | 谢霆锋 |
| 587 | Croatian Rhapsody | The Piano Player | Maksim Mrvica |
| 588 | He's a Pirate | Pirates of the Caribbean: The Curse of the Black Pearl | Klaus Badelt |
| 589 | 星月神话 | 女人又一次哭泣 | 金莎 |
| 590 | 夜上海 | 夜上海精选 | 周璇 |
| 591 | 带你去旅行 | 带你去旅行 | 校长（张驰） |
| 592 | 天下第一 | 武侠音乐系列之豪气中天 （截取版） | 麦振鸿 / 罗坚 |
| 593 | '97爱情宣言 | 狼 97黄金自选辑 | 齐秦 |
| 594 | 外面的世界 | 燃烧爱情（狼之旅） | 齐秦 |
| 595 | 小酒窝 | JJ陆 | 林俊杰 / 蔡卓妍 |
| 596 | 大约在冬季 | 摘金宝典 | 齐秦 |
| 597 | Go Time | Go Time | Mark Petrie |
| 598 | 往事随风 | 痛并快乐着 | 齐秦 |
| 599 | Someone to Stay | Someone to Stay | Vancouver Sleep Clinic |
| 600 | The Portrait | Titanic: Special Edition | James Horner |
| 601 | 你还欠我一个拥抱 | 很有爱 | 后弦 / Sara |
| 602 | Strength of a Thousand Men | Archangel | Two Steps From Hell |
| 603 | 匆匆那年 | 匆匆那年 电影原声带 | 王菲 |
| 604 | Spirit of the Wild | Age of Wonders | BrunuhVille |
| 605 | 命运 운명 | 풀 하우스 OST (KBS 미니시리즈) | Why |
| 606 | 大海~ | Asia | THE JAYWALK |
| 607 | Flavor Of Life | Flavor Of Life | 宇多田ヒカル |
| 608 | Death Of Titanic | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 609 | 孤勇者_凤凰传奇 | 孤勇者 | 凤凰传奇 |
| 610 | 不如不见 | What's Going On…? | 陈奕迅 |
| 611 | Distant Memories | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 612 | 偏爱 | 破天荒 | 张芸京 |
| 613 | Diamonds | Diamonds | Rihanna |
| 614 | 我欲成仙 | 西游记后传片头曲 | 刘欢 |
| 615 | 希望 (国语) | 我是阳光的 | 陈慧琳 |
| 616 | Something Just Like This | Something Just Like This | The Chainsmokers / Coldplay |
