package com.springboot.tryouts.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.tryouts.demo.model.Course;
import com.springboot.tryouts.demo.model.Student;
import com.springboot.tryouts.demo.model.StudentCriteria;
import com.springboot.tryouts.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	
	@GetMapping("/v1/app/students")
	public List<Student> getStudents(StudentCriteria criteria) {
		return this.service.getStudents(criteria);
	}
	
}
