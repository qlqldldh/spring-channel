<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POST-Transfer</title>
</head>
<body>
<!-- Delete 결과 값을 'result'에 POST 방식으로 전송하기 위한 JSP Page -->
<form action="result" method="post" id="frm">
	<input value="${inp }" name="inp">
</form>

<script>
	$(document).ready(function(){
		$("#frm").submit();
	})
</script>
</body>
</html>