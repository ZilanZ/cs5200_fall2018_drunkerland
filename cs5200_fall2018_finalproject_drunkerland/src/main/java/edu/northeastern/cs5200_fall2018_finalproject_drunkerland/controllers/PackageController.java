package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api.PackageApi;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Package;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Package.PackageStatus;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.PackageRepository;


@RestController
public class PackageController implements PackageApi{
	
	@Autowired
	PackageRepository packageRepository;

	@Override
	public Package createPackage(Package pack) {
		
		return packageRepository.save(pack);
	}

	@Override
	public List<Package> findAllPackages() {
		
		return (List<Package>) packageRepository.findAll();
	}

	@Override
	public Package findPackageById(int id) {
		
		return packageRepository.findById(id).orElse(null);
	}

	@Override
	public Package findPackageByTrackingNum(String trackingNumber) {
		
		return packageRepository.findPackageByTracking(trackingNumber);
	}

	@Override
	public List<Package> findPackageByStatus(PackageStatus status) {
		
		return packageRepository.findPackagesByStatus(status);
	}

	@Override
	public void deletePackageById(int id) {
		
		packageRepository.deleteById(id);
	}

	@Override
	public Package updatePackageById(int id, Package newPackage) {
		Package pack = findPackageById(id);
		pack.set(newPackage);
		return packageRepository.save(pack);
	}

}
