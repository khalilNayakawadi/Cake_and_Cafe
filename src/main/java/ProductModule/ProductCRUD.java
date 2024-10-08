package ProductModule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import ConnectionModule.MyDbConnection;

public class ProductCRUD {
	List<ProductDetails>productList = new ArrayList<ProductDetails>();
	public List<ProductDetails> getProducts() throws ClassNotFoundException, SQLException {
		Connection connection = MyDbConnection.getDbConnection();
		
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
	
	public List<ProductDetails>filterByCatagory(String catagory){
		for (ProductDetails productDetails : productList) {
			if(productDetails.getProductCatagory().equals(catagory)) {
				productList.add(productDetails);
			}
			
		}
		return productList;
	}

}
