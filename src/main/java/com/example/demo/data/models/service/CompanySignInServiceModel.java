package com.example.demo.data.models.service;

import com.example.demo.data.entites.Company;
import com.example.demo.data.models.service.base.BaseServiceModel;

public class CompanySignInServiceModel extends BaseServiceModel {

    private String companySignInEmail;
    private String companySignInPassword;
    private CompanyServiceModel company;

    public CompanySignInServiceModel() {
    }

    public String getCompanySignInEmail() {
        return companySignInEmail;
    }

    public void setCompanySignInEmail(String companySignInEmail) {
        this.companySignInEmail = companySignInEmail;
    }

    public String getCompanySignInPassword() {
        return companySignInPassword;
    }

    public void setCompanySignInPassword(String companySignInPassword) {
        this.companySignInPassword = companySignInPassword;
    }

    public CompanyServiceModel getCompany() {
        return company;
    }

    public void setCompany(CompanyServiceModel company) {
        this.company = company;
    }
}
