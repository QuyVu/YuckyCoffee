package com.quyvd.model;

import java.util.List;

public class Cup {

	private int cupID;
	private int orderID;
	private String size;
	private Coffee coffee;
	private List<Condiment> condiments;
	private double price;

	public Cup() {
	}

	public Cup(int id, int orderID, String size, Coffee coffee, List<Condiment> condiments, double price) {
		this.cupID = id;
		this.orderID = orderID;
		this.coffee = coffee;
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

	public Coffee getCoffee() {
		return coffee;
	}

	public void setCoffee(Coffee coffeeID) {
		this.coffee = coffeeID;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public List<Condiment> getCondiments() {
		return condiments;
	}

	public void setCondiments(List<Condiment> condiments) {
		this.condiments = condiments;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getCondimentIds () {
		String idList = null;
		for(Condiment con: this.condiments) {
			String s = String.valueOf(con.getProductID());
			if (idList.equals(null)) idList += s;
			else idList = idList + ", " + s;
		}
		return idList;
	}

	public double getTotalCondiment() {
		double totalCondiments = 0;
		for(Condiment con: this.condiments) {
			totalCondiments += con.getProductPrice();
		}
		return totalCondiments;
	}
	
	public String getCondimentNames() {
		String nameList = null;
		for(Condiment con: this.condiments) {
			String s = con.getProductName();
			if (nameList.equals(null)) nameList += s;
			else nameList = nameList + ", " + s;
		}
		return nameList;
	}
}
