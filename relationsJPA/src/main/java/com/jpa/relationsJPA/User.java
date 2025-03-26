package com.jpa.relationsJPA;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; 
import jakarta.persistence.NamedNativeQuery;

@Entity
@NamedQuery(name = "User.findByEmail", query = "select u from User u where u.email=:email")
@NamedNativeQuery(name="User.findByStatus", query = "SELECT * FROM user WHERE status = ?", resultClass = User.class)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String status;
	
	public User() {}
	
	public User(String name, String email, String status) {	
		this.name = name;
		this.email = email;
		this.status = status;		                 
	}
	
	public void setId(Long id) {
		this.id = id;		
	}
	public Long getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;		
	}
	
	public String getName() {
		return name;
	}
	public void setEmail(String email) {
		this.email = email;		
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setStatus(String status) {
		this.status = status;		
	}
	
	public String getStatus() {
		return status;
	}
	
	
	

}
