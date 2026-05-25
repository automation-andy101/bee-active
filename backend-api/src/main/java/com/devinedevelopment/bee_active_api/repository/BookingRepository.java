package com.devinedevelopment.bee_active_api.repository;

import com.devinedevelopment.bee_active_api.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
