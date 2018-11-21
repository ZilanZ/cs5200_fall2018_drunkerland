package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="FOLLOW")
public class Follow {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	private Customer customer;
	
	@ManyToOne()
	private Reviewer reviewer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
		if(!customer.getFollows().contains(this))
			customer.getFollows().add(this);
	}

	public Reviewer getReviewer() {
		return reviewer;
	}

	public void setReviewer(Reviewer reviewer) {
		this.reviewer = reviewer;
		if(!reviewer.getFollows().contains(this))
			reviewer.getFollows().add(this);
	}

	
	
	//constructor
	public Follow() {
		super();
	}

	public Follow(int id, Customer customer, Reviewer reviewer) {
		super();
		this.id = id;
		this.customer = customer;
		this.reviewer = reviewer;
	}
	
	

}
