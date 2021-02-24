package com.example.demo.data.entites;

import com.example.demo.data.entites.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "companies")
public class Company extends BaseEntity {

    private String name;
    private byte[] logo;
    private long bulstat;
    private List<JobOffer> jobOffers;

    public Company() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "logo")
    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    @Column(name = "bulstat")
    public long getBulstat() {
        return bulstat;
    }

    public void setBulstat(long bulstat) {
        this.bulstat = bulstat;
    }

    @OneToMany(mappedBy = "company")
    public List<JobOffer> getJobOffers() {
        return jobOffers;
    }

    public void setJobOffers(List<JobOffer> jobOffers) {
        this.jobOffers = jobOffers;
    }
}

