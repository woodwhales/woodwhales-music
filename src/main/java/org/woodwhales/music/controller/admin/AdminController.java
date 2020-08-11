package org.woodwhales.music.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.woodwhales.music.model.MusicDetailInfo;
import org.woodwhales.music.service.MusicService;

import java.util.Objects;

/**
 * @projectName: woodwhales-music
 * @author: woodwhales
 * @date: 20.8.3 22:15
 * @description:
 */
@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private MusicService musicService;

    @GetMapping("")
    public String index() {
        return "redirect:admin/";
    }

    @GetMapping({"/"})
    public String home() {
        return "admin/index";
    }

    @GetMapping({"add"})
    public String add() {
        return "admin/add";
    }

    @GetMapping({"edit"})
    public String edit(@RequestParam Long id, Model model) {
        if(Objects.isNull(id)) {
            return "redirect:admin/";
        }
        MusicDetailInfo musicDetailInfo = musicService.getMusicDetailInfoById(id);
        model.addAttribute("music", musicDetailInfo);
        return "admin/edit";
    }

    @GetMapping("login")
    public String login() {
        return "admin/login";
    }
}
