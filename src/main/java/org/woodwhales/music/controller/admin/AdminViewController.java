package org.woodwhales.music.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.woodwhales.music.enums.MusicPlatformTypeEnum;
import org.woodwhales.music.model.MusicDetailInfo;
import org.woodwhales.music.service.music.MusicStoreService;
import org.woodwhales.music.service.music.impl.MusicServiceImpl;
import org.woodwhales.music.service.sysConfig.SysConfigService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @projectName: woodwhales-music
 * @author: woodwhales
 * @date: 20.8.3 22:15
 * @description:
 */
@CrossOrigin
@RequestMapping("/admin")
@Controller
public class AdminViewController {

    @Autowired
    private MusicServiceImpl musicService;

    @Autowired
    private MusicStoreService musicStoreService;

    @GetMapping("")
    public String index(Model model) {
        SysConfigService.addMusicSite(model);
        return "redirect:admin/";
    }

    @GetMapping({"/"})
    public String home(Model model) {
        SysConfigService.addMusicSite(model);
        return "admin2/index";
    }

    @GetMapping({"/index"})
    public String home2(Model model) {
        SysConfigService.addMusicSite(model);
        return "admin2/index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        SysConfigService.addMusicSite(model);
        return "admin2/login";
    }

    @GetMapping("/404")
    public String notFound(Model model) {
        SysConfigService.addMusicSite(model);
        return "admin2/404";
    }

    @GetMapping("/two-factor")
    public String twoFactor(Model model) throws IOException {
        SysConfigService.addMusicSite(model);
        return "admin2/two-factor";
    }

    @GetMapping({"sysConfig"})
    public String sysConfig(Model model) {
        SysConfigService.addMusicSite(model);
        return "admin2/sysConfig";
    }

    @GetMapping({"add"})
    public String add(@RequestParam(required = false) Long id, Model model) {
        List<MusicPlatformTypeEnum> musicPlatformTypes = Arrays.asList(MusicPlatformTypeEnum.values());
        model.addAttribute("musicPlatformTypes", musicPlatformTypes);
        model.addAttribute("musicStore", musicStoreService.getMusicStore());

        MusicDetailInfo musicDetailInfo = null;
        if(Objects.nonNull(id)) {
            musicDetailInfo = musicService.getMusicDetailInfoById(id);
        }
        SysConfigService.addMusicSite(model);
        model.addAttribute("music", musicDetailInfo);
        return "admin2/add";
    }

    @GetMapping({"edit"})
    public String edit(@RequestParam Long id, Model model) {
        if(Objects.isNull(id)) {
            return "redirect:admin/";
        }
        model.addAttribute("musicStore", musicStoreService.getMusicStore());
        List<MusicPlatformTypeEnum> musicPlatformTypes = Arrays.asList(MusicPlatformTypeEnum.values());
        model.addAttribute("musicPlatformTypes", musicPlatformTypes);
        SysConfigService.addMusicSite(model);
        return "add";
    }

    @GetMapping({"export"})
    public String export(Model model) {
        SysConfigService.addMusicSite(model);
        return "admin2/export";
    }

}
