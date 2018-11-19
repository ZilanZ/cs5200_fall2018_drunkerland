package com.example.cs5200_fall2018_finalproject_drunkerland.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.cs5200_fall2018_finalproject_drunkerland.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
