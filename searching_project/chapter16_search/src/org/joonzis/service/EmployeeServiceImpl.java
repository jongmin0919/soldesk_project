package org.joonzis.service;

import java.util.List;
import java.util.Map;

import org.joonzis.dao.EmployeeDao;
import org.joonzis.dao.EmployeeDaoImpl;
import org.joonzis.vo.EmployeeVO;

public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDao dao = EmployeeDaoImpl.getInstance();
	
	@Override
	public List<EmployeeVO> getAll() {
		return dao.getAllEmployees();
	}
	
	@Override
	public List<EmployeeVO> getOne(int department_id) {
		return dao.getOneEmployees(department_id);
	}
	
	@Override
	public EmployeeVO getDynamicResult(Map<String, String> searching) {
		return dao.getDynamicSearching(searching);
	}
	
	@Override
	public List<EmployeeVO> getDynamicResultList(Map<String, String> searching) {
		return dao.getDynamicSearchingList(searching);
	}
}
