package com.example.demo.data.models.service;

import com.example.demo.data.entites.Company;
import com.example.demo.data.models.service.base.BaseServiceModel;

public class CompanyContactsServiceModel extends BaseServiceModel {

    private String companyEmail;
    private String companyWebsite;
    private String companyAddress;
    private String companyPhone;
    private CompanyServiceModel company;

    public CompanyContactsServiceModel() {

    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public CompanyServiceModel getCompany() {
        return company;
    }

    public void CompanyServiceModel(CompanyServiceModel company) {
        this.company = company;
    }
}
