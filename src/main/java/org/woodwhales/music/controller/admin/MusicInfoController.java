package org.woodwhales.music.controller.admin;

import cn.woodwhales.common.model.vo.LayuiPageVO;
import cn.woodwhales.common.model.vo.RespVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.woodwhales.music.controller.param.*;
import org.woodwhales.music.controller.util.JsonUtil;
import org.woodwhales.music.model.MusicDetailInfo;
import org.woodwhales.music.model.MusicInfoLinkDetailVo;
import org.woodwhales.music.model.MusicListInfo;
import org.woodwhales.music.model.MusicSimpleInfo;
import org.woodwhales.music.service.music.impl.MusicServiceImpl;

import java.util.List;

/**
 * @author woodwhales
 */
@Slf4j
@RequestMapping("admin")
@RestController
public class MusicInfoController {
	
	@Autowired
	private MusicServiceImpl musicService;

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
		musicService.createOrUpdate(requestBody);
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
	 * 查询音乐详情
	 * @param requestBody
	 * @return
	 */
	@PostMapping("/detailMusic")
	public RespVO<MusicDetailInfo> detailMusic(@Validated @RequestBody MusicDetailRequestBody requestBody) {
		log.info("requestBody = {}", JsonUtil.toString(requestBody));
		return RespVO.success(musicService.getMusicDetailInfoById(requestBody.getId()));
	}

	@GetMapping("/getLinkList")
	public RespVO<List<MusicInfoLinkDetailVo>> getLinkList() {
		return RespVO.success(musicService.getLinkList());
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

}
