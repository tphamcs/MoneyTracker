package com.revature.moneytracker.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.moneytracker.model.User;
import com.revature.moneytracker.util.JDBCutility;

public class UserDao {
	
	public User checkLogin(String username, String password) throws SQLException {
		
		Connection connection = JDBCutility.getConnection();
		
		String sql = "SELECT * FROM users WHERE username = ? and password = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, username);
		statement.setString(2, password);
		
		//result hold database value, not user object
		ResultSet result = statement.executeQuery();

		
		User user = null;
		
		if (result.next()) {
		    user = new User();
		    //mapping result to user object
		    user.setId(result.getInt("id"));
		    user.setName(result.getString("name"));
		    user.setRole(result.getString("role"));
		}
		
		connection.close();
		
		return user;
	}
	
}
