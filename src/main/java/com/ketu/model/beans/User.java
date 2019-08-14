package com.ketu.model.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private int id;
	String firstName;
	String lastName;
	String email;
	String phone;
	String role;
	String username;
	String passwd;
	
	public String getFirsrtName() {
		return firstName;
	}
	public void setFirsrtName(String firsrtName) {
		this.firstName = firsrtName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}
