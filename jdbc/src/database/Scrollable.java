package database;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Scrollable {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/shopping?useSSL=false";
		String username = "root";
		String password = "albany123";
		//String host = "Local instance MySQL80";
		Connection connect = DriverManager.getConnection(url, username, password);
		System.out.println("connected");
		
		Statement stat = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stat.executeQuery("SELECT * FROM book");
		System.out.println(rs);
		
		int count = 0;
		/*if(rs!=null) {
			
			if(rs.getRow()%2 == 0) {
				rs.next();
			}
			else {
				System.out.println(rs.getInt(1) + "-->" + rs.getString(2) + "-->" + 
						rs.getString(3) + "-->" +rs.getString(4));
			}
			
			count++;
		}*/
		
		if(rs!=null) {
			while(rs.next()) {
	            int id = rs.getInt("book_id");
	            String name = rs.getString("book_name");
	            String type = rs.getString("book_type");
	            String author = rs.getString("author");
	            //print alternate rows
	            if(rs.getRow()%2 == 0) {
	            	rs.next();
	            }
	            else {
	            	System.out.println(id+"   "+name+"    "+type+" "+author);
	            	rs.next();
	            }
	            count++;	            
			}
		}
		
		

	}

}
