package com.revature.moneytracker.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.moneytracker.model.Product;
import com.revature.moneytracker.model.User;
import com.revature.moneytracker.util.JDBCutility;

public class UserDao {
	
	
	//authentication method
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
	
	//insert user method
	public void insertUser(String fullname, String role, String email, String username, String password) {
		
		try (Connection connection = JDBCutility.getConnection()) {
			
			connection.setAutoCommit(false);
			
			String sqlQuery = "INSERT INTO users "
					+ "(name, role, email, username, password) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, fullname);
			pstmt.setString(2, role);
			pstmt.setString(3, email);
			pstmt.setString(4, username);
			pstmt.setString(5, password);
			
			if (pstmt.executeUpdate() != 1) {
				throw new SQLException("Inserting failed");
			}
			
			connection.commit();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
