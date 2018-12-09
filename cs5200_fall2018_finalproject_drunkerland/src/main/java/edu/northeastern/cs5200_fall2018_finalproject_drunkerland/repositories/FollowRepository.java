package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Consumer;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Follow;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Reviewer;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FollowRepository extends CrudRepository<Follow, Integer>{
	
	@Query(value = "SELECT f FROM Follow f WHERE f.consumer = :consumer")
	List<Follow> findFollowsByConsumer(@Param("consumer") Consumer consumer);
	
	@Query(value = "SELECT f FROM Follow f WHERE f.reviewer = :reviewer")
	List<Follow> findFollowsByReviewer(@Param("reviewer") Reviewer reviewer);


}
