package com.devinedevelopment.bee_active_api.repository;

import com.devinedevelopment.bee_active_api.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
