package org.woodwhales.music.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * 文件分片信息表，仅在手动分片上传时使用
 */
@Data
@TableName(value = "file_part_detail")
public class FilePartDetail {
    /**
     * 分片id
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
     * 存储平台
     */
    @TableField(value = "platform")
    private String platform;

    /**
     * 上传ID，仅在手动分片上传时使用
     */
    @TableField(value = "upload_id")
    private String uploadId;

    /**
     * 分片 ETag
     */
    @TableField(value = "e_tag")
    private String eTag;

    /**
     * 分片号。每一个上传的分片都有一个分片号，一般情况下取值范围是1~10000
     */
    @TableField(value = "part_number")
    private Integer partNumber;

    /**
     * 文件大小，单位字节
     */
    @TableField(value = "part_size")
    private Long partSize;

    /**
     * 哈希信息
     */
    @TableField(value = "hash_info")
    private String hashInfo;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    public static final String COL_ID = "id";

    public static final String COL_PLATFORM = "platform";

    public static final String COL_UPLOAD_ID = "upload_id";

    public static final String COL_E_TAG = "e_tag";

    public static final String COL_PART_NUMBER = "part_number";

    public static final String COL_PART_SIZE = "part_size";

    public static final String COL_HASH_INFO = "hash_info";

    public static final String COL_CREATE_TIME = "create_time";
}
