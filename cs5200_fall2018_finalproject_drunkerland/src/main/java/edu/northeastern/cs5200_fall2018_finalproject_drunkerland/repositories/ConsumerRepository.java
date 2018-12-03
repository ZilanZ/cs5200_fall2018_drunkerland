package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Consumer;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConsumerRepository extends CrudRepository<Consumer, Integer>{
    @Query("select u from User u where u.firstName=:firstName and u.lastName=:lastName and dtype=Consumer")
    List<Consumer> findConsumerByName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("select u from User u where u.username=:username and dtype=Consumer")
    Consumer findConsumerByUsername(@Param("username") String username);

    @Query("select u from User u where u.username=:username and u.password=:password and dtype=Consumer")
    Consumer findConsumerByCredential(@Param("username") String username, @Param("password") String password);


}
