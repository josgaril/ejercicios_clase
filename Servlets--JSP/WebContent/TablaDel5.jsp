<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tabla del 5</title>
</head>
<body>
	<p>La tabla del 5 es:</p>
<% for (int i = 1; i <= 10; i++) {	%>
	<p> 5 x <%=i%> = <%= (5*i) %></p>
<% } %>
</body>
</html>