package org.woodwhales.music.controller.admin;

import cn.woodwhales.common.model.vo.RespVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.woodwhales.music.controller.param.SysConfigCreateOrUpdateRequestBody;
import org.woodwhales.music.controller.param.SysConfigGetRequestBody;
import org.woodwhales.music.controller.util.JsonUtil;
import org.woodwhales.music.model.SysConfigVo;
import org.woodwhales.music.service.sysConfig.SysConfigService;

/**
 * @author woodwhales on 2024-05-08 17:23
 */
@Slf4j
@RequestMapping("admin/sysConfig")
@RestController
public class SysConfigController {

    @Autowired
    private SysConfigService service;

    /**
     * 保存或更新配置
     * @param requestBody
     * @return
     */
    @PostMapping("/createOrUpdate")
    public RespVO<Void> createOrUpdateMusic(@Validated @RequestBody SysConfigCreateOrUpdateRequestBody requestBody) {
        log.info("requestBody = {}", JsonUtil.toString(requestBody));
        return RespVO.resp(service.createOrUpdate(requestBody));
    }

    /**
     * 获取配置
     * @param requestBody
     * @return
     */
    @PostMapping("/getConfig")
    public RespVO<SysConfigVo> getConfig(@Validated @RequestBody SysConfigGetRequestBody requestBody) {
        log.info("requestBody = {}", JsonUtil.toString(requestBody));
        return RespVO.resp(service.getConfig(requestBody));
    }
}
