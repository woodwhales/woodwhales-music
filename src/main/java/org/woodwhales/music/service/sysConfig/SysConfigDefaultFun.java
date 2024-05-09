package org.woodwhales.music.service.sysConfig;

import java.util.Map;

/**
 * configKey 对应的 SysConfig 数据库配置信息为空时，系统配置的默认值
 * @author woodwhales on 2024-05-09 13:47
 */
public interface SysConfigDefaultFun {

    String configKey();

    Map<String, Object> defaultConfig();

}
