package org.woodwhales.music.enums;

import cn.woodwhales.common.model.result.BaseRespResult;

/**
 * 应用层业务响应码枚举：与 woodwhales-common 的 RespCodeEnum 对齐（SUCCESS=0, ERROR=-1），
 * 额外补充本项目特有的业务码（如 404-数据不存在），便于前端按 code 精确分流，而不用匹配文案。
 *
 * @author woodwhales
 */
public enum AppRespCodeEnum implements BaseRespResult {

	/**
	 * 成功
	 */
	SUCCESS(0, "操作成功"),
	/**
	 * 通用失败
	 */
	ERROR(-1, "操作失败"),
	/**
	 * 业务数据不存在
	 */
	DATA_NOT_FOUND(404, "数据不存在"),
	;

	private final Integer code;
	private final String message;

	AppRespCodeEnum(final Integer code, final String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public Integer getCode() {
		return this.code;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
