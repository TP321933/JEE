package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertQuery {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/shopping?useSSL=false";
		String username = "root";
		String password = "albany123";
		//String host = "Local instance MySQL80";
		Connection connect = DriverManager.getConnection(url, username, password);
		System.out.println("connected");
		
		Statement stat = connect.createStatement();

		String col = "INSERT INTO book " +
					"VALUES (001, 'Charlottes Web', 'Kids', 'E.B.White')";
		stat.executeUpdate(col);
		
		col = "INSERT INTO book " +
				"VALUES (002, '2 States', 'Romance', 'Chetan Bhagat')";
		stat.executeUpdate(col);
		
		col = "INSERT INTO book " +
				"VALUES (003, 'The Girl on the Train', 'Thriller', 'Paula Hawkins')";
		stat.executeUpdate(col);
		
		System.out.println("Inserted data into Book table");
		connect.close();
		

	}

}
