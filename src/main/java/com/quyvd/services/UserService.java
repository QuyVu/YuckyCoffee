package com.quyvd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quyvd.dao.UserDAOImpl;
import com.quyvd.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDAOImpl userDAO;
	
	public int addUser (User user) {
		return userDAO.addUser(user.getUserName(), user.getPassword(), user.getRole(), user.isEnabled());
	}
	
	public List<User> listAllUser() {
		return userDAO.listUser();
	}
	
	public int changePassword (String userName, String password) {
		return userDAO.changePassword(userName, password);
	}
	
	public String findPassword (String userName) {
		return userDAO.findPassword(userName);
	}
	
	public int lockUser (String userName) {
		return userDAO.deactiveUser(userName);
	}
	
	public int unlockUser (String userName) {
		return userDAO.activeUser(userName);
	}
}
