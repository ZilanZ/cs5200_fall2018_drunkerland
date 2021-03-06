package edu.northeastern.cs5200_fall2018_finalproject_drunkerland;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.ConsumerController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.UserController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Consumer;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.ConsumerRepository;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by danlinjia on 12/2/18.
 */
public class ConsumerControllerTests extends DemoApplicationTests {
    @Autowired
     ConsumerController consumerController;

    @Autowired
    UserController userController;

    @Test
    public  void createConsumerTest(){
        Consumer consumer = new Consumer("jia", "jia", "danlin", "jia", "notaste");
        consumerController.createConsumer(consumer);
    }

    @Test
    public void findConsumerById(){
        int id = 66;
        consumerController.findConsumerById(id);
    }

    @Test
    public void findConsumerByName() {
        consumerController.findConsumerByName("danlin jia");
    }

    @Test
    public void findAllConsumer() {
        consumerController.findAllConsumers();
    }

    @Test
    public void findConsumerByCredential() {
        Consumer newConsumer = new Consumer("jia", "jia", "danlin", "jia", "sometaste");
        consumerController.findConsumerByCredential(newConsumer);
    }

    @Test
    public void updateConsumerById() {
        int id = 66;
        Consumer newConsumer = new Consumer("jia", "jia", "danlin", "jia", "sometaste");
        consumerController.updateConsumerById(id, newConsumer);
    }

//    @Test
//    public  void deleteConsumerById() {
//        int id = 59;
//        consumerController.deleteConsumerById(id);
//    }

    @Test
    public void testInitializeConsumer(){
        consumerController.createInitialShippingCartForConsumer(21);
    }

    @Test
    public void addAddressToUser(){
        userController.addAddressToUser(21, 1);
    }
}
