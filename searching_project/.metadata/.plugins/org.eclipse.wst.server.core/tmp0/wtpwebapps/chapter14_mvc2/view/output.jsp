<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="org.joonzis.vo.PersonVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PersonVO vo = (PersonVO)session.getAttribute("vo");
	Map<String, String> map = (Map<String, String>)session.getAttribute("map");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>1. request 확인</h1>
		<ul>
			<li>이름 : ${name}</li>
			<li>나이 : ${age}</li>
			<li>전화번호 : ${phone}</li>
			<li>주소 : ${addr}</li>
			<li>자기 소개 : ${self}</li>
		</ul>
		<h1>2. session 확인</h1>
		<ul>
			<li>이름 : ${sessionScope.name}</li>
			<li>나이 : ${sessionScope.age}</li>
			<li>전화번호 : ${sessionScope.phone}</li>
			<li>주소 : ${sessionScope.addr}</li>
			<li>자기 소개 : ${sessionScope.self}</li>
		</ul>
		<h1>3. vo 확인</h1>
		<ul>
			<li>이름 : ${vo.name}</li>
			<li>나이 : ${vo.age}</li>
			<li>전화번호 : ${vo.phone}</li>
			<li>주소 : ${vo.addr}</li>
			<li>자기 소개 : ${vo.self}</li>
		</ul>
		<h1>4. map 확인</h1>
		<ul>
			<li>이름 : ${map.name}</li>
			<li>나이 : ${map.age}</li>
			<li>전화번호 : ${map.phone}</li>
			<li>주소 : ${map.addr}</li>
			<li>자기 소개 : ${map.self}</li>
		</ul>
	
	</div>
</body>
</html>