package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Package;

@RequestMapping("rest/api/package")
public interface PackageApi {
	
	
	/**
	 * create package
	 * @param pack
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	Package createPackage(Package pack);
	
	/**
	 * retrieve all packages
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
    List<Package> findAllPackages();
	
	
	/**
	 * retrieve package by package id
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	Package findPackageById(@PathVariable int id);
	
	
	/**
	 * retrieve package by tracking number
	 * @param trackingNumber
	 * @return
	 */
	@RequestMapping(value = "/tracking", method = RequestMethod.GET)
	Package findPackageByTrackingNum(@RequestParam("tracking") String trackingNumber);
	
	
	/**
	 * retrieve package by status
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "/status", method = RequestMethod.GET)
	List<Package> findPackageByStatus(@RequestParam("status") Package.PackageStatus status);
	
	
	/**
	 * delete package by package id
	 * @param id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	void deletePackageById(@PathVariable("id") int id);
	
	
	
	/**
	 * update package by package id
	 * @param id
	 * @param newPackage
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Package updatePackageById(@PathVariable("id") int id, @RequestBody Package newPackage);

	
}
