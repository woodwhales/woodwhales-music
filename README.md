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
| 6 | Imagine | Imagine: John Lennon | John Lennon |
| 7 | 后来 | 我等你 | 刘若英 |
| 8 | Comptine D'un Autre Été, L'après-Midi | Le Fabuleux Destin d'Amélie Poulain | Yann Tiersen |
| 9 | 听说 | Rene | 刘若英 |
| 10 | Journey | Serenity | Capo Productions |
| 11 | 惊蛰 | 二十四节气 | 音阙诗听 / 王梓钰 |
| 12 | 关于郑州的记忆 | 《你好，郑州》 | 李志 |
| 13 | 哀歌 (M-5) | 犬夜叉 音楽篇 | 和田薫 |
| 14 | 野狼disco | 野狼disco | 宝石Gem |
| 15 | 童年 | 罗大佑自选辑 | 罗大佑 |
| 16 | For the Love of a Princess | Braveheart (Original Motion Picture Soundtrack) (Expanded Edition) | James Horner |
| 17 | 老街 | 小黄 | 李荣浩 |
| 18 | 恋曲1990 | 昨日情歌74-89 | 罗大佑 |
| 19 | 光阴的故事 | 命中注定最犀利 | 罗大佑 |
| 20 | 情非得已 | 遇见100%幸福1 烈爱红盘 | 庾澄庆 |
| 21 | 你要相信这不是最后一天 | 你要相信这不是最后一天 | 华晨宇 |
| 22 | 蜀绣 | 蜀绣 | 李宇春 |
| 23 | 追梦赤子心 | 追梦痴子心 | GALA |
| 24 | Jasmine Flower | Love Ballads | Kenny G |
| 25 | 太阳照常升起 | 太阳照常升起 电影原声大碟 | 久石譲 |
| 26 | Destiny | 마녀유희 OST | 李成旭 |
| 27 | 1965 | 1965 | Zella Day |
| 28 | A Thousand Years | A Thousand Years | Christina Perri |
| 29 | Come By the Hills | Song of the Irish Whistle 2 | Joanie Madden |
| 30 | La Valse D'Amelie | Le Fabuleux destin d'Amélie Poulain | Yann Tiersen |
| 31 | 理想三旬 | 浓烟下的诗歌电台 | 陈鸿宇 |
| 32 | 东风破  | 叶惠美 | 周杰伦 |
| 33 | The Long And Winding Street | Mellow Candle | Robert de Boron |
| 34 | 安和桥 | 安和桥北 | 宋冬野 |
| 35 | The Cello Song | The Piano Guys: Hits Volume 1 | Steven Sharp Nelson |
| 36 | 当我想你的时候 | 当我想你的时候 | 汪峰 |
| 37 | 明天，你好 | Lost & Found 去寻找 | 牛奶咖啡 |
| 38 | 芒种 | 二十四节气 | 音阙诗听 / 赵方婧 |
| 39 | 漂浮地铁 | N+1 Evolution 珍藏版 | 李宇春 |
| 40 | 别送我 | 别送我 | 陈鸿宇 / 苏紫旭 / 刘昊霖 / 寒洛&鼓润 |
| 41 | 稻香 | 魔杰座 | 周杰伦 |
| 42 | 认真的雪 | 未完成的歌 | 薛之谦 |
| 43 | 晚风花香 | 原乡情浓 | 邓丽君 |
| 44 | 沉默是金 | 张国荣经典金曲精选 | 张国荣 |
| 45 | Best of 2012: Payphone/Call Me Maybe/Wide Awake/Starship/We Are Young | Anthem Lights Covers | Anthem Lights |
| 46 | 为爱痴狂 | 收获 新歌+精选 | 刘若英 |
| 47 | Lemon Tree | Dish Of The Day | Fool's Garden |
| 48 | 广东十年爱情故事 | 广东十年爱情故事 | 广东雨神 |
| 49 | Monsters | Monsters | Katie Sky |
| 50 | A Day at a Time | Life In a Day (O.S.T) | Ellie Goulding Matthew Herbert |
| 51 | 我的八十年代 | 别再问我什么是迪斯科 | 张蔷 |
| 52 | 南山南 | 南山南 | 马頔 |
| 53 | 后会无期 | 后会无期 | G.E.M.邓紫棋 |
| 54 | 画心 | 画心 | 张靓颖 |
| 55 | 为爱痴狂_陈梦嘉 | THUG LIFE | 陈梦嘉 |
| 56 | Yellow | Best Of British | Coldplay |
| 57 | 一百万个可能 | 一百万个可能 | Christine Welch |
| 58 | 习惯了寂寞 | 习惯了寂寞 | 牛奶咖啡 |
| 59 | 我的歌声里 | Everything In The World (白金庆功版) | 曲婉婷 |
| 60 | 一剪梅 | 花神 | 黄渤 /左小祖咒 |
| 61 | A Life So Changed | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 62 | Here We Are Again (纯音乐) (《喜剧之王》电影插曲) | Here We Are Again (纯音乐) (《喜剧之王》电影插曲) | Cagnet (キャグネット) |
| 63 | 相思好比小蚂蚁 | 特别的日子 | 张蔷 |
| 64 | 明天你是否依然爱我 | 其实你不懂我的心 | 童安格 |
| 65 | With An Orchid | If I Could Tell You | Yanni |
| 66 | 爱如潮水 | 张信哲精选 | 张信哲 |
| 67 | 7 Years | The Young Pope (Original Series Sountrack) | Lukas Graham |
| 68 | The Sound of Silence (Reprise) | The Graduate | Simon & Garfunkel |
| 69 | BINGBIAN病变 (女声版) | BINGBIAN病变 (女声版) | 鞠文娴 |
| 70 | かごめと犬夜叉 (M-11+6) | 犬夜叉 音楽篇 | 和田薫 |
| 71 | 吉姆餐厅 | 吉姆餐厅 | 赵雷 |
| 72 | 很爱很爱你 | 很爱很爱你 | 刘若英 |
| 73 | 我们的时光 | 吉姆餐厅 | 赵雷 |
| 74 | Women of Ireland | Song of the Irish Whistle | Joanie Madden |
| 75 | Traveling Light | Traveling Light | Joel Hanson |
| 76 | 笑看风云 (Live) | 汪小敏 笑看风云 | 汪小敏 |
| 77 | 醉赤壁 | JJ陆 | 林俊杰 |
| 78 | 再度重相逢 | 泪桥 | 伍佰 & China Blue |
| 79 | The Way Of Life | 오! 필승 봉순영 OST | 吴硕浚 |
| 80 | 世界这么大还是遇见你 (清新的小女孩（中文版）) | 清新的小女孩（中文版） | 程响 |
| 81 | Chasing Pavements | Chasing Pavements | Adele |
| 82 | Right Here Waiting | Ballads | Richard Marx |
| 83 | 成都 | 成都 | 赵雷 |
| 84 | Faidherbe square (instrumental) | Curses from past times | ProleteR |
| 85 | Easy Breeze | Something Simple | Thomas Greenberg |
| 86 | Spring In My Step | Spring In My Step | Silent Partner |
| 87 | Free Loop | Cf, Movie & Drama Hits 广告，开麦拉！ | Daniel Powter |
| 88 | 不让我的眼泪陪我过夜 | 丝路 | 齐秦 |
| 89 | I Could Be The One | Acoustic | Donna Lewis |
| 90 | Unchained Melody | Ghost | Alex North |
| 91 | Let Her Go | All The Little Lights | Passenger |
| 92 | Jar Of Love | Everything In The World (白金庆功版) | 曲婉婷 |
| 93 | 菊花爆满山 | 菊花爆满山 | 马博 |
| 94 | John of the Glen | Song of the Irish Whistle 2 | Joanie Madden |
| 95 | Marry You | Now Los Mejores Exitos Del Ano 2012 | Bruno Mars |
| 96 | Seve | Seve | Tez Cadey |
| 97 | 似水流年 | Salute | 张国荣 |
| 98 | 喜欢你 | Beyond 25th Anniversary | Beyond |
| 99 | 我只在乎你 | 我只在乎你 | 邓丽君 |
| 100 | Coachella - Woodstock In My Mind | Lust For Life | Lana Del Rey |
| 101 | 海阔天空 | 乐与怒 | Beyond |
| 102 | 傲气傲笑万重浪 | 黄飞鸿系列电影原声精装版 | 黄霑 |
| 103 | 倩女幽魂 | Ultimate | 张国荣 |
| 104 | Angolan Women | Life In a Day (O.S.T) | The Three Angolan Women |
| 105 | 清明雨上 | 自定义 | 许嵩 |
| 106 | 小情歌 | 小宇宙 | 苏打绿 |
| 107 | 阳光总在风雨后 | 都是夜归人 | 许美静 |
| 108 | Day by Day | 마녀유희 OST | 赵冠宇 |
| 109 | The Sound of Silence (Album Version) | Forever Friends 'Just For You' | Simon & Garfunkel |
| 110 | Refrain | Eternal Light | 阿南亮子 (あなん りょうこ) |
| 111 | 盛夏的果实 | 莫后年代 莫文蔚20周年世纪典藏 | 莫文蔚 |
| 112 | Dark Paradise (Alternative Demo) | Born To Die (Demos) | Lana Del Rey |
| 113 | Dirty Paws | Summer Acoustic | Of Monsters And Men |
| 114 | Miracle In The Middle Of My Heart (Original Mix) | Miracle In The Middle Of My Heart (Original Mix) | Clément Bcx |
| 115 | 老朋友 | 老朋友 | 杨尘,王旭(旭日阳刚) |
| 116 | Whistle | Glee: The Music - The Complete Season Four | Glee Cast |
| 117 | She | 7 Years and 50 Days | Groove Coverage |
| 118 | 十月：我和曾经的我们 | 迷藏 | 钟城 / 姚望 |
| 119 | Stronger | Kids Top 20 - De Grootste Hits Van 2013 - Summer Edition 2013 | Kelly Clarkson |
| 120 | The Immigrant | Song of the Irish Whistle | Joanie Madden |
| 121 | 家族の风景 | 虹の歌集 | 手嶌葵 |
| 122 | 爱拼才会赢 | 爱拼才会赢 | 叶启田 |
| 123 | 单身情歌 | 单身情歌．超炫精选 | 林志炫 |
| 124 | 丑八怪 | 意外 | 薛之谦 |
| 125 | 沧海一声笑 | 沧海一声笑 | 许冠杰 |
| 126 | 桔梗谣 | 桔梗谣 | 阿里郎 |
| 127 | Intro | xx | The xx |
| 128 | Need You Now | iTunes Session | Lady A |
| 129 | 父亲 | 父亲 | 筷子兄弟 |
| 130 | 桔梗谣 | 织谣 | 斯琴格日乐 |
| 131 | 老男孩 | 父亲 | 筷子兄弟 |
| 132 | 合肥的石头 | 赤脚青春 | 飘乐队 |
| 133 | 似夜流月 | 热门华语234 | 宗次郎 (そうじろう) |
| 134 | 芒种 | 二十四节气 | 音阙诗听 / 赵方婧 |
| 135 | Right Now (Na Na Na) | Right Now (Na Na Na) | Akon |
| 136 | Victory | Battlecry | Two Steps From Hell |
| 137 | 桔梗谣(道拉基) (朝鲜民谣) | 恋恋金达莱 | 蒋薇 |
| 138 | Down By the Salley Gardens | Song of the Irish Whistle | Joanie Madden |
| 139 | 故乡 | 我只有两天.许巍精选 | 许巍 |
| 140 | 小鱼儿的思绪 | 武侠音乐系列第二部之思情篇（截取版） | 麦振鸿 |
| 141 | Bubbly | So Fresh - The Hits Of Autumn 2008 | Colbie Caillat |
| 142 | 我很好 | I'm fine | 刘沁 |
| 143 | 江南 | 他是…JJ林俊杰 | 林俊杰 |
| 144 | 勇敢的心 | 勇敢的心 | 汪峰 |
| 145 | 年少有为 | 耳朵 | 李荣浩 |
| 146 | Price Tag | Price Tag | Jessie J / B.o.B |
| 147 | The Sound of Silence_轻音乐 | The Best Pan Pipes in the World...Ever! | Panpipes |
| 148 | Eversleeping | Eversleeping | Xandria |
| 149 | Breaking My Heart | Breaking My Heart | Lana Del Rey |
| 150 | Dying In the Sun | Bury the Hatchet | The Cranberries |
| 151 | See You Again | See You Again | See You Again |
| 152 | I Am You | I Am You | Kim Taylor |
| 153 | I'm Yours | I'm Yours | Jason Mraz |
| 154 | Innocence | The Best Damn Thing: Deluxe Edition | Avril Lavigne |
| 155 | 一生所爱 | 齐天周大圣之西游双记 电影歌乐游唱版 | 卢冠廷 / 莫文蔚 |
| 156 | 潇洒地走 | 潇洒地走 | 张蔷 |
| 157 | Apologize | Dreaming Out Loud (Tour Edition) | OneRepublic |
| 158 | Better Than One | The Score EP 2 | The Score |
| 159 | 停格 | 停格 | 蔡健雅 |
| 160 | 容易受伤的女人 | 阿菲正传 | 王菲 |
| 161 | Astronomia | Astronomia | Vicetone / Tony Igy |
| 162 | River Flows In You | Kuschelklassik Piano Dreams, Vol. 2 | Martin Ermen |
| 163 | 倔强 | 神的孩子都在跳舞 | 五月天 |
| 164 | 牛仔很忙 | 我很忙 | 周杰伦 |
| 165 | 日晷之梦 | 幸福时光 精选辑 | Kevin Kern |
| 166 | 分手以后才知道最珍贵 | 回到家乡 | 胡力 |
| 167 | 叱咤红人 | 相依为命: 20年精彩印记 | 陈小春 |
| 168 | 天才白痴梦 | 天才与白痴 | 许冠杰 |
| 169 | 往事只能回味 | 怀念老歌一 | 高胜美 |
| 170 | 我这家伙的答案是你 | AsuRa BalBalTa | Leessang / 河琳 |
| 171 | 往事只能回味 | 我是歌手第四季 第9期 | 金志文 |
| 172 | 勇敢的心 | 最新热歌慢摇88 | Various Artists |
| 173 | 等一分钟 | 滕爱Teng Love | 徐誉滕 |
| 174 | 我想大声告诉你 (《蜗居》电视剧片尾曲) | 我想大声告诉你 | 樊凡 |
| 175 | 光阴的故事 | 光阴的故事 | 黄晓明 邓超 佟大为 |
| 176 | 越长大越孤单 | 越长大越孤单 | 牛奶咖啡 |
| 177 | 知足 | 知足 最真杰作选 | 五月天 |
| 178 | 往事只能回味 | 说时依旧 | 好妹妹 |
| 179 | 演员 | 绅士 | 薛之谦 |
| 180 | 一起摇摆 | 生来彷徨 | 汪峰 |
| 181 | 南方姑娘 | 赵小雷 | 赵雷 |
| 182 | 我最亲爱的 | 你在看我吗 | 张惠妹 |
| 183 | 문을 여시오 (New Ver.) 请开门 | 문을 여시오 | 任昌丁 / 金昌烈 |
| 184 | Cornfield Chase | Interstellar (Original Motion Picture Soundtrack) | Hans Zimmer |
| 185 | Riverside | Philharmonics (Deluxe Edition) | Agnes Obel |
| 186 | Gotta Have You | Say I Am You | The Weepies |
| 187 | Big Big World | Big Big World | Emilia |
| 188 | 认错 | 自定义 | 许嵩 |
| 189 | 月光下的凤尾竹 (葫芦丝) | 金耳朵.发烧民乐 | 纯音乐 |
| 190 | Love The Way You Lie | Life After Recovery | Eminem / Rihanna |
| 191 | 好汉歌 | 好汉歌 | 刘欢 |
| 192 | My Heart Will Go On | Love Ballads | Kenny G |
| 193 | 布拉格广场 | 看我72变 | 蔡依林 / 周杰伦 |
| 194 | 粉红色的回忆 | 粉红色的回忆 | 韩宝仪 |
| 195 | Chiru (Saisei No Uta) | Nostalgic | Robert de Boron |
| 196 | Southampton | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 197 | 雪见·落入凡尘 | 仙剑奇侠传三 电视剧原声带 | 麦振鸿 |
| 198 | 时间都去哪儿了 | 听得到的时间 | 王铮亮 |
| 199 | 土耳其进行曲 | 土耳其进行曲 | Various Artists |
| 200 | That's Not My Name | That's Not My Name | The Ting Tings |
| 201 | The Mountain of Women | Song of the Irish Whistle | Joanie Madden |
| 202 | Hymn To The Sea | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 203 | Don't push me | Jade - silver edition | sweetbox |
| 204 | Just Give Me A Reason | The Truth About Love | P!nk Nate Ruess |
| 205 | いつも何度でも | Prime Selection | 宗次郎 |
| 206 | 光年之外 | 光年之外 | G.E.M.邓紫棋 |
| 207 | Take It From Me | Say I Am You | The Weepies |
| 208 | 差生 | 少年中国 | 李宇春 |
| 209 | Nocturne No. 2 in E Flat Major, Op. 9, No. 2 | The Chopin Collection: The Nocturnes | Arthur Rubinstein |
| 210 | 青花瓷 | 我很忙 | 周杰伦 |
| 211 | Beyond The Memory | Beyond The Memory | July |
| 212 | 十年 | 黑白灰 | 陈奕迅 |
| 213 | 送别 | 送别 | 朴树 |
| 214 | 曹操 | 曹操 | 林俊杰 |
| 215 | 黑板情书 | 黑板情书 | 后弦 |
| 216 | I can't let this go on any further | I can't let this go on any further | Savior |
| 217 | 一辈子的孤单 | 涩女郎 电视原声带 | 刘若英 |
| 218 | 因为爱情 | Stranger Under My Skin | 陈奕迅 王菲 |
| 219 | 我从崖边跌落 | 算云烟 | 谢春花 |
| 220 | 往事只能回味 | 往事只能回味 | 岳云鹏 / 宋小宝 |
| 221 | Never An Absolution | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 222 | Rose | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 223 | 关于郑州的记忆 | 你好，郑州 | 李志 |
| 224 | 突然的自我 | 忘情1015精选辑 | 伍佰 & China Blue |
| 225 | Roses and Gold | Dust Diaries | Robin Jackson |
| 226 | 春风十里 | 所有的酒，都不如你 | 鹿先森乐队 |
| 227 | 星座书上 | 自定义 | 许嵩 |
| 228 | Yesterday Once More | Yesterday Once More | Carpenters |
| 229 | 粉末 | 粉末 | 李宇春 |
| 230 | 苏州城外的微笑 | 很有爱 | 后弦 |
| 231 | Hey Jude | It's a Battle | John Lennon / Paul McCartney / It's a Cover Up |
| 232 | 天下 | 明天过后 | 张杰 |
| 233 | Last Dance | 爱情的尽头 | 伍佰 & China Blue |
| 234 | Miss Misery | Good Will Hunting (Music from the Miramax Motion Picture) | Elliott Smith |
| 235 | 不再犹豫 | Beyond The Stage | Beyond |
| 236 | Take a Bow | Good Girl Gone Bad | Rihanna |
| 237 | 泡沫 | Xposed | G.E.M.邓紫棋 |
| 238 | 没有什么不同 | 我的歌声里 | 曲婉婷 |
| 239 | 夜太黑 | 夜太黑 | 林忆莲 |
| 240 | 故乡的原风景 | 武侠音乐精装特辑 | 宗次郎 |
| 241 | 亲爱的那不是爱情 | Ang 5.0 | 张韶涵 |
| 242 | 红色高跟鞋 | 若你碰到他 | 蔡健雅 |
| 243 | The End of the World | The End of the World | Skeeter Davis |
| 244 | 怒放的生命 | 怒放的生命 | 汪峰 |
| 245 | 大约在冬季 | 冬雨 | 齐秦 |
| 246 | 喜欢你 | 喜欢你 | G.E.M. 邓紫棋 |
| 247 | 挪威的森林 | 爱情的尽头 | 伍佰 & China Blue |
| 248 | 本草纲目 | 依然范特西 | 周杰伦 |
| 249 | 小刀会序曲 | 武侠音乐系列之豪气中天 | 商易 / 夏飞云 / 上海民族乐团 |
| 250 | 2 Soon | Not Thinking Bout 2morrow | Jon Young |
| 251 | 彩云追月 | Edell.Love | 爱戴 |
| 252 | 忧伤倒数 | 夫妻那些事 电视剧原声带 | 小昔米 |
| 253 | 爱情转移 | 认了吧 | 陈奕迅 |
| 254 | 阳光下的我们 | Say The Words | 曲婉婷 |
| 255 | 今天 | 真永远 | 刘德华 |
| 256 | Breaking My Heart | Unreleased | Lana Del Rey |
| 257 | 隐形的翅膀 | 潘朵拉 | 张韶涵 |
| 258 | 蝴蝶泉边 | 崽崽 | 黄雅莉 |
| 259 | Sugar | V | Maroon 5 |
| 260 | 七里香 | 七里香 | 周杰伦 |
| 261 | 庐州月 | 寻雾启示 | 许嵩 |
| 262 | Only Time | Only Time: The Collection (Box Set) | Enya |
| 263 | 香水有毒 (DJ版) | 香水有毒(宣传单曲) | 胡杨林 |
| 264 | 有何不可 | 自定义 | 许嵩 |
| 265 | 真的爱你 | BEYOND IV | Beyond |
| 266 | Remember The Time | The Ultimate Collection | Michael Jackson |
| 267 | Teenage Dream | Teenage Dream | Katy Perry |
| 268 | 莫扎特：《小夜曲》第一乐章 | 2008-2011 演奏实况合集 | 中国国家交响乐团 |
| 269 | Loves Me Not | t.A.T.u. - The Best | t.A.T.u. |
| 270 | 穿越时空的思念2 时代を超える想い2 | 映画“犬夜叉 时代を越える想い 音楽篇” | 和田薫 |
| 271 | 毕业说分手 | 毕业说分手 | 冰冰超人 |
| 272 | The South Wind | Song of the Irish Whistle | Joanie Madden |
| 273 | The Scientist | The Scientist | Coldplay |
| 274 | 大海 | 70老男孩 | 张雨生 |
| 275 | 八年的爱 | 八年的爱 | 冰冰超人 |
| 276 | TiK ToK | Animal | Kesha |
| 277 | Underneath Your Clothes | Laundry Service | Shakira |
| 278 | My Heart Will Go On | My Love: Ultimate Essential Collection (North American Version) | Celine Dion |
| 279 | 我变了 我没变 | 我变了 我没变 | 杨宗纬 |
| 280 | Trip | Trip | Axero |
| 281 | 断桥残雪 | 断桥残雪 | 许嵩 |
| 282 | 春天里 | 信仰在空中飘扬 | 汪峰 |
| 283 | What A Wonderful World | All Time Greatest Hits | Louis Armstrong |
| 284 | 光明 | 信仰在空中飘扬 | 汪峰 |
| 285 | 光辉岁月 | 光辉岁月 | Beyond |
| 286 | Rhythm Of The Rain | Let It Be Me | Jason Donovan |
| 287 | Five Hundred Miles (《醉乡民谣》电影主题曲|《一路繁花相送》电视剧插曲) | Inside Llewyn Davis: Original Soundtrack Recording | Justin Timberlake / Carey Mull |
| 288 | Snowdreams 雪之梦 | Rhine River | Bandari |
| 289 | Not a Single Day 하루도 | Rain's World (Special Edition) | Rain |
| 290 | Don't Wanna Know/We Don't Talk Anymore | Don't Wanna Know/We Don't Talk Anymore | Sam Tsui Alex Blue |
| 291 | Summer Vibe | Summer Vibe | Walk off the Earth |
| 292 | We Are One | Super Deluxe Sound I | Kelly Sweet |
| 293 | 北京北京 | 勇敢的心 | 汪峰 |
| 294 | We Don't Talk Anymore | We Don't Talk Anymore | Alex Blue TJ Brown |
| 295 | You Got Me | Breakthrough | Colbie Caillat |
| 296 | Where Is the Love | Best of Both Worlds | Josh Vietti |
| 297 | Love Story | Women's Day 2019 | Taylor Swift |
| 298 | BLUE | Blue Neighbourhood (Deluxe) | Troye Sivan Alex Hope |
| 299 | I Do | I Do | Colbie Caillat |
| 300 | A Little Story | My View | Valentin |
| 301 | Memories | 마녀유희 OST | 金有京 |
| 302 | MELANCHOLY | MELANCHOLY | White Cherry |
| 303 | Sundial Dreams | In the Enchanted Garden | Kevin Kern |
| 304 | If | 마녀유희 OST | 全慧彬 |
| 305 | 相思赋予谁 | 春生 | 好妹妹 |
| 306 | 筝锋 | 功夫 电影原声大碟 | 黄英华 |
| 307 | Thinking Out Loud | NOW That's What I Call Music! 90 | Ed Sheeran |
| 308 | Righteous Path | Introducing Mellow | Blazo |
| 309 | Somebody That I Used To Know | Making Mirrors | Gotye Kimbra |
| 310 | Aloha Heja He | Melancholie und Sturmflut (Bonus Tracks Edition) | Achim Reichel |
| 311 | 回家(萨克斯风) | 金耳朵Ⅲ | Kenny G |
| 312 | Palace Memories | Sound. Earth. Nature. Spirit. - Vol. Sound | S.E.N.S. |
| 313 | East of Eden | East of Eden | Zella Day |
| 314 | Breath and Life | The Platinum Series III: Eterna | Audiomachine |
| 315 | Carpe Diem | Dead Poets Society | Maurice Jarre |
| 316 | Beautiful In White (Demo) | Beautiful In White (Demo) | Shane Filan |
| 317 | Keating's Triumph | Dead Poets Society | Maurice Jarre |
| 318 | Better Man | Sing When You're Winning | Robbie Williams |
| 319 | Love Me Like You Do | Delirium | Ellie Goulding |
| 320 | Summer | ENCORE | 久石譲 |
| 321 | Viva La Vida | Viva La Vida Or Death And All His Friends | Coldplay |
| 322 | 爱向着我来的那天 사랑아 내게 오기만 해 (PartⅠ) | 마녀유희 OST | Ashily |
| 323 | Love The Way You Lie [Part III (Original Demo)] | Her Songs | Skylar Grey |
| 324 | You're Beautiful | So Beautiful 1 | James Blunt |
| 325 | 思念是一种病 | OK | 张震岳 / 蔡健雅 |
| 326 | Sunburst | Sunburst | Tobu / Itro |
| 327 | Farewell to Camraw | When the Pipers Play | Black Kilts Berlin /Robert Mathieson |
| 328 | 想太多 | 想太多 | 李玖哲 |
| 329 | Booty Music | Git Fresh | Deep Side |
| 330 | Genie | THE BEST ~New Edition~ | 少女时代 |
| 331 | 樱花草 | 花言乔语 (精装版) | Sweety |
| 332 | Girlfriend | The Best Damn Thing: Deluxe Edition | Avril Lavigne |
| 333 | Remember The Name | Sampler Mixtape | Fort Minor |
| 334 | The Long Way Home | The Bright Side | Lenka |
| 335 | Right Here Waiting_轻音乐 | Ballads | Richard Marx |
| 336 | 单车恋人 | 9公主 | 后弦 |
| 337 | 愤怒的消失 그게 말이죠 | 마녀유희 OST | 木单车 |
| 338 | 西厢 | 古·玩 | 后弦 |
| 339 | Bye Bye Bye | Rising Love | Lovestoned |
| 340 | Star of the County Down | Musique Celtic | Rosheen |
| 341 | Main Title (The Godfather Waltz) | The Godfather I | Nino Rota |
| 342 | 命运的恶作剧 운명의 장난 | 마녀유희 OST | MC 真理 / 哈哈 |
| 343 | Far Away From Home | Greatest Hits | Groove Coverage |
| 344 | Damn You | The Unreleased Collection | Lana Del Rey |
| 345 | Love Yourself (Natio Remix) | Love Yourself (Natio Remix) | Natio / Justin Bieber / Conor Maynard |
| 346 | Red River Valley | Journey Home | Bronn Journey |
| 347 | 去年夏天 | 去年夏天 | 王大毛 |
| 348 | 友谊之光 | 监狱风云 | 玛莉亚 |
| 349 | The Moon Represents My Heart | Love Ballads | Kenny G |
| 350 | Auld Lang Syne | The Greatest Gift | Charlie Landsborough |
| 351 | 口弦 | 听见凉山 电视剧原声带 | 赵艺涵 |
| 352 | 奇异恩典 | 最新热歌慢摇73 | Various Artists |
| 353 | Flower Dance | A Cup Of Coffee | DJ Okawari |
| 354 | Come And Get It | Chartsurfer Vol. 30 | Selena Gomez |
| 355 | Heartbeats | Swings and Roundabouts | Amy Deasismont |
| 356 | Hero | Hero | Enrique Iglesias |
| 357 | I Just Wanna Run | Take Action! Volume 9 | The Downtown Fiction |
| 358 | 莫失莫忘 | 武侠音乐系列之后悔莫及 | 麦振鸿 |
| 359 | I Want You to Know | I Want You to Know | Zedd / Selena Gomez |
| 360 | We Are Young | Dancing Bear Best Of 2012 International | Fun. Janelle Monáe |
| 361 | The Day You Went Away | The Day You Went Away: The Best of M2M | M2M |
| 362 | Sleepyhead | Acoustic Daydreams | Galen Crew |
| 363 | Moon As My Heart | Harmonica Sound of Hong Kong | Robert Bonfiglio |
| 364 | 卡农D大调 | 胎教音乐 | 群星 |
| 365 | My Soul | Time... | July |
| 366 | 富士山下 | What's Going On…? | 陈奕迅 |
| 367 | New Soul | Irlande | Vox Angeli |
| 368 | If I Die Young | If I Die Young - Single | The Band Perry |
| 369 | The Godfather (Love Theme) | The Godfather I | Nino Rota |
| 370 | My Love (Radio Edit) | Coast to Coast | Westlife |
| 371 | What Are Words | What Are Words | Chris Medina |
| 372 | Young For You | Young For You | GALA |
| 373 | The Ludlows | Legends Of The Fall Original Motion Picture Soundtrack | James Horner |
| 374 | Pop Danthology 2012 | Pop Danthology | DJ Daniel Kim |
| 375 | Paris | Paris | Else |
| 376 | 呼唤 오나라 I | 대장금 OST | 김지현 |
| 377 | 爱向着我来的那天2 사랑아 내게 오기만 해 (Part II) | 마녀유희 OST | Ashily |
| 378 | 再见 | 再见 | 张震岳 |
| 379 | 千千阙歌 | 千千阙歌 | 陈慧娴 |
| 380 | Roses and Gold | Dust Diaries | Robin Jackson |
| 381 | Kiss The Rain 비를 맞다 | The Best - Reminiscent 10th Anniversary | Yiruma |
| 382 | Runner | Runner | Dustin O'Halloran |
| 383 | This Is the Life | Weathered | Angie Miller |
| 384 | Dead Poets Society (Finale) | Filmharmonic II | The Royal Philharmonic Orchestra Maurice Jarre |
| 385 | The sally gardens | Arias Ancora | Laure Green |
| 386 | 安静 钢琴版 | 纯音乐流行歌曲钢琴版 | Paul Liu |
| 387 | Wrecking Ball | Wrecking Ball | Miley Cyrus |
| 388 | 是啊 그래 | 마녀유희 OST | 나창현 |
| 389 | Six Feet Under | Six Feet Under | Billie Eilish |
| 390 | 穿越时空的思念1 时代を超える想い1 | 映画“犬夜叉 时代を越える想い 音楽篇” | 和田薫 |
| 391 | Umbrella | Now That's What I Call Music! 25 Years | Rihanna / Jay-Z |
| 392 | 桔梗谣 | 桔梗谣 | 阿里郎 |
| 393 | Waka Waka (Esto Es África) | Waka Waka (This Time For Africa) (The Official 2010 Fifa World Cup Song) | Shakira |
| 394 | Kiss The Rain 비를 맞다 | The Best - Reminiscent 10th Anniversary | Yiruma |
| 395 | In The End | In The End | Linkin Park |
| 396 | 野子 (Live) | 我是歌手第四季 第3期 | 苏运莹 |
| 397 | Monody | Monody | TheFatRat / Laura Brehm |
| 398 | The Show | The Show | Lenka |
| 399 | Ship In The Sand | Dear Me, Look Up | Marble Sounds |
| 400 | Summertime Sadness | Summertime Sadness | Lana Del Rey |
| 401 | 慕情 (M-4) | 犬夜叉 音楽篇 | 和田薫 |
| 402 | 你还要我怎样 | 意外 | 薛之谦 |
| 403 | 发现爱 | 西界 | 林俊杰 / 金莎 |
| 404 | 桥边姑娘 | 桥边姑娘 | 海伦 |
| 405 | 犯错 | 犯错 | 顾峰 / 斯琴高丽 |
| 406 | 那年初夏 | 毕业了我们一无所有 | 任然 |
| 407 | 北京欢迎你 | 北京2008年奥运会歌曲专辑 | 群星 |
| 408 | Red River Valley | Cowboy Songs | Michael Martin Murphey |
| 409 | 500 Miles | Buck The Trend | Peter, Paul & Mary |
| 410 | 500 Miles | Christ Is My Hope | The Innocence Mission |
| 411 | 500 Miles | Let's Folk | The Brothers Four |
| 412 | 阿凡达与屌丝男 | 心花路放 电影原声带 | 许鹤缤 |
| 413 | Skinny Love | Skinny Love | Birdy |
| 414 | 我的歌声里 | 我的歌声里 | 李代沫 |
| 415 | 情人 | 海阔天空 | Beyond |
| 416 | 桔梗谣 | 노들강변 매화타령 민요 | 노들강변 매화타령 민요 |
| 417 | 为爱痴狂 | 歌曲合辑 | 金志文 |
| 418 | Mariage d'amour | Lettre à ma Mère | Richard Clayderman |
| 419 | 世界第一等 | 世界第一等 | 浪哥 |
| 420 | Unable To Stay, Unwilling To Leave | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 421 | Baby | Baby | Justin Bieber / Ludacris |
| 422 | 春娇与志明 | 春娇与志明 | 街道办GDC /欧阳耀莹 |
| 423 | Nevada | Monstercat - Best of 2016 | Vicetone / Cozi Zuehlsdorff |
| 424 | 听妈妈的话 | 依然范特西 | 周杰伦 |
| 425 | 红尘情歌 | 情路无悔 | 高安 /黑鸭子组合 |
| 426 | Jambalaya | 不朽的声音(人生最难忘的歌) | Carpenters |
| 427 | 安静 | 范特西 | 周杰伦 |
| 428 | 梦中蝶影 | 歌曲合辑 | 华语群星 |
| 429 | 姑娘我爱你 | 姑娘我爱你 | 索朗扎西 |
| 430 | 借我 | 算云烟 | 谢春花 |
| 431 | 兰亭序 | 魔杰座 | 周杰伦 |
| 432 | The Red Sun | 20 Years of Achievement around the World | Richard Clayderman |
| 433 | 纯真年代 | 大小世界 | 爱朵女孩 |
| 434 | 李白 | 模特 | 李荣浩 |
| 435 | 平凡之路 | 猎户星座 | 朴树 |
| 436 | Vincent | Legendary Don McLean | Don McLean |
| 437 | 意外 | 意外 | 薛之谦 |
| 438 | Coming Home | Coming Home | Skylar Grey / Diddy-Dirty Money |
| 439 | Turnin' | Young Rising Sons | Young Rising Sons |
| 440 | 那些年 | 那些年，我们一起追的女孩 电影原声带 | 胡夏 |
| 441 | 有一种爱叫做放手 | 有一种爱叫做放手 | 阿木 |
| 442 | 童年 | 童年 | 北京天使合唱团 |
| 443 | 我最亲爱的 | 我的歌声里 | 李代沫 |
| 444 | 我希望 | 匆匆那年 电视原声带 | 杨玏 |
| 445 | 知道不知道 | Rene | 刘若英 |
| 446 | Say Hello | These Friends Of Mine | Rosie Thomas / Sufjan Stevens |
| 447 | 相思 | 腔.调 | 毛阿敏 |
| 448 | Sally Gardens | Spring | The O'Neill Brothers |
| 449 | Valder Fields | A Plea en Vendredi | Tamas Wells |
| 450 | 刚好遇见你 | 刚好遇见你 | 李玉刚 |
| 451 | 海阔天空 | 一声所爱 大地飞歌（第九期） | 汪小敏 |
| 452 | Luv Letter | 髙橋大輔～フェイヴァリット・ミュージック～ | 神津裕之 |
| 453 | 万水千山总是情 | 万水千山总是情 电视剧原声带 | 汪明荃 |
| 454 | 希望 | Grace & Charm | 陈慧琳 |
| 455 | 城府 | 自定义 | 许嵩 |
| 456 | The Long Way Home | The Bright Side | Lenka |
| 457 | 梦中的婚礼 | Richard Clayderman | Richard Clayderman |
| 458 | 发如雪 | 十一月的萧邦 | 周杰伦 |
| 459 | Demons | Continued Silence EP | Imagine Dragons |
| 460 | Take Me To Church | Bravo Hits 86 | Hozier |
| 461 | Love The Way You Lie (Part III (Original Demo)) | Relaxing Acoustic | Skylar Grey |
| 462 | 小苹果 | 老男孩之猛龙过江 电影原声 | 筷子兄弟 |
| 463 | 我是一只小小鸟 | 我是一只小小鸟 | 赵传 |
| 464 | 好久不见 | 认了吧 | 陈奕迅 |
| 465 | Be What You Wanna Be | Darin | Darin |
| 466 | A Place Called You | Enchanted | Emma Stevens |
| 467 | Young And Beautiful | Triple J Hottest 100 Vol 21 | Lana Del Rey |
| 468 | Frail Love | Frail Love | Cloves |
| 469 | 从头再来 | 经典20年 珍藏锦集 | 刘欢 |
| 470 | 浮夸 | U-87 | 陈奕迅 |
| 471 | The Ocean (Radio Edit) | The Ocean | Mike Perry / SHY Martin |
| 472 | When You're Gone | When You're Gone | Avril Lavigne |
| 473 | Unity | Sounds of Syndication, Vol .1 (Presented by Syndicate) | TheFatRat |
| 474 | Hey, Soul Sister | Save Me, San Francisco | Train |
| 475 | Too Far | King in the Mirror | Anna F |
| 476 | Inspire | Serenity | Capo Productions |
| 477 | 曾经的你 | 每一刻都是崭新的 | 许巍 |
| 478 | Sutter's Mill | The Music of Dan Fogelberg | Dan Fogelberg |
| 479 | 存在 | 生无所求 | 汪峰 |
| 480 | Stay Here Forever | Valentine's Day OST | Jewel |
| 481 | 易燃易爆炸 | 如也 | 陈粒 |
| 482 | 飞向别人的床 | 飞向别人的床 | 沉珂（C.K）& 光光 |
| 483 | 传奇 | 传奇 | 王菲 |
| 484 | Everybody | Everybody | Ingrid Michaelson |
| 485 | Astronomia（黑人抬棺古风版） | 黑人抬棺古风版 | litterzy、水玥儿 |
| 486 | brave heart | brave heart | 宮崎歩 |
| 487 | Hymn To The Sea | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 488 | Read My Mind | Jade | Sweetbox |
| 489 | Let It Out | Let It Out | Frances |
| 490 | 飞得更高 | 笑着哭 | 汪峰 |
| 491 | 花火 | 花火 | 汪峰 |
| 492 | 跟往事干杯 | 不朽金曲精选 Ⅰ | 姜育恒 |
| 493 | 直到永远 | 生死不离 我们在一起 | 汪峰 |
| 494 | 蓝莲花 | 时光.漫步 | 许巍 |
| 495 | 娃娃脸 | 娃娃脸 | 后弦 |
| 496 | 星象仪 プラネタリウム | プラネタリウム | 大塚爱 |
| 497 | 我爱你中国 | 怒放的生命 | 汪峰 |
| 498 | 莫失莫忘 | 仙侠音乐系列之仙剑奇侠传一 | 麦振鸿 |
| 499 | 一直很安静 | 寂寞在唱歌 | 阿桑 |
| 500 | 生活不止眼前的苟且 | 生活不止眼前的苟且 | 许巍 |
| 501 | 運命のルーレット廻して (转动命运之轮) | 運命のルーレット廻して | ZARD (ザード) |
| 502 | Tears Of A Clown | Mastercutor | U.D.O. |
| 503 | My Destiny (我的命运) | 별에서 온 그대 OST Part 1 | LYn (린) |
| 504 | 亲爱的路人 | 亲爱的路人 | 刘若英 |
| 505 | Call Me Maybe | Call Me Maybe | Carly Rae Jepsen |
| 506 | 如果不能好好爱 | 如果不能好好爱 | 吴克群 |
| 507 | 花开在眼前 | 花开在眼前 | 韩磊 |
| 508 | 童年 | 纵贯线演唱会 | 罗大佑、李宗盛、张震岳、周华健 |
| 509 | 魔訶不思議アドベンチャー! | ドラゴンボール全曲集 | 高橋洋樹 |
| 510 | The Monster | The Monster | Eminem / Rihanna |
| 511 | One Night In 北京 | SHIN 同名专辑 | 信乐团 |
| 512 | Amazing Grace 天赐恩宠 | 苏格兰音乐之旅 苏格兰风笛 | 群星 |
| 513 | 小仙女 | 武侠音乐系列之缠绵悱恻 （截取版） | 麦振鸿 |
| 514 | 喜剧之王 | 喜剧之王 | 李荣浩 |
| 515 | Scotland the Brave 苏格兰勇士 | 苏格兰音乐之旅 苏格兰风笛 | 群星 |
| 516 | Hallelujah | Warmer In The Winter (Deluxe Edition) | Lindsey Stirling |
| 517 | 二泉映月 | 阿炳全集 | 阿炳 |
| 518 | 男儿当自强 | 笑傲歌坛 传世经典 | 林子祥 |
| 519 | Summer | ENCORE | 久石譲 |
| 520 | 我和你 | 北京2008 奥运会、残奥会开闭幕式主题歌曲专辑 | 刘欢 / Sarah Brightman |
| 521 | 上海滩 | 上海滩 | 叶丽仪 |
| 522 | 算你狠 | 绝对收藏 | 陈小春 |
| 523 | 黄种人 | 黄·锋 | 谢霆锋 |
| 524 | Croatian Rhapsody | The Piano Player | Maksim Mrvica |
| 525 | He's a Pirate | Pirates of the Caribbean: The Curse of the Black Pearl | Klaus Badelt |
| 526 | 星月神话 | 女人又一次哭泣 | 金莎 |
| 527 | 夜上海 | 夜上海精选 | 周璇 |
| 528 | 带你去旅行 | 带你去旅行 | 校长（张驰） |
| 529 | 天下第一 | 武侠音乐系列之豪气中天 （截取版） | 麦振鸿 / 罗坚 |
| 530 | '97爱情宣言 | 狼 97黄金自选辑 | 齐秦 |
| 531 | 外面的世界 | 燃烧爱情（狼之旅） | 齐秦 |
| 532 | 小酒窝 | JJ陆 | 林俊杰 / 蔡卓妍 |
| 533 | 大约在冬季 | 摘金宝典 | 齐秦 |
| 534 | Go Time | Go Time | Mark Petrie |
| 535 | 往事随风 | 痛并快乐着 | 齐秦 |
| 536 | The Portrait | Titanic: Special Edition | James Horner |
| 537 | 你还欠我一个拥抱 | 很有爱 | 后弦 / Sara |
| 538 | 匆匆那年 | 匆匆那年 电影原声带 | 王菲 |
| 539 | 命运 운명 | 풀 하우스 OST (KBS 미니시리즈) | Why |
| 540 | 大海~ | Asia | THE JAYWALK |
| 541 | Flavor Of Life | Flavor Of Life | 宇多田ヒカル |
| 542 | Death Of Titanic | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 543 | 不如不见 | What's Going On…? | 陈奕迅 |
| 544 | Distant Memories | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 545 | 偏爱 | 破天荒 | 张芸京 |
| 546 | Diamonds | Diamonds | Rihanna |
| 547 | 我欲成仙 | 西游记后传片头曲 | 刘欢 |
| 548 | 希望 (国语) | 我是阳光的 | 陈慧琳 |
