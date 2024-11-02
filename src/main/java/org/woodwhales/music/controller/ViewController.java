package org.woodwhales.music.controller;

import cn.woodwhales.common.model.vo.RespVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.woodwhales.music.controller.index.ClickPlayParam;
import org.woodwhales.music.model.MusicInfoVo;
import org.woodwhales.music.service.music.impl.MusicServiceImpl;
import org.woodwhales.music.service.sysConfig.SysConfigService;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 视图控制器
 * @author woodwhales
 */
@Slf4j
@RequestMapping("/")
@Controller
public class ViewController {

	@Autowired
	private MusicServiceImpl musicService;

	@Autowired
	private SysConfigService sysConfigService;

	@GetMapping({"", "index"})
	public String index(Model model) {
		List<MusicInfoVo> musicInfoVoList = musicService.listMusic();
		model.addAttribute("musicInfoList", musicInfoVoList);
		SysConfigService.addMusicSite(model);
		return "index";
	}

	@ResponseBody
	@PostMapping({"clickPlay"})
	public RespVO<Map<String, Object>> play(@RequestParam(value = "t") Long time,
											@Validated @RequestBody ClickPlayParam param) {
		if(!Objects.equals(time, param.getTime())) {
			// TODO go to black list
			return RespVO.errorWithErrorMsg("非法请求");
		}
		Map<String, Object> result = sysConfigService.recordPlay();
		return RespVO.success(result);
	}
}
