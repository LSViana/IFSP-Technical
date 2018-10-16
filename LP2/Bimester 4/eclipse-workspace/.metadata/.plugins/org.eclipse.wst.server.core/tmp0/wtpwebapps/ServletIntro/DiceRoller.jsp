<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dice Roller</title>
</head>
<body>
 <form action="DiceRoller" method="POST">
 	<div>
 		<label>Your guess</label>
 		<input type="number" min="2" max="12" name="userGuess">
 	</div>
 	<button type="submit">Send</button>
 </form>
</body>
</html>