<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>

<style>
	th{
		border-style:solid;
		border-width:0.5px;
		border-color:red;
	}
	
	td{
		border-style:solid;
		border-width:0.5px;
		border-color:blue;
	}
</style>
</head>
<body>

<h2>Result : ${res }</h2>

<table>
	<tr>
		<th>GNO</th>
		<th>Gift Name</th>
		<th>G_Start</th>
		<th>G_End</th>
	</tr>
	<c:forEach var="itm" items="${gifts }">
	<tr>
		<td>${itm.gno }</td>
		<td>${itm.gname }</td>
		<td>${itm.g_start }</td>
		<td>${itm.g_end }</td>
	</tr>
	</c:forEach>
</table>

<button onclick="location.href='insert'" name="btn">Insert Gift Info</button>

</body>
</html>