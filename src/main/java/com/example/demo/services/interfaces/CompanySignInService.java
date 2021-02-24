package com.example.demo.services.interfaces;

import com.example.demo.data.entites.CompanySignIn;
import com.example.demo.data.models.service.CompanySignInServiceModel;

public interface CompanySignInService {

    void saveCompanySignInInformation(CompanySignInServiceModel companySignInServiceModel);

    boolean findByEmail(String email);

}
