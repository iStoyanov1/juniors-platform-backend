package com.example.demo.web.rest;

import com.example.demo.data.models.dtos.AuthLoginDto;
import com.example.demo.data.models.dtos.CompanyRegisterDto;
import com.example.demo.data.models.dtos.UserRegisterDto;
import com.example.demo.data.models.service.AuthServiceModel;
import com.example.demo.data.models.service.CompanyAdministrativeInfoServiceModel;
import com.example.demo.data.models.service.CompanyServiceModel;
import com.example.demo.data.models.service.UserServiceModel;
import com.example.demo.services.interfaces.AuthService;
import com.example.demo.services.interfaces.CompanyAdministrativeInfoService;
import com.example.demo.services.interfaces.CompanyService;
import com.example.demo.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final ModelMapper modelMapper;
    private final CompanyService companyService;
    private final CompanyAdministrativeInfoService companyAdministrativeInfoService;
    private final AuthService authService;
    private final UserService userService;

    public AuthController(ModelMapper modelMapper, CompanyService companyService,
                          CompanyAdministrativeInfoService companyAdministrativeInfoService,
                          AuthService authService, UserService userService) {
        this.modelMapper = modelMapper;
        this.companyService = companyService;
        this.companyAdministrativeInfoService = companyAdministrativeInfoService;
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/api/register/user")
    @CrossOrigin
    public void createUser(@RequestBody UserRegisterDto userRegisterDto) {
        System.out.printf("t");
        if (this.authService.checkUsernameExist(userRegisterDto.getUsername())){
            throw new IllegalArgumentException("Вече съществува потребител с такъв имейл.");
        }

        this.modelMapper.getConfiguration().setAmbiguityIgnored(true);

        AuthServiceModel authServiceModel = this.authService.
                setCredentials(this.modelMapper.map(userRegisterDto,
                        AuthServiceModel.class));

        UserServiceModel user = this.modelMapper.map(userRegisterDto, UserServiceModel.class);
        user.setAuth(authServiceModel);
        userService.registerUser(user);

    }


    @PostMapping("/api/register/company")
    @CrossOrigin
    public void createCompany(@RequestBody CompanyRegisterDto companyRegisterDto) {

        this.modelMapper.getConfiguration().setAmbiguityIgnored(true);

        checkAvailableEmails(companyRegisterDto.getEmail(), companyRegisterDto.getUsername());

        AuthServiceModel authServiceModel = this.authService.
                setCredentials(this.modelMapper.map(companyRegisterDto,
                        AuthServiceModel.class));


        CompanyAdministrativeInfoServiceModel companyAdministrativeInfo = this.modelMapper.
                map(companyRegisterDto, CompanyAdministrativeInfoServiceModel.class);


        CompanyServiceModel companyServiceModel = this.modelMapper.map(companyRegisterDto, CompanyServiceModel.class);
        companyServiceModel.setAuthServiceModel(authServiceModel);

        companyServiceModel = this.companyService.registerCompany(companyServiceModel);

        companyAdministrativeInfo.setCompany(companyServiceModel);


        this.companyAdministrativeInfoService.saveCompanyAdministrativeInfo(companyAdministrativeInfo);


    }


    void checkAvailableEmails(String administrativeEmail, String username) {
        if (this.companyAdministrativeInfoService.checkEmail(administrativeEmail))
        {
            throw new IllegalArgumentException("Имейлът " + administrativeEmail + " вече съществува в системата. Моля опитайте с друг.");
        }else if (this.authService.checkUsernameExist(username)){
            throw new IllegalArgumentException("Имейлът " + username + " вече съществува в системата. Моля опитайте с друг.");
        }
    }
}
