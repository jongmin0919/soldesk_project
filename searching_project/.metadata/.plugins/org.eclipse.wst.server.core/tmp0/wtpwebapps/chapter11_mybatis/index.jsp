<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {
		margin: 0 auto;
		border:  1px solid lightseagreen;
	}
	thead {
		background-color: lightseagreen;
		color: white;
	}
	tfoot{
		background-color: lightseagreen;
	}
	td{
		text-align: center;
		padding: 3px;
	}
	th{
		height: 30px;
		padding: 5px;
	}
	input[type=button], input[type=reset]{
		background-color: lightseagreen;
		border: 1px solid white;
		padding: 5px;
		color: white;
	}
	input[type=button]:hover {
		background-color: white;
		color: lightseagreen;
		font-weight: bold;
		cursor: pointer;
	}
</style>
<script type="text/javascript" defer>
	function view_all(){
		location.href = "view_all.jsp";
	}

	function view_one(f){
		let regId = /^[0-9a-zA-Z]{8,16}$/;
		if (!regId.exec(f.id.value)) {
		    alert("대소문자와 소문자를 혼합한 8~16자의 아이디를 입력해 주세요.");
		    f.id.value = "";
		    f.id.focus();
		    return;
		}
		f.action = "view_one.jsp";
		f.submit();
	}

	function insert_one(f){
		let regId = /^[0-9a-zA-Z]{8,16}$/;
		if (!regId.exec(f.id.value)) {
		    alert("대소문자와 소문자를 혼합한 8~16자의 아이디를 입력해 주세요.");
		    f.id.value = "";
		    f.id.focus();
		    return;
		}
		let regPw = /^[0-9a-zA-Z]{8,16}$/;
		if (!regPw.exec(f.pw.value)) {
		    alert("대소문자와 소문자를 혼합한 8~16자의 비밀번호를 입력해 주세요.");
		    f.pw.value = "";
		    f.pw.focus();
		    return;
		}
		let koreanRegName = /^[가-힣]{2,6}$/;
	    if (!koreanRegName.exec(f.name.value)) {
		    alert("올바른 이름을 입력해 주세요.");
		    f.name.value = "";
		    f.name.focus();
		    return;
	    }
	    let regAge = /^[0-9]{1,3}$/;
	    if (!regAge.exec(f.age.value)) {
		    alert("올바른 나이를 입력해 주세요.");
		    f.age.value = "";
		    f.age.focus();
		    return;
	    }
	    let regAddr = /^[가-힣0-9\s]{5,30}$/;
	    if (!regAddr.exec(f.addr.value)) {
		    alert("올바른 주소를 5자 이상 입력해 주세요");
		    f.addr.value = "";
		    f.addr.focus();
		    return;
	    }
		f.action = "insert_one.jsp";
		f.submit();
	}

	function remove_one(f){
		let regId = /^[0-9a-zA-Z]{8,16}$/;
		if (!regId.exec(f.id.value)) {
		    alert("대소문자와 소문자를 혼합한 8~16자의 아이디를 입력해 주세요.");
		    f.id.value = "";
		    f.id.focus();
		    return;
		}
		let regPw = /^[0-9a-zA-Z]{8,16}$/;
		if (!regPw.exec(f.pw.value)) {
		    alert("대소문자와 소문자를 혼합한 8~16자의 비밀번호를 입력해 주세요.");
		    f.pw.value = "";
		    f.pw.focus();
		    return;
		}
		f.action = "remove_one.jsp";
		f.submit();
	}

	function update_one(f){
		let regId = /^[0-9a-zA-Z]{8,16}$/;
		if (!regId.exec(f.id.value)) {
		    alert("대소문자와 소문자를 혼합한 8~16자의 아이디를 입력해 주세요.");
		    f.id.value = "";
		    f.id.focus();
		    return;
		}
		let regPw = /^[0-9a-zA-Z]{8,16}$/;
		if (!regPw.exec(f.pw.value)) {
		    alert("대소문자와 소문자를 혼합한 8~16자의 비밀번호를 입력해 주세요.");
		    f.pw.value = "";
		    f.pw.focus();
		    return;
		}
		f.action = "update_one.jsp";
		f.submit();
	}
</script>
</head>
<body>
	<form method="post">
		<table>
			<thead>
				<tr>
					<th colspan="2">회원 정보 관리</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="2">
						<input type="button" value="전체보기" onclick="view_all()">&nbsp;&nbsp;
						<input type="button" value="검색" onclick="view_one(this.form)">&nbsp;&nbsp;
						<input type="button" value="삽입" onclick="insert_one(this.form)">&nbsp;&nbsp;
						<input type="button" value="삭제" onclick="remove_one(this.form)">&nbsp;&nbsp;
						<input type="button" value="수정" onclick="update_one(this.form)">&nbsp;&nbsp;
						<input type="reset" value="다시 작성">
					</th>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>
