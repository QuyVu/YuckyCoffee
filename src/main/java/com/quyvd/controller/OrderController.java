package com.quyvd.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quyvd.config.Principal;
import com.quyvd.dao.CoffeeDAO;
import com.quyvd.dao.CondimentDAO;
import com.quyvd.dao.CupDAO;
import com.quyvd.dao.OrderDAO;
import com.quyvd.model.Coffee;
import com.quyvd.model.Condiment;
import com.quyvd.model.Cup;
import com.quyvd.model.Order;
import com.quyvd.model.OrderWrapper;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

	private Principal principal = new Principal();
	@Autowired
	private CoffeeDAO coffeeDAO;
	@Autowired
	private CondimentDAO condimentDAO;
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private CupDAO cupDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String orderPage(@ModelAttribute("model") ModelMap model, Model user) {
		List<Coffee> listCoffee = coffeeDAO.listAvailableCoffee();
		List<Condiment> listCondiment = condimentDAO.listAvailableCondiment();
		model.addAttribute("listCoffee", listCoffee);
		model.addAttribute("listCondiment", listCondiment);
		user.addAttribute("user", principal.getPrincipal());
		return "orderPage";
	}

	@RequestMapping(value = "/submit-order", method = RequestMethod.POST)
	public @ResponseBody Integer setOrder(@RequestBody OrderWrapper ow) {
		List<Cup> cupList = ow.getCupArray();
		Order order = new Order(principal.getPrincipal(), new Timestamp(ow.getPurchaseTime()), ow.getTotal());
		return insertCup(order, cupList);
	}

	public Integer insertCup(Order order, List<Cup> cupList) {
		// validate price before insert into db
		Integer i = new Integer(0);
		if (isValidOrderPrice(order, cupList)) {
			int orderID = orderDAO.addOrder(order.getUserName(), order.getPurchaseTime(), order.getTotal());
			order.setOrderID(orderID);
			i = 1;
		} else {
			i = 0;
		}
		// insert cup into db
		for (Cup tmp : cupList) {
			cupDAO.addCup(order.getOrderID(), tmp.getCoffeeID(), tmp.getSize(), tmp.getCondiments(), tmp.getPrice());
		}
		return i;
	}

	public double getTotalCondiment(String condiments) {
		if (condiments != "") {
			String[] arrCondiment = condiments.split(", ");
			double total = 0;
			for (int i = 0; i < arrCondiment.length; i++) {
				total += condimentDAO.getPriceByID(Integer.parseInt(arrCondiment[i]));
			}
			return total;
		} else
			return 0;
	}

	public boolean isValidOrderPrice(Order order, List<Cup> cupList) {
		double total = 0;
		for (Cup tmp : cupList) {
			if (isValidCupPrice(tmp))
				total += tmp.getPrice();
		}
		if (total == order.getTotal())
			return true;
		else
			return false;
	}

	public boolean isValidCupPrice(Cup cup) {
		double price = 0;
		if (cup.getSize().equals("Normal")) {
			price = coffeeDAO.getPriceByID(cup.getCoffeeID()) + getTotalCondiment(cup.getCondiments());
		} else if (cup.getSize().equals("Large")) {
			price = coffeeDAO.getPriceByID(cup.getCoffeeID()) + getTotalCondiment(cup.getCondiments()) + 1;
		} else
			return false;
		if (price == cup.getPrice())
			return true;
		else
			return false;

	}
}
