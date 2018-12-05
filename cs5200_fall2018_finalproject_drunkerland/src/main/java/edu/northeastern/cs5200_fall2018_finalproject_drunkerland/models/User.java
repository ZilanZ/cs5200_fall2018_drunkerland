package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String gender;
	private String phone;
	private String email;
	private Date dob;

	@OneToMany(mappedBy = "user")
	private List<Address> addresses = new ArrayList<>();

	public User() {
	}

	public User(String username, String password, String firstName, String lastName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(String username, String password, String firstName, String lastName, String gender, String phone, String email, Date dob) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.dob = dob;
	}

	public int getId() {
		return id;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

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

	public void set (User newUser){
		this.username = newUser.username;
		this.password = newUser.password;
		this.firstName = newUser.firstName;
		this.lastName = newUser.lastName;
		this.gender = newUser.gender;
		this.phone = newUser.phone;
		this.email = newUser.email;
		this.dob = newUser.dob;
	}

}
