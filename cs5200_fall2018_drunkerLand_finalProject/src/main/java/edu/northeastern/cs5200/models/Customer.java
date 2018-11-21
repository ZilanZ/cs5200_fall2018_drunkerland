package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer extends User{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String taste;
	@OneToMany
	private List<Order> orders;
	@OneToMany
	private Set<Follow> follows;
	public Customer(String username, String password, String lastname, String firstname, String gender, String phone,
			String email, Date dob, String taste) {
		super(username, password, lastname, firstname, gender, phone, email, dob);
		this.taste = taste;
	}

	public Customer(String username, String password, String lastname, String firstname, String taste) {
		super(username, password, lastname, firstname);
		this.taste = taste;
	}
	
	public void addFollow(Follow follow)
	{
		this.follows.add(follow);
		if(follow.getCustomer()!=this)
			follow.setCustomer(this);
	}
	
	public void removeFollow(Follow follow)
	{
		this.follows.remove(follow);
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

	public Set<Follow> getFollows() {
		return follows;
	}

	public void setFollows(Set<Follow> follows) {
		this.follows = follows;
	}
	

}