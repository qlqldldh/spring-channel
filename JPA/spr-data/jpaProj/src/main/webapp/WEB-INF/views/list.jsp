<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Page</title>

<style>
	th,td{
		text-align:center;
	}
</style>
</head>
<body>

<h1>Student List</h1>

<table>
	<tr>
		<th>Student ID</th>
		<th>Name</th>
		<th>Grade</th>
		<th>Group</th>
		<th>Option</th>
	</tr>
	
		<c:forEach var="itm" items="${list }">
		<tr>
			<td>${itm.studid }</td>
			<td>${itm.stname }</td>
			<td>${itm.grade }</td>
			<td>${itm.stgroup }</td>
			<td><button onclick="location.href='delete?studid=${itm.studid}'">Delete</button></td>
		</tr>
		</c:forEach>
	
</table>
<br>
<button onclick="location.href='index'">Go Back</button>

</body>
</html>