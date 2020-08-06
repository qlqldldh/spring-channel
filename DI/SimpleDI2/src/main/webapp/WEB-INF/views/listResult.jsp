<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Autowiring Page</title>
<style>
	p{
		background-color:"lightblue";
	}
</style>
</head>
<body>
<h1>List Autowiring Page</h1>

<c:forEach var="itm" items="${reslist }">
	<p>${itm }</p>
</c:forEach>

</body>
</html>