package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Employee;
import com.crud.service.EmployeeServiceImpl;

@RestController
@RequestMapping(value = "/")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@GetMapping("/home")
	public String home() {
		System.out.println("Hello world.............");
		return "Docker home";
	}
	
	@PostMapping(value = "/addEmployee", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@PostMapping(value = "/addEmployees", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> addEmployee(@RequestBody List<Employee> employees) {
		return employeeService.saveEmployees(employees);
	}
	
	@GetMapping("/employees")
	public List<Employee> findAllEmployees() {
		return employeeService.getEmployees();
	}
	
	@GetMapping("/employee/{id}")
	public Employee findEmployeeById(@PathVariable(value = "id") Long id) {
		return employeeService.getEmployeeById(id);
	}
	
	@GetMapping("/employee/{name}")
	public List<Employee> findEmployeeByName(@PathVariable(value = "name") String name) {
		return employeeService.getEmployeeByName(name);
	}
	
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable(value = "id") Long id) {
		return employeeService.deleteEmployee(id);
	}

}
