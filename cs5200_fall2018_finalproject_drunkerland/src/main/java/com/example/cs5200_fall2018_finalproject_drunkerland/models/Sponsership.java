package com.example.cs5200_fall2018_finalproject_drunkerland.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sponsership {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Supplier supplier;
	@ManyToOne
	private WineReviewerRelationship sponserRelationship;


	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public WineReviewerRelationship getSponserRelationship() {
		return sponserRelationship;
	}
	public void setSponserRelationship(WineReviewerRelationship sponserRelationship) {
		this.sponserRelationship = sponserRelationship;
	}

	

}
