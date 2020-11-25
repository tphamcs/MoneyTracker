<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.revature.moneytracker.model.Product" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List</title>
</head>
<body>

	<div class="topnav">
	  <a href="/moneytracker/dashboard.jsp">Dashboard</a>
	  <a href="/moneytracker/logout">Logout</a>
	</div>
	
	<p>What product have you purchased?</p>
	<form action="insertProduct" method="post">
		<table>
			<tr>
				<th>Title</th>
				<th>Category</th>
				<th>Date</th>
				<th>Amount</th>
				<th></th>
			</tr>
		    <tr>
		        <td><input type="text" name="title"></td>
		        <td><input type="text" name="category"></td>
		        <td><input type="text" name="date"></td>
		        <td><input type="number" name="amount"></td>
		        <td><input type="submit" value="Submit"></td>
		    </tr>
		</table>
	</form>

	
</body>
</html>