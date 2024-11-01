package org.woodwhales.music.service.sysConfig;

import cn.hutool.extra.spring.SpringUtil;
import cn.woodwhales.common.model.result.OpResult;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.woodwhales.music.config.ThreadPoolConfig;
import org.woodwhales.music.controller.param.SysConfigCreateOrUpdateRequestBody;
import org.woodwhales.music.controller.param.SysConfigGetRequestBody;
import org.woodwhales.music.entity.SysConfig;
import org.woodwhales.music.mapper.SysConfigMapper;
import org.woodwhales.music.model.SysConfigVo;

import java.math.BigDecimal;
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
    private Map<String, SysConfigDefaultFun> sysConfigDefaultFunMap;

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

    public SysConfig letConfigByKey(String key) {
        SysConfig sysConfig = this.getOne(Wrappers.<SysConfig>lambdaQuery()
                .eq(SysConfig::getConfigKey, key));
        if(Objects.isNull(sysConfig)) {
            sysConfig = this.matchDefault(key);
        }
        return sysConfig;
    }

    public OpResult<SysConfigVo> getConfig(SysConfigGetRequestBody requestBody) {
        SysConfig sysConfig = this.getOne(Wrappers.<SysConfig>lambdaQuery()
                .eq(SysConfig::getConfigKey, requestBody.getConfigKey()));
        if(Objects.isNull(sysConfig)) {
            sysConfig = this.matchDefault(requestBody.getConfigKey());
            if(Objects.isNull(sysConfig)) {
                return OpResult.failure();
            }
        }
        SysConfigVo sysConfigVo = new SysConfigVo();
        sysConfigVo.setConfigKey(sysConfig.getConfigKey());
        sysConfigVo.setContent(JSON.parseObject(sysConfig.getConfigContent()));
        return OpResult.success(sysConfigVo);
    }

    private SysConfig matchDefault(String configKey) {
        SysConfig sysConfig = null;
        for (SysConfigDefaultFun sysConfigDefaultFun : sysConfigDefaultFunMap.values()) {
            if (StringUtils.equals(sysConfigDefaultFun.configKey(), configKey)) {
                sysConfig = new SysConfig();
                Map<String, Object> content = sysConfigDefaultFun.defaultConfig();
                sysConfig.setConfigKey(configKey);
                sysConfig.setConfigContent(JSON.toJSONString(content));
                return sysConfig;
            }
        }
        return sysConfig;
    }

    private static String[] default_keys = new String[] {AdminSysConfigDefault.KEY,
                                                            HomeSysConfigDefault.KEY,
                                                            VisitSysConfigDefault.KEY,
                                                            ClicksSysConfigDefault.KEY};

    public static void addMusicSite(Model model, String ...keys) {
        SysConfigService sysConfigService = SpringUtil.getBean(SysConfigService.class);
        if(Objects.isNull(keys) || keys.length == 0) {
            keys = default_keys;
        }
        for (String key : keys) {
            OpResult<SysConfigVo> opResult = sysConfigService.getConfig(new SysConfigGetRequestBody(key));
            model.addAttribute(opResult.getData().getConfigKey(), opResult.getData().getContent());
        }
        sysConfigService.record();
    }

    @Async(ThreadPoolConfig.COMMON_POOL_NAME)
    public void record() {
        SysConfig visitsConfig = this.letConfigByKey(VisitSysConfigDefault.KEY);
        JSONObject jsonObject = JSON.parseObject(visitsConfig.getConfigContent());
        BigDecimal bigDecimal = new BigDecimal(jsonObject.get("count").toString());
        bigDecimal = bigDecimal.add(BigDecimal.ONE);
        jsonObject.put("count", bigDecimal.toString());
        visitsConfig.setConfigContent(jsonObject.toJSONString());
        this.saveOrUpdate(visitsConfig);
    }
}
