package com.example.demo.data.entites;

import com.example.demo.data.entites.base.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name = "company_sign_in")
public class CompanySignIn extends BaseEntity {

    private String companySignInEmail;
    private String companySignInPassword;
    private Company company;

    public CompanySignIn() {
    }

    @Column(name = "company_sign_in_email")
    public String getCompanySignInEmail() {
        return companySignInEmail;
    }

    public void setCompanySignInEmail(String companySignInEmail) {
        this.companySignInEmail = companySignInEmail;
    }

    @Column(name = "company_sign_in_password")
    public String getCompanySignInPassword() {
        return companySignInPassword;
    }

    public void setCompanySignInPassword(String companySignInPassword) {
        this.companySignInPassword = companySignInPassword;
    }

    @OneToOne
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
