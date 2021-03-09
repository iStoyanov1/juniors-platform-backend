package com.example.demo.services;

import com.example.demo.data.entites.File;
import com.example.demo.data.models.service.FileServiceModel;
import com.example.demo.repositories.FileRepository;
import com.example.demo.services.interfaces.FileService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

    private final ModelMapper modelMapper;
    private final FileRepository fileRepository;

    public FileServiceImpl(ModelMapper modelMapper, FileRepository fileRepository) {
        this.modelMapper = modelMapper;
        this.fileRepository = fileRepository;
    }


    @Override
    public FileServiceModel uploadFile(FileServiceModel file) {

        File cv = this.modelMapper.map(file, File.class);

        return this.modelMapper.map(this.fileRepository.saveAndFlush(cv), FileServiceModel.class);
    }

    @Override
    public FileServiceModel getFileById(String id) {
        File file = this.fileRepository.findById(id).orElse(null);

        if (file == null){
            throw new IllegalArgumentException("Грешка!");
        }
        return this.modelMapper.map(file, FileServiceModel.class);
    }
}
