package com.example.cs5200_fall2018_finalproject_drunkerland.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	public User(String username, String password, String lastname, String firstname) {
		super();
		this.username = username;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
	}
	public User(String username, String password, String lastname, String firstname, String gender, String phone,
			String email, Date dob) {
		super();
		this.username = username;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.dob = dob;
	}
	private String username;
	private String password;
	private String lastname;
	private String firstname;
	private String gender;
	private String phone;
	private String email;
	private Date dob;

	@OneToMany(mappedBy = "user")
	private List<Address> addresses;

	public void addAddress(Address address)
	{
		this.addresses.add(address);
		if(address.getUser()!=this)
			address.setUser(this);
	}

	public void removeAddress(Address address)
	{
		this.addresses.remove(address);
	}

	public int getId() {
		return id;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
}
