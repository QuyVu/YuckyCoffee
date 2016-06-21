package com.quyvd.dao;

import java.util.List;
import com.quyvd.model.User;

public interface UserDAO {
	public int addUser(String userName, String password, String role, Boolean enabled);

	public int changePassword(String userName, String password);

	public String findPassword(String userName);

	public User findUserInfo(String userName);

	public List<User> listUser();

	public int deleteUser(String userName);

	public int activeUser(String userName);

	public int deactiveUser(String userName);
}
