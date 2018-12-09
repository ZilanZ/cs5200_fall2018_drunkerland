package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api;


import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Consumer;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @PathVariable passing by URL eg. /{id}
 * @RequestParam passing by URL eg. ?key1=value1&key2=value2
 * @RequestBody passing by body [type: (default) json]
 *
 * we use @RestController here, @ResponseBody is not required. default: Json
 */
@RequestMapping("rest/api/consumers")
public interface ConsumerApi {

    /**
     * create consumer
     * @param consumer
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    Consumer createConsumer(@RequestBody Consumer consumer);

    /**
     * retrieve all consumers
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    List<Consumer> findAllConsumers();

    /**
     * retrieve consumer by id
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Consumer findConsumerById(@PathVariable int id);

    /**
     * retrieve consumer by name
     * @param name
     * @return
     */
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    List<Consumer> findConsumerByName(@RequestParam("name") String name);

    /**
     * consumer authentication: retrieve consumer by credential
     * @param consumer
     * @return
     */
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    Consumer findConsumerByCredential(@RequestBody Consumer consumer);

    /**
     * delete consumer by id
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteConsumerById(@PathVariable("id") int id);

    /**
     * update consumer by id
     * @param id
     * @param newConsumer
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Consumer updateConsumerById(@PathVariable("id") int id, @RequestBody Consumer newConsumer);

}
