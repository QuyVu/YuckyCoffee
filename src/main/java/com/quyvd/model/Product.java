package com.quyvd.model;

public class Product {
	private int productID;
	private String productName;
	private double productPrice;
	private boolean enabled;
	
	public Product() {
	}

	public Product(String name, double price) {
		this.productName = name;
		this.productPrice = price;
	}

	public Product(int id, String name, double price) {
		this.productID = id;
		this.productName = name;
		this.productPrice = price;
	}

	public Product(int id, String name, double price, boolean enabled) {
		this.productID = id;
		this.productName = name;
		this.productPrice = price;
		this.enabled = enabled;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String toString() {
		return "Product: " + this.getProductID() + ", " + this.getProductName() + ", " + this.getProductPrice() + ", " + this.isEnabled();
	}
}
