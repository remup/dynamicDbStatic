package com.example.remya.StaticMultipleDB.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Employee")
@Entity(name = "Employee")
public class Employee {
  @Id
  public int id;
  public String name;
  public Employee(int id, String name) {
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
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}

}
