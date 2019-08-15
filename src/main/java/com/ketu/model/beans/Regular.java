package com.ketu.model.beans;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "regular")
@PrimaryKeyJoinColumn(name = "id")
public class Regular extends User {
	
	
	String addr;


	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	

}
