<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Result Page</title>
</head>
<body>
<div>
	<div>ID</div>
	<div>${lf.uid }</div>
	<div>Password</div>
	<div>${lf.pwd }</div>
</div>

<br><br>
<button onclick="location.href='index'">Go Back</button>
</body>
</html>