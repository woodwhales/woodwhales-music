package org.woodwhales.music.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.woodwhales.music.config.AppConfig;
import org.woodwhales.music.model.MusicInfoVo;
import org.woodwhales.music.service.music.impl.MusicServiceImpl;

import java.util.List;

/**
 * 视图控制器
 * @author woodwhales
 */
@Slf4j
@Controller
public class ViewController {

	@Autowired
	private MusicServiceImpl musicService;

	@Autowired
	private AppConfig appConfig;

	@GetMapping({"", "index"})
	public String index(Model model) {
		List<MusicInfoVo> musicInfoVoList = musicService.listMusic();
		model.addAttribute("musicInfoList", musicInfoVoList);
		model.addAttribute("githubUrl", appConfig.getGithubUrl());
		model.addAttribute("githubShow", appConfig.isGithubShow());
		return "index";
	}
	
}
