<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in</title>
<link rel="stylesheet" href="/styles/stylesheet.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/stylesheet.css" />

</head>
<body>

	<%@ include file="_header.html"%>

	<div class="container">
		<c:if test="${authenticatedUser.role=='ADMIN'}">
			<div class="sidenav"><%@ include file="_menu.jsp"%></div>
		</c:if>

		<div class="dynamic-content">
			<p class="exception">${Exception}</p>

			<c:if test="${displayAdd}">
				<td><a class="add-user" href="adduser">Add User</a></td>
			</c:if>
			<c:if test="${!empty users}">
				<h2>List of registered users</h2>

				<table>
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
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
							<td><a href="edituser?id=${user.id}">Edit</a></td>
							<td><a href="deleteuser?id=${user.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<p class="success">${Success}</p>
			<p class="exception">${Failure}</p>
		

			<c:if test="${!empty newUser}">
				<form:form method="POST" action="/saveuser"
					modelAttribute="UserInsertion">
					<table>
						<tr>
							<td><form:label path="id">id:</form:label></td>
							<td><form:input path="id" value="${newUser.id}" readonly/></td>
						</tr>
						<tr>
							<td><form:label path="username">username:</form:label></td>
							<td><form:input path="username" value="${newUser.username}" /></td>
						</tr>
						<tr>
							<td><form:label path="password">password:</form:label></td>
							<td><form:input path="password" type="password"
									value="${newUser.password}" /></td>
						</tr>
						<tr>
							<td><form:label path="firstName">First Name:</form:label></td>
							<td><form:input path="firstName"
									value="${newUser.firstName}" /></td>
						</tr>
						<tr>
							<td><form:label path="lastName">Last Name:</form:label></td>
							<td><form:input path="lastName" value="${newUser.lastName}" /></td>
						</tr>
						<tr>
							<td><form:label path="email">E-mail:</form:label></td>
							<td><form:input path="email" value="${newUser.email}" /></td>
						</tr>

						<tr>
							<td><form:label path="role">Role:</form:label></td>
							<td><select name="role" value="${newUser.role}">
									<option value="ADMIN">admin</option>
									<option value="REGULAR">regular</option>
							</select></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="save" /></td>
						</tr>
					</table>
				</form:form>
			</c:if>
		</div>
	</div>

	<%@ include file="_footer.html"%>

</body>
</html>