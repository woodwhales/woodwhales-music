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
import org.woodwhales.music.entity.Music;
import org.woodwhales.music.entity.MusicLink;
import org.woodwhales.music.enums.MusicLinkSourceEnum;
import org.woodwhales.music.enums.MusicLinkTypeEnum;
import org.woodwhales.music.mapper.MusicLinkMapper;
import org.woodwhales.music.model.MusicInfoLinkDetailVo;

import java.util.*;

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
        Map<Integer, List<MusicLink>> mapping = DataTool.groupingBy(list, MusicLink::getLinkSource);
        for (MusicLinkSourceEnum musicLinkSourceEnum : MusicLinkSourceEnum.values()) {
            List<MusicLink> musicLinkList = mapping.get(musicLinkSourceEnum.getCode());
            MusicInfoLinkDetailVo detailVo = new MusicInfoLinkDetailVo();
            detailVo.setLinkSource(musicLinkSourceEnum.getCode());
            detailVo.setLinkSourceName(musicLinkSourceEnum.getDesc());
            detailVo.setLinkMap(MusicLinkTypeEnum.buildLinkMap(musicLinkList));
            result.add(detailVo);
        }
        return result;
    }

    public void createOrUpdate(Music music, List<MusicInfoLinkDetailVo> linkList) {
        List<MusicLink> musicLinkList = this.list(Wrappers.<MusicLink>lambdaQuery()
                .eq(MusicLink::getMusicId, music.getId()));
        if(CollectionUtils.isEmpty(linkList) && CollectionUtils.isNotEmpty(musicLinkList)) {
            this.removeByIds(DataTool.toList(musicLinkList, MusicLink::getId));
            return;
        }

        Date now = new Date();
        Map<String, MusicLink> mapping = DataTool.toMap(musicLinkList, musicLink ->
                musicLink.getLinkSource() + "_" + MusicLinkTypeEnum.ofCode(musicLink.getLinkType()).name());
        List<MusicLink> willSaveOrUpdateList = new ArrayList<>();

        for (MusicInfoLinkDetailVo detailVo : linkList) {
            Integer linkSource = detailVo.getLinkSource();
            Map<String, String> linkMap = detailVo.getLinkMap();
            linkMap.entrySet().stream().forEach(entry -> {
                String linkTypeEnumName = entry.getKey();
                String linkUrl = entry.getValue();
                String key = linkSource + "_" + linkTypeEnumName;
                MusicLink musicLink = mapping.get(key);
                if(Objects.isNull(musicLink)) {
                    musicLink = new MusicLink();
                    musicLink.setMusicId(music.getId());
                    musicLink.setLinkType(MusicLinkTypeEnum.getMusicLinkTypeEnum(linkTypeEnumName).getCode());
                    musicLink.setLinkSource(linkSource);
                    musicLink.setGmtCreated(now);
                }
                musicLink.setGmtModified(now);
                musicLink.setLinkUrl(linkUrl);
                willSaveOrUpdateList.add(musicLink);
            });
        }

        this.saveOrUpdateBatch(willSaveOrUpdateList);
    }
}
