package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.DatabaseMetaData;

public class DatabaseDetails {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/shopping?useSSL=false";
		String username = "root";
		String password = "albany123";
		Connection connect = DriverManager.getConnection(url, username, password);
		System.out.println("connected");
		
		DatabaseMetaData db = connect.getMetaData();
		int dbmajver = db.getDatabaseMajorVersion();
		int dbminver = db.getDatabaseMinorVersion();
		int drmajver = db.getDriverMajorVersion();
		int drminver = db.getDriverMinorVersion();
		String drver = db.getDriverVersion(); //String
		String drname = db.getDriverName();
		System.out.println("Database Major Version: " + dbmajver + "\n" + " Database Minor Version: " + dbminver + "\n" +
						" Driver Major Version: " + drmajver +"\n" + " Driver Minor Version: " + drminver + "\n" + 
						" Driver Version: " + drver + "\n" + " Driver Name: " + drname);
		}

}
