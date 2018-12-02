package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api.UserApi;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.User;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController implements UserApi {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User findUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findUserByName(String name) {
        String[] names = name.split(" ");
        return userRepository.findUserByName(names[0], names[1]);
    }

    public User findUserByCredential(User user) {
        return userRepository.findUserByCredential(user.getUsername(), user.getPassword());
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    public User updateUserById(int id, User newUser) {
        User user = findUserById(id);
        user.set(newUser);
        return userRepository.save(user);
    }
}
