package com.springboot.tryouts.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.tryouts.demo.model.Course;
import com.springboot.tryouts.demo.service.CourseService;

@RestController
public class CourseController {
	@Autowired
	private CourseService service;

	@GetMapping("/v1/app/course/{id}")
	public Course getCourseDetailsById(@PathVariable("id") int id) {
		return this.service.getCourseById(id);
	}
}
