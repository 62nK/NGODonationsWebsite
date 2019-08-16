<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gifts</title>
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

			<h3>Gifts</h3>
			<c:if test="${!empty donations}">
				<form:form method="POST" action="/makegift"
					modelAttribute="GiftForm">
					<table>
						<c:forEach items="${gifts}" var="gift">
							<tr>
								<td><c:out value="${gift.key.type}"/></td>
								<td><input name="${gifts[gift.key]}"/></td>
							</tr>
						</c:forEach>
					</table>
					<input type="submit" name="action" value="continue" />
					<input type="submit" name="action" value="cancel" />
				</form:form>

			</c:if>
			<p class="success">${Success}</p>
			<p class="failure">${Failure}</p>
		</div>
	</div>

	<%@ include file="_footer.html"%>
</body>
</html>