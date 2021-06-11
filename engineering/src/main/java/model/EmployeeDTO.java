package model;

import java.util.Date;

public class EmployeeDTO {
	Long empNo;
	String empId;
	String empPw;
	String empName;
	String empDeptNumber;
	String empEmail;
	String empPhoneNumber;
	Date hireDate;
	Long salary;
	public Long getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpPw() {
		return empPw;
	}
	public void setEmpPw(String empPw) {
		this.empPw = empPw;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDeptNumber() {
		return empDeptNumber;
	}
	public void setEmpDeptNumber(String empDeptNumber) {
		this.empDeptNumber = empDeptNumber;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpPhoneNumber() {
		return empPhoneNumber;
	}
	public void setEmpPhoneNumber(String empPhoneNumber) {
		this.empPhoneNumber = empPhoneNumber;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
}
