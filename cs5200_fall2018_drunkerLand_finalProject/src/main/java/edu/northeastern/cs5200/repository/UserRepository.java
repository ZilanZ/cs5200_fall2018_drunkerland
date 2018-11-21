package edu.northeastern.cs5200.repository;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.User;



public interface UserRepository extends CrudRepository<User, Integer> {

}
