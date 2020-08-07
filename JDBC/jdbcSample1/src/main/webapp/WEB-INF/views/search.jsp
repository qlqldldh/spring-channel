<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Page</title>
<style>
	th{
		background-color:"lightgreen";
	}
	table{
		border-style:solid;
		border-width:0.5px;
	}
</style>
</head>
<body>
<h1>Search Page</h1>

<table>
	<tr>
		<th>Email</th>
		<th>Password</th>
		<th>Phone</th>
		<th>Address</th>
		<th>Birth</th>
		<th>Name</th>
	</tr>
	<tr>
		<td>${buser.email }</td>
		<td>${buser.passwd }</td>
		<td>${buser.phone }</td>
		<td>${buser.address }</td>
		<td>${buser.birth }</td>
		<td>${buser.name }</td>
	</tr>
</table>
<br><br>
<h1>Update Information</h1>

<form action="update" method="post">
	Phone Number : <input name="phone"><br><br>
	Address : <input name="address"><br><br>
	Birth : <input name="birth"><br><br>
	Name : <input name="name"><br><br>
	<input type="hidden" name="email" value="${buser.email }">
	<input type="submit" value="Update">
</form>


</body>
</html>