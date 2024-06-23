# woodwhales-music

[![](https://img.shields.io/badge/author-woodwhales-green.svg)](https://music.icoders.cn) ![](https://img.shields.io/badge/license-GPL%203.0-orange.svg)

> 基于 SpringBoot 的开源超简洁音乐播放器
> 
> A open source Music Player developed based on Java SpringBoot

<div align=center>在线播放：<a href="https://music.icoders.cn">https://music.icoders.cn</a></div>

环境要求：JDK 17+

前端技术栈：Vue 2.0 + Element-UI + Thymeleaf + Axios + APlayer

后端技术栈：Spring Boot3 + Spring Security6 + jsoup + MyBatis-Plus + MySQL

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

> 系统启动时会执行 [woodwhales-music/src/main/resources/init.sql](https://github.com/woodwhales/woodwhales-music/blob/master/src/main/resources/init.sql) 脚本进行库表结构初始化

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

    - 后台系统密码：`system.init.password`
    
    ```yaml
    system:
    init:
    # 后台系统admin账号的登录密码，每次初始化都会初始化
    password: xxx
    ```
    
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

### 2.2 后台登录流程图

![](doc/images/Admin-Login-Process-Flowchart.jpg)

## 3. 编译打包

### 3.1 打包 jar 文件 

执行 mvn 命令打包：

```shell
mvn clean package -Pdev
```

打包成功的 woodwhales-music.jar 文件在项目根目录下的 target 文件目录中。

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

### 3.2 docker 构建

> 本系统在 docker hub 仓库中提供了最新版本镜像
>
> ```shell
> docker pull woodwhales/woodwhales-music
> ```

本系统提供俩种构建方式：

#### 方式1：mvn 命令构建

命令行执行目录切换到项目根目录，执行如下命令：

```shell
mvn clean install
```
或者：

```shell
mvn clean package docker:build
```

控制台输出 BUILD SUCCESS 信息，即表示构建成功。

![](doc/images/build-with-maven.png)

#### 方式2：docker-compose 命令构建

命令行执行目录切换到项目根目录，执行如下命令：

```shell
docker-compose build
```

控制台输出 docker 镜像信息，即表示构建成功

![](doc/images/build-with-docker-compose.png)

## 4. 启动方式

注意：本系统服务需要依赖 mysql 数据库，在第一次安装之前请自行准备一个可以访问的 mysql 服务。

执行创建名为 open-music 数据库 sql 命令：

```sql
CREATE DATABASE IF NOT EXISTS open_music CHARACTER 
	SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 方式1：jar 包启动

系统安装 jdk 版本 17 以上，命令行切换至 woodwhales-music.jar 所在目录，执行如下命令：

```shell
java -jar woodwhales-music.jar
```

如果出现数据库链接失败，则检查在编译打包 jar 文件时指定什么环境参数，确认数据库链接是否配置正确。

### 方式2：docker 启动

完整的 docker 启动命令：

```shell
docker run -d \
--restart=always \
--name woodwhales-music \
-p 8084:8084 \
-e "MYSQL_HOST=host.docker.internal" \
-e "MYSQL_DATABASE=open-music" \
-e "MYSQL_PORT=3306" \
-e "MYSQL_USER=root" \
-e "MYSQL_PASSWORD=root1234" \
-e "SYSTEM_INIT_PASSWORD=admin" \
woodwhales/woodwhales-music:latest
```

环境命令参数说明：

| 环境参数             | 说明                                                         | 默认值               |
| -------------------- | ------------------------------------------------------------ | -------------------- |
| MYSQL_HOST           | mysql 数据库服务的链接地址，默认值针对 windows、mac 系统生效，linux 系统需要用户强制指定宿主机 IP | host.docker.internal |
| MYSQL_DATABASE       | 数据库名称                                                   | open-music           |
| MYSQL_PORT           | mysql 数据库服务的端口号                                     | 3306                 |
| MYSQL_USER           | mysql 数据库服务的账号名称                                   | root                 |
| MYSQL_PASSWORD       | mysql 数据库服务的账号密码                                   | root1234             |
| SYSTEM_INIT_PASSWORD | woodwhales-music 系统的后台管理员 admin 账号登录密码，**生产环境请勿必自定义** | admin                |

## 5. 功能说明

### v3.7.1

- 添加、编辑音乐时，可以根据 html 页面源码解析封面链接
- 增加 favicon
- 修复分页大于 100 时页码数据不对问题

### v3.7.0

- Spring Boot 2.0 升级至 Spring Boot 3.0，Spring Security 5.0 升级至 Spring Security 6.0（JDK 版本要求 17 以上）
- 系统启动时增加默认执行初始化库表 SQL 脚本
- 增加 2FA 认证
- 后台可视化配置 2FA 认证
- 重构后台登录页面
- README 文档说明排版更新
- 增加 docker 构建配置文件

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

## 6. 歌单

已收录 1134 首音乐

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
| 164 | Crystal Ball-Lenka | Attune | Lenka |
| 165 | Anacreon-Bear McCreary | Foundation: Season 1 (Apple TV+ Original Series Soundtrack) | Bear McCreary |
| 166 | 湘江中路-庄达菲 | 湘江中路 | 庄达菲 |
| 167 | 夜空中最亮的星 | 世界 | 逃跑计划 |
| 168 | 般若波罗蜜多心经 | 《大唐玄奘》电影片尾曲 | 王菲 |
| 169 | 彩云之南 | 彩云之南 | 徐千雅 |
| 170 | 合肥的石头 | 赤脚青春 | 飘乐队 |
| 171 | 似夜流月 | 热门华语234 | 宗次郎 (そうじろう) |
| 172 | 北国之春 (日文版)-邓丽君 | 邓丽君15周年但愿人长久 | 邓丽君 |
| 173 | A Day in the Life-John Lennon | Imagine: John Lennon | John Lennon |
| 174 | Caribbean Blue 加勒比海蓝 | Moonlight Bay | Bandari |
| 175 | Five hundred miles | America, Vol. 10: Country - The Folk Revival Revolution | The Journeymen |
| 176 | Right Now (Na Na Na) | Right Now (Na Na Na) | Akon |
| 177 | Victory | Battlecry | Two Steps From Hell |
| 178 | 桔梗谣(道拉基) (朝鲜民谣) | 恋恋金达莱 | 蒋薇 |
| 179 | Down By the Salley Gardens | Song of the Irish Whistle | Joanie Madden |
| 180 | 追梦人 | 浮世情怀 | 凤飞飞 |
| 181 | 小鱼儿的思绪 | 武侠音乐系列第二部之思情篇（截取版） | 麦振鸿 |
| 182 | 故乡 | 我只有两天.许巍精选 | 许巍 |
| 183 | Bubbly | So Fresh - The Hits Of Autumn 2008 | Colbie Caillat |
| 184 | 勇敢的心 | 勇敢的心 | 汪峰 |
| 185 | 我很好 | I'm fine | 刘沁 |
| 186 | 江南 | 他是…JJ林俊杰 | 林俊杰 |
| 187 | 年少有为 | 耳朵 | 李荣浩 |
| 188 | Price Tag | Price Tag | Jessie J / B.o.B |
| 189 | The Sound of Silence_轻音乐 | The Best Pan Pipes in the World...Ever! | Panpipes |
| 190 | Eversleeping | Eversleeping | Xandria |
| 191 | Breaking My Heart | Unreleased | Lana Del Rey |
| 192 | Dying In the Sun | Bury the Hatchet | The Cranberries |
| 193 | See You Again | See You Again | See You Again |
| 194 | I Am You | I Am You | Kim Taylor |
| 195 | I'm Yours | I'm Yours | Jason Mraz |
| 196 | Innocence | The Best Damn Thing: Deluxe Edition | Avril Lavigne |
| 197 | 如果这都不算爱-张学友 | 学友 热 | 张学友 |
| 198 | 一生所爱 | 齐天周大圣之西游双记 电影歌乐游唱版 | 卢冠廷 / 莫文蔚 |
| 199 | 潇洒地走 | 潇洒地走 | 张蔷 |
| 200 | Apologize | Dreaming Out Loud (Tour Edition) | OneRepublic |
| 201 | Better Than One | The Score EP 2 | The Score |
| 202 | 停格 | 停格 | 蔡健雅 |
| 203 | When You're Gone | When You're Gone | Avril Lavigne |
| 204 | Astronomia | Astronomia | Vicetone / Tony Igy |
| 205 | 容易受伤的女人 | 阿菲正传 | 王菲 |
| 206 | River Flows In You | Kuschelklassik Piano Dreams, Vol. 2 | Martin Ermen |
| 207 | 倔强 | 神的孩子都在跳舞 | 五月天 |
| 208 | 牛仔很忙 | 我很忙 | 周杰伦 |
| 209 | 凄美地-郭顶 | 飞行器的执行周期 | 郭顶 |
| 210 | 面会菜-林生祥 | [大佛普拉斯] 电影配乐 | 林生祥 |
| 211 | 当爱在靠近 | Love & the City | 刘若英 |
| 212 | 日晷之梦 | 幸福时光 精选辑 | Kevin Kern |
| 213 | Last Reunion | Lament of Valkyrie (Epicmusicvn Series) | Peter Roe |
| 214 | 起风了 | 起风了 | 吴青峰 |
| 215 | Concerning Hobbits | The Lord of the Rings: The Fellowship of the Ring (Original Motion Picture Soundtrack) | Howard Shore |
| 216 | 叱咤红人 | 相依为命: 20年精彩印记 | 陈小春 |
| 217 | 天才白痴梦 | 天才与白痴 | 许冠杰 |
| 218 | 分手以后才知道最珍贵 | 回到家乡 | 胡力 |
| 219 | 往事只能回味 | 怀念老歌一 | 高胜美 |
| 220 | 原来你也在这里 | 我的失败与伟大 | 刘若英 |
| 221 | 我这家伙的答案是你 | AsuRa BalBalTa | Leessang / 河琳 |
| 222 | 往事只能回味 | 我是歌手第四季 第9期 | 金志文 |
| 223 | 勇敢的心 | 最新热歌慢摇88 | Various Artists |
| 224 | 等一分钟 | 滕爱Teng Love | 徐誉滕 |
| 225 | 我想大声告诉你 (《蜗居》电视剧片尾曲) | 我想大声告诉你 | 樊凡 |
| 226 | 光阴的故事 | 光阴的故事 | 黄晓明 邓超 佟大为 |
| 227 | 越长大越孤单 | 越长大越孤单 | 牛奶咖啡 |
| 228 | 往事只能回味 | 说时依旧 | 好妹妹 |
| 229 | 知足 | 知足 最真杰作选 | 五月天 |
| 230 | 一起摇摆 | 生来彷徨 | 汪峰 |
| 231 | 演员 | 绅士 | 薛之谦 |
| 232 | 南方姑娘 | 赵小雷 | 赵雷 |
| 233 | 我最亲爱的 | 你在看我吗 | 张惠妹 |
| 234 | 篇章-张韶涵 / 王赫野 | 篇章 | 张韶涵 / 王赫野 |
| 235 | 你的样子 | 罗大佑自选辑 | 罗大佑 |
| 236 | 문을 여시오 (New Ver.) 请开门 | 문을 여시오 | 任昌丁 / 金昌烈 |
| 237 | Cornfield Chase | Interstellar (Original Motion Picture Soundtrack) | Hans Zimmer |
| 238 | Riverside | Philharmonics (Deluxe Edition) | Agnes Obel |
| 239 | Gotta Have You | Say I Am You | The Weepies |
| 240 | Big Big World | Big Big World | Emilia |
| 241 | 认错 | 自定义 | 许嵩 |
| 242 | My Heart Will Go On | Love Ballads | Kenny G |
| 243 | 月光下的凤尾竹 (葫芦丝) | 金耳朵.发烧民乐 | 纯音乐 |
| 244 | Love The Way You Lie | Life After Recovery | Eminem / Rihanna |
| 245 | 好汉歌 | 好汉歌 | 刘欢 |
| 246 | 布拉格广场 | 看我72变 | 蔡依林 / 周杰伦 |
| 247 | 粉红色的回忆 | 粉红色的回忆 | 韩宝仪 |
| 248 | 大敦煌-刀郎 | 谢谢你 | 刀郎 |
| 249 | Childhood Memory 童年 | Sunny Bay | Bandari |
| 250 | Dream Catcher 追梦人 | Relaxation - Dreams | Bandari |
| 251 | 小苹果 | 老男孩之猛龙过江 电影原声 | 筷子兄弟 |
| 252 | 穿越时空的思念 (DiESi Remix) | 穿越时空的思念 | DiESi |
| 253 | Hello | Hello | Adele |
| 254 | Chiru (Saisei No Uta) | Nostalgic | Robert de Boron |
| 255 | Southampton | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 256 | 雪见·落入凡尘 | 仙剑奇侠传三 电视剧原声带 | 麦振鸿 |
| 257 | 时间都去哪儿了 | 听得到的时间 | 王铮亮 |
| 258 | 土耳其进行曲 | 土耳其进行曲 | Various Artists |
| 259 | That's Not My Name | That's Not My Name | The Ting Tings |
| 260 | The Mountain of Women | Song of the Irish Whistle | Joanie Madden |
| 261 | Hymn To The Sea | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 262 | Don't push me | Jade - silver edition | sweetbox |
| 263 | Just Give Me A Reason | The Truth About Love | P!nk Nate Ruess |
| 264 | いつも何度でも | Prime Selection | 宗次郎 |
| 265 | 光年之外 | 光年之外 | G.E.M.邓紫棋 |
| 266 | 差生 | 少年中国 | 李宇春 |
| 267 | 人民不需要自由 | 108个关键词（李志的自我修养2012年度汇报演出） | 李志 |
| 268 | Nocturne No. 2 in E Flat Major, Op. 9, No. 2 | The Chopin Collection: The Nocturnes | Arthur Rubinstein |
| 269 | 青花瓷 | 我很忙 | 周杰伦 |
| 270 | Beyond The Memory | Beyond The Memory | July |
| 271 | 十年 | 黑白灰 | 陈奕迅 |
| 272 | 送别 | 送别 | 朴树 |
| 273 | 曹操 | 曹操 | 林俊杰 |
| 274 | 一辈子的孤单 | 涩女郎 电视原声带 | 刘若英 |
| 275 | 黑板情书 | 黑板情书 | 后弦 |
| 276 | I can't let this go on any further | I can't let this go on any further | Savior |
| 277 | 因为爱情 | Stranger Under My Skin | 陈奕迅 王菲 |
| 278 | New Morning 清晨 | Mist | Bandari |
| 279 | Love the Way You Lie Part III (Original Demo) | Don't Look Down | Skylar Grey |
| 280 | 我从崖边跌落 | 算云烟 | 谢春花 |
| 281 | 往事只能回味 | 往事只能回味 | 岳云鹏 / 宋小宝 |
| 282 | 兰亭序 (慢四版)-周杰伦 | 兰亭序 | 周杰伦 |
| 283 | 君が好きだと叫びたい~TV Version~（好想大声说爱你）-BAAD | Slam Dunk Complete Vocal Collection ~TV Version~ | BAAD |
| 284 | 我只在乎你-齐秦 | 柒年·七个音乐故事 | 齐秦 |
| 285 | それが大事（最重要的事） | それが大事 | 大事MANブラザーズバンド / 渡辺禎史 |
| 286 | Never An Absolution | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 287 | Rose | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 288 | Secrets | Secrets | OneRepublic |
| 289 | 突然的自我 | 忘情1015精选辑 | 伍佰 & China Blue |
| 290 | 赤木の不安-徳永暁人 | Slam Dunk Complete Vocal Collection ~TV Version~ | 徳永暁人 |
| 291 | 春风十里 | 所有的酒，都不如你 | 鹿先森乐队 |
| 292 | Roses and Gold | Dust Diaries | Robin Jackson |
| 293 | Yesterday Once More | Yesterday Once More | Carpenters |
| 294 | 星座书上 | 自定义 | 许嵩 |
| 295 | 粉末 | 粉末 | 李宇春 |
| 296 | 苏州城外的微笑 | 很有爱 | 后弦 |
| 297 | Hey Jude | It's a Battle | John Lennon / Paul McCartney / It's a Cover Up |
| 298 | 天下 | 明天过后 | 张杰 |
| 299 | Last Dance | 爱情的尽头 | 伍佰 & China Blue |
| 300 | May It Be(电影《指环王：魔戒再现》插曲)-Enya | The Lord of the Rings: The Fellowship of the Ring (Original Motion Picture Soundtrack) | Enya |
| 301 | The 1950's-Zhao Jiping | Lifetimes (Vivre!) [Original Motion Picture Soundtrack] | Zhao Jiping |
| 302 | Miss Misery | Good Will Hunting (Music from the Miramax Motion Picture) | Elliott Smith |
| 303 | 风继续吹 | 风继续吹 | 张国荣 |
| 304 | Rain after Summer | Rain after Summer | 羽肿 |
| 305 | 宝贝 (in the night) | Original | 张悬 |
| 306 | 不再犹豫 | Beyond The Stage | Beyond |
| 307 | 舞女-韩宝仪 | 舞女 | 韩宝仪 |
| 308 | Take a Bow | Good Girl Gone Bad | Rihanna |
| 309 | 泡沫 | Xposed | G.E.M.邓紫棋 |
| 310 | 天堂 (Live)-腾格尔 | 歌手2018 第7期 | 腾格尔 |
| 311 | 夕焼けの歌（夕阳之歌） | Matchy Best | 近藤真彦 |
| 312 | 梦醒时分-伍佰 & China Blue | 单程车票 | 伍佰 & China Blue |
| 313 | 无论你多怪异我还是会喜欢你-江惠莲 | 刺客伍六七 动画歌曲OST | 江惠莲 |
| 314 | 没有什么不同 | 我的歌声里 | 曲婉婷 |
| 315 | 夜太黑 | 夜太黑 | 林忆莲 |
| 316 | Rise - Epic Music | Rise - Epic Music | John Dreamer |
| 317 | 故乡的原风景 | 武侠音乐精装特辑 | 宗次郎 |
| 318 | 亲爱的那不是爱情 | Ang 5.0 | 张韶涵 |
| 319 | 红色高跟鞋 | 若你碰到他 | 蔡健雅 |
| 320 | The End of the World | The End of the World | Skeeter Davis |
| 321 | 怒放的生命 | 怒放的生命 | 汪峰 |
| 322 | 大约在冬季 | 冬雨 | 齐秦 |
| 323 | 喜欢你 | 喜欢你 | G.E.M. 邓紫棋 |
| 324 | 挪威的森林 | 爱情的尽头 | 伍佰 & China Blue |
| 325 | 本草纲目 | 依然范特西 | 周杰伦 |
| 326 | 小刀会序曲 | 武侠音乐系列之豪气中天 | 商易 / 夏飞云 / 上海民族乐团 |
| 327 | 问题出现我再告诉大家-五条人 | 县城记 | 五条人 |
| 328 | Nijamena | Nijamena | Anurag Kulkarni /Anup Rubens |
| 329 | 2 Soon | Not Thinking Bout 2morrow | Jon Young |
| 330 | 彩云追月 | Edell.Love | 爱戴 |
| 331 | 忧伤倒数 | 夫妻那些事 电视剧原声带 | 小昔米 |
| 332 | 爱情转移 | 认了吧 | 陈奕迅 |
| 333 | 阳光下的我们 | Say The Words | 曲婉婷 |
| 334 | 今天 | 真永远 | 刘德华 |
| 335 | 隐形的翅膀 | 潘朵拉 | 张韶涵 |
| 336 | 蝴蝶泉边 | 崽崽 | 黄雅莉 |
| 337 | Tassel | Dulcet Series spring special collection | Cymophane |
| 338 | 生如夏花 | 生如夏花 | 朴树 |
| 339 | Sugar | V | Maroon 5 |
| 340 | 七里香 | 七里香 | 周杰伦 |
| 341 | 辞·九门回忆 | 辞·九门回忆 | 冰幽 / 解忧草 |
| 342 | 庐州月 | 寻雾启示 | 许嵩 |
| 343 | 我可以抱你吗-张惠妹 | 我可以抱你吗？爱人 | 张惠妹 |
| 344 | Only Time | Only Time: The Collection (Box Set) | Enya |
| 345 | 香水有毒 (DJ版) | 香水有毒(宣传单曲) | 胡杨林 |
| 346 | 有何不可 | 自定义 | 许嵩 |
| 347 | 真的爱你 | BEYOND IV | Beyond |
| 348 | Remember The Time | The Ultimate Collection | Michael Jackson |
| 349 | 漫步人生路-刘惜君 | 惜 . 君 | 刘惜君 |
| 350 | 你的样子 | 一个人的样子 | 林志炫 |
| 351 | Teenage Dream | Teenage Dream | Katy Perry |
| 352 | 莫扎特：《小夜曲》第一乐章 | 2008-2011 演奏实况合集 | 中国国家交响乐团 |
| 353 | Loves Me Not | t.A.T.u. - The Best | t.A.T.u. |
| 354 | 幸せ（幸福）-中岛美雪 | Singles 2000 | 中島みゆき |
| 355 | 穿越时空的思念2 时代を超える想い2 | 映画“犬夜叉 时代を越える想い 音楽篇” | 和田薫 |
| 356 | 毕业说分手 | 毕业说分手 | 冰冰超人 |
| 357 | The South Wind | Song of the Irish Whistle | Joanie Madden |
| 358 | 精忠报国-屠洪刚 | 精忠报国 | 屠洪刚 |
| 359 | 所念皆星河 | 所念皆星河 | CMJ |
| 360 | 可能 | 可能 | 程响 |
| 361 | The Scientist | The Scientist | Coldplay |
| 362 | 大海 | 70老男孩 | 张雨生 |
| 363 | 八年的爱 | 八年的爱 | 冰冰超人 |
| 364 | 漫步人生路-邓丽君 | 邓丽君-传奇的诞生 | 邓丽君 |
| 365 | TiK ToK | Animal | Kesha |
| 366 | Underneath Your Clothes | Laundry Service | Shakira |
| 367 | My Heart Will Go On | My Love: Ultimate Essential Collection (North American Version) | Celine Dion |
| 368 | Rock House Jail | The Rock (Original Motion Picture Score) | Nick Glennie-Smith / Hans Zimmer / Harry Gregson-Williams |
| 369 | 我变了 我没变 | 我变了 我没变 | 杨宗纬 |
| 370 | Trip | Trip | Axero |
| 371 | 断桥残雪 | 断桥残雪 | 许嵩 |
| 372 | 春天里 | 信仰在空中飘扬 | 汪峰 |
| 373 | Lifetimes-Zhao Jiping | Lifetimes (Vivre!) [Original Motion Picture Soundtrack] | Zhao Jiping |
| 374 | 未来へ (向着未来) | 長い間 ～キロロの森～ | Kiroro (キロロ) |
| 375 | What A Wonderful World | All Time Greatest Hits | Louis Armstrong |
| 376 | 光明 | 信仰在空中飘扬 | 汪峰 |
| 377 | 光辉岁月 | 光辉岁月 | Beyond |
| 378 | Rhythm Of The Rain | Let It Be Me | Jason Donovan |
| 379 | Five Hundred Miles (《醉乡民谣》电影主题曲|《一路繁花相送》电视剧插曲) | Inside Llewyn Davis: Original Soundtrack Recording | Justin Timberlake / Carey Mull |
| 380 | 关山酒-等什么君(邓寓君) | 关山酒 | 等什么君(邓寓君) |
| 381 | 画皮-刀郎 | 山歌寥哉 | 刀郎 |
| 382 | 21 Guns | 21st Century Breakdown | Green Day |
| 383 | The truth that you leave | The truth that you leave | Pianoboy高至豪 |
| 384 | 雨过天不晴 | 雨过天不晴 | 柯柯柯啊 |
| 385 | Snowdreams 雪之梦 | Rhine River | Bandari |
| 386 | Not a Single Day 하루도 | Rain's World (Special Edition) | Rain |
| 387 | Summer Vibe | Summer Vibe | Walk off the Earth |
| 388 | We Are One | Super Deluxe Sound I | Kelly Sweet |
| 389 | 北京北京 | 勇敢的心 | 汪峰 |
| 390 | Don't Wanna Know/We Don't Talk Anymore | Don't Wanna Know/We Don't Talk Anymore | Sam Tsui / Alex Blue |
| 391 | We Don't Talk Anymore | We Don't Talk Anymore | Alex Blue TJ Brown |
| 392 | Will and Elizabeth | Pirates of the Caribbean: The Curse of the Black Pearl | Klaus Badelt |
| 393 | You Got Me | Breakthrough | Colbie Caillat |
| 394 | Where Is the Love | Best of Both Worlds | Josh Vietti |
| 395 | Love Story | Women's Day 2019 | Taylor Swift |
| 396 | I Do | I Do | Colbie Caillat |
| 397 | BLUE | Blue Neighbourhood (Deluxe) | Troye Sivan Alex Hope |
| 398 | A Little Story | My View | Valentin |
| 399 | ひとり上手（习惯孤独） | 大吟醸 | 中島みゆき |
| 400 | Memories | 마녀유희 OST | 金有京 |
| 401 | MELANCHOLY | MELANCHOLY | White Cherry |
| 402 | Sundial Dreams | In the Enchanted Garden | Kevin Kern |
| 403 | If | 마녀유희 OST | 全慧彬 |
| 404 | 相思赋予谁 | 春生 | 好妹妹 |
| 405 | 小河淌水-龚琳娜 | 小河淌水 | 龚琳娜 |
| 406 | 画离弦 (柯柯吉他版) | 画离弦 | 柯柯柯啊 |
| 407 | 筝锋 | 功夫 电影原声大碟 | 黄英华 |
| 408 | Thinking Out Loud | NOW That's What I Call Music! 90 | Ed Sheeran |
| 409 | Righteous Path | Introducing Mellow | Blazo |
| 410 | Somebody That I Used To Know | Making Mirrors | Gotye Kimbra |
| 411 | Hard to Sleep | This Is What It Feels Like | Gracie Abrams |
| 412 | Aloha Heja He | Melancholie und Sturmflut (Bonus Tracks Edition) | Achim Reichel |
| 413 | Palace Memories | Sound. Earth. Nature. Spirit. - Vol. Sound | S.E.N.S. |
| 414 | 回家(萨克斯风) | 金耳朵Ⅲ | Kenny G |
| 415 | Breath and Life | The Platinum Series III: Eterna | Audiomachine |
| 416 | East of Eden | East of Eden | Zella Day |
| 417 | Carpe Diem | Dead Poets Society | Maurice Jarre |
| 418 | 姑娘别哭泣-柯柯柯啊 | 姑娘别哭泣 | 柯柯柯啊 |
| 419 | Beautiful In White (Demo) | Beautiful In White (Demo) | Shane Filan |
| 420 | 萱草花-张小斐 | 你好，李焕英 电影原声大碟 | 张小斐 |
| 421 | Keating's Triumph | Dead Poets Society | Maurice Jarre |
| 422 | Better Man | Sing When You're Winning | Robbie Williams |
| 423 | Bridge of Faith(缘分一道桥)-王力宏、谭维维 | The Great Wall (Original Motion Picture Soundtrack) | 王力宏 / 谭维维 |
| 424 | Love Me Like You Do | Delirium | Ellie Goulding |
| 425 | Summer | ENCORE | 久石譲 |
| 426 | Viva La Vida | Viva La Vida Or Death And All His Friends | Coldplay |
| 427 | 诺言 (郭有才版) | 诺言（郭有才版） | 郭有才 |
| 428 | 爱向着我来的那天 사랑아 내게 오기만 해 (PartⅠ) | 마녀유희 OST | Ashily |
| 429 | You're Beautiful | So Beautiful 1 | James Blunt |
| 430 | 思念是一种病 | OK | 张震岳 / 蔡健雅 |
| 431 | Careless Whisper-George Michael | Ladies And Gentlemen... The Best Of George Michael | George Michael |
| 432 | 难却 (DJ细霖版|待上浓妆好戏开场) | 难却 | 平生不晚 |
| 433 | 月光-胡彦斌 | 音乐斌潮 | 胡彦斌 |
| 434 | Sunburst | Sunburst | Tobu / Itro |
| 435 | The Mass-Era | The Mass | Era |
| 436 | 精卫-30年前，50年后 | 丧失年轻，勿失年华 | 30年前，50年后 |
| 437 | Farewell to Camraw | When the Pipers Play | Black Kilts Berlin /Robert Mathieson |
| 438 | 想太多 | 想太多 | 李玖哲 |
| 439 | Booty Music | Git Fresh | Deep Side |
| 440 | Genie | THE BEST ~New Edition~ | 少女时代 |
| 441 | Caravan-a_hisa | Single Collection | a_hisa |
| 442 | 樱花草 | 花言乔语 (精装版) | Sweety |
| 443 | Girlfriend | The Best Damn Thing: Deluxe Edition | Avril Lavigne |
| 444 | 道山靓仔-五条人 | 县城记 | 五条人 |
| 445 | 精卫-一颗狼星_许篮心 | 精卫（戏腔） | 一颗狼星_许篮心 |
| 446 | Remember The Name | Sampler Mixtape | Fort Minor |
| 447 | Right Here Waiting (Piano) | Right Here Waiting (Piano) | Basil Jose /Richard Marx |
| 448 | The Long Way Home | The Bright Side | Lenka |
| 449 | 单车恋人 | 9公主 | 后弦 |
| 450 | 愤怒的消失 그게 말이죠 | 마녀유희 OST | 木单车 |
| 451 | 西厢 | 古·玩 | 后弦 |
| 452 | Bye Bye Bye | Rising Love | Lovestoned |
| 453 | Star of the County Down | Musique Celtic | Rosheen |
| 454 | 一格格-卫兰 | 一格格 | 卫兰 |
| 455 | Main Title (The Godfather Waltz) | The Godfather I | Nino Rota |
| 456 | 命运的恶作剧 운명의 장난 | 마녀유희 OST | MC 真理 / 哈哈 |
| 457 | Far Away From Home | Greatest Hits | Groove Coverage |
| 458 | Damn You | The Unreleased Collection | Lana Del Rey |
| 459 | The Happy Troll (Griefing Theme Song)-D1ofaquavibe | The Happy Troll (Griefing Theme Song) | D1ofaquavibe |
| 460 | 乌兰巴托之夜-谭维维 | 高原之心 | 谭维维 |
| 461 | Love Yourself (Natio Remix) | Love Yourself (Natio Remix) | Natio / Justin Bieber / Conor Maynard |
| 462 | Red River Valley | Journey Home | Bronn Journey |
| 463 | 去年夏天 | 去年夏天 | 王大毛 |
| 464 | My Happy Ending | Under My Skin (Special Edition) | Avril Lavigne |
| 465 | 友谊之光 | 监狱风云 | 玛莉亚 |
| 466 | The Moon Represents My Heart | Love Ballads | Kenny G |
| 467 | Auld Lang Syne | The Greatest Gift | Charlie Landsborough |
| 468 | 口弦 | 听见凉山 电视剧原声带 | 赵艺涵 |
| 469 | 奇异恩典 | 最新热歌慢摇73 | Various Artists |
| 470 | 吻别-张学友 | 吻别 | 张学友 |
| 471 | Flower Dance | A Cup Of Coffee | DJ Okawari |
| 472 | Come And Get It | Chartsurfer Vol. 30 | Selena Gomez |
| 473 | Heartbeats | Swings and Roundabouts | Amy Deasismont |
| 474 | Hero | Hero | Enrique Iglesias |
| 475 | 风中有朵雨做的云-孟庭苇 | 风中有朵雨做的云 | 孟庭苇 |
| 476 | I Just Wanna Run | Take Action! Volume 9 | The Downtown Fiction |
| 477 | Payphone-Boyce Avenue | Cover Sessions, Vol. 2 | Boyce Avenue |
| 478 | 莫失莫忘 | 仙剑奇侠传 电视原创配乐 | 麦振鸿 |
| 479 | I Want You to Know | I Want You to Know | Zedd / Selena Gomez |
| 480 | We Are Young | Dancing Bear Best Of 2012 International | Fun. Janelle Monáe |
| 481 | 罗刹海市-刀郎 | 山歌寥哉 | 刀郎 |
| 482 | The Day You Went Away | The Day You Went Away: The Best of M2M | M2M |
| 483 | Sleepyhead | Acoustic Daydreams | Galen Crew |
| 484 | Moon As My Heart | Harmonica Sound of Hong Kong | Robert Bonfiglio |
| 485 | Solstice-K-391 | Solstice | K-391 |
| 486 | 西海情歌-刀郎 | 刀郎Ⅲ | 刀郎 |
| 487 | 卡农D大调 | 胎教音乐 | 群星 |
| 488 | My Soul | Time... | July |
| 489 | Conquest of Paradise-Vangelis | 1492 - Conquest Of Paradise | Vangelis |
| 490 | 富士山下 | What's Going On…? | 陈奕迅 |
| 491 | New Soul | Irlande | Vox Angeli |
| 492 | 乌兰巴托的夜 (丹正母子版) | 乌兰巴托的夜 | 丹正母子 |
| 493 | 青丝-唐伯虎Annie | 青丝 | 唐伯虎Annie |
| 494 | If I Die Young | If I Die Young - Single | The Band Perry |
| 495 | The Godfather (Love Theme) | The Godfather I | Nino Rota |
| 496 | 原来你也在这里-周笔畅 | 原来你也在这里 | 周笔畅 |
| 497 | Hero's Theme-Steven Burke | Kameo: Elements of Power O.S.T | Steven Burke |
| 498 | My Love (Radio Edit) | Coast to Coast | Westlife |
| 499 | What Are Words | What Are Words | Chris Medina |
| 500 | 离别开出花-就是南方凯 | 离别开出花 | 就是南方凯 |
| 501 | Young For You | Young For You | GALA |
| 502 | The Ludlows | Legends Of The Fall Original Motion Picture Soundtrack | James Horner |
| 503 | 雪の華（雪之花）-中岛美嘉 | 雪の華 | 中島美嘉 |
| 504 | 让我欢喜让我忧-周华健 | 让我欢喜让我忧 | 周华健 |
| 505 | Pop Danthology 2012 | Pop Danthology | DJ Daniel Kim |
| 506 | 向云端-小霞&海洋Bo | 向云端 | 小霞 / 海洋Bo |
| 507 | 城南花已开 | 城南花已开 | 三亩地 |
| 508 | Paris | Paris | Else |
| 509 | Monsters (Live)-周深 | 歌手·当打之年 第5期 | 周深 |
| 510 | 颠倒歌-刀郎 | 山歌寥哉 | 刀郎 |
| 511 | 花心 | Keep Wakin 1987-2002 周而复始 | 周华健 |
| 512 | 呼唤 오나라 I | 대장금 OST | 김지현 |
| 513 | 爱向着我来的那天2 사랑아 내게 오기만 해 (Part II) | 마녀유희 OST | Ashily |
| 514 | 再见 | 再见 | 张震岳 |
| 515 | 千千阙歌 | 千千阙歌 | 陈慧娴 |
| 516 | Night Crusing(夜间巡航) (Inst.)-牛尾憲輔 | ピンポン OST | 牛尾憲輔 (agraph) |
| 517 | 萍聚 | 萍聚/珍重再见 | 李翊君 / 李富兴 |
| 518 | Kiss The Rain 비를 맞다 | The Best - Reminiscent 10th Anniversary | Yiruma |
| 519 | Runner | Runner | Dustin O'Halloran |
| 520 | This Is the Life | Weathered | Angie Miller |
| 521 | 从头再来 | 从头再来 | 刘欢 |
| 522 | Dead Poets Society (Finale) | Filmharmonic II | The Royal Philharmonic Orchestra Maurice Jarre |
| 523 | The sally gardens | Arias Ancora | Laure Green |
| 524 | Friendships-Pascal Letoublon | Friendships | Pascal Letoublon |
| 525 | 序曲：天地孤影任我行 | 东邪西毒(电影音乐) | 陈勋奇 |
| 526 | 送别 | 送别 | 韩红 |
| 527 | 安静 钢琴版 | 纯音乐流行歌曲钢琴版 | Paul Liu |
| 528 | Wrecking Ball | Wrecking Ball | Miley Cyrus |
| 529 | 是啊 그래 | 마녀유희 OST | 나창현 |
| 530 | Six Feet Under | Six Feet Under | Billie Eilish |
| 531 | 穿越时空的思念1 时代を超える想い1 | 映画“犬夜叉 时代を越える想い 音楽篇” | 和田薫 |
| 532 | 千千阙歌 (Live)-周深 | 聚划算55青春选择之夜晚会Live | 周深 |
| 533 | 偷功 | 太极张三丰 电影原声带 | 胡伟立 |
| 534 | Umbrella | Now That's What I Call Music! 25 Years | Rihanna / Jay-Z |
| 535 | Waka Waka (Esto Es África) | Waka Waka (This Time For Africa) (The Official 2010 Fifa World Cup Song) | Shakira |
| 536 | 假如爱有天意(电视剧《最食人间烟火色》插曲)-贺三 | 假如爱有天意 | 贺三 |
| 537 | In The End | In The End | Linkin Park |
| 538 | Monody | Monody | TheFatRat / Laura Brehm |
| 539 | The Show | The Show | Lenka |
| 540 | 野子 (Live) | 我是歌手第四季 第3期 | 苏运莹 |
| 541 | Gee | The First Mini Album Gee | 少女时代 (소녀시대) |
| 542 | Ship In The Sand | Dear Me, Look Up | Marble Sounds |
| 543 | Summertime Sadness | Summertime Sadness | Lana Del Rey |
| 544 | Trouble Is A Friend-Lenka | Trouble Is A Friend - The Remixes | Lenka |
| 545 | 慕情 (M-4) | 犬夜叉 音楽篇 | 和田薫 |
| 546 | 最浪漫的事-赵咏华&好妹妹 | 追梦人 | 赵咏华 / 好妹妹 |
| 547 | Honor (Main Title Theme from "The Pacific") | The Pacific (Music From the HBO Miniseries) | Hans Zimmer / Geoff Zanelli / Blake Neely |
| 548 | 花妖-刀郎 | 山歌寥哉 | 刀郎 |
| 549 | 兰亭序 (粤语版)-邓千荧 | 兰亭序 | 邓千荧 |
| 550 | Requiem For A Tower | Escala | Escala |
| 551 | 乌兰巴托的夜-左小祖咒 | 美国 The U.S.A（电影原声配乐） | 左小祖咒 |
| 552 | I Love You (Remix) | I Love You | United Idol |
| 553 | 你还要我怎样 | 意外 | 薛之谦 |
| 554 | 发现爱 | 西界 | 林俊杰 / 金莎 |
| 555 | 思念是一种病+爱人同志+爱如潮水+你现在还好吗(Live)-纵贯线 | Live in Taipei 出发/终点站 | 纵贯线 |
| 556 | 桥边姑娘 | 桥边姑娘 | 海伦 |
| 557 | 犯错 | 犯错 | 顾峰 / 斯琴高丽 |
| 558 | 那年初夏 | 毕业了我们一无所有 | 任然 |
| 559 | 北京欢迎你 | 北京2008年奥运会歌曲专辑 | 群星 |
| 560 | Red River Valley | Cowboy Songs | Michael Martin Murphey |
| 561 | 500 Miles | Buck The Trend | Peter, Paul & Mary |
| 562 | 500 Miles | Christ Is My Hope | The Innocence Mission |
| 563 | 500 Miles | Let's Folk | The Brothers Four |
| 564 | 画离弦 (柯柯版) | 画离弦 | 柯柯柯啊 |
| 565 | Ferrari-Jayvine Ramma | Ferrari | Jayvine Ramma |
| 566 | Annie's Wonderland 安妮的仙境 | Wonderland | Bandari |
| 567 | 阿凡达与屌丝男 | 心花路放 电影原声带 | 许鹤缤 |
| 568 | 花 ~すべての人に心の花を~ (オリジナル・ヴァージョン) | ザ・ニュー・ベスト・オブ・喜納昌吉＆チャンプルース | 喜納昌吉 (きな しょうきち) |
| 569 | Princesses Don't Cry-CARYS | Songs About Boys | CARYS |
| 570 | Skinny Love | Skinny Love | Birdy |
| 571 | 我的歌声里 | 我的歌声里 | 李代沫 |
| 572 | 情人 | 海阔天空 | Beyond |
| 573 | 给我一个吻-杨子姗 | 重返20岁 电影原声带 | 杨子姗 |
| 574 | 桔梗谣 | 노들강변 매화타령 민요 | 노들강변 매화타령 민요 |
| 575 | 为爱痴狂 | 《中国好声音》2012跨年演唱会 | 金志文 |
| 576 | Mariage d'amour | Lettre à ma Mère | Richard Clayderman |
| 577 | 我可以抱你吗 (Live)-孟根花 | 我可以抱你吗 | 孟根花 |
| 578 | 世界第一等 | 世界第一等 | 浪哥 |
| 579 | Unable To Stay, Unwilling To Leave | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 580 | 带我到山顶 | 听见凉山 | 赵艺涵 |
| 581 | Baby | Baby | Justin Bieber / Ludacris |
| 582 | 春娇与志明 | 春娇与志明 | 街道办GDC /欧阳耀莹 |
| 583 | Nevada | Monstercat - Best of 2016 | Vicetone / Cozi Zuehlsdorff |
| 584 | 听妈妈的话 | 依然范特西 | 周杰伦 |
| 585 | Jambalaya | 不朽的声音(人生最难忘的歌) | Carpenters |
| 586 | 红尘情歌 | 情路无悔 | 高安 /黑鸭子组合 |
| 587 | 莉莉安-宋冬野 | 安和桥北 | 宋冬野 |
| 588 | Prendre sa main | Cri d'amour | Angel Lover |
| 589 | 安静 | 范特西 | 周杰伦 |
| 590 | 梦中蝶影 | 歌曲合辑 | 华语群星 |
| 591 | 姑娘我爱你 | 姑娘我爱你 | 索朗扎西 |
| 592 | 借我 | 算云烟 | 谢春花 |
| 593 | Always With Me | 幸福的味道 | 木村弓 / 奥户巴寿 |
| 594 | 총맞은것처럼 (像中枪一样)-白智英 | Sensibility | 白智英 (백지영) |
| 595 | 兰亭序 | 魔杰座 | 周杰伦 |
| 596 | The Red Sun | 20 Years of Achievement around the World | Richard Clayderman |
| 597 | 快乐崇拜-潘玮柏、张韶涵 | Wu Ha | 潘玮柏 / 张韶涵 |
| 598 | 纯真年代 | 大小世界 | 爱朵女孩 |
| 599 | Vincent | Legendary Don McLean | Don McLean |
| 600 | 平凡之路 | 猎户星座 | 朴树 |
| 601 | 李白 | 模特 | 李荣浩 |
| 602 | You | YOU | Approaching Nirvana |
| 603 | Coming Home | Coming Home | Skylar Grey / Diddy-Dirty Money |
| 604 | Turnin' | Young Rising Sons | Young Rising Sons |
| 605 | 意外 | 意外 | 薛之谦 |
| 606 | Promise | Promise | sapientdream |
| 607 | 那些年 | 那些年，我们一起追的女孩 电影原声带 | 胡夏 |
| 608 | 有一种爱叫做放手 | 有一种爱叫做放手 | 阿木 |
| 609 | 童年 | 童年 | 北京天使合唱团 |
| 610 | Still D.R.E (Instrumental Version)-Dr. Dre Snoop Dogg | Still D.R.E. | Dr. Dre / Snoop Dogg |
| 611 | 赤伶(DJ版) | 赤伶 | DJ名龙 |
| 612 | 我最亲爱的 | 我的歌声里 | 李代沫 |
| 613 | April 四月之春 | Sunrise Hill | Bandari |
| 614 | Fight | Fight | BeatBrothers |
| 615 | 我希望 | 匆匆那年 电视原声带 | 杨玏 |
| 616 | 笑傲江湖曲(琴箫合奏)-胡伟立 | 武侠音乐系列之疗伤神法 | 胡伟立 |
| 617 | 恋曲1990-高胜美 | 经典金选1 哭砂 | 高胜美 |
| 618 | 知道不知道 | Rene | 刘若英 |
| 619 | Jiazhen Leaves Fughi-Zhao Jiping | Lifetimes (Vivre!) [Original Motion Picture Soundtrack] | Zhao Jiping |
| 620 | 花-喜納昌吉 | The Celebrations | 喜納昌吉 / チャンプルーズ |
| 621 | Don't Worry Be Happy | Pretty Donkey Girl | Holly Dolly |
| 622 | Say Hello | These Friends Of Mine | Rosie Thomas / Sufjan Stevens |
| 623 | 海阔天空-G.E.M.邓紫棋 | T.I.M.E. | G.E.M.邓紫棋 |
| 624 | 我记得 | 署前街少年 | 赵雷 |
| 625 | The Right Path | Age of Innocence (Original Soundtrack) | Thomas Greenberg |
| 626 | 相思 | 腔.调 | 毛阿敏 |
| 627 | 云宫迅音-许镜清 | 西游记 电视剧配乐原声 | 许镜清 |
| 628 | Seven Lonely Days | Remember When? - 25 Golden Memories | Georgia Gibbs |
| 629 | 相对 | 子曰 第一册 | 子曰乐队 |
| 630 | Sally Gardens | Spring | The O'Neill Brothers |
| 631 | 2 Phút Hơn (KAIZ Remix) | 2 Phút Hơn (KAIZ Remix) | Pháo / KAIZ |
| 632 | 你的酒馆对我打了烊-陈雪凝 | 你的酒馆对我打了烊 | 陈雪凝 |
| 633 | Valder Fields | A Plea en Vendredi | Tamas Wells |
| 634 | 诺言(中视八点档《孽海花》片头曲)-李翊君 | 诺言 | 李翊君 |
| 635 | 刚好遇见你 | 刚好遇见你 | 李玉刚 |
| 636 | Way Back then | 오징어게임 OST | 郑在日 (정재일) |
| 637 | 爱要坦荡荡-萧潇 | Beautiful Angel | 萧潇 |
| 638 | 你的答案-阿冗 | 你的答案 | 阿冗 |
| 639 | 桃花诺(电视剧《上古情歌》片尾曲)-G.E.M.邓紫棋 | 上古情歌 电视剧原声带 | G.E.M.邓紫棋 |
| 640 | Luv Letter | 髙橋大輔～フェイヴァリット・ミュージック～ | 神津裕之 |
| 641 | 海阔天空 | 一声所爱 大地飞歌（第九期） | 汪小敏 |
| 642 | 半妖-和田薫 | TVアニメーション「犬夜叉」オリジナルサウンドトラックアルバム「犬夜叉 音楽篇」 | 和田薫 |
| 643 | 男と女（男和女） | Standing Ovation | CHAGE and ASKA |
| 644 | 万水千山总是情 | 万水千山总是情 电视剧原声带 | 汪明荃 |
| 645 | 希望 | Grace & Charm | 陈慧琳 |
| 646 | Anak (remix: Freddie Aguilar|Remix) | 清尘 | 清尘 |
| 647 | Liability | Melodrama | Lorde |
| 648 | Never Say Good Bye | 마이걸 | Mario & Nesty (마리오&네스티) |
| 649 | 城府 | 自定义 | 许嵩 |
| 650 | Rompasso-Angetenar（DEITIES remix）-DEITIES Ghetto Artist | Angetenar (DEITIES Remix) | DEITIES / Ghetto Artist |
| 651 | All Falls Down | All Falls Down | Alan Walker / Noah Cyrus / Digital Farm Animals / Juliander |
| 652 | 梦中的婚礼 | Richard Clayderman | Richard Clayderman |
| 653 | Ferrari-Bebe Rexha | Expectations | Bebe Rexha |
| 654 | Faded | Faded | Alan Walker / Iselin Solheim |
| 655 | 被遗忘的时光-蔡琴 | 出塞曲 | 蔡琴 |
| 656 | Take It From Me | Say I Am You | The Weepies / Deb Talan / Steve Tannen |
| 657 | 鼓楼 | 无法长大 | 赵雷 |
| 658 | You Belong To Me | To You | Carla Bruni |
| 659 | 发如雪 | 十一月的萧邦 | 周杰伦 |
| 660 | Windy Hill（风之谷） | Windy Hill | 羽肿 |
| 661 | Bloom of Youth | クドわふたー オリジナル サウンドトラック | 清水淳一 |
| 662 | Your Man | Double Cream 5: 20 Years of Nashville #1's 1992-2012 | Josh Turner |
| 663 | 天地龙鳞(大型纪录片《紫禁城》主题歌)-王力宏 | 大型纪录片《紫禁城》主题歌音乐专辑 | 王力宏 |
| 664 | 鸿雁-额尔古纳乐队 | 往日时光 | 额尔古纳乐队 |
| 665 | 热爱105°C的你 | 热爱105°C的你 | 腾格尔 / 艾伦 / 沈腾 |
| 666 | Eventide | Eventide | Nylon |
| 667 | Because of You | Because Of You | Kelly Clarkson |
| 668 | 等爱的玫瑰-凤凰传奇 | 吉祥如意 | 凤凰传奇 |
| 669 | Demons | Continued Silence EP | Imagine Dragons |
| 670 | Take Me To Church | Bravo Hits 86 | Hozier |
| 671 | Just One Last Dance (Album Version) | Key To My Soul | Sarah Connor /Marc Terenzi |
| 672 | Love The Way You Lie (Part III (Original Demo)) | Relaxing Acoustic | Skylar Grey |
| 673 | 老男孩 | 父亲 | 筷子兄弟 |
| 674 | 我是一只小小鸟 | 我是一只小小鸟 | 赵传 |
| 675 | 独家记忆 | 独家记忆 (Hong Kong Version) | 陈小春 |
| 676 | Be What You Wanna Be | Darin | Darin |
| 677 | 好久不见 | 认了吧 | 陈奕迅 |
| 678 | A Place Called You | Enchanted | Emma Stevens |
| 679 | Young And Beautiful | Triple J Hottest 100 Vol 21 | Lana Del Rey |
| 680 | 长路漫漫任我闯 | 林子祥精选之天长地久 | 林子祥 |
| 681 | Frail Love | Frail Love | Cloves |
| 682 | Scarborough Fair | The Very Best of Sarah Brightman 1990-2000 | Sarah Brightman |
| 683 | 从头再来 | 经典20年 珍藏锦集 | 刘欢 |
| 684 | 浮夸 | U-87 | 陈奕迅 |
| 685 | Asphyxia 窒息 | asphyxia | 逆时针向 |
| 686 | The Ocean (Radio Edit) | The Ocean | Mike Perry / SHY Martin |
| 687 | 乌兰巴托的夜-葱香科学家（王悠然） | 乌兰巴托的夜 | 葱香科学家（王悠然） |
| 688 | 听 | 拾 | 张杰 |
| 689 | Lonely | Nana | Nana |
| 690 | Unity | Sounds of Syndication, Vol .1 (Presented by Syndicate) | TheFatRat |
| 691 | Hey, Soul Sister | Save Me, San Francisco | Train |
| 692 | Waltz No.6 'Petit Chien' in D Flat Major Op.40-1 | 越听越聪明 1 | Classical Artists |
| 693 | Elsinore Revisited(重访埃尔西诺) | Rosencrantz & Guildenstern are Undead | Sean Lennon |
| 694 | Too Far | King in the Mirror | Anna F |
| 695 | Inspire | Serenity | Capo Productions |
| 696 | 让我偷偷看你 | 阿弥陀佛么么哒·一个孩子的心愿 | 赵雷 |
| 697 | やわらかな光(柔和之光)-やまだ豊 | フジテレビ系ドラマ「僕のいた時間」オリジナルサウンドトラック - (日剧《我存在的时间》原声带) | やまだ豊 |
| 698 | 夜的钢琴曲五 | 夜的钢琴曲 Demo集 | 石进 |
| 699 | Sutter's Mill | The Music of Dan Fogelberg | Dan Fogelberg |
| 700 | Please Don't Go | Please Don't Go | Joel Adams |
| 701 | 曾经的你 | 每一刻都是崭新的 | 许巍 |
| 702 | Don't Let Me Fall-Lenka | Lenka (Expanded Edition) | Lenka |
| 703 | Stay Here Forever | Valentine's Day OST | Jewel |
| 704 | 存在 | 生无所求 | 汪峰 |
| 705 | Stay Alive | The Secret Life Of Walter Mitty (Music From And Inspired By The Motion Picture) | José González |
| 706 | 我就喜欢你这样的丫头 | 匆匆那年 电视原声带 | 杜维瀚 |
| 707 | Everybody | Everybody | Ingrid Michaelson |
| 708 | 传奇 | 传奇 | 王菲 |
| 709 | 易燃易爆炸 | 如也 | 陈粒 |
| 710 | 飞向别人的床 | 飞向别人的床 | 沉珂（C.K）& 光光 |
| 711 | 赤伶 (弹唱版) | 赤伶 | 孙鹏凯 |
| 712 | Astronomia（黑人抬棺古风版） | 黑人抬棺古风版 | litterzy、水玥儿 |
| 713 | I Want My Tears Back | Imaginaerum | Nightwish |
| 714 | 红颜 | MuSiC混合体 | 胡彦斌 |
| 715 | 혼자시킨 사랑 独自的爱情 | 명랑소녀 성공기 OST | True Bird |
| 716 | 潮湿的心 | 蜕变1少女的心情故事 | 卓依婷 |
| 717 | brave heart | brave heart | 宮崎歩 |
| 718 | 明天过后 | 明天过后 | 张杰 |
| 719 | Love Theme | 명랑소녀 성공기 OST | 吴振宇 |
| 720 | Read My Mind | Jade | Sweetbox |
| 721 | 千里之外-周杰伦、费玉清 | 依然范特西 | 周杰伦/费玉清 |
| 722 | Let It Out | Let It Out | Frances |
| 723 | Love Song | 명랑소녀 성공기 OST | 赵长赫 |
| 724 | 芒种(梦幻西游普陀山门派曲)-腾格尔 | 芒种 | 腾格尔 |
| 725 | 飞得更高 | 笑着哭 | 汪峰 |
| 726 | 花火 | 花火 | 汪峰 |
| 727 | 直到永远 | 生死不离 我们在一起 | 汪峰 |
| 728 | 跟往事干杯 | 不朽金曲精选 Ⅰ | 姜育恒 |
| 729 | 蓝莲花 | 时光.漫步 | 许巍 |
| 730 | 娃娃脸 | 娃娃脸 | 后弦 |
| 731 | 我爱你中国 | 怒放的生命 | 汪峰 |
| 732 | 星象仪 プラネタリウム | プラネタリウム | 大塚爱 |
| 733 | 推理(オリジナル・ヴァージョン)-大野克夫 | 「名探偵コナン」サントラ・スーパー・ベスト- (名侦探柯南) | 大野克夫 |
| 734 | 一直很安静 | 寂寞在唱歌 | 阿桑 |
| 735 | 生活不止眼前的苟且 | 生活不止眼前的苟且 | 许巍 |
| 736 | Mark's Theme-顾嘉辉 | 英雄本色1&2 | 顾嘉辉 |
| 737 | Tears Of A Clown | Mastercutor | U.D.O. |
| 738 | 運命のルーレット廻して (转动命运之轮) | 運命のルーレット廻して | ZARD (ザード) |
| 739 | The Dawn-Dreamtale | Beyond Reality (Japanese Edition) | Dreamtale |
| 740 | 兰亭序 (粤语版) (Single Version) | 兰亭序 | 王十三 |
| 741 | For Free | Folk For Kids | Lana Del Rey / Zella Day / Weyes Blood |
| 742 | My Destiny (我的命运) | 별에서 온 그대 OST Part 1 | LYn (린) |
| 743 | 亲爱的路人 | 亲爱的路人 | 刘若英 |
| 744 | 等不到的爱 | 裸婚时代 电视剧原声带 | 文章 |
| 745 | Call Me Maybe | Call Me Maybe | Carly Rae Jepsen |
| 746 | 花开在眼前 | 花开在眼前 | 韩磊 |
| 747 | 如果不能好好爱 | 如果不能好好爱 | 吴克群 |
| 748 | 童年 | 纵贯线演唱会 | 罗大佑、李宗盛、张震岳、周华健 |
| 749 | 魔訶不思議アドベンチャー! | ドラゴンボール全曲集 | 高橋洋樹 |
| 750 | 我是一只小小鸟-任贤齐&李宗盛 | 台湾男儿任贤齐认真精选辑 | 任贤齐 / 李宗盛 |
| 751 | 白羊座的忧伤-石进 | 夜的钢琴曲Ⅱ | 石进 |
| 752 | One Night In 北京 | SHIN 同名专辑 | 信乐团 |
| 753 | The Monster | The Monster | Eminem / Rihanna |
| 754 | 1%-Oscar Scheller、Lily Allen | 1% | Oscar Scheller / Lily Allen |
| 755 | Groundhog Day | Groundhog Day | Em Beihold |
| 756 | 我期待-张雨生 | 卡拉OK.台北.我 | 张雨生 |
| 757 | Amazing Grace 天赐恩宠 | 苏格兰音乐之旅 苏格兰风笛 | 群星 |
| 758 | 兰亭序【笛子版】-亿只张勤洗 | 兰亭序 | 亿只张勤洗 |
| 759 | 小仙女 | 武侠音乐系列之缠绵悱恻 （截取版） | 麦振鸿 |
| 760 | Élan | Élan | Nightwish |
| 761 | 爱你在心口难开-高胜美 | 怀念老歌七 | 高胜美 |
| 762 | Fengxia Leaves Her Parents-Zhao Jiping | Lifetimes (Vivre!) [Original Motion Picture Soundtrack] | Zhao Jiping |
| 763 | The Hampster Dance Song-Hampton the Hampster | The Hamsterdance Album | Hampton the Hampster |
| 764 | Dans la maison (Thème)-Philippe Rombi | Dans la maison | Philippe Rombi |
| 765 | 一千年以后(A Thousand Years Later)-林俊杰 | 编号89757 | 林俊杰 |
| 766 | 「名探偵コナン」~メインテーマ-大野克夫 | 「名探偵コナン」メインテーマ | 大野克夫 |
| 767 | 万里の長城-太田美知彦 | 中華一番! スペシャルTVオンエアーミックス& ― オリジナル・サウンドトラック | 太田美知彦 |
| 768 | 喜剧之王 | 喜剧之王 | 李荣浩 |
| 769 | Tennessee-Hans Zimmer | Pearl Harbor [O.S.T] | Hans Zimmer |
| 770 | 浮沉的兄弟-戎祥 | 浮沉的兄弟 | 戎祥 |
| 771 | 幸せ（幸福）-小林幸子 | 小林幸子全曲集 2013 | 小林幸子 |
| 772 | Liekkas | Assogattis: By The Embers | Sofia Jannok |
| 773 | 郎的诱惑-凤凰传奇 | 最炫民族风 | 凤凰传奇 |
| 774 | 我真的受伤了-张学友 | 学友 热 | 张学友 |
| 775 | 我想和你一起去海边-江惠莲 | 伍六七 原声大碟 | 江惠莲 |
| 776 | For the World-谭盾 | Late Night Tales: Air | 谭盾 |
| 777 | Scotland the Brave 苏格兰勇士 | 苏格兰音乐之旅 苏格兰风笛 | 群星 |
| 778 | 月牙湾 | 爱.歌姬 | F.I.R. |
| 779 | Gangsta Bop | Konvicted | Akon |
| 780 | Hallelujah | Warmer In The Winter (Deluxe Edition) | Lindsey Stirling |
| 781 | Nijamena (BGM版) | Nijamena | H2s |
| 782 | 二泉映月 | 阿炳全集 | 阿炳 |
| 783 | 男儿当自强 | 笑傲歌坛 传世经典 | 林子祥 |
| 784 | 上海滩 | 上海滩 | 叶丽仪 |
| 785 | 我和你 | 北京2008 奥运会、残奥会开闭幕式主题歌曲专辑 | 刘欢 / Sarah Brightman |
| 786 | 算你狠 | 绝对收藏 | 陈小春 |
| 787 | 黄种人 | 黄·锋 | 谢霆锋 |
| 788 | Croatian Rhapsody | The Piano Player | Maksim Mrvica |
| 789 | He's a Pirate | Pirates of the Caribbean: The Curse of the Black Pearl | Klaus Badelt |
| 790 | Natural-Imagine Dragons | Origins (Deluxe) | Imagine Dragons |
| 791 | 星月神话 | 女人又一次哭泣 | 金莎 |
| 792 | 夜上海 | 夜上海精选 | 周璇 |
| 793 | 带你去旅行 | 带你去旅行 | 校长（张驰） |
| 794 | 天下第一 | 武侠音乐系列之豪气中天 （截取版） | 麦振鸿 / 罗坚 |
| 795 | 没有你的日子我真的好孤单-韩晶 | 不要用我的爱来伤害我 | 韩晶 |
| 796 | 给我一个吻-张露 | 群星会 38 张露 (珍藏系列) | 张露 |
| 797 | '97爱情宣言 | 狼 97黄金自选辑 | 齐秦 |
| 798 | 外面的世界 | 燃烧爱情（狼之旅） | 齐秦 |
| 799 | 小酒窝 | JJ陆 | 林俊杰 / 蔡卓妍 |
| 800 | Past Lives | Drowning | Slushii |
| 801 | 往事随风 | 痛并快乐着 | 齐秦 |
| 802 | Go Time | Go Time | Mark Petrie |
| 803 | Only Love(电视剧《妙手仁心 II》插曲)-Trademark | #Love | Trademark |
| 804 | 日不落-蔡依林 | 特务J - (Agent J) | 蔡依林 |
| 805 | 难念的经(1997年TVB版电视剧《天龙八部》片头曲)-周华健 | 电视剧歌曲大全 | 周华健 |
| 806 | 李香兰-张学友 | Jacky Cheung 15 | 张学友 |
| 807 | Someone to Stay | Someone to Stay | Vancouver Sleep Clinic |
| 808 | The Portrait | Titanic: Special Edition | James Horner |
| 809 | 假如爱有天意-李健 | 李健 | 李健 |
| 810 | 那年我双手插兜 不知道什么叫做对手 | 那年我双手插兜 不知道什么叫做对手（语录版） | 黑左 / 莎馬淑鳐 / 刘liu创意人 |
| 811 | 你还欠我一个拥抱 | 很有爱 | 后弦 / Sara |
| 812 | Strength of a Thousand Men | Archangel | Two Steps From Hell |
| 813 | 匆匆那年 | 匆匆那年 电影原声带 | 王菲 |
| 814 | 麻雀-李荣浩 | 麻雀 | 李荣浩 |
| 815 | 一路 | 匆匆那年 电视原声带 | 白敬亭 / 杨玏 / 杜维瀚 |
| 816 | Spirit of the Wild | Age of Wonders | BrunuhVille |
| 817 | 命运 운명 | 풀 하우스 OST (KBS 미니시리즈) | Why |
| 818 | 青い空に出逢えた(TV Mix) | 中華一番! スペシャルTVオンエアーミックス& ― オリジナル・サウンドトラック | 辻尾有紗 |
| 819 | 大海~ | Asia | THE JAYWALK |
| 820 | 热爱105°C的你 | 热爱105°C的你 | 阿肆 |
| 821 | Flavor Of Life | Flavor Of Life | 宇多田ヒカル |
| 822 | 我的未来不是梦-张雨生 | 6个朋友 | 张雨生 |
| 823 | Death Of Titanic | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 824 | Lordly (Instrumental Mix)-Feder | Lordly (Instrumental Mix) | Feder |
| 825 | 最浪漫的事-赵咏华 | 我的爱我的梦我的家 | 赵咏华 |
| 826 | 孤勇者_凤凰传奇 | 孤勇者 | 凤凰传奇 |
| 827 | 不如不见 | What's Going On…? | 陈奕迅 |
| 828 | Distant Memories | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 829 | 偏爱 | 破天荒 | 张芸京 |
| 830 | Diamonds | Diamonds | Rihanna |
| 831 | 風の住む街（风居住的街道）-磯村由紀子 | 風の住む街 | 磯村由紀子 |
| 832 | 还有我-任贤齐 | 如果没有你 | 任贤齐 |
| 833 | 绅士-薛之谦 | 绅士 | 薛之谦 |
| 834 | Je m'appelle Hélène | Hélène | Hélène Rolles |
| 835 | 我欲成仙 | 西游记后传片头曲 | 刘欢 |
| 836 | 希望 (国语) | 我是阳光的 | 陈慧琳 |
| 837 | Something Just Like This | Something Just Like This | The Chainsmokers / Coldplay |
| 838 | Children of the Dark | Together Till the End | Mono Inc. / Joachim Witt / Tilo Wolff / Chris Harms |
| 839 | 極楽浄土 | 約束 -Promise code- | GARNiDELiA |
| 840 | 作曲家 | 李荣浩 | 李荣浩 |
| 841 | 辞九门回忆(DJ版) | 未知 | 未知 |
| 842 | 诺言 (正式版)-海来阿木 | 诺言 (正式版) | 海来阿木 |
| 843 | Maga-Such a Whore（Maga remix）-Maga | Such a Whore | Maga |
| 844 | 闯将令-香港中乐团 于会咏 胡登跳 | 功夫 电影原声大碟 | 香港中乐团 / 于会咏 / 胡登跳 |
| 845 | 黑暗中的舞者 | 寂静的天空 | 黛青塔娜 / HAYA乐团 |
| 846 | 亲爱的旅人啊-周深 | 亲爱的旅人啊《千与千寻》（Cover 木村弓） | 周深 |
| 847 | 銀の龍の背に乗って | 銀の龍の背に乗って | 中島みゆき |
| 848 | She Is My Sin-Nightwish | Tales from the Elvenpath | Nightwish |
| 849 | To Ramona | The Complete Album Collection Vol.1 | Bob Dylan |
| 850 | Azul | Acoustik Guitar | John H. Clarke |
| 851 | 痴情冢（完整版）-吴严武 | 痴情冢（完整版） | 吴严武 |
| 852 | Opening | 少林足球 电影原声带 | 黄英华 |
| 853 | Feel Me-Selena Gomez | Feel Me | Selena Gomez |
| 854 | Hummell Gets The Rockets | The Rock (Original Motion Picture Score) | Nick Glennie-Smith /Harry Gregson-Williams |
| 855 | 星の下での邂逅-赵大鼾 | 星の下での邂逅 | 赵大鼾 |
| 856 | Impossible-Two Steps From Hell | Unleashed | Two Steps From Hell |
| 857 | Love From Me-Johnson Rodgie | Love From Me | Johnson Rodgie |
| 858 | 猜不透 | 我爱上的 | 丁当 |
| 859 | Samba-Ludovico Einaudi | I Giorni | Ludovico Einaudi |
| 860 | Håll Om Mig-Nanne Grönvall | Melodifestivalen 1958-2013 | Nanne Grönvall |
| 861 | 难却 | 难却 | 平生不晚 |
| 862 | 梦醒时分-杨钰莹 | 我有一段情 | 杨钰莹 |
| 863 | 王招君 (你看你拉住我的模样)(《寻汉计》电影推广曲)-任素汐 | 王招君 (你看你拉住我的模样) | 任素汐 |
| 864 | Old Threads-Deep East Music | Vintage Sunshine | Deep East Music |
| 865 | 萤火之森-CMJ | 萤火之森 | CMJ |
| 866 | 万疆-李玉刚 | 万疆 | 李玉刚 |
| 867 | Opening Credits-Hans Zimmer | Call of Duty: Modern Warfare 2 OST | Hans Zimmer |
| 868 | Samsara-Tungevaag & Raaban | Club Sounds Vol.73 | Tungevaag & Raaban |
| 869 | Dream-Priscilla Ahn | A Good Day | Priscilla Ahn |
| 870 | 今天你要嫁给我(Marry Me Today)-蔡依林、陶喆 | 太美丽 | 蔡依林 / 陶喆 |
| 871 | The X-Files (Original Version)-Mark Snow | The X Files? | Mark Snow |
| 872 | BOOM-Tiësto / Sevenn | BOOM | Tiësto / Sevenn |
| 873 | 初识太极 | 太极张三丰 电影原声带 | 胡伟立 |
| 874 | At Anchor | The Airship | Port Blue |
| 875 | 难却 (DJ版0.85x|待上浓妆好戏开场) | 难却 | 平生不晚 |
| 876 | 同桌的你(电影《同桌的你》片尾主题曲)-胡夏 | 同桌的你 | 胡夏 |
| 877 | 悬溺-葛东琪 | 第二街区 | 葛东琪 |
| 878 | 我要你(电影《驴得水》主题曲)-任素汐 | 我要你 | 任素汐 |
| 879 | Special Ops-Silver Screen | Under Siege | Silver Screen |
| 880 | Frontier-Doctor Vox | Level Up | Doctor Vox |
| 881 | Electric Romeo | Themes for Orchestra and Choir 2 - Abbey Road | Immediate Music |
| 882 | 賭神 | 赌神 电影原声 | 卢冠廷 |
| 883 | 下雨天-南拳妈妈 | 优の良曲 南搞小孩 | 南拳妈妈 |
| 884 | 姑娘别哭泣（弹唱版）-柯柯柯啊 | 姑娘别哭泣 | 柯柯柯啊 |
| 885 | 真心英雄 (Live)-纵贯线 | Live in Taipei 出发/终点站 | 纵贯线 |
| 886 | 秘密-卡洛儿 | 秘密 | 卡洛儿 |
| 887 | Time (Official)-MKJ | Time After Time | MKJ |
| 888 | 但愿人长久-邓丽君 | 但愿人长久 15周年纪念集 | 邓丽君 |
| 889 | The Next Episode | The Next Episode | Dr. Dre / Snoop Dogg / Kurupt / Nate Dogg |
| 890 | 你潇洒我漂亮-韩宝仪 | 台湾福建 畅销金曲沙龙镭射效果音乐 | 韩宝仪 |
| 891 | 驼铃-刀郎 | 披着羊皮的狼 | 刀郎 |
| 892 | 爱要坦荡荡 (Live)-丁丁 | 《中国好声音》2012跨年演唱会 | 丁丁 |
| 893 | Italia e voi（Orginal Mix）-HSHK | Italia e voi | HSHK / 贰皮 / VodKa / Pnan |
| 894 | かごめと犬夜叉 | TVアニメーション「犬夜叉」オリジナルサウンドトラックアルバム「犬夜叉 音楽篇」 | 和田薫 |
| 895 | 琵琶语-林海 | 林海影视配乐精选 | 林海 |
| 896 | 비오는 소리 (Intro)下雨的声音-July | To Heaven | July |
| 897 | 北国之春-邓丽君 | 邓丽君 纪念特别专辑 第二辑 | 邓丽君 |
| 898 | アシタカせっ記 (The Legend of Ashitaka)-久石让 | もののけ姫 イメージアルバム | 久石让 (ひさいし じょう) |
| 899 | Past Lives-Past Lives-Jasper、Martin Arteta | Past Lives | Jasper / Martin Arteta / 11:11 Music Group |
| 900 | K歌之王-陈奕迅 | 打得火热 | 陈奕迅 |
| 901 | Winter Without You-Gloria Kim | Winter Without You | Gloria Kim |
| 902 | 成全(电视剧《梦想成真》片头曲)-刘若英 | 年华 | 刘若英 |
| 903 | Run Me Out-Zola Jesus | How to Get Away with Murder | Zola Jesus |
| 904 | Pilgrimage-Jannik | Pilgrimage Epic Orchestral | Jannik |
| 905 | We No Speak Americano(UK Radio Edit)-Yolanda Be Cool | We No Speak Americano | Yolanda Be Cool |
| 906 | 荷塘月色-凤凰传奇 | 我从草原来 新歌+精选 | 凤凰传奇 |
| 907 | 芦苇荡(电影《大话西游》插曲)-赵季平 | 热门华语20 | 赵季平 |
| 908 | Deflagration-Silver Screen | Under Siege | Silver Screen |
| 909 | The Boys | 'The Boys' The 3rd Album | 少女时代 |
| 910 | 万物生 (国语)-萨顶顶 | 万物生 | 萨顶顶 |
| 911 | 我用什么把你留住-福禄寿FloruitShow | 我用什么把你留住 | 福禄寿FloruitShow |
| 912 | Wicked Wonderland (Radio Edit)-Martin Tungevaag | Wicked Wonderland | Martin Tungevaag |
| 913 | 幽默-胡伟立 | 九品芝麻官之白面包青天 电影原声 | 胡伟立 |
| 914 | 不将就(电影《何以笙箫默》片尾主题曲)-李荣浩 | 有理想 | 李荣浩 |
| 915 | Alone-Alan Walker | Alone | Alan Walker |
| 916 | Time Back-Bad Style | 最新热歌慢摇63 | Bad Style |
| 917 | Numb Encore | Look Out For Detox | Dr. Dre / 50 Cent / JAY-Z / Eminem / Linkin Park |
| 918 | Star Sky-Two Steps From Hell | Battlecry | Two Steps From Hell |
| 919 | Oceanside | Melody Lane | Lainey Lou |
| 920 | One Day In Spring | One Day In Spring | Bandari |
| 921 | Deadwood-Really Slow Motion | Deadwood | Really Slow Motion |
| 922 | Promises | Promises | Ryn Weaver |
| 923 | 我知道-By2 | Twins | By2 |
| 924 | Between Worlds | X I I | Roger Subirana |
| 925 | Dream It Possible | Dream It Possible | Delacey |
| 926 | 桔梗谣-金栄実 | 伽倻琴演奏《与你一起》 | 金栄実 |
| 927 | 桔梗谣-이금미 | Korea: Folk Songs I - Songs Of Kyonggido District | 이금미 |
| 928 | Simon Birch | The Bucket List (Original Motion Picture Soundtrack) | Marc Shaiman |
| 929 | Firework | Teenage Dream | Katy Perry |
| 930 | Everything at Once | Two | Lenka |
| 931 | 口弦-妙子 | 独家爱唱Ⅲ | 妙子 |
| 932 | Murder In My Mind-Kordhell | Murder In My Mind | Kordhell |
| 933 | 在你的身边 (0.8x)-慢热的气球 | 在你的身边 (0.8x) | 慢热的气球 |
| 934 | Once Upon a Time in America: Deborah's Theme-Ennio Morricone | The Grandmaster (Original Score) | Ennio Morricone |
| 935 | Morsmordre-Crazy Donkey | Morsmordre | Crazy Donkey |
| 936 | 旅行的意义(TRAVEL IS MEANINGFUL) | 渺渺 电影原声 | 陈绮贞 |
| 937 | 空 (TV Mix) | 中華一番! スペシャルTVオンエアーミックス& ― オリジナル・サウンドトラック | 大黒摩季 |
| 938 | 模特 | 模特 | 李荣浩 |
| 939 | FourFiveSeconds | FourFiveSeconds | Rihanna / Kanye West / Paul McCartney |
| 940 | Psycho, Pt. 2-Russ | Psycho, Pt. 2 | Russ |
| 941 | Anacreon-Bear McCreary | Foundation: Season 1 (Apple TV+ Original Series Soundtrack) | Bear McCreary |
| 942 | 风居住的街道（Piano ver） (翻自 磯村由紀子）-饭碗的彼岸 | Piano Cover | 饭碗的彼岸 |
| 943 | 爱转角 | Best Show | 罗志祥 |
| 944 | 我真的受伤了(电影《Delete爱人》插曲)-王菀之 | Audiophile Compilations | 王菀之 |
| 945 | Like That-Bea Miller | Chapter Two: Red | Bea Miller |
| 946 | Take Me Home Country Roads-John Denver | Take Me Home: The John Denver Story | John Denver |
| 947 | 江湖笑(张纪中版《神雕侠侣》片尾曲)-周华健 | 雨人 | 周华健 |
| 948 | Maps | Maps | Maroon 5 |
| 949 | One Match-Sarah Harmer | oh little fire | Sarah Harmer |
| 950 | 半生雪-七叔-叶泽浩 | 半生雪 | 七叔-叶泽浩 |
| 951 | MR.TAXI(Korean ver.) | 'The Boys' The 3rd Album | 少女时代 |
| 952 | Gentle-Isaac Shepard | Deep Joy | Isaac Shepard |
| 953 | 故人泪-麦小兜 | 故人泪 | 麦小兜 |
| 954 | May It Be-Bandari | MistyLand | Bandari |
| 955 | 秘密-王珺 | 一尘不染 | 王珺 |
| 956 | 赤伶-李玉刚 | 赤伶 | 李玉刚 |
| 957 | My Songs Know What You Did In The Dark (Light Em Up) (2 Chainz Remix) | My Songs Know What You Did In The Dark (Light Em Up) | Fall Out Boy |
| 958 | Emerald-Ariel | Elan | Ariel |
| 959 | River Flows In You | Tales Of Dusk And Dawn Chapter II | Various Artists |
| 960 | Roar | Roar | Katy Perry |
| 961 | 同桌的你-老狼 | 龙凤金歌榜 | 老狼 |
| 962 | Just Blue-Space | Just Blue | Space |
| 963 | Secrets AMFB Onerepublic | Time Machine (Part 1) | Bryson Andres |
| 964 | Sign-DEAMN | Sign | DEAMN |
| 965 | 当爱已成往事-张国荣 | 最红 | 张国荣 |
| 966 | Titanium-David Guetta / Sia | Best Of... | David Guetta / Sia |
| 967 | The Telephone Box | The Magic Empire | Uniform Motion |
| 968 | 在你的身边-盛哲 | 在你的身边 | 盛哲 |
| 969 | Why-Sabrina Carpenter | Why | Sabrina Carpenter |
| 970 | Sunrise | waiting for the light | Catie Mckinney |
| 971 | Walk on By-Noosa | Wonderland | Noosa |
| 972 | Shiver-skel | Shiver | skel |
| 973 | 映山红-刀郎 | 红色经典 | 刀郎 |
| 974 | Liberators-Epic Score | Vengeance - ES033 | Epic Score |
| 975 | Dismantle-Peter Sandberg | Dismantle | Peter Sandberg |
| 976 | 彩虹-周杰伦 | 我很忙 | 周杰伦 |
| 977 | Older-Sasha Alex Sloan | Older | Sasha Alex Sloan |
| 978 | Radius-Hi-Finesse | Axiom | Hi-Finesse |
| 979 | The Final Countdown | The Final Countdown: The Best Of Europe | Europe |
| 980 | 上海滩(无线电视剧《上海滩》主题曲) | 上海滩 | 叶丽仪 |
| 981 | Hyacinth-July | In Love | July |
| 982 | 遺憾-陈洁仪 | 重譯 陳潔儀.重奏 | 陈洁仪 |
| 983 | One More Light(又一道光芒)-Linkin Park | One More Light | Linkin Park |
| 984 | 敢问路在何方-刀郎 | 电视剧新西游记主题曲 | 刀郎 |
| 985 | 时を越えて かごめ | 犬夜叉 音楽撰集 | 和田薫 |
| 986 | 隐形的翅膀 (Live)-腾格尔 | 聚划算99划算盛典Live | 腾格尔 |
| 987 | The Party Troll-D1ofaquavibe | The Party Troll | D1ofaquavibe |
| 988 | 有形的翅膀-张韶涵 | 有形的翅膀 | 张韶涵 |
| 989 | Novera-Dark Winter Music | Epic World Volume2 Return 归来(2014) | Dark Winter Music |
| 990 | SCARSONG-flash8 | 最新热歌慢摇3 | flash8 |
| 991 | Concerto No. 4 in F minor, Op. 8, RV 297, "L'inverno" (Winter): II. Largo | The Four Seasons: The Vivaldi Album | Anne Akiko Meyers / English Chamber Orchestra / David Lockington |
| 992 | 光阴的故事(Live)-纵贯线 | Live in Taipei 出发/终点站 | 纵贯线 |
| 993 | Somewhere | Somewhere | July |
| 994 | If We Ever Broke Up-Mae Stephens | If We Ever Broke Up | Mae Stephens |
| 995 | Close Eyes (Slowed + Reverb)-DVRST | Close Eyes (Slowed + Reverb) | DVRST |
| 996 | 别再闹了(电影《来电狂响》暖冬主题曲)-毛不易 | 别再闹了 | 毛不易 |
| 997 | 月亮代表我的心-张国荣 | Miss You Much, Leslie | 张国荣 |
| 998 | Look4You-Alberto Ciccarini | Look4You | Alberto Ciccarini |
| 999 | 北国の春-木村好夫 | 木村好夫-ギター演歌名曲全集2 | 木村好夫 |
| 1000 | 不得不爱-潘玮柏、弦子 | 夏日撒糖情歌 | 潘玮柏 / 弦子 |
| 1001 | Future Funk-Varien | Pick Your Poison Vol. 01 | Varien |
| 1002 | Balenciaga-T3nzu | Balenciaga | T3nzu |
| 1003 | A Quiet Departure-Josh Leake | Benjamin | Josh Leake |
| 1004 | A Mozart Reincarnated-Ennio Morricone | La Leggenda del Pianista Sull'oceano | Ennio Morricone |
| 1005 | Best Moments (feat. Kondor)-Blazo | Alone Journey | Blazo |
| 1006 | 舞女泪-韩宝仪 | 怀念金曲 | 韩宝仪 |
| 1007 | Becoming a Legend-John Dreamer | Becoming a Legend - Single | John Dreamer |
| 1008 | 下一站天后(电影《下一站天后》主题曲)-Twins | 我们相爱6年(新曲+精选) | Twins |
| 1009 | Beloved-Dan Gibson | Native Harmony | Dan Gibson |
| 1010 | 明天会更好-群星 | 明天会更好 | 群星 |
| 1011 | 全是爱-凤凰传奇 | 最炫民族风 | 凤凰传奇 |
| 1012 | 我怀念的-孙燕姿 | 逆光 - (Against The Light) | 孙燕姿 |
| 1013 | Brotherhood-John Dreamer | Brotherhood | John Dreamer |
| 1014 | 昨夜星辰-高胜美 | 旧情绵绵(珍藏版3) | 高胜美 |
| 1015 | Hello Zepp-Charlie Clouser | Saw (Original Motion Picture Soundtrack) | Charlie Clouser |
| 1016 | 晚秋-毛宁 | 二十世纪原创经典典藏 龙凤金歌榜 | 毛宁 |
| 1017 | Mind Heist(电影《盗梦空间》预告片配乐) | Inception Trailer | Zack Hemsey |
| 1018 | RAVE-Dxrk ダーク | RAVE | Dxrk ダーク |
| 1019 | Golden Key-Isgaard | Golden Key [#2] | Isgaard |
| 1020 | Koko-Ariel | Koko | Ariel |
| 1021 | Anatomy | Anatomy | DJRUSTAM / FIZO FAOUEZ |
| 1022 | 新鸳鸯蝴蝶梦(电视剧《包青天》片尾曲)-黄安 | 新鸳鸯蝴蝶梦 | 黄安 |
| 1023 | 万物生 (梵语)-萨顶顶 | 万物生 | 萨顶顶 |
| 1024 | Eye of the Tiger-Survivor | Eye Of The Tiger | Survivor |
| 1025 | 甜蜜蜜(Sweet)-邓丽君 | 宝丽金经典中文金曲 | 邓丽君 |
| 1026 | 遗憾(新加坡电视剧《实况剧场》主题曲)-许美静 | 遗憾 | 许美静 |
| 1027 | Famous-Ivy Adara | Famous | Ivy Adara |
| 1028 | 耍猴儿(百鬼夜行) (唢呐版)-Harry来了 | 未知 | Harry来了 |
| 1029 | 无问(电影《无问西东》宣传曲)-毛不易 | 无问 | 毛不易 |
| 1030 | 1901-Birdy | Birdy (Deluxe Version) | Birdy |
| 1031 | 2002 (Acoustic)-Amber Leigh Irish | Unplugged Acoustic, Vol. 2 | Amber Leigh Irish |
| 1032 | 水星记-郭顶 | 飞行器的执行周期 | 郭顶 |
| 1033 | golden hour-JVKE | this is what ____ feels like (Vol. 1-4) | JVKE |
| 1034 | The Black Rose-Joanie Madden | Celtic Twilight 2 | Joanie Madden |
| 1035 | My Sunset (Original Mix)-Feint | Feint EP2 | Feint |
| 1036 | 雨空-α·Pav | Colors | α·Pav |
| 1037 | 白色风车-周杰伦 | 依然范特西 | 周杰伦 |
| 1038 | Tuesday-Burak Yeter Danelle | Dance 2017 - Armada Music | Burak Yeter / Danelle |
| 1039 | 红玫瑰-陈奕迅 | 认了吧 | 陈奕迅 |
| 1040 | Welcome to Jurassic World(电影《侏罗纪世界》配乐)-Michael Giacchino | Jurassic World (Original Motion Picture Soundtrack)- (侏罗纪世界) | Michael Giacchino |
| 1041 | PDD洪荒之力-Hoaprox | #Lov3 #Ngẫu Hứng | Hoaprox |
| 1042 | 告白之夜（纯音乐）-CMJ | 告白の夜 | CMJ |
| 1043 | 匆匆那年 (纯音乐)-梁翘柏 | 匆匆那年 电影原声带 | 梁翘柏 |
| 1044 | 兰亭序-吴紫涵 | 情动心弦 | 吴紫涵 |
| 1045 | 往事只能回味-韩宝仪 | 旧情绵绵 | 韩宝仪 |
| 1046 | Ghost Bride Prelude-Nate Connelly | 僵尸 电影原声大碟 | Nate Connelly |
| 1047 | You-Approaching Nirvana | Blocking the Sky Redux | Approaching Nirvana |
| 1048 | Whisper Of Hope (Main)-Gothic Storm | Epic Emotional Piano | Gothic Storm |
| 1049 | The Imperial March(帝国进行曲)-John Williams | Music from the Star Wars Saga- (星球大战) | John Williams |
| 1050 | Young Hearts-Dirk Reichardt | Kokowääh 2 (Original Motion Picture Soundtrack) | Dirk Reichardt |
| 1051 | James Bond Theme-John Barry Monty Norman | Dr. No (Original Motion Picture Soundtrack) | John Barry / Monty Norman |
| 1052 | 铁血丹心(1983年TVB版电视剧《射雕英雄传之铁血丹心》主题曲)-罗文、甄妮 | 射雕英雄传 | 罗文 / 甄妮 |
| 1053 | A Little Bit Broken-Spritely | A Little Bit Broken | Spritely |
| 1054 | メインテーマ「永遠の一瞬」（主题「永恒的一瞬」）-伊藤賢治 | この青空に約束をー~ようこそつぐみ寮へ~Piano Stories | 伊藤賢治 |
| 1055 | 潮鳴り-折戸伸治 | CLANNAD ORIGINAL SOUNDTRACK | 折戸伸治 |
| 1056 | The Pink Panther Theme-Henry Mancini | In the Pink | Henry Mancini |
| 1057 | 白いスーツのテーマ(白色西装主题曲)-市川淳 | TBS系 金曜ドラマ うぬぼれ刑事 オリジナル・サウンドトラック | 市川淳 |
| 1058 | 穿越时空的爱恋-CMJ | 穿越时空的爱恋 | CMJ |
| 1059 | 像我这样的人-毛不易 | 平凡的一天 | 毛不易 |
| 1060 | 北国の春(北国之春)-渥美二郎 | 全日傳 砂金之卷+鉑環之卷 | 渥美二郎 |
| 1061 | Dusk Till Dawn | Piano Acoustic Covers Vol 2 | Kurt Hugo Schneider / Kirsten Collins / Blake Rose |
| 1062 | Dreamland-Liquid Mind | Liquid Mind XI: Deep Sleep | Liquid Mind |
| 1063 | 月亮之上-凤凰传奇 | 月亮之上 | 凤凰传奇 |
| 1064 | 浮光 (The History)-Jannik | 浮光 (The History) | Jannik |
| 1065 | Criminals-F.O.O.L | Revenger | F.O.O.L |
| 1066 | P.I.M.P-TangTian | P.I.M.P | TangTian |
| 1067 | 射雕英雄传(电影《射雕英雄传之东成西就》片尾曲)-林穆 | 笑傲歌坛 传世经典 | 林穆 |
| 1068 | 赤伶-是二智呀 | 赤伶（民谣版） | 是二智呀 |
| 1069 | Halloween Theme - Main Title | Greatest Hits | John Carpenter |
| 1070 | 王进打高俅-赵季平 | 水浒传 原声音乐 | 赵季平 |
| 1071 | 平凡的一天-毛不易 | 平凡的一天 | 毛不易 |
| 1072 | 梦醒时分(电视剧《1989一念间》插曲)-陈淑桦 | 1989一念间 电视原声带 | 陈淑桦 |
| 1073 | 无名的人(电影《雄狮少年》主题曲)-毛不易 | 无名的人 | 毛不易 |
| 1074 | 流浪者之歌-Budapest Festival Orchestra 诹访内晶子 | 惠威试音专用Ⅱ | Budapest Festival Orchestra / 诹访内晶子 |
| 1075 | 恨爱交加-麦振鸿 | 天地传说之创世纪乐章 | 麦振鸿 |
| 1076 | 虞兮叹-闻人听書_ | 虞兮叹 | 闻人听書_ |
| 1077 | 淘汰-陈奕迅 | 认了吧 | 陈奕迅 |
| 1078 | 消愁-毛不易 | 平凡的一天 | 毛不易 |
| 1079 | 高山流水-王昌元 | 中国古筝名家名曲——中国民族器乐精品系列 | 王昌元 |
| 1080 | 美丽拍挡-胡伟立 | 国产凌凌漆 | 胡伟立 |
| 1081 | Polska-Sava | Aire | Sava |
| 1082 | Curtain-凌晨一点的莱茵猫 | Curtain falls | 凌晨一点的莱茵猫 |
| 1083 | 奢香夫人-凤凰传奇 | 最炫民族风 | 凤凰传奇 |
| 1084 | 金三角 (恐怖纯音乐) | 金三角（恐怖纯音乐） | R̶ᴇ̶ɢ̶ʀ̶ᴇ̶ᴛ̶. |
| 1085 | sans.-Toby Fox | UNDERTALE Soundtrack | Toby Fox |
| 1086 | 一荤一素-毛不易 | 平凡的一天 | 毛不易 |
| 1087 | 一程山路-毛不易 | 小王 | 毛不易 |
| 1088 | 夏夜-四季音色 | 春夏之交，轻旋淡律 | 四季音色 |
| 1089 | 人形の館-岩崎琢 | 黒執事 サウンドコンプリート BLACK BOX | 岩崎琢 |
| 1090 | Single Ladies (Put a Ring on It)-Beyoncé | Single Ladies (Put A Ring On It) - Dance Remixes | Beyoncé |
| 1091 | 十面埋伏(琵琶独奏)-群星 | 中国古典音乐历朝黄金年鉴 | 群星 |
| 1092 | 她的微笑 (original Mix)-阳山伟伟 | 她的微笑 (original Mix) | 阳山伟伟 |
| 1093 | Mystery of Love-Luke Pickman | Mystery of Love | Luke Pickman |
| 1094 | 西厢寻他-伯爵Johnny / 唐伯虎Annie | 西厢寻他 | 伯爵Johnny / 唐伯虎Annie |
| 1095 | 西楼别序-尹昔眠 / 小田音乐社 | 西楼别序 | 尹昔眠 / 小田音乐社 |
| 1096 | 青天-胡伟立 | 九品芝麻官之白面包青天 电影原声 | 胡伟立 |
| 1097 | 青空-Candy_Wind | 拂晓车站 | Candy_Wind |
| 1098 | 勇往直前-胡伟立 | 唐伯虎点秋香 | 胡伟立 |
| 1099 | 遗憾-李代沫 | 我的歌声里 | 李代沫 |
| 1100 | 执迷不悟-铁脑袋mp3 | 执迷不悟 | 铁脑袋mp3 |
| 1101 | 小心な侵入者-根岸貴幸 | カードキャプターさくら オリジナル・サウンドトラック4 | 根岸貴幸 |
| 1102 | 小鱼儿与花无缺片头音乐-麦振鸿 | 武侠音乐系列之豪气中天 （截取版） | 麦振鸿 |
| 1103 | 菊花台-周杰伦 | 依然范特西 | 周杰伦 |
| 1104 | 雨的舞步-赵大鼾 | 雨的舞步 | 赵大鼾 |
| 1105 | Lost Love (Instrumental)-Lunnna Janey杰尼 | Memories | Lunnna / Janey杰尼 |
| 1106 | 我从草原来-凤凰传奇 | 我从草原来 新歌+精选 | 凤凰传奇 |
| 1107 | 起风了(BILIBILI 11周年演讲)-周深 | 起风了 | 周深 |
| 1108 | Betrayal Voices | Horror/Sci-Fi #1 | Immediate Music |
| 1109 | Theme from Mission: Impossible-Danny Elfman | Mission Impossible [Original Score] | Danny Elfman |
| 1110 | 明月夜-张国荣 | 兜风心情 | 张国荣 |
| 1111 | 匆匆那年-周深 | 匆匆那年 | 周深 |
| 1112 | Trinity: Con la Stella Di Vicesceriffo-Franco Micalizzi | Lo Chiamavano Trinita (They Call Me Trinity) | Franco Micalizzi |
| 1113 | Dum Dum Dum-RENEE | Extending Playground | RENEE |
| 1114 | Theme From Jurassic Park (From "Jurassic Park" Soundtrack)-John Williams | Jurassic Park (Soundtrack) | John Williams |
| 1115 | 至少还有你-林忆莲 | 林忆莲's | 林忆莲 |
| 1116 | 再见(Live)-纵贯线 | Live in Taipei 出发/终点站 | 纵贯线 |
| 1117 | 不能说的秘密-周杰伦 | 不能说的秘密 电影原声带 | 周杰伦 |
| 1118 | 漂洋过海来看你-周深 | 漂洋过海来看你 | 周深 |
| 1119 | Luminous-贝奇Becky | Luminous | 贝奇Becky |
| 1120 | 不再犹豫-Twins | 青春重置计划之BEYOND 40 | Twins |
| 1121 | 最炫民族风-凤凰传奇 | 最炫民族风 | 凤凰传奇 |
| 1122 | 自由飞翔-凤凰传奇 | 吉祥如意 | 凤凰传奇 |
| 1123 | Octopus-ALan | Octopus | ALan |
| 1124 | 霍元甲-周杰伦 | 霍元甲 | 周杰伦 |
| 1125 | 迷迭香-周杰伦 | 依然范特西 | 周杰伦 |
| 1126 | 恋曲1980 (Live)-纵贯线 | Live in Taipei 出发/终点站 | 纵贯线 |
| 1127 | 光阴的故事-北京天使合唱团 | 光阴的故事 | 北京天使合唱团 |
| 1128 | 欢沁-林海 | 林海影视配乐精选 | 林海 |
| 1129 | No Glory | No Glory | Krale / M.I.M.E / Drama B / Skan |
| 1130 | 这，就是爱-张杰 | 这，就是爱 | 张杰 |
| 1131 | Criticalpoint-凌晨一点的莱茵猫 | Criticalpoint | 凌晨一点的莱茵猫 |
| 1132 | 夜曲-周杰伦 | 十一月的萧邦 | 周杰伦 |
| 1133 | 烟花易冷-周杰伦 | 跨时代 | 周杰伦 |
| 1134 | 恋曲1990(Live)-纵贯线 | Live in Taipei 出发/终点站 | 纵贯线 |
