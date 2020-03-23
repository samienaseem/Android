package com.example.sandeep1.dbsqlite3;

public class Employee {
	
	private String emp_name;
	private String emp_id;
	private String emp_dpt;
	private String dob;
	private String sex;
	
	
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_dpt() {
		return emp_dpt;
	}
	public void setEmp_dpt(String emp_dpt) {
		this.emp_dpt = emp_dpt;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}

}
