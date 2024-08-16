package org.joonzis.dao;

import java.util.List;
import java.util.Map;

import org.joonzis.vo.EmployeeVO;

public interface EmployeeDao {
	public List<EmployeeVO> getAllEmployees();
	public List<EmployeeVO> getOneEmployees(int department_id);
	public EmployeeVO getDynamicSearching(Map<String, String> searching);
	public List<EmployeeVO> getDynamicSearchingList(Map<String, String> searching);
}
