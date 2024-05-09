package org.woodwhales.music.controller;

import cn.woodwhales.common.model.result.OpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.woodwhales.music.controller.param.SysConfigGetRequestBody;
import org.woodwhales.music.model.MusicInfoVo;
import org.woodwhales.music.model.SysConfigVo;
import org.woodwhales.music.service.music.impl.MusicServiceImpl;
import org.woodwhales.music.service.sysConfig.SysConfigService;

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
	private SysConfigService sysConfigService;


	@GetMapping({"", "index"})
	public String index(Model model) {
		List<MusicInfoVo> musicInfoVoList = musicService.listMusic();
		model.addAttribute("musicInfoList", musicInfoVoList);
		OpResult<SysConfigVo> opResult = sysConfigService.getConfig(new SysConfigGetRequestBody("home"));
		if(opResult.isFailure()) {
			SysConfigVo sysConfigVo = new SysConfigVo();

			opResult = OpResult.success(sysConfigVo);
		}
		model.addAttribute(opResult.getData().getConfigKey(), opResult.getData().getContent());
		return "index";
	}
	
}
