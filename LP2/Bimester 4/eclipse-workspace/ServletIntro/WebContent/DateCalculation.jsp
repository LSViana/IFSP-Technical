<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Date Calculation</title>
</head>
<body>
	<form action="DateCalculation" method="POST">
		<div>
			<label>Start Date</label>
			<input name="startDate" type="date">
		</div>
		<div>
			<label>End Date</label>
			<input name="endDate" type="date">
		</div>
		<button type="submit">Calculate</button>
	</form>
</body>
</html>