package com.quyvd.model;

public class Coffee extends Product{

	public Coffee() {
	}

	public Coffee(String name, double price) {
		super(name, price);
	}
	
	public Coffee(int id, String name, double price, boolean enabled) {
		super(id,name,price,enabled);
	}
	
	public String toString() {
		return "Coffee: " + this.getProductID() + ", " + this.getProductName() + ", " + this.getProductPrice() + ", " + this.isEnabled();
	}
}
