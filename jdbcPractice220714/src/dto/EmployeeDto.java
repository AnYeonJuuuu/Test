package dto;

import java.sql.Timestamp;

public class EmployeeDto {
	
	private String empId;
	private String empName;
	private int salary;
	private Timestamp hireDate;
	private String email;
	private String phone;
	
	// 기본 생성자 -> 직접 만들어야 함.
	public EmployeeDto() {
		
	}
	
	// 생성자
	public EmployeeDto(String empId, String empName, int salary, Timestamp hireDate, String email, String phone) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.hireDate = hireDate;
		this.email = email;
		this.phone = phone;
	}
	
	//getter setter
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Timestamp getHireDate() {
		return hireDate;
	}
	public void setHireDate(Timestamp hireDate) {
		this.hireDate = hireDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "EmployeeDto [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", hireDate=" + hireDate
				+ ", email=" + email + ", phone=" + phone + "]";
	}
	
	
}
