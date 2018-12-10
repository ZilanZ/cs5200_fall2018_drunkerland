package edu.northeastern.cs5200_fall2018_finalproject_drunkerland;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.ConsumerController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.ItemController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.OrderController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.StockController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.VendorController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.WineController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Consumer;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Item;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Order;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Stock;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Vendor;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Wine;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemControllerTest {
	
	@Autowired
	ItemController itemController;
	@Autowired
    OrderController orderController;
	@Autowired
    ConsumerController consumerController;
	@Autowired
    WineController wineController;
	@Autowired
    VendorController vendorController;
	@Autowired
    StockController stockController;

	
//	@Before
//	public void setUp()
//	{
//		Vendor vendor1 = new Vendor("adam", "password", "Adam", "Stone", true);
//		vendorController.createVendor(vendor1);
//		
//		Wine Tos = wineController.findWineById(23246);
//		Stock stock1 = new Stock(300, 350, 750, true, vendor1, Tos);
//		stockController.createStock(stock1);
//		
//		 Order order = orderController.findOrderById(22);
//		 Item pear = new Item(22, stock1, order);
//		 itemController.createItem(pear);
//	}
	
	
	@Test
	public void testFindAllItems()
	{
		 List<Item> items = itemController.findAllItems();
	        
	        for(Item it : items)
	        {
	        	System.out.println(it.getQuantity());
	        }
	}
	
	
	@Test
	public void testFindItemById()
	{
		 Item item = itemController.findItemById(32);
	        
	       System.out.println(item.getQuantity());
	       
	}
	
	
	@Test
	public void testFindItemsByOrder() throws ParseException
	{
	
	
//        Consumer bob = consumerController.findConsumerById(11);
//		
//		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//        java.util.Date da = f.parse("2018-12-21");
//
//        Item pear = new Item(19);
//	    itemController.createItem(pear);
//	    List<Item> items = new ArrayList<>();
//	    items.add(pear);
//	    
//		Order order = new Order(Order.OrderStatus.PAID, "Boston", (float)323.5,
//				new Date(da.getTime()), bob, items);
//		orderController.createOrder(order);
		
		
		 Order order = orderController.findOrderById(22);
		List<Item> itemss = itemController.findItemsByOrder(order);
	        
	        for(Item it : itemss)
	        {
	        	System.out.println(it.getQuantity());
	        }
	}
	
	
	@Test
	public void testFindItemsByStock()
	{
		Stock stock = stockController.findStockById(2);
		List<Item> items = itemController.findItemsByStock(stock);
		for(Item it : items)
        {
        	System.out.println(it.getQuantity());
        }
		
	}
	
	
	@Test
	public void testDeleteItemById()
	{
		itemController.deleteItemById(31);
	}
	
	
	@Test
	public void testUpdateItemById()
	{
		Item newItem = new Item(8);
		itemController.updateItemById(32, newItem);
	}
	
}
