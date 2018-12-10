package edu.northeastern.cs5200_fall2018_finalproject_drunkerland;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Item;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.ConsumerController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.ItemController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.OrderController;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Consumer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderControllerTest {
	
	@Autowired
    OrderController orderController;
	@Autowired
    ConsumerController consumerController;
	@Autowired
    ItemController itemController;
	
//	@Before
//	public void setup()
//	{
//		 Consumer alice = new Consumer("alice", "password", "Alice", "Wonderland");
//	     consumerController.createConsumer(alice);
//	     Consumer bob = new Consumer("bob", "password", "Bob", "Lovelace");
//	     consumerController.createConsumer(bob);
//	     
//	     Item apple = new Item(6);
//	     itemController.createItem(apple);
//	     
//	     Item orange = new Item(9);
//	     itemController.createItem(orange);
//	     
//	     List<Item> items = new ArrayList<>();
//	     items.add(apple);
//	     items.add(orange);
//	     
//	     Order order123 = new Order(Order.OrderStatus.BASKET, (float)123.5, alice, items );
//	     orderController.createOrder(order123);
//	     
//	     Order order234 = new Order(Order.OrderStatus.BASKET, (float)223.5, bob, items );
//	     orderController.createOrder(order234);
//	     
//	     Order order345 = new Order(Order.OrderStatus.PAID, "Boston", (float)323.5, new Date(0), bob, items );
//	     orderController.createOrder(order345);
//	}
	
    @Test
    public void testFindAllOrders() {
		
        List<Order> orders = orderController.findAllOrders();
        
        for(Order od : orders)
        {
        	System.out.println(od.getStatus());
        }
    }
    
    
    @Test
    public void testFindOrderById() {
		
       Order order = orderController.findOrderById(19);
       
        	System.out.println(order.getConsumer().getUsername());
        
    }
    
    
    @Test
    public void testFindOrdersForConsumer() {
		
    	Consumer bob = consumerController.findConsumerById(9);
    	
    	List<Order> orders = orderController.findOrdersForConsumer(bob);
       
       for(Order od : orders)
       {
       	System.out.println(od.getStatus());
       }
        
    }
    
      
    @Test
    public void testFindOrdersByStatus() {
    	
    	List<Order> orders = orderController.findOrdersByStatus(Order.OrderStatus.BASKET);
       
       for(Order od : orders)
       {
       	System.out.println(od.getTotalPrice());
       }
        
    }
    
    
    @Test
    public void testFindOrdersByCreated() throws ParseException {
    	
    	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date da = f.parse("1969-12-31");
    	
    	java.sql.Date created = new java.sql.Date(da.getTime());
    	
    	List<Order> orders = orderController.findOrdersByCreated(created);
       
       for(Order od : orders)
       {
       	System.out.println(od.getTotalPrice());
       }
        
    }
    
    
    @Test
    public void testDeleteOrderById() {
    	
     orderController.deleteOrderById(24);
       
    }
	
	
	@Test
    public void testUpdateOrderById() throws ParseException {
		
		Consumer bob = consumerController.findConsumerById(9);
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date da = f.parse("2018-12-21");

		 Item peach = new Item(100);
	     itemController.createItem(peach);
	     
	     List<Item> items = new ArrayList<>();
	     
	     items.add(peach);
	     // Order newOrder = new Order(Order.OrderStatus.PAID, "Boston", (float)323.5, new Date(da.getTime()), bob, items);

         //orderController.updateOrderById(22, newOrder);
  
      	//System.out.println(newOrder.getStatus());
      
  }
    
}
