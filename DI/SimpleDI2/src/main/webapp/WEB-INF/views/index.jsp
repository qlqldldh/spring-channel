<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
</head>
<body>
<h1>Index Page</h1>

<form action="numcount" method="post">
	Type String : <input name="input"><br>
	<br><input type="submit" value="To Numcount">
</form>
<br>
<form action="listResult" method="post">
	Type String : <input name="input"><br>
	<br><input type="submit" value="To ListResult">
</form>
<br>
<form action="mapResult" method="post">
	Type String : <input name="input"><br>
	<br><input type="submit" value="To MapResult">
</form>


</body>
</html>