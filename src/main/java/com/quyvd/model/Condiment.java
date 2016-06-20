package com.quyvd.model;

public class Condiment extends Product {
	
	public Condiment() {
	}
	
	public Condiment(String name, double price) {
		super(name, price);
	}
	
	public Condiment(int id, String name, double price, boolean enabled) {
		super(id,name,price,enabled);
	}
	
	public String toString() {
		return "Condiment: " + this.getProductID() + ", " + this.getProductName() + ", " + this.getProductPrice() + ", " + this.isEnabled();
	}
}
