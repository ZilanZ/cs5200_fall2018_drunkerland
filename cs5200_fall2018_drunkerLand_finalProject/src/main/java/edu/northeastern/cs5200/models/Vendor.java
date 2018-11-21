package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vendor extends User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy = "vendor", fetch = FetchType.EAGER)
	private Set<Stock> stocks;
	
	public void addStock(Stock stock)
	{
		this.stocks.add(stock);
		if(stock.getVendor()!=this)
			stock.setVendor(this);
	}
	
	
	public void removeStock(Stock stock)
	{
		this.stocks.remove(stock);
	}
	
	private Boolean qualified;
	
	public Boolean getQualified() {
		return qualified;
	}
	public void setQualified(Boolean qualified) {
		this.qualified = qualified;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public Set<Stock> getStocks() {
		return stocks;
	}



	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}



	//constructor
	public Vendor(String username, String password, String lastname, String firstname, Boolean qualified) {
		super(username, password, lastname, firstname);
		this.qualified = qualified;
	}
	public Vendor(String username, String password, String lastname, String firstname, String gender, String phone,
			String email, Date dob, Boolean qualified) {
		super(username, password, lastname, firstname, gender, phone, email, dob);
		this.qualified = qualified;
	}
	
}
