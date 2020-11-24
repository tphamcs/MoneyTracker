package com.revature.moneytracker.service;

import java.util.ArrayList;

import com.revature.moneytracker.dao.ProductDao;
import com.revature.moneytracker.model.Product;
import com.revature.moneytracker.model.User;


//This Service class will contain extra business logic to the methods from productDAO class
public class ProductService {
	
	private ProductDao productDao;
	
	public ProductService() {
		this.productDao = new ProductDao();
	}
	
	//need more extra condition for validate in the future
	public ArrayList<Product> getAllProduct(int uid) {

		return productDao.getAllProduct(uid);
	}
	
	public Product insertProduct(int authorID, String title, String category, String date, int amount) {

		//calling insert method from productDao
		return productDao.insertProduct(authorID, title, category, date, amount);
	}
	
	public void deleteProduct(int pid) {

		//calling delete method from productDao
		productDao.deleteProduct(pid);

	}
}
