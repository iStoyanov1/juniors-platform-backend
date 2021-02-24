package com.example.demo.data.models.service;

import com.example.demo.data.entites.Company;
import com.example.demo.data.entites.JobOffer;
import com.example.demo.data.entites.Role;
import com.example.demo.data.entites.Technology;
import com.example.demo.data.models.service.base.BaseServiceModel;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

public class UserServiceModel extends BaseServiceModel {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String description;
    private String phone;
    private byte[] file;
    private List<CompanyServiceModel> companies;
    private List<TechnologyServiceModel> technologies;
    private Set<RoleServiceModel> authorities;
    private JobOfferServiceModel jobOffer;

    public UserServiceModel() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public List<CompanyServiceModel> getCompanies() {
        return companies;
    }

    public void setCompanies(List<CompanyServiceModel> companies) {
        this.companies = companies;
    }

    public List<TechnologyServiceModel> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<TechnologyServiceModel> technologies) {
        this.technologies = technologies;
    }

    public Set<RoleServiceModel> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<RoleServiceModel> authorities) {
        this.authorities = authorities;
    }

    public JobOfferServiceModel getJobOffer() {
        return jobOffer;
    }

    public void setJobOffer(JobOfferServiceModel jobOffer) {
        this.jobOffer = jobOffer;
    }
}
