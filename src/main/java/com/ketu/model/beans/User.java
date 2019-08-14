package com.ketu.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	public transient static final String role1 = "ADMIN";
	public transient static final String role2 = "REGULAR";
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private int id;
	String firsrtName;
	String lastName;
	String email;
	String phone;
	String role;
    @Column(name="username", unique=true)
	String username;
	String password;
	
	public String getFirsrtName() {
		return firsrtName;
	}
	public void setFirsrtName(String firsrtName) {
		this.firsrtName = firsrtName;
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
	public String getPassword() {
		return password;
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
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String passwd) {
		this.password = passwd;
	}
	

}
