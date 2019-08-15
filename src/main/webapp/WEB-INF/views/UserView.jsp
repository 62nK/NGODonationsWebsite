<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in</title>
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

			<h3>Select the donation type</h3>
			<c:if test="${!empty donations}">
				<c:forEach items="${donations}" var="donation">
					<input type="submit" value="${donation.type}" name="button" onClick="${donation.id}"/><br>
				</c:forEach>
			</c:if>
			<p class="success">${Success}</p>
			<p class="failure">${Failure}</p>
		</div>
	</div>

	<%@ include file="_footer.html"%>
</body>
</html>