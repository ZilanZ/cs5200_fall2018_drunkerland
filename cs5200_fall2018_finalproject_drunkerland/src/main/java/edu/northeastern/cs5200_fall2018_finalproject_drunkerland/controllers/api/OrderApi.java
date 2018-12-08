package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api;


import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Order;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;


/**
 * @PathVariable passing by URL eg. /{id}
 * @RequestParam passing by URL eg. ?key1=value1&key2=value2
 * @RequestBody passing by body [type: (default) json]
 *
 * we use @RestController here, @ResponseBody is not required. default: Json
 */
@RequestMapping("rest/api/orders")
public interface OrderApi {

    /**
     * @param order
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    Order createOrder(@RequestBody Order order);


    /**
     * retrieve all orders
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    List<Order> findAllOrders();


    /**
     * retrieve order by order id
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Order findOrderById(@PathVariable int id);


    /**
     * retrieve orders placed by consumer
     * @param cId
     * @return
     */
    @RequestMapping(value = "/{cId}/orders", method = RequestMethod.GET)
    List<Order> findOrdersForConsumer(@PathVariable int cId);


    /**
     * retrieve orders by order status
     * @param status
     * @return
     */
    @RequestMapping(value = "/{status}", method = RequestMethod.GET)
    List<Order> findOrdersByStatus(@PathVariable Order.OrderStatus status);


    /**
     * retrieve orders by created date
     * @param created
     * @return
     */

    @RequestMapping(value = "/{created}", method = RequestMethod.GET)
    List<Order> findOrdersByCreated(@PathVariable("created") Date created);


    /**
     * delete order by order id
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteOrderById(@PathVariable("id") int id);



    /**
     * update order by order id
     * @param id
     * @param newOrder
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Order updateOrderById(@PathVariable("id") int id, @RequestBody Order newOrder);


}
