package com.ketu.model.beans;

public class Donation {

	String name;
	String date;
	double amt;
	String DonationType;
	
	
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
		return DonationType;
	}
	public void setDonationType(String donationType) {
		DonationType = donationType;
	}
	
	
}
