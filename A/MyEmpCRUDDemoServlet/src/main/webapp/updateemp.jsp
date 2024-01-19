<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="updateemp">
		<label>Id <input type="number" name="id" value=${emp.id } readonly ></label>
		<label>Name <input type="text" name="name" value=${emp.name } ></label>
		<label>Salary <input type="number" name="salary" value=${emp.salary } ></label>
		<label>Gender <input type="text" name="gender" value=${emp.gender } ></label>
		<button type="submit">Edit</button>
	</form>
</body>
</html>