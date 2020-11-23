package com.revature.moneytracker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.moneytracker.model.Product;
import com.revature.moneytracker.model.User;
import com.revature.moneytracker.util.JDBCutility;

public class ProductDao {

	public ProductDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	//function get all product of each user
	public ArrayList<Product> getAllProduct(User user) {
		
		String sqlQuery = "SELECT * "
				+ "FROM product p "
				+ "INNER JOIN users u "
				+ "ON p.authorid = u.id";
		
		ArrayList<Product> productList = new ArrayList<Product>();
		
		try (Connection connection = JDBCutility.getConnection()) {
			
			// Simple Statement, not to be confused Prepared Statement
			Statement stmt = connection.createStatement(); 
			ResultSet rs = stmt.executeQuery(sqlQuery);
			
			
			while (rs.next()) {
				//getting all the value for each row of Product table
				int id = rs.getInt(1);
				int authorID = rs.getInt(2);
				String title = rs.getString(3);
				String category = rs.getString(4);
				String date = rs.getString(5);
				double amount = rs.getDouble(6);
				//creating product object
				Product product = new Product(id, authorID, title, category, date, amount);
				//adding each object to the List
				productList.add(product);
			}
			
			return productList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productList;
	}
	
	/**
	 * @return Pirate or null
	 */
	public Product insertProduct(int authorID, String title, String category, String date, double amount) 
	{
		try (Connection connection = JDBCutility.getConnection()) {
			
			connection.setAutoCommit(false);
			
			String sqlQuery = "INSERT INTO product "
					+ "(authorID, title, category, date, amount) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setInt(1, authorID);
			pstmt.setString(2, title);
			pstmt.setString(3, category);
			pstmt.setString(4, date);
			pstmt.setDouble(5, amount);
			
			if (pstmt.executeUpdate() != 1) {
				throw new SQLException("Inserting pirate failed, no rows were affected");
			}
			
			int autoId = 0;
			ResultSet generatedKeys = pstmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				autoId = generatedKeys.getInt(1);
			} else {
				throw new SQLException("Inserting pirate failed, no ID generated");
			}
			
			connection.commit();
			
			return new Product(authorID, title, category, date, amount);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}


	/**
	 * @return Pirate or null
	 */
	public Product deleteProduct() {
		return null;
		
	}
	
	/**
	 * @return Pirate or null
	 */
	public Product updateProduct() {
		return null;
		
	}

}
