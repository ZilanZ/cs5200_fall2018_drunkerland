package edu.northeastern.cs5200.repository;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Wine;



public interface WineRepository  extends CrudRepository<Wine, Integer>{

}
