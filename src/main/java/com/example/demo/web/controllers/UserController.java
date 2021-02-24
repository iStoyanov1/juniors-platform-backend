package com.example.demo.web.controllers;

import com.example.demo.data.models.dtos.UserRegisterDto;
import com.example.demo.data.models.service.UserServiceModel;
import com.example.demo.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;

    @Autowired
    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/register/user")
    public ModelAndView registerView(ModelAndView model){
        model.setViewName("register-user");
        return model;
    }

//    @PostMapping("/register/user")
//    public ModelAndView register(@ModelAttribute UserRegisterDto model,
//                                 ModelAndView modelAndView){
//        this.userService.registerUser(this.modelMapper.map(model, UserServiceModel.class));
//        modelAndView.setViewName("redirect:/register/user");
//        return modelAndView;
//    }
//
//    @GetMapping("/login")
//    public ModelAndView login(ModelAndView modelAndView){
//        modelAndView.setViewName("login");
//        return modelAndView;
//    }
}
