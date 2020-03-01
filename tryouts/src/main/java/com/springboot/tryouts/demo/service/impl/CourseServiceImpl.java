package com.springboot.tryouts.demo.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.tryouts.demo.entity.CourseEntity;
import com.springboot.tryouts.demo.exception.CourseNotFoundException;
import com.springboot.tryouts.demo.model.Course;
import com.springboot.tryouts.demo.repository.CourseRepository;
import com.springboot.tryouts.demo.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository repo;
	
	@Autowired
	private ModelMapper mapper;
	
	public Course getCourseById(int id) {
		CourseEntity entity = this.repo.findById(id).
				orElseThrow(() -> new CourseNotFoundException("Course id : "+ id + "is not found"));
		return this.mapper.map(entity, Course.class);
	}

	

}
