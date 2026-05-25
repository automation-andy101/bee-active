package com.devinedevelopment.bee_active_api.model;

import jakarta.persistence.*;

@Entity
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    private String city;

    public Studio() {}

    public Studio(String name, String category, String city) {
        this.name = name;
        this.category = category;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
