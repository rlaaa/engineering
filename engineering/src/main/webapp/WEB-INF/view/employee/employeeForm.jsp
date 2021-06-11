<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="empJoin" method="post" name="frm">
<table border= "1" width="500" align="center">
	<tr><td width="130">직원번호</td>
		<td width="370">
			<input type="text" name="empNo" value="${empNo1 }">
		</td></tr>
	<tr><td>아이디</td>
		<td>
			<input type="text" name="empId">
		</td></tr>
	<tr><td>비밀번호</td>
		<td>
			<input type="password" name="empPw">
		</td></tr>
	<tr><td>비밀번호 확인</td>
		<td>
			<input type="password" name="empPwCon">
		</td></tr>
	<tr><td>이름</td>
		<td>
			<input type="text" name="empName">
		</td></tr>
	<tr><td>부서명</td>
		<td>
			<input type="text" name="empDeptNumber">
		</td></tr>
	<tr><td>이메일</td>
		<td>
			<input type="text" name="empEmail">
		</td></tr>
	<tr><td>연락처</td>
		<td>
			<input type="text" name="empPhoneNumber" 
				placeholder="010-1234-1234">
		</td></tr>
	<tr><td>입사일</td>
		<td>
			<input type="text" name="hireDate" 
				placeholder="2000-10-25">
		</td></tr>
	<tr><td>급여</td>
		<td>
			<input type="text" name="salary">
		</td></tr>
	<tr><td colspan=2 align="center">
			<input type="submit" value="직원등록 완료">
			<input type="reset" value="취소">
		</td></tr>
</table>
</form>
</body>
</html>