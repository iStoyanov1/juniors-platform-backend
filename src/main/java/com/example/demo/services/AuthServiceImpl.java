package com.example.demo.services;

import com.example.demo.data.entites.Auth;
import com.example.demo.data.models.service.AuthServiceModel;
import com.example.demo.repositories.AuthRepository;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.services.interfaces.AuthService;
import com.example.demo.services.interfaces.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthRepository authRepository;
    private ModelMapper modelMapper;
    private RoleService roleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthServiceImpl(AuthRepository authRepository, ModelMapper modelMapper, RoleService roleService,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.authRepository = authRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public AuthServiceModel setCredentials(AuthServiceModel authServiceModel) {

        this.roleService.saveRole();

        Auth auth = this.modelMapper.map(authServiceModel, Auth.class);

        auth.setPassword(this.bCryptPasswordEncoder.encode(auth.getPassword()));

        return this.modelMapper.map(this.authRepository.saveAndFlush(auth), AuthServiceModel.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.authRepository.findByUsername(username);
    }

    @Override
    public AuthServiceModel findAuthById(String id) {
        return this.modelMapper.map(this.authRepository.findById(id), AuthServiceModel.class);
    }

    @Override
    public boolean findByUsername(String username) {
        Auth findAuthByUsername = this.authRepository.findByUsername(username);

        if (findAuthByUsername == null){
            return false;
        }
        return true;
    }
}
