package com.revature.moneytracker;

import java.sql.SQLException;

import com.revature.moneytracker.util.JDBCutility;

public class MoneyTracker {
	
	public static void main(String[] args) {
		
		try {
			
			System.out.println(JDBCutility.getConnection());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
