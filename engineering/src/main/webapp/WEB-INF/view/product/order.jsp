<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
주문서
<hr />
1. 주문상품 할인적용
<table width="800" border="1">
	<tr><th colspan="2">상품정보</th><th>적용금액</th></tr>
<c:set var="totalPrice" value="0" />
<c:set var="prodNums" value="" />
<c:forEach items="${list }" var="productCartDTO">
	<tr><td><img src="../product/upload/${productCartDTO.productDTO.prodImage.split(',')[0] }" /></td>
		<td>${productCartDTO.productDTO.prodName }<br />
			단가 : ${productCartDTO.productDTO.prodPrice } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			수량 : ${productCartDTO.cartDTO.cartQty }개
		</td>
		<td align="right">${productCartDTO.cartDTO.cartPrice }원</td></tr>
<c:set var="totalPrice" value="${totalPrice + productCartDTO.cartDTO.cartPrice }" />
<c:set var="prodNums" value="${prodNums += productCartDTO.cartDTO.prodNo += ',' }" />
</c:forEach>
	<tr><td colspan="3" align="right">최종 결제 금액<br />${totalPrice }원</td></tr>
</table>
2. 배송지 정보 입력 (* 필수 입력)
<form action="goodsOrder" method="post">
<input type="hidden" name="purchTotal" value="${totalPrice }" />
<input type="hidden" name="prodNums" value="${prodNums }" />
<table width="800">
	<tr><th>배송지 주소</th>
		<td><input type="text" name="purchAddr" /></td></tr>
	<tr><th>받는 사람</th>
		<td><input type="text" name="purchReceiver" /></td></tr>
	<tr><th>연락처</th>
		<td><input type="text" name="purchPhoneNumber" /></td></tr>
	<tr><th>주문 메세지</th>
		<td><input type="text" name="purchMsg" /></td></tr>
	<tr><th colspan="2"><input type="submit" value="결제하기" /></th></tr>
</table>
</form>
</body>
</html>