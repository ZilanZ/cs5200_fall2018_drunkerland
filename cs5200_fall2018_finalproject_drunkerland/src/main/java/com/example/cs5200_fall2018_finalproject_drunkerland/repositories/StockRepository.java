package com.example.cs5200_fall2018_finalproject_drunkerland.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.cs5200_fall2018_finalproject_drunkerland.models.Stock;

public interface StockRepository extends CrudRepository<Stock, Integer>{

}
