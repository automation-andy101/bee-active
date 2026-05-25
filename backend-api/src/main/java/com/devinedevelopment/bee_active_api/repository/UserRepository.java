package com.devinedevelopment.bee_active_api.repository;

import com.devinedevelopment.bee_active_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
}