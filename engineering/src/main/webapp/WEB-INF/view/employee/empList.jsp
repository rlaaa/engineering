<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
직원리스트 페이지입니다.<br />
<table border = 1>
	<tr><td>사원번호</td><td>이름</td><td>부서명</td>
	    <td>이메일</td><td>전화번호</td></tr>
	<c:forEach items="${empList}" var="dto">
	<tr><td><a href="empInfo?empNo=${dto.empNo }">${dto.empNo }</a></td><td>${dto.empName }</td>
		<td>${dto.empDeptNumber }</td><td>${dto.empEmail }</td>
		<td>${dto.empPhoneNumber }</td></tr>
	</c:forEach>
</table>
<a href="empReget">직원등록</a>
</body>
</html>