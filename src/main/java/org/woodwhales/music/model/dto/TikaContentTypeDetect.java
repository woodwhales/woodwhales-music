package org.woodwhales.music.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dromara.x.file.storage.core.tika.ContentTypeDetect;
import org.dromara.x.file.storage.core.tika.TikaFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TikaContentTypeDetect implements ContentTypeDetect {

    private TikaFactory tikaFactory;

    @Override
    public String detect(File file) throws IOException {
        return tikaFactory.getTika().detect(file);
    }

    @Override
    public String detect(byte[] bytes) {
        return tikaFactory.getTika().detect(bytes);
    }

    @Override
    public String detect(byte[] bytes,String filename) {
        return tikaFactory.getTika().detect(bytes,filename);
    }

    @Override
    public String detect(InputStream in, String filename) throws IOException {
        return tikaFactory.getTika().detect(in,filename);
    }
}
