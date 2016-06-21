package com.quyvd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quyvd.mapper.CoffeeMapper;
import com.quyvd.model.Product;

@Service
@Transactional
public class CoffeeDAOImpl extends JdbcDaoSupport implements ProductDAO {
	
    @Autowired
    public CoffeeDAOImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

	public int addProduct(String name, double price, boolean enabled) {
		String sql = "INSERT INTO coffees (name, price, enabled) VALUES (?,?,?)";
		Object[] params = new Object[] { name, price, enabled };
		try {
			return this.getJdbcTemplate().update(sql, params);
		} catch (CannotGetJdbcConnectionException ex) {
			return -1;
		} catch (DuplicateKeyException e) {
			return 0;
		}
	}

	public int editProduct(Product coffee) {
		String sql = "UPDATE coffees SET name = ?, price = ?, enabled = ? WHERE coffee_id = ?";
		Object[] params = new Object[] { coffee.getProductName(), coffee.getProductPrice(), coffee.isEnabled(), coffee.getProductID() };
		try {
			return this.getJdbcTemplate().update(sql, params);
		} catch (CannotGetJdbcConnectionException ex) {
			return -1;
		} catch (DuplicateKeyException e) {
			return 0;
		}
	}

	public String getNameById(int coffeeID) {
		String sql = "SELECT name FROM coffees WHERE coffee_id=?";
		Object[] params = new Object[] { coffeeID };
		String coffeeName = this.getJdbcTemplate().queryForObject(sql, params, String.class);
		return coffeeName;
	}

	public double getPriceById(int coffeeID) {
		String sql = "SELECT price FROM coffees WHERE coffee_id=?";
		Object[] params = new Object[] { coffeeID };
		Double price = this.getJdbcTemplate().queryForObject(sql, params, Double.class);
		return price;
	}

	public List<Product> listAll() {
		String sql = "SELECT * FROM coffees order by coffee_id";
		CoffeeMapper cMap = new CoffeeMapper();
		List<Product> list = new ArrayList<Product>(this.getJdbcTemplate().query(sql, cMap));
		return list;
	}

	public List<Product> listAvailable() {
		String sql = "SELECT * FROM coffees WHERE enabled=TRUE order by coffee_id";
		CoffeeMapper cMap = new CoffeeMapper();
		List<Product> list = new ArrayList<Product>(this.getJdbcTemplate().query(sql, cMap));
		return list;
	}
}
