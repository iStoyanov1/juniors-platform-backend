package com.example.demo.services.interfaces;

import com.example.demo.data.models.dtos.views.FileViewModel;
import com.example.demo.data.models.service.FileServiceModel;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    FileServiceModel uploadFile(FileServiceModel file);

    FileServiceModel getFileById(String id);
}
