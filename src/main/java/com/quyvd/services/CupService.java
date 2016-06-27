package com.quyvd.services;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quyvd.dao.CoffeeDAOImpl;
import com.quyvd.dao.CondimentDAOImpl;
import com.quyvd.dao.CupDAOImpl;
import com.quyvd.model.Cup;
import com.quyvd.model.Order;

@Service
public class CupService {

	public static final Logger logger = LogManager.getLogger(CupService.class);
	@Autowired
	private CoffeeDAOImpl coffeeDAOImpl;
	@Autowired
	private CondimentDAOImpl condimentDAOImpl;
	@Autowired
	private CupDAOImpl cupDAOImpl;
	
	public List<Map<String,Object>> selectCupsByOrder (int orderId) {
		return cupDAOImpl.selectCupByOrder(orderId);
	}

	public String convertIdToName(String ids) {
		String[] id = ids.split(", ");
		String result = "";
		for (int i = 0; i < id.length; i++) {
			String s = condimentDAOImpl.getNameById(Integer.parseInt(id[i]));
			if (result.equals(""))
				result = result + s;
			else
				result = result + ", " + s;
		}
		return result;
	}

	public int insertCup(Order order) {
		for (Cup tmp : order.getCups()) {
			cupDAOImpl.addCup(order.getOrderID(), tmp.getSize(), tmp.getCoffee().getId(), tmp.getCondimentIds(),
					tmp.getPrice());
		}
		return 1;
	}

	public boolean isValidCups(List<Cup> cups) {
		boolean isValid = true;
		for (Cup cup : cups) {
			logger.debug(cup.getCoffee().getId());
			double price = 0;
			if (cup.getSize().equals("Normal")) {
				price = coffeeDAOImpl.getPriceById(cup.getCoffee().getId()) + cup.getTotalCondiment();
			} else if (cup.getSize().equals("Large")) {
				price = coffeeDAOImpl.getPriceById(cup.getCoffee().getId()) + cup.getTotalCondiment() + 1;
			} else {
				isValid = false;
				break;
			}
			if (price == cup.getPrice())
				isValid = true;
			else {
				isValid = false;
				break;
			}	
		}
		return isValid;

	}
}
