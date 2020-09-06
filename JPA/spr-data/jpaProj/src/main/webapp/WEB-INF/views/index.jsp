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

<button onclick="location.href='select'">Show Student List</button>
<br><br>
<button onclick="location.href='insertPage'">Go Insert Page</button>
<br><br>
<form action="updatePage" method="post">
Student ID to Modify : <input name="studid"><br>
<input type="submit" value="Submit">
</form>


</body>
</html>