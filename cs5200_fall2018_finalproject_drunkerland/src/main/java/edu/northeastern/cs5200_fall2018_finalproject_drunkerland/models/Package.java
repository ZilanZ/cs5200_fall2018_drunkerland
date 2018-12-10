package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.*;

@Entity
@Table(name="PACKAGE")
public class Package {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	public enum PackageStatus{
		SHIPPED,
		INTRANSIT,
		DELIVERED,
		RETURNED
	}
	private String trackingNumber;

	@Enumerated(EnumType.STRING)
	private PackageStatus status;
	
	@ManyToOne()
	@JsonIgnore
	private Item item;

	
	
	
	//
	
	public Package(int id, String trackingNumber, PackageStatus status, Item item) {
		
		this.id = id;
		this.trackingNumber = trackingNumber;
		this.status = status;
		this.item = item;
	}

	public Package(String trackingNumber, PackageStatus status) {
		this.trackingNumber = trackingNumber;
		this.status = status;
	}
	
	
	public Package(String trackingNumber, PackageStatus status, Item item) {
		this.trackingNumber = trackingNumber;
		this.status = status;
		this.item = item;
	}

	public Package() {

	}


	//

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

	public PackageStatus getStatus() {
		return status;
	}

	public void setStatus(PackageStatus status) {
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
	
	public void set(Package newPackage)
	{
		this.status = newPackage.status;
		//this.trackingNumber = newPackage.trackingNumber;
	}


}
