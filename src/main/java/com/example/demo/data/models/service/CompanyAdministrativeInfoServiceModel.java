package com.example.demo.data.models.service;

import com.example.demo.data.models.service.base.BaseServiceModel;

public class CompanyAdministrativeInfoServiceModel extends BaseServiceModel {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private CompanyServiceModel company;

    public CompanyAdministrativeInfoServiceModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CompanyServiceModel getCompany() {
        return company;
    }

    public void setCompany(CompanyServiceModel company) {
        this.company = company;
    }
}
