package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api.ItemApi;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Item;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Order;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Stock;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.ItemRepository;


@RestController
public class ItemController implements ItemApi{
	
	@Autowired
	ItemRepository itemRepository;
	
	@Override
	public Item createItem(Item item) {
	
		return itemRepository.save(item);
	}

	@Override
	public List<Item> findAllItems() {
		
		return (List<Item>) itemRepository.findAll();
	}

	@Override
	public Item findItemById(int id) {
	
		return itemRepository.findById(id).orElse(null);
	}

	@Override
	public List<Item> findItemsByOrder(Order order) {

		return itemRepository.findItemByOrder(order);
	}

	@Override
	public List<Item> findItemsByStock(Stock stock) {

		return itemRepository.findItemByStock(stock);
	}

	@Override
	public void deleteItemById(int id) {
		
		itemRepository.deleteById(id);
	}

	@Override
	public Item updateItemById(int id, Item newItem) {
		Item item = findItemById(id);
		item.set(newItem);
		return itemRepository.save(item);
	}
	
	

}
