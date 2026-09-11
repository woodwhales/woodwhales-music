package org.woodwhales.music.controller.admin;

import cn.woodwhales.common.model.vo.RespVO;
import lombok.extern.slf4j.Slf4j;
import org.dromara.x.file.storage.core.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.woodwhales.music.model.FileUploadVO;
import org.woodwhales.music.service.file.FileDetailService;

/**
 * 后台文件接口
 *
 * @author woodwhales
 */
@Slf4j
@RestController
@RequestMapping("/admin/file")
public class FileDetailController {

	@Autowired
	private FileDetailService fileDetailService;

	/**
	 * 上传文件
	 */
	@PostMapping("/upload")
	public RespVO<FileUploadVO> upload(MultipartFile file) {
		FileInfo fileInfo = this.fileDetailService.upload(file);
		return RespVO.success(this.fileDetailService.toUploadVO(fileInfo));
	}

}
