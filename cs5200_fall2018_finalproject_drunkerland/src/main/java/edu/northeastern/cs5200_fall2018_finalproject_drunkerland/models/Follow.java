package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	private Consumer consumer;
	
	@ManyToOne()
	@JsonIgnore
	private Reviewer reviewer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
		if(!consumer.getFollows().contains(this))
			consumer.getFollows().add(this);
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

	}

	public Follow(int id, Consumer consumer, Reviewer reviewer) {
		
		this.id = id;
		this.consumer = consumer;
		this.reviewer = reviewer;
	}
	
	
	public void set(Follow newFollow)
	{
		this.consumer = newFollow.consumer;
		this.reviewer = newFollow.reviewer;
	}

}
