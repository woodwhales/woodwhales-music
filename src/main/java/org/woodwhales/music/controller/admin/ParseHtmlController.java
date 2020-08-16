package org.woodwhales.music.controller.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.woodwhales.music.controller.param.ParseMusicRequestBody;
import org.woodwhales.music.controller.resp.BaseVO;
import org.woodwhales.music.model.HtmlContent;
import org.woodwhales.music.service.parse.ParseMusicPlatformHtmlService;

/**
 * @projectName: woodwhales-music
 * @author: woodwhales
 * @date: 20.8.15 20:02
 * @description:
 */
@Slf4j
@RequestMapping("admin")
@RestController
public class ParseHtmlController {

    @Autowired
    private ParseMusicPlatformHtmlService parseHtmlService;

    @PostMapping("parse")
    public BaseVO<HtmlContent> parse(@Validated @RequestBody ParseMusicRequestBody requestBody) {
        String platformType = requestBody.getPlatformType();
        String content = requestBody.getContent();
        HtmlContent htmlContent = parseHtmlService.parse(platformType, content);
        return BaseVO.returnResp(htmlContent);
    }
}
