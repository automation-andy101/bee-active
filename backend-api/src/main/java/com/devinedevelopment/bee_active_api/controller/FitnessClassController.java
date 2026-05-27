package com.devinedevelopment.bee_active_api.controller;

import com.devinedevelopment.bee_active_api.model.FitnessClass;
import com.devinedevelopment.bee_active_api.repository.FitnessClassRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class FitnessClassController {

    private final FitnessClassRepository repository;

    public FitnessClassController(FitnessClassRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<FitnessClass> getClasses() {
        return repository.findAll();
    }

    @PostMapping
    public FitnessClass createClass(@RequestBody FitnessClass fitnessClass) {
        return repository.save(fitnessClass);
    }

    @GetMapping("/{id}")
    public FitnessClass getClassById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow();
    }
    
}
