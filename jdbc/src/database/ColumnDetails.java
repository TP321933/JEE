package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.sql.*;

public class ColumnDetails {
	
	public static void main(String args[]) throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/shopping?useSSL=false";
		String username = "root";
		String password = "albany123";
		//String host = "Local instance MySQL80";
		Connection connect = DriverManager.getConnection(url, username, password);
		System.out.println("connected");
		
		Statement stat = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stat.executeQuery("SELECT * FROM book");
		
		ResultSetMetaData col = rs.getMetaData();
		int colcount = col.getColumnCount();
		System.out.println(colcount);
		for(int i=1; i<=colcount; i++) {
			
			String colnum = col.getColumnLabel(i);
			System.out.println(colnum);
			String name = col.getColumnName(i);
			String type = col.getColumnTypeName(i);
			int width = col.getColumnDisplaySize(i);
			System.out.println("COLUMN NAME: " + name + " COLUMN TYPE: " + type + " COLUMN WIDTH: " + width);
		}
		
		connect.close();
		
		/*ResultSet rst = col.getColumns(null,null, "book", null);
		
		if(rs!=null) {
			while(rst.next()) {
				String name = rs.getString("COLUMN_NAME");
			    String type = rs.getString("TYPE_NAME");
			    int size = rs.getInt("COLUMN_SIZE");
			    System.out.println(name + type + size);
			}
		}*/
		
		
	}

}
