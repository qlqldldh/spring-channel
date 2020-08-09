<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
</head>
<body>
<h1>Register Page</h1>
<form action="registerDo" method="post">
<table>
	<tr>
		<td>ID</td>
		<td><input name="uid"></td>
		<td><c:if test="${err.uid ne null }"><font color="red">${err.uid }</font></c:if></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input name="pwd"></td>
		<td><c:if test="${err.pwd ne null }"><font color="red">${err.pwd }</font></c:if></td>
	</tr>
	<tr>
		<td>Retype Password</td>
		<td><input name="repwd"></td>
		<td><c:if test="${err.repwd ne null }"><font color="red">${err.repwd }</font></c:if>
		<c:if test="${err.repwd2 ne null }">&nbsp;&nbsp;<font color="red">${err.repwd2 }</font></c:if></td>
	</tr>
	<tr>
		<td>Name</td>
		<td><input name="name"></td>
		<td><c:if test="${err.name ne null }"><font color="red">${err.name }</font></c:if></td>
	</tr>
	<tr>
		<td>Age</td>
		<td><input name="age"></td>
		<td><c:if test="${err.age ne null }"><font color="red">${err.age }</font></c:if></td>
	</tr>
	<tr>
		<td>Address</td>
		<td><input name="address"></td>
		<td><c:if test="${err.address ne null }"><font color="red">${err.address }</font></c:if></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><input name="email" type="email"></td>
		<td><c:if test="${err.email ne null }"><font color="red">${err.email }</font></c:if></td>
	</tr>
</table>
<input type="submit" value="Update">
</form>


</body>
</html>