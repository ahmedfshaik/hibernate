package edu.home.hibernate.app5;

import java.io.Serializable;

public class EmployeePan implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int eno; // id property
	private int panno; // common property
	private Employee employee; // foreign key property

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public int getPanno() {
		return panno;
	}

	public void setPanno(int panno) {
		this.panno = panno;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
