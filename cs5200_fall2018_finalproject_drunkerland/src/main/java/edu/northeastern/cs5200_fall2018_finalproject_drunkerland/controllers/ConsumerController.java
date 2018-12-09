package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api.ConsumerApi;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Article;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Consumer;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumerController implements ConsumerApi {

    @Autowired
    ConsumerRepository consumerRepository;


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

}
