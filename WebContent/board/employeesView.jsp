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
<h1 id="title">정보 보기</h1>
	<table>
		
			<tr><th>아이디</th><td align="left">&nbsp;${employees.id}</td></tr>
			<tr><th>비밀번호</th><td align="left">&nbsp;${employees.pass}</td></tr>
			<tr><th>이름</th><td align="left">&nbsp;${employees.name}</td></tr>
			<tr><th>권한</th><td align="left">&nbsp;${employees.lev}</td></tr>
			<tr><th>성별</th><td align="left">&nbsp;${employees.gender}</td></tr>
			<tr><th>전화번호</th><td align="left">&nbsp;${employees.phone}</td></tr>
			<tr><th>가입일</th><td align="left">&nbsp;${employees.enter}</td></tr>
	</table>
	<input type="button" value="수정" onclick="winOpen('EmployeesServlet?command=check_pass_form&id=${employees.id}','update')">
	<input type="button" value="삭제" onclick="winOpen('EmployeesServlet?command=check_pass_form&id=${employees.id}','delete')">
	<input type="button" value="목록" onclick="location.href='EmployeesServlet?command=employees_list'">
	<input type="button" value="등록" onclick="location.href='EmployeesServlet?command=employees_insert_form'">
</div>
</body>
</html>