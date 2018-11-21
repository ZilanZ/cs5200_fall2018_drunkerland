package edu.northeastern.cs5200.repository;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Item;

public interface ItemRepository extends CrudRepository<Item, Integer>{

}
