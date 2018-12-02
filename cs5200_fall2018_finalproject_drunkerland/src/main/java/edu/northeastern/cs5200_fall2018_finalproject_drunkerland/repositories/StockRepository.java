package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, Integer>{

}
