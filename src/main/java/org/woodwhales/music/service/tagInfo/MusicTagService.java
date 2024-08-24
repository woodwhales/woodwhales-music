package org.woodwhales.music.service.tagInfo;

import cn.woodwhales.common.business.DataTool;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.woodwhales.music.entity.MusicInfo;
import org.woodwhales.music.entity.MusicTag;
import org.woodwhales.music.entity.TagInfo;
import org.woodwhales.music.mapper.MusicTagMapper;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author woodwhales on 2024-08-24 22:44
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class MusicTagService extends ServiceImpl<MusicTagMapper, MusicTag> {

    @Autowired
    private TagInfoService tagInfoService;

    public Map<Long, List<TagInfo>> getMusicTagMapping(List<MusicInfo> musicInfoList) {
        if(CollectionUtils.isEmpty(musicInfoList)) {
            return Collections.emptyMap();
        }

        List<MusicTag> musicTagList = this.list(Wrappers.<MusicTag>lambdaQuery()
                .in(MusicTag::getMusicId, DataTool.toSet(musicInfoList, MusicInfo::getId)));

        Map<Long, TagInfo> tagMapping;
        if(CollectionUtils.isNotEmpty(musicTagList)) {
            List<TagInfo> tagInfos = this.tagInfoService.listByIds(DataTool.toSet(musicTagList, MusicTag::getTagId));
            tagMapping = DataTool.toMap(tagInfos, TagInfo::getId);
        } else {
            tagMapping = new HashMap<>();
        }

        Map<Long, List<TagInfo>> musicTagMapping = new HashMap<>();
        DataTool.groupingBy(musicTagList, MusicTag::getMusicId).entrySet().stream().forEach(entry -> {
            Long musicId = entry.getKey();
            musicTagMapping.put(musicId, DataTool.toList(entry.getValue(), musicTag -> tagMapping.get(musicTag.getTagId())));
        });
        return musicTagMapping;
    }

    public List<TagInfo> getListByMusicId(Long musicId) {
        List<MusicTag> musicTagList = this.list(Wrappers.<MusicTag>lambdaQuery()
                .eq(MusicTag::getMusicId, musicId));
        if(CollectionUtils.isEmpty(musicTagList)) {
            return Collections.emptyList();
        }
        List<TagInfo> tagInfoList = this.tagInfoService.listByIds(DataTool.toSet(musicTagList, MusicTag::getTagId));
        if(CollectionUtils.isEmpty(tagInfoList)) {
            return Collections.emptyList();
        }
        return tagInfoList;
    }
}
