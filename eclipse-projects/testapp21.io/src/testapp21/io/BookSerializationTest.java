package testapp21.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookSerializationTest {

	Author author1,author2;
	Book book1,book2,book3,book4;
	ArrayList<Book> books;
	String path="D:\\MyWorks\\Corporate\\202110-ltts-java\\books-test.txt";
	File file;
	
	@BeforeEach
	void setUp() throws Exception {
		
		author1=new Author("Vivek Dutta Mishra", "Author of the Lost Epic Series");
		author2= new Author("Jeffrey Archer","Contemporary Best seller");
		
		book1=author1.createBook("The Accursed God", 399);
		book2=author2.createBook("Kane and Abel", 400);
		book3=author2.createBook("Sons of Forutne", 300);
		
		books=new ArrayList<Book>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		file=new File(path);
		
		
	}
	
	@AfterEach
	public void clean() {
		
		if(file.exists())
			file.delete();
		
	}

	@Test
	void canSerializeBooks() throws IOException {
		save();
		assertTrue( file.exists());
		assertTrue(file.length()>0);	
		
	}

	private void save() throws FileNotFoundException, IOException {
		var fileStream= new FileOutputStream(path);
		var serializer= new ObjectOutputStream(fileStream);
		serializer.writeObject(books);
		serializer.close();
		fileStream.close();
		System.out.println("file saved "+file.length()+" bytes");
	}
	
	@Test
	public void canDeserializeBooks() throws IOException, ClassNotFoundException{
		
		save();
		
		var fileStream=new FileInputStream(file);
		var serializer=new ObjectInputStream(fileStream);
		
		var result=(ArrayList<Book>) serializer.readObject();
		
		serializer.close();
		fileStream.close();
		
		assertEquals(3, result.size());
		assertEquals("The Accursed God", result.get(0).getTitle());
		assertEquals("Vivek Dutta Mishra", result.get(0).getAuthor().getName());
		
	}

}









