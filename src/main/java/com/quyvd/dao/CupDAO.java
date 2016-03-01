package com.quyvd.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CupDAO extends JdbcDaoSupport {

	@Autowired
	public CupDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public int addCup(int orderID, int coffeeID, String size, String condiments, double price) {
		String sql = "INSERT INTO cups (order_id, coffee_id, size, condiments, price) VALUES (?,?,?,?,?)";
		Object[] params = new Object[] { orderID, coffeeID, size, condiments, price };
		try {
			return this.getJdbcTemplate().update(sql, params);
		} catch (CannotGetJdbcConnectionException ex) {
			return 0;
		}
	};

	public void getCupByID(int id) {
	};
}
