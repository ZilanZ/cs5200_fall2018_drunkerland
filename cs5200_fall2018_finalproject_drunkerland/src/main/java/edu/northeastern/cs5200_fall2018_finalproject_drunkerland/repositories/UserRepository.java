package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("select u from User u where u.firstName=:firstName and u.lastName=:lastName")
    List<User> findUserByName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("select u from User u where u.username=:username")
    User findUserByUsername(@Param("username") String username);

    @Query("select u from User u where u.username=:username and u.password=:password")
    User findUserByCredential(@Param("username") String username, @Param("password") String password);

}
