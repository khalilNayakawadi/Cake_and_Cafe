package ProductModule;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/filter")
public class ProductController extends HttpServlet {
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String productName = req.getParameter("productname");
			System.out.println("productname : "+ productName);
			String category = req.getParameter("category");
			   int minPrice = 0; // Default value
		        String minPriceStr = req.getParameter("minprice");
		        if (minPriceStr != null && !minPriceStr.isEmpty()) {
		            try {
		                minPrice = Integer.parseInt(minPriceStr);
		            } catch (NumberFormatException e) {
		                System.out.println("Invalid minprice: " + minPriceStr);
		            }
		        }
		        System.out.println("minprice : " + minPrice);

		        int maxPrice = 0; // Default value
		        String maxPriceStr = req.getParameter("maxprice");
		        if (maxPriceStr != null && !maxPriceStr.isEmpty()) {
		            try {
		                maxPrice = Integer.parseInt(maxPriceStr);
		            } catch (NumberFormatException e) {
		                System.out.println("Invalid maxprice: " + maxPriceStr);
		            }
		        
			
			ProductCRUD pc = new ProductCRUD();
			
			try {
				 	List<ProductDetails>filteredProducts = new ArrayList<ProductDetails>();
				 	filteredProducts = pc.filterProducts(productName, category, minPrice, maxPrice);
				RequestDispatcher rd =req.getRequestDispatcher("Home.jsp");
				req.setAttribute("filterProducts", filteredProducts);
				rd.include(req, resp);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}}
