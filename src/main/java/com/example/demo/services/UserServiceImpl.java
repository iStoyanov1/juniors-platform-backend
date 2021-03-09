package com.example.demo.services;

import com.example.demo.data.entites.Auth;
import com.example.demo.data.entites.File;
import com.example.demo.data.entites.User;
import com.example.demo.data.models.service.FileServiceModel;
import com.example.demo.data.models.service.UserServiceModel;
import com.example.demo.repositories.AuthRepository;
import com.example.demo.repositories.FileRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.interfaces.AuthService;
import com.example.demo.services.interfaces.RoleService;
import com.example.demo.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;

@Service
public class UserServiceImpl implements UserService{


    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleService roleService;
    private final AuthService authService;
    private final AuthRepository authRepository;
    private final FileRepository fileRepository;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
                           RoleService roleService, AuthService authService, AuthRepository authRepository,
                           FileRepository fileRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleService = roleService;
        this.authService = authService;
        this.authRepository = authRepository;
        this.fileRepository = fileRepository;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {

        User user = this.modelMapper.map(userServiceModel, User.class);

        if (userRepository.count() == 0){
            userServiceModel.getAuthServiceModel().setAuthorities(new LinkedHashSet<>());
            userServiceModel.getAuthServiceModel().getAuthorities().add(this.roleService.findByAuthority("ROLE_MODERATOR"));
        }else{
            userServiceModel.getAuthServiceModel().setAuthorities(new LinkedHashSet<>());
            userServiceModel.getAuthServiceModel().getAuthorities().add(this.roleService.findByAuthority("ROLE_USER"));
        }

        Auth auth = this.modelMapper.map(userServiceModel.getAuthServiceModel(), Auth.class);

        this.authRepository.saveAndFlush(auth);
        return this.modelMapper.map(this.userRepository.saveAndFlush(user), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findUserByAuthId(String id) {
        return this.modelMapper.map(this.userRepository.findUserByAuth_Id(id), UserServiceModel.class);
    }

    @Override
    public UserServiceModel uploadUserCV(UserServiceModel userServiceModel) {

        User user = this.userRepository.findById(userServiceModel.getId()).orElse(null);

        File file = this.fileRepository.findById(userServiceModel.getFile().getId()).orElse(null);

        if (file == null){
            throw new IllegalArgumentException("Грешка!");
        }

        user.setFile(file);

        return this.modelMapper.map(this.userRepository.saveAndFlush(user), UserServiceModel.class);
    }
}
