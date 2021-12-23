# woodwhales-music

[![](https://img.shields.io/badge/author-woodwhales-green.svg)](https://woodwhales.cn/) ![](https://img.shields.io/badge/license-GPL%203.0-orange.svg)

> 基于 SpringBoot 的开源超简洁音乐播放器

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
| 13 | 关于郑州的记忆 | 《你好，郑州》 | 李志 |
| 14 | 哀歌 (M-5) | 犬夜叉 音楽篇 | 和田薫 |
| 15 | 野狼disco | 野狼disco | 宝石Gem |
| 16 | 童年 | 罗大佑自选辑 | 罗大佑 |
| 17 | For the Love of a Princess | Braveheart (Original Motion Picture Soundtrack) (Expanded Edition) | James Horner |
| 18 | 老街 | 小黄 | 李荣浩 |
| 19 | 恋曲1990 | 昨日情歌74-89 | 罗大佑 |
| 20 | 光阴的故事 | 命中注定最犀利 | 罗大佑 |
| 21 | 情非得已 | 遇见100%幸福1 烈爱红盘 | 庾澄庆 |
| 22 | 你要相信这不是最后一天 | 你要相信这不是最后一天 | 华晨宇 |
| 23 | 蜀绣 | 蜀绣 | 李宇春 |
| 24 | 追梦赤子心 | 追梦痴子心 | GALA |
| 25 | Jasmine Flower | Love Ballads | Kenny G |
| 26 | 太阳照常升起 | 太阳照常升起 电影原声大碟 | 久石譲 |
| 27 | Destiny | 마녀유희 OST | 李成旭 |
| 28 | 1965 | 1965 | Zella Day |
| 29 | A Thousand Years | A Thousand Years | Christina Perri |
| 30 | Come By the Hills | Song of the Irish Whistle 2 | Joanie Madden |
| 31 | La Valse D'Amelie | Le Fabuleux destin d'Amélie Poulain | Yann Tiersen |
| 32 | 理想三旬 | 浓烟下的诗歌电台 | 陈鸿宇 |
| 33 | 东风破  | 叶惠美 | 周杰伦 |
| 34 | The Long And Winding Street | Mellow Candle | Robert de Boron |
| 35 | 安和桥 | 安和桥北 | 宋冬野 |
| 36 | The Cello Song | The Piano Guys: Hits Volume 1 | Steven Sharp Nelson |
| 37 | 当我想你的时候 | 当我想你的时候 | 汪峰 |
| 38 | 明天，你好 | Lost & Found 去寻找 | 牛奶咖啡 |
| 39 | 芒种 | 二十四节气 | 音阙诗听 / 赵方婧 |
| 40 | 漂浮地铁 | N+1 Evolution 珍藏版 | 李宇春 |
| 41 | 别送我 | 别送我 | 陈鸿宇 / 苏紫旭 / 刘昊霖 / 寒洛&鼓润 |
| 42 | 稻香 | 魔杰座 | 周杰伦 |
| 43 | 认真的雪 | 未完成的歌 | 薛之谦 |
| 44 | 晚风花香 | 原乡情浓 | 邓丽君 |
| 45 | 沉默是金 | 张国荣经典金曲精选 | 张国荣 |
| 46 | Best of 2012: Payphone/Call Me Maybe/Wide Awake/Starship/We Are Young | Anthem Lights Covers | Anthem Lights |
| 47 | 为爱痴狂 | 收获 新歌+精选 | 刘若英 |
| 48 | Lemon Tree | Dish Of The Day | Fool's Garden |
| 49 | 广东十年爱情故事 | 广东十年爱情故事 | 广东雨神 |
| 50 | Turning Tables | 21 | Adele |
| 51 | Monsters | Monsters | Katie Sky |
| 52 | A Day at a Time | Life In a Day (O.S.T) | Ellie Goulding Matthew Herbert |
| 53 | 我的八十年代 | 别再问我什么是迪斯科 | 张蔷 |
| 54 | 南山南 | 南山南 | 马頔 |
| 55 | 后会无期 | 后会无期 | G.E.M.邓紫棋 |
| 56 | 画心 | 画心 | 张靓颖 |
| 57 | 为爱痴狂_陈梦嘉 | THUG LIFE | 陈梦嘉 |
| 58 | Yellow | Best Of British | Coldplay |
| 59 | 一百万个可能 | 一百万个可能 | Christine Welch |
| 60 | 习惯了寂寞 | 习惯了寂寞 | 牛奶咖啡 |
| 61 | 我的歌声里 | Everything In The World (白金庆功版) | 曲婉婷 |
| 62 | 一剪梅 | 花神 | 黄渤 /左小祖咒 |
| 63 | A Life So Changed | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 64 | Here We Are Again (纯音乐) (《喜剧之王》电影插曲) | Here We Are Again (纯音乐) (《喜剧之王》电影插曲) | Cagnet (キャグネット) |
| 65 | 相思好比小蚂蚁 | 特别的日子 | 张蔷 |
| 66 | 明天你是否依然爱我 | 其实你不懂我的心 | 童安格 |
| 67 | With An Orchid | If I Could Tell You | Yanni |
| 68 | 爱如潮水 | 张信哲精选 | 张信哲 |
| 69 | 7 Years | The Young Pope (Original Series Sountrack) | Lukas Graham |
| 70 | The Sound of Silence (Reprise) | The Graduate | Simon & Garfunkel |
| 71 | BINGBIAN病变 (女声版) | BINGBIAN病变 (女声版) | 鞠文娴 |
| 72 | Don't You Remember | 21 | Adele |
| 73 | かごめと犬夜叉 (M-11+6) | 犬夜叉 音楽篇 | 和田薫 |
| 74 | 吉姆餐厅 | 吉姆餐厅 | 赵雷 |
| 75 | 很爱很爱你 | 很爱很爱你 | 刘若英 |
| 76 | 我们的时光 | 吉姆餐厅 | 赵雷 |
| 77 | Women of Ireland | Song of the Irish Whistle | Joanie Madden |
| 78 | Traveling Light | Traveling Light | Joel Hanson |
| 79 | 笑看风云 (Live) | 汪小敏 笑看风云 | 汪小敏 |
| 80 | 醉赤壁 | JJ陆 | 林俊杰 |
| 81 | 再度重相逢 | 泪桥 | 伍佰 & China Blue |
| 82 | The Way Of Life | 오! 필승 봉순영 OST | 吴硕浚 |
| 83 | 世界这么大还是遇见你 (清新的小女孩（中文版）) | 清新的小女孩（中文版） | 程响 |
| 84 | Chasing Pavements | Chasing Pavements | Adele |
| 85 | Right Here Waiting | Ballads | Richard Marx |
| 86 | 成都 | 成都 | 赵雷 |
| 87 | Faidherbe square (instrumental) | Curses from past times | ProleteR |
| 88 | Easy Breeze | Something Simple | Thomas Greenberg |
| 89 | Spring In My Step | Spring In My Step | Silent Partner |
| 90 | Free Loop | Cf, Movie & Drama Hits 广告，开麦拉！ | Daniel Powter |
| 91 | 不让我的眼泪陪我过夜 | 丝路 | 齐秦 |
| 92 | I Could Be The One | Acoustic | Donna Lewis |
| 93 | Unchained Melody | Ghost | Alex North |
| 94 | Let Her Go | All The Little Lights | Passenger |
| 95 | Jar Of Love | Everything In The World (白金庆功版) | 曲婉婷 |
| 96 | 菊花爆满山 | 菊花爆满山 | 马博 |
| 97 | John of the Glen | Song of the Irish Whistle 2 | Joanie Madden |
| 98 | Marry You | Now Los Mejores Exitos Del Ano 2012 | Bruno Mars |
| 99 | Seve | Seve | Tez Cadey |
| 100 | 似水流年 | Salute | 张国荣 |
| 101 | Rolling In The Deep | Rolling In The Deep | Adele |
| 102 | 喜欢你 | Beyond 25th Anniversary | Beyond |
| 103 | 我只在乎你 | 我只在乎你 | 邓丽君 |
| 104 | Coachella - Woodstock In My Mind | Lust For Life | Lana Del Rey |
| 105 | 海阔天空 | 乐与怒 | Beyond |
| 106 | 傲气傲笑万重浪 | 黄飞鸿系列电影原声精装版 | 黄霑 |
| 107 | 倩女幽魂 | Ultimate | 张国荣 |
| 108 | Angolan Women | Life In a Day (O.S.T) | The Three Angolan Women |
| 109 | 清明雨上 | 自定义 | 许嵩 |
| 110 | Set Fire to the Rain | 21 | Adele |
| 111 | That Girl | 24 HRS (Deluxe) | Olly Murs |
| 112 | 小情歌 | 小宇宙 | 苏打绿 |
| 113 | 阳光总在风雨后 | 都是夜归人 | 许美静 |
| 114 | Day by Day | 마녀유희 OST | 赵冠宇 |
| 115 | The Sound of Silence (Album Version) | Forever Friends 'Just For You' | Simon & Garfunkel |
| 116 | Refrain | Eternal Light | 阿南亮子 (あなん りょうこ) |
| 117 | 盛夏的果实 | 莫后年代 莫文蔚20周年世纪典藏 | 莫文蔚 |
| 118 | Dark Paradise (Alternative Demo) | Born To Die (Demos) | Lana Del Rey |
| 119 | Dirty Paws | Summer Acoustic | Of Monsters And Men |
| 120 | Miracle In The Middle Of My Heart (Original Mix) | Miracle In The Middle Of My Heart (Original Mix) | Clément Bcx |
| 121 | 老朋友 | 老朋友 | 杨尘,王旭(旭日阳刚) |
| 122 | Whistle | Glee: The Music - The Complete Season Four | Glee Cast |
| 123 | She | 7 Years and 50 Days | Groove Coverage |
| 124 | 十月：我和曾经的我们 | 迷藏 | 钟城 / 姚望 |
| 125 | Stronger | Kids Top 20 - De Grootste Hits Van 2013 - Summer Edition 2013 | Kelly Clarkson |
| 126 | The Immigrant | Song of the Irish Whistle | Joanie Madden |
| 127 | 家族の风景 | 虹の歌集 | 手嶌葵 |
| 128 | 爱拼才会赢 | 爱拼才会赢 | 叶启田 |
| 129 | 单身情歌 | 单身情歌．超炫精选 | 林志炫 |
| 130 | 丑八怪 | 意外 | 薛之谦 |
| 131 | 沧海一声笑 | 沧海一声笑 | 许冠杰 |
| 132 | 桔梗谣 | 桔梗谣 | 阿里郎 |
| 133 | Intro | xx | The xx |
| 134 | Need You Now | iTunes Session | Lady A |
| 135 | 父亲 | 父亲 | 筷子兄弟 |
| 136 | 桔梗谣 | 织谣 | 斯琴格日乐 |
| 137 | 老男孩 | 父亲 | 筷子兄弟 |
| 138 | Chasing Pavements | Chasing Pavements | Adele |
| 139 | 合肥的石头 | 赤脚青春 | 飘乐队 |
| 140 | 似夜流月 | 热门华语234 | 宗次郎 (そうじろう) |
| 141 | 芒种 | 二十四节气 | 音阙诗听 / 赵方婧 |
| 142 | Right Now (Na Na Na) | Right Now (Na Na Na) | Akon |
| 143 | Victory | Battlecry | Two Steps From Hell |
| 144 | 桔梗谣(道拉基) (朝鲜民谣) | 恋恋金达莱 | 蒋薇 |
| 145 | Down By the Salley Gardens | Song of the Irish Whistle | Joanie Madden |
| 146 | 故乡 | 我只有两天.许巍精选 | 许巍 |
| 147 | 小鱼儿的思绪 | 武侠音乐系列第二部之思情篇（截取版） | 麦振鸿 |
| 148 | Bubbly | So Fresh - The Hits Of Autumn 2008 | Colbie Caillat |
| 149 | 我很好 | I'm fine | 刘沁 |
| 150 | 江南 | 他是…JJ林俊杰 | 林俊杰 |
| 151 | 勇敢的心 | 勇敢的心 | 汪峰 |
| 152 | 年少有为 | 耳朵 | 李荣浩 |
| 153 | Price Tag | Price Tag | Jessie J / B.o.B |
| 154 | The Sound of Silence_轻音乐 | The Best Pan Pipes in the World...Ever! | Panpipes |
| 155 | Eversleeping | Eversleeping | Xandria |
| 156 | Breaking My Heart | Breaking My Heart | Lana Del Rey |
| 157 | Dying In the Sun | Bury the Hatchet | The Cranberries |
| 158 | See You Again | See You Again | See You Again |
| 159 | I Am You | I Am You | Kim Taylor |
| 160 | I'm Yours | I'm Yours | Jason Mraz |
| 161 | Innocence | The Best Damn Thing: Deluxe Edition | Avril Lavigne |
| 162 | 一生所爱 | 齐天周大圣之西游双记 电影歌乐游唱版 | 卢冠廷 / 莫文蔚 |
| 163 | 潇洒地走 | 潇洒地走 | 张蔷 |
| 164 | Apologize | Dreaming Out Loud (Tour Edition) | OneRepublic |
| 165 | Better Than One | The Score EP 2 | The Score |
| 166 | 停格 | 停格 | 蔡健雅 |
| 167 | When You're Gone | When You're Gone | Avril Lavigne |
| 168 | 容易受伤的女人 | 阿菲正传 | 王菲 |
| 169 | Astronomia | Astronomia | Vicetone / Tony Igy |
| 170 | River Flows In You | Kuschelklassik Piano Dreams, Vol. 2 | Martin Ermen |
| 171 | 倔强 | 神的孩子都在跳舞 | 五月天 |
| 172 | 牛仔很忙 | 我很忙 | 周杰伦 |
| 173 | 日晷之梦 | 幸福时光 精选辑 | Kevin Kern |
| 174 | 分手以后才知道最珍贵 | 回到家乡 | 胡力 |
| 175 | 叱咤红人 | 相依为命: 20年精彩印记 | 陈小春 |
| 176 | 天才白痴梦 | 天才与白痴 | 许冠杰 |
| 177 | 往事只能回味 | 怀念老歌一 | 高胜美 |
| 178 | 我这家伙的答案是你 | AsuRa BalBalTa | Leessang / 河琳 |
| 179 | 往事只能回味 | 我是歌手第四季 第9期 | 金志文 |
| 180 | 勇敢的心 | 最新热歌慢摇88 | Various Artists |
| 181 | 等一分钟 | 滕爱Teng Love | 徐誉滕 |
| 182 | 我想大声告诉你 (《蜗居》电视剧片尾曲) | 我想大声告诉你 | 樊凡 |
| 183 | 光阴的故事 | 光阴的故事 | 黄晓明 邓超 佟大为 |
| 184 | 越长大越孤单 | 越长大越孤单 | 牛奶咖啡 |
| 185 | 知足 | 知足 最真杰作选 | 五月天 |
| 186 | 往事只能回味 | 说时依旧 | 好妹妹 |
| 187 | 演员 | 绅士 | 薛之谦 |
| 188 | 一起摇摆 | 生来彷徨 | 汪峰 |
| 189 | 南方姑娘 | 赵小雷 | 赵雷 |
| 190 | 我最亲爱的 | 你在看我吗 | 张惠妹 |
| 191 | 문을 여시오 (New Ver.) 请开门 | 문을 여시오 | 任昌丁 / 金昌烈 |
| 192 | Cornfield Chase | Interstellar (Original Motion Picture Soundtrack) | Hans Zimmer |
| 193 | Riverside | Philharmonics (Deluxe Edition) | Agnes Obel |
| 194 | Gotta Have You | Say I Am You | The Weepies |
| 195 | Big Big World | Big Big World | Emilia |
| 196 | 认错 | 自定义 | 许嵩 |
| 197 | 月光下的凤尾竹 (葫芦丝) | 金耳朵.发烧民乐 | 纯音乐 |
| 198 | Love The Way You Lie | Life After Recovery | Eminem / Rihanna |
| 199 | 好汉歌 | 好汉歌 | 刘欢 |
| 200 | My Heart Will Go On | Love Ballads | Kenny G |
| 201 | 布拉格广场 | 看我72变 | 蔡依林 / 周杰伦 |
| 202 | 粉红色的回忆 | 粉红色的回忆 | 韩宝仪 |
| 203 | Hello | Hello | Adele |
| 204 | Chiru (Saisei No Uta) | Nostalgic | Robert de Boron |
| 205 | Southampton | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 206 | 雪见·落入凡尘 | 仙剑奇侠传三 电视剧原声带 | 麦振鸿 |
| 207 | 时间都去哪儿了 | 听得到的时间 | 王铮亮 |
| 208 | 土耳其进行曲 | 土耳其进行曲 | Various Artists |
| 209 | That's Not My Name | That's Not My Name | The Ting Tings |
| 210 | The Mountain of Women | Song of the Irish Whistle | Joanie Madden |
| 211 | Hymn To The Sea | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 212 | Don't push me | Jade - silver edition | sweetbox |
| 213 | Just Give Me A Reason | The Truth About Love | P!nk Nate Ruess |
| 214 | いつも何度でも | Prime Selection | 宗次郎 |
| 215 | 光年之外 | 光年之外 | G.E.M.邓紫棋 |
| 216 | Take It From Me | Say I Am You | The Weepies |
| 217 | 差生 | 少年中国 | 李宇春 |
| 218 | Nocturne No. 2 in E Flat Major, Op. 9, No. 2 | The Chopin Collection: The Nocturnes | Arthur Rubinstein |
| 219 | 青花瓷 | 我很忙 | 周杰伦 |
| 220 | Beyond The Memory | Beyond The Memory | July |
| 221 | 十年 | 黑白灰 | 陈奕迅 |
| 222 | 送别 | 送别 | 朴树 |
| 223 | 曹操 | 曹操 | 林俊杰 |
| 224 | 黑板情书 | 黑板情书 | 后弦 |
| 225 | I can't let this go on any further | I can't let this go on any further | Savior |
| 226 | 一辈子的孤单 | 涩女郎 电视原声带 | 刘若英 |
| 227 | 因为爱情 | Stranger Under My Skin | 陈奕迅 王菲 |
| 228 | 我从崖边跌落 | 算云烟 | 谢春花 |
| 229 | 往事只能回味 | 往事只能回味 | 岳云鹏 / 宋小宝 |
| 230 | Never An Absolution | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 231 | Rose | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 232 | 关于郑州的记忆 | 你好，郑州 | 李志 |
| 233 | 突然的自我 | 忘情1015精选辑 | 伍佰 & China Blue |
| 234 | Roses and Gold | Dust Diaries | Robin Jackson |
| 235 | 春风十里 | 所有的酒，都不如你 | 鹿先森乐队 |
| 236 | 星座书上 | 自定义 | 许嵩 |
| 237 | Yesterday Once More | Yesterday Once More | Carpenters |
| 238 | 粉末 | 粉末 | 李宇春 |
| 239 | 苏州城外的微笑 | 很有爱 | 后弦 |
| 240 | Hey Jude | It's a Battle | John Lennon / Paul McCartney / It's a Cover Up |
| 241 | 天下 | 明天过后 | 张杰 |
| 242 | Last Dance | 爱情的尽头 | 伍佰 & China Blue |
| 243 | Miss Misery | Good Will Hunting (Music from the Miramax Motion Picture) | Elliott Smith |
| 244 | 不再犹豫 | Beyond The Stage | Beyond |
| 245 | Take a Bow | Good Girl Gone Bad | Rihanna |
| 246 | 泡沫 | Xposed | G.E.M.邓紫棋 |
| 247 | 没有什么不同 | 我的歌声里 | 曲婉婷 |
| 248 | 夜太黑 | 夜太黑 | 林忆莲 |
| 249 | 故乡的原风景 | 武侠音乐精装特辑 | 宗次郎 |
| 250 | 亲爱的那不是爱情 | Ang 5.0 | 张韶涵 |
| 251 | 红色高跟鞋 | 若你碰到他 | 蔡健雅 |
| 252 | The End of the World | The End of the World | Skeeter Davis |
| 253 | 怒放的生命 | 怒放的生命 | 汪峰 |
| 254 | 大约在冬季 | 冬雨 | 齐秦 |
| 255 | 喜欢你 | 喜欢你 | G.E.M. 邓紫棋 |
| 256 | 挪威的森林 | 爱情的尽头 | 伍佰 & China Blue |
| 257 | 本草纲目 | 依然范特西 | 周杰伦 |
| 258 | 小刀会序曲 | 武侠音乐系列之豪气中天 | 商易 / 夏飞云 / 上海民族乐团 |
| 259 | 2 Soon | Not Thinking Bout 2morrow | Jon Young |
| 260 | 彩云追月 | Edell.Love | 爱戴 |
| 261 | 忧伤倒数 | 夫妻那些事 电视剧原声带 | 小昔米 |
| 262 | 爱情转移 | 认了吧 | 陈奕迅 |
| 263 | 阳光下的我们 | Say The Words | 曲婉婷 |
| 264 | 今天 | 真永远 | 刘德华 |
| 265 | Breaking My Heart | Unreleased | Lana Del Rey |
| 266 | 隐形的翅膀 | 潘朵拉 | 张韶涵 |
| 267 | 蝴蝶泉边 | 崽崽 | 黄雅莉 |
| 268 | Sugar | V | Maroon 5 |
| 269 | 七里香 | 七里香 | 周杰伦 |
| 270 | 庐州月 | 寻雾启示 | 许嵩 |
| 271 | Only Time | Only Time: The Collection (Box Set) | Enya |
| 272 | 香水有毒 (DJ版) | 香水有毒(宣传单曲) | 胡杨林 |
| 273 | 有何不可 | 自定义 | 许嵩 |
| 274 | 真的爱你 | BEYOND IV | Beyond |
| 275 | Remember The Time | The Ultimate Collection | Michael Jackson |
| 276 | Teenage Dream | Teenage Dream | Katy Perry |
| 277 | 莫扎特：《小夜曲》第一乐章 | 2008-2011 演奏实况合集 | 中国国家交响乐团 |
| 278 | Loves Me Not | t.A.T.u. - The Best | t.A.T.u. |
| 279 | 穿越时空的思念2 时代を超える想い2 | 映画“犬夜叉 时代を越える想い 音楽篇” | 和田薫 |
| 280 | 毕业说分手 | 毕业说分手 | 冰冰超人 |
| 281 | The South Wind | Song of the Irish Whistle | Joanie Madden |
| 282 | The Scientist | The Scientist | Coldplay |
| 283 | 大海 | 70老男孩 | 张雨生 |
| 284 | 八年的爱 | 八年的爱 | 冰冰超人 |
| 285 | TiK ToK | Animal | Kesha |
| 286 | Underneath Your Clothes | Laundry Service | Shakira |
| 287 | My Heart Will Go On | My Love: Ultimate Essential Collection (North American Version) | Celine Dion |
| 288 | 我变了 我没变 | 我变了 我没变 | 杨宗纬 |
| 289 | Trip | Trip | Axero |
| 290 | 断桥残雪 | 断桥残雪 | 许嵩 |
| 291 | 春天里 | 信仰在空中飘扬 | 汪峰 |
| 292 | What A Wonderful World | All Time Greatest Hits | Louis Armstrong |
| 293 | 光明 | 信仰在空中飘扬 | 汪峰 |
| 294 | 光辉岁月 | 光辉岁月 | Beyond |
| 295 | Rhythm Of The Rain | Let It Be Me | Jason Donovan |
| 296 | Five Hundred Miles (《醉乡民谣》电影主题曲|《一路繁花相送》电视剧插曲) | Inside Llewyn Davis: Original Soundtrack Recording | Justin Timberlake / Carey Mull |
| 297 | Snowdreams 雪之梦 | Rhine River | Bandari |
| 298 | Not a Single Day 하루도 | Rain's World (Special Edition) | Rain |
| 299 | Don't Wanna Know/We Don't Talk Anymore | Don't Wanna Know/We Don't Talk Anymore | Sam Tsui Alex Blue |
| 300 | Summer Vibe | Summer Vibe | Walk off the Earth |
| 301 | We Are One | Super Deluxe Sound I | Kelly Sweet |
| 302 | 北京北京 | 勇敢的心 | 汪峰 |
| 303 | We Don't Talk Anymore | We Don't Talk Anymore | Alex Blue TJ Brown |
| 304 | You Got Me | Breakthrough | Colbie Caillat |
| 305 | Where Is the Love | Best of Both Worlds | Josh Vietti |
| 306 | Love Story | Women's Day 2019 | Taylor Swift |
| 307 | BLUE | Blue Neighbourhood (Deluxe) | Troye Sivan Alex Hope |
| 308 | I Do | I Do | Colbie Caillat |
| 309 | A Little Story | My View | Valentin |
| 310 | Memories | 마녀유희 OST | 金有京 |
| 311 | MELANCHOLY | MELANCHOLY | White Cherry |
| 312 | Sundial Dreams | In the Enchanted Garden | Kevin Kern |
| 313 | If | 마녀유희 OST | 全慧彬 |
| 314 | 相思赋予谁 | 春生 | 好妹妹 |
| 315 | 筝锋 | 功夫 电影原声大碟 | 黄英华 |
| 316 | Thinking Out Loud | NOW That's What I Call Music! 90 | Ed Sheeran |
| 317 | Righteous Path | Introducing Mellow | Blazo |
| 318 | Somebody That I Used To Know | Making Mirrors | Gotye Kimbra |
| 319 | Aloha Heja He | Melancholie und Sturmflut (Bonus Tracks Edition) | Achim Reichel |
| 320 | 回家(萨克斯风) | 金耳朵Ⅲ | Kenny G |
| 321 | Palace Memories | Sound. Earth. Nature. Spirit. - Vol. Sound | S.E.N.S. |
| 322 | East of Eden | East of Eden | Zella Day |
| 323 | Breath and Life | The Platinum Series III: Eterna | Audiomachine |
| 324 | Carpe Diem | Dead Poets Society | Maurice Jarre |
| 325 | Beautiful In White (Demo) | Beautiful In White (Demo) | Shane Filan |
| 326 | Keating's Triumph | Dead Poets Society | Maurice Jarre |
| 327 | Better Man | Sing When You're Winning | Robbie Williams |
| 328 | Love Me Like You Do | Delirium | Ellie Goulding |
| 329 | Summer | ENCORE | 久石譲 |
| 330 | Viva La Vida | Viva La Vida Or Death And All His Friends | Coldplay |
| 331 | 爱向着我来的那天 사랑아 내게 오기만 해 (PartⅠ) | 마녀유희 OST | Ashily |
| 332 | Love The Way You Lie [Part III (Original Demo)] | Her Songs | Skylar Grey |
| 333 | You're Beautiful | So Beautiful 1 | James Blunt |
| 334 | 思念是一种病 | OK | 张震岳 / 蔡健雅 |
| 335 | Sunburst | Sunburst | Tobu / Itro |
| 336 | Farewell to Camraw | When the Pipers Play | Black Kilts Berlin /Robert Mathieson |
| 337 | 想太多 | 想太多 | 李玖哲 |
| 338 | Booty Music | Git Fresh | Deep Side |
| 339 | Genie | THE BEST ~New Edition~ | 少女时代 |
| 340 | 樱花草 | 花言乔语 (精装版) | Sweety |
| 341 | Girlfriend | The Best Damn Thing: Deluxe Edition | Avril Lavigne |
| 342 | Remember The Name | Sampler Mixtape | Fort Minor |
| 343 | The Long Way Home | The Bright Side | Lenka |
| 344 | Right Here Waiting_轻音乐 | Ballads | Richard Marx |
| 345 | 单车恋人 | 9公主 | 后弦 |
| 346 | 愤怒的消失 그게 말이죠 | 마녀유희 OST | 木单车 |
| 347 | 西厢 | 古·玩 | 后弦 |
| 348 | Bye Bye Bye | Rising Love | Lovestoned |
| 349 | Star of the County Down | Musique Celtic | Rosheen |
| 350 | Main Title (The Godfather Waltz) | The Godfather I | Nino Rota |
| 351 | 命运的恶作剧 운명의 장난 | 마녀유희 OST | MC 真理 / 哈哈 |
| 352 | Far Away From Home | Greatest Hits | Groove Coverage |
| 353 | Damn You | The Unreleased Collection | Lana Del Rey |
| 354 | Love Yourself (Natio Remix) | Love Yourself (Natio Remix) | Natio / Justin Bieber / Conor Maynard |
| 355 | Red River Valley | Journey Home | Bronn Journey |
| 356 | 去年夏天 | 去年夏天 | 王大毛 |
| 357 | My Happy Ending | Under My Skin (Special Edition) | Avril Lavigne |
| 358 | 友谊之光 | 监狱风云 | 玛莉亚 |
| 359 | The Moon Represents My Heart | Love Ballads | Kenny G |
| 360 | Auld Lang Syne | The Greatest Gift | Charlie Landsborough |
| 361 | 口弦 | 听见凉山 电视剧原声带 | 赵艺涵 |
| 362 | 奇异恩典 | 最新热歌慢摇73 | Various Artists |
| 363 | Flower Dance | A Cup Of Coffee | DJ Okawari |
| 364 | Come And Get It | Chartsurfer Vol. 30 | Selena Gomez |
| 365 | Heartbeats | Swings and Roundabouts | Amy Deasismont |
| 366 | Hero | Hero | Enrique Iglesias |
| 367 | I Just Wanna Run | Take Action! Volume 9 | The Downtown Fiction |
| 368 | 莫失莫忘 | 武侠音乐系列之后悔莫及 | 麦振鸿 |
| 369 | I Want You to Know | I Want You to Know | Zedd / Selena Gomez |
| 370 | We Are Young | Dancing Bear Best Of 2012 International | Fun. Janelle Monáe |
| 371 | The Day You Went Away | The Day You Went Away: The Best of M2M | M2M |
| 372 | Sleepyhead | Acoustic Daydreams | Galen Crew |
| 373 | Moon As My Heart | Harmonica Sound of Hong Kong | Robert Bonfiglio |
| 374 | 卡农D大调 | 胎教音乐 | 群星 |
| 375 | My Soul | Time... | July |
| 376 | 富士山下 | What's Going On…? | 陈奕迅 |
| 377 | New Soul | Irlande | Vox Angeli |
| 378 | If I Die Young | If I Die Young - Single | The Band Perry |
| 379 | The Godfather (Love Theme) | The Godfather I | Nino Rota |
| 380 | My Love (Radio Edit) | Coast to Coast | Westlife |
| 381 | What Are Words | What Are Words | Chris Medina |
| 382 | Young For You | Young For You | GALA |
| 383 | The Ludlows | Legends Of The Fall Original Motion Picture Soundtrack | James Horner |
| 384 | Pop Danthology 2012 | Pop Danthology | DJ Daniel Kim |
| 385 | Paris | Paris | Else |
| 386 | 呼唤 오나라 I | 대장금 OST | 김지현 |
| 387 | 爱向着我来的那天2 사랑아 내게 오기만 해 (Part II) | 마녀유희 OST | Ashily |
| 388 | 再见 | 再见 | 张震岳 |
| 389 | 千千阙歌 | 千千阙歌 | 陈慧娴 |
| 390 | Roses and Gold | Dust Diaries | Robin Jackson |
| 391 | Kiss The Rain 비를 맞다 | The Best - Reminiscent 10th Anniversary | Yiruma |
| 392 | Runner | Runner | Dustin O'Halloran |
| 393 | This Is the Life | Weathered | Angie Miller |
| 394 | Dead Poets Society (Finale) | Filmharmonic II | The Royal Philharmonic Orchestra Maurice Jarre |
| 395 | The sally gardens | Arias Ancora | Laure Green |
| 396 | 安静 钢琴版 | 纯音乐流行歌曲钢琴版 | Paul Liu |
| 397 | Wrecking Ball | Wrecking Ball | Miley Cyrus |
| 398 | 是啊 그래 | 마녀유희 OST | 나창현 |
| 399 | Six Feet Under | Six Feet Under | Billie Eilish |
| 400 | 穿越时空的思念1 时代を超える想い1 | 映画“犬夜叉 时代を越える想い 音楽篇” | 和田薫 |
| 401 | Umbrella | Now That's What I Call Music! 25 Years | Rihanna / Jay-Z |
| 402 | 桔梗谣 | 桔梗谣 | 阿里郎 |
| 403 | Waka Waka (Esto Es África) | Waka Waka (This Time For Africa) (The Official 2010 Fifa World Cup Song) | Shakira |
| 404 | Kiss The Rain 비를 맞다 | The Best - Reminiscent 10th Anniversary | Yiruma |
| 405 | In The End | In The End | Linkin Park |
| 406 | 野子 (Live) | 我是歌手第四季 第3期 | 苏运莹 |
| 407 | Monody | Monody | TheFatRat / Laura Brehm |
| 408 | The Show | The Show | Lenka |
| 409 | Ship In The Sand | Dear Me, Look Up | Marble Sounds |
| 410 | Summertime Sadness | Summertime Sadness | Lana Del Rey |
| 411 | 慕情 (M-4) | 犬夜叉 音楽篇 | 和田薫 |
| 412 | I Love You | I Love You | United Idol |
| 413 | 你还要我怎样 | 意外 | 薛之谦 |
| 414 | 发现爱 | 西界 | 林俊杰 / 金莎 |
| 415 | 桥边姑娘 | 桥边姑娘 | 海伦 |
| 416 | 犯错 | 犯错 | 顾峰 / 斯琴高丽 |
| 417 | 那年初夏 | 毕业了我们一无所有 | 任然 |
| 418 | 北京欢迎你 | 北京2008年奥运会歌曲专辑 | 群星 |
| 419 | Red River Valley | Cowboy Songs | Michael Martin Murphey |
| 420 | 500 Miles | Buck The Trend | Peter, Paul & Mary |
| 421 | 500 Miles | Christ Is My Hope | The Innocence Mission |
| 422 | 500 Miles | Let's Folk | The Brothers Four |
| 423 | 阿凡达与屌丝男 | 心花路放 电影原声带 | 许鹤缤 |
| 424 | Skinny Love | Skinny Love | Birdy |
| 425 | 我的歌声里 | 我的歌声里 | 李代沫 |
| 426 | 情人 | 海阔天空 | Beyond |
| 427 | 桔梗谣 | 노들강변 매화타령 민요 | 노들강변 매화타령 민요 |
| 428 | 为爱痴狂 | 歌曲合辑 | 金志文 |
| 429 | Mariage d'amour | Lettre à ma Mère | Richard Clayderman |
| 430 | 世界第一等 | 世界第一等 | 浪哥 |
| 431 | Unable To Stay, Unwilling To Leave | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 432 | Baby | Baby | Justin Bieber / Ludacris |
| 433 | 春娇与志明 | 春娇与志明 | 街道办GDC /欧阳耀莹 |
| 434 | Nevada | Monstercat - Best of 2016 | Vicetone / Cozi Zuehlsdorff |
| 435 | 听妈妈的话 | 依然范特西 | 周杰伦 |
| 436 | 红尘情歌 | 情路无悔 | 高安 /黑鸭子组合 |
| 437 | Jambalaya | 不朽的声音(人生最难忘的歌) | Carpenters |
| 438 | 安静 | 范特西 | 周杰伦 |
| 439 | 梦中蝶影 | 歌曲合辑 | 华语群星 |
| 440 | 姑娘我爱你 | 姑娘我爱你 | 索朗扎西 |
| 441 | 借我 | 算云烟 | 谢春花 |
| 442 | 兰亭序 | 魔杰座 | 周杰伦 |
| 443 | The Red Sun | 20 Years of Achievement around the World | Richard Clayderman |
| 444 | 纯真年代 | 大小世界 | 爱朵女孩 |
| 445 | 李白 | 模特 | 李荣浩 |
| 446 | 平凡之路 | 猎户星座 | 朴树 |
| 447 | Vincent | Legendary Don McLean | Don McLean |
| 448 | 意外 | 意外 | 薛之谦 |
| 449 | Coming Home | Coming Home | Skylar Grey / Diddy-Dirty Money |
| 450 | Turnin' | Young Rising Sons | Young Rising Sons |
| 451 | 那些年 | 那些年，我们一起追的女孩 电影原声带 | 胡夏 |
| 452 | 有一种爱叫做放手 | 有一种爱叫做放手 | 阿木 |
| 453 | 童年 | 童年 | 北京天使合唱团 |
| 454 | 我最亲爱的 | 我的歌声里 | 李代沫 |
| 455 | 我希望 | 匆匆那年 电视原声带 | 杨玏 |
| 456 | 知道不知道 | Rene | 刘若英 |
| 457 | Say Hello | These Friends Of Mine | Rosie Thomas / Sufjan Stevens |
| 458 | 相思 | 腔.调 | 毛阿敏 |
| 459 | Sally Gardens | Spring | The O'Neill Brothers |
| 460 | Valder Fields | A Plea en Vendredi | Tamas Wells |
| 461 | 刚好遇见你 | 刚好遇见你 | 李玉刚 |
| 462 | 海阔天空 | 一声所爱 大地飞歌（第九期） | 汪小敏 |
| 463 | Luv Letter | 髙橋大輔～フェイヴァリット・ミュージック～ | 神津裕之 |
| 464 | 万水千山总是情 | 万水千山总是情 电视剧原声带 | 汪明荃 |
| 465 | 希望 | Grace & Charm | 陈慧琳 |
| 466 | 城府 | 自定义 | 许嵩 |
| 467 | The Long Way Home | The Bright Side | Lenka |
| 468 | 梦中的婚礼 | Richard Clayderman | Richard Clayderman |
| 469 | 发如雪 | 十一月的萧邦 | 周杰伦 |
| 470 | Demons | Continued Silence EP | Imagine Dragons |
| 471 | Take Me To Church | Bravo Hits 86 | Hozier |
| 472 | Love The Way You Lie (Part III (Original Demo)) | Relaxing Acoustic | Skylar Grey |
| 473 | 小苹果 | 老男孩之猛龙过江 电影原声 | 筷子兄弟 |
| 474 | 我是一只小小鸟 | 我是一只小小鸟 | 赵传 |
| 475 | 好久不见 | 认了吧 | 陈奕迅 |
| 476 | Be What You Wanna Be | Darin | Darin |
| 477 | A Place Called You | Enchanted | Emma Stevens |
| 478 | Young And Beautiful | Triple J Hottest 100 Vol 21 | Lana Del Rey |
| 479 | Frail Love | Frail Love | Cloves |
| 480 | 从头再来 | 经典20年 珍藏锦集 | 刘欢 |
| 481 | 浮夸 | U-87 | 陈奕迅 |
| 482 | The Ocean (Radio Edit) | The Ocean | Mike Perry / SHY Martin |
| 483 | When You're Gone | When You're Gone | Avril Lavigne |
| 484 | Unity | Sounds of Syndication, Vol .1 (Presented by Syndicate) | TheFatRat |
| 485 | Hey, Soul Sister | Save Me, San Francisco | Train |
| 486 | Too Far | King in the Mirror | Anna F |
| 487 | Inspire | Serenity | Capo Productions |
| 488 | 曾经的你 | 每一刻都是崭新的 | 许巍 |
| 489 | Sutter's Mill | The Music of Dan Fogelberg | Dan Fogelberg |
| 490 | 存在 | 生无所求 | 汪峰 |
| 491 | Stay Here Forever | Valentine's Day OST | Jewel |
| 492 | 易燃易爆炸 | 如也 | 陈粒 |
| 493 | 飞向别人的床 | 飞向别人的床 | 沉珂（C.K）& 光光 |
| 494 | 传奇 | 传奇 | 王菲 |
| 495 | Everybody | Everybody | Ingrid Michaelson |
| 496 | Astronomia（黑人抬棺古风版） | 黑人抬棺古风版 | litterzy、水玥儿 |
| 497 | brave heart | brave heart | 宮崎歩 |
| 498 | Hymn To The Sea | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 499 | Read My Mind | Jade | Sweetbox |
| 500 | Let It Out | Let It Out | Frances |
| 501 | 飞得更高 | 笑着哭 | 汪峰 |
| 502 | 花火 | 花火 | 汪峰 |
| 503 | 跟往事干杯 | 不朽金曲精选 Ⅰ | 姜育恒 |
| 504 | 直到永远 | 生死不离 我们在一起 | 汪峰 |
| 505 | 蓝莲花 | 时光.漫步 | 许巍 |
| 506 | 娃娃脸 | 娃娃脸 | 后弦 |
| 507 | 星象仪 プラネタリウム | プラネタリウム | 大塚爱 |
| 508 | 我爱你中国 | 怒放的生命 | 汪峰 |
| 509 | 莫失莫忘 | 仙侠音乐系列之仙剑奇侠传一 | 麦振鸿 |
| 510 | 一直很安静 | 寂寞在唱歌 | 阿桑 |
| 511 | 生活不止眼前的苟且 | 生活不止眼前的苟且 | 许巍 |
| 512 | 運命のルーレット廻して (转动命运之轮) | 運命のルーレット廻して | ZARD (ザード) |
| 513 | Tears Of A Clown | Mastercutor | U.D.O. |
| 514 | My Destiny (我的命运) | 별에서 온 그대 OST Part 1 | LYn (린) |
| 515 | 亲爱的路人 | 亲爱的路人 | 刘若英 |
| 516 | Call Me Maybe | Call Me Maybe | Carly Rae Jepsen |
| 517 | 如果不能好好爱 | 如果不能好好爱 | 吴克群 |
| 518 | 花开在眼前 | 花开在眼前 | 韩磊 |
| 519 | 童年 | 纵贯线演唱会 | 罗大佑、李宗盛、张震岳、周华健 |
| 520 | 魔訶不思議アドベンチャー! | ドラゴンボール全曲集 | 高橋洋樹 |
| 521 | The Monster | The Monster | Eminem / Rihanna |
| 522 | One Night In 北京 | SHIN 同名专辑 | 信乐团 |
| 523 | Amazing Grace 天赐恩宠 | 苏格兰音乐之旅 苏格兰风笛 | 群星 |
| 524 | 小仙女 | 武侠音乐系列之缠绵悱恻 （截取版） | 麦振鸿 |
| 525 | 喜剧之王 | 喜剧之王 | 李荣浩 |
| 526 | Scotland the Brave 苏格兰勇士 | 苏格兰音乐之旅 苏格兰风笛 | 群星 |
| 527 | Hallelujah | Warmer In The Winter (Deluxe Edition) | Lindsey Stirling |
| 528 | 二泉映月 | 阿炳全集 | 阿炳 |
| 529 | 男儿当自强 | 笑傲歌坛 传世经典 | 林子祥 |
| 530 | Summer | ENCORE | 久石譲 |
| 531 | 我和你 | 北京2008 奥运会、残奥会开闭幕式主题歌曲专辑 | 刘欢 / Sarah Brightman |
| 532 | 上海滩 | 上海滩 | 叶丽仪 |
| 533 | 算你狠 | 绝对收藏 | 陈小春 |
| 534 | 黄种人 | 黄·锋 | 谢霆锋 |
| 535 | Croatian Rhapsody | The Piano Player | Maksim Mrvica |
| 536 | He's a Pirate | Pirates of the Caribbean: The Curse of the Black Pearl | Klaus Badelt |
| 537 | 星月神话 | 女人又一次哭泣 | 金莎 |
| 538 | 夜上海 | 夜上海精选 | 周璇 |
| 539 | 带你去旅行 | 带你去旅行 | 校长（张驰） |
| 540 | 天下第一 | 武侠音乐系列之豪气中天 （截取版） | 麦振鸿 / 罗坚 |
| 541 | '97爱情宣言 | 狼 97黄金自选辑 | 齐秦 |
| 542 | 外面的世界 | 燃烧爱情（狼之旅） | 齐秦 |
| 543 | 小酒窝 | JJ陆 | 林俊杰 / 蔡卓妍 |
| 544 | 大约在冬季 | 摘金宝典 | 齐秦 |
| 545 | Go Time | Go Time | Mark Petrie |
| 546 | 往事随风 | 痛并快乐着 | 齐秦 |
| 547 | The Portrait | Titanic: Special Edition | James Horner |
| 548 | 你还欠我一个拥抱 | 很有爱 | 后弦 / Sara |
| 549 | 匆匆那年 | 匆匆那年 电影原声带 | 王菲 |
| 550 | 命运 운명 | 풀 하우스 OST (KBS 미니시리즈) | Why |
| 551 | 大海~ | Asia | THE JAYWALK |
| 552 | Flavor Of Life | Flavor Of Life | 宇多田ヒカル |
| 553 | Death Of Titanic | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 554 | 不如不见 | What's Going On…? | 陈奕迅 |
| 555 | Distant Memories | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 556 | 偏爱 | 破天荒 | 张芸京 |
| 557 | Diamonds | Diamonds | Rihanna |
| 558 | 我欲成仙 | 西游记后传片头曲 | 刘欢 |
| 559 | 希望 (国语) | 我是阳光的 | 陈慧琳 |
