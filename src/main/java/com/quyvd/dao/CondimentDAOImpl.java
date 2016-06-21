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

import com.quyvd.mapper.CondimentMapper;
import com.quyvd.model.Product;

@Service
@Transactional
public class CondimentDAOImpl extends JdbcDaoSupport implements ProductDAO {
	@Autowired
	public CondimentDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public int addProduct(String name, double price, boolean enabled) {
		String sql = "INSERT INTO condiments (name, price, enabled) VALUES (?,?,?)";
		Object[] params = new Object[] {name, price, enabled };
		try {
			return this.getJdbcTemplate().update(sql, params);
		} catch (CannotGetJdbcConnectionException ex) {
			return -1;
		} catch (DuplicateKeyException e) {
			return 0;
		}
	}

	public int editProduct(Product condiment) {
		String sql = "UPDATE condiments SET name = ?, price = ?, enabled = ? WHERE condiment_id = ?";
		Object[] params = new Object[] { condiment.getProductName(), condiment.getProductPrice(), condiment.isEnabled(), condiment.getProductID() };
		try {
			return this.getJdbcTemplate().update(sql, params);
		} catch (CannotGetJdbcConnectionException ex) {
			return -1;
		} catch (DuplicateKeyException e) {
			return 0;
		}
	};
	
	public String getNameById(int condimentID) {
		String sql = "SELECT name FROM condiments WHERE condiment_id=?";
		Object[] params = new Object[] {condimentID};
		String name = this.getJdbcTemplate().queryForObject(sql, params, String.class);
		return name;
	}
	
	public double getPriceById(int condimentID) {
		String sql = "SELECT price FROM condiments WHERE condiment_id=?";
		Object[] params = new Object[] {condimentID};
		Double price = this.getJdbcTemplate().queryForObject(sql, params, Double.class);
		return price;
	}

	public List<Product> listAll() {
		String sql = "SELECT * FROM condiments";
		CondimentMapper cMap = new CondimentMapper();
		List<Product> list = new ArrayList<Product>(this.getJdbcTemplate().query(sql, cMap));
		return list;
	}

	public List<Product> listAvailable() {
		String sql = "SELECT * FROM condiments WHERE enabled=TRUE";
		CondimentMapper cMap = new CondimentMapper();
		List<Product> list =  new ArrayList<Product>(this.getJdbcTemplate().query(sql, cMap));
		return list;
	}
}
