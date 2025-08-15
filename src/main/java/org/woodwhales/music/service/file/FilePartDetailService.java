package org.woodwhales.music.service.file;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.dromara.x.file.storage.core.upload.FilePartInfo;
import org.springframework.stereotype.Service;
import org.woodwhales.music.entity.FilePartDetail;
import org.woodwhales.music.mapper.FilePartDetailMapper;

/**
 * 用来将文件分片上传记录保存到数据库，这里使用了 MyBatis-Plus 和 Hutool 工具类
 * 目前仅手动分片分片上传时使用
 */
@Slf4j
@Service
public class FilePartDetailService extends ServiceImpl<FilePartDetailMapper, FilePartDetail> {

    /**
     * 保存文件分片信息
     * @param info 文件分片信息
     */
    @SneakyThrows
    public void saveFilePart(FilePartInfo info) {
        FilePartDetail detail = toFilePartDetail(info);
        if (save(detail)) {
            info.setId(detail.getId().toString());
        }
    }

    /**
     * 删除文件分片信息
     */
    public void deleteFilePartByUploadId(String uploadId) {
        remove(new QueryWrapper<FilePartDetail>().eq(FilePartDetail.COL_UPLOAD_ID, uploadId));
    }

    /**
     * 将 FilePartInfo 转成 FilePartDetail
     * @param info 文件分片信息
     */
    public FilePartDetail toFilePartDetail(FilePartInfo info) {
        FilePartDetail detail = new FilePartDetail();
        detail.setPlatform(info.getPlatform());
        detail.setUploadId(info.getUploadId());
        detail.setETag(info.getETag());
        detail.setPartNumber(info.getPartNumber());
        detail.setPartSize(info.getPartSize());
        detail.setHashInfo(valueToJson(info.getHashInfo()));
        detail.setCreateTime(info.getCreateTime());
        return detail;
    }

    /**
     * 将指定值转换成 json 字符串
     */
    public String valueToJson(Object value) {
        return JSON.toJSONString(value);
    }
}
