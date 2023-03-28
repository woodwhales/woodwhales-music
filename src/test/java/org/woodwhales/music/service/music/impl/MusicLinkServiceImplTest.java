package org.woodwhales.music.service.music.impl;

import java.net.URLEncoder;

class MusicLinkServiceImplTest {

    public static void main(String[] args) {
        String url = "辞九门回忆-邓寓君(等什么君).jpg";
        String encode = URLEncoder.encode(url);
        System.out.println("encode = https://alist.icoders.cn/d/local/music/" + encode + "?sign=beGiFl4kM16YV5DqGnLV3OoKtZBJHJiMHr6VhIhTI54=:0");
    }

}