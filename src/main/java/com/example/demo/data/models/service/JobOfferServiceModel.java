package com.example.demo.data.models.service;

import com.example.demo.data.entites.Company;
import com.example.demo.data.entites.Technology;
import com.example.demo.data.models.service.base.BaseServiceModel;

import java.time.LocalDate;
import java.util.List;

public class JobOfferServiceModel extends BaseServiceModel {

    private String title;
    private LocalDate date;
    private String description;
    private String city;
    private int views;
    private CompanyServiceModel company;
    private List<TechnologyServiceModel> technologies;

    public JobOfferServiceModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public CompanyServiceModel getCompany() {
        return company;
    }

    public void setCompany(CompanyServiceModel company) {
        this.company = company;
    }

    public List<TechnologyServiceModel> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<TechnologyServiceModel> technologies) {
        this.technologies = technologies;
    }
}
