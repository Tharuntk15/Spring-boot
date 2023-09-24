package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepo;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepo employeerepo;
	
	//Handler for creating data in DB
	@PostMapping("/save")
	public Employee saveData(@RequestBody Employee employee) {
		employeerepo.save(employee);
		return employee;
	}
	//Handler for fetch single data from DB
	@GetMapping("/getData/{id}")
	public Employee getData(@PathVariable int id) {
		Employee employee= employeerepo.findById(id).get();
		return employee;
	}
	//Handler for fetch the all data from DB
	@GetMapping("/getAllEmployee")
	public List<Employee>getAll(){
		List<Employee> employeeList= employeerepo.findAll();
		return employeeList;
	}
	//Handler for delete data from DB
	@DeleteMapping("/Delete/{id}")
	public String deleteData(@PathVariable int id) {
		Employee empolyee=employeerepo.findById(id).get();
		if(empolyee!=null) 
			employeerepo.delete(empolyee);
		return "Deleted Successfully";
	}
	
	@PutMapping("/updateData")
	public Employee updateData(@RequestBody Employee employee) {
		employeerepo.save(employee);
		return employee;
	}
	

}
