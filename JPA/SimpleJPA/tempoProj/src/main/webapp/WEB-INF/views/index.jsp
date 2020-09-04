<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
<h1>Index</h1>

<!-- <button onclick="location.href='notice'">Go Notice List</button> -->

<form action="list" method="get">
<input type="submit" value="Go Notice">
</form>
<br><br>

<h2>Search by Title</h2>
<form action="detail" method="post">
Title : <input name="title"><br><br>
<input type="submit" value="Go Detail">
</form>
<br><br>

<button onclick="location.href='writeNotice'">Insert Notice</button>
</body>
</html>