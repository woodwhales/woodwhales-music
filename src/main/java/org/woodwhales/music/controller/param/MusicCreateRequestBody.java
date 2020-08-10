package org.woodwhales.music.controller.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author woodwhales
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicCreateRequestBody {

	@NotBlank(message = "音乐名称不允许为空")
	private String musicName;
	
	private String artist;
	
	private String album;
	
	private String audioUrl;
	
	private String coverUrl;

	@Max(value = Integer.MAX_VALUE, message = "排序值不能过大")
	@Min(value = 0, message = "排序值不能小于0")
	private Integer sort = Integer.MAX_VALUE;
}
