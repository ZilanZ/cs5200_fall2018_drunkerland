package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Item;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Order;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Stock;


@RequestMapping("rest/api/items")
public interface ItemApi {
	
	/**
	 * create item
	 * @param item
	 * @return
	 */
	
	@RequestMapping(method = RequestMethod.POST)
    Item createItem(@RequestBody Item item);
	
	
	/**
	 * retrieve all items
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
    List<Item> findAllItems();
	
	
	/**
	 * retrieve item by item id
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Item findItemById(@PathVariable("id") int id);
	
	
	/**
	 * retrieve items by order id
	 * @param oId
	 * @return
	 */
	@RequestMapping(value = "/order", method = RequestMethod.POST)
    List<Item> findItemsByOrder(@RequestBody Order order);
	
	
	
	/**
	 * retrieve items by stock id
	 * @param sId
	 * @return
	 */
	@RequestMapping(value = "/stock", method = RequestMethod.POST)
    List<Item> findItemsByStock(@RequestBody Stock stock);
	
	
	/**
	 * delete item by item id
	 * @param id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	void deleteItemById(@PathVariable("id") int id);
	
	
	/**
	 * update item by id
	 * @param id
	 * @param newItem
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Item updateItemById(@PathVariable("id") int id, @RequestBody Item newItem);

	 
	 

}
