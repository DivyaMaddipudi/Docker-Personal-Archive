package com.docker.crud.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StudentController {
	
	@Autowired
	private StudentRepo repo;
	
	@PostMapping("/assStudent")
	public Student addStudent(@RequestBody Student student) {
		return repo.save(student);
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
	    return repo.findAll();
	}
	

}
