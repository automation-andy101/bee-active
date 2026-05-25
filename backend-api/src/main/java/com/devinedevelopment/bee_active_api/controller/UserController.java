package com.devinedevelopment.bee_active_api.controller;

import com.devinedevelopment.bee_active_api.model.Studio;
import com.devinedevelopment.bee_active_api.model.User;
import com.devinedevelopment.bee_active_api.repository.StudioRepository;
import com.devinedevelopment.bee_active_api.repository.UserRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
