package org.joonzis.vo;

import java.util.Date;

public class EmployeeVO {
	private String first_name, last_name, email, phone_number, job_id; 
	private int employee_id, salary, commision_pct, manager_id, department_id;
	private Date hire_date;
	
	public EmployeeVO() {}
	
	public EmployeeVO(String first_name, String last_name, String email, String phone_number, String job_id,
			int employee_id, int salary, int commision_pct, int manager_id, int department_id, Date hire_date) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
		this.job_id = job_id;
		this.employee_id = employee_id;
		this.salary = salary;
		this.commision_pct = commision_pct;
		this.manager_id = manager_id;
		this.department_id = department_id;
		this.hire_date = hire_date;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getCommision_pct() {
		return commision_pct;
	}
	public void setCommision_pct(int commision_pct) {
		this.commision_pct = commision_pct;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public Date getHire_date() {
		return hire_date;
	}
	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	} 
}
