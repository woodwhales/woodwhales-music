package org.woodwhales.music.controller.param;

import cn.woodwhales.common.business.DataTool;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.woodwhales.music.enums.LinkStatusEnum;
import org.woodwhales.music.model.MusicInfoLinkDetailVo;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author woodwhales on 2023-03-25 15:15
 */
@Data
public class MusicCreateOrUpdateRequestBody {

    private Long id;

    @NotBlank(message = "音乐名称不允许为空")
    private String musicName;

    @NotBlank(message = "作者不允许为空")
    private String artist;

    @NotBlank(message = "专辑名称不允许为空")
    private String album;

    private List<MusicInfoLinkDetailVo> linkList;

    private List<String> tagNameList;

    @Max(value = Integer.MAX_VALUE, message = "排序值不能过大")
    @Min(value = 0, message = "排序值不能小于0")
    private Integer sort = Integer.MAX_VALUE;

    public MusicCreateOrUpdateRequestBody trim() {
        this.musicName = StringUtils.trim(musicName);
        this.artist = StringUtils.trim(artist);
        this.album = StringUtils.trim(album);
        if(CollectionUtils.isNotEmpty(this.tagNameList)) {
            this.tagNameList = DataTool.toList(this.tagNameList, StringUtils::trim);
        } else {
            this.tagNameList = Collections.emptyList();
        }
        return this;
    }

    public LinkStatusEnum checkLinkStatus() {
        if(CollectionUtils.isEmpty(this.linkList)) {
            return LinkStatusEnum.UN_LINKED;
        }

        LinkStatusEnum linkStatusEnum = LinkStatusEnum.UN_LINKED;
        for (MusicInfoLinkDetailVo detailVo : this.linkList) {
            Map<String, String> linkMap = detailVo.getLinkMap();
            if(MapUtils.isNotEmpty(linkMap)) {
                boolean allNotBlank = true;
                for (String linkUrl : linkMap.values()) {
                    if (StringUtils.isBlank(linkUrl)) {
                        allNotBlank = false;
                        break;
                    }
                }
                if(allNotBlank) {
                    linkStatusEnum = LinkStatusEnum.LINKED;
                    return linkStatusEnum;
                }
            }
        }
        return linkStatusEnum;
    }
}
