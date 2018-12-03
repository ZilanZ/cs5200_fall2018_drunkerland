package edu.northeastern.cs5200_fall2018_finalproject_drunkerland;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.SupplierController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Supplier;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by danlinjia on 12/2/18.
 */
public class SupplierControllerTests extends DemoApplicationTests {
    @Autowired
     SupplierController supplierController;

//    @Test
//    public  void createSupplierTest(){
//        Supplier supplier = new Supplier("supplier","supplier","danlin","jia","china","red","nohistory",true);
//        supplierController.createSupplier(supplier);
//    }

    @Test
    public void findSupplierByName() {
        supplierController.findSupplierByName("danlin jia");
    }

    @Test
    public void findSupplierById(){
        int id = 67;
        supplierController.findSupplierById(id);
    }


    @Test
    public void findAllSupplier() {
        supplierController.findAllSuppliers();
    }

    @Test
    public void findSupplierByCredential() {
        Supplier newSupplier = new Supplier("supplier","supplier","danlin","jia","china","red","nohistory",true);
        supplierController.findSupplierByCredential(newSupplier);
    }

    @Test
    public void updateSupplierById() {
        int id = 67;
        Supplier newSupplier = new Supplier("supplier","supplier","danlin","jia","china","red","nohistory",false);
        supplierController.updateSupplierById(id, newSupplier);
    }

//    @Test
//    public void deleteConsumerById() {
//        int id = 67;
//        supplierController.deleteSupplierById(id);
//    }
}
