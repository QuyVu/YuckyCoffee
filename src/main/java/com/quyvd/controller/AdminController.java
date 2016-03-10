package com.quyvd.controller;

import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quyvd.config.Principal;
import com.quyvd.dao.CoffeeDAO;
import com.quyvd.dao.CondimentDAO;
import com.quyvd.dao.CupDAO;
import com.quyvd.dao.OrderDAO;
import com.quyvd.dao.UserDAO;
import com.quyvd.model.Coffee;
import com.quyvd.model.Condiment;
import com.quyvd.model.Cup;
import com.quyvd.model.CupWrapper;
import com.quyvd.model.Order;
import com.quyvd.model.User;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	public static final Logger logger = LogManager.getLogger(AdminController.class);
	// private static final Logger logger =
	// Logger.getLogger(AdminController.class);

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private CoffeeDAO coffeeDAO;

	@Autowired
	private CondimentDAO condimentDAO;

	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private CupDAO cupDAO;

	private Principal principal = new Principal();

	@RequestMapping(method = RequestMethod.GET)
	public String adminPage() {
		logger.entry();
		return logger.exit("redirect:admin/order");
	}

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String orderPage(Model user) {
		logger.entry();
		logger.trace("trace");
		user.addAttribute("user", principal.getPrincipal());
		return logger.exit("listOrderPage");
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userPage(@ModelAttribute("model") ModelMap model, Model user) {
		logger.entry();
		List<User> users = userDAO.listUser();
		model.addAttribute("users", users);
		user.addAttribute("user", principal.getPrincipal());
		return logger.exit("userManagePage");
	}

	@RequestMapping(value = "/coffee", method = RequestMethod.GET)
	public String coffeePage(@ModelAttribute("model") ModelMap model, Model user) {
		logger.entry();
		List<Coffee> coffees = coffeeDAO.listAllCoffee();
		model.addAttribute("coffees", coffees);
		user.addAttribute("user", principal.getPrincipal());
		return logger.exit("coffeeManagePage");
	}

	@RequestMapping(value = "/condiment", method = RequestMethod.GET)
	public String condimentPage(@ModelAttribute("model") ModelMap model, Model user) {
		logger.entry();
		List<Condiment> condiments = condimentDAO.listAllCondiment();
		model.addAttribute("condiments", condiments);
		user.addAttribute("user", principal.getPrincipal());
		return logger.exit("condimentManagePage");
	}

	@RequestMapping(value = "/statistic", method = RequestMethod.GET)
	public String statisticPage(Model user) {
		logger.entry();
		user.addAttribute("user", principal.getPrincipal());
		return logger.exit("statisticPage");
	}

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public @ResponseBody List<Order> selectOrderByDate(@ModelAttribute("foo") ModelMap model,
			@RequestParam("sDate") Long startDate, @RequestParam("eDate") Long endDate) {
		logger.entry("startDate: " + startDate, "endDate: " + endDate);
		List<Order> orders = new ArrayList<Order>();
		Timestamp sDate = new Timestamp(startDate);
		Timestamp eDate = new Timestamp(endDate);
		orders = orderDAO.selectOrderByDate(sDate, eDate);
		model.addAttribute("orders", orders);
		return logger.exit(orders);
	}

	@RequestMapping(value="/list-cup-by-order", method = RequestMethod.POST)
	public @ResponseBody List<CupWrapper> selectCupByOrder(@RequestParam("id") int orderID) {
		logger.entry("orderID: " + orderID);
		List<Cup> cups = new ArrayList<Cup>();
		List<CupWrapper> cw = new ArrayList<CupWrapper>();
		cups = cupDAO.selectCupByOrder(orderID);
		for(Cup cup: cups) {
			String condiments = getCondimentName(cup.getCondiments());
			String coffeeName = coffeeDAO.getNamebyID(cup.getCoffeeID());
			CupWrapper tmp = new CupWrapper(cup.getCupID(), coffeeName , cup.getSize(), condiments,cup.getPrice()); 
			cw.add(tmp);
		}
		return logger.exit(cw);
	}

	public String getCondimentName(String condiments) {
		String nameArray = "";
		System.out.println(condiments);
		if (!condiments.equals("")) {
			String[] arrCondiment = condiments.split(", ");
			for (int i = 0; i < arrCondiment.length; i++) {
				nameArray += condimentDAO.getNameByID(Integer.parseInt(arrCondiment[i]));
				if (i < arrCondiment.length - 1)
					nameArray += ", ";
			}
		} else nameArray = "N/A";
		return nameArray;
	}

	@RequestMapping(value = "/order-by-month", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> selectOrderByDate(@RequestParam("time") Long monthOfYear) {
		logger.entry("time: " + monthOfYear);
		List<Map<String, Object>> orders = new ArrayList<Map<String, Object>>();
		// get time from request parameters
		Date time = new Date(monthOfYear);
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		orders = orderDAO.selectOrderByMonth(cal);
		return logger.exit(orders);
	}

	@RequestMapping(value = "/submit-new-user", method = RequestMethod.POST)
	public @ResponseBody Integer getUser(@RequestBody User user) {
		logger.entry(user.toString());
		Integer response = new Integer(0);
		response = userDAO.addUser(user.getUserName(), user.getPassword(), user.getRole(), user.isEnabled());
		return logger.exit(response);
	}

	@RequestMapping(value = "/submit-new-coffee", method = RequestMethod.POST)
	public @ResponseBody Integer getNewCoffee(@RequestBody Coffee coffee) {
		logger.entry(coffee.toString());
		Integer response = new Integer(0);
		response = coffeeDAO.addCoffee(coffee.getCoffeeName(), coffee.getCoffeePrice(), coffee.isEnabled());
		return logger.exit(response);
	}

	@RequestMapping(value = "/submit-new-condiment", method = RequestMethod.POST)
	public @ResponseBody Integer getNewCondiment(@RequestBody Condiment condiment) {
		logger.entry(condiment.toString());
		Integer response = new Integer(0);
		response = condimentDAO.addCondiment(condiment.getCondimentName(), condiment.getCondimentPrice(),
				condiment.isEnabled());
		return logger.exit(response);
	}

	@RequestMapping(value = "/update-user", method = RequestMethod.POST)
	public @ResponseBody Integer updateUser(@RequestParam("username") String userName,
			@RequestParam("action") String action) {
		logger.entry("user: " + userName, "action: " + action);
		Integer response = new Integer(0);
		if (action.equals("active")) {
			response = userDAO.activeUser(userName);
		} else {
			response = userDAO.deactiveUser(userName);
		}
		return logger.exit(response);
	}

	@RequestMapping(value = "/update-coffee", method = RequestMethod.POST)
	public @ResponseBody Integer updateCoffee(@RequestBody Coffee coffee) {
		logger.entry(coffee.toString());
		Integer response = new Integer(0);
		response = coffeeDAO.editCoffee(coffee);
		return logger.exit(response);
	}

	@RequestMapping(value = "/update-condiment", method = RequestMethod.POST)
	public @ResponseBody Integer updateCondiment(@RequestBody Condiment condiment) {
		logger.entry(condiment.toString());
		Integer response = new Integer(0);
		response = condimentDAO.editCondiment(condiment);
		return logger.exit(response);
	}

}
