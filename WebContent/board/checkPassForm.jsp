<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/employees.css">
<script type="text/javascript" src="script/employees.js"></script>
</head>
<body>
<div style="width: 500px" align="center">
	<form action="EmployeesServlet" method="post" name="frm">
	<input type="hidden" name="command" value="check_pass">
	<input type="hidden" name="id" value="${param.id}">
	<table>
		<tr>
			<th width="200">비밀번호</th><td><input type="password" name="pass" size="30"></td>
		</tr>
	</table>
		<input type="submit" value="확인">
		<input type="reset" value="취소"><br>
		${message}
		
	</form>

</div>

</body>
</html>