package com.ketu.model.beans;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
	
	@Id
	long id;
	String street;
	String city;
	String state;
	String zipcode;
	String country;
	
	
	public long getId() {
		return id;
	}
	public String getCountry() {
		return country;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	
	
}
