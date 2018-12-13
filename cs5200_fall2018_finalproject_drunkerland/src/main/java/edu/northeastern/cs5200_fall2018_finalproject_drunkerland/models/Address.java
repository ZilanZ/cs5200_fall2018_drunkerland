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
    private String zipCode;
    private String city;
    private String state;
    private String country;
    private Boolean isPrimary;

    @ManyToOne()
    @JsonIgnore
    private User user;

    public Address() {
    }

    public Address(String street1, String zipCode, String city, String state,
    		String country, Boolean isPrimary) {
        this.street1 = street1;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.isPrimary = isPrimary;
    }

    public Address(String street1, String street2, String zipCode,
                   String city, String state, String country,
                   Boolean isPrimary)
    {
        this.street1 = street1;
        this.street2 = street2;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.isPrimary = isPrimary;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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


    public Boolean getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
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
        this.zipCode = newAddress.zipCode;
        this.city = newAddress.city;
        this.state = newAddress.state;
        this.country = newAddress.country;
        this.isPrimary = newAddress.isPrimary;
    }
    
    
    
}
