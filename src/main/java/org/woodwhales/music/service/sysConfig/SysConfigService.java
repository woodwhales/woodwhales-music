package org.woodwhales.music.service.sysConfig;

import cn.woodwhales.common.model.result.OpResult;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.woodwhales.music.config.AppConfig;
import org.woodwhales.music.controller.param.SysConfigCreateOrUpdateRequestBody;
import org.woodwhales.music.controller.param.SysConfigGetRequestBody;
import org.woodwhales.music.entity.SysConfig;
import org.woodwhales.music.mapper.SysConfigMapper;
import org.woodwhales.music.model.SysConfigVo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author woodwhales on 2024-05-08 17:35
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SysConfigService extends ServiceImpl<SysConfigMapper, SysConfig> {

    @Autowired
    private AppConfig appConfig;

    public OpResult<Void> createOrUpdate(SysConfigCreateOrUpdateRequestBody requestBody) {
        SysConfig sysConfig = this.getOne(Wrappers.<SysConfig>lambdaQuery()
                .eq(SysConfig::getConfigKey, requestBody.getConfigKey()));
        if(Objects.isNull(sysConfig)) {
            sysConfig = new SysConfig();
            sysConfig.setConfigKey(requestBody.getConfigKey());
        }
        sysConfig.setConfigContent(JSON.toJSONString(requestBody.getContent()));
        this.saveOrUpdate(sysConfig);
        return OpResult.success();
    }

    public OpResult<SysConfigVo> getConfig(SysConfigGetRequestBody requestBody) {
        SysConfig sysConfig = this.getOne(Wrappers.<SysConfig>lambdaQuery()
                .eq(SysConfig::getConfigKey, requestBody.getConfigKey()));
        if(Objects.isNull(sysConfig)) {
            sysConfig = new SysConfig();
            sysConfig.setConfigKey("home");
            Map<String, Object> content = new HashMap<>();
            content.put("gitHubCornersShow", appConfig.isGithubShow());
            content.put("gitHubCornersUrl", appConfig.getGithubUrl());
            content.put("authorName", appConfig.getAuthorName());
            content.put("authorWebsite", appConfig.getAuthorWebsite());
            sysConfig.setConfigContent(JSON.toJSONString(content));
        }
        SysConfigVo sysConfigVo = new SysConfigVo();
        sysConfigVo.setConfigKey(sysConfig.getConfigKey());
        sysConfigVo.setContent(JSON.parseObject(sysConfig.getConfigContent()));
        return OpResult.success(sysConfigVo);
    }

}
