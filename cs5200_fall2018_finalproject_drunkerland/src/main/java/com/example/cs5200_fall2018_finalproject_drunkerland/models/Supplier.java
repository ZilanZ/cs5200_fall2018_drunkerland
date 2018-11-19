package com.example.cs5200_fall2018_finalproject_drunkerland.models;

import java.sql.Date;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Supplier extends User{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	public Supplier(String username, String password, String lastname, String firstname, String location,
			String graspType, String history, Boolean qualified) {
		super(username, password, lastname, firstname);
		this.location = location;
		this.graspType = graspType;
		this.history = history;
		this.qualified = qualified;
	}
	public Supplier(String username, String password, String lastname, String firstname, String gender, String phone,
			String email, Date dob, String location, String graspType, String history, Boolean qualified) {
		super(username, password, lastname, firstname, gender, phone, email, dob);
		this.location = location;
		this.graspType = graspType;
		this.history = history;
		this.qualified = qualified;
	}
	private String location;
	private String graspType;
	private String history;
	private Boolean qualified;
	@OneToMany(mappedBy="supplier")
	private List<Wine> wines;
	@OneToMany(mappedBy="supplier")
	private List<Sponsership> sponsers;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getGraspType() {
		return graspType;
	}
	public void setGraspType(String graspType) {
		this.graspType = graspType;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public Boolean getQualified() {
		return qualified;
	}
	public void setQualified(Boolean qualified) {
		this.qualified = qualified;
	}

	public List<Wine> getWines() {
		return wines;
	}
	public void setWines(List<Wine> wines) {
		this.wines = wines;
	}
	public List<Sponsership> getSponsers() {
		return sponsers;
	}
	public void setSponsers(List<Sponsership> sponsers) {
		this.sponsers = sponsers;
	}
	public void addWine(Wine wine) {
		this.wines.add(wine);
		if (wine.getSupplier()!=this) {
			wine.setSupplier(this);;
		}
	}
	public void addSponser(Sponsership sponser) {
		this.sponsers.add(sponser);
		if (sponser.getSupplier()!=this) {
			sponser.setSupplier(this);
		}
	}
	
}
