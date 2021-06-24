<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="reviewOk" method="post" name="frm">
<input type="hidden" name="prodNo" value="${prodNo }"/>
<table>
	<tr><td>구매번호</td>
		<td><input type="text" name="purchNo" value="${purchNo }" readonly="readonly" /></td></tr>
	<tr><td>상품명</td>
		<td>${prodName }</td></tr>
	<tr><td>내용</td>
		<td><textarea rows="5" cols="50" name="reviewContent"></textarea></td></tr>
	<tr><td colspan="2">
		<input type="submit" value="리뷰저장" />
		</td></tr>
</table>
</form>
</body>
</html>