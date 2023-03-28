package org.woodwhales.music;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.woodwhales.music.service.music.impl.MusicServiceImpl;

@EnableTransactionManagement(proxyTargetClass=true)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		MusicServiceImpl musicService = SpringUtil.getBean(MusicServiceImpl.class);
		musicService.washLink();
	}

}
