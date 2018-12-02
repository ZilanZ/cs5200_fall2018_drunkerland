package com.example.cs5200_fall2018_finalproject_drunkerland;

import com.example.cs5200_fall2018_finalproject_drunkerland.controllers.UserController;
import com.example.cs5200_fall2018_finalproject_drunkerland.models.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ControllerTests extends DemoApplicationTests {

    @Autowired
    UserController userController;
    
    @Test
    public void testCreateUser() {
        User alice = new User("alice", "password", "Alice", "Wonderland");
        User user = userController.createUser(alice);
    }
}
