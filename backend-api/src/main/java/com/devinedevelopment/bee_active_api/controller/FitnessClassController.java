package com.devinedevelopment.bee_active_api.controller;

import com.devinedevelopment.bee_active_api.model.FitnessClass;
import com.devinedevelopment.bee_active_api.repository.BookingRepository;
import com.devinedevelopment.bee_active_api.repository.FitnessClassRepository;
import org.springframework.web.bind.annotation.*;

import com.devinedevelopment.bee_active_api.dto.FitnessClassResponse;
import com.devinedevelopment.bee_active_api.repository.BookingRepository;
import java.util.stream.Collectors;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class FitnessClassController {

    private final FitnessClassRepository fitnessClassRepository;

    private final BookingRepository bookingRepository;

    public FitnessClassController(FitnessClassRepository fitnessClassRepository, BookingRepository bookingRepository) {
        this.fitnessClassRepository = fitnessClassRepository;
        this.bookingRepository = bookingRepository;
    }

    @PostMapping
    public FitnessClass createClass(@RequestBody FitnessClass fitnessClass) {
        return fitnessClassRepository.save(fitnessClass);
    }

    @GetMapping("/{id}")
    public FitnessClassResponse getClassById(@PathVariable Long id) {
        FitnessClass fitnessClass = fitnessClassRepository.findById(id)
                .orElseThrow();

        long bookingCount = bookingRepository.countByFitnessClass(fitnessClass);
        int spotsRemaining = fitnessClass.getCapacity() - (int) bookingCount;

        return new FitnessClassResponse(fitnessClass, spotsRemaining);
    }

    @GetMapping
    public List<FitnessClassResponse> getClasses() {
        return fitnessClassRepository.findAll()
                .stream()
                .map(fitnessClass -> {
                    long bookingCount = bookingRepository.countByFitnessClass(fitnessClass);
                    int spotsRemaining = fitnessClass.getCapacity() - (int) bookingCount;

                    return new FitnessClassResponse(fitnessClass, spotsRemaining);
                })
                .collect(Collectors.toList());
    }
    
}
