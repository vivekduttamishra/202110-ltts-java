package testapp21.io;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Author implements Serializable{

	String name;
	String biography;
	List<Book> books=new ArrayList<Book>();
	
	
	public Author(String name, String biography) {
		super();
		this.name = name;
		this.biography = biography;
	}

	public Book createBook(String title, int price) {
		var book=new Book(title,this,price);
		books.add(book);
		return book;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public List<Book> getBooks() {
		return books;
	}

}
