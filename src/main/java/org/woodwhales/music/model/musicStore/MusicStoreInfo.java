package org.woodwhales.music.model.musicStore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author woodwhales on 2020-09-29
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MusicStoreInfo {

    /**
     * 仓库名称
     */
    private String name;

    /**
     * 仓库链接地址
     */
    private String link;

}
