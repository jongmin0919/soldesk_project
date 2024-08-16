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
 
 GreenDao dao = GreenDao.getInstance();
 GreenVO result = dao.getUserInfoById(id);
 pageContext.setAttribute("vo", result);
 
 // 이전에 사용했던 방법
 //response.sendRedirect("view_all.jsp");
 %>
 
 <body>
    <jsp:include page="index.jsp"/>
    
    <br> <hr> <br>
    
    <h1 style="text-align:center">green 테이블의 전체 데이터</h1>
    <table>
        <thead>
           <tr>
	           <th>번호</th>
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
                <c:when test="${not empty vo}">
                        <tr>
                            <th>${vo.getIdx()}</th>
                            <th>${vo.getId()}</th>
                            <th>${vo.getPw()}</th>
                            <th>${vo.getName()}</th>
                            <th>${vo.getAge()}</th>
                            <th>${vo.getAddr()}</th>
                            <th>${vo.getReg_date()}</th>
                        </tr>
                </c:when>
                <c:otherwise>
                	<tr>
                		<td colspan="7">정보 조회에 실패했습니다 </td>
                	</tr>
                </c:otherwise> 
            </c:choose> 
        </tbody>
    </table>
</body>
