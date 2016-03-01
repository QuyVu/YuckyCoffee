package com.quyvd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.quyvd.model.Condiment;

public class CondimentMapper implements RowMapper<Condiment> {

	public Condiment mapRow(ResultSet resSet, int rowNum) throws SQLException {
		int id = resSet.getInt("condiments_id");
		String name = resSet.getString("name");
		double price = resSet.getDouble("price");
		boolean enabled = resSet.getBoolean("enabled");
		return new Condiment(id,name,price,enabled);
	}

}
