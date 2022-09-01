package com.example.remya.StaticMutlipleDB.SQLController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.remya.StaticMutlipleDB.Entity.Employee;
import com.example.remya.StaticMutlipleDB.Entity.EmployeeH2;
import com.example.remya.StaticMutlipleDB.Repo.EmployeeRepo;
import com.example.remya.StaticMutlipleDB.service.EmployeeService;

@RestController
public class SQLController {
	@Autowired
	EmployeeRepo repo;
	@Autowired
	EmployeeService service;  
	
	@GetMapping("/hiSQL")
	public String hi(){
		return "HiSQL";
		
	}
	
	
	
	@GetMapping("/getAllSQL")
	public List<Employee> getAllSQL(){
		return (List<Employee>) service.allEmployee();
		
	}
	
	 @RequestMapping(value="/addEmployeeSQL", method=RequestMethod.POST)
		public ResponseEntity<Employee> addEmployeeSQL(@RequestBody Employee emp)
		{
		 Employee employee =service.addEmployeeSQL(emp);
		 return new  ResponseEntity<Employee>(employee, HttpStatus.OK);
			
			 
			
			
		}


}
