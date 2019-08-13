<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in</title>
<link rel="stylesheet" href="styles/stylesheet.css" />
</head>
<body>

<th:block th:include="/_header"></th:block>

	<div class="sidenav"></div>

	<form:form method="POST" action="signin">
		<table>
			<tr>
				<td><form:label path="username">username</form:label></td>
				<td><form:input path="username" value="${user.username}" /></td>
			</tr>
			<tr>
				<td><form:label path="password" type="password">password</form:label></td>
				<td><form:input path="password" value="${user.passwd}" /></td>
			</tr>		
			<tr>
				<td colspan="3"><input type="submit" value="Log In" /></td>
			</tr>
			</table>
	</form:form>
	<th:block th:include="/_footer"></th:block>
	
</body>
</html>