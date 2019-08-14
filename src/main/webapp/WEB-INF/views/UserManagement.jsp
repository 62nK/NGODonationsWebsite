<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in</title>
<link rel="stylesheet" href="styles/stylesheet.css" />
</head>
<body>

<div class="header">NGO Donations</div>

<div class="container">
	<div class="sidenav">User Management</div>
  
<div class="content">

	<form:form method="POST" action="signin">
		<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Role</th>
			<th></th>
			<th></th>
		</tr>
		<c:set var="total" value="0"></c:set>
			<tr>
				<td>${FirstName }</td>
				<td>${LastName }</td>
				<td>${Email}</td>
				<td>${Role}</td>
        		<td><a href="/edit"></td>
				<td>${ Remove}</td>
		</table>
	</form:form>
  </div>
  </div>

	<div class="footer">im the footer </div>
  
</body>
</html>