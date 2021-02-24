package com.example.demo.web.rest;

import com.example.demo.data.models.dtos.CompanyRegisterDto;
import com.example.demo.data.models.service.CompanyAdministrativeInfoServiceModel;
import com.example.demo.data.models.service.CompanyServiceModel;
import com.example.demo.data.models.service.CompanySignInServiceModel;
import com.example.demo.services.interfaces.CompanyAdministrativeInfoService;
import com.example.demo.services.interfaces.CompanyService;
import com.example.demo.services.interfaces.CompanySignInService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyRestController {

    private final ModelMapper modelMapper;
    private final CompanyService companyService;
    private final CompanySignInService companySignInService;
    private final CompanyAdministrativeInfoService companyAdministrativeInfoService;

    public CompanyRestController(ModelMapper modelMapper, CompanyService companyService, CompanySignInService companySignInService, CompanyAdministrativeInfoService companyAdministrativeInfoService) {
        this.modelMapper = modelMapper;
        this.companyService = companyService;
        this.companySignInService = companySignInService;
        this.companyAdministrativeInfoService = companyAdministrativeInfoService;
    }

    @PostMapping("/api/register/company")
    @CrossOrigin
    public void createCompany(@RequestBody CompanyRegisterDto companyRegisterDto) {

        this.modelMapper.getConfiguration().setAmbiguityIgnored(true);

        checkAvailableEmails(companyRegisterDto.getEmail(), companyRegisterDto.getCompanySignInEmail());

        CompanyAdministrativeInfoServiceModel companyAdministrativeInfo = this.modelMapper.
                map(companyRegisterDto, CompanyAdministrativeInfoServiceModel.class);

        CompanySignInServiceModel companySignIn = this.modelMapper.map(companyRegisterDto, CompanySignInServiceModel.class);

        CompanyServiceModel companyServiceModel = this.companyService.
                registerCompany(this.modelMapper.map(companyRegisterDto, CompanyServiceModel.class));

        companyAdministrativeInfo.setCompany(companyServiceModel);
        companySignIn.setCompany(companyServiceModel);

        this.companyAdministrativeInfoService.saveCompanyAdministrativeInfo(companyAdministrativeInfo);
        this.companySignInService.saveCompanySignInInformation(companySignIn);

    }

    void checkAvailableEmails(String administrativeEmail, String signInEmail) {
        if (this.companyAdministrativeInfoService.checkEmail(administrativeEmail))
        {
            throw new IllegalArgumentException("Имейлът " + administrativeEmail + " вече съществува в системата. Моля опитайте с друг.");
        }else if (this.companySignInService.findByEmail(signInEmail)){
            throw new IllegalArgumentException("Имейлът " + signInEmail + " вече съществува в системата. Моля опитайте с друг.");
        }
    }

}
