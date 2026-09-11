package org.woodwhales.music.model;

import lombok.Data;

import java.util.Date;

/**
 * 文件上传响应 VO，对外隔离 dromara FileInfo 内部类
 *
 * @author woodwhales
 */
@Data
public class FileUploadVO {

	private String id;

	/** 已经是相对路径 music/xxx.txt */
	private String url;

	private Long size;

	private String originalName;

	private String contentType;

	private String ext;

	private String sha256;

	private String md5;

	private Date createTime;

}
