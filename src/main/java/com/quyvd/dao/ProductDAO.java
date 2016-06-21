package com.quyvd.dao;

import java.util.List;

import com.quyvd.model.Product;

public interface ProductDAO {
	public int addProduct(String name, double price, boolean enabled);
	public int editProduct(Product product);
	public String getNameById(int productID);
	public double getPriceById(int productID);
	public List<Product> listAll();
	public List<Product> listAvailable();
}
