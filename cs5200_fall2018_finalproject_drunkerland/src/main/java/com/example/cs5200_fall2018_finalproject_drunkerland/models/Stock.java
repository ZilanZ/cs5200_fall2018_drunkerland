package com.example.cs5200_fall2018_finalproject_drunkerland.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GenerationType;


@Entity
@Table(name="STOCK")
public class Stock {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int amount;
	private float purchasingPrice;
	private float sellingPrice;
	private boolean available;
	
	@ManyToOne()
	private Vendor vendor;
	
	@ManyToOne()
	private Wine wine;
	
	@OneToMany(mappedBy = "stock", fetch = FetchType.LAZY)
	private List<Item> itemsInStock;
	
	public void addItem(Item item)
	{
		this.itemsInStock.add(item);
		if(item.getStock()!=this)
			item.setStock(this);
	}
	
	
	public void removeItem(Item item)
	{
		this.itemsInStock.remove(item);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getPurchasingPrice() {
		return purchasingPrice;
	}

	public void setPurchasingPrice(float purchasingPrice) {
		this.purchasingPrice = purchasingPrice;
	}

	public float getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
		if(!vendor.getStocks().contains(this))
		{
			vendor.getStocks().add(this);
		}
	}

	public Wine getWine() {
		return wine;
	}

	public void setWine(Wine wine) {
		this.wine = wine;
		if(!wine.getStocks().contains(this))
		{
			wine.getStocks().add(this);
		}
	}

	public List<Item> getItemsInStock() {
		return itemsInStock;
	}

	public void setItemsInStock(List<Item> itemsInStock) {
		this.itemsInStock = itemsInStock;
	}


	
	//constructor
	public Stock() {
		super();
	}


	public Stock(int id, int amount, float purchasingPrice, float sellingPrice, boolean available, Vendor vendor,
			Wine wine, List<Item> itemsInStock) {
		super();
		this.id = id;
		this.amount = amount;
		this.purchasingPrice = purchasingPrice;
		this.sellingPrice = sellingPrice;
		this.available = available;
		this.vendor = vendor;
		this.wine = wine;
		this.itemsInStock = itemsInStock;
	}
	
	
	
	

}
