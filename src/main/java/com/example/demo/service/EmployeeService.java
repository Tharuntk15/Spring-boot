package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.EmployeeDTO;
import com.example.demo.entity.EmployeeUpdateDTO;

public interface EmployeeService {
	
	String adddata(EmployeeDTO employeedto); 
	
	List<EmployeeDTO>getAllEmployee();

	boolean deleteData(int id);

	void updateData(EmployeeUpdateDTO employeeupdatedto);

	

}
