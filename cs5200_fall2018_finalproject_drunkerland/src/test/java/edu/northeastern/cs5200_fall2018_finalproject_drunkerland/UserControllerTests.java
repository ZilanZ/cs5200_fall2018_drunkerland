package edu.northeastern.cs5200_fall2018_finalproject_drunkerland;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.UserController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.User;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by danlinjia on 12/2/18.
 */
public class UserControllerTests extends DemoApplicationTests {

    @Autowired
    UserController userController;

    //@Test
    public void testCreateUser() {
        User alice = new User("jia", "jia", "Dan", "Jones");
        assert (userController.createUser(alice)==null);
    }

//    @Test
//    public void testFindAllUsers() {
//        userController.findAllUsers();
//    }
//
//    @Test
//    public void testFindUserByName() {
//        userController.findUserByName("Dan Jones");
//    }
//
//    @Test
//    public void testFindUsersByCredential() {
//        User test = new User("dan", "password", null, null);
//        userController.findUserByCredential(test);
//    }
//
//   // @Test
//    public void testDeleteUserById() {
//        int id = 38;
//        userController.deleteUserById(id);
//    }
//
//    //@Test
//    public void testUpdateUserById() {
//        int id = 37;
//        User test = new User("danlin", "danlin", "danlin", "jia");
//        userController.updateUserById(id, test);
//    }
}
