package org.woodwhales.music.controller.resp;

import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @projectName: woodwhales-music
 * @author: woodwhales
 * @date: 20.8.9 18:01
 * @description:
 */
@Data
public class PageBaseVO<T> extends BaseVO<T> {

    private Long count;

    public static <T, R> PageBaseVO<List<T>> success(long count, List<T> data) {
        PageBaseVO<List<T>> pageBaseVO = new PageBaseVO<>();
        pageBaseVO.setCount(count);
        pageBaseVO.setCode(0);
        pageBaseVO.setMsg("success");
        if(CollectionUtils.isEmpty(data)) {
            pageBaseVO.setData(Collections.emptyList());
        } else {
            pageBaseVO.setData(data);
        }
        return pageBaseVO;
    }
}
