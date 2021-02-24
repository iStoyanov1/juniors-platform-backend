package com.example.demo.services.interfaces;

import com.example.demo.data.models.service.CompanyAdministrativeInfoServiceModel;

public interface CompanyAdministrativeInfoService {

    void saveCompanyAdministrativeInfo(CompanyAdministrativeInfoServiceModel companyAdministrativeInfoServiceModel);

    boolean checkEmail(String email);
}
