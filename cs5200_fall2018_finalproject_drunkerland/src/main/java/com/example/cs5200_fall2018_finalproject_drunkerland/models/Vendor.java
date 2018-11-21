package com.example.cs5200_fall2018_finalproject_drunkerland.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vendor extends User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	public Vendor(String username, String password, String lastname, String firstname, Boolean qualified) {
		super(username, password, lastname, firstname);
		this.qualified = qualified;
	}
	public Vendor(String username, String password, String lastname, String firstname, String gender, String phone,
			String email, Date dob, Boolean qualified) {
		super(username, password, lastname, firstname, gender, phone, email, dob);
		this.qualified = qualified;
	}
	private Boolean qualified;
//	@OneToMany
//	private List<Stock> stocks;
	public Boolean getQualified() {
		return qualified;
	}
	public void setQualified(Boolean qualified) {
		this.qualified = qualified;
	}
//	public List<Stock> getStocks() {
//		return stocks;
//	}
//	public void setStocks(List<Stock> stocks) {
//		this.stocks = stocks;
//	}
	
}
