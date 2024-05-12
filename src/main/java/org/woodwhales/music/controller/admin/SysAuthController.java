package org.woodwhales.music.controller.admin;

import cn.woodwhales.common.model.vo.RespVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.woodwhales.music.controller.param.EnableTwoFactorParam;
import org.woodwhales.music.service.sysAuth.SysAuthService;

/**
 * @author woodwhales on 2024-05-12 20:35
 */
@Slf4j
@RequestMapping("admin/sysAuth")
@RestController
public class SysAuthController {

    @Autowired
    private SysAuthService sysAuthService;

    /**
     * 开启、关闭 2FA
     */
    @PostMapping("enableTwoFactor")
    public RespVO<Void> enableTwoFactor(@RequestBody EnableTwoFactorParam param) {
        return RespVO.resp(sysAuthService.enableTwoFactor(param));
    }



}
