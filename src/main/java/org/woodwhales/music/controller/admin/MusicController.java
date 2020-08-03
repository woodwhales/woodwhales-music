package org.woodwhales.music.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.woodwhales.music.controller.param.MusicCreateRequestBody;
import org.woodwhales.music.controller.resp.BaseVO;
import org.woodwhales.music.controller.util.JsonUtil;
import org.woodwhales.music.service.MusicService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("admin")
@RestController
public class MusicController {
	
	@Autowired
	private MusicService musicService;

	@PostMapping("/createMusic")
	public BaseVO<Void> createMusic(@Validated @RequestBody MusicCreateRequestBody requestBody) {
		log.info("requestBody = {}", JsonUtil.toString(requestBody));
		return BaseVO.returnResp(musicService.createMusic(requestBody));
	}
	
}
