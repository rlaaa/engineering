<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% pageContext.setAttribute("br", "\n"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	///자바스크립트
	///script 보편적으로 title 밑에 쓰지만 어디에든 만들어도 된다.
	function cartAdd(prodNo, prodPrice, cateNum) {
		if(${authInfo == null}) {
			alert("먼저 로그인을 해주세요.");
			location.href="../";
			return false;
		}else {
			var qty = document.getElementById("qty").value;
			location.href="cartAdd?prodNo="+prodNo+"&cartQty="+qty+"&prodPrice="+prodPrice
							   +"&cateNum="+cateNum;
		}
	}
</script>
</head>
<body>
제품상세페이지 <br />
<table align="center" width="800">
	<tr><td rowspan="4">
		<img width="300" src = "../product/upload/${dto.prodImage.split(',')[0] }" /></td>
		<td>${dto.prodName }</td></tr>
	<tr><td align="right">
	<fmt:formatNumber value="${dto.prodPrice }" pattern="#,###,###,###" />원</td></tr>
	<tr><td><input type="number" min="1" value="1" name="qty" id="qty" />개</td></tr>
	<tr><td><input type="button" value="장바구니" 
				   onclick="cartAdd('${dto.prodNo }','${dto.prodPrice }','${dto.cateNum }')" />
			<input type="button" value="바로구매" /></td></tr>
	<tr><td colspan="2">
			 <br />
			제품상세설명 <br />
			${dto.prodInfo }<br />
			<c:forTokens items="${dto.prodImage }" delims="," var="image">
				<img width="500" src = "../product/upload/${image }" /> <br />
			</c:forTokens>
			</td></tr>
</table>
<c:forEach items="${list }" var="dto1">
<table align="center">
<tr><td>
<p>
	${dto1.membId } | 구매일 : ${dto1.purchDate } | 리뷰등록일 : ${dto1.reviewDate } <br />
	${fn:replace(dto1.reviewContent,br,"<br />") } 
</p>
</td></tr>
</table>
</c:forEach>
</body>
</html>