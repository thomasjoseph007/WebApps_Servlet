<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div style="padding:5px;">
		<a href="${pageContext.request.contextPath}/">Home</a>
		|
		<a href="${pageContext.request.contextPath}/Product">Product List</a>
		|
		<a href="${pageContext.request.contextPath}/userInfo">My Account</a>
		|
		<a href="${pageContext.request.contextPath}/login">Login</a>
	</div>
</body>
</html>