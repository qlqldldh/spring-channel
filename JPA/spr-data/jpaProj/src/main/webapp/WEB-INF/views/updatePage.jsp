<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Page</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<h1>Update ${vo.studid }'s Information</h1>

<form action="update" method="get">
<input type="hidden" name="studid" value=${vo.studid }>
Student Name : <input name="stname" value="${vo.stname }" id="stname"><br>
Student's Grade : <input name="grade" value="${vo.grade }" id="grade"><br>
Student's Group : <input name="stgroup" value="${vo.stgroup }" id="stgroup"><br>
<input type="submit" value="Update" id="Sub">
</form>

<script>
$(function(){
	$('#Sub').click(function(){
		if($('#stname').val()==""){
			alert("Fill Blank of Student Name");
			$('#stname').focus();
			return false;
		}
		else $('#Sub').submit();
	})
		
})
</script>

</body>
</html>