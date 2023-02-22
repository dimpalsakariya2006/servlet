<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<h1> Registration </h1>
<form action="register" method = "post">
Enter Firstname:<br> <input type = "text" name = "fname" required><br>
Enter Lastname:<br> <input type = "text" name = "lname" required><br>
Enter Username:<br> <input type = "text" name = "uname" required><br>
BirthDate : <br><input type = "date" name = "bdate" required><br>
Enter Password :<br> <input type = "password" name = "pass" required> <br>
Confirm password : <br> <input type = "password" name = "rpass" required> <br> 
Email : <br> <input type = "email" name = "email" required><br>
Security Question :<br>
<select name = "Question" id = "question">
<option value  = "select"> Select </option>
<option value  = "Your mother's maiden name"> Your mother's maiden name </option>
<option value  = " Your childhood bestfriend"> Your childhood bestfriend </option>
<option value  = "Your primary school name"> Your primary school name </option>
<option value  = " Your favrite color"> Your favrite color </option>
<option value  = "Your Birthplace"> Your Birthplace </option>
</select><br>
Answer : <br> <input type = "text" name = "Answer" id ="answer"><br>
<input type =  "checkbox" name = "checkbox" id = "checkbox" required>
<label for = "checkbox"> I agree with the Terms & Conditions</label><br>
<input type = "reset" value = "Reset">
<input type = "submit" value = "Register">
</form>
<a href = "login.jsp"> Already Registered</a>
</body>
</html>