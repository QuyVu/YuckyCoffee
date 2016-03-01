package com.quyvd.model;

public class Cup {

	private int cupID;
	private int coffeeID;
	private String size;
	private int orderID;
	private String condiments;
	private double price;

	public Cup() {
		// TODO Auto-generated constructor stub
	}

	public Cup(int id, int orderID, int coffeeID, String size, String condiments, double price) {
		this.cupID = id;
		this.orderID = orderID;
		this.coffeeID = coffeeID;
		this.size = size;
		this.condiments = condiments;
		this.price = price;
	}

	public int getCupID() {
		return cupID;
	}

	public void setCupID(int cupID) {
		this.cupID = cupID;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getCoffeeID() {
		return coffeeID;
	}

	public void setCoffeeID(int coffeeID) {
		this.coffeeID = coffeeID;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getCondiments() {
		return condiments;
	}

	public void setCondiments(String condiments) {
		this.condiments = condiments;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
