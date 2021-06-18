<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productForm.jsp</title>
</head>
<body>
상품등록 페이지입니다.
<form action="prodJoinOk" method="post" enctype="multipart/form-data">
<table border = 1>
	<tr><th>상품번호</th>
		<td><input type="text" name="prodNo" value="${autoNum }" /></td></tr>
	<tr><th>카테고리</th>
		<td>
			<select name="cateNum">
				<c:forEach items="${lists }" var="dto">
					<option value="${dto.cateNum }">${dto.cateName }</option>
				</c:forEach>
			</select>
		</td></tr>
	<tr><th>이름</th>
		<td><input type="text" name="prodName" /></td></tr>
	<tr><th>가격</th>
		<td><input type="number" name="prodPrice" min=0, step="1" value="0" /></td></tr>
	<tr><th>설명</th>
		<td><textarea rows="6" cols="30" name="prodInfo"></textarea></td></tr>
	<tr><th>이미지</th>
		<td><input type="file" name="prodImage" multiple="multiple" /></td></tr>
	<tr><th colspan="2">
		<input type="submit" value="상품 등록" />
		<input type="reset" value="취소" />
		<input type="button" onclick="javascript:history.back();" value="리스트" />
	</th><td></td></tr>

</table>
</form>
</body>
</html>