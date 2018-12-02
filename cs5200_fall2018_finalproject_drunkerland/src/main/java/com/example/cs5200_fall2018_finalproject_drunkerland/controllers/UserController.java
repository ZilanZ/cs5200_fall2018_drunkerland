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


    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public User findUserById(@PathVariable int id) {
        return userRepository.findById(id).orElse(null);
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.POST)
    @ResponseBody
    public List<User> findUserByName(@RequestBody User user) {
        return userRepository.findUserByName(user.getFirstName(), user.getLastName());
    }

    @RequestMapping(value = "/findByCredential", method = RequestMethod.POST)
    @ResponseBody
    public User findUserByCredential(@RequestBody User user) {
        return userRepository.findUserByCredential(user.getUsername(), user.getPassword());
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable("id") int id) {
        userRepository.deleteById(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public User updateUserById(@PathVariable("id") int id, @RequestBody User newUser) {
        User user = findUserById(id);
        user.set(newUser);
        return userRepository.save(user);
    }
}
