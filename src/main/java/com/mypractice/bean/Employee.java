package com.mypractice.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	private Integer empID;
	private String empName;
	private String email;

	public Employee(Integer empID, String empName, String email) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.email = email;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getEmpID() {
		return empID;
	}

	public void setEmpID(Integer empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
