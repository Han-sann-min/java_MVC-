<%@ page import="model.domain.Student"%> <!--  필요한 패키지가 있다면 import 명령어를 사용해서 가져옵니다. -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!--   import="model.domain.Student" 하나의 지시어에 다 넣어도 괜찮음 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- jsp는 자바 코드와 html 코드를 섞어쓰기 위한 방법
객체를 만들지 않으면 사용하기 번거롭다. -->
	<h1> Request 객체 </h1>	
        <!--  "이름: " ${requestScope.name} --> <!-- null Point Exception 을 알아서 처리해주고 있음 -->
		 이름: ${requestScope.name.name} <br>
		 나이: ${requestScope.name.age} <br>
		<hr>
	<c:forEach items="${requestScope.vehicle}" var="vehicle"  varStatus="i">
		<p> ${i.index} : ${vehicle}</p>
	</c:forEach>
	<c:set var="st2" value="짱아" />



	<% 
			Student st2 = new Student("짱아", 5);
		%>
		${st2.name}


<hr>
		<%@ include file="endview1.jsp" %>
</body>
</html>