package edu.northeastern.cs5200.repository;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Package;

public interface PackageRepository extends CrudRepository<Package, Integer>{

}
