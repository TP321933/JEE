package database;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class UpdatePrepStatement{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/shopping?useSSL=false";
		String username = "root";
		String password = "albany123";
		//String host = "Local instance MySQL80";
		Connection connect = DriverManager.getConnection(url, username, password);
		System.out.println("connected");
		
		//Statement stat = connect.createStatement();
		String data = "UPDATE book SET book_name=?, book_type=? WHERE book_Id=?";
		
		PreparedStatement prep = connect.prepareStatement(data);
		prep.setString(1, "twostates");
		prep.setString(2, "Fiction-Romance");
		prep.setInt(3, 2);
		prep.executeUpdate();
		
		System.out.println("Record updated");
		prep.close();


	}

}
