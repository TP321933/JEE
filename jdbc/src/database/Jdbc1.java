package database;

import java.sql.*;


public class Jdbc1 {
	
	public static void main(String args[]) throws Exception{
		
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/shopping";
		String username = "root";
		String password = "albany123";
		//String host = "Local instance MySQL80";
		Connection connect = DriverManager.getConnection(url, username, password);
		System.out.println("connected");
		
		Statement stat = connect.createStatement();
		
		String tab = "CREATE TABLE book " + 
					"(book_Id INTEGER not NULL, " +
					"book_name VARCHAR(45) not NULL, " +
					"book_type VARCHAR(45), " +
					"author VARCHAR(45), " +
					" PRIMARY KEY (book_Id))";
		
		stat.executeUpdate(tab);
		connect.close();
		
	    DatabaseMetaData dbm = connect.getMetaData();
	    ResultSet rs = dbm.getTables(null, null, "book", null);
	    if (rs.next()) {
	      System.out.println("Table exists"); 
	    } else {
	      System.out.println("Table does not exist"); 
	    }
	    
	    //System.out.println(dbm.getSchemas());*/
		
		
	}

}
