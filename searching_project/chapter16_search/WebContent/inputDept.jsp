<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<h1>부서를 선택하고 검색 버튼을 누르세요.</h1>
		<form>
			<table>
				<tr>
					<th>부서 검색</th>
				</tr>
				<tr>
					<td>
						<select name="department_id">
						  <option value="" disabled selected>-부서선택-</option>
						  <option value="10" >10</option>
						  <option value="20">20</option>
						  <option value="30">30</option>
						  <option value="40">40</option>
						  <option value="50">50</option>
						  <option value="60">60</option>
						  <option value="70">70</option>
						  <option value="80">80</option>
						  <option value="90">90</option>
						  <option value="100">100</option>
						  <option value="110">110</option>
						</select>
						<input type = "hidden" value = "deptList" name = "cmd">
						<input type="button" value="검색" onclick="dynamicSearching(this.form)">
					</td>
				</tr>
			</table>
		</form>
		<button style = "margin-top : 20px;" onclick = "location.href='index.jsp'">홈으로 돌아가기</button>
	</div>
</body>
<script type="text/javascript">
	function dynamicSearching(f){
		f.action="/chapter16_search/Controller"
	    f.submit();
	}
</script>
</html>