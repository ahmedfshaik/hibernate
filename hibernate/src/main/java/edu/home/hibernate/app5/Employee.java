package edu.home.hibernate.app5;

import java.io.Serializable;
import java.math.BigDecimal;

public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int eno;
	private String ename;
	private int age;
	private BigDecimal salary;
	private String address;
	private long mobile;

	// private Set<EmployeePan> employeePan; //collection property
	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	/*
	 * public Set<EmployeePan> getEmployeePan() { return employeePan; } public
	 * void setEmployeePan(Set<EmployeePan> employeePan) { this.employeePan =
	 * employeePan; }
	 */
}
