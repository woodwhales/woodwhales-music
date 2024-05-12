package org.woodwhales.music.controller.admin;

import cn.woodwhales.common.model.result.OpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.woodwhales.music.controller.param.SysConfigGetRequestBody;
import org.woodwhales.music.enums.MusicPlatformTypeEnum;
import org.woodwhales.music.model.MusicDetailInfo;
import org.woodwhales.music.model.SysConfigVo;
import org.woodwhales.music.security.TwoFactorAuthentication;
import org.woodwhales.music.service.music.MusicStoreService;
import org.woodwhales.music.service.music.impl.MusicServiceImpl;
import org.woodwhales.music.service.sysConfig.SysConfigService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Autowired
    private SysConfigService sysConfigService;

    @GetMapping("")
    public String index(Model model) {
        this.addMusicSite(model);
        return "redirect:admin/";
    }

    @GetMapping({"/"})
    public String home(Model model) {
        this.addMusicSite(model);
        return "admin2/index";
    }

    @GetMapping("/two-factor")
    public String twoFactor(Model model,
                            HttpServletRequest request,
                            HttpServletResponse response) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication.getPrincipal() instanceof TwoFactorAuthentication)) {
            new DefaultRedirectStrategy().sendRedirect(request, response, "/admin/login");
        }
        return "admin2/two-factor";
    }

    private void addMusicSite(Model model) {
        OpResult<SysConfigVo> opResult = sysConfigService.getConfig(new SysConfigGetRequestBody("admin"));
        model.addAttribute(opResult.getData().getConfigKey(), opResult.getData().getContent());
    }

    @GetMapping({"sysConfig"})
    public String sysConfig(Model model) {
        this.addMusicSite(model);
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
        this.addMusicSite(model);
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
        this.addMusicSite(model);
        return "add";
    }

    @GetMapping({"export"})
    public String export(Model model) {
        this.addMusicSite(model);
        return "admin2/export";
    }

    @GetMapping("login")
    public String login() {
        return "admin/login";
    }
}
