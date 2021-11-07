package testapp22.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookBuilder {

	public Book build(ResultSet rs) throws SQLException {
		var book=new Book();
		
		book.setIsbn(rs.getString("isbn"));
		book.setTitle(rs.getString("title"));
		book.setAuthor(rs.getString("author"));
		book.setPrice(rs.getInt("price"));
		book.setRating(rs.getDouble("rating"));
		
		return book;
	}
}
