package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Item;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Order;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Stock;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends CrudRepository<Item, Integer>{

	@Query(value = "SELECT i FROM Item i WHERE i.order = :order")
	List<Item> findItemByOrder(@Param("order") Order order);
	
	
	@Query(value = "SELECT i FROM Item i WHERE i.stock = :stock")
	List<Item> findItemByStock(@Param("stock") Stock stock);
	
	
}
