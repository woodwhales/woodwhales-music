package org.woodwhales.music.controller;

import cn.woodwhales.common.model.result.OpResult;
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
import org.woodwhales.music.service.sysConfig.ClicksSysConfigDefault;
import org.woodwhales.music.service.sysConfig.SysConfigService;
import org.woodwhales.music.service.sysConfig.VisitSysConfigDefault;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
	public RespVO<Map<String, Object>> play(@Validated @RequestBody ClickPlayParam param) {
		sysConfigService.recordPlay();
		OpResult<Map<String, Object>> opResult = sysConfigService.getConfig(Arrays.asList(VisitSysConfigDefault.KEY, ClicksSysConfigDefault.KEY));
		return RespVO.resp(opResult);
	}
}
