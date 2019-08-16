<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personal Information Form</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/stylesheet.css" />
</head>
<body>

	<%@ include file="_header.html"%>
	<c:if test="${!empty authenticatedUser}">
		<%@ include file="userBar.jsp"%>
	</c:if>
	<div class="container">
		<c:if test="${authenticatedUser.role=='ADMIN'}">
			<div class="sidenav"><%@ include file="_menu.jsp"%></div>
		</c:if>
		<div class="dynamic-content">
			<p class="exception">${Exception}</p>

			<h3>Insert User Information</h3>
			<form:form method="POST" action="/submituserinfo" modelAttribute="UserInfo">
				<table>
					<tr>
						<td><form:label path="firstName">First Name</form:label></td>
						<td><form:input path="firstName" value="${userInfo.firstName}"
								size="35" /></td>
					</tr>
					<tr>
						<td><form:label path="lastName">Last Name</form:label></td>
						<td><form:input path="lastName" value="${userInfo.lastName}"
								size="35" /></td>
					</tr>
					<%-- <tr>
						<td><form:label path="cma">cma</form:label></td>
						<td><form:input path="cma" value="${user.cma}" size="35" /></td>
					</tr> --%>
					<tr>
						<td><form:label path="phone">phone</form:label></td>
						<td><form:input path="phone" value="${userInfo.phone}" size="35" /></td>
					</tr>
					<tr>
						<td><form:label path="address.street">Street</form:label></td>
						<td><form:input path="address.street"
								value="${userInfo.address.street}" size="35" /></td>
					</tr>
					<tr>
						<td><form:label path="address.city">City</form:label></td>
						<td><form:input path="address.city"
								value="${userInfo.address.city}" size="35" /></td>
					<tr>
						<td><form:label path="address.state">State</form:label></td>
						<td><form:input path="address.state"
								value="${userInfo.address.state}" size="35" /></td>
					</tr>

					<tr>
						<td><form:label path="address.zipcode">ZIP code</form:label></td>
						<td><form:input path="address.zipcode"
								value="${userInfo.address.zipcode}" size="35" /></td>
					</tr>

					<tr>
						<td><form:label path="address.country">Country</form:label></td>
						<td><form:input path="address.country"
								value="${userInfo.address.country}" size="35" /></td>
					</tr>

				</table>

				<input type="submit" name="action" value="continue" />
				<input type="submit" name="action" value="cancel" />

			</form:form>
		</div>
	</div>
	<%@ include file="_footer.html"%>
</body>
</html>