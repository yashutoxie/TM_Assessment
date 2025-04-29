package com.test.UserManagement;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
	private long l;
	public User(long l, String name, String email) {
		this.setL(l);
		this.name  = name;
		this.email = email;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getL() {
		return l;
	}
	public void setL(long l) {
		this.l = l;
	}
	
	public String toString() {
		return "Id:" + l + "Name: " + name + "Email: " + email;
	}
}