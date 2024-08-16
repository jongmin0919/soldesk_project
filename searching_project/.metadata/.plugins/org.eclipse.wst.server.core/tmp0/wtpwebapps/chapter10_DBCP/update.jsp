<%@page import="org.joonzis.ex.GreenDao"%>
<%@page import="org.joonzis.ex.GreenVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
	
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String addr = request.getParameter("addr");
	int idx = Integer.parseInt(request.getParameter("idx"));
	
	GreenVO vo = new GreenVO();
	
	vo.setPw(pw);
	vo.setName(name);
	vo.setAge(age);
	vo.setAddr(addr);
	vo.setIdx(idx);
	
	GreenDao dao =GreenDao.getInstance();
	int result = dao.getUpdate(vo);
	
	pageContext.setAttribute("result", result);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${result > 0}">
			<script type="text/javascript">
				location.href = "view_all.jsp";
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("정보 수정에 실패했습니다.")
				location.href = "view_all.jsp";
			</script>
			
		</c:otherwise>
	</c:choose>
</body>
</html>