package com.docker.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docker.demo.entity.Employee;
import com.docker.demo.repository.EmployeeRepository;

@RestController("/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping(value = "/home")
	public String home() {
		return "Hello Docker";
	}
	
	@GetMapping(value = "/allEmployees", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	@GetMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getAllEmployees(@PathVariable(value = "id") Integer id) {
		return employeeRepository.findById(id).orElse(null);
	}
	
	@PostMapping(value = "/addEmployee", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@PutMapping(value = "/updateEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee updateEmployee(@RequestBody Employee employee) {
		Employee existingEmployee = employeeRepository.findById(employee.getId()).orElse(null);
		existingEmployee.setEmpName(employee.getEmpName());
		existingEmployee.setSalary(employee.getSalary());
		return employeeRepository.save(existingEmployee);
	}
	
	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteEmployee(@PathVariable(value = "id") Integer id) {
		employeeRepository.deleteById(id);
		return "deleted employee with id" + id;
	}
}
