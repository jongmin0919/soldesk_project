package org.joonzis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joonzis.service.EmployeeService;
import org.joonzis.service.EmployeeServiceImpl;
import org.joonzis.vo.EmployeeVO;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			
			// 어떤 경로로 이동할건지가 담긴 cmd 형태의 요청 파라미터를 추출하여 cmd 변수에 할당  
			// 이 변수는 switch문의 분기점으로 활용될 예정
			String cmd = request.getParameter("cmd");
			
			//단순 화면 이동인지 데이터를 전달하는 이동인지 구분해야함
			// 그래서 forward 방식일 경우 isForward를 true로 지정한 뒤 
			// 조건값으로 forward문을 태울거고, false일 경우 sendRedirect문을 태울거임
			// 일종의 플래그와도 같음
			boolean isForward = false;
			
			// forward와 sendRedirect의 경로가 할당될 변수 
			String path = "";
			
			// 서비스 인스턴스 생성
			EmployeeService service = new EmployeeServiceImpl();
			
			// request에 세팅할 다중 속성(EmployeeVO 타입의 List)을 받을 list 변수와
			// 단일 속성(EmployeeVO person 변수를 미리 선엉ㄴ
			List<EmployeeVO> list = null;
			EmployeeVO person = null;
			
			// cmd 값에 따라 switch문 실행
			switch (cmd) {
			// allList (모든 사용자 조회) 의 경우 service 인스턴스의 getAll 메서드 실행 후 반환값을 list에 할당
			// 할당받은 속성을 request의 속성에 설정 후 isForward(실어나를 값이 있는지)을 true(값이 있음)로 변경
			// path(사용자가 이동할 경로)를 allList.jsp로 지정 후 break(switch문 종료)
			case "allList":
				list = service.getAll();
				request.setAttribute("list", list);
				isForward = true;
				path = "allList.jsp";
			  break;
			// 따로 실어나를(request에 할당할 속성, 즉 전달할 값이 없는 상태) 값이 없는 경우
			// isForward는 놔두고 path(경로)만 지정한 뒤 break
			case "inputDept":
				path = "inputDept.jsp";
				break;
			case "inputDynamic":
				path = "inputDynamic.jsp";
				break;
			// deptList의 설명은 allList와 동일
			// 단 전달하는 값은 정수형 부서 번호 (오라클에서 department_id가 Number로 되어있기 때문에 맞춰줌)
			// 값을 보낼때에도 service의 getOne 메서드에 지정한 매개변수의 타입대로 int로 변환해 전달
			case "deptList":
				list = service.getOne(Integer.parseInt(request.getParameter("department_id")));
				request.setAttribute("list", list);
				isForward = true;
				path = "allList.jsp";
				break;
				
			// ★ 동적 생성을 위한 페이지. 여기서 설명이 조금 복잡해지기 때문에 주석을 세세히 나눌 예정 ★
			case "dynamicList":
				//searching은 사용자의 옵션(option에서 선택한 값)과 searching_content(입력한 값)
				//을 담기 위해 Map을 하나 만들어줌. 그냥 객체 하나 생성했다고 보면 됨
				Map<String, String> searching = new HashMap<>();
				String type = request.getParameter("type");
				String searchingContent = request.getParameter("searching_content");
				// 위에서 꺼낸 두 파라미터 값을 Map으로 선언한 searching 변수의 put 메서드를 이용해
				// 아래와 같이 문자열 타입의 속성 이름과 문자열 타입의 값(getParameter 한 값들)으로 할당함
				// 사용자가 만약 입력창에서 employee_id 옵션을 선택한 뒤 searching_content의 값으로
				// 135를 입력했다면 첫번째 put메서드에는 "type" : "employee_id"가
				// 두번째 put 메서드에는 "searching_content" : "135"가 입력됨
				searching.put("type", type);
				searching.put("searching_content", searchingContent);
				// hire_date, job_id, full_name의 경우 반환값이 한 명이 아닐수도 있음. 
				// 입사 일자 이후의 값을 조회하기 때문이고, job_id(직급)이 같은 경우가 있고
				// 풀 네임이 같은 사람이 있을 수도 있기 때문임. 그래서 사용자가 입력한 type(옵션)이 이들 값이 아닌 경우,
				// 즉 단일 쿼리 반환값인 person(EmployeeVO)만 반환하는 상황인 경우
				if(!type.equals("hire_date") && !type.equals("job_id") && !type.equals("full_name")) {
					// EmployeeVO 타입의 Person에 service 인스턴스의 getDynamicResult(단일 VO 반환 함수)
					// 를 호출하고 매개변수로 put 메서드로 세팅한 searching을 전달함
					person = service.getDynamicResult(searching);
					// 그 뒤 반환 받은 person의 값(VO)을 request에 아래의 명칭과 같이 싣고
					request.setAttribute("person", person);
					// 경로(path)를 단일 VO를 출력하는 페이지로 지정
					path = "searchOne.jsp";
				// if조건에 걸리지 않은 타입들, 즉 다중 리스트(List<EmployeeVO>)를 반환 받는 상황인 경우
				}else {
					// service 인스턴스의 다중 리스트를 반환해주는 메서드를 호출하여 마찬가지로 searching 전달 후
					// 반환 받은 다중 리스트를 미리 선언해 놓은 list(List<EmployeeVO>)에 할당한 뒤 옵션에 세팅
					list = service.getDynamicResultList(searching);
					request.setAttribute("list", list);
					// allList 페이지를 활용해줌 (어차피 다 보여주는 페이지는 동일하되 반환되는 쿼리 값들만 다르므로)
					path = "allList.jsp";
				}
				// 
				isForward = true;
				break;
			}
			// 포워드 값이 true(전달할 request 속성이 있는 경우라면)라면 디스패쳐 포워드로 패스와 함께 요청 처리를 날림
			if(isForward) {
				request.getRequestDispatcher(path).forward(request, response);
			// 전달할 값(request에 세팅이 되어있지 않은 상태)이 없는 경우 그냥 경로(path)로 응답 페이지를 제공
			}else {
				response.sendRedirect(path);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
