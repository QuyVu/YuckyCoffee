package com.quyvd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.quyvd.model.Cup;

public class CupMapper implements RowMapper<Cup>{

	public Cup mapRow(ResultSet resSet, int rowNum) throws SQLException {
		int id = resSet.getInt("cups_id");
		int orderID = resSet.getInt("order_id");
		int coffeeID = resSet.getInt("coffee_id");
		String size = resSet.getString("size");
		String condiments = resSet.getString("condiments");
		double price = resSet.getDouble("price");
		return new Cup(id, orderID, coffeeID, size, condiments, price);
	}

}
