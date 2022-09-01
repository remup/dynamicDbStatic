package com.example.remya.StaticMutlipleDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.remya.StaticMutlipleDB.Entity.Employee;
import com.example.remya.StaticMutlipleDB.Repo.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo repo;
	
	public List<Employee> allEmployee() {
		return (List<Employee>) repo.findAll();
	}

	public Employee addEmployeeSQL(Employee emp) {
		return repo.save(emp);
	}

}
