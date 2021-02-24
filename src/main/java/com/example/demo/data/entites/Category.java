package com.example.demo.data.entites;

import com.example.demo.data.entites.base.BaseEntity;
import com.example.demo.data.enums.Categories;

import javax.persistence.*;
import java.util.List;

@Entity(name = "categories")
public class Category extends BaseEntity {

    private Categories category;
    private List<Technology> technologies;

    public Category() {
    }

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    @OneToMany(mappedBy = "category")
    public List<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }
}
