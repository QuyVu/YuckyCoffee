package com.quyvd.model;

import java.sql.Timestamp;
import java.util.List;

public class Order {
	private int orderID;
	private String seller;
	private Timestamp purchaseTime;
	private List<Cup> cups;
	private double total=0;


	public Order() {
	}
	
	public Order(int orderID, String userName, Timestamp purchaseTime, double total) {
		this.orderID = orderID;
		this.seller = userName;
		this.purchaseTime = purchaseTime;
		this.total = total;
	}

	public Order(String userName, Timestamp purchaseTime, double total) {
		this.seller = userName;
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
		return seller;
	}

	public void setUserName(String userID) {
		this.seller = userID;
	}

	public Timestamp getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(Timestamp purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	public List<Cup> getCups() {
		return cups;
	}

	public void setCups(List<Cup> cups) {
		this.cups = cups;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
}
