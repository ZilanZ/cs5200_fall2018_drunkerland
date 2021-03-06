package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories;

import java.sql.Date;
import java.util.List;


import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Consumer;

public interface OrderRepository extends CrudRepository<Order, Integer>{
	
	//1-find orders by status
	@Query(value="SELECT o FROM Order o WHERE o.status = :status")
	 List<Order> findOrdersByStatus(@Param("status") Order.OrderStatus status);
	
	//2-find orders by created date
	@Query(value="SELECT o FROM Order o WHERE o.created = :created")
	 List<Order> findOrdersByCreatedDate(@Param("created") Date created);
	
	//3-find orders for consumer
	@Query(value="SELECT o From Order o WHERE o.consumer = :consumer")
	 List<Order> findOrdersForConsumer(@Param("consumer") Consumer consumer);

}
