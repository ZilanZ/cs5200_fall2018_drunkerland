package com.example.cs5200_fall2018_finalproject_drunkerland.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.*;

@Entity
@Table(name="ORDERS")

public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	public enum OrderStatus{
		basket,
		pending,
		paid,
		canceled,
		refunded
	}
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	private String destination;
	
	private float totalPrice;
	
	private Date created;
	
	@ManyToOne()
	private Consumer consumer;
	
	@OneToMany(mappedBy="order", fetch=FetchType.LAZY)
	private List<Item> items;
	
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

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
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

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
		if(!consumer.getOrders().contains(this))
			consumer.getOrders().add(this);
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	
	//constructor
	public Order() {
		super();
	}

	public Order(int id, OrderStatus status, String destination, float totalPrice, Date created, Consumer consumer,
			List<Item> items) {
		super();
		this.id = id;
		this.status = status;
		this.destination = destination;
		this.totalPrice = totalPrice;
		this.created = created;
		this.consumer = consumer;
		this.items = items;
	}
	
	

}
