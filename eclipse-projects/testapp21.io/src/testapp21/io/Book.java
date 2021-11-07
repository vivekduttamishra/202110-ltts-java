package testapp21.io;

import java.io.Serializable;

public class Book implements Serializable{

	private String title;
	private Author author;
	private int price;

	public Book(String title, Author author, int price) {
		// TODO Auto-generated constructor stub
		this.title=title;
		this.author=author;
		this.price=price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
