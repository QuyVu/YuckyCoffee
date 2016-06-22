package com.quyvd.model;

import java.sql.Timestamp;
import java.util.List;

public class Order {
	private int orderId;
	private String seller;
	private Timestamp purchaseTime;
	private List<Cup> cups;
	private double total=0;


	public Order() {
	}
	
	public Order(int orderId, String userName, Timestamp purchaseTime, List<Cup> cups, double total) {
		this.orderId = orderId;
		this.seller = userName;
		this.purchaseTime = purchaseTime;
		this.cups = cups;
		this.total = total;
	}

	public int getOrderID() {
		return orderId;
	}

	public void setOrderID(int orderID) {
		this.orderId = orderID;
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
	
	public String toString() {
		String cupStr = "";
		for (Cup cup: this.cups) {
			cupStr += (cup.toString() + "\n");
		}
		return this.orderId + "\t" + this.seller + "\t" + this.purchaseTime + "\t" + cupStr + this.total;
	}
	
}
