package com.devinedevelopment.bee_active_api.controller;

import com.devinedevelopment.bee_active_api.model.Studio;
import com.devinedevelopment.bee_active_api.repository.StudioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/studios")
public class StudioController {

    private final StudioRepository studioRepository;

    public StudioController(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    @GetMapping
    public List<Studio> getStudios() {
        return studioRepository.findAll();
    }

    @PostMapping
    public Studio createStudio(@RequestBody Studio studio) {
        return studioRepository.save(studio);
    }
}
