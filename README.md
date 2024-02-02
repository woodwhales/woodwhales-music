# woodwhales-music

[![](https://img.shields.io/badge/author-woodwhales-green.svg)](https://music.icoders.cn) ![](https://img.shields.io/badge/license-GPL%203.0-orange.svg)

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

> 配置文件使用 yml 语法

**文件位置**

- 默认环境：[woodwhales-music/src/main/resources/dev/application.yml](https://github.com/woodwhales/woodwhales-music/blob/master/src/main/resources/application.yml)
- dev 环境：[woodwhales-music/src/main/resources/dev/application-dev.yml](https://github.com/woodwhales/woodwhales-music/blob/master/src/main/resources/dev/application-dev.yml)

**环境配置**

举例，配置生产环境 `prod` 配置文件：

1. 在 woodwhales-music/src/main/resources/ 下创建以文件夹，名称为：prod

2. 在 prod 文件夹下，创建 application-prod.yml 配置文件

3. 在 pom 配置文件中，配置 profiles 节点：

    ```XML
    <profiles>
        <profile>
            <id>prod</id>
            <properties>
                <profiles.active>prod</profiles.active>
            </properties>
        </profile>
    </profiles>
    ```

 4. 使用 maven 命令打包工程时，-P 参数指定 `prod` 环境参数

    ```shell
    mvn install -Pprod
    ```

**文件说明**

- 后台系统账号、密码

    - 后台系统账号：`system.username`
    - 后台系统密码：`system.password`

    ```yaml
    system:
      # 后台系统账号
      username: xxx
      # 后台系统密码
      password: xxx
    ```

    开发者可以使用 [org.woodwhales.music.security.PasswordTest#test](https://github.com/woodwhales/woodwhales-music/blob/master/src/test/java/org/woodwhales/music/security/PasswordTest.java#L14) 单元测试代码，生成自定义的后台系统账号和密码

- GitHub Corners

    - 是否展示 GitHub Corners：`github.show`
    - github 链接：`github.url`

    ```yaml
    github:
      # 是否展示 GitHub Corners
      show: true
      # github 链接
      url: "https://github.com/woodwhales/woodwhales-music"
    ```

- 版权信息

    - 作者名称：`author.name`
    - 作者网站：`author.website`

    ```yaml
    author:
      # 作者名称
      name: "woodwhales"
      # 作者网站
      website: "https://www.woodwhales.cn"
    ```

- 音乐链接来源

    - 首页展示的音乐链接来源：`music.link.source`

    ```yaml
    music:
      link:
        # 链接来源：0-github，1-alist
        source: 1
    ```
- 音乐网站首页

    - 音乐网站首页：`music.site`，用于后台 banner 快捷跳转至网站首页

    ```yaml
    music:
      # 音乐网站首页
      site: "https://music.icoders.cn/"
    ```

### 1.2 编译打包

执行 mvn 命令打包：

```shell
mvn clean install -Pdev
```

上述 -P 表示打包 dev 环境参数配置文件。

目前项目中的 pom.xml 配置文件中只指定了 dev 和 prod，开发者可根据需要指定其他环境参数：

> 如果配置生产环境，则需要在 [woodwhales-music/src/main/resources/](https://github.com/woodwhales/woodwhales-music/tree/master/src/main/resources) 中创建 prod 文件夹，并创建 application-prod.yml 配置文件，打包时 -P 参数指定为：prod

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

### 3.6.2

- 重构后台页面头
- 后台页面头增加跳转前台页面链接

### 3.6.1

- 后台音乐列表支持可排序列：排序、创建时间、更新时间
- 首页增加增加 GitHub Corners，可以通过 application.yml 自定义配置：是否展示，github 链接
- 修复开发环境后台列表查询数据接口响应失败

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

已收录 989 首音乐

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
| 73 | 阿珍爱上了阿强-五条人 | 梦幻丽莎发廊 | 五条人 |
| 74 | Almost Lover | Almost Lover | A Fine Frenzy |
| 75 | Down By The Salley Gardens | camomile | 藤田恵美 (ふじた えみ) |
| 76 | With An Orchid | If I Could Tell You | Yanni |
| 77 | 宝贝 (in a day) | Original | 张悬 |
| 78 | 这世界那么多人 | 这世界那么多人 | 莫文蔚 |
| 79 | 明天你是否依然爱我 | 其实你不懂我的心 | 童安格 |
| 80 | 爱如潮水 | 张信哲精选 | 张信哲 |
| 81 | 7 Years | The Young Pope (Original Series Sountrack) | Lukas Graham |
| 82 | The Sound of Silence (Reprise) | The Graduate | Simon & Garfunkel |
| 83 | BINGBIAN病变 (女声版) | BINGBIAN病变 (女声版) | 鞠文娴 |
| 84 | Don't You Remember | 21 | Adele |
| 85 | かごめと犬夜叉 (M-11+6) | 犬夜叉 音楽篇 | 和田薫 |
| 86 | 吉姆餐厅 | 吉姆餐厅 | 赵雷 |
| 87 | 很爱很爱你 | 很爱很爱你 | 刘若英 |
| 88 | 我们的时光 | 吉姆餐厅 | 赵雷 |
| 89 | Women of Ireland | Song of the Irish Whistle | Joanie Madden |
| 90 | Traveling Light | Traveling Light | Joel Hanson |
| 91 | 醉赤壁 | JJ陆 | 林俊杰 |
| 92 | 笑看风云 (Live) | 汪小敏 笑看风云 | 汪小敏 |
| 93 | 再度重相逢 | 泪桥 | 伍佰 & China Blue |
| 94 | The Way Of Life | 오! 필승 봉순영 OST | 吴硕浚 |
| 95 | 世界这么大还是遇见你 (清新的小女孩（中文版）) | 清新的小女孩（中文版） | 程响 |
| 96 | The Sounds Of Silence 寂静之音 | Silence With Sound From Nature | Bandari |
| 97 | 夏日漱石 (Summer Cozy Rock) | 浪潮上岸 (Tears In Ocean) | 橘子海 (Orange Ocean) |
| 98 | Chasing Pavements | Chasing Pavements | Adele |
| 99 | Right Here Waiting | Ballads | Richard Marx |
| 100 | ル一ジユ（口红）-中岛美雪 | 美雪集-原曲流行极品 | 中島みゆき |
| 101 | 成都 | 成都 | 赵雷 |
| 102 | Faidherbe square (instrumental) | Curses from past times | ProleteR |
| 103 | Easy Breeze | Something Simple | Thomas Greenberg |
| 104 | Spring In My Step | Spring In My Step | Silent Partner |
| 105 | Free Loop | Cf, Movie & Drama Hits 广告，开麦拉！ | Daniel Powter |
| 106 | 世界が終るまでは･･･ (直到世界尽头) | 世界が終るまでは･･･ | WANDS (ワンズ) |
| 107 | I Could Be The One | Acoustic | Donna Lewis |
| 108 | 不让我的眼泪陪我过夜 | 丝路 | 齐秦 |
| 109 | Unchained Melody | Ghost | Alex North |
| 110 | Let Her Go | All The Little Lights | Passenger |
| 111 | Jar Of Love | Everything In The World (白金庆功版) | 曲婉婷 |
| 112 | 菊花爆满山 | 菊花爆满山 | 马博 |
| 113 | John of the Glen | Song of the Irish Whistle 2 | Joanie Madden |
| 114 | Illusionary Daytime（幻昼）-Shirfine | Endless Daydream | Shirfine |
| 115 | 青丝 | 青丝（完整版） | 等什么君(邓寓君) |
| 116 | Marry You | Now Los Mejores Exitos Del Ano 2012 | Bruno Mars |
| 117 | Seve | Seve | Tez Cadey |
| 118 | 似水流年 | Salute | 张国荣 |
| 119 | Rolling In The Deep | Rolling In The Deep | Adele |
| 120 | 喜欢你 | Beyond 25th Anniversary | Beyond |
| 121 | 我只在乎你 | 我只在乎你 | 邓丽君 |
| 122 | Coachella - Woodstock In My Mind | Lust For Life | Lana Del Rey |
| 123 | 辞九门回忆 | 辞九门回忆 | 等什么君(邓寓君) |
| 124 | 海阔天空 | 乐与怒 | Beyond |
| 125 | 傲气傲笑万重浪 | 黄飞鸿系列电影原声精装版 | 黄霑 |
| 126 | 倩女幽魂 | Ultimate | 张国荣 |
| 127 | Angolan Women | Life In a Day (O.S.T) | The Three Angolan Women |
| 128 | 清明雨上 | 自定义 | 许嵩 |
| 129 | Last Dance (Live)-五条人 | 乐队的夏天2 第7期 | 五条人 |
| 130 | A Day In The Life (Remastered)-The Beatles | Sgt. Pepper's Lonely Hearts Club Band (Remastered) | The Beatles |
| 131 | That Girl | 24 HRS (Deluxe) | Olly Murs |
| 132 | Set Fire to the Rain | 21 | Adele |
| 133 | 小情歌 | 小宇宙 | 苏打绿 |
| 134 | 阳光总在风雨后 | 都是夜归人 | 许美静 |
| 135 | Day by Day | 마녀유희 OST | 赵冠宇 |
| 136 | The Sound of Silence (Album Version) | Forever Friends 'Just For You' | Simon & Garfunkel |
| 137 | Refrain | Eternal Light | 阿南亮子 (あなん りょうこ) |
| 138 | 盛夏的果实 | 莫后年代 莫文蔚20周年世纪典藏 | 莫文蔚 |
| 139 | 若把你 | 若把你 | Kirsty刘瑾睿 |
| 140 | Dark Paradise | Born To Die (Deluxe Version) | Lana Del Rey |
| 141 | Dirty Paws | Summer Acoustic | Of Monsters And Men |
| 142 | Miracle In The Middle Of My Heart (Original Mix) | Miracle In The Middle Of My Heart (Original Mix) | Clément Bcx |
| 143 | 老朋友 | 老朋友 | 杨尘,王旭(旭日阳刚) |
| 144 | Whistle | Glee: The Music - The Complete Season Four | Glee Cast |
| 145 | She | 7 Years and 50 Days | Groove Coverage |
| 146 | 十月：我和曾经的我们 | 迷藏 | 钟城 / 姚望 |
| 147 | Stronger | Kids Top 20 - De Grootste Hits Van 2013 - Summer Edition 2013 | Kelly Clarkson |
| 148 | A Penny At A Time | Life In A Day OST | Matthew Herbert |
| 149 | The Immigrant | Song of the Irish Whistle | Joanie Madden |
| 150 | 家族の风景 | 虹の歌集 | 手嶌葵 |
| 151 | 爱拼才会赢 | 爱拼才会赢 | 叶启田 |
| 152 | 我只在乎你-刘惜君 | 惜 . 君 | 刘惜君 |
| 153 | 单身情歌 | 单身情歌．超炫精选 | 林志炫 |
| 154 | 丑八怪 | 意外 | 薛之谦 |
| 155 | 沧海一声笑 | 沧海一声笑 | 许冠杰 |
| 156 | 桔梗谣 | 桔梗谣 | 阿里郎 |
| 157 | Intro | xx | The xx |
| 158 | Need You Now | iTunes Session | Lady A |
| 159 | 父亲 | 父亲 | 筷子兄弟 |
| 160 | 桔梗谣 | 织谣 | 斯琴格日乐 |
| 161 | 姑娘在远方 | 姑娘在远方 | 柯柯柯啊 |
| 162 | 湘江中路-庄达菲 | 湘江中路 | 庄达菲 |
| 163 | 夜空中最亮的星 | 世界 | 逃跑计划 |
| 164 | 般若波罗蜜多心经 | 《大唐玄奘》电影片尾曲 | 王菲 |
| 165 | 彩云之南 | 彩云之南 | 徐千雅 |
| 166 | 合肥的石头 | 赤脚青春 | 飘乐队 |
| 167 | 似夜流月 | 热门华语234 | 宗次郎 (そうじろう) |
| 168 | 北国之春 (日文版)-邓丽君 | 邓丽君15周年但愿人长久 | 邓丽君 |
| 169 | A Day in the Life-John Lennon | Imagine: John Lennon | John Lennon |
| 170 | Caribbean Blue 加勒比海蓝 | Moonlight Bay | Bandari |
| 171 | Five hundred miles | America, Vol. 10: Country - The Folk Revival Revolution | The Journeymen |
| 172 | Right Now (Na Na Na) | Right Now (Na Na Na) | Akon |
| 173 | Victory | Battlecry | Two Steps From Hell |
| 174 | 桔梗谣(道拉基) (朝鲜民谣) | 恋恋金达莱 | 蒋薇 |
| 175 | Down By the Salley Gardens | Song of the Irish Whistle | Joanie Madden |
| 176 | 追梦人 | 浮世情怀 | 凤飞飞 |
| 177 | 小鱼儿的思绪 | 武侠音乐系列第二部之思情篇（截取版） | 麦振鸿 |
| 178 | 故乡 | 我只有两天.许巍精选 | 许巍 |
| 179 | Bubbly | So Fresh - The Hits Of Autumn 2008 | Colbie Caillat |
| 180 | 勇敢的心 | 勇敢的心 | 汪峰 |
| 181 | 我很好 | I'm fine | 刘沁 |
| 182 | 江南 | 他是…JJ林俊杰 | 林俊杰 |
| 183 | 年少有为 | 耳朵 | 李荣浩 |
| 184 | Price Tag | Price Tag | Jessie J / B.o.B |
| 185 | The Sound of Silence_轻音乐 | The Best Pan Pipes in the World...Ever! | Panpipes |
| 186 | Eversleeping | Eversleeping | Xandria |
| 187 | Breaking My Heart | Unreleased | Lana Del Rey |
| 188 | Dying In the Sun | Bury the Hatchet | The Cranberries |
| 189 | See You Again | See You Again | See You Again |
| 190 | I Am You | I Am You | Kim Taylor |
| 191 | I'm Yours | I'm Yours | Jason Mraz |
| 192 | Innocence | The Best Damn Thing: Deluxe Edition | Avril Lavigne |
| 193 | 一生所爱 | 齐天周大圣之西游双记 电影歌乐游唱版 | 卢冠廷 / 莫文蔚 |
| 194 | 潇洒地走 | 潇洒地走 | 张蔷 |
| 195 | Apologize | Dreaming Out Loud (Tour Edition) | OneRepublic |
| 196 | Better Than One | The Score EP 2 | The Score |
| 197 | 停格 | 停格 | 蔡健雅 |
| 198 | When You're Gone | When You're Gone | Avril Lavigne |
| 199 | Astronomia | Astronomia | Vicetone / Tony Igy |
| 200 | 容易受伤的女人 | 阿菲正传 | 王菲 |
| 201 | River Flows In You | Kuschelklassik Piano Dreams, Vol. 2 | Martin Ermen |
| 202 | 倔强 | 神的孩子都在跳舞 | 五月天 |
| 203 | 牛仔很忙 | 我很忙 | 周杰伦 |
| 204 | 面会菜-林生祥 | [大佛普拉斯] 电影配乐 | 林生祥 |
| 205 | 当爱在靠近 | Love & the City | 刘若英 |
| 206 | 日晷之梦 | 幸福时光 精选辑 | Kevin Kern |
| 207 | Last Reunion | Lament of Valkyrie (Epicmusicvn Series) | Peter Roe |
| 208 | 起风了 | 起风了 | 吴青峰 |
| 209 | Concerning Hobbits | The Lord of the Rings: The Fellowship of the Ring (Original Motion Picture Soundtrack) | Howard Shore |
| 210 | 叱咤红人 | 相依为命: 20年精彩印记 | 陈小春 |
| 211 | 天才白痴梦 | 天才与白痴 | 许冠杰 |
| 212 | 分手以后才知道最珍贵 | 回到家乡 | 胡力 |
| 213 | 往事只能回味 | 怀念老歌一 | 高胜美 |
| 214 | 原来你也在这里 | 我的失败与伟大 | 刘若英 |
| 215 | 我这家伙的答案是你 | AsuRa BalBalTa | Leessang / 河琳 |
| 216 | 往事只能回味 | 我是歌手第四季 第9期 | 金志文 |
| 217 | 勇敢的心 | 最新热歌慢摇88 | Various Artists |
| 218 | 等一分钟 | 滕爱Teng Love | 徐誉滕 |
| 219 | 我想大声告诉你 (《蜗居》电视剧片尾曲) | 我想大声告诉你 | 樊凡 |
| 220 | 光阴的故事 | 光阴的故事 | 黄晓明 邓超 佟大为 |
| 221 | 越长大越孤单 | 越长大越孤单 | 牛奶咖啡 |
| 222 | 往事只能回味 | 说时依旧 | 好妹妹 |
| 223 | 知足 | 知足 最真杰作选 | 五月天 |
| 224 | 一起摇摆 | 生来彷徨 | 汪峰 |
| 225 | 演员 | 绅士 | 薛之谦 |
| 226 | 南方姑娘 | 赵小雷 | 赵雷 |
| 227 | 我最亲爱的 | 你在看我吗 | 张惠妹 |
| 228 | 篇章-张韶涵 / 王赫野 | 篇章 | 张韶涵 / 王赫野 |
| 229 | 你的样子 | 罗大佑自选辑 | 罗大佑 |
| 230 | 문을 여시오 (New Ver.) 请开门 | 문을 여시오 | 任昌丁 / 金昌烈 |
| 231 | Cornfield Chase | Interstellar (Original Motion Picture Soundtrack) | Hans Zimmer |
| 232 | Riverside | Philharmonics (Deluxe Edition) | Agnes Obel |
| 233 | Gotta Have You | Say I Am You | The Weepies |
| 234 | Big Big World | Big Big World | Emilia |
| 235 | 认错 | 自定义 | 许嵩 |
| 236 | My Heart Will Go On | Love Ballads | Kenny G |
| 237 | 月光下的凤尾竹 (葫芦丝) | 金耳朵.发烧民乐 | 纯音乐 |
| 238 | Love The Way You Lie | Life After Recovery | Eminem / Rihanna |
| 239 | 好汉歌 | 好汉歌 | 刘欢 |
| 240 | 布拉格广场 | 看我72变 | 蔡依林 / 周杰伦 |
| 241 | 粉红色的回忆 | 粉红色的回忆 | 韩宝仪 |
| 242 | 大敦煌-刀郎 | 谢谢你 | 刀郎 |
| 243 | Childhood Memory 童年 | Sunny Bay | Bandari |
| 244 | Dream Catcher 追梦人 | Relaxation - Dreams | Bandari |
| 245 | 小苹果 | 老男孩之猛龙过江 电影原声 | 筷子兄弟 |
| 246 | 穿越时空的思念 (DiESi Remix) | 穿越时空的思念 | DiESi |
| 247 | Hello | Hello | Adele |
| 248 | Chiru (Saisei No Uta) | Nostalgic | Robert de Boron |
| 249 | Southampton | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 250 | 雪见·落入凡尘 | 仙剑奇侠传三 电视剧原声带 | 麦振鸿 |
| 251 | 时间都去哪儿了 | 听得到的时间 | 王铮亮 |
| 252 | 土耳其进行曲 | 土耳其进行曲 | Various Artists |
| 253 | That's Not My Name | That's Not My Name | The Ting Tings |
| 254 | The Mountain of Women | Song of the Irish Whistle | Joanie Madden |
| 255 | Hymn To The Sea | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 256 | Don't push me | Jade - silver edition | sweetbox |
| 257 | Just Give Me A Reason | The Truth About Love | P!nk Nate Ruess |
| 258 | いつも何度でも | Prime Selection | 宗次郎 |
| 259 | 光年之外 | 光年之外 | G.E.M.邓紫棋 |
| 260 | 差生 | 少年中国 | 李宇春 |
| 261 | 人民不需要自由 | 108个关键词（李志的自我修养2012年度汇报演出） | 李志 |
| 262 | Nocturne No. 2 in E Flat Major, Op. 9, No. 2 | The Chopin Collection: The Nocturnes | Arthur Rubinstein |
| 263 | 青花瓷 | 我很忙 | 周杰伦 |
| 264 | Beyond The Memory | Beyond The Memory | July |
| 265 | 十年 | 黑白灰 | 陈奕迅 |
| 266 | 送别 | 送别 | 朴树 |
| 267 | 曹操 | 曹操 | 林俊杰 |
| 268 | 一辈子的孤单 | 涩女郎 电视原声带 | 刘若英 |
| 269 | 黑板情书 | 黑板情书 | 后弦 |
| 270 | I can't let this go on any further | I can't let this go on any further | Savior |
| 271 | 因为爱情 | Stranger Under My Skin | 陈奕迅 王菲 |
| 272 | New Morning 清晨 | Mist | Bandari |
| 273 | Love the Way You Lie Part III (Original Demo) | Don't Look Down | Skylar Grey |
| 274 | 我从崖边跌落 | 算云烟 | 谢春花 |
| 275 | 往事只能回味 | 往事只能回味 | 岳云鹏 / 宋小宝 |
| 276 | 君が好きだと叫びたい~TV Version~（好想大声说爱你）-BAAD | Slam Dunk Complete Vocal Collection ~TV Version~ | BAAD |
| 277 | 我只在乎你-齐秦 | 柒年·七个音乐故事 | 齐秦 |
| 278 | それが大事（最重要的事） | それが大事 | 大事MANブラザーズバンド / 渡辺禎史 |
| 279 | Never An Absolution | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 280 | Rose | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 281 | Secrets | Secrets | OneRepublic |
| 282 | 突然的自我 | 忘情1015精选辑 | 伍佰 & China Blue |
| 283 | 赤木の不安-徳永暁人 | Slam Dunk Complete Vocal Collection ~TV Version~ | 徳永暁人 |
| 284 | 春风十里 | 所有的酒，都不如你 | 鹿先森乐队 |
| 285 | Roses and Gold | Dust Diaries | Robin Jackson |
| 286 | Yesterday Once More | Yesterday Once More | Carpenters |
| 287 | 星座书上 | 自定义 | 许嵩 |
| 288 | 粉末 | 粉末 | 李宇春 |
| 289 | 苏州城外的微笑 | 很有爱 | 后弦 |
| 290 | Hey Jude | It's a Battle | John Lennon / Paul McCartney / It's a Cover Up |
| 291 | 天下 | 明天过后 | 张杰 |
| 292 | Last Dance | 爱情的尽头 | 伍佰 & China Blue |
| 293 | May It Be(电影《指环王：魔戒再现》插曲)-Enya | The Lord of the Rings: The Fellowship of the Ring (Original Motion Picture Soundtrack) | Enya |
| 294 | The 1950's-Zhao Jiping | Lifetimes (Vivre!) [Original Motion Picture Soundtrack] | Zhao Jiping |
| 295 | Miss Misery | Good Will Hunting (Music from the Miramax Motion Picture) | Elliott Smith |
| 296 | 风继续吹 | 风继续吹 | 张国荣 |
| 297 | Rain after Summer | Rain after Summer | 羽肿 |
| 298 | 宝贝 (in the night) | Original | 张悬 |
| 299 | 不再犹豫 | Beyond The Stage | Beyond |
| 300 | Take a Bow | Good Girl Gone Bad | Rihanna |
| 301 | 泡沫 | Xposed | G.E.M.邓紫棋 |
| 302 | 夕焼けの歌（夕阳之歌） | Matchy Best | 近藤真彦 |
| 303 | 无论你多怪异我还是会喜欢你-江惠莲 | 刺客伍六七 动画歌曲OST | 江惠莲 |
| 304 | 没有什么不同 | 我的歌声里 | 曲婉婷 |
| 305 | 夜太黑 | 夜太黑 | 林忆莲 |
| 306 | Rise - Epic Music | Rise - Epic Music | John Dreamer |
| 307 | 故乡的原风景 | 武侠音乐精装特辑 | 宗次郎 |
| 308 | 亲爱的那不是爱情 | Ang 5.0 | 张韶涵 |
| 309 | 红色高跟鞋 | 若你碰到他 | 蔡健雅 |
| 310 | The End of the World | The End of the World | Skeeter Davis |
| 311 | 怒放的生命 | 怒放的生命 | 汪峰 |
| 312 | 大约在冬季 | 冬雨 | 齐秦 |
| 313 | 喜欢你 | 喜欢你 | G.E.M. 邓紫棋 |
| 314 | 挪威的森林 | 爱情的尽头 | 伍佰 & China Blue |
| 315 | 本草纲目 | 依然范特西 | 周杰伦 |
| 316 | 小刀会序曲 | 武侠音乐系列之豪气中天 | 商易 / 夏飞云 / 上海民族乐团 |
| 317 | 问题出现我再告诉大家-五条人 | 县城记 | 五条人 |
| 318 | Nijamena | Nijamena | Anurag Kulkarni /Anup Rubens |
| 319 | 2 Soon | Not Thinking Bout 2morrow | Jon Young |
| 320 | 彩云追月 | Edell.Love | 爱戴 |
| 321 | 忧伤倒数 | 夫妻那些事 电视剧原声带 | 小昔米 |
| 322 | 爱情转移 | 认了吧 | 陈奕迅 |
| 323 | 阳光下的我们 | Say The Words | 曲婉婷 |
| 324 | 今天 | 真永远 | 刘德华 |
| 325 | 隐形的翅膀 | 潘朵拉 | 张韶涵 |
| 326 | 蝴蝶泉边 | 崽崽 | 黄雅莉 |
| 327 | Tassel | Dulcet Series spring special collection | Cymophane |
| 328 | 生如夏花 | 生如夏花 | 朴树 |
| 329 | Sugar | V | Maroon 5 |
| 330 | 七里香 | 七里香 | 周杰伦 |
| 331 | 辞·九门回忆 | 辞·九门回忆 | 冰幽 / 解忧草 |
| 332 | 庐州月 | 寻雾启示 | 许嵩 |
| 333 | 我可以抱你吗-张惠妹 | 我可以抱你吗？爱人 | 张惠妹 |
| 334 | Only Time | Only Time: The Collection (Box Set) | Enya |
| 335 | 香水有毒 (DJ版) | 香水有毒(宣传单曲) | 胡杨林 |
| 336 | 有何不可 | 自定义 | 许嵩 |
| 337 | 真的爱你 | BEYOND IV | Beyond |
| 338 | Remember The Time | The Ultimate Collection | Michael Jackson |
| 339 | 漫步人生路-刘惜君 | 惜 . 君 | 刘惜君 |
| 340 | 你的样子 | 一个人的样子 | 林志炫 |
| 341 | Teenage Dream | Teenage Dream | Katy Perry |
| 342 | 莫扎特：《小夜曲》第一乐章 | 2008-2011 演奏实况合集 | 中国国家交响乐团 |
| 343 | Loves Me Not | t.A.T.u. - The Best | t.A.T.u. |
| 344 | 幸せ（幸福）-中岛美雪 | Singles 2000 | 中島みゆき |
| 345 | 穿越时空的思念2 时代を超える想い2 | 映画“犬夜叉 时代を越える想い 音楽篇” | 和田薫 |
| 346 | 毕业说分手 | 毕业说分手 | 冰冰超人 |
| 347 | The South Wind | Song of the Irish Whistle | Joanie Madden |
| 348 | 精忠报国-屠洪刚 | 精忠报国 | 屠洪刚 |
| 349 | 所念皆星河 | 所念皆星河 | CMJ |
| 350 | 可能 | 可能 | 程响 |
| 351 | The Scientist | The Scientist | Coldplay |
| 352 | 大海 | 70老男孩 | 张雨生 |
| 353 | 八年的爱 | 八年的爱 | 冰冰超人 |
| 354 | 漫步人生路-邓丽君 | 邓丽君-传奇的诞生 | 邓丽君 |
| 355 | TiK ToK | Animal | Kesha |
| 356 | Underneath Your Clothes | Laundry Service | Shakira |
| 357 | My Heart Will Go On | My Love: Ultimate Essential Collection (North American Version) | Celine Dion |
| 358 | Rock House Jail | The Rock (Original Motion Picture Score) | Nick Glennie-Smith / Hans Zimmer / Harry Gregson-Williams |
| 359 | 我变了 我没变 | 我变了 我没变 | 杨宗纬 |
| 360 | Trip | Trip | Axero |
| 361 | 断桥残雪 | 断桥残雪 | 许嵩 |
| 362 | 春天里 | 信仰在空中飘扬 | 汪峰 |
| 363 | Lifetimes-Zhao Jiping | Lifetimes (Vivre!) [Original Motion Picture Soundtrack] | Zhao Jiping |
| 364 | 未来へ (向着未来) | 長い間 ～キロロの森～ | Kiroro (キロロ) |
| 365 | What A Wonderful World | All Time Greatest Hits | Louis Armstrong |
| 366 | 光明 | 信仰在空中飘扬 | 汪峰 |
| 367 | 光辉岁月 | 光辉岁月 | Beyond |
| 368 | Rhythm Of The Rain | Let It Be Me | Jason Donovan |
| 369 | Five Hundred Miles (《醉乡民谣》电影主题曲|《一路繁花相送》电视剧插曲) | Inside Llewyn Davis: Original Soundtrack Recording | Justin Timberlake / Carey Mull |
| 370 | 关山酒-等什么君(邓寓君) | 关山酒 | 等什么君(邓寓君) |
| 371 | 画皮-刀郎 | 山歌寥哉 | 刀郎 |
| 372 | 21 Guns | 21st Century Breakdown | Green Day |
| 373 | The truth that you leave | The truth that you leave | Pianoboy高至豪 |
| 374 | 雨过天不晴 | 雨过天不晴 | 柯柯柯啊 |
| 375 | Snowdreams 雪之梦 | Rhine River | Bandari |
| 376 | Not a Single Day 하루도 | Rain's World (Special Edition) | Rain |
| 377 | Summer Vibe | Summer Vibe | Walk off the Earth |
| 378 | We Are One | Super Deluxe Sound I | Kelly Sweet |
| 379 | 北京北京 | 勇敢的心 | 汪峰 |
| 380 | Don't Wanna Know/We Don't Talk Anymore | Don't Wanna Know/We Don't Talk Anymore | Sam Tsui / Alex Blue |
| 381 | We Don't Talk Anymore | We Don't Talk Anymore | Alex Blue TJ Brown |
| 382 | Will and Elizabeth | Pirates of the Caribbean: The Curse of the Black Pearl | Klaus Badelt |
| 383 | You Got Me | Breakthrough | Colbie Caillat |
| 384 | Where Is the Love | Best of Both Worlds | Josh Vietti |
| 385 | Love Story | Women's Day 2019 | Taylor Swift |
| 386 | I Do | I Do | Colbie Caillat |
| 387 | BLUE | Blue Neighbourhood (Deluxe) | Troye Sivan Alex Hope |
| 388 | A Little Story | My View | Valentin |
| 389 | ひとり上手（习惯孤独） | 大吟醸 | 中島みゆき |
| 390 | Memories | 마녀유희 OST | 金有京 |
| 391 | MELANCHOLY | MELANCHOLY | White Cherry |
| 392 | Sundial Dreams | In the Enchanted Garden | Kevin Kern |
| 393 | If | 마녀유희 OST | 全慧彬 |
| 394 | 相思赋予谁 | 春生 | 好妹妹 |
| 395 | 小河淌水-龚琳娜 | 小河淌水 | 龚琳娜 |
| 396 | 画离弦 (柯柯吉他版) | 画离弦 | 柯柯柯啊 |
| 397 | 筝锋 | 功夫 电影原声大碟 | 黄英华 |
| 398 | Thinking Out Loud | NOW That's What I Call Music! 90 | Ed Sheeran |
| 399 | Righteous Path | Introducing Mellow | Blazo |
| 400 | Somebody That I Used To Know | Making Mirrors | Gotye Kimbra |
| 401 | Hard to Sleep | This Is What It Feels Like | Gracie Abrams |
| 402 | Aloha Heja He | Melancholie und Sturmflut (Bonus Tracks Edition) | Achim Reichel |
| 403 | Palace Memories | Sound. Earth. Nature. Spirit. - Vol. Sound | S.E.N.S. |
| 404 | 回家(萨克斯风) | 金耳朵Ⅲ | Kenny G |
| 405 | Breath and Life | The Platinum Series III: Eterna | Audiomachine |
| 406 | East of Eden | East of Eden | Zella Day |
| 407 | Carpe Diem | Dead Poets Society | Maurice Jarre |
| 408 | 姑娘别哭泣-柯柯柯啊 | 姑娘别哭泣 | 柯柯柯啊 |
| 409 | Beautiful In White (Demo) | Beautiful In White (Demo) | Shane Filan |
| 410 | 萱草花-张小斐 | 你好，李焕英 电影原声大碟 | 张小斐 |
| 411 | Keating's Triumph | Dead Poets Society | Maurice Jarre |
| 412 | Better Man | Sing When You're Winning | Robbie Williams |
| 413 | Love Me Like You Do | Delirium | Ellie Goulding |
| 414 | Summer | ENCORE | 久石譲 |
| 415 | Viva La Vida | Viva La Vida Or Death And All His Friends | Coldplay |
| 416 | 爱向着我来的那天 사랑아 내게 오기만 해 (PartⅠ) | 마녀유희 OST | Ashily |
| 417 | You're Beautiful | So Beautiful 1 | James Blunt |
| 418 | 思念是一种病 | OK | 张震岳 / 蔡健雅 |
| 419 | Careless Whisper-George Michael | Ladies And Gentlemen... The Best Of George Michael | George Michael |
| 420 | 难却 (DJ细霖版|待上浓妆好戏开场) | 难却 | 平生不晚 |
| 421 | Sunburst | Sunburst | Tobu / Itro |
| 422 | The Mass-Era | The Mass | Era |
| 423 | 精卫-30年前，50年后 | 丧失年轻，勿失年华 | 30年前，50年后 |
| 424 | Farewell to Camraw | When the Pipers Play | Black Kilts Berlin /Robert Mathieson |
| 425 | 想太多 | 想太多 | 李玖哲 |
| 426 | Booty Music | Git Fresh | Deep Side |
| 427 | Genie | THE BEST ~New Edition~ | 少女时代 |
| 428 | Caravan-a_hisa | Single Collection | a_hisa |
| 429 | 樱花草 | 花言乔语 (精装版) | Sweety |
| 430 | Girlfriend | The Best Damn Thing: Deluxe Edition | Avril Lavigne |
| 431 | 道山靓仔-五条人 | 县城记 | 五条人 |
| 432 | 精卫-一颗狼星_许篮心 | 精卫（戏腔） | 一颗狼星_许篮心 |
| 433 | Remember The Name | Sampler Mixtape | Fort Minor |
| 434 | Right Here Waiting (Piano) | Right Here Waiting (Piano) | Basil Jose /Richard Marx |
| 435 | The Long Way Home | The Bright Side | Lenka |
| 436 | 单车恋人 | 9公主 | 后弦 |
| 437 | 愤怒的消失 그게 말이죠 | 마녀유희 OST | 木单车 |
| 438 | 西厢 | 古·玩 | 后弦 |
| 439 | Bye Bye Bye | Rising Love | Lovestoned |
| 440 | Star of the County Down | Musique Celtic | Rosheen |
| 441 | 一格格-卫兰 | 一格格 | 卫兰 |
| 442 | Main Title (The Godfather Waltz) | The Godfather I | Nino Rota |
| 443 | 命运的恶作剧 운명의 장난 | 마녀유희 OST | MC 真理 / 哈哈 |
| 444 | Far Away From Home | Greatest Hits | Groove Coverage |
| 445 | Damn You | The Unreleased Collection | Lana Del Rey |
| 446 | The Happy Troll (Griefing Theme Song)-D1ofaquavibe | The Happy Troll (Griefing Theme Song) | D1ofaquavibe |
| 447 | 乌兰巴托之夜-谭维维 | 高原之心 | 谭维维 |
| 448 | Love Yourself (Natio Remix) | Love Yourself (Natio Remix) | Natio / Justin Bieber / Conor Maynard |
| 449 | Red River Valley | Journey Home | Bronn Journey |
| 450 | 去年夏天 | 去年夏天 | 王大毛 |
| 451 | My Happy Ending | Under My Skin (Special Edition) | Avril Lavigne |
| 452 | 友谊之光 | 监狱风云 | 玛莉亚 |
| 453 | The Moon Represents My Heart | Love Ballads | Kenny G |
| 454 | Auld Lang Syne | The Greatest Gift | Charlie Landsborough |
| 455 | 口弦 | 听见凉山 电视剧原声带 | 赵艺涵 |
| 456 | 奇异恩典 | 最新热歌慢摇73 | Various Artists |
| 457 | Flower Dance | A Cup Of Coffee | DJ Okawari |
| 458 | Come And Get It | Chartsurfer Vol. 30 | Selena Gomez |
| 459 | Heartbeats | Swings and Roundabouts | Amy Deasismont |
| 460 | Hero | Hero | Enrique Iglesias |
| 461 | 风中有朵雨做的云-孟庭苇 | 风中有朵雨做的云 | 孟庭苇 |
| 462 | I Just Wanna Run | Take Action! Volume 9 | The Downtown Fiction |
| 463 | 莫失莫忘 | 仙剑奇侠传 电视原创配乐 | 麦振鸿 |
| 464 | I Want You to Know | I Want You to Know | Zedd / Selena Gomez |
| 465 | We Are Young | Dancing Bear Best Of 2012 International | Fun. Janelle Monáe |
| 466 | 罗刹海市-刀郎 | 山歌寥哉 | 刀郎 |
| 467 | The Day You Went Away | The Day You Went Away: The Best of M2M | M2M |
| 468 | Sleepyhead | Acoustic Daydreams | Galen Crew |
| 469 | Moon As My Heart | Harmonica Sound of Hong Kong | Robert Bonfiglio |
| 470 | Solstice-K-391 | Solstice | K-391 |
| 471 | 西海情歌-刀郎 | 刀郎Ⅲ | 刀郎 |
| 472 | 卡农D大调 | 胎教音乐 | 群星 |
| 473 | My Soul | Time... | July |
| 474 | Conquest of Paradise-Vangelis | 1492 - Conquest Of Paradise | Vangelis |
| 475 | 富士山下 | What's Going On…? | 陈奕迅 |
| 476 | New Soul | Irlande | Vox Angeli |
| 477 | 乌兰巴托的夜 (丹正母子版) | 乌兰巴托的夜 | 丹正母子 |
| 478 | If I Die Young | If I Die Young - Single | The Band Perry |
| 479 | The Godfather (Love Theme) | The Godfather I | Nino Rota |
| 480 | 原来你也在这里-周笔畅 | 原来你也在这里 | 周笔畅 |
| 481 | Hero's Theme-Steven Burke | Kameo: Elements of Power O.S.T | Steven Burke |
| 482 | My Love (Radio Edit) | Coast to Coast | Westlife |
| 483 | What Are Words | What Are Words | Chris Medina |
| 484 | Young For You | Young For You | GALA |
| 485 | The Ludlows | Legends Of The Fall Original Motion Picture Soundtrack | James Horner |
| 486 | 雪の華（雪之花）-中岛美嘉 | 雪の華 | 中島美嘉 |
| 487 | 让我欢喜让我忧-周华健 | 让我欢喜让我忧 | 周华健 |
| 488 | Pop Danthology 2012 | Pop Danthology | DJ Daniel Kim |
| 489 | 向云端-小霞&海洋Bo | 向云端 | 小霞 / 海洋Bo |
| 490 | 城南花已开 | 城南花已开 | 三亩地 |
| 491 | Paris | Paris | Else |
| 492 | Monsters (Live)-周深 | 歌手·当打之年 第5期 | 周深 |
| 493 | 颠倒歌-刀郎 | 山歌寥哉 | 刀郎 |
| 494 | 花心 | Keep Wakin 1987-2002 周而复始 | 周华健 |
| 495 | 呼唤 오나라 I | 대장금 OST | 김지현 |
| 496 | 爱向着我来的那天2 사랑아 내게 오기만 해 (Part II) | 마녀유희 OST | Ashily |
| 497 | 再见 | 再见 | 张震岳 |
| 498 | 千千阙歌 | 千千阙歌 | 陈慧娴 |
| 499 | 萍聚 | 萍聚/珍重再见 | 李翊君 / 李富兴 |
| 500 | Kiss The Rain 비를 맞다 | The Best - Reminiscent 10th Anniversary | Yiruma |
| 501 | Runner | Runner | Dustin O'Halloran |
| 502 | This Is the Life | Weathered | Angie Miller |
| 503 | 从头再来 | 从头再来 | 刘欢 |
| 504 | Dead Poets Society (Finale) | Filmharmonic II | The Royal Philharmonic Orchestra Maurice Jarre |
| 505 | The sally gardens | Arias Ancora | Laure Green |
| 506 | Friendships-Pascal Letoublon | Friendships | Pascal Letoublon |
| 507 | 序曲：天地孤影任我行 | 东邪西毒(电影音乐) | 陈勋奇 |
| 508 | 送别 | 送别 | 韩红 |
| 509 | 安静 钢琴版 | 纯音乐流行歌曲钢琴版 | Paul Liu |
| 510 | Wrecking Ball | Wrecking Ball | Miley Cyrus |
| 511 | 是啊 그래 | 마녀유희 OST | 나창현 |
| 512 | Six Feet Under | Six Feet Under | Billie Eilish |
| 513 | 穿越时空的思念1 时代を超える想い1 | 映画“犬夜叉 时代を越える想い 音楽篇” | 和田薫 |
| 514 | 千千阙歌 (Live)-周深 | 聚划算55青春选择之夜晚会Live | 周深 |
| 515 | 偷功 | 太极张三丰 电影原声带 | 胡伟立 |
| 516 | Umbrella | Now That's What I Call Music! 25 Years | Rihanna / Jay-Z |
| 517 | Waka Waka (Esto Es África) | Waka Waka (This Time For Africa) (The Official 2010 Fifa World Cup Song) | Shakira |
| 518 | In The End | In The End | Linkin Park |
| 519 | Monody | Monody | TheFatRat / Laura Brehm |
| 520 | The Show | The Show | Lenka |
| 521 | 野子 (Live) | 我是歌手第四季 第3期 | 苏运莹 |
| 522 | Gee | The First Mini Album Gee | 少女时代 (소녀시대) |
| 523 | Ship In The Sand | Dear Me, Look Up | Marble Sounds |
| 524 | Summertime Sadness | Summertime Sadness | Lana Del Rey |
| 525 | 慕情 (M-4) | 犬夜叉 音楽篇 | 和田薫 |
| 526 | 最浪漫的事-赵咏华&好妹妹 | 追梦人 | 赵咏华 / 好妹妹 |
| 527 | Honor (Main Title Theme from "The Pacific") | The Pacific (Music From the HBO Miniseries) | Hans Zimmer / Geoff Zanelli / Blake Neely |
| 528 | 花妖-刀郎 | 山歌寥哉 | 刀郎 |
| 529 | 乌兰巴托的夜-左小祖咒 | 美国 The U.S.A（电影原声配乐） | 左小祖咒 |
| 530 | I Love You (Remix) | I Love You | United Idol |
| 531 | 你还要我怎样 | 意外 | 薛之谦 |
| 532 | 发现爱 | 西界 | 林俊杰 / 金莎 |
| 533 | 桥边姑娘 | 桥边姑娘 | 海伦 |
| 534 | 犯错 | 犯错 | 顾峰 / 斯琴高丽 |
| 535 | 那年初夏 | 毕业了我们一无所有 | 任然 |
| 536 | 北京欢迎你 | 北京2008年奥运会歌曲专辑 | 群星 |
| 537 | Red River Valley | Cowboy Songs | Michael Martin Murphey |
| 538 | 500 Miles | Buck The Trend | Peter, Paul & Mary |
| 539 | 500 Miles | Christ Is My Hope | The Innocence Mission |
| 540 | 500 Miles | Let's Folk | The Brothers Four |
| 541 | 画离弦 (柯柯版) | 画离弦 | 柯柯柯啊 |
| 542 | Ferrari-Jayvine Ramma | Ferrari | Jayvine Ramma |
| 543 | Annie's Wonderland 安妮的仙境 | Wonderland | Bandari |
| 544 | 阿凡达与屌丝男 | 心花路放 电影原声带 | 许鹤缤 |
| 545 | 花 ~すべての人に心の花を~ (オリジナル・ヴァージョン) | ザ・ニュー・ベスト・オブ・喜納昌吉＆チャンプルース | 喜納昌吉 (きな しょうきち) |
| 546 | Skinny Love | Skinny Love | Birdy |
| 547 | 我的歌声里 | 我的歌声里 | 李代沫 |
| 548 | 情人 | 海阔天空 | Beyond |
| 549 | 给我一个吻-杨子姗 | 重返20岁 电影原声带 | 杨子姗 |
| 550 | 桔梗谣 | 노들강변 매화타령 민요 | 노들강변 매화타령 민요 |
| 551 | 为爱痴狂 | 《中国好声音》2012跨年演唱会 | 金志文 |
| 552 | Mariage d'amour | Lettre à ma Mère | Richard Clayderman |
| 553 | 我可以抱你吗 (Live)-孟根花 | 我可以抱你吗 | 孟根花 |
| 554 | 世界第一等 | 世界第一等 | 浪哥 |
| 555 | Unable To Stay, Unwilling To Leave | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 556 | 带我到山顶 | 听见凉山 | 赵艺涵 |
| 557 | Baby | Baby | Justin Bieber / Ludacris |
| 558 | 春娇与志明 | 春娇与志明 | 街道办GDC /欧阳耀莹 |
| 559 | Nevada | Monstercat - Best of 2016 | Vicetone / Cozi Zuehlsdorff |
| 560 | 听妈妈的话 | 依然范特西 | 周杰伦 |
| 561 | Jambalaya | 不朽的声音(人生最难忘的歌) | Carpenters |
| 562 | 红尘情歌 | 情路无悔 | 高安 /黑鸭子组合 |
| 563 | 莉莉安-宋冬野 | 安和桥北 | 宋冬野 |
| 564 | Prendre sa main | Cri d'amour | Angel Lover |
| 565 | 安静 | 范特西 | 周杰伦 |
| 566 | 梦中蝶影 | 歌曲合辑 | 华语群星 |
| 567 | 姑娘我爱你 | 姑娘我爱你 | 索朗扎西 |
| 568 | 借我 | 算云烟 | 谢春花 |
| 569 | Always With Me | 幸福的味道 | 木村弓 / 奥户巴寿 |
| 570 | 총맞은것처럼 (像中枪一样)-白智英 | Sensibility | 白智英 (백지영) |
| 571 | 兰亭序 | 魔杰座 | 周杰伦 |
| 572 | The Red Sun | 20 Years of Achievement around the World | Richard Clayderman |
| 573 | 纯真年代 | 大小世界 | 爱朵女孩 |
| 574 | Vincent | Legendary Don McLean | Don McLean |
| 575 | 平凡之路 | 猎户星座 | 朴树 |
| 576 | 李白 | 模特 | 李荣浩 |
| 577 | You | YOU | Approaching Nirvana |
| 578 | Coming Home | Coming Home | Skylar Grey / Diddy-Dirty Money |
| 579 | Turnin' | Young Rising Sons | Young Rising Sons |
| 580 | 意外 | 意外 | 薛之谦 |
| 581 | Promise | Promise | sapientdream |
| 582 | 那些年 | 那些年，我们一起追的女孩 电影原声带 | 胡夏 |
| 583 | 有一种爱叫做放手 | 有一种爱叫做放手 | 阿木 |
| 584 | 童年 | 童年 | 北京天使合唱团 |
| 585 | Still D.R.E (Instrumental Version)-Dr. Dre Snoop Dogg | Still D.R.E. | Dr. Dre / Snoop Dogg |
| 586 | 赤伶(DJ版) | 赤伶 | DJ名龙 |
| 587 | 我最亲爱的 | 我的歌声里 | 李代沫 |
| 588 | April 四月之春 | Sunrise Hill | Bandari |
| 589 | Fight | Fight | BeatBrothers |
| 590 | 我希望 | 匆匆那年 电视原声带 | 杨玏 |
| 591 | 恋曲1990-高胜美 | 经典金选1 哭砂 | 高胜美 |
| 592 | 知道不知道 | Rene | 刘若英 |
| 593 | Jiazhen Leaves Fughi-Zhao Jiping | Lifetimes (Vivre!) [Original Motion Picture Soundtrack] | Zhao Jiping |
| 594 | 花-喜納昌吉 | The Celebrations | 喜納昌吉 / チャンプルーズ |
| 595 | Don't Worry Be Happy | Pretty Donkey Girl | Holly Dolly |
| 596 | Say Hello | These Friends Of Mine | Rosie Thomas / Sufjan Stevens |
| 597 | 我记得 | 署前街少年 | 赵雷 |
| 598 | The Right Path | Age of Innocence (Original Soundtrack) | Thomas Greenberg |
| 599 | 相思 | 腔.调 | 毛阿敏 |
| 600 | 云宫迅音-许镜清 | 西游记 电视剧配乐原声 | 许镜清 |
| 601 | Seven Lonely Days | Remember When? - 25 Golden Memories | Georgia Gibbs |
| 602 | 相对 | 子曰 第一册 | 子曰乐队 |
| 603 | Sally Gardens | Spring | The O'Neill Brothers |
| 604 | 2 Phút Hơn (KAIZ Remix) | 2 Phút Hơn (KAIZ Remix) | Pháo / KAIZ |
| 605 | Valder Fields | A Plea en Vendredi | Tamas Wells |
| 606 | 刚好遇见你 | 刚好遇见你 | 李玉刚 |
| 607 | Way Back then | 오징어게임 OST | 郑在日 (정재일) |
| 608 | 爱要坦荡荡-萧潇 | Beautiful Angel | 萧潇 |
| 609 | 你的答案-阿冗 | 你的答案 | 阿冗 |
| 610 | Luv Letter | 髙橋大輔～フェイヴァリット・ミュージック～ | 神津裕之 |
| 611 | 海阔天空 | 一声所爱 大地飞歌（第九期） | 汪小敏 |
| 612 | 半妖-和田薫 | TVアニメーション「犬夜叉」オリジナルサウンドトラックアルバム「犬夜叉 音楽篇」 | 和田薫 |
| 613 | 男と女（男和女） | Standing Ovation | CHAGE and ASKA |
| 614 | 万水千山总是情 | 万水千山总是情 电视剧原声带 | 汪明荃 |
| 615 | 希望 | Grace & Charm | 陈慧琳 |
| 616 | Anak (remix: Freddie Aguilar|Remix) | 清尘 | 清尘 |
| 617 | Liability | Melodrama | Lorde |
| 618 | Never Say Good Bye | 마이걸 | Mario & Nesty (마리오&네스티) |
| 619 | 城府 | 自定义 | 许嵩 |
| 620 | Rompasso-Angetenar（DEITIES remix）-DEITIES Ghetto Artist | Angetenar (DEITIES Remix) | DEITIES / Ghetto Artist |
| 621 | All Falls Down | All Falls Down | Alan Walker / Noah Cyrus / Digital Farm Animals / Juliander |
| 622 | 梦中的婚礼 | Richard Clayderman | Richard Clayderman |
| 623 | Ferrari-Bebe Rexha | Expectations | Bebe Rexha |
| 624 | Faded | Faded | Alan Walker / Iselin Solheim |
| 625 | 被遗忘的时光-蔡琴 | 出塞曲 | 蔡琴 |
| 626 | Take It From Me | Say I Am You | The Weepies / Deb Talan / Steve Tannen |
| 627 | 鼓楼 | 无法长大 | 赵雷 |
| 628 | You Belong To Me | To You | Carla Bruni |
| 629 | 发如雪 | 十一月的萧邦 | 周杰伦 |
| 630 | Windy Hill（风之谷） | Windy Hill | 羽肿 |
| 631 | Bloom of Youth | クドわふたー オリジナル サウンドトラック | 清水淳一 |
| 632 | Your Man | Double Cream 5: 20 Years of Nashville #1's 1992-2012 | Josh Turner |
| 633 | 鸿雁-额尔古纳乐队 | 往日时光 | 额尔古纳乐队 |
| 634 | 热爱105°C的你 | 热爱105°C的你 | 腾格尔 / 艾伦 / 沈腾 |
| 635 | Eventide | Eventide | Nylon |
| 636 | Because of You | Because Of You | Kelly Clarkson |
| 637 | Demons | Continued Silence EP | Imagine Dragons |
| 638 | Take Me To Church | Bravo Hits 86 | Hozier |
| 639 | Just One Last Dance (Album Version) | Key To My Soul | Sarah Connor /Marc Terenzi |
| 640 | Love The Way You Lie (Part III (Original Demo)) | Relaxing Acoustic | Skylar Grey |
| 641 | 老男孩 | 父亲 | 筷子兄弟 |
| 642 | 我是一只小小鸟 | 我是一只小小鸟 | 赵传 |
| 643 | 独家记忆 | 独家记忆 (Hong Kong Version) | 陈小春 |
| 644 | Be What You Wanna Be | Darin | Darin |
| 645 | 好久不见 | 认了吧 | 陈奕迅 |
| 646 | A Place Called You | Enchanted | Emma Stevens |
| 647 | Young And Beautiful | Triple J Hottest 100 Vol 21 | Lana Del Rey |
| 648 | 长路漫漫任我闯 | 林子祥精选之天长地久 | 林子祥 |
| 649 | Frail Love | Frail Love | Cloves |
| 650 | Scarborough Fair | The Very Best of Sarah Brightman 1990-2000 | Sarah Brightman |
| 651 | 从头再来 | 经典20年 珍藏锦集 | 刘欢 |
| 652 | 浮夸 | U-87 | 陈奕迅 |
| 653 | Asphyxia 窒息 | asphyxia | 逆时针向 |
| 654 | The Ocean (Radio Edit) | The Ocean | Mike Perry / SHY Martin |
| 655 | 乌兰巴托的夜-葱香科学家（王悠然） | 乌兰巴托的夜 | 葱香科学家（王悠然） |
| 656 | 听 | 拾 | 张杰 |
| 657 | Lonely | Nana | Nana |
| 658 | Unity | Sounds of Syndication, Vol .1 (Presented by Syndicate) | TheFatRat |
| 659 | Hey, Soul Sister | Save Me, San Francisco | Train |
| 660 | Waltz No.6 'Petit Chien' in D Flat Major Op.40-1 | 越听越聪明 1 | Classical Artists |
| 661 | Too Far | King in the Mirror | Anna F |
| 662 | Inspire | Serenity | Capo Productions |
| 663 | 让我偷偷看你 | 阿弥陀佛么么哒·一个孩子的心愿 | 赵雷 |
| 664 | 夜的钢琴曲五 | 夜的钢琴曲 Demo集 | 石进 |
| 665 | Sutter's Mill | The Music of Dan Fogelberg | Dan Fogelberg |
| 666 | Please Don't Go | Please Don't Go | Joel Adams |
| 667 | 曾经的你 | 每一刻都是崭新的 | 许巍 |
| 668 | Stay Here Forever | Valentine's Day OST | Jewel |
| 669 | 存在 | 生无所求 | 汪峰 |
| 670 | Stay Alive | The Secret Life Of Walter Mitty (Music From And Inspired By The Motion Picture) | José González |
| 671 | 我就喜欢你这样的丫头 | 匆匆那年 电视原声带 | 杜维瀚 |
| 672 | Everybody | Everybody | Ingrid Michaelson |
| 673 | 传奇 | 传奇 | 王菲 |
| 674 | 易燃易爆炸 | 如也 | 陈粒 |
| 675 | 飞向别人的床 | 飞向别人的床 | 沉珂（C.K）& 光光 |
| 676 | 赤伶 (弹唱版) | 赤伶 | 孙鹏凯 |
| 677 | Astronomia（黑人抬棺古风版） | 黑人抬棺古风版 | litterzy、水玥儿 |
| 678 | I Want My Tears Back | Imaginaerum | Nightwish |
| 679 | 红颜 | MuSiC混合体 | 胡彦斌 |
| 680 | 혼자시킨 사랑 独自的爱情 | 명랑소녀 성공기 OST | True Bird |
| 681 | 潮湿的心 | 蜕变1少女的心情故事 | 卓依婷 |
| 682 | brave heart | brave heart | 宮崎歩 |
| 683 | 明天过后 | 明天过后 | 张杰 |
| 684 | Love Theme | 명랑소녀 성공기 OST | 吴振宇 |
| 685 | Read My Mind | Jade | Sweetbox |
| 686 | Let It Out | Let It Out | Frances |
| 687 | Love Song | 명랑소녀 성공기 OST | 赵长赫 |
| 688 | 飞得更高 | 笑着哭 | 汪峰 |
| 689 | 花火 | 花火 | 汪峰 |
| 690 | 直到永远 | 生死不离 我们在一起 | 汪峰 |
| 691 | 跟往事干杯 | 不朽金曲精选 Ⅰ | 姜育恒 |
| 692 | 蓝莲花 | 时光.漫步 | 许巍 |
| 693 | 娃娃脸 | 娃娃脸 | 后弦 |
| 694 | 我爱你中国 | 怒放的生命 | 汪峰 |
| 695 | 星象仪 プラネタリウム | プラネタリウム | 大塚爱 |
| 696 | 推理(オリジナル・ヴァージョン)-大野克夫 | 「名探偵コナン」サントラ・スーパー・ベスト- (名侦探柯南) | 大野克夫 |
| 697 | 一直很安静 | 寂寞在唱歌 | 阿桑 |
| 698 | 生活不止眼前的苟且 | 生活不止眼前的苟且 | 许巍 |
| 699 | Mark's Theme-顾嘉辉 | 英雄本色1&2 | 顾嘉辉 |
| 700 | Tears Of A Clown | Mastercutor | U.D.O. |
| 701 | 運命のルーレット廻して (转动命运之轮) | 運命のルーレット廻して | ZARD (ザード) |
| 702 | The Dawn-Dreamtale | Beyond Reality (Japanese Edition) | Dreamtale |
| 703 | 兰亭序 (粤语版) (Single Version) | 兰亭序 | 王十三 |
| 704 | For Free | Folk For Kids | Lana Del Rey / Zella Day / Weyes Blood |
| 705 | My Destiny (我的命运) | 별에서 온 그대 OST Part 1 | LYn (린) |
| 706 | 亲爱的路人 | 亲爱的路人 | 刘若英 |
| 707 | 等不到的爱 | 裸婚时代 电视剧原声带 | 文章 |
| 708 | Call Me Maybe | Call Me Maybe | Carly Rae Jepsen |
| 709 | 花开在眼前 | 花开在眼前 | 韩磊 |
| 710 | 如果不能好好爱 | 如果不能好好爱 | 吴克群 |
| 711 | 童年 | 纵贯线演唱会 | 罗大佑、李宗盛、张震岳、周华健 |
| 712 | 魔訶不思議アドベンチャー! | ドラゴンボール全曲集 | 高橋洋樹 |
| 713 | 我是一只小小鸟-任贤齐&李宗盛 | 台湾男儿任贤齐认真精选辑 | 任贤齐 / 李宗盛 |
| 714 | 白羊座的忧伤-石进 | 夜的钢琴曲Ⅱ | 石进 |
| 715 | One Night In 北京 | SHIN 同名专辑 | 信乐团 |
| 716 | The Monster | The Monster | Eminem / Rihanna |
| 717 | Groundhog Day | Groundhog Day | Em Beihold |
| 718 | 我期待-张雨生 | 卡拉OK.台北.我 | 张雨生 |
| 719 | Amazing Grace 天赐恩宠 | 苏格兰音乐之旅 苏格兰风笛 | 群星 |
| 720 | 小仙女 | 武侠音乐系列之缠绵悱恻 （截取版） | 麦振鸿 |
| 721 | Élan | Élan | Nightwish |
| 722 | 爱你在心口难开-高胜美 | 怀念老歌七 | 高胜美 |
| 723 | Fengxia Leaves Her Parents-Zhao Jiping | Lifetimes (Vivre!) [Original Motion Picture Soundtrack] | Zhao Jiping |
| 724 | The Hampster Dance Song-Hampton the Hampster | The Hamsterdance Album | Hampton the Hampster |
| 725 | Dans la maison (Thème)-Philippe Rombi | Dans la maison | Philippe Rombi |
| 726 | 「名探偵コナン」~メインテーマ-大野克夫 | 「名探偵コナン」メインテーマ | 大野克夫 |
| 727 | 万里の長城-太田美知彦 | 中華一番! スペシャルTVオンエアーミックス& ― オリジナル・サウンドトラック | 太田美知彦 |
| 728 | 喜剧之王 | 喜剧之王 | 李荣浩 |
| 729 | Tennessee-Hans Zimmer | Pearl Harbor [O.S.T] | Hans Zimmer |
| 730 | 浮沉的兄弟-戎祥 | 浮沉的兄弟 | 戎祥 |
| 731 | 幸せ（幸福）-小林幸子 | 小林幸子全曲集 2013 | 小林幸子 |
| 732 | Liekkas | Assogattis: By The Embers | Sofia Jannok |
| 733 | 我想和你一起去海边-江惠莲 | 伍六七 原声大碟 | 江惠莲 |
| 734 | For the World-谭盾 | Late Night Tales: Air | 谭盾 |
| 735 | Scotland the Brave 苏格兰勇士 | 苏格兰音乐之旅 苏格兰风笛 | 群星 |
| 736 | 月牙湾 | 爱.歌姬 | F.I.R. |
| 737 | Gangsta Bop | Konvicted | Akon |
| 738 | Hallelujah | Warmer In The Winter (Deluxe Edition) | Lindsey Stirling |
| 739 | Nijamena (BGM版) | Nijamena | H2s |
| 740 | 二泉映月 | 阿炳全集 | 阿炳 |
| 741 | 男儿当自强 | 笑傲歌坛 传世经典 | 林子祥 |
| 742 | 上海滩 | 上海滩 | 叶丽仪 |
| 743 | 我和你 | 北京2008 奥运会、残奥会开闭幕式主题歌曲专辑 | 刘欢 / Sarah Brightman |
| 744 | 算你狠 | 绝对收藏 | 陈小春 |
| 745 | 黄种人 | 黄·锋 | 谢霆锋 |
| 746 | Croatian Rhapsody | The Piano Player | Maksim Mrvica |
| 747 | He's a Pirate | Pirates of the Caribbean: The Curse of the Black Pearl | Klaus Badelt |
| 748 | Natural-Imagine Dragons | Origins (Deluxe) | Imagine Dragons |
| 749 | 星月神话 | 女人又一次哭泣 | 金莎 |
| 750 | 夜上海 | 夜上海精选 | 周璇 |
| 751 | 带你去旅行 | 带你去旅行 | 校长（张驰） |
| 752 | 天下第一 | 武侠音乐系列之豪气中天 （截取版） | 麦振鸿 / 罗坚 |
| 753 | 给我一个吻-张露 | 群星会 38 张露 (珍藏系列) | 张露 |
| 754 | '97爱情宣言 | 狼 97黄金自选辑 | 齐秦 |
| 755 | 外面的世界 | 燃烧爱情（狼之旅） | 齐秦 |
| 756 | 小酒窝 | JJ陆 | 林俊杰 / 蔡卓妍 |
| 757 | Past Lives | Drowning | Slushii |
| 758 | 往事随风 | 痛并快乐着 | 齐秦 |
| 759 | Go Time | Go Time | Mark Petrie |
| 760 | Someone to Stay | Someone to Stay | Vancouver Sleep Clinic |
| 761 | The Portrait | Titanic: Special Edition | James Horner |
| 762 | 那年我双手插兜 不知道什么叫做对手 | 那年我双手插兜 不知道什么叫做对手（语录版） | 黑左 / 莎馬淑鳐 / 刘liu创意人 |
| 763 | 你还欠我一个拥抱 | 很有爱 | 后弦 / Sara |
| 764 | Strength of a Thousand Men | Archangel | Two Steps From Hell |
| 765 | 匆匆那年 | 匆匆那年 电影原声带 | 王菲 |
| 766 | 一路 | 匆匆那年 电视原声带 | 白敬亭 / 杨玏 / 杜维瀚 |
| 767 | Spirit of the Wild | Age of Wonders | BrunuhVille |
| 768 | 命运 운명 | 풀 하우스 OST (KBS 미니시리즈) | Why |
| 769 | 青い空に出逢えた(TV Mix) | 中華一番! スペシャルTVオンエアーミックス& ― オリジナル・サウンドトラック | 辻尾有紗 |
| 770 | 大海~ | Asia | THE JAYWALK |
| 771 | 热爱105°C的你 | 热爱105°C的你 | 阿肆 |
| 772 | Flavor Of Life | Flavor Of Life | 宇多田ヒカル |
| 773 | 我的未来不是梦-张雨生 | 6个朋友 | 张雨生 |
| 774 | Death Of Titanic | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 775 | 最浪漫的事-赵咏华 | 我的爱我的梦我的家 | 赵咏华 |
| 776 | 孤勇者_凤凰传奇 | 孤勇者 | 凤凰传奇 |
| 777 | 不如不见 | What's Going On…? | 陈奕迅 |
| 778 | Distant Memories | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 779 | 偏爱 | 破天荒 | 张芸京 |
| 780 | Diamonds | Diamonds | Rihanna |
| 781 | 風の住む街（风居住的街道）-磯村由紀子 | 風の住む街 | 磯村由紀子 |
| 782 | 还有我-任贤齐 | 如果没有你 | 任贤齐 |
| 783 | 绅士-薛之谦 | 绅士 | 薛之谦 |
| 784 | Je m'appelle Hélène | Hélène | Hélène Rolles |
| 785 | 我欲成仙 | 西游记后传片头曲 | 刘欢 |
| 786 | 希望 (国语) | 我是阳光的 | 陈慧琳 |
| 787 | Something Just Like This | Something Just Like This | The Chainsmokers / Coldplay |
| 788 | Children of the Dark | Together Till the End | Mono Inc. / Joachim Witt / Tilo Wolff / Chris Harms |
| 789 | 極楽浄土 | 約束 -Promise code- | GARNiDELiA |
| 790 | 作曲家 | 李荣浩 | 李荣浩 |
| 791 | 辞九门回忆(DJ版) | 未知 | 未知 |
| 792 | Maga-Such a Whore（Maga remix）-Maga | Such a Whore | Maga |
| 793 | 闯将令-香港中乐团 于会咏 胡登跳 | 功夫 电影原声大碟 | 香港中乐团 / 于会咏 / 胡登跳 |
| 794 | 黑暗中的舞者 | 寂静的天空 | 黛青塔娜 / HAYA乐团 |
| 795 | 亲爱的旅人啊-周深 | 亲爱的旅人啊《千与千寻》（Cover 木村弓） | 周深 |
| 796 | 銀の龍の背に乗って | 銀の龍の背に乗って | 中島みゆき |
| 797 | She Is My Sin-Nightwish | Tales from the Elvenpath | Nightwish |
| 798 | To Ramona | The Complete Album Collection Vol.1 | Bob Dylan |
| 799 | Azul | Acoustik Guitar | John H. Clarke |
| 800 | 痴情冢（完整版）-吴严武 | 痴情冢（完整版） | 吴严武 |
| 801 | Opening | 少林足球 电影原声带 | 黄英华 |
| 802 | Feel Me-Selena Gomez | Feel Me | Selena Gomez |
| 803 | Hummell Gets The Rockets | The Rock (Original Motion Picture Score) | Nick Glennie-Smith /Harry Gregson-Williams |
| 804 | 星の下での邂逅-赵大鼾 | 星の下での邂逅 | 赵大鼾 |
| 805 | Impossible-Two Steps From Hell | Unleashed | Two Steps From Hell |
| 806 | Love From Me-Johnson Rodgie | Love From Me | Johnson Rodgie |
| 807 | 猜不透 | 我爱上的 | 丁当 |
| 808 | Samba-Ludovico Einaudi | I Giorni | Ludovico Einaudi |
| 809 | Håll Om Mig-Nanne Grönvall | Melodifestivalen 1958-2013 | Nanne Grönvall |
| 810 | 难却 | 难却 | 平生不晚 |
| 811 | 王招君 (你看你拉住我的模样)(《寻汉计》电影推广曲)-任素汐 | 王招君 (你看你拉住我的模样) | 任素汐 |
| 812 | Old Threads-Deep East Music | Vintage Sunshine | Deep East Music |
| 813 | 萤火之森-CMJ | 萤火之森 | CMJ |
| 814 | 万疆-李玉刚 | 万疆 | 李玉刚 |
| 815 | Opening Credits-Hans Zimmer | Call of Duty: Modern Warfare 2 OST | Hans Zimmer |
| 816 | Samsara-Tungevaag & Raaban | Club Sounds Vol.73 | Tungevaag & Raaban |
| 817 | The X-Files (Original Version)-Mark Snow | The X Files? | Mark Snow |
| 818 | BOOM-Tiësto / Sevenn | BOOM | Tiësto / Sevenn |
| 819 | 初识太极 | 太极张三丰 电影原声带 | 胡伟立 |
| 820 | At Anchor | The Airship | Port Blue |
| 821 | 难却 (DJ版0.85x|待上浓妆好戏开场) | 难却 | 平生不晚 |
| 822 | 我要你(电影《驴得水》主题曲)-任素汐 | 我要你 | 任素汐 |
| 823 | Special Ops-Silver Screen | Under Siege | Silver Screen |
| 824 | Frontier-Doctor Vox | Level Up | Doctor Vox |
| 825 | Electric Romeo | Themes for Orchestra and Choir 2 - Abbey Road | Immediate Music |
| 826 | 賭神 | 赌神 电影原声 | 卢冠廷 |
| 827 | 姑娘别哭泣（弹唱版）-柯柯柯啊 | 姑娘别哭泣 | 柯柯柯啊 |
| 828 | Time (Official)-MKJ | Time After Time | MKJ |
| 829 | The Next Episode | The Next Episode | Dr. Dre / Snoop Dogg / Kurupt / Nate Dogg |
| 830 | 驼铃-刀郎 | 披着羊皮的狼 | 刀郎 |
| 831 | 爱要坦荡荡 (Live)-丁丁 | 《中国好声音》2012跨年演唱会 | 丁丁 |
| 832 | Italia e voi（Orginal Mix）-HSHK | Italia e voi | HSHK / 贰皮 / VodKa / Pnan |
| 833 | かごめと犬夜叉 | TVアニメーション「犬夜叉」オリジナルサウンドトラックアルバム「犬夜叉 音楽篇」 | 和田薫 |
| 834 | 비오는 소리 (Intro)下雨的声音-July | To Heaven | July |
| 835 | 北国之春-邓丽君 | 邓丽君 纪念特别专辑 第二辑 | 邓丽君 |
| 836 | アシタカせっ記 (The Legend of Ashitaka)-久石让 | もののけ姫 イメージアルバム | 久石让 (ひさいし じょう) |
| 837 | Winter Without You-Gloria Kim | Winter Without You | Gloria Kim |
| 838 | Run Me Out-Zola Jesus | How to Get Away with Murder | Zola Jesus |
| 839 | Pilgrimage-Jannik | Pilgrimage Epic Orchestral | Jannik |
| 840 | We No Speak Americano(UK Radio Edit)-Yolanda Be Cool | We No Speak Americano | Yolanda Be Cool |
| 841 | 芦苇荡(电影《大话西游》插曲)-赵季平 | 热门华语20 | 赵季平 |
| 842 | Deflagration-Silver Screen | Under Siege | Silver Screen |
| 843 | The Boys | 'The Boys' The 3rd Album | 少女时代 |
| 844 | Wicked Wonderland (Radio Edit)-Martin Tungevaag | Wicked Wonderland | Martin Tungevaag |
| 845 | 幽默-胡伟立 | 九品芝麻官之白面包青天 电影原声 | 胡伟立 |
| 846 | Alone-Alan Walker | Alone | Alan Walker |
| 847 | Time Back-Bad Style | 最新热歌慢摇63 | Bad Style |
| 848 | Numb Encore | Look Out For Detox | Dr. Dre / 50 Cent / JAY-Z / Eminem / Linkin Park |
| 849 | Star Sky-Two Steps From Hell | Battlecry | Two Steps From Hell |
| 850 | Oceanside | Melody Lane | Lainey Lou |
| 851 | One Day In Spring | One Day In Spring | Bandari |
| 852 | Deadwood-Really Slow Motion | Deadwood | Really Slow Motion |
| 853 | Promises | Promises | Ryn Weaver |
| 854 | 我知道-By2 | Twins | By2 |
| 855 | Between Worlds | X I I | Roger Subirana |
| 856 | Dream It Possible | Dream It Possible | Delacey |
| 857 | 桔梗谣-金栄実 | 伽倻琴演奏《与你一起》 | 金栄実 |
| 858 | 桔梗谣-이금미 | Korea: Folk Songs I - Songs Of Kyonggido District | 이금미 |
| 859 | Simon Birch | The Bucket List (Original Motion Picture Soundtrack) | Marc Shaiman |
| 860 | Firework | Teenage Dream | Katy Perry |
| 861 | Everything at Once | Two | Lenka |
| 862 | 口弦-妙子 | 独家爱唱Ⅲ | 妙子 |
| 863 | Murder In My Mind-Kordhell | Murder In My Mind | Kordhell |
| 864 | Once Upon a Time in America: Deborah's Theme-Ennio Morricone | The Grandmaster (Original Score) | Ennio Morricone |
| 865 | Morsmordre-Crazy Donkey | Morsmordre | Crazy Donkey |
| 866 | 旅行的意义(TRAVEL IS MEANINGFUL) | 渺渺 电影原声 | 陈绮贞 |
| 867 | 空 (TV Mix) | 中華一番! スペシャルTVオンエアーミックス& ― オリジナル・サウンドトラック | 大黒摩季 |
| 868 | 模特 | 模特 | 李荣浩 |
| 869 | FourFiveSeconds | FourFiveSeconds | Rihanna / Kanye West / Paul McCartney |
| 870 | Anacreon-Bear McCreary | Foundation: Season 1 (Apple TV+ Original Series Soundtrack) | Bear McCreary |
| 871 | 风居住的街道（Piano ver） (翻自 磯村由紀子）-饭碗的彼岸 | Piano Cover | 饭碗的彼岸 |
| 872 | 爱转角 | Best Show | 罗志祥 |
| 873 | Like That-Bea Miller | Chapter Two: Red | Bea Miller |
| 874 | Take Me Home Country Roads-John Denver | Take Me Home: The John Denver Story | John Denver |
| 875 | Maps | Maps | Maroon 5 |
| 876 | One Match-Sarah Harmer | oh little fire | Sarah Harmer |
| 877 | 半生雪-七叔-叶泽浩 | 半生雪 | 七叔-叶泽浩 |
| 878 | MR.TAXI(Korean ver.) | 'The Boys' The 3rd Album | 少女时代 |
| 879 | Gentle-Isaac Shepard | Deep Joy | Isaac Shepard |
| 880 | 故人泪-麦小兜 | 故人泪 | 麦小兜 |
| 881 | May It Be-Bandari | MistyLand | Bandari |
| 882 | 赤伶-李玉刚 | 赤伶 | 李玉刚 |
| 883 | My Songs Know What You Did In The Dark (Light Em Up) (2 Chainz Remix) | My Songs Know What You Did In The Dark (Light Em Up) | Fall Out Boy |
| 884 | River Flows In You | Tales Of Dusk And Dawn Chapter II | Various Artists |
| 885 | Roar | Roar | Katy Perry |
| 886 | Just Blue-Space | Just Blue | Space |
| 887 | Secrets AMFB Onerepublic | Time Machine (Part 1) | Bryson Andres |
| 888 | The Telephone Box | The Magic Empire | Uniform Motion |
| 889 | Why-Sabrina Carpenter | Why | Sabrina Carpenter |
| 890 | Sunrise | waiting for the light | Catie Mckinney |
| 891 | Walk on By-Noosa | Wonderland | Noosa |
| 892 | 映山红-刀郎 | 红色经典 | 刀郎 |
| 893 | Liberators-Epic Score | Vengeance - ES033 | Epic Score |
| 894 | Dismantle-Peter Sandberg | Dismantle | Peter Sandberg |
| 895 | Older-Sasha Alex Sloan | Older | Sasha Alex Sloan |
| 896 | Radius-Hi-Finesse | Axiom | Hi-Finesse |
| 897 | The Final Countdown | The Final Countdown: The Best Of Europe | Europe |
| 898 | Hyacinth-July | In Love | July |
| 899 | 遺憾-陈洁仪 | 重譯 陳潔儀.重奏 | 陈洁仪 |
| 900 | One More Light(又一道光芒)-Linkin Park | One More Light | Linkin Park |
| 901 | 敢问路在何方-刀郎 | 电视剧新西游记主题曲 | 刀郎 |
| 902 | 时を越えて かごめ | 犬夜叉 音楽撰集 | 和田薫 |
| 903 | The Party Troll-D1ofaquavibe | The Party Troll | D1ofaquavibe |
| 904 | Novera-Dark Winter Music | Epic World Volume2 Return 归来(2014) | Dark Winter Music |
| 905 | SCARSONG-flash8 | 最新热歌慢摇3 | flash8 |
| 906 | Concerto No. 4 in F minor, Op. 8, RV 297, "L'inverno" (Winter): II. Largo | The Four Seasons: The Vivaldi Album | Anne Akiko Meyers / English Chamber Orchestra / David Lockington |
| 907 | Somewhere | Somewhere | July |
| 908 | If We Ever Broke Up-Mae Stephens | If We Ever Broke Up | Mae Stephens |
| 909 | Close Eyes (Slowed + Reverb)-DVRST | Close Eyes (Slowed + Reverb) | DVRST |
| 910 | 别再闹了(电影《来电狂响》暖冬主题曲)-毛不易 | 别再闹了 | 毛不易 |
| 911 | Look4You-Alberto Ciccarini | Look4You | Alberto Ciccarini |
| 912 | 北国の春-木村好夫 | 木村好夫-ギター演歌名曲全集2 | 木村好夫 |
| 913 | Future Funk-Varien | Pick Your Poison Vol. 01 | Varien |
| 914 | Balenciaga-T3nzu | Balenciaga | T3nzu |
| 915 | A Quiet Departure-Josh Leake | Benjamin | Josh Leake |
| 916 | A Mozart Reincarnated-Ennio Morricone | La Leggenda del Pianista Sull'oceano | Ennio Morricone |
| 917 | Best Moments (feat. Kondor)-Blazo | Alone Journey | Blazo |
| 918 | Becoming a Legend-John Dreamer | Becoming a Legend - Single | John Dreamer |
| 919 | Beloved-Dan Gibson | Native Harmony | Dan Gibson |
| 920 | Brotherhood-John Dreamer | Brotherhood | John Dreamer |
| 921 | Hello Zepp-Charlie Clouser | Saw (Original Motion Picture Soundtrack) | Charlie Clouser |
| 922 | RAVE-Dxrk ダーク | RAVE | Dxrk ダーク |
| 923 | Golden Key-Isgaard | Golden Key [#2] | Isgaard |
| 924 | Eye of the Tiger-Survivor | Eye Of The Tiger | Survivor |
| 925 | 遗憾(新加坡电视剧《实况剧场》主题曲)-许美静 | 遗憾 | 许美静 |
| 926 | Famous-Ivy Adara | Famous | Ivy Adara |
| 927 | 耍猴儿(百鬼夜行) (唢呐版)-Harry来了 | 未知 | Harry来了 |
| 928 | 无问(电影《无问西东》宣传曲)-毛不易 | 无问 | 毛不易 |
| 929 | 1901-Birdy | Birdy (Deluxe Version) | Birdy |
| 930 | 2002 (Acoustic)-Amber Leigh Irish | Unplugged Acoustic, Vol. 2 | Amber Leigh Irish |
| 931 | golden hour-JVKE | this is what ____ feels like (Vol. 1-4) | JVKE |
| 932 | The Black Rose-Joanie Madden | Celtic Twilight 2 | Joanie Madden |
| 933 | My Sunset (Original Mix)-Feint | Feint EP2 | Feint |
| 934 | 雨空-α·Pav | Colors | α·Pav |
| 935 | Tuesday-Burak Yeter Danelle | Dance 2017 - Armada Music | Burak Yeter / Danelle |
| 936 | Welcome to Jurassic World(电影《侏罗纪世界》配乐)-Michael Giacchino | Jurassic World (Original Motion Picture Soundtrack)- (侏罗纪世界) | Michael Giacchino |
| 937 | PDD洪荒之力-Hoaprox | #Lov3 #Ngẫu Hứng | Hoaprox |
| 938 | 告白之夜（纯音乐）-CMJ | 告白の夜 | CMJ |
| 939 | You-Approaching Nirvana | Blocking the Sky Redux | Approaching Nirvana |
| 940 | Whisper Of Hope (Main)-Gothic Storm | Epic Emotional Piano | Gothic Storm |
| 941 | The Imperial March(帝国进行曲)-John Williams | Music from the Star Wars Saga- (星球大战) | John Williams |
| 942 | Young Hearts-Dirk Reichardt | Kokowääh 2 (Original Motion Picture Soundtrack) | Dirk Reichardt |
| 943 | James Bond Theme-John Barry Monty Norman | Dr. No (Original Motion Picture Soundtrack) | John Barry / Monty Norman |
| 944 | A Little Bit Broken-Spritely | A Little Bit Broken | Spritely |
| 945 | メインテーマ「永遠の一瞬」（主题「永恒的一瞬」）-伊藤賢治 | この青空に約束をー~ようこそつぐみ寮へ~Piano Stories | 伊藤賢治 |
| 946 | 潮鳴り-折戸伸治 | CLANNAD ORIGINAL SOUNDTRACK | 折戸伸治 |
| 947 | The Pink Panther Theme-Henry Mancini | In the Pink | Henry Mancini |
| 948 | 白いスーツのテーマ(白色西装主题曲)-市川淳 | TBS系 金曜ドラマ うぬぼれ刑事 オリジナル・サウンドトラック | 市川淳 |
| 949 | 穿越时空的爱恋-CMJ | 穿越时空的爱恋 | CMJ |
| 950 | 像我这样的人-毛不易 | 平凡的一天 | 毛不易 |
| 951 | 北国の春(北国之春)-渥美二郎 | 全日傳 砂金之卷+鉑環之卷 | 渥美二郎 |
| 952 | Dusk Till Dawn | Piano Acoustic Covers Vol 2 | Kurt Hugo Schneider / Kirsten Collins / Blake Rose |
| 953 | Dreamland-Liquid Mind | Liquid Mind XI: Deep Sleep | Liquid Mind |
| 954 | 浮光 (The History)-Jannik | 浮光 (The History) | Jannik |
| 955 | Criminals-F.O.O.L | Revenger | F.O.O.L |
| 956 | P.I.M.P-TangTian | P.I.M.P | TangTian |
| 957 | 王进打高俅-赵季平 | 水浒传 原声音乐 | 赵季平 |
| 958 | 平凡的一天-毛不易 | 平凡的一天 | 毛不易 |
| 959 | 无名的人(电影《雄狮少年》主题曲)-毛不易 | 无名的人 | 毛不易 |
| 960 | 流浪者之歌-Budapest Festival Orchestra 诹访内晶子 | 惠威试音专用Ⅱ | Budapest Festival Orchestra / 诹访内晶子 |
| 961 | 恨爱交加-麦振鸿 | 天地传说之创世纪乐章 | 麦振鸿 |
| 962 | 消愁-毛不易 | 平凡的一天 | 毛不易 |
| 963 | 高山流水-王昌元 | 中国古筝名家名曲——中国民族器乐精品系列 | 王昌元 |
| 964 | 美丽拍挡-胡伟立 | 国产凌凌漆 | 胡伟立 |
| 965 | Polska-Sava | Aire | Sava |
| 966 | 金三角 (恐怖纯音乐) | 金三角（恐怖纯音乐） | R̶ᴇ̶ɢ̶ʀ̶ᴇ̶ᴛ̶. |
| 967 | sans.-Toby Fox | UNDERTALE Soundtrack | Toby Fox |
| 968 | 一荤一素-毛不易 | 平凡的一天 | 毛不易 |
| 969 | 一程山路-毛不易 | 小王 | 毛不易 |
| 970 | 夏夜-四季音色 | 春夏之交，轻旋淡律 | 四季音色 |
| 971 | 人形の館-岩崎琢 | 黒執事 サウンドコンプリート BLACK BOX | 岩崎琢 |
| 972 | Single Ladies (Put a Ring on It)-Beyoncé | Single Ladies (Put A Ring On It) - Dance Remixes | Beyoncé |
| 973 | 十面埋伏(琵琶独奏)-群星 | 中国古典音乐历朝黄金年鉴 | 群星 |
| 974 | 她的微笑 (original Mix)-阳山伟伟 | 她的微笑 (original Mix) | 阳山伟伟 |
| 975 | 西楼别序-尹昔眠 / 小田音乐社 | 西楼别序 | 尹昔眠 / 小田音乐社 |
| 976 | 青天-胡伟立 | 九品芝麻官之白面包青天 电影原声 | 胡伟立 |
| 977 | 青空-Candy_Wind | 拂晓车站 | Candy_Wind |
| 978 | 勇往直前-胡伟立 | 唐伯虎点秋香 | 胡伟立 |
| 979 | 遗憾-李代沫 | 我的歌声里 | 李代沫 |
| 980 | 执迷不悟-铁脑袋mp3 | 执迷不悟 | 铁脑袋mp3 |
| 981 | 小心な侵入者-根岸貴幸 | カードキャプターさくら オリジナル・サウンドトラック4 | 根岸貴幸 |
| 982 | 小鱼儿与花无缺片头音乐-麦振鸿 | 武侠音乐系列之豪气中天 （截取版） | 麦振鸿 |
| 983 | 雨的舞步-赵大鼾 | 雨的舞步 | 赵大鼾 |
| 984 | Lost Love (Instrumental)-Lunnna Janey杰尼 | Memories | Lunnna / Janey杰尼 |
| 985 | 起风了(BILIBILI 11周年演讲)-周深 | 起风了 | 周深 |
| 986 | Theme from Mission: Impossible-Danny Elfman | Mission Impossible [Original Score] | Danny Elfman |
| 987 | 匆匆那年-周深 | 匆匆那年 | 周深 |
| 988 | Dum Dum Dum-RENEE | Extending Playground | RENEE |
| 989 | Theme From Jurassic Park (From "Jurassic Park" Soundtrack)-John Williams | Jurassic Park (Soundtrack) | John Williams |
