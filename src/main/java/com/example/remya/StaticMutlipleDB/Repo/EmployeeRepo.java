package com.example.remya.StaticMutlipleDB.Repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.remya.StaticMutlipleDB.Entity.Employee;



@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Serializable>{
	@Query(value="select *from DemoH2Entity where name=:name ",nativeQuery=true)
	public Employee findByName(@Param("name") String name);
}
