package com.sddo.dv1c02.cw1.dto;

public class Book {

	private String bookID;
	private String title;
	private String author;
	private String ISBN;
	private float price;
	private String category;
	
	
	/**
	 * @param bookID
	 * @param title
	 * @param author
	 * @param iSBN
	 * @param price
	 * @param category
	 */
	public Book(String bookID, String title, String author, String iSBN, float price, String category) {
		super();
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		ISBN = iSBN;
		this.price = price;
		this.category = category;
	}
	
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}