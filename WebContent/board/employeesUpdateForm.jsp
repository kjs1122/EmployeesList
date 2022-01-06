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
<div id="wrap">
<h1 id="title">정보 수정</h1>
	<form method="post" action="EmployeesServlet" name="frm">
	<input type="hidden" name="command" value="employees_update">
	<table>
			<tr><th>아이디</th><td align="left">&nbsp;<input type="text" name="id" value="${employees.id}" readonly="readonly"></td></tr>
			<tr><th>비밀번호</th><td align="left">&nbsp;<input type="password" name="pass" value="${employees.pass}"></td></tr>
			<tr><th>이름</th><td align="left">&nbsp;<input type="text" name="name" value="${employees.name}"></td></tr>
			<tr><th>권한</th>
			<td align="left">
			<select name="lev">
				<option value="A">운영자</option>
				<option value="B">일반회원</option>
			</select>
			</td></tr>
			<tr><th>성별</th>
			<td align="left">
			<select name="gender">
				<option value="1">남성</option>
				<option value="2">여성</option>
			</select>
			</td></tr>
			<tr><th>전화번호</th><td align="left">&nbsp;<input type="text" name="phone" value="${employees.phone}"></td></tr>
	</table>
	<input type="submit" value="확인" onclick="return check()">
	<input type="reset" value="취소">
	<input type="button" value="목록" onclick="location.href='EmployeesServlet?command=employees_list'"> 
	</form>
</div>
</body>
</html>