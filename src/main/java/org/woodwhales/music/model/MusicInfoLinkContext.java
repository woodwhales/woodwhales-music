package org.woodwhales.music.model;

import cn.hutool.extra.spring.SpringUtil;
import cn.woodwhales.common.business.DataTool;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.woodwhales.music.config.AppConfig;
import org.woodwhales.music.entity.Music;
import org.woodwhales.music.entity.MusicLink;
import org.woodwhales.music.enums.MusicLinkTypeEnum;
import org.woodwhales.music.service.music.impl.MusicLinkServiceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author woodwhales on 2023-03-28 15:38
 */
@Data
public class MusicInfoLinkContext {
    private List<Music> musicList;
    private Map<Long, MusicLink> audioUrlMapping;
    private Map<Long, MusicLink> coverUrlMapping;

    public String getCoverUrl(Long musicId) {
        if(this.coverUrlMapping.containsKey(musicId)) {
            return this.coverUrlMapping.get(musicId).getLinkUrl();
        } else {
            return null;
        }
    }

    public String getAudioUrl(Long musicId) {
        if(this.audioUrlMapping.containsKey(musicId)) {
            return this.audioUrlMapping.get(musicId).getLinkUrl();
        } else {
            return null;
        }
    }

    public MusicInfoLinkContext(List<Music> musicList) {
        this.musicList = musicList;
        if(CollectionUtils.isNotEmpty(this.musicList)) {
            AppConfig appConfig = SpringUtil.getBean(AppConfig.class);
            MusicLinkServiceImpl musicLinkService = SpringUtil.getBean(MusicLinkServiceImpl.class);
            List<MusicLink> musicLinkList = musicLinkService.getLinkInfoListByMusicIds(DataTool.toList(this.musicList, Music::getId));
            this.audioUrlMapping = DataTool.toMap(DataTool.filter(musicLinkList,
                            musicLink -> MusicLinkTypeEnum.AUDIO_LINK.match(musicLink.getLinkType())
                                    && appConfig.getMusicLinkSourceEnum().match(musicLink.getLinkSource())),
                    MusicLink::getMusicId);
            this.coverUrlMapping = DataTool.toMap(DataTool.filter(musicLinkList,
                            musicLink -> MusicLinkTypeEnum.COVER_LINK.match(musicLink.getLinkType())
                                    && appConfig.getMusicLinkSourceEnum().match(musicLink.getLinkSource())),
                    MusicLink::getMusicId);
        } else {
            this.audioUrlMapping = Collections.emptyMap();
            this.coverUrlMapping = Collections.emptyMap();
        }
    }
}
