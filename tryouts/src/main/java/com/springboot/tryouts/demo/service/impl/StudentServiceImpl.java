package com.springboot.tryouts.demo.service.impl;

import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.tryouts.demo.entity.StudentEntity;
import com.springboot.tryouts.demo.model.Student;
import com.springboot.tryouts.demo.model.StudentCriteria;
import com.springboot.tryouts.demo.repository.StudentRepository;
import com.springboot.tryouts.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<Student> getStudents(StudentCriteria criteria) {
		List<StudentEntity> stuEntityList = this.studentRepo.getPlans(criteria.getStudentId(), criteria.getStudentName());
		stuEntityList = this.sortAndPaginate(stuEntityList , criteria);
		Type listType = new TypeToken<List<Student>>() {}.getType();
		return this.mapper.map(stuEntityList,listType);
	}

	public List<StudentEntity> sortAndPaginate( List<StudentEntity> studentEntityList ,StudentCriteria criteria) {
		String sortBy = criteria.getSortBy();
		int page = criteria.getPage();
		int maxRes = criteria.getMaxResult();
		
		if( sortBy != null && sortBy.equals("studentName")) {
			studentEntityList = sortByStudentName(studentEntityList , criteria);
		}
		
		int startAt = page * maxRes;
		int end = startAt + maxRes;
		
		studentEntityList = studentEntityList.subList(startAt, (end > studentEntityList.size() ? studentEntityList.size() : end));
		return studentEntityList;
	}
	
	public List<StudentEntity> sortByStudentName(List<StudentEntity> studentEntityList , StudentCriteria criteria) {
		String sortBy = criteria.getSortBy();
		String orderBy = criteria.getOrderBy();
		if(sortBy!=null && orderBy != null) {
			if(orderBy.equals("asc")) {
				studentEntityList.sort(Comparator.comparing(StudentEntity::getName));
			} else {
				studentEntityList.sort(Comparator.comparing(StudentEntity::getName).reversed());
			}
		}
	
		return studentEntityList;
	}
}
