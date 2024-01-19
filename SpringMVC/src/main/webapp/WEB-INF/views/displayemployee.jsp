<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="2">
		<tr>
			<th>Empid</th>
			<th>Name</th>
			<th>Gender</th>
			<th>Salary</th>
			<th>action</th>
		</tr>
			<c:forEach var="p" items="${plist}">
			<tr>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.gender}</td>
				<td>${p.price}</td>
				<td><a href="edit/${p.id}">Edit</a> / <a href="delete/${p.id}">Delete</a></td>
			</tr>
			</c:forEach>
	</table>
	<a href="insert">Add new Employee</a>&nbsp&nbsp<a href="login/">Logout</a>
</body>
</html>