package com.example.remya.StaticMutlipleDB.H2Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.remya.StaticMutlipleDB.Entity.EmployeeH2;
import com.example.remya.StaticMutlipleDB.H2Service.H2Service;
import com.example.remya.StaticMutlipleDB.RepoH2.EmployeeRepoH2;



@RestController
public class H2Controller {
	@Autowired
	EmployeeRepoH2 repoH2;
	@Autowired
	H2Service h2Service;
	@Value("${value1}")
	String value1;
	@Value("${value2}")
	String value2;
	
	@GetMapping("/hiH2")
	public String hi(){
		String value=1==1?value1:value2;
		
		return "HiH2"+" "+value;
		
	}
	
	
	
	@GetMapping("/getAllH2")
	public List<EmployeeH2> getAllH2(){
		return (List<EmployeeH2>) h2Service.allEmployee();
		
	}
	
	 @RequestMapping(value="/addEmployeeH2", method=RequestMethod.POST)
		public ResponseEntity<EmployeeH2> addEmployeeH2(@RequestBody EmployeeH2 emp)
		{
		 EmployeeH2 employeeH2 =h2Service.addEmployeeH2(emp);
		 return new  ResponseEntity<EmployeeH2>(employeeH2, HttpStatus.OK);
			
			 
			
			
		}


}
