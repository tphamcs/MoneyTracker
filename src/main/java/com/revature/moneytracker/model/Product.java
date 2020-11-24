package com.revature.moneytracker.model;


public class Product {
	
	private int id;
	private int authorID;
	private String title;
	private String category;
	private String date;
	private int amount;
	
	public Product() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Product(int authorID, String title, String category, String date, int amount) {
		this.authorID = authorID;
		this.title = title;
		this.category = category;
		this.date = date;
		this.amount = amount;
	}
	
	public Product(int id, int authorID, String title, String category, String date, int amount) {
		this.id = id;
		this.authorID = authorID;
		this.title = title;
		this.category = category;
		this.date = date;
		this.amount = amount;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
