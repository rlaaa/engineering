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
상품정보리스트 페이지입니다. <br />
<table border = 1>
	<tr><td>이미지</td><td>상품번호</td><td>상품명</td><td>가격</td></tr>
	<c:forEach items="${prodList}" var="dto">
	<tr><td><img width="50" src='../product/upload/${dto.prodImage.split(",")[0] }' /></td>
		<td><a href="prodUpdate?prodNo=${dto.prodNo }" >${dto.prodNo }</a></td>
		<td>${dto.prodName }</td><td>${dto.prodPrice }</td></tr>
	</c:forEach>
</table>
<a href="prodJoin">상품등록</a>
</body>
</html>