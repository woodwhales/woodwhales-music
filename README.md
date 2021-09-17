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
| 1 | Someone Like You | Someone Like You | Someone Like You |
| 2 | 容易受伤的女人(国) | 阿菲正传 | 阿菲正传 |
| 3 | Glad You Came | The Wanted (Special Edition) | The Wanted (Special Edition) |
| 4 | 红日 | 红日 | 红日 |
| 5 | Imagine | Imagine: John Lennon | Imagine: John Lennon |
| 6 | 后来 | 我等你 | 我等你 |
| 7 | Comptine D'un Autre Été, L'après-Midi | Le Fabuleux Destin d'Amélie Poulain | Le Fabuleux Destin d'Amélie Poulain |
| 8 | 听说 | Rene | Rene |
| 9 | Journey | Serenity | Serenity |
| 10 | 惊蛰 | 二十四节气 | 二十四节气 |
| 11 | 关于郑州的记忆 | 《你好，郑州》 | 《你好，郑州》 |
| 12 | 哀歌 (M-5) | 犬夜叉 音楽篇 | 犬夜叉 音楽篇 |
| 13 | 野狼disco | 野狼disco | 野狼disco |
| 14 | 童年 | 罗大佑自选辑 | 罗大佑自选辑 |
| 15 | For the Love of a Princess | Braveheart (Original Motion Picture Soundtrack) (Expanded Edition) | Braveheart (Original Motion Picture Soundtrack) (Expanded Edition) |
| 16 | 老街 | 小黄 | 小黄 |
| 17 | 恋曲1990 | 昨日情歌74-89 | 昨日情歌74-89 |
| 18 | 光阴的故事 | 命中注定最犀利 | 命中注定最犀利 |
| 19 | 情非得已 | 遇见100%幸福1 烈爱红盘 | 遇见100%幸福1 烈爱红盘 |
| 20 | 你要相信这不是最后一天 | 你要相信这不是最后一天 | 你要相信这不是最后一天 |
| 21 | 蜀绣 | 蜀绣 | 蜀绣 |
| 22 | 追梦赤子心 | 追梦痴子心 | 追梦痴子心 |
| 23 | Jasmine Flower | Love Ballads | Love Ballads |
| 24 | 太阳照常升起 | 太阳照常升起 电影原声大碟 | 太阳照常升起 电影原声大碟 |
| 25 | Destiny | 마녀유희 OST | 마녀유희 OST |
| 26 | 1965 | 1965 | 1965 |
| 27 | A Thousand Years | A Thousand Years | A Thousand Years |
| 28 | Come By the Hills | Song of the Irish Whistle 2 | Song of the Irish Whistle 2 |
| 29 | La Valse D'Amelie | Le Fabuleux destin d'Amélie Poulain | Le Fabuleux destin d'Amélie Poulain |
| 30 | 理想三旬 | 浓烟下的诗歌电台 | 浓烟下的诗歌电台 |
| 31 | 东风破  | 叶惠美 | 叶惠美 |
| 32 | 安和桥 | 安和桥北 | 安和桥北 |
| 33 | The Cello Song | The Piano Guys: Hits Volume 1 | The Piano Guys: Hits Volume 1 |
| 34 | 当我想你的时候 | 当我想你的时候 | 当我想你的时候 |
| 35 | 明天，你好 | Lost & Found 去寻找 | Lost & Found 去寻找 |
| 36 | 芒种 | 二十四节气 | 二十四节气 |
| 37 | 漂浮地铁 | N+1 Evolution 珍藏版 | N+1 Evolution 珍藏版 |
| 38 | 别送我 | 别送我 | 别送我 |
| 39 | 稻香 | 魔杰座 | 魔杰座 |
| 40 | 认真的雪 | 未完成的歌 | 未完成的歌 |
| 41 | 晚风花香 | 原乡情浓 | 原乡情浓 |
| 42 | 沉默是金 | 张国荣经典金曲精选 | 张国荣经典金曲精选 |
| 43 | Best of 2012: Payphone/Call Me Maybe/Wide Awake/Starship/We Are Young | Anthem Lights Covers | Anthem Lights Covers |
| 44 | 为爱痴狂 | 收获 新歌+精选 | 收获 新歌+精选 |
| 45 | Lemon Tree | Dish Of The Day | Dish Of The Day |
| 46 | 广东十年爱情故事 | 广东十年爱情故事 | 广东十年爱情故事 |
| 47 | Monsters | Monsters | Monsters |
| 48 | A Day at a Time | Life In a Day (O.S.T) | Life In a Day (O.S.T) |
| 49 | 我的八十年代 | 别再问我什么是迪斯科 | 别再问我什么是迪斯科 |
| 50 | 南山南 | 南山南 | 南山南 |
| 51 | 后会无期 | 后会无期 | 后会无期 |
| 52 | 画心 | 画心 | 画心 |
| 53 | 为爱痴狂_陈梦嘉 | THUG LIFE | THUG LIFE |
| 54 | Yellow | Best Of British | Best Of British |
| 55 | 一百万个可能 | 一百万个可能 | 一百万个可能 |
| 56 | 习惯了寂寞 | 习惯了寂寞 | 习惯了寂寞 |
| 57 | 我的歌声里 | Everything In The World (白金庆功版) | Everything In The World (白金庆功版) |
| 58 | 一剪梅 | 花神 | 花神 |
| 59 | A Life So Changed | Titanic: Music from the Motion Picture Soundtrack | Titanic: Music from the Motion Picture Soundtrack |
| 60 | Here We Are Again (纯音乐) (《喜剧之王》电影插曲) | Here We Are Again (纯音乐) (《喜剧之王》电影插曲) | Here We Are Again (纯音乐) (《喜剧之王》电影插曲) |
| 61 | 相思好比小蚂蚁 | 特别的日子 | 特别的日子 |
| 62 | 明天你是否依然爱我 | 其实你不懂我的心 | 其实你不懂我的心 |
| 63 | With An Orchid | If I Could Tell You | If I Could Tell You |
| 64 | 爱如潮水 | 张信哲精选 | 张信哲精选 |
| 65 | 7 Years | The Young Pope (Original Series Sountrack) | The Young Pope (Original Series Sountrack) |
| 66 | The Sound of Silence (Reprise) | The Graduate | The Graduate |
| 67 | BINGBIAN病变 (女声版) | BINGBIAN病变 (女声版) | BINGBIAN病变 (女声版) |
| 68 | かごめと犬夜叉 (M-11+6) | 犬夜叉 音楽篇 | 犬夜叉 音楽篇 |
| 69 | 吉姆餐厅 | 吉姆餐厅 | 吉姆餐厅 |
| 70 | 很爱很爱你 | 很爱很爱你 | 很爱很爱你 |
| 71 | 我们的时光 | 吉姆餐厅 | 吉姆餐厅 |
| 72 | Women of Ireland | Song of the Irish Whistle | Song of the Irish Whistle |
| 73 | Traveling Light | Traveling Light | Traveling Light |
| 74 | 笑看风云 (Live) | 汪小敏 笑看风云 | 汪小敏 笑看风云 |
| 75 | 醉赤壁 | JJ陆 | JJ陆 |
| 76 | 再度重相逢 | 泪桥 | 泪桥 |
| 77 | The Way Of Life | 오! 필승 봉순영 OST | 오! 필승 봉순영 OST |
| 78 | 世界这么大还是遇见你 (清新的小女孩（中文版）) | 清新的小女孩（中文版） | 清新的小女孩（中文版） |
| 79 | Chasing Pavements | Chasing Pavements | Chasing Pavements |
| 80 | Right Here Waiting | Ballads | Ballads |
| 81 | 成都 | 成都 | 成都 |
| 82 | Faidherbe square (instrumental) | Curses from past times | Curses from past times |
| 83 | Easy Breeze | Something Simple | Something Simple |
| 84 | Spring In My Step | Spring In My Step | Spring In My Step |
| 85 | Free Loop | Cf, Movie & Drama Hits 广告，开麦拉！ | Cf, Movie & Drama Hits 广告，开麦拉！ |
| 86 | 不让我的眼泪陪我过夜 | 丝路 | 丝路 |
| 87 | I Could Be The One | Acoustic | Acoustic |
| 88 | Unchained Melody | Ghost | Ghost |
| 89 | Let Her Go | All The Little Lights | All The Little Lights |
| 90 | Jar Of Love | Everything In The World (白金庆功版) | Everything In The World (白金庆功版) |
| 91 | 菊花爆满山 | 菊花爆满山 | 菊花爆满山 |
| 92 | John of the Glen | Song of the Irish Whistle 2 | Song of the Irish Whistle 2 |
| 93 | Marry You | Now Los Mejores Exitos Del Ano 2012 | Now Los Mejores Exitos Del Ano 2012 |
| 94 | Seve | Seve | Seve |
| 95 | 似水流年 | Salute | Salute |
| 96 | 喜欢你 | Beyond 25th Anniversary | Beyond 25th Anniversary |
| 97 | 我只在乎你 | 我只在乎你 | 我只在乎你 |
| 98 | Coachella - Woodstock In My Mind | Lust For Life | Lust For Life |
| 99 | 海阔天空 | 乐与怒 | 乐与怒 |
| 100 | 傲气傲笑万重浪 | 黄飞鸿系列电影原声精装版 | 黄飞鸿系列电影原声精装版 |
| 101 | 倩女幽魂 | Ultimate | Ultimate |
| 102 | Angolan Women | Life In a Day (O.S.T) | Life In a Day (O.S.T) |
| 103 | 清明雨上 | 自定义 | 自定义 |
| 104 | 小情歌 | 小宇宙 | 小宇宙 |
| 105 | 阳光总在风雨后 | 都是夜归人 | 都是夜归人 |
| 106 | Day by Day | 마녀유희 OST | 마녀유희 OST |
| 107 | The Sound of Silence (Album Version) | Forever Friends 'Just For You' | Forever Friends 'Just For You' |
| 108 | Refrain | Eternal Light | Eternal Light |
| 109 | 盛夏的果实 | 莫后年代 莫文蔚20周年世纪典藏 | 莫后年代 莫文蔚20周年世纪典藏 |
| 110 | Dark Paradise (Alternative Demo) | Born To Die (Demos) | Born To Die (Demos) |
| 111 | Dirty Paws | Summer Acoustic | Summer Acoustic |
| 112 | Miracle In The Middle Of My Heart (Original Mix) | Miracle In The Middle Of My Heart (Original Mix) | Miracle In The Middle Of My Heart (Original Mix) |
| 113 | 老朋友 | 老朋友 | 老朋友 |
| 114 | Whistle | Glee: The Music - The Complete Season Four | Glee: The Music - The Complete Season Four |
| 115 | She | 7 Years and 50 Days | 7 Years and 50 Days |
| 116 | 十月：我和曾经的我们 | 迷藏 | 迷藏 |
| 117 | Stronger | Kids Top 20 - De Grootste Hits Van 2013 - Summer Edition 2013 | Kids Top 20 - De Grootste Hits Van 2013 - Summer Edition 2013 |
| 118 | The Immigrant | Song of the Irish Whistle | Song of the Irish Whistle |
| 119 | 家族の风景 | 虹の歌集 | 虹の歌集 |
| 120 | 爱拼才会赢 | 爱拼才会赢 | 爱拼才会赢 |
| 121 | 单身情歌 | 单身情歌．超炫精选 | 单身情歌．超炫精选 |
| 122 | 丑八怪 | 意外 | 意外 |
| 123 | 沧海一声笑 | 沧海一声笑 | 沧海一声笑 |
| 124 | 桔梗谣 | 桔梗谣 | 桔梗谣 |
| 125 | Intro | xx | xx |
| 126 | Need You Now | iTunes Session | iTunes Session |
| 127 | 父亲 | 父亲 | 父亲 |
| 128 | 桔梗谣 | 织谣 | 织谣 |
| 129 | 老男孩 | 父亲 | 父亲 |
| 130 | 合肥的石头 | 赤脚青春 | 赤脚青春 |
| 131 | 似夜流月 | 热门华语234 | 热门华语234 |
| 132 | 芒种 | 二十四节气 | 二十四节气 |
| 133 | Right Now (Na Na Na) | Right Now (Na Na Na) | Right Now (Na Na Na) |
| 134 | Victory | Battlecry | Battlecry |
| 135 | 桔梗谣(道拉基) (朝鲜民谣) | 恋恋金达莱 | 恋恋金达莱 |
| 136 | Down By the Salley Gardens | Song of the Irish Whistle | Song of the Irish Whistle |
| 137 | 故乡 | 我只有两天.许巍精选 | 我只有两天.许巍精选 |
| 138 | 小鱼儿的思绪 | 武侠音乐系列第二部之思情篇（截取版） | 武侠音乐系列第二部之思情篇（截取版） |
| 139 | Bubbly | So Fresh - The Hits Of Autumn 2008 | So Fresh - The Hits Of Autumn 2008 |
| 140 | 我很好 | I'm fine | I'm fine |
| 141 | 江南 | 他是…JJ林俊杰 | 他是…JJ林俊杰 |
| 142 | 勇敢的心 | 勇敢的心 | 勇敢的心 |
| 143 | 年少有为 | 耳朵 | 耳朵 |
| 144 | Price Tag | Price Tag | Price Tag |
| 145 | The Sound of Silence_轻音乐 | The Best Pan Pipes in the World...Ever! | The Best Pan Pipes in the World...Ever! |
| 146 | Eversleeping | Eversleeping | Eversleeping |
| 147 | Breaking My Heart | Breaking My Heart | Breaking My Heart |
| 148 | Dying In the Sun | Bury the Hatchet | Bury the Hatchet |
| 149 | See You Again | See You Again | See You Again |
| 150 | I Am You | I Am You | I Am You |
| 151 | I'm Yours | I'm Yours | I'm Yours |
| 152 | Innocence | The Best Damn Thing: Deluxe Edition | The Best Damn Thing: Deluxe Edition |
| 153 | 一生所爱 | 齐天周大圣之西游双记 电影歌乐游唱版 | 齐天周大圣之西游双记 电影歌乐游唱版 |
| 154 | 潇洒地走 | 潇洒地走 | 潇洒地走 |
| 155 | Apologize | Dreaming Out Loud (Tour Edition) | Dreaming Out Loud (Tour Edition) |
| 156 | Better Than One | The Score EP 2 | The Score EP 2 |
| 157 | 停格 | 停格 | 停格 |
| 158 | 容易受伤的女人 | 阿菲正传 | 阿菲正传 |
| 159 | Astronomia | Astronomia | Astronomia |
| 160 | River Flows In You | Kuschelklassik Piano Dreams, Vol. 2 | Kuschelklassik Piano Dreams, Vol. 2 |
| 161 | 倔强 | 神的孩子都在跳舞 | 神的孩子都在跳舞 |
| 162 | 牛仔很忙 | 我很忙 | 我很忙 |
| 163 | 日晷之梦 | 幸福时光 精选辑 | 幸福时光 精选辑 |
| 164 | 分手以后才知道最珍贵 | 回到家乡 | 回到家乡 |
| 165 | 叱咤红人 | 相依为命: 20年精彩印记 | 相依为命: 20年精彩印记 |
| 166 | 天才白痴梦 | 天才与白痴 | 天才与白痴 |
| 167 | 往事只能回味 | 怀念老歌一 | 怀念老歌一 |
| 168 | 我这家伙的答案是你 | AsuRa BalBalTa | AsuRa BalBalTa |
| 169 | 往事只能回味 | 我是歌手第四季 第9期 | 我是歌手第四季 第9期 |
| 170 | 勇敢的心 | 最新热歌慢摇88 | 最新热歌慢摇88 |
| 171 | 等一分钟 | 滕爱Teng Love | 滕爱Teng Love |
| 172 | 我想大声告诉你 (《蜗居》电视剧片尾曲) | 我想大声告诉你 | 我想大声告诉你 |
| 173 | 光阴的故事 | 光阴的故事 | 光阴的故事 |
| 174 | 越长大越孤单 | 越长大越孤单 | 越长大越孤单 |
| 175 | 知足 | 知足 最真杰作选 | 知足 最真杰作选 |
| 176 | 往事只能回味 | 说时依旧 | 说时依旧 |
| 177 | 演员 | 绅士 | 绅士 |
| 178 | 一起摇摆 | 生来彷徨 | 生来彷徨 |
| 179 | 南方姑娘 | 赵小雷 | 赵小雷 |
| 180 | 我最亲爱的 | 你在看我吗 | 你在看我吗 |
| 181 | 문을 여시오 (New Ver.) 请开门 | 문을 여시오 | 문을 여시오 |
| 182 | Cornfield Chase | Interstellar (Original Motion Picture Soundtrack) | Interstellar (Original Motion Picture Soundtrack) |
| 183 | Riverside | Philharmonics (Deluxe Edition) | Philharmonics (Deluxe Edition) |
| 184 | Gotta Have You | Say I Am You | Say I Am You |
| 185 | Big Big World | Big Big World | Big Big World |
| 186 | 认错 | 自定义 | 自定义 |
| 187 | 月光下的凤尾竹 (葫芦丝) | 金耳朵.发烧民乐 | 金耳朵.发烧民乐 |
| 188 | Love The Way You Lie | Life After Recovery | Life After Recovery |
| 189 | 好汉歌 | 好汉歌 | 好汉歌 |
| 190 | My Heart Will Go On | Love Ballads | Love Ballads |
| 191 | 布拉格广场 | 看我72变 | 看我72变 |
| 192 | 粉红色的回忆 | 粉红色的回忆 | 粉红色的回忆 |
| 193 | Southampton | Titanic: Music from the Motion Picture Soundtrack | Titanic: Music from the Motion Picture Soundtrack |
| 194 | 雪见·落入凡尘 | 仙剑奇侠传三 电视剧原声带 | 仙剑奇侠传三 电视剧原声带 |
| 195 | 时间都去哪儿了 | 听得到的时间 | 听得到的时间 |
| 196 | 土耳其进行曲 | 土耳其进行曲 | 土耳其进行曲 |
| 197 | That's Not My Name | That's Not My Name | That's Not My Name |
| 198 | The Mountain of Women | Song of the Irish Whistle | Song of the Irish Whistle |
| 199 | Hymn To The Sea | Titanic: Music from the Motion Picture Soundtrack | Titanic: Music from the Motion Picture Soundtrack |
| 200 | Don't push me | Jade - silver edition | Jade - silver edition |
| 201 | Just Give Me A Reason | The Truth About Love | The Truth About Love |
| 202 | いつも何度でも | Prime Selection | Prime Selection |
| 203 | 光年之外 | 光年之外 | 光年之外 |
| 204 | Take It From Me | Say I Am You | Say I Am You |
| 205 | 差生 | 少年中国 | 少年中国 |
| 206 | Nocturne No. 2 in E Flat Major, Op. 9, No. 2 | The Chopin Collection: The Nocturnes | The Chopin Collection: The Nocturnes |
| 207 | 青花瓷 | 我很忙 | 我很忙 |
| 208 | Beyond The Memory | Beyond The Memory | Beyond The Memory |
| 209 | 十年 | 黑白灰 | 黑白灰 |
| 210 | 送别 | 送别 | 送别 |
| 211 | 曹操 | 曹操 | 曹操 |
| 212 | 黑板情书 | 黑板情书 | 黑板情书 |
| 213 | I can't let this go on any further | I can't let this go on any further | I can't let this go on any further |
| 214 | 一辈子的孤单 | 涩女郎 电视原声带 | 涩女郎 电视原声带 |
| 215 | 因为爱情 | Stranger Under My Skin | Stranger Under My Skin |
| 216 | 我从崖边跌落 | 算云烟 | 算云烟 |
| 217 | 往事只能回味 | 往事只能回味 | 往事只能回味 |
| 218 | Never An Absolution | Titanic: Music from the Motion Picture Soundtrack | Titanic: Music from the Motion Picture Soundtrack |
| 219 | Rose | Titanic: Music from the Motion Picture Soundtrack | Titanic: Music from the Motion Picture Soundtrack |
| 220 | 关于郑州的记忆 | 你好，郑州 | 你好，郑州 |
| 221 | 突然的自我 | 忘情1015精选辑 | 忘情1015精选辑 |
| 222 | Roses and Gold | Dust Diaries | Dust Diaries |
| 223 | 春风十里 | 所有的酒，都不如你 | 所有的酒，都不如你 |
| 224 | 星座书上 | 自定义 | 自定义 |
| 225 | Yesterday Once More | Yesterday Once More | Yesterday Once More |
| 226 | 粉末 | 粉末 | 粉末 |
| 227 | 苏州城外的微笑 | 很有爱 | 很有爱 |
| 228 | Hey Jude | It's a Battle | It's a Battle |
| 229 | 天下 | 明天过后 | 明天过后 |
| 230 | Last Dance | 爱情的尽头 | 爱情的尽头 |
| 231 | Miss Misery | Good Will Hunting (Music from the Miramax Motion Picture) | Good Will Hunting (Music from the Miramax Motion Picture) |
| 232 | 不再犹豫 | Beyond The Stage | Beyond The Stage |
| 233 | Take a Bow | Good Girl Gone Bad | Good Girl Gone Bad |
| 234 | 泡沫 | Xposed | Xposed |
| 235 | 没有什么不同 | 我的歌声里 | 我的歌声里 |
| 236 | 夜太黑 | 夜太黑 | 夜太黑 |
| 237 | 故乡的原风景 | 武侠音乐精装特辑 | 武侠音乐精装特辑 |
| 238 | 亲爱的那不是爱情 | Ang 5.0 | Ang 5.0 |
| 239 | 红色高跟鞋 | 若你碰到他 | 若你碰到他 |
| 240 | The End of the World | The End of the World | The End of the World |
| 241 | 怒放的生命 | 怒放的生命 | 怒放的生命 |
| 242 | 大约在冬季 | 冬雨 | 冬雨 |
| 243 | 喜欢你 | 喜欢你 | 喜欢你 |
| 244 | 挪威的森林 | 爱情的尽头 | 爱情的尽头 |
| 245 | 本草纲目 | 依然范特西 | 依然范特西 |
| 246 | 小刀会序曲 | 武侠音乐系列之豪气中天 | 武侠音乐系列之豪气中天 |
| 247 | 2 Soon | Not Thinking Bout 2morrow | Not Thinking Bout 2morrow |
| 248 | 彩云追月 | Edell.Love | Edell.Love |
| 249 | 忧伤倒数 | 夫妻那些事 电视剧原声带 | 夫妻那些事 电视剧原声带 |
| 250 | 爱情转移 | 认了吧 | 认了吧 |
| 251 | 阳光下的我们 | Say The Words | Say The Words |
| 252 | 今天 | 真永远 | 真永远 |
| 253 | Breaking My Heart | Unreleased | Unreleased |
| 254 | 隐形的翅膀 | 潘朵拉 | 潘朵拉 |
| 255 | 蝴蝶泉边 | 崽崽 | 崽崽 |
| 256 | Sugar | V | V |
| 257 | 七里香 | 七里香 | 七里香 |
| 258 | 庐州月 | 寻雾启示 | 寻雾启示 |
| 259 | Only Time | Only Time: The Collection (Box Set) | Only Time: The Collection (Box Set) |
| 260 | 香水有毒 (DJ版) | 香水有毒(宣传单曲) | 香水有毒(宣传单曲) |
| 261 | 有何不可 | 自定义 | 自定义 |
| 262 | 真的爱你 | BEYOND IV | BEYOND IV |
| 263 | Remember The Time | The Ultimate Collection | The Ultimate Collection |
| 264 | Teenage Dream | Teenage Dream | Teenage Dream |
| 265 | 莫扎特：《小夜曲》第一乐章 | 2008-2011 演奏实况合集 | 2008-2011 演奏实况合集 |
| 266 | Loves Me Not | t.A.T.u. - The Best | t.A.T.u. - The Best |
| 267 | 穿越时空的思念2 时代を超える想い2 | 映画“犬夜叉 时代を越える想い 音楽篇” | 映画“犬夜叉 时代を越える想い 音楽篇” |
| 268 | 毕业说分手 | 毕业说分手 | 毕业说分手 |
| 269 | The South Wind | Song of the Irish Whistle | Song of the Irish Whistle |
| 270 | The Scientist | The Scientist | The Scientist |
| 271 | 大海 | 70老男孩 | 70老男孩 |
| 272 | 八年的爱 | 八年的爱 | 八年的爱 |
| 273 | TiK ToK | Animal | Animal |
| 274 | Underneath Your Clothes | Laundry Service | Laundry Service |
| 275 | My Heart Will Go On | My Love: Ultimate Essential Collection (North American Version) | My Love: Ultimate Essential Collection (North American Version) |
| 276 | 我变了 我没变 | 我变了 我没变 | 我变了 我没变 |
| 277 | Trip | Trip | Trip |
| 278 | 断桥残雪 | 断桥残雪 | 断桥残雪 |
| 279 | 春天里 | 信仰在空中飘扬 | 信仰在空中飘扬 |
| 280 | What A Wonderful World | All Time Greatest Hits | All Time Greatest Hits |
| 281 | 光明 | 信仰在空中飘扬 | 信仰在空中飘扬 |
| 282 | 光辉岁月 | 光辉岁月 | 光辉岁月 |
| 283 | Rhythm Of The Rain | Let It Be Me | Let It Be Me |
| 284 | Five Hundred Miles (《醉乡民谣》电影主题曲|《一路繁花相送》电视剧插曲) | Inside Llewyn Davis: Original Soundtrack Recording | Inside Llewyn Davis: Original Soundtrack Recording |
| 285 | Snowdreams 雪之梦 | Rhine River | Rhine River |
| 286 | Not a Single Day 하루도 | Rain's World (Special Edition) | Rain's World (Special Edition) |
| 287 | Don't Wanna Know/We Don't Talk Anymore | Don't Wanna Know/We Don't Talk Anymore | Don't Wanna Know/We Don't Talk Anymore |
| 288 | Summer Vibe | Summer Vibe | Summer Vibe |
| 289 | We Are One | Super Deluxe Sound I | Super Deluxe Sound I |
| 290 | 北京北京 | 勇敢的心 | 勇敢的心 |
| 291 | We Don't Talk Anymore | We Don't Talk Anymore | We Don't Talk Anymore |
| 292 | You Got Me | Breakthrough | Breakthrough |
| 293 | Where Is the Love | Best of Both Worlds | Best of Both Worlds |
| 294 | Love Story | Women's Day 2019 | Women's Day 2019 |
| 295 | BLUE | Blue Neighbourhood (Deluxe) | Blue Neighbourhood (Deluxe) |
| 296 | I Do | I Do | I Do |
| 297 | A Little Story | My View | My View |
| 298 | Memories | 마녀유희 OST | 마녀유희 OST |
| 299 | Sundial Dreams | In the Enchanted Garden | In the Enchanted Garden |
| 300 | If | 마녀유희 OST | 마녀유희 OST |
| 301 | 相思赋予谁 | 春生 | 春生 |
| 302 | 筝锋 | 功夫 电影原声大碟 | 功夫 电影原声大碟 |
| 303 | Thinking Out Loud | NOW That's What I Call Music! 90 | NOW That's What I Call Music! 90 |
| 304 | Righteous Path | Introducing Mellow | Introducing Mellow |
| 305 | Somebody That I Used To Know | Making Mirrors | Making Mirrors |
| 306 | 回家(萨克斯风) | 金耳朵Ⅲ | 金耳朵Ⅲ |
| 307 | Palace Memories | Sound. Earth. Nature. Spirit. - Vol. Sound | Sound. Earth. Nature. Spirit. - Vol. Sound |
| 308 | East of Eden | East of Eden | East of Eden |
| 309 | Breath and Life | The Platinum Series III: Eterna | The Platinum Series III: Eterna |
| 310 | Carpe Diem | Dead Poets Society | Dead Poets Society |
| 311 | Beautiful In White (Demo) | Beautiful In White (Demo) | Beautiful In White (Demo) |
| 312 | Keating's Triumph | Dead Poets Society | Dead Poets Society |
| 313 | Better Man | Sing When You're Winning | Sing When You're Winning |
| 314 | Love Me Like You Do | Delirium | Delirium |
| 315 | Summer | ENCORE | ENCORE |
| 316 | Viva La Vida | Viva La Vida Or Death And All His Friends | Viva La Vida Or Death And All His Friends |
| 317 | 爱向着我来的那天 사랑아 내게 오기만 해 (PartⅠ) | 마녀유희 OST | 마녀유희 OST |
| 318 | Love The Way You Lie [Part III (Original Demo)] | Her Songs | Her Songs |
| 319 | You're Beautiful | So Beautiful 1 | So Beautiful 1 |
| 320 | 思念是一种病 | OK | OK |
| 321 | Sunburst | Sunburst | Sunburst |
| 322 | Farewell to Camraw | When the Pipers Play | When the Pipers Play |
| 323 | 想太多 | 想太多 | 想太多 |
| 324 | Booty Music | Git Fresh | Git Fresh |
| 325 | Genie | THE BEST ~New Edition~ | THE BEST ~New Edition~ |
| 326 | 樱花草 | 花言乔语 (精装版) | 花言乔语 (精装版) |
| 327 | Girlfriend | The Best Damn Thing: Deluxe Edition | The Best Damn Thing: Deluxe Edition |
| 328 | Remember The Name | Sampler Mixtape | Sampler Mixtape |
| 329 | The Long Way Home | The Bright Side | The Bright Side |
| 330 | Right Here Waiting_轻音乐 | Ballads | Ballads |
| 331 | 单车恋人 | 9公主 | 9公主 |
| 332 | 愤怒的消失 그게 말이죠 | 마녀유희 OST | 마녀유희 OST |
| 333 | 西厢 | 古·玩 | 古·玩 |
| 334 | Bye Bye Bye | Rising Love | Rising Love |
| 335 | Star of the County Down | Musique Celtic | Musique Celtic |
| 336 | Main Title (The Godfather Waltz) | The Godfather I | The Godfather I |
| 337 | 命运的恶作剧 운명의 장난 | 마녀유희 OST | 마녀유희 OST |
| 338 | Far Away From Home | Greatest Hits | Greatest Hits |
| 339 | Damn You | The Unreleased Collection | The Unreleased Collection |
| 340 | Love Yourself (Natio Remix) | Love Yourself (Natio Remix) | Love Yourself (Natio Remix) |
| 341 | Red River Valley | Journey Home | Journey Home |
| 342 | 去年夏天 | 去年夏天 | 去年夏天 |
| 343 | 友谊之光 | 监狱风云 | 监狱风云 |
| 344 | The Moon Represents My Heart | Love Ballads | Love Ballads |
| 345 | Auld Lang Syne | The Greatest Gift | The Greatest Gift |
| 346 | 口弦 | 听见凉山 电视剧原声带 | 听见凉山 电视剧原声带 |
| 347 | 奇异恩典 | 最新热歌慢摇73 | 最新热歌慢摇73 |
| 348 | Flower Dance | A Cup Of Coffee | A Cup Of Coffee |
| 349 | Come And Get It | Chartsurfer Vol. 30 | Chartsurfer Vol. 30 |
| 350 | Heartbeats | Swings and Roundabouts | Swings and Roundabouts |
| 351 | Hero | Hero | Hero |
| 352 | I Just Wanna Run | Take Action! Volume 9 | Take Action! Volume 9 |
| 353 | 莫失莫忘 | 武侠音乐系列之后悔莫及 | 武侠音乐系列之后悔莫及 |
| 354 | I Want You to Know | I Want You to Know | I Want You to Know |
| 355 | We Are Young | Dancing Bear Best Of 2012 International | Dancing Bear Best Of 2012 International |
| 356 | The Day You Went Away | The Day You Went Away: The Best of M2M | The Day You Went Away: The Best of M2M |
| 357 | Sleepyhead | Acoustic Daydreams | Acoustic Daydreams |
| 358 | Moon As My Heart | Harmonica Sound of Hong Kong | Harmonica Sound of Hong Kong |
| 359 | 卡农D大调 | 胎教音乐 | 胎教音乐 |
| 360 | My Soul | Time... | Time... |
| 361 | 富士山下 | What's Going On…? | What's Going On…? |
| 362 | New Soul | Irlande | Irlande |
| 363 | If I Die Young | If I Die Young - Single | If I Die Young - Single |
| 364 | The Godfather (Love Theme) | The Godfather I | The Godfather I |
| 365 | My Love (Radio Edit) | Coast to Coast | Coast to Coast |
| 366 | What Are Words | What Are Words | What Are Words |
| 367 | Young For You | Young For You | Young For You |
| 368 | The Ludlows | Legends Of The Fall Original Motion Picture Soundtrack | Legends Of The Fall Original Motion Picture Soundtrack |
| 369 | Pop Danthology 2012 | Pop Danthology | Pop Danthology |
| 370 | Paris | Paris | Paris |
| 371 | 呼唤 오나라 I | 대장금 OST | 대장금 OST |
| 372 | 爱向着我来的那天2 사랑아 내게 오기만 해 (Part II) | 마녀유희 OST | 마녀유희 OST |
| 373 | 再见 | 再见 | 再见 |
| 374 | 千千阙歌 | 千千阙歌 | 千千阙歌 |
| 375 | Roses and Gold | Dust Diaries | Dust Diaries |
| 376 | Kiss The Rain 비를 맞다 | The Best - Reminiscent 10th Anniversary | The Best - Reminiscent 10th Anniversary |
| 377 | Runner | Runner | Runner |
| 378 | This Is the Life | Weathered | Weathered |
| 379 | Dead Poets Society (Finale) | Filmharmonic II | Filmharmonic II |
| 380 | The sally gardens | Arias Ancora | Arias Ancora |
| 381 | 安静 钢琴版 | 纯音乐流行歌曲钢琴版 | 纯音乐流行歌曲钢琴版 |
| 382 | Wrecking Ball | Wrecking Ball | Wrecking Ball |
| 383 | 是啊 그래 | 마녀유희 OST | 마녀유희 OST |
| 384 | Six Feet Under | Six Feet Under | Six Feet Under |
| 385 | 穿越时空的思念1 时代を超える想い1 | 映画“犬夜叉 时代を越える想い 音楽篇” | 映画“犬夜叉 时代を越える想い 音楽篇” |
| 386 | Umbrella | Now That's What I Call Music! 25 Years | Now That's What I Call Music! 25 Years |
| 387 | 桔梗谣 | 桔梗谣 | 桔梗谣 |
| 388 | Waka Waka (Esto Es África) | Waka Waka (This Time For Africa) (The Official 2010 Fifa World Cup Song) | Waka Waka (This Time For Africa) (The Official 2010 Fifa World Cup Song) |
| 389 | Kiss The Rain 비를 맞다 | The Best - Reminiscent 10th Anniversary | The Best - Reminiscent 10th Anniversary |
| 390 | In The End | In The End | In The End |
| 391 | 野子 (Live) | 我是歌手第四季 第3期 | 我是歌手第四季 第3期 |
| 392 | Monody | Monody | Monody |
| 393 | The Show | The Show | The Show |
| 394 | Ship In The Sand | Dear Me, Look Up | Dear Me, Look Up |
| 395 | Summertime Sadness | Summertime Sadness | Summertime Sadness |
| 396 | 慕情 (M-4) | 犬夜叉 音楽篇 | 犬夜叉 音楽篇 |
| 397 | 你还要我怎样 | 意外 | 意外 |
| 398 | 发现爱 | 西界 | 西界 |
| 399 | 犯错 | 犯错 | 犯错 |
| 400 | 北京欢迎你 | 北京2008年奥运会歌曲专辑 | 北京2008年奥运会歌曲专辑 |
| 401 | Skinny Love | Skinny Love | Skinny Love |
| 402 | 我的歌声里 | 我的歌声里 | 我的歌声里 |
| 403 | 情人 | 海阔天空 | 海阔天空 |
| 404 | 桔梗谣 | 노들강변 매화타령 민요 | 노들강변 매화타령 민요 |
| 405 | 为爱痴狂 | 歌曲合辑 | 歌曲合辑 |
| 406 | Mariage d'amour | Lettre à ma Mère | Lettre à ma Mère |
| 407 | 世界第一等 | 世界第一等 | 世界第一等 |
| 408 | Unable To Stay, Unwilling To Leave | Titanic: Music from the Motion Picture Soundtrack | Titanic: Music from the Motion Picture Soundtrack |
| 409 | Baby | Baby | Baby |
| 410 | 春娇与志明 | 春娇与志明 | 春娇与志明 |
| 411 | Nevada | Monstercat - Best of 2016 | Monstercat - Best of 2016 |
| 412 | 听妈妈的话 | 依然范特西 | 依然范特西 |
| 413 | 红尘情歌 | 情路无悔 | 情路无悔 |
| 414 | Jambalaya | 不朽的声音(人生最难忘的歌) | 不朽的声音(人生最难忘的歌) |
| 415 | 安静 | 范特西 | 范特西 |
| 416 | 梦中蝶影 | 歌曲合辑 | 歌曲合辑 |
| 417 | 姑娘我爱你 | 姑娘我爱你 | 姑娘我爱你 |
| 418 | 借我 | 算云烟 | 算云烟 |
| 419 | 兰亭序 | 魔杰座 | 魔杰座 |
| 420 | The Red Sun | 20 Years of Achievement around the World | 20 Years of Achievement around the World |
| 421 | 纯真年代 | 大小世界 | 大小世界 |
| 422 | 李白 | 模特 | 模特 |
| 423 | 平凡之路 | 猎户星座 | 猎户星座 |
| 424 | Vincent | Legendary Don McLean | Legendary Don McLean |
| 425 | 意外 | 意外 | 意外 |
| 426 | Coming Home | Coming Home | Coming Home |
| 427 | Turnin' | Young Rising Sons | Young Rising Sons |
| 428 | 那些年 | 那些年，我们一起追的女孩 电影原声带 | 那些年，我们一起追的女孩 电影原声带 |
| 429 | 有一种爱叫做放手 | 有一种爱叫做放手 | 有一种爱叫做放手 |
| 430 | 童年 | 童年 | 童年 |
| 431 | 我最亲爱的 | 我的歌声里 | 我的歌声里 |
| 432 | 我希望 | 匆匆那年 电视原声带 | 匆匆那年 电视原声带 |
| 433 | 知道不知道 | Rene | Rene |
| 434 | Say Hello | These Friends Of Mine | These Friends Of Mine |
| 435 | 相思 | 腔.调 | 腔.调 |
| 436 | Sally Gardens | Spring | Spring |
| 437 | Valder Fields | A Plea en Vendredi | A Plea en Vendredi |
| 438 | 刚好遇见你 | 刚好遇见你 | 刚好遇见你 |
| 439 | 海阔天空 | 一声所爱 大地飞歌（第九期） | 一声所爱 大地飞歌（第九期） |
| 440 | Luv Letter | 髙橋大輔～フェイヴァリット・ミュージック～ | 髙橋大輔～フェイヴァリット・ミュージック～ |
| 441 | 万水千山总是情 | 万水千山总是情 电视剧原声带 | 万水千山总是情 电视剧原声带 |
| 442 | 希望 | Grace & Charm | Grace & Charm |
| 443 | 城府 | 自定义 | 自定义 |
| 444 | The Long Way Home | The Bright Side | The Bright Side |
| 445 | 梦中的婚礼 | Richard Clayderman | Richard Clayderman |
| 446 | 发如雪 | 十一月的萧邦 | 十一月的萧邦 |
| 447 | Demons | Continued Silence EP | Continued Silence EP |
| 448 | Take Me To Church | Bravo Hits 86 | Bravo Hits 86 |
| 449 | Love The Way You Lie (Part III (Original Demo)) | Relaxing Acoustic | Relaxing Acoustic |
| 450 | 小苹果 | 老男孩之猛龙过江 电影原声 | 老男孩之猛龙过江 电影原声 |
| 451 | 我是一只小小鸟 | 我是一只小小鸟 | 我是一只小小鸟 |
| 452 | 好久不见 | 认了吧 | 认了吧 |
| 453 | Be What You Wanna Be | Darin | Darin |
| 454 | A Place Called You | Enchanted | Enchanted |
| 455 | Young And Beautiful | Triple J Hottest 100 Vol 21 | Triple J Hottest 100 Vol 21 |
| 456 | Frail Love | Frail Love | Frail Love |
| 457 | 从头再来 | 经典20年 珍藏锦集 | 经典20年 珍藏锦集 |
| 458 | 浮夸 | U-87 | U-87 |
| 459 | The Ocean (Radio Edit) | The Ocean | The Ocean |
| 460 | When You're Gone | When You're Gone | When You're Gone |
| 461 | Unity | Sounds of Syndication, Vol .1 (Presented by Syndicate) | Sounds of Syndication, Vol .1 (Presented by Syndicate) |
| 462 | Hey, Soul Sister | Save Me, San Francisco | Save Me, San Francisco |
| 463 | Too Far | King in the Mirror | King in the Mirror |
| 464 | Inspire | Serenity | Serenity |
| 465 | 曾经的你 | 每一刻都是崭新的 | 每一刻都是崭新的 |
| 466 | Sutter's Mill | The Music of Dan Fogelberg | The Music of Dan Fogelberg |
| 467 | 存在 | 生无所求 | 生无所求 |
| 468 | Stay Here Forever | Valentine's Day OST | Valentine's Day OST |
| 469 | 易燃易爆炸 | 如也 | 如也 |
| 470 | 飞向别人的床 | 飞向别人的床 | 飞向别人的床 |
| 471 | 传奇 | 传奇 | 传奇 |
| 472 | Everybody | Everybody | Everybody |
| 473 | Astronomia（黑人抬棺古风版） | 黑人抬棺古风版 | 黑人抬棺古风版 |
| 474 | brave heart | brave heart | brave heart |
| 475 | Hymn To The Sea | Titanic: Music from the Motion Picture Soundtrack | Titanic: Music from the Motion Picture Soundtrack |
| 476 | Read My Mind | Jade | Jade |
| 477 | Let It Out | Let It Out | Let It Out |
| 478 | 飞得更高 | 笑着哭 | 笑着哭 |
| 479 | 花火 | 花火 | 花火 |
| 480 | 跟往事干杯 | 不朽金曲精选 Ⅰ | 不朽金曲精选 Ⅰ |
| 481 | 直到永远 | 生死不离 我们在一起 | 生死不离 我们在一起 |
| 482 | 蓝莲花 | 时光.漫步 | 时光.漫步 |
| 483 | 娃娃脸 | 娃娃脸 | 娃娃脸 |
| 484 | 星象仪 プラネタリウム | プラネタリウム | プラネタリウム |
| 485 | 我爱你中国 | 怒放的生命 | 怒放的生命 |
| 486 | 莫失莫忘 | 仙侠音乐系列之仙剑奇侠传一 | 仙侠音乐系列之仙剑奇侠传一 |
| 487 | 一直很安静 | 寂寞在唱歌 | 寂寞在唱歌 |
| 488 | 生活不止眼前的苟且 | 生活不止眼前的苟且 | 生活不止眼前的苟且 |
| 489 | 運命のルーレット廻して (转动命运之轮) | 運命のルーレット廻して | 運命のルーレット廻して |
| 490 | Tears Of A Clown | Mastercutor | Mastercutor |
| 491 | My Destiny (我的命运) | 별에서 온 그대 OST Part 1 | 별에서 온 그대 OST Part 1 |
| 492 | 亲爱的路人 | 亲爱的路人 | 亲爱的路人 |
| 493 | Call Me Maybe | Call Me Maybe | Call Me Maybe |
| 494 | 如果不能好好爱 | 如果不能好好爱 | 如果不能好好爱 |
| 495 | 花开在眼前 | 花开在眼前 | 花开在眼前 |
| 496 | 童年 | 纵贯线演唱会 | 纵贯线演唱会 |
| 497 | 魔訶不思議アドベンチャー! | ドラゴンボール全曲集 | ドラゴンボール全曲集 |
| 498 | The Monster | The Monster | The Monster |
| 499 | One Night In 北京 | SHIN 同名专辑 | SHIN 同名专辑 |
| 500 | Amazing Grace 天赐恩宠 | 苏格兰音乐之旅 苏格兰风笛 | 苏格兰音乐之旅 苏格兰风笛 |
| 501 | 小仙女 | 武侠音乐系列之缠绵悱恻 （截取版） | 武侠音乐系列之缠绵悱恻 （截取版） |
| 502 | 喜剧之王 | 喜剧之王 | 喜剧之王 |
| 503 | Scotland the Brave 苏格兰勇士 | 苏格兰音乐之旅 苏格兰风笛 | 苏格兰音乐之旅 苏格兰风笛 |
| 504 | Hallelujah | Warmer In The Winter (Deluxe Edition) | Warmer In The Winter (Deluxe Edition) |
| 505 | 二泉映月 | 阿炳全集 | 阿炳全集 |
| 506 | 男儿当自强 | 笑傲歌坛 传世经典 | 笑傲歌坛 传世经典 |
| 507 | Summer | ENCORE | ENCORE |
| 508 | 我和你 | 北京2008 奥运会、残奥会开闭幕式主题歌曲专辑 | 北京2008 奥运会、残奥会开闭幕式主题歌曲专辑 |
| 509 | 上海滩 | 上海滩 | 上海滩 |
| 510 | 算你狠 | 绝对收藏 | 绝对收藏 |
| 511 | 黄种人 | 黄·锋 | 黄·锋 |
| 512 | Croatian Rhapsody | The Piano Player | The Piano Player |
| 513 | He's a Pirate | Pirates of the Caribbean: The Curse of the Black Pearl | Pirates of the Caribbean: The Curse of the Black Pearl |
| 514 | 星月神话 | 女人又一次哭泣 | 女人又一次哭泣 |
| 515 | 夜上海 | 夜上海精选 | 夜上海精选 |
| 516 | 带你去旅行 | 带你去旅行 | 带你去旅行 |
| 517 | 天下第一 | 武侠音乐系列之豪气中天 （截取版） | 武侠音乐系列之豪气中天 （截取版） |
| 518 | '97爱情宣言 | 狼 97黄金自选辑 | 狼 97黄金自选辑 |
| 519 | 外面的世界 | 燃烧爱情（狼之旅） | 燃烧爱情（狼之旅） |
| 520 | 小酒窝 | JJ陆 | JJ陆 |
| 521 | 大约在冬季 | 摘金宝典 | 摘金宝典 |
| 522 | Go Time | Go Time | Go Time |
| 523 | 往事随风 | 痛并快乐着 | 痛并快乐着 |
| 524 | The Portrait | Titanic: Special Edition | Titanic: Special Edition |
| 525 | 你还欠我一个拥抱 | 很有爱 | 很有爱 |
| 526 | 匆匆那年 | 匆匆那年 电影原声带 | 匆匆那年 电影原声带 |
| 527 | 命运 운명 | 풀 하우스 OST (KBS 미니시리즈) | 풀 하우스 OST (KBS 미니시리즈) |
| 528 | 大海~ | Asia | Asia |
| 529 | Flavor Of Life | Flavor Of Life | Flavor Of Life |
| 530 | Death Of Titanic | Titanic: Music from the Motion Picture Soundtrack | Titanic: Music from the Motion Picture Soundtrack |
| 531 | 不如不见 | What's Going On…? | What's Going On…? |
| 532 | Distant Memories | Titanic: Music from the Motion Picture Soundtrack | Titanic: Music from the Motion Picture Soundtrack |
| 533 | 偏爱 | 破天荒 | 破天荒 |
| 534 | Diamonds | Diamonds | Diamonds |
| 535 | 我欲成仙 | 西游记后传片头曲 | 西游记后传片头曲 |
| 536 | 希望 (国语) | 我是阳光的 | 我是阳光的 |
