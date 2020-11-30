package com.revature.moneytracker.service;

import java.util.ArrayList;

import com.revature.moneytracker.dao.UserDao;
import com.revature.moneytracker.model.User;

public class UserService {

	private UserDao userDao;
	
	public UserService() {
		this.userDao = new UserDao();
	}
	
	//need more extra condition for validate in the future
//	public ArrayList<User> getAllUser(int uid) {
//
//		return userDao.getAllUser(uid);
//	}
	
	public void insertUser(String fullname, String role, String email, String username, String password) {

		//calling insert method from productDao
		userDao.insertUser(fullname, role, email, username, password);
	}
	

	
	
}
