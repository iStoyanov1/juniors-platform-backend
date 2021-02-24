package com.example.demo.data.entites;

import com.example.demo.data.entites.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "company_description")
public class CompanyDescription extends BaseEntity {

    private String information;
    private int year;
    private String urlPath;
    private List<Technology> technologies;
    private Company company;

    public CompanyDescription() {
    }

    @Column(name = "company_information")
    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Column(name = "company_year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Column(name = "url")
    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    @OneToMany(mappedBy = "company")
    public List<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }

    @OneToOne
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
