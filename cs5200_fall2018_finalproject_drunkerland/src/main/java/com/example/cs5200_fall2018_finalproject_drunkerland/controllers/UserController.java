package com.example.cs5200_fall2018_finalproject_drunkerland.controllers;

import com.example.cs5200_fall2018_finalproject_drunkerland.models.User;
import com.example.cs5200_fall2018_finalproject_drunkerland.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }


}
