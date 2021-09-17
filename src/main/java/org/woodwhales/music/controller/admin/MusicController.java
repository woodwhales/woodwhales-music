package org.woodwhales.music.controller.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.woodwhales.music.controller.param.MusicCreateRequestBody;
import org.woodwhales.music.controller.param.MusicDeleteRequestBody;
import org.woodwhales.music.controller.param.MusicUpdateRequestBody;
import org.woodwhales.music.controller.param.PageMusicQueryRequestParam;
import org.woodwhales.music.controller.resp.BaseVO;
import org.woodwhales.music.controller.resp.PageBaseVO;
import org.woodwhales.music.controller.util.JsonUtil;
import org.woodwhales.music.model.MusicSimpleInfo;
import org.woodwhales.music.service.music.MusicService;

import java.util.List;

/**
 * @author woodwhales
 */
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

	@GetMapping("/pageMusic")
	public PageBaseVO<List<MusicSimpleInfo>> pageMusic(PageMusicQueryRequestParam param) {
		return musicService.pageMusic(param);
	}

	@PostMapping("/deleteMusic")
	public BaseVO<Void> deleteMusic(@Validated @RequestBody MusicDeleteRequestBody requestBody) {
		log.info("requestBody = {}", JsonUtil.toString(requestBody));
		return BaseVO.returnResp(musicService.deleteMusic(requestBody));
	}

	@PostMapping("/updateMusic")
	public BaseVO<Void> updateMusic(@Validated @RequestBody MusicUpdateRequestBody requestBody) {
		log.info("requestBody = {}", JsonUtil.toString(requestBody));
		return BaseVO.returnResp(musicService.updateMusic(requestBody));
	}

}
