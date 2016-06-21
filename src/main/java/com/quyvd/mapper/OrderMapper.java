package com.quyvd.mapper;

import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.quyvd.model.Order;

public class OrderMapper implements RowMapper<Order> {
	
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		int orderID = rs.getInt("order_id");
		String seller = rs.getString("username");
		Timestamp purchaseTime = rs.getTimestamp("purchase_time");
		double total = rs.getDouble("total");
		return new Order(orderID, seller, purchaseTime, total);
	}

}
