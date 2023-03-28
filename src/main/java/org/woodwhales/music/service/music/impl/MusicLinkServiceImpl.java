package org.woodwhales.music.service.music.impl;

import cn.woodwhales.common.business.DataTool;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.woodwhales.music.config.AppConfig;
import org.woodwhales.music.entity.MusicLink;
import org.woodwhales.music.enums.MusicLinkSourceEnum;
import org.woodwhales.music.enums.MusicLinkTypeEnum;
import org.woodwhales.music.mapper.MusicLinkMapper;
import org.woodwhales.music.model.MusicInfoLinkDetailVo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author woodwhales on 2023-03-28 11:50
 */
@Slf4j
@Primary
@Service
@Transactional(rollbackFor = Exception.class)
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

    public List<MusicInfoLinkDetailVo> getLinkDetailVoListByMusicId(Long musicId) {
        List<MusicLink> list = this.list(Wrappers.<MusicLink>lambdaQuery()
                .eq(MusicLink::getMusicId, musicId));
        List<MusicInfoLinkDetailVo> result = new ArrayList<>();

        if(CollectionUtils.isNotEmpty(list)) {
            Map<Integer, List<MusicLink>> mapping = DataTool.groupingBy(list, MusicLink::getLinkSource);
            for (MusicLinkSourceEnum musicLinkSourceEnum : MusicLinkSourceEnum.values()) {
                List<MusicLink> musicLinkList = mapping.get(musicLinkSourceEnum.getCode());
                MusicInfoLinkDetailVo detailVo = new MusicInfoLinkDetailVo();
                detailVo.setLinkSource(musicLinkSourceEnum.getCode());
                detailVo.setLinkSourceName(musicLinkSourceEnum.getDesc());
                fillLinkUrl(musicLinkList, MusicLinkTypeEnum.COVER_LINK, detailVo::setCoverUrl);
                fillLinkUrl(musicLinkList, MusicLinkTypeEnum.AUDIO_LINK, detailVo::setAudioUrl);
                result.add(detailVo);
            }
        }
        return result;
    }

    private static void fillLinkUrl(List<MusicLink> musicLinkList,
                                    MusicLinkTypeEnum musicLinkTypeEnum,
                                    Consumer<String> setLinkUrlConsumer) {
        List<MusicLink> linkList = DataTool.filter(musicLinkList, link -> musicLinkTypeEnum.match(link.getLinkType()));
        if(CollectionUtils.isNotEmpty(linkList)) {
            setLinkUrlConsumer.accept(linkList.get(0).getLinkUrl());
        }
    }
}
