package com.springboot.tryouts.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.tryouts.demo.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	@Query("SELECT s from StudentEntity s where "
			+ " :id is null or s.id = :id and "
			+ " :name is null or s.name = :name")
	public List<StudentEntity> getPlans(Integer id , String name);
}
