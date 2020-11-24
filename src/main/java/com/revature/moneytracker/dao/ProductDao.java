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

	//all product of each user based on uid
	public ArrayList<Product> getAllProduct(int uid) {
		
		//ArrayList holding Product object	
		ArrayList<Product> productList = new ArrayList<Product>();

		try (Connection connection = JDBCutility.getConnection()) {
			
			String sqlQuery = "SELECT * FROM product p WHERE p.authorid = ?";
			
			PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setInt(1, uid);
			ResultSet rs = pstmt.executeQuery();
			

			while (rs.next()) {
				
				//getting all the value for each row of Product table
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String category = rs.getString(3);
				String date = rs.getString(4);
				int amount = rs.getInt(5);
				int authorID = rs.getInt(6);
				
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
	public Product insertProduct(int authorID, String title, String category, String date, int amount) 
	{
		try (Connection connection = JDBCutility.getConnection()) {
			
			connection.setAutoCommit(false);
			
			String sqlQuery = "INSERT INTO product "
					+ "(authorid, title, category, date, amount) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setInt(1, authorID);
			pstmt.setString(2, title);
			pstmt.setString(3, category);
			pstmt.setString(4, date);
			pstmt.setInt(5, amount);
			
			if (pstmt.executeUpdate() != 1) {
				throw new SQLException("Inserting failed");
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
	public void deleteProduct(int pid) {
		
		try (Connection connection = JDBCutility.getConnection()) {
			
			connection.setAutoCommit(false);

			String sqlQuery = "DELETE from product p where p.id = ?";
			
			PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
			
			pstmt.setInt(1, pid);

			
			if (pstmt.executeUpdate() != 1) {
				throw new SQLException("Delete failed");
			}
					
			
			System.out.println("Delete sucessfully!");
			
			connection.commit();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * @return Pirate or null
	 */
	public Product updateProduct() {
		return null;
		
	}

}
