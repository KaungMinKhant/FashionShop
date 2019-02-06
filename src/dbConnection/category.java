package dbConnection;

import java.sql.*;

public class category {
	private Connection con;
	private Statement st;
	public category() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fashion_shop","root","");
			st = con.createStatement();
			System.out.println("Database Connection Starting");
		}
		catch(Exception ex){
			System.out.println("Error Expected " + ex + "!!!");
		}
	}
	public void insertData(String name) {
		try {
			String insertedData = "INSERT INTO category(category_id, category_name) VALUES (0, '"+ name +"')";
			st.execute(insertedData);
			System.out.println("Category " + name + " is added.");
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
	public ResultSet showData() {
		ResultSet rs = null;
		try {
			String shownData = "SELECT * FROM category";
			st.execute(shownData);
			rs = st.executeQuery(shownData);
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return rs;
	}
	public void editData(String id, String name) {
		try {
			String updatedData = "UPDATE category SET category_name = '"+ name + "' WHERE category_id = '"+ id + "'";
			st.execute(updatedData);
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
	public void deleteData(String category_id) {
		try {
			String deletedData = "DELETE FROM category WHERE category_id = '"+ category_id + "'";
			st.execute(deletedData);
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
}
