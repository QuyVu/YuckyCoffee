package com.quyvd.dao;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quyvd.mapper.OrderMapper;
import com.quyvd.model.Order;

@Service
@Transactional
public class OrderDAO extends JdbcDaoSupport {

	@Autowired
	public OrderDAO(DataSource dataSource) {
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
	
	public List<Order> selectOrderByDate(Timestamp startDate, Timestamp endDate) {
		String sql = "SELECT * FROM orders WHERE purchase_time BETWEEN ? AND ? ORDER BY purchase_time ASC";
		Object[] params = new Object[] {startDate, endDate};
		OrderMapper uMap = new OrderMapper();
		List<Order> orders = this.getJdbcTemplate().query(sql,params,uMap);
		return orders;
	}
	
	public List<Map<String,Object>> selectOrderByMonth(Calendar cal) {
		String sql = "select date_part('days',purchase_time) as day, SUM(total) from orders where date_part('months',purchase_time)=? and date_part('years',purchase_time)=? GROUP BY date_part('days',purchase_time) ORDER BY day ASC";
		//get parameters from calendar
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		Object[] params = new Object[] {month, year};
		List<Map<String,Object>> orders = this.getJdbcTemplate().queryForList(sql,params);
		return sortOrdersByDay(orders,cal);
	}
	
	//Add empty day to the list
	public List<Map<String,Object>> insertEmptyDay(List<Map<String,Object>> orders, Calendar cal) {
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);	
		boolean exist = false;
		for (double i = 1; i <= maxDay; i++) {
			for (Map<String, Object> m : orders) {
				//true if that day already in list
				if (i == Double.parseDouble(m.get("day").toString()))
					exist = true;
			}
			if (!exist) {
				Map<String, Object> map = new TreeMap<String, Object>();
				map.put("sum", 0);
				map.put("day", i);
				orders.add(map);
			}
			exist=false;
		}
		return orders;
	}
	
	public List<Map<String,Object>> sortOrdersByDay(List<Map<String,Object>> orders, Calendar cal){
		orders = insertEmptyDay(orders,cal);
		Comparator<Map<String, Object>> mapComparator = new Comparator<Map<String, Object>>() {
			public int compare(Map<String, Object> m1, Map<String, Object> m2) {
				return ( (Double) m1.get("day")).compareTo( (Double) m2.get("day"));
			}
		};
		Collections.sort(orders, mapComparator);
		return orders;
	}
}
