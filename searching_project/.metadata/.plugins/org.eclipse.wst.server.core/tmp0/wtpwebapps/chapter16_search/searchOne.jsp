<%@page import="org.joonzis.vo.EmployeeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>
<style type="text/css">
    div {
        width: 800px;
        text-align: center;
        margin: auto;
    }
    table {
        width: 100%;
        border-collapse: collapse;
    }
    th, td {
        border: 1px solid gray;
    }
    th {
        padding: 5px;
        background-color: darkslateblue;
        color: white;
    }
</style>
</head>
<body>
    <div>
    	<!-- 동적으로 전달 받은 한 명의 개인 정보를 출력하는 페이지 -->
        <h1>${person.first_name} ${person.last_name} 직원 목록</h1>
        
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
            <!-- 전달받은 request의 속성 값(person)이 비어있지 않은 경우 각 값들을 순차적으로 꺼내어 표시 -->
            <!-- 전달받은 request의 속성 값(person)이 비어있는 경우 데이터가 존재하지 않음을 표시 -->
            <tbody>
                <c:choose>
                    <c:when test="${person != null}">
                        <tr>
                            <td>${person.employee_id}</td>
                            <td>${person.first_name} ${person.last_name}</td>
                            <td>${person.phone_number}</td>
                            <td>${person.salary}</td>
                            <td>${person.department_id}</td>
                            <td>${person.hire_date}</td>
                        </tr>
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