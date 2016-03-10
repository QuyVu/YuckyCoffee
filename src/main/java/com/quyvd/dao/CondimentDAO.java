package com.quyvd.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quyvd.model.Condiment;

@Service
@Transactional
public class CondimentDAO extends JdbcDaoSupport {
	@Autowired
	public CondimentDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public int addCondiment(String condimentName, double condimentPrice, boolean enabled) {
		String sql = "INSERT INTO condiments (name, price, enabled) VALUES (?,?,?)";
		Object[] params = new Object[] { condimentName, condimentPrice, enabled };
		try {
			return this.getJdbcTemplate().update(sql, params);
		} catch (CannotGetJdbcConnectionException ex) {
			return -1;
		} catch (DuplicateKeyException e) {
			return 0;
		}
	};

	public int editCondiment(Condiment condiment) {
		String sql = "UPDATE condiments SET name = ?, price = ?, enabled = ? WHERE condiments_id = ?";
		Object[] params = new Object[] { condiment.getCondimentName(), condiment.getCondimentPrice(), condiment.isEnabled(), condiment.getCondimentID() };
		try {
			return this.getJdbcTemplate().update(sql, params);
		} catch (CannotGetJdbcConnectionException ex) {
			return -1;
		} catch (DuplicateKeyException e) {
			return 0;
		}
	};
	
	public String getNameByID(int condimentID) {
		String sql = "SELECT name FROM condiments WHERE condiments_id=?";
		Object[] params = new Object[] {condimentID};
		String name = this.getJdbcTemplate().queryForObject(sql, params, String.class);
		return name;
	}
	
	public double getPriceByID(int condimentID) {
		String sql = "SELECT price FROM condiments WHERE condiments_id=?";
		Object[] params = new Object[] {condimentID};
		Double price = this.getJdbcTemplate().queryForObject(sql, params, Double.class);
		return price;
	}

	public List<Condiment> listAllCondiment() {
		String sql = "SELECT * FROM condiments";
		CondimentMapper cMap = new CondimentMapper();
		List<Condiment> list = this.getJdbcTemplate().query(sql, cMap);
		return list;
	}

	public List<Condiment> listAvailableCondiment() {
		String sql = "SELECT * FROM condiments WHERE enabled=TRUE";
		CondimentMapper cMap = new CondimentMapper();
		List<Condiment> list = this.getJdbcTemplate().query(sql, cMap);
		return list;
	}
}
