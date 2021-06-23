<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
결제 페이지 입니다. <br />
<form action="doPayment" method="post">
<input type="hidden" name="purchNo" value="${purchNo }" />
<input type="hidden" name="payPrice" value="${payPrice }" />
<table>
	<tr><td>구매번호</td><td></td></tr>
	<tr><td>결제금액</td><td></td></tr>
	<tr><td>결제방법</td><td>카드</td></tr>
	<tr><td>카드번호</td>
		<td><input type="text" name="payAccNum" /></td></tr>
	<tr><td>카드/은행명</td>
		<td><input type="text" name="payCardBank" /></td></tr>
	<tr><th colspan="2">
		<input type="submit" value="결제완료" />
	</th></tr>
</table>
</form>
</body>
</html>