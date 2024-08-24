package org.woodwhales.music.service.tagInfo;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.woodwhales.music.entity.TagInfo;
import org.woodwhales.music.mapper.TagInfoMapper;

import java.util.Objects;

/**
 * @author woodwhales on 2024-08-24 22:16
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class TagInfoService extends ServiceImpl<TagInfoMapper, TagInfo> {

    private TagInfo getTag(String tagName) {
        tagName = StringUtils.trim(tagName);
        TagInfo tagInfo = this.getOne(Wrappers.<TagInfo>lambdaQuery()
                .eq(TagInfo::getName, tagName));
        if(Objects.nonNull(tagInfo)) {
            return tagInfo;
        }
        tagInfo = new TagInfo();
        tagInfo.setName(tagName);
        this.save(tagInfo);
        return tagInfo;
    }

}
