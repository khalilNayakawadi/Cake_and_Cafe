package ProductModule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import ConnectionModule.MyDbConnection;

public class ProductCRUD {
	
	public List<ProductDetails> getProducts() throws ClassNotFoundException, SQLException {
		Connection connection = MyDbConnection.getDbConnection();
		List<ProductDetails>productList = new ArrayList<ProductDetails>();
		String query = "select * from products";
		 Statement stmt = connection.createStatement();
		 ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			ProductDetails pd = new ProductDetails();
			pd.setProductName(rs.getNString("name"));
			pd.setProductCatagory(rs.getString("category"));
			pd.setProductPrice(rs.getFloat("price"));
			pd.setDescription(rs.getNString("description"));
			pd.setStock(rs.getInt("stock"));
			pd.setImage(rs.getNString("image"));
			productList.add(pd);
		
		}
		connection.close();
		rs.close();
		return productList;
	}
	
	public List<ProductDetails> filterProducts(String name, String category, int minprice, int maxprice) throws ClassNotFoundException, SQLException {
	    String query = null;
	    Connection connection = MyDbConnection.getDbConnection();
	    List<ProductDetails> productList = new ArrayList<ProductDetails>();
	    PreparedStatement stmt = null;

	    if (name != null && category != null && minprice >= 0 && maxprice > 0) {
	        query = "SELECT * FROM products WHERE name = ? AND category = ? AND price BETWEEN ? AND ?";
	        stmt = connection.prepareStatement(query);
	        stmt.setString(1, name);
	        stmt.setString(2, category);
	        stmt.setInt(3, minprice);
	        stmt.setInt(4, maxprice);
	    } else if (name != null && category != null && minprice == 0 && maxprice == 0) {
	        query = "SELECT * FROM products WHERE name = ? AND category = ?";
	        stmt = connection.prepareStatement(query);
	        stmt.setString(1, name);
	        stmt.setString(2, category);
	    } else if (name != null && category == null && minprice == 0 && maxprice == 0) {
	        query = "SELECT * FROM products WHERE name = ?";
	        stmt = connection.prepareStatement(query);
	        stmt.setString(1, name);
	    }

	    if (stmt != null) {
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            ProductDetails pd = new ProductDetails();
	            pd.setProductName(rs.getNString("name"));
	            pd.setProductCatagory(rs.getString("category"));
	            pd.setProductPrice(rs.getFloat("price"));
	            pd.setDescription(rs.getNString("description"));
	            pd.setStock(rs.getInt("stock"));
	            pd.setImage(rs.getNString("image"));
	            productList.add(pd);
	        }
	        rs.close();
	    }

	    connection.close();
	    return productList;
	}

}
