package dbConnection;

import java.sql.*;

public class dbConnect {
	private Connection con;
	private Statement st;
	
	public dbConnect(){
		try {
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fashion_shop", "root","");
			st = con.createStatement();
		}
		catch(Exception ex){
			System.out.println("Error Expected");
		}
	}
}
