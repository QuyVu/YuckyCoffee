package com.quyvd.config;

import com.quyvd.model.Cup;
import com.quyvd.model.Order;

public class ResponseObject {
	private Order order;
	private Cup cup;
	private int code;
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Cup getCup() {
		return cup;
	}

	public void setCup(Cup cup) {
		this.cup = cup;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	

}
