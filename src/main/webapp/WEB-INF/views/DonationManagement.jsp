<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in</title>
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

			<c:if test="${displayAdd}">
				<td><a class="add-donation" href="adddonation">Add Donation</a></td>
			</c:if>
			<c:if test="${!empty donations}">
				<h2>List of donations</h2>

				<table>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Date</th>
						<th>Amount</th>
						<th>Type</th>
						<th></th>
						<th></th>
					</tr>

					<c:forEach items="${donations}" var="donation">
						<tr>
							<td><c:out value="${donation.id}" /></td>
							<td><c:out value="${donation.name}" /></td>
							<td><c:out value="${donation.date}" /></td>
							<td><c:out value="${donation.amount}" /></td>
							<td><c:out value="${donation.type}" /></td>
							<td><a href="editdonation?id=${donation.id}">Edit</a></td>
							<td><a href="deletedonation?id=${donation.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<p class="success">${Success}</p>
			<p class="exception">${Failure}</p>


			<c:if test="${!empty newDonation}">
				<form:form method="POST" action="savedonation"
					modelAttribute="DonationInsertion">
					<table>
						<tr>
							<td><form:label path="id">ID:</form:label></td>
							<td><form:input path="id" value="${newDonation.id}"
									readonly="true" /></td>
						</tr>
						<tr>
							<td><form:label path="name">Name:</form:label></td>
							<td><form:input path="name" value="${newDonation.name}" /></td>
						</tr>
						<tr>
							<td><form:label path="date">Date:</form:label></td>
							<td><form:input path="date" type="date"
									value="${newDonation.date}" /></td>
						</tr>
						<tr>
							<td><form:label path="amount">Amount:</form:label></td>
							<td><form:input path="amount" value="${newDonation.amount}" /></td>
						</tr>
						<tr>
							<td><form:label path="type">Type:</form:label></td>
							<td><form:input path="type" value="${newDonation.type}" /></td>
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