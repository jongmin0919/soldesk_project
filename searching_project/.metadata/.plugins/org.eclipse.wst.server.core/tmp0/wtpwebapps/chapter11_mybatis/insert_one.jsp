<%@page import="org.joonzis.ex.GreenDao"%>
<%@page import="org.joonzis.ex.GreenVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <%
 request.setCharacterEncoding("utf-8");
 String id = request.getParameter("id");
 String pw = request.getParameter("pw");
 String name = request.getParameter("name");
 String age = request.getParameter("age");
 String addr = request.getParameter("addr");
 
 GreenVO vo = new GreenVO();
 
 vo.setId(id);
 vo.setPw(pw);
 vo.setName(name);
 vo.setAge(Integer.parseInt(age));
 vo.setAddr(addr);
 
 GreenDao dao = GreenDao.getInstance();
 int result = dao.getInsert(vo);
 pageContext.setAttribute("result", result);
 
 //response.sendRedirect("view_all.jsp");
 %>
 
 <c:choose> 
 	<c:when test="${result >= 0}">
		<script type="text/javascript">
			location.href = "view_all.jsp"
		</script> 			
 	</c:when>
 	<c:otherwise>
 		<script type="text/javascript">
 			alert("회원 가입에 실패했습니다.")
			location.href = "view_all.jsp"
		</script>
 	</c:otherwise>
 </c:choose>