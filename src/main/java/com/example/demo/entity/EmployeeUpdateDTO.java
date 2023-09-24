package com.example.demo.entity;

import jakarta.persistence.Id;

public class EmployeeUpdateDTO {
	@Id
	private int id;
	private String name; 
	private long mobile;
	private String roll;
	private double salary;
	
	public EmployeeUpdateDTO() {
		
	}
	public EmployeeUpdateDTO(int id, String name, long mobile, String roll, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.roll = roll;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getMobile() {
		return mobile;
	}


	public void setMobile(long mobile) {
		this.mobile = mobile;
	}


	public String getRoll() {
		return roll;
	}


	public void setRoll(String roll) {
		this.roll = roll;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", mobile=" + mobile + ", roll=" + roll
				+ ", salary=" + salary + "]";
	}
	

}
