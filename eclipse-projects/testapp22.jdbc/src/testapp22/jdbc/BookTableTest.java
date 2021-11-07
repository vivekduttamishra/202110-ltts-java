package testapp22.jdbc;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTableTest {

	String url="jdbc:mysql://localhost:3306/booksdb";
	String username="training";
	String password="training";
	Connection connection=null;
	
	@BeforeEach
	void setUp() throws Exception {
		connection=DriverManager.getConnection(url,username,password);
		var statement=connection.createStatement();
		statement.executeUpdate(String.format("insert into booktest values('%s','%s','%s',%d,%f)","1111", "The Accursed God","Vivek Dutta Mishra",300,4.1));
		statement.executeUpdate(String.format("insert into booktest values('%s','%s','%s','%d','%f')","2222", "Kane and Abel","Jeffrey Archer",200,4.1));
		statement.executeUpdate(String.format("insert into booktest values('%s','%s','%s','%d','%f')","3333", "The Count of Monte Cristo","Alexandre Dumas",300,4.1));
		
	}
	
	@AfterEach
	public void clean() throws Exception {
		var statement= connection.createStatement();
		statement.executeUpdate("delete from booktest where isbn='1111'");
		statement.executeUpdate("delete from booktest where isbn='2222'");
		statement.executeUpdate("delete from booktest where isbn='3333'");
		connection.close();
	}

	@Test
	void connectionWorksWithRightCredential() throws SQLException {
		
		assertNotNull(connection);
	}
	
	@Test()
	void connectionFailsWithWrongCredential() throws SQLException {
		
		assertThrows(SQLException.class, ()->{
			var connection= DriverManager.getConnection(url,username,"wrong-password");
		});
	}
	
	@Test
	public void canFetchAllDataFromTable() throws SQLException{
		
		
		var statement= connection.createStatement();
		
		var results= statement.executeQuery("select * from booktest");
		
		var books=new ArrayList<Book>();
		var builder=new BookBuilder();
		
		while(results.next()) {
			
			var book= builder.build(results);
			
			books.add(book);
			
		}
		
		
		assertEquals(3, books.size());
		
		assertEquals("The Accursed God", books.get(0).getTitle());
		
	}

	
	@Test
	public void failsToFetchRecordWithWrongIsbn() throws SQLException {
		
		var statement=connection.createStatement();
		var results= statement.executeQuery("select * from booktest where isbn='invalid'");
		
		assertFalse(results.next());
		
		
	}

	
	@Test
	public void canFetchOneRecordWithRightIsbn() throws SQLException {
		
		var statement=connection.createStatement();
		var results= statement.executeQuery("select * from booktest where isbn='1111'");
		
		assertTrue(results.next());
		
		BookBuilder builder=new BookBuilder();
		var book=builder.build(results);
		assertEquals("The Accursed God", book.getTitle());
		
		
	}

}
