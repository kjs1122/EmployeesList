<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<link rel="stylesheet" type="text/css" href="css/employees.css">
</head>
<body>
	<div id="wrap">
		<h1 id="title">리스트</h1>
		<a href="EmployeesServlet?command=employees_insert_form" class="insert">정보등록</a>
		<table>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>권한</th>
				<th>성별</th>
				<th>전화번호</th>
			</tr>
			<c:forEach var="employee" items="${employees}">
				<tr>
					<td>${employee.id}</td>
					<td><a href="EmployeesServlet?command=employees_view&id=${employee.id}">${employee.name}</a></td>
					<td>${employee.lev}</td>
					<td>${employee.gender}</td>
					<td>${employee.phone}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>