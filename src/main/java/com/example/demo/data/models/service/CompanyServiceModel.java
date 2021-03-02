package com.example.demo.data.models.service;

import com.example.demo.data.entites.*;
import com.example.demo.data.models.service.base.BaseServiceModel;

import java.util.List;

public class CompanyServiceModel extends BaseServiceModel {

    private AuthServiceModel authServiceModel;
    private String name;
    private byte[] logo;
    private long bulstat;
    private List<JobOfferServiceModel> jobOffers;

    public CompanyServiceModel() {
    }

    public AuthServiceModel getAuthServiceModel() {
        return authServiceModel;
    }

    public void setAuthServiceModel(AuthServiceModel authServiceModel) {
        this.authServiceModel = authServiceModel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public long getBulstat() {
        return bulstat;
    }

    public void setBulstat(long bulstat) {
        this.bulstat = bulstat;
    }

    public List<JobOfferServiceModel> getJobOffers() {
        return jobOffers;
    }

    public void setJobOffers(List<JobOfferServiceModel> jobOffers) {
        this.jobOffers = jobOffers;
    }
}
