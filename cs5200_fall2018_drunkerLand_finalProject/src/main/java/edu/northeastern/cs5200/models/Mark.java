package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MARK")
public class Mark {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int points;
	
	@ManyToOne()
	private Reviewer reviewed;
	
	@ManyToOne()
	private Wine wine;

	

	//
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Reviewer getReviewed() {
		return reviewed;
	}

	public void setReviewed(Reviewer reviewed) {
		this.reviewed = reviewed;
		if(!reviewed.getMarks().contains(this))
			reviewed.getMarks().add(this);
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	public Wine getWine() {
		return wine;
	}

	public void setWine(Wine wine) {
		this.wine = wine;
		if(!wine.getMarks().contains(this))
			wine.getMarks().add(this);
	}

	
	
	//constructor
	public Mark() {
		super();
	}

	public Mark(int id, int points, Reviewer reviewed, Wine wine) {
		super();
		this.id = id;
		this.points = points;
		this.reviewed = reviewed;
		this.wine = wine;
	}
	
	
	
	

}
