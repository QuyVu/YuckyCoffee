package com.quyvd.model;

import java.util.List;

public class Cup {

	private int cupId;
	private int orderId;
	private String size;
	private Coffee coffee;
	private List<Condiment> condiments;
	private double price;

	public Cup() {
	}

	public Cup(int id, int orderID, String size, Coffee coffee, List<Condiment> condiments, double price) {
		this.cupId = id;
		this.orderId = orderID;
		this.size = size;
		this.coffee = coffee;
		this.condiments = condiments;
		this.price = price;
	}

	public int getCupID() {
		return cupId;
	}

	public void setCupID(int cupID) {
		this.cupId = cupID;
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
		return orderId;
	}

	public void setOrderID(int orderID) {
		this.orderId = orderID;
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
		String idList = "";
		for(Condiment con: this.condiments) {
			String s = String.valueOf(con.getId());
			if (idList.equals("")) idList += s;
			else idList = idList + ", " + s;
		}
		return idList;
	}

	public double getTotalCondiment() {
		double totalCondiments = 0;
		for(Condiment con: this.condiments) {
			totalCondiments += con.getPrice();
		}
		return totalCondiments;
	}
	
	public String getCondimentNames() {
		String nameList = null;
		for(Condiment con: this.condiments) {
			String s = con.getName();
			if (nameList.equals(null)) nameList += s;
			else nameList = nameList + ", " + s;
		}
		return nameList;
	}
	
	public String toString() {
		String conStr = "{";
		for(Condiment c : this.condiments) {
			conStr += (c.toString() + " \\ ");
		}
		conStr += "}";
		return this.coffee.toString() + " / " + this.size + " " + conStr + " " + this.price;
	}
}
