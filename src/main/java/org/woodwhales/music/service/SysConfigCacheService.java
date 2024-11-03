package org.woodwhales.music.service;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.woodwhales.music.entity.SysConfig;
import org.woodwhales.music.service.sysConfig.fun.SysConfigDefaultFun;
import org.woodwhales.music.service.sysConfig.SysConfigService;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author woodwhales on 2024-11-02 14:24
 */
@Service
@Slf4j
public class SysConfigCacheService {

    @Autowired
    private SysConfigService sysConfigService;

    private LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder().build(new CacheLoader<String, String>() {
        @Override
        public String load(String key) throws Exception {
            SysConfig sysConfig = sysConfigService.lambdaQuery()
                    .eq(SysConfig::getConfigKey, key)
                    .one();
            if(Objects.isNull(sysConfig)) {
                SysConfigDefaultFun<?> defaultFun = sysConfigService.findDefaultFun(key);
                Object object = defaultFun.defaultConfig();
                if(ObjectUtils.isEmpty(object)) {
                    object = new HashMap<>();
                }
                String value = JSON.toJSONString(object);
                log.warn("load default value for key={}, value={}", key, value);
                return value;
            }
            return sysConfig.getConfigContent();
        }
    });

    public JSONObject get(String key) {
        try {
            String content = loadingCache.get(key);
            return JSON.parseObject(content);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T get(String key, Class<T> clazz) {
        try {
            String content = loadingCache.get(key);
            return JSON.parseObject(content, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T> void put(String key, T value) {
        String content = value instanceof String ? value.toString() : JSON.toJSONString(value);
        loadingCache.put(key, content);
        sysConfigService.asyncSaveOrUpdate(key, content);
    }

}
