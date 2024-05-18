package org.woodwhales.music.controller.admin;

import cn.woodwhales.common.model.vo.RespVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.woodwhales.music.controller.param.TwoFactorVerifyParam;
import org.woodwhales.music.model.GenerateVo;
import org.woodwhales.music.model.UserMeVo;
import org.woodwhales.music.service.sysAuth.SysAuthService;

/**
 * @author woodwhales on 2024-05-12 20:35
 */
@Slf4j
@RequestMapping("admin")
@RestController
public class SysAuthController {

    @Autowired
    private SysAuthService sysAuthService;

    /**
     * 开启、关闭 2FA
     */
    @PostMapping("/two-factor/disable")
    public RespVO<Void> disable() {
        return RespVO.resp(sysAuthService.disableTwoFactor());
    }

    @PostMapping("/two-factor/generate")
    public RespVO<GenerateVo> generate() {
        return RespVO.resp(sysAuthService.generate());
    }

    @PostMapping("/two-factor/enable")
    public RespVO<Void> enable(@RequestBody TwoFactorVerifyParam param) {
        return RespVO.resp(sysAuthService.enableTwoFactor(param));
    }

    @PostMapping("/two-factor/verify")
    public void verify(HttpServletRequest request, HttpServletResponse response,
                       @RequestBody TwoFactorVerifyParam param) throws Exception {
        sysAuthService.verify(request, response, param);
    }

    @PostMapping("/user/me")
    public RespVO<UserMeVo> userMe() {
        return RespVO.resp(sysAuthService.userMe());
    }

}
