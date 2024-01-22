<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<hr>
<h2> Cookie 객체 - 클라이언트의 브라우저에 저장 </h2>
쿠키의 key1, key2 를 출력하도록 endview.jsp를 변경해 주세요.

	${cookie.key1.value}
	${cookie.key2.value}
	


<hr>

<h2> Session 객체 - 클라이언트가 접속할 때 서버에 생성 </h2>

	${sessionScope.key3}
	${sessionScope.key4}
	
	${msg2.key2}
<%-- = request.getAttribute("key3") --%>
<%-- = request.getAttribute("key4") --%>
</body>
</html>
