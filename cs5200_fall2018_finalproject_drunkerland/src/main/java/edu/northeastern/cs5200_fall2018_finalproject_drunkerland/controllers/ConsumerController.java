package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api.ConsumerApi;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.*;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.ConsumerRepository;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;
import java.util.StringJoiner;

@RestController
public class ConsumerController implements ConsumerApi {

    @Autowired
    ConsumerRepository consumerRepository;
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderController orderController;

    @Autowired
    UserController userController;

    public Consumer createConsumer(Consumer consumer) {
        return consumerRepository.save(consumer);
    }

    public List<Consumer> findAllConsumers() {
        return (List<Consumer>) consumerRepository.findAll();
    }

    public Consumer findConsumerById(int id) {
        return consumerRepository.findById(id).orElse(null);
    }

    public List<Consumer> findConsumerByName(String name) {
        String[] names = name.split(" ");
        return  consumerRepository.findConsumerByName(names[0], names[1]);
    }

    public Consumer findConsumerByCredential(Consumer consumer) {
        return (Consumer) consumerRepository.findConsumerByCredential(consumer.getUsername(), consumer.getPassword());
    }

    public void deleteConsumerById(int id) {
        consumerRepository.deleteById(id);
    }

    public Consumer updateConsumerById(int id, Consumer newConsumer) {
        Consumer consumer = findConsumerById(id);
        consumer.setConsumer(newConsumer);
        return consumerRepository.save(consumer);
    }

    public Consumer addOrderForConsumer(int cId, int oId){
        Consumer consumer = findConsumerById(cId);
        Order order = orderController.findOrderById(oId);
        consumer.addOrder(order);
        order.setConsumer(consumer);
        orderRepository.save(order);
        return consumerRepository.save(consumer);
    }

    public void createInitialShippingCartForConsumer(int consumerId) {
        java.util.Date utilDate = new java.util.Date();
        Date createDate = new java.sql.Date(utilDate.getTime());
        Address address = userController.findPrimaryAddressForUser(consumerId);
        if (address==null) {
            System.out.println("Error: user has not set primary address");
            return;
        }
        String destination = address.getStreet1()+", "+address.getStreet2()+", "+address.getCity()+", "
                +address.getState()+", "+ address.getZipcode() + ", " + address.getCountry();
        Order order = new Order( Order.OrderStatus.BASKET, destination,0 , createDate);
        orderController.createOrder(order);
        this.addOrderForConsumer(consumerId, order.getId());
    }

}
