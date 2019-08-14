<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in</title>
<link rel="stylesheet" href="styles/stylesheet.css" />

<script type="text/javascript" src="Javascript/js.js"></script>
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
<<<<<<< HEAD
				<td>${FirstName }</td>
				<td>${LastName }</td>
				<td>${Email}</td>
				<td>${Role}</td>
        		<td><a href="/edit"></td>
				<td>${ Remove}</td>
=======
				<td>${User.firstName}</td>
				<td>${User.lastName }</td>
				<td>${User.email}</td>
				<td>${User.role}</td>
        		<td><a href="user/edit?id=${user.id}">
        		
        		
        		<dialog id="favDialog">  
								<form method="dialog">
									First name: <input type="text" name="FirstName"
										value="FirstName"><br> Last name: <input
										type="text" name="LastName" value="LastName"><br>
									Email: <input type="email" name="Email" value="email"><br>
									Role: <input type="text" name="Role" value="role"><br>

									   
									<menu>
										     
										<button value="cancel">Cancel</button>
										     
										<button id="confirmBtn" value="default">Confirm</button>
										   
									</menu>
									 
								</form>
								</dialog>

								<menu>
									 
									<button id="updateDetails">Update details</button>
								</menu> <output aria-live="polite"></output>
        		
        		
        		
        		
        		</a></td>
        		
        		
				<td><a href="user/remove?id=${user.id}">remove</a></td>
			</tr>
>>>>>>> 544173a209a2e0191c6e17b9a228b4a61ca974f4
		</table>
	</form:form>
  </div>
  </div>

	<div class="footer">im the footer </div>
  
</body>
</html>