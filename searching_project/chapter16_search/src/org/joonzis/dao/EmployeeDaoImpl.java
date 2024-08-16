package org.joonzis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.joonzis.mybatis.config.DBService;
import org.joonzis.vo.EmployeeVO;

public class EmployeeDaoImpl implements EmployeeDao{
	
	// DAO 객체 생성
	private static EmployeeDaoImpl instance = null;
	public EmployeeDaoImpl() {}
	// DAO 획득하는 함수
	public static EmployeeDaoImpl getInstance() {
		if(instance == null) {
			instance = new EmployeeDaoImpl();
		}
		return instance;
	}
		
	// 필드
	private static SqlSession sqlsession = null;

	// 팩토리 얻어오는 함수, 단 동기화를 시켜 여러 접속으로부터의 팩토리 획득을 방지하도록 함
	// 왜냐하면 팩토리는 공유 자원(static)인건 맞으나, 팩토리 세션을 생성하는 작업은 1회만 발생(static 구역)
	// 즉 단 한 번 생성된 팩토리 자원을 안정적으로 다수의 호출자로부터의 호출 충돌을 방지하기 위한 작업이라고 보면 됨
	private synchronized static SqlSession getSqlSession() {
		if(sqlsession == null) {
			sqlsession = DBService.getFactory().openSession(false);
		}
		return sqlsession;
	}
	
	// 테이블의 모든 사원들의 정보를 획득하여 전달하는 역할 
	@Override
	public List<EmployeeVO> getAllEmployees() {
		return getSqlSession().selectList("select_all");
	}
	
	// 테이블의 특정 부서 사원들의 정보를 획득하여 전달하는 역할
	@Override
	public List<EmployeeVO> getOneEmployees(int department_id) {
		return getSqlSession().selectList("select_one", department_id);
	}
	
	
	// 동적 검색을 할 때 테이블의 특정 사원의 정보를 획득하여 전달하는 역할 
	@Override
	public EmployeeVO getDynamicSearching(Map<String, String> searching) {
		String type = searching.get("type");
		String searching_content = searching.get("searching_content");
		//id 전달 전용 변수
		int number_content = 0;
		
		// type의 분기점에 따라 마이바티스에 전달할 searching_content의 값을 number_content(사원 id는 Number이므로)
		// 로 변환하거나, 그대로 냅둬서 selectOne 메서드에 전달함
		if(type.equals("employee_id")) {
			number_content = Integer.parseInt(searching.get("searching_content"));
			System.out.println(number_content);
			return getSqlSession().selectOne("dynamic_searching_byid", number_content);
		}else if(type.equals("email")){
			return getSqlSession().selectOne("dynamic_searching_byemail", searching_content);
		}else{
			return getSqlSession().selectOne("dynamic_searching_bynumber", searching_content);
		}
	}
	
	// 동적 검색을 할 때 테이블의 특정 사원들의 정보를 획득하여 전달하는 역할
	public List<EmployeeVO> getDynamicSearchingList(Map<String, String> searching) {
		String type = searching.get("type");
		String searching_content = searching.get("searching_content");
		// 이름 전달 전용 변수
		Map<String, String> names = new HashMap<>();
		
		// 위 단일 VO를 반환하는 동적 검색 함수와의 차이점은 selectList를 반환, 즉 다수의 VO를 반환한다는
		// 차이점이 존재함, (매개변수는 같기 때문에 오버로딩이 안됨, 어차피 반환 타입도 다름) 
		// 그래서 List<EmployeeVO>를 반환하는 메서드를 하나 더 만들어줌 (설명은 단일 동적 검색 함수 주석과 동일)
		if(type.equals("job_id")) {
			return getSqlSession().selectList("dynamic_searching_byjob", searching_content);
		}else if(type.equals("hire_date")) {
			return getSqlSession().selectList("dynamic_searching_byhiredate", searching_content);
		}else {
			// else문에는 type이 full_name인 경우가 되는데, 이때 searching(사용자가 전달한 map)을
			// 공백을 기준으로 나눠 nameArr 배열에 할당함
			// 이럴 경우 공백을 기준으로 앞의 값은 names 맵에 first_name 이름으로 할당하고, 
			// 뒤의 값은 last_name 이름으로 할당한 뒤 마이바티스에 names를 전달
			String[] nameArr = searching.get("searching_content").split(" ");
			names.put("first_name", nameArr[0]);
			names.put("last_name", nameArr[1]);
			return getSqlSession().selectList("dynamic_searching_byname", names);
		}
	}
	
}
