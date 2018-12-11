package edu.northeastern.cs5200_fall2018_finalproject_drunkerland;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.AddressController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Address;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by danlinjia on 12/2/18.
 */
public class AddressControllerTests extends DemoApplicationTests {
    @Autowired
     AddressController addressController;

    @Test
    public  void createAddressTest(){
        Address address = new Address("street1", "street2", "0123", "Boston", "MA", "USA",true);
        addressController.createAddress(address);
    }

    @Test
    public void findAddressById(){
        int id = 67;
        addressController.findAddressById(id);
    }


    @Test
    public void findAllAddress() {
        addressController.findAllAddresses();
    }



//    @Test
//    public void deleteAddressById() {
//        int id = 67;
//        addressController.deleteAddressById(id);
//    }



}
