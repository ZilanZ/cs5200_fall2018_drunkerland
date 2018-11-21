package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PACKAGE")
public class Package {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String trackingNumber;
	
	private String status;
	
	@ManyToOne()
	private Item item;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
		if(!item.getItemsInPackage().contains(this))
			item.getItemsInPackage().add(this);
			
	}

	
	
	//constructor
	public Package() {
		super();
	}

	public Package(int id, String trackingNumber, String status, Item item) {
		super();
		this.id = id;
		this.trackingNumber = trackingNumber;
		this.status = status;
		this.item = item;
	}
	
	
	
	

}
