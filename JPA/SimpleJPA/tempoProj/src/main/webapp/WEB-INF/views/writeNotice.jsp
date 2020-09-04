<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write Notice Page</title>
</head>
<body>
<h1>Write Notice Page</h1>

<form action="write" method="post">
<table>
	<tr>
		<td>Username</td>
		<td><input name="username">&nbsp;<c:if test="${username!=null }"><font color='red'>${username }</font></c:if></td>
	</tr>
	<tr>
		<td>Title</td>
		<td><input name="title">&nbsp;<c:if test="${title!=null }"><font color='red'>${title }</font></c:if></td>
	</tr>
	<tr>
		<td>Contents</td>
		<td><textarea name="ncontents"></textarea></td>
	</tr>
	<tr>
		<td>Date</td>
		<td><input name="ndate"></td>
	</tr>
</table>
<br>
<input type="submit" value="Register">
</form>
</body>
</html>