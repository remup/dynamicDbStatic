package com.example.remya.StaticMultipleDB.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.remya.StaticMultipleDB.entity.Employee;

@Repository
public interface DBRepository extends CrudRepository<Employee, Serializable>{

}
