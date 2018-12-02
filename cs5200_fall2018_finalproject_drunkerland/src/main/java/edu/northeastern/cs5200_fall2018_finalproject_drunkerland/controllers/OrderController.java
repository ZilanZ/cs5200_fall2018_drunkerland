package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers;

import java.sql.Date;
import java.util.List;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Consumer;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Order;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/order")
public class OrderController {
	
	@Autowired
    OrderRepository orderRepository;
	
	//1-create order
	@RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Order createOrder(@RequestBody Order order)
	{
        return orderRepository.save(order);
    }

	//2-find all orders
	 @RequestMapping(value = "/findAll", method = RequestMethod.GET)
	    public List<Order> findAllOrders() 
	 {
	        return (List<Order>) orderRepository.findAll();
	    }
	 
	//3-find orders by status
	 @RequestMapping(value = "/findByStatus/{status}", method = RequestMethod.GET)
	    public List<Order> findOrdersByStatus(@PathVariable("status") Order.OrderStatus status)
	 {
	        return (List<Order>) orderRepository.findOrdersByStatus(status);
	        	
	 }
	 
	 //4-find orders by created date
	 @RequestMapping(value = "/findByCreatedDate/{created}", method = RequestMethod.GET)
	    public List<Order> findOrdersByCreated(@PathVariable("created") Date created) 
	 {
	        return (List<Order>) orderRepository.findOrdersByCreatedDate(created);
	        	
	 }
	 
	 //5-find orders for consumer
	 @RequestMapping(value = "/findByConsumer/{consumer}", method = RequestMethod.GET)
	    public List<Order> findOrdersForConsumer(@PathVariable("consumer") Consumer consumer)
	    {
		     return (List<Order>) orderRepository.findOrdersForConsumer(consumer);
	    }
    
}
