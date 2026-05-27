package com.devinedevelopment.bee_active_api.controller;

import com.devinedevelopment.bee_active_api.model.Booking;
import com.devinedevelopment.bee_active_api.model.FitnessClass;
import com.devinedevelopment.bee_active_api.model.User;
import com.devinedevelopment.bee_active_api.repository.BookingRepository;
import com.devinedevelopment.bee_active_api.repository.FitnessClassRepository;
import com.devinedevelopment.bee_active_api.repository.UserRepository;

import com.devinedevelopment.bee_active_api.exception.BookingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final FitnessClassRepository fitnessClassRepository;

    public BookingController(BookingRepository bookingRepository, 
        UserRepository userRepository, 
        FitnessClassRepository fitnessClassRepository
    ) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.fitnessClassRepository = fitnessClassRepository;
    }

    @GetMapping
    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking bookingRequest) {
        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByEmail(email).orElseThrow();

        FitnessClass fitnessClass = fitnessClassRepository
                .findById(bookingRequest.getFitnessClass().getId())
                .orElseThrow();

        if (bookingRepository.existsByUserAndFitnessClass(user, fitnessClass)) {
            throw new BookingException("You already booked this class");
        }

        long currentBookings = bookingRepository.countByFitnessClass(fitnessClass);

        if (currentBookings >= fitnessClass.getCapacity()) {
            throw new BookingException("Class is full");
        }

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setFitnessClass(fitnessClass);

        return bookingRepository.save(booking);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingRepository.deleteById(id);
    }

    @GetMapping("/my")
    public List<Booking> getMyBookings() {

        String email = SecurityContextHolder
            .getContext()
            .getAuthentication()
            .getName();

        User user = userRepository
            .findByEmail(email)
            .orElseThrow();

        return bookingRepository.findByUser(user);
    }
    
}