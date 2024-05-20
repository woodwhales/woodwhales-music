# woodwhales-music

[![](https://img.shields.io/badge/author-woodwhales-green.svg)](https://music.icoders.cn) ![](https://img.shields.io/badge/license-GPL%203.0-orange.svg)

> 基于 SpringBoot 的开源超简洁音乐播放器
> 
> A open source Music Player developed based on Java Springboot

<div align=center>在线播放：<a href="https://music.icoders.cn">https://music.icoders.cn</a></div>

环境要求：JDK1.8

技术栈：springboot + thymeleaf + layui + spring security + jsoup + mybatis plus + mySQL

## 1. 前台效果图

dev 环境：http://127.0.0.1:8084/

![](doc/images/index.png)

## 2 后台效果图

dev 环境：http://127.0.0.1:8084/music/admin/

dev 环境账号密码：admin / admin

### 2.1 首页

![](doc/images/admin-index.png)

音乐名称为<font color='gree'>绿色字体</font>，表示该音乐**已关联**音频链接和专辑封面链接。

音乐名称为<font color='red'>红色字体</font>，表示该音乐**未关联**音频链接和专辑封面链接。

### 2.2 登录页面

#### 2.2.1 账号密码登录

![](doc/images/admin-sign-in.png)

#### 2.2.2 2FA认证

![](doc/images/admin-2FA.png)

### 2.3 添加/编辑

太懒了，加了个解析音乐平台的解析器，一旦解析成功，自动填充：音乐名称、作者、专辑名称。

> 支持：网易云、QQ 音乐、虾米音乐（平台已关闭）
>
> 建议开发者自行搭建 [alist](https://github.com/alist-org/alist) 并维护音乐源文件

![](doc/images/admin-add.png)

### 2.4 解析

1. 复制要解析的 html 源码。

2. 选择要解析的平台，粘贴 html 源码，点击解析：

![](doc/images/admin-add-parse.png)

#### 2.4.1 网易云

class 为：`g-bd4 f-cb`的 html 源码

![](doc/images/admin-add-wangyiyun.png)

#### 2.4.2 QQ 音乐

class 为：`main`的 html 源码

![](doc/images/admin-add-qqmusic.png)

#### 2.4.3 虾米（平台已关闭）

class 为：`page-container`的 html 源码

![](doc/images/admin-add-xiami.png)

### 2.5 系统配置

#### 2.5.1 首页配置

![](doc/images/admin-sys-config-index.png)

#### 2.5.2 后台配置

![](doc/images/admin-sys-config-admin.png)

#### 2.5.3 用户配置

![](doc/images/admin-sys-config-user.png)

## 2. 系统说明

### 2.1 配置文件

#### 2.1.1 SQL 文件

文件位置：

- woodwhales-music/doc/sql/open_music_适用高于v3.6.0版本.sql
- woodwhales-music/doc/sql/open_music_适用高于v3.6.0版本_只含库表结构.sql
- woodwhales-music/doc/sql/open_music_适用高于v3.6.0版本_只含数据.sql

文件说明：

- 不建议使用低于 v3.6.0 版本的 SQL 文件
- 只导入库表结构，则使用：open_music_适用高于v3.6.0版本_只含库表结构.sql
- 导入数据，则使用：open_music_适用高于v3.6.0版本_只含数据.sql，开发者可导入后从后台页面做批量删除操作。

#### 2.1.2 系统配置

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

### 2.2 编译打包

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

## 3. 功能说明

### v3.6.3

- 后台首页增加系统配置快捷按钮，跳转至系统配置管理页面，可实时动态修改：

  - 首页的底部版权信息和 GitHub Corners 可进行
  - 后台页面公共头部的 icon 跳转首页链接配置

- 修复在 jdk17 版本以上编译失败

### v3.6.2

- 重构后台页面头
- 后台页面头增加跳转前台页面链接

### v3.6.1

- 后台音乐列表支持可排序列：排序、创建时间、更新时间
- 首页增加增加 GitHub Corners，可以通过 application.yml 自定义配置：是否展示，github 链接
- 修复开发环境后台列表查询数据接口响应失败

### v3.6.0

- **与低于 v3.6.0 版本的库表不兼容，请使用 doc 中的 [open_music_适用高于v3.6.0版本.sql](./doc/sql/open_music_适用高于v3.6.0版本.sql) 进行库表数据初始化操作**

    > 低于  v3.6.0 版本的库表数据初始化 SQL： [open_music_适用低于v3.6.0版本.sql](./doc/sql/open_music_适用低于v3.6.0版本.sql) 

- 后台 UI 页面全面升级（使用 vue + element-ui 进行重构）

- 列表查询、新增、编辑音乐页面增加播放 APlayer 播放器，可支持实时听音乐

- 音乐链接支持 github、alist 来源

### v3.5.5

- 修复 cdn.jsdelivr.net 因未翻墙而无法访问题
- woodwhales-common 版本依赖更新

###  v3.5.0

- 引入 [woodwhales-common](https://github.com/woodwhales/woodwhales-common) 依赖

### v3.0.0

- 支持导出已关联音乐清单。

### v2.0.0

-   添加、编辑音乐信息时，当填写了音乐链接或者封面链接其中之一后，可自动填充另外一个文本内容。

### v1.0.0

-   前端页面加载完毕，可离线播放。
-   后台系统可添加、编辑、删除音乐，并对音乐列表排序。
-   添加音乐：可从音乐平台 html 动态解析，支持：网易云、QQ云音乐、虾米音乐（平台已关闭）。

## 4. 歌单

已收录 1113 首音乐

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
| 125 | 你把我灌醉-G.E.M.邓紫棋 | The Best of G.E.M. 2008 - 2012 (Deluxe Version) | G.E.M.邓紫棋 |
| 126 | 傲气傲笑万重浪 | 黄飞鸿系列电影原声精装版 | 黄霑 |
| 127 | 倩女幽魂 | Ultimate | 张国荣 |
| 128 | Angolan Women | Life In a Day (O.S.T) | The Three Angolan Women |
| 129 | 清明雨上 | 自定义 | 许嵩 |
| 130 | Last Dance (Live)-五条人 | 乐队的夏天2 第7期 | 五条人 |
| 131 | A Day In The Life (Remastered)-The Beatles | Sgt. Pepper's Lonely Hearts Club Band (Remastered) | The Beatles |
| 132 | That Girl | 24 HRS (Deluxe) | Olly Murs |
| 133 | Set Fire to the Rain | 21 | Adele |
| 134 | 小情歌 | 小宇宙 | 苏打绿 |
| 135 | 阳光总在风雨后 | 都是夜归人 | 许美静 |
| 136 | Day by Day | 마녀유희 OST | 赵冠宇 |
| 137 | The Sound of Silence (Album Version) | Forever Friends 'Just For You' | Simon & Garfunkel |
| 138 | Refrain | Eternal Light | 阿南亮子 (あなん りょうこ) |
| 139 | 盛夏的果实 | 莫后年代 莫文蔚20周年世纪典藏 | 莫文蔚 |
| 140 | 若把你 | 若把你 | Kirsty刘瑾睿 |
| 141 | Dark Paradise | Born To Die (Deluxe Version) | Lana Del Rey |
| 142 | Dirty Paws | Summer Acoustic | Of Monsters And Men |
| 143 | Miracle In The Middle Of My Heart (Original Mix) | Miracle In The Middle Of My Heart (Original Mix) | Clément Bcx |
| 144 | 老朋友 | 老朋友 | 杨尘,王旭(旭日阳刚) |
| 145 | Whistle | Glee: The Music - The Complete Season Four | Glee Cast |
| 146 | She | 7 Years and 50 Days | Groove Coverage |
| 147 | 十月：我和曾经的我们 | 迷藏 | 钟城 / 姚望 |
| 148 | Stronger | Kids Top 20 - De Grootste Hits Van 2013 - Summer Edition 2013 | Kelly Clarkson |
| 149 | A Penny At A Time | Life In A Day OST | Matthew Herbert |
| 150 | The Immigrant | Song of the Irish Whistle | Joanie Madden |
| 151 | 家族の风景 | 虹の歌集 | 手嶌葵 |
| 152 | 爱拼才会赢 | 爱拼才会赢 | 叶启田 |
| 153 | 我只在乎你-刘惜君 | 惜 . 君 | 刘惜君 |
| 154 | 单身情歌 | 单身情歌．超炫精选 | 林志炫 |
| 155 | 丑八怪 | 意外 | 薛之谦 |
| 156 | 沧海一声笑 | 沧海一声笑 | 许冠杰 |
| 157 | 桔梗谣 | 桔梗谣 | 阿里郎 |
| 158 | Intro | xx | The xx |
| 159 | Need You Now | iTunes Session | Lady A |
| 160 | 父亲 | 父亲 | 筷子兄弟 |
| 161 | 桔梗谣 | 织谣 | 斯琴格日乐 |
| 162 | 盗墓笔记·十年人间-李常超（Lao乾妈） | 盗墓笔记·十年人间 | 李常超（Lao乾妈） |
| 163 | 姑娘在远方 | 姑娘在远方 | 柯柯柯啊 |
| 164 | Anacreon-Bear McCreary | Foundation: Season 1 (Apple TV+ Original Series Soundtrack) | Bear McCreary |
| 165 | 湘江中路-庄达菲 | 湘江中路 | 庄达菲 |
| 166 | 夜空中最亮的星 | 世界 | 逃跑计划 |
| 167 | 般若波罗蜜多心经 | 《大唐玄奘》电影片尾曲 | 王菲 |
| 168 | 彩云之南 | 彩云之南 | 徐千雅 |
| 169 | 合肥的石头 | 赤脚青春 | 飘乐队 |
| 170 | 似夜流月 | 热门华语234 | 宗次郎 (そうじろう) |
| 171 | 北国之春 (日文版)-邓丽君 | 邓丽君15周年但愿人长久 | 邓丽君 |
| 172 | A Day in the Life-John Lennon | Imagine: John Lennon | John Lennon |
| 173 | Caribbean Blue 加勒比海蓝 | Moonlight Bay | Bandari |
| 174 | Five hundred miles | America, Vol. 10: Country - The Folk Revival Revolution | The Journeymen |
| 175 | Right Now (Na Na Na) | Right Now (Na Na Na) | Akon |
| 176 | Victory | Battlecry | Two Steps From Hell |
| 177 | 桔梗谣(道拉基) (朝鲜民谣) | 恋恋金达莱 | 蒋薇 |
| 178 | Down By the Salley Gardens | Song of the Irish Whistle | Joanie Madden |
| 179 | 追梦人 | 浮世情怀 | 凤飞飞 |
| 180 | 小鱼儿的思绪 | 武侠音乐系列第二部之思情篇（截取版） | 麦振鸿 |
| 181 | 故乡 | 我只有两天.许巍精选 | 许巍 |
| 182 | Bubbly | So Fresh - The Hits Of Autumn 2008 | Colbie Caillat |
| 183 | 勇敢的心 | 勇敢的心 | 汪峰 |
| 184 | 我很好 | I'm fine | 刘沁 |
| 185 | 江南 | 他是…JJ林俊杰 | 林俊杰 |
| 186 | 年少有为 | 耳朵 | 李荣浩 |
| 187 | Price Tag | Price Tag | Jessie J / B.o.B |
| 188 | The Sound of Silence_轻音乐 | The Best Pan Pipes in the World...Ever! | Panpipes |
| 189 | Eversleeping | Eversleeping | Xandria |
| 190 | Breaking My Heart | Unreleased | Lana Del Rey |
| 191 | Dying In the Sun | Bury the Hatchet | The Cranberries |
| 192 | See You Again | See You Again | See You Again |
| 193 | I Am You | I Am You | Kim Taylor |
| 194 | I'm Yours | I'm Yours | Jason Mraz |
| 195 | Innocence | The Best Damn Thing: Deluxe Edition | Avril Lavigne |
| 196 | 如果这都不算爱-张学友 | 学友 热 | 张学友 |
| 197 | 一生所爱 | 齐天周大圣之西游双记 电影歌乐游唱版 | 卢冠廷 / 莫文蔚 |
| 198 | 潇洒地走 | 潇洒地走 | 张蔷 |
| 199 | Apologize | Dreaming Out Loud (Tour Edition) | OneRepublic |
| 200 | Better Than One | The Score EP 2 | The Score |
| 201 | 停格 | 停格 | 蔡健雅 |
| 202 | When You're Gone | When You're Gone | Avril Lavigne |
| 203 | Astronomia | Astronomia | Vicetone / Tony Igy |
| 204 | 容易受伤的女人 | 阿菲正传 | 王菲 |
| 205 | River Flows In You | Kuschelklassik Piano Dreams, Vol. 2 | Martin Ermen |
| 206 | 倔强 | 神的孩子都在跳舞 | 五月天 |
| 207 | 牛仔很忙 | 我很忙 | 周杰伦 |
| 208 | 凄美地-郭顶 | 飞行器的执行周期 | 郭顶 |
| 209 | 面会菜-林生祥 | [大佛普拉斯] 电影配乐 | 林生祥 |
| 210 | 当爱在靠近 | Love & the City | 刘若英 |
| 211 | 日晷之梦 | 幸福时光 精选辑 | Kevin Kern |
| 212 | Last Reunion | Lament of Valkyrie (Epicmusicvn Series) | Peter Roe |
| 213 | 起风了 | 起风了 | 吴青峰 |
| 214 | Concerning Hobbits | The Lord of the Rings: The Fellowship of the Ring (Original Motion Picture Soundtrack) | Howard Shore |
| 215 | 叱咤红人 | 相依为命: 20年精彩印记 | 陈小春 |
| 216 | 天才白痴梦 | 天才与白痴 | 许冠杰 |
| 217 | 分手以后才知道最珍贵 | 回到家乡 | 胡力 |
| 218 | 往事只能回味 | 怀念老歌一 | 高胜美 |
| 219 | 原来你也在这里 | 我的失败与伟大 | 刘若英 |
| 220 | 我这家伙的答案是你 | AsuRa BalBalTa | Leessang / 河琳 |
| 221 | 往事只能回味 | 我是歌手第四季 第9期 | 金志文 |
| 222 | 勇敢的心 | 最新热歌慢摇88 | Various Artists |
| 223 | 等一分钟 | 滕爱Teng Love | 徐誉滕 |
| 224 | 我想大声告诉你 (《蜗居》电视剧片尾曲) | 我想大声告诉你 | 樊凡 |
| 225 | 光阴的故事 | 光阴的故事 | 黄晓明 邓超 佟大为 |
| 226 | 越长大越孤单 | 越长大越孤单 | 牛奶咖啡 |
| 227 | 往事只能回味 | 说时依旧 | 好妹妹 |
| 228 | 知足 | 知足 最真杰作选 | 五月天 |
| 229 | 一起摇摆 | 生来彷徨 | 汪峰 |
| 230 | 演员 | 绅士 | 薛之谦 |
| 231 | 南方姑娘 | 赵小雷 | 赵雷 |
| 232 | 我最亲爱的 | 你在看我吗 | 张惠妹 |
| 233 | 篇章-张韶涵 / 王赫野 | 篇章 | 张韶涵 / 王赫野 |
| 234 | 你的样子 | 罗大佑自选辑 | 罗大佑 |
| 235 | 문을 여시오 (New Ver.) 请开门 | 문을 여시오 | 任昌丁 / 金昌烈 |
| 236 | Cornfield Chase | Interstellar (Original Motion Picture Soundtrack) | Hans Zimmer |
| 237 | Riverside | Philharmonics (Deluxe Edition) | Agnes Obel |
| 238 | Gotta Have You | Say I Am You | The Weepies |
| 239 | Big Big World | Big Big World | Emilia |
| 240 | 认错 | 自定义 | 许嵩 |
| 241 | My Heart Will Go On | Love Ballads | Kenny G |
| 242 | 月光下的凤尾竹 (葫芦丝) | 金耳朵.发烧民乐 | 纯音乐 |
| 243 | Love The Way You Lie | Life After Recovery | Eminem / Rihanna |
| 244 | 好汉歌 | 好汉歌 | 刘欢 |
| 245 | 布拉格广场 | 看我72变 | 蔡依林 / 周杰伦 |
| 246 | 粉红色的回忆 | 粉红色的回忆 | 韩宝仪 |
| 247 | 大敦煌-刀郎 | 谢谢你 | 刀郎 |
| 248 | Childhood Memory 童年 | Sunny Bay | Bandari |
| 249 | Dream Catcher 追梦人 | Relaxation - Dreams | Bandari |
| 250 | 小苹果 | 老男孩之猛龙过江 电影原声 | 筷子兄弟 |
| 251 | 穿越时空的思念 (DiESi Remix) | 穿越时空的思念 | DiESi |
| 252 | Hello | Hello | Adele |
| 253 | Chiru (Saisei No Uta) | Nostalgic | Robert de Boron |
| 254 | Southampton | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 255 | 雪见·落入凡尘 | 仙剑奇侠传三 电视剧原声带 | 麦振鸿 |
| 256 | 时间都去哪儿了 | 听得到的时间 | 王铮亮 |
| 257 | 土耳其进行曲 | 土耳其进行曲 | Various Artists |
| 258 | That's Not My Name | That's Not My Name | The Ting Tings |
| 259 | The Mountain of Women | Song of the Irish Whistle | Joanie Madden |
| 260 | Hymn To The Sea | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 261 | Don't push me | Jade - silver edition | sweetbox |
| 262 | Just Give Me A Reason | The Truth About Love | P!nk Nate Ruess |
| 263 | いつも何度でも | Prime Selection | 宗次郎 |
| 264 | 光年之外 | 光年之外 | G.E.M.邓紫棋 |
| 265 | 差生 | 少年中国 | 李宇春 |
| 266 | 人民不需要自由 | 108个关键词（李志的自我修养2012年度汇报演出） | 李志 |
| 267 | Nocturne No. 2 in E Flat Major, Op. 9, No. 2 | The Chopin Collection: The Nocturnes | Arthur Rubinstein |
| 268 | 青花瓷 | 我很忙 | 周杰伦 |
| 269 | Beyond The Memory | Beyond The Memory | July |
| 270 | 十年 | 黑白灰 | 陈奕迅 |
| 271 | 送别 | 送别 | 朴树 |
| 272 | 曹操 | 曹操 | 林俊杰 |
| 273 | 一辈子的孤单 | 涩女郎 电视原声带 | 刘若英 |
| 274 | 黑板情书 | 黑板情书 | 后弦 |
| 275 | I can't let this go on any further | I can't let this go on any further | Savior |
| 276 | 因为爱情 | Stranger Under My Skin | 陈奕迅 王菲 |
| 277 | New Morning 清晨 | Mist | Bandari |
| 278 | Love the Way You Lie Part III (Original Demo) | Don't Look Down | Skylar Grey |
| 279 | 我从崖边跌落 | 算云烟 | 谢春花 |
| 280 | 往事只能回味 | 往事只能回味 | 岳云鹏 / 宋小宝 |
| 281 | 兰亭序 (慢四版)-周杰伦 | 兰亭序 | 周杰伦 |
| 282 | 君が好きだと叫びたい~TV Version~（好想大声说爱你）-BAAD | Slam Dunk Complete Vocal Collection ~TV Version~ | BAAD |
| 283 | 我只在乎你-齐秦 | 柒年·七个音乐故事 | 齐秦 |
| 284 | それが大事（最重要的事） | それが大事 | 大事MANブラザーズバンド / 渡辺禎史 |
| 285 | Never An Absolution | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 286 | Rose | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 287 | Secrets | Secrets | OneRepublic |
| 288 | 突然的自我 | 忘情1015精选辑 | 伍佰 & China Blue |
| 289 | 赤木の不安-徳永暁人 | Slam Dunk Complete Vocal Collection ~TV Version~ | 徳永暁人 |
| 290 | 春风十里 | 所有的酒，都不如你 | 鹿先森乐队 |
| 291 | Roses and Gold | Dust Diaries | Robin Jackson |
| 292 | Yesterday Once More | Yesterday Once More | Carpenters |
| 293 | 星座书上 | 自定义 | 许嵩 |
| 294 | 粉末 | 粉末 | 李宇春 |
| 295 | 苏州城外的微笑 | 很有爱 | 后弦 |
| 296 | Hey Jude | It's a Battle | John Lennon / Paul McCartney / It's a Cover Up |
| 297 | 天下 | 明天过后 | 张杰 |
| 298 | Last Dance | 爱情的尽头 | 伍佰 & China Blue |
| 299 | May It Be(电影《指环王：魔戒再现》插曲)-Enya | The Lord of the Rings: The Fellowship of the Ring (Original Motion Picture Soundtrack) | Enya |
| 300 | The 1950's-Zhao Jiping | Lifetimes (Vivre!) [Original Motion Picture Soundtrack] | Zhao Jiping |
| 301 | Miss Misery | Good Will Hunting (Music from the Miramax Motion Picture) | Elliott Smith |
| 302 | 风继续吹 | 风继续吹 | 张国荣 |
| 303 | Rain after Summer | Rain after Summer | 羽肿 |
| 304 | 宝贝 (in the night) | Original | 张悬 |
| 305 | 不再犹豫 | Beyond The Stage | Beyond |
| 306 | 舞女-韩宝仪 | 舞女 | 韩宝仪 |
| 307 | Take a Bow | Good Girl Gone Bad | Rihanna |
| 308 | 泡沫 | Xposed | G.E.M.邓紫棋 |
| 309 | 天堂 (Live)-腾格尔 | 歌手2018 第7期 | 腾格尔 |
| 310 | 夕焼けの歌（夕阳之歌） | Matchy Best | 近藤真彦 |
| 311 | 梦醒时分-伍佰 & China Blue | 单程车票 | 伍佰 & China Blue |
| 312 | 无论你多怪异我还是会喜欢你-江惠莲 | 刺客伍六七 动画歌曲OST | 江惠莲 |
| 313 | 没有什么不同 | 我的歌声里 | 曲婉婷 |
| 314 | 夜太黑 | 夜太黑 | 林忆莲 |
| 315 | Rise - Epic Music | Rise - Epic Music | John Dreamer |
| 316 | 故乡的原风景 | 武侠音乐精装特辑 | 宗次郎 |
| 317 | 亲爱的那不是爱情 | Ang 5.0 | 张韶涵 |
| 318 | 红色高跟鞋 | 若你碰到他 | 蔡健雅 |
| 319 | The End of the World | The End of the World | Skeeter Davis |
| 320 | 怒放的生命 | 怒放的生命 | 汪峰 |
| 321 | 大约在冬季 | 冬雨 | 齐秦 |
| 322 | 喜欢你 | 喜欢你 | G.E.M. 邓紫棋 |
| 323 | 挪威的森林 | 爱情的尽头 | 伍佰 & China Blue |
| 324 | 本草纲目 | 依然范特西 | 周杰伦 |
| 325 | 小刀会序曲 | 武侠音乐系列之豪气中天 | 商易 / 夏飞云 / 上海民族乐团 |
| 326 | 问题出现我再告诉大家-五条人 | 县城记 | 五条人 |
| 327 | Nijamena | Nijamena | Anurag Kulkarni /Anup Rubens |
| 328 | 2 Soon | Not Thinking Bout 2morrow | Jon Young |
| 329 | 彩云追月 | Edell.Love | 爱戴 |
| 330 | 忧伤倒数 | 夫妻那些事 电视剧原声带 | 小昔米 |
| 331 | 爱情转移 | 认了吧 | 陈奕迅 |
| 332 | 阳光下的我们 | Say The Words | 曲婉婷 |
| 333 | 今天 | 真永远 | 刘德华 |
| 334 | 隐形的翅膀 | 潘朵拉 | 张韶涵 |
| 335 | 蝴蝶泉边 | 崽崽 | 黄雅莉 |
| 336 | Tassel | Dulcet Series spring special collection | Cymophane |
| 337 | 生如夏花 | 生如夏花 | 朴树 |
| 338 | Sugar | V | Maroon 5 |
| 339 | 七里香 | 七里香 | 周杰伦 |
| 340 | 辞·九门回忆 | 辞·九门回忆 | 冰幽 / 解忧草 |
| 341 | 庐州月 | 寻雾启示 | 许嵩 |
| 342 | 我可以抱你吗-张惠妹 | 我可以抱你吗？爱人 | 张惠妹 |
| 343 | Only Time | Only Time: The Collection (Box Set) | Enya |
| 344 | 香水有毒 (DJ版) | 香水有毒(宣传单曲) | 胡杨林 |
| 345 | 有何不可 | 自定义 | 许嵩 |
| 346 | 真的爱你 | BEYOND IV | Beyond |
| 347 | Remember The Time | The Ultimate Collection | Michael Jackson |
| 348 | 漫步人生路-刘惜君 | 惜 . 君 | 刘惜君 |
| 349 | 你的样子 | 一个人的样子 | 林志炫 |
| 350 | Teenage Dream | Teenage Dream | Katy Perry |
| 351 | 莫扎特：《小夜曲》第一乐章 | 2008-2011 演奏实况合集 | 中国国家交响乐团 |
| 352 | Loves Me Not | t.A.T.u. - The Best | t.A.T.u. |
| 353 | 幸せ（幸福）-中岛美雪 | Singles 2000 | 中島みゆき |
| 354 | 穿越时空的思念2 时代を超える想い2 | 映画“犬夜叉 时代を越える想い 音楽篇” | 和田薫 |
| 355 | 毕业说分手 | 毕业说分手 | 冰冰超人 |
| 356 | The South Wind | Song of the Irish Whistle | Joanie Madden |
| 357 | 精忠报国-屠洪刚 | 精忠报国 | 屠洪刚 |
| 358 | 所念皆星河 | 所念皆星河 | CMJ |
| 359 | 可能 | 可能 | 程响 |
| 360 | The Scientist | The Scientist | Coldplay |
| 361 | 大海 | 70老男孩 | 张雨生 |
| 362 | 八年的爱 | 八年的爱 | 冰冰超人 |
| 363 | 漫步人生路-邓丽君 | 邓丽君-传奇的诞生 | 邓丽君 |
| 364 | TiK ToK | Animal | Kesha |
| 365 | Underneath Your Clothes | Laundry Service | Shakira |
| 366 | My Heart Will Go On | My Love: Ultimate Essential Collection (North American Version) | Celine Dion |
| 367 | Rock House Jail | The Rock (Original Motion Picture Score) | Nick Glennie-Smith / Hans Zimmer / Harry Gregson-Williams |
| 368 | 我变了 我没变 | 我变了 我没变 | 杨宗纬 |
| 369 | Trip | Trip | Axero |
| 370 | 断桥残雪 | 断桥残雪 | 许嵩 |
| 371 | 春天里 | 信仰在空中飘扬 | 汪峰 |
| 372 | Lifetimes-Zhao Jiping | Lifetimes (Vivre!) [Original Motion Picture Soundtrack] | Zhao Jiping |
| 373 | 未来へ (向着未来) | 長い間 ～キロロの森～ | Kiroro (キロロ) |
| 374 | What A Wonderful World | All Time Greatest Hits | Louis Armstrong |
| 375 | 光明 | 信仰在空中飘扬 | 汪峰 |
| 376 | 光辉岁月 | 光辉岁月 | Beyond |
| 377 | Rhythm Of The Rain | Let It Be Me | Jason Donovan |
| 378 | Five Hundred Miles (《醉乡民谣》电影主题曲|《一路繁花相送》电视剧插曲) | Inside Llewyn Davis: Original Soundtrack Recording | Justin Timberlake / Carey Mull |
| 379 | 关山酒-等什么君(邓寓君) | 关山酒 | 等什么君(邓寓君) |
| 380 | 画皮-刀郎 | 山歌寥哉 | 刀郎 |
| 381 | 21 Guns | 21st Century Breakdown | Green Day |
| 382 | The truth that you leave | The truth that you leave | Pianoboy高至豪 |
| 383 | 雨过天不晴 | 雨过天不晴 | 柯柯柯啊 |
| 384 | Snowdreams 雪之梦 | Rhine River | Bandari |
| 385 | Not a Single Day 하루도 | Rain's World (Special Edition) | Rain |
| 386 | Summer Vibe | Summer Vibe | Walk off the Earth |
| 387 | We Are One | Super Deluxe Sound I | Kelly Sweet |
| 388 | 北京北京 | 勇敢的心 | 汪峰 |
| 389 | Don't Wanna Know/We Don't Talk Anymore | Don't Wanna Know/We Don't Talk Anymore | Sam Tsui / Alex Blue |
| 390 | We Don't Talk Anymore | We Don't Talk Anymore | Alex Blue TJ Brown |
| 391 | Will and Elizabeth | Pirates of the Caribbean: The Curse of the Black Pearl | Klaus Badelt |
| 392 | You Got Me | Breakthrough | Colbie Caillat |
| 393 | Where Is the Love | Best of Both Worlds | Josh Vietti |
| 394 | Love Story | Women's Day 2019 | Taylor Swift |
| 395 | I Do | I Do | Colbie Caillat |
| 396 | BLUE | Blue Neighbourhood (Deluxe) | Troye Sivan Alex Hope |
| 397 | A Little Story | My View | Valentin |
| 398 | ひとり上手（习惯孤独） | 大吟醸 | 中島みゆき |
| 399 | Memories | 마녀유희 OST | 金有京 |
| 400 | MELANCHOLY | MELANCHOLY | White Cherry |
| 401 | Sundial Dreams | In the Enchanted Garden | Kevin Kern |
| 402 | If | 마녀유희 OST | 全慧彬 |
| 403 | 相思赋予谁 | 春生 | 好妹妹 |
| 404 | 小河淌水-龚琳娜 | 小河淌水 | 龚琳娜 |
| 405 | 画离弦 (柯柯吉他版) | 画离弦 | 柯柯柯啊 |
| 406 | 筝锋 | 功夫 电影原声大碟 | 黄英华 |
| 407 | Thinking Out Loud | NOW That's What I Call Music! 90 | Ed Sheeran |
| 408 | Righteous Path | Introducing Mellow | Blazo |
| 409 | Somebody That I Used To Know | Making Mirrors | Gotye Kimbra |
| 410 | Hard to Sleep | This Is What It Feels Like | Gracie Abrams |
| 411 | Aloha Heja He | Melancholie und Sturmflut (Bonus Tracks Edition) | Achim Reichel |
| 412 | Palace Memories | Sound. Earth. Nature. Spirit. - Vol. Sound | S.E.N.S. |
| 413 | 回家(萨克斯风) | 金耳朵Ⅲ | Kenny G |
| 414 | Breath and Life | The Platinum Series III: Eterna | Audiomachine |
| 415 | East of Eden | East of Eden | Zella Day |
| 416 | Carpe Diem | Dead Poets Society | Maurice Jarre |
| 417 | 姑娘别哭泣-柯柯柯啊 | 姑娘别哭泣 | 柯柯柯啊 |
| 418 | Beautiful In White (Demo) | Beautiful In White (Demo) | Shane Filan |
| 419 | 萱草花-张小斐 | 你好，李焕英 电影原声大碟 | 张小斐 |
| 420 | Keating's Triumph | Dead Poets Society | Maurice Jarre |
| 421 | Better Man | Sing When You're Winning | Robbie Williams |
| 422 | Bridge of Faith(缘分一道桥)-王力宏、谭维维 | The Great Wall (Original Motion Picture Soundtrack) | 王力宏 / 谭维维 |
| 423 | Love Me Like You Do | Delirium | Ellie Goulding |
| 424 | Summer | ENCORE | 久石譲 |
| 425 | Viva La Vida | Viva La Vida Or Death And All His Friends | Coldplay |
| 426 | 诺言 (郭有才版) | 诺言（郭有才版） | 郭有才 |
| 427 | 爱向着我来的那天 사랑아 내게 오기만 해 (PartⅠ) | 마녀유희 OST | Ashily |
| 428 | You're Beautiful | So Beautiful 1 | James Blunt |
| 429 | 思念是一种病 | OK | 张震岳 / 蔡健雅 |
| 430 | Careless Whisper-George Michael | Ladies And Gentlemen... The Best Of George Michael | George Michael |
| 431 | 难却 (DJ细霖版|待上浓妆好戏开场) | 难却 | 平生不晚 |
| 432 | Sunburst | Sunburst | Tobu / Itro |
| 433 | The Mass-Era | The Mass | Era |
| 434 | 精卫-30年前，50年后 | 丧失年轻，勿失年华 | 30年前，50年后 |
| 435 | Farewell to Camraw | When the Pipers Play | Black Kilts Berlin /Robert Mathieson |
| 436 | 想太多 | 想太多 | 李玖哲 |
| 437 | Booty Music | Git Fresh | Deep Side |
| 438 | Genie | THE BEST ~New Edition~ | 少女时代 |
| 439 | Caravan-a_hisa | Single Collection | a_hisa |
| 440 | 樱花草 | 花言乔语 (精装版) | Sweety |
| 441 | Girlfriend | The Best Damn Thing: Deluxe Edition | Avril Lavigne |
| 442 | 道山靓仔-五条人 | 县城记 | 五条人 |
| 443 | 精卫-一颗狼星_许篮心 | 精卫（戏腔） | 一颗狼星_许篮心 |
| 444 | Remember The Name | Sampler Mixtape | Fort Minor |
| 445 | Right Here Waiting (Piano) | Right Here Waiting (Piano) | Basil Jose /Richard Marx |
| 446 | The Long Way Home | The Bright Side | Lenka |
| 447 | 单车恋人 | 9公主 | 后弦 |
| 448 | 愤怒的消失 그게 말이죠 | 마녀유희 OST | 木单车 |
| 449 | 西厢 | 古·玩 | 后弦 |
| 450 | Bye Bye Bye | Rising Love | Lovestoned |
| 451 | Star of the County Down | Musique Celtic | Rosheen |
| 452 | 一格格-卫兰 | 一格格 | 卫兰 |
| 453 | Main Title (The Godfather Waltz) | The Godfather I | Nino Rota |
| 454 | 命运的恶作剧 운명의 장난 | 마녀유희 OST | MC 真理 / 哈哈 |
| 455 | Far Away From Home | Greatest Hits | Groove Coverage |
| 456 | Damn You | The Unreleased Collection | Lana Del Rey |
| 457 | The Happy Troll (Griefing Theme Song)-D1ofaquavibe | The Happy Troll (Griefing Theme Song) | D1ofaquavibe |
| 458 | 乌兰巴托之夜-谭维维 | 高原之心 | 谭维维 |
| 459 | Love Yourself (Natio Remix) | Love Yourself (Natio Remix) | Natio / Justin Bieber / Conor Maynard |
| 460 | Red River Valley | Journey Home | Bronn Journey |
| 461 | 去年夏天 | 去年夏天 | 王大毛 |
| 462 | My Happy Ending | Under My Skin (Special Edition) | Avril Lavigne |
| 463 | 友谊之光 | 监狱风云 | 玛莉亚 |
| 464 | The Moon Represents My Heart | Love Ballads | Kenny G |
| 465 | Auld Lang Syne | The Greatest Gift | Charlie Landsborough |
| 466 | 口弦 | 听见凉山 电视剧原声带 | 赵艺涵 |
| 467 | 奇异恩典 | 最新热歌慢摇73 | Various Artists |
| 468 | 吻别-张学友 | 吻别 | 张学友 |
| 469 | Flower Dance | A Cup Of Coffee | DJ Okawari |
| 470 | Come And Get It | Chartsurfer Vol. 30 | Selena Gomez |
| 471 | Heartbeats | Swings and Roundabouts | Amy Deasismont |
| 472 | Hero | Hero | Enrique Iglesias |
| 473 | 风中有朵雨做的云-孟庭苇 | 风中有朵雨做的云 | 孟庭苇 |
| 474 | I Just Wanna Run | Take Action! Volume 9 | The Downtown Fiction |
| 475 | 莫失莫忘 | 仙剑奇侠传 电视原创配乐 | 麦振鸿 |
| 476 | I Want You to Know | I Want You to Know | Zedd / Selena Gomez |
| 477 | We Are Young | Dancing Bear Best Of 2012 International | Fun. Janelle Monáe |
| 478 | 罗刹海市-刀郎 | 山歌寥哉 | 刀郎 |
| 479 | The Day You Went Away | The Day You Went Away: The Best of M2M | M2M |
| 480 | Sleepyhead | Acoustic Daydreams | Galen Crew |
| 481 | Moon As My Heart | Harmonica Sound of Hong Kong | Robert Bonfiglio |
| 482 | Solstice-K-391 | Solstice | K-391 |
| 483 | 西海情歌-刀郎 | 刀郎Ⅲ | 刀郎 |
| 484 | 卡农D大调 | 胎教音乐 | 群星 |
| 485 | My Soul | Time... | July |
| 486 | Conquest of Paradise-Vangelis | 1492 - Conquest Of Paradise | Vangelis |
| 487 | 富士山下 | What's Going On…? | 陈奕迅 |
| 488 | New Soul | Irlande | Vox Angeli |
| 489 | 乌兰巴托的夜 (丹正母子版) | 乌兰巴托的夜 | 丹正母子 |
| 490 | If I Die Young | If I Die Young - Single | The Band Perry |
| 491 | The Godfather (Love Theme) | The Godfather I | Nino Rota |
| 492 | 原来你也在这里-周笔畅 | 原来你也在这里 | 周笔畅 |
| 493 | Hero's Theme-Steven Burke | Kameo: Elements of Power O.S.T | Steven Burke |
| 494 | My Love (Radio Edit) | Coast to Coast | Westlife |
| 495 | What Are Words | What Are Words | Chris Medina |
| 496 | 离别开出花-就是南方凯 | 离别开出花 | 就是南方凯 |
| 497 | Young For You | Young For You | GALA |
| 498 | The Ludlows | Legends Of The Fall Original Motion Picture Soundtrack | James Horner |
| 499 | 雪の華（雪之花）-中岛美嘉 | 雪の華 | 中島美嘉 |
| 500 | 让我欢喜让我忧-周华健 | 让我欢喜让我忧 | 周华健 |
| 501 | Pop Danthology 2012 | Pop Danthology | DJ Daniel Kim |
| 502 | 向云端-小霞&海洋Bo | 向云端 | 小霞 / 海洋Bo |
| 503 | 城南花已开 | 城南花已开 | 三亩地 |
| 504 | Paris | Paris | Else |
| 505 | Monsters (Live)-周深 | 歌手·当打之年 第5期 | 周深 |
| 506 | 颠倒歌-刀郎 | 山歌寥哉 | 刀郎 |
| 507 | 花心 | Keep Wakin 1987-2002 周而复始 | 周华健 |
| 508 | 呼唤 오나라 I | 대장금 OST | 김지현 |
| 509 | 爱向着我来的那天2 사랑아 내게 오기만 해 (Part II) | 마녀유희 OST | Ashily |
| 510 | 再见 | 再见 | 张震岳 |
| 511 | 千千阙歌 | 千千阙歌 | 陈慧娴 |
| 512 | Night Crusing(夜间巡航) (Inst.)-牛尾憲輔 | ピンポン OST | 牛尾憲輔 (agraph) |
| 513 | 萍聚 | 萍聚/珍重再见 | 李翊君 / 李富兴 |
| 514 | Kiss The Rain 비를 맞다 | The Best - Reminiscent 10th Anniversary | Yiruma |
| 515 | Runner | Runner | Dustin O'Halloran |
| 516 | This Is the Life | Weathered | Angie Miller |
| 517 | 从头再来 | 从头再来 | 刘欢 |
| 518 | Dead Poets Society (Finale) | Filmharmonic II | The Royal Philharmonic Orchestra Maurice Jarre |
| 519 | The sally gardens | Arias Ancora | Laure Green |
| 520 | Friendships-Pascal Letoublon | Friendships | Pascal Letoublon |
| 521 | 序曲：天地孤影任我行 | 东邪西毒(电影音乐) | 陈勋奇 |
| 522 | 送别 | 送别 | 韩红 |
| 523 | 安静 钢琴版 | 纯音乐流行歌曲钢琴版 | Paul Liu |
| 524 | Wrecking Ball | Wrecking Ball | Miley Cyrus |
| 525 | 是啊 그래 | 마녀유희 OST | 나창현 |
| 526 | Six Feet Under | Six Feet Under | Billie Eilish |
| 527 | 穿越时空的思念1 时代を超える想い1 | 映画“犬夜叉 时代を越える想い 音楽篇” | 和田薫 |
| 528 | 千千阙歌 (Live)-周深 | 聚划算55青春选择之夜晚会Live | 周深 |
| 529 | 偷功 | 太极张三丰 电影原声带 | 胡伟立 |
| 530 | Umbrella | Now That's What I Call Music! 25 Years | Rihanna / Jay-Z |
| 531 | Waka Waka (Esto Es África) | Waka Waka (This Time For Africa) (The Official 2010 Fifa World Cup Song) | Shakira |
| 532 | 假如爱有天意(电视剧《最食人间烟火色》插曲)-贺三 | 假如爱有天意 | 贺三 |
| 533 | In The End | In The End | Linkin Park |
| 534 | Monody | Monody | TheFatRat / Laura Brehm |
| 535 | The Show | The Show | Lenka |
| 536 | 野子 (Live) | 我是歌手第四季 第3期 | 苏运莹 |
| 537 | Gee | The First Mini Album Gee | 少女时代 (소녀시대) |
| 538 | Ship In The Sand | Dear Me, Look Up | Marble Sounds |
| 539 | Summertime Sadness | Summertime Sadness | Lana Del Rey |
| 540 | 慕情 (M-4) | 犬夜叉 音楽篇 | 和田薫 |
| 541 | 最浪漫的事-赵咏华&好妹妹 | 追梦人 | 赵咏华 / 好妹妹 |
| 542 | Honor (Main Title Theme from "The Pacific") | The Pacific (Music From the HBO Miniseries) | Hans Zimmer / Geoff Zanelli / Blake Neely |
| 543 | 花妖-刀郎 | 山歌寥哉 | 刀郎 |
| 544 | 兰亭序 (粤语版)-邓千荧 | 兰亭序 | 邓千荧 |
| 545 | Requiem For A Tower | Escala | Escala |
| 546 | 乌兰巴托的夜-左小祖咒 | 美国 The U.S.A（电影原声配乐） | 左小祖咒 |
| 547 | I Love You (Remix) | I Love You | United Idol |
| 548 | 你还要我怎样 | 意外 | 薛之谦 |
| 549 | 发现爱 | 西界 | 林俊杰 / 金莎 |
| 550 | 思念是一种病+爱人同志+爱如潮水+你现在还好吗(Live)-纵贯线 | Live in Taipei 出发/终点站 | 纵贯线 |
| 551 | 桥边姑娘 | 桥边姑娘 | 海伦 |
| 552 | 犯错 | 犯错 | 顾峰 / 斯琴高丽 |
| 553 | 那年初夏 | 毕业了我们一无所有 | 任然 |
| 554 | 北京欢迎你 | 北京2008年奥运会歌曲专辑 | 群星 |
| 555 | Red River Valley | Cowboy Songs | Michael Martin Murphey |
| 556 | 500 Miles | Buck The Trend | Peter, Paul & Mary |
| 557 | 500 Miles | Christ Is My Hope | The Innocence Mission |
| 558 | 500 Miles | Let's Folk | The Brothers Four |
| 559 | 画离弦 (柯柯版) | 画离弦 | 柯柯柯啊 |
| 560 | Ferrari-Jayvine Ramma | Ferrari | Jayvine Ramma |
| 561 | Annie's Wonderland 安妮的仙境 | Wonderland | Bandari |
| 562 | 阿凡达与屌丝男 | 心花路放 电影原声带 | 许鹤缤 |
| 563 | 花 ~すべての人に心の花を~ (オリジナル・ヴァージョン) | ザ・ニュー・ベスト・オブ・喜納昌吉＆チャンプルース | 喜納昌吉 (きな しょうきち) |
| 564 | Princesses Don't Cry-CARYS | Songs About Boys | CARYS |
| 565 | Skinny Love | Skinny Love | Birdy |
| 566 | 我的歌声里 | 我的歌声里 | 李代沫 |
| 567 | 情人 | 海阔天空 | Beyond |
| 568 | 给我一个吻-杨子姗 | 重返20岁 电影原声带 | 杨子姗 |
| 569 | 桔梗谣 | 노들강변 매화타령 민요 | 노들강변 매화타령 민요 |
| 570 | 为爱痴狂 | 《中国好声音》2012跨年演唱会 | 金志文 |
| 571 | Mariage d'amour | Lettre à ma Mère | Richard Clayderman |
| 572 | 我可以抱你吗 (Live)-孟根花 | 我可以抱你吗 | 孟根花 |
| 573 | 世界第一等 | 世界第一等 | 浪哥 |
| 574 | Unable To Stay, Unwilling To Leave | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 575 | 带我到山顶 | 听见凉山 | 赵艺涵 |
| 576 | Baby | Baby | Justin Bieber / Ludacris |
| 577 | 春娇与志明 | 春娇与志明 | 街道办GDC /欧阳耀莹 |
| 578 | Nevada | Monstercat - Best of 2016 | Vicetone / Cozi Zuehlsdorff |
| 579 | 听妈妈的话 | 依然范特西 | 周杰伦 |
| 580 | Jambalaya | 不朽的声音(人生最难忘的歌) | Carpenters |
| 581 | 红尘情歌 | 情路无悔 | 高安 /黑鸭子组合 |
| 582 | 莉莉安-宋冬野 | 安和桥北 | 宋冬野 |
| 583 | Prendre sa main | Cri d'amour | Angel Lover |
| 584 | 安静 | 范特西 | 周杰伦 |
| 585 | 梦中蝶影 | 歌曲合辑 | 华语群星 |
| 586 | 姑娘我爱你 | 姑娘我爱你 | 索朗扎西 |
| 587 | 借我 | 算云烟 | 谢春花 |
| 588 | Always With Me | 幸福的味道 | 木村弓 / 奥户巴寿 |
| 589 | 총맞은것처럼 (像中枪一样)-白智英 | Sensibility | 白智英 (백지영) |
| 590 | 兰亭序 | 魔杰座 | 周杰伦 |
| 591 | The Red Sun | 20 Years of Achievement around the World | Richard Clayderman |
| 592 | 快乐崇拜-潘玮柏、张韶涵 | Wu Ha | 潘玮柏 / 张韶涵 |
| 593 | 纯真年代 | 大小世界 | 爱朵女孩 |
| 594 | Vincent | Legendary Don McLean | Don McLean |
| 595 | 平凡之路 | 猎户星座 | 朴树 |
| 596 | 李白 | 模特 | 李荣浩 |
| 597 | You | YOU | Approaching Nirvana |
| 598 | Coming Home | Coming Home | Skylar Grey / Diddy-Dirty Money |
| 599 | Turnin' | Young Rising Sons | Young Rising Sons |
| 600 | 意外 | 意外 | 薛之谦 |
| 601 | Promise | Promise | sapientdream |
| 602 | 那些年 | 那些年，我们一起追的女孩 电影原声带 | 胡夏 |
| 603 | 有一种爱叫做放手 | 有一种爱叫做放手 | 阿木 |
| 604 | 童年 | 童年 | 北京天使合唱团 |
| 605 | Still D.R.E (Instrumental Version)-Dr. Dre Snoop Dogg | Still D.R.E. | Dr. Dre / Snoop Dogg |
| 606 | 赤伶(DJ版) | 赤伶 | DJ名龙 |
| 607 | 我最亲爱的 | 我的歌声里 | 李代沫 |
| 608 | April 四月之春 | Sunrise Hill | Bandari |
| 609 | Fight | Fight | BeatBrothers |
| 610 | 我希望 | 匆匆那年 电视原声带 | 杨玏 |
| 611 | 笑傲江湖曲(琴箫合奏)-胡伟立 | 武侠音乐系列之疗伤神法 | 胡伟立 |
| 612 | 恋曲1990-高胜美 | 经典金选1 哭砂 | 高胜美 |
| 613 | 知道不知道 | Rene | 刘若英 |
| 614 | Jiazhen Leaves Fughi-Zhao Jiping | Lifetimes (Vivre!) [Original Motion Picture Soundtrack] | Zhao Jiping |
| 615 | 花-喜納昌吉 | The Celebrations | 喜納昌吉 / チャンプルーズ |
| 616 | Don't Worry Be Happy | Pretty Donkey Girl | Holly Dolly |
| 617 | Say Hello | These Friends Of Mine | Rosie Thomas / Sufjan Stevens |
| 618 | 海阔天空-G.E.M.邓紫棋 | T.I.M.E. | G.E.M.邓紫棋 |
| 619 | 我记得 | 署前街少年 | 赵雷 |
| 620 | The Right Path | Age of Innocence (Original Soundtrack) | Thomas Greenberg |
| 621 | 相思 | 腔.调 | 毛阿敏 |
| 622 | 云宫迅音-许镜清 | 西游记 电视剧配乐原声 | 许镜清 |
| 623 | Seven Lonely Days | Remember When? - 25 Golden Memories | Georgia Gibbs |
| 624 | 相对 | 子曰 第一册 | 子曰乐队 |
| 625 | Sally Gardens | Spring | The O'Neill Brothers |
| 626 | 2 Phút Hơn (KAIZ Remix) | 2 Phút Hơn (KAIZ Remix) | Pháo / KAIZ |
| 627 | Valder Fields | A Plea en Vendredi | Tamas Wells |
| 628 | 诺言(中视八点档《孽海花》片头曲)-李翊君 | 诺言 | 李翊君 |
| 629 | 刚好遇见你 | 刚好遇见你 | 李玉刚 |
| 630 | Way Back then | 오징어게임 OST | 郑在日 (정재일) |
| 631 | 爱要坦荡荡-萧潇 | Beautiful Angel | 萧潇 |
| 632 | 你的答案-阿冗 | 你的答案 | 阿冗 |
| 633 | 桃花诺(电视剧《上古情歌》片尾曲)-G.E.M.邓紫棋 | 上古情歌 电视剧原声带 | G.E.M.邓紫棋 |
| 634 | Luv Letter | 髙橋大輔～フェイヴァリット・ミュージック～ | 神津裕之 |
| 635 | 海阔天空 | 一声所爱 大地飞歌（第九期） | 汪小敏 |
| 636 | 半妖-和田薫 | TVアニメーション「犬夜叉」オリジナルサウンドトラックアルバム「犬夜叉 音楽篇」 | 和田薫 |
| 637 | 男と女（男和女） | Standing Ovation | CHAGE and ASKA |
| 638 | 万水千山总是情 | 万水千山总是情 电视剧原声带 | 汪明荃 |
| 639 | 希望 | Grace & Charm | 陈慧琳 |
| 640 | Anak (remix: Freddie Aguilar|Remix) | 清尘 | 清尘 |
| 641 | Liability | Melodrama | Lorde |
| 642 | Never Say Good Bye | 마이걸 | Mario & Nesty (마리오&네스티) |
| 643 | 城府 | 自定义 | 许嵩 |
| 644 | Rompasso-Angetenar（DEITIES remix）-DEITIES Ghetto Artist | Angetenar (DEITIES Remix) | DEITIES / Ghetto Artist |
| 645 | All Falls Down | All Falls Down | Alan Walker / Noah Cyrus / Digital Farm Animals / Juliander |
| 646 | 梦中的婚礼 | Richard Clayderman | Richard Clayderman |
| 647 | Ferrari-Bebe Rexha | Expectations | Bebe Rexha |
| 648 | Faded | Faded | Alan Walker / Iselin Solheim |
| 649 | 被遗忘的时光-蔡琴 | 出塞曲 | 蔡琴 |
| 650 | Take It From Me | Say I Am You | The Weepies / Deb Talan / Steve Tannen |
| 651 | 鼓楼 | 无法长大 | 赵雷 |
| 652 | You Belong To Me | To You | Carla Bruni |
| 653 | 发如雪 | 十一月的萧邦 | 周杰伦 |
| 654 | Windy Hill（风之谷） | Windy Hill | 羽肿 |
| 655 | Bloom of Youth | クドわふたー オリジナル サウンドトラック | 清水淳一 |
| 656 | Your Man | Double Cream 5: 20 Years of Nashville #1's 1992-2012 | Josh Turner |
| 657 | 天地龙鳞(大型纪录片《紫禁城》主题歌)-王力宏 | 大型纪录片《紫禁城》主题歌音乐专辑 | 王力宏 |
| 658 | 鸿雁-额尔古纳乐队 | 往日时光 | 额尔古纳乐队 |
| 659 | 热爱105°C的你 | 热爱105°C的你 | 腾格尔 / 艾伦 / 沈腾 |
| 660 | Eventide | Eventide | Nylon |
| 661 | Because of You | Because Of You | Kelly Clarkson |
| 662 | 等爱的玫瑰-凤凰传奇 | 吉祥如意 | 凤凰传奇 |
| 663 | Demons | Continued Silence EP | Imagine Dragons |
| 664 | Take Me To Church | Bravo Hits 86 | Hozier |
| 665 | Just One Last Dance (Album Version) | Key To My Soul | Sarah Connor /Marc Terenzi |
| 666 | Love The Way You Lie (Part III (Original Demo)) | Relaxing Acoustic | Skylar Grey |
| 667 | 老男孩 | 父亲 | 筷子兄弟 |
| 668 | 我是一只小小鸟 | 我是一只小小鸟 | 赵传 |
| 669 | 独家记忆 | 独家记忆 (Hong Kong Version) | 陈小春 |
| 670 | Be What You Wanna Be | Darin | Darin |
| 671 | 好久不见 | 认了吧 | 陈奕迅 |
| 672 | A Place Called You | Enchanted | Emma Stevens |
| 673 | Young And Beautiful | Triple J Hottest 100 Vol 21 | Lana Del Rey |
| 674 | 长路漫漫任我闯 | 林子祥精选之天长地久 | 林子祥 |
| 675 | Frail Love | Frail Love | Cloves |
| 676 | Scarborough Fair | The Very Best of Sarah Brightman 1990-2000 | Sarah Brightman |
| 677 | 从头再来 | 经典20年 珍藏锦集 | 刘欢 |
| 678 | 浮夸 | U-87 | 陈奕迅 |
| 679 | Asphyxia 窒息 | asphyxia | 逆时针向 |
| 680 | The Ocean (Radio Edit) | The Ocean | Mike Perry / SHY Martin |
| 681 | 乌兰巴托的夜-葱香科学家（王悠然） | 乌兰巴托的夜 | 葱香科学家（王悠然） |
| 682 | 听 | 拾 | 张杰 |
| 683 | Lonely | Nana | Nana |
| 684 | Unity | Sounds of Syndication, Vol .1 (Presented by Syndicate) | TheFatRat |
| 685 | Hey, Soul Sister | Save Me, San Francisco | Train |
| 686 | Waltz No.6 'Petit Chien' in D Flat Major Op.40-1 | 越听越聪明 1 | Classical Artists |
| 687 | Elsinore Revisited(重访埃尔西诺) | Rosencrantz & Guildenstern are Undead | Sean Lennon |
| 688 | Too Far | King in the Mirror | Anna F |
| 689 | Inspire | Serenity | Capo Productions |
| 690 | 让我偷偷看你 | 阿弥陀佛么么哒·一个孩子的心愿 | 赵雷 |
| 691 | やわらかな光(柔和之光)-やまだ豊 | フジテレビ系ドラマ「僕のいた時間」オリジナルサウンドトラック - (日剧《我存在的时间》原声带) | やまだ豊 |
| 692 | 夜的钢琴曲五 | 夜的钢琴曲 Demo集 | 石进 |
| 693 | Sutter's Mill | The Music of Dan Fogelberg | Dan Fogelberg |
| 694 | Please Don't Go | Please Don't Go | Joel Adams |
| 695 | 曾经的你 | 每一刻都是崭新的 | 许巍 |
| 696 | Stay Here Forever | Valentine's Day OST | Jewel |
| 697 | 存在 | 生无所求 | 汪峰 |
| 698 | Stay Alive | The Secret Life Of Walter Mitty (Music From And Inspired By The Motion Picture) | José González |
| 699 | 我就喜欢你这样的丫头 | 匆匆那年 电视原声带 | 杜维瀚 |
| 700 | Everybody | Everybody | Ingrid Michaelson |
| 701 | 传奇 | 传奇 | 王菲 |
| 702 | 易燃易爆炸 | 如也 | 陈粒 |
| 703 | 飞向别人的床 | 飞向别人的床 | 沉珂（C.K）& 光光 |
| 704 | 赤伶 (弹唱版) | 赤伶 | 孙鹏凯 |
| 705 | Astronomia（黑人抬棺古风版） | 黑人抬棺古风版 | litterzy、水玥儿 |
| 706 | I Want My Tears Back | Imaginaerum | Nightwish |
| 707 | 红颜 | MuSiC混合体 | 胡彦斌 |
| 708 | 혼자시킨 사랑 独自的爱情 | 명랑소녀 성공기 OST | True Bird |
| 709 | 潮湿的心 | 蜕变1少女的心情故事 | 卓依婷 |
| 710 | brave heart | brave heart | 宮崎歩 |
| 711 | 明天过后 | 明天过后 | 张杰 |
| 712 | Love Theme | 명랑소녀 성공기 OST | 吴振宇 |
| 713 | Read My Mind | Jade | Sweetbox |
| 714 | 千里之外-周杰伦、费玉清 | 依然范特西 | 周杰伦/费玉清 |
| 715 | Let It Out | Let It Out | Frances |
| 716 | Love Song | 명랑소녀 성공기 OST | 赵长赫 |
| 717 | 芒种(梦幻西游普陀山门派曲)-腾格尔 | 芒种 | 腾格尔 |
| 718 | 飞得更高 | 笑着哭 | 汪峰 |
| 719 | 花火 | 花火 | 汪峰 |
| 720 | 直到永远 | 生死不离 我们在一起 | 汪峰 |
| 721 | 跟往事干杯 | 不朽金曲精选 Ⅰ | 姜育恒 |
| 722 | 蓝莲花 | 时光.漫步 | 许巍 |
| 723 | 娃娃脸 | 娃娃脸 | 后弦 |
| 724 | 我爱你中国 | 怒放的生命 | 汪峰 |
| 725 | 星象仪 プラネタリウム | プラネタリウム | 大塚爱 |
| 726 | 推理(オリジナル・ヴァージョン)-大野克夫 | 「名探偵コナン」サントラ・スーパー・ベスト- (名侦探柯南) | 大野克夫 |
| 727 | 一直很安静 | 寂寞在唱歌 | 阿桑 |
| 728 | 生活不止眼前的苟且 | 生活不止眼前的苟且 | 许巍 |
| 729 | Mark's Theme-顾嘉辉 | 英雄本色1&2 | 顾嘉辉 |
| 730 | Tears Of A Clown | Mastercutor | U.D.O. |
| 731 | 運命のルーレット廻して (转动命运之轮) | 運命のルーレット廻して | ZARD (ザード) |
| 732 | The Dawn-Dreamtale | Beyond Reality (Japanese Edition) | Dreamtale |
| 733 | 兰亭序 (粤语版) (Single Version) | 兰亭序 | 王十三 |
| 734 | For Free | Folk For Kids | Lana Del Rey / Zella Day / Weyes Blood |
| 735 | My Destiny (我的命运) | 별에서 온 그대 OST Part 1 | LYn (린) |
| 736 | 亲爱的路人 | 亲爱的路人 | 刘若英 |
| 737 | 等不到的爱 | 裸婚时代 电视剧原声带 | 文章 |
| 738 | Call Me Maybe | Call Me Maybe | Carly Rae Jepsen |
| 739 | 花开在眼前 | 花开在眼前 | 韩磊 |
| 740 | 如果不能好好爱 | 如果不能好好爱 | 吴克群 |
| 741 | 童年 | 纵贯线演唱会 | 罗大佑、李宗盛、张震岳、周华健 |
| 742 | 魔訶不思議アドベンチャー! | ドラゴンボール全曲集 | 高橋洋樹 |
| 743 | 我是一只小小鸟-任贤齐&李宗盛 | 台湾男儿任贤齐认真精选辑 | 任贤齐 / 李宗盛 |
| 744 | 白羊座的忧伤-石进 | 夜的钢琴曲Ⅱ | 石进 |
| 745 | One Night In 北京 | SHIN 同名专辑 | 信乐团 |
| 746 | The Monster | The Monster | Eminem / Rihanna |
| 747 | 1%-Oscar Scheller、Lily Allen | 1% | Oscar Scheller / Lily Allen |
| 748 | Groundhog Day | Groundhog Day | Em Beihold |
| 749 | 我期待-张雨生 | 卡拉OK.台北.我 | 张雨生 |
| 750 | Amazing Grace 天赐恩宠 | 苏格兰音乐之旅 苏格兰风笛 | 群星 |
| 751 | 兰亭序【笛子版】-亿只张勤洗 | 兰亭序 | 亿只张勤洗 |
| 752 | 小仙女 | 武侠音乐系列之缠绵悱恻 （截取版） | 麦振鸿 |
| 753 | Élan | Élan | Nightwish |
| 754 | 爱你在心口难开-高胜美 | 怀念老歌七 | 高胜美 |
| 755 | Fengxia Leaves Her Parents-Zhao Jiping | Lifetimes (Vivre!) [Original Motion Picture Soundtrack] | Zhao Jiping |
| 756 | The Hampster Dance Song-Hampton the Hampster | The Hamsterdance Album | Hampton the Hampster |
| 757 | Dans la maison (Thème)-Philippe Rombi | Dans la maison | Philippe Rombi |
| 758 | 一千年以后(A Thousand Years Later)-林俊杰 | 编号89757 | 林俊杰 |
| 759 | 「名探偵コナン」~メインテーマ-大野克夫 | 「名探偵コナン」メインテーマ | 大野克夫 |
| 760 | 万里の長城-太田美知彦 | 中華一番! スペシャルTVオンエアーミックス& ― オリジナル・サウンドトラック | 太田美知彦 |
| 761 | 喜剧之王 | 喜剧之王 | 李荣浩 |
| 762 | Tennessee-Hans Zimmer | Pearl Harbor [O.S.T] | Hans Zimmer |
| 763 | 浮沉的兄弟-戎祥 | 浮沉的兄弟 | 戎祥 |
| 764 | 幸せ（幸福）-小林幸子 | 小林幸子全曲集 2013 | 小林幸子 |
| 765 | Liekkas | Assogattis: By The Embers | Sofia Jannok |
| 766 | 郎的诱惑-凤凰传奇 | 最炫民族风 | 凤凰传奇 |
| 767 | 我真的受伤了-张学友 | 学友 热 | 张学友 |
| 768 | 我想和你一起去海边-江惠莲 | 伍六七 原声大碟 | 江惠莲 |
| 769 | For the World-谭盾 | Late Night Tales: Air | 谭盾 |
| 770 | Scotland the Brave 苏格兰勇士 | 苏格兰音乐之旅 苏格兰风笛 | 群星 |
| 771 | 月牙湾 | 爱.歌姬 | F.I.R. |
| 772 | Gangsta Bop | Konvicted | Akon |
| 773 | Hallelujah | Warmer In The Winter (Deluxe Edition) | Lindsey Stirling |
| 774 | Nijamena (BGM版) | Nijamena | H2s |
| 775 | 二泉映月 | 阿炳全集 | 阿炳 |
| 776 | 男儿当自强 | 笑傲歌坛 传世经典 | 林子祥 |
| 777 | 上海滩 | 上海滩 | 叶丽仪 |
| 778 | 我和你 | 北京2008 奥运会、残奥会开闭幕式主题歌曲专辑 | 刘欢 / Sarah Brightman |
| 779 | 算你狠 | 绝对收藏 | 陈小春 |
| 780 | 黄种人 | 黄·锋 | 谢霆锋 |
| 781 | Croatian Rhapsody | The Piano Player | Maksim Mrvica |
| 782 | He's a Pirate | Pirates of the Caribbean: The Curse of the Black Pearl | Klaus Badelt |
| 783 | Natural-Imagine Dragons | Origins (Deluxe) | Imagine Dragons |
| 784 | 星月神话 | 女人又一次哭泣 | 金莎 |
| 785 | 夜上海 | 夜上海精选 | 周璇 |
| 786 | 带你去旅行 | 带你去旅行 | 校长（张驰） |
| 787 | 天下第一 | 武侠音乐系列之豪气中天 （截取版） | 麦振鸿 / 罗坚 |
| 788 | 没有你的日子我真的好孤单-韩晶 | 不要用我的爱来伤害我 | 韩晶 |
| 789 | 给我一个吻-张露 | 群星会 38 张露 (珍藏系列) | 张露 |
| 790 | '97爱情宣言 | 狼 97黄金自选辑 | 齐秦 |
| 791 | 外面的世界 | 燃烧爱情（狼之旅） | 齐秦 |
| 792 | 小酒窝 | JJ陆 | 林俊杰 / 蔡卓妍 |
| 793 | Past Lives | Drowning | Slushii |
| 794 | 往事随风 | 痛并快乐着 | 齐秦 |
| 795 | Go Time | Go Time | Mark Petrie |
| 796 | Only Love(电视剧《妙手仁心 II》插曲)-Trademark | #Love | Trademark |
| 797 | 日不落-蔡依林 | 特务J - (Agent J) | 蔡依林 |
| 798 | 李香兰-张学友 | Jacky Cheung 15 | 张学友 |
| 799 | Someone to Stay | Someone to Stay | Vancouver Sleep Clinic |
| 800 | The Portrait | Titanic: Special Edition | James Horner |
| 801 | 假如爱有天意-李健 | 李健 | 李健 |
| 802 | 那年我双手插兜 不知道什么叫做对手 | 那年我双手插兜 不知道什么叫做对手（语录版） | 黑左 / 莎馬淑鳐 / 刘liu创意人 |
| 803 | 你还欠我一个拥抱 | 很有爱 | 后弦 / Sara |
| 804 | Strength of a Thousand Men | Archangel | Two Steps From Hell |
| 805 | 匆匆那年 | 匆匆那年 电影原声带 | 王菲 |
| 806 | 一路 | 匆匆那年 电视原声带 | 白敬亭 / 杨玏 / 杜维瀚 |
| 807 | Spirit of the Wild | Age of Wonders | BrunuhVille |
| 808 | 命运 운명 | 풀 하우스 OST (KBS 미니시리즈) | Why |
| 809 | 青い空に出逢えた(TV Mix) | 中華一番! スペシャルTVオンエアーミックス& ― オリジナル・サウンドトラック | 辻尾有紗 |
| 810 | 大海~ | Asia | THE JAYWALK |
| 811 | 热爱105°C的你 | 热爱105°C的你 | 阿肆 |
| 812 | Flavor Of Life | Flavor Of Life | 宇多田ヒカル |
| 813 | 我的未来不是梦-张雨生 | 6个朋友 | 张雨生 |
| 814 | Death Of Titanic | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 815 | Lordly (Instrumental Mix)-Feder | Lordly (Instrumental Mix) | Feder |
| 816 | 最浪漫的事-赵咏华 | 我的爱我的梦我的家 | 赵咏华 |
| 817 | 孤勇者_凤凰传奇 | 孤勇者 | 凤凰传奇 |
| 818 | 不如不见 | What's Going On…? | 陈奕迅 |
| 819 | Distant Memories | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 820 | 偏爱 | 破天荒 | 张芸京 |
| 821 | Diamonds | Diamonds | Rihanna |
| 822 | 風の住む街（风居住的街道）-磯村由紀子 | 風の住む街 | 磯村由紀子 |
| 823 | 还有我-任贤齐 | 如果没有你 | 任贤齐 |
| 824 | 绅士-薛之谦 | 绅士 | 薛之谦 |
| 825 | Je m'appelle Hélène | Hélène | Hélène Rolles |
| 826 | 我欲成仙 | 西游记后传片头曲 | 刘欢 |
| 827 | 希望 (国语) | 我是阳光的 | 陈慧琳 |
| 828 | Something Just Like This | Something Just Like This | The Chainsmokers / Coldplay |
| 829 | Children of the Dark | Together Till the End | Mono Inc. / Joachim Witt / Tilo Wolff / Chris Harms |
| 830 | 極楽浄土 | 約束 -Promise code- | GARNiDELiA |
| 831 | 作曲家 | 李荣浩 | 李荣浩 |
| 832 | 辞九门回忆(DJ版) | 未知 | 未知 |
| 833 | 诺言 (正式版)-海来阿木 | 诺言 (正式版) | 海来阿木 |
| 834 | Maga-Such a Whore（Maga remix）-Maga | Such a Whore | Maga |
| 835 | 闯将令-香港中乐团 于会咏 胡登跳 | 功夫 电影原声大碟 | 香港中乐团 / 于会咏 / 胡登跳 |
| 836 | 黑暗中的舞者 | 寂静的天空 | 黛青塔娜 / HAYA乐团 |
| 837 | 亲爱的旅人啊-周深 | 亲爱的旅人啊《千与千寻》（Cover 木村弓） | 周深 |
| 838 | 銀の龍の背に乗って | 銀の龍の背に乗って | 中島みゆき |
| 839 | She Is My Sin-Nightwish | Tales from the Elvenpath | Nightwish |
| 840 | To Ramona | The Complete Album Collection Vol.1 | Bob Dylan |
| 841 | Azul | Acoustik Guitar | John H. Clarke |
| 842 | 痴情冢（完整版）-吴严武 | 痴情冢（完整版） | 吴严武 |
| 843 | Opening | 少林足球 电影原声带 | 黄英华 |
| 844 | Feel Me-Selena Gomez | Feel Me | Selena Gomez |
| 845 | Hummell Gets The Rockets | The Rock (Original Motion Picture Score) | Nick Glennie-Smith /Harry Gregson-Williams |
| 846 | 星の下での邂逅-赵大鼾 | 星の下での邂逅 | 赵大鼾 |
| 847 | Impossible-Two Steps From Hell | Unleashed | Two Steps From Hell |
| 848 | Love From Me-Johnson Rodgie | Love From Me | Johnson Rodgie |
| 849 | 猜不透 | 我爱上的 | 丁当 |
| 850 | Samba-Ludovico Einaudi | I Giorni | Ludovico Einaudi |
| 851 | Håll Om Mig-Nanne Grönvall | Melodifestivalen 1958-2013 | Nanne Grönvall |
| 852 | 难却 | 难却 | 平生不晚 |
| 853 | 梦醒时分-杨钰莹 | 我有一段情 | 杨钰莹 |
| 854 | 王招君 (你看你拉住我的模样)(《寻汉计》电影推广曲)-任素汐 | 王招君 (你看你拉住我的模样) | 任素汐 |
| 855 | Old Threads-Deep East Music | Vintage Sunshine | Deep East Music |
| 856 | 萤火之森-CMJ | 萤火之森 | CMJ |
| 857 | 万疆-李玉刚 | 万疆 | 李玉刚 |
| 858 | Opening Credits-Hans Zimmer | Call of Duty: Modern Warfare 2 OST | Hans Zimmer |
| 859 | Samsara-Tungevaag & Raaban | Club Sounds Vol.73 | Tungevaag & Raaban |
| 860 | 今天你要嫁给我(Marry Me Today)-蔡依林、陶喆 | 太美丽 | 蔡依林 / 陶喆 |
| 861 | The X-Files (Original Version)-Mark Snow | The X Files? | Mark Snow |
| 862 | BOOM-Tiësto / Sevenn | BOOM | Tiësto / Sevenn |
| 863 | 初识太极 | 太极张三丰 电影原声带 | 胡伟立 |
| 864 | At Anchor | The Airship | Port Blue |
| 865 | 难却 (DJ版0.85x|待上浓妆好戏开场) | 难却 | 平生不晚 |
| 866 | 同桌的你(电影《同桌的你》片尾主题曲)-胡夏 | 同桌的你 | 胡夏 |
| 867 | 悬溺-葛东琪 | 第二街区 | 葛东琪 |
| 868 | 我要你(电影《驴得水》主题曲)-任素汐 | 我要你 | 任素汐 |
| 869 | Special Ops-Silver Screen | Under Siege | Silver Screen |
| 870 | Frontier-Doctor Vox | Level Up | Doctor Vox |
| 871 | Electric Romeo | Themes for Orchestra and Choir 2 - Abbey Road | Immediate Music |
| 872 | 賭神 | 赌神 电影原声 | 卢冠廷 |
| 873 | 下雨天-南拳妈妈 | 优の良曲 南搞小孩 | 南拳妈妈 |
| 874 | 姑娘别哭泣（弹唱版）-柯柯柯啊 | 姑娘别哭泣 | 柯柯柯啊 |
| 875 | 真心英雄 (Live)-纵贯线 | Live in Taipei 出发/终点站 | 纵贯线 |
| 876 | 秘密-卡洛儿 | 秘密 | 卡洛儿 |
| 877 | Time (Official)-MKJ | Time After Time | MKJ |
| 878 | 但愿人长久-邓丽君 | 但愿人长久 15周年纪念集 | 邓丽君 |
| 879 | The Next Episode | The Next Episode | Dr. Dre / Snoop Dogg / Kurupt / Nate Dogg |
| 880 | 你潇洒我漂亮-韩宝仪 | 台湾福建 畅销金曲沙龙镭射效果音乐 | 韩宝仪 |
| 881 | 驼铃-刀郎 | 披着羊皮的狼 | 刀郎 |
| 882 | 爱要坦荡荡 (Live)-丁丁 | 《中国好声音》2012跨年演唱会 | 丁丁 |
| 883 | Italia e voi（Orginal Mix）-HSHK | Italia e voi | HSHK / 贰皮 / VodKa / Pnan |
| 884 | かごめと犬夜叉 | TVアニメーション「犬夜叉」オリジナルサウンドトラックアルバム「犬夜叉 音楽篇」 | 和田薫 |
| 885 | 琵琶语-林海 | 林海影视配乐精选 | 林海 |
| 886 | 비오는 소리 (Intro)下雨的声音-July | To Heaven | July |
| 887 | 北国之春-邓丽君 | 邓丽君 纪念特别专辑 第二辑 | 邓丽君 |
| 888 | アシタカせっ記 (The Legend of Ashitaka)-久石让 | もののけ姫 イメージアルバム | 久石让 (ひさいし じょう) |
| 889 | Past Lives-Past Lives-Jasper、Martin Arteta | Past Lives | Jasper / Martin Arteta / 11:11 Music Group |
| 890 | K歌之王-陈奕迅 | 打得火热 | 陈奕迅 |
| 891 | Winter Without You-Gloria Kim | Winter Without You | Gloria Kim |
| 892 | 成全(电视剧《梦想成真》片头曲)-刘若英 | 年华 | 刘若英 |
| 893 | Run Me Out-Zola Jesus | How to Get Away with Murder | Zola Jesus |
| 894 | Pilgrimage-Jannik | Pilgrimage Epic Orchestral | Jannik |
| 895 | We No Speak Americano(UK Radio Edit)-Yolanda Be Cool | We No Speak Americano | Yolanda Be Cool |
| 896 | 荷塘月色-凤凰传奇 | 我从草原来 新歌+精选 | 凤凰传奇 |
| 897 | 芦苇荡(电影《大话西游》插曲)-赵季平 | 热门华语20 | 赵季平 |
| 898 | Deflagration-Silver Screen | Under Siege | Silver Screen |
| 899 | The Boys | 'The Boys' The 3rd Album | 少女时代 |
| 900 | 我用什么把你留住-福禄寿FloruitShow | 我用什么把你留住 | 福禄寿FloruitShow |
| 901 | Wicked Wonderland (Radio Edit)-Martin Tungevaag | Wicked Wonderland | Martin Tungevaag |
| 902 | 幽默-胡伟立 | 九品芝麻官之白面包青天 电影原声 | 胡伟立 |
| 903 | 不将就(电影《何以笙箫默》片尾主题曲)-李荣浩 | 有理想 | 李荣浩 |
| 904 | Alone-Alan Walker | Alone | Alan Walker |
| 905 | Time Back-Bad Style | 最新热歌慢摇63 | Bad Style |
| 906 | Numb Encore | Look Out For Detox | Dr. Dre / 50 Cent / JAY-Z / Eminem / Linkin Park |
| 907 | Star Sky-Two Steps From Hell | Battlecry | Two Steps From Hell |
| 908 | Oceanside | Melody Lane | Lainey Lou |
| 909 | One Day In Spring | One Day In Spring | Bandari |
| 910 | Deadwood-Really Slow Motion | Deadwood | Really Slow Motion |
| 911 | Promises | Promises | Ryn Weaver |
| 912 | 我知道-By2 | Twins | By2 |
| 913 | Between Worlds | X I I | Roger Subirana |
| 914 | Dream It Possible | Dream It Possible | Delacey |
| 915 | 桔梗谣-金栄実 | 伽倻琴演奏《与你一起》 | 金栄実 |
| 916 | 桔梗谣-이금미 | Korea: Folk Songs I - Songs Of Kyonggido District | 이금미 |
| 917 | Simon Birch | The Bucket List (Original Motion Picture Soundtrack) | Marc Shaiman |
| 918 | Firework | Teenage Dream | Katy Perry |
| 919 | Everything at Once | Two | Lenka |
| 920 | 口弦-妙子 | 独家爱唱Ⅲ | 妙子 |
| 921 | Murder In My Mind-Kordhell | Murder In My Mind | Kordhell |
| 922 | 在你的身边 (0.8x)-慢热的气球 | 在你的身边 (0.8x) | 慢热的气球 |
| 923 | Once Upon a Time in America: Deborah's Theme-Ennio Morricone | The Grandmaster (Original Score) | Ennio Morricone |
| 924 | Morsmordre-Crazy Donkey | Morsmordre | Crazy Donkey |
| 925 | 旅行的意义(TRAVEL IS MEANINGFUL) | 渺渺 电影原声 | 陈绮贞 |
| 926 | 空 (TV Mix) | 中華一番! スペシャルTVオンエアーミックス& ― オリジナル・サウンドトラック | 大黒摩季 |
| 927 | 模特 | 模特 | 李荣浩 |
| 928 | FourFiveSeconds | FourFiveSeconds | Rihanna / Kanye West / Paul McCartney |
| 929 | Anacreon-Bear McCreary | Foundation: Season 1 (Apple TV+ Original Series Soundtrack) | Bear McCreary |
| 930 | 风居住的街道（Piano ver） (翻自 磯村由紀子）-饭碗的彼岸 | Piano Cover | 饭碗的彼岸 |
| 931 | 爱转角 | Best Show | 罗志祥 |
| 932 | 我真的受伤了(电影《Delete爱人》插曲)-王菀之 | Audiophile Compilations | 王菀之 |
| 933 | Like That-Bea Miller | Chapter Two: Red | Bea Miller |
| 934 | Take Me Home Country Roads-John Denver | Take Me Home: The John Denver Story | John Denver |
| 935 | Maps | Maps | Maroon 5 |
| 936 | One Match-Sarah Harmer | oh little fire | Sarah Harmer |
| 937 | 半生雪-七叔-叶泽浩 | 半生雪 | 七叔-叶泽浩 |
| 938 | MR.TAXI(Korean ver.) | 'The Boys' The 3rd Album | 少女时代 |
| 939 | Gentle-Isaac Shepard | Deep Joy | Isaac Shepard |
| 940 | 故人泪-麦小兜 | 故人泪 | 麦小兜 |
| 941 | May It Be-Bandari | MistyLand | Bandari |
| 942 | 秘密-王珺 | 一尘不染 | 王珺 |
| 943 | 赤伶-李玉刚 | 赤伶 | 李玉刚 |
| 944 | My Songs Know What You Did In The Dark (Light Em Up) (2 Chainz Remix) | My Songs Know What You Did In The Dark (Light Em Up) | Fall Out Boy |
| 945 | Emerald-Ariel | Elan | Ariel |
| 946 | River Flows In You | Tales Of Dusk And Dawn Chapter II | Various Artists |
| 947 | Roar | Roar | Katy Perry |
| 948 | 同桌的你-老狼 | 龙凤金歌榜 | 老狼 |
| 949 | Just Blue-Space | Just Blue | Space |
| 950 | Secrets AMFB Onerepublic | Time Machine (Part 1) | Bryson Andres |
| 951 | 当爱已成往事-张国荣 | 最红 | 张国荣 |
| 952 | The Telephone Box | The Magic Empire | Uniform Motion |
| 953 | 在你的身边-盛哲 | 在你的身边 | 盛哲 |
| 954 | Why-Sabrina Carpenter | Why | Sabrina Carpenter |
| 955 | Sunrise | waiting for the light | Catie Mckinney |
| 956 | Walk on By-Noosa | Wonderland | Noosa |
| 957 | Shiver-skel | Shiver | skel |
| 958 | 映山红-刀郎 | 红色经典 | 刀郎 |
| 959 | Liberators-Epic Score | Vengeance - ES033 | Epic Score |
| 960 | Dismantle-Peter Sandberg | Dismantle | Peter Sandberg |
| 961 | 彩虹-周杰伦 | 我很忙 | 周杰伦 |
| 962 | Older-Sasha Alex Sloan | Older | Sasha Alex Sloan |
| 963 | Radius-Hi-Finesse | Axiom | Hi-Finesse |
| 964 | The Final Countdown | The Final Countdown: The Best Of Europe | Europe |
| 965 | Hyacinth-July | In Love | July |
| 966 | 遺憾-陈洁仪 | 重譯 陳潔儀.重奏 | 陈洁仪 |
| 967 | One More Light(又一道光芒)-Linkin Park | One More Light | Linkin Park |
| 968 | 敢问路在何方-刀郎 | 电视剧新西游记主题曲 | 刀郎 |
| 969 | 时を越えて かごめ | 犬夜叉 音楽撰集 | 和田薫 |
| 970 | 隐形的翅膀 (Live)-腾格尔 | 聚划算99划算盛典Live | 腾格尔 |
| 971 | The Party Troll-D1ofaquavibe | The Party Troll | D1ofaquavibe |
| 972 | 有形的翅膀-张韶涵 | 有形的翅膀 | 张韶涵 |
| 973 | Novera-Dark Winter Music | Epic World Volume2 Return 归来(2014) | Dark Winter Music |
| 974 | SCARSONG-flash8 | 最新热歌慢摇3 | flash8 |
| 975 | Concerto No. 4 in F minor, Op. 8, RV 297, "L'inverno" (Winter): II. Largo | The Four Seasons: The Vivaldi Album | Anne Akiko Meyers / English Chamber Orchestra / David Lockington |
| 976 | 光阴的故事(Live)-纵贯线 | Live in Taipei 出发/终点站 | 纵贯线 |
| 977 | Somewhere | Somewhere | July |
| 978 | If We Ever Broke Up-Mae Stephens | If We Ever Broke Up | Mae Stephens |
| 979 | Close Eyes (Slowed + Reverb)-DVRST | Close Eyes (Slowed + Reverb) | DVRST |
| 980 | 别再闹了(电影《来电狂响》暖冬主题曲)-毛不易 | 别再闹了 | 毛不易 |
| 981 | 月亮代表我的心-张国荣 | Miss You Much, Leslie | 张国荣 |
| 982 | Look4You-Alberto Ciccarini | Look4You | Alberto Ciccarini |
| 983 | 北国の春-木村好夫 | 木村好夫-ギター演歌名曲全集2 | 木村好夫 |
| 984 | 不得不爱-潘玮柏、弦子 | 夏日撒糖情歌 | 潘玮柏 / 弦子 |
| 985 | Future Funk-Varien | Pick Your Poison Vol. 01 | Varien |
| 986 | Balenciaga-T3nzu | Balenciaga | T3nzu |
| 987 | A Quiet Departure-Josh Leake | Benjamin | Josh Leake |
| 988 | A Mozart Reincarnated-Ennio Morricone | La Leggenda del Pianista Sull'oceano | Ennio Morricone |
| 989 | Best Moments (feat. Kondor)-Blazo | Alone Journey | Blazo |
| 990 | 舞女泪-韩宝仪 | 怀念金曲 | 韩宝仪 |
| 991 | Becoming a Legend-John Dreamer | Becoming a Legend - Single | John Dreamer |
| 992 | 下一站天后(电影《下一站天后》主题曲)-Twins | 我们相爱6年(新曲+精选) | Twins |
| 993 | Beloved-Dan Gibson | Native Harmony | Dan Gibson |
| 994 | 明天会更好-群星 | 明天会更好 | 群星 |
| 995 | 全是爱-凤凰传奇 | 最炫民族风 | 凤凰传奇 |
| 996 | 我怀念的-孙燕姿 | 逆光 - (Against The Light) | 孙燕姿 |
| 997 | Brotherhood-John Dreamer | Brotherhood | John Dreamer |
| 998 | 昨夜星辰-高胜美 | 旧情绵绵(珍藏版3) | 高胜美 |
| 999 | Hello Zepp-Charlie Clouser | Saw (Original Motion Picture Soundtrack) | Charlie Clouser |
| 1000 | 晚秋-毛宁 | 二十世纪原创经典典藏 龙凤金歌榜 | 毛宁 |
| 1001 | Mind Heist(电影《盗梦空间》预告片配乐) | Inception Trailer | Zack Hemsey |
| 1002 | RAVE-Dxrk ダーク | RAVE | Dxrk ダーク |
| 1003 | Golden Key-Isgaard | Golden Key [#2] | Isgaard |
| 1004 | Koko-Ariel | Koko | Ariel |
| 1005 | Anatomy | Anatomy | DJRUSTAM / FIZO FAOUEZ |
| 1006 | Eye of the Tiger-Survivor | Eye Of The Tiger | Survivor |
| 1007 | 甜蜜蜜(Sweet)-邓丽君 | 宝丽金经典中文金曲 | 邓丽君 |
| 1008 | 遗憾(新加坡电视剧《实况剧场》主题曲)-许美静 | 遗憾 | 许美静 |
| 1009 | Famous-Ivy Adara | Famous | Ivy Adara |
| 1010 | 耍猴儿(百鬼夜行) (唢呐版)-Harry来了 | 未知 | Harry来了 |
| 1011 | 无问(电影《无问西东》宣传曲)-毛不易 | 无问 | 毛不易 |
| 1012 | 1901-Birdy | Birdy (Deluxe Version) | Birdy |
| 1013 | 2002 (Acoustic)-Amber Leigh Irish | Unplugged Acoustic, Vol. 2 | Amber Leigh Irish |
| 1014 | 水星记-郭顶 | 飞行器的执行周期 | 郭顶 |
| 1015 | golden hour-JVKE | this is what ____ feels like (Vol. 1-4) | JVKE |
| 1016 | The Black Rose-Joanie Madden | Celtic Twilight 2 | Joanie Madden |
| 1017 | My Sunset (Original Mix)-Feint | Feint EP2 | Feint |
| 1018 | 雨空-α·Pav | Colors | α·Pav |
| 1019 | 白色风车-周杰伦 | 依然范特西 | 周杰伦 |
| 1020 | Tuesday-Burak Yeter Danelle | Dance 2017 - Armada Music | Burak Yeter / Danelle |
| 1021 | 红玫瑰-陈奕迅 | 认了吧 | 陈奕迅 |
| 1022 | Welcome to Jurassic World(电影《侏罗纪世界》配乐)-Michael Giacchino | Jurassic World (Original Motion Picture Soundtrack)- (侏罗纪世界) | Michael Giacchino |
| 1023 | PDD洪荒之力-Hoaprox | #Lov3 #Ngẫu Hứng | Hoaprox |
| 1024 | 告白之夜（纯音乐）-CMJ | 告白の夜 | CMJ |
| 1025 | 匆匆那年 (纯音乐)-梁翘柏 | 匆匆那年 电影原声带 | 梁翘柏 |
| 1026 | 兰亭序-吴紫涵 | 情动心弦 | 吴紫涵 |
| 1027 | 往事只能回味-韩宝仪 | 旧情绵绵 | 韩宝仪 |
| 1028 | Ghost Bride Prelude-Nate Connelly | 僵尸 电影原声大碟 | Nate Connelly |
| 1029 | You-Approaching Nirvana | Blocking the Sky Redux | Approaching Nirvana |
| 1030 | Whisper Of Hope (Main)-Gothic Storm | Epic Emotional Piano | Gothic Storm |
| 1031 | The Imperial March(帝国进行曲)-John Williams | Music from the Star Wars Saga- (星球大战) | John Williams |
| 1032 | Young Hearts-Dirk Reichardt | Kokowääh 2 (Original Motion Picture Soundtrack) | Dirk Reichardt |
| 1033 | James Bond Theme-John Barry Monty Norman | Dr. No (Original Motion Picture Soundtrack) | John Barry / Monty Norman |
| 1034 | A Little Bit Broken-Spritely | A Little Bit Broken | Spritely |
| 1035 | メインテーマ「永遠の一瞬」（主题「永恒的一瞬」）-伊藤賢治 | この青空に約束をー~ようこそつぐみ寮へ~Piano Stories | 伊藤賢治 |
| 1036 | 潮鳴り-折戸伸治 | CLANNAD ORIGINAL SOUNDTRACK | 折戸伸治 |
| 1037 | The Pink Panther Theme-Henry Mancini | In the Pink | Henry Mancini |
| 1038 | 白いスーツのテーマ(白色西装主题曲)-市川淳 | TBS系 金曜ドラマ うぬぼれ刑事 オリジナル・サウンドトラック | 市川淳 |
| 1039 | 穿越时空的爱恋-CMJ | 穿越时空的爱恋 | CMJ |
| 1040 | 像我这样的人-毛不易 | 平凡的一天 | 毛不易 |
| 1041 | 北国の春(北国之春)-渥美二郎 | 全日傳 砂金之卷+鉑環之卷 | 渥美二郎 |
| 1042 | Dusk Till Dawn | Piano Acoustic Covers Vol 2 | Kurt Hugo Schneider / Kirsten Collins / Blake Rose |
| 1043 | Dreamland-Liquid Mind | Liquid Mind XI: Deep Sleep | Liquid Mind |
| 1044 | 月亮之上-凤凰传奇 | 月亮之上 | 凤凰传奇 |
| 1045 | 浮光 (The History)-Jannik | 浮光 (The History) | Jannik |
| 1046 | Criminals-F.O.O.L | Revenger | F.O.O.L |
| 1047 | P.I.M.P-TangTian | P.I.M.P | TangTian |
| 1048 | Halloween Theme - Main Title | Greatest Hits | John Carpenter |
| 1049 | 王进打高俅-赵季平 | 水浒传 原声音乐 | 赵季平 |
| 1050 | 平凡的一天-毛不易 | 平凡的一天 | 毛不易 |
| 1051 | 梦醒时分(电视剧《1989一念间》插曲)-陈淑桦 | 1989一念间 电视原声带 | 陈淑桦 |
| 1052 | 无名的人(电影《雄狮少年》主题曲)-毛不易 | 无名的人 | 毛不易 |
| 1053 | 流浪者之歌-Budapest Festival Orchestra 诹访内晶子 | 惠威试音专用Ⅱ | Budapest Festival Orchestra / 诹访内晶子 |
| 1054 | 恨爱交加-麦振鸿 | 天地传说之创世纪乐章 | 麦振鸿 |
| 1055 | 虞兮叹-闻人听書_ | 虞兮叹 | 闻人听書_ |
| 1056 | 淘汰-陈奕迅 | 认了吧 | 陈奕迅 |
| 1057 | 消愁-毛不易 | 平凡的一天 | 毛不易 |
| 1058 | 高山流水-王昌元 | 中国古筝名家名曲——中国民族器乐精品系列 | 王昌元 |
| 1059 | 美丽拍挡-胡伟立 | 国产凌凌漆 | 胡伟立 |
| 1060 | Polska-Sava | Aire | Sava |
| 1061 | Curtain-凌晨一点的莱茵猫 | Curtain falls | 凌晨一点的莱茵猫 |
| 1062 | 奢香夫人-凤凰传奇 | 最炫民族风 | 凤凰传奇 |
| 1063 | 金三角 (恐怖纯音乐) | 金三角（恐怖纯音乐） | R̶ᴇ̶ɢ̶ʀ̶ᴇ̶ᴛ̶. |
| 1064 | sans.-Toby Fox | UNDERTALE Soundtrack | Toby Fox |
| 1065 | 一荤一素-毛不易 | 平凡的一天 | 毛不易 |
| 1066 | 一程山路-毛不易 | 小王 | 毛不易 |
| 1067 | 夏夜-四季音色 | 春夏之交，轻旋淡律 | 四季音色 |
| 1068 | 人形の館-岩崎琢 | 黒執事 サウンドコンプリート BLACK BOX | 岩崎琢 |
| 1069 | Single Ladies (Put a Ring on It)-Beyoncé | Single Ladies (Put A Ring On It) - Dance Remixes | Beyoncé |
| 1070 | 十面埋伏(琵琶独奏)-群星 | 中国古典音乐历朝黄金年鉴 | 群星 |
| 1071 | 她的微笑 (original Mix)-阳山伟伟 | 她的微笑 (original Mix) | 阳山伟伟 |
| 1072 | Mystery of Love-Luke Pickman | Mystery of Love | Luke Pickman |
| 1073 | 西厢寻他-伯爵Johnny / 唐伯虎Annie | 西厢寻他 | 伯爵Johnny / 唐伯虎Annie |
| 1074 | 西楼别序-尹昔眠 / 小田音乐社 | 西楼别序 | 尹昔眠 / 小田音乐社 |
| 1075 | 青天-胡伟立 | 九品芝麻官之白面包青天 电影原声 | 胡伟立 |
| 1076 | 青空-Candy_Wind | 拂晓车站 | Candy_Wind |
| 1077 | 勇往直前-胡伟立 | 唐伯虎点秋香 | 胡伟立 |
| 1078 | 遗憾-李代沫 | 我的歌声里 | 李代沫 |
| 1079 | 执迷不悟-铁脑袋mp3 | 执迷不悟 | 铁脑袋mp3 |
| 1080 | 小心な侵入者-根岸貴幸 | カードキャプターさくら オリジナル・サウンドトラック4 | 根岸貴幸 |
| 1081 | 小鱼儿与花无缺片头音乐-麦振鸿 | 武侠音乐系列之豪气中天 （截取版） | 麦振鸿 |
| 1082 | 菊花台-周杰伦 | 依然范特西 | 周杰伦 |
| 1083 | 雨的舞步-赵大鼾 | 雨的舞步 | 赵大鼾 |
| 1084 | Lost Love (Instrumental)-Lunnna Janey杰尼 | Memories | Lunnna / Janey杰尼 |
| 1085 | 我从草原来-凤凰传奇 | 我从草原来 新歌+精选 | 凤凰传奇 |
| 1086 | 起风了(BILIBILI 11周年演讲)-周深 | 起风了 | 周深 |
| 1087 | Betrayal Voices | Horror/Sci-Fi #1 | Immediate Music |
| 1088 | Theme from Mission: Impossible-Danny Elfman | Mission Impossible [Original Score] | Danny Elfman |
| 1089 | 明月夜-张国荣 | 兜风心情 | 张国荣 |
| 1090 | 匆匆那年-周深 | 匆匆那年 | 周深 |
| 1091 | Trinity: Con la Stella Di Vicesceriffo-Franco Micalizzi | Lo Chiamavano Trinita (They Call Me Trinity) | Franco Micalizzi |
| 1092 | Dum Dum Dum-RENEE | Extending Playground | RENEE |
| 1093 | Theme From Jurassic Park (From "Jurassic Park" Soundtrack)-John Williams | Jurassic Park (Soundtrack) | John Williams |
| 1094 | 至少还有你-林忆莲 | 林忆莲's | 林忆莲 |
| 1095 | 再见(Live)-纵贯线 | Live in Taipei 出发/终点站 | 纵贯线 |
| 1096 | 不能说的秘密-周杰伦 | 不能说的秘密 电影原声带 | 周杰伦 |
| 1097 | 漂洋过海来看你-周深 | 漂洋过海来看你 | 周深 |
| 1098 | Luminous-贝奇Becky | Luminous | 贝奇Becky |
| 1099 | 不再犹豫-Twins | 青春重置计划之BEYOND 40 | Twins |
| 1100 | 最炫民族风-凤凰传奇 | 最炫民族风 | 凤凰传奇 |
| 1101 | 自由飞翔-凤凰传奇 | 吉祥如意 | 凤凰传奇 |
| 1102 | Octopus-ALan | Octopus | ALan |
| 1103 | 霍元甲-周杰伦 | 霍元甲 | 周杰伦 |
| 1104 | 迷迭香-周杰伦 | 依然范特西 | 周杰伦 |
| 1105 | 恋曲1980 (Live)-纵贯线 | Live in Taipei 出发/终点站 | 纵贯线 |
| 1106 | 光阴的故事-北京天使合唱团 | 光阴的故事 | 北京天使合唱团 |
| 1107 | 欢沁-林海 | 林海影视配乐精选 | 林海 |
| 1108 | No Glory | No Glory | Krale / M.I.M.E / Drama B / Skan |
| 1109 | 这，就是爱-张杰 | 这，就是爱 | 张杰 |
| 1110 | Criticalpoint-凌晨一点的莱茵猫 | Criticalpoint | 凌晨一点的莱茵猫 |
| 1111 | 夜曲-周杰伦 | 十一月的萧邦 | 周杰伦 |
| 1112 | 烟花易冷-周杰伦 | 跨时代 | 周杰伦 |
| 1113 | 恋曲1990(Live)-纵贯线 | Live in Taipei 出发/终点站 | 纵贯线 |
