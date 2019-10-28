package database;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class PrepStatement {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/shopping?useSSL=false";
		String username = "root";
		String password = "albany123";
		//String host = "Local instance MySQL80";
		Connection connect = DriverManager.getConnection(url, username, password);
		System.out.println("connected");
		
		//Statement stat = connect.createStatement();
		String data = "INSERT INTO book(book_Id, book_name, book_type, author) VALUES (?,?,?,?)";
		
		PreparedStatement prep = connect.prepareStatement(data);
		prep.setInt(1, 004);
		prep.setString(2, "The Hobbit");
		prep.setString(3, "Fantasy");
		prep.setString(4, "J.R.R.Tolklen");
		prep.executeUpdate();

	}

}
