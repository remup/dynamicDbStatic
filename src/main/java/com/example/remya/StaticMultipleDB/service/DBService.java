package com.example.remya.StaticMultipleDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.remya.StaticMultipleDB.entity.Employee;
import com.example.remya.StaticMultipleDB.repository.DBRepository;

@Service
public class DBService {
	@Autowired
	DBRepository repo;
	
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return (List<Employee>) repo.findAll();
	}

}
