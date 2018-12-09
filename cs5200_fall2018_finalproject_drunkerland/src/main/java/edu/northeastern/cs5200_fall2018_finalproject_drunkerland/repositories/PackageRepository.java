package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Package;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PackageRepository extends CrudRepository<Package, Integer>{

	@Query(value = "SELECT p FROM Package p WHERE p.trackingNumber = :trackingNumber")
	Package findPackageByTracking(@Param("trackingNumber") String trackingNumber);
	
	@Query(value="SELECT p FROM Package p WHERE p.status = :status")
	List<Package> findPackagesByStatus(@Param("status") Package.PackageStatus status);
	
}
