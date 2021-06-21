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
<form action="empUpdateOk" method="post" name="frm">
<table border= "1" width="500" align="center">
	<tr><td width="130">직원번호</td>
		<td width="370">${emp.empNo }	
		</td></tr>
	<tr><td>아이디</td>
		<td>${emp.empId }
		</td></tr>
	<tr><td>비밀번호</td>
		<td><input type="password" name="empPw">
		<span>${pwFail1 }</span></td></tr>
	<tr><td>이름</td>
		<td>${emp.empName }
		</td></tr>
	<tr><td>부서명</td>
		<td>
			<input type="text" name="empDeptNumber" value="${emp.empDeptNumber }">
		</td></tr>
	<tr><td>이메일</td>
		<td>
			<input type="email" name="empEmail" value="${emp.empEmail }">
		</td></tr>
	<tr><td>연락처</td>
		<td>
			<input type="text" name="empPhoneNumber" 
				value="${emp.empPhoneNumber }">
		</td></tr>
	<tr><td>입사일</td>
		<td>
			<fmt:formatDate value="${emp.hireDate }" type="date"
								pattern="yyyy-MM-dd" />
		</td></tr>
	<tr><td>급여</td>
		<td>
			<input type="text" name="salary" value="${emp.salary }">
		</td></tr>
	<tr><td colspan=2 align="center">
			<input type="submit" value="수정 완료">
			<input type="button" value="수정 안함"
					onclick="javascript:history.back();" />
		</td></tr>
</table>
</form>
</body>
</html>