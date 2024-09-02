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
	<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<%
		List<ProductDetails> productList = new ArrayList<ProductDetails>();
		ProductCRUD pc = new ProductCRUD();
%>
<body>
	<div class="navbar">
			<img alt="" src="logo.png" height="70px" id="logo">
		<ul>
			<%--<li><a href="#"id = "mode">&#127769;</a></li> --%>
			<li><a href="Home.jsp" title="Home">&#127968;</a></li>
			<li><a href="#" title="Products">&#128230;</a></li>
			<li><a href="#" title="Cart">&#128722;</a></li>
			<li><a href="#" title="About">&#128195;</a></li>
			<li><a href="Login.jsp" title ="Logout">&#128100;</a></li>
		</ul>
	</div>
	
	<div class="poster">
	</div>
	
	
	<div class="formdiv" id = "formDiv" >
		<form action="filter" method="post" >
			<div class="filteroptions">
				<h5>Search by Name</h5>
				<input type="text" placeholder="Product" name="productname" onkeypress="">
			</div>
			<div class="filteroptions">
				<h5>Select Category</h5>
				<select name="category">
				<option>...</option>
				<option value="Cake">Cake</option>
				<option value="Drink">Drink</option>
				<option value="Meal">Meal</option>
			</select>
			</div>
			<div class="filteroptions">
				<h5>Search by price</h5>
				<select name="category">
				<option>...</option>
				<option value="min" >Minimum - Maximum</option>
				<option value="max">Maximum - Minimum</option>
			</select>
			</div>
		<%-- 	<div class="filteroptions submitbtn">
				<input type="submit" value="" name="productname" id="submitbtn" >
			</div> --%>
		</form>
		<br>
	</div>
    <h3 align="center" class="productheading"> Our Best Products</h3>
    <%			if(request.getAttribute("filterProducts") == null){
    			productList = pc.getProducts();
    }else{
    	 productList = (List<ProductDetails>)request.getAttribute("filterProducts");
    }
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
    %>
    <script type="text/javascript" src="Home.js"></script>
</body>
</html>
