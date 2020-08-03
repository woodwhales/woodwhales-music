package org.woodwhales.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.woodwhales.music.service.MusicService;

/**
 * 视图控制器
 * @author woodwhales
 */
@Controller
public class ViewController {
	
	@Autowired
	private MusicService musicService;

	@GetMapping({"", "index"})
	public String index(Model model) {
		model.addAttribute("musicInfoList", musicService.listMusic());
		return "index";
	}
	
}
