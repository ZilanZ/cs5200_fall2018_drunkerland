package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sponser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Supplier sponsered;
	@ManyToOne
	private WineReviewerRelationship sponserRelationship;
	public Supplier getSponsered() {
		return sponsered;
	}
	public void setSponsered(Supplier sponsered) {
		this.sponsered = sponsered;
	}
	public WineReviewerRelationship getSponserRelationship() {
		return sponserRelationship;
	}
	public void setSponserRelationship(WineReviewerRelationship sponserRelationship) {
		this.sponserRelationship = sponserRelationship;
	}

	

}
