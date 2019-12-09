<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SampleWeb</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>
<h3>HomePage</h3>
<ul>
	<li>Login</li>
	<li>Storing user information in cookies</li>
	<li>Product List</li>
	<li>Create Product</li>
	<li>Edit Product</li>
	<li>Delete Product</li>
</ul>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>