package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ORDER")

public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String status;
	
	private String destination;
	
	private float totalPrice;
	
	private Date created;
	
	@ManyToOne()
	private Customer customer;
	
	@OneToMany(mappedBy="order", fetch=FetchType.EAGER)
	private Set<Item> items;
	
	public void addItem(Item item)
	{
		this.items.add(item);
		if(item.getOrder()!=this)
			item.setOrder(this);
	}
	
	public void removeItem(Item item)
	{
		this.items.remove(item);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
		if(!customer.getOrders().contains(this))
			customer.getOrders().add(this);
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	
	//constructor
	public Order() {
		super();
	}

	public Order(int id, String status, String destination, float totalPrice, Date created, Customer customer,
			Set<Item> items) {
		super();
		this.id = id;
		this.status = status;
		this.destination = destination;
		this.totalPrice = totalPrice;
		this.created = created;
		this.customer = customer;
		this.items = items;
	}
	
	

}
