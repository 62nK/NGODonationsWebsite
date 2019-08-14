<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<div class="sidenav"><%@ include file="_menu.jsp"%></div>

		<div class="dynamic-content">

			<c:if test="${!empty users}">
				<h2>List of registered users</h2>
				<table align="left" border="1">
					<tr>
						<th>User ID</th>
						<th>User First Name</th>
						<th>User Last Name</th>
						<th>E-mail</th>
						<th>Role</th>
						<th></th>
						<th></th>
					</tr>

					<c:forEach items="${users}" var="user">
						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.firstName}" /></td>
							<td><c:out value="${user.lastName}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.role}" /></td>
							<td align="center"><a href="user/edit?id=${user.id}">Edit</a>
								| <a href="user/delete?id=${user.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>

	<div class="footer">im the footer</div>

</body>
</html>