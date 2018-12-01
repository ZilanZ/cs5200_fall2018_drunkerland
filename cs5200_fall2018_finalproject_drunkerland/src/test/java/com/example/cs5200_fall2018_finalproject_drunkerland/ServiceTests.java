package com.example.cs5200_fall2018_finalproject_drunkerland;

import com.example.cs5200_fall2018_finalproject_drunkerland.models.User;
import com.example.cs5200_fall2018_finalproject_drunkerland.services.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceTests extends DemoApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void testCreateUser() {
        User user = new User("alice", "password", "Alice", "Wonderland");
        User newUser = userService.createUser(user);
    }
}
