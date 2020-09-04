<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice Page</title>
</head>
<body>

<h1>Notice</h1>
<table>
<tr>
	<th>Username</th>
	<th>Title</th>
	<th>Contents</th>
	<th>Date</th>
	<th>Options</th>
</tr>
<c:forEach var="itm" items="${list }">
<tr>
	<td>${itm.username }</td>
	<td>${itm.title }</td>
	<td>${itm.ncontents }</td>
	<td>${itm.ndate }</td>
	<td><button onclick="location.href='delete?title=${itm.title}'">Delete</button>
			&nbsp; <button onclick="location.href='updateNotice?title=${itm.title}'">modify Content</button></td>
</tr>
</c:forEach>
</table>
<br><br>

<button onclick="location.href='index'">Go Index Page</button>

</body>
</html>