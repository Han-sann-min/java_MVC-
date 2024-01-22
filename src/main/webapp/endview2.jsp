<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- jsp 코드는 자바코드와 html 코드를 섞어 쓰기 위한 방법
객체를 만들지 않으면 사용하기 번거로움 -->
<h2> session 에서 불러옴</h2>

<% 		Cookie msg1 = new Cookie("key1", "fisa");
Cookie msg2 = new Cookie("key2", "쿠키"); %>

	<p>${msg1.getValue()}</p>
	<p>${msg2.getValue()}</p>


<%= session.getAttribute("key3") %>
<%= session.getAttribute("key4") %>
</body>
</html>