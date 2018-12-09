package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String street1;
    private String street2;
    private String zipcode;
    private String city;
    private String state;
    private String country;
    private Boolean primaryAdd;

    @ManyToOne()
    @JsonIgnore
    private User user;

    public Address() {
    }

    public Address(String street1, String zipcode, String city, String state, 
    		String country, Boolean primaryAdd) {
        this.street1 = street1;
        this.zipcode = zipcode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.primaryAdd = primaryAdd;
    }

    public Address(String street1, String street2, String zipcode,
                   String city, String state, String country,
                   Boolean primaryAdd)
    {
        this.street1 = street1;
        this.street2 = street2;
        this.zipcode = zipcode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.primaryAdd = primaryAdd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public Boolean isPrimaryAdd() {
        return primaryAdd;
    }

    public void setPrimaryAdd(Boolean primaryAdd) {
        this.primaryAdd = primaryAdd;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        if (!user.getAddresses().contains(this))
            user.getAddresses().add(this);
    }
    
    
    public void set(Address newAddress)
    {
    	this.street1 = newAddress.street1;
        this.street2 = newAddress.street2;
        this.zipcode = newAddress.zipcode;
        this.city = newAddress.city;
        this.state = newAddress.state;
        this.country = newAddress.country;
        this.primaryAdd = newAddress.primaryAdd;
    }
    
    
    
}
