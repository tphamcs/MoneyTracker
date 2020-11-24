<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<div class="topnav">
	  <a href="/moneytracker/index.jsp">Home</a>
	</div>
	
   <h3>User Login</h3>
   
   <form action="login" method="post">
	   <table style="with: 100%">
		    <tr>
		     <td>UserName</td>
		     <td><input type="text" name="username" /></td>
		    </tr>
		    <tr>
		     <td>Password</td>
		     <td><input type="password" name="password" /></td>
		    </tr>
	   </table>
   <input type="submit" value="Submit" />
  </form>
    
</body>
</html>