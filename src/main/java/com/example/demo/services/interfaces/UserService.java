package com.example.demo.services.interfaces;

import com.example.demo.data.models.service.FileServiceModel;
import com.example.demo.data.models.service.UserServiceModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByAuthId(String id);

    UserServiceModel uploadUserCV(UserServiceModel userServiceModel);

    UserServiceModel editUserName(String id, String firstName, String lastName);


    void editUserPassword(String id, String password);
}
