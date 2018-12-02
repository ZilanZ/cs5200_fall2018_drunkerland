package com.example.cs5200_fall2018_finalproject_drunkerland.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.cs5200_fall2018_finalproject_drunkerland.models.Order;
import com.example.cs5200_fall2018_finalproject_drunkerland.models.Order.OrderStatus;

public interface OrderRepository extends CrudRepository<Order, Integer>{
	
	//1-find order by status
	@Query(value="SELECT status FROM Order o WHERE o.status = :status")
	public Order findOrderByStatus(@Param("status") OrderStatus status);

}
