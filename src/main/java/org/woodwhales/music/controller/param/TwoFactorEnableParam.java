package org.woodwhales.music.controller.param;

import lombok.Data;

/**
 * @author woodwhales on 2024-05-12 21:42
 */
@Data
public class TwoFactorEnableParam {

    /**
     * 是否开启 2FA
     */
    private boolean twoFactorEnabled;

    /**
     * 验证码
     */
    private String code;

}
