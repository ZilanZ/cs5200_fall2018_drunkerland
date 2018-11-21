package edu.northeastern.cs5200.repository;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>{

}
