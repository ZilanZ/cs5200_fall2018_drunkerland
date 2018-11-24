package com.example.cs5200_fall2018_finalproject_drunkerland.models;

import org.aspectj.weaver.ast.Or;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Consumer extends User{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String taste;
	@OneToMany(mappedBy="consumer")
	private List<Order> orders;
	@OneToMany(mappedBy="consumer")
	private List<Follow> follows;


	public Consumer(String username, String password, String lastname, String firstname, String gender, String phone,
                    String email, Date dob, String taste) {
		super(username, password, lastname, firstname, gender, phone, email, dob);
		this.taste = taste;
	}

	public Consumer(String username, String password, String lastname, String firstname, String taste) {
		super(username, password, lastname, firstname);
		this.taste = taste;
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
}
