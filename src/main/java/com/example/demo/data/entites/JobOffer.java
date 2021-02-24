package com.example.demo.data.entites;

import com.example.demo.data.entites.base.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "job_offers")
public class JobOffer extends BaseEntity {

    private String title;
    private LocalDate date;
    private String description;
    private String city;
    private int views;
    private Company company;
    private List<Technology> technologies;

    public JobOffer() {
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "date")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "views")
    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @ManyToOne
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @ManyToMany(targetEntity = Technology.class, fetch = FetchType.EAGER)
    @JoinTable(
            name = "job_offers_technologies",
            joinColumns = @JoinColumn(
                    name = "job_offer_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "technology_id",
                    referencedColumnName = "id"
            )
    )
    public List<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }
}
