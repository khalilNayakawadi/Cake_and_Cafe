<%@page import="ProductModule.ProductCRUD"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ProductModule.ProductDetails"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Home.css">
<title>Home</title>
</head>
<body>
	<div class="navbar">
			<img alt="" src="logo.png" height="70px" id="logo">
			
		<ul>
			<li><a href="Home.jsp">Home</a></li>
			<li><a href="#">Products</a></li>
			<li><a href="#">Cart</a></li>
			<li><a href="#">About</a></li>
			<li><a href="Login.jsp">Logout</a></li>
		</ul>
	</div>
	<div class="poster">
	</div>
    <h3 align="center"> Our Best Products</h3>
    <%
        List<ProductDetails> productList = (List<ProductDetails>) request.getAttribute("products");
        if (productList != null && !productList.isEmpty()) {
            for (ProductDetails pd : productList) {
    %>
    			
                <div class="products">
                    <a href="https://www.google.com"><img src="<%= pd.getImage() %>" alt="<%= pd.getProductName() %>" class ="images"/></a>
                    <h4> <%= pd.getProductName() %></h4>
                    <div class="prinfo">
                    <ul type="none">
                    <li>Category: <%= pd.getProductCatagory() %></li>
                    <li>Price: <span id="price"><%= pd.getProductPrice() %></span>  &#8377;</li>
                    <li>Description: <%= pd.getDescription() %></li>
                    <li>Stock: <%= pd.getStock() %></li>
                    </ul>
                    </div>
                </div>
    <%
            }
        } else {
        	ProductCRUD pc = new ProductCRUD();
        	productList = pc.getProducts();
        	 if (productList != null && !productList.isEmpty()) {
             for (ProductDetails pd : productList) {
    %>
             <div class="products">
                    <a href="https://www.google.com"><img src="<%= pd.getImage() %>" alt="<%= pd.getProductName() %>" class ="images"/></a>
                    <h4> <%= pd.getProductName() %></h4>
                    <div class="prinfo">
                    <ul type="none">
                    <li>Category: <%= pd.getProductCatagory() %></li>
                    <li>Price: <span id="price"><%= pd.getProductPrice() %></span>  &#8377;</li>
                    <li>Description: <%= pd.getDescription() %></li>
                    <li>Stock: <%= pd.getStock() %></li>
                    </ul>
                    </div>
                </div>
    <%
        }
     }
  }
    %>
</body>
</html>
