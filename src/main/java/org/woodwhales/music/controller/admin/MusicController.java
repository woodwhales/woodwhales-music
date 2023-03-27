package org.woodwhales.music.controller.admin;

import cn.woodwhales.common.model.vo.LayuiPageVO;
import cn.woodwhales.common.model.vo.RespVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.woodwhales.music.controller.param.*;
import org.woodwhales.music.controller.util.JsonUtil;
import org.woodwhales.music.model.MusicListInfo;
import org.woodwhales.music.model.MusicSimpleInfo;
import org.woodwhales.music.service.music.MusicService;

import java.util.Objects;

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
	public RespVO<Boolean> createMusic(@Validated @RequestBody MusicCreateRequestBody requestBody) {
		log.info("requestBody = {}", JsonUtil.toString(requestBody));
		return RespVO.success(musicService.createMusic(requestBody));
	}

	@PostMapping("exportMusic")
	public RespVO<MusicListInfo> exportMusic() {
		return RespVO.success(musicService.exportMusic());
	}

	@PostMapping("/createOrUpdateMusic")
	public RespVO<Boolean> createOrUpdateMusic(@Validated @RequestBody MusicCreateOrUpdateRequestBody requestBody) {
		log.info("requestBody = {}", JsonUtil.toString(requestBody));
		requestBody.trim();
		if(Objects.isNull(requestBody.getId())) {
			MusicCreateRequestBody param = new MusicCreateRequestBody();
			BeanUtils.copyProperties(requestBody, param);
			musicService.createMusic(param);
		} else {
			MusicUpdateRequestBody param = new MusicUpdateRequestBody();
			BeanUtils.copyProperties(requestBody, param);
			musicService.updateMusic(param);
		}
		return RespVO.success();
	}

	@PostMapping("/pageMusic")
	public LayuiPageVO<MusicSimpleInfo> pageMusic(@RequestBody PageMusicQueryRequestParam param) {
		return musicService.pageMusic(param);
	}

	@PostMapping("/deleteMusic")
	public RespVO<Boolean> deleteMusic(@Validated @RequestBody MusicDeleteRequestBody requestBody) {
		log.info("requestBody = {}", JsonUtil.toString(requestBody));
		return RespVO.success(musicService.deleteMusic(requestBody));
	}

	@PostMapping("/updateMusic")
	public RespVO<Boolean> updateMusic(@Validated @RequestBody MusicUpdateRequestBody requestBody) {
		log.info("requestBody = {}", JsonUtil.toString(requestBody));
		return RespVO.success(musicService.updateMusic(requestBody));
	}

}
