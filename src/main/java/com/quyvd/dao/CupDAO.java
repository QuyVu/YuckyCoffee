package com.quyvd.dao;

import java.util.List;
import java.util.Map;

public interface CupDAO {
	public int addCup(int orderID, String size, int coffeeID, String condiments, double price);;
	public List<Map<String,Object>> selectCupByOrder(int orderID);
}
