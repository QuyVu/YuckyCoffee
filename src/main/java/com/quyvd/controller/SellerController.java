package com.quyvd.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;

import com.quyvd.config.Principal;
import com.quyvd.model.Coffee;
import com.quyvd.model.Condiment;
import com.quyvd.model.Cup;
import com.quyvd.model.Order;
import com.quyvd.services.CupService;
import com.quyvd.services.OrderService;
import com.quyvd.services.ProductService;

@Controller
@RequestMapping(value = "/seller")
public class SellerController {
	public static final Logger logger = LogManager.getLogger(SellerController.class);

	private Principal principal = new Principal();
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private CupService cupService;
	@Autowired
	LocaleResolver localeResolver;

	@RequestMapping(method = RequestMethod.GET)
	public String orderPage(HttpServletRequest request, HttpServletResponse response,
			@CookieValue(value = "lang", defaultValue = "en") String lang, @ModelAttribute("model") ModelMap model,
			Model user) {
		List<Coffee> listCoffee = productService.listAvailableCoffee();
		List<Condiment> listCondiment = productService.listAvailableCondiment();
		localeResolver.setLocale(request, response, StringUtils.parseLocaleString(lang));
		model.addAttribute("listCoffee", listCoffee);
		model.addAttribute("listCondiment", listCondiment);
		user.addAttribute("user", principal.getPrincipal());
		return "pages/seller";
	}

	@RequestMapping(value = "/submit-order", method = RequestMethod.POST)
	public @ResponseBody Integer setOrder(@RequestBody Order order) {
		order.setUserName(principal.getPrincipal());
		logger.debug(order.toString());
		List<Cup> cupList = order.getCups();
		if (order.getTotal() == 0) {
			return -1;
		} else if (!cupService.isValidCups(cupList)) {
			return 0;
		} else {
			int id = orderService.insertOrder(order);
			if (id != 0) {
				order.setOrderID(id);
				cupService.insertCup(order);
				return id;
			} else {
				return 0;
			}
		}
	}
}
