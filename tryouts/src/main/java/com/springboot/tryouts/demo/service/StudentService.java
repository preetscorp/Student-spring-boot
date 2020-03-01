package com.springboot.tryouts.demo.service;

import java.util.List;

import com.springboot.tryouts.demo.model.Student;
import com.springboot.tryouts.demo.model.StudentCriteria;


public interface StudentService {

	public List<Student> getStudents(StudentCriteria criteria);
}
