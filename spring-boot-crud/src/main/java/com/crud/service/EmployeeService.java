package com.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.entity.Employee;

@Service
public interface EmployeeService {
	
	public Employee saveEmployee(Employee employee);

	public List<Employee> saveEmployees(List<Employee> employees);

	public List<Employee> getEmployees();

	public Employee getEmployeeById(Long id);

	public List<Employee> getEmployeeByName(String name);

	public String deleteEmployee(Long id);

	public Employee updateEmployee(Employee employee);

}
