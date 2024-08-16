<%@page import="org.joonzis.ex.GreenVO"%>
<%@page import="org.joonzis.ex.GreenDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function update(f){
		if(f.pw.value == '' || !f.name.value || f.age.value === null || f.addr.value === null){
			alert("정보가 비어있습니다. 확인해 주세요.")
			return;
		}
		f.action = "update.jsp";
		f.submit();
	}
</script>
<body>
	<jsp:include page="index.jsp"/>
	
	<br> <hr> <br>
	
	<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	GreenDao dao = GreenDao.getInstance();
	GreenVO vo = dao.getUpdateView(id, pw);
	pageContext.setAttribute("vo", vo);	
	%>
	
	<h1 style = "text-align:center">${vo.getId()} 회원의 데이터</h1>
	<form method = "post">
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
		 				<c:when test="${empty vo}">
		 					<tr>
		 						<td colspan="7">member 데이터가 없습니다.</td>
	 						</tr>	
		 				</c:when>
		 				<c:otherwise>
		 					<tr>
		 						<td>
		 							${vo.getIdx()}
		 							<input type = "hidden" name = "idx" value = "${vo.getIdx()}">  
		 						</td>			
		 						<td>
		 							${vo.getId()}
		 						</td>			
		 						<td>
		 							<input type = "password" name = "pw" value = "${vo.getPw()}"> 
		 						</td>			
		 						<td>
		 							<input type = "text" name = "name" value = "${vo.getName()}">
		 						</td>			
		 						<td>
		 							<input type = "number" name = "age" value = "${vo.getAge()}"> 
		 						</td>			
		 						<td>
		 							<input type = "text" name = "addr" value = "${vo.getAddr()}">
		 						</td>			
		 						<td>
		 							<input type = "text" name = "reg_date" value = "${vo.getReg_date()}" readonly> 
		 						</td>			
		 					</tr>	
		 				</c:otherwise>
		 			</c:choose>
			</tbody>
			<tfoot>
				<tr>
					<td colspan = "7">
						<input type = button value = "수정" onclick = "update(this.form)">
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>