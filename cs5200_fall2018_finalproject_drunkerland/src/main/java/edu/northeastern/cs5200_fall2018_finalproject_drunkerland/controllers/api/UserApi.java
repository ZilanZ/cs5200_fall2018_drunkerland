package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api;


import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * @PathVariable passing by URL eg. /{id}
 * @RequestParam passing by URL eg. ?key1=value1&key2=value2
 * @RequestBody passing by body [type: (default) json]
 *
 * we use @RestController here, @ResponseBody is not required. default: Json
 */
@RequestMapping("rest/api/users")
public interface UserApi {

    /**
     * create user
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    User createUser(@RequestBody User user);

    /**
     * retrieve all users
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    List<User> findAllUsers();

    /**
     * retrieve user by id
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User findUserById(@PathVariable int id);

    /**
     * retrieve user by name
     * @param name
     * @return
     */
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    List<User> findUserByName(@RequestParam("name") String name);

    /**
     * user authentication: retrieve user by credential
     * @param user
     * @return
     */
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    User findUserByCredential(@RequestBody User user);

    /**
     * Find user by username
     * @param username
     * @return
     */
    @RequestMapping(value = "/username", method = RequestMethod.POST)
    User findUserByUsername(@RequestParam("username") String username);

    /**
     * delete user by id
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteUserById(@PathVariable("id") int id);

    /**
     * update user by id
     * @param id
     * @param newUser
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    User updateUserById(@PathVariable("id") int id, @RequestBody User newUser);

}
