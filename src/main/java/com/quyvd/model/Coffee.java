package com.quyvd.model;

public class Coffee extends Product {

	public Coffee() {
		super();
	}
	
	public Coffee(int id, String name, double price, boolean enabled) {
		super(id,name,price,enabled);
	}
	
	public String toString() {
		return "Coffee: " + this.getId() + ", " + this.getName() + ", " + this.getPrice() + ", " + this.isEnabled();
	}
}
