package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.User;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.UserRepository;
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
@RequestMapping("rest/api/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    /**
     * create user
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    /**
     * retrieve all users
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    /**
     * retrieve user by id
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findUserById(@PathVariable int id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * retrieve user by name
     * @param name
     * @return
     */
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public List<User> findUserByName(@RequestParam("name") String name) {
        String[] names = name.split(" ");
        return userRepository.findUserByName(names[0], names[1]);
    }

    /**
     * user authentication: retrieve user by credential
     * @param user
     * @return
     */
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public User findUserByCredential(@RequestBody User user) {
        return userRepository.findUserByCredential(user.getUsername(), user.getPassword());
    }

    /**
     * delete user by id
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable("id") int id) {
        userRepository.deleteById(id);
    }

    /**
     * update user by id
     * @param id
     * @param newUser
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User updateUserById(@PathVariable("id") int id, @RequestBody User newUser) {
        User user = findUserById(id);
        user.set(newUser);
        return userRepository.save(user);
    }
}
