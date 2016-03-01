package com.quyvd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.quyvd.model.User;

public class UserMapper implements RowMapper<User> {

	public User mapRow(ResultSet resSet, int rowNum) throws SQLException {
		String userName = resSet.getString("username");
		String password = resSet.getString("password");
		String role = (String) resSet.getObject("role");
		boolean enabled = resSet.getBoolean("enabled");
		return new User(userName,password,role,enabled);
	}

}
