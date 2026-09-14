package org.woodwhales.music.exception;

/**
 * 业务数据不存在异常：用于从"服务器内部错误(500)"中区分出"数据不存在(404)"场景
 *
 * @author woodwhales
 */
public class DataNotFoundException extends RuntimeException {

	public DataNotFoundException(String message) {
		super(message);
	}

}
