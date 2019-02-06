package dbConnection;

import java.sql.*;

public class brandDB {
	private Statement st;
	private Connection con;
	private ResultSet rs;
	public brandDB() {
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
			String insertquery = "INSERT INTO brand(brand_id, brand_name) VALUES (0, '"+ name +"')";
			st.execute(insertquery);
			System.out.println("Brand Name " + name + " is added");
		}
		catch(Exception ex) {
			System.out.println("Error Expected");
			System.out.println(ex);
		}
	}
	public ResultSet showBrand() {
		ResultSet rs = null;	
		try {
			String result = "SELECT * FROM brand";
			st.execute(result);
			rs = st.executeQuery(result);
		}
		catch(Exception e) {
			System.out.println(e + "has been detected. fuck you check your code");
		}
		return rs;
	}
	public void updateData(String brand_id, String brand_name) {
		try {
			int bid = Integer.parseInt(brand_id);
			System.out.println(bid);
			System.out.println(brand_name);
			String updatedData = "UPDATE brand SET brand_name = '" + brand_name +"' WHERE brand_id = '"+ brand_id +"'";
			st.execute(updatedData);
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
	public void deleteData(String brand_id) {
		try {
			String deletedData = "DELETE FROM brand WHERE brand_id = '"+ brand_id + "'";
			st.execute(deletedData);
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
}
