package org.woodwhales.music.entity;

import cn.hutool.core.lang.Dict;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.Fastjson2TypeHandler;
import lombok.Data;
import org.dromara.x.file.storage.core.hash.HashInfo;

import java.util.Date;
import java.util.Map;

/**
 * 文件记录表
 */
@Data
@TableName(value = "file_detail")
public class FileDetail {
    /**
     * 文件id
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
     * 文件访问地址
     */
    @TableField(value = "url")
    private String url;

    /**
     * 文件大小，单位字节
     */
    @TableField(value = "`size`")
    private Long size;

    /**
     * 文件名称
     */
    @TableField(value = "filename")
    private String filename;

    /**
     * 原始文件名
     */
    @TableField(value = "original_filename")
    private String originalFilename;

    /**
     * 基础存储路径
     */
    @TableField(value = "base_path")
    private String basePath;

    /**
     * 存储路径
     */
    @TableField(value = "`path`")
    private String path;

    /**
     * 文件扩展名
     */
    @TableField(value = "ext")
    private String ext;

    /**
     * MIME类型
     */
    @TableField(value = "content_type")
    private String contentType;

    /**
     * 存储平台
     */
    @TableField(value = "platform")
    private String platform;

    /**
     * 缩略图访问路径
     */
    @TableField(value = "th_url")
    private String thUrl;

    /**
     * 缩略图名称
     */
    @TableField(value = "th_filename")
    private String thFilename;

    /**
     * 缩略图大小，单位字节
     */
    @TableField(value = "th_size")
    private Long thSize;

    /**
     * 缩略图MIME类型
     */
    @TableField(value = "th_content_type")
    private String thContentType;

    /**
     * 文件所属对象id
     */
    @TableField(value = "object_id")
    private String objectId;

    /**
     * 文件所属对象类型，例如用户头像，评价图片
     */
    @TableField(value = "object_type")
    private String objectType;

    /**
     * 文件元数据
     */
    @TableField(value = "metadata", typeHandler = Fastjson2TypeHandler.class)
    private Map<String, String> metadata;

    /**
     * 文件用户元数据
     */
    @TableField(value = "user_metadata", typeHandler = Fastjson2TypeHandler.class)
    private Map<String, String> userMetadata;

    /**
     * 缩略图元数据
     */
    @TableField(value = "th_metadata", typeHandler = Fastjson2TypeHandler.class)
    private Map<String, String> thMetadata;

    /**
     * 缩略图用户元数据
     */
    @TableField(value = "th_user_metadata", typeHandler = Fastjson2TypeHandler.class)
    private Map<String, String> thUserMetadata;

    /**
     * 附加属性
     */
    @TableField(value = "attr", typeHandler = Fastjson2TypeHandler.class)
    private Dict attr;

    /**
     * 哈希信息
     */
    @TableField(value = "hash_info", typeHandler = Fastjson2TypeHandler.class)
    private HashInfo hashInfo;

    /**
     * 上传ID，仅在手动分片上传时使用
     */
    @TableField(value = "upload_id")
    private String uploadId;

    /**
     * 哈希信息
     */
    @TableField(value = "sha256")
    private String sha256;

    /**
     * 上传状态，仅在手动分片上传时使用，1：初始化完成，2：上传完成
     */
    @TableField(value = "upload_status")
    private Integer uploadStatus;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    public static final String COL_ID = "id";

    public static final String COL_URL = "url";

    public static final String COL_SIZE = "size";

    public static final String COL_FILENAME = "filename";

    public static final String COL_ORIGINAL_FILENAME = "original_filename";

    public static final String COL_BASE_PATH = "base_path";

    public static final String COL_PATH = "path";

    public static final String COL_EXT = "ext";

    public static final String COL_CONTENT_TYPE = "content_type";

    public static final String COL_PLATFORM = "platform";

    public static final String COL_TH_URL = "th_url";

    public static final String COL_TH_FILENAME = "th_filename";

    public static final String COL_TH_SIZE = "th_size";

    public static final String COL_TH_CONTENT_TYPE = "th_content_type";

    public static final String COL_OBJECT_ID = "object_id";

    public static final String COL_OBJECT_TYPE = "object_type";

    public static final String COL_METADATA = "metadata";

    public static final String COL_USER_METADATA = "user_metadata";

    public static final String COL_TH_METADATA = "th_metadata";

    public static final String COL_TH_USER_METADATA = "th_user_metadata";

    public static final String COL_ATTR = "attr";

    public static final String COL_HASH_INFO = "hash_info";

    public static final String COL_UPLOAD_ID = "upload_id";

    public static final String COL_UPLOAD_STATUS = "upload_status";

    public static final String COL_CREATE_TIME = "create_time";
}
