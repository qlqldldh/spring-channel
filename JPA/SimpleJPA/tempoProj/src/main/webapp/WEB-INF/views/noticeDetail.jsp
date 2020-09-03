<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice Detail Page</title>
</head>
<body>

<h1>Title : ${detail.title }</h1>

<br>username : ${detail.username }<br>
<br>Contents : ${detail.ncontents }<br>
<%-- <br>Date : ${detail.ndate }<br> --%>

<button onclick="location.href='index'">Go Back</button>
</body>
</html>