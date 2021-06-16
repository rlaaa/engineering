<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function delOk() {
		if(confirm("진짜진짜정말로 탈퇴하실건가요?")) {
		 // javascript 기본함수
		 	document.frm.submit();
		}else {
			return false;
		}
	}
</script>
</head>
<body>
<form action="memDeleteOk" method="post" name="frm"
	  onsubmit="return delOk();">
	비밀번호 : <input type="password" name="membPw" ><br />
	<input type="submit" value="탈퇴" />

</form>
</body>
</html>