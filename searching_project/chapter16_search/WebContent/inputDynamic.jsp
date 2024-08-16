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
		<h1>무엇을 검색 하시겠습니까?</h1>
		<form>
			<table>
				<tr>
					<th>검색 옵션</th>
				</tr>
				<tr>
					<td>
						선택 검색 :
						<select name = "type" onchange = "placeholderChanger(this)">
							<option value = "employee_id">직원 ID</option>
							<option value = "full_name">직원 이름</option>
							<option value = "job_id">직급</option>
							<option value = "email">직원 이메일</option>
							<option value = "phone_number">직원 전화번호</option>
							<option value = "hire_date">입사 일자</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						입력 검색 :
						<input type = "text" placeholder="ID를 입력해 주세요." id = "searching_content" name = "searching_content" onkeydown="handleKeydown(event, this.form)">
					</td>
				</tr>
				<tr>
					<td>
						<input type = "hidden" value="dynamicList" name = "cmd"> 
						<input type = "button" value = "검색" onclick = "dynamicSearching	(this.form)">
					</td>
				</tr>
			</table>
		</form>
		<button style = "margin-top : 20px;" onclick = "location.href='index.jsp'">홈으로 돌아가기</button>
	</div>
</body>
<script type="text/javascript">
	 	
	 	// 사용자가 선택한 옵션 값과 입력한 값을 checkInfo 함수로 체킹하고 반환 받은 논리값을 이용해
	 	// 무사히 통과 받은 상태(true인 상태) 라면 컨트롤러로 폼들을 제출함
	function dynamicSearching(f){
		// select의 value값은 type(type in this case(option)), 
		// 즉 해당 option의 value값으로 정의되어 있다고 함. 
		let option = f.type.value;
		let searchValue = f.searching_content.value;
		let state = checkInfo(option, searchValue);
		
		if(state){
			f.action = "/chapter16_search/Controller"
			f.submit();	
		}
	}
	
	// 각 입력값들이 유효한지를 선택된 select의 옵션 값과 사용자 입력값을 이용하여 비교
	function checkInfo(option, value){
		
		let checkId, checkName, checkEmail, checkNumber, checkJob, checkHireDate;
		
		// 옵션(사용자가 검색하고자 하는 카테고리)에 따라 조건문을 타고 미리 정의해 둔
		// 각 변수들에 정규식을 할당한 뒤 exec 메서드를 호출해 정규식에 해당 사용자의 입력값이 유효한지를 검사
		// 유효하지 않은 경우 경고 문구 후 함수 종료
		if(option === "employee_id"){
			// id는 정수 범위에서 최소1 최대4자리까지 (늘어날  사원들의 id를 생각)
            checkId = /^[0-9]{1,4}$/;
            if(!checkId.exec(value)){
                alert("올바른 사원의 ID를 입력해 주세요. (예시 : 100, 200)");
                return false;
            }
        }else if(option === "full_name"){
        	// full name은 first_name과 last_name을 공백을 두고 서버에 전달할것이기 때문에
        	// 사용자에게 알파벳 범위 내에서 공백을 사이에 두고 한 자 이상씩을 받도록 설정
			let checkName = /^[a-zA-Z]+ [a-zA-Z]+$/;
			if(!checkName.exec(value)){
				alert("올바른 사원의 이름을 입력해 주세요. (예시 : Steven King, neena kochhar)")
				return false;
			}
		}else if(option === "email"){
			// 이메일의 경우 단순히 연속되는 문자열로만 구성되어 있기 때문에 1자 - 20자의 알파벳 범위 안에서 체킹
			let checkEmail = /^[a-zA-Z]{1,20}$/;
			if(!checkEmail.exec(value)){
				alert("올바른 사원의 이메일을 1자 이상 입력해 주세요. (예시 : sking, LDEHAAN)")
				return false;
			}
		}else if(option === "phone_number"){
		    // phone_number의 경우 점(.)을 기준으로 3-3-4 자리와 3-2-4-6자리, 두 종류로 나뉘어짐
		    // 그래서 입력되는 값은 점을 사이에 두고 3-3-4 자리의 정수값이거나 3-2-4-6자리의 정수로
		    // 선택적으로 사용자에게 받음
			let checkNumber = /^(?:\d{3}\.\d{3}\.\d{4}|\d{3}\.\d{2}\.\d{4}\.\d{6})$/;
		    if(!checkNumber.exec(value)){
		        alert("올바른 사원의 전화번호를 입력해 주세요. (예시 : 515.123.7777 또는 011.44.1644.429267)");
		        return false;
		    }
		}else if(option === "job_id"){
			// 사원의 직급은 앞이 부서고 뒤가 직급을 의미함. 그래서 무난하게 알파벳 열자리로 입력 받도록 함
			let checkJob = /^[a-zA-Z]{1,10}$/;
			if(!checkJob.exec(value)){
				alert("올바른 사원의 직급을 입력해 주세요. (예시 : clerk 또는 MGR)");
				return false
			}
		}else if (option === "hire_date") {
			// 입사 일자의 경우 RR(세기 구분 연도)/MM(월)/DD(일) 형식으로 저장되어 있는데
			// 이에 대한 정규식으로 슬래쉬(/)로 구분지어 각 두자리씩 00년부터 39년 중 하나, 
			// 01월부터 12월 중, 01일부터 31일 중 하나의 값을 가지도록 함
		    let checkHireDate = /^(0[0-9]|1[0-9]|2[0-9]|3[0-9])\/(0[1-9]|1[0-2])\/(0[1-9]|[1-2][0-9]|3[0-1])$/;
		    if (!checkHireDate.test(value)) {
		        alert("올바른 사원의 입사 일자를 입력해 주세요. (예시 : 07/01/01)");
		        return false;
		    }
		}

		return true;
	}
	
	// 검색 창에 Enter 이벤트 키가 발생할 때 기본 동작 방식을 방지하고 dynamicSearching 함수를 실행
	// 검색 버튼을 눌렀을 때와 동일한 과정이 진행
	function handleKeydown(event, form) {
        if (event.key === 'Enter') {
            event.preventDefault(); 
            dynamicSearching(form); 
        }
    }
	
	// 옵션 변경시 입력 내용 초기화하는 함수
	function placeholderChanger(option) {
	    let text;
		
	    // this(select)의 value(선택된 option 중 하나의 값)에 따라 text에 선택지의 문구를 골라 할당
	    switch (option.value) {
	        case "employee_id":
	            text = "ID를 입력해 주세요.";
	            break;
	        case "full_name":
	            text = "이름을 입력해 주세요.";
	            break;
	        case "email":
	            text = "이메일을 입력해 주세요.";
	            break;
	        case "phone_number":
	            text = "전화번호를 입력해 주세요.";
	            break;
	        case "job_id":
	            text = "직급을 입력해 주세요.";
	            break;
	        case "hire_date":
	            text = "입사일자를 입력해 주세요.";
	            break;
	    }

	    // 검색 입력 요소 선택 후 placeholder를 type(선택된 옵션의 name)에 따라 할당 된 text값으로 할당
	    // 이때 value(입력 상태)도 빈 문자열로 같이 초기화
	    let item = document.querySelector('#searching_content')
	    item.placeholder = text;
	    item.value = "";
	}
	
</script>
</html>



