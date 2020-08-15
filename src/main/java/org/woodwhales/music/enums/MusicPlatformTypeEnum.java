package org.woodwhales.music.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.woodwhales.music.service.MusicPlatformParser;
import org.woodwhales.music.service.impl.WangYiYunMusicPlatformParser;

/**
 * @projectName: woodwhales-music
 * @author: woodwhales
 * @date: 20.8.15 22:24
 * @description:
 */
@Getter
public enum MusicPlatformTypeEnum {

    /**
     * 网易云音乐
     */
    WANG_YI_YUN("WANG_YI_YUN", WangYiYunMusicPlatformParser.class,"网易云"),

    /**
     * QQ音乐
     */
    QQ_MUSIC("QQ_MUSIC", null,"QQ音乐"),

    /**
     * 虾米音乐
     */
    XIA_MI_MUSIC("XIA_MI_MUSIC", null,"网易云"),
    ;

    MusicPlatformTypeEnum(String platform, Class serviceClass, String desc) {
        this.platform = platform;
        this.serviceClass = serviceClass;
        this.desc = desc;

    }

    private String platform;
    private Class<MusicPlatformParser> serviceClass;
    private String desc;

    public static MusicPlatformTypeEnum ofPlatform(String platform) {
        MusicPlatformTypeEnum[] musicPlatformTypeEnum = MusicPlatformTypeEnum.values();
        for (MusicPlatformTypeEnum platformTypeEnum : musicPlatformTypeEnum) {
            if(StringUtils.equals(platform, platformTypeEnum.getPlatform())) {
                return platformTypeEnum;
            }
        }
        return null;
    }

    /**
     * 是否匹配
     * @param platformType
     * @return
     */
    public boolean isMatch(String platformType) {
        return StringUtils.equals(this.platform, platformType);
    }
}
