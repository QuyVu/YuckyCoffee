package com.quyvd.model;

public class CupWrapper {
	private int cupID;
	private String coffeeName;
	private String size;
	private String condiments;
	private double price;
	
	public CupWrapper(int cupID, String coffeeName, String size, String condiments, double price) {
		super();
		this.cupID = cupID;
		this.coffeeName = coffeeName;
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
	public String getCoffeeName() {
		return coffeeName;
	}
	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
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
