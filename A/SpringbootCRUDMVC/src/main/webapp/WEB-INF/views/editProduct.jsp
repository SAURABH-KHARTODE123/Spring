<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <form action="/product/updateProduct" method="post">
       Product id : <input type="text" name="id" id="id" value="${p.id}" readonly><br>
       Product name : <input type="text" name="name" id="name" value="${p.name}"><br>
        Quantity: <input type="text" name="qty" id="qty" value="${p.qty}"><br>
         price : <input type="text" name="price" id="price" value="${p.price}"><br>
         <button type="submit" name="btn" id="btn">update Product</button>
   </form>
</body>
</html>