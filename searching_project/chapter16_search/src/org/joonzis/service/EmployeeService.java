package org.joonzis.service;

import java.util.List;
import java.util.Map;

import org.joonzis.vo.EmployeeVO;

public interface EmployeeService {
	public List<EmployeeVO> getAll();
	public List<EmployeeVO> getOne(int department_id);
	public EmployeeVO getDynamicResult(Map<String, String> searching);
	public List<EmployeeVO> getDynamicResultList(Map<String, String> searching);
}
