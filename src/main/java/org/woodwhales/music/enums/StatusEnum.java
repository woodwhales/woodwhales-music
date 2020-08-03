package org.woodwhales.music.enums;

/**
 * 是否删除，0-已启用，1-已停用，2-已删除
 * @author woodwhales
 *
 */
public enum StatusEnum {

	DEFAULT((byte)0, "已启用"),
	STOP((byte)1, "已停用"),
	DELETE((byte)2, "已删除"),
	;
	
	public final Byte code;
	public final String description;
	
	private StatusEnum(final Byte code, final String description) {
		this.code = code;
		this.description = description;
	}
	
}
