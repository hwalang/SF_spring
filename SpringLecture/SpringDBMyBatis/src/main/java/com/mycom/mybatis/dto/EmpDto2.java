package com.mycom.mybatis.dto;

public class EmpDto2 {
	
	private int employeeId;
	private String firstName;
	private String lastName;
	
	public EmpDto2() {}
	public EmpDto2(int employeeId, String firstName, String lastName) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		System.out.println("setLastName()");
		if (lastName == null) {
			this.lastName = "";
			return;
		}
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "EmpDto [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
