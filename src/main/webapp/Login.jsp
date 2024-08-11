<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="login.css" rel="stylesheet">
<title>Login Page</title>
</head>
<body onload="myFunction()">
	<div class="maindiv">
		<div class="innerdiv">
			<h3 id="heading">Login to your account</h3>
			<form action="login" method="post">
				<img alt="" src="https://static.thenounproject.com/png/750599-200.png" class="userimg">
				<input type="text" placeholder="Username" name="username" id="username" required="required">
				<input type="password" placeholder="Password" name="password" id="password" required="required">
				<div class="btndiv">
					<input type="submit">
					<input type="button" value="Sign Up" onclick="location.href='Signup.jsp'"/>
				</div>
			</form>
		</div>
	</div>

</body>
</html>

