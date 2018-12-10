package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="ORDERS")

public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	public enum OrderStatus{
		BASKET,
		PENDING,
		PAID,
		CANCELED,
		REFUNDED
	}
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	private String destination;
	
	private float totalPrice;
	
	private Date created;
	
	@ManyToOne()
	@JsonIgnore
	private Consumer consumer;
	
	@OneToMany(mappedBy="order", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
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

	}

	public Order(int id, OrderStatus status, String destination, float totalPrice, Date created) {

		this.id = id;
		this.status = status;
		this.destination = destination;
		this.totalPrice = totalPrice;
		this.created = created;
	}
	
	public Order(OrderStatus status, String destination, float totalPrice, Date created)
	{
		this.status = status;
		this.destination = destination;
		this.totalPrice = totalPrice;
		this.created = created;
		items = new ArrayList<>();
	}
	
	
	//constructor for shopping cart
	public Order(OrderStatus status, float totalPrice, Consumer consumer, List<Item> items) 
	{
		this.status = status;
		this.totalPrice = totalPrice;
		this.consumer = consumer;
		this.items = items;
	}
	
	public void set(Order newOrder)
	{
		this.destination = newOrder.destination;
		this.status = newOrder.status;
		this.items = newOrder.items;
		this.totalPrice = newOrder.totalPrice;

	}

}
