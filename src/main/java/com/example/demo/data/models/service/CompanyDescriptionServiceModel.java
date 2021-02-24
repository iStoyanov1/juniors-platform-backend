package com.example.demo.data.models.service;

import com.example.demo.data.entites.Company;
import com.example.demo.data.entites.Technology;
import com.example.demo.data.models.service.base.BaseServiceModel;

import java.util.List;

public class CompanyDescriptionServiceModel extends BaseServiceModel {

    private String information;
    private int year;
    private String urlPath;
    private List<TechnologyServiceModel> technologies;
    private CompanyServiceModel company;

    public CompanyDescriptionServiceModel() {
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public List<TechnologyServiceModel> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<TechnologyServiceModel> technologies) {
        this.technologies = technologies;
    }

    public CompanyServiceModel getCompany() {
        return company;
    }

    public void setCompany(CompanyServiceModel company) {
        this.company = company;
    }
}
