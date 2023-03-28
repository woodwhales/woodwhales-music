package org.woodwhales.music.service.music.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.woodwhales.music.config.AppConfig;
import org.woodwhales.music.entity.MusicLink;
import org.woodwhales.music.mapper.MusicLinkMapper;

import java.util.Collections;
import java.util.List;

/**
 * @author woodwhales on 2023-03-28 11:50
 */
@Slf4j
@Primary
@Service
public class MusicLinkServiceImpl extends ServiceImpl<MusicLinkMapper, MusicLink> {

    @Autowired
    private AppConfig appConfig;

    public List<MusicLink> getLinkInfoListByMusicId(Long musicId) {
        return this.list(Wrappers.<MusicLink>lambdaQuery()
                .eq(MusicLink::getMusicId, musicId));
    }

    public List<MusicLink> getLinkInfoListByMusicIds(List<Long> musicIdList) {
        if(CollectionUtils.isEmpty(musicIdList)) {
            return Collections.emptyList();
        }
        return this.list(Wrappers.<MusicLink>lambdaQuery()
                .eq(MusicLink::getLinkSource, appConfig.getMusicLinkSourceEnum().getCode())
                .in(MusicLink::getMusicId, musicIdList));
    }
}
