package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


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
	@OneToMany(mappedBy="supplied")
	private List<Wine> wines;
	@OneToMany(mappedBy="sponsered")
	private List<Sponser> sponsers;
	
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
	public List<Sponser> getSponsers() {
		return sponsers;
	}
	public void setSponsers(List<Sponser> sponsers) {
		this.sponsers = sponsers;
	}
	public void addWine(Wine wine) {
		this.wines.add(wine);
		if (wine.getSupplier()!=this) {
			wine.setSupplier(this);;
		}
	}
	public void addSponser(Sponser sponser) {
		this.sponsers.add(sponser);
		if (sponser.getSponsered()!=this) {
			sponser.setSponsered(this);
		}
	}
	
}
