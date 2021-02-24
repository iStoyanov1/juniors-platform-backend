package com.example.demo.data.entites;

import com.example.demo.data.entites.base.BaseEntity;
import com.example.demo.data.enums.Technologies;

import javax.persistence.*;
import java.util.List;

@Entity(name = "technologies")
public class Technology extends BaseEntity {

    private Technologies technology;
    private Category category;
    private Company company;
    private User user;

    public Technology() {
    }

    @Column(name = "technology")
    @Enumerated(EnumType.STRING)
    public Technologies getTechnology() {
        return technology;
    }

    public void setTechnology(Technologies technology) {
        this.technology = technology;
    }

    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @ManyToOne
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
