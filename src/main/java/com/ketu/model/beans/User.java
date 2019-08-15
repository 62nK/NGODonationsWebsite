package com.ketu.model.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	
	public transient static final String role1 = "ADMIN";
	public transient static final String role2 = "REGULAR";
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private long id;
	String firstName;
	String lastName;
	String email;
	String phone;
	String role;
    @Column(name="username", unique=true)
	String username;
	String password;
	
	public String getFirsrtName() {
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
	public long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String passwd) {
		this.password = passwd;
	} 
	public String toString() {
		return "user"+"...";
	}

}
