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

#### 2.5.4 robots.txt 配置

![](doc/images/admin-sys-config-robots.png)

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
-e "MYSQL_DATABASE=open_music" \
-e "MYSQL_PORT=3306" \
-e "MYSQL_USER=root" \
-e "MYSQL_PASSWORD=root1234" \
-e "SYSTEM_INIT_PASSWORD=admin" \
woodwhales/woodwhales-music:latest
```

环境命令参数说明：

| 环境参数             | 说明                                                         | 默认值                  |
| -------------------- | ------------------------------------------------------------ |----------------------|
| MYSQL_HOST           | mysql 数据库服务的链接地址，默认值针对 windows、mac 系统生效，linux 系统需要用户强制指定宿主机 IP | host.docker.internal |
| MYSQL_DATABASE       | 数据库名称                                                   | open_music           |
| MYSQL_PORT           | mysql 数据库服务的端口号                                     | 3306                 |
| MYSQL_USER           | mysql 数据库服务的账号名称                                   | root                 |
| MYSQL_PASSWORD       | mysql 数据库服务的账号密码                                   | root1234             |
| SYSTEM_INIT_PASSWORD | woodwhales-music 系统的后台管理员 admin 账号登录密码，**生产环境请勿必自定义** | admin                |

## 5. 功能说明

### V3.7.9

- 增加 robots.txt 配置

### V3.7.8

- 登录失效页面跳转问题修复

### V3.7.7

- 页面底部UI样式更新
- 修复解析音乐图片下载按钮不重置问题

### V3.7.6

- 修复点击音乐播放未更新点击次数
- 页面底部UI样式更新
- 回到顶部UI样式更新

### V3.7.5

- 增加页面访问人次、歌曲点击人次
- 增加系统版本信息
- 重构后台页面底部信息

### V3.7.4

- 修复后台首页搜索问题
- 优化新增、编辑链接文本框（自适应文本高度）
- 后台增加友情链接配置

### V3.7.3

- 优化首页
- 修复依赖冲突导致的控制台日志打印问题

### V3.7.2

- 支持对音乐增加标签
- 2FA 验证文本样式优化

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

已收录 1723 首音乐

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
| 62 | 姑娘-陈楚生 | 快乐男声陈楚生歌曲 | 陈楚生 |
| 63 | 为爱痴狂_陈梦嘉 | THUG LIFE | 陈梦嘉 |
| 64 | 夜空中最亮的星 | 世界 | 逃跑计划 |
| 65 | Yellow | Best Of British | Coldplay |
| 66 | 一百万个可能 | 一百万个可能 | Christine Welch |
| 67 | 习惯了寂寞 | 习惯了寂寞 | 牛奶咖啡 |
| 68 | 我的歌声里 | Everything In The World (白金庆功版) | 曲婉婷 |
| 69 | 女人花 | 女人花 | 梅艳芳 |
| 70 | 一剪梅 | 花神 | 黄渤 / 左小祖咒 |
| 71 | A Life So Changed | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 72 | Here We Are Again (纯音乐) (《喜剧之王》电影插曲) | Here We Are Again (纯音乐) (《喜剧之王》电影插曲) | Cagnet (キャグネット) |
| 73 | 相思好比小蚂蚁 | 特别的日子 | 张蔷 |
| 74 | 阿珍爱上了阿强-五条人 | 梦幻丽莎发廊 | 五条人 |
| 75 | Almost Lover | Almost Lover | A Fine Frenzy |
| 76 | Down By The Salley Gardens | camomile | 藤田恵美 (ふじた えみ) |
| 77 | With An Orchid | If I Could Tell You | Yanni |
| 78 | 宝贝 (in a day) | Original | 张悬 |
| 79 | 这世界那么多人 | 这世界那么多人 | 莫文蔚 |
| 80 | 明天你是否依然爱我 | 其实你不懂我的心 | 童安格 |
| 81 | 爱如潮水 | 张信哲精选 | 张信哲 |
| 82 | 7 Years | The Young Pope (Original Series Sountrack) | Lukas Graham |
| 83 | The Sound of Silence (Reprise) | The Graduate | Simon & Garfunkel |
| 84 | BINGBIAN病变 (女声版) | BINGBIAN病变 (女声版) | 鞠文娴 |
| 85 | Don't You Remember | 21 | Adele |
| 86 | かごめと犬夜叉 (M-11+6) | 犬夜叉 音楽篇 | 和田薫 |
| 87 | 吉姆餐厅 | 吉姆餐厅 | 赵雷 |
| 88 | 很爱很爱你 | 很爱很爱你 | 刘若英 |
| 89 | 我们的时光 | 吉姆餐厅 | 赵雷 |
| 90 | Women of Ireland | Song of the Irish Whistle | Joanie Madden |
| 91 | Traveling Light | Traveling Light | Joel Hanson |
| 92 | 醉赤壁 | JJ陆 | 林俊杰 |
| 93 | 笑看风云 (Live) | 汪小敏 笑看风云 | 汪小敏 |
| 94 | 再度重相逢 | 泪桥 | 伍佰 & China Blue |
| 95 | The Way Of Life | 오! 필승 봉순영 OST | 吴硕浚 |
| 96 | 世界这么大还是遇见你 (清新的小女孩（中文版）) | 清新的小女孩（中文版） | 程响 |
| 97 | The Sounds Of Silence 寂静之音 | Silence With Sound From Nature | Bandari |
| 98 | 夏日漱石 (Summer Cozy Rock) | 浪潮上岸 (Tears In Ocean) | 橘子海 (Orange Ocean) |
| 99 | Chasing Pavements | Chasing Pavements | Adele |
| 100 | Right Here Waiting | Ballads | Richard Marx |
| 101 | 思念是一种病-齐秦 | 纪念日 | 齐秦 |
| 102 | ル一ジユ（口红）-中岛美雪 | 美雪集-原曲流行极品 | 中島みゆき |
| 103 | 成都 | 成都 | 赵雷 |
| 104 | Faidherbe square (instrumental) | Curses from past times | ProleteR |
| 105 | Easy Breeze | Something Simple | Thomas Greenberg |
| 106 | Spring In My Step | Spring In My Step | Silent Partner |
| 107 | Free Loop | Cf, Movie & Drama Hits 广告，开麦拉！ | Daniel Powter |
| 108 | 世界が終るまでは･･･ (直到世界尽头) | 世界が終るまでは･･･ | WANDS (ワンズ) |
| 109 | I Could Be The One | Acoustic | Donna Lewis |
| 110 | 不让我的眼泪陪我过夜 | 丝路 | 齐秦 |
| 111 | Unchained Melody | Ghost | Alex North |
| 112 | Let Her Go | All The Little Lights | Passenger |
| 113 | Jar Of Love | Everything In The World (白金庆功版) | 曲婉婷 |
| 114 | 菊花爆满山 | 菊花爆满山 | 马博 |
| 115 | John of the Glen | Song of the Irish Whistle 2 | Joanie Madden |
| 116 | Illusionary Daytime（幻昼）-Shirfine | Endless Daydream | Shirfine |
| 117 | 青丝 | 青丝（完整版） | 等什么君(邓寓君) |
| 118 | Marry You | Now Los Mejores Exitos Del Ano 2012 | Bruno Mars |
| 119 | Seve | Seve | Tez Cadey |
| 120 | 似水流年 | Salute | 张国荣 |
| 121 | Rolling In The Deep | Rolling In The Deep | Adele |
| 122 | 喜欢你 | Beyond 25th Anniversary | Beyond |
| 123 | 我只在乎你 | 我只在乎你 | 邓丽君 |
| 124 | Coachella - Woodstock In My Mind | Lust For Life | Lana Del Rey |
| 125 | 辞九门回忆 | 辞九门回忆 | 等什么君(邓寓君) |
| 126 | 海阔天空 | 乐与怒 | Beyond |
| 127 | 你把我灌醉-G.E.M.邓紫棋 | The Best of G.E.M. 2008 - 2012 (Deluxe Version) | G.E.M.邓紫棋 |
| 128 | 傲气傲笑万重浪 | 黄飞鸿系列电影原声精装版 | 黄霑 |
| 129 | 倩女幽魂 | Ultimate | 张国荣 |
| 130 | Angolan Women | Life In a Day (O.S.T) | The Three Angolan Women |
| 131 | 清明雨上 | 自定义 | 许嵩 |
| 132 | Last Dance (Live)-五条人 | 乐队的夏天2 第7期 | 五条人 |
| 133 | A Day In The Life (Remastered)-The Beatles | Sgt. Pepper's Lonely Hearts Club Band (Remastered) | The Beatles |
| 134 | That Girl | 24 HRS (Deluxe) | Olly Murs |
| 135 | Set Fire to the Rain | 21 | Adele |
| 136 | 小情歌 | 小宇宙 | 苏打绿 |
| 137 | 阳光总在风雨后 | 都是夜归人 | 许美静 |
| 138 | Day by Day | 마녀유희 OST | 赵冠宇 |
| 139 | The Sound of Silence (Album Version) | Forever Friends 'Just For You' | Simon & Garfunkel |
| 140 | Refrain | Eternal Light | 阿南亮子 (あなん りょうこ) |
| 141 | 盛夏的果实 | 莫后年代 莫文蔚20周年世纪典藏 | 莫文蔚 |
| 142 | 若把你 | 若把你 | Kirsty刘瑾睿 |
| 143 | Dark Paradise | Born To Die (Deluxe Version) | Lana Del Rey |
| 144 | Dirty Paws | Summer Acoustic | Of Monsters And Men |
| 145 | Miracle In The Middle Of My Heart (Original Mix) | Miracle In The Middle Of My Heart (Original Mix) | Clément Bcx |
| 146 | 老朋友 | 老朋友 | 杨尘,王旭(旭日阳刚) |
| 147 | Whistle | Glee: The Music - The Complete Season Four | Glee Cast |
| 148 | She | 7 Years and 50 Days | Groove Coverage |
| 149 | 十月：我和曾经的我们 | 迷藏 | 钟城 / 姚望 |
| 150 | Stronger | Kids Top 20 - De Grootste Hits Van 2013 - Summer Edition 2013 | Kelly Clarkson |
| 151 | A Penny At A Time | Life In A Day OST | Matthew Herbert |
| 152 | The Immigrant | Song of the Irish Whistle | Joanie Madden |
| 153 | 家族の风景 | 虹の歌集 | 手嶌葵 |
| 154 | 爱拼才会赢 | 爱拼才会赢 | 叶启田 |
| 155 | 我只在乎你-刘惜君 | 惜 . 君 | 刘惜君 |
| 156 | 单身情歌 | 单身情歌．超炫精选 | 林志炫 |
| 157 | 丑八怪 | 意外 | 薛之谦 |
| 158 | 沧海一声笑 | 沧海一声笑 | 许冠杰 |
| 159 | 桔梗谣 | 桔梗谣 | 阿里郎 |
| 160 | Intro | xx | The xx |
| 161 | Need You Now | iTunes Session | Lady A |
| 162 | 父亲 | 父亲 | 筷子兄弟 |
| 163 | 桔梗谣 | 织谣 | 斯琴格日乐 |
| 164 | 盗墓笔记·十年人间-李常超（Lao乾妈） | 盗墓笔记·十年人间 | 李常超（Lao乾妈） |
| 165 | 姑娘在远方 | 姑娘在远方 | 柯柯柯啊 |
| 166 | Crystal Ball-Lenka | Attune | Lenka |
| 167 | Anacreon-Bear McCreary | Foundation: Season 1 (Apple TV+ Original Series Soundtrack) | Bear McCreary |
| 168 | 湘江中路-庄达菲 | 湘江中路 | 庄达菲 |
| 169 | 夜空中最亮的星 | 世界 | 逃跑计划 |
| 170 | 般若波罗蜜多心经 | 《大唐玄奘》电影片尾曲 | 王菲 |
| 171 | 彩云之南 | 彩云之南 | 徐千雅 |
| 172 | 合肥的石头 | 赤脚青春 | 飘乐队 |
| 173 | 似夜流月 | 热门华语234 | 宗次郎 (そうじろう) |
| 174 | 北国之春 (日文版)-邓丽君 | 邓丽君15周年但愿人长久 | 邓丽君 |
| 175 | A Day in the Life-John Lennon | Imagine: John Lennon | John Lennon |
| 176 | Caribbean Blue 加勒比海蓝 | Moonlight Bay | Bandari |
| 177 | Five hundred miles | America, Vol. 10: Country - The Folk Revival Revolution | The Journeymen |
| 178 | Right Now (Na Na Na) | Right Now (Na Na Na) | Akon |
| 179 | Victory | Battlecry | Two Steps From Hell |
| 180 | 桔梗谣(道拉基) (朝鲜民谣) | 恋恋金达莱 | 蒋薇 |
| 181 | Down By the Salley Gardens | Song of the Irish Whistle | Joanie Madden |
| 182 | 李白的酒杜甫的愁-王一佳 | 李白的酒杜甫的愁 | 王一佳 |
| 183 | 追梦人 | 浮世情怀 | 凤飞飞 |
| 184 | 小鱼儿的思绪 | 武侠音乐系列第二部之思情篇（截取版） | 麦振鸿 |
| 185 | 故乡 | 我只有两天.许巍精选 | 许巍 |
| 186 | Bubbly | So Fresh - The Hits Of Autumn 2008 | Colbie Caillat |
| 187 | 勇敢的心 | 勇敢的心 | 汪峰 |
| 188 | 我很好 | I'm fine | 刘沁 |
| 189 | 江南 | 他是…JJ林俊杰 | 林俊杰 |
| 190 | 年少有为 | 耳朵 | 李荣浩 |
| 191 | Price Tag | Price Tag | Jessie J / B.o.B |
| 192 | The Sound of Silence_轻音乐 | The Best Pan Pipes in the World...Ever! | Panpipes |
| 193 | Eversleeping | Eversleeping | Xandria |
| 194 | Breaking My Heart | Unreleased | Lana Del Rey |
| 195 | Dying In the Sun | Bury the Hatchet | The Cranberries |
| 196 | See You Again | See You Again | See You Again |
| 197 | I Am You | I Am You | Kim Taylor |
| 198 | I'm Yours | I'm Yours | Jason Mraz |
| 199 | Innocence | The Best Damn Thing: Deluxe Edition | Avril Lavigne |
| 200 | 路口-张震岳 | OK | 张震岳 |
| 201 | 如果这都不算爱-张学友 | 学友 热 | 张学友 |
| 202 | 一生所爱 | 齐天周大圣之西游双记 电影歌乐游唱版 | 卢冠廷 / 莫文蔚 |
| 203 | 潇洒地走 | 潇洒地走 | 张蔷 |
| 204 | Apologize | Dreaming Out Loud (Tour Edition) | OneRepublic |
| 205 | Better Than One | The Score EP 2 | The Score |
| 206 | 停格 | 停格 | 蔡健雅 |
| 207 | When You're Gone | When You're Gone | Avril Lavigne |
| 208 | Astronomia | Astronomia | Vicetone / Tony Igy |
| 209 | 容易受伤的女人 | 阿菲正传 | 王菲 |
| 210 | River Flows In You | Kuschelklassik Piano Dreams, Vol. 2 | Martin Ermen |
| 211 | 倔强 | 神的孩子都在跳舞 | 五月天 |
| 212 | 牛仔很忙 | 我很忙 | 周杰伦 |
| 213 | 凄美地-郭顶 | 飞行器的执行周期 | 郭顶 |
| 214 | 面会菜-林生祥 | [大佛普拉斯] 电影配乐 | 林生祥 |
| 215 | 当爱在靠近 | Love & the City | 刘若英 |
| 216 | 日晷之梦 | 幸福时光 精选辑 | Kevin Kern |
| 217 | Last Reunion | Lament of Valkyrie (Epicmusicvn Series) | Peter Roe |
| 218 | 起风了 | 起风了 | 吴青峰 |
| 219 | Concerning Hobbits | The Lord of the Rings: The Fellowship of the Ring (Original Motion Picture Soundtrack) | Howard Shore |
| 220 | 叱咤红人 | 相依为命: 20年精彩印记 | 陈小春 |
| 221 | 天才白痴梦 | 天才与白痴 | 许冠杰 |
| 222 | 分手以后才知道最珍贵 | 回到家乡 | 胡力 |
| 223 | 往事只能回味 | 怀念老歌一 | 高胜美 |
| 224 | 原来你也在这里 | 我的失败与伟大 | 刘若英 |
| 225 | 我这家伙的答案是你 | AsuRa BalBalTa | Leessang / 河琳 |
| 226 | 往事只能回味 | 我是歌手第四季 第9期 | 金志文 |
| 227 | 勇敢的心 | 最新热歌慢摇88 | Various Artists |
| 228 | 等一分钟 | 滕爱Teng Love | 徐誉滕 |
| 229 | 我想大声告诉你 (《蜗居》电视剧片尾曲) | 我想大声告诉你 | 樊凡 |
| 230 | 光阴的故事 | 光阴的故事 | 黄晓明 邓超 佟大为 |
| 231 | 越长大越孤单 | 越长大越孤单 | 牛奶咖啡 |
| 232 | 你不知道的事-王力宏 | 十八般武艺 | 王力宏 |
| 233 | 2002年的第一场雪-刀郎 | 2002年的第一场雪 | 刀郎 |
| 234 | 往事只能回味 | 说时依旧 | 好妹妹 |
| 235 | 知足 | 知足 最真杰作选 | 五月天 |
| 236 | 红色高跟鞋-西柚 | 红色高跟鞋 | 西柚 |
| 237 | 一起摇摆 | 生来彷徨 | 汪峰 |
| 238 | 演员 | 绅士 | 薛之谦 |
| 239 | 南方姑娘 | 赵小雷 | 赵雷 |
| 240 | 我最亲爱的 | 你在看我吗 | 张惠妹 |
| 241 | 篇章-张韶涵 / 王赫野 | 篇章 | 张韶涵 / 王赫野 |
| 242 | 你的样子 | 罗大佑自选辑 | 罗大佑 |
| 243 | 문을 여시오 (New Ver.) 请开门 | 문을 여시오 | 任昌丁 / 金昌烈 |
| 244 | Cornfield Chase | Interstellar (Original Motion Picture Soundtrack) | Hans Zimmer |
| 245 | Riverside | Philharmonics (Deluxe Edition) | Agnes Obel |
| 246 | Gotta Have You | Say I Am You | The Weepies |
| 247 | Big Big World | Big Big World | Emilia |
| 248 | 认错 | 自定义 | 许嵩 |
| 249 | 在水一方 (Live)-李健 | 我是歌手第三季 第5期 | 李健 |
| 250 | My Heart Will Go On | Love Ballads | Kenny G |
| 251 | 月光下的凤尾竹 (葫芦丝) | 金耳朵.发烧民乐 | 纯音乐 |
| 252 | Love The Way You Lie | Life After Recovery | Eminem / Rihanna |
| 253 | 好汉歌 | 好汉歌 | 刘欢 |
| 254 | 布拉格广场 | 看我72变 | 蔡依林 / 周杰伦 |
| 255 | 粉红色的回忆 | 粉红色的回忆 | 韩宝仪 |
| 256 | 大敦煌-刀郎 | 谢谢你 | 刀郎 |
| 257 | Childhood Memory 童年 | Sunny Bay | Bandari |
| 258 | Dream Catcher 追梦人 | Relaxation - Dreams | Bandari |
| 259 | 小苹果 | 老男孩之猛龙过江 电影原声 | 筷子兄弟 |
| 260 | 穿越时空的思念 (DiESi Remix) | 穿越时空的思念 | DiESi |
| 261 | Hello | Hello | Adele |
| 262 | Chiru (Saisei No Uta) | Nostalgic | Robert de Boron |
| 263 | Southampton | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 264 | 雪见·落入凡尘 | 仙剑奇侠传三 电视剧原声带 | 麦振鸿 |
| 265 | 时间都去哪儿了 | 听得到的时间 | 王铮亮 |
| 266 | 土耳其进行曲 | 土耳其进行曲 | Various Artists |
| 267 | That's Not My Name | That's Not My Name | The Ting Tings |
| 268 | The Mountain of Women | Song of the Irish Whistle | Joanie Madden |
| 269 | Hymn To The Sea | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 270 | Don't push me | Jade - silver edition | sweetbox |
| 271 | Just Give Me A Reason | The Truth About Love | P!nk Nate Ruess |
| 272 | いつも何度でも | Prime Selection | 宗次郎 |
| 273 | 光年之外 | 光年之外 | G.E.M.邓紫棋 |
| 274 | 差生 | 少年中国 | 李宇春 |
| 275 | 人民不需要自由 | 108个关键词（李志的自我修养2012年度汇报演出） | 李志 |
| 276 | Nocturne No. 2 in E Flat Major, Op. 9, No. 2 | The Chopin Collection: The Nocturnes | Arthur Rubinstein |
| 277 | 青花瓷 | 我很忙 | 周杰伦 |
| 278 | Beyond The Memory | Beyond The Memory | July |
| 279 | 十年 | 黑白灰 | 陈奕迅 |
| 280 | All of Me-John Legend | Love In The Future | John Legend |
| 281 | 送别 | 送别 | 朴树 |
| 282 | 曹操 | 曹操 | 林俊杰 |
| 283 | 涛声依旧-毛宁 | 请让我的情感留在你身边 | 毛宁 |
| 284 | 一辈子的孤单 | 涩女郎 电视原声带 | 刘若英 |
| 285 | 黑板情书 | 黑板情书 | 后弦 |
| 286 | I can't let this go on any further | I can't let this go on any further | Savior |
| 287 | 因为爱情 | Stranger Under My Skin | 陈奕迅 王菲 |
| 288 | New Morning 清晨 | Mist | Bandari |
| 289 | Love the Way You Lie Part III (Original Demo) | Don't Look Down | Skylar Grey |
| 290 | 我从崖边跌落 | 算云烟 | 谢春花 |
| 291 | 往事只能回味 | 往事只能回味 | 岳云鹏 / 宋小宝 |
| 292 | 兰亭序 (慢四版)-周杰伦 | 兰亭序 | 周杰伦 |
| 293 | 君が好きだと叫びたい~TV Version~（好想大声说爱你）-BAAD | Slam Dunk Complete Vocal Collection ~TV Version~ | BAAD |
| 294 | 我只在乎你-齐秦 | 柒年·七个音乐故事 | 齐秦 |
| 295 | それが大事（最重要的事） | それが大事 | 大事MANブラザーズバンド / 渡辺禎史 |
| 296 | Never An Absolution | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 297 | Rose | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 298 | Secrets | Secrets | OneRepublic |
| 299 | 突然的自我 | 忘情1015精选辑 | 伍佰 & China Blue |
| 300 | 儿时-刘昊霖 | 鱼干铺里 | 刘昊霖 |
| 301 | 赤木の不安-徳永暁人 | Slam Dunk Complete Vocal Collection ~TV Version~ | 徳永暁人 |
| 302 | 春风十里 | 所有的酒，都不如你 | 鹿先森乐队 |
| 303 | Roses and Gold | Dust Diaries | Robin Jackson |
| 304 | Yesterday Once More | Yesterday Once More | Carpenters |
| 305 | 星座书上 | 自定义 | 许嵩 |
| 306 | 粉末 | 粉末 | 李宇春 |
| 307 | 苏州城外的微笑 | 很有爱 | 后弦 |
| 308 | Hey Jude | It's a Battle | John Lennon / Paul McCartney / It's a Cover Up |
| 309 | 天下 | 明天过后 | 张杰 |
| 310 | Last Dance | 爱情的尽头 | 伍佰 & China Blue |
| 311 | May It Be(电影《指环王：魔戒再现》插曲)-Enya | The Lord of the Rings: The Fellowship of the Ring (Original Motion Picture Soundtrack) | Enya |
| 312 | The 1950's-Zhao Jiping | Lifetimes (Vivre!) [Original Motion Picture Soundtrack] | Zhao Jiping |
| 313 | 春不晚-邓寓君(等什么君) | 春不晚 | 邓寓君(等什么君) |
| 314 | Miss Misery | Good Will Hunting (Music from the Miramax Motion Picture) | Elliott Smith |
| 315 | 风继续吹 | 风继续吹 | 张国荣 |
| 316 | Rain after Summer | Rain after Summer | 羽肿 |
| 317 | 宝贝 (in the night) | Original | 张悬 |
| 318 | 不再犹豫 | Beyond The Stage | Beyond |
| 319 | Call End（phonk）山花终将灿烂-Justin G、DJ21、DJ清心 | Call End(DeepPlay)山花终将灿烂 | Justin G / DJ21 / DJ清心 |
| 320 | 舞女-韩宝仪 | 舞女 | 韩宝仪 |
| 321 | Take a Bow | Good Girl Gone Bad | Rihanna |
| 322 | 泡沫 | Xposed | G.E.M.邓紫棋 |
| 323 | 天堂 (Live)-腾格尔 | 歌手2018 第7期 | 腾格尔 |
| 324 | 夕焼けの歌（夕阳之歌） | Matchy Best | 近藤真彦 |
| 325 | 梦醒时分-伍佰 & China Blue | 单程车票 | 伍佰 & China Blue |
| 326 | 无论你多怪异我还是会喜欢你-江惠莲 | 刺客伍六七 动画歌曲OST | 江惠莲 |
| 327 | 没有什么不同 | 我的歌声里 | 曲婉婷 |
| 328 | 夜太黑 | 夜太黑 | 林忆莲 |
| 329 | Rise - Epic Music | Rise - Epic Music | John Dreamer |
| 330 | 故乡的原风景 | 武侠音乐精装特辑 | 宗次郎 |
| 331 | 亲爱的那不是爱情 | Ang 5.0 | 张韶涵 |
| 332 | 如愿-李健（像海一样 live）-Asoat | 在未live | Asoat |
| 333 | 红色高跟鞋 | 若你碰到他 | 蔡健雅 |
| 334 | The End of the World | The End of the World | Skeeter Davis |
| 335 | 怒放的生命 | 怒放的生命 | 汪峰 |
| 336 | 有多少爱可以重来-迪克牛仔 | 别港 | 迪克牛仔 |
| 337 | 大约在冬季 | 冬雨 | 齐秦 |
| 338 | 喜欢你 | 喜欢你 | G.E.M. 邓紫棋 |
| 339 | 挪威的森林 | 爱情的尽头 | 伍佰 & China Blue |
| 340 | 本草纲目 | 依然范特西 | 周杰伦 |
| 341 | 小刀会序曲 | 武侠音乐系列之豪气中天 | 商易 / 夏飞云 / 上海民族乐团 |
| 342 | 红尘客栈-周杰伦 | 十二新作 | 周杰伦 |
| 343 | 问题出现我再告诉大家-五条人 | 县城记 | 五条人 |
| 344 | Nijamena | Nijamena | Anurag Kulkarni /Anup Rubens |
| 345 | 2 Soon | Not Thinking Bout 2morrow | Jon Young |
| 346 | 彩云追月 | Edell.Love | 爱戴 |
| 347 | 我要去西藏-乌兰托娅 | 我要去西藏 | 乌兰托娅 |
| 348 | 忧伤倒数 | 夫妻那些事 电视剧原声带 | 小昔米 |
| 349 | 爱情转移 | 认了吧 | 陈奕迅 |
| 350 | 阳光下的我们 | Say The Words | 曲婉婷 |
| 351 | 今天 | 真永远 | 刘德华 |
| 352 | 隐形的翅膀 | 潘朵拉 | 张韶涵 |
| 353 | 称王称圣任纵横-游戏科学、8082Audio | 《黑神话：悟空》游戏音乐精选集 | 游戏科学 / 8082Audio |
| 354 | 蝴蝶泉边 | 崽崽 | 黄雅莉 |
| 355 | Tassel | Dulcet Series spring special collection | Cymophane |
| 356 | 生如夏花 | 生如夏花 | 朴树 |
| 357 | Sugar | V | Maroon 5 |
| 358 | 七里香 | 七里香 | 周杰伦 |
| 359 | 辞·九门回忆 | 辞·九门回忆 | 冰幽 / 解忧草 |
| 360 | 庐州月 | 寻雾启示 | 许嵩 |
| 361 | 我可以抱你吗-张惠妹 | 我可以抱你吗？爱人 | 张惠妹 |
| 362 | Only Time | Only Time: The Collection (Box Set) | Enya |
| 363 | 香水有毒 (DJ版) | 香水有毒(宣传单曲) | 胡杨林 |
| 364 | 有何不可 | 自定义 | 许嵩 |
| 365 | 真的爱你 | BEYOND IV | Beyond |
| 366 | Blurred Lines | Blurred Lines | Robin Thicke / T.I. / Pharrell Williams |
| 367 | Remember The Time | The Ultimate Collection | Michael Jackson |
| 368 | 漫步人生路-刘惜君 | 惜 . 君 | 刘惜君 |
| 369 | 你的样子 | 一个人的样子 | 林志炫 |
| 370 | Teenage Dream | Teenage Dream | Katy Perry |
| 371 | 莫扎特：《小夜曲》第一乐章 | 2008-2011 演奏实况合集 | 中国国家交响乐团 |
| 372 | Loves Me Not | t.A.T.u. - The Best | t.A.T.u. |
| 373 | 幸せ（幸福）-中岛美雪 | Singles 2000 | 中島みゆき |
| 374 | 穿越时空的思念2 时代を超える想い2 | 映画“犬夜叉 时代を越える想い 音楽篇” | 和田薫 |
| 375 | 毕业说分手 | 毕业说分手 | 冰冰超人 |
| 376 | The South Wind | Song of the Irish Whistle | Joanie Madden |
| 377 | 精忠报国-屠洪刚 | 精忠报国 | 屠洪刚 |
| 378 | 所念皆星河 | 所念皆星河 | CMJ |
| 379 | 可能 | 可能 | 程响 |
| 380 | The Scientist | The Scientist | Coldplay |
| 381 | 大海 | 70老男孩 | 张雨生 |
| 382 | 八年的爱 | 八年的爱 | 冰冰超人 |
| 383 | 漫步人生路-邓丽君 | 邓丽君-传奇的诞生 | 邓丽君 |
| 384 | TiK ToK | Animal | Kesha |
| 385 | Underneath Your Clothes | Laundry Service | Shakira |
| 386 | My Heart Will Go On | My Love: Ultimate Essential Collection (North American Version) | Celine Dion |
| 387 | Rock House Jail | The Rock (Original Motion Picture Score) | Nick Glennie-Smith / Hans Zimmer / Harry Gregson-Williams |
| 388 | 有何不可（自白版）-许嵩 | 自定义 | 许嵩 |
| 389 | 我变了 我没变 | 我变了 我没变 | 杨宗纬 |
| 390 | Trip | Trip | Axero |
| 391 | 断桥残雪 | 断桥残雪 | 许嵩 |
| 392 | 春天里 | 信仰在空中飘扬 | 汪峰 |
| 393 | Lifetimes-Zhao Jiping | Lifetimes (Vivre!) [Original Motion Picture Soundtrack] | Zhao Jiping |
| 394 | 未来へ (向着未来) | 長い間 ～キロロの森～ | Kiroro (キロロ) |
| 395 | What A Wonderful World | All Time Greatest Hits | Louis Armstrong |
| 396 | 光明 | 信仰在空中飘扬 | 汪峰 |
| 397 | 光辉岁月 | 光辉岁月 | Beyond |
| 398 | Rhythm Of The Rain | Let It Be Me | Jason Donovan |
| 399 | Five Hundred Miles (《醉乡民谣》电影主题曲|《一路繁花相送》电视剧插曲) | Inside Llewyn Davis: Original Soundtrack Recording | Justin Timberlake / Carey Mull |
| 400 | 在他乡-水木年华 | 毕业纪念册 | 水木年华 |
| 401 | 关山酒-等什么君(邓寓君) | 关山酒 | 等什么君(邓寓君) |
| 402 | 画皮-刀郎 | 山歌寥哉 | 刀郎 |
| 403 | 21 Guns | 21st Century Breakdown | Green Day |
| 404 | The truth that you leave | The truth that you leave | Pianoboy高至豪 |
| 405 | 雨过天不晴 | 雨过天不晴 | 柯柯柯啊 |
| 406 | Snowdreams 雪之梦 | Rhine River | Bandari |
| 407 | Not a Single Day 하루도 | Rain's World (Special Edition) | Rain |
| 408 | Summer Vibe | Summer Vibe | Walk off the Earth |
| 409 | We Are One | Super Deluxe Sound I | Kelly Sweet |
| 410 | 北京北京 | 勇敢的心 | 汪峰 |
| 411 | Don't Wanna Know/We Don't Talk Anymore | Don't Wanna Know/We Don't Talk Anymore | Sam Tsui / Alex Blue |
| 412 | We Don't Talk Anymore | We Don't Talk Anymore | Alex Blue TJ Brown |
| 413 | Will and Elizabeth | Pirates of the Caribbean: The Curse of the Black Pearl | Klaus Badelt |
| 414 | You Got Me | Breakthrough | Colbie Caillat |
| 415 | Where Is the Love | Best of Both Worlds | Josh Vietti |
| 416 | Love Story | Women's Day 2019 | Taylor Swift |
| 417 | I Do | I Do | Colbie Caillat |
| 418 | BLUE | Blue Neighbourhood (Deluxe) | Troye Sivan Alex Hope |
| 419 | A Little Story | My View | Valentin |
| 420 | ひとり上手（习惯孤独） | 大吟醸 | 中島みゆき |
| 421 | Memories | 마녀유희 OST | 金有京 |
| 422 | Lover-Taylor Swift | Lover | Taylor Swift |
| 423 | MELANCHOLY | MELANCHOLY | White Cherry |
| 424 | Sundial Dreams | In the Enchanted Garden | Kevin Kern |
| 425 | If | 마녀유희 OST | 全慧彬 |
| 426 | 相思赋予谁 | 春生 | 好妹妹 |
| 427 | 小河淌水-龚琳娜 | 小河淌水 | 龚琳娜 |
| 428 | 画离弦 (柯柯吉他版) | 画离弦 | 柯柯柯啊 |
| 429 | 筝锋 | 功夫 电影原声大碟 | 黄英华 |
| 430 | Thinking Out Loud | NOW That's What I Call Music! 90 | Ed Sheeran |
| 431 | 土坡上的狗尾草 (藏语版)-宫巴 | 土坡上的狗尾巴草（藏语版） | 宫巴 |
| 432 | Righteous Path | Introducing Mellow | Blazo |
| 433 | Somebody That I Used To Know | Making Mirrors | Gotye Kimbra |
| 434 | 特别的人(Special Person)-方大同 | 危险世界 | 方大同 |
| 435 | Hard to Sleep | This Is What It Feels Like | Gracie Abrams |
| 436 | Aloha Heja He | Melancholie und Sturmflut (Bonus Tracks Edition) | Achim Reichel |
| 437 | Palace Memories | Sound. Earth. Nature. Spirit. - Vol. Sound | S.E.N.S. |
| 438 | 回家(萨克斯风) | 金耳朵Ⅲ | Kenny G |
| 439 | Breath and Life | The Platinum Series III: Eterna | Audiomachine |
| 440 | East of Eden | East of Eden | Zella Day |
| 441 | Carpe Diem | Dead Poets Society | Maurice Jarre |
| 442 | 姑娘别哭泣-柯柯柯啊 | 姑娘别哭泣 | 柯柯柯啊 |
| 443 | Beautiful In White (Demo) | Beautiful In White (Demo) | Shane Filan |
| 444 | 萱草花-张小斐 | 你好，李焕英 电影原声大碟 | 张小斐 |
| 445 | Keating's Triumph | Dead Poets Society | Maurice Jarre |
| 446 | Better Man | Sing When You're Winning | Robbie Williams |
| 447 | 理想三旬（女声版）-藤柒吖 | 理想三旬 | 藤柒吖 |
| 448 | Bridge of Faith(缘分一道桥)-王力宏、谭维维 | The Great Wall (Original Motion Picture Soundtrack) | 王力宏 / 谭维维 |
| 449 | Love Me Like You Do | Delirium | Ellie Goulding |
| 450 | Summer | ENCORE | 久石譲 |
| 451 | Viva La Vida | Viva La Vida Or Death And All His Friends | Coldplay |
| 452 | 诺言 (郭有才版) | 诺言（郭有才版） | 郭有才 |
| 453 | 爱向着我来的那天 사랑아 내게 오기만 해 (PartⅠ) | 마녀유희 OST | Ashily |
| 454 | You're Beautiful | So Beautiful 1 | James Blunt |
| 455 | 思念是一种病 | OK | 张震岳 / 蔡健雅 |
| 456 | Careless Whisper-George Michael | Ladies And Gentlemen... The Best Of George Michael | George Michael |
| 457 | 难却 (DJ细霖版|待上浓妆好戏开场) | 难却 | 平生不晚 |
| 458 | 月光-胡彦斌 | 音乐斌潮 | 胡彦斌 |
| 459 | Sunburst | Sunburst | Tobu / Itro |
| 460 | 须尽欢-钟棋煜 (渡) | 须尽欢 | 钟棋煜 (渡) |
| 461 | 像风一样自由-许巍 | 在路上…… | 许巍 |
| 462 | The Mass-Era | The Mass | Era |
| 463 | 精卫-30年前，50年后 | 丧失年轻，勿失年华 | 30年前，50年后 |
| 464 | Farewell to Camraw | When the Pipers Play | Black Kilts Berlin /Robert Mathieson |
| 465 | 想太多 | 想太多 | 李玖哲 |
| 466 | Booty Music | Git Fresh | Deep Side |
| 467 | Genie | THE BEST ~New Edition~ | 少女时代 |
| 468 | Caravan-a_hisa | Single Collection | a_hisa |
| 469 | 樱花草 | 花言乔语 (精装版) | Sweety |
| 470 | Girlfriend | The Best Damn Thing: Deluxe Edition | Avril Lavigne |
| 471 | 把悲伤留给自己-钟镇涛 | to bee continued… | 钟镇涛 |
| 472 | 出山-花粥、王胜娚 | 粥请客（四） | 花粥 / 王胜娚 |
| 473 | 道山靓仔-五条人 | 县城记 | 五条人 |
| 474 | 精卫-一颗狼星_许篮心 | 精卫（戏腔） | 一颗狼星_许篮心 |
| 475 | Remember The Name | Sampler Mixtape | Fort Minor |
| 476 | Right Here Waiting (Piano) | Right Here Waiting (Piano) | Basil Jose /Richard Marx |
| 477 | The Long Way Home | The Bright Side | Lenka |
| 478 | 暗香-沙宝亮 | 沙宝亮 | 沙宝亮 |
| 479 | 单车恋人 | 9公主 | 后弦 |
| 480 | 愤怒的消失 그게 말이죠 | 마녀유희 OST | 木单车 |
| 481 | 西厢 | 古·玩 | 后弦 |
| 482 | Bye Bye Bye | Rising Love | Lovestoned |
| 483 | 迟到-陈彼得 | 迟到 | 陈彼得 |
| 484 | Star of the County Down | Musique Celtic | Rosheen |
| 485 | 同桌的你-刘若英 | 在一起 | 刘若英 |
| 486 | 一格格-卫兰 | 一格格 | 卫兰 |
| 487 | Main Title (The Godfather Waltz) | The Godfather I | Nino Rota |
| 488 | 命运的恶作剧 운명의 장난 | 마녀유희 OST | MC 真理 / 哈哈 |
| 489 | Far Away From Home | Greatest Hits | Groove Coverage |
| 490 | Damn You | The Unreleased Collection | Lana Del Rey |
| 491 | The Happy Troll (Griefing Theme Song)-D1ofaquavibe | The Happy Troll (Griefing Theme Song) | D1ofaquavibe |
| 492 | 乌兰巴托之夜-谭维维 | 高原之心 | 谭维维 |
| 493 | Love Yourself (Natio Remix) | Love Yourself (Natio Remix) | Natio / Justin Bieber / Conor Maynard |
| 494 | Red River Valley | Journey Home | Bronn Journey |
| 495 | 去年夏天 | 去年夏天 | 王大毛 |
| 496 | 冲动的惩罚-刀郎 | 2002年的第一场雪 | 刀郎 |
| 497 | My Happy Ending | Under My Skin (Special Edition) | Avril Lavigne |
| 498 | 友谊之光 | 监狱风云 | 玛莉亚 |
| 499 | The Moon Represents My Heart | Love Ballads | Kenny G |
| 500 | Auld Lang Syne | The Greatest Gift | Charlie Landsborough |
| 501 | 口弦 | 听见凉山 电视剧原声带 | 赵艺涵 |
| 502 | 芦苇飞-泡芙芙Scarlett | 芦苇飞 | 泡芙芙Scarlett |
| 503 | 奇异恩典 | 最新热歌慢摇73 | Various Artists |
| 504 | 迟到-刘文正 | COLLECTION | 刘文正 |
| 505 | 吻别-张学友 | 吻别 | 张学友 |
| 506 | Flower Dance | A Cup Of Coffee | DJ Okawari |
| 507 | Come And Get It | Chartsurfer Vol. 30 | Selena Gomez |
| 508 | 我们的纪念-李雅微 | 我们的纪念 | 李雅微 |
| 509 | Heartbeats | Swings and Roundabouts | Amy Deasismont |
| 510 | Hero | Hero | Enrique Iglesias |
| 511 | 春不晚 (女生版)-冰洁 | 春不晚 (DJ阿卓版) | 冰洁 |
| 512 | 风中有朵雨做的云-孟庭苇 | 风中有朵雨做的云 | 孟庭苇 |
| 513 | I Just Wanna Run | Take Action! Volume 9 | The Downtown Fiction |
| 514 | 心愿-四个女生 | 心愿 | 四个女生 |
| 515 | Payphone-Boyce Avenue | Cover Sessions, Vol. 2 | Boyce Avenue |
| 516 | 莫失莫忘 | 仙剑奇侠传 电视原创配乐 | 麦振鸿 |
| 517 | I Want You to Know | I Want You to Know | Zedd / Selena Gomez |
| 518 | We Are Young | Dancing Bear Best Of 2012 International | Fun. Janelle Monáe |
| 519 | 罗刹海市-刀郎 | 山歌寥哉 | 刀郎 |
| 520 | The Day You Went Away | The Day You Went Away: The Best of M2M | M2M |
| 521 | Sleepyhead | Acoustic Daydreams | Galen Crew |
| 522 | Moon As My Heart | Harmonica Sound of Hong Kong | Robert Bonfiglio |
| 523 | Solstice-K-391 | Solstice | K-391 |
| 524 | 西海情歌-刀郎 | 刀郎Ⅲ | 刀郎 |
| 525 | 卡农D大调 | 胎教音乐 | 群星 |
| 526 | My Soul | Time... | July |
| 527 | 我记得你眼里的依恋-万芳 | 真情 | 万芳 |
| 528 | 爱你-徐俊雅 | 我的秘密 | 徐俊雅 |
| 529 | 你头顶的风-王小帅 | 你头顶的风 | 王小帅 |
| 530 | 弱水三千-周传雄 | 蓝色土耳其 | 周传雄 |
| 531 | Conquest of Paradise-Vangelis | 1492 - Conquest Of Paradise | Vangelis |
| 532 | 富士山下 | What's Going On…? | 陈奕迅 |
| 533 | New Soul | Irlande | Vox Angeli |
| 534 | 莫问归期 (DZC-remix|Remix)-蒋雪儿Snow.J | 莫问归期 （DZC-remix） | 蒋雪儿Snow.J |
| 535 | 乌兰巴托的夜 (丹正母子版) | 乌兰巴托的夜 | 丹正母子 |
| 536 | 青丝-唐伯虎Annie | 青丝 | 唐伯虎Annie |
| 537 | If I Die Young | If I Die Young - Single | The Band Perry |
| 538 | The Godfather (Love Theme) | The Godfather I | Nino Rota |
| 539 | 有没有一首歌会让你想起我-周华健 | 忘忧草 | 周华健 |
| 540 | Stitches-Shawn Mendes | Kids Zone | Shawn Mendes |
| 541 | 歳月-雲流れ-(岁月-层云流动- / 砕月)-Foxtail-Grass Studio | なつかぜメモリア | Foxtail-Grass Studio |
| 542 | Cheap Thrills-Sia | This Is Acting | Sia |
| 543 | 灰色轨迹(电影《天若有情》插曲)-Beyond | Beyond 24K Gold 金碟至尊精选 | Beyond |
| 544 | Call End（DeepPlay Slow）-KKK、Mike | Call End（Deep House） | KKK / Mike |
| 545 | 原来你也在这里-周笔畅 | 原来你也在这里 | 周笔畅 |
| 546 | 渔舟唱晚混音版(央视天气预报背景音乐)-浦琦璋 | 劲舞 | 浦琦璋 |
| 547 | 女儿情(电视剧《西游记》插曲)-吴静 | 西游记 电视连续剧歌曲 | 吴静 |
| 548 | Moves Like Jagger-Maroon 5、Christina Aguilera | Moves Like Jagger | Maroon 5 / Christina Aguilera |
| 549 | Hero's Theme-Steven Burke | Kameo: Elements of Power O.S.T | Steven Burke |
| 550 | My Love (Radio Edit) | Coast to Coast | Westlife |
| 551 | What Are Words | What Are Words | Chris Medina |
| 552 | 春不晚-司南 | 春不晚 | 司南 |
| 553 | 弱水三千 (抒情版)-瑕吕汀汀 | 弱水三千 (抒情版) | 瑕吕汀汀 |
| 554 | 离别开出花-就是南方凯 | 离别开出花 | 就是南方凯 |
| 555 | Young For You | Young For You | GALA |
| 556 | Realm Ideal理想-安苒 | 书香气斯人 | 安苒 |
| 557 | The Ludlows | Legends Of The Fall Original Motion Picture Soundtrack | James Horner |
| 558 | 雪の華（雪之花）-中岛美嘉 | 雪の華 | 中島美嘉 |
| 559 | 外婆的澎湖湾-潘安邦 | 思念总在潘安邦 | 潘安邦 |
| 560 | Believer-Imagine Dragons | Believer | Imagine Dragons / Lil Wayne |
| 561 | 让我欢喜让我忧-周华健 | 让我欢喜让我忧 | 周华健 |
| 562 | Pop Danthology 2012 | Pop Danthology | DJ Daniel Kim |
| 563 | 向云端-小霞&海洋Bo | 向云端 | 小霞 / 海洋Bo |
| 564 | 城南花已开 | 城南花已开 | 三亩地 |
| 565 | Paris | Paris | Else |
| 566 | Monsters (Live)-周深 | 歌手·当打之年 第5期 | 周深 |
| 567 | 颠倒歌-刀郎 | 山歌寥哉 | 刀郎 |
| 568 | 花心 | Keep Wakin 1987-2002 周而复始 | 周华健 |
| 569 | 呼唤 오나라 I | 대장금 OST | 김지현 |
| 570 | 爱向着我来的那天2 사랑아 내게 오기만 해 (Part II) | 마녀유희 OST | Ashily |
| 571 | 再见 | 再见 | 张震岳 |
| 572 | Catch My Breath-Kelly Clarkson | Greatest Hits - Chapter One | Kelly Clarkson |
| 573 | 千千阙歌 | 千千阙歌 | 陈慧娴 |
| 574 | 心跳-王力宏 | 心·跳 | 王力宏 |
| 575 | 風になる(幻化成风 / 大手拉小手)-つじあやの | 猫の恩返し サウンドトラック | つじあやの |
| 576 | Night Crusing(夜间巡航) (Inst.)-牛尾憲輔 | ピンポン OST | 牛尾憲輔 (agraph) |
| 577 | 萍聚 | 萍聚/珍重再见 | 李翊君 / 李富兴 |
| 578 | Kiss The Rain 비를 맞다 | The Best - Reminiscent 10th Anniversary | Yiruma |
| 579 | 黄风起兮-熊竹英、游戏科学、8082Audio | 《黑神话：悟空》游戏音乐精选集 | 熊竹英、游戏科学、8082Audio |
| 580 | 千百度-许嵩 | 苏格拉没有底 | 许嵩 |
| 581 | Runner | Runner | Dustin O'Halloran |
| 582 | This Is the Life | Weathered | Angie Miller |
| 583 | 从头再来 | 从头再来 | 刘欢 |
| 584 | Dead Poets Society (Finale) | Filmharmonic II | The Royal Philharmonic Orchestra Maurice Jarre |
| 585 | The sally gardens | Arias Ancora | Laure Green |
| 586 | Friendships-Pascal Letoublon | Friendships | Pascal Letoublon |
| 587 | 序曲：天地孤影任我行 | 东邪西毒(电影音乐) | 陈勋奇 |
| 588 | 送别 | 送别 | 韩红 |
| 589 | 安静 钢琴版 | 纯音乐流行歌曲钢琴版 | Paul Liu |
| 590 | Wrecking Ball | Wrecking Ball | Miley Cyrus |
| 591 | 是啊 그래 | 마녀유희 OST | 나창현 |
| 592 | Six Feet Under | Six Feet Under | Billie Eilish |
| 593 | 穿越时空的思念1 时代を超える想い1 | 映画“犬夜叉 时代を越える想い 音楽篇” | 和田薫 |
| 594 | 千千阙歌 (Live)-周深 | 聚划算55青春选择之夜晚会Live | 周深 |
| 595 | 偷功 | 太极张三丰 电影原声带 | 胡伟立 |
| 596 | Umbrella | Now That's What I Call Music! 25 Years | Rihanna / Jay-Z |
| 597 | Waka Waka (Esto Es África) | Waka Waka (This Time For Africa) (The Official 2010 Fifa World Cup Song) | Shakira |
| 598 | 假如爱有天意(电视剧《最食人间烟火色》插曲)-贺三 | 假如爱有天意 | 贺三 |
| 599 | In The End | In The End | Linkin Park |
| 600 | Shots (Broiler Remix)-Imagine Dragons | Shots | Broiler / Imagine Dragons |
| 601 | Monody | Monody | TheFatRat / Laura Brehm |
| 602 | The Show | The Show | Lenka |
| 603 | 野子 (Live) | 我是歌手第四季 第3期 | 苏运莹 |
| 604 | Gee | The First Mini Album Gee | 少女时代 (소녀시대) |
| 605 | Ship In The Sand | Dear Me, Look Up | Marble Sounds |
| 606 | Summertime Sadness | Summertime Sadness | Lana Del Rey |
| 607 | Trouble Is A Friend-Lenka | Trouble Is A Friend - The Remixes | Lenka |
| 608 | 慕情 (M-4) | 犬夜叉 音楽篇 | 和田薫 |
| 609 | 绝对占有 相对自由-陈粒 | 如也 | 陈粒 |
| 610 | 十里亭-黄建威 | 十里亭 | 黄建威 |
| 611 | 最浪漫的事-赵咏华&好妹妹 | 追梦人 | 赵咏华 / 好妹妹 |
| 612 | 外滩十八号 | 外滩十八号 | 男才女貌 |
| 613 | Honor (Main Title Theme from "The Pacific") | The Pacific (Music From the HBO Miniseries) | Hans Zimmer / Geoff Zanelli / Blake Neely |
| 614 | 花妖-刀郎 | 山歌寥哉 | 刀郎 |
| 615 | 爱-小虎队 | 爱 | 小虎队 |
| 616 | 兰亭序 (粤语版)-邓千荧 | 兰亭序 | 邓千荧 |
| 617 | Requiem For A Tower | Escala | Escala |
| 618 | 乌兰巴托的夜-左小祖咒 | 美国 The U.S.A（电影原声配乐） | 左小祖咒 |
| 619 | I Love You (Remix) | I Love You | United Idol |
| 620 | 你还要我怎样 | 意外 | 薛之谦 |
| 621 | 发现爱 | 西界 | 林俊杰 / 金莎 |
| 622 | 轻轻地告诉你-杨钰莹 | 月亮船 | 杨钰莹 |
| 623 | 黑色毛衣-周杰伦 | 十一月的萧邦 | 周杰伦 |
| 624 | 思念是一种病+爱人同志+爱如潮水+你现在还好吗(Live)-纵贯线 | Live in Taipei 出发/终点站 | 纵贯线 |
| 625 | 桥边姑娘 | 桥边姑娘 | 海伦 |
| 626 | 犯错 | 犯错 | 顾峰 / 斯琴高丽 |
| 627 | 那年初夏 | 毕业了我们一无所有 | 任然 |
| 628 | 北京欢迎你 | 北京2008年奥运会歌曲专辑 | 群星 |
| 629 | Red River Valley | Cowboy Songs | Michael Martin Murphey |
| 630 | 500 Miles | Buck The Trend | Peter, Paul & Mary |
| 631 | 500 Miles | Christ Is My Hope | The Innocence Mission |
| 632 | 500 Miles | Let's Folk | The Brothers Four |
| 633 | 画离弦 (柯柯版) | 画离弦 | 柯柯柯啊 |
| 634 | Ferrari-Jayvine Ramma | Ferrari | Jayvine Ramma |
| 635 | Annie's Wonderland 安妮的仙境 | Wonderland | Bandari |
| 636 | 阿凡达与屌丝男 | 心花路放 电影原声带 | 许鹤缤 |
| 637 | 花 ~すべての人に心の花を~ (オリジナル・ヴァージョン) | ザ・ニュー・ベスト・オブ・喜納昌吉＆チャンプルース | 喜納昌吉 (きな しょうきち) |
| 638 | 茶花开了-王睿卓 | 茶花开了 | 王睿卓 |
| 639 | Princesses Don't Cry-CARYS | Songs About Boys | CARYS |
| 640 | Skinny Love | Skinny Love | Birdy |
| 641 | 我的歌声里 | 我的歌声里 | 李代沫 |
| 642 | 情人 | 海阔天空 | Beyond |
| 643 | 给我一个吻-杨子姗 | 重返20岁 电影原声带 | 杨子姗 |
| 644 | 桔梗谣 | 노들강변 매화타령 민요 | 노들강변 매화타령 민요 |
| 645 | 为爱痴狂 | 《中国好声音》2012跨年演唱会 | 金志文 |
| 646 | Mariage d'amour | Lettre à ma Mère | Richard Clayderman |
| 647 | 我可以抱你吗 (Live)-孟根花 | 我可以抱你吗 | 孟根花 |
| 648 | 世界第一等 | 世界第一等 | 浪哥 |
| 649 | 晴天-周杰伦 | 叶惠美 | 周杰伦 |
| 650 | Unable To Stay, Unwilling To Leave | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 651 | Mine (Illenium Remix)-ILLENIUM、Phoebe Ryan | Mine (ILLENIUM Remix) | ILLENIUM / Phoebe Ryan |
| 652 | 带我到山顶 | 听见凉山 | 赵艺涵 |
| 653 | Baby | Baby | Justin Bieber / Ludacris |
| 654 | 美丽的神话(Endless Love 2)-韩红、孙楠 | 恋曲神话 | 韩红 / 孙楠 |
| 655 | 岁月漫长-赵进 | 六姊妹 电视剧原声带 | 赵进 |
| 656 | 须尽欢(人间烟火)-海伦、刘兆宇 | 须尽欢·人间烟火 | 海伦 / 刘兆宇 |
| 657 | 春娇与志明 | 春娇与志明 | 街道办GDC /欧阳耀莹 |
| 658 | Nevada | Monstercat - Best of 2016 | Vicetone / Cozi Zuehlsdorff |
| 659 | 游山恋-海伦 | 游山恋 | 海伦 |
| 660 | 听妈妈的话 | 依然范特西 | 周杰伦 |
| 661 | Whataya Want from Me-Adam Lambert | For Your Entertainment (Tour Edition) | Adam Lambert |
| 662 | Jambalaya | 不朽的声音(人生最难忘的歌) | Carpenters |
| 663 | 红尘情歌 | 情路无悔 | 高安 /黑鸭子组合 |
| 664 | 恋曲1990-程璧 | 恋曲1990 | 程璧 |
| 665 | Moon River(月河)-Audrey Hepburn | Music from the Films of Audrey Hepburn | Audrey Hepburn |
| 666 | 车站 (Live)-李健 | 我是歌手 2015巅峰会 | 李健 |
| 667 | 海角七号-东来东往 | 路过.爱 | 东来东往 |
| 668 | 须尽欢 (女版)-弹棉花的小花 | 须尽欢 (女版) | 弹棉花的小花 |
| 669 | 莉莉安-宋冬野 | 安和桥北 | 宋冬野 |
| 670 | Prendre sa main | Cri d'amour | Angel Lover |
| 671 | 安静 | 范特西 | 周杰伦 |
| 672 | 梦中蝶影 | 歌曲合辑 | 华语群星 |
| 673 | 姑娘我爱你 | 姑娘我爱你 | 索朗扎西 |
| 674 | 借我 | 算云烟 | 谢春花 |
| 675 | Always With Me | 幸福的味道 | 木村弓 / 奥户巴寿 |
| 676 | 총맞은것처럼 (像中枪一样)-白智英 | Sensibility | 白智英 (백지영) |
| 677 | 兰亭序 | 魔杰座 | 周杰伦 |
| 678 | The Red Sun | 20 Years of Achievement around the World | Richard Clayderman |
| 679 | 快乐崇拜-潘玮柏、张韶涵 | Wu Ha | 潘玮柏 / 张韶涵 |
| 680 | 纯真年代 | 大小世界 | 爱朵女孩 |
| 681 | Vincent | Legendary Don McLean | Don McLean |
| 682 | 平凡之路 | 猎户星座 | 朴树 |
| 683 | 李白 | 模特 | 李荣浩 |
| 684 | You | YOU | Approaching Nirvana |
| 685 | Coming Home | Coming Home | Skylar Grey / Diddy-Dirty Money |
| 686 | Turnin' | Young Rising Sons | Young Rising Sons |
| 687 | 意外 | 意外 | 薛之谦 |
| 688 | Cruel Summer-Taylor Swift | Lover | Taylor Swift |
| 689 | Promise | Promise | sapientdream |
| 690 | 那些年 | 那些年，我们一起追的女孩 电影原声带 | 胡夏 |
| 691 | 有一种爱叫做放手 | 有一种爱叫做放手 | 阿木 |
| 692 | 童年 | 童年 | 北京天使合唱团 |
| 693 | 弱水三千 (抒情女声戏腔版)-柳桐非 | 弱水三千 (抒情女声戏腔版) | 柳桐非 |
| 694 | 爱的供养(电视剧《宫锁心玉》主题曲)-杨幂 | 宫锁心玉 电视剧原声带 | 杨幂 |
| 695 | 壁上观-龚琳娜 | 壁上观 | 龚琳娜 |
| 696 | 父亲写的散文诗-许飞 | 父亲写的散文诗 | 许飞 |
| 697 | Still D.R.E (Instrumental Version)-Dr. Dre Snoop Dogg | Still D.R.E. | Dr. Dre / Snoop Dogg |
| 698 | 赤伶(DJ版) | 赤伶 | DJ名龙 |
| 699 | 我最亲爱的 | 我的歌声里 | 李代沫 |
| 700 | April 四月之春 | Sunrise Hill | Bandari |
| 701 | 外婆的澎湖湾-张明敏 | 民歌回忆专辑 | 张明敏 |
| 702 | Fight | Fight | BeatBrothers |
| 703 | 我希望 | 匆匆那年 电视原声带 | 杨玏 |
| 704 | 笑傲江湖曲(琴箫合奏)-胡伟立 | 武侠音乐系列之疗伤神法 | 胡伟立 |
| 705 | 恋曲1990-高胜美 | 经典金选1 哭砂 | 高胜美 |
| 706 | 知道不知道 | Rene | 刘若英 |
| 707 | 屁-者来女、游戏科学、8082Audio | 《黑神话：悟空》游戏音乐精选集 | 者来女 / 游戏科学 / 8082Audio |
| 708 | 春庭雪（DJ小瑞版） | 春庭雪（DJ小瑞版） | 小瑞 |
| 709 | Jiazhen Leaves Fughi-Zhao Jiping | Lifetimes (Vivre!) [Original Motion Picture Soundtrack] | Zhao Jiping |
| 710 | 花-喜納昌吉 | The Celebrations | 喜納昌吉 / チャンプルーズ |
| 711 | Don't Worry Be Happy | Pretty Donkey Girl | Holly Dolly |
| 712 | Say Hello | These Friends Of Mine | Rosie Thomas / Sufjan Stevens |
| 713 | Absolution-Ryan Taubert | The Works of Ryan Taubert | Ryan Taubert |
| 714 | 大风吹 (Live)-刘惜君、王赫野 | 天赐的声音第二季 第12期 | 刘惜君 /王赫野 |
| 715 | 海阔天空-G.E.M.邓紫棋 | T.I.M.E. | G.E.M.邓紫棋 |
| 716 | 我记得 | 署前街少年 | 赵雷 |
| 717 | The Right Path | Age of Innocence (Original Soundtrack) | Thomas Greenberg |
| 718 | 相思 | 腔.调 | 毛阿敏 |
| 719 | 云宫迅音-许镜清 | 西游记 电视剧配乐原声 | 许镜清 |
| 720 | Seven Lonely Days | Remember When? - 25 Golden Memories | Georgia Gibbs |
| 721 | 相对 | 子曰 第一册 | 子曰乐队 |
| 722 | Sally Gardens | Spring | The O'Neill Brothers |
| 723 | 2 Phút Hơn (KAIZ Remix) | 2 Phút Hơn (KAIZ Remix) | Pháo / KAIZ |
| 724 | 亲爱的你啊(电视剧《无尽的尽头》主题曲)-任素汐 | 亲爱的你啊 | 任素汐 |
| 725 | 紫 (Live)-郭沁 | 中国新歌声第二季 第10期 | 郭沁 |
| 726 | 你的酒馆对我打了烊-陈雪凝 | 你的酒馆对我打了烊 | 陈雪凝 |
| 727 | Valder Fields | A Plea en Vendredi | Tamas Wells |
| 728 | 诺言(中视八点档《孽海花》片头曲)-李翊君 | 诺言 | 李翊君 |
| 729 | 刚好遇见你 | 刚好遇见你 | 李玉刚 |
| 730 | Way Back then | 오징어게임 OST | 郑在日 (정재일) |
| 731 | 轻轻地告诉你(电影《独行月球》七夕推广曲)-沈腾、马丽 | Moon Man (Original Motion Picture Soundtrack) - (《独行月球》电影原声专辑) | 沈腾 / 马丽 |
| 732 | 探故知 (超梦幻DJ版)-浅影阿 | 探故知 | 浅影阿 |
| 733 | 爱要坦荡荡-萧潇 | Beautiful Angel | 萧潇 |
| 734 | 你的答案-阿冗 | 你的答案 | 阿冗 |
| 735 | 借口-周杰伦 | 七里香 | 周杰伦 |
| 736 | 敢问路在何方-蒋大为 | 中国歌唱大师名家经典 蒋大为 | 蒋大为 |
| 737 | 桃花诺(电视剧《上古情歌》片尾曲)-G.E.M.邓紫棋 | 上古情歌 电视剧原声带 | G.E.M.邓紫棋 |
| 738 | Luv Letter | 髙橋大輔～フェイヴァリット・ミュージック～ | 神津裕之 |
| 739 | 海阔天空 | 一声所爱 大地飞歌（第九期） | 汪小敏 |
| 740 | 半妖-和田薫 | TVアニメーション「犬夜叉」オリジナルサウンドトラックアルバム「犬夜叉 音楽篇」 | 和田薫 |
| 741 | 男と女（男和女） | Standing Ovation | CHAGE and ASKA |
| 742 | 万水千山总是情 | 万水千山总是情 电视剧原声带 | 汪明荃 |
| 743 | 希望 | Grace & Charm | 陈慧琳 |
| 744 | Sunny Day-Joy Williams | Songs from This - EP | Joy Williams |
| 745 | Anak (remix: Freddie Aguilar|Remix) | 清尘 | 清尘 |
| 746 | Liability | Melodrama | Lorde |
| 747 | Never Say Good Bye | 마이걸 | Mario & Nesty (마리오&네스티) |
| 748 | 城府 | 自定义 | 许嵩 |
| 749 | Rompasso-Angetenar（DEITIES remix）-DEITIES Ghetto Artist | Angetenar (DEITIES Remix) | DEITIES / Ghetto Artist |
| 750 | All Falls Down | All Falls Down | Alan Walker / Noah Cyrus / Digital Farm Animals / Juliander |
| 751 | 梦中的婚礼 | Richard Clayderman | Richard Clayderman |
| 752 | Ferrari-Bebe Rexha | Expectations | Bebe Rexha |
| 753 | Faded | Faded | Alan Walker / Iselin Solheim |
| 754 | 须尽欢 (释怀版)-王梓钰 | 须尽欢（释怀版） | 王梓钰 |
| 755 | 被遗忘的时光-蔡琴 | 出塞曲 | 蔡琴 |
| 756 | Take It From Me | Say I Am You | The Weepies / Deb Talan / Steve Tannen |
| 757 | You Belong To Me | To You | Carla Bruni |
| 758 | 鼓楼 | 无法长大 | 赵雷 |
| 759 | 发如雪 | 十一月的萧邦 | 周杰伦 |
| 760 | Bad Romance (Radio Edit)-Lady Gaga | Bad Romance | Lady Gaga |
| 761 | Windy Hill（风之谷） | Windy Hill | 羽肿 |
| 762 | Bloom of Youth | クドわふたー オリジナル サウンドトラック | 清水淳一 |
| 763 | Your Man | Double Cream 5: 20 Years of Nashville #1's 1992-2012 | Josh Turner |
| 764 | 天地龙鳞(大型纪录片《紫禁城》主题歌)-王力宏 | 大型纪录片《紫禁城》主题歌音乐专辑 | 王力宏 |
| 765 | 鸿雁-额尔古纳乐队 | 往日时光 | 额尔古纳乐队 |
| 766 | 热爱105°C的你 | 热爱105°C的你 | 腾格尔 / 艾伦 / 沈腾 |
| 767 | Eventide | Eventide | Nylon |
| 768 | Because of You | Because Of You | Kelly Clarkson |
| 769 | 思念是一种病-孙露 | 对你太在乎 | 孙露 |
| 770 | 等爱的玫瑰-凤凰传奇 | 吉祥如意 | 凤凰传奇 |
| 771 | Demons | Continued Silence EP | Imagine Dragons |
| 772 | Take Me To Church | Bravo Hits 86 | Hozier |
| 773 | Just One Last Dance (Album Version) | Key To My Soul | Sarah Connor /Marc Terenzi |
| 774 | Love The Way You Lie (Part III (Original Demo)) | Relaxing Acoustic | Skylar Grey |
| 775 | 归去来兮-花粥 | 一碗 | 花粥 |
| 776 | 不染(电视剧《香蜜沉沉烬如霜》主题曲)-毛不易 | 香蜜沉沉烬如霜 电视原声音乐专辑 | 毛不易 |
| 777 | 可能否-木小雅 | 可能否 | 木小雅 |
| 778 | 老男孩 | 父亲 | 筷子兄弟 |
| 779 | The Bolter(逃脱者)-Taylor Swift | THE TORTURED POETS DEPARTMENT: THE ANTHOLOGY | Taylor Swift |
| 780 | 安和桥（女声版）-藤柒吖 | 安和桥 | 藤柒吖 |
| 781 | 我是一只小小鸟 | 我是一只小小鸟 | 赵传 |
| 782 | Ngẫu Hứng-Hoaprox、MonBet | Ngẫu Hứng | Hoaprox / MonBet |
| 783 | 把悲伤留给自己-赵鹏 | 2008再低一次 | 赵鹏 |
| 784 | 三寸天堂 （电视剧《步步惊心》片尾曲）-尘子 | 三寸天堂（电视剧《步步惊心》片尾曲） | 尘子 |
| 785 | 漂洋过海来看你-刘明湘 | 我不要再比了 | 刘明湘 |
| 786 | 外婆的澎湖湾-北京天使合唱团 | 童年 | 北京天使合唱团 |
| 787 | 星晴-周杰伦 | Jay | 周杰伦 |
| 788 | Shots-Imagine Dragons | Shots | Imagine Dragons |
| 789 | Fragile-George Skaroulis | Reunion | George Skaroulis |
| 790 | 青丝（DJ小瑞版） | 青丝（一缕青丝一声叹） | 小瑞 |
| 791 | 独家记忆 | 独家记忆 (Hong Kong Version) | 陈小春 |
| 792 | Be What You Wanna Be | Darin | Darin |
| 793 | 好久不见 | 认了吧 | 陈奕迅 |
| 794 | A Place Called You | Enchanted | Emma Stevens |
| 795 | Young And Beautiful | Triple J Hottest 100 Vol 21 | Lana Del Rey |
| 796 | 长路漫漫任我闯 | 林子祥精选之天长地久 | 林子祥 |
| 797 | Frail Love | Frail Love | Cloves |
| 798 | Scarborough Fair | The Very Best of Sarah Brightman 1990-2000 | Sarah Brightman |
| 799 | 从头再来 | 经典20年 珍藏锦集 | 刘欢 |
| 800 | 浮夸 | U-87 | 陈奕迅 |
| 801 | Asphyxia 窒息 | asphyxia | 逆时针向 |
| 802 | The Ocean (Radio Edit) | The Ocean | Mike Perry / SHY Martin |
| 803 | 琴师-要不要买菜 | 琴师 | 要不要买菜 |
| 804 | 西海情歌-黑鸭子 | 典盛集5 | 黑鸭子 |
| 805 | 乌兰巴托的夜-葱香科学家（王悠然） | 乌兰巴托的夜 | 葱香科学家（王悠然） |
| 806 | 听 | 拾 | 张杰 |
| 807 | Lonely | Nana | Nana |
| 808 | 冰雨-刘德华 | 爱在刻骨铭心时 | 刘德华 |
| 809 | Unity | Sounds of Syndication, Vol .1 (Presented by Syndicate) | TheFatRat |
| 810 | Hey, Soul Sister | Save Me, San Francisco | Train |
| 811 | Waltz No.6 'Petit Chien' in D Flat Major Op.40-1 | 越听越聪明 1 | Classical Artists |
| 812 | 我们的纪念-弦子 | 我们的纪念 | 弦子 |
| 813 | 最好的安排-曲婉婷 | LLL | 曲婉婷 |
| 814 | Elsinore Revisited(重访埃尔西诺) | Rosencrantz & Guildenstern are Undead | Sean Lennon |
| 815 | Too Far | King in the Mirror | Anna F |
| 816 | Inspire | Serenity | Capo Productions |
| 817 | 好春光(电视剧《春光灿烂猪八戒》主题曲)-吴彤 | 好春光 | 吴彤 |
| 818 | 映山红(电影《闪闪的红星》插曲)-刘欢 | 六十年代生人 | 刘欢 |
| 819 | Happy-Pharrell Williams | Happy (From "Despicable Me 2") | Pharrell Williams |
| 820 | 让我偷偷看你 | 阿弥陀佛么么哒·一个孩子的心愿 | 赵雷 |
| 821 | Collapsing World(崩溃的世界)-Lightscape | Collapsing World | Lightscape |
| 822 | やわらかな光(柔和之光)-やまだ豊 | フジテレビ系ドラマ「僕のいた時間」オリジナルサウンドトラック - (日剧《我存在的时间》原声带) | やまだ豊 |
| 823 | 夜的钢琴曲五 | 夜的钢琴曲 Demo集 | 石进 |
| 824 | Sutter's Mill | The Music of Dan Fogelberg | Dan Fogelberg |
| 825 | Please Don't Go | Please Don't Go | Joel Adams |
| 826 | 曾经的你 | 每一刻都是崭新的 | 许巍 |
| 827 | 最伟大的作品-周杰伦 | 最伟大的作品 | 周杰伦 |
| 828 | Don't Let Me Fall-Lenka | Lenka (Expanded Edition) | Lenka |
| 829 | Stay Here Forever | Valentine's Day OST | Jewel |
| 830 | 存在 | 生无所求 | 汪峰 |
| 831 | Stay Alive | The Secret Life Of Walter Mitty (Music From And Inspired By The Motion Picture) | José González |
| 832 | Counting Stars-OneRepublic | Native (Deluxe Version) | OneRepublic |
| 833 | 往生咒（黑神话：悟空）-游戏科学 | 黑神话：悟空（Black Myth：WuKong） | 游戏科学 |
| 834 | 我就喜欢你这样的丫头 | 匆匆那年 电视原声带 | 杜维瀚 |
| 835 | Everybody | Everybody | Ingrid Michaelson |
| 836 | 传奇 | 传奇 | 王菲 |
| 837 | 易燃易爆炸 | 如也 | 陈粒 |
| 838 | 飞向别人的床 | 飞向别人的床 | 沉珂（C.K）& 光光 |
| 839 | 赤伶 (弹唱版) | 赤伶 | 孙鹏凯 |
| 840 | Astronomia（黑人抬棺古风版） | 黑人抬棺古风版 | litterzy、水玥儿 |
| 841 | 是否我真的一无所有(电影《飚城》主题曲)-王杰 | 白羽毛之恋 华语典藏情歌 Vol.2 | 王杰 |
| 842 | I Want My Tears Back | Imaginaerum | Nightwish |
| 843 | 红颜 | MuSiC混合体 | 胡彦斌 |
| 844 | 漫步人生路-王若琳 | 爱的呼唤 | 王若琳 |
| 845 | 路过人间-郁可唯 | 路过人间 | 郁可唯 |
| 846 | 鸳鸯戏-邓寓君(等什么君) | 鸳鸯戏 | 邓寓君(等什么君) |
| 847 | 혼자시킨 사랑 独自的爱情 | 명랑소녀 성공기 OST | True Bird |
| 848 | 潮湿的心 | 蜕变1少女的心情故事 | 卓依婷 |
| 849 | brave heart | brave heart | 宮崎歩 |
| 850 | 世界第一等-伍佰 | 滚石香港黄金十年 伍佰精选 | 伍佰 |
| 851 | 明天过后 | 明天过后 | 张杰 |
| 852 | 暖暖-1个球 | 暖暖 | 1个球 |
| 853 | Love Theme | 명랑소녀 성공기 OST | 吴振宇 |
| 854 | Read My Mind | Jade | Sweetbox |
| 855 | 千里之外-周杰伦、费玉清 | 依然范特西 | 周杰伦/费玉清 |
| 856 | Let It Out | Let It Out | Frances |
| 857 | Love Song | 명랑소녀 성공기 OST | 赵长赫 |
| 858 | 芒种(梦幻西游普陀山门派曲)-腾格尔 | 芒种 | 腾格尔 |
| 859 | 飞得更高 | 笑着哭 | 汪峰 |
| 860 | 花火 | 花火 | 汪峰 |
| 861 | 直到永远 | 生死不离 我们在一起 | 汪峰 |
| 862 | 跟往事干杯 | 不朽金曲精选 Ⅰ | 姜育恒 |
| 863 | 枫-周杰伦 | 十一月的萧邦 | 周杰伦 |
| 864 | 蓝莲花 | 时光.漫步 | 许巍 |
| 865 | 娃娃脸 | 娃娃脸 | 后弦 |
| 866 | 我爱你中国 | 怒放的生命 | 汪峰 |
| 867 | 星象仪 プラネタリウム | プラネタリウム | 大塚爱 |
| 868 | 推理(オリジナル・ヴァージョン)-大野克夫 | 「名探偵コナン」サントラ・スーパー・ベスト- (名侦探柯南) | 大野克夫 |
| 869 | 一直很安静 | 寂寞在唱歌 | 阿桑 |
| 870 | 生活不止眼前的苟且 | 生活不止眼前的苟且 | 许巍 |
| 871 | Mark's Theme-顾嘉辉 | 英雄本色1&2 | 顾嘉辉 |
| 872 | Tears Of A Clown | Mastercutor | U.D.O. |
| 873 | 運命のルーレット廻して (转动命运之轮) | 運命のルーレット廻して | ZARD (ザード) |
| 874 | The Dawn-Dreamtale | Beyond Reality (Japanese Edition) | Dreamtale |
| 875 | 兰亭序 (粤语版) (Single Version) | 兰亭序 | 王十三 |
| 876 | For Free | Folk For Kids | Lana Del Rey / Zella Day / Weyes Blood |
| 877 | Poker Face-Lady Gaga | Poker Face | Lady Gaga |
| 878 | My Destiny (我的命运) | 별에서 온 그대 OST Part 1 | LYn (린) |
| 879 | 亲爱的路人 | 亲爱的路人 | 刘若英 |
| 880 | Casablanca(卡萨布兰卡)-Bertie Higgins | Movie 930 | Bertie Higgins |
| 881 | 等不到的爱 | 裸婚时代 电视剧原声带 | 文章 |
| 882 | Call Me Maybe | Call Me Maybe | Carly Rae Jepsen |
| 883 | 花开在眼前 | 花开在眼前 | 韩磊 |
| 884 | 如果不能好好爱 | 如果不能好好爱 | 吴克群 |
| 885 | 童年 | 纵贯线演唱会 | 罗大佑、李宗盛、张震岳、周华健 |
| 886 | 魔訶不思議アドベンチャー! | ドラゴンボール全曲集 | 高橋洋樹 |
| 887 | 虹之间(电视剧《爱情公寓4》插曲)-金贵晟 | 爱情公寓4 电视原声带 | 金贵晟 |
| 888 | 外婆的澎湖湾-卓依婷 | 校园民谣 | 卓依婷 |
| 889 | 我是一只小小鸟-任贤齐&李宗盛 | 台湾男儿任贤齐认真精选辑 | 任贤齐 / 李宗盛 |
| 890 | 白羊座的忧伤-石进 | 夜的钢琴曲Ⅱ | 石进 |
| 891 | One Night In 北京 | SHIN 同名专辑 | 信乐团 |
| 892 | The Monster | The Monster | Eminem / Rihanna |
| 893 | 花香(电视剧《薰衣草》插曲)-许绍洋 | 香草恋人馆 电视原声带 | 许绍洋 |
| 894 | 1%-Oscar Scheller、Lily Allen | 1% | Oscar Scheller / Lily Allen |
| 895 | Groundhog Day | Groundhog Day | Em Beihold |
| 896 | 我期待-张雨生 | 卡拉OK.台北.我 | 张雨生 |
| 897 | Amazing Grace 天赐恩宠 | 苏格兰音乐之旅 苏格兰风笛 | 群星 |
| 898 | 依然爱你-王力宏 | 火力全开 (新歌+精选) | 王力宏 |
| 899 | 童年-张艾嘉 | 童年 | 张艾嘉 |
| 900 | 漂洋过海来看你-孙露 | 寂寞女人心 | 孙露 |
| 901 | 兰亭序【笛子版】-亿只张勤洗 | 兰亭序 | 亿只张勤洗 |
| 902 | 小仙女 | 武侠音乐系列之缠绵悱恻 （截取版） | 麦振鸿 |
| 903 | Élan | Élan | Nightwish |
| 904 | 美丽的神话Ⅰ(Endless Love 1)-成龙、金喜善 | 神话 电影原声带 | 成龙 / 金喜善 |
| 905 | 下个路口见 （完整版）-藤柒吖 | 下个路口见 | 藤柒吖 |
| 906 | 爱你在心口难开-高胜美 | 怀念老歌七 | 高胜美 |
| 907 | Fengxia Leaves Her Parents-Zhao Jiping | Lifetimes (Vivre!) [Original Motion Picture Soundtrack] | Zhao Jiping |
| 908 | The Hampster Dance Song-Hampton the Hampster | The Hamsterdance Album | Hampton the Hampster |
| 909 | Dans la maison (Thème)-Philippe Rombi | Dans la maison | Philippe Rombi |
| 910 | 一千年以后(A Thousand Years Later)-林俊杰 | 编号89757 | 林俊杰 |
| 911 | 「名探偵コナン」~メインテーマ-大野克夫 | 「名探偵コナン」メインテーマ | 大野克夫 |
| 912 | 万里の長城-太田美知彦 | 中華一番! スペシャルTVオンエアーミックス& ― オリジナル・サウンドトラック | 太田美知彦 |
| 913 | 喜剧之王 | 喜剧之王 | 李荣浩 |
| 914 | Tennessee-Hans Zimmer | Pearl Harbor [O.S.T] | Hans Zimmer |
| 915 | 浮沉的兄弟-戎祥 | 浮沉的兄弟 | 戎祥 |
| 916 | 幸せ（幸福）-小林幸子 | 小林幸子全曲集 2013 | 小林幸子 |
| 917 | Liekkas | Assogattis: By The Embers | Sofia Jannok |
| 918 | 改变自己-王力宏 | 火力全开 (新歌+精选) | 王力宏 |
| 919 | 一生守候-王若琳 | 为爱做的一切 | 王若琳 |
| 920 | 绒花(电影《芳华》片尾曲)-韩红 | 绒花 | 韩红 |
| 921 | 不是因为寂寞才想你-T.R.Y. | 精彩TRY | T.R.Y. |
| 922 | 郎的诱惑-凤凰传奇 | 最炫民族风 | 凤凰传奇 |
| 923 | 我真的受伤了-张学友 | 学友 热 | 张学友 |
| 924 | 我想和你一起去海边-江惠莲 | 伍六七 原声大碟 | 江惠莲 |
| 925 | For the World-谭盾 | Late Night Tales: Air | 谭盾 |
| 926 | Scotland the Brave 苏格兰勇士 | 苏格兰音乐之旅 苏格兰风笛 | 群星 |
| 927 | 月牙湾 | 爱.歌姬 | F.I.R. |
| 928 | Gangsta Bop | Konvicted | Akon |
| 929 | Hallelujah | Warmer In The Winter (Deluxe Edition) | Lindsey Stirling |
| 930 | 夜、萤火虫和你-AniFace | 夜、萤火虫和你 | AniFace |
| 931 | Nijamena (BGM版) | Nijamena | H2s |
| 932 | 兰亭序-Simyee陈芯怡 | 兰亭序（粤语完整版） | Simyee陈芯怡 |
| 933 | 弱水三千-唐伯虎Annie、伯爵Johnny | 弱水三千 | 唐伯虎Annie / 伯爵Johnny |
| 934 | O Come O Come Emmanuel-Tommee Profitt | The Birth Of A King | Tommee Profitt |
| 935 | 二泉映月 | 阿炳全集 | 阿炳 |
| 936 | 男儿当自强 | 笑傲歌坛 传世经典 | 林子祥 |
| 937 | 上海滩 | 上海滩 | 叶丽仪 |
| 938 | 我和你 | 北京2008 奥运会、残奥会开闭幕式主题歌曲专辑 | 刘欢 / Sarah Brightman |
| 939 | 算你狠 | 绝对收藏 | 陈小春 |
| 940 | 黄种人 | 黄·锋 | 谢霆锋 |
| 941 | 时间煮雨(电影《小时代》主题曲)-郁可唯 | 小时代 电影原声带 | 郁可唯 |
| 942 | Croatian Rhapsody | The Piano Player | Maksim Mrvica |
| 943 | He's a Pirate | Pirates of the Caribbean: The Curse of the Black Pearl | Klaus Badelt |
| 944 | Natural-Imagine Dragons | Origins (Deluxe) | Imagine Dragons |
| 945 | 星月神话 | 女人又一次哭泣 | 金莎 |
| 946 | 夜上海 | 夜上海精选 | 周璇 |
| 947 | 带你去旅行 | 带你去旅行 | 校长（张驰） |
| 948 | 天下第一 | 武侠音乐系列之豪气中天 （截取版） | 麦振鸿 / 罗坚 |
| 949 | 飘洋过海来看你-文武贝 | 文武贝钢琴改编作品集（2015年全集） | 文武贝 |
| 950 | 没有你的日子我真的好孤单-韩晶 | 不要用我的爱来伤害我 | 韩晶 |
| 951 | Ordinary Day-Melanie Penn | Wake up Love | Melanie Penn |
| 952 | 给我一个吻-张露 | 群星会 38 张露 (珍藏系列) | 张露 |
| 953 | '97爱情宣言 | 狼 97黄金自选辑 | 齐秦 |
| 954 | 东风破-欧阳耀莹 | 欧阳耀莹 Cover合辑 | 欧阳耀莹 |
| 955 | 外面的世界 | 燃烧爱情（狼之旅） | 齐秦 |
| 956 | 兄弟情谊-赵季平 | 水浒传 原声音乐 | 赵季平 |
| 957 | 小酒窝 | JJ陆 | 林俊杰 / 蔡卓妍 |
| 958 | Past Lives | Drowning | Slushii |
| 959 | 往事随风 | 痛并快乐着 | 齐秦 |
| 960 | Go Time | Go Time | Mark Petrie |
| 961 | Only Love(电视剧《妙手仁心 II》插曲)-Trademark | #Love | Trademark |
| 962 | 日不落-蔡依林 | 特务J - (Agent J) | 蔡依林 |
| 963 | 西部猎人-李浩瑞 | 西部猎人 | 李浩瑞 |
| 964 | 春不晚（with 冰洁）-郑浩、冰洁 | 须尽欢（Deluxe） | 郑浩 / 冰洁 |
| 965 | 晚秋-毛宁 | 晚秋 | 毛宁 |
| 966 | 难念的经(1997年TVB版电视剧《天龙八部》片头曲)-周华健 | 电视剧歌曲大全 | 周华健 |
| 967 | 李香兰-张学友 | Jacky Cheung 15 | 张学友 |
| 968 | Someone to Stay | Someone to Stay | Vancouver Sleep Clinic |
| 969 | The Portrait | Titanic: Special Edition | James Horner |
| 970 | 有你的快乐(原曲：Lost in Paradise)-王若琳 | Start From Here | 王若琳 |
| 971 | 晚秋 (粤语女声版)-赵十三 | 晚秋（粤语女声版） | 赵十三 |
| 972 | 我记得你眼里的依恋-孙建平、Sweet Style | 音乐磁场10 | 孙建平 & Sweet Style |
| 973 | 霜雪千年 (官方重置版)-洛天依Official、乐正绫 | 霜雪千年 (官方重置版) | 洛天依Official / 乐正绫 |
| 974 | 看见-陈鸿宇、游戏科学、8082Audio | 《黑神话：悟空》游戏音乐精选集 | 陈鸿宇 / 游戏科学 / 8082Audio |
| 975 | 假如爱有天意-李健 | 李健 | 李健 |
| 976 | 那年我双手插兜 不知道什么叫做对手 | 那年我双手插兜 不知道什么叫做对手（语录版） | 黑左 / 莎馬淑鳐 / 刘liu创意人 |
| 977 | Cute Pinch(PHONK)(将军进行曲)-BOY、刘艺诚、KKK | Cute Pinch(PHONK) | BOY / 刘艺诚 / KKK |
| 978 | 你还欠我一个拥抱 | 很有爱 | 后弦 / Sara |
| 979 | Strength of a Thousand Men | Archangel | Two Steps From Hell |
| 980 | 匆匆那年 | 匆匆那年 电影原声带 | 王菲 |
| 981 | 外婆的澎湖湾-蔡琴 | 爱像一首歌 | 蔡琴 |
| 982 | 莫问归期-蒋雪儿、七叔（叶泽浩） | 莫问归期 | 蒋雪儿 / 七叔（叶泽浩） |
| 983 | 说好的幸福呢-周杰伦 | 魔杰座 | 周杰伦 |
| 984 | 存在-雷婷 | 存在 | 雷婷 |
| 985 | 麻雀-李荣浩 | 麻雀 | 李荣浩 |
| 986 | Perfect-Ed Sheeran | ÷ (Deluxe) | Ed Sheeran |
| 987 | 一路 | 匆匆那年 电视原声带 | 白敬亭 / 杨玏 / 杜维瀚 |
| 988 | Spirit of the Wild | Age of Wonders | BrunuhVille |
| 989 | 命运 운명 | 풀 하우스 OST (KBS 미니시리즈) | Why |
| 990 | 青い空に出逢えた(TV Mix) | 中華一番! スペシャルTVオンエアーミックス& ― オリジナル・サウンドトラック | 辻尾有紗 |
| 991 | 大海~ | Asia | THE JAYWALK |
| 992 | 最后一页(电视剧《熊猫人》片尾曲)-江语晨 | 恋习 | 江语晨 |
| 993 | 男人海洋-周传雄 | 男人.海洋 | 周传雄 |
| 994 | 贝加尔湖畔-李健 | 依然 | 李健 |
| 995 | 映山红-韩红 | 红歌② | 韩红 |
| 996 | 热爱105°C的你 | 热爱105°C的你 | 阿肆 |
| 997 | Flavor Of Life | Flavor Of Life | 宇多田ヒカル |
| 998 | 百鸟朝凤(唢呐)-任同祥 | 大师・管子 唢呐 | 任同祥 |
| 999 | 花田错-王力宏 | 盖世英雄 | 王力宏 |
| 1000 | 披着羊皮的狼-刀郎 | 披着羊皮的狼 | 刀郎 |
| 1001 | 我的未来不是梦-张雨生 | 6个朋友 | 张雨生 |
| 1002 | 阳光宅男-周杰伦 | 我很忙 | 周杰伦 |
| 1003 | 我们的纪念-弦子 | 我们的纪念 | 弦子 |
| 1004 | Death Of Titanic | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 1005 | Lordly (Instrumental Mix)-Feder | Lordly (Instrumental Mix) | Feder |
| 1006 | 最浪漫的事-赵咏华 | 我的爱我的梦我的家 | 赵咏华 |
| 1007 | 最近比较烦 (Live)-周华健、李宗盛、任贤齐 | 未知 | 周华健、李宗盛、任贤齐 |
| 1008 | 孤勇者_凤凰传奇 | 孤勇者 | 凤凰传奇 |
| 1009 | 不见不散(电影《不见不散》主题曲)-孙楠 | 楠得精选 | 孙楠 |
| 1010 | A Fool In Love-Jimmy Barnes | The Rhythm And The Blues | Jimmy Barnes |
| 1011 | 塞上曲-方锦龙 | 方锦龙十面埋伏 | 方锦龙 |
| 1012 | 不如不见 | What's Going On…? | 陈奕迅 |
| 1013 | Distant Memories | Titanic: Music from the Motion Picture Soundtrack | James Horner |
| 1014 | 偏爱 | 破天荒 | 张芸京 |
| 1015 | 爱的代价(The Price of Love 电影《念念》首波宣传曲)-张艾嘉 | 爱的代价 | 张艾嘉 |
| 1016 | 大侠霍元甲(电视剧《大侠霍元甲》主题曲)-叶振棠 | 叶振棠精选全集(珍藏版) | 叶振棠 |
| 1017 | 我们的纪念-徐薇 | 我们的纪念 | 徐薇 |
| 1018 | Diamonds | Diamonds | Rihanna |
| 1019 | 風の住む街（风居住的街道）-磯村由紀子 | 風の住む街 | 磯村由紀子 |
| 1020 | 另一个天堂-王力宏、张靓颖 | 火力全开 (新歌+精选) | 王力宏 / 张靓颖 |
| 1021 | 还有我-任贤齐 | 如果没有你 | 任贤齐 |
| 1022 | 太多(电视剧《穿越时空的爱恋》片头曲)-陈冠蒲 | 就让你走 | 陈冠蒲 |
| 1023 | 绅士-薛之谦 | 绅士 | 薛之谦 |
| 1024 | Je m'appelle Hélène | Hélène | Hélène Rolles |
| 1025 | 我欲成仙 | 西游记后传片头曲 | 刘欢 |
| 1026 | 阿普的思念(写给爷爷的歌)-诺米么Lodmemo | risingstar12.6 | 诺米么Lodmemo |
| 1027 | 新套马杆-乌兰托娅 | 新套马杆 | 乌兰托娅 |
| 1028 | 雨蝶-李翊君 | 誓言谎言 | 李翊君 |
| 1029 | 牵丝戏-银临、Aki阿杰 | 牵丝戏 | 银临 / Aki阿杰 |
| 1030 | 水手+上海滩+热情的沙漠+蓝精灵+辣妹子+啊朋友再见-黄渤、庾澄庆 | 2016极限挑战公益联欢会现场 | 黄渤 / 庾澄庆 |
| 1031 | 希望 (国语) | 我是阳光的 | 陈慧琳 |
| 1032 | 双截棍-周杰伦 | 范特西 | 周杰伦 |
| 1033 | 我想当风(电影《抓娃娃》片尾曲)-鹿先森乐队 | 我想当风 | 鹿先森乐队 |
| 1034 | Something Just Like This | Something Just Like This | The Chainsmokers / Coldplay |
| 1035 | Ldeal Realm（Ideal situation）-大乔木子 | Ldeal Realm | 大乔木子 |
| 1036 | 暖暖 (香皂泡DJ版)-香皂泡 | 暖暖 | 香皂泡 |
| 1037 | 探故知-浅影阿、汐音社 | 探故知 | 浅影阿 / 汐音社 |
| 1038 | 玫瑰花的葬礼-许嵩 | 许嵩单曲集 | 许嵩 |
| 1039 | 旅行-许巍 | 每一刻都是崭新的 | 许巍 |
| 1040 | 花海-周杰伦 | 魔杰座 | 周杰伦 |
| 1041 | Children of the Dark | Together Till the End | Mono Inc. / Joachim Witt / Tilo Wolff / Chris Harms |
| 1042 | 極楽浄土 | 約束 -Promise code- | GARNiDELiA |
| 1043 | 一次就好-杨宗纬 | 夏洛特烦恼 电影原声带 | 杨宗纬 |
| 1044 | 唯一-G.E.M.邓紫棋 | T.I.M.E. | G.E.M.邓紫棋 |
| 1045 | 作曲家 | 李荣浩 | 李荣浩 |
| 1046 | 高山流水 (古筝独奏)-华夏民族乐团 | 古筝古琴十大金曲01 (10首) | 华夏民族乐团 |
| 1047 | 辞九门回忆(DJ版) | 未知 | 未知 |
| 1048 | 当爱已成往事(电影《霸王别姬》主题曲)-林忆莲、李宗盛 | 我们的主打歌 | 林忆莲 / 李宗盛 |
| 1049 | 黑色幽默-周杰伦 | Jay | 周杰伦 |
| 1050 | 须尽欢(正式授权版)-要不要买菜 | 须尽欢 | 要不要买菜 |
| 1051 | 盗将行-花粥、马雨阳 | 粥请客（二） | 花粥 / 马雨阳 |
| 1052 | 诺言 (正式版)-海来阿木 | 诺言 (正式版) | 海来阿木 |
| 1053 | Maga-Such a Whore（Maga remix）-Maga | Such a Whore | Maga |
| 1054 | 闯将令-香港中乐团 于会咏 胡登跳 | 功夫 电影原声大碟 | 香港中乐团 / 于会咏 / 胡登跳 |
| 1055 | 黑暗中的舞者 | 寂静的天空 | 黛青塔娜 / HAYA乐团 |
| 1056 | 北京东路的日子-汪源、刘千楚、徐逸昊、鲁天舒、姜玮珉、胡梦原、张鎏依、梁竞元、游彧涵、金书援、许一璇、张夙西 | 北京东路的日子 | 汪源 / 刘千楚 / 徐逸昊 / 鲁天舒 / 姜玮珉 / 胡梦原 / 张鎏依 / 梁竞元 / 游彧涵 / 金书援 / 许一璇 / 张夙西 |
| 1057 | 亲爱的旅人啊-周深 | 亲爱的旅人啊《千与千寻》（Cover 木村弓） | 周深 |
| 1058 | 銀の龍の背に乗って | 銀の龍の背に乗って | 中島みゆき |
| 1059 | She Is My Sin-Nightwish | Tales from the Elvenpath | Nightwish |
| 1060 | To Ramona | The Complete Album Collection Vol.1 | Bob Dylan |
| 1061 | Azul | Acoustik Guitar | John H. Clarke |
| 1062 | 痴情冢（完整版）-吴严武 | 痴情冢（完整版） | 吴严武 |
| 1063 | Opening | 少林足球 电影原声带 | 黄英华 |
| 1064 | 思念是一种病 (Live)-薛凯琪、潘玮柏 | 音你而来 第2期 | 薛凯琪 / 潘玮柏 |
| 1065 | Natural-Imagine Dragons | Origins (Deluxe) | Imagine Dragons |
| 1066 | Feel Me-Selena Gomez | Feel Me | Selena Gomez |
| 1067 | 安和桥(女生版)-白允y | 安和桥 | 白允y |
| 1068 | Hummell Gets The Rockets | The Rock (Original Motion Picture Score) | Nick Glennie-Smith /Harry Gregson-Williams |
| 1069 | 把悲伤留给自己-赵传 | 滚石香港黄金十年 赵传精选 | 赵传 |
| 1070 | La Disparition(消陨)-Keren Ann | La Disparition | Keren Ann |
| 1071 | 在水一方-邓丽君 | 在水一方 | 邓丽君 |
| 1072 | 星の下での邂逅-赵大鼾 | 星の下での邂逅 | 赵大鼾 |
| 1073 | Impossible-Two Steps From Hell | Unleashed | Two Steps From Hell |
| 1074 | 爱是你我(Live)-徐子尧、刀郎 | 爱是你我 | 徐子尧、刀郎 |
| 1075 | Love From Me-Johnson Rodgie | Love From Me | Johnson Rodgie |
| 1076 | 猜不透 | 我爱上的 | 丁当 |
| 1077 | Samba-Ludovico Einaudi | I Giorni | Ludovico Einaudi |
| 1078 | Håll Om Mig-Nanne Grönvall | Melodifestivalen 1958-2013 | Nanne Grönvall |
| 1079 | 难却 | 难却 | 平生不晚 |
| 1080 | Until You-Shayne Ward | Breathless | Shayne Ward |
| 1081 | 梦醒时分-杨钰莹 | 我有一段情 | 杨钰莹 |
| 1082 | 王招君 (你看你拉住我的模样)(《寻汉计》电影推广曲)-任素汐 | 王招君 (你看你拉住我的模样) | 任素汐 |
| 1083 | Old Threads-Deep East Music | Vintage Sunshine | Deep East Music |
| 1084 | 凉凉-杨宗纬、张碧晨 | 三生三世十里桃花 电视剧原声专辑 | 杨宗纬 / 张碧晨 |
| 1085 | 外婆的澎湖湾-黑鸭子 | 青春之歌 | 黑鸭子 |
| 1086 | 甜甜的-周杰伦 | 我很忙 | 周杰伦 |
| 1087 | Not Angry-Chris James | Not Angry | Chris James |
| 1088 | 萤火之森-CMJ | 萤火之森 | CMJ |
| 1089 | 万疆-李玉刚 | 万疆 | 李玉刚 |
| 1090 | 日不落(温柔抒情版)-藤柒吖 | 日不落 | 藤柒吖 |
| 1091 | 友谊天长地久-杨钰莹、毛宁 | 快乐时光（12）世界名歌精选（一） | 杨钰莹 / 毛宁 |
| 1092 | 珊瑚海-周杰伦、Lara梁心颐 | 十一月的萧邦 | 周杰伦 / Lara梁心颐 |
| 1093 | Lonely Dance-Vexento | Soul Lifting Melodic Tracks | Vexento |
| 1094 | 土坡上的狗尾草-卢润泽 | 土坡上的狗尾巴草 | 卢润泽 |
| 1095 | Closer-The Chainsmokers、Halsey | Closer | The Chainsmokers / Halsey |
| 1096 | 游山恋·2024-游戈、哦漏、听潮阁 | 游山恋·2024 | 游戈 / 哦漏 / 听潮阁 |
| 1097 | 慢慢喜欢你-莫文蔚 | 我们在中场相遇 | 莫文蔚 |
| 1098 | Opening Credits-Hans Zimmer | Call of Duty: Modern Warfare 2 OST | Hans Zimmer |
| 1099 | 青花瓷-Simyee陈芯怡 | 青花瓷 (粤语版) | Simyee陈芯怡 |
| 1100 | 茉莉花(江苏民歌)-龚琳娜 | 走西口 | 龚琳娜 |
| 1101 | 沈园外 (DJ版)-阿YueYue、戾格、小田音乐社 | 沈园外 | 阿YueYue / 戾格 / 小田音乐社 |
| 1102 | 棉花糖-至上励合 | 降临 | 至上励合 |
| 1103 | Samsara-Tungevaag & Raaban | Club Sounds Vol.73 | Tungevaag & Raaban |
| 1104 | WakeJHONK(生于华夏)-Klee | WAKE | Klee |
| 1105 | 爱情睡醒了-袁成杰 | 爱情睡醒了 电视原声 | 袁成杰 |
| 1106 | 鞋儿破帽儿破-游本昌 | 济公 电视原声带 | 游本昌 |
| 1107 | 外面的世界-莫文蔚 | 回蔚 | 莫文蔚 |
| 1108 | Dream-Priscilla Ahn | A Good Day | Priscilla Ahn |
| 1109 | 今天你要嫁给我(Marry Me Today)-蔡依林、陶喆 | 太美丽 | 蔡依林 / 陶喆 |
| 1110 | The X-Files (Original Version)-Mark Snow | The X Files? | Mark Snow |
| 1111 | 蓝色土耳其-周传雄 | 蓝色土耳其 | 周传雄 |
| 1112 | BOOM-Tiësto / Sevenn | BOOM | Tiësto / Sevenn |
| 1113 | 初识太极 | 太极张三丰 电影原声带 | 胡伟立 |
| 1114 | At Anchor | The Airship | Port Blue |
| 1115 | 7 Years-MADILYN、Josh Evans | 7 Years | MADILYN / Josh Evans |
| 1116 | 霜雪千年-浅影阿 | 霜雪千年 | 浅影阿 |
| 1117 | 以父之名-周杰伦 | 叶惠美 | 周杰伦 |
| 1118 | 愿得一人心-李行亮 | 愿得一人心 | 李行亮 |
| 1119 | 青花-周传雄 | 蓝色土耳其 | 周传雄 |
| 1120 | 难却 (DJ版0.85x|待上浓妆好戏开场) | 难却 | 平生不晚 |
| 1121 | 我落泪情绪零碎-周杰伦 | 跨时代 | 周杰伦 |
| 1122 | 同桌的你(电影《同桌的你》片尾主题曲)-胡夏 | 同桌的你 | 胡夏 |
| 1123 | 悬溺-葛东琪 | 第二街区 | 葛东琪 |
| 1124 | 最近比较烦-李宗盛、周华健、品冠 | 作品李宗盛 | 李宗盛 / 周华健 / 品冠 |
| 1125 | 我要你(电影《驴得水》主题曲)-任素汐 | 我要你 | 任素汐 |
| 1126 | 追梦人(The Dream Chaser)-王若琳 | 午夜剧院 | 王若琳 |
| 1127 | 最近比较烦-沈腾、马丽、常远、黄才伦 | 最近比较烦 | 沈腾 /马丽 / 常远 / 黄才伦 |
| 1128 | 遇上你是我的缘-央金兰泽 | 爱琴海 | 央金兰泽 |
| 1129 | Special Ops-Silver Screen | Under Siege | Silver Screen |
| 1130 | Frontier-Doctor Vox | Level Up | Doctor Vox |
| 1131 | 芦苇飞（哈市DJ小鹏2024）-泡芙芙Scarlett | 芦苇飞（哈市DJ小鹏2024） | 泡芙芙Scarlett |
| 1132 | Electric Romeo | Themes for Orchestra and Choir 2 - Abbey Road | Immediate Music |
| 1133 | 賭神 | 赌神 电影原声 | 卢冠廷 |
| 1134 | 那盏茶 (新编版)-金志文 | 那盏茶 (新编版) | 金志文 |
| 1135 | 下雨天-南拳妈妈 | 优の良曲 南搞小孩 | 南拳妈妈 |
| 1136 | 姑娘别哭泣（弹唱版）-柯柯柯啊 | 姑娘别哭泣 | 柯柯柯啊 |
| 1137 | 美酒加咖啡-邓丽君 | 花样年华 | 邓丽君 |
| 1138 | 真心英雄 (Live)-纵贯线 | Live in Taipei 出发/终点站 | 纵贯线 |
| 1139 | 秘密-卡洛儿 | 秘密 | 卡洛儿 |
| 1140 | 不潮不用花钱(High Fashion)-林俊杰 | JJ陆 | 林俊杰 |
| 1141 | Time (Official)-MKJ | Time After Time | MKJ |
| 1142 | 琴师-音频怪物 | 老妖的奇异之旅 | 音频怪物 |
| 1143 | 我的地盘-周杰伦 | 七里香 | 周杰伦 |
| 1144 | 但愿人长久-邓丽君 | 但愿人长久 15周年纪念集 | 邓丽君 |
| 1145 | The Next Episode | The Next Episode | Dr. Dre / Snoop Dogg / Kurupt / Nate Dogg |
| 1146 | 会呼吸的痛-梁静茹 | 崇拜 | 梁静茹 |
| 1147 | 纸短情长 (完整版)-烟把儿 | 纸短情长 | 烟把儿 |
| 1148 | 你潇洒我漂亮-韩宝仪 | 台湾福建 畅销金曲沙龙镭射效果音乐 | 韩宝仪 |
| 1149 | 驼铃-刀郎 | 披着羊皮的狼 | 刀郎 |
| 1150 | 爱要坦荡荡 (Live)-丁丁 | 《中国好声音》2012跨年演唱会 | 丁丁 |
| 1151 | Italia e voi（Orginal Mix）-HSHK | Italia e voi | HSHK / 贰皮 / VodKa / Pnan |
| 1152 | かごめと犬夜叉 | TVアニメーション「犬夜叉」オリジナルサウンドトラックアルバム「犬夜叉 音楽篇」 | 和田薫 |
| 1153 | Rather Be(宁愿)-Clean Bandit、Jess Glynne | Rather Be | Clean Bandit / Jess Glynne |
| 1154 | 琵琶语-林海 | 林海影视配乐精选 | 林海 |
| 1155 | 비오는 소리 (Intro)下雨的声音-July | To Heaven | July |
| 1156 | 北国之春-邓丽君 | 邓丽君 纪念特别专辑 第二辑 | 邓丽君 |
| 1157 | アシタカせっ記 (The Legend of Ashitaka)-久石让 | もののけ姫 イメージアルバム | 久石让 (ひさいし じょう) |
| 1158 | Pretty Boy-M2M | Love 101 (Singapore) | M2M |
| 1159 | 烽烟情焰(电视剧《燃烧岁月》插曲)-蔡国权 | 创作我的歌32首 | 蔡国权 |
| 1160 | Past Lives-Jasper、Martin Arteta | Past Lives | Jasper / Martin Arteta / 11:11 Music Group |
| 1161 | 我们的爱-F.I.R. | 同名专辑 | F.I.R. |
| 1162 | K歌之王-陈奕迅 | 打得火热 | 陈奕迅 |
| 1163 | Winter Without You-Gloria Kim | Winter Without You | Gloria Kim |
| 1164 | 泪桥-伍佰 | 泪桥 | 伍佰 & China Blue |
| 1165 | 喀什噶尔胡杨-刀郎 | 喀什噶尔胡杨 | 刀郎 |
| 1166 | 成全(电视剧《梦想成真》片头曲)-刘若英 | 年华 | 刘若英 |
| 1167 | Run Me Out-Zola Jesus | How to Get Away with Murder | Zola Jesus |
| 1168 | Pilgrimage-Jannik | Pilgrimage Epic Orchestral | Jannik |
| 1169 | 青花瓷 | 再醉一次.精选二 | 刘芳 |
| 1170 | 情人-刀郎 | 2002年的第一场雪 | 刀郎 |
| 1171 | 云宫迅音（Black Myth：WuKong）-游戏科学 | 黑神话：悟空（Black Myth：WuKong） | 游戏科学 |
| 1172 | We No Speak Americano(UK Radio Edit)-Yolanda Be Cool | We No Speak Americano | Yolanda Be Cool |
| 1173 | 春不晚 (相思版)-闻人听書_ | 春不晚 | 闻人听書_ |
| 1174 | 门楼-赵季平 | 大宅门 音乐专辑 | 赵季平 |
| 1175 | 如愿(电影《我和我的父辈》主题推广曲)-王菲 | 如愿 | 王菲 |
| 1176 | 探窗-国风新语、浮生梦、汐音社 | 探窗 | 国风新语 / 浮生梦 / 汐音社 |
| 1177 | 传奇-李健 | 似水流年 | 李健 |
| 1178 | 壁上观-邓寓君(等什么君) | 壁上观 | 邓寓君(等什么君) |
| 1179 | 龙的传人-王力宏 | Evolution 王力宏的音乐进化论 '95-'02 新歌+精选 | 王力宏 |
| 1180 | 百鸟朝凤-中央民族乐团 | 虎年春节中国民族音乐会 | 中央民族乐团 |
| 1181 | I Want It That Way-Backstreet Boys | Playlist: The Very Best Of Backstreet Boys | Backstreet Boys |
| 1182 | 半生雪 (学生版)-村里的孩儿 | 半生雪 (学生版) | 村里的孩儿 |
| 1183 | The Rose(1979/米 映画「ローズ」より)-手嶌葵 | The Rose ～I Love Cinemas～ | 手嶌葵 |
| 1184 | 一眼万年(Forever 电视剧《爱情睡醒了》原声带)-林俊杰 | 她说 概念自选辑 | 林俊杰 |
| 1185 | 外婆的澎湖湾-刘文正 | 阿美!阿美! | 刘文正 |
| 1186 | 忽然之间-莫文蔚 | 就是 莫文蔚 | 莫文蔚 |
| 1187 | 桔梗谣-卢爱兰 | 朝鲜族民歌 《桔梗谣 . 道拉基》中国音乐地图 听见吉林 | 卢爱兰 |
| 1188 | 爱的飞行日记-周杰伦、杨瑞代 | 跨时代 | 周杰伦 / 杨瑞代 |
| 1189 | Just the Way You Are-Bruno Mars | The Brit Awards Album 2011 | Bruno Mars |
| 1190 | 关山月-路南 | 关山月 | 路南 |
| 1191 | 那盏茶-金志文 | 热门华语149 | 金志文 |
| 1192 | 荷塘月色-凤凰传奇 | 我从草原来 新歌+精选 | 凤凰传奇 |
| 1193 | 芦苇荡(电影《大话西游》插曲)-赵季平 | 热门华语20 | 赵季平 |
| 1194 | 友谊天长地久-黑鸭子 | 伴你二十年特辑 黑鸭子圣诞经典 | 黑鸭子 |
| 1195 | Deflagration-Silver Screen | Under Siege | Silver Screen |
| 1196 | The Boys | 'The Boys' The 3rd Album | 少女时代 |
| 1197 | 万物生 (国语)-萨顶顶 | 万物生 | 萨顶顶 |
| 1198 | 我用什么把你留住-福禄寿FloruitShow | 我用什么把你留住 | 福禄寿FloruitShow |
| 1199 | 一首简单的歌(《巴黎恋人》)-王力宏 | 婚礼歌手：幸福情歌精选 | 王力宏 |
| 1200 | 大城小爱-王力宏 | 盖世英雄 | 王力宏 |
| 1201 | Gimme（Reset）-人面兽心、花凯 | Gimme（Reset） | 人面兽心 / 花凯 |
| 1202 | 春不晚-李常超 (Lao乾妈) | 春不晚 | 李常超 (Lao乾妈) |
| 1203 | 退后-周杰伦 | 依然范特西 | 周杰伦 |
| 1204 | 黄金甲-周杰伦 | 黄金甲 | 周杰伦 |
| 1205 | 须尽欢(热播女声版)-糯米Nomi、余子林 | 须尽欢 | 糯米Nomi / 余子林 |
| 1206 | 弱水三千 (0.9x版)-阮言Ruany | 弱水三千 | 阮言Ruany |
| 1207 | What Do You Mean?-Justin Bieber | What Do You Mean? | Justin Bieber |
| 1208 | Wicked Wonderland (Radio Edit)-Martin Tungevaag | Wicked Wonderland | Martin Tungevaag |
| 1209 | 幽默-胡伟立 | 九品芝麻官之白面包青天 电影原声 | 胡伟立 |
| 1210 | 春风十里不如你(电视剧 《春风十里不如你》同名主题曲)-李健 | 春风十里不如你 | 李健 |
| 1211 | 谁家-池鱼 | 谁家 | 池鱼 |
| 1212 | 半岛铁盒-周杰伦 | 八度空间 | 周杰伦 |
| 1213 | 不将就(电影《何以笙箫默》片尾主题曲)-李荣浩 | 有理想 | 李荣浩 |
| 1214 | Alone-Alan Walker | Alone | Alan Walker |
| 1215 | Time Back-Bad Style | 最新热歌慢摇63 | Bad Style |
| 1216 | Numb Encore | Look Out For Detox | Dr. Dre / 50 Cent / JAY-Z / Eminem / Linkin Park |
| 1217 | Star Sky-Two Steps From Hell | Battlecry | Two Steps From Hell |
| 1218 | Oceanside | Melody Lane | Lainey Lou |
| 1219 | One Day In Spring | One Day In Spring | Bandari |
| 1220 | 明明就-周杰伦 | 十二新作 | 周杰伦 |
| 1221 | Deadwood-Really Slow Motion | Deadwood | Really Slow Motion |
| 1222 | Promises | Promises | Ryn Weaver |
| 1223 | 我知道-By2 | Twins | By2 |
| 1224 | Between Worlds | X I I | Roger Subirana |
| 1225 | Dream It Possible | Dream It Possible | Delacey |
| 1226 | 桔梗谣-金栄実 | 伽倻琴演奏《与你一起》 | 金栄実 |
| 1227 | 桔梗谣-이금미 | Korea: Folk Songs I - Songs Of Kyonggido District | 이금미 |
| 1228 | Simon Birch | The Bucket List (Original Motion Picture Soundtrack) | Marc Shaiman |
| 1229 | Firework | Teenage Dream | Katy Perry |
| 1230 | Everything at Once | Two | Lenka |
| 1231 | 口弦-妙子 | 独家爱唱Ⅲ | 妙子 |
| 1232 | 可能否-腾格尔 | 可能否 | 腾格尔 |
| 1233 | Murder In My Mind-Kordhell | Murder In My Mind | Kordhell |
| 1234 | 岁月神偷-金玟岐 | 完美世界 | 金玟岐 |
| 1235 | 历史的天空(电视连续剧《三国演义》片尾曲)-毛阿敏 | 天之大 | 毛阿敏 |
| 1236 | 渔舟唱晚-中国中央交响乐团 | 龙之吟—中国管弦乐纪念名盘 | 中国中央交响乐团 |
| 1237 | 秦颂(The Emperor's Song / 电影《秦颂》片尾曲)-赵季平 | 秦颂 | 赵季平 |
| 1238 | 敢问路在何方（黑神话：悟空）-黑神话：悟空、Benjamin·Scott、杨洪基 | 《黑神话：悟空》游戏原声带 | 黑神话：悟空 / Benjamin·Scott / 杨洪基 |
| 1239 | 一千个伤心的理由-张学友 | 刻骨铭心 | 张学友 |
| 1240 | 在你的身边 (0.8x)-慢热的气球 | 在你的身边 (0.8x) | 慢热的气球 |
| 1241 | Once Upon a Time in America: Deborah's Theme-Ennio Morricone | The Grandmaster (Original Score) | Ennio Morricone |
| 1242 | 童年 (童声版)-宋小睿 | 宋小睿的电台 | 宋小睿 |
| 1243 | Morsmordre-Crazy Donkey | Morsmordre | Crazy Donkey |
| 1244 | 旅行的意义(TRAVEL IS MEANINGFUL) | 渺渺 电影原声 | 陈绮贞 |
| 1245 | 空 (TV Mix) | 中華一番! スペシャルTVオンエアーミックス& ― オリジナル・サウンドトラック | 大黒摩季 |
| 1246 | 模特 | 模特 | 李荣浩 |
| 1247 | FourFiveSeconds | FourFiveSeconds | Rihanna / Kanye West / Paul McCartney |
| 1248 | Psycho, Pt. 2-Russ | Psycho, Pt. 2 | Russ |
| 1249 | Anacreon-Bear McCreary | Foundation: Season 1 (Apple TV+ Original Series Soundtrack) | Bear McCreary |
| 1250 | 纪念-银木铃子 | 高考应援曲 高考加油 | 银木铃子 |
| 1251 | 风居住的街道（Piano ver） (翻自 磯村由紀子）-饭碗的彼岸 | Piano Cover | 饭碗的彼岸 |
| 1252 | 爱转角 | Best Show | 罗志祥 |
| 1253 | New Soul-Renee、Jeremy | A Little Love | Renee & Jeremy |
| 1254 | 再回首-郝蕾 | 再回首 | 郝蕾 |
| 1255 | 须尽欢 (0.8x)-郑浩 | 须尽欢 | 郑浩 |
| 1256 | Sing You To Sleep-Matt Cab | Sing You To Sleep | Matt Cab |
| 1257 | 我真的受伤了(电影《Delete爱人》插曲)-王菀之 | Audiophile Compilations | 王菀之 |
| 1258 | Like That-Bea Miller | Chapter Two: Red | Bea Miller |
| 1259 | 栀子花开(电影《栀子花开》主题曲)-何炅 | 可以爱 | 何炅 |
| 1260 | Pure Ocean-Jamvana | Pure Ocean | Jamvana |
| 1261 | Take Me Home Country Roads-John Denver | Take Me Home: The John Denver Story | John Denver |
| 1262 | 江湖笑(张纪中版《神雕侠侣》片尾曲)-周华健 | 雨人 | 周华健 |
| 1263 | Maps | Maps | Maroon 5 |
| 1264 | 不完整的旋律-王力宏 | 改变自己 | 王力宏 |
| 1265 | Champions(冠军)-Jonathan Buchanan | Urban Strings & Beats | Jonathan Buchanan |
| 1266 | 倒数-G.E.M.邓紫棋 | 另一个童话 | G.E.M.邓紫棋 |
| 1267 | 寂寞沙洲冷-周传雄 | 星空下的传说 | 周传雄 |
| 1268 | One Match-Sarah Harmer | oh little fire | Sarah Harmer |
| 1269 | 半生雪-七叔-叶泽浩 | 半生雪 | 七叔-叶泽浩 |
| 1270 | MR.TAXI(Korean ver.) | 'The Boys' The 3rd Album | 少女时代 |
| 1271 | Gentle-Isaac Shepard | Deep Joy | Isaac Shepard |
| 1272 | 故人泪-麦小兜 | 故人泪 | 麦小兜 |
| 1273 | May It Be-Bandari | MistyLand | Bandari |
| 1274 | Whatcha Reckon-Josh Turner | Punching Bag (Deluxe Edition) | Josh Turner |
| 1275 | 龙拳-周杰伦 | 八度空间 | 周杰伦 |
| 1276 | 秘密-王珺 | 一尘不染 | 王珺 |
| 1277 | 赤伶-李玉刚 | 赤伶 | 李玉刚 |
| 1278 | My Songs Know What You Did In The Dark (Light Em Up) (2 Chainz Remix) | My Songs Know What You Did In The Dark (Light Em Up) | Fall Out Boy |
| 1279 | 一生最爱的人-伍佰 | 白鸽 | 伍佰 & China Blue |
| 1280 | Emerald-Ariel | Elan | Ariel |
| 1281 | River Flows In You | Tales Of Dusk And Dawn Chapter II | Various Artists |
| 1282 | Roar | Roar | Katy Perry |
| 1283 | 水手-郑智化 | 私房歌 | 郑智化 |
| 1284 | Don't Wanna Know-Maroon 5 | BRIT Awards 2017 | Maroon 5 |
| 1285 | 同桌的你-老狼 | 龙凤金歌榜 | 老狼 |
| 1286 | Just Blue-Space | Just Blue | Space |
| 1287 | Secrets AMFB Onerepublic | Time Machine (Part 1) | Bryson Andres |
| 1288 | 止战之殇-周杰伦 | 七里香 | 周杰伦 |
| 1289 | 弱水三千 (阮言版) | 弱水三千 (阮言版) | 阮言Ruany |
| 1290 | 当爱成了往事(电视剧《当爱已成往事》片尾曲)-郝蕾 | 当爱已成往事 | 郝蕾 |
| 1291 | 一路向北-周杰伦 | J III MP3 Player | 周杰伦 |
| 1292 | 纸短情长-花粥 | 纸短情长 | 花粥 |
| 1293 | Sign-DEAMN | Sign | DEAMN |
| 1294 | 当爱已成往事-张国荣 | 最红 | 张国荣 |
| 1295 | Titanium-David Guetta / Sia | Best Of... | David Guetta / Sia |
| 1296 | The Telephone Box | The Magic Empire | Uniform Motion |
| 1297 | 探故知 (DJlucky小阳版)-浅影阿 | 探故知 | 浅影阿 |
| 1298 | 在你的身边-盛哲 | 在你的身边 | 盛哲 |
| 1299 | Why-Sabrina Carpenter | Why | Sabrina Carpenter |
| 1300 | Sunrise | waiting for the light | Catie Mckinney |
| 1301 | Walk on By-Noosa | Wonderland | Noosa |
| 1302 | 春庭雪-邓寓君(等什么君) | 春庭雪 | 邓寓君(等什么君) |
| 1303 | Shiver-skel | Shiver | skel |
| 1304 | 映山红-刀郎 | 红色经典 | 刀郎 |
| 1305 | Liberators-Epic Score | Vengeance - ES033 | Epic Score |
| 1306 | Dismantle-Peter Sandberg | Dismantle | Peter Sandberg |
| 1307 | 小宇-张震岳 | OK | 张震岳 |
| 1308 | 彩虹-周杰伦 | 我很忙 | 周杰伦 |
| 1309 | Older-Sasha Alex Sloan | Older | Sasha Alex Sloan |
| 1310 | 落叶归根-王力宏 | 力宏二十 二十周年唯一精选 | 王力宏 |
| 1311 | Radius-Hi-Finesse | Axiom | Hi-Finesse |
| 1312 | The Final Countdown | The Final Countdown: The Best Of Europe | Europe |
| 1313 | 世界第一等-刘德华 | 爱在刻骨铭心时 | 刘德华 |
| 1314 | 春庭雪（0.8x_DJ小瑞） | 春庭雪 | 小瑞 |
| 1315 | 友谊天长地久-亚洲天使童声合唱团 | 天使在唱歌 | 亚洲天使童声合唱团 |
| 1316 | 上海滩(无线电视剧《上海滩》主题曲) | 上海滩 | 叶丽仪 |
| 1317 | Hyacinth-July | In Love | July |
| 1318 | 我们的纪念-徐薇 | 我们的纪念 | 徐薇 |
| 1319 | 遺憾-陈洁仪 | 重譯 陳潔儀.重奏 | 陈洁仪 |
| 1320 | 须尽欢-郑浩 | 须尽欢 | 郑浩 |
| 1321 | So Far Away(遥不可及) | So Far Away | Martin Garrix / David Guetta / Jamie Scott / Romy Dya |
| 1322 | 恋曲1990 (空灵版)-赵十三 | 恋曲1990 (空灵版) | 赵十三 |
| 1323 | 当你老了-莫文蔚 | 当你老了 | 莫文蔚 |
| 1324 | One More Light(又一道光芒)-Linkin Park | One More Light | Linkin Park |
| 1325 | 敢问路在何方-刀郎 | 电视剧新西游记主题曲 | 刀郎 |
| 1326 | 时を越えて かごめ | 犬夜叉 音楽撰集 | 和田薫 |
| 1327 | Lovin' You On My Mind-Josh Turner | Haywire (Deluxe Edition) | Josh Turner |
| 1328 | 隐形的翅膀 (Live)-腾格尔 | 聚划算99划算盛典Live | 腾格尔 |
| 1329 | The Party Troll-D1ofaquavibe | The Party Troll | D1ofaquavibe |
| 1330 | 有形的翅膀-张韶涵 | 有形的翅膀 | 张韶涵 |
| 1331 | 谁明浪子心(电视剧《还我本色》主题曲)-王杰 | 谁明浪子心 | 王杰 |
| 1332 | Novera-Dark Winter Music | Epic World Volume2 Return 归来(2014) | Dark Winter Music |
| 1333 | 三国恋-Tank | Fighting！生存之道 | Tank |
| 1334 | SCARSONG-flash8 | 最新热歌慢摇3 | flash8 |
| 1335 | Concerto No. 4 in F minor, Op. 8, RV 297, "L'inverno" (Winter): II. Largo | The Four Seasons: The Vivaldi Album | Anne Akiko Meyers / English Chamber Orchestra / David Lockington |
| 1336 | 光阴的故事(Live)-纵贯线 | Live in Taipei 出发/终点站 | 纵贯线 |
| 1337 | Somewhere | Somewhere | July |
| 1338 | If We Ever Broke Up-Mae Stephens | If We Ever Broke Up | Mae Stephens |
| 1339 | 爱的就是你(电视剧《蜜桃女孩》片头曲)-王力宏 | Evolution 王力宏的音乐进化论 '95-'02 新歌+精选 | 王力宏 |
| 1340 | 水星记-陈梦嘉 | 環遊記 | 陈梦嘉 |
| 1341 | 东风破-刘芳 | 再醉一次 | 刘芳 |
| 1342 | Close Eyes (Slowed + Reverb)-DVRST | Close Eyes (Slowed + Reverb) | DVRST |
| 1343 | 别再闹了(电影《来电狂响》暖冬主题曲)-毛不易 | 别再闹了 | 毛不易 |
| 1344 | 月亮代表我的心-张国荣 | Miss You Much, Leslie | 张国荣 |
| 1345 | Look4You-Alberto Ciccarini | Look4You | Alberto Ciccarini |
| 1346 | 思念是一种病-彭芳 | 纯色角5 | 彭芳 |
| 1347 | 北国の春-木村好夫 | 木村好夫-ギター演歌名曲全集2 | 木村好夫 |
| 1348 | 那些花儿(电影《那时花开》片尾曲)-朴树 | 我去2000年 | 朴树 |
| 1349 | 等你下课 (with 杨瑞代)-周杰伦 | 等你下课 | 周杰伦 |
| 1350 | 不得不爱-潘玮柏、弦子 | 夏日撒糖情歌 | 潘玮柏 / 弦子 |
| 1351 | Future Funk-Varien | Pick Your Poison Vol. 01 | Varien |
| 1352 | Balenciaga-T3nzu | Balenciaga | T3nzu |
| 1353 | cocoon-林ゆうき | 「トライアングル」オリジナル・サウンドトラック | 林ゆうき |
| 1354 | A Quiet Departure-Josh Leake | Benjamin | Josh Leake |
| 1355 | A Mozart Reincarnated-Ennio Morricone | La Leggenda del Pianista Sull'oceano | Ennio Morricone |
| 1356 | 9420-麦小兜 | 9420 | 麦小兜 |
| 1357 | 探故知(dj原版、清风上南枝 梦中仍相似)-吉泽树 | 探故知dj原版 | 吉泽树 |
| 1358 | Clsr (Aash Mehta Flip)-The Chainsmokers、Aash Mehta、Halsey | Clsr (Aash Mehta Flip) | The Chainsmokers / Aash Mehta / Halsey |
| 1359 | 入画江南-黄龄 | 江南百景图松江府主题曲 | 黄龄 |
| 1360 | Best Moments (feat. Kondor)-Blazo | Alone Journey | Blazo |
| 1361 | 梦里水乡-童丽 | 金韵民歌 | 童丽 |
| 1362 | As It Was-PREP | As It Was | PREP |
| 1363 | 舞女泪-韩宝仪 | 怀念金曲 | 韩宝仪 |
| 1364 | Young and Beautiful-手嶌葵 | Cheek to Cheek～I Love Cinemas～ - (Cheek to Cheek~I Love Cinemas~) | 手嶌葵 |
| 1365 | 道别-陈光荣 | 无间道Ⅲ 终极无间 | 陈光荣 |
| 1366 | Becoming a Legend-John Dreamer | Becoming a Legend - Single | John Dreamer |
| 1367 | 倒带(电视剧《求婚事务所》片尾曲)-蔡依林 | 城堡 | 蔡依林 |
| 1368 | 下一站天后(电影《下一站天后》主题曲)-Twins | 我们相爱6年(新曲+精选) | Twins |
| 1369 | Beloved-Dan Gibson | Native Harmony | Dan Gibson |
| 1370 | 我要的飞翔(电视剧《一起来看流星雨》片尾曲)-许飞 | 一起来看流星雨 原声音乐辑 | 许飞 |
| 1371 | 手写的从前-周杰伦 | 哎呦，不错哦 | 周杰伦 |
| 1372 | 夏日之梦-傅许 | 夏日之梦 | 傅许 |
| 1373 | 明天会更好-群星 | 明天会更好 | 群星 |
| 1374 | 返璞归真-胡伟立 | 太极张三丰 电影原声带 | 胡伟立 |
| 1375 | 须尽欢-柯柯柯啊 | 须尽欢 | 柯柯柯啊 |
| 1376 | 套马杆-乌兰托娅 | 我要去西藏 | 乌兰托娅 |
| 1377 | 莫问归期-蒋雪儿Snow.J | 莫问归期 | 蒋雪儿Snow.J |
| 1378 | 土坡上的狗尾草 (双语版)-卢润泽、宫巴 | 土坡上的狗尾巴草（双语版） | 卢润泽 / 宫巴 |
| 1379 | 我的楼兰-云朵 | 倔强 | 云朵 |
| 1380 | 全是爱-凤凰传奇 | 最炫民族风 | 凤凰传奇 |
| 1381 | 弱水三千 (0.8x DJ苏熠鸣) | 弱水三千 (DJ苏熠鸣版) | 苏熠鸣 |
| 1382 | 我怀念的-孙燕姿 | 逆光 - (Against The Light) | 孙燕姿 |
| 1383 | Brotherhood-John Dreamer | Brotherhood | John Dreamer |
| 1384 | 朋友(Friends)-周华健 | 朋友 | 周华健 |
| 1385 | 画心(猜不透是你瞳孔的颜色)-于春洋 | 画心 | 于春洋 |
| 1386 | 昨夜星辰-高胜美 | 旧情绵绵(珍藏版3) | 高胜美 |
| 1387 | 我们的纪念-李雅微 | 我们的纪念 | 李雅微 |
| 1388 | 左手指月 (Live)-黄霄雲 | 梦想的声音第三季 第9期 | 黄霄雲 |
| 1389 | 爱在西元前-周杰伦 | 范特西 | 周杰伦 |
| 1390 | Hello Zepp-Charlie Clouser | Saw (Original Motion Picture Soundtrack) | Charlie Clouser |
| 1391 | 一路生花-温奕心 | 一路生花 | 温奕心 |
| 1392 | Mind Heist(电影《盗梦空间》预告片配乐) | Inception Trailer | Zack Hemsey |
| 1393 | RAVE-Dxrk ダーク | RAVE | Dxrk ダーク |
| 1394 | Golden Key-Isgaard | Golden Key [#2] | Isgaard |
| 1395 | 花好月圆夜(国)(电影《花好月圆》插曲)-杨千嬅、任贤齐 | 2004开大 | 杨千嬅 / 任贤齐 |
| 1396 | 写给黄淮-邵帅 | 写给黄淮 | 邵帅 |
| 1397 | I Believe-孙楠 | 缘份的天空 | 孙楠 |
| 1398 | Uptown Funk-Mark Ronson、Bruno Mars | Uptown Funk | Mark Ronson / Bruno Mars |
| 1399 | Koko-Ariel | Koko | Ariel |
| 1400 | Anatomy | Anatomy | DJRUSTAM / FIZO FAOUEZ |
| 1401 | Coming Home-Dash Berlin、Bo Bruce | We Are (Part 2) | Dash Berlin / Bo Bruce |
| 1402 | 爱的初体验-张震岳 | 这个下午很无聊 | 张震岳 |
| 1403 | 苏慕遮-张晓棠 | 苏幕遮 | 张晓棠 |
| 1404 | 新鸳鸯蝴蝶梦(电视剧《包青天》片尾曲)-黄安 | 新鸳鸯蝴蝶梦 | 黄安 |
| 1405 | 万物生 (梵语)-萨顶顶 | 万物生 | 萨顶顶 |
| 1406 | Eye of the Tiger-Survivor | Eye Of The Tiger | Survivor |
| 1407 | 甜蜜蜜(Sweet)-邓丽君 | 宝丽金经典中文金曲 | 邓丽君 |
| 1408 | 迷宫(电视剧《美味关系》插曲)-王若琳 | 美味关係电视原声带 | 王若琳 |
| 1409 | 说书人-小沈阳 | 说书人 | 小沈阳 |
| 1410 | 遗憾(新加坡电视剧《实况剧场》主题曲)-许美静 | 遗憾 | 许美静 |
| 1411 | Famous-Ivy Adara | Famous | Ivy Adara |
| 1412 | 耍猴儿(百鬼夜行) (唢呐版)-Harry来了 | 未知 | Harry来了 |
| 1413 | 時の流れに身をまかせ(我只在乎你 日语版)-王若琳 | 時の流れに身をまかせ | 王若琳 |
| 1414 | 24/7, 365 (sunset session)-elijah woods | bright orange everglow (sunset sessions) | elijah woods |
| 1415 | 背对背拥抱(Back to Back)-林俊杰 | 他是…JJ林俊杰 | 林俊杰 |
| 1416 | 丁香花-唐磊 | 丁香花 | 唐磊 |
| 1417 | 我可以(电视剧《转角遇到爱》插曲)-蔡旻佑 | 蔡旻佑首张创作专辑 19 | 蔡旻佑 |
| 1418 | 干杯(干杯)-五月天 | 第二人生 (明日版) | 五月天 |
| 1419 | 没那么简单(电视剧《左手亲情右手爱》主题曲)-黄小琥 | 简单/不简单 | 黄小琥 |
| 1420 | 无问(电影《无问西东》宣传曲)-毛不易 | 无问 | 毛不易 |
| 1421 | 1901-Birdy | Birdy (Deluxe Version) | Birdy |
| 1422 | Rose (Epic Orchestra)-Mathias Fritsche | Rose (Epic Orchestra) | Mathias Fritsche |
| 1423 | 童年-叶蒨文 | Inside Out | 叶蒨文 |
| 1424 | 2002 (Acoustic)-Amber Leigh Irish | Unplugged Acoustic, Vol. 2 | Amber Leigh Irish |
| 1425 | 唯一-告五人 | 运气来得若有似无 | 告五人 |
| 1426 | 水星记-郭顶 | 飞行器的执行周期 | 郭顶 |
| 1427 | golden hour-JVKE | this is what ____ feels like (Vol. 1-4) | JVKE |
| 1428 | 爱错-王力宏 | 心中的日月 | 王力宏 |
| 1429 | The Black Rose-Joanie Madden | Celtic Twilight 2 | Joanie Madden |
| 1430 | My Sunset (Original Mix)-Feint | Feint EP2 | Feint |
| 1431 | 空谷幽兰-许巍 | 许巍此时此刻巡回演唱会DVD | 许巍 |
| 1432 | 雨空-α·Pav | Colors | α·Pav |
| 1433 | One Day-Matisyahu | One Day | Matisyahu |
| 1434 | 白色风车-周杰伦 | 依然范特西 | 周杰伦 |
| 1435 | 绒花-韩红 | 红 | 韩红 |
| 1436 | 兰花草-叶蒨文 | Inside Out | 叶蒨文 |
| 1437 | Tuesday-Burak Yeter Danelle | Dance 2017 - Armada Music | Burak Yeter / Danelle |
| 1438 | 红玫瑰-陈奕迅 | 认了吧 | 陈奕迅 |
| 1439 | Welcome to Jurassic World(电影《侏罗纪世界》配乐)-Michael Giacchino | Jurassic World (Original Motion Picture Soundtrack)- (侏罗纪世界) | Michael Giacchino |
| 1440 | PDD洪荒之力-Hoaprox | #Lov3 #Ngẫu Hứng | Hoaprox |
| 1441 | Because I Love You-Shakin' Stevens | Strawberry Love | Shakin' Stevens |
| 1442 | 飘洋过海来看你（钢琴唯美版） | 李宗盛经典金曲钢琴版 | QQ音乐·助眠减压俱乐部 |
| 1443 | 告白之夜（纯音乐）-CMJ | 告白の夜 | CMJ |
| 1444 | 安和桥-宇西 | 安和桥 | 宇西 |
| 1445 | 梦里水乡-陈婧霏 | 梦里水乡 (青春重置计划5 请回答1999) | 陈婧霏 |
| 1446 | 问月-葫芦童声、妞妞合唱团 | 问月 | 葫芦童声 / 妞妞合唱团 |
| 1447 | 画-赵雷 | 赵小雷 | 赵雷 |
| 1448 | 花雨落-任然 | 花雨落 | 任然 |
| 1449 | 爱你一万年-伍佰 | 爱你伍佰年 | 伍佰 & China Blue |
| 1450 | 青丝-时光胶囊 | 记忆给他的礼物 | 时光胶囊 |
| 1451 | 匆匆那年 (纯音乐)-梁翘柏 | 匆匆那年 电影原声带 | 梁翘柏 |
| 1452 | 兰亭序-吴紫涵 | 情动心弦 | 吴紫涵 |
| 1453 | 往事只能回味-韩宝仪 | 旧情绵绵 | 韩宝仪 |
| 1454 | Ghost Bride Prelude-Nate Connelly | 僵尸 电影原声大碟 | Nate Connelly |
| 1455 | You-Approaching Nirvana | Blocking the Sky Redux | Approaching Nirvana |
| 1456 | Whisper Of Hope (Main)-Gothic Storm | Epic Emotional Piano | Gothic Storm |
| 1457 | The Imperial March(帝国进行曲)-John Williams | Music from the Star Wars Saga- (星球大战) | John Williams |
| 1458 | Young Hearts-Dirk Reichardt | Kokowääh 2 (Original Motion Picture Soundtrack) | Dirk Reichardt |
| 1459 | James Bond Theme-John Barry Monty Norman | Dr. No (Original Motion Picture Soundtrack) | John Barry / Monty Norman |
| 1460 | 心中的日月-王力宏 | 心中的日月 | 王力宏 |
| 1461 | 画离弦-浅影阿 | 画离弦 | 浅影阿 |
| 1462 | 外婆的澎湖湾2015-任贤齐 | 落跑吧爱情 电影原声带 | 任贤齐 |
| 1463 | 轨迹-周杰伦 | 寻找周杰伦 | 周杰伦 |
| 1464 | 友情岁月-陈小春 | 夜生活 | 陈小春 |
| 1465 | Welcome To New York-Taylor Swift | reputation Stadium Tour Surprise Song Playlist | Taylor Swift |
| 1466 | 铁血丹心(1983年TVB版电视剧《射雕英雄传之铁血丹心》主题曲)-罗文、甄妮 | 射雕英雄传 | 罗文 / 甄妮 |
| 1467 | A Little Bit Broken-Spritely | A Little Bit Broken | Spritely |
| 1468 | メインテーマ「永遠の一瞬」（主题「永恒的一瞬」）-伊藤賢治 | この青空に約束をー~ようこそつぐみ寮へ~Piano Stories | 伊藤賢治 |
| 1469 | 潮鳴り-折戸伸治 | CLANNAD ORIGINAL SOUNDTRACK | 折戸伸治 |
| 1470 | The Pink Panther Theme-Henry Mancini | In the Pink | Henry Mancini |
| 1471 | 白いスーツのテーマ(白色西装主题曲)-市川淳 | TBS系 金曜ドラマ うぬぼれ刑事 オリジナル・サウンドトラック | 市川淳 |
| 1472 | 我们的歌-王力宏 | 改变自己 | 王力宏 |
| 1473 | 爱是你我-刀郎、云朵、王翰仪 | 谢谢你 | 刀郎、云朵、王翰仪 |
| 1474 | 穿越时空的爱恋-CMJ | 穿越时空的爱恋 | CMJ |
| 1475 | 红色高跟鞋（温柔版）-藤柒吖 | 红色高跟鞋 | 藤柒吖 |
| 1476 | 像我这样的人-毛不易 | 平凡的一天 | 毛不易 |
| 1477 | 北国の春(北国之春)-渥美二郎 | 全日傳 砂金之卷+鉑環之卷 | 渥美二郎 |
| 1478 | Dusk Till Dawn | Piano Acoustic Covers Vol 2 | Kurt Hugo Schneider / Kirsten Collins / Blake Rose |
| 1479 | A Little Love-冯曦妤 | A Little Love | 冯曦妤 |
| 1480 | Dreamland-Liquid Mind | Liquid Mind XI: Deep Sleep | Liquid Mind |
| 1481 | Letting Go-蔡健雅 | 说到爱 | 蔡健雅 |
| 1482 | 月亮之上-凤凰传奇 | 月亮之上 | 凤凰传奇 |
| 1483 | 浮光 (The History)-Jannik | 浮光 (The History) | Jannik |
| 1484 | Criminals-F.O.O.L | Revenger | F.O.O.L |
| 1485 | 过火-张信哲 | 爱程集 | 张信哲 |
| 1486 | 姑娘在远方 (女版)-池鱼 | 姑娘在远方 (女版) | 池鱼 |
| 1487 | Afternoon love flower-GHEAS RMX | Afternoon love flower | GHEAS RMX |
| 1488 | 黄昏-周传雄 | Transfer | 周传雄 |
| 1489 | P.I.M.P-TangTian | P.I.M.P | TangTian |
| 1490 | 射雕英雄传(电影《射雕英雄传之东成西就》片尾曲)-林穆 | 笑傲歌坛 传世经典 | 林穆 |
| 1491 | 赤伶-是二智呀 | 赤伶（民谣版） | 是二智呀 |
| 1492 | Halloween Theme - Main Title | Greatest Hits | John Carpenter |
| 1493 | 王进打高俅-赵季平 | 水浒传 原声音乐 | 赵季平 |
| 1494 | 平凡的一天-毛不易 | 平凡的一天 | 毛不易 |
| 1495 | 梦里水乡-钟明秋 | 为你钟情 | 钟明秋 |
| 1496 | きっとまたいつか（album version）(午后柠檬树下的阳光)-DEPAPEPE | Ciao!Bravo!! | DEPAPEPE |
| 1497 | 七月上-Jam | 阿敬的单曲集 | Jam |
| 1498 | 梦醒时分(电视剧《1989一念间》插曲)-陈淑桦 | 1989一念间 电视原声带 | 陈淑桦 |
| 1499 | 无名的人(电影《雄狮少年》主题曲)-毛不易 | 无名的人 | 毛不易 |
| 1500 | 流浪者之歌-Budapest Festival Orchestra 诹访内晶子 | 惠威试音专用Ⅱ | Budapest Festival Orchestra / 诹访内晶子 |
| 1501 | 恨爱交加-麦振鸿 | 天地传说之创世纪乐章 | 麦振鸿 |
| 1502 | 最长的电影-周杰伦 | 我很忙 | 周杰伦 |
| 1503 | 我很丑，可是我很温柔-赵传 | 一人一首成名曲 | 赵传 |
| 1504 | Payphone-Maroon 5、Wiz Khalifa | Overexposed | Maroon 5 / Wiz Khalifa |
| 1505 | 虞兮叹-闻人听書_ | 虞兮叹 | 闻人听書_ |
| 1506 | 淘汰-陈奕迅 | 认了吧 | 陈奕迅 |
| 1507 | 消愁-毛不易 | 平凡的一天 | 毛不易 |
| 1508 | 高山流水-王昌元 | 中国古筝名家名曲——中国民族器乐精品系列 | 王昌元 |
| 1509 | 美丽拍挡-胡伟立 | 国产凌凌漆 | 胡伟立 |
| 1510 | Polska-Sava | Aire | Sava |
| 1511 | 乡间的小路-北京天使合唱团 | 我的快乐天堂 | 北京天使合唱团 |
| 1512 | 我是如此相信-周杰伦 | 我是如此相信 | 周杰伦 |
| 1513 | Dehors(外面)-JORDANN | Dehors | JORDANN |
| 1514 | Curtain-凌晨一点的莱茵猫 | Curtain falls | 凌晨一点的莱茵猫 |
| 1515 | 奢香夫人-凤凰传奇 | 最炫民族风 | 凤凰传奇 |
| 1516 | 金三角 (恐怖纯音乐) | 金三角（恐怖纯音乐） | R̶ᴇ̶ɢ̶ʀ̶ᴇ̶ᴛ̶. |
| 1517 | sans.-Toby Fox | UNDERTALE Soundtrack | Toby Fox |
| 1518 | 渔舟唱晚-方锦龙 | 霸王卸甲—中国琵琶经典 | 方锦龙 |
| 1519 | 壁上观-一棵小葱、张曦匀 | 壁上观 | 一棵小葱 / 张曦匀 |
| 1520 | 霜雪千年-邓寓君(等什么君) | 霜雪千年 | 邓寓君(等什么君) |
| 1521 | Last Christmas-Taylor Swift | Best Country Christmas | Taylor Swift |
| 1522 | 美酒加咖啡-高胜美 | 美丽的回忆 | 高胜美 |
| 1523 | 一荤一素-毛不易 | 平凡的一天 | 毛不易 |
| 1524 | 一程山路-毛不易 | 小王 | 毛不易 |
| 1525 | 夏夜-四季音色 | 春夏之交，轻旋淡律 | 四季音色 |
| 1526 | 人形の館-岩崎琢 | 黒執事 サウンドコンプリート BLACK BOX | 岩崎琢 |
| 1527 | Single Ladies (Put a Ring on It)-Beyoncé | Single Ladies (Put A Ring On It) - Dance Remixes | Beyoncé |
| 1528 | 山外小楼夜听雨-任然 | 从小到大 | 任然 |
| 1529 | 十面埋伏(琵琶独奏)-群星 | 中国古典音乐历朝黄金年鉴 | 群星 |
| 1530 | 她的微笑 (original Mix)-阳山伟伟 | 她的微笑 (original Mix) | 阳山伟伟 |
| 1531 | 映山红-黄英 | Cover Girls | 黄英 |
| 1532 | Mystery of Love-Luke Pickman | Mystery of Love | Luke Pickman |
| 1533 | 西厢寻他-伯爵Johnny / 唐伯虎Annie | 西厢寻他 | 伯爵Johnny / 唐伯虎Annie |
| 1534 | 西楼别序-尹昔眠 / 小田音乐社 | 西楼别序 | 尹昔眠 / 小田音乐社 |
| 1535 | 青天-胡伟立 | 九品芝麻官之白面包青天 电影原声 | 胡伟立 |
| 1536 | 青空-Candy_Wind | 拂晓车站 | Candy_Wind |
| 1537 | 勇往直前-胡伟立 | 唐伯虎点秋香 | 胡伟立 |
| 1538 | 遗憾-李代沫 | 我的歌声里 | 李代沫 |
| 1539 | 执迷不悟-铁脑袋mp3 | 执迷不悟 | 铁脑袋mp3 |
| 1540 | 小心な侵入者-根岸貴幸 | カードキャプターさくら オリジナル・サウンドトラック4 | 根岸貴幸 |
| 1541 | 弱水三千-石头、张晓棠 | 念 | 石头 / 张晓棠 |
| 1542 | 小鱼儿与花无缺片头音乐-麦振鸿 | 武侠音乐系列之豪气中天 （截取版） | 麦振鸿 |
| 1543 | 菊花台-周杰伦 | 依然范特西 | 周杰伦 |
| 1544 | 雨的舞步-赵大鼾 | 雨的舞步 | 赵大鼾 |
| 1545 | Lost Love (Instrumental)-Lunnna Janey杰尼 | Memories | Lunnna / Janey杰尼 |
| 1546 | 我从草原来-凤凰传奇 | 我从草原来 新歌+精选 | 凤凰传奇 |
| 1547 | 起风了(BILIBILI 11周年演讲)-周深 | 起风了 | 周深 |
| 1548 | Betrayal Voices | Horror/Sci-Fi #1 | Immediate Music |
| 1549 | Theme from Mission: Impossible-Danny Elfman | Mission Impossible [Original Score] | Danny Elfman |
| 1550 | 樱花草 (治愈版)-藤柒吖 | 樱花草 | 藤柒吖 |
| 1551 | 明月夜-张国荣 | 兜风心情 | 张国荣 |
| 1552 | 左手指月(电视剧《香蜜沉沉烬如霜》片尾曲)-萨顶顶 | 香蜜沉沉烬如霜 电视原声音乐专辑 | 萨顶顶 |
| 1553 | 狮子座-曾轶可 | Forever Road | 曾轶可 |
| 1554 | Daisies-Black Gryph0n、Baasik | Daisies | Black Gryph0n / Baasik |
| 1555 | 匆匆那年-周深 | 匆匆那年 | 周深 |
| 1556 | 童年-卓依婷 | 校园青春乐 | 卓依婷 |
| 1557 | Trinity: Con la Stella Di Vicesceriffo-Franco Micalizzi | Lo Chiamavano Trinita (They Call Me Trinity) | Franco Micalizzi |
| 1558 | 我只在乎你-王若琳 | 我只在乎你 | 王若琳 |
| 1559 | 大笨钟-周杰伦 | 十二新作 | 周杰伦 |
| 1560 | Dum Dum Dum-RENEE | Extending Playground | RENEE |
| 1561 | Theme From Jurassic Park (From "Jurassic Park" Soundtrack)-John Williams | Jurassic Park (Soundtrack) | John Williams |
| 1562 | 说了再见-周杰伦 | 跨时代 | 周杰伦 |
| 1563 | 弱水三千 (0.7x)-张晓棠、石头、赵允哲、DJ Wave | 弱水三千 (0.7x) | 张晓棠 /石头 /赵允哲 /DJ Wave |
| 1564 | 青春纪念册-可米小子 | 青春纪念册 | 可米小子 |
| 1565 | Forever Friends-孙楠、张惠妹 | 北京2008年奥运会歌曲专辑 | 孙楠 / 张惠妹 |
| 1566 | Wrap Me In Plastic-CHROMANCE、Marcus Layton | Wrap Me In Plastic | CHROMANCE / Marcus Layton |
| 1567 | 天路 (世界音乐版)-韩红 | 感动 | 韩红 |
| 1568 | 父亲写的散文诗 (live)(原唱：许飞)-李健 | 歌手 第8期 | 李健 |
| 1569 | Lay Low-Josh Turner | Lay Low | Josh Turner |
| 1570 | I Don't Want To Say Goodbye(电影《断背山》插曲)-Teddy Thompson | Brokeback Mountain (Original Motion Picture Soundtrack) | Teddy Thompson |
| 1571 | 萍聚-卓依婷 | 蜕变1少女的心情故事 | 卓依婷 |
| 1572 | 春不晚 (DJHZ版)-RE-D、郑浩 | 春不晚 (Remixes) | RE-D / 郑浩 |
| 1573 | 认真的雪 (温柔版)-藤柒吖 | 认真的雪 | 藤柒吖 |
| 1574 | We Can't Stop-Boyce Avenue、Bea Miller | Cover Sessions, Vol. 3 | Boyce Avenue / Bea Miller |
| 1575 | 至少还有你-林忆莲 | 林忆莲's | 林忆莲 |
| 1576 | 但愿人长久-王菲 | 但愿人长久 | 王菲 |
| 1577 | 简单爱-周杰伦 | 范特西 | 周杰伦 |
| 1578 | 千年泪-曹雨航 | 千年泪 | 曹雨航 |
| 1579 | Just The Two Of Us-王若琳 | The Adult Storybook | 王若琳 |
| 1580 | 外婆的澎湖湾（童声版）-青乐、张紫涵 | 青乐学员cover | 青乐 / 张紫涵 |
| 1581 | 二泉映月(The Moon Reflected in Er-Quan)-中国广播民族乐团 | 彩云追月 - (Moon Rising in the Rosy Clouds) | 中国广播民族乐团 |
| 1582 | 须尽欢(DJ弹鼓版)-沐泽 | 须尽欢 | 沐泽 |
| 1583 | 春庭雪（DJ弹鼓版）-DJ光头 | 春庭雪 （DJ弹鼓版） | DJ光头 |
| 1584 | 春庭雪 (DJ名龙 Mix) | 春庭雪 (DJ名龙 Mix) | DJ名龙 |
| 1585 | 凤凰花开的路口-林志炫 | 熟情歌 | 林志炫 |
| 1586 | 漂洋过海来看你-周深 | 漂洋过海来看你 周深翻唱精选Vol. 2 | 周深 |
| 1587 | New Soul-Yael Naim | Yael Naim | Yael Naim |
| 1588 | 最后一页 (Live)-王赫野、姚晓棠 | 天赐的声音第五季 第1期 | 王赫野 / 姚晓棠 |
| 1589 | Gonna Get There Someday-Dierks Bentley | Modern Day Drifter | Dierks Bentley |
| 1590 | 梦醒时分-迪克牛仔 | 咆哮 | 迪克牛仔 |
| 1591 | 刀马旦-CoCo李玟、周杰伦 | Promise | CoCo李玟 / 周杰伦 |
| 1592 | 再见(Live)-纵贯线 | Live in Taipei 出发/终点站 | 纵贯线 |
| 1593 | 不能说的秘密-周杰伦 | 不能说的秘密 电影原声带 | 周杰伦 |
| 1594 | 无名之辈(电视剧《亲爱的，热爱的》主题曲)-陈雪燃 | 亲爱的，热爱的 影视原声带 | 陈雪燃 |
| 1595 | 难忘的一天-许巍 | 爱如少年 | 许巍 |
| 1596 | 坐在巷口的那对男女-自然卷 | C'est la vie 这就是生活 | 自然卷 |
| 1597 | 年月日(电影《初恋这件小事》插曲)-Jeab Wattana | เพลงประกอบภาพยนตร์ สิ่งเล็กเล็กที่เรียกว่ารัก - (初恋这件小事) | Jeab Wattana |
| 1598 | 万水千山总是情-黑鸭子 | 流行的经典 | 黑鸭子 |
| 1599 | Hard Time(游戏《刺客信条编年史：中国》预告片插曲)-Seinabo Sey | Hard Time | Seinabo Sey |
| 1600 | 暗号-周杰伦 | 八度空间 | 周杰伦 |
| 1601 | 下个，路口，见-李宇春 | 李宇春 同名专辑 | 李宇春 |
| 1602 | 暖暖 (香皂泡版) | 暖暖 | 香皂泡 |
| 1603 | 漂洋过海来看你-周深 | 漂洋过海来看你 | 周深 |
| 1604 | 我心灿烂-许巍、天使童声合唱团 | 我心灿烂 | 许巍 / 天使童声合唱团 |
| 1605 | 风吹麦浪-李健 | 想念你 | 李健 |
| 1606 | Horizon(地平线 / 地平线)-Janji | Outertone 003 - Vision | Janji |
| 1607 | 零落-金天 | 零落 | 金天 |
| 1608 | 告白气球-周杰伦 | 周杰伦的床边故事 | 周杰伦 |
| 1609 | Luminous-贝奇Becky | Luminous | 贝奇Becky |
| 1610 | 不再犹豫-Twins | 青春重置计划之BEYOND 40 | Twins |
| 1611 | 我们-许巍 | 爱如少年 | 许巍 |
| 1612 | exile-Taylor Swift、Bon Iver | folklore (deluxe version) | Taylor Swift / Bon Iver |
| 1613 | 搁浅-周杰伦 | 七里香 | 周杰伦 |
| 1614 | 最炫民族风-凤凰传奇 | 最炫民族风 | 凤凰传奇 |
| 1615 | 无愧于心(电视剧《少年包青天》原声)-孙楠 | 无愧于心 | 孙楠 |
| 1616 | 高山流水-方锦龙 | 方锦龙十面埋伏 | 方锦龙 |
| 1617 | 光的方向-张碧晨 | 长歌行 电视剧原声带 | 张碧晨 |
| 1618 | 说书人-暗杠、寅子 | 说书人 | 暗杠 / 寅子 |
| 1619 | 园游会-周杰伦 | 七里香 | 周杰伦 |
| 1620 | 勇气-梁静茹 | 勇气 | 梁静茹 |
| 1621 | 春风再美也比不上你的笑，没见过你的人自然不会明了。（Demo） | 一个人跨年的你看啊，今晚月色真美。 | 十指流玉 |
| 1622 | 自由飞翔-凤凰传奇 | 吉祥如意 | 凤凰传奇 |
| 1623 | Octopus-ALan | Octopus | ALan |
| 1624 | 一剪梅(电视剧《一剪梅》主题曲)-费玉清 | 一剪梅 | 费玉清 |
| 1625 | 时间煮雨(电影《小时代》主题曲)-郁可唯 | 小时代 电影原声带 | 郁可唯 |
| 1626 | 梦里水乡-江珊 | 原唱流行经典名曲1 | 江珊 |
| 1627 | 心爱(2003年版电视剧《倚天屠龙记》片头曲)-金学峰 | 倚天屠龙记 原声大碟 | 金学峰 |
| 1628 | 无名之辈(电影《大场面》片尾曲)-王天放、马旭东、管乐、酷酷的滕、吕严、叶浏、张祐维、李飞、张呈 | 无名之辈 | 王天放 / 马旭东 / 管乐 / 酷酷的滕 / 吕严 / 叶浏 / 张祐维 / 李飞 / 张呈 |
| 1629 | 霍元甲-周杰伦 | 霍元甲 | 周杰伦 |
| 1630 | 暖暖-梁静茹 | 亲亲 | 梁静茹 |
| 1631 | 光阴的故事-张艾嘉 | 童年 | 张艾嘉 |
| 1632 | 当你(When you)-林俊杰 | 她说 概念自选辑 | 林俊杰 |
| 1633 | 世间始终你好(电影《美人鱼》宣传曲)-莫文蔚、郑少秋 | 世间始终你好 | 莫文蔚 / 郑少秋 |
| 1634 | All of Me-John Legend | Love In The Future | John Legend |
| 1635 | 迷迭香-周杰伦 | 依然范特西 | 周杰伦 |
| 1636 | 恋曲1980 (Live)-纵贯线 | Live in Taipei 出发/终点站 | 纵贯线 |
| 1637 | 光阴的故事-北京天使合唱团 | 光阴的故事 | 北京天使合唱团 |
| 1638 | 欢沁-林海 | 林海影视配乐精选 | 林海 |
| 1639 | No Glory | No Glory | Krale / M.I.M.E / Drama B / Skan |
| 1640 | 这一路走来-杨宗纬 | 初。爱 | 杨宗纬 |
| 1641 | Shape Of My Heart(电影《这个杀手不太冷》片尾曲)-Sting | Fifteen Healing Bites | Sting |
| 1642 | 春天里 (Live)-G.E.M.邓紫棋、方大同 | 我是歌手第二季 总决赛 | G.E.M.邓紫棋 / 方大同 |
| 1643 | 这，就是爱-张杰 | 这，就是爱 | 张杰 |
| 1644 | 超越梦想-汪正正、杨竹青 | Beyond the Dream - (超越梦想) | 汪正正 / 杨竹青 |
| 1645 | 断了的弦-周杰伦 | 寻找周杰伦 | 周杰伦 |
| 1646 | Angel-Sarah McLachlan | Closer: The Best Of Sarah McLachlan | Sarah McLachlan |
| 1647 | Aphrodite-椅子乐团 The Chairs | Aphrodite | 椅子乐团 The Chairs |
| 1648 | 壁上观 (1.08x黑神话悟空)-沈梦君 | 壁上观（1.08x黑神话悟空） | 沈梦君 |
| 1649 | 霜雪千年-封茗囧菌、双笙 (陈元汐) | 封茗囧菌翻唱合辑 | 封茗囧菌 / 双笙 (陈元汐) |
| 1650 | 青丝（～迷乱我双眼）-DJLH | DJ-LH说唱版Mix旋律版} | DJLH |
| 1651 | I Really Like You-Carly Rae Jepsen | I Really Like You | Carly Rae Jepsen |
| 1652 | 把悲伤留给自己(电影《罗曼蒂克消亡史》推广曲)-左小祖咒、钟欣潼 | 罗曼蒂克消亡史 电影歌曲 | 左小祖咒 / 钟欣潼 |
| 1653 | As Long as You Love Me-Backstreet Boys | Backstreet Boys (US Version) | Backstreet Boys |
| 1654 | Donna Donna-Joan Baez | Let's Folk Again | Joan Baez |
| 1655 | 春庭雪 (DJ默涵版) | 春庭雪 (DJ默涵版) | DJ默涵 |
| 1656 | Criticalpoint-凌晨一点的莱茵猫 | Criticalpoint | 凌晨一点的莱茵猫 |
| 1657 | 青藏高原-韩红 | 醒了 | 韩红 |
| 1658 | 千年泪-Tank | 天外飞仙 电视原声带 | Tank |
| 1659 | Loyal（PHONK）（将军进行曲）-BOY、KKK | Loyal（PHONK） | BOY / KKK |
| 1660 | Letting Go-藤柒吖 | Letting Go | 藤柒吖 |
| 1661 | 三寸天堂-严艺丹 | 无·果 | 严艺丹 |
| 1662 | 夜曲-周杰伦 | 十一月的萧邦 | 周杰伦 |
| 1663 | 星语心愿(电影《星愿》插曲)-张柏芝 | 张柏芝 | 张柏芝 |
| 1664 | 烟花易冷-周杰伦 | 跨时代 | 周杰伦 |
| 1665 | 你是落日弥漫的橘，天边透亮的星-Hea2t | 你是落日弥漫的橘，天边透亮的星 | Hea2t |
| 1666 | 相思遥-玉慧同学 | 相思遥 | 玉慧同学 |
| 1667 | 我是真的爱上你-王杰 | 爱与梦 | 王杰 |
| 1668 | 爷爷泡的茶-周杰伦 | 八度空间 | 周杰伦 |
| 1669 | 记·念 (Live)-雷雨心 | 第二季中国好歌曲十大金曲 | 雷雨心 |
| 1670 | 霜雪千年-尘ah. | 霜雪千年 | 尘ah. |
| 1671 | Memory Reboot(往事重启)-Ratter | Slowed collection vol. 13 | Ratter |
| 1672 | 蒲公英的约定-周杰伦 | 我很忙 | 周杰伦 |
| 1673 | My Heart Will Go On • 泰坦尼克号 (Remix)-沈有道 | Wabit Mote | 沈有道 |
| 1674 | 我会好好的-王心凌 | 独唱情歌 | 王心凌 |
| 1675 | 祝你一路顺风(电影《逃学外传》主题曲)-吴奇隆 | 追风少年 | 吴奇隆 |
| 1676 | 梦里水乡-龚玥 | 民歌红3 | 龚玥 |
| 1677 | 夜的第七章-周杰伦、潘儿 | 依然范特西 | 周杰伦 /潘儿 |
| 1678 | 流星雨(电视剧《流星花园》片尾曲)-F4 | 流星雨 | F4 |
| 1679 | 我会好好的-伍佰 | 诗情摇滚 | 伍佰 & China Blue |
| 1680 | 粉色海洋-周杰伦 | 最伟大的作品 | 周杰伦 |
| 1681 | Memory Reboot(往事重启)-VØJ、Narvent | Memory Reboot | VØJ / Narvent |
| 1682 | Love Is Gone (Acoustic)-Dylan Matthew、SLANDER | Love Is Gone (Acoustic) | Dylan Matthew / SLANDER |
| 1683 | 向天再借五百年(电视剧《康熙王朝》主题曲)-韩磊 | 向天再借五百年 | 韩磊 |
| 1684 | 说好不哭-周杰伦 | 说好不哭 | 周杰伦 |
| 1685 | 再回首-姜育恒 | 多年以后·再回首 | 姜育恒 |
| 1686 | 恋曲1990(Live)-纵贯线 | Live in Taipei 出发/终点站 | 纵贯线 |
| 1687 | 第一次爱的人-王心凌 | My! Cyndi! | 王心凌 |
| 1688 | 可爱女人-周杰伦 | Jay | 周杰伦 |
| 1689 | 爱是你我-云朵、刀郎 | 云朵 | 云朵 /刀郎 |
| 1690 | 梦里水乡-陈红 | 这一次我是真的留下来陪你 | 陈红 |
| 1691 | 谁 (Live版)-廖俊涛 | 这个人创作LIVE现场辑 | 廖俊涛 |
| 1692 | 给我一首歌的时间-周杰伦 | 魔杰座 | 周杰伦 |
| 1693 | 十送红军-刀郎、云朵 | 红色经典 | 刀郎 / 云朵 |
| 1694 | 当你老了(电视剧《嘿！老头》片尾曲)-赵照 | 中国好歌曲第一季 第五期 | 赵照 |
| 1695 | 友情岁月(电影《古惑仔Ⅰ》主题曲)-郑伊健 | 影歌集 - 25年香港经典电影歌曲 | 郑伊健 |
| 1696 | 再不疯狂我们就老了-李宇春 | 再不疯狂我们就老了 | 李宇春 |
| 1697 | 梦想在望-周笔畅 | 北京2008年奥运会歌曲专辑 | 周笔畅 |
| 1698 | 梦里水乡 (合唱版)-许多晴 | 梦里水乡 | 许多晴 |
| 1699 | 梦回大唐 (钢琴萧声版)-沈波 | 梦回大唐 (纯音乐) | 沈波 |
| 1700 | 龙卷风-周杰伦 | Jay | 周杰伦 |
| 1701 | 反方向的钟-周杰伦 | Jay | 周杰伦 |
| 1702 | 小满足-杨宗纬、刘惜君 | 小满足 | 杨宗纬 / 刘惜君 |
| 1703 | 友谊天长地久-北海雄哥 | 友谊天长地久 | 北海雄哥 |
| 1704 | 重生之我在异乡为异客 (纯享版)-王睿卓 | 重生之我在异乡为异客（纯享版） | 王睿卓 |
| 1705 | All Rise-Blue | Top of the Pops 2001 | Blue |
| 1706 | 我不配-周杰伦 | 我很忙 | 周杰伦 |
| 1707 | 夏天的风-火羊瞌睡了 | 夏天的风 | 火羊瞌睡了 |
| 1708 | 把悲伤留给自己-孙露 | 谁为我停留 | 孙露 |
| 1709 | 梦里水乡-于春洋 | 梦里水乡 | 于春洋 |
| 1710 | Lifestyle-HMHK | Lifestyle | HMHK |
| 1711 | Can't Take My Eyes Off You-王若琳 | The Adult Storybook | 王若琳 |
| 1712 | 九儿(电视剧《红高粱》主题曲)-韩红 | 红高粱 电视剧原声带 | 韩红 |
| 1713 | 映山红-刀郎 | 红色经典 | 刀郎 |
| 1714 | 映山红-黑鸭子 | 红色经典特别版 | 黑鸭子 |
| 1715 | 小半-陈粒 | 小梦大半 | 陈粒 |
| 1716 | 天亮了-韩红 | 醒了 | 韩红 |
| 1717 | 把悲伤留给自己(Please Think of Me)-蔡琴 | 遇见 | 蔡琴 |
| 1718 | You Raise Me Up-Westlife | Hot Cakes | Westlife |
| 1719 | You've Got My Heart-Audrianna Cole | You've Got My Heart | Audrianna Cole |
| 1720 | 春娇与志明 (咚鼓版)-陈毅 | 愁深几许 | 陈毅 |
| 1721 | 回到过去-周杰伦 | 八度空间 | 周杰伦 |
| 1722 | 童年-蔡国权 | 真经典: 蔡国权 | 蔡国权 |
| 1723 | 轻轻的告诉你-卓依婷 | 春语1 | 卓依婷 |
| 1724 | 爱你爱到死-李宇春 | 在吗？ | 李宇春 |
| 1725 | 潇洒走一回(电影《京城四少》主题曲)-叶蒨文 | 潇洒走一回 | 叶蒨文 |
| 1726 | 梦里水乡-楚可怜儿 | 梦里水乡 (女版) | 楚可怜儿 |
| 1727 | 恶作剧-林依晨 | 幸福遇见 | 林依晨 |
| 1728 | 回马枪-张晓棠 | 回马枪 | 张晓棠 |
| 1729 | Mojito-周杰伦 | Mojito | 周杰伦 |
| 1730 | 红颜如霜-周杰伦 | 最伟大的作品 | 周杰伦 |
| 1731 | 醉拳(电影《醉拳》主题曲)-成龙 | 醉拳II 电影原声带 | 成龙 |
| 1732 | 送别-亚洲天使童声合唱团 | 天使在唱歌 | 亚洲天使童声合唱团 |
| 1733 | 乡间的小路-卓依婷 | 校园民谣 | 卓依婷 |
| 1734 | 绣红旗-刀郎、徐子尧 | 绣红旗 | 刀郎、徐子尧 |
| 1735 | Stay-The Kid LAROI、Justin Bieber | F*CK LOVE 3: OVER YOU | The Kid LAROI / Justin Bieber |
| 1736 | 武家坡2021(薛平贵与王宝钏)-龍猛寺寬度 | 武家坡 2021 | 龍猛寺寬度 |
| 1737 | Lemon Tree (中文版)-王若琳 | The Things We Do For Love | 王若琳 |
| 1738 | 半点心-草蜢 | Grasshopper Ⅳ | 草蜢 |
| 1739 | 爱你爱到死-杨荞安、同恩、夏宇童 | 海角七号 电影原声带 | 杨荞安 / 同恩 / 夏宇童 |
| 1740 | 似水柔情-王备 | 倚天屠龙记 原声大碟 | 王备 |
| 1741 | 外婆-周杰伦 | 七里香 | 周杰伦 |
| 1742 | 开不了口-周杰伦 | 范特西 | 周杰伦 |
| 1743 | 十面埋伏五弦琵琶方锦龙演奏谱-方锦龙 | 方锦龙十面埋伏 | 方锦龙 |
| 1744 | 渔舟唱晚-于秋璇 | 中国民乐大师纯独奏-古筝 | 于秋璇 |
| 1745 | New Soul-Vitamin String Quartet | Bleeding Love | Vitamin String Quartet |
| 1746 | California-Mindy Gledhill | Anchor | Mindy Gledhill |
| 1747 | The Well-Shine Dion | Wyn | Shine Dion |
| 1748 | 乡间的小路-刘文正 | 阿美!阿美! | 刘文正 |
| 1749 | 唯一-王力宏 | 唯一 | 王力宏 |
| 1750 | 晚风-伍佰 | 泪桥 | 伍佰 & China Blue |
| 1751 | 洛春赋-云汐 | 洛春赋 | 云汐 |
| 1752 | 渔舟唱晚-中央民族乐团 | 古筝传奇 | 中央民族乐团 |
| 1753 | 十七岁的雨季-林志颖 | 别了，晴雨的回忆 | 林志颖 |
| 1754 | Moonlight Shadow-Dana Winner | Märchenland der Gefühl | Dana Winner |
| 1755 | 独家记忆-陳梦嘉 | Hug Me | 陳梦嘉 |
| 1756 | Lost In Paradise(《有你的快乐》英文版)-王若琳 | Yiruma Recommends | 王若琳 |
| 1757 | 不装饰你的梦-蔡国权 | 不装饰你的梦 | 蔡国权 |
| 1758 | 霜雪千年-洛天依、乐正绫 | 洛天依作品集 | 洛天依 / 乐正绫 |
| 1759 | 探窗-叶聪明、ya妖精、小淅儿、边靖婷、可爱晨、汐音社 | 探窗 | 叶聪明 / ya妖精 / 小淅儿 / 边靖婷 / 可爱晨 / 汐音社 |
| 1760 | 一生何求(电视剧《义不容情》主题曲)-陈百强 | 一生何求 | 陈百强 |
| 1761 | 关山酒-草帽酱 | 关山酒 | 草帽酱 |
| 1762 | Summer-Elle Coves | Summer | Elle Coves |
| 1763 | 高山流水-于秋璇 | 中国民乐大师纯独奏-古筝 | 于秋璇 |
| 1764 | 小薇-黄品源 | 简单情歌 小薇 | 黄品源 |
| 1765 | 达尔文-林俊杰 | JJ的咖啡调调, Vol. 2 | 林俊杰 |
| 1766 | 抬花轿-任同祥 | 国乐大师12 任同祥 | 任同祥 |
| 1767 | 重生之我在异乡为异客-王睿卓、Damn5z | 重生之我在异乡为异客 | 王睿卓 / Damn5z |
| 1768 | 百鳥朝鳳 (嗩吶獨奏)-Noble Band | 出神入化: 國寶級大師國樂演奏精選第玖輯 (嗩吶獨奏) | Noble Band |
| 1769 | 把悲伤留给自己(Live)-任贤齐 | 1999任贤齐1St演唱会 | 任贤齐 |
| 1770 | 火力全开-王力宏 | 火力全开 | 王力宏 |
| 1771 | 追梦人-赵十三 | 追梦人 | 赵十三 |
| 1772 | 忆江南-方锦龙 | 忆江南 (琵琶独奏) | 方锦龙 |
| 1773 | Seasons in the Sun-Westlife | I Have A Dream | Westlife |
