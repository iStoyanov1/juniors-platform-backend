package com.example.demo.data.models.dtos;

public class CompanyRegisterDto {

    private String name;
    private long bulstat;
    private byte[] logo;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    private String companySignInEmail;
    private String companySignInPassword;
    private String companySignInConfirmPassword;

    public CompanyRegisterDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBulstat() {
        return bulstat;
    }

    public void setBulstat(long bulstat) {
        this.bulstat = bulstat;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
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
