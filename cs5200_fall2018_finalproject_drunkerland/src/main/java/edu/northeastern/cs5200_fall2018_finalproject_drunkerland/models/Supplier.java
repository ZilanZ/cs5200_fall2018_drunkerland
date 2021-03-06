package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models;

import java.sql.Date;
import java.util.*;

import javax.persistence.*;

@Entity
public class Supplier extends User{
	private String location;
	private String grapeType;
	private String history;
	@Column(name = "supplier_qualified")
	private Boolean qualified;
	@OneToMany(mappedBy="supplier")
	private List<Wine> wines;
	@OneToMany(mappedBy="supplier")
	private List<Sponsorship> sponsorships;
	public Supplier(){}
	public Supplier(String username, String password, String lastName, String firstName, String location,
					String grapeType, String history, Boolean qualified) {
		super(username, password, lastName, firstName);
		this.location = location;
		this.grapeType = grapeType;
		this.history = history;
		this.qualified = qualified;
	}
	public Supplier(String username, String password, String lastname, String firstname, String gender, String phone,
					String email, Date dob, String location, String grapeType, String history, Boolean qualified) {
		super(username, password, lastname, firstname, gender, phone, email, dob);
		this.location = location;
		this.grapeType = grapeType;
		this.history = history;
		this.qualified = qualified;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getGraspType() {
		return grapeType;
	}
	public void setGraspType(String graspType) {
		this.grapeType = graspType;
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
	public List<Sponsorship> getSponsorships() {
		return sponsorships;
	}
	public void setSponsorships(List<Sponsorship> sponsorships) {
		this.sponsorships = sponsorships;
	}
	public void addWine(Wine wine) {
		this.wines.add(wine);
		if (wine.getSupplier()!=this) {
			wine.setSupplier(this);;
		}
	}
	public void addSponser(Sponsorship sponser) {
		this.sponsorships.add(sponser);
		if (sponser.getSupplier()!=this) {
			sponser.setSupplier(this);
		}
	}
	public void setSupplier(Supplier newSupplier) {
		this.set(newSupplier);
		this.location = newSupplier.location;
		this.history = newSupplier.history;
		this.grapeType = newSupplier.grapeType;
	}
}
