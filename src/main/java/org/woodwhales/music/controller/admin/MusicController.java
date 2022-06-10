package org.woodwhales.music.controller.admin;

import cn.woodwhales.common.model.vo.LayuiPageVO;
import cn.woodwhales.common.model.vo.PageRespVO;
import cn.woodwhales.common.model.vo.RespVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.woodwhales.music.controller.param.MusicCreateRequestBody;
import org.woodwhales.music.controller.param.MusicDeleteRequestBody;
import org.woodwhales.music.controller.param.MusicUpdateRequestBody;
import org.woodwhales.music.controller.param.PageMusicQueryRequestParam;
import org.woodwhales.music.controller.util.JsonUtil;
import org.woodwhales.music.model.MusicSimpleInfo;
import org.woodwhales.music.service.music.MusicService;

import javax.swing.plaf.LayerUI;
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
	public RespVO<Boolean> createMusic(@Validated @RequestBody MusicCreateRequestBody requestBody) {
		log.info("requestBody = {}", JsonUtil.toString(requestBody));
		return RespVO.success(musicService.createMusic(requestBody));
	}

	@GetMapping("/pageMusic")
	public LayuiPageVO<MusicSimpleInfo> pageMusic(PageMusicQueryRequestParam param) {
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
