package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeDTO;
import com.example.demo.entity.EmployeeUpdateDTO;
import com.example.demo.repository.EmployeeRepo;

@Service
public class EmployeeServiceIMPL implements EmployeeService{
	
	@Autowired
	private EmployeeRepo employeerepo;

	@Override
	public String adddata(EmployeeDTO employeedto) {
		Employee employee= new Employee(
				employeedto.getId(),
				employeedto.getName(),
				employeedto.getMobile(),
				employeedto.getRoll(),
				employeedto.getSalary());
		
		employeerepo.save(employee);
		return employee.getName();
	}

	@Override
	public List<EmployeeDTO> getAllEmployee() {
		List<Employee>getEmployees=employeerepo.findAll();
		List<EmployeeDTO>employeeDtoList=new ArrayList<>();
		
		for(Employee a:getEmployees) {
			EmployeeDTO employeDto=new EmployeeDTO(
					a.getId(),
					a.getName(),
					a.getMobile(),
					a.getRoll(),
					a.getSalary());
			employeeDtoList.add(employeDto);
		}
		return employeeDtoList ;
	}

	@Override
	public void updateData(EmployeeUpdateDTO employeeupdatedto) {
		Employee employee =employeerepo.findById(employeeupdatedto.getId()).orElse(null);
		 if(employee!=null) {
			   
			   employee.setName(employeeupdatedto.getName());
			   employee.setMobile(employeeupdatedto.getMobile());
			   employee.setRoll(employeeupdatedto.getRoll());
			   employee.setSalary(employeeupdatedto.getSalary());	
			   
		   }
		   else {
			   System.out.println("Employee ID do not exist");
			   
		   }
		
	}

	@Override
	public boolean deleteData(int id) {
		if(employeerepo.existsById(id)) {
			employeerepo.deleteById(id);
		}
		else {
			System.out.println("Employee ID not fond");
		}
		return true;
	}

	
	}

	
	




