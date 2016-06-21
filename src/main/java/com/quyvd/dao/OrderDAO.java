package com.quyvd.dao;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import com.quyvd.model.Order;

public interface OrderDAO {
	public int addOrder(String userName, Timestamp pTime, double price);
	
	public List<Order> selectOrderByDate(Timestamp startDate, Timestamp endDate);
	
	public List<Map<String,Object>> selectOrderByMonth(Calendar cal);
	
	//Add empty day to the list
	public List<Map<String,Object>> insertEmptyDay(List<Map<String,Object>> orders, Calendar cal);
	
	public List<Map<String,Object>> sortOrdersByDay(List<Map<String,Object>> orders, Calendar cal);
}
