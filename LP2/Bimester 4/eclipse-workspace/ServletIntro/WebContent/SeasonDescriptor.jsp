<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Season Descriptor</title>
</head>
<body>
 <form action="SeasonDescriptor" method="POST">
 	<div>
 		<label>Season Name</label>
 		<select name="seasonName">
 			<option value="spring">Spring</option>
 			<option value="summer">Summer</option>
 			<option value="winter">Winter</option>
 			<option value="autumn">Autumn</option>
 		</select>
 	</div>
 	<button type="submit">Send</button>
 </form>
</body>
</html>