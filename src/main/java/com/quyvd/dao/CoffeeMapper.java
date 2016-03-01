package com.quyvd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.quyvd.model.Coffee;

public class CoffeeMapper implements RowMapper<Coffee> {

	public Coffee mapRow(ResultSet resSet, int rowNum) throws SQLException {
		int id = resSet.getInt("coffees_id");
		String name = resSet.getString("name");
		double price = resSet.getDouble("price");
		boolean enabled = resSet.getBoolean("enabled");
		return new Coffee(id,name,price,enabled);
	}

}
