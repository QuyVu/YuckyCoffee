package com.quyvd.controller;

import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;

import com.quyvd.config.Principal;
import com.quyvd.model.Coffee;
import com.quyvd.model.Condiment;
import com.quyvd.model.User;
import com.quyvd.services.CupService;
import com.quyvd.services.OrderService;
import com.quyvd.services.ProductService;
import com.quyvd.services.UserService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	public static final Logger logger = LogManager.getLogger(AdminController.class);
	// private static final Logger logger =
	// Logger.getLogger(AdminController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private CupService cupService;

	@Autowired
	LocaleResolver localeResolver;

	private Principal principal = new Principal();

	@RequestMapping(method = RequestMethod.GET)
	public String adminPage(HttpServletRequest request, HttpServletResponse response,
			@CookieValue(value = "lang", defaultValue = "en") String lang) {
		logger.entry();
		localeResolver.setLocale(request, response, StringUtils.parseLocaleString(lang));
		return logger.exit("redirect:admin/order");
	}

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String orderPage(HttpServletRequest request, HttpServletResponse response,
			@CookieValue(value = "lang", defaultValue = "en") String lang, Model user) {
		logger.entry();
		logger.trace("trace");
		localeResolver.setLocale(request, response, StringUtils.parseLocaleString(lang));
		user.addAttribute("user", principal.getPrincipal());
		return logger.exit("pages/list-order");
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userPage(HttpServletRequest request, HttpServletResponse response,
			@CookieValue(value = "lang", defaultValue = "en") String lang, @ModelAttribute("model") ModelMap model,
			Model user) {
		logger.entry();
		List<User> users = userService.listAllUser();
		model.addAttribute("users", users);
		localeResolver.setLocale(request, response, StringUtils.parseLocaleString(lang));
		user.addAttribute("user", principal.getPrincipal());
		return logger.exit("pages/manage-user");
	}

	@RequestMapping(value = "/coffee", method = RequestMethod.GET)
	public String coffeePage(HttpServletRequest request, HttpServletResponse response,
			@CookieValue(value = "lang", defaultValue = "en") String lang, @ModelAttribute("model") ModelMap model,
			Model user) {
		logger.entry();
		List<Coffee> coffees = productService.listAllCoffee();
		model.addAttribute("coffees", coffees);
		localeResolver.setLocale(request, response, StringUtils.parseLocaleString(lang));
		user.addAttribute("user", principal.getPrincipal());
		return logger.exit("pages/manage-coffee");
	}

	@RequestMapping(value = "/condiment", method = RequestMethod.GET)
	public String condimentPage(HttpServletRequest request, HttpServletResponse response,
			@CookieValue(value = "lang", defaultValue = "en") String lang, @ModelAttribute("model") ModelMap model,
			Model user) {
		logger.entry();
		List<Condiment> condiments = productService.listAllCondiment();
		model.addAttribute("condiments", condiments);
		localeResolver.setLocale(request, response, StringUtils.parseLocaleString(lang));
		user.addAttribute("user", principal.getPrincipal());
		return logger.exit("pages/manage-condiment");
	}

	@RequestMapping(value = "/statistic", method = RequestMethod.GET)
	public String statisticPage(HttpServletRequest request, HttpServletResponse response,
			@CookieValue(value = "lang", defaultValue = "en") String lang, Model user) {
		logger.entry();
		localeResolver.setLocale(request, response, StringUtils.parseLocaleString(lang));
		user.addAttribute("user", principal.getPrincipal());
		return logger.exit("pages/statistic");
	}

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> selectOrderByDate(@RequestParam("sDate") Long startDate,
			@RequestParam("eDate") Long endDate) {
		logger.entry("startDate: " + startDate, "endDate: " + endDate);
		Timestamp sDate = new Timestamp(startDate);
		Timestamp eDate = new Timestamp(endDate);
		List<Map<String, Object>> orders = orderService.selectOrdersByDate(sDate, eDate);
		return logger.exit(orders);
	}

	@RequestMapping(value = "/list-cup-by-order", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> selectCupByOrder(@RequestParam("id") int orderId) {
		logger.entry("orderID: " + orderId);
		List<Map<String, Object>> cups = cupService.selectCupsByOrder(orderId);
		for (Map<String, Object> cup : cups) {
			String ids = String.valueOf(cup.get("condiments"));
			String coffeeName = productService.getCoffeeNameById(Integer.parseInt(String.valueOf(cup.get("coffee_id"))));
			String names = cupService.convertIdToName(ids);
			cup.remove("coffee_id");
			cup.put("coffee", coffeeName);
			cup.replace("condiments", names);
		}
		return logger.exit(cups);
	}

	@RequestMapping(value = "/order-by-month", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> selectOrderByMonth(@RequestParam("time") Long monthOfYear) {
		logger.entry("time: " + monthOfYear);
		List<Map<String, Object>> orders = new ArrayList<Map<String, Object>>();
		// get time from request parameters
		Date time = new Date(monthOfYear);
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		orders = orderService.selectOrdersByMonth(cal);
		return logger.exit(orders);
	}

	@RequestMapping(value = "/submit-new-user", method = RequestMethod.POST)
	public @ResponseBody Integer getUser(@RequestBody User user) {
		logger.entry(user.toString());
		Integer response = new Integer(0);
		response = userService.addUser(user);
		return logger.exit(response);
	}

	@RequestMapping(value = "/submit-new-coffee", method = RequestMethod.POST)
	public @ResponseBody Integer getNewCoffee(@RequestBody Coffee coffee) {
		logger.entry(coffee.toString());
		Integer response = new Integer(0);
		response = productService.addProduct(coffee);
		return logger.exit(response);
	}

	@RequestMapping(value = "/submit-new-condiment", method = RequestMethod.POST)
	public @ResponseBody Integer getNewCondiment(@RequestBody Condiment condiment) {
		logger.entry(condiment.toString());
		Integer response = new Integer(0);
		response = productService.addProduct(condiment);
		return logger.exit(response);
	}

	@RequestMapping(value = "/update-user", method = RequestMethod.POST)
	public @ResponseBody Integer updateUser(@RequestParam("username") String userName,
			@RequestParam("action") String action) {
		logger.entry("user: " + userName, "action: " + action);
		Integer response = new Integer(0);
		if (action.equals("active")) {
			response = userService.unlockUser(userName);
		} else {
			response = userService.lockUser(userName);
		}
		return logger.exit(response);
	}

	@RequestMapping(value = "/update-coffee", method = RequestMethod.POST)
	public @ResponseBody Integer updateCoffee(@RequestBody Coffee coffee) {
		logger.entry(coffee.toString());
		Integer response = new Integer(0);
		response = productService.editProduct(coffee);
		return logger.exit(response);
	}

	@RequestMapping(value = "/update-condiment", method = RequestMethod.POST)
	public @ResponseBody Integer updateCondiment(@RequestBody Condiment condiment) {
		logger.entry(condiment.toString());
		Integer response = new Integer(0);
		response = productService.editProduct(condiment);
		return logger.exit(response);
	}

}
