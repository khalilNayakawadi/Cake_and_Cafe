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
	
	
	<div class="formdiv">
		<form action="filter" method="post">
			<div class="filteroptions">
				<h5>Search by Name</h5>
				<input type="text" placeholder="Product" name="productname">
			</div>
			<div class="filteroptions">
				<h5>Select Category</h5>
				<select name="catagory">
				<option>...</option>
				<option value="Cake" >Cake</option>
				<option value="Drink">Drink</option>
				<option value="Meal" >Meal</option>
			</select>
			</div>
			<div class="filteroptions">
				<h5>Enter Price Range</h5>
				<input type="text" placeholder="Minimum" name="minprice"><span> To</span>
				<input type="text" placeholder="Maximum" name="maxprice">
			</div>
			<div class="filteroptions submitbtn">
				<input type="submit" value="Filter" name="productname" id="submitbtn">
			</div>
		</form>
		<br>
	</div>
	
	
    <h3 align="center" class="productheading"> Our Best Products</h3>
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
