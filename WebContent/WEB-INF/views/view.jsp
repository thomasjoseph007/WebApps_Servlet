<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page language="java" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  </head>
<body>
   <jsp:include page="header.jsp"></jsp:include>
   <jsp:include page="_menu.jsp"></jsp:include>    
   			<br>
   			<br>
<div class="col-sm-3">
   		</div>
   		<div class="col-sm-6">   																									
   			<table class="table">
  				<thead class="thead-dark">
   					 <tr>
					      <th scope="col">Product Name</th>
					      <th scope="col">Product Qunatity</th>
					      <th scope="col">Product Price</th>
    				</tr>
  				</thead>
 				 <tbody>
				  <%Iterator itr;%>
					<% List data= (List)request.getAttribute("data");
						for (itr=data.iterator(); itr.hasNext(); )
						{
						%> 
				    <tr>
				      <td><%=itr.next()%></td>
				      <td><%=itr.next()%></td>
				      <td><%=itr.next()%></td>								       
				    </tr>
				     <%}%>   
				</tbody>
			</table>
   		</div>
</body>
</html>