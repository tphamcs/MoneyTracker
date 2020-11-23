package com.revature.moneytracker.service;

import java.util.ArrayList;

import com.revature.moneytracker.dao.ProductDao;
import com.revature.moneytracker.model.Product;


//This Service class will contain extra business logic to the methods from productDAO class
public class ProductService {
	
	private ProductDao productDao;
	
	public ProductService() {
		this.productDao = new ProductDao();
	}
	
	
	public ArrayList<Product> getAllProduct() {
		
		//calling getAllProduct method from productDao
		return productDao.getAllProduct();
	}
	
	public Product insertProduct(int authorID, String title, String category, String date, double amount) {
		
		//calling insert method from productDao
		return productDao.insertProduct(authorID, title, category, date, amount);
	}
}
