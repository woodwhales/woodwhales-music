# woodwhales-music

[![](https://img.shields.io/badge/author-woodwhales-green.svg)](https://woodwhales.cn/) ![](https://img.shields.io/badge/license-GPL%203.0-orange.svg)

> 基于 SpringBoot 的开源超简洁音乐播放器

<div align=center>在线播放：<a href="https://music.icoders.cn">https://music.icoders.cn</a></div>

环境要求：JDK1.8

技术栈：springboot + thymeleaf + layui + spring security + jsoup + mybatis plus + mysql 

## 1. 系统说明

### 1.1 配置文件

#### 1.1.1 SQL 文件

文件位置：

- woodwhales-music/doc/sql/open_music_适用高于v3.6.0版本.sql
- woodwhales-music/doc/sql/open_music_适用高于v3.6.0版本_只含库表结构.sql
- woodwhales-music/doc/sql/open_music_适用低于v3.6.0版本.sql

文件说明：

- 不建议使用低于 v3.6.0版本的 SQL 文件
- open_music_适用高于v3.6.0版本.sql 文件中包含下章节中的歌单链接，开发者可导入后从后台页面做批量删除操作。
- 只导入库表结构，则使用：open_music_适用高于v3.6.0版本_只含库表结构.sql

#### 1.1.2 系统配置

文件位置：

- woodwhales-music/src/main/resources/dev/application-dev.yml

文件说明：

- 配置文件使用 yml 语法，其中 system.username 和 system.password 分别表示后台系统的系统账号名和密码。

    ```yaml
    system:
      username: xxx
      password: xxx
    ```

    开发者可以使用 org.woodwhales.music.security.PasswordTest#test 单元测试代码，生成自定义的后台系统账号和密码

### 1.2 编译打包

执行 mvn 命令打包：

```shell
mvn clean install -Pdev
```

上述 -P 表示打包 dev 环境参数配置文件。

目前项目中的 pom.xml 配置文件中只指定了 dev 和 prod，开发者可根据需要指定其他环境参数：

> 如果配置生产环境，则需要在 woodwhales-music/src/main/resources/ 中创建 prod 文件夹，并创建 application-prod.yml 配置文件，打包时 -P 参数指定为：prod

```xml
<profiles>
    <profile>
        <id>dev</id>
        <activation>
            <activeByDefault>true</activeByDefault>
        </activation>
        <properties>
            <profiles.active>dev</profiles.active>
        </properties>
    </profile>
    <profile>
        <id>prod</id>
        <properties>
            <profiles.active>prod</profiles.active>
        </properties>
    </profile>
</profiles>
```

## 2. 功能说明

### 3.6.0

- **与低于 v3.6.0 版本的库表不兼容，请使用 doc 中的 [open_music_适用高于v3.6.0版本.sql](./doc/sql/open_music_适用高于v3.6.0版本.sql) 进行库表数据初始化操作**

    > 低于  v3.6.0 版本的库表数据初始化 SQL： [open_music_适用低于v3.6.0版本.sql](./doc/sql/open_music_适用低于v3.6.0版本.sql) 

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

## 3. 前台

访问端口：http://127.0.0.1:8084/music/

![](doc/images/index.png)

## 4. 后台

访问端口：http://127.0.0.1:8084/music/admin/

dev 环境账号密码：admin / admin

### 4.1 首页

![](doc/images/v3.6.0/admin-index.png)

音乐名称为<font color='gree'>绿色字体</font>，表示该音乐**已关联**音频链接和专辑封面链接。

音乐名称为<font color='red'>红色字体</font>，表示该音乐**未关联**音频链接和专辑封面链接。

### 4.1 添加/编辑

太懒了，加了个解析音乐平台的解析器，一旦解析成功，自动填充：音乐名称、作者、专辑名称。

> 支持：网易云、QQ 音乐、虾米音乐（平台已关闭）
>
> 建议开发者自行搭建 [alist](https://github.com/alist-org/alist) 并维护音乐源文件

![](doc/images/v3.6.0/admin-add.png)

### 4.2 解析

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

## 5. 歌单

已收录 920 首音乐

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
| 23 | 金风玉露 | 金风玉露 | 旅行新蜜蜂 |
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
| 63 | 夜空中最亮的星 | 世界 | 逃跑计划 |
| 64 | Yellow | Best Of British | Coldplay |
| 65 | 一百万个可能 | 一百万个可能 | Christine Welch |
| 66 | 习惯了寂寞 | 习惯了寂寞 | 牛奶咖啡 |
| 67 | 我的歌声里 | Everything In The World (白金庆功版) | 曲婉婷 |
| 68 | 女人花 | 女人花 | 梅艳芳 |
| 69 | 一剪梅 | 花神 | 黄渤 / 左小祖咒 |
| 70 | A Life So Changed | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 71 | Here We Are Again (纯音乐) (《喜剧之王》电影插曲) | Here We Are Again (纯音乐) (《喜剧之王》电影插曲) | Cagnet (キャグネット) |
| 72 | 相思好比小蚂蚁 | 特别的日子 | 张蔷 |
| 73 | Almost Lover | Almost Lover | A Fine Frenzy |
| 74 | Down By The Salley Gardens | camomile | 藤田恵美 (ふじた えみ) |
| 75 | With An Orchid | If I Could Tell You | Yanni |
| 76 | 宝贝 (in a day) | Original | 张悬 |
| 77 | 这世界那么多人 | 这世界那么多人 | 莫文蔚 |
| 78 | 明天你是否依然爱我 | 其实你不懂我的心 | 童安格 |
| 79 | 爱如潮水 | 张信哲精选 | 张信哲 |
| 80 | 7 Years | The Young Pope (Original Series Sountrack) | Lukas Graham |
| 81 | The Sound of Silence (Reprise) | The Graduate | Simon & Garfunkel |
| 82 | BINGBIAN病变 (女声版) | BINGBIAN病变 (女声版) | 鞠文娴 |
| 83 | Don't You Remember | 21 | Adele |
| 84 | かごめと犬夜叉 (M-11+6) | 犬夜叉 音楽篇 | 和田薫 |
| 85 | 吉姆餐厅 | 吉姆餐厅 | 赵雷 |
| 86 | 很爱很爱你 | 很爱很爱你 | 刘若英 |
| 87 | 我们的时光 | 吉姆餐厅 | 赵雷 |
| 88 | Women of Ireland | Song of the Irish Whistle | Joanie Madden |
| 89 | Traveling Light | Traveling Light | Joel Hanson |
| 90 | 醉赤壁 | JJ陆 | 林俊杰 |
| 91 | 笑看风云 (Live) | 汪小敏 笑看风云 | 汪小敏 |
| 92 | 再度重相逢 | 泪桥 | 伍佰 & China Blue |
| 93 | The Way Of Life | 오! 필승 봉순영 OST | 吴硕浚 |
| 94 | 世界这么大还是遇见你 (清新的小女孩（中文版）) | 清新的小女孩（中文版） | 程响 |
| 95 | The Sounds Of Silence 寂静之音 | Silence With Sound From Nature | Bandari |
| 96 | 夏日漱石 (Summer Cozy Rock) | 浪潮上岸 (Tears In Ocean) | 橘子海 (Orange Ocean) |
| 97 | Chasing Pavements | Chasing Pavements | Adele |
| 98 | Right Here Waiting | Ballads | Richard Marx |
| 99 | ル一ジユ（口红）-中岛美雪 | 美雪集-原曲流行极品 | 中島みゆき |
| 100 | 成都 | 成都 | 赵雷 |
| 101 | Faidherbe square (instrumental) | Curses from past times | ProleteR |
| 102 | Easy Breeze | Something Simple | Thomas Greenberg |
| 103 | Spring In My Step | Spring In My Step | Silent Partner |
| 104 | Free Loop | Cf, Movie & Drama Hits 广告，开麦拉！ | Daniel Powter |
| 105 | 世界が終るまでは･･･ (直到世界尽头) | 世界が終るまでは･･･ | WANDS (ワンズ) |
| 106 | I Could Be The One | Acoustic | Donna Lewis |
| 107 | 不让我的眼泪陪我过夜 | 丝路 | 齐秦 |
| 108 | Unchained Melody | Ghost | Alex North |
| 109 | Let Her Go | All The Little Lights | Passenger |
| 110 | Jar Of Love | Everything In The World (白金庆功版) | 曲婉婷 |
| 111 | 菊花爆满山 | 菊花爆满山 | 马博 |
| 112 | John of the Glen | Song of the Irish Whistle 2 | Joanie Madden |
| 113 | Illusionary Daytime（幻昼）-Shirfine | Endless Daydream | Shirfine |
| 114 | 青丝 | 青丝（完整版） | 等什么君(邓寓君) |
| 115 | Marry You | Now Los Mejores Exitos Del Ano 2012 | Bruno Mars |
| 116 | Seve | Seve | Tez Cadey |
| 117 | 似水流年 | Salute | 张国荣 |
| 118 | Rolling In The Deep | Rolling In The Deep | Adele |
| 119 | 喜欢你 | Beyond 25th Anniversary | Beyond |
| 120 | 我只在乎你 | 我只在乎你 | 邓丽君 |
| 121 | Coachella - Woodstock In My Mind | Lust For Life | Lana Del Rey |
| 122 | 辞九门回忆 | 辞九门回忆 | 等什么君(邓寓君) |
| 123 | 海阔天空 | 乐与怒 | Beyond |
| 124 | 傲气傲笑万重浪 | 黄飞鸿系列电影原声精装版 | 黄霑 |
| 125 | 倩女幽魂 | Ultimate | 张国荣 |
| 126 | Angolan Women | Life In a Day (O.S.T) | The Three Angolan Women |
| 127 | 清明雨上 | 自定义 | 许嵩 |
| 128 | A Day In The Life (Remastered)-The Beatles | Sgt. Pepper's Lonely Hearts Club Band (Remastered) | The Beatles |
| 129 | That Girl | 24 HRS (Deluxe) | Olly Murs |
| 130 | Set Fire to the Rain | 21 | Adele |
| 131 | 小情歌 | 小宇宙 | 苏打绿 |
| 132 | 阳光总在风雨后 | 都是夜归人 | 许美静 |
| 133 | Day by Day | 마녀유희 OST | 赵冠宇 |
| 134 | The Sound of Silence (Album Version) | Forever Friends 'Just For You' | Simon & Garfunkel |
| 135 | Refrain | Eternal Light | 阿南亮子 (あなん りょうこ) |
| 136 | 盛夏的果实 | 莫后年代 莫文蔚20周年世纪典藏 | 莫文蔚 |
| 137 | 若把你 | 若把你 | Kirsty刘瑾睿 |
| 138 | Dark Paradise | Born To Die (Deluxe Version) | Lana Del Rey |
| 139 | Dirty Paws | Summer Acoustic | Of Monsters And Men |
| 140 | Miracle In The Middle Of My Heart (Original Mix) | Miracle In The Middle Of My Heart (Original Mix) | Clément Bcx |
| 141 | 老朋友 | 老朋友 | 杨尘,王旭(旭日阳刚) |
| 142 | Whistle | Glee: The Music - The Complete Season Four | Glee Cast |
| 143 | She | 7 Years and 50 Days | Groove Coverage |
| 144 | 十月：我和曾经的我们 | 迷藏 | 钟城 / 姚望 |
| 145 | Stronger | Kids Top 20 - De Grootste Hits Van 2013 - Summer Edition 2013 | Kelly Clarkson |
| 146 | A Penny At A Time | Life In A Day OST | Matthew Herbert |
| 147 | The Immigrant | Song of the Irish Whistle | Joanie Madden |
| 148 | 家族の风景 | 虹の歌集 | 手嶌葵 |
| 149 | 爱拼才会赢 | 爱拼才会赢 | 叶启田 |
| 150 | 我只在乎你-刘惜君 | 惜 . 君 | 刘惜君 |
| 151 | 单身情歌 | 单身情歌．超炫精选 | 林志炫 |
| 152 | 丑八怪 | 意外 | 薛之谦 |
| 153 | 沧海一声笑 | 沧海一声笑 | 许冠杰 |
| 154 | 桔梗谣 | 桔梗谣 | 阿里郎 |
| 155 | Intro | xx | The xx |
| 156 | Need You Now | iTunes Session | Lady A |
| 157 | 父亲 | 父亲 | 筷子兄弟 |
| 158 | 桔梗谣 | 织谣 | 斯琴格日乐 |
| 159 | 姑娘在远方 | 姑娘在远方 | 柯柯柯啊 |
| 160 | 夜空中最亮的星 | 世界 | 逃跑计划 |
| 161 | 般若波罗蜜多心经 | 《大唐玄奘》电影片尾曲 | 王菲 |
| 162 | 彩云之南 | 彩云之南 | 徐千雅 |
| 163 | 合肥的石头 | 赤脚青春 | 飘乐队 |
| 164 | 似夜流月 | 热门华语234 | 宗次郎 (そうじろう) |
| 165 | A Day in the Life-John Lennon | Imagine: John Lennon | John Lennon |
| 166 | Caribbean Blue 加勒比海蓝 | Moonlight Bay | Bandari |
| 167 | Five hundred miles | America, Vol. 10: Country - The Folk Revival Revolution | The Journeymen |
| 168 | Right Now (Na Na Na) | Right Now (Na Na Na) | Akon |
| 169 | Victory | Battlecry | Two Steps From Hell |
| 170 | 桔梗谣(道拉基) (朝鲜民谣) | 恋恋金达莱 | 蒋薇 |
| 171 | Down By the Salley Gardens | Song of the Irish Whistle | Joanie Madden |
| 172 | 追梦人 | 浮世情怀 | 凤飞飞 |
| 173 | 小鱼儿的思绪 | 武侠音乐系列第二部之思情篇（截取版） | 麦振鸿 |
| 174 | 故乡 | 我只有两天.许巍精选 | 许巍 |
| 175 | Bubbly | So Fresh - The Hits Of Autumn 2008 | Colbie Caillat |
| 176 | 勇敢的心 | 勇敢的心 | 汪峰 |
| 177 | 我很好 | I'm fine | 刘沁 |
| 178 | 江南 | 他是…JJ林俊杰 | 林俊杰 |
| 179 | 年少有为 | 耳朵 | 李荣浩 |
| 180 | Price Tag | Price Tag | Jessie J / B.o.B |
| 181 | The Sound of Silence_轻音乐 | The Best Pan Pipes in the World...Ever! | Panpipes |
| 182 | Eversleeping | Eversleeping | Xandria |
| 183 | Breaking My Heart | Unreleased | Lana Del Rey |
| 184 | Dying In the Sun | Bury the Hatchet | The Cranberries |
| 185 | See You Again | See You Again | See You Again |
| 186 | I Am You | I Am You | Kim Taylor |
| 187 | I'm Yours | I'm Yours | Jason Mraz |
| 188 | Innocence | The Best Damn Thing: Deluxe Edition | Avril Lavigne |
| 189 | 一生所爱 | 齐天周大圣之西游双记 电影歌乐游唱版 | 卢冠廷 / 莫文蔚 |
| 190 | 潇洒地走 | 潇洒地走 | 张蔷 |
| 191 | Apologize | Dreaming Out Loud (Tour Edition) | OneRepublic |
| 192 | Better Than One | The Score EP 2 | The Score |
| 193 | 停格 | 停格 | 蔡健雅 |
| 194 | When You're Gone | When You're Gone | Avril Lavigne |
| 195 | Astronomia | Astronomia | Vicetone / Tony Igy |
| 196 | 容易受伤的女人 | 阿菲正传 | 王菲 |
| 197 | River Flows In You | Kuschelklassik Piano Dreams, Vol. 2 | Martin Ermen |
| 198 | 倔强 | 神的孩子都在跳舞 | 五月天 |
| 199 | 牛仔很忙 | 我很忙 | 周杰伦 |
| 200 | 面会菜-林生祥 | [大佛普拉斯] 电影配乐 | 林生祥 |
| 201 | 当爱在靠近 | Love & the City | 刘若英 |
| 202 | 日晷之梦 | 幸福时光 精选辑 | Kevin Kern |
| 203 | Last Reunion | Lament of Valkyrie (Epicmusicvn Series) | Peter Roe |
| 204 | 起风了 | 起风了 | 吴青峰 |
| 205 | Concerning Hobbits | The Lord of the Rings: The Fellowship of the Ring (Original Motion Picture Soundtrack) | Howard Shore |
| 206 | 叱咤红人 | 相依为命: 20年精彩印记 | 陈小春 |
| 207 | 天才白痴梦 | 天才与白痴 | 许冠杰 |
| 208 | 分手以后才知道最珍贵 | 回到家乡 | 胡力 |
| 209 | 往事只能回味 | 怀念老歌一 | 高胜美 |
| 210 | 原来你也在这里 | 我的失败与伟大 | 刘若英 |
| 211 | 我这家伙的答案是你 | AsuRa BalBalTa | Leessang / 河琳 |
| 212 | 往事只能回味 | 我是歌手第四季 第9期 | 金志文 |
| 213 | 勇敢的心 | 最新热歌慢摇88 | Various Artists |
| 214 | 等一分钟 | 滕爱Teng Love | 徐誉滕 |
| 215 | 我想大声告诉你 (《蜗居》电视剧片尾曲) | 我想大声告诉你 | 樊凡 |
| 216 | 光阴的故事 | 光阴的故事 | 黄晓明 邓超 佟大为 |
| 217 | 越长大越孤单 | 越长大越孤单 | 牛奶咖啡 |
| 218 | 往事只能回味 | 说时依旧 | 好妹妹 |
| 219 | 知足 | 知足 最真杰作选 | 五月天 |
| 220 | 一起摇摆 | 生来彷徨 | 汪峰 |
| 221 | 演员 | 绅士 | 薛之谦 |
| 222 | 南方姑娘 | 赵小雷 | 赵雷 |
| 223 | 我最亲爱的 | 你在看我吗 | 张惠妹 |
| 224 | 你的样子 | 罗大佑自选辑 | 罗大佑 |
| 225 | 문을 여시오 (New Ver.) 请开门 | 문을 여시오 | 任昌丁 / 金昌烈 |
| 226 | Cornfield Chase | Interstellar (Original Motion Picture Soundtrack) | Hans Zimmer |
| 227 | Riverside | Philharmonics (Deluxe Edition) | Agnes Obel |
| 228 | Gotta Have You | Say I Am You | The Weepies |
| 229 | Big Big World | Big Big World | Emilia |
| 230 | 认错 | 自定义 | 许嵩 |
| 231 | My Heart Will Go On | Love Ballads | Kenny G |
| 232 | 月光下的凤尾竹 (葫芦丝) | 金耳朵.发烧民乐 | 纯音乐 |
| 233 | Love The Way You Lie | Life After Recovery | Eminem / Rihanna |
| 234 | 好汉歌 | 好汉歌 | 刘欢 |
| 235 | 布拉格广场 | 看我72变 | 蔡依林 / 周杰伦 |
| 236 | 粉红色的回忆 | 粉红色的回忆 | 韩宝仪 |
| 237 | 大敦煌-刀郎 | 谢谢你 | 刀郎 |
| 238 | Childhood Memory 童年 | Sunny Bay | Bandari |
| 239 | Dream Catcher 追梦人 | Relaxation - Dreams | Bandari |
| 240 | 小苹果 | 老男孩之猛龙过江 电影原声 | 筷子兄弟 |
| 241 | 穿越时空的思念 (DiESi Remix) | 穿越时空的思念 | DiESi |
| 242 | Hello | Hello | Adele |
| 243 | Chiru (Saisei No Uta) | Nostalgic | Robert de Boron |
| 244 | Southampton | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 245 | 雪见·落入凡尘 | 仙剑奇侠传三 电视剧原声带 | 麦振鸿 |
| 246 | 时间都去哪儿了 | 听得到的时间 | 王铮亮 |
| 247 | 土耳其进行曲 | 土耳其进行曲 | Various Artists |
| 248 | That's Not My Name | That's Not My Name | The Ting Tings |
| 249 | The Mountain of Women | Song of the Irish Whistle | Joanie Madden |
| 250 | Hymn To The Sea | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 251 | Don't push me | Jade - silver edition | sweetbox |
| 252 | Just Give Me A Reason | The Truth About Love | P!nk Nate Ruess |
| 253 | いつも何度でも | Prime Selection | 宗次郎 |
| 254 | 光年之外 | 光年之外 | G.E.M.邓紫棋 |
| 255 | 差生 | 少年中国 | 李宇春 |
| 256 | 人民不需要自由 | 108个关键词（李志的自我修养2012年度汇报演出） | 李志 |
| 257 | Nocturne No. 2 in E Flat Major, Op. 9, No. 2 | The Chopin Collection: The Nocturnes | Arthur Rubinstein |
| 258 | 青花瓷 | 我很忙 | 周杰伦 |
| 259 | Beyond The Memory | Beyond The Memory | July |
| 260 | 十年 | 黑白灰 | 陈奕迅 |
| 261 | 送别 | 送别 | 朴树 |
| 262 | 曹操 | 曹操 | 林俊杰 |
| 263 | 一辈子的孤单 | 涩女郎 电视原声带 | 刘若英 |
| 264 | 黑板情书 | 黑板情书 | 后弦 |
| 265 | I can't let this go on any further | I can't let this go on any further | Savior |
| 266 | 因为爱情 | Stranger Under My Skin | 陈奕迅 王菲 |
| 267 | New Morning 清晨 | Mist | Bandari |
| 268 | Love the Way You Lie Part III (Original Demo) | Don't Look Down | Skylar Grey |
| 269 | 我从崖边跌落 | 算云烟 | 谢春花 |
| 270 | 往事只能回味 | 往事只能回味 | 岳云鹏 / 宋小宝 |
| 271 | 君が好きだと叫びたい~TV Version~（好想大声说爱你）-BAAD | Slam Dunk Complete Vocal Collection ~TV Version~ | BAAD |
| 272 | 我只在乎你-齐秦 | 柒年·七个音乐故事 | 齐秦 |
| 273 | それが大事（最重要的事） | それが大事 | 大事MANブラザーズバンド / 渡辺禎史 |
| 274 | Never An Absolution | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 275 | Rose | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 276 | Secrets | Secrets | OneRepublic |
| 277 | 突然的自我 | 忘情1015精选辑 | 伍佰 & China Blue |
| 278 | 赤木の不安-徳永暁人 | Slam Dunk Complete Vocal Collection ~TV Version~ | 徳永暁人 |
| 279 | 春风十里 | 所有的酒，都不如你 | 鹿先森乐队 |
| 280 | Roses and Gold | Dust Diaries | Robin Jackson |
| 281 | Yesterday Once More | Yesterday Once More | Carpenters |
| 282 | 星座书上 | 自定义 | 许嵩 |
| 283 | 粉末 | 粉末 | 李宇春 |
| 284 | 苏州城外的微笑 | 很有爱 | 后弦 |
| 285 | Hey Jude | It's a Battle | John Lennon / Paul McCartney / It's a Cover Up |
| 286 | 天下 | 明天过后 | 张杰 |
| 287 | Last Dance | 爱情的尽头 | 伍佰 & China Blue |
| 288 | Miss Misery | Good Will Hunting (Music from the Miramax Motion Picture) | Elliott Smith |
| 289 | 风继续吹 | 风继续吹 | 张国荣 |
| 290 | Rain after Summer | Rain after Summer | 羽肿 |
| 291 | 宝贝 (in the night) | Original | 张悬 |
| 292 | 不再犹豫 | Beyond The Stage | Beyond |
| 293 | Take a Bow | Good Girl Gone Bad | Rihanna |
| 294 | 泡沫 | Xposed | G.E.M.邓紫棋 |
| 295 | 夕焼けの歌（夕阳之歌） | Matchy Best | 近藤真彦 |
| 296 | 没有什么不同 | 我的歌声里 | 曲婉婷 |
| 297 | 夜太黑 | 夜太黑 | 林忆莲 |
| 298 | Rise - Epic Music | Rise - Epic Music | John Dreamer |
| 299 | 故乡的原风景 | 武侠音乐精装特辑 | 宗次郎 |
| 300 | 亲爱的那不是爱情 | Ang 5.0 | 张韶涵 |
| 301 | 红色高跟鞋 | 若你碰到他 | 蔡健雅 |
| 302 | The End of the World | The End of the World | Skeeter Davis |
| 303 | 怒放的生命 | 怒放的生命 | 汪峰 |
| 304 | 大约在冬季 | 冬雨 | 齐秦 |
| 305 | 喜欢你 | 喜欢你 | G.E.M. 邓紫棋 |
| 306 | 挪威的森林 | 爱情的尽头 | 伍佰 & China Blue |
| 307 | 本草纲目 | 依然范特西 | 周杰伦 |
| 308 | 小刀会序曲 | 武侠音乐系列之豪气中天 | 商易 / 夏飞云 / 上海民族乐团 |
| 309 | Nijamena | Nijamena | Anurag Kulkarni /Anup Rubens |
| 310 | 2 Soon | Not Thinking Bout 2morrow | Jon Young |
| 311 | 彩云追月 | Edell.Love | 爱戴 |
| 312 | 忧伤倒数 | 夫妻那些事 电视剧原声带 | 小昔米 |
| 313 | 爱情转移 | 认了吧 | 陈奕迅 |
| 314 | 阳光下的我们 | Say The Words | 曲婉婷 |
| 315 | 今天 | 真永远 | 刘德华 |
| 316 | 隐形的翅膀 | 潘朵拉 | 张韶涵 |
| 317 | 蝴蝶泉边 | 崽崽 | 黄雅莉 |
| 318 | Tassel | Dulcet Series spring special collection | Cymophane |
| 319 | 生如夏花 | 生如夏花 | 朴树 |
| 320 | Sugar | V | Maroon 5 |
| 321 | 七里香 | 七里香 | 周杰伦 |
| 322 | 辞·九门回忆 | 辞·九门回忆 | 冰幽 / 解忧草 |
| 323 | 庐州月 | 寻雾启示 | 许嵩 |
| 324 | Only Time | Only Time: The Collection (Box Set) | Enya |
| 325 | 香水有毒 (DJ版) | 香水有毒(宣传单曲) | 胡杨林 |
| 326 | 有何不可 | 自定义 | 许嵩 |
| 327 | 真的爱你 | BEYOND IV | Beyond |
| 328 | Remember The Time | The Ultimate Collection | Michael Jackson |
| 329 | 漫步人生路-刘惜君 | 惜 . 君 | 刘惜君 |
| 330 | 你的样子 | 一个人的样子 | 林志炫 |
| 331 | Teenage Dream | Teenage Dream | Katy Perry |
| 332 | 莫扎特：《小夜曲》第一乐章 | 2008-2011 演奏实况合集 | 中国国家交响乐团 |
| 333 | Loves Me Not | t.A.T.u. - The Best | t.A.T.u. |
| 334 | 幸せ（幸福）-中岛美雪 | Singles 2000 | 中島みゆき |
| 335 | 穿越时空的思念2 时代を超える想い2 | 映画“犬夜叉 时代を越える想い 音楽篇” | 和田薫 |
| 336 | 毕业说分手 | 毕业说分手 | 冰冰超人 |
| 337 | The South Wind | Song of the Irish Whistle | Joanie Madden |
| 338 | 所念皆星河 | 所念皆星河 | CMJ |
| 339 | 可能 | 可能 | 程响 |
| 340 | The Scientist | The Scientist | Coldplay |
| 341 | 大海 | 70老男孩 | 张雨生 |
| 342 | 八年的爱 | 八年的爱 | 冰冰超人 |
| 343 | 漫步人生路-邓丽君 | 邓丽君-传奇的诞生 | 邓丽君 |
| 344 | TiK ToK | Animal | Kesha |
| 345 | Underneath Your Clothes | Laundry Service | Shakira |
| 346 | My Heart Will Go On | My Love: Ultimate Essential Collection (North American Version) | Celine Dion |
| 347 | Rock House Jail | The Rock (Original Motion Picture Score) | Nick Glennie-Smith / Hans Zimmer / Harry Gregson-Williams |
| 348 | 我变了 我没变 | 我变了 我没变 | 杨宗纬 |
| 349 | Trip | Trip | Axero |
| 350 | 断桥残雪 | 断桥残雪 | 许嵩 |
| 351 | 春天里 | 信仰在空中飘扬 | 汪峰 |
| 352 | 未来へ (向着未来) | 長い間 ～キロロの森～ | Kiroro (キロロ) |
| 353 | What A Wonderful World | All Time Greatest Hits | Louis Armstrong |
| 354 | 光明 | 信仰在空中飘扬 | 汪峰 |
| 355 | 光辉岁月 | 光辉岁月 | Beyond |
| 356 | Rhythm Of The Rain | Let It Be Me | Jason Donovan |
| 357 | Five Hundred Miles (《醉乡民谣》电影主题曲|《一路繁花相送》电视剧插曲) | Inside Llewyn Davis: Original Soundtrack Recording | Justin Timberlake / Carey Mull |
| 358 | 关山酒-等什么君(邓寓君) | 关山酒 | 等什么君(邓寓君) |
| 359 | 画皮-刀郎 | 山歌寥哉 | 刀郎 |
| 360 | 21 Guns | 21st Century Breakdown | Green Day |
| 361 | The truth that you leave | The truth that you leave | Pianoboy高至豪 |
| 362 | 雨过天不晴 | 雨过天不晴 | 柯柯柯啊 |
| 363 | Snowdreams 雪之梦 | Rhine River | Bandari |
| 364 | Not a Single Day 하루도 | Rain's World (Special Edition) | Rain |
| 365 | Summer Vibe | Summer Vibe | Walk off the Earth |
| 366 | We Are One | Super Deluxe Sound I | Kelly Sweet |
| 367 | 北京北京 | 勇敢的心 | 汪峰 |
| 368 | Don't Wanna Know/We Don't Talk Anymore | Don't Wanna Know/We Don't Talk Anymore | Sam Tsui / Alex Blue |
| 369 | We Don't Talk Anymore | We Don't Talk Anymore | Alex Blue TJ Brown |
| 370 | Will and Elizabeth | Pirates of the Caribbean: The Curse of the Black Pearl | Klaus Badelt |
| 371 | You Got Me | Breakthrough | Colbie Caillat |
| 372 | Where Is the Love | Best of Both Worlds | Josh Vietti |
| 373 | Love Story | Women's Day 2019 | Taylor Swift |
| 374 | I Do | I Do | Colbie Caillat |
| 375 | BLUE | Blue Neighbourhood (Deluxe) | Troye Sivan Alex Hope |
| 376 | A Little Story | My View | Valentin |
| 377 | ひとり上手（习惯孤独） | 大吟醸 | 中島みゆき |
| 378 | Memories | 마녀유희 OST | 金有京 |
| 379 | MELANCHOLY | MELANCHOLY | White Cherry |
| 380 | Sundial Dreams | In the Enchanted Garden | Kevin Kern |
| 381 | If | 마녀유희 OST | 全慧彬 |
| 382 | 相思赋予谁 | 春生 | 好妹妹 |
| 383 | 画离弦 (柯柯吉他版) | 画离弦 | 柯柯柯啊 |
| 384 | 筝锋 | 功夫 电影原声大碟 | 黄英华 |
| 385 | Thinking Out Loud | NOW That's What I Call Music! 90 | Ed Sheeran |
| 386 | Righteous Path | Introducing Mellow | Blazo |
| 387 | Somebody That I Used To Know | Making Mirrors | Gotye Kimbra |
| 388 | Hard to Sleep | This Is What It Feels Like | Gracie Abrams |
| 389 | Aloha Heja He | Melancholie und Sturmflut (Bonus Tracks Edition) | Achim Reichel |
| 390 | Palace Memories | Sound. Earth. Nature. Spirit. - Vol. Sound | S.E.N.S. |
| 391 | 回家(萨克斯风) | 金耳朵Ⅲ | Kenny G |
| 392 | Breath and Life | The Platinum Series III: Eterna | Audiomachine |
| 393 | East of Eden | East of Eden | Zella Day |
| 394 | Carpe Diem | Dead Poets Society | Maurice Jarre |
| 395 | Beautiful In White (Demo) | Beautiful In White (Demo) | Shane Filan |
| 396 | 萱草花-张小斐 | 你好，李焕英 电影原声大碟 | 张小斐 |
| 397 | Keating's Triumph | Dead Poets Society | Maurice Jarre |
| 398 | Better Man | Sing When You're Winning | Robbie Williams |
| 399 | Love Me Like You Do | Delirium | Ellie Goulding |
| 400 | Summer | ENCORE | 久石譲 |
| 401 | Viva La Vida | Viva La Vida Or Death And All His Friends | Coldplay |
| 402 | 爱向着我来的那天 사랑아 내게 오기만 해 (PartⅠ) | 마녀유희 OST | Ashily |
| 403 | You're Beautiful | So Beautiful 1 | James Blunt |
| 404 | 思念是一种病 | OK | 张震岳 / 蔡健雅 |
| 405 | Careless Whisper-George Michael | Ladies And Gentlemen... The Best Of George Michael | George Michael |
| 406 | 难却 (DJ细霖版|待上浓妆好戏开场) | 难却 | 平生不晚 |
| 407 | Sunburst | Sunburst | Tobu / Itro |
| 408 | The Mass-Era | The Mass | Era |
| 409 | 精卫-30年前，50年后 | 丧失年轻，勿失年华 | 30年前，50年后 |
| 410 | Farewell to Camraw | When the Pipers Play | Black Kilts Berlin /Robert Mathieson |
| 411 | 想太多 | 想太多 | 李玖哲 |
| 412 | Booty Music | Git Fresh | Deep Side |
| 413 | Genie | THE BEST ~New Edition~ | 少女时代 |
| 414 | Caravan-a_hisa | Single Collection | a_hisa |
| 415 | 樱花草 | 花言乔语 (精装版) | Sweety |
| 416 | Girlfriend | The Best Damn Thing: Deluxe Edition | Avril Lavigne |
| 417 | 精卫-一颗狼星_许篮心 | 精卫（戏腔） | 一颗狼星_许篮心 |
| 418 | Remember The Name | Sampler Mixtape | Fort Minor |
| 419 | Right Here Waiting (Piano) | Right Here Waiting (Piano) | Basil Jose /Richard Marx |
| 420 | The Long Way Home | The Bright Side | Lenka |
| 421 | 单车恋人 | 9公主 | 后弦 |
| 422 | 愤怒的消失 그게 말이죠 | 마녀유희 OST | 木单车 |
| 423 | 西厢 | 古·玩 | 后弦 |
| 424 | Bye Bye Bye | Rising Love | Lovestoned |
| 425 | Star of the County Down | Musique Celtic | Rosheen |
| 426 | 一格格-卫兰 | 一格格 | 卫兰 |
| 427 | Main Title (The Godfather Waltz) | The Godfather I | Nino Rota |
| 428 | 命运的恶作剧 운명의 장난 | 마녀유희 OST | MC 真理 / 哈哈 |
| 429 | Far Away From Home | Greatest Hits | Groove Coverage |
| 430 | Damn You | The Unreleased Collection | Lana Del Rey |
| 431 | The Happy Troll (Griefing Theme Song)-D1ofaquavibe | The Happy Troll (Griefing Theme Song) | D1ofaquavibe |
| 432 | 乌兰巴托之夜-谭维维 | 高原之心 | 谭维维 |
| 433 | Love Yourself (Natio Remix) | Love Yourself (Natio Remix) | Natio / Justin Bieber / Conor Maynard |
| 434 | Red River Valley | Journey Home | Bronn Journey |
| 435 | 去年夏天 | 去年夏天 | 王大毛 |
| 436 | My Happy Ending | Under My Skin (Special Edition) | Avril Lavigne |
| 437 | 友谊之光 | 监狱风云 | 玛莉亚 |
| 438 | The Moon Represents My Heart | Love Ballads | Kenny G |
| 439 | Auld Lang Syne | The Greatest Gift | Charlie Landsborough |
| 440 | 口弦 | 听见凉山 电视剧原声带 | 赵艺涵 |
| 441 | 奇异恩典 | 最新热歌慢摇73 | Various Artists |
| 442 | Flower Dance | A Cup Of Coffee | DJ Okawari |
| 443 | Come And Get It | Chartsurfer Vol. 30 | Selena Gomez |
| 444 | Heartbeats | Swings and Roundabouts | Amy Deasismont |
| 445 | Hero | Hero | Enrique Iglesias |
| 446 | 风中有朵雨做的云-孟庭苇 | 风中有朵雨做的云 | 孟庭苇 |
| 447 | I Just Wanna Run | Take Action! Volume 9 | The Downtown Fiction |
| 448 | 莫失莫忘 | 仙剑奇侠传 电视原创配乐 | 麦振鸿 |
| 449 | I Want You to Know | I Want You to Know | Zedd / Selena Gomez |
| 450 | We Are Young | Dancing Bear Best Of 2012 International | Fun. Janelle Monáe |
| 451 | 罗刹海市-刀郎 | 山歌寥哉 | 刀郎 |
| 452 | The Day You Went Away | The Day You Went Away: The Best of M2M | M2M |
| 453 | Sleepyhead | Acoustic Daydreams | Galen Crew |
| 454 | Moon As My Heart | Harmonica Sound of Hong Kong | Robert Bonfiglio |
| 455 | Solstice-K-391 | Solstice | K-391 |
| 456 | 西海情歌-刀郎 | 刀郎Ⅲ | 刀郎 |
| 457 | 卡农D大调 | 胎教音乐 | 群星 |
| 458 | My Soul | Time... | July |
| 459 | Conquest of Paradise-Vangelis | 1492 - Conquest Of Paradise | Vangelis |
| 460 | 富士山下 | What's Going On…? | 陈奕迅 |
| 461 | New Soul | Irlande | Vox Angeli |
| 462 | 乌兰巴托的夜 (丹正母子版) | 乌兰巴托的夜 | 丹正母子 |
| 463 | If I Die Young | If I Die Young - Single | The Band Perry |
| 464 | The Godfather (Love Theme) | The Godfather I | Nino Rota |
| 465 | 原来你也在这里-周笔畅 | 原来你也在这里 | 周笔畅 |
| 466 | Hero's Theme-Steven Burke | Kameo: Elements of Power O.S.T | Steven Burke |
| 467 | My Love (Radio Edit) | Coast to Coast | Westlife |
| 468 | What Are Words | What Are Words | Chris Medina |
| 469 | Young For You | Young For You | GALA |
| 470 | The Ludlows | Legends Of The Fall Original Motion Picture Soundtrack | James Horner |
| 471 | 雪の華（雪之花）-中岛美嘉 | 雪の華 | 中島美嘉 |
| 472 | 让我欢喜让我忧-周华健 | 让我欢喜让我忧 | 周华健 |
| 473 | Pop Danthology 2012 | Pop Danthology | DJ Daniel Kim |
| 474 | 向云端-小霞&海洋Bo | 向云端 | 小霞 / 海洋Bo |
| 475 | 城南花已开 | 城南花已开 | 三亩地 |
| 476 | Paris | Paris | Else |
| 477 | 颠倒歌-刀郎 | 山歌寥哉 | 刀郎 |
| 478 | 花心 | Keep Wakin 1987-2002 周而复始 | 周华健 |
| 479 | 呼唤 오나라 I | 대장금 OST | 김지현 |
| 480 | 爱向着我来的那天2 사랑아 내게 오기만 해 (Part II) | 마녀유희 OST | Ashily |
| 481 | 再见 | 再见 | 张震岳 |
| 482 | 千千阙歌 | 千千阙歌 | 陈慧娴 |
| 483 | 萍聚 | 萍聚/珍重再见 | 李翊君 / 李富兴 |
| 484 | Kiss The Rain 비를 맞다 | The Best - Reminiscent 10th Anniversary | Yiruma |
| 485 | Runner | Runner | Dustin O'Halloran |
| 486 | This Is the Life | Weathered | Angie Miller |
| 487 | 从头再来 | 从头再来 | 刘欢 |
| 488 | Dead Poets Society (Finale) | Filmharmonic II | The Royal Philharmonic Orchestra Maurice Jarre |
| 489 | The sally gardens | Arias Ancora | Laure Green |
| 490 | Friendships-Pascal Letoublon | Friendships | Pascal Letoublon |
| 491 | 序曲：天地孤影任我行 | 东邪西毒(电影音乐) | 陈勋奇 |
| 492 | 送别 | 送别 | 韩红 |
| 493 | 安静 钢琴版 | 纯音乐流行歌曲钢琴版 | Paul Liu |
| 494 | Wrecking Ball | Wrecking Ball | Miley Cyrus |
| 495 | 是啊 그래 | 마녀유희 OST | 나창현 |
| 496 | Six Feet Under | Six Feet Under | Billie Eilish |
| 497 | 穿越时空的思念1 时代を超える想い1 | 映画“犬夜叉 时代を越える想い 音楽篇” | 和田薫 |
| 498 | 偷功 | 太极张三丰 电影原声带 | 胡伟立 |
| 499 | Umbrella | Now That's What I Call Music! 25 Years | Rihanna / Jay-Z |
| 500 | Waka Waka (Esto Es África) | Waka Waka (This Time For Africa) (The Official 2010 Fifa World Cup Song) | Shakira |
| 501 | In The End | In The End | Linkin Park |
| 502 | Monody | Monody | TheFatRat / Laura Brehm |
| 503 | The Show | The Show | Lenka |
| 504 | 野子 (Live) | 我是歌手第四季 第3期 | 苏运莹 |
| 505 | Gee | The First Mini Album Gee | 少女时代 (소녀시대) |
| 506 | Ship In The Sand | Dear Me, Look Up | Marble Sounds |
| 507 | Summertime Sadness | Summertime Sadness | Lana Del Rey |
| 508 | 慕情 (M-4) | 犬夜叉 音楽篇 | 和田薫 |
| 509 | 最浪漫的事-赵咏华&好妹妹 | 追梦人 | 赵咏华 / 好妹妹 |
| 510 | Honor (Main Title Theme from "The Pacific") | The Pacific (Music From the HBO Miniseries) | Hans Zimmer / Geoff Zanelli / Blake Neely |
| 511 | 花妖-刀郎 | 山歌寥哉 | 刀郎 |
| 512 | 乌兰巴托的夜-左小祖咒 | 美国 The U.S.A（电影原声配乐） | 左小祖咒 |
| 513 | I Love You (Remix) | I Love You | United Idol |
| 514 | 你还要我怎样 | 意外 | 薛之谦 |
| 515 | 发现爱 | 西界 | 林俊杰 / 金莎 |
| 516 | 桥边姑娘 | 桥边姑娘 | 海伦 |
| 517 | 犯错 | 犯错 | 顾峰 / 斯琴高丽 |
| 518 | 那年初夏 | 毕业了我们一无所有 | 任然 |
| 519 | 北京欢迎你 | 北京2008年奥运会歌曲专辑 | 群星 |
| 520 | Red River Valley | Cowboy Songs | Michael Martin Murphey |
| 521 | 500 Miles | Buck The Trend | Peter, Paul & Mary |
| 522 | 500 Miles | Christ Is My Hope | The Innocence Mission |
| 523 | 500 Miles | Let's Folk | The Brothers Four |
| 524 | 画离弦 (柯柯版) | 画离弦 | 柯柯柯啊 |
| 525 | Ferrari-Jayvine Ramma | Ferrari | Jayvine Ramma |
| 526 | Annie's Wonderland 安妮的仙境 | Wonderland | Bandari |
| 527 | 阿凡达与屌丝男 | 心花路放 电影原声带 | 许鹤缤 |
| 528 | 花 ~すべての人に心の花を~ (オリジナル・ヴァージョン) | ザ・ニュー・ベスト・オブ・喜納昌吉＆チャンプルース | 喜納昌吉 (きな しょうきち) |
| 529 | Skinny Love | Skinny Love | Birdy |
| 530 | 我的歌声里 | 我的歌声里 | 李代沫 |
| 531 | 情人 | 海阔天空 | Beyond |
| 532 | 给我一个吻-杨子姗 | 重返20岁 电影原声带 | 杨子姗 |
| 533 | 桔梗谣 | 노들강변 매화타령 민요 | 노들강변 매화타령 민요 |
| 534 | 为爱痴狂 | 《中国好声音》2012跨年演唱会 | 金志文 |
| 535 | Mariage d'amour | Lettre à ma Mère | Richard Clayderman |
| 536 | 世界第一等 | 世界第一等 | 浪哥 |
| 537 | Unable To Stay, Unwilling To Leave | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 538 | 带我到山顶 | 听见凉山 | 赵艺涵 |
| 539 | Baby | Baby | Justin Bieber / Ludacris |
| 540 | 春娇与志明 | 春娇与志明 | 街道办GDC /欧阳耀莹 |
| 541 | Nevada | Monstercat - Best of 2016 | Vicetone / Cozi Zuehlsdorff |
| 542 | 听妈妈的话 | 依然范特西 | 周杰伦 |
| 543 | Jambalaya | 不朽的声音(人生最难忘的歌) | Carpenters |
| 544 | 红尘情歌 | 情路无悔 | 高安 /黑鸭子组合 |
| 545 | 莉莉安-宋冬野 | 安和桥北 | 宋冬野 |
| 546 | Prendre sa main | Cri d'amour | Angel Lover |
| 547 | 安静 | 范特西 | 周杰伦 |
| 548 | 梦中蝶影 | 歌曲合辑 | 华语群星 |
| 549 | 姑娘我爱你 | 姑娘我爱你 | 索朗扎西 |
| 550 | 借我 | 算云烟 | 谢春花 |
| 551 | Always With Me | 幸福的味道 | 木村弓 / 奥户巴寿 |
| 552 | 총맞은것처럼 (像中枪一样)-白智英 | Sensibility | 白智英 (백지영) |
| 553 | 兰亭序 | 魔杰座 | 周杰伦 |
| 554 | The Red Sun | 20 Years of Achievement around the World | Richard Clayderman |
| 555 | 纯真年代 | 大小世界 | 爱朵女孩 |
| 556 | Vincent | Legendary Don McLean | Don McLean |
| 557 | 平凡之路 | 猎户星座 | 朴树 |
| 558 | 李白 | 模特 | 李荣浩 |
| 559 | You | YOU | Approaching Nirvana |
| 560 | Coming Home | Coming Home | Skylar Grey / Diddy-Dirty Money |
| 561 | Turnin' | Young Rising Sons | Young Rising Sons |
| 562 | 意外 | 意外 | 薛之谦 |
| 563 | Promise | Promise | sapientdream |
| 564 | 那些年 | 那些年，我们一起追的女孩 电影原声带 | 胡夏 |
| 565 | 有一种爱叫做放手 | 有一种爱叫做放手 | 阿木 |
| 566 | 童年 | 童年 | 北京天使合唱团 |
| 567 | Still D.R.E (Instrumental Version)-Dr. Dre Snoop Dogg | Still D.R.E. | Dr. Dre / Snoop Dogg |
| 568 | 赤伶(DJ版) | 赤伶 | DJ名龙 |
| 569 | 我最亲爱的 | 我的歌声里 | 李代沫 |
| 570 | April 四月之春 | Sunrise Hill | Bandari |
| 571 | Fight | Fight | BeatBrothers |
| 572 | 我希望 | 匆匆那年 电视原声带 | 杨玏 |
| 573 | 恋曲1990-高胜美 | 经典金选1 哭砂 | 高胜美 |
| 574 | 知道不知道 | Rene | 刘若英 |
| 575 | 花-喜納昌吉 | The Celebrations | 喜納昌吉 / チャンプルーズ |
| 576 | Don't Worry Be Happy | Pretty Donkey Girl | Holly Dolly |
| 577 | Say Hello | These Friends Of Mine | Rosie Thomas / Sufjan Stevens |
| 578 | 我记得 | 署前街少年 | 赵雷 |
| 579 | The Right Path | Age of Innocence (Original Soundtrack) | Thomas Greenberg |
| 580 | 相思 | 腔.调 | 毛阿敏 |
| 581 | Seven Lonely Days | Remember When? - 25 Golden Memories | Georgia Gibbs |
| 582 | 相对 | 子曰 第一册 | 子曰乐队 |
| 583 | Sally Gardens | Spring | The O'Neill Brothers |
| 584 | 2 Phút Hơn (KAIZ Remix) | 2 Phút Hơn (KAIZ Remix) | Pháo / KAIZ |
| 585 | Valder Fields | A Plea en Vendredi | Tamas Wells |
| 586 | 刚好遇见你 | 刚好遇见你 | 李玉刚 |
| 587 | Way Back then | 오징어게임 OST | 郑在日 (정재일) |
| 588 | 你的答案-阿冗 | 你的答案 | 阿冗 |
| 589 | Luv Letter | 髙橋大輔～フェイヴァリット・ミュージック～ | 神津裕之 |
| 590 | 海阔天空 | 一声所爱 大地飞歌（第九期） | 汪小敏 |
| 591 | 半妖-和田薫 | TVアニメーション「犬夜叉」オリジナルサウンドトラックアルバム「犬夜叉 音楽篇」 | 和田薫 |
| 592 | 男と女（男和女） | Standing Ovation | CHAGE and ASKA |
| 593 | 万水千山总是情 | 万水千山总是情 电视剧原声带 | 汪明荃 |
| 594 | 希望 | Grace & Charm | 陈慧琳 |
| 595 | Anak (remix: Freddie Aguilar|Remix) | 清尘 | 清尘 |
| 596 | Liability | Melodrama | Lorde |
| 597 | Never Say Good Bye | 마이걸 | Mario & Nesty (마리오&네스티) |
| 598 | 城府 | 自定义 | 许嵩 |
| 599 | Rompasso-Angetenar（DEITIES remix）-DEITIES Ghetto Artist | Angetenar (DEITIES Remix) | DEITIES / Ghetto Artist |
| 600 | All Falls Down | All Falls Down | Alan Walker / Noah Cyrus / Digital Farm Animals / Juliander |
| 601 | 梦中的婚礼 | Richard Clayderman | Richard Clayderman |
| 602 | Ferrari-Bebe Rexha | Expectations | Bebe Rexha |
| 603 | Faded | Faded | Alan Walker / Iselin Solheim |
| 604 | 被遗忘的时光-蔡琴 | 出塞曲 | 蔡琴 |
| 605 | Take It From Me | Say I Am You | The Weepies / Deb Talan / Steve Tannen |
| 606 | 鼓楼 | 无法长大 | 赵雷 |
| 607 | You Belong To Me | To You | Carla Bruni |
| 608 | 发如雪 | 十一月的萧邦 | 周杰伦 |
| 609 | Windy Hill（风之谷） | Windy Hill | 羽肿 |
| 610 | Bloom of Youth | クドわふたー オリジナル サウンドトラック | 清水淳一 |
| 611 | Your Man | Double Cream 5: 20 Years of Nashville #1's 1992-2012 | Josh Turner |
| 612 | 热爱105°C的你 | 热爱105°C的你 | 腾格尔 / 艾伦 / 沈腾 |
| 613 | Eventide | Eventide | Nylon |
| 614 | Because of You | Because Of You | Kelly Clarkson |
| 615 | Demons | Continued Silence EP | Imagine Dragons |
| 616 | Take Me To Church | Bravo Hits 86 | Hozier |
| 617 | Just One Last Dance (Album Version) | Key To My Soul | Sarah Connor /Marc Terenzi |
| 618 | Love The Way You Lie (Part III (Original Demo)) | Relaxing Acoustic | Skylar Grey |
| 619 | 老男孩 | 父亲 | 筷子兄弟 |
| 620 | 我是一只小小鸟 | 我是一只小小鸟 | 赵传 |
| 621 | 独家记忆 | 独家记忆 (Hong Kong Version) | 陈小春 |
| 622 | Be What You Wanna Be | Darin | Darin |
| 623 | 好久不见 | 认了吧 | 陈奕迅 |
| 624 | A Place Called You | Enchanted | Emma Stevens |
| 625 | Young And Beautiful | Triple J Hottest 100 Vol 21 | Lana Del Rey |
| 626 | 长路漫漫任我闯 | 林子祥精选之天长地久 | 林子祥 |
| 627 | Frail Love | Frail Love | Cloves |
| 628 | Scarborough Fair | The Very Best of Sarah Brightman 1990-2000 | Sarah Brightman |
| 629 | 从头再来 | 经典20年 珍藏锦集 | 刘欢 |
| 630 | 浮夸 | U-87 | 陈奕迅 |
| 631 | Asphyxia 窒息 | asphyxia | 逆时针向 |
| 632 | The Ocean (Radio Edit) | The Ocean | Mike Perry / SHY Martin |
| 633 | 乌兰巴托的夜-葱香科学家（王悠然） | 乌兰巴托的夜 | 葱香科学家（王悠然） |
| 634 | 听 | 拾 | 张杰 |
| 635 | Lonely | Nana | Nana |
| 636 | Unity | Sounds of Syndication, Vol .1 (Presented by Syndicate) | TheFatRat |
| 637 | Hey, Soul Sister | Save Me, San Francisco | Train |
| 638 | Waltz No.6 'Petit Chien' in D Flat Major Op.40-1 | 越听越聪明 1 | Classical Artists |
| 639 | Too Far | King in the Mirror | Anna F |
| 640 | Inspire | Serenity | Capo Productions |
| 641 | 让我偷偷看你 | 阿弥陀佛么么哒·一个孩子的心愿 | 赵雷 |
| 642 | 夜的钢琴曲五 | 夜的钢琴曲 Demo集 | 石进 |
| 643 | Sutter's Mill | The Music of Dan Fogelberg | Dan Fogelberg |
| 644 | Please Don't Go | Please Don't Go | Joel Adams |
| 645 | 曾经的你 | 每一刻都是崭新的 | 许巍 |
| 646 | Stay Here Forever | Valentine's Day OST | Jewel |
| 647 | 存在 | 生无所求 | 汪峰 |
| 648 | Stay Alive | The Secret Life Of Walter Mitty (Music From And Inspired By The Motion Picture) | José González |
| 649 | 我就喜欢你这样的丫头 | 匆匆那年 电视原声带 | 杜维瀚 |
| 650 | Everybody | Everybody | Ingrid Michaelson |
| 651 | 传奇 | 传奇 | 王菲 |
| 652 | 易燃易爆炸 | 如也 | 陈粒 |
| 653 | 飞向别人的床 | 飞向别人的床 | 沉珂（C.K）& 光光 |
| 654 | 赤伶 (弹唱版) | 赤伶 | 孙鹏凯 |
| 655 | Astronomia（黑人抬棺古风版） | 黑人抬棺古风版 | litterzy、水玥儿 |
| 656 | I Want My Tears Back | Imaginaerum | Nightwish |
| 657 | 红颜 | MuSiC混合体 | 胡彦斌 |
| 658 | 혼자시킨 사랑 独自的爱情 | 명랑소녀 성공기 OST | True Bird |
| 659 | 潮湿的心 | 蜕变1少女的心情故事 | 卓依婷 |
| 660 | brave heart | brave heart | 宮崎歩 |
| 661 | 明天过后 | 明天过后 | 张杰 |
| 662 | Love Theme | 명랑소녀 성공기 OST | 吴振宇 |
| 663 | Read My Mind | Jade | Sweetbox |
| 664 | Let It Out | Let It Out | Frances |
| 665 | Love Song | 명랑소녀 성공기 OST | 赵长赫 |
| 666 | 飞得更高 | 笑着哭 | 汪峰 |
| 667 | 花火 | 花火 | 汪峰 |
| 668 | 直到永远 | 生死不离 我们在一起 | 汪峰 |
| 669 | 跟往事干杯 | 不朽金曲精选 Ⅰ | 姜育恒 |
| 670 | 蓝莲花 | 时光.漫步 | 许巍 |
| 671 | 娃娃脸 | 娃娃脸 | 后弦 |
| 672 | 我爱你中国 | 怒放的生命 | 汪峰 |
| 673 | 星象仪 プラネタリウム | プラネタリウム | 大塚爱 |
| 674 | 推理(オリジナル・ヴァージョン)-大野克夫 | 「名探偵コナン」サントラ・スーパー・ベスト- (名侦探柯南) | 大野克夫 |
| 675 | 一直很安静 | 寂寞在唱歌 | 阿桑 |
| 676 | 生活不止眼前的苟且 | 生活不止眼前的苟且 | 许巍 |
| 677 | Mark's Theme-顾嘉辉 | 英雄本色1&2 | 顾嘉辉 |
| 678 | Tears Of A Clown | Mastercutor | U.D.O. |
| 679 | 運命のルーレット廻して (转动命运之轮) | 運命のルーレット廻して | ZARD (ザード) |
| 680 | The Dawn-Dreamtale | Beyond Reality (Japanese Edition) | Dreamtale |
| 681 | 兰亭序 (粤语版) (Single Version) | 兰亭序 | 王十三 |
| 682 | For Free | Folk For Kids | Lana Del Rey / Zella Day / Weyes Blood |
| 683 | My Destiny (我的命运) | 별에서 온 그대 OST Part 1 | LYn (린) |
| 684 | 亲爱的路人 | 亲爱的路人 | 刘若英 |
| 685 | 等不到的爱 | 裸婚时代 电视剧原声带 | 文章 |
| 686 | Call Me Maybe | Call Me Maybe | Carly Rae Jepsen |
| 687 | 花开在眼前 | 花开在眼前 | 韩磊 |
| 688 | 如果不能好好爱 | 如果不能好好爱 | 吴克群 |
| 689 | 童年 | 纵贯线演唱会 | 罗大佑、李宗盛、张震岳、周华健 |
| 690 | 魔訶不思議アドベンチャー! | ドラゴンボール全曲集 | 高橋洋樹 |
| 691 | 白羊座的忧伤-石进 | 夜的钢琴曲Ⅱ | 石进 |
| 692 | One Night In 北京 | SHIN 同名专辑 | 信乐团 |
| 693 | The Monster | The Monster | Eminem / Rihanna |
| 694 | Groundhog Day | Groundhog Day | Em Beihold |
| 695 | Amazing Grace 天赐恩宠 | 苏格兰音乐之旅 苏格兰风笛 | 群星 |
| 696 | 小仙女 | 武侠音乐系列之缠绵悱恻 （截取版） | 麦振鸿 |
| 697 | Élan | Élan | Nightwish |
| 698 | 爱你在心口难开-高胜美 | 怀念老歌七 | 高胜美 |
| 699 | The Hampster Dance Song-Hampton the Hampster | The Hamsterdance Album | Hampton the Hampster |
| 700 | Dans la maison (Thème)-Philippe Rombi | Dans la maison | Philippe Rombi |
| 701 | 「名探偵コナン」~メインテーマ-大野克夫 | 「名探偵コナン」メインテーマ | 大野克夫 |
| 702 | 万里の長城-太田美知彦 | 中華一番! スペシャルTVオンエアーミックス& ― オリジナル・サウンドトラック | 太田美知彦 |
| 703 | 喜剧之王 | 喜剧之王 | 李荣浩 |
| 704 | Tennessee-Hans Zimmer | Pearl Harbor [O.S.T] | Hans Zimmer |
| 705 | 浮沉的兄弟-戎祥 | 浮沉的兄弟 | 戎祥 |
| 706 | 幸せ（幸福）-小林幸子 | 小林幸子全曲集 2013 | 小林幸子 |
| 707 | Liekkas | Assogattis: By The Embers | Sofia Jannok |
| 708 | For the World-谭盾 | Late Night Tales: Air | 谭盾 |
| 709 | Scotland the Brave 苏格兰勇士 | 苏格兰音乐之旅 苏格兰风笛 | 群星 |
| 710 | 月牙湾 | 爱.歌姬 | F.I.R. |
| 711 | Gangsta Bop | Konvicted | Akon |
| 712 | Hallelujah | Warmer In The Winter (Deluxe Edition) | Lindsey Stirling |
| 713 | Nijamena (BGM版) | Nijamena | H2s |
| 714 | 二泉映月 | 阿炳全集 | 阿炳 |
| 715 | 男儿当自强 | 笑傲歌坛 传世经典 | 林子祥 |
| 716 | 上海滩 | 上海滩 | 叶丽仪 |
| 717 | 我和你 | 北京2008 奥运会、残奥会开闭幕式主题歌曲专辑 | 刘欢 / Sarah Brightman |
| 718 | 算你狠 | 绝对收藏 | 陈小春 |
| 719 | 黄种人 | 黄·锋 | 谢霆锋 |
| 720 | Croatian Rhapsody | The Piano Player | Maksim Mrvica |
| 721 | He's a Pirate | Pirates of the Caribbean: The Curse of the Black Pearl | Klaus Badelt |
| 722 | Natural-Imagine Dragons | Origins (Deluxe) | Imagine Dragons |
| 723 | 星月神话 | 女人又一次哭泣 | 金莎 |
| 724 | 夜上海 | 夜上海精选 | 周璇 |
| 725 | 带你去旅行 | 带你去旅行 | 校长（张驰） |
| 726 | 天下第一 | 武侠音乐系列之豪气中天 （截取版） | 麦振鸿 / 罗坚 |
| 727 | 给我一个吻-张露 | 群星会 38 张露 (珍藏系列) | 张露 |
| 728 | '97爱情宣言 | 狼 97黄金自选辑 | 齐秦 |
| 729 | 外面的世界 | 燃烧爱情（狼之旅） | 齐秦 |
| 730 | 小酒窝 | JJ陆 | 林俊杰 / 蔡卓妍 |
| 731 | Past Lives | Drowning | Slushii |
| 732 | 往事随风 | 痛并快乐着 | 齐秦 |
| 733 | Go Time | Go Time | Mark Petrie |
| 734 | Someone to Stay | Someone to Stay | Vancouver Sleep Clinic |
| 735 | The Portrait | Titanic: Special Edition | James Horner |
| 736 | 那年我双手插兜 不知道什么叫做对手 | 那年我双手插兜 不知道什么叫做对手（语录版） | 黑左 / 莎馬淑鳐 / 刘liu创意人 |
| 737 | 你还欠我一个拥抱 | 很有爱 | 后弦 / Sara |
| 738 | Strength of a Thousand Men | Archangel | Two Steps From Hell |
| 739 | 匆匆那年 | 匆匆那年 电影原声带 | 王菲 |
| 740 | 一路 | 匆匆那年 电视原声带 | 白敬亭 / 杨玏 / 杜维瀚 |
| 741 | Spirit of the Wild | Age of Wonders | BrunuhVille |
| 742 | 命运 운명 | 풀 하우스 OST (KBS 미니시리즈) | Why |
| 743 | 青い空に出逢えた(TV Mix) | 中華一番! スペシャルTVオンエアーミックス& ― オリジナル・サウンドトラック | 辻尾有紗 |
| 744 | 大海~ | Asia | THE JAYWALK |
| 745 | 热爱105°C的你 | 热爱105°C的你 | 阿肆 |
| 746 | Flavor Of Life | Flavor Of Life | 宇多田ヒカル |
| 747 | Death Of Titanic | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 748 | 最浪漫的事-赵咏华 | 我的爱我的梦我的家 | 赵咏华 |
| 749 | 孤勇者_凤凰传奇 | 孤勇者 | 凤凰传奇 |
| 750 | 不如不见 | What's Going On…? | 陈奕迅 |
| 751 | Distant Memories | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 752 | 偏爱 | 破天荒 | 张芸京 |
| 753 | Diamonds | Diamonds | Rihanna |
| 754 | 風の住む街（风居住的街道）-磯村由紀子 | 風の住む街 | 磯村由紀子 |
| 755 | Je m'appelle Hélène | Hélène | Hélène Rolles |
| 756 | 我欲成仙 | 西游记后传片头曲 | 刘欢 |
| 757 | 希望 (国语) | 我是阳光的 | 陈慧琳 |
| 758 | Something Just Like This | Something Just Like This | The Chainsmokers / Coldplay |
| 759 | Children of the Dark | Together Till the End | Mono Inc. / Joachim Witt / Tilo Wolff / Chris Harms |
| 760 | 極楽浄土 | 約束 -Promise code- | GARNiDELiA |
| 761 | 作曲家 | 李荣浩 | 李荣浩 |
| 762 | 辞九门回忆(DJ版) | 未知 | 未知 |
| 763 | 闯将令-香港中乐团 于会咏 胡登跳 | 功夫 电影原声大碟 | 香港中乐团 / 于会咏 / 胡登跳 |
| 764 | 黑暗中的舞者 | 寂静的天空 | 黛青塔娜 / HAYA乐团 |
| 765 | 銀の龍の背に乗って | 銀の龍の背に乗って | 中島みゆき |
| 766 | She Is My Sin-Nightwish | Tales from the Elvenpath | Nightwish |
| 767 | To Ramona | The Complete Album Collection Vol.1 | Bob Dylan |
| 768 | Azul | Acoustik Guitar | John H. Clarke |
| 769 | Opening | 少林足球 电影原声带 | 黄英华 |
| 770 | Feel Me-Selena Gomez | Feel Me | Selena Gomez |
| 771 | Hummell Gets The Rockets | The Rock (Original Motion Picture Score) | Nick Glennie-Smith /Harry Gregson-Williams |
| 772 | 星の下での邂逅-赵大鼾 | 星の下での邂逅 | 赵大鼾 |
| 773 | Impossible-Two Steps From Hell | Unleashed | Two Steps From Hell |
| 774 | Love From Me-Johnson Rodgie | Love From Me | Johnson Rodgie |
| 775 | 猜不透 | 我爱上的 | 丁当 |
| 776 | Samba-Ludovico Einaudi | I Giorni | Ludovico Einaudi |
| 777 | Håll Om Mig-Nanne Grönvall | Melodifestivalen 1958-2013 | Nanne Grönvall |
| 778 | 难却 | 难却 | 平生不晚 |
| 779 | Old Threads-Deep East Music | Vintage Sunshine | Deep East Music |
| 780 | 萤火之森-CMJ | 萤火之森 | CMJ |
| 781 | 万疆-李玉刚 | 万疆 | 李玉刚 |
| 782 | Opening Credits-Hans Zimmer | Call of Duty: Modern Warfare 2 OST | Hans Zimmer |
| 783 | Samsara-Tungevaag & Raaban | Club Sounds Vol.73 | Tungevaag & Raaban |
| 784 | The X-Files (Original Version)-Mark Snow | The X Files? | Mark Snow |
| 785 | BOOM-Tiësto / Sevenn | BOOM | Tiësto / Sevenn |
| 786 | 初识太极 | 太极张三丰 电影原声带 | 胡伟立 |
| 787 | At Anchor | The Airship | Port Blue |
| 788 | 难却 (DJ版0.85x|待上浓妆好戏开场) | 难却 | 平生不晚 |
| 789 | Special Ops-Silver Screen | Under Siege | Silver Screen |
| 790 | Frontier-Doctor Vox | Level Up | Doctor Vox |
| 791 | Electric Romeo | Themes for Orchestra and Choir 2 - Abbey Road | Immediate Music |
| 792 | 賭神 | 赌神 电影原声 | 卢冠廷 |
| 793 | Time (Official)-MKJ | Time After Time | MKJ |
| 794 | The Next Episode | The Next Episode | Dr. Dre / Snoop Dogg / Kurupt / Nate Dogg |
| 795 | Italia e voi（Orginal Mix）-HSHK | Italia e voi | HSHK / 贰皮 / VodKa / Pnan |
| 796 | かごめと犬夜叉 | TVアニメーション「犬夜叉」オリジナルサウンドトラックアルバム「犬夜叉 音楽篇」 | 和田薫 |
| 797 | 비오는 소리 (Intro)下雨的声音-July | To Heaven | July |
| 798 | アシタカせっ記 (The Legend of Ashitaka)-久石让 | もののけ姫 イメージアルバム | 久石让 (ひさいし じょう) |
| 799 | Run Me Out-Zola Jesus | How to Get Away with Murder | Zola Jesus |
| 800 | Pilgrimage-Jannik | Pilgrimage Epic Orchestral | Jannik |
| 801 | We No Speak Americano(UK Radio Edit)-Yolanda Be Cool | We No Speak Americano | Yolanda Be Cool |
| 802 | Deflagration-Silver Screen | Under Siege | Silver Screen |
| 803 | The Boys | 'The Boys' The 3rd Album | 少女时代 |
| 804 | Wicked Wonderland (Radio Edit)-Martin Tungevaag | Wicked Wonderland | Martin Tungevaag |
| 805 | 幽默-胡伟立 | 九品芝麻官之白面包青天 电影原声 | 胡伟立 |
| 806 | Alone-Alan Walker | Alone | Alan Walker |
| 807 | Time Back-Bad Style | 最新热歌慢摇63 | Bad Style |
| 808 | Numb Encore | Look Out For Detox | Dr. Dre / 50 Cent / JAY-Z / Eminem / Linkin Park |
| 809 | Star Sky-Two Steps From Hell | Battlecry | Two Steps From Hell |
| 810 | Oceanside | Melody Lane | Lainey Lou |
| 811 | One Day In Spring | One Day In Spring | Bandari |
| 812 | Deadwood-Really Slow Motion | Deadwood | Really Slow Motion |
| 813 | Promises | Promises | Ryn Weaver |
| 814 | 我知道-By2 | Twins | By2 |
| 815 | Between Worlds | X I I | Roger Subirana |
| 816 | Dream It Possible | Dream It Possible | Delacey |
| 817 | 桔梗谣-金栄実 | 伽倻琴演奏《与你一起》 | 金栄実 |
| 818 | 桔梗谣-이금미 | Korea: Folk Songs I - Songs Of Kyonggido District | 이금미 |
| 819 | Simon Birch | The Bucket List (Original Motion Picture Soundtrack) | Marc Shaiman |
| 820 | Firework | Teenage Dream | Katy Perry |
| 821 | Everything at Once | Two | Lenka |
| 822 | 口弦-妙子 | 独家爱唱Ⅲ | 妙子 |
| 823 | Murder In My Mind-Kordhell | Murder In My Mind | Kordhell |
| 824 | Once Upon a Time in America: Deborah's Theme-Ennio Morricone | The Grandmaster (Original Score) | Ennio Morricone |
| 825 | Morsmordre-Crazy Donkey | Morsmordre | Crazy Donkey |
| 826 | 旅行的意义(TRAVEL IS MEANINGFUL) | 渺渺 电影原声 | 陈绮贞 |
| 827 | 空 (TV Mix) | 中華一番! スペシャルTVオンエアーミックス& ― オリジナル・サウンドトラック | 大黒摩季 |
| 828 | 模特 | 模特 | 李荣浩 |
| 829 | FourFiveSeconds | FourFiveSeconds | Rihanna / Kanye West / Paul McCartney |
| 830 | 风居住的街道（Piano ver） (翻自 磯村由紀子）-饭碗的彼岸 | Piano Cover | 饭碗的彼岸 |
| 831 | 爱转角 | Best Show | 罗志祥 |
| 832 | Take Me Home Country Roads-John Denver | Take Me Home: The John Denver Story | John Denver |
| 833 | Maps | Maps | Maroon 5 |
| 834 | 半生雪-七叔-叶泽浩 | 半生雪 | 七叔-叶泽浩 |
| 835 | MR.TAXI(Korean ver.) | 'The Boys' The 3rd Album | 少女时代 |
| 836 | Gentle-Isaac Shepard | Deep Joy | Isaac Shepard |
| 837 | 故人泪-麦小兜 | 故人泪 | 麦小兜 |
| 838 | May It Be-Bandari | MistyLand | Bandari |
| 839 | 赤伶-李玉刚 | 赤伶 | 李玉刚 |
| 840 | My Songs Know What You Did In The Dark (Light Em Up) (2 Chainz Remix) | My Songs Know What You Did In The Dark (Light Em Up) | Fall Out Boy |
| 841 | River Flows In You | Tales Of Dusk And Dawn Chapter II | Various Artists |
| 842 | Roar | Roar | Katy Perry |
| 843 | Just Blue-Space | Just Blue | Space |
| 844 | Secrets AMFB Onerepublic | Time Machine (Part 1) | Bryson Andres |
| 845 | The Telephone Box | The Magic Empire | Uniform Motion |
| 846 | Sunrise | waiting for the light | Catie Mckinney |
| 847 | 映山红-刀郎 | 红色经典 | 刀郎 |
| 848 | Liberators-Epic Score | Vengeance - ES033 | Epic Score |
| 849 | Dismantle-Peter Sandberg | Dismantle | Peter Sandberg |
| 850 | Radius-Hi-Finesse | Axiom | Hi-Finesse |
| 851 | The Final Countdown | The Final Countdown: The Best Of Europe | Europe |
| 852 | Hyacinth-July | In Love | July |
| 853 | One More Light(又一道光芒)-Linkin Park | One More Light | Linkin Park |
| 854 | 敢问路在何方-刀郎 | 电视剧新西游记主题曲 | 刀郎 |
| 855 | 时を越えて かごめ | 犬夜叉 音楽撰集 | 和田薫 |
| 856 | The Party Troll-D1ofaquavibe | The Party Troll | D1ofaquavibe |
| 857 | Novera-Dark Winter Music | Epic World Volume2 Return 归来(2014) | Dark Winter Music |
| 858 | SCARSONG-flash8 | 最新热歌慢摇3 | flash8 |
| 859 | Concerto No. 4 in F minor, Op. 8, RV 297, "L'inverno" (Winter): II. Largo | The Four Seasons: The Vivaldi Album | Anne Akiko Meyers / English Chamber Orchestra / David Lockington |
| 860 | Somewhere | Somewhere | July |
| 861 | If We Ever Broke Up-Mae Stephens | If We Ever Broke Up | Mae Stephens |
| 862 | Close Eyes (Slowed + Reverb)-DVRST | Close Eyes (Slowed + Reverb) | DVRST |
| 863 | Future Funk-Varien | Pick Your Poison Vol. 01 | Varien |
| 864 | Balenciaga-T3nzu | Balenciaga | T3nzu |
| 865 | A Quiet Departure-Josh Leake | Benjamin | Josh Leake |
| 866 | A Mozart Reincarnated-Ennio Morricone | La Leggenda del Pianista Sull'oceano | Ennio Morricone |
| 867 | Best Moments (feat. Kondor)-Blazo | Alone Journey | Blazo |
| 868 | Becoming a Legend-John Dreamer | Becoming a Legend - Single | John Dreamer |
| 869 | Beloved-Dan Gibson | Native Harmony | Dan Gibson |
| 870 | Brotherhood-John Dreamer | Brotherhood | John Dreamer |
| 871 | Hello Zepp-Charlie Clouser | Saw (Original Motion Picture Soundtrack) | Charlie Clouser |
| 872 | RAVE-Dxrk ダーク | RAVE | Dxrk ダーク |
| 873 | Golden Key-Isgaard | Golden Key [#2] | Isgaard |
| 874 | Eye of the Tiger-Survivor | Eye Of The Tiger | Survivor |
| 875 | golden hour-JVKE | this is what ____ feels like (Vol. 1-4) | JVKE |
| 876 | The Black Rose-Joanie Madden | Celtic Twilight 2 | Joanie Madden |
| 877 | My Sunset (Original Mix)-Feint | Feint EP2 | Feint |
| 878 | 雨空-α·Pav | Colors | α·Pav |
| 879 | Tuesday-Burak Yeter Danelle | Dance 2017 - Armada Music | Burak Yeter / Danelle |
| 880 | Welcome to Jurassic World(电影《侏罗纪世界》配乐)-Michael Giacchino | Jurassic World (Original Motion Picture Soundtrack)- (侏罗纪世界) | Michael Giacchino |
| 881 | PDD洪荒之力-Hoaprox | #Lov3 #Ngẫu Hứng | Hoaprox |
| 882 | 告白之夜（纯音乐）-CMJ | 告白の夜 | CMJ |
| 883 | You-Approaching Nirvana | Blocking the Sky Redux | Approaching Nirvana |
| 884 | Whisper Of Hope (Main)-Gothic Storm | Epic Emotional Piano | Gothic Storm |
| 885 | The Imperial March(帝国进行曲)-John Williams | Music from the Star Wars Saga- (星球大战) | John Williams |
| 886 | Young Hearts-Dirk Reichardt | Kokowääh 2 (Original Motion Picture Soundtrack) | Dirk Reichardt |
| 887 | James Bond Theme-John Barry Monty Norman | Dr. No (Original Motion Picture Soundtrack) | John Barry / Monty Norman |
| 888 | メインテーマ「永遠の一瞬」（主题「永恒的一瞬」）-伊藤賢治 | この青空に約束をー~ようこそつぐみ寮へ~Piano Stories | 伊藤賢治 |
| 889 | 潮鳴り-折戸伸治 | CLANNAD ORIGINAL SOUNDTRACK | 折戸伸治 |
| 890 | The Pink Panther Theme-Henry Mancini | In the Pink | Henry Mancini |
| 891 | 白いスーツのテーマ(白色西装主题曲)-市川淳 | TBS系 金曜ドラマ うぬぼれ刑事 オリジナル・サウンドトラック | 市川淳 |
| 892 | 穿越时空的爱恋-CMJ | 穿越时空的爱恋 | CMJ |
| 893 | Dusk Till Dawn | Piano Acoustic Covers Vol 2 | Kurt Hugo Schneider / Kirsten Collins / Blake Rose |
| 894 | Dreamland-Liquid Mind | Liquid Mind XI: Deep Sleep | Liquid Mind |
| 895 | Criminals-F.O.O.L | Revenger | F.O.O.L |
| 896 | P.I.M.P-TangTian | P.I.M.P | TangTian |
| 897 | 平凡的一天-毛不易 | 平凡的一天 | 毛不易 |
| 898 | 流浪者之歌-Budapest Festival Orchestra 诹访内晶子 | 惠威试音专用Ⅱ | Budapest Festival Orchestra / 诹访内晶子 |
| 899 | 恨爱交加-麦振鸿 | 天地传说之创世纪乐章 | 麦振鸿 |
| 900 | 高山流水-王昌元 | 中国古筝名家名曲——中国民族器乐精品系列 | 王昌元 |
| 901 | 美丽拍挡-胡伟立 | 国产凌凌漆 | 胡伟立 |
| 902 | Polska-Sava | Aire | Sava |
| 903 | 金三角 (恐怖纯音乐) | 金三角（恐怖纯音乐） | R̶ᴇ̶ɢ̶ʀ̶ᴇ̶ᴛ̶. |
| 904 | sans.-Toby Fox | UNDERTALE Soundtrack | Toby Fox |
| 905 | 夏夜-四季音色 | 春夏之交，轻旋淡律 | 四季音色 |
| 906 | 人形の館-岩崎琢 | 黒執事 サウンドコンプリート BLACK BOX | 岩崎琢 |
| 907 | Single Ladies (Put a Ring on It)-Beyoncé | Single Ladies (Put A Ring On It) - Dance Remixes | Beyoncé |
| 908 | 十面埋伏(琵琶独奏)-群星 | 中国古典音乐历朝黄金年鉴 | 群星 |
| 909 | 她的微笑 (original Mix)-阳山伟伟 | 她的微笑 (original Mix) | 阳山伟伟 |
| 910 | 西楼别序-尹昔眠 / 小田音乐社 | 西楼别序 | 尹昔眠 / 小田音乐社 |
| 911 | 青天-胡伟立 | 九品芝麻官之白面包青天 电影原声 | 胡伟立 |
| 912 | 青空-Candy_Wind | 拂晓车站 | Candy_Wind |
| 913 | 勇往直前-胡伟立 | 唐伯虎点秋香 | 胡伟立 |
| 914 | 执迷不悟-铁脑袋mp3 | 执迷不悟 | 铁脑袋mp3 |
| 915 | 小心な侵入者-根岸貴幸 | カードキャプターさくら オリジナル・サウンドトラック4 | 根岸貴幸 |
| 916 | 小鱼儿与花无缺片头音乐-麦振鸿 | 武侠音乐系列之豪气中天 （截取版） | 麦振鸿 |
| 917 | 雨的舞步-赵大鼾 | 雨的舞步 | 赵大鼾 |
| 918 | Lost Love (Instrumental)-Lunnna Janey杰尼 | Memories | Lunnna / Janey杰尼 |
| 919 | Theme from Mission: Impossible-Danny Elfman | Mission Impossible [Original Score] | Danny Elfman |
| 920 | Theme From Jurassic Park (From "Jurassic Park" Soundtrack)-John Williams | Jurassic Park (Soundtrack) | John Williams |
