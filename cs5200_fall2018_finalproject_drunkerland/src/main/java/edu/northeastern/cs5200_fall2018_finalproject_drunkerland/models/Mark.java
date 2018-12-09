package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	private Reviewer reviewer;
	
	@ManyToOne()
	@JsonIgnore
	private Wine wine;

	

	//
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Reviewer getReviewer() {
		return reviewer;
	}

	public void setReviewer(Reviewer reviewer) {
		this.reviewer = reviewer;
		if(!reviewer.getMarks().contains(this))
			reviewer.getMarks().add(this);
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

	}

	public Mark(int id, int points, Reviewer reviewer, Wine wine) {
		
		this.id = id;
		this.points = points;
		this.reviewer = reviewer;
		this.wine = wine;
	}
	
	
	public void set(Mark newMark)
	{
		this.points = newMark.points;
		this.reviewer = newMark.reviewer;
		this.wine = newMark.wine;
	}
	

}
