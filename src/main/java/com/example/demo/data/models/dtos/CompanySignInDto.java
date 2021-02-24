package com.example.demo.data.models.dtos;

public class CompanySignInDto {

    private String companySignInEmail;
    private String companySignInPassword;
    private String companySignInConfirmPassword;

    public CompanySignInDto() {
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

    public String getCompanySignInConfirmPassword() {
        return companySignInConfirmPassword;
    }

    public void setCompanySignInConfirmPassword(String companySignInConfirmPassword) {
        this.companySignInConfirmPassword = companySignInConfirmPassword;
    }
}
