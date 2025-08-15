package org.woodwhales.music.service.file;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.imaging.ImageInfo;
import org.apache.commons.imaging.Imaging;
import org.apache.commons.io.IOUtils;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageService;
import org.dromara.x.file.storage.core.constant.Constant;
import org.dromara.x.file.storage.core.exception.FileStorageRuntimeException;
import org.dromara.x.file.storage.core.hash.HashCalculatorManager;
import org.dromara.x.file.storage.core.hash.MessageDigestHashCalculator;
import org.dromara.x.file.storage.core.recorder.FileRecorder;
import org.dromara.x.file.storage.core.tika.ContentTypeDetect;
import org.dromara.x.file.storage.core.upload.FilePartInfo;
import org.dromara.x.file.storage.core.upload.UploadPretreatment;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.woodwhales.music.entity.FileDetail;
import org.woodwhales.music.mapper.FileDetailMapper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

/**
 * 用来将文件上传记录保存到数据库，这里使用了 MyBatis-Plus 和 Hutool 工具类
 */
@Slf4j
@Service
public class FileDetailService extends ServiceImpl<FileDetailMapper, FileDetail> implements FileRecorder {

    @Autowired
    private FilePartDetailService filePartDetailService;

    @Autowired
    @Lazy
    private FileStorageService fileStorageService;

    @Autowired
    private ContentTypeDetect contentTypeDetect;

    public FileInfo upload(MultipartFile file) {
        if (file.isEmpty()) {
            return null;
        }

        UploadPretreatment uploadPretreatment = this.fileStorageService.of(file);
        FileInfo fileInfo;
        try {
            fileInfo = uploadPretreatment.getFileWrapper().getInputStreamMaskResetReturn(in -> {
                MessageDigestHashCalculator calculator = new MessageDigestHashCalculator(Constant.Hash.MessageDigest.SHA256);
                calculator.update(IOUtils.toByteArray(in));
                String sha256 = calculator.getValue();

                List<FileDetail> list = this.lambdaQuery()
                        .eq(FileDetail::getSha256, sha256)
                        .orderByDesc(FileDetail::getId)
                        .last("limit 1")
                        .list();
                if (CollectionUtils.isNotEmpty(list)) {
                    return this.toFileInfo(list.get(0));
                }
                return null;
            });

        } catch (IOException e) {
            throw new FileStorageRuntimeException("读取文件sha256信息失败！", e);
        }

        if(Objects.nonNull(fileInfo)) {
            return fileInfo;
        }

        if(isImage(file)) {
            try {
                uploadPretreatment.getFileWrapper().getInputStreamMaskReset(in -> {
                    ImageInfo imageInfo = Imaging.getImageInfo(in, file.getOriginalFilename());
                    int width = imageInfo.getWidth();
                    int height = imageInfo.getHeight();
                    uploadPretreatment.putUserMetadata("width", width + "");
                    uploadPretreatment.putUserMetadata("height", height + "");
                });
            } catch (IOException e) {
                throw new FileStorageRuntimeException("读取图片宽高信息失败！", e);
            }
            uploadPretreatment.thumbnail(th -> th.scale(0.2));
        }

        uploadPretreatment
                .setHashCalculatorManager(new HashCalculatorManager())
                .setHashCalculatorMd5()
                .setHashCalculatorSha256();

        uploadPretreatment
                .setProgressListener((progressSize, allSize) ->
                        log.info("已上传={}, 总大小={}, ", progressSize, (allSize == null ? "未知" : allSize)));

        return uploadPretreatment.upload();
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

    /**
     * 保存文件信息到数据库
     */
    @SneakyThrows
    @Override
    public boolean save(FileInfo info) {
        FileDetail detail = toFileDetail(info);
        boolean b = save(detail);
        if (b) {
            info.setId(detail.getId().toString());
        }
        return b;
    }

    /**
     * 更新文件记录，可以根据文件 ID 或 URL 来更新文件记录，
     * 主要用在手动分片上传文件-完成上传，作用是更新文件信息
     */
    @SneakyThrows
    @Override
    public void update(FileInfo info) {
        FileDetail detail = toFileDetail(info);
        QueryWrapper<FileDetail> qw = new QueryWrapper<FileDetail>()
                .eq(detail.getUrl() != null, FileDetail.COL_URL, detail.getUrl())
                .eq(detail.getId() != null, FileDetail.COL_ID, detail.getId());
        update(detail, qw);
    }

    /**
     * 根据 url 查询文件信息
     */
    @SneakyThrows
    @Override
    public FileInfo getByUrl(String url) {
        return toFileInfo(getOne(new QueryWrapper<FileDetail>().eq(FileDetail.COL_URL, url)));
    }

    /**
     * 根据 url 删除文件信息
     */
    @Override
    public boolean delete(String url) {
        remove(new QueryWrapper<FileDetail>().eq(FileDetail.COL_URL, url));
        return true;
    }

    /**
     * 保存文件分片信息
     * @param filePartInfo 文件分片信息
     */
    @Override
    public void saveFilePart(FilePartInfo filePartInfo) {
        filePartDetailService.saveFilePart(filePartInfo);
    }

    /**
     * 删除文件分片信息
     */
    @Override
    public void deleteFilePartByUploadId(String uploadId) {
        filePartDetailService.deleteFilePartByUploadId(uploadId);
    }

    /**
     * 将 FileInfo 转为 FileDetail
     */
    public FileDetail toFileDetail(FileInfo info) {
        FileDetail detail = new FileDetail();
        BeanUtils.copyProperties(info, detail);
        detail.setSha256(info.getHashInfo().getSha256());
        return detail;
    }

    /**
     * 将 FileDetail 转为 FileInfo
     */
    public FileInfo toFileInfo(FileDetail detail) {
        FileInfo info = new FileInfo();
        BeanUtils.copyProperties(detail, info);
        info.setId(detail.getId().toString());
        return info;
    }
}
