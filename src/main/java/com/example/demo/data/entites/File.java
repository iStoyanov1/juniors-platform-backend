package com.example.demo.data.entites;

import com.example.demo.data.entites.base.BaseEntity;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity(name = "files")
public class File extends BaseEntity {

    private String originalFileName;
    private String contentType;
    private byte[] bytes;

    public File() {
    }

    @Column(name = "file_name")
    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    @Column(name = "file_content_type")
    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Column(name = "file_bytes", length = 100000)
    @Lob
    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
