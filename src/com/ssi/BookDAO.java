package com.ssi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

	private Connection con;

	public void deleteBook(int code){
		try{
			String sql = "delete from books where bcode=?";
			PreparedStatement st =con.prepareStatement(sql);
			st.setInt(1,code);
			st.executeUpdate();
			
		}
		catch(Exception e){
			
		}
		                   
		
	}
	public void saveBook(Book book) {
		try {
			String sql = "insert into books values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, book.getCode());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getSubject());
			ps.setInt(5, book.getPrice());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Book searchBook(int code) {
		Book book = null;
		String sql = "SELECT * FROM books WHERE bcode=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, code);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				book = new Book();
				book.setCode(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setSubject(rs.getString(4));
				book.setPrice(rs.getInt(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return book;
	}

	public List<Book> getAllBooks() {
		ArrayList<Book> al = new ArrayList();
		String sql  = "select * from books";
		return null;
	}

	public BookDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/booksdata", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
