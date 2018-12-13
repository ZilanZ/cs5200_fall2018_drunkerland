package edu.northeastern.cs5200_fall2018_finalproject_drunkerland;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.SupplierController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.WineController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Supplier;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Wine;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.WineRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by danlinjia on 12/8/18.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class WineControllerTests {

    @Autowired
    WineController wineController;
    
    @Autowired
    SupplierController supplierController;

//    @Autowired
//    WineRepository wineRepository;

//    @Test
//    @Bean
//    public void testCreateWines() {
//        // read json and write to db
//        ObjectMapper mapper = new ObjectMapper();
//        TypeReference<List<Wine>> typeReference = new TypeReference<List<Wine>>() {
//        };
//        InputStream inputStream = TypeReference.class.getResourceAsStream("/wines.json");
//        try {
//            List<Wine> wines = mapper.readValue(inputStream, typeReference);
//            for (Wine wine:wines) {
//                wineController.createWine(wine);
//            }
//            System.out.println("Users Saved!");
//        } catch (IOException e) {
//            System.out.println("Unable to save users: " + e.getMessage());
//        }
//        }
//
//    @Test
//    public void testFindWineBetweenScore() {
//        wineController.findWineBetweenScore("90.0 95.0");
//    }
    
    @Test
    public void testFindWineBySupplier()
    {
    	Supplier supplier = supplierController.findSupplierById(25);
    	List<Wine> wines = wineController.findWinesBySupplier(supplier);
    	for(Wine wi : wines)
    	{
    		System.out.println(wi.getColor());
    	}
    }

}
