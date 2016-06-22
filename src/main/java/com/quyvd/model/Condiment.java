package com.quyvd.model;

public class Condiment extends Product {
	
	public Condiment() {
		super();
	}
	
	public Condiment(int id, String name, double price, boolean enabled) {
		super(id,name,price,enabled);
	}
	
	public String toString() {
		return "Condiment: " + this.getId() + ", " + this.getName() + ", " + this.getPrice() + ", " + this.isEnabled();
	}
}
