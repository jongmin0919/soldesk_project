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
 
 GreenVO vo = new GreenVO();
 
 vo.setId(id);
 vo.setPw(pw);
 
 GreenDao dao = GreenDao.getInstance();
 int result = dao.getRemove(vo);
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
 			alert("정보 삭제에 실패했습니다.")
			location.href = "view_all.jsp"
		</script>
 	</c:otherwise>
 </c:choose>