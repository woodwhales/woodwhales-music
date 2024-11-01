package org.woodwhales.music.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.woodwhales.music.model.MusicInfoVo;
import org.woodwhales.music.service.music.impl.MusicServiceImpl;
import org.woodwhales.music.service.sysConfig.SysConfigService;

import java.util.List;

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

	@GetMapping({"", "index"})
	public String index(Model model) {
		List<MusicInfoVo> musicInfoVoList = musicService.listMusic();
		model.addAttribute("musicInfoList", musicInfoVoList);
		SysConfigService.addMusicSite(model);
		return "index";
	}

	@ResponseBody
	@PostMapping({"clickPlay"})
	public String play() {
		log.info("play");
		return "ok";
	}
}
