<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.model.vo.Order" %>
<%
	// .getAttribute("키값") => : Object
	String alertMsg = (String)request.getAttribute("alertMSG");
	ArrayList<Order> list = (ArrayList<Order>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역뽑기</title>
</head>
<body>
	<h3>샌드위치 주문내역 확인</h3>
	
	<table border="1">
		<tr>
			<th>주문자명</th>
			<th>핸드폰번호</th>
			<th>주소</th>
			<th>요청사항</th>
			<th>샌드위치</th>
			<th>채소</th>
			<th>소스</th>
			<th>쿠키</th>
			<th>결제수단</th>
			<th>총금액</th>
			<th>주문일자</th>
		</tr>
		
		<% if(list.isEmpty()) { %>
			<tr>
				<td colspan="11"><%= alertMsg%></td>
			</tr>
		<% } else {%>
			<!-- 조회결과 있었다. -->
			<!-- 리스트를 반복을 도리면서 요소들에 순차적으로 접근해서 table에 찍어주기 -->
			
			<% for(Order o : list) { %>
				<tr>
					<td><%= o.getUserName()%></td>
					<td><%= o.getPhone()%></td>
					<td><%= o.getAddress()%></td>
					<td><%= o.getMessage()%></td>
					<td><%= o.getSandwich()%></td>
					<td><%= o.getVegetable()%></td>
					<td><%= o.getSauce()%></td>
					<td><%= o.getCookie()%></td>
					<td><%= o.getPayment()%></td>
					<td><%= o.getPrice()%></td>
					<td><%= o.getOrderDate()%></td>
				</tr>
			<% } %>
		<% } %>
		
	</table>
	
	
	
	
	
	
	
	
	
</body>
</html>