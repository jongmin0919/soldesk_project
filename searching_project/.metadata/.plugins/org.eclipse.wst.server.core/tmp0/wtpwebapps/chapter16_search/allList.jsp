<%@page import="org.joonzis.vo.EmployeeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    div{
        width: 800px;
        text-align: center;
        margin: auto;
    }
    table{
        width: 100%;
        border-collapse: collapse;
    }
    th, td{
        border: 1px solid gray;
    }
    th{
        padding: 5px;
        background-color: darkslateblue;
        color: white;
    }
</style>
</head>
<body>
    <div>
        <h1>전체 직원 목록</h1>
        <table>
            <thead>
                <tr>
                    <th>직원ID</th>
                    <th>직원이름</th>
                    <th>직원연락처</th>
                    <th>직원연봉</th>
                    <th>부서ID</th>
                    <th>고용일</th>
                </tr>
            </thead>
            <!-- 
            2명 이상의 직원들의 리스트를 받을 때 출력되는 곳으로 request에 세팅 된 list 속성이 비어있지 않은 상태라면 
            forEach 태그로 하나하나 꺼낸 요소들(vo)의 각 필드값들을 출력하도록함.
            -->
            <tbody>
                <c:choose>
                    <c:when test="${not empty list}">
                        <c:forEach var="vo" items="${list}">
                            <tr>
                                <td>${vo.job_id}</td>
                                <td>${vo.first_name} ${vo.last_name}</td>
                                <td>${vo.phone_number}</td>
                                <td>${vo.salary}</td>
                                <td>${vo.department_id}</td> 
                                <td>${vo.hire_date}</td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="6">데이터가 존재하지 않습니다. 올바른 값을 입력해 주세요.</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>
        <button style = "margin-top : 20px;" onclick = "location.href='index.jsp'">홈으로 돌아가기</button>
    </div>
</body>
</html>
