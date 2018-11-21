package edu.northeastern.cs5200.models;

import java.util.Set;

import javax.persistence.Column;
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
	
	@Column(name="QTY")
	private int quantity;
	
	@ManyToOne()
	private Stock stock;
	
	@ManyToOne()
	private Order order;
	
	@OneToMany(mappedBy="item", fetch=FetchType.EAGER)
	private Set<Package> itemsInPackage;
	
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

	public Set<Package> getItemsInPackage() {
		return itemsInPackage;
	}

	public void setItemsInPackage(Set<Package> itemsInPackage) {
		this.itemsInPackage = itemsInPackage;
	}

	
	
	//constructor
	public Item() {
		super();
	}

	public Item(int id, int quantity, Stock stock, Order order, Set<Package> itemsInPackage) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.stock = stock;
		this.order = order;
		this.itemsInPackage = itemsInPackage;
	}
	
	
	

}
