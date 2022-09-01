package com.example.remya.StaticMutlipleDB.H2Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.remya.StaticMutlipleDB.Entity.EmployeeH2;
import com.example.remya.StaticMutlipleDB.RepoH2.EmployeeRepoH2;

@Service
public class H2Service {
	@Autowired
	EmployeeRepoH2 h2Repo;

	public List<EmployeeH2> allEmployee() {
		// TODO Auto-generated method stub
		return (List<EmployeeH2>) h2Repo.findAll();
	}

	public EmployeeH2 addEmployeeH2(EmployeeH2 emp) {
		return h2Repo.save(emp);
	}

	

}
