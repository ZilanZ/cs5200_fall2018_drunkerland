package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
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
	private Boolean available;
	
	@ManyToOne()
	@JsonIgnore
	private Vendor vendor;
	
	@ManyToOne()
	@JsonIgnore
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

	public Boolean isAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
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

	}


	public Stock(int id, int amount, float purchasingPrice, float sellingPrice, Boolean available, Vendor vendor,
			Wine wine, List<Item> itemsInStock) {
		
		this.id = id;
		this.amount = amount;
		this.purchasingPrice = purchasingPrice;
		this.sellingPrice = sellingPrice;
		this.available = available;
		this.vendor = vendor;
		this.wine = wine;
		this.itemsInStock = itemsInStock;
		itemsInStock = new ArrayList<>();
	}
	
	
	public void set(Stock newStock)
	{
		this.amount = newStock.amount;
		this.purchasingPrice = newStock.purchasingPrice;
		this.sellingPrice = newStock.sellingPrice;
		this.available = newStock.available;
		this.vendor = newStock.vendor;
		this.wine = newStock.wine;
		this.itemsInStock = newStock.itemsInStock;
	}
	

}
