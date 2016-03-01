package com.quyvd.model;

public class Condiment {
	private int condimentID;
	private String condimentName;
	private double condimentPrice;
	private boolean enabled;
	
	public Condiment() {
		// TODO Auto-generated constructor stub
	}
	public Condiment(String name, double price) {
		this.condimentName=name;
		this.condimentPrice=price;
	}
	public Condiment(int id, String name, double price) {
		this.condimentID=id;
		this.condimentName=name;
		this.condimentPrice=price;
	}
	public Condiment(int id, String name, double price, boolean enabled) {
		this.condimentID=id;
		this.condimentName=name;
		this.condimentPrice=price;
		this.enabled = enabled;
	}
	public int getCondimentID() {
		return condimentID;
	}
	public void setCondimentID(int condimentID) {
		this.condimentID = condimentID;
	}
	public String getCondimentName() {
		return condimentName;
	}
	public void setCondimentName(String condimentName) {
		this.condimentName = condimentName;
	}
	public double getCondimentPrice() {
		return condimentPrice;
	}
	public void setCondimentPrice(double condimentPrice) {
		this.condimentPrice = condimentPrice;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}	
	
	public String toString() {
		return "Condiment: " + this.getCondimentID() + ", " + this.getCondimentName() + ", " + this.getCondimentPrice() + ", " + this.isEnabled();
	}
}
