package com.quyvd.dao;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderDAOImpl extends JdbcDaoSupport {

	@Autowired
	public OrderDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public int addOrder(String userName, Timestamp pTime, double price) {
		String sql = "INSERT INTO orders (username, purchase_time, total) VALUES (?, ?, ?) RETURNING order_id";
		Object[] params = new Object[] { userName, pTime, price };
		try {
			return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
		} catch (CannotGetJdbcConnectionException ex) {
			return 0;
		}
	};
	
	public List<Map<String,Object>> selectOrderByDate(Timestamp startDate, Timestamp endDate) {
		String sql = "SELECT * FROM orders WHERE purchase_time BETWEEN ? AND ? ORDER BY purchase_time ASC";
		Object[] params = new Object[] {startDate, endDate};
		List<Map<String,Object>> orders = this.getJdbcTemplate().queryForList(sql, params);
		return orders;
	}
	
	public List<Map<String,Object>> selectOrderByMonth(Calendar cal) {
		String sql = "select date_part('days',purchase_time) as day, SUM(total) from orders where date_part('months',purchase_time)=? and date_part('years',purchase_time)=? GROUP BY date_part('days',purchase_time) ORDER BY day ASC";
		//get parameters from calendar
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		Object[] params = new Object[] {month, year};
		List<Map<String,Object>> orders = this.getJdbcTemplate().queryForList(sql,params);
		return orders;
	}
}
