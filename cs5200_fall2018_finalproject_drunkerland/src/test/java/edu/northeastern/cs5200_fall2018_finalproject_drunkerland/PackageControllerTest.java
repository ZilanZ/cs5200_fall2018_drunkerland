package edu.northeastern.cs5200_fall2018_finalproject_drunkerland;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.ItemController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.PackageController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Package;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PackageControllerTest {

	@Autowired
	PackageController packageController;
	@Autowired
	ItemController itemController;
	
	
//	@Before
//	public void setUp()
//	{
//		Item item1 = itemController.findItemById(32);
//		Item item2 = itemController.findItemById(33);
//		Item item3 = itemController.findItemById(41);
//		
//		Package package1 = new Package("123456vjhvjjb", Package.PackageStatus.SHIPPED, item1);
//		Package package2 = new Package("1234878hhbvcb", Package.PackageStatus.DELIVERED, item2);
//		Package package3 = new Package("123nnlnlhv6jb", Package.PackageStatus.INTRANSIT, item3);
//		
//		packageController.createPackage(package1);
//		packageController.createPackage(package2);
//		packageController.createPackage(package3);
//		
//	}
	
	
	@Test
	public void testFindAllPackages()
	{
		List<Package> packages = packageController.findAllPackages();
		for(Package pa : packages)
        {
        	System.out.println(pa.getTrackingNumber());
        }
				
	}
	
	
	@Test
	public void testFindPackageById()
	{
		Package pack = packageController.findPackageById(1);
		System.out.println(pack.getTrackingNumber());
	}
	
	
	@Test
	public void testFindPackageByTrackingNum()
	{
		Package pack = packageController.findPackageByTrackingNum("1234878hhbvcb");
		System.out.println(pack.getStatus());
	}
	
	
	@Test
	public void testFindPackageByStatus()
	{
		List<Package> packages = packageController.findPackageByStatus(Package.PackageStatus.INTRANSIT);
		for(Package pa : packages)
	        {
	        	System.out.println(pa.getTrackingNumber());
	        }
	}
	
	
	
	@Test
	public void testDeletePackageById()
	{
		packageController.deletePackageById(1);
	}
	
	
	@Test
	public void testUpdatePackageById()
	{
		Package newPackage = new Package("gfgrtrry323ghg", Package.PackageStatus.SHIPPED);
		packageController.updatePackageById(3, newPackage);
	}
	
	
	
	
}
