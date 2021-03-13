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

    private AuthServiceModel auth;
    private String firstName;
    private String lastName;
    private String description;
    private String phone;
    private FileServiceModel file;
    private List<CompanyServiceModel> companies;
    private List<TechnologyServiceModel> technologies;
    private JobOfferServiceModel jobOffer;

    public UserServiceModel() {
    }

    public AuthServiceModel getAuth() {
        return auth;
    }

    public void setAuth(AuthServiceModel auth) {
        this.auth = auth;
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

    public FileServiceModel getFile() {
        return file;
    }

    public void setFile(FileServiceModel file) {
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

    public JobOfferServiceModel getJobOffer() {
        return jobOffer;
    }

    public void setJobOffer(JobOfferServiceModel jobOffer) {
        this.jobOffer = jobOffer;
    }
}
