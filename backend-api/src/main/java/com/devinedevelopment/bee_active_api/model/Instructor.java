package com.devinedevelopment.bee_active_api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @JsonIgnore
    @OneToMany(mappedBy = "instructor")
    private List<FitnessClass> fitnessClasses;
    
    @ManyToOne
    @JoinColumn(name = "studio_id")
    private Studio studio;

    public Instructor() {}

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<FitnessClass> getFitnessClasses() {
        return fitnessClasses;
    }

    public void setFitnessClasses(List<FitnessClass> fitnessClasses) {
        this.fitnessClasses = fitnessClasses;
    }
}
