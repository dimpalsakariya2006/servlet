<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h3> Log in </h3>
<form action="login" name = "Log In" method = "post">

Enter Username:<br> <input type = "text" name = "uname" ><br>
Enter Password :<br> <input type = "password" name = "pass" > <br>
<input type = "submit" value = "Login">
<a href = "registration.jsp" > Click me to register</a>
</form>
</body>
</html>