package com.example.remya.StaticMutlipleDB.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeH2 {
	@Id
	public int id;
	public String name;
	public EmployeeH2() {
		// TODO Auto-generated constructor stub
	}
	public EmployeeH2(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}

}
