package org.woodwhales.music.image;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;
import org.junit.jupiter.api.Test;

/**
 * @author woodwhales on 2020-08-03
 * @description
 */
public class ImageDownloadTest {

    @Test
    public void download() {

        String fileUrl = "http://mirrors.sohu.com/centos/7.3.1611/isos/x86_64/CentOS-7-x86_64-DVD-1611.iso";
        //将文件下载后保存在E盘，返回结果为下载文件大小
        long size = HttpUtil.downloadFile(fileUrl, FileUtil.file("D:/"));
        System.out.println("Download size: " + size);

    }
}
