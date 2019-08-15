<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personal Information Form</title>
</head>
<body>
<h1>Personal Information</h1>


<form:form method="POST" action="register">

			<table style="width: 40%">
				<tr>
					<td><form:label path = "firstName">First Name</form:label></td>
					<td><form:input path ="firstname" value ="${user.firstName}" size="35" /></td>
				</tr>
				<tr>
					<td><form:label path = "lastName">Last Name</form:label></td>
					<td><form:input path ="lastName" value ="${user.lastName}" size="35" /></td>
				</tr>
				<tr>
					<td><form:label path = "cma">cma</form:label></td>
					<td><form:input path ="cma" value ="${user.cma}" size="35" /></td>
				</tr>
					<tr>
					<td><form:label path = "phone">phone</form:label></td>
					<td><form:input path ="phone" value ="${user.phone}" size="35" /></td>
				</tr>
				<tr>
					<td><form:label path = "address">Address</form:label></td>
					<td><form:input path ="address" value ="${address.address}" size="35" /></td>
				</tr>
				<tr>
					<td><form:label path = "city">City</form:label></td>
					<td><form:input path ="city" value ="${address.city}" size="35" /></td>
					
						<tr>
					<td><form:label path = "state">State</form:label></td>
					<td><form:input path ="state" value ="${address.state}" size="35" /></td>
				</tr>
				
					<tr>
					<td><form:label path = "zipcode">Zipcode</form:label></td>
					<td><form:input path ="zipcode" value ="${address.zipcode}" size="35" /></td>
				</tr>
				
					<tr>
					<td><form:label path = "country">Country</form:label></td>
					<td><form:input path ="country" value ="${address.country}" size="35" /></td>
				</tr>
					
				</table>
				
			<input type="submit" value="Submit" />
			
			<input type ="button" value = "Cancel" />
			
			</form:form>
			
			
</body>
</html>