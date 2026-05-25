package com.devinedevelopment.bee_active_api.repository;

import com.devinedevelopment.bee_active_api.model.Studio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudioRepository extends JpaRepository<Studio, Long> {
    
}