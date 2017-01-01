package edu.home.hibernate.app6;

import java.io.Serializable;

public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int eno; // Primitive type
	private String ename;
	private int age;
	private long sal;

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

	public long getSal() {
		return sal;
	}

	public void setSal(long sal) {
		this.sal = sal;
	}
}
