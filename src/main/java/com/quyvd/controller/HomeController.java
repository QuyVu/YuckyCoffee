package com.quyvd.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quyvd.config.Principal;
import com.quyvd.dao.UserDAO;

@Controller
public class HomeController {
	
	@Autowired
	private UserDAO userDAO;
	
	private Principal principal = new Principal();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String defaultPage() {
		String role = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.isAuthenticated());
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		for (GrantedAuthority a : authorities) {
			System.out.println(a.getAuthority());
			role = a.getAuthority();
		}
		if (role.equals("ROLE_SELLER")) {
			return "redirect:order";
		} else if (role.equals("ROLE_ADMIN")) {
			return "redirect:admin";
		} else if (role.equals("ROLE_ANONYMOUS")) {
			return "redirect:login";
		} else
			return "redirect:403";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(@RequestParam(value = "error", required = false) String error, Model model) {
		System.out.println(error);
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}
		return "loginPage";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String forbiddenPage() {
		return "403";
	}
	
	@RequestMapping(value="/update-password", method = RequestMethod.POST)
	public @ResponseBody Integer changePassword(@RequestParam("curPass") String curPass, @RequestParam("newPass") String newPass){
		Integer response = new Integer(0);
		System.out.println(curPass + " " + newPass);
		String pw = userDAO.findPassword(principal.getPrincipal());
		System.out.println(pw);
		if (!pw.equals(curPass)){
			response = -1;
		} else {
			response = userDAO.changePassword(principal.getPrincipal(), newPass);
		}
		System.out.println(response);
		return response;
	}
}
