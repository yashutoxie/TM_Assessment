package com.Jdbc.JdbcEx;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String item;
	private int quantity;
	
	
	public Orders() {
		
	}
	
	public Orders(String item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}
	
	
	public Long getId() {
		return id;
	}
	
	public String getItem() {
		return item;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	@Override
	public String toString() {
		return "Id: " + id+ ", item name: "+ item + ", quantity: " + quantity; 
	}
	
}
