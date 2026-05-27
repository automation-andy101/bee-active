package com.devinedevelopment.bee_active_api.repository;

import com.devinedevelopment.bee_active_api.model.Booking;
import com.devinedevelopment.bee_active_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.devinedevelopment.bee_active_api.model.FitnessClass;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByUser(User user);

    long countByFitnessClass(FitnessClass fitnessClass);

    boolean existsByUserAndFitnessClass(User user, FitnessClass fitnessClass);
}
