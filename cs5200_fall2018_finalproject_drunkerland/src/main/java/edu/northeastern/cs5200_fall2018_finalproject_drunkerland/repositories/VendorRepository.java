package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Vendor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface VendorRepository extends CrudRepository<Vendor, Integer>{
    @Query("select u from Vendor u where u.firstName=:firstName and u.lastName=:lastName and dtype=Vendor")
    List<Vendor> findVendorByName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("select u from Vendor u where u.username=:username and dtype=Vendor")
    Vendor findVendorByVendorname(@Param("username") String username);

    @Query("select u from Vendor u where u.username=:username and u.password=:password and dtype=Vendor")
    Vendor findVendorByCredential(@Param("username") String username, @Param("password") String password);


}
