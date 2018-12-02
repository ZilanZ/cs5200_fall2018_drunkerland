package com.example.cs5200_fall2018_finalproject_drunkerland.controllers;

import com.example.cs5200_fall2018_finalproject_drunkerland.models.User;
import com.example.cs5200_fall2018_finalproject_drunkerland.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @PathVariable passing by URL eg. /{id}
 * @RequestParam passing by URL eg. ?key1=value1&key2=value2
 * @RequestBody passing by body [type: (default) json]
 *
 * we use @RestController here, @ResponseBody is not required. default: Json
 */
@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
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

    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public List<User> findUserByName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return userRepository.findUserByName(firstName, lastName);
    }

    @RequestMapping(value = "/findByCredential", method = RequestMethod.POST)
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
