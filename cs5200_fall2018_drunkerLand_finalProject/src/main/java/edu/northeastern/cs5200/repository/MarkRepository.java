package edu.northeastern.cs5200.repository;

import org.springframework.data.repository.CrudRepository;


import edu.northeastern.cs5200.models.Mark;

public interface MarkRepository extends CrudRepository<Mark, Integer>{

}
