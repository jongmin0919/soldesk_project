<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="upload.jsp" method="post" enctype="multipart/form-data">
			<p>업로더 <input type="text" name="uploader"> </p>
			<p>첨부파일 <input type="file" name="filename"> </p>
			<input type="submit" value="업로드">
		</form>
	</div>
</body>
</html>