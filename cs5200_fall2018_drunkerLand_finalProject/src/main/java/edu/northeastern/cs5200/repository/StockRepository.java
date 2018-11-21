package edu.northeastern.cs5200.repository;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Stock;

public interface StockRepository extends CrudRepository<Stock, Integer>{

}
