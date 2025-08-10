package org.woodwhales.music.controller.admin;

import lombok.extern.slf4j.Slf4j;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageService;
import org.dromara.x.file.storage.core.tika.ContentTypeDetect;
import org.dromara.x.file.storage.core.upload.UploadPretreatment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@RestController
public class FileDetailController {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private ContentTypeDetect contentTypeDetect;

    /**
     * 上传文件
     */
    @PostMapping("/upload")
    public FileInfo upload(MultipartFile file) {
        if (file.isEmpty()) {
            return null;
        }

        UploadPretreatment uploadPretreatment = fileStorageService.of(file);
        if(isImage(file)) {
            uploadPretreatment.thumbnail(th -> th.scale(0.2));
        }

        return uploadPretreatment
                .setHashCalculatorMd5()
                .setHashCalculatorSha256()
                .thumbnail(th -> th.size(200,200))
                .setProgressListener((progressSize,allSize) ->
                log.info("已上传={}, 总大小={}, ", progressSize, (allSize == null ? "未知" : allSize))
        ).upload();
    }

    public boolean isImage(MultipartFile file) {
        // 1. content-type 检查
        String detect = null;
        try {
            detect = contentTypeDetect.detect(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (detect == null || !detect.startsWith("image/")) {
            return false;
        }

        // 2. 文件扩展名检查
        String filename = file.getOriginalFilename();
        if (filename == null || !filename.matches("(?i).*\\.(jpg|jpeg|png|gif|bmp|webp)$")) {
            return false;
        }

        // 3. 实际内容判断
        try (InputStream input = file.getInputStream()) {
            BufferedImage image = ImageIO.read(input);
            return image != null;
        } catch (IOException e) {
            return false;
        }
    }

}
