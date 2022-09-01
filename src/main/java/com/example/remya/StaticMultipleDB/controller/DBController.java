package com.example.remya.StaticMultipleDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.remya.StaticMultipleDB.entity.Employee;
import com.example.remya.StaticMultipleDB.service.DBService;

@RestController
public class DBController {
	@Autowired
    DBService service;
	
	@GetMapping("/hello")
	public String test() {
		return "hello DB";
	}
	
	@GetMapping("/getEmployees")
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}
}
