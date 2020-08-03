package org.woodwhales.music.controller.param;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicCreateRequestBody {

	@NotBlank(message = "音乐名称不允许为空")
	private String musicName;
	
	@NotBlank(message = "作者不允许为空")
	private String artist;
	
	@NotBlank(message = "专辑名称不允许为空")
	private String album;
	
	@NotBlank(message = "音乐链接不允许为空")
	private String audioUrl;
	
	@NotBlank(message = "音乐封面不允许为空")
	private String coverUrl;
}
