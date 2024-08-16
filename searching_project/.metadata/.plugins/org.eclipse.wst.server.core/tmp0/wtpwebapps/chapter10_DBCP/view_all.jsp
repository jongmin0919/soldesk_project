<%@page import="org.joonzis.ex.GreenVO"%>
<%@page import="java.util.List"%>
<%@page import="org.joonzis.ex.GreenDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	GreenDao dao = GreenDao.getInstance();
 	List<GreenVO> list = dao.getAllList();
 	pageContext.setAttribute("list", list);
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="index.jsp"/>
	
	<br> <hr> <br>
	
	<h1 style = "text-align:center" >member 테이블의 전체 데이터</h1>
	<table>
		<thead>
			<tr>
				<th>회원번호</th> 
				<th>아이디</th> 
				<th>비밀번호</th> 
				<th>이름</th> 
				<th>나이</th> 
				<th>주소</th> 
				<th>가입일</th> 
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${list.size() > 0}">
					<c:forEach var = "vo" items = "${list}">
						<tr>
							<td>${vo.getIdx()}</td> 
							<td>${vo.getId()}</td>
							<%-- 필드처럼 쓰려면 필드명대로 써야함 (private 이지만 필드를 쓰면 컴파일러는 getter로 자동 인식) --%>
							<td>${vo.pw}</td> 
							<td>${vo.getName()}</td> 
							<td>${vo.getAge()}</td> 
							<td>${vo.getAddr()}</td> 
							<td>${vo.getReg_date()}</td> 
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr> 
						<td colspan="7">회원이 존재하지 않습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>
</html>