<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="beans.Login"%>
<jsp:useBean id="loginBean" scope="session" class="beans.Login" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/base.css">
<title>Authenticator</title>
</head>
<body>
	<form action="results.jsp" method="post" class="form-flex">
		<div>
			<label>Login</label> <input type="text" name="login"
				value="<%=loginBean.getLogin()%>">
		</div>
		<div>
			<label>Password</label> <input type="password" name="password"
				value="<%=loginBean.getPassword()%>">
		</div>
		<div>
			<button type="submit" value="Authenticate">Authenticate</button>
		</div>
		<%
			if (loginBean.isNotFilled()) {
		%>
		<div>
			<h3 class="error">You've not filled the fields successfully!</h3>
		</div>
		<%
			} else if (loginBean.isNotAuthenticated()) {
		%>
		<div>
			<h3 class="error">Invalid credentials!</h3>
		</div>
		<%
			}
		%>
	</form>
</body>
</html>