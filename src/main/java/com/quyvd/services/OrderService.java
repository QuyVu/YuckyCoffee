package com.quyvd.services;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quyvd.dao.OrderDAOImpl;
import com.quyvd.model.Cup;
import com.quyvd.model.Order;

@Service
public class OrderService {

	@Autowired
	private CupService cupService;
	@Autowired
	private OrderDAOImpl orderDAOImpl;

	public boolean isValidOrderPrice(Order order) {
		List<Cup> cupList = order.getCups();
		double total = 0;
		if (cupService.isValidCups(cupList)) {
			for (Cup tmp : cupList) {
				total += tmp.getPrice();
			}
		}
		if (total == order.getTotal())
			return true;
		else
			return false;
	}

	public int insertOrder(Order order) {
		if (isValidOrderPrice(order)) {
			int orderId = orderDAOImpl.addOrder(order.getUserName(), order.getPurchaseTime(), order.getTotal());
			return orderId;
		} else return 0;
	}

	public List<Map<String, Object>> selectOrdersByDate(Timestamp startDate, Timestamp endDate) {
		return orderDAOImpl.selectOrderByDate(startDate, endDate);
	}

	public List<Map<String, Object>> selectOrdersByMonth(Calendar cal) {
		return sortOrdersByDay(orderDAOImpl.selectOrderByMonth(cal), cal);
	}

	// Add empty day to the list
	private List<Map<String, Object>> insertEmptyDay(List<Map<String, Object>> orders, Calendar cal) {
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		boolean exist = false;
		for (double i = 1; i <= maxDay; i++) {
			for (Map<String, Object> m : orders) {
				// true if that day already in list
				if (i == Double.parseDouble(m.get("day").toString()))
					exist = true;
			}
			if (!exist) {
				Map<String, Object> map = new TreeMap<String, Object>();
				map.put("sum", 0);
				map.put("day", i);
				orders.add(map);
			}
			exist = false;
		}
		return orders;
	}

	private List<Map<String, Object>> sortOrdersByDay(List<Map<String, Object>> orders, Calendar cal) {
		orders = insertEmptyDay(orders, cal);
		Comparator<Map<String, Object>> mapComparator = new Comparator<Map<String, Object>>() {
			public int compare(Map<String, Object> m1, Map<String, Object> m2) {
				return ((Double) m1.get("day")).compareTo((Double) m2.get("day"));
			}
		};
		Collections.sort(orders, mapComparator);
		return orders;
	}

}
