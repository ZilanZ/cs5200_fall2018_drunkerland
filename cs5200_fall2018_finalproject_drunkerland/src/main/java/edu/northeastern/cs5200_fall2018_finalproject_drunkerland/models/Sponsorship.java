package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sponsorship {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JsonIgnore
	private Supplier supplier;
	@ManyToOne
	@JsonIgnore
	private WineReviewerRelationship sponsorRelationship;

	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
		if (!supplier.getSponsorships().contains(this)) {
		    supplier.getSponsorships().add(this);
        }
	}
	public WineReviewerRelationship getSponsorRelationship() {
		return sponsorRelationship;
	}
	public void setSponsorRelationship(WineReviewerRelationship sponsorRelationship) {
		this.sponsorRelationship = sponsorRelationship;
		if (!sponsorRelationship.getSponsorships().contains(this)){
            sponsorRelationship.getSponsorships().add(this);
        }
	}



}
