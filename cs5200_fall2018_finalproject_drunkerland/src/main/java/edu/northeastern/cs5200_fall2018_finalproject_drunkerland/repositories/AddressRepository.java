package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Address;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.User;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends CrudRepository<Address, Integer> {
	
	@Query(value = "SELECT a FROM Address a WHERE a.user = :user")
	List<Address> findAddressesByUser(@Param("user") User user);
}
