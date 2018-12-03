package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Vendor extends User {
	@Column(name = "vendor_qualified")
	private Boolean qualified;
	@OneToMany(mappedBy = "vendor")
	private List<Stock> stocks;
	public Vendor(String username, String password, String lastname, String firstname, Boolean qualified) {
		super(username, password, lastname, firstname);
		this.qualified = qualified;
	}
	public Vendor(String username, String password, String lastname, String firstname, String gender, String phone,
				  String email, Date dob, Boolean qualified) {
		super(username, password, lastname, firstname, gender, phone, email, dob);
		this.qualified = qualified;
	}
	public Boolean getQualified() {
		return qualified;
	}
	public void setQualified(Boolean qualified) {
		this.qualified = qualified;
	}
	public List<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public void addStock(Stock stock){
		this.stocks.add(stock);
		if (stock.getVendor()!=this){
			stock.setVendor(this);
		}
	}
	public void removeStock(Stock stock){
		this.stocks.remove(stock);
	}
}
