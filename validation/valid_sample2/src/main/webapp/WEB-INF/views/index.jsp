<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>

<style>
	td{
		margin-top:100px;
		margin-right:40px;
	}
</style>
</head>
<body>

<form action="login" method="post">
<table>
	<tr>
		<th>ID</th>
		<th>Password</th>
		<th></th>
	</tr>
	<tr>
		<td><input name="uid"/></td>
		<td><input name="pwd"/></td>
		<td><input type="submit" value="Login"></td>
	</tr>
</table>
</form>
<c:if test="${errs ne null }">
<font color="red">${errs[0] }</font><br>
</c:if>

<br><button onclick="location.href='register'">Register</button>



</body>
</html>



