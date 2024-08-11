<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Account</title>
<link rel="stylesheet" href="signup.css">
<link rel="icon" href="user.png">
</head>
<body>
	<div class="maindiv" >
	<div class="innerdiv" id="formdiv">
			
			<form action="signup" method="post">
			<h2 id="heading">Create Account</h2>
			<img alt="" src="user.png" class="userimg slide-right">
			<input type="text" placeholder="First Name" name="firstname" required="required">
			<input type="text" placeholder="Last Name" name="lastname" required="required">
			<input type="text" placeholder="Phone Number" name="contact" required="required">
			<input type="text" placeholder="Address" name="address">
			<input type="text" placeholder="Email" name="email"required="required">
			<input type="text" placeholder="Password" name="password" required="required">
			<input type="text" placeholder="Confirm Password" name="password2" required="required">
			<div class="btndiv">
				<input type="submit"/>
				<input type="button" value="Existing User" onclick="location.href='Login.jsp'"/>
			</div>
		</form>
	</div>
	</div>
</body>
</html>