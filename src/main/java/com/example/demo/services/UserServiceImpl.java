package com.example.demo.services;

import com.example.demo.data.entites.Auth;
import com.example.demo.data.entites.User;
import com.example.demo.data.models.service.UserServiceModel;
import com.example.demo.repositories.AuthRepository;
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

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RoleService roleService, AuthService authService, AuthRepository authRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleService = roleService;
        this.authService = authService;
        this.authRepository = authRepository;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {

        User user = this.modelMapper.map(userServiceModel, User.class);

        if (userRepository.count() == 0){
            userServiceModel.getAuthServiceModel().setAuthorities(new LinkedHashSet<>());
            userServiceModel.getAuthServiceModel().getAuthorities().add(this.roleService.findByAuthority("MODERATOR"));
        }else{
            userServiceModel.getAuthServiceModel().setAuthorities(new LinkedHashSet<>());
            userServiceModel.getAuthServiceModel().getAuthorities().add(this.roleService.findByAuthority("USER"));
        }

        Auth auth = this.modelMapper.map(userServiceModel.getAuthServiceModel(), Auth.class);

        this.authRepository.saveAndFlush(auth);
        return this.modelMapper.map(this.userRepository.saveAndFlush(user), UserServiceModel.class);
    }

}
