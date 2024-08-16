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
<script type="text/javascript">
	function search1(){
		location.href='/chapter16_search/Controller?cmd=allList';
	}
	function search2(){
		location.href='/chapter16_search/Controller?cmd=inputDept';
	}
	function search3(){
		location.href='/chapter16_search/Controller?cmd=inputDynamic';
	}
</script>
</head>
<body>
	<div>
		<h1>원하는 검색 버튼 클릭</h1>
		<form>
			<table>
				<tr>
					<th>검색 버튼을 클릭하세요.</th>
				</tr>
				<tr>
					<td>
						<input type="button" value="전체 직원 보기" onclick="search1()">
						<input type="button" value="부서별 검색" onclick="search2()">
						<input type="button" value="동적 검색" onclick="search3()">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>




