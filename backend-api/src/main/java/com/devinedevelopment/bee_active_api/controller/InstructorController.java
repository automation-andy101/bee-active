package com.devinedevelopment.bee_active_api.controller;

import com.devinedevelopment.bee_active_api.model.Instructor;
import com.devinedevelopment.bee_active_api.repository.InstructorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructor")
public class InstructorController {

    private final InstructorRepository instructorRepository;

    public InstructorController(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @GetMapping
    public List<Instructor> getInstructors() {
        return instructorRepository.findAll();
    }

    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        return instructorRepository.save(instructor);
    }
}
