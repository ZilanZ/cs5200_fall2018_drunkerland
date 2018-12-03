package edu.northeastern.cs5200_fall2018_finalproject_drunkerland;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.UserController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ControllerTests extends DemoApplicationTests {

    @Autowired
    UserController userController;
    
    //@Test
    public void testCreateUser() {
        User alice = new User("dan", "password", "Dan", "Jones");
        User user = userController.createUser(alice);
    }

    //@Test
    public void testFindAllUsers() {
        User test = new User("dan", "password", null, null);
        User users = userController.findUserByCredential(test);
    }
}
