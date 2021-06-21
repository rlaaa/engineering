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
직원 상세정보 페이지 입니다.<br />
아이디 : ${emp.empId } <br />
이름 : ${emp.empName } <br />
부서번호 : ${emp.empDeptNumber } <br />
연락처 : ${emp.empPhoneNumber } <br />
이메일 : ${emp.empEmail } <br />
입사일 : <fmt:formatDate value="${emp.hireDate }" type="date" pattern="yyyy-MM-dd"/> <br />


<a href="empUpdate">수정</a>
</p>
</body>
</html>