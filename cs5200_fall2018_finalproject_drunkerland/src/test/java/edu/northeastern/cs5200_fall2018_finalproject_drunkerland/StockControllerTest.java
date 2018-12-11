package edu.northeastern.cs5200_fall2018_finalproject_drunkerland;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.StockController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.VendorController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.WineController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Stock;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Vendor;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Wine;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockControllerTest {
	
	@Autowired
    StockController stockController;
	@Autowired
    WineController wineController;
	@Autowired
    VendorController vendorController;
	
//	@Before
//	public void setUp()
//	{
//		
//		Vendor vendor1 = vendorController.findVendorById(18);
//		Vendor vendor2 = vendorController.findVendorById(19);
//		
//		Wine Tos = wineController.findWineById(23246);
//		Wine Men = wineController.findWineById(28733);
//		
//		Stock stock1 = new Stock(300, 350, 750, true, vendor1, Tos);
//		Stock stock2 = new Stock(200, 450, 850, true, vendor2, Men);
//		
//		stockController.createStock(stock1);
//		stockController.createStock(stock2);
//
//		
//	}
	
	
	@Test
	public void testFindAllStocks()
	{
		List<Stock> stocks = stockController.findAllStocks();
		for(Stock st : stocks)
        {
        	System.out.println(st.getWine().getCountry());
        }
	}

	

	@Test
	public void testFindStockById()
	{
		Stock stock = stockController.findStockById(3);
		 System.out.println(stock.getAmount());
	}
	
	
	
	@Test
	public void testFindStocksByAvailable()
	{
		List<Stock> stocks = stockController.findStocksByAvailable(true);
		for(Stock st : stocks)
	        {
	        	System.out.println(st.getWine().getCountry());
	        }
	}
	
	
	@Test
	public void testFindStocksByVendor()
	{
		Vendor vendor = vendorController.findVendorById(18);
		List<Stock> stocks = stockController.findStocksByVendor(vendor);
		for(Stock st : stocks)
        {
        	System.out.println(st.getWine().getCountry());
        }
		
	}
	
	
	@Test
	public void testFindStocksByWine()
	{
		Wine Tos = wineController.findWineById(23246);
		List<Stock> stocks = stockController.findStocksByWine(Tos);
		for(Stock st : stocks)
        {
        	System.out.println(st.getPurchasingPrice());
        }
		
	}
	
	@Test
	public void testDeleteStockById()
	{
		stockController.deleteStockById(3);
	}
	
	
	@Test
	public void testUpdateStockById()
	{
		Vendor vendor = vendorController.findVendorById(20);
		Wine Men = wineController.findWineById(28733);
		Stock newStock = new Stock(233, 333, 666, true, vendor, Men);
		
		stockController.updateStockById(4, newStock);
	}
	
}
