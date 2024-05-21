# 使用官方的 OpenJDK 17 作为基础镜像
FROM openjdk:17-jdk-slim

LABEL maintainer="woodwhales.cn"

# 设置工作目录
WORKDIR /app

# 将 Maven 构建的 jar 文件复制到容器中
COPY target/woodwhales-music.jar woodwhales-music.jar

# 设置环境变量（这些变量会被 Docker Compose 覆盖）
ENV MYSQL_HOST=localhost
ENV MYSQL_PORT=3306
ENV MYSQL_DATABASE=open_music
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=root1234

# 暴露应用的端口
EXPOSE 8084

# 启动应用
ENTRYPOINT ["java", "-jar", "woodwhales-music.jar"]