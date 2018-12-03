package edu.northeastern.cs5200_fall2018_finalproject_drunkerland;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.VendorController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Vendor;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by danlinjia on 12/2/18.
 */
public class VendorControllerTests extends DemoApplicationTests {
    @Autowired
    VendorController vendorController;

//    @Test
//    public void createVendorTest(){
//        Vendor vendor = new Vendor("vendor","vendor","danlin","jia",true);
//        vendorController.createVendor(vendor);
//    }
//
//    @Test
//    public void findVendorById(){
//        int id = 68;
//        vendorController.findVendorById(id);
//    }
//
//    @Test
//    public void findVendorByName() {
//        vendorController.findVendorByName("danlin jia");
//    }
//
//    @Test
//    public void findAllVendor() {
//        vendorController.findAllVendors();
//    }
//
//    @Test
//    public void findVendorByCredential() {
//        Vendor newVendor = new Vendor("vendor","vendor","danlin","jia",true);
//        vendorController.findVendorByCredential(newVendor);
//    }
//
//    @Test
//    public void updateVendorById() {
//        int id = 68;
//        Vendor newVendor = new Vendor("vendor","vendor","danlin","jia",false);
//        vendorController.updateVendorById(id, newVendor);
//    }

    @Test
    public void deleteVendorById() {
        int id = 68;
        vendorController.deleteVendorById(id);
    }
}
