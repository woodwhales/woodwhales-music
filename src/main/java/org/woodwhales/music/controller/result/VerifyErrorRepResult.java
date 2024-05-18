package org.woodwhales.music.controller.result;

import cn.woodwhales.common.model.result.BaseRespResult;

/**
 * @author woodwhales on 2024-05-19 0:21
 */
public class VerifyErrorRepResult implements BaseRespResult {

    @Override
    public String getMessage() {
        return "验证码无效";
    }

    @Override
    public Integer getCode() {
        return 403;
    }
}
