package com.quyvd.model;

import java.util.List;

public class OrderWrapper {
	private long purchaseTime;
	private double total;
	private List<Cup> cupArray;

	public long getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(long purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Cup> getCupArray() {
		return cupArray;
	}

	public void setCupArray(List<Cup> cupArray) {
		this.cupArray = cupArray;
	}

}
