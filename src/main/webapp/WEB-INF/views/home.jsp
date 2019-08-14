<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Static home page</title>
<link rel="stylesheet" href="styles/stylesheet.css" />

</head>
<body>
	<%@ include file="_header.html"%>
	<!-- static loading at compile time -->
	<div class="container">
		<%@ include file="_sidenav.html"%>
		<!-- static loading at compile time -->

		<div class="dynamic-content">
				Home
		</div>
	</div>
	<%@ include file="_footer.html"%>

</body>
</html>