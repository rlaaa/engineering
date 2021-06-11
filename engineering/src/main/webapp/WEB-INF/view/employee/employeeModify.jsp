<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="empModifyOk" method="post" name="frm">
<input type="hidden" name="empNo" value="${emp.empNo } " />
<table border= "1" width="500" align="center">
	<tr><td width="130">직원번호</td>
		<td width="370"> ${emp.empNo } </td></tr>
	<tr><td>아이디</td>
		<td> ${emp.empId }
		</td></tr>
	<tr><td>이름</td>
		<td> ${emp.empName }
		</td></tr>
	<tr><td>부서명</td>
		<td>
			<input type="text" name="empDeptNumber"
			value="${emp.empDeptNumber }">
		</td></tr>
	<tr><td>이메일</td>
		<td>
			<input type="text" name="empEmail" value="${emp.empEmail }">
		</td></tr>
	<tr><td>연락처</td>
		<td>
			<input type="text" name="empPhoneNumber" 
				placeholder="010-1234-1234" value="${emp.empPhoneNumber }">
		</td></tr>
	<tr><td>입사일</td>
		<td>
			<input type="text" name="hireDate" 
				placeholder="2000-10-25" 
				value="<fmt:formatDate value='${emp.hireDate }' type='date' 
				pattern='yyyy/MM/dd'/> ">
		</td></tr>
	<tr><td>급여</td>
		<td>
			<input type="text" name="salary" value="${emp.salary }">
		</td></tr>
	<tr><td colspan=2 align="center">
			<input type="submit" value="직원수정 완료" />
			<input type="button" value="직원 삭제" 
			onclick="javascript:location.href='empDelete?empNo=${emp.empNo }';"/>
		</td></tr>
</table>
</form>
</body>
</html>