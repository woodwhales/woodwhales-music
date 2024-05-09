package org.woodwhales.music.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author woodwhales on 2024-05-08 17:25
 */
@TableName(value= "sys_config")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 是否删除，0-已启用，1-已停用，2-已删除
     */
    @TableLogic(delval = "2")
    @TableField(value = "status")
    private Byte status;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_created")
    private java.util.Date gmtCreated;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified")
    private java.util.Date gmtModified;

    /**
     * 配置key
     */
    @TableField(value = "config_key")
    private String configKey;

    /**
     * 配置内容
     */
    @TableField(value = "config_content")
    private String configContent;

}
