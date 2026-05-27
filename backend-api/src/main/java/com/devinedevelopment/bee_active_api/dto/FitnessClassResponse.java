package com.devinedevelopment.bee_active_api.dto;

import com.devinedevelopment.bee_active_api.model.FitnessClass;
import com.devinedevelopment.bee_active_api.model.Instructor;
import com.devinedevelopment.bee_active_api.model.Studio;

import java.time.LocalDateTime;

public class FitnessClassResponse {

    private Long id;
    private String title;
    private String category;
    private String city;
    private int capacity;
    private int spotsRemaining;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Instructor instructor;
    private Studio studio;

    public FitnessClassResponse(
            FitnessClass fitnessClass,
            int spotsRemaining
    ) {
        this.id = fitnessClass.getId();
        this.title = fitnessClass.getTitle();
        this.category = fitnessClass.getCategory();
        this.city = fitnessClass.getCity();
        this.capacity = fitnessClass.getCapacity();
        this.spotsRemaining = spotsRemaining;
        this.startTime = fitnessClass.getStartTime();
        this.endTime = fitnessClass.getEndTime();
        this.instructor = fitnessClass.getInstructor();
        this.studio = fitnessClass.getStudio();
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getCity() { return city; }
    public int getCapacity() { return capacity; }
    public int getSpotsRemaining() { return spotsRemaining; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public Instructor getInstructor() { return instructor; }
    public Studio getStudio() { return studio; }
}