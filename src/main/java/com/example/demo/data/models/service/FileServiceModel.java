package com.example.demo.data.models.service;

import com.example.demo.data.models.service.base.BaseServiceModel;

public class FileServiceModel extends BaseServiceModel {


    private String originalFileName;
    private String contentType;
    private byte[] bytes;

    public FileServiceModel() {
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
