<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="addnewemp">
		<label>Id <input type="number" name="id" ></label>
		<label>Name <input type="text" name="name"></label>
		<label>Salary <input type="number" name="salary"></label>
		<label>Gender <input type="text" name="gender"></label>
		<button type="submit">Insert</button>
	</form>
</body>
</html>