package com.example.cs5200_fall2018_finalproject_drunkerland;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.cs5200_fall2018_finalproject_drunkerland.controllers.OrderController;
import com.example.cs5200_fall2018_finalproject_drunkerland.controllers.UserController;
import com.example.cs5200_fall2018_finalproject_drunkerland.models.Item;
import com.example.cs5200_fall2018_finalproject_drunkerland.models.Order;
import com.example.cs5200_fall2018_finalproject_drunkerland.models.Order.OrderStatus;
import com.example.cs5200_fall2018_finalproject_drunkerland.models.User;
import com.example.cs5200_fall2018_finalproject_drunkerland.models.Consumer;

public class OrderControllerTest extends DemoApplicationTests{
	
	@Autowired
    OrderController orderController;
	@Autowired
    UserController userController;
	
	@Before
	public void setup()
	{
		 Consumer alice = new Consumer("alice", "password", "Alice", "Wonderland");
	     userController.createUser(alice);
	    
	     
	     Item apple = new Item(6);
	     List<Item> items = new ArrayList<>();
	     items.add(apple);
	     
	     Order order123 = new Order(OrderStatus.BASKET, (float)123.5, (Consumer)alice, items );
	     orderController.createOrder(order123);
	}
	@Test
    public void testCreateOrder() {
		
        
    }
}
