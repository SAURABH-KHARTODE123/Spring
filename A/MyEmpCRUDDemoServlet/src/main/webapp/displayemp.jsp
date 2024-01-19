<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"  %>   	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employees List</title>
</head>
<body>
	<table border="2">
	<thead>
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>salary</th>
		<th>gender</th>
		<th>actions</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach var="emp" items="${list }">
	<tr>
			<td>${emp.id }</td>
			<td>${emp.name }</td>
			<td>${emp.salary }</td>
			<td>${emp.gender }</td>
			<td><a href="Editemp?eid=${emp.id }">Edit</a>/<a href="deleteemp?eid=${emp.id }">Delete</a></td>
	</tr>
		</c:forEach>
	</tbody>
	</table>
	<a href="insertemp.jsp">Add new Employee</a>
</body>
</html>