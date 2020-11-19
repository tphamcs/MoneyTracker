package com.revature.moneytracker.model;


public class Product {
	
	private int id;
	private String author;
	private String title;
	private String category;
	private String date;
	private Double amount;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(int id, String author, String title, String category, String date, Double amount) {
		super();
		this.id = id;
		this.author = author;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
}
