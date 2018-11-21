package edu.northeastern.cs5200.repository;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Follow;

public interface FollowRepository extends CrudRepository<Follow, Integer>{

}
