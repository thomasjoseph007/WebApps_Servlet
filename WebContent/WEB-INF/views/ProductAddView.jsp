<%@page import="com.face.bo.ProductBO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
   <%@page import="java.util.*"%>
   <%@page import="com.face.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  </head>
<body>
   <jsp:include page="header.jsp"></jsp:include>
   <jsp:include page="_menu.jsp"></jsp:include>
   <div class="row">	
    <h3>Add Product</h3>
   		<div class="col-sm-3">
   		</div>
   		<div class="col-sm-4">
   			<form method="post" action="${pageContext.request.contextPath}/Product">
   				<input type="text" class="form-control" name="pname" placeholder="Product Name"><br>
   				<input type="number" name="pquantity" min="1" max="5" class="form-control"  placeholder="Enter Quantity"><br>
   				<input type="text" class="form-control" name="price"  placeholder="Product Price" required><br>
   				<input type="submit" class="btn btn-primary" value="submit"><br>
   			</form>
   			<br>
   			<br>	
   			<% ArrayList<ProductBO> p = (ArrayList<ProductBO>)request.getAttribute("data");%>																					
   			<table class="table">
 <thead class="thead-dark">
   <tr>
      <th scope="col">#</th>
     <th scope="col">NAme</th>
     <th scope="col">Qty</th>
     <th scope="col">Price</th>
   </tr>
 </thead>
 <tbody>
 <%  for(ProductBO ps : p){ %>
   <tr>
    <td><%=ps.getId() %></td>
     <td> <%=ps.getPname() %></td>
         <td><%=ps.getPquantity() %></td>
     <td><%=ps.getPrice()%></td>
      <td>
      <form action="${pageContext.request.contextPath}/ProductEdit" method="post">
      	 <input type="text" value="<%=ps.getId() %>" hidden name="id">
      <button data-toggle="modal" data-target="#myModal" type="submit" ><span class="glyphicon glyphicon-edit"></span></button>  
      </form>    
      </td>
       <td><a href="ProductEdit?id=${ps.getId()}"><span class="glyphicon glyphicon-trash"></span></a></td>
   </tr>
   <%} %>
 </tbody>
</table>
   		</div>
   </div>
   <div class="modal fade" id="myModal" role="dialog">
 
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Edit</h4>
        </div>
        
       
  		<!--omit bootstrap boilerplate-->  
        <div class="modal-body">
        <form method="post" action="">
        <%
				if (request.getAttribute("datas") != null) {
					ProductBO pd = (ProductBO) request.getAttribute("datas");
			%>
			<!--omit bootstrap boilerplate-->
          	<input type="text" class="form-control" name="pname" value="<%=pd.getPname() %>"><br>
   			<input type="number" name="pquantity" min="1" max="5" class="form-control"  placeholder="Enter Quantity" value="<%=pd.getPquantity() %>"><br>
   			<input type="text" class="form-control" name="price"  placeholder="Product Price" value="<%=pd.getPrice()%>"required><br>
   			<input type="submit" class="btn btn-primary" value="submit"><br>
   		</form>	
   	<%
				} 
			%>
   	
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
     </div>
     </div> 
</body>
</html>