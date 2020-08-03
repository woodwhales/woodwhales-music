package org.woodwhales.music.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @projectName: woodwhales-music
 * @author: woodwhales
 * @date: 20.8.3 22:15
 * @description:
 */
@RequestMapping("/admin")
@Controller
public class AdminController {

    @GetMapping({"", "/", "index"})
    public String index() {
        return "admin/index";
    }
}
