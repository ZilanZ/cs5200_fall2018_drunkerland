package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers;

import java.sql.Date;
import java.util.List;


import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api.OrderApi;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Consumer;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Order;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/order")
public class OrderController implements OrderApi {
	
	@Autowired
    OrderRepository orderRepository;


	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}


	public List<Order> findAllOrders() {
		return (List<Order>) orderRepository.findAll();
	}


	public Order findOrderById(int id)
	{
		return orderRepository.findById(id).orElse(null);
	}


	public List<Order> findOrdersForConsumer(Consumer consumer)
	{
		return orderRepository.findOrdersForConsumer(consumer);
	}

	public List<Order> findOrdersByStatus( Order.OrderStatus status)
	{
		return orderRepository.findOrdersByStatus(status);

	}


	public List<Order> findOrdersByCreated(Date created)
	{
		return orderRepository.findOrdersByCreatedDate(created);

	}

	public void deleteOrderById(int id)
	{
		orderRepository.deleteById(id);
	}

	public Order updateOrderById(int id, Order newOrder)
	{
		Order order = findOrderById(id);
		order.set(newOrder);
        return orderRepository.save(order);
	}

}
