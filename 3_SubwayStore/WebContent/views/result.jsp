<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!-- page지시어 -->
<%
	// 스크립틀릿 : 자바코드를 그대로 작성(세미콜론을 포함한 완전한 형태로 작성)
	
	// 포장풀기 => request의 Attribute영역
	// request.getAttibute("키값"); => object타입(모든 형태의 부모)
	
	String sandwich = (String)request.getAttribute("sandwich");
	String[] vegetable = (String[])request.getAttribute("vegetable");
	String[] sauce = (String[])request.getAttribute("sauce");
	String[] cookie = (String[])request.getAttribute("cookie");
	String payment = (String)request.getAttribute("payment");
	int price = (int)request.getAttribute("price");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>주문내역</h1>
	<!-- = : 출력식, 표현식  => jsp화면에 뿌려주는 역할 => 내가 출력할 변수명, 메소드명(호출) => 세미콜론은 X-->
	샌드위치 : <%= sandwich %> <br>
	
	채소 :
	<% if(vegetable == null) {%>
		선택 안 함
	<% } else { %>
		<!-- String.join(연결자, 배열명) -->
		<%= String.join(",", vegetable) %>
	<% } %>
	
	소스 :
	<% if(sauce == null) { %>
		선택 안 함
	<% } else { %>
		<%= String.join(",", sauce) %>
	<% } %>
	
	쿠키 :
	<% if(cookie == null) { %>
		선택 안 함
	<% } else { %>
		<%= String.join(",", cookie) %>
	<% } %>
	
	결제 방식 : <%= payment %> <br><br>
	
	위와 같이 주문하시겠습니까? <br>
	
	총 가격 : <%= price %>원	
</body>
</html>