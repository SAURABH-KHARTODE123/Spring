<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/SpringMVC/employee/updateemployee" method="post">
      Product id : <input type="text" name="pid" id="pid" value="${p.id}" readonly><br>
      Product name : <input type="text" name="pname" id="pname" value="${p.name}"><br>
      Gender: <input type="text" name="gender" id="gender" value="${p.gender}"><br>
      Salary : <input type="text" name="price" id="price" value="${p.price}"><br>
      <button type="submit" name="btn" id="btn">update Employee</button>
   </form>
</body>
</html>