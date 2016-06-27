package com.quyvd.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quyvd.dao.CoffeeDAOImpl;
import com.quyvd.dao.CondimentDAOImpl;
import com.quyvd.model.Coffee;
import com.quyvd.model.Condiment;
import com.quyvd.model.Product;

@Service
public class ProductService {

	@Autowired
	private CoffeeDAOImpl coffeeDAOImpl;
	@Autowired
	private CondimentDAOImpl condimentDAOImpl;

	public Integer addProduct(Product product) {
		if (product.getClass().getName().equals("com.quyvd.model.Coffee")) {
			return coffeeDAOImpl.addProduct(product.getName(), product.getPrice(), product.isEnabled());
		} else
			System.out.println(product.getClass().getName().equals("Coffee"));
			return condimentDAOImpl.addProduct(product.getName(), product.getPrice(),
					product.isEnabled());
	}	
	
	public Integer editProduct(Product product) {
		if (product.getClass().getName().equals("com.quyvd.model.Coffee")) {
			return coffeeDAOImpl.editProduct(product);
		} else
			return condimentDAOImpl.editProduct(product);
	}
	
	public String getCoffeeNameById (int coffeeId) {
		String name = coffeeDAOImpl.getNameById(coffeeId);
		return name;
	}

	public List<Coffee> listAllCoffee() {
		List<Product> listProduct = coffeeDAOImpl.listAll();
		List<Coffee> listCoffee = new ArrayList<Coffee>();
		for (Product p : listProduct) {
			listCoffee.add((Coffee) p);
		}
		return listCoffee;
	}

	public List<Coffee> listAvailableCoffee() {
		List<Product> listProduct = coffeeDAOImpl.listAvailable();
		List<Coffee> listCoffee = new ArrayList<Coffee>();
		for (Product p : listProduct) {
			listCoffee.add((Coffee) p);
		}
		return listCoffee;
	}

	public List<Condiment> listAllCondiment() {
		List<Product> listProduct = condimentDAOImpl.listAll();
		List<Condiment> listCondiment = new ArrayList<Condiment>();
		for (Product p : listProduct) {
			listCondiment.add((Condiment) p);
		}
		return listCondiment;
	}

	public List<Condiment> listAvailableCondiment() {
		List<Product> listProduct = condimentDAOImpl.listAvailable();
		List<Condiment> listCondiment = new ArrayList<Condiment>();
		for (Product p : listProduct) {
			listCondiment.add((Condiment) p);
		}
		return listCondiment;
	}
}
