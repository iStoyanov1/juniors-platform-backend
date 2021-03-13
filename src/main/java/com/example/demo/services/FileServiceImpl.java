package com.example.demo.services;

import com.example.demo.data.entites.File;
import com.example.demo.data.entites.User;
import com.example.demo.data.models.service.FileServiceModel;
import com.example.demo.repositories.FileRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.interfaces.FileService;
import com.example.demo.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {

    private final ModelMapper modelMapper;
    private final FileRepository fileRepository;
    private final UserRepository userRepository;

    public FileServiceImpl(ModelMapper modelMapper, FileRepository fileRepository, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.fileRepository = fileRepository;
        this.userRepository = userRepository;
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

    @Override
    public void deleteFileById(String userId, String fileId){
        User user = this.userRepository.findById(userId).orElse(null);
        File file = this.fileRepository.findById(fileId).orElse(null);


        if (file == null){
            throw new IllegalArgumentException("Няма намерен файл.");
        }

        user.setFile(null);
        this.userRepository.save(user);

        this.fileRepository.delete(file);
    }
}
