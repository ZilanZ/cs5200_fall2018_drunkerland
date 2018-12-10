package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Package;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ITEM")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	

	private int quantity;
	
	@ManyToOne()
	@JsonIgnore
	private Stock stock;
	
	@ManyToOne()
	@JsonIgnore
	private Order order;
	
	@OneToMany(mappedBy="item", fetch=FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<Package> itemsInPackage;
	
	public void addPackage(Package pack)
	{
		this.itemsInPackage.add(pack);
		if(pack.getItem()!=this)
			pack.setItem(this);
	}
	
	public void removePackage(Package pack)
	{
		this.itemsInPackage.remove(pack);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
		if(!stock.getItemsInStock().contains(this))
		{
			stock.getItemsInStock().add(this);
		}
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
		if(!order.getItems().contains(this))
			order.getItems().add(this);
	}

	public List<Package> getItemsInPackage() {
		return itemsInPackage;
	}

	public void setItemsInPackage(List<Package> itemsInPackage) {
		this.itemsInPackage = itemsInPackage;
	}

	
	
	//constructor
	public Item() {

	}

	public Item(int id, int quantity, Stock stock, Order order, List<Package> itemsInPackage) {
		
		this.id = id;
		this.quantity = quantity;
		this.stock = stock;
		this.order = order;
		this.itemsInPackage = itemsInPackage;
		itemsInPackage =new ArrayList<>();
	}
	
    public Item(int quantity) {
		
		this.quantity = quantity;

	}
    

	public Item(int quantity, Stock stock, Order order) {
		this.quantity = quantity;
		this.stock = stock;
		this.order = order;
	}

	public void set(Item newItem) {
		
		this.quantity = newItem.quantity;
		this.stock = newItem.stock;
	}
    
    
    
	

}
