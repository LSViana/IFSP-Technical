<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="beans.Login"%>
<jsp:useBean id="loginBean" scope="session" class="beans.Login" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/base.css">
<title>Authentication Results</title>
</head> 
<body>
	<%
		String login = request.getParameter("login");
		if (login == null)
			login = "";
		String password = request.getParameter("password");
		if (password == null)
			password = "";

		Login lb = (Login) session.getAttribute("loginBean");

		if (login.equals("LSViana") && password.equals("123")) {
			lb.setNotAuthenticated(false);
		} else {
			lb.setLogin(login);
			lb.setPassword(password);
			if (login.isEmpty() || password.isEmpty()) {
				lb.setNotFilled(true);
				lb.setNotAuthenticated(true);
			} else {
				lb.setNotFilled(false);
				lb.setNotAuthenticated(true);
			}
			response.sendRedirect("index.jsp");
		}
	%>
	<h1 class="success">You're successfully authenticated!</h1>
</body>
</html>