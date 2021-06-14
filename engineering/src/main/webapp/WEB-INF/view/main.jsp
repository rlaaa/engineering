<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 로그인이 안 된 상태 -->
<table border=1>
<tr><td colspan="3">1111</td></tr>
<tr><td>아이디</td>
	<td>
		<input type="text" name="loginId" />
	</td><td rowspan="2">
		<input type="image" src="" />
	</td></tr>
<tr><td>비밀번호</td>
	<td>
		<input type="password" name="loginPw" />
	</td></tr>
<tr><td colspan="3">
		아이디/비밀번호찾기 | <a href="member/agree">회원가입</a>
	</td></tr>
</table>


<!-- 관리자 로그인 -->
<a href="emp/empList">직원 정보 리스트</a><br />
<a href="member/memList">회원 정보 리스트</a><br />


<!-- 일반직원 로그인 -->


<!-- 사용자 로그인 -->


</body>
</html>