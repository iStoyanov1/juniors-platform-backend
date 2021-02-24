package com.example.demo.web.rest;

import com.example.demo.data.models.dtos.UserRegisterDto;
import com.example.demo.data.models.service.UserServiceModel;
import com.example.demo.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UserRestController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    public UserRestController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @PostMapping("/api/register/user")
    @CrossOrigin
    public void createUser(@RequestBody UserRegisterDto userRegisterDto) throws IOException {

        boolean checkEmailAvailable = this.userService.checkExistEmail(userRegisterDto.getEmail());

        if (!checkEmailAvailable){
            throw new IllegalArgumentException("Вече същестувува потребител с този имейл.");
        }

        UserServiceModel user = this.modelMapper.map(userRegisterDto, UserServiceModel.class);

        userService.registerUser(user);

    }

}
