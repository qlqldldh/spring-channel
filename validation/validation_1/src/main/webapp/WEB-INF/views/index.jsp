<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>

</head>
<body>
<h1>params of 'sel'</h1>
<form action="result" method="post">
	<!-- Input String : <input name="inp"><br><br> -->
	<select name="sel">
		<option value="student">student</option>
		<option value="professor">professor</option>
		<option value="subteacher">Sub-Teacher</option>
		<option value="admin">Administrator</option>
	</select>
	
	<br><br><input type="submit" value="Submit">
</form>
<br>
<h1>params of 'inp'</h1>
<form action="result" method="post">
	Input : <input name="inp"><br><br>
	<input type="submit" value="Submit">
</form>

</body>
</html>