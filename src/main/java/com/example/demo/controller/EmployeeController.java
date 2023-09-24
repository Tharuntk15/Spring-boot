package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EmployeeDTO;
import com.example.demo.entity.EmployeeUpdateDTO;
import com.example.demo.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeservice;
	
	//Handler for creating data in DB
	@PostMapping("/save")
	public String addData(@RequestBody EmployeeDTO employeedto) {
		String id=employeeservice.adddata(employeedto);
		return id;
	}
	
	//Handler for fetch the all data from DB
	@GetMapping("/getAllEmployee")
	public List<EmployeeDTO>getAll(){
		List<EmployeeDTO> allEmployees= employeeservice.getAllEmployee();
		return allEmployees;
	}
	//Handler for update data to DB
	@PutMapping("/updateData")
	public EmployeeUpdateDTO updateData(@RequestBody EmployeeUpdateDTO employeeupdatedto) {
		employeeservice.updateData(employeeupdatedto);
		return employeeupdatedto;
	}
	//Handler for delete data from DB
	@DeleteMapping("/Delete/{id}")
	public String deleteData(@PathVariable int id) {
		boolean deletedata=employeeservice.deleteData(id);
		return "Deleted Successfully";
	}
	
	
	

}
