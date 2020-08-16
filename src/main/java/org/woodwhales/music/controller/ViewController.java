package org.woodwhales.music.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.woodwhales.music.model.MusicInfo;
import org.woodwhales.music.service.music.MusicService;

import java.util.List;

/**
 * 视图控制器
 * @author woodwhales
 */
@Slf4j
@Controller
public class ViewController {

	@Qualifier("musicServiceImpl")
	@Autowired
	private MusicService musicService;

	@GetMapping({"", "index"})
	public String index(Model model) {
		List<MusicInfo> musicInfos = musicService.listMusic();
		model.addAttribute("musicInfoList", musicService.listMusic());
		return "index";
	}
	
}
