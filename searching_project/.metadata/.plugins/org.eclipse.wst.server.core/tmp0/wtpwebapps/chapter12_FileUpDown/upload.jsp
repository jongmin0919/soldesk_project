<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String realPath = request.getServletContext().getRealPath("/upload");
// String realPath = application.getRealPath("/upload");도 가능

//multipart 인코딩 방식으로 요청한 경우 request 대신 MultipartRequest 클래스 사용

MultipartRequest mr = new MultipartRequest(
		request,
		realPath,
		1024 * 1024 * 10,
		"utf-8",
		new DefaultFileRenamePolicy());
File file = mr.getFile("filename");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<ul>
			<!-- 실제 서버에 저장된 이름 -->
			<li>실제 저장 경로 : <%=realPath %> </li>
			<li>업로더 : <%=mr.getParameter("uploader")%> </li>
			<li>원본 파일 명 : <%=mr.getOriginalFileName("filename")%></li>
			<li>저장 파일 명 : <%=mr.getFilesystemName("filename")%></li>
			
			<!-- File 객체를 통한 확인 -->
			<li>파일 명 : <%=file.getName() %> </li>
			<li>파일 크기 : <%=file.length() / 1024%> KB</li>
			<li>파일 수정 날짜 : <%=file.lastModified() %> </li>
			<%SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 hh시 mm분");%>
			<li>파일 수정 날짜 : <%= sdf.format(file.lastModified()) %></li>
		</ul>
	</div>
	
	<br> <br>
	
	<a href = "download.jsp?path=upload&filename=<%=mr.getFilesystemName("filename")%>">다운로드</a>
</body>
</html>