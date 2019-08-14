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

	<%@ include file="_header.html"%>
	<div class="container">
		<div class="dynamic-content">
		<p>Login with your username and password</p>
			<p class="exception">${AuthenticationException}</p>
			<form:form method="POST" action="signin"
				modelAttribute="UserLoginForm">
				<table>
					<tr>
						<td><form:label path="username">username</form:label></td>
						<td><form:input path="username"
								value="${userLoginForm.username}" /></td>
					</tr>
					<tr>
						<td><form:label path="password" type="password">password</form:label></td>
						<td><form:input path="password" type="password"
								value="${userLoginForm.password}" /></td>
					</tr>
					<tr>
						<td colspan="3"><input type="submit" value="Log In" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
	<%@ include file="_footer.html"%>

</body>
</html>