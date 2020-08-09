<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gift Insert Page</title>
</head>
<body>
<h1>Validation Test1 - throw Exception from DAO</h1>
<div>
	<form action="insertdo" method="post">
	<div>Gno: <input name="gno"></div>
	<div>Gname: <input name="gname"></div>
	<div>G_start: <input name="g_start"></div>
	<div>G_end: <input name="g_end"></div>
	<div><input type="submit" value="Insert"></div>
	</form>
</div>

<h1 style="padding-top:100px">Validation Test2 - Use @Valid & BindingResult</h1>
<div style="border-style:solid">
	<form action="insertdo2" method="post">
	<div>Gno: <input name="gno"></div>
	<div>Gname: <input name="gname"></div>
	<div>G_start: <input name="g_start"></div>
	<div>G_end: <input name="g_end"></div>
	<div><input type="submit" value="Insert"></div>
	</form>
</div>


</body>
</html>