package dbConnection;

import java.sql.*;

public class type {
	private Statement st;
	private Connection con;
	private ResultSet rs;
	public type() {
		try {
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fashion_shop", "root","");
			st = con.createStatement();
			System.out.println("Database connection starting");
		}
		catch(Exception ex) {
			System.out.println("Error Expected");
			System.out.println(ex);
		}
	}
	public void insertData(String name) {
		try {
			String insertquery = "INSERT INTO type(type_id, type_name) VALUES (0, '"+ name +"')";
			st.execute(insertquery);
			System.out.println("Type Name " + name + " is added");
		}
		catch(Exception ex) {
			System.out.println("Error Expected");
			System.out.println(ex);
		}
	}
	public ResultSet showType() {
		ResultSet rs = null;
		try {
			String result = "SELECT * FROM type";
			st.execute(result);
			rs = st.executeQuery(result);
		}
		catch(Exception e) {
			System.out.println(e + "has been detected. fuck you check your code");
		}
		return rs;
	}
	public void updateData(String type_id, String type_name) {
		try {
			
			String updatedData = "UPDATE type SET type_name = '" + type_name +"' WHERE type_id = '"+ type_id +"'";
			st.execute(updatedData);
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
	public void deleteData(String type_id) {
		try {
			String deletedData = "DELETE FROM type WHERE type_id = '"+ type_id + "'";
			st.execute(deletedData);
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
}
