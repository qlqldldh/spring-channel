<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
<style>
	table{
		border-style:solid;
		border-width:0.5px;
		border-color:blue;
	}
	
	th{
		background-color:"lightblue";
	}
	td{
		border-style:solid;
		border-color:"red";
		border-width:0.5px;
	}
	
</style>

</head>
<body>
<h1>Index Page</h1>

<font size="10">Count of Total Users : ${users }</font><br>
<table>
	<tr>
		<th>Email</th>
		<th>Password</th>
		<th>Phone</th>
		<th>Address</th>
		<th>Birth</th>
		<th>Name</th>
	</tr>
<c:forEach var="itm" items="${list }">
	<tr>
		<td>${itm.email }</td>
		<td>${itm.passwd }</td>
		<td>${itm.phone }</td>
		<td>${itm.address }</td>
		<td>${itm.birth }</td>
		<td>${itm.name }</td>
	</tr>
</c:forEach>
</table>

<button onclick="index2">Go Index 2</button>


<h2>Search</h2>

<form action="search" method="post">
	Email : <input type="email" name="email"><br><br>
	<input type="submit" value="Search">
</form>

</body>
</html>