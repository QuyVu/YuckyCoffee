package com.quyvd.model;

public class Coffee {
	private int coffeeID;
	private String coffeeName;
	private double coffeePrice;
	private boolean enabled;

	public Coffee() {
	}

	public Coffee(String name, double price) {
		this.coffeeName = name;
		this.coffeePrice = price;
	}

	public Coffee(int id, String name, double price) {
		this.coffeeID = id;
		this.coffeeName = name;
		this.coffeePrice = price;
	}

	public Coffee(int id, String name, double price, boolean enabled) {
		this.coffeeID = id;
		this.coffeeName = name;
		this.coffeePrice = price;
		this.enabled = enabled;
	}

	public int getCoffeeID() {
		return coffeeID;
	}

	public void setCoffeeID(int coffeeID) {
		this.coffeeID = coffeeID;
	}

	public String getCoffeeName() {
		return coffeeName;
	}

	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}

	public double getCoffeePrice() {
		return coffeePrice;
	}

	public void setCoffeePrice(double coffeePrice) {
		this.coffeePrice = coffeePrice;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String toString() {
		return "Coffee: " + this.getCoffeeID() + ", " + this.getCoffeeName() + ", " + this.getCoffeePrice() + ", " + this.isEnabled();
	}
}
