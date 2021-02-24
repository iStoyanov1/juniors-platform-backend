package com.example.demo.services.interfaces;

import com.example.demo.data.models.service.UserServiceModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserServiceModel findUserByUsername(String username);

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    boolean checkExistEmail(String email);

}
