package com.quyvd.model;

import java.sql.Timestamp;

public class Order {
	private int orderID;
	private String userName;
	private Timestamp purchaseTime;
	private double total=0;


	public Order() {
	}
	
	public Order(int orderID, String userName, Timestamp purchaseTime, double total) {
		this.orderID = orderID;
		this.userName = userName;
		this.purchaseTime = purchaseTime;
		this.total = total;
	}

	public Order(String userName, Timestamp purchaseTime, double total) {
		this.userName = userName;
		this.purchaseTime = purchaseTime;
		this.total = total;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userID) {
		this.userName = userID;
	}

	public Timestamp getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(Timestamp purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
}
