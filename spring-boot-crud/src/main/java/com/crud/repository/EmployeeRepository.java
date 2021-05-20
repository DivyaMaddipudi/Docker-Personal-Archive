package com.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	List<Employee> findByName(String name);

}
