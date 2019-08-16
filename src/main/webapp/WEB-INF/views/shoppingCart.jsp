<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/stylesheet.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/shoppingCart.css" />
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
			<h2>Shopping Cart</h2>
			<c:if test="${!empty gifts}">
				<table>
					<tr>
						<th>Item Description</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Total</th>
						<th></th>
					</tr>

					<c:forEach items="${gifts}" var="gift">
						<tr>
							<td><c:out value="${key.type}" /></td>
							<td><c:out value="1" /></td>
							<td><c:out value="${value}" /></td>
							<td><c:out value="${value}" /></td>
					</c:forEach>
				</table>
			</c:if>
			<p class="success">${Success}</p>
			<p class="exception">${Failure}</p>
			<!-- <div class="shopping-cart">

				<div class="column-labels">
					<label class="product-details">Product</label> <label
						class="product-quantity">Quantity</label> <label
						class="product-price">Price</label> <label
						class="product-line-price">Total</label>
				</div>

				<div class="product">

					<div class="product-details">
						<div class="product-title">Product 1</div>
						<p class="product-description"></p>
					</div>
					<div class="product-price">12.99</div>
					<div class="product-quantity">
						<input type="number" value="2" min="1">
					</div>
					<div class="product-removal">
						<button class="remove-product">Remove</button>
					</div>
					<div class="product-line-price">25.98</div>
				</div>

				<div class="product">

					<div class="product-details">
						<div class="product-title">Product 2</div>

					</div>
					<div class="product-price">45.99</div>
					<div class="product-quantity">
						<input type="number" value="1" min="1">
					</div>
					<div class="product-removal">
						<button class="remove-product">Remove</button>

					</div>
					<div class="product-line-price">45.99</div>
				</div>

				<div class="totals">
					<div class="totals-item">
						<label>Subtotal</label>
						<div class="totals-value" id="cart-subtotal">71.97</div>
					</div>

				</div>

				<button class="checkout">Checkout</button>
				<div class="btn-group">
					<button >Empty Cart</button>
					<button >Update Cart</button>
				</div> -->
			</div>
		</div>
	</div>
	<%@ include file="_footer.html"%>
</body>
</html>