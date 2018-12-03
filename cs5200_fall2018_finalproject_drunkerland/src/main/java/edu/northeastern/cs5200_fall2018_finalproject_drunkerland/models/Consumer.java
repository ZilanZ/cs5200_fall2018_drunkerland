package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Consumer extends User{
	private String taste;
	@OneToMany(mappedBy="consumer", cascade = CascadeType.MERGE)
	private List<Order> orders;
	@OneToMany(mappedBy="consumer", cascade = CascadeType.MERGE)
	private List<Follow> follows;

	public Consumer() {
	}

	public Consumer(String username, String password, String lastname, String firstname, String gender, String phone,
					String email, Date dob, String taste) {
		super(username, password, lastname, firstname, gender, phone, email, dob);
		this.taste = taste;
	}

	public Consumer(String username, String password, String lastname, String firstname, String taste) {
		super(username, password, lastname, firstname);
		this.taste = taste;
	}
	
	public Consumer(String username, String password, String lastname, String firstname) {
		super(username, password, lastname, firstname);
		
	}


	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Follow> getFollows() {
		return follows;
	}

	public void setFollows(List<Follow> follows) {
		this.follows = follows;
	}
	
	public void addOrder(Order order) {
		orders.add(order);
		if (order.getConsumer()!=this){
			order.setConsumer(this);
		}
	}

	public void addFollow(Follow follow) {
		follows.add(follow);
		if (follow.getConsumer()!=this){
			follow.setConsumer(this);
		}
	}

	public  void removeOrder(Order order) {
		this.orders.remove(order);
	}

	public void removeFollow(Follow follow) {
		this.follows.remove(follow);
	}

	public void setConsumer(Consumer newConsumer) {
		 set(newConsumer);
		 this.taste = newConsumer.taste;
	}
}
