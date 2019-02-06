package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class item {
	private Statement st;
	private Connection con;
	private ResultSet rs;
	public item() {
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
	public ResultSet insertData(String name, String price, String stock, String brand, String category, String type) {
		try {
			
			
			String brand_id = "SELECT brand_id FROM brand WHERE brand_name = '"+ brand +"'";
			ResultSet bid = st.executeQuery(brand_id);
			String realbid = "";
			while(bid.next()) {
				realbid = bid.getString("brand_id");
			}
			
			
			
			String category_id = "SELECT category_id FROM category WHERE category_name = '"+ category + "'";
			ResultSet cid = st.executeQuery(category_id);
			String realcid = "";
			while(cid.next()) {
				realcid = cid.getString("category_id");
			}
			
			String type_id = "SELECT type_id FROM type WHERE type_name = '"+ type +"'";
			ResultSet tid = st.executeQuery(type_id);
			String realtid = "";
			while(tid.next()) {
				realtid = tid.getString("type_id");
			}
			
			
			
			String insertquery = "INSERT INTO items(item_name, item_price, item_stock, brand_id, category_id, type_id) VALUES('"+ name +"','"+ price +"', '"+ stock +"', '"+ realbid +"', '"+ realcid +"', '"+ realtid +"')";
			st.execute(insertquery);
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return rs;
	}
	public ResultSet getBrand() {
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
	public ResultSet getCategory() {
		ResultSet rs = null;	
		try {
			String result = "SELECT * FROM category";
			st.execute(result);
			rs = st.executeQuery(result);
		}
		catch(Exception e) {
			System.out.println(e + "has been detected. fuck you check your code");
		}
		return rs;
	}
	public ResultSet getType() {
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
	public ResultSet showData() {
		ResultSet rs = null;
		try {
			String result_array = "SELECT * FROM items";
			st.execute(result_array);
			rs = st.executeQuery(result_array);
		}
		catch(Exception ex) {
			
		}
		return rs;
		
	}
	public ResultSet search(String search_key) {
		ResultSet rs = null;
		try {
			String search_array = "SELECT * FROM items WHERE item_name LIKE '"+ search_key +"'";
			st.execute(search_array);
			rs = st.executeQuery(search_array);
		}
		catch(Exception ex) {
			
		}
		return rs;
		
	}
}
