package com.example.cs5200_fall2018_finalproject_drunkerland.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Costumer extends User{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String taste;

	public Costumer(String username, String password, String lastname, String firstname, String gender, String phone,
			String email, Date dob, String taste) {
		super(username, password, lastname, firstname, gender, phone, email, dob);
		this.taste = taste;
	}

	public Costumer(String username, String password, String lastname, String firstname, String taste) {
		super(username, password, lastname, firstname);
		this.taste = taste;
	}
	

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}
	

}
