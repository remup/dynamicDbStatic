package com.example.remya.StaticMutlipleDB.RepoH2;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.remya.StaticMutlipleDB.Entity.Employee;
import com.example.remya.StaticMutlipleDB.Entity.EmployeeH2;



@Repository

public interface EmployeeRepoH2 extends CrudRepository<EmployeeH2, Serializable>{
	@Query(value="select *from DemoH2Entity where name=:name ",nativeQuery=true)
	public Employee findByName(@Param("name") String name);
}
