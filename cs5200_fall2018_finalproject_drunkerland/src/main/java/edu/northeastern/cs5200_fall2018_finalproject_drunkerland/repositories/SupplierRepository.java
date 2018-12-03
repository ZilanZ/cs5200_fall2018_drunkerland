package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Supplier;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Supplier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SupplierRepository extends CrudRepository<Supplier, Integer> {
    @Query("select u from Supplier u where u.firstName=:firstName and u.lastName=:lastName and dtype=Supplier")
    List<Supplier> findSupplierByName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("select u from Supplier u where u.username=:username and dtype=Supplier")
    Supplier findSupplierBySuppliername(@Param("username") String username);

    @Query("select u from Supplier u where u.username=:username and u.password=:password and dtype=Supplier")
    Supplier findSupplierByCredential(@Param("username") String username, @Param("password") String password);


}
