package com.quyvd.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quyvd.model.User;

@Service
@Transactional
public class UserDAO extends JdbcDaoSupport {

	@Autowired
	public UserDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public int addUser(String userName, String password, String role, Boolean enabled) {
		String sql = "INSERT INTO users (username, password, role, enabled) VALUES (?, ?, ?, ?)";
		Object[] params = new Object[] { userName, password, role, enabled };
		try {
			return this.getJdbcTemplate().update(sql, params);
		} catch (CannotGetJdbcConnectionException ex) {
			return 0;
		} catch (DuplicateKeyException e) {
			return -1;
		}
	};

	public int changePassword(String userName, String password) {
		String sql = "UPDATE users SET password=? WHERE username=?";
		Object[] params = new Object[] { password, userName };
		return this.getJdbcTemplate().update(sql, params);
	};

	public String findPassword(String userName) {
		String sql = "SELECT password FROM users WHERE username=?";
		Object[] params = new Object[] {userName};
		return (String)this.getJdbcTemplate().queryForObject(sql, params, String.class);
	};

	public User findUserInfo(String userName) {
		String sql = "SELECT username,password,role FROM users WHERE username=?";
		Object[] params = new Object[] { userName };
		UserMapper uMap = new UserMapper();
		User user = this.getJdbcTemplate().queryForObject(sql, params, uMap);
		return user;
	}

	public List<User> listUser() {
		String sql = "SELECT * FROM users";
		UserMapper uMap = new UserMapper();
		List<User> list = this.getJdbcTemplate().query(sql, uMap);
		return list;
	}

	public int deleteUser(String userName) {
		String sql = "DELETE FROM users WHERE username=?";
		Object[] params = new Object[] { userName };
		try {
			return this.getJdbcTemplate().update(sql, params);
		} catch (CannotGetJdbcConnectionException ex) {
			return -1;
		}
	};

	public int activeUser(String userName) {
		String sql = "UPDATE users SET enabled = 'TRUE' WHERE username=?";
		Object[] params = new Object[] { userName };
		try {
			return this.getJdbcTemplate().update(sql, params);
		} catch (CannotGetJdbcConnectionException ex) {
			return -1;
		}
	};

	public int deactiveUser(String userName) {
		String sql = "UPDATE users SET enabled = 'FALSE' WHERE username=?";
		Object[] params = new Object[] { userName };
		try {
			return this.getJdbcTemplate().update(sql, params);
		} catch (CannotGetJdbcConnectionException ex) {
			return -1;
		}
	};
}
