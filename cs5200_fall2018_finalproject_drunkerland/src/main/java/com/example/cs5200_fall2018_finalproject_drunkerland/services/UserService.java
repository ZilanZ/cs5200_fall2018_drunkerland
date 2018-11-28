package com.example.cs5200_fall2018_finalproject_drunkerland.services;

import com.example.cs5200_fall2018_finalproject_drunkerland.models.User;
import com.example.cs5200_fall2018_finalproject_drunkerland.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserService {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/api/users")
    public List<User> findAllUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }
}
