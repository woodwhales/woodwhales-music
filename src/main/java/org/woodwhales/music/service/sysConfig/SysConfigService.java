package org.woodwhales.music.service.sysConfig;

import cn.hutool.extra.spring.SpringUtil;
import cn.woodwhales.common.model.result.OpResult;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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
import org.woodwhales.music.service.SysConfigCacheService;

import java.math.BigDecimal;
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
    @Lazy
    private SysConfigCacheService sysConfigCacheService;

    @Autowired
    private Map<String, SysConfigDefaultFun<?>> sysConfigDefaultFunMap;

    public OpResult<Void> createOrUpdate(SysConfigCreateOrUpdateRequestBody requestBody) {
        this.sysConfigCacheService.put(requestBody.getConfigKey(), requestBody.getContent());
        return OpResult.success();
    }

    public OpResult<SysConfigVo> getConfig(SysConfigGetRequestBody requestBody) {
        String configKey = requestBody.getConfigKey();
        SysConfig sysConfig = this.getOne(Wrappers.<SysConfig>lambdaQuery()
                .eq(SysConfig::getConfigKey, configKey));
        if(Objects.isNull(sysConfig)) {
            SysConfigDefaultFun<?> defaultFun = this.findDefaultFun(configKey);
            sysConfig.setConfigContent(JSON.toJSONString(defaultFun.defaultConfig()));
        }
        SysConfigVo sysConfigVo = new SysConfigVo();
        sysConfigVo.setConfigKey(configKey);
        sysConfigVo.setContent(JSON.parseObject(sysConfig.getConfigContent()));
        return OpResult.success(sysConfigVo);
    }

    public SysConfigDefaultFun<?> findDefaultFun(String configKey) {
        for (SysConfigDefaultFun<?> sysConfigDefaultFun : sysConfigDefaultFunMap.values()) {
            if (StringUtils.equals(sysConfigDefaultFun.configKey(), configKey)) {
                return sysConfigDefaultFun;
            }
        }
        return null;
    }

    private static String[] default_keys = new String[] {AdminSysConfigDefault.KEY,
                                                            HomeSysConfigDefault.KEY,
                                                            VisitSysConfigDefault.KEY,
                                                            ClicksSysConfigDefault.KEY};

    public static void addMusicSite(Model model, String ...keys) {
        SysConfigService sysConfigService = SpringUtil.getBean(SysConfigService.class);
        sysConfigService.recordVisits();

        SysConfigCacheService sysConfigCacheService = SpringUtil.getBean(SysConfigCacheService.class);
        if (ObjectUtils.isEmpty(keys)) {
            keys = default_keys;
        }
        for (String key : keys) {
            model.addAttribute(key, sysConfigCacheService.get(key));
        }
    }

    public void recordVisits() {
        VisitSysConfigDefault.Content content = this.sysConfigCacheService.get(VisitSysConfigDefault.KEY, VisitSysConfigDefault.Content.class);
        content.setCount(content.getCount().add(BigDecimal.ONE));
        this.sysConfigCacheService.put(VisitSysConfigDefault.KEY, content);
    }

    public Map<String, Object> recordPlay() {
        Map<String, Object> result = new HashMap<>();
        ClicksSysConfigDefault.Content content = this.sysConfigCacheService.get(ClicksSysConfigDefault.KEY, ClicksSysConfigDefault.Content.class);
        content.setCount(content.getCount().add(BigDecimal.ONE));
        this.sysConfigCacheService.put(ClicksSysConfigDefault.KEY, content);

        result.put(ClicksSysConfigDefault.KEY, content);
        result.put(VisitSysConfigDefault.KEY, this.sysConfigCacheService.get(VisitSysConfigDefault.KEY));
        return result;
    }

    @Async(ThreadPoolConfig.COMMON_POOL_NAME)
    public void asyncSaveOrUpdate(String key, String content) {
        SysConfig sysConfig = this.getOne(Wrappers.<SysConfig>lambdaQuery()
                .eq(SysConfig::getConfigKey, key));
        if(Objects.isNull(sysConfig)) {
            sysConfig = new SysConfig();
            sysConfig.setConfigKey(key);
        }
        sysConfig.setConfigContent(content);
        this.saveOrUpdate(sysConfig);
    }
}
