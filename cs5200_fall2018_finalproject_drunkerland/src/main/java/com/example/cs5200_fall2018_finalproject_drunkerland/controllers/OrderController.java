package com.example.cs5200_fall2018_finalproject_drunkerland.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cs5200_fall2018_finalproject_drunkerland.models.Order;
import com.example.cs5200_fall2018_finalproject_drunkerland.repositories.OrderRepository;

@RestController
@RequestMapping("api/order")
public class OrderController {
	
	@Autowired
	OrderRepository orderRepository;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

	 @RequestMapping(value = "/findAll", method = RequestMethod.GET)
	    public List<Order> findAllOrders() {
	        return (List<Order>) orderRepository.findAll();
	    }

}
