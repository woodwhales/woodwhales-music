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
import org.woodwhales.music.service.music.impl.MusicServiceImpl;

import java.util.Objects;

/**
 * @author woodwhales
 */
@Slf4j
@RequestMapping("admin")
@RestController
public class MusicController {
	
	@Autowired
	private MusicServiceImpl musicService;

	/**
	 * 创建音乐
	 * @param requestBody
	 * @return
	 */
	@PostMapping("/createMusic")
	public RespVO<Boolean> createMusic(@Validated @RequestBody MusicCreateRequestBody requestBody) {
		log.info("requestBody = {}", JsonUtil.toString(requestBody));
		return RespVO.success(musicService.createMusic(requestBody));
	}

	/**
	 * 导出音乐
	 * @return
	 */
	@PostMapping("exportMusic")
	public RespVO<MusicListInfo> exportMusic() {
		return RespVO.success(musicService.exportMusic());
	}

	/**
	 * 保存或更新音乐
	 * @param requestBody
	 * @return
	 */
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

	/**
	 * 分页查询音乐
	 * @param param
	 * @return
	 */
	@PostMapping("/pageMusic")
	public LayuiPageVO<MusicSimpleInfo> pageMusic(@RequestBody PageMusicQueryRequestParam param) {
		return musicService.pageMusic(param);
	}

	/**
	 * 删除音乐
	 * @param requestBody
	 * @return
	 */
	@PostMapping("/deleteMusic")
	public RespVO<Boolean> deleteMusic(@Validated @RequestBody MusicDeleteRequestBody requestBody) {
		log.info("requestBody = {}", JsonUtil.toString(requestBody));
		return RespVO.success(musicService.deleteMusic(requestBody));
	}

	/**
	 * 更新音乐
	 * @param requestBody
	 * @return
	 */
	@PostMapping("/updateMusic")
	public RespVO<Boolean> updateMusic(@Validated @RequestBody MusicUpdateRequestBody requestBody) {
		log.info("requestBody = {}", JsonUtil.toString(requestBody));
		return RespVO.success(musicService.updateMusic(requestBody));
	}

}
