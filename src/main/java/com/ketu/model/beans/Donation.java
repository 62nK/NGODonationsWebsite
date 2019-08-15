package com.ketu.model.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="donations")
public class Donation {

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private int id;
	String name;
	String date;
	double amt;
	String donationType;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(double amt) {
		this.amt = amt;
	}
	public String getDonationType() {
		return donationType;
	}
	public void setDonationType(String donationType) {
		donationType = donationType;
	}
	
	
}
