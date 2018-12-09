package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Mark;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Reviewer;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Wine;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MarkRepository extends CrudRepository<Mark, Integer>{
	
	
	@Query(value = "SELECT m FROM Mark m WHERE m.reviewer = :reviewer")
	List<Mark> findMarksByReviewer(@Param("reviewer") Reviewer reviewer);
	
	
	@Query(value = "SELECT m FROM Mark m WHERE m.wine = :wine")
	List<Mark> findMarksByWine(@Param("wine") Wine wine);


}
