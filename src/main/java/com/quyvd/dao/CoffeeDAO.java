package com.quyvd.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quyvd.model.Coffee;

@Service
@Transactional
public class CoffeeDAO extends JdbcDaoSupport {

	@Autowired
	public CoffeeDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public int addCoffee(String coffeeName, double coffeePrice, boolean enabled) {
		String sql = "INSERT INTO coffees (name, price, enabled) VALUES (?,?,?)";
		Object[] params = new Object[] { coffeeName, coffeePrice, enabled };
		try {
			return this.getJdbcTemplate().update(sql, params);
		} catch (CannotGetJdbcConnectionException ex) {
			return -1;
		} catch (DuplicateKeyException e) {
			return 0;
		}
	};

	public int editCoffee(Coffee coffee) {
		String sql = "UPDATE coffees SET name = ?, price = ?, enabled = ? WHERE coffee_id = ?";
		Object[] params = new Object[] { coffee.getCoffeeName(), coffee.getCoffeePrice(), coffee.isEnabled(), coffee.getCoffeeID() };
		try {
			return this.getJdbcTemplate().update(sql, params);
		} catch (CannotGetJdbcConnectionException ex) {
			return -1;
		} catch (DuplicateKeyException e) {
			return 0;
		}
	};

	public String getNamebyID(int coffeeID) {
		String sql = "SELECT name FROM coffees WHERE coffee_id=?";
		Object[] params = new Object[] { coffeeID };
		String coffeeName = this.getJdbcTemplate().queryForObject(sql, params, String.class);
		return coffeeName;
	}

	public double getPriceByID(int coffeeID) {
		String sql = "SELECT price FROM coffees WHERE coffee_id=?";
		Object[] params = new Object[] { coffeeID };
		Double price = this.getJdbcTemplate().queryForObject(sql, params, Double.class);
		return price;
	}

	public List<Coffee> listAllCoffee() {
		String sql = "SELECT * FROM coffees order by coffee_id";
		CoffeeMapper cMap = new CoffeeMapper();
		List<Coffee> list = this.getJdbcTemplate().query(sql, cMap);
		return list;
	}

	public List<Coffee> listAvailableCoffee() {
		String sql = "SELECT * FROM coffees WHERE enabled=TRUE order by coffee_id";
		CoffeeMapper cMap = new CoffeeMapper();
		List<Coffee> list = this.getJdbcTemplate().query(sql, cMap);
		return list;
	}
}
