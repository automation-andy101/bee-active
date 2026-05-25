package com.devinedevelopment.bee_active_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private String city;

    @JsonIgnore
    @OneToMany(mappedBy = "studio")
    private List<FitnessClass> fitnessClasses;

    @JsonIgnore
    @OneToMany(mappedBy = "studio")
    private List<Instructor> instructors;

    public Studio() {}

    public Studio(String name, String category, String city) {
        this.name = name;
        this.category = category;
        this.city = city;
    }

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public List<FitnessClass> getFitnessClasses() { return fitnessClasses; }
    public void setFitnessClasses(List<FitnessClass> fitnessClasses) {
        this.fitnessClasses = fitnessClasses;
    }

    public List<Instructor> getInstructors() { return instructors; }
    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }
}