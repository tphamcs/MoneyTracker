<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.revature.moneytracker.model.Product" %>

<%--calling servlet here so that we have value for "listProduct" --%>
<jsp:include page="/listProduct" flush="true"/> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<div class="topnav">
	  <a href="/moneytracker/dashboard.jsp">Dashboard</a>
	  <a href="/moneytracker/createList.jsp">Create</a>
	</div>
	
	<h3>Dashboard</h3>
	
			
	<% 
		ArrayList<Product> listProduct =  (ArrayList<Product>) request.getAttribute("listProduct");
		if (listProduct.isEmpty()) { %>
		
		<p> Nothing found. Please "Create" your tracking list  </p> 
			
	<%	} else { %>
			<table>
				<tr>
					<th>ID</th>	
					<th>Title</th>
					<th>Category</th>
					<th>Date</th>
					<th>Amount</th>
					<th></th>
				</tr>
				
				<%for (Product p : listProduct) {%>
					     
					<tr>
				        <td><%=p.getId()%></td>
				        <td><%=p.getTitle()%></td>
				        <td><%=p.getCategory()%></td>
				        <td><%=p.getDate()%></td>
				        <td>$ <%=p.getAmount()%></td>
				        <td><a href="/moneytracker/deleteProduct?id=<%=p.getId()%>">Delete</a></td>
			    	</tr>		
		   		<%}%>
		   		
		   	</table>
   		<%}%>
	
	
	
</body>
</html>