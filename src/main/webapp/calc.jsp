<!DOCTYPE html>
<html>
<body>
	
	<h1>Calculator</h1>


	<form action = "calci" >
		Enter number: <input type="text" name="num1"><br> 
		Enter number: <input type="text" name="num2"><br>
		
		
		Select Operation :<br>
		<input type = "radio" id= "add" name = "calculation" value = "Addition">
        <label for ="add" > Addition </label><br>

        <input type = "radio" id= "sub" name = "calculation" value = "Substraction">
        <label for ="sub" > Substraction </label><br>

        <input type = "radio" id= "mul" name = "calculation" value = "Multiplication">
        <label for ="mul" > Multiplication </label><br>

        <input type = "radio" id= "div" name = "calculation" value = "Division">
        <label for ="div" > Division </label><br>
        <input type = "reset" value = "Reset">
		<input type="submit" value="Calculate">
		
	</form>
<form action = "logout" method="post">
<br>
<input type = "submit" value = "Logout">
</form>


</body>
</html>
