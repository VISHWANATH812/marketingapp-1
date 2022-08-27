<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>create lead</title>
</head>
<body>
		<h2> create new lead</h2>
		<hr>
		<form action="saveLead" method="post">
		<pre>
		first name<input type="text" name="firstName"/>
		LastNAME<input type="text" name="lastName"/>
		Email<input type="text" name="email"/>
		mobile<input type="text" name="mobile"/>
		<input type="submit" value="save">		
		</pre>
		</form>
</body>
${msg}
</html>